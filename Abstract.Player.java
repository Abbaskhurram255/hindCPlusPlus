import static java.lang.System.out;
import java.util.*;
import java.util.concurrent.*;
import javax.swing.*;

class Timeout {
	private static final Map<Integer, Thread> intervalThreads = new ConcurrentHashMap<>();
	private static int intervalId = 0;
	public static int set(Runnable fn, int interval) {
	    intervalId++;
	    Thread thread = new Thread(() -> {
	        while (!Thread.currentThread().isInterrupted()) {
	            try {
	                Thread.sleep(interval < 1000 ? interval * 1000 : interval);
	            } catch (InterruptedException e) {
	                break;
	            }
	            SwingUtilities.invokeLater(fn);
	        }
	    });
	    intervalThreads.put(intervalId, thread);
	    thread.start();
	    return intervalId;
	}
	public static void clear(int id) {
	    Thread thread = intervalThreads.remove(id);
	    if (thread != null) {
	        thread.interrupt();
	        out.println("yeah?");
	    }
	}
}

class Game {
	public static boolean starts, ends, won, lost;
	Game() {
		out.println("A new game is ready to be initiated. Add some players!");
	}
	public static void start() {
		starts = true;
	}
	public static void lose() {
		ends = true;
		lost = true;
		won = false;
	}
	public static void end() {
		ends = true;
		lost = false;
		won = true;
		out.println("The monster has been destroyed. Great job.");
	}
	public static void printScoreBoard() {
		out.println("========================");
		out.println("= Player1 Health: "+Player1.getHealth() + " =");
		out.println("= Player1 Dead: "+Player1.isDead + " =");
		out.println("= Player2 Health: "+Player2.getHealth() + " =");
		out.println("= Player2 Dead "+Player2.isDead + " =");
		out.println("= Enemy Health: "+Player2.getHealth() + " =");
		out.println("= Enemy Dead "+Player2.isDead + " =");
		out.println("= Game won yet: "+won + " =");
		out.println("= Game lost yet: "+lost + " =");
		out.println("========================");
	}
	static {
		Timeout.set(() -> printScoreBoard(), 5);
	}
}

abstract class Player extends Game {
	private static String name;
	private static int health = 100;
	public static String upKey,
	  downKey,
	  leftKey,
	  rightKey;
	public static void seeIfOtherPlayersAreAlive() {
		if (Player1.isDead && Player2.isDead) Game.lose();
	}
	public static void handleWin() {
		if (Enemy.isDead) Game.end();
	}
	public static String getName() {
	    return name;
	}
	public static void setName(String newName) {
	    name = newName;
	}
	public static int getHealth() {
	    return health;
	}
	public static void setHealth(int newHealth) {
	    health = newHealth;
	}
	
	
	abstract Player moveForward();
	abstract Player moveBackward();
	abstract Player moveLeft();
	abstract Player moveRight();
	abstract Player attack();
	abstract Player jump();
	abstract Player die();
}

class Player1 extends Player {
	public static boolean isHitting,
	  isInTheAir,
	  isDead;
	  
	Player1() {
		setName("Knight");
		int timeout = Timeout.set(() -> {
			setHealth(isHitting || isInTheAir ? getHealth() - 1 : getHealth() - 3);
		}, 1000);
		if (getHealth() <= 0) {
			setHealth(0);
			isDead = true;
			Timeout.clear(timeout);
			seeIfOtherPlayersAreAlive();
		}
	}
	Player1(String name) {
		setName(name);
		int timeout = Timeout.set(() -> {
			setHealth(isHitting || isInTheAir ? getHealth() - 1 : getHealth() - 3);
		}, 1000);
		if (getHealth() <= 0) {
			setHealth(0);
			isDead = true;
			Timeout.clear(timeout);
			seeIfOtherPlayersAreAlive();
		}
	}
	Player1 moveForward() {
		
		return this;
	}
	Player1 moveBackward() {
		
		return this;
	}
	Player1 moveLeft() {
		
		return this;
	}
	Player1 moveRight() {
		
		return this;
	}
	Player1 attack() {
		isHitting = true;
		Enemy.setHealth(Enemy.getHealth() - 5);
		Timeout.set(() -> isHitting = false, 1000);
		return this;
	}
	Player1 collide() {
		if (Enemy.isHitting) setHealth(getHealth() - 10);
		return this;
	}
	Player1 jump() {
		isInTheAir = true;
		Timeout.set(() -> isInTheAir = false, 700);
		return this;
	}
	Player1 die() {
		isDead = true;
		out.println(getName().length() > 2 ? getName() : "Player1" + " dies!");
		seeIfOtherPlayersAreAlive();
		return this;
	}
}

class Player2 extends Player {
	public static boolean isHitting,
	  isInTheAir,
	  isDead;
	
	Player2() {
		setName("Princess");
		int timeout = Timeout.set(() -> {
			setHealth(isHitting || isInTheAir ? getHealth() - 1 : getHealth() - 3);
		}, 1000);
		if (getHealth() <= 0) {
			setHealth(0);
			isDead = true;
			Timeout.clear(timeout);
			seeIfOtherPlayersAreAlive();
		}
	}
	Player2(String name) {
		setName(name);
		int timeout = Timeout.set(() -> {
			setHealth(isHitting || isInTheAir ? getHealth() - 1 : getHealth() - 3);
		}, 1000);
		if (getHealth() <= 0) {
			setHealth(0);
			isDead = true;
			Timeout.clear(timeout);
			seeIfOtherPlayersAreAlive();
		}
	}
	Player2 moveForward() {
		
		return this;
	}
	Player2 moveBackward() {
		
		return this;
	}
	Player2 moveLeft() {
		
		return this;
	}
	Player2 moveRight() {
		
		return this;
	}
	Player2 attack() {
		isHitting = true;
		Enemy.setHealth(Enemy.getHealth() - 5);
		Timeout.set(() -> isHitting = false, 1000);
		return this;
	}
	Player2 collide() {
		
		return this;
	}
	Player2 jump() {
		isInTheAir = true;
		Timeout.set(() -> isInTheAir = false, 700);
		return this;
	}
	Player2 die() {
		isDead = true;
		out.println(getName().length() > 2 ? getName() : "Player2" + " dies!");
		seeIfOtherPlayersAreAlive();
		return this;
	}
}

class Enemy extends Player {
	public static boolean isHitting,
	  isInTheAir,
	  isDead;
	
	Enemy() {
		setName("Lizard");
		isHitting = true;
	}
	Enemy(String name) {
		setName(name);
		isHitting = true;
	}
	Enemy moveForward() {
		
		return this;
	}
	Enemy moveBackward() {
		
		return this;
	}
	Enemy moveLeft() {
		
		return this;
	}
	Enemy moveRight() {
		
		return this;
	}
	Enemy attack() {
		
		return this;
	}
	Enemy jump() {
		
		return this;
	}
	Enemy collide() {
		
		return this;
	}
	Enemy die() {
		out.println(getName().length() > 2 ? getName() : "The enemy" + " dies!");
		return this;
	}
}

class Main {
	public static void main(String[] args) {
		Game game = new Game();
		Player1 p1 = new Player1();
		Player p2 = new Player2();
		Enemy lizard = new Enemy();
		game.start();
	}
}