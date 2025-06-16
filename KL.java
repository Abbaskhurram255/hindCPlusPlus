import java.io.*;
import java.nio.file.*;
import java.nio.charset.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.text.*;
import java.util.*;
import java.util.TreeMap.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import java.lang.reflect.*;
import java.net.*;
//GUI
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.*;
@SuppressWarnings("all")
public class KL {
	public static class Money {
		private double amnt;
		private String curr;
		Money() {
			this.amnt = 0;
			this.curr = "Rs. ";
		}
		Money(double amnt) {
			this.amnt = isinf(amnt) ? 0 : amnt;
			this.curr = "Rs. ";
		}
		Money(double amnt, String curr) {
			this.amnt = not(amnt) || isinf(amnt) ? 0 : amnt;
			this.curr = not(this.curr) || len(this.curr) < 1
						|| len(this.curr) > 4 ? "Rs. " : titleCase(curr);
		}
		Money curr(String curr) {
			this.curr = not(curr) || len(curr) < 1 || len(curr) > 4
						? "Rs. "
						: titleCase(curr);
			return this;
		}
		Money amount(double newAmnt) {
			this.amnt = isinf(newAmnt) ? this.amnt : newAmnt;
			return this;
		}
		Money set(double newAmnt) {
			amount(newAmnt);
			return this;
		}
		Money add(double... nums) {
			each(nums, (n, i) -> this.amnt += n);
			return this;
		}
		Money give(double... nums) {
			add(nums);
			return this;
		}
		Money plus(double... nums) {
			add(nums);
			return this;
		}
		Money deposit(double... nums) {
			add(nums);
			return this;
		}
		Money minus(double... nums) {
			each(nums, (n, i) -> this.amnt -= n);
			return this;
		}
		Money take(double... nums) {
			minus(nums);
			return this;
		}
		Money sub(double... nums) {
			minus(nums);
			return this;
		}
		Money withdraw(double... nums) {
			minus(nums);
			return this;
		}
		Money times(double... nums) {
			each(nums, (n, i) -> this.amnt *= n);
			return this;
		}
		Money mul(double... nums) {
			times(nums);
			return this;
		}
		Money div(double... nums) {
			each(nums, (n, i) -> this.amnt /= n);
			return this;
		}
		Money quotient(double... nums) {
			div(nums);
			return this;
		}
		public String suffix(boolean... bools) {
			boolean forceInternational = bools.length > 0 ? bools[0] : false;
			this.curr = trim(this.curr) + " ";
			if (in(this.curr, "pk|rs"))
				return "Rs. " + (forceInternational
								 ? ussuffix(amnt)
								 : pksuffix(amnt));
			if (in(this.curr, "us"))
				return "US$ " + ussuffix(amnt);
			return this.curr + (forceInternational
								|| (is(this.curr) && !in(this.curr, "pk|rs"))
								? ussuffix(amnt)
								: pksuffix(amnt));
		}
		public String toString() {
			this.curr = trim(this.curr) + " ";
			if (not(this.curr) || in(this.curr, "pk|rs"))
				return pkr(amnt);
			if (in(this.curr, "us"))
				return usd(amnt);
			return this.curr + f(amnt);
		}
		public String toString(boolean suffixMode) {
			return suffixMode ? suffix() : toString();
		}
		public String string() {
			return toString();
		}
		public String string(boolean suffixMode) {
			return toString(suffixMode);
		}
		public String balance() {
			return toString();
		}
		public String balance(boolean suffixMode) {
			return toString(suffixMode);
		}
		public String bal() {
			return toString();
		}
		public String bal(boolean suffixMode) {
			return toString(suffixMode);
		}
		public String total() {
			return toString();
		}
		public String total(boolean suffixMode) {
			return toString(suffixMode);
		}
	}
	public static final class Pesa extends Money {
		Pesa() {
			super.amnt = 0;
			super.curr = "Rs. ";
		}
		Pesa(double amnt) {
			super.amnt = isinf(amnt) ? 0 : amnt;
			super.curr = "Rs. ";
		}
		Pesa(double amnt, String curr) {
			super.amnt = not(amnt) || isinf(amnt) ? 0 : amnt;
			super.curr = not(super.curr) || len(super.curr) < 1
						 || len(super.curr) > 4 ? "Rs. " : titleCase(curr);
		}
	}
	public static final class Kmath {
		public static double Pi = 3.141592653589793, C = 2.99792e8,
							 earthsGravity = 9.80665, earthsMass = 5.9722e24,
							 earthsRadius = 6.378137e3;
		public static String C_Unit = "m/s", K_Unit = "Nm^2/c^2",
							 earthsGravity_Unit = "m/s^2", earthsMass_Unit = "km",
							 earthsRadius_Unit = "km";
	}
	public static String encode(String s) {
		return Base64.getEncoder().encodeToString(s.getBytes());
	}
	public static String decode(String s) {
		return new String(Base64.getDecoder().decode(s));
	}
	public static String encodeUrl(String s) {
		String encoded = s.replace("%", "%25").replace(" ", "%20")
						 .replace("!", "%21").replace("#", "%23").replace("$", "%24")
						 .replace("&", "%26").replace("'", "%27").replace("(", "%28")
						 .replace(")", "%29").replace("*", "%2A").replace("+", "%2B")
						 .replace(",", "%2C").replace("/", "%2F").replace(":", "%3A")
						 .replace(";", "%3B").replace("=", "%3D").replace("?", "%3F")
						 .replace("@", "%40").replace("[", "%5B").replace("]", "%5D");
		return encoded;
	}
	public static String decodeUrl(String s) {
		String decoded = s.replace("%21", "!").replace("%20", " ")
						 .replace("%23", "#").replace("%24", "$").replace("%26", "&")
						 .replace("%27", "'").replace("%28", "(").replace("%29", ")")
						 .replace("%2A", "*").replace("%2B", "+").replace("%2C", ",")
						 .replace("%2F", "/").replace("%3A", ":").replace("%3B", ";")
						 .replace("%3D", "=").replace("%3F", "?").replace("%40", "@")
						 .replace("%5B", "[").replace("%5D", "]").replace("%25", "%");
		return decoded;
	}
	public static String encrypt(String data, String key) {
		final String algo = "AES";
		try {
			SecretKeySpec secretKey = new SecretKeySpec(
				key.getBytes(StandardCharsets.UTF_8), algo);
			Cipher cipher = Cipher.getInstance(algo);
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			byte[] encryptedBytes = cipher
									.doFinal(data.getBytes(StandardCharsets.UTF_8));
			return Base64.getEncoder().encodeToString(encryptedBytes);
		} catch (Exception err) {
			return data;
		}
	}
	public static String decrypt(String encryptedData, String key) {
		final String algo = "AES";
		try {
			SecretKeySpec secretKey = new SecretKeySpec(
				key.getBytes(StandardCharsets.UTF_8), algo);
			Cipher cipher = Cipher.getInstance(algo);
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			byte[] decryptedBytes = cipher
									.doFinal(Base64.getDecoder().decode(encryptedData));
			return new String(decryptedBytes, StandardCharsets.UTF_8);
		} catch (Exception err) {
			print("[KL.EncrypTool.BadArguments]:\nFailed to decrypt the message.");
			return "";
		}
	}
	public static Obj_S fetch(String url) {
		Obj_S map = new Obj_S();
		try {
			URL urlString = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) urlString
										   .openConnection();
			connection.setRequestMethod("GET");
			int statusCode = connection.getResponseCode();
			if (statusCode == HttpURLConnection.HTTP_OK) {
				BufferedReader reader = new BufferedReader(
					new InputStreamReader(connection.getInputStream()));
				String line;
				StringBuilder respBuilder = new StringBuilder();
				while ((line = reader.readLine()) != null) {
					respBuilder.append(line);
				}
				reader.close();
				String jsonString = respBuilder.toString();
				jsonString = jsonString.trim();
				if (jsonString.startsWith("{") && jsonString.endsWith("}"))
					jsonString = jsonString.substring(1,
													  jsonString.length() - 1);
				String[] keyValuePairs = jsonString.split(",");
				for (String pair : keyValuePairs) {
					String[] parts = pair.split(":", 2);
					if (parts.length == 2) {
						String key = parts[0].trim().replaceAll("[\"\\{\\}\\]]",
																"");
						String value = parts[1].trim()
									   .replaceAll("[\"\\{\\}\\]]", "");
						map.put(key, value);
					}
				}
				map.add("response", "200").add("status", "ok").add("error",
						"no");
				return map;
			} else {
				map.add("response", Str(statusCode)).add("status", "notok")
				.add("error", "yes");
				print("[KLFetch.Status.NotOK]:\nMessage: GET request failed with status code",
					  statusCode);
			}
			connection.disconnect();
		} catch (IOException e) {
			map.add("response", "404").add("status", "notok").add("error",
					"yes");
			print("[KLFetch.Status.Offline]:\nMessage: Failed to fetch. It appears, you might be offline.");
		}
		return map;
	}
	public String getPath(String to) {
		if (not(to))
			return "";
		return getClass().getResource(to).toString();
	}
	public static String fileSeparator = System.getProperty("file.separator"),
						 workDirectory = System.getProperty("user.dir").toLowerCase();
	public static class os {
		public static String name = System.getProperty("os.name").toLowerCase()
									.split(" ")[0],
									version = System.getProperty("os.version").toLowerCase(),
									arch = System.getProperty("os.arch").toLowerCase();
		public static boolean is(String s) {
			return in(name, s);
		}
	}
	public static class user {
		public static String name = System.getProperty("user.name"),
							 language = System.getProperty("user.language").toLowerCase(),
							 homeDirectory = System.getProperty("user.home"),
							 workDirectory = KL.workDirectory;
	}
	// GUI
	public static class GUI extends JFrame {
		private static final long serialVersionUID = 1L;
		GUI() {
			super();
			exitOnClose();
			resizable();
			super.setLayout(new BorderLayout());
		}
		GUI(String title) {
			super();
			exitOnClose();
			resizable();
			title(title);
			super.setLayout(new BorderLayout());
		}
		GUI(String title, int w, int h) {
			super();
			exitOnClose();
			resizable();
			title(title);
			size(w, h);
			super.setLayout(new BorderLayout());
		}
		GUI title(String title) {
			super.setTitle(title);
			return this;
		}
		GUI kaTitle(String title) {
			title(title);
			return this;
		}
		GUI size(int w, int h) {
			super.setSize(w, h);
			super.setLocationRelativeTo(null);
			return this;
		}
		GUI kiSize(int w, int h) {
			size(w, h);
			return this;
		}
		GUI start() {
			super.pack();
			super.setVisible(true);
			return this;
		}
		GUI start(int w, int h) {
			size(w, h);
			super.pack();
			super.setVisible(true);
			return this;
		}
		GUI shuru() {
			start();
			return this;
		}
		GUI shuru(int w, int h) {
			start(w, h);
			return this;
		}
		GUI appear() {
			start();
			return this;
		}
		GUI disappear() {
			super.setVisible(false);
			return this;
		}
		GUI resizable() {
			super.setResizable(true);
			return this;
		}
		GUI notResizable() {
			super.setResizable(false);
			return this;
		}
		GUI resizableNaHo() {
			notResizable();
			return this;
		}
		GUI onTop(boolean b) {
			super.setAlwaysOnTop(b);
			return this;
		}
		GUI onTop() {
			onTop(true);
			return this;
		}
		GUI offTop() {
			onTop(false);
			return this;
		}
		GUI alwaysOnTop(boolean b) {
			onTop(b);
			return this;
		}
		GUI alwaysOnTop() {
			onTop();
			return this;
		}
		GUI hameshaTopPe(boolean b) {
			onTop(b);
			return this;
		}
		GUI hameshaTopPe() {
			onTop();
			return this;
		}
		GUI opacity(double o) {
			if (o <= 100) {
				if (o >= 0 && o <= 1)
					super.setOpacity((float) o);
				else if (o > 1)
					super.setOpacity((float) o / 100);
			}
			return this;
		}
		GUI cursor(int c) {
			super.setCursor(new Cursor(c));
			return this;
		}
		GUI cursor(Cursor crsrObj) {
			super.setCursor(crsrObj);
			return this;
		}
		GUI bg(Color clr) {
			super.setBackground(clr);
			return this;
		}
		GUI setBg(Color clr) {
			bg(clr);
			return this;
		}
		GUI font(String fontFamily, int fontSize) {
			super.setFont(new Font(fontFamily, Font.PLAIN, fontSize));
			return this;
		}
		GUI font(String fontFamily, int fontSize, int fontWidth) {
			super.setFont(new Font(fontFamily, fontWidth, fontSize));
			return this;
		}
		GUI font(String fontFamily, int fontSize, boolean bold,
				 boolean italic) {
			super.setFont(new Font(fontFamily, bold && italic
								   ? Font.BOLD | Font.ITALIC
								   : bold ? Font.BOLD : italic ? Font.ITALIC : Font.PLAIN,
								   fontSize));
			return this;
		}
		GUI font(String fontFamily, int fontSize, boolean bold) {
			font(fontFamily, fontSize, bold, false);
			return this;
		}
		GUI font(String fontFamily, int fontSize, int bold, int italic) {
			super.setFont(new Font(fontFamily,
								   bold == 1 && italic == 1
								   ? Font.BOLD | Font.ITALIC
								   : bold == 1
								   ? Font.BOLD
								   : italic == 1 ? Font.ITALIC : Font.PLAIN,
								   fontSize));
			return this;
		}
		GUI font(Font fnt) {
			super.setFont(fnt);
			return this;
		}
		double mouseX() {
			return MouseInfo.getPointerInfo().getLocation().getX();
		}
		double mouseY() {
			return MouseInfo.getPointerInfo().getLocation().getY();
		}
		GUI exitOnClose() {
			super.setDefaultCloseOperation(super.EXIT_ON_CLOSE);
			return this;
		}
		GUI on(String k, Runnable action) {
			if (KL.in(k, "\\w{3,}[|]\\w{3,}")) {
				String[] keys = k.split("[|]");
				for (var key : keys) {
					on(key, action);
				}
			}
			if (KL.is(k) && KL.is(action)) {
				super.addKeyListener(new KeyListener() {
					@Override
					public void keyPressed(KeyEvent e) {
						char keyCharCaptured = e.getKeyChar();
						int keyCodeCaptured = e.getKeyCode();
						String keyCaptured = "" + keyCharCaptured;
						switch (keyCodeCaptured) {
						case KeyEvent.VK_UP :
							keyCaptured = "up";
							break;
						case KeyEvent.VK_DOWN :
							keyCaptured = "down";
							break;
						case KeyEvent.VK_LEFT :
							keyCaptured = "left";
							break;
						case KeyEvent.VK_RIGHT :
							keyCaptured = "right";
							break;
						case KeyEvent.VK_CONTROL :
							keyCaptured = "ctrl";
							break;
						}
						if (KL.eq(k, keyCaptured)) {
							new Thread(action).run();;
						}
					}
					@Override
					public void keyReleased(KeyEvent e) {
					}
					@Override
					public void keyTyped(KeyEvent e) {
					}
				});
				super.addMouseListener(new MouseListener() {
					@Override
					public void mouseClicked(MouseEvent e) {
					}
					@Override
					public void mousePressed(MouseEvent e) {
						int button = -1;
						if (KL.eq(k, "click") || KL.eq(k, "clickl")
								|| KL.eq(k, "lclick"))
							button = MouseEvent.BUTTON1;
						else if (KL.eq(k, "clickm") || KL.eq(k, "clickw")
								 || KL.eq(k, "mclick") || KL.eq(k, "wclick"))
							button = MouseEvent.BUTTON2;
						else if (KL.eq(k, "clickr") || KL.eq(k, "rclick"))
							button = MouseEvent.BUTTON3;
						if (e.getButton() == button) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseReleased(MouseEvent e) {
						if (KL.eq(k, "release")) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseEntered(MouseEvent e) {
						if (KL.eq(k, "enter")) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseExited(MouseEvent e) {
						if (KL.eq(k, "leave")) {
							new Thread(action).run();
						}
					}
				});
				super.addMouseMotionListener(new MouseMotionListener() {
					@Override
					public void mouseDragged(MouseEvent e) {
						if (KL.eq(k, "drag")) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseMoved(MouseEvent e) {
						if (KL.eq(k, "move")) {
							new Thread(action).run();
						}
					}
				});
				super.addMouseWheelListener(new MouseWheelListener() {
					@Override
					public void mouseWheelMoved(MouseWheelEvent e) {
						if (KL.eq(k, "wheel")) {
							new Thread(action).run();
						}
					}
				});
				super.addWindowListener(new WindowListener() {
					@Override
					public void windowOpened(WindowEvent e) {
						if (KL.eq(k, "launch")) {
							new Thread(action).run();
						}
					}
					@Override
					public void windowClosing(WindowEvent e) {
						if (KL.in(k, "exit|close")) {
							new Thread(action).run();
						}
					}
					@Override
					public void windowClosed(WindowEvent e) {
					}
					@Override
					public void windowIconified(WindowEvent e) {
						if (KL.startsWith(k, "min")) {
							new Thread(action).run();
						}
					}
					@Override
					public void windowDeiconified(WindowEvent e) {
					}
					@Override
					public void windowActivated(WindowEvent e) {
						if (KL.startsWith(k, "focus")) {
							new Thread(action).run();
						}
					}
					@Override
					public void windowDeactivated(WindowEvent e) {
						if (KL.startsWith(k, "defocus")) {
							new Thread(action).run();
						}
					}
				});
			}
			return this;
		}
		GUI state(String newState) {
			switch (newState) {
			case "min" :
				super.setExtendedState(super.ICONIFIED);
				break;
			case "max" :
				super.setExtendedState(super.MAXIMIZED_BOTH);
				break;
			case "none" :
			case "regular" :
			case "normal" :
				super.setExtendedState(super.NORMAL);
				break;
			}
			return this;
		}
		String state() {
			int x = super.getExtendedState();
			String state = x == super.NORMAL
						   ? "normal"
						   : x == super.ICONIFIED
						   ? "minimized"
						   : x == super.MAXIMIZED_BOTH
						   ? "maximized"
						   : "unknown";
			return state;
		}
		GUI min() {
			state("min");
			return this;
		}
		GUI max() {
			state("max");
			return this;
		}
		GUI message(String message) {
			offTop();
			JOptionPane.showMessageDialog(null, message, "Message",
										  JOptionPane.INFORMATION_MESSAGE);
			return this;
		}
		GUI message(String title, String message) {
			offTop();
			JOptionPane.showMessageDialog(null, message, title,
										  JOptionPane.INFORMATION_MESSAGE);
			return this;
		}
		GUI message(String title, String message, String iconAddress) {
			offTop();
			JOptionPane.showMessageDialog(null, message, title,
										  JOptionPane.INFORMATION_MESSAGE, new Icon(iconAddress));
			return this;
		}
		GUI message(String title, String message, Icon ico) {
			offTop();
			JOptionPane.showMessageDialog(null, message, title,
										  JOptionPane.INFORMATION_MESSAGE, ico);
			return this;
		}
		GUI error(String message) {
			offTop();
			JOptionPane.showMessageDialog(null, message, "Error",
										  JOptionPane.ERROR_MESSAGE);
			return this;
		}
		GUI error(String title, String message) {
			offTop();
			JOptionPane.showMessageDialog(null, message, title,
										  JOptionPane.ERROR_MESSAGE);
			return this;
		}
		GUI error(String title, String message, String iconAddress) {
			offTop();
			JOptionPane.showMessageDialog(null, message, title,
										  JOptionPane.ERROR_MESSAGE, new Icon(iconAddress));
			return this;
		}
		GUI error(String title, String message, Icon ico) {
			offTop();
			JOptionPane.showMessageDialog(null, message, title,
										  JOptionPane.ERROR_MESSAGE, ico);
			return this;
		}
		GUI warn(String message) {
			offTop();
			JOptionPane.showMessageDialog(null, message, "Warning",
										  JOptionPane.WARNING_MESSAGE);
			return this;
		}
		GUI warn(String title, String message) {
			offTop();
			JOptionPane.showMessageDialog(null, message, title,
										  JOptionPane.WARNING_MESSAGE);
			return this;
		}
		GUI warn(String title, String message, String iconAddress) {
			offTop();
			JOptionPane.showMessageDialog(null, message, title,
										  JOptionPane.WARNING_MESSAGE, new Icon(iconAddress));
			return this;
		}
		GUI warn(String title, String message, Icon ico) {
			offTop();
			JOptionPane.showMessageDialog(null, message, title,
										  JOptionPane.WARNING_MESSAGE, ico);
			return this;
		}
		boolean confirm(String message) {
			offTop();
			return (JOptionPane.showConfirmDialog(null, message, "Confirmation",
												  JOptionPane.YES_NO_OPTION,
												  JOptionPane.QUESTION_MESSAGE) == 0);
		}
		boolean confirm(String title, String message) {
			offTop();
			return (JOptionPane.showConfirmDialog(null, message, title,
												  JOptionPane.YES_NO_OPTION,
												  JOptionPane.QUESTION_MESSAGE) == 0);
		}
		boolean confirm(String title, String message, String iconAddress) {
			offTop();
			return (JOptionPane.showConfirmDialog(null, message, title,
												  JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
												  new Icon(iconAddress)) == 0);
		}
		boolean confirm(String title, String message, Icon ico) {
			offTop();
			return (JOptionPane.showConfirmDialog(null, message, title,
												  JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
												  ico) == 0);
		}
		boolean confirmCancellable(String message) {
			offTop();
			return (JOptionPane.showConfirmDialog(null, message, "Confirmation",
												  JOptionPane.YES_NO_CANCEL_OPTION,
												  JOptionPane.QUESTION_MESSAGE) == 0);
		}
		boolean confirmCancellable(String title, String message) {
			offTop();
			return (JOptionPane.showConfirmDialog(null, message, title,
												  JOptionPane.YES_NO_CANCEL_OPTION,
												  JOptionPane.QUESTION_MESSAGE) == 0);
		}
		boolean confirmCancellable(String title, String message,
								   String iconAddress) {
			offTop();
			return (JOptionPane.showConfirmDialog(null, message, title,
												  JOptionPane.YES_NO_CANCEL_OPTION,
												  JOptionPane.QUESTION_MESSAGE, new Icon(iconAddress)) == 0);
		}
		boolean confirmCancellable(String title, String message, Icon ico) {
			offTop();
			return (JOptionPane.showConfirmDialog(null, message, title,
												  JOptionPane.YES_NO_CANCEL_OPTION,
												  JOptionPane.QUESTION_MESSAGE, ico) == 0);
		}
		String ask(String message) {
			offTop();
			return JOptionPane.showInputDialog(null, message, "Input",
											   JOptionPane.QUESTION_MESSAGE);
		}
		String ask(String title, String message) {
			offTop();
			return JOptionPane.showInputDialog(null, message, title,
											   JOptionPane.QUESTION_MESSAGE);
		}
	}
	public static class Label extends JLabel {
		private static final long serialVersionUID = 1L;
		Label() {
			super();
			super.setOpaque(true);
		}
		Label(String name) {
			super();
			super.setOpaque(true);
		}
		Label bg(Color clr) {
			super.setBackground(clr);
			return this;
		}
		Label fg(Color clr) {
			super.setForeground(clr);
			return this;
		}
		Label setBg(Color clr) {
			bg(clr);
			return this;
		}
		Label setFg(Color clr) {
			fg(clr);
			return this;
		}
		Label cursor(int c) {
			super.setCursor(new Cursor(c));
			return this;
		}
		Label cursor(Cursor crsrObj) {
			super.setCursor(crsrObj);
			return this;
		}
		Label font(String fontFamily, int fontSize) {
			super.setFont(new Font(fontFamily, Font.PLAIN, fontSize));
			return this;
		}
		Label font(String fontFamily, int fontSize, int fontWidth) {
			super.setFont(new Font(fontFamily, fontWidth, fontSize));
			return this;
		}
		Label font(String fontFamily, int fontSize, boolean bold,
				   boolean italic) {
			super.setFont(new Font(fontFamily, bold && italic
								   ? Font.BOLD | Font.ITALIC
								   : bold ? Font.BOLD : italic ? Font.ITALIC : Font.PLAIN,
								   fontSize));
			return this;
		}
		Label font(String fontFamily, int fontSize, boolean bold) {
			font(fontFamily, fontSize, bold, false);
			return this;
		}
		Label font(String fontFamily, int fontSize, int bold, int italic) {
			super.setFont(new Font(fontFamily,
								   bold == 1 && italic == 1
								   ? Font.BOLD | Font.ITALIC
								   : bold == 1
								   ? Font.BOLD
								   : italic == 1 ? Font.ITALIC : Font.PLAIN,
								   fontSize));
			return this;
		}
		Label font(Font fnt) {
			super.setFont(fnt);
			return this;
		}
		Label alignx(int pos) {
			super.setHorizontalAlignment(pos);
			return this;
		}
		Label aligny(int pos) {
			super.setVerticalAlignment(pos);
			return this;
		}
		String text() {
			return super.getText();
		}
		Label text(String s) {
			super.setText(s);
			return this;
		}
		Label on(String k, Runnable action) {
			if (KL.in(k, "\\w{3,}[|]\\w{3,}")) {
				String[] keys = k.split("[|]");
				for (var key : keys) {
					on(key, action);
				}
			}
			if (KL.is(k) && KL.is(action)) {
				super.addKeyListener(new KeyListener() {
					@Override
					public void keyPressed(KeyEvent e) {
						char keyCharCaptured = e.getKeyChar();
						int keyCodeCaptured = e.getKeyCode();
						String keyCaptured = "" + keyCharCaptured;
						switch (keyCodeCaptured) {
						case KeyEvent.VK_UP :
							keyCaptured = "up";
							break;
						case KeyEvent.VK_DOWN :
							keyCaptured = "down";
							break;
						case KeyEvent.VK_LEFT :
							keyCaptured = "left";
							break;
						case KeyEvent.VK_RIGHT :
							keyCaptured = "right";
							break;
						case KeyEvent.VK_CONTROL :
							keyCaptured = "ctrl";
							break;
						}
						if (KL.eq(k, keyCaptured)) {
							new Thread(action).run();;
						}
					}
					@Override
					public void keyReleased(KeyEvent e) {
					}
					@Override
					public void keyTyped(KeyEvent e) {
					}
				});
				super.addMouseListener(new MouseListener() {
					@Override
					public void mouseClicked(MouseEvent e) {
					}
					@Override
					public void mousePressed(MouseEvent e) {
						int button = -1;
						if (KL.eq(k, "click") || KL.eq(k, "clickl"))
							button = MouseEvent.BUTTON1;
						else if (KL.eq(k, "clickm") || KL.eq(k, "clickw"))
							button = MouseEvent.BUTTON2;
						else if (KL.eq(k, "clickr"))
							button = MouseEvent.BUTTON3;
						if (e.getButton() == button) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseReleased(MouseEvent e) {
						if (KL.eq(k, "release")) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseEntered(MouseEvent e) {
						if (KL.eq(k, "enter")) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseExited(MouseEvent e) {
						if (KL.eq(k, "leave")) {
							new Thread(action).run();
						}
					}
				});
				super.addMouseMotionListener(new MouseMotionListener() {
					@Override
					public void mouseDragged(MouseEvent e) {
						if (KL.eq(k, "drag")) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseMoved(MouseEvent e) {
						if (KL.eq(k, "move")) {
							new Thread(action).run();
						}
					}
				});
				super.addMouseWheelListener(new MouseWheelListener() {
					@Override
					public void mouseWheelMoved(MouseWheelEvent e) {
						if (KL.eq(k, "wheel")) {
							new Thread(action).run();
						}
					}
				});
			}
			return this;
		}
	}
	public static class BordLay extends BorderLayout {
		private static final long serialVersionUID = 1L;
		BordLay() {
			super();
		}
		BordLay(int hgap, int vgap) {
			super(hgap, vgap);
		}
	}
	public static class GridLay extends GridLayout {
		private static final long serialVersionUID = 1L;
		GridLay() {
			super();
		}
		GridLay(int rows, int columns) {
			super(rows, columns);
		}
		GridLay(int rows, int columns, int hgap, int vgap) {
			super(rows, columns, hgap, vgap);
		}
	}
	public static class GridBagLay extends GridBagLayout {
		private static final long serialVersionUID = 1L;
		GridBagLay() {
			super();
		}
	}
	public static class GridBagSettings extends GridBagConstraints {
		private static final long serialVersionUID = 1L;
		GridBagSettings() {
			super();
		}
	}
	public static class FlowLay extends FlowLayout {
		private static final long serialVersionUID = 1L;
		FlowLay() {
			super();
		}
		FlowLay(int align) {
			super(align);
		}
		FlowLay(int align, int hgap, int vgap) {
			super(align, hgap, vgap);
		}
	}
	public static class CardLay extends CardLayout {
		private static final long serialVersionUID = 1L;
		CardLay() {
			super();
		}
		CardLay(int hgap, int vgap) {
			super(hgap, vgap);
		}
	}
	public static class BoxLay extends BoxLayout {
		private static final long serialVersionUID = 1L;
		BoxLay(Container target, int axis) {
			super(target, axis);
		}
	}
	public static class Panel extends JPanel {
		private static final long serialVersionUID = 1L;
		Panel() {
			super();
		}
		Panel(LayoutManager layout) {
			super(layout);
		}
		Panel(boolean isDoubleBuffered) {
			super(isDoubleBuffered);
		}
		Panel(LayoutManager layout, boolean isDoubleBuffered) {
			super(layout, isDoubleBuffered);
		}
		Panel lay(LayoutManager layout) {
			super.setLayout(layout);
			return this;
		}
		Panel setLay(LayoutManager layout) {
			lay(layout);
			return this;
		}
		Panel layout(LayoutManager layout) {
			lay(layout);
			return this;
		}
		Panel bg(Color clr) {
			super.setBackground(clr);
			return this;
		}
		Panel fg(Color clr) {
			super.setForeground(clr);
			return this;
		}
		Panel setBg(Color clr) {
			bg(clr);
			return this;
		}
		Panel setFg(Color clr) {
			fg(clr);
			return this;
		}
		Panel cursor(int c) {
			super.setCursor(new Cursor(c));
			return this;
		}
		Panel cursor(Cursor crsrObj) {
			super.setCursor(crsrObj);
			return this;
		}
		Panel font(String fontFamily, int fontSize) {
			super.setFont(new Font(fontFamily, Font.PLAIN, fontSize));
			return this;
		}
		Panel font(String fontFamily, int fontSize, int fontWidth) {
			super.setFont(new Font(fontFamily, fontWidth, fontSize));
			return this;
		}
		Panel font(String fontFamily, int fontSize, boolean bold,
				   boolean italic) {
			super.setFont(new Font(fontFamily, bold && italic
								   ? Font.BOLD | Font.ITALIC
								   : bold ? Font.BOLD : italic ? Font.ITALIC : Font.PLAIN,
								   fontSize));
			return this;
		}
		Panel font(String fontFamily, int fontSize, boolean bold) {
			font(fontFamily, fontSize, bold, false);
			return this;
		}
		Panel font(String fontFamily, int fontSize, int bold, int italic) {
			super.setFont(new Font(fontFamily,
								   bold == 1 && italic == 1
								   ? Font.BOLD | Font.ITALIC
								   : bold == 1
								   ? Font.BOLD
								   : italic == 1 ? Font.ITALIC : Font.PLAIN,
								   fontSize));
			return this;
		}
		Panel font(Font fnt) {
			super.setFont(fnt);
			return this;
		}
		Panel border(LineBorder brdr) {
			super.setBorder(brdr);
			return this;
		}
		Panel on(String k, Runnable action) {
			if (KL.in(k, "\\w{3,}[|]\\w{3,}")) {
				String[] keys = k.split("[|]");
				for (var key : keys) {
					on(key, action);
				}
			}
			if (KL.is(k) && KL.is(action)) {
				super.addKeyListener(new KeyListener() {
					@Override
					public void keyPressed(KeyEvent e) {
						char keyCharCaptured = e.getKeyChar();
						int keyCodeCaptured = e.getKeyCode();
						String keyCaptured = "" + keyCharCaptured;
						switch (keyCodeCaptured) {
						case KeyEvent.VK_UP :
							keyCaptured = "up";
							break;
						case KeyEvent.VK_DOWN :
							keyCaptured = "down";
							break;
						case KeyEvent.VK_LEFT :
							keyCaptured = "left";
							break;
						case KeyEvent.VK_RIGHT :
							keyCaptured = "right";
							break;
						case KeyEvent.VK_CONTROL :
							keyCaptured = "ctrl";
							break;
						}
						if (KL.eq(k, keyCaptured)) {
							new Thread(action).run();;
						}
					}
					@Override
					public void keyReleased(KeyEvent e) {
					}
					@Override
					public void keyTyped(KeyEvent e) {
					}
				});
				super.addMouseListener(new MouseListener() {
					@Override
					public void mouseClicked(MouseEvent e) {
					}
					@Override
					public void mousePressed(MouseEvent e) {
						int button = -1;
						if (KL.eq(k, "click") || KL.eq(k, "clickl"))
							button = MouseEvent.BUTTON1;
						else if (KL.eq(k, "clickm") || KL.eq(k, "clickw"))
							button = MouseEvent.BUTTON2;
						else if (KL.eq(k, "clickr"))
							button = MouseEvent.BUTTON3;
						if (e.getButton() == button) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseReleased(MouseEvent e) {
						if (KL.eq(k, "release")) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseEntered(MouseEvent e) {
						if (KL.eq(k, "enter")) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseExited(MouseEvent e) {
						if (KL.eq(k, "leave")) {
							new Thread(action).run();
						}
					}
				});
				super.addMouseMotionListener(new MouseMotionListener() {
					@Override
					public void mouseDragged(MouseEvent e) {
						if (KL.eq(k, "drag")) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseMoved(MouseEvent e) {
						if (KL.eq(k, "move")) {
							new Thread(action).run();
						}
					}
				});
				super.addMouseWheelListener(new MouseWheelListener() {
					@Override
					public void mouseWheelMoved(MouseWheelEvent e) {
						if (KL.eq(k, "wheel")) {
							new Thread(action).run();
						}
					}
				});
			}
			return this;
		}
	}
	public static class Btn extends JButton {
		private static final long serialVersionUID = 1L;
		Btn() {
			super();
			super.setFocusable(false);
		}
		Btn(String text) {
			super(text);
			super.setFocusable(false);
		}
		Btn(Action a) {
			super(a);
			super.setFocusable(false);
		}
		Btn(Icon i) {
			super(i);
			super.setFocusable(false);
		}
		Btn(String text, Icon i) {
			super(text, i);
			super.setFocusable(false);
		}
		Btn(String text, ActionListener listener) {
			super(text);
			super.setFocusable(false);
			click(listener);
		}
		Btn(String text, ActionListener listener, Color bg, Color fg) {
			this(text, listener);
			bg(bg);
			fg(fg);
		}
		Btn click(ActionListener listener) {
			super.addActionListener(listener);
			return this;
		}
		Btn offClick(ActionListener listener) {
			super.removeActionListener(listener);
			return this;
		}
		Btn bg(Color clr) {
			super.setBackground(clr);
			return this;
		}
		Btn fg(Color clr) {
			super.setForeground(clr);
			return this;
		}
		Btn setBg(Color clr) {
			bg(clr);
			return this;
		}
		Btn setFg(Color clr) {
			fg(clr);
			return this;
		}
		Btn cursor(int c) {
			super.setCursor(new Cursor(c));
			return this;
		}
		Btn cursor(Cursor crsrObj) {
			super.setCursor(crsrObj);
			return this;
		}
		Btn font(String fontFamily, int fontSize) {
			super.setFont(new Font(fontFamily, Font.PLAIN, fontSize));
			return this;
		}
		Btn font(String fontFamily, int fontSize, int fontWidth) {
			super.setFont(new Font(fontFamily, fontWidth, fontSize));
			return this;
		}
		Btn font(String fontFamily, int fontSize, boolean bold,
				 boolean italic) {
			super.setFont(new Font(fontFamily, bold && italic
								   ? Font.BOLD | Font.ITALIC
								   : bold ? Font.BOLD : italic ? Font.ITALIC : Font.PLAIN,
								   fontSize));
			return this;
		}
		Btn font(String fontFamily, int fontSize, boolean bold) {
			font(fontFamily, fontSize, bold, false);
			return this;
		}
		Btn font(String fontFamily, int fontSize, int bold, int italic) {
			super.setFont(new Font(fontFamily,
								   bold == 1 && italic == 1
								   ? Font.BOLD | Font.ITALIC
								   : bold == 1
								   ? Font.BOLD
								   : italic == 1 ? Font.ITALIC : Font.PLAIN,
								   fontSize));
			return this;
		}
		Btn font(Font fnt) {
			super.setFont(fnt);
			return this;
		}
		Btn border(LineBorder brdr) {
			super.setBorder(brdr);
			return this;
		}
		Btn alignx(int pos) {
			super.setHorizontalAlignment(pos);
			return this;
		}
		Btn aligny(int pos) {
			super.setVerticalAlignment(pos);
			return this;
		}
		String text() {
			return super.getText();
		}
		Btn text(String s) {
			super.setText(s);
			return this;
		}
		Btn on(String evt, ActionListener action) {
			if (KL.is(evt) && KL.is(action) && KL.eq(evt, "click"))
				click(action);
			return this;
		}
	}
	public static class TxtField extends JTextField {
		private static final long serialVersionUID = 1L;
		TxtField() {
			super();
		}
		TxtField(String text) {
			super(text);
		}
		TxtField(int columns) {
			super(columns);
		}
		TxtField(String text, int columns) {
			super(text, columns);
		}
		TxtField(Document doc, String text, int columns) {
			super(doc, text, columns);
		}
		TxtField cursor(int c) {
			super.setCursor(new Cursor(c));
			return this;
		}
		TxtField cursor(Cursor crsrObj) {
			super.setCursor(crsrObj);
			return this;
		}
		TxtField border(LineBorder brdr) {
			super.setBorder(brdr);
			return this;
		}
		String text() {
			return super.getText();
		}
		TxtField text(String s) {
			super.setText(s);
			return this;
		}
		String val() {
			return text();
		}
		TxtField val(String s) {
			text(s);
			return this;
		}
		String value() {
			return text();
		}
		TxtField value(String s) {
			text(s);
			return this;
		}
		TxtField on(String k, Runnable action) {
			if (KL.is(k) && KL.is(action)) {
				super.addKeyListener(new KeyListener() {
					@Override
					public void keyPressed(KeyEvent e) {
						char keyCharCaptured = e.getKeyChar();
						int keyCodeCaptured = e.getKeyCode();
						String keyCaptured = "" + keyCharCaptured;
						switch (keyCodeCaptured) {
						case KeyEvent.VK_UP :
							keyCaptured = "up";
							break;
						case KeyEvent.VK_DOWN :
							keyCaptured = "down";
							break;
						case KeyEvent.VK_LEFT :
							keyCaptured = "left";
							break;
						case KeyEvent.VK_RIGHT :
							keyCaptured = "right";
							break;
						case KeyEvent.VK_CONTROL :
							keyCaptured = "ctrl";
							break;
						}
						if (KL.eq(k, keyCaptured)) {
							new Thread(action).run();;
						}
					}
					@Override
					public void keyReleased(KeyEvent e) {
					}
					@Override
					public void keyTyped(KeyEvent e) {
					}
				});
				super.addMouseListener(new MouseListener() {
					@Override
					public void mouseClicked(MouseEvent e) {
					}
					@Override
					public void mousePressed(MouseEvent e) {
						int button = -1;
						if (KL.eq(k, "click") || KL.eq(k, "clickl"))
							button = MouseEvent.BUTTON1;
						else if (KL.eq(k, "clickm") || KL.eq(k, "clickw"))
							button = MouseEvent.BUTTON2;
						else if (KL.eq(k, "clickr"))
							button = MouseEvent.BUTTON3;
						if (e.getButton() == button) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseReleased(MouseEvent e) {
						if (KL.eq(k, "release")) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseEntered(MouseEvent e) {
						if (KL.eq(k, "enter")) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseExited(MouseEvent e) {
						if (KL.eq(k, "leave")) {
							new Thread(action).run();
						}
					}
				});
				super.addMouseMotionListener(new MouseMotionListener() {
					@Override
					public void mouseDragged(MouseEvent e) {
						if (KL.eq(k, "drag")) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseMoved(MouseEvent e) {
						if (KL.eq(k, "move")) {
							new Thread(action).run();
						}
					}
				});
				super.addMouseWheelListener(new MouseWheelListener() {
					@Override
					public void mouseWheelMoved(MouseWheelEvent e) {
						if (KL.eq(k, "wheel")) {
							new Thread(action).run();
						}
					}
				});
			}
			return this;
		}
	}
	public static class PwdField extends JPasswordField {
		private static final long serialVersionUID = 1L;
		PwdField() {
			super();
		}
		PwdField(String text) {
			super(text);
		}
		PwdField(int columns) {
			super(columns);
		}
		PwdField(String text, int columns) {
			super(text, columns);
		}
		PwdField(Document doc, String text, int columns) {
			super(doc, text, columns);
		}
		PwdField cursor(int c) {
			super.setCursor(new Cursor(c));
			return this;
		}
		PwdField cursor(Cursor crsrObj) {
			super.setCursor(crsrObj);
			return this;
		}
		PwdField border(LineBorder brdr) {
			super.setBorder(brdr);
			return this;
		}
		String text() {
			return new String(super.getPassword());
		}
		PwdField text(String text) {
			super.setText(text);
			return this;
		}
		String val() {
			return text();
		}
		PwdField val(String s) {
			text(s);
			return this;
		}
		String value() {
			return text();
		}
		PwdField value(String s) {
			text(s);
			return this;
		}
		PwdField on(String k, Runnable action) {
			if (KL.is(k) && KL.is(action)) {
				super.addKeyListener(new KeyListener() {
					@Override
					public void keyPressed(KeyEvent e) {
						char keyCharCaptured = e.getKeyChar();
						int keyCodeCaptured = e.getKeyCode();
						String keyCaptured = "" + keyCharCaptured;
						switch (keyCodeCaptured) {
						case KeyEvent.VK_UP :
							keyCaptured = "up";
							break;
						case KeyEvent.VK_DOWN :
							keyCaptured = "down";
							break;
						case KeyEvent.VK_LEFT :
							keyCaptured = "left";
							break;
						case KeyEvent.VK_RIGHT :
							keyCaptured = "right";
							break;
						case KeyEvent.VK_CONTROL :
							keyCaptured = "ctrl";
							break;
						}
						if (KL.eq(k, keyCaptured)) {
							new Thread(action).run();;
						}
					}
					@Override
					public void keyReleased(KeyEvent e) {
					}
					@Override
					public void keyTyped(KeyEvent e) {
					}
				});
				super.addMouseListener(new MouseListener() {
					@Override
					public void mouseClicked(MouseEvent e) {
					}
					@Override
					public void mousePressed(MouseEvent e) {
						int button = -1;
						if (KL.eq(k, "click") || KL.eq(k, "clickl"))
							button = MouseEvent.BUTTON1;
						else if (KL.eq(k, "clickm") || KL.eq(k, "clickw"))
							button = MouseEvent.BUTTON2;
						else if (KL.eq(k, "clickr"))
							button = MouseEvent.BUTTON3;
						if (e.getButton() == button) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseReleased(MouseEvent e) {
						if (KL.eq(k, "release")) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseEntered(MouseEvent e) {
						if (KL.eq(k, "enter")) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseExited(MouseEvent e) {
						if (KL.eq(k, "leave")) {
							new Thread(action).run();
						}
					}
				});
				super.addMouseMotionListener(new MouseMotionListener() {
					@Override
					public void mouseDragged(MouseEvent e) {
						if (KL.eq(k, "drag")) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseMoved(MouseEvent e) {
						if (KL.eq(k, "move")) {
							new Thread(action).run();
						}
					}
				});
				super.addMouseWheelListener(new MouseWheelListener() {
					@Override
					public void mouseWheelMoved(MouseWheelEvent e) {
						if (KL.eq(k, "wheel")) {
							new Thread(action).run();
						}
					}
				});
			}
			return this;
		}
	}
	public static class Icon extends ImageIcon {
		Icon() {
			super();
		}
		Icon(byte[] imageData) {
			super(imageData);
		}
		Icon(Image image) {
			super(image);
		}
		Icon(String filename) {
			super(filename);
		}
		Icon(java.net.URL urlObject) {
			super(urlObject);
		}
	}
	public static class clr extends Color {
		private static final long serialVersionUID = 1L;
		clr(int rgb) {
			super(rgb);
		}
		clr(int rgb, boolean includesAlphaAtEnd) {
			super(rgb, includesAlphaAtEnd);
		}
		clr(int r, int g, int b) {
			super(r, g, b);
			/*
			 * @params all in the integer range: 0 to 255
			 */
		}
		clr(int r, int g, int b, int a) {
			super(r, g, b, a);
			/*
			 * @params all in the integer range: 0 to 255
			 */
		}
		clr(double r, double g, double b) {
			super((float)r, (float)g, (float)b);
		}
		clr(double r, double g, double b, double a) {
			super((float)r, (float)g, (float)b, (float)a);
			/*
			 * @params all in the floating range: 0 to 1
			 */
		}
		clr(String hexStringWithAlpha, boolean hasApha) {
			this(from(hexStringWithAlpha), hasApha);
			/*
			 * @param hexString in the range: (#|0x)000 thru (#|0x)ffffff
			 */
		}
		clr(String hexStringWithAlpha) {
			super(from(hexStringWithAlpha), false);
			/*
			 * @param hexString in the range: (#|0x)000 thru (#|0x)ffffff
			 */
		}
		public static int from(String hex) {
			hex = hex.replaceAll("^(0x|#)", "");
			if (!eq(hex, "([a-f0-9]{3,4}){1,2}") || len(hex) == 5 || len(hex) == 7) return 0;
			int len = len(hex);
			int r, g, b, a = 255;
			if (len == 8) {
				a = Int(slice(hex, 6, 8), 16);
				r = Int(slice(hex, 0, 2), 16);
				g = Int(slice(hex, 2, 4), 16);
				b = Int(slice(hex, 4, 6), 16);
				return a << 24 | r << 16 | g << 8 | b;
				//the order stays as-is
			} else if (len == 6) {
				r = Int(slice(hex, 0, 2), 16);
				g = Int(slice(hex, 2, 4), 16);
				b = Int(slice(hex, 4, 6), 16);
				return r << 16 | g << 8 | b;
				//the order stays as-is
			} else if (len == 4) {
				a = Int(slice(hex, 3, 4), 16) * 17;
				r = Int(slice(hex, 0, 1), 16) * 17;
				g = Int(slice(hex, 1, 2), 16) * 17;
				b = Int(slice(hex, 2, 3), 16) * 17;
				return a << 24 | r << 16 | g << 8 | b;
				//the order stays as-is
			}
			r = Int(slice(hex, 0, 1), 16) * 17;
			g = Int(slice(hex, 1, 2), 16) * 17;
			b = Int(slice(hex, 2, 3), 16) * 17;
			return r << 16 | g << 8 | b;
			//the order stays as-is
		}
	}
	// some global font variables for the ease of access, only handy if you
	// extend
	// the library class with your own
	int BOLD, PLAIN, ITALIC, BOLDITALIC, Bold = BOLD = Font.BOLD,
										 Plain = PLAIN = Font.PLAIN, Italic = ITALIC = Font.ITALIC,
										 BoldItalic = BOLDITALIC = Bold | Italic;
	// some other syntax candies
	public static Pesa pesa() {
		return new Pesa();
	}
	public static Pesa pesa(double amnt) {
		return new Pesa(amnt);
	}
	public static Pesa pesa(double amnt, String curr) {
		return new Pesa(amnt, curr);
	}
	public static BordLay bordlay() {
		return new BordLay();
	}
	public static BordLay bordlay(int hgap, int vgap) {
		return new BordLay(hgap, vgap);
	}
	public static GridLay gridlay() {
		return new GridLay();
	}
	public static GridLay gridlay(int rows, int columns) {
		return new GridLay(rows, columns);
	}
	public static GridLay gridlay(int rows, int columns, int hgap, int vgap) {
		return new GridLay(rows, columns, hgap, vgap);
	}
	public static GridBagLay gridbaglay() {
		return new GridBagLay();
	}
	public static GridBagSettings gridbagsettings() {
		return new GridBagSettings();
	}
	public static FlowLay flowlay() {
		return new FlowLay();
	}
	public static FlowLay flowlay(int align) {
		return new FlowLay(align);
	}
	public static FlowLay flowlay(int align, int hgap, int vgap) {
		return new FlowLay(align, hgap, vgap);
	}
	public static CardLay cardlay() {
		return new CardLay();
	}
	public static CardLay cardlay(int hgap, int vgap) {
		return new CardLay(hgap, vgap);
	}
	public static BoxLay boxlay(Container target, int axis) {
		return new BoxLay(target, axis);
	}
	public static Panel panel() {
		return new Panel();
	}
	public static Panel panel(LayoutManager layout) {
		return new Panel(layout);
	}
	public static Panel panel(boolean isDoubleBuffered) {
		return new Panel(isDoubleBuffered);
	}
	public static Panel panel(LayoutManager layout, boolean isDoubleBuffered) {
		return new Panel(layout, isDoubleBuffered);
	}
	public static Label label() {
		return new Label();
	}
	public static Label label(String text) {
		return new Label(text);
	}
	public static TxtField txtField() {
		return new TxtField();
	}
	public static TxtField txtField(String text) {
		return new TxtField(text);
	}
	public static TxtField txtField(int columns) {
		return new TxtField(columns);
	}
	public static TxtField txtField(String text, int columns) {
		return new TxtField(text, columns);
	}
	public static TxtField txtField(Document doc, String text, int columns) {
		return new TxtField(doc, text, columns);
	}
	public static PwdField pwdField() {
		return new PwdField();
	}
	public static PwdField pwdField(String text) {
		return new PwdField(text);
	}
	public static PwdField pwdField(int columns) {
		return new PwdField(columns);
	}
	public static PwdField pwdField(String text, int columns) {
		return new PwdField(text, columns);
	}
	public static PwdField pwdField(Document doc, String text, int columns) {
		return new PwdField(doc, text, columns);
	}
	public static Icon icon() {
		return new Icon();
	}
	public static Icon icon(byte[] imageData) {
		return new Icon(imageData);
	}
	public static Icon icon(Image image) {
		return new Icon(image);
	}
	public static Icon icon(String filename) {
		return new Icon(filename);
	}
	public static Icon icon(java.net.URL urlObject) {
		return new Icon(urlObject);
	}
	public static clr clr(int rgb) {
		return new clr(rgb);
	}
	public static clr clr(int rgb, boolean includesAlphaAtEnd) {
		return new clr(rgb, includesAlphaAtEnd);
	}
	public static clr clr(int r, int g, int b) {
		return new clr(r, g, b);
	}
	public static clr clr(int r, int g, int b, int a) {
		return new clr(r, g, b, a);
		/*
		 * @params all in the integer range: 0 to 255
		 */
	}
	public static clr clr(double r, double g, double b) {
		return new clr(r, g, b);
	}
	public static clr clr(double r, double g, double b, double a) {
		return new clr(r, g, b, a);
		/*
		 * @params all in the floating range: 0 to 1
		 */
	}
	public static clr clr(String hexString) {
		hexString = hexString.replaceAll("^(0x|#)", "");
		int len = len(hexString);
		if (len == 8 || len == 4) return new clr(hexString, true);
		return new clr(hexString, false);
		/*
		 * @params all in the hex range: (0x|#)?000 thru (0x|#)?ffffffff
		 */
	}
	public static GUI gui() {
		return new GUI();
	}
	public static GUI gui(String t) {
		return new GUI(t);
	}
	public static GUI gui(String t, int w, int h) {
		return new GUI(t, w, h);
	}
	public static GUI nayaGUI() {
		return new GUI();
	}
	public static GUI nayaGUI(String t) {
		return new GUI(t);
	}
	public static GUI nayaGUI(String t, int w, int h) {
		return new GUI(t, w, h);
	}
	public static Btn btn() {
		return new Btn();
	}
	public static Btn btn(String txt) {
		return new Btn(txt);
	}
	public static Btn btn(String txt, ActionListener actionOnClick) {
		return new Btn(txt, actionOnClick);
	}
	public static Btn btn(Action a) {
		return new Btn(a);
	}
	public static Btn btn(Icon i) {
		return new Btn(i);
	}
	public static Btn btn(String text, Icon i) {
		return new Btn(text, i);
	}
	public static Btn nayaBtn() {
		return new Btn();
	}
	public static Btn nayaBtn(String txt) {
		return new Btn(txt);
	}
	public static Btn nayaBtn(String txt, ActionListener actionOnClick) {
		return new Btn(txt, actionOnClick);
	}
	public static Btn nayaBtn(Action a) {
		return new Btn(a);
	}
	public static Btn nayaBtn(Icon i) {
		return new Btn(i);
	}
	public static Btn nayaBtn(String text, Icon i) {
		return new Btn(text, i);
	}
	public static URL url(String address) {
		try {
			return URI.create(address).toURL();
		} catch (IllegalArgumentException | MalformedURLException e) {
			print("[KL.Exception.MalformedURL]\nBad URL!");
		}
		return null;
	}
	// general
	public static final class Obj_S extends HashMap<String, String> {
		Obj_S() {
			super();
		}
		Obj_S(String k1, String v1, String k2, String v2, String k3, String v3,
			  String k4, String v4, String k5, String v5, String k6,
			  String v6, String k7, String v7, String k8, String v8,
			  String k9, String v9, String k10, String v10) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
			super.put(k6, v6);
			super.put(k7, v7);
			super.put(k8, v8);
			super.put(k9, v9);
			super.put(k10, v10);
		}
		Obj_S(String k1, String v1, String k2, String v2, String k3, String v3,
			  String k4, String v4, String k5, String v5, String k6,
			  String v6, String k7, String v7, String k8, String v8,
			  String k9, String v9) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
			super.put(k6, v6);
			super.put(k7, v7);
			super.put(k8, v8);
			super.put(k9, v9);
		}
		Obj_S(String k1, String v1, String k2, String v2, String k3, String v3,
			  String k4, String v4, String k5, String v5, String k6,
			  String v6, String k7, String v7, String k8, String v8) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
			super.put(k6, v6);
			super.put(k7, v7);
			super.put(k8, v8);
		}
		Obj_S(String k1, String v1, String k2, String v2, String k3, String v3,
			  String k4, String v4, String k5, String v5, String k6,
			  String v6, String k7, String v7) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
			super.put(k6, v6);
			super.put(k7, v7);
		}
		Obj_S(String k1, String v1, String k2, String v2, String k3, String v3,
			  String k4, String v4, String k5, String v5, String k6,
			  String v6) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
			super.put(k6, v6);
		}
		Obj_S(String k1, String v1, String k2, String v2, String k3, String v3,
			  String k4, String v4, String k5, String v5) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
		}
		Obj_S(String k1, String v1, String k2, String v2, String k3, String v3,
			  String k4, String v4) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
		}
		Obj_S(String k1, String v1, String k2, String v2, String k3,
			  String v3) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
		}
		Obj_S(String k1, String v1, String k2, String v2) {
			super.put(k1, v1);
			super.put(k2, v2);
		}
		Obj_S(String k1, String v1) {
			super.put(k1, v1);
		}
		String key(String k) {
			return hasKey(k) ? super.get(k) : null;
		}
		String k(String k) {
			return hasKey(k) ? super.get(k) : null;
		}
		String val(String k) {
			return hasKey(k) ? super.get(k) : null;
		}
		String v(String k) {
			return hasKey(k) ? super.get(k) : null;
		}
		boolean hasKey(String k) {
			return super.containsKey(k);
		}
		boolean hasValue(String v) {
			return super.containsValue(v);
		}
		String[] keyArray() {
			Object[] objArray = super.keySet().toArray();
			String[] resultantArr = new String[objArray.length];
			for (int i = 0; i < objArray.length; i++) {
				resultantArr[i] = (String) objArray[i];
			}
			return resultantArr;
		}
		String[] array() {
			Object[] objArray = super.values().toArray();
			String[] resultantArr = new String[objArray.length];
			for (int i = 0; i < objArray.length; i++) {
				resultantArr[i] = (String) objArray[i];
			}
			return resultantArr;
		}
		String nthKey(int n) {
			return n >= 0 && n < length() ? keyArray()[n] : "";
		}
		String nthValue(int n) {
			return n >= 0 && n < length() ? array()[n] : "";
		}
		String nthLastValue(int n) {
			return n > 0 && n <= length() ? array()[length() - n] : "";
			// resolved bugfix: some changes helped avoid an index-out-of-bound
			// exception
		}
		String i(int n) {
			return nthValue(n);
		}
		String lasti(int n) {
			return nthLastValue(n);
		}
		String ilast(int n) {
			return nthLastValue(n);
		}
		String nth(int n) {
			return nthValue(n);
		}
		String nthlast(int n) {
			return nthLastValue(n);
		}
		String first() {
			return nth(0);
		}
		String second() {
			return nth(1);
		}
		String seclast() {
			return nthlast(2);
		}
		String last() {
			return nthlast(1);
		}
		Obj_S set(String k, String v) {
			if (!super.containsKey(k))
				super.put(k, v);
			else
				super.replace(k, v);
			return this;
		}
		Obj_S add(String k, String v) {
			set(k, v);
			return this;
		}
		String delete (String k) {
			String v = hasKey(k) ? super.get(k) : null;
			super.remove(k);
			return v;
		}
		Obj_S push(String k, String v) {
			add(k, v);
			return this;
		}
		String pop(String k) {
			return delete (k);
		}
		Obj_S update(String k, String v) {
			set(k, v);
			return this;
		}
		Set<String> keys() {
			return super.keySet();
		}
		Set<Map.Entry<String, String>> entries() {
			return super.entrySet();
		}
		void printMap() {
			System.out.println(super.clone());
		}
		void printAll() {
			printMap();
		}
		int length() {
			return super.size();
		}
	}
	public static final class Obj_I extends HashMap<String, Integer> {
		Obj_I() {
			super();
		}
		Obj_I(String k1, Integer v1, String k2, Integer v2, String k3,
			  Integer v3, String k4, Integer v4, String k5, Integer v5,
			  String k6, Integer v6, String k7, Integer v7, String k8,
			  Integer v8, String k9, Integer v9, String k10, Integer v10) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
			super.put(k6, v6);
			super.put(k7, v7);
			super.put(k8, v8);
			super.put(k9, v9);
			super.put(k10, v10);
		}
		Obj_I(String k1, Integer v1, String k2, Integer v2, String k3,
			  Integer v3, String k4, Integer v4, String k5, Integer v5,
			  String k6, Integer v6, String k7, Integer v7, String k8,
			  Integer v8, String k9, Integer v9) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
			super.put(k6, v6);
			super.put(k7, v7);
			super.put(k8, v8);
			super.put(k9, v9);
		}
		Obj_I(String k1, Integer v1, String k2, Integer v2, String k3,
			  Integer v3, String k4, Integer v4, String k5, Integer v5,
			  String k6, Integer v6, String k7, Integer v7, String k8,
			  Integer v8) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
			super.put(k6, v6);
			super.put(k7, v7);
			super.put(k8, v8);
		}
		Obj_I(String k1, Integer v1, String k2, Integer v2, String k3,
			  Integer v3, String k4, Integer v4, String k5, Integer v5,
			  String k6, Integer v6, String k7, Integer v7) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
			super.put(k6, v6);
			super.put(k7, v7);
		}
		Obj_I(String k1, Integer v1, String k2, Integer v2, String k3,
			  Integer v3, String k4, Integer v4, String k5, Integer v5,
			  String k6, Integer v6) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
			super.put(k6, v6);
		}
		Obj_I(String k1, Integer v1, String k2, Integer v2, String k3,
			  Integer v3, String k4, Integer v4, String k5, Integer v5) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
		}
		Obj_I(String k1, Integer v1, String k2, Integer v2, String k3,
			  Integer v3, String k4, Integer v4) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
		}
		Obj_I(String k1, Integer v1, String k2, Integer v2, String k3,
			  Integer v3) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
		}
		Obj_I(String k1, Integer v1, String k2, Integer v2) {
			super.put(k1, v1);
			super.put(k2, v2);
		}
		Obj_I(String k, Integer v) {
			super.put(k, v);
		}
		int key(String k) {
			return hasKey(k) ? super.get(k) : null;
		}
		int k(String k) {
			return hasKey(k) ? super.get(k) : null;
		}
		int val(String k) {
			return hasKey(k) ? super.get(k) : null;
		}
		int v(String k) {
			return hasKey(k) ? super.get(k) : null;
		}
		boolean hasKey(String k) {
			return super.containsKey(k);
		}
		boolean hasValue(Integer v) {
			return super.containsValue(v);
		}
		String[] keyArray() {
			Object[] objArray = super.keySet().toArray();
			String[] resultantArr = new String[objArray.length];
			for (int i = 0; i < objArray.length; i++) {
				resultantArr[i] = (String) objArray[i];
			}
			return resultantArr;
		}
		int[] array() {
			Object[] objArray = super.values().toArray();
			int[] resultantArr = new int[objArray.length];
			for (int i = 0; i < objArray.length; i++) {
				resultantArr[i] = (Integer) objArray[i];
			}
			return resultantArr;
		}
		String nthKey(int n) {
			return n >= 0 && n < length() ? keyArray()[n] : "";
		}
		int nthValue(int n) {
			return n >= 0 && n < length() ? array()[n] : 0;
		}
		int nthLastValue(int n) {
			return n > 0 && n <= length() ? array()[length() - n] : 0;
			// resolved bugfix: some changes helped avoid an index-out-of-bound
			// exception
		}
		int i(int n) {
			return nthValue(n);
		}
		int lasti(int n) {
			return nthLastValue(n);
		}
		int ilast(int n) {
			return nthLastValue(n);
		}
		int nth(int n) {
			return nthValue(n);
		}
		int nthlast(int n) {
			return nthLastValue(n);
		}
		int first() {
			return nth(0);
		}
		int second() {
			return nth(1);
		}
		int seclast() {
			return nthlast(2);
		}
		int last() {
			return nthlast(1);
		}
		Obj_I set(String k, Integer v) {
			if (!super.containsKey(k))
				super.put(k, v);
			else
				super.replace(k, v);
			return this;
		}
		Obj_I add(String k, Integer v) {
			set(k, v);
			return this;
		}
		int delete (String k) {
			int v = hasKey(k) ? super.get(k) : null;
			super.remove(k);
			return v;
		}
		Obj_I push(String k, int v) {
			add(k, v);
			return this;
		}
		int pop(String k) {
			return delete (k);
		}
		Obj_I update(String k, Integer v) {
			set(k, v);
			return this;
		}
		Set<String> keys() {
			return super.keySet();
		}
		Set<Map.Entry<String, Integer>> entries() {
			return super.entrySet();
		}
		void printMap() {
			System.out.println(super.clone());
		}
		void printAll() {
			printMap();
		}
		int length() {
			return super.size();
		}
	}
	public static final class Obj_L extends HashMap<String, Long> {
		Obj_L() {
			super();
		}
		Obj_L(String k1, Long v1, String k2, Long v2, String k3, Long v3,
			  String k4, Long v4, String k5, Long v5, String k6, Long v6,
			  String k7, Long v7, String k8, Long v8, String k9, Long v9,
			  String k10, Long v10) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
			super.put(k6, v6);
			super.put(k7, v7);
			super.put(k8, v8);
			super.put(k9, v9);
			super.put(k10, v10);
		}
		Obj_L(String k1, Long v1, String k2, Long v2, String k3, Long v3,
			  String k4, Long v4, String k5, Long v5, String k6, Long v6,
			  String k7, Long v7, String k8, Long v8, String k9, Long v9) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
			super.put(k6, v6);
			super.put(k7, v7);
			super.put(k8, v8);
			super.put(k9, v9);
		}
		Obj_L(String k1, Long v1, String k2, Long v2, String k3, Long v3,
			  String k4, Long v4, String k5, Long v5, String k6, Long v6,
			  String k7, Long v7, String k8, Long v8) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
			super.put(k6, v6);
			super.put(k7, v7);
			super.put(k8, v8);
		}
		Obj_L(String k1, Long v1, String k2, Long v2, String k3, Long v3,
			  String k4, Long v4, String k5, Long v5, String k6, Long v6,
			  String k7, Long v7) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
			super.put(k6, v6);
			super.put(k7, v7);
		}
		Obj_L(String k1, Long v1, String k2, Long v2, String k3, Long v3,
			  String k4, Long v4, String k5, Long v5, String k6, Long v6) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
			super.put(k6, v6);
		}
		Obj_L(String k1, Long v1, String k2, Long v2, String k3, Long v3,
			  String k4, Long v4, String k5, Long v5) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
		}
		Obj_L(String k1, Long v1, String k2, Long v2, String k3, Long v3,
			  String k4, Long v4) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
		}
		Obj_L(String k1, Long v1, String k2, Long v2, String k3, Long v3) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
		}
		Obj_L(String k1, Long v1, String k2, Long v2) {
			super.put(k1, v1);
			super.put(k2, v2);
		}
		Obj_L(String k, Long v) {
			super.put(k, v);
		}
		long key(String k) {
			return hasKey(k) ? super.get(k) : null;
		}
		long k(String k) {
			return hasKey(k) ? super.get(k) : null;
		}
		long val(String k) {
			return hasKey(k) ? super.get(k) : null;
		}
		long v(String k) {
			return hasKey(k) ? super.get(k) : null;
		}
		String[] keyArray() {
			Object[] objArray = super.keySet().toArray();
			String[] resultantArr = new String[objArray.length];
			for (int i = 0; i < objArray.length; i++) {
				resultantArr[i] = (String) objArray[i];
			}
			return resultantArr;
		}
		long[] array() {
			Object[] objArray = super.values().toArray();
			long[] resultantArr = new long[objArray.length];
			for (int i = 0; i < objArray.length; i++) {
				resultantArr[i] = (Long) objArray[i];
			}
			return resultantArr;
		}
		String nthKey(int n) {
			return n >= 0 && n < length() ? keyArray()[n] : "";
		}
		long nthValue(int n) {
			return n >= 0 && n < length() ? array()[n] : 0;
		}
		long nthLastValue(int n) {
			return n > 0 && n <= length() ? array()[length() - n] : 0;
			// resolved bugfix: some changes helped avoid an index-out-of-bound
			// exception
		}
		long i(int n) {
			return nthValue(n);
		}
		long lasti(int n) {
			return nthLastValue(n);
		}
		long ilast(int n) {
			return nthLastValue(n);
		}
		long nth(int n) {
			return nthValue(n);
		}
		long nthlast(int n) {
			return nthLastValue(n);
		}
		long first() {
			return nth(0);
		}
		long second() {
			return nth(1);
		}
		long seclast() {
			return nthlast(2);
		}
		long last() {
			return nthlast(1);
		}
		boolean hasKey(String k) {
			return super.containsKey(k);
		}
		boolean hasValue(Long v) {
			return super.containsValue(v);
		}
		Obj_L set(String k, Long v) {
			if (!super.containsKey(k))
				super.put(k, v);
			else
				super.replace(k, v);
			return this;
		}
		Obj_L add(String k, Long v) {
			set(k, v);
			return this;
		}
		long delete (String k) {
			return super.remove(k);
		}
		Obj_L push(String k, long v) {
			add(k, v);
			return this;
		}
		long pop(String k) {
			return delete (k);
		}
		Obj_L update(String k, Long v) {
			set(k, v);
			return this;
		}
		Set<String> keys() {
			return super.keySet();
		}
		Set<Map.Entry<String, Long>> entries() {
			return super.entrySet();
		}
		void printMap() {
			System.out.println(super.clone());
		}
		void printAll() {
			printMap();
		}
		int length() {
			return super.size();
		}
	}
	public static final class Obj_F extends HashMap<String, Float> {
		Obj_F() {
			super();
		}
		Obj_F(String k1, Float v1, String k2, Float v2, String k3, Float v3,
			  String k4, Float v4, String k5, Float v5, String k6, Float v6,
			  String k7, Float v7, String k8, Float v8, String k9, Float v9,
			  String k10, Float v10) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
			super.put(k6, v6);
			super.put(k7, v7);
			super.put(k8, v8);
			super.put(k9, v9);
			super.put(k10, v10);
		}
		Obj_F(String k1, Float v1, String k2, Float v2, String k3, Float v3,
			  String k4, Float v4, String k5, Float v5, String k6, Float v6,
			  String k7, Float v7, String k8, Float v8, String k9, Float v9) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
			super.put(k6, v6);
			super.put(k7, v7);
			super.put(k8, v8);
			super.put(k9, v9);
		}
		Obj_F(String k1, Float v1, String k2, Float v2, String k3, Float v3,
			  String k4, Float v4, String k5, Float v5, String k6, Float v6,
			  String k7, Float v7, String k8, Float v8) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
			super.put(k6, v6);
			super.put(k7, v7);
			super.put(k8, v8);
		}
		Obj_F(String k1, Float v1, String k2, Float v2, String k3, Float v3,
			  String k4, Float v4, String k5, Float v5, String k6, Float v6,
			  String k7, Float v7) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
			super.put(k6, v6);
			super.put(k7, v7);
		}
		Obj_F(String k1, Float v1, String k2, Float v2, String k3, Float v3,
			  String k4, Float v4, String k5, Float v5, String k6, Float v6) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
			super.put(k6, v6);
		}
		Obj_F(String k1, Float v1, String k2, Float v2, String k3, Float v3,
			  String k4, Float v4, String k5, Float v5) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
		}
		Obj_F(String k1, Float v1, String k2, Float v2, String k3, Float v3,
			  String k4, Float v4) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
		}
		Obj_F(String k1, Float v1, String k2, Float v2, String k3, Float v3) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
		}
		Obj_F(String k1, Float v1, String k2, Float v2) {
			super.put(k1, v1);
			super.put(k2, v2);
		}
		Obj_F(String k1, Float v1) {
			super.put(k1, v1);
		}
		float key(String k) {
			return hasKey(k) ? super.get(k) : null;
		}
		float k(String k) {
			return hasKey(k) ? super.get(k) : null;
		}
		float val(String k) {
			return hasKey(k) ? super.get(k) : null;
		}
		float v(String k) {
			return hasKey(k) ? super.get(k) : null;
		}
		String[] keyArray() {
			Object[] objArray = super.keySet().toArray();
			String[] resultantArr = new String[objArray.length];
			for (int i = 0; i < objArray.length; i++) {
				resultantArr[i] = (String) objArray[i];
			}
			return resultantArr;
		}
		float[] array() {
			Object[] objArray = super.values().toArray();
			float[] resultantArr = new float[objArray.length];
			for (int i = 0; i < objArray.length; i++) {
				resultantArr[i] = (Float) objArray[i];
			}
			return resultantArr;
		}
		String nthKey(int n) {
			return n >= 0 && n < length() ? keyArray()[n] : "";
		}
		float nthValue(int n) {
			return n >= 0 && n < length() ? array()[n] : 0;
		}
		float nthLastValue(int n) {
			return n > 0 && n <= length() ? array()[length() - n] : 0;
			// resolved bugfix: some changes helped avoid an index-out-of-bound
			// exception
		}
		float i(int n) {
			return nthValue(n);
		}
		float lasti(int n) {
			return nthLastValue(n);
		}
		float ilast(int n) {
			return nthLastValue(n);
		}
		float nth(int n) {
			return nthValue(n);
		}
		float nthlast(int n) {
			return nthLastValue(n);
		}
		float first() {
			return nth(0);
		}
		float second() {
			return nth(1);
		}
		float seclast() {
			return nthlast(2);
		}
		float last() {
			return nthlast(1);
		}
		boolean hasKey(String k) {
			return super.containsKey(k);
		}
		boolean hasValue(Float v) {
			return super.containsValue(v);
		}
		Obj_F set(String k, Float v) {
			if (!super.containsKey(k))
				super.put(k, v);
			else
				super.replace(k, v);
			return this;
		}
		Obj_F add(String k, Float v) {
			set(k, v);
			return this;
		}
		float delete (String k) {
			return super.remove(k);
		}
		Obj_F push(String k, float v) {
			add(k, v);
			return this;
		}
		float pop(String k) {
			return delete (k);
		}
		Obj_F update(String k, Float v) {
			set(k, v);
			return this;
		}
		Set<String> keys() {
			return super.keySet();
		}
		Set<Map.Entry<String, Float>> entries() {
			return super.entrySet();
		}
		void printMap() {
			System.out.println(super.clone());
		}
		void printAll() {
			printMap();
		}
		int length() {
			return super.size();
		}
	}
	public static final class Obj_D extends HashMap<String, Double> {
		Obj_D() {
			super();
		}
		Obj_D(String k1, Double v1, String k2, Double v2, String k3, Double v3,
			  String k4, Double v4, String k5, Double v5, String k6,
			  Double v6, String k7, Double v7, String k8, Double v8,
			  String k9, Double v9, String k10, Double v10) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
			super.put(k6, v6);
			super.put(k7, v7);
			super.put(k8, v8);
			super.put(k9, v9);
			super.put(k10, v10);
		}
		Obj_D(String k1, Double v1, String k2, Double v2, String k3, Double v3,
			  String k4, Double v4, String k5, Double v5, String k6,
			  Double v6, String k7, Double v7, String k8, Double v8,
			  String k9, Double v9) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
			super.put(k6, v6);
			super.put(k7, v7);
			super.put(k8, v8);
			super.put(k9, v9);
		}
		Obj_D(String k1, Double v1, String k2, Double v2, String k3, Double v3,
			  String k4, Double v4, String k5, Double v5, String k6,
			  Double v6, String k7, Double v7, String k8, Double v8) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
			super.put(k6, v6);
			super.put(k7, v7);
			super.put(k8, v8);
		}
		Obj_D(String k1, Double v1, String k2, Double v2, String k3, Double v3,
			  String k4, Double v4, String k5, Double v5, String k6,
			  Double v6, String k7, Double v7) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
			super.put(k6, v6);
			super.put(k7, v7);
		}
		Obj_D(String k1, Double v1, String k2, Double v2, String k3, Double v3,
			  String k4, Double v4, String k5, Double v5, String k6,
			  Double v6) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
			super.put(k6, v6);
		}
		Obj_D(String k1, Double v1, String k2, Double v2, String k3, Double v3,
			  String k4, Double v4, String k5, Double v5) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
		}
		Obj_D(String k1, Double v1, String k2, Double v2, String k3, Double v3,
			  String k4, Double v4) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
		}
		Obj_D(String k1, Double v1, String k2, Double v2, String k3,
			  Double v3) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
		}
		Obj_D(String k1, Double v1, String k2, Double v2) {
			super.put(k1, v1);
			super.put(k2, v2);
		}
		Obj_D(String k, Double v) {
			super.put(k, v);
		}
		double key(String k) {
			return hasKey(k) ? super.get(k) : null;
		}
		double k(String k) {
			return hasKey(k) ? super.get(k) : null;
		}
		double val(String k) {
			return hasKey(k) ? super.get(k) : null;
		}
		double v(String k) {
			return hasKey(k) ? super.get(k) : null;
		}
		String[] keyArray() {
			Object[] objArray = super.keySet().toArray();
			String[] resultantArr = new String[objArray.length];
			for (int i = 0; i < objArray.length; i++) {
				resultantArr[i] = (String) objArray[i];
			}
			return resultantArr;
		}
		double[] array() {
			Object[] objArray = super.values().toArray();
			double[] resultantArr = new double[objArray.length];
			for (int i = 0; i < objArray.length; i++) {
				resultantArr[i] = (Double) objArray[i];
			}
			return resultantArr;
		}
		String nthKey(int n) {
			return n >= 0 && n < length() ? keyArray()[n] : "";
		}
		double nthValue(int n) {
			return n >= 0 && n < length() ? array()[n] : 0;
		}
		double nthLastValue(int n) {
			return n > 0 && n <= length() ? array()[length() - n] : 0;
			// resolved bugfix: some changes helped avoid an index-out-of-bound
			// exception
		}
		double i(int n) {
			return nthValue(n);
		}
		double lasti(int n) {
			return nthLastValue(n);
		}
		double ilast(int n) {
			return nthLastValue(n);
		}
		double nth(int n) {
			return nthValue(n);
		}
		double nthlast(int n) {
			return nthLastValue(n);
		}
		double first() {
			return nth(0);
		}
		double second() {
			return nth(1);
		}
		double seclast() {
			return nthlast(2);
		}
		double last() {
			return nthlast(1);
		}
		boolean hasKey(String k) {
			return super.containsKey(k);
		}
		boolean hasValue(Double v) {
			return super.containsValue(v);
		}
		Obj_D set(String k, Double v) {
			if (!super.containsKey(k))
				super.put(k, v);
			else
				super.replace(k, v);
			return this;
		}
		Obj_D add(String k, Double v) {
			set(k, v);
			return this;
		}
		double delete (String k) {
			return super.remove(k);
		}
		Obj_D push(String k, double v) {
			add(k, v);
			return this;
		}
		double pop(String k) {
			return delete (k);
		}
		Obj_D update(String k, Double v) {
			set(k, v);
			return this;
		}
		Set<String> keys() {
			return super.keySet();
		}
		Set<Map.Entry<String, Double>> entries() {
			return super.entrySet();
		}
		void printMap() {
			System.out.println(super.clone());
		}
		void printAll() {
			printMap();
		}
		int length() {
			return super.size();
		}
	}
	public static final class Obj_B extends HashMap<String, Boolean> {
		Obj_B() {
			super();
		}
		Obj_B(String k1, Boolean v1, String k2, Boolean v2, String k3,
			  Boolean v3, String k4, Boolean v4, String k5, Boolean v5,
			  String k6, Boolean v6, String k7, Boolean v7, String k8,
			  Boolean v8, String k9, Boolean v9, String k10, Boolean v10) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
			super.put(k6, v6);
			super.put(k7, v7);
			super.put(k8, v8);
			super.put(k9, v9);
			super.put(k10, v10);
		}
		Obj_B(String k1, Boolean v1, String k2, Boolean v2, String k3,
			  Boolean v3, String k4, Boolean v4, String k5, Boolean v5,
			  String k6, Boolean v6, String k7, Boolean v7, String k8,
			  Boolean v8, String k9, Boolean v9) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
			super.put(k6, v6);
			super.put(k7, v7);
			super.put(k8, v8);
			super.put(k9, v9);
		}
		Obj_B(String k1, Boolean v1, String k2, Boolean v2, String k3,
			  Boolean v3, String k4, Boolean v4, String k5, Boolean v5,
			  String k6, Boolean v6, String k7, Boolean v7, String k8,
			  Boolean v8) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
			super.put(k6, v6);
			super.put(k7, v7);
			super.put(k8, v8);
		}
		Obj_B(String k1, Boolean v1, String k2, Boolean v2, String k3,
			  Boolean v3, String k4, Boolean v4, String k5, Boolean v5,
			  String k6, Boolean v6, String k7, Boolean v7) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
			super.put(k6, v6);
			super.put(k7, v7);
		}
		Obj_B(String k1, Boolean v1, String k2, Boolean v2, String k3,
			  Boolean v3, String k4, Boolean v4, String k5, Boolean v5,
			  String k6, Boolean v6) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
			super.put(k6, v6);
		}
		Obj_B(String k1, Boolean v1, String k2, Boolean v2, String k3,
			  Boolean v3, String k4, Boolean v4, String k5, Boolean v5) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
		}
		Obj_B(String k1, Boolean v1, String k2, Boolean v2, String k3,
			  Boolean v3, String k4, Boolean v4) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
		}
		Obj_B(String k1, Boolean v1, String k2, Boolean v2, String k3,
			  Boolean v3) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
		}
		Obj_B(String k1, Boolean v1, String k2, Boolean v2) {
			super.put(k1, v1);
			super.put(k2, v2);
		}
		Obj_B(String k, Boolean v) {
			super.put(k, v);
		}
		boolean key(String k) {
			return hasKey(k) ? super.get(k) : null;
		}
		boolean k(String k) {
			return hasKey(k) ? super.get(k) : null;
		}
		boolean val(String k) {
			return hasKey(k) ? super.get(k) : null;
		}
		boolean v(String k) {
			return hasKey(k) ? super.get(k) : null;
		}
		String[] keyArray() {
			Object[] objArray = super.keySet().toArray();
			String[] resultantArr = new String[objArray.length];
			for (int i = 0; i < objArray.length; i++) {
				resultantArr[i] = (String) objArray[i];
			}
			return resultantArr;
		}
		boolean[] array() {
			Object[] objArray = super.values().toArray();
			boolean[] resultantArr = new boolean[objArray.length];
			for (int i = 0; i < objArray.length; i++) {
				resultantArr[i] = (Boolean) objArray[i];
			}
			return resultantArr;
		}
		String nthKey(int n) {
			return n >= 0 && n < length() ? keyArray()[n] : "";
		}
		boolean nthValue(int n) {
			return n >= 0 && n < length() ? array()[n] : false;
		}
		boolean nthLastValue(int n) {
			return n > 0 && n <= length() ? array()[length() - n] : false;
			// resolved bugfix: some changes helped avoid an index-out-of-bound
			// exception
		}
		boolean i(int n) {
			return nthValue(n);
		}
		boolean lasti(int n) {
			return nthLastValue(n);
		}
		boolean ilast(int n) {
			return nthLastValue(n);
		}
		boolean nth(int n) {
			return nthValue(n);
		}
		boolean nthlast(int n) {
			return nthLastValue(n);
		}
		boolean first() {
			return nth(0);
		}
		boolean second() {
			return nth(1);
		}
		boolean seclast() {
			return nthlast(2);
		}
		boolean last() {
			return nthlast(1);
		}
		boolean hasKey(String k) {
			return super.containsKey(k);
		}
		boolean hasValue(Boolean v) {
			return super.containsValue(v);
		}
		Obj_B set(String k, Boolean v) {
			if (!super.containsKey(k))
				super.put(k, v);
			else
				super.replace(k, v);
			return this;
		}
		Obj_B add(String k, Boolean v) {
			set(k, v);
			return this;
		}
		boolean delete (String k) {
			return super.remove(k);
		}
		Obj_B push(String k, Boolean v) {
			add(k, v);
			return this;
		}
		boolean pop(String k) {
			return delete (k);
		}
		Obj_B update(String k, Boolean v) {
			set(k, v);
			return this;
		}
		Set<String> keys() {
			return super.keySet();
		}
		Set<Map.Entry<String, Boolean>> entries() {
			return super.entrySet();
		}
		void printMap() {
			System.out.println(super.clone());
		}
		void printAll() {
			printMap();
		}
		int length() {
			return super.size();
		}
	}
	public static class Tree<Key, Value> extends TreeMap<Key, Value> {
		Tree() {
			super();
		}
		Tree(Key k1, Value v1, Key k2, Value v2, Key k3, Value v3, Key k4,
			 Value v4, Key k5, Value v5, Key k6, Value v6, Key k7, Value v7,
			 Key k8, Value v8, Key k9, Value v9, Key k10, Value v10) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
			super.put(k6, v6);
			super.put(k7, v7);
			super.put(k8, v8);
			super.put(k9, v9);
			super.put(k10, v10);
		}
		Tree(Key k1, Value v1, Key k2, Value v2, Key k3, Value v3, Key k4,
			 Value v4, Key k5, Value v5, Key k6, Value v6, Key k7, Value v7,
			 Key k8, Value v8, Key k9, Value v9) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
			super.put(k6, v6);
			super.put(k7, v7);
			super.put(k8, v8);
			super.put(k9, v9);
		}
		Tree(Key k1, Value v1, Key k2, Value v2, Key k3, Value v3, Key k4,
			 Value v4, Key k5, Value v5, Key k6, Value v6, Key k7, Value v7,
			 Key k8, Value v8) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
			super.put(k6, v6);
			super.put(k7, v7);
			super.put(k8, v8);
		}
		Tree(Key k1, Value v1, Key k2, Value v2, Key k3, Value v3, Key k4,
			 Value v4, Key k5, Value v5, Key k6, Value v6, Key k7,
			 Value v7) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
			super.put(k6, v6);
			super.put(k7, v7);
		}
		Tree(Key k1, Value v1, Key k2, Value v2, Key k3, Value v3, Key k4,
			 Value v4, Key k5, Value v5, Key k6, Value v6) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
			super.put(k6, v6);
		}
		Tree(Key k1, Value v1, Key k2, Value v2, Key k3, Value v3, Key k4,
			 Value v4, Key k5, Value v5) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
		}
		Tree(Key k1, Value v1, Key k2, Value v2, Key k3, Value v3, Key k4,
			 Value v4) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
		}
		Tree(Key k1, Value v1, Key k2, Value v2, Key k3, Value v3) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
		}
		Tree(Key k1, Value v1, Key k2, Value v2) {
			super.put(k1, v1);
			super.put(k2, v2);
		}
		Tree(Key k1, Value v1) {
			super.put(k1, v1);
		}
		Value key(Key k) {
			return hasKey(k) ? super.get(k) : null;
		}
		Value k(Key k) {
			return hasKey(k) ? super.get(k) : null;
		}
		Value val(Key k) {
			return hasKey(k) ? super.get(k) : null;
		}
		Value v(Key k) {
			return hasKey(k) ? super.get(k) : null;
		}
		boolean hasKey(Key k) {
			return super.containsKey(k);
		}
		boolean hasValue(Value v) {
			return super.containsValue(v);
		}
		Tree<Key, Value> set(Key k, Value v) {
			if (!super.containsKey(k))
				super.put(k, v);
			else
				super.replace(k, v);
			return this;
		}
		Tree<Key, Value> add(Key k, Value v) {
			set(k, v);
			return this;
		}
		Value delete (Key k) {
			Value v = hasKey(k) ? super.get(k) : null;
			super.remove(k);
			return v;
		}
		Tree<Key, Value> push(Key k, Value v) {
			add(k, v);
			return this;
		}
		Value pop(Key k) {
			return delete (k);
		}
		Tree<Key, Value> update(Key k, Value v) {
			set(k, v);
			return this;
		}
		Value first() {
			Map.Entry<Key, Value> firstEntry = super.firstEntry();
			Value firstValue = null;
			if (firstEntry != null) {
				firstValue = firstEntry.getValue();
			}
			return firstValue;
		}
		Value last() {
			Map.Entry<Key, Value> lastEntry = super.lastEntry();
			Value lastValue = null;
			if (lastEntry != null) {
				lastValue = lastEntry.getValue();
			}
			return lastValue;
		}
		Set<Key> keys() {
			return super.keySet();
		}
		Set<Map.Entry<Key, Value>> entries() {
			return super.entrySet();
		}
		void printMap() {
			System.out.println(super.clone());
		}
		void printAll() {
			printMap();
		}
		int length() {
			return super.size();
		}
	}
	public static class Tree_S extends Tree<String, Integer> {
		// public static final long serialVersionUID = 1L;
		Tree_S() {
			super();
		}
		Tree_S(String k1, int v1, String k2, int v2, String k3, int v3,
			   String k4, int v4, String k5, int v5, String k6, int v6,
			   String k7, int v7, String k8, int v8, String k9, int v9,
			   String k10, int v10) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9, k10, v10);
		}
		Tree_S(String k1, int v1, String k2, int v2, String k3, int v3,
			   String k4, int v4, String k5, int v5, String k6, int v6,
			   String k7, int v7, String k8, int v8, String k9, int v9) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9);
		}
		Tree_S(String k1, int v1, String k2, int v2, String k3, int v3,
			   String k4, int v4, String k5, int v5, String k6, int v6,
			   String k7, int v7, String k8, int v8) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8);
		}
		Tree_S(String k1, int v1, String k2, int v2, String k3, int v3,
			   String k4, int v4, String k5, int v5, String k6, int v6,
			   String k7, int v7) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7);
		}
		Tree_S(String k1, int v1, String k2, int v2, String k3, int v3,
			   String k4, int v4, String k5, int v5, String k6, int v6) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
		}
		Tree_S(String k1, int v1, String k2, int v2, String k3, int v3,
			   String k4, int v4, String k5, int v5) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
		}
		Tree_S(String k1, int v1, String k2, int v2, String k3, int v3,
			   String k4, int v4) {
			super(k1, v1, k2, v2, k3, v3, k4, v4);
		}
		Tree_S(String k1, int v1, String k2, int v2, String k3, int v3) {
			super(k1, v1, k2, v2, k3, v3);
		}
		Tree_S(String k1, int v1, String k2, int v2) {
			super(k1, v1, k2, v2);
		}
		Tree_S(String k1, int v1) {
			super(k1, v1);
		}
		Tree_S copy() {
			return (Tree_S) super.clone();
		}
		String[] keyArray() {
			Object[] objArray = super.keySet().toArray();
			String[] resultantArr = new String[objArray.length];
			for (int i = 0; i < objArray.length; i++) {
				resultantArr[i] = (String) objArray[i];
			}
			return resultantArr;
		}
		int[] array() {
			Object[] objArray = super.values().toArray();
			int[] resultantArr = new int[objArray.length];
			for (int i = 0; i < objArray.length; i++) {
				resultantArr[i] = (Integer) objArray[i];
			}
			return resultantArr;
		}
		String nthKey(int n) {
			return n >= 0 && n < super.length() ? keyArray()[n] : "";
		}
		int nthValue(int n) {
			return n >= 0 && n < super.length() ? array()[n] : 0;
		}
		int nthLastValue(int n) {
			return n > 0 && n <= super.length()
				   ? array()[super.length() - n]
				   : 0;
			// bugfixed
		}
		int i(int n) {
			return nthValue(n);
		}
		int lasti(int n) {
			return nthLastValue(n);
		}
		int ilast(int n) {
			return nthLastValue(n);
		}
		int nth(int n) {
			return nthValue(n);
		}
		int nthlast(int n) {
			return nthLastValue(n);
		}
	}
	public static class Tree_SL extends Tree<String, Long> {
		// public static final long serialVersionUID = 1L;
		Tree_SL() {
			super();
		}
		Tree_SL(String k1, long v1, String k2, long v2, String k3, long v3,
				String k4, long v4, String k5, long v5, String k6, long v6,
				String k7, long v7, String k8, long v8, String k9, long v9,
				String k10, long v10) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9, k10, v10);
		}
		Tree_SL(String k1, long v1, String k2, long v2, String k3, long v3,
				String k4, long v4, String k5, long v5, String k6, long v6,
				String k7, long v7, String k8, long v8, String k9, long v9) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9);
		}
		Tree_SL(String k1, long v1, String k2, long v2, String k3, long v3,
				String k4, long v4, String k5, long v5, String k6, long v6,
				String k7, long v7, String k8, long v8) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8);
		}
		Tree_SL(String k1, long v1, String k2, long v2, String k3, long v3,
				String k4, long v4, String k5, long v5, String k6, long v6,
				String k7, long v7) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7);
		}
		Tree_SL(String k1, long v1, String k2, long v2, String k3, long v3,
				String k4, long v4, String k5, long v5, String k6, long v6) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
		}
		Tree_SL(String k1, long v1, String k2, long v2, String k3, long v3,
				String k4, long v4, String k5, long v5) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
		}
		Tree_SL(String k1, long v1, String k2, long v2, String k3, long v3,
				String k4, long v4) {
			super(k1, v1, k2, v2, k3, v3, k4, v4);
		}
		Tree_SL(String k1, long v1, String k2, long v2, String k3, long v3) {
			super(k1, v1, k2, v2, k3, v3);
		}
		Tree_SL(String k1, long v1, String k2, long v2) {
			super(k1, v1, k2, v2);
		}
		Tree_SL(String k1, long v1) {
			super(k1, v1);
		}
		Tree_SL copy() {
			return (Tree_SL) super.clone();
		}
		String[] keyArray() {
			Object[] objArray = super.keySet().toArray();
			String[] resultantArr = new String[objArray.length];
			for (int i = 0; i < objArray.length; i++) {
				resultantArr[i] = (String) objArray[i];
			}
			return resultantArr;
		}
		long[] array() {
			Object[] objArray = super.values().toArray();
			long[] resultantArr = new long[objArray.length];
			for (int i = 0; i < objArray.length; i++) {
				resultantArr[i] = (Long) objArray[i];
			}
			return resultantArr;
		}
		String nthKey(int n) {
			return n >= 0 && n < super.length() ? keyArray()[n] : "";
		}
		long nthValue(int n) {
			return n >= 0 && n < super.length() ? array()[n] : 0;
		}
		long nthLastValue(int n) {
			return n > 0 && n <= super.length()
				   ? array()[super.length() - n]
				   : 0;
			// resolved bugfix: some changes helped avoid an index-out-of-bound
			// exception
		}
		long i(int n) {
			return nthValue(n);
		}
		long lasti(int n) {
			return nthLastValue(n);
		}
		long ilast(int n) {
			return nthLastValue(n);
		}
		long nth(int n) {
			return nthValue(n);
		}
		long nthlast(int n) {
			return nthLastValue(n);
		}
	}
	public static class Tree_SF extends Tree<String, Float> {
		// public static final long serialVersionUID = 1L;
		Tree_SF() {
			super();
		}
		Tree_SF(String k1, float v1, String k2, float v2, String k3, float v3,
				String k4, float v4, String k5, float v5, String k6, float v6,
				String k7, float v7, String k8, float v8, String k9, float v9,
				String k10, float v10) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9, k10, v10);
		}
		Tree_SF(String k1, float v1, String k2, float v2, String k3, float v3,
				String k4, float v4, String k5, float v5, String k6, float v6,
				String k7, float v7, String k8, float v8, String k9, float v9) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9);
		}
		Tree_SF(String k1, float v1, String k2, float v2, String k3, float v3,
				String k4, float v4, String k5, float v5, String k6, float v6,
				String k7, float v7, String k8, float v8) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8);
		}
		Tree_SF(String k1, float v1, String k2, float v2, String k3, float v3,
				String k4, float v4, String k5, float v5, String k6, float v6,
				String k7, float v7) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7);
		}
		Tree_SF(String k1, float v1, String k2, float v2, String k3, float v3,
				String k4, float v4, String k5, float v5, String k6, float v6) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
		}
		Tree_SF(String k1, float v1, String k2, float v2, String k3, float v3,
				String k4, float v4, String k5, float v5) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
		}
		Tree_SF(String k1, float v1, String k2, float v2, String k3, float v3,
				String k4, float v4) {
			super(k1, v1, k2, v2, k3, v3, k4, v4);
		}
		Tree_SF(String k1, float v1, String k2, float v2, String k3, float v3) {
			super(k1, v1, k2, v2, k3, v3);
		}
		Tree_SF(String k1, float v1, String k2, float v2) {
			super(k1, v1, k2, v2);
		}
		Tree_SF(String k1, float v1) {
			super(k1, v1);
		}
		Tree_SF copy() {
			return (Tree_SF) super.clone();
		}
		String[] keyArray() {
			Object[] objArray = super.keySet().toArray();
			String[] resultantArr = new String[objArray.length];
			for (int i = 0; i < objArray.length; i++) {
				resultantArr[i] = (String) objArray[i];
			}
			return resultantArr;
		}
		float[] array() {
			Object[] objArray = super.values().toArray();
			float[] resultantArr = new float[objArray.length];
			for (int i = 0; i < objArray.length; i++) {
				resultantArr[i] = (Float) objArray[i];
			}
			return resultantArr;
		}
		String nthKey(int n) {
			return n >= 0 && n < super.length() ? keyArray()[n] : "";
		}
		float nthValue(int n) {
			return n >= 0 && n < super.length() ? array()[n] : 0;
		}
		float nthLastValue(int n) {
			return n > 0 && n <= super.length()
				   ? array()[super.length() - n]
				   : 0;
			// resolved bugfix: some changes helped avoid an index-out-of-bound
			// exception
		}
		float i(int n) {
			return nthValue(n);
		}
		float lasti(int n) {
			return nthLastValue(n);
		}
		float ilast(int n) {
			return nthLastValue(n);
		}
		float nth(int n) {
			return nthValue(n);
		}
		float nthlast(int n) {
			return nthLastValue(n);
		}
	}
	public static class Tree_SD extends Tree<String, Double> {
		// public static final long serialVersionUID = 1L;
		Tree_SD() {
			super();
		}
		Tree_SD(String k1, double v1, String k2, double v2, String k3,
				double v3, String k4, double v4, String k5, double v5,
				String k6, double v6, String k7, double v7, String k8,
				double v8, String k9, double v9, String k10, double v10) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9, k10, v10);
		}
		Tree_SD(String k1, double v1, String k2, double v2, String k3,
				double v3, String k4, double v4, String k5, double v5,
				String k6, double v6, String k7, double v7, String k8,
				double v8, String k9, double v9) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9);
		}
		Tree_SD(String k1, double v1, String k2, double v2, String k3,
				double v3, String k4, double v4, String k5, double v5,
				String k6, double v6, String k7, double v7, String k8,
				double v8) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8);
		}
		Tree_SD(String k1, double v1, String k2, double v2, String k3,
				double v3, String k4, double v4, String k5, double v5,
				String k6, double v6, String k7, double v7) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7);
		}
		Tree_SD(String k1, double v1, String k2, double v2, String k3,
				double v3, String k4, double v4, String k5, double v5,
				String k6, double v6) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
		}
		Tree_SD(String k1, double v1, String k2, double v2, String k3,
				double v3, String k4, double v4, String k5, double v5) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
		}
		Tree_SD(String k1, double v1, String k2, double v2, String k3,
				double v3, String k4, double v4) {
			super(k1, v1, k2, v2, k3, v3, k4, v4);
		}
		Tree_SD(String k1, double v1, String k2, double v2, String k3,
				double v3) {
			super(k1, v1, k2, v2, k3, v3);
		}
		Tree_SD(String k1, double v1, String k2, double v2) {
			super(k1, v1, k2, v2);
		}
		Tree_SD(String k1, double v1) {
			super(k1, v1);
		}
		Tree_SD copy() {
			return (Tree_SD) super.clone();
		}
		String[] keyArray() {
			Object[] objArray = super.keySet().toArray();
			String[] resultantArr = new String[objArray.length];
			for (int i = 0; i < objArray.length; i++) {
				resultantArr[i] = (String) objArray[i];
			}
			return resultantArr;
		}
		double[] array() {
			Object[] objArray = super.values().toArray();
			double[] resultantArr = new double[objArray.length];
			for (int i = 0; i < objArray.length; i++) {
				resultantArr[i] = (Double) objArray[i];
			}
			return resultantArr;
		}
		String nthKey(int n) {
			return n >= 0 && n < super.length() ? keyArray()[n] : "";
		}
		double nthValue(int n) {
			return n >= 0 && n < super.length() ? array()[n] : 0;
		}
		double nthLastValue(int n) {
			return n > 0 && n <= super.length()
				   ? array()[super.length() - n]
				   : 0;
			// resolved bugfix: some changes helped avoid an index-out-of-bound
			// exception
		}
		double i(int n) {
			return nthValue(n);
		}
		double lasti(int n) {
			return nthLastValue(n);
		}
		double ilast(int n) {
			return nthLastValue(n);
		}
		double nth(int n) {
			return nthValue(n);
		}
		double nthlast(int n) {
			return nthLastValue(n);
		}
	}
	public static class Tree_SB extends Tree<String, Boolean> {
		// public static final long serialVersionUID = 1L;
		Tree_SB() {
			super();
		}
		Tree_SB(String k1, boolean v1, String k2, boolean v2, String k3,
				boolean v3, String k4, boolean v4, String k5, boolean v5,
				String k6, boolean v6, String k7, boolean v7, String k8,
				boolean v8, String k9, boolean v9, String k10, boolean v10) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9, k10, v10);
		}
		Tree_SB(String k1, boolean v1, String k2, boolean v2, String k3,
				boolean v3, String k4, boolean v4, String k5, boolean v5,
				String k6, boolean v6, String k7, boolean v7, String k8,
				boolean v8, String k9, boolean v9) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9);
		}
		Tree_SB(String k1, boolean v1, String k2, boolean v2, String k3,
				boolean v3, String k4, boolean v4, String k5, boolean v5,
				String k6, boolean v6, String k7, boolean v7, String k8,
				boolean v8) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8);
		}
		Tree_SB(String k1, boolean v1, String k2, boolean v2, String k3,
				boolean v3, String k4, boolean v4, String k5, boolean v5,
				String k6, boolean v6, String k7, boolean v7) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7);
		}
		Tree_SB(String k1, boolean v1, String k2, boolean v2, String k3,
				boolean v3, String k4, boolean v4, String k5, boolean v5,
				String k6, boolean v6) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
		}
		Tree_SB(String k1, boolean v1, String k2, boolean v2, String k3,
				boolean v3, String k4, boolean v4, String k5, boolean v5) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
		}
		Tree_SB(String k1, boolean v1, String k2, boolean v2, String k3,
				boolean v3, String k4, boolean v4) {
			super(k1, v1, k2, v2, k3, v3, k4, v4);
		}
		Tree_SB(String k1, boolean v1, String k2, boolean v2, String k3,
				boolean v3) {
			super(k1, v1, k2, v2, k3, v3);
		}
		Tree_SB(String k1, boolean v1, String k2, boolean v2) {
			super(k1, v1, k2, v2);
		}
		Tree_SB(String k1, boolean v1) {
			super(k1, v1);
		}
		Tree_SB copy() {
			return (Tree_SB) super.clone();
		}
		String[] keyArray() {
			Object[] objArray = super.keySet().toArray();
			String[] resultantArr = new String[objArray.length];
			for (int i = 0; i < objArray.length; i++) {
				resultantArr[i] = (String) objArray[i];
			}
			return resultantArr;
		}
		boolean[] array() {
			Object[] objArray = super.values().toArray();
			boolean[] resultantArr = new boolean[objArray.length];
			for (int i = 0; i < objArray.length; i++) {
				resultantArr[i] = (Boolean) objArray[i];
			}
			return resultantArr;
		}
		String nthKey(int n) {
			return n >= 0 && n < super.length() ? keyArray()[n] : "";
		}
		boolean nthValue(int n) {
			return n >= 0 && n < super.length() ? array()[n] : false;
		}
		boolean nthLastValue(int n) {
			return n > 0 && n <= super.length()
				   ? array()[super.length() - n]
				   : false;
			// resolved bugfix: some changes helped avoid an index-out-of-bound
			// exception
		}
		boolean i(int n) {
			return nthValue(n);
		}
		boolean lasti(int n) {
			return nthLastValue(n);
		}
		boolean ilast(int n) {
			return nthLastValue(n);
		}
		boolean nth(int n) {
			return nthValue(n);
		}
		boolean nthlast(int n) {
			return nthLastValue(n);
		}
	}
	public static class Tree_I extends Tree<Integer, String> {
		// public static final long serialVersionUID = 1L;
		Tree_I() {
			super();
		}
		Tree_I(int k1, String v1, int k2, String v2, int k3, String v3, int k4,
			   String v4, int k5, String v5, int k6, String v6, int k7, String v7, int k8, String v8, int k9, String v9, int k10, String v10) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9, k10, v10);
		}
		Tree_I(int k1, String v1, int k2, String v2, int k3, String v3, int k4,
			   String v4, int k5, String v5, int k6, String v6, int k7, String v7, int k8, String v8, int k9, String v9) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9);
		}
		Tree_I(int k1, String v1, int k2, String v2, int k3, String v3, int k4,
			   String v4, int k5, String v5, int k6, String v6, int k7, String v7, int k8, String v8) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8);
		}
		Tree_I(int k1, String v1, int k2, String v2, int k3, String v3, int k4,
			   String v4, int k5, String v5, int k6, String v6, int k7, String v7) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7);
		}
		Tree_I(int k1, String v1, int k2, String v2, int k3, String v3, int k4,
			   String v4, int k5, String v5, int k6, String v6) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
		}
		Tree_I(int k1, String v1, int k2, String v2, int k3, String v3, int k4,
			   String v4, int k5, String v5) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
		}
		Tree_I(int k1, String v1, int k2, String v2, int k3, String v3, int k4,
			   String v4) {
			super(k1, v1, k2, v2, k3, v3, k4, v4);
		}
		Tree_I(int k1, String v1, int k2, String v2, int k3, String v3) {
			super(k1, v1, k2, v2, k3, v3);
		}
		Tree_I(int k1, String v1, int k2, String v2) {
			super(k1, v1, k2, v2);
		}
		Tree_I(int k1, String v1) {
			super(k1, v1);
		}
		Tree_I copy() {
			return (Tree_I) super.clone();
		}
		int[] keyArray() {
			Object[] objArray = super.keySet().toArray();
			int[] resultantArr = new int[objArray.length];
			for (int i = 0; i < objArray.length; i++) {
				resultantArr[i] = (Integer) objArray[i];
			}
			return resultantArr;
		}
		String[] array() {
			Object[] objArray = super.values().toArray();
			String[] resultantArr = new String[objArray.length];
			for (int i = 0; i < objArray.length; i++) {
				resultantArr[i] = (String) objArray[i];
			}
			return resultantArr;
		}
		int nthKey(int n) {
			return n >= 0 && n < super.length() ? keyArray()[n] : 0;
		}
		String nthValue(int n) {
			return n >= 0 && n < super.length() ? array()[n] : "";
		}
		String nthLastValue(int n) {
			return n > 0 && n <= super.length()
				   ? array()[super.length() - n]
				   : "";
			// resolved bugfix: some changes helped avoid an index-out-of-bound
			// exception
		}
		String i(int n) {
			return nthValue(n);
		}
		String lasti(int n) {
			return nthLastValue(n);
		}
		String ilast(int n) {
			return nthLastValue(n);
		}
		String nth(int n) {
			return nthValue(n);
		}
		String nthlast(int n) {
			return nthLastValue(n);
		}
	}
	public static class Tree_L extends Tree<Integer, Long> {
		// public static final long serialVersionUID = 1L;
		Tree_L() {
			super();
		}
		Tree_L(int k1, long v1, int k2, long v2, int k3, long v3, int k4,
			   long v4, int k5, long v5, int k6, long v6, int k7, long v7,
			   int k8, long v8, int k9, long v9, int k10, long v10) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9, k10, v10);
		}
		Tree_L(int k1, long v1, int k2, long v2, int k3, long v3, int k4,
			   long v4, int k5, long v5, int k6, long v6, int k7, long v7,
			   int k8, long v8, int k9, long v9) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9);
		}
		Tree_L(int k1, long v1, int k2, long v2, int k3, long v3, int k4,
			   long v4, int k5, long v5, int k6, long v6, int k7, long v7,
			   int k8, long v8) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8);
		}
		Tree_L(int k1, long v1, int k2, long v2, int k3, long v3, int k4,
			   long v4, int k5, long v5, int k6, long v6, int k7, long v7) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7);
		}
		Tree_L(int k1, long v1, int k2, long v2, int k3, long v3, int k4,
			   long v4, int k5, long v5, int k6, long v6) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
		}
		Tree_L(int k1, long v1, int k2, long v2, int k3, long v3, int k4,
			   long v4, int k5, long v5) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
		}
		Tree_L(int k1, long v1, int k2, long v2, int k3, long v3, int k4,
			   long v4) {
			super(k1, v1, k2, v2, k3, v3, k4, v4);
		}
		Tree_L(int k1, long v1, int k2, long v2, int k3, long v3) {
			super(k1, v1, k2, v2, k3, v3);
		}
		Tree_L(int k1, long v1, int k2, long v2) {
			super(k1, v1, k2, v2);
		}
		Tree_L(int k1, long v1) {
			super(k1, v1);
		}
		Tree_L copy() {
			return (Tree_L) super.clone();
		}
		int[] keyArray() {
			Object[] objArray = super.keySet().toArray();
			int[] resultantArr = new int[objArray.length];
			for (int i = 0; i < objArray.length; i++) {
				resultantArr[i] = (Integer) objArray[i];
			}
			return resultantArr;
		}
		long[] array() {
			Object[] objArray = super.values().toArray();
			long[] resultantArr = new long[objArray.length];
			for (int i = 0; i < objArray.length; i++) {
				resultantArr[i] = (Long) objArray[i];
			}
			return resultantArr;
		}
		int nthKey(int n) {
			return n >= 0 && n < super.length() ? keyArray()[n] : 0;
		}
		long nthValue(int n) {
			return n >= 0 && n < super.length() ? array()[n] : 0;
		}
		long nthLastValue(int n) {
			return n > 0 && n <= super.length()
				   ? array()[super.length() - n]
				   : 0;
			// resolved bugfix: some changes helped avoid an index-out-of-bound
			// exception
		}
		long i(int n) {
			return nthValue(n);
		}
		long lasti(int n) {
			return nthLastValue(n);
		}
		long ilast(int n) {
			return nthLastValue(n);
		}
		long nth(int n) {
			return nthValue(n);
		}
		long nthlast(int n) {
			return nthLastValue(n);
		}
	}
	public static class Tree_F extends Tree<Integer, Float> {
		// public static final long serialVersionUID = 1L;
		Tree_F() {
			super();
		}
		Tree_F(int k1, float v1, int k2, float v2, int k3, float v3, int k4,
			   float v4, int k5, float v5, int k6, float v6, int k7, float v7,
			   int k8, float v8, int k9, float v9, int k10, float v10) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9, k10, v10);
		}
		Tree_F(int k1, float v1, int k2, float v2, int k3, float v3, int k4,
			   float v4, int k5, float v5, int k6, float v6, int k7, float v7,
			   int k8, float v8, int k9, float v9) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9);
		}
		Tree_F(int k1, float v1, int k2, float v2, int k3, float v3, int k4,
			   float v4, int k5, float v5, int k6, float v6, int k7, float v7,
			   int k8, float v8) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8);
		}
		Tree_F(int k1, float v1, int k2, float v2, int k3, float v3, int k4,
			   float v4, int k5, float v5, int k6, float v6, int k7, float v7) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7);
		}
		Tree_F(int k1, float v1, int k2, float v2, int k3, float v3, int k4,
			   float v4, int k5, float v5, int k6, float v6) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
		}
		Tree_F(int k1, float v1, int k2, float v2, int k3, float v3, int k4,
			   float v4, int k5, float v5) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
		}
		Tree_F(int k1, float v1, int k2, float v2, int k3, float v3, int k4,
			   float v4) {
			super(k1, v1, k2, v2, k3, v3, k4, v4);
		}
		Tree_F(int k1, float v1, int k2, float v2, int k3, float v3) {
			super(k1, v1, k2, v2, k3, v3);
		}
		Tree_F(int k1, float v1, int k2, float v2) {
			super(k1, v1, k2, v2);
		}
		Tree_F(int k1, float v1) {
			super(k1, v1);
		}
		Tree_F copy() {
			return (Tree_F) super.clone();
		}
		int[] keyArray() {
			Object[] objArray = super.keySet().toArray();
			int[] resultantArr = new int[objArray.length];
			for (int i = 0; i < objArray.length; i++) {
				resultantArr[i] = (Integer) objArray[i];
			}
			return resultantArr;
		}
		float[] array() {
			Object[] objArray = super.values().toArray();
			float[] resultantArr = new float[objArray.length];
			for (int i = 0; i < objArray.length; i++) {
				resultantArr[i] = (Float) objArray[i];
			}
			return resultantArr;
		}
		int nthKey(int n) {
			return n >= 0 && n < super.length() ? keyArray()[n] : 0;
		}
		float nthValue(int n) {
			return n >= 0 && n < super.length() ? array()[n] : 0;
		}
		float nthLastValue(int n) {
			return n > 0 && n <= super.length()
				   ? array()[super.length() - n]
				   : 0;
			// resolved bugfix: some changes helped avoid an index-out-of-bound
			// exception
		}
		float i(int n) {
			return nthValue(n);
		}
		float lasti(int n) {
			return nthLastValue(n);
		}
		float ilast(int n) {
			return nthLastValue(n);
		}
		float nth(int n) {
			return nthValue(n);
		}
		float nthlast(int n) {
			return nthLastValue(n);
		}
	}
	public static class Tree_D extends Tree<Integer, Double> {
		// public static final long serialVersionUID = 1L;
		Tree_D() {
			super();
		}
		Tree_D(int k1, double v1, int k2, double v2, int k3, double v3, int k4,
			   double v4, int k5, double v5, int k6, double v6, int k7, double v7,
			   int k8, double v8, int k9, double v9, int k10, double v10) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9, k10, v10);
		}
		Tree_D(int k1, double v1, int k2, double v2, int k3, double v3, int k4,
			   double v4, int k5, double v5, int k6, double v6, int k7, double v7,
			   int k8, double v8, int k9, double v9) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9);
		}
		Tree_D(int k1, double v1, int k2, double v2, int k3, double v3, int k4,
			   double v4, int k5, double v5, int k6, double v6, int k7, double v7,
			   int k8, double v8) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8);
		}
		Tree_D(int k1, double v1, int k2, double v2, int k3, double v3, int k4,
			   double v4, int k5, double v5, int k6, double v6, int k7, double v7) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7);
		}
		Tree_D(int k1, double v1, int k2, double v2, int k3, double v3, int k4,
			   double v4, int k5, double v5, int k6, double v6) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
		}
		Tree_D(int k1, double v1, int k2, double v2, int k3, double v3, int k4,
			   double v4, int k5, double v5) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
		}
		Tree_D(int k1, double v1, int k2, double v2, int k3, double v3, int k4,
			   double v4) {
			super(k1, v1, k2, v2, k3, v3, k4, v4);
		}
		Tree_D(int k1, double v1, int k2, double v2, int k3, double v3) {
			super(k1, v1, k2, v2, k3, v3);
		}
		Tree_D(int k1, double v1, int k2, double v2) {
			super(k1, v1, k2, v2);
		}
		Tree_D(int k1, double v1) {
			super(k1, v1);
		}
		Tree_D copy() {
			return (Tree_D) super.clone();
		}
		int[] keyArray() {
			Object[] objArray = super.keySet().toArray();
			int[] resultantArr = new int[objArray.length];
			for (int i = 0; i < objArray.length; i++) {
				resultantArr[i] = (Integer) objArray[i];
			}
			return resultantArr;
		}
		double[] array() {
			Object[] objArray = super.values().toArray();
			double[] resultantArr = new double[objArray.length];
			for (int i = 0; i < objArray.length; i++) {
				resultantArr[i] = (Double) objArray[i];
			}
			return resultantArr;
		}
		int nthKey(int n) {
			return n >= 0 && n < super.length() ? keyArray()[n] : 0;
		}
		double nthValue(int n) {
			return n >= 0 && n < super.length() ? array()[n] : 0;
		}
		double nthLastValue(int n) {
			return n > 0 && n <= super.length()
				   ? array()[super.length() - n]
				   : 0;
			// resolved bugfix: some changes helped avoid an index-out-of-bound
			// exception
		}
		double i(int n) {
			return nthValue(n);
		}
		double lasti(int n) {
			return nthLastValue(n);
		}
		double ilast(int n) {
			return nthLastValue(n);
		}
		double nth(int n) {
			return nthValue(n);
		}
		double nthlast(int n) {
			return nthLastValue(n);
		}
	}
	public static class Tree_B extends Tree<Integer, Boolean> {
		public static final long serialVersionUID = 1L;
		Tree_B() {
			super();
		}
		Tree_B(int k1, boolean v1, int k2, boolean v2, int k3, boolean v3, int k4,
			   boolean v4, int k5, boolean v5, int k6, boolean v6, int k7, boolean v7,
			   int k8, boolean v8, int k9, boolean v9, int k10, boolean v10) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9, k10, v10);
		}
		Tree_B(int k1, boolean v1, int k2, boolean v2, int k3, boolean v3, int k4,
			   boolean v4, int k5, boolean v5, int k6, boolean v6, int k7, boolean v7,
			   int k8, boolean v8, int k9, boolean v9) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9);
		}
		Tree_B(int k1, boolean v1, int k2, boolean v2, int k3, boolean v3, int k4,
			   boolean v4, int k5, boolean v5, int k6, boolean v6, int k7, boolean v7,
			   int k8, boolean v8) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8);
		}
		Tree_B(int k1, boolean v1, int k2, boolean v2, int k3, boolean v3, int k4,
			   boolean v4, int k5, boolean v5, int k6, boolean v6, int k7, boolean v7) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7);
		}
		Tree_B(int k1, boolean v1, int k2, boolean v2, int k3, boolean v3, int k4,
			   boolean v4, int k5, boolean v5, int k6, boolean v6) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
		}
		Tree_B(int k1, boolean v1, int k2, boolean v2, int k3, boolean v3, int k4,
			   boolean v4, int k5, boolean v5) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
		}
		Tree_B(int k1, boolean v1, int k2, boolean v2, int k3, boolean v3, int k4,
			   boolean v4) {
			super(k1, v1, k2, v2, k3, v3, k4, v4);
		}
		Tree_B(int k1, boolean v1, int k2, boolean v2, int k3, boolean v3) {
			super(k1, v1, k2, v2, k3, v3);
		}
		Tree_B(int k1, boolean v1, int k2, boolean v2) {
			super(k1, v1, k2, v2);
		}
		Tree_B(int k1, boolean v1) {
			super(k1, v1);
		}
		Tree_B copy() {
			return (Tree_B) super.clone();
		}
		int[] keyArray() {
			Object[] objArray = super.keySet().toArray();
			int[] resultantArr = new int[objArray.length];
			for (int i = 0; i < objArray.length; i++) {
				resultantArr[i] = (Integer) objArray[i];
			}
			return resultantArr;
		}
		boolean[] array() {
			Object[] objArray = super.values().toArray();
			boolean[] resultantArr = new boolean[objArray.length];
			for (int i = 0; i < objArray.length; i++) {
				resultantArr[i] = (Boolean) objArray[i];
			}
			return resultantArr;
		}
		int nthKey(int n) {
			return n >= 0 && n < super.length() ? keyArray()[n] : 0;
		}
		boolean nthValue(int n) {
			return n >= 0 && n < super.length() ? array()[n] : false;
		}
		boolean nthLastValue(int n) {
			return n > 0 && n <= super.length()
				   ? array()[super.length() - n]
				   : false;
			// resolved bugfix: some changes helped avoid an index-out-of-bound
			// exception
		}
		boolean i(int n) {
			return nthValue(n);
		}
		boolean lasti(int n) {
			return nthLastValue(n);
		}
		boolean ilast(int n) {
			return nthLastValue(n);
		}
		boolean nth(int n) {
			return nthValue(n);
		}
		boolean nthlast(int n) {
			return nthLastValue(n);
		}
	}
	public static final class StrArr extends ArrayList<String> {
		StrArr() {
			super();
		}
		StrArr(String... strings) {
			super();
			for (String s : strings)
				super.add(s);
		}
		StrArr pushAt(int i, String... strings) {
			if (i >= 0 && i <= super.size() && 0 != len(strings)) {
				for (String s : strings)
					super.add(i, s);
			}
			return this;
		}
		StrArr pushStart(String... strings) {
			if (0 != len(strings))
				pushAt(0, strings);
			return this;
		}
		StrArr push(String... strings) {
			if (0 != len(strings))
				pushAt(super.size(), strings);
			return this;
		}
		String shift() {
			if (super.isEmpty())
				return "";
			String removed = super.get(0);
			super.remove(0);
			return removed;
		}
		String pop(int... indexes) {
			if (super.isEmpty())
				return "";
			for (int i : indexes) {
				if (i >= 0 && i < length()) {
					super.remove(i);
					return super.get(i);
				}
			}
			return "";
		}
		String pop(String... strings) {
			if (super.isEmpty())
				return "";
			for (String s : strings) {
				if (has(s))
					super.remove(String.valueOf(s));
			}
			return strings[0];
		}
		StrArr popIf(Predicate<? super String> fn) {
			super.removeIf(fn);
			return this;
		}
		StrArr filterOut(Predicate<? super String> fn) {
			super.removeIf(fn);
			return this;
		}
		StrArr keepIf(Predicate<? super String> fn) {
			super.removeIf(fn.negate());
			return this;
		}
		StrArr filter(Predicate<? super String> fn) {
			super.removeIf(fn.negate());
			return this;
		}
		StrArr map(UnaryOperator<String> fn) {
			super.replaceAll(fn);
			return this;
		}
		StrArr unique() {
			Object obj = super.clone();
			Collection<?> collection = (Collection<?>) obj;
			Set<Object> set = new LinkedHashSet<>(collection);
			Set<String> uniqueSet = new LinkedHashSet<>();
			for (Object el : set)
				uniqueSet.add((String) el);
			super.clear();
			super.addAll(uniqueSet);
			return this;
		}
		boolean has(String x) {
			return super.contains(x);
		}
		String i(int i) {
			return i >= 0 && i < super.size() ? super.get(i) : "";
		}
		String lasti(int n) {
			return n > 0 && n <= super.size()
				   ? super.get(super.size() - n)
				   : "";
			// resolved bugfix: some changes helped avoid an index-out-of-bound
			// exception
		}
		String ilast(int n) {
			return lasti(n);
		}
		String nth(int n) {
			return i(n);
		}
		String nthlast(int n) {
			return lasti(n);
		}
		String first() {
			return nth(0);
		}
		String second() {
			return nth(1);
		}
		String seclast() {
			return nthlast(2);
		}
		String last() {
			return nthlast(1);
		}
		StrArr update(int i, String x) {
			if (!has(x))
				super.add(x);
			else {
				if (i < 0 || i > super.size())
					return this;
				super.set(i, x);
			}
			return this;
		}
		StrArr shuffle() {
			Object obj = super.clone();
			Collection<?> collection = (Collection<?>) obj;
			Set<Object> set = new LinkedHashSet<>(collection);
			Set<String> set2 = new LinkedHashSet<>();
			for (Object el : set)
				set2.add((String) el);
			ArrayList<String> list = new ArrayList<>(set2);
			Collections.shuffle(list, new Random(System.nanoTime()));
			super.clear();
			super.addAll(list);
			return this;
		}
		StrArr sort() {
			java.util.List newList = list();
			Collections.sort(newList, String.CASE_INSENSITIVE_ORDER);
			empty();
			super.addAll(newList);
			return this;
		}
		StrArr sort(String condition) {
			if (not(condition)) return this;
			if (condition.matches("^len(gth)?(:asc)?$")) {
				super.sort((s1, s2) -> len(s1) - len(s2));
			} else if (condition.matches("^len(gth)?:(desc|r(ev)?(ersed?)?)$")) {
				super.sort((s1, s2) -> len(s2) - len(s1));
			} else if (condition.matches("^(desc|r(ev)?(ersed?)?)$")) {
				sortReverse();
			} else {
				sort();
			}
			return this;
		}
		StrArr sortReverse() {
			java.util.List newList = list();
			Collections.sort(newList, String.CASE_INSENSITIVE_ORDER.reversed());
			empty();
			super.addAll(newList);
			return this;
		}
		StrArr reverseSort() {
			sortReverse();
			return this;
		}
		StrArr reverse() {
			java.util.List newList = list();
			Collections.reverse(newList);
			empty();
			super.addAll(newList);
			return this;
		}
		String[] array() {
			return super.toArray(new String[0]);
		}
		ArrayList<String> list() {
			ArrayList<String> result = new ArrayList<>();
			StrArr clone = copy();
			for (int i : range(clone))
				result.add(clone.i(i));
			return result;
		}
		String string() {
			return super.toString();
		}
		StrArr slice(int x, int y) {
			if (x < 0 || x >= length() || y <= 0 || y >= length())
				return copy();
			return (StrArr)(super.subList(x, y).toArray())[0];
		}
		StrArr empty() {
			super.clear();
			return this;
		}
		boolean eq(StrArr arrB) {
			StrArr arrA = copy();
			arrA.sort();
			arrB.sort();
			return arrA.equals(arrB);
		}
		boolean compare(StrArr arrB) {
			int len = intersection(arrB).length();
			return len > len / 2;
		}
		StrArr combine(StrArr arrB) {
			StrArr arrA = copy();
			ArrayList<String> combined = new ArrayList<>();
			combined.addAll(arrA);
			combined.addAll(arrB);
			empty();
			super.addAll(combined);
			return this;
		}
		StrArr union(StrArr arrB) {
			combine(arrB);
			return this;
		}
		StrArr intersection(StrArr arrB) {
			super.retainAll(arrB);
			return this;
		}
		StrArr negativeIntersection(StrArr arrB) {
			super.removeAll(arrB);
			return this;
		}
		StrArr copy() {
			return (StrArr) super.clone();
		}
		StrArr each(Consumer<? super String> fn) {
			super.forEach(fn);
			return this;
		}
		void printMap() {
			System.out.println(copy());
		}
		void printAll() {
			printMap();
		}
		int length() {
			return super.size();
		}
	}
	public static StrArr strArr(String... strings) {
		return new StrArr(strings);
	}
	public static StrArr StrArr(String... strings) {
		return new StrArr(strings);
	}
	public static final class IntArr extends ArrayList<Integer> {
		IntArr() {
			super();
		}
		IntArr(int... nums) {
			super();
			for (int n : nums)
				super.add(n);
		}
		IntArr pushAt(int i, int... ints) {
			if (i >= 0 && i <= super.size() && 0 != len(ints)) {
				for (int n : ints)
					super.add(i, n);
			}
			return this;
		}
		IntArr pushStart(int... ints) {
			if (0 != len(ints))
				pushAt(0, ints);
			return this;
		}
		IntArr push(int... ints) {
			if (0 != len(ints))
				pushAt(super.size(), ints);
			return this;
		}
		int shift() {
			if (super.isEmpty())
				return 0;
			int removed = super.get(0);
			super.remove(0);
			return removed;
		}
		int pop(int... ints) {
			if (super.isEmpty())
				return 0;
			for (int n : ints) {
				if (has(n))
					super.remove(Integer.valueOf(n));
			}
			return ints[0];
		}
		IntArr popIf(Predicate<? super Integer> fn) {
			super.removeIf(fn);
			return this;
		}
		IntArr filterOut(Predicate<? super Integer> fn) {
			super.removeIf(fn);
			return this;
		}
		IntArr keepIf(Predicate<? super Integer> fn) {
			super.removeIf(fn.negate());
			return this;
		}
		IntArr filter(Predicate<? super Integer> fn) {
			super.removeIf(fn.negate());
			return this;
		}
		IntArr map(UnaryOperator<Integer> fn) {
			super.replaceAll(fn);
			return this;
		}
		IntArr unique() {
			Object obj = super.clone();
			Collection<?> collection = (Collection<?>) obj;
			Set<Object> set = new LinkedHashSet<>(collection);
			Set<Integer> uniqueSet = new LinkedHashSet<>();
			for (Object el : set)
				uniqueSet.add((Integer) el);
			super.clear();
			super.addAll(uniqueSet);
			return this;
		}
		boolean has(int x) {
			return super.contains(x);
		}
		int i(int i) {
			return i >= 0 && i < super.size() ? super.get(i) : 0;
		}
		int lasti(int n) {
			return n > 0 && n <= super.size() ? super.get(super.size() - n) : 0;
			// resolved bugfix: some changes helped avoid an index-out-of-bound
			// exception
		}
		int ilast(int n) {
			return lasti(n);
		}
		int nth(int n) {
			return i(n);
		}
		int nthlast(int n) {
			return lasti(n);
		}
		int first() {
			return nth(0);
		}
		int second() {
			return nth(1);
		}
		int seclast() {
			return nthlast(2);
		}
		int last() {
			return nthlast(1);
		}
		IntArr update(int i, int x) {
			if (!has(x))
				super.add(x);
			else {
				if (i < 0 || i > super.size())
					return this;
				super.set(i, x);
			}
			return this;
		}
		IntArr shuffle() {
			Object obj = super.clone();
			Collection<?> collection = (Collection<?>) obj;
			Set<Object> set = new LinkedHashSet<>(collection);
			Set<Integer> set2 = new LinkedHashSet<>();
			for (Object el : set)
				set2.add((Integer) el);
			ArrayList<Integer> list = new ArrayList<>(set2);
			Collections.shuffle(list, new Random(System.nanoTime()));
			super.clear();
			super.addAll(list);
			return this;
		}
		IntArr sort() {
			super.sort(null);
			return this;
		}
		IntArr sort(String condition) {
			if (not(condition)) return this;
			if (condition.matches("^len(gth)?(:asc)?$")) {
				super.sort((s1, s2) -> len(s1) - len(s2));
			} else if (condition.matches("^len(gth)?:(desc|r(ev)?(ersed?)?)$")) {
				super.sort((s1, s2) -> len(s2) - len(s1));
			} else if (condition.matches("^(desc|r(ev)?(ersed?)?)$")) {
				sortReverse();
			} else {
				sort();
			}
			return this;
		}
		IntArr sortReverse() {
			super.sort(Collections.reverseOrder());
			return this;
		}
		IntArr reverseSort() {
			sortReverse();
			return this;
		}
		IntArr reverse() {
			java.util.List newList = list();
			Collections.reverse(newList);
			empty();
			super.addAll(newList);
			return this;
		}
		int[] array() {
			Integer[] partA = super.toArray(new Integer[0]);
			int[] resultantArr = new int[partA.length];
			for (int i = 0; i < partA.length; i++) {
				resultantArr[i] = partA[i];
			}
			return resultantArr;
		}
		ArrayList<Integer> list() {
			ArrayList<Integer> result = new ArrayList<>();
			IntArr clone = copy();
			for (int i : range(clone))
				result.add(clone.i(i));
			return result;
		}
		String string() {
			return super.toString();
		}
		IntArr slice(int x, int y) {
			if (x < 0 || x >= length() || y <= 0 || y >= length())
				return copy();
			return (IntArr)(super.subList(x, y).toArray())[0];
		}
		IntArr empty() {
			super.clear();
			return this;
		}
		boolean eq(IntArr arrB) {
			IntArr arrA = copy();
			arrA.sort();
			arrB.sort();
			return arrA.equals(arrB);
		}
		boolean compare(IntArr arrB) {
			int len = intersection(arrB).length();
			return len > len / 2;
		}
		IntArr combine(IntArr arrB) {
			IntArr arrA = copy();
			ArrayList<Integer> combined = new ArrayList<>();
			combined.addAll(arrA);
			combined.addAll(arrB);
			empty();
			super.addAll(combined);
			return this;
		}
		IntArr union(IntArr arrB) {
			combine(arrB);
			return this;
		}
		IntArr intersection(IntArr arrB) {
			super.retainAll(arrB);
			return this;
		}
		IntArr negativeIntersection(IntArr arrB) {
			super.removeAll(arrB);
			return this;
		}
		IntArr copy() {
			return (IntArr) super.clone();
		}
		IntArr each(Consumer<? super Integer> fn) {
			super.forEach(fn);
			return this;
		}
		void printMap() {
			System.out.println(copy());
		}
		void printAll() {
			printMap();
		}
		int length() {
			return super.size();
		}
	}
	public static IntArr intArr(int... ints) {
		return new IntArr(ints);
	}
	public static IntArr IntArr(int... ints) {
		return new IntArr(ints);
	}
	public static final class LongArr extends ArrayList<Long> {
		LongArr() {
			super();
		}
		LongArr(long... nums) {
			super();
			for (long n : nums)
				super.add(n);
		}
		LongArr pushAt(int i, long... longs) {
			if (i >= 0 && i <= super.size() && 0 != len(longs)) {
				for (long l : longs)
					super.add(i, l);
			}
			return this;
		}
		LongArr pushStart(long... longs) {
			if (0 != len(longs))
				pushAt(0, longs);
			return this;
		}
		LongArr push(long... longs) {
			if (0 != len(longs))
				pushAt(super.size(), longs);
			return this;
		}
		long shift() {
			if (super.isEmpty())
				return 0;
			long removed = super.get(0);
			super.remove(0);
			return removed;
		}
		long pop(int... indexes) {
			if (super.isEmpty())
				return 0;
			for (int i : indexes) {
				if (i >= 0 && i < length()) {
					super.remove(i);
					return super.get(i);
				}
			}
			return 0;
		}
		long pop(long... longs) {
			if (super.isEmpty())
				return 0;
			for (long l : longs) {
				if (has(l))
					super.remove(Long.valueOf(l));
			}
			return longs[0];
		}
		LongArr popIf(Predicate<? super Long> fn) {
			super.removeIf(fn);
			return this;
		}
		LongArr filterOut(Predicate<? super Long> fn) {
			super.removeIf(fn);
			return this;
		}
		LongArr keepIf(Predicate<? super Long> fn) {
			super.removeIf(fn.negate());
			return this;
		}
		LongArr filter(Predicate<? super Long> fn) {
			super.removeIf(fn.negate());
			return this;
		}
		LongArr map(UnaryOperator<Long> fn) {
			super.replaceAll(fn);
			return this;
		}
		LongArr unique() {
			Object obj = super.clone();
			Collection<?> collection = (Collection<?>) obj;
			Set<Object> set = new LinkedHashSet<>(collection);
			Set<Long> uniqueSet = new LinkedHashSet<>();
			for (Object el : set)
				uniqueSet.add((Long) el);
			super.clear();
			super.addAll(uniqueSet);
			return this;
		}
		boolean has(long x) {
			return super.contains(x);
		}
		long i(int i) {
			return i >= 0 && i < super.size() ? super.get(i) : 0;
		}
		long lasti(int n) {
			return n > 0 && n <= super.size() ? super.get(super.size() - n) : 0;
			// resolved bugfix: some changes helped avoid an index-out-of-bound
			// exception
		}
		long ilast(int n) {
			return lasti(n);
		}
		long nth(int n) {
			return i(n);
		}
		long nthlast(int n) {
			return lasti(n);
		}
		long first() {
			return nth(0);
		}
		long second() {
			return nth(1);
		}
		long seclast() {
			return nthlast(2);
		}
		long last() {
			return nthlast(1);
		}
		LongArr update(int i, long x) {
			if (!has(x))
				super.add(x);
			else {
				if (i < 0 || i > super.size())
					return this;
				super.set(i, x);
			}
			return this;
		}
		LongArr shuffle() {
			Object obj = super.clone();
			Collection<?> collection = (Collection<?>) obj;
			Set<Object> set = new LinkedHashSet<>(collection);
			Set<Long> set2 = new LinkedHashSet<>();
			for (Object el : set)
				set2.add((Long) el);
			ArrayList<Long> list = new ArrayList<>(set2);
			Collections.shuffle(list, new Random(System.nanoTime()));
			super.clear();
			super.addAll(list);
			return this;
		}
		LongArr sort() {
			super.sort(null);
			return this;
		}
		LongArr sort(String condition) {
			if (not(condition)) return this;
			if (condition.matches("^len(gth)?(:asc)?$")) {
				super.sort((s1, s2) -> len(s1) - len(s2));
			} else if (condition.matches("^len(gth)?:(desc|r(ev)?(ersed?)?)$")) {
				super.sort((s1, s2) -> len(s2) - len(s1));
			} else if (condition.matches("^(desc|r(ev)?(ersed?)?)$")) {
				sortReverse();
			} else {
				sort();
			}
			return this;
		}
		LongArr sortReverse() {
			super.sort(Collections.reverseOrder());
			return this;
		}
		LongArr reverseSort() {
			sortReverse();
			return this;
		}
		LongArr reverse() {
			java.util.List newList = list();
			Collections.reverse(newList);
			empty();
			super.addAll(newList);
			return this;
		}
		long[] array() {
			Long[] partA = super.toArray(new Long[0]);
			long[] resultantArr = new long[partA.length];
			for (int i = 0; i < partA.length; i++) {
				resultantArr[i] = partA[i];
			}
			return resultantArr;
		}
		ArrayList<Long> list() {
			ArrayList<Long> result = new ArrayList<>();
			LongArr clone = copy();
			for (int i : range(clone))
				result.add(clone.i(i));
			return result;
		}
		String string() {
			return super.toString();
		}
		LongArr slice(int x, int y) {
			if (x < 0 || x >= length() || y <= 0 || y >= length())
				return copy();
			return (LongArr)(super.subList(x, y).toArray())[0];
		}
		LongArr empty() {
			super.clear();
			return this;
		}
		boolean eq(LongArr arrB) {
			LongArr arrA = copy();
			arrA.sort();
			arrB.sort();
			return arrA.equals(arrB);
		}
		boolean compare(LongArr arrB) {
			int len = intersection(arrB).length();
			return len > len / 2;
		}
		LongArr combine(LongArr arrB) {
			LongArr arrA = copy();
			ArrayList<Long> combined = new ArrayList<>();
			combined.addAll(arrA);
			combined.addAll(arrB);
			empty();
			super.addAll(combined);
			return this;
		}
		LongArr union(LongArr arrB) {
			combine(arrB);
			return this;
		}
		LongArr intersection(LongArr arrB) {
			super.retainAll(arrB);
			return this;
		}
		LongArr negativeIntersection(LongArr arrB) {
			super.removeAll(arrB);
			return this;
		}
		LongArr copy() {
			return (LongArr) super.clone();
		}
		LongArr each(Consumer<? super Long> fn) {
			super.forEach(fn);
			return this;
		}
		void printMap() {
			System.out.println(copy());
		}
		void printAll() {
			printMap();
		}
		int length() {
			return super.size();
		}
	}
	public static LongArr longArr(long... longs) {
		return new LongArr(longs);
	}
	public static LongArr LongArr(long... longs) {
		return new LongArr(longs);
	}
	public static final class FltArr extends ArrayList<Float> {
		FltArr() {
			super();
		}
		FltArr(float... nums) {
			super();
			for (float n : nums)
				super.add(n);
		}
		FltArr pushAt(int i, float... floats) {
			if (i >= 0 && i <= super.size() && 0 != len(floats)) {
				for (float f : floats)
					super.add(i, f);
			}
			return this;
		}
		FltArr pushStart(float... floats) {
			if (0 != len(floats))
				pushAt(0, floats);
			return this;
		}
		FltArr push(float... floats) {
			if (0 != len(floats))
				pushAt(super.size(), floats);
			return this;
		}
		float shift() {
			if (super.isEmpty())
				return 0;
			float removed = super.get(0);
			super.remove(0);
			return removed;
		}
		float pop(int... indexes) {
			if (super.isEmpty())
				return 0;
			for (int i : indexes) {
				if (i >= 0 && i < length()) {
					super.remove(i);
					return super.get(i);
				}
			}
			return 0;
		}
		float pop(float... floats) {
			if (super.isEmpty())
				return 0;
			for (float f : floats) {
				if (has(f))
					super.remove(Float.valueOf(f));
			}
			return floats[0];
		}
		FltArr popIf(Predicate<? super Float> fn) {
			super.removeIf(fn);
			return this;
		}
		FltArr filterOut(Predicate<? super Float> fn) {
			super.removeIf(fn);
			return this;
		}
		FltArr keepIf(Predicate<? super Float> fn) {
			super.removeIf(fn.negate());
			return this;
		}
		FltArr filter(Predicate<? super Float> fn) {
			super.removeIf(fn.negate());
			return this;
		}
		FltArr map(UnaryOperator<Float> fn) {
			super.replaceAll(fn);
			return this;
		}
		FltArr unique() {
			Object obj = super.clone();
			Collection<?> collection = (Collection<?>) obj;
			Set<Object> set = new LinkedHashSet<>(collection);
			Set<Float> uniqueSet = new LinkedHashSet<>();
			for (Object el : set)
				uniqueSet.add((Float) el);
			super.clear();
			super.addAll(uniqueSet);
			return this;
		}
		boolean has(float x) {
			return super.contains(x);
		}
		float i(int i) {
			return i >= 0 && i < super.size() ? super.get(i) : 0;
		}
		float lasti(int n) {
			return n > 0 && n <= super.size() ? super.get(super.size() - n) : 0;
			// resolved bugfix: some changes helped avoid an index-out-of-bound
			// exception
		}
		float ilast(int n) {
			return lasti(n);
		}
		float nth(int n) {
			return i(n);
		}
		float nthlast(int n) {
			return lasti(n);
		}
		float first() {
			return nth(0);
		}
		float second() {
			return nth(1);
		}
		float seclast() {
			return nthlast(2);
		}
		float last() {
			return nthlast(1);
		}
		FltArr update(int i, float x) {
			if (!has(x))
				super.add(x);
			else {
				if (i < 0 || i > super.size())
					return this;
				super.set(i, x);
			}
			return this;
		}
		FltArr shuffle() {
			Object obj = super.clone();
			Collection<?> collection = (Collection<?>) obj;
			Set<Object> set = new LinkedHashSet<>(collection);
			Set<Float> set2 = new LinkedHashSet<>();
			for (Object el : set)
				set2.add((Float) el);
			ArrayList<Float> list = new ArrayList<>(set2);
			Collections.shuffle(list, new Random(System.nanoTime()));
			super.clear();
			super.addAll(list);
			return this;
		}
		FltArr sort() {
			super.sort(null);
			return this;
		}
		FltArr sort(String condition) {
			if (not(condition)) return this;
			if (condition.matches("^(desc|r(ev)?(ersed?)?)$")) {
				sortReverse();
			} else {
				sort();
			}
			return this;
		}
		FltArr sortReverse() {
			super.sort(Collections.reverseOrder());
			return this;
		}
		FltArr reverseSort() {
			sortReverse();
			return this;
		}
		FltArr reverse() {
			java.util.List newList = list();
			Collections.reverse(newList);
			empty();
			super.addAll(newList);
			return this;
		}
		float[] array() {
			Float[] partA = super.toArray(new Float[0]);
			float[] resultantArr = new float[partA.length];
			for (int i = 0; i < partA.length; i++) {
				resultantArr[i] = partA[i];
			}
			return resultantArr;
		}
		ArrayList<Float> list() {
			ArrayList<Float> result = new ArrayList<>();
			FltArr clone = copy();
			for (int i : range(clone))
				result.add(clone.i(i));
			return result;
		}
		String string() {
			return super.toString();
		}
		FltArr slice(int x, int y) {
			if (x < 0 || x >= length() || y <= 0 || y >= length())
				return copy();
			return (FltArr)(super.subList(x, y).toArray())[0];
		}
		FltArr empty() {
			super.clear();
			return this;
		}
		boolean eq(FltArr arrB) {
			FltArr arrA = copy();
			arrA.sort();
			arrB.sort();
			return arrA.equals(arrB);
		}
		boolean compare(FltArr arrB) {
			int len = intersection(arrB).length();
			return len > len / 2;
		}
		FltArr combine(FltArr arrB) {
			FltArr arrA = copy();
			ArrayList<Float> combined = new ArrayList<>();
			combined.addAll(arrA);
			combined.addAll(arrB);
			empty();
			super.addAll(combined);
			return this;
		}
		FltArr union(FltArr arrB) {
			combine(arrB);
			return this;
		}
		FltArr intersection(FltArr arrB) {
			super.retainAll(arrB);
			return this;
		}
		FltArr negativeIntersection(FltArr arrB) {
			super.removeAll(arrB);
			return this;
		}
		FltArr copy() {
			return (FltArr) super.clone();
		}
		FltArr each(Consumer<? super Float> fn) {
			super.forEach(fn);
			return this;
		}
		void printMap() {
			System.out.println(copy());
		}
		void printAll() {
			printMap();
		}
		int length() {
			return super.size();
		}
	}
	public static FltArr fltArr(float... floats) {
		return new FltArr(floats);
	}
	public static FltArr FltArr(float... floats) {
		return new FltArr(floats);
	}
	public static final class DblArr extends ArrayList<Double> {
		DblArr() {
			super();
		}
		DblArr(double... doubles) {
			super();
			for (double d : doubles)
				super.add(d);
		}
		DblArr pushAt(int i, double... doubles) {
			if (i >= 0 && i <= super.size() && 0 != len(doubles)) {
				for (double d : doubles)
					super.add(i, d);
			}
			return this;
		}
		DblArr pushStart(double... doubles) {
			if (0 != len(doubles))
				pushAt(0, doubles);
			return this;
		}
		DblArr push(double... doubles) {
			if (0 != len(doubles))
				pushAt(super.size(), doubles);
			return this;
		}
		double shift() {
			if (super.isEmpty())
				return 0;
			double removed = super.get(0);
			super.remove(0);
			return removed;
		}
		double pop(int... indexes) {
			if (super.isEmpty())
				return 0;
			for (int i : indexes) {
				if (i >= 0 && i < length()) {
					super.remove(i);
					return super.get(i);
				}
			}
			return 0;
		}
		double pop(double... doubles) {
			if (super.isEmpty())
				return 0;
			for (double d : doubles) {
				if (has(d))
					super.remove(Double.valueOf(d));
			}
			return doubles[0];
		}
		DblArr popIf(Predicate<? super Double> fn) {
			super.removeIf(fn);
			return this;
		}
		DblArr filterOut(Predicate<? super Double> fn) {
			super.removeIf(fn);
			return this;
		}
		DblArr keepIf(Predicate<? super Double> fn) {
			super.removeIf(fn.negate());
			return this;
		}
		DblArr filter(Predicate<? super Double> fn) {
			super.removeIf(fn.negate());
			return this;
		}
		DblArr map(UnaryOperator<Double> fn) {
			super.replaceAll(fn);
			return this;
		}
		DblArr unique() {
			Object obj = super.clone();
			Collection<?> collection = (Collection<?>) obj;
			Set<Object> set = new LinkedHashSet<>(collection);
			Set<Double> uniqueSet = new LinkedHashSet<>();
			for (Object el : set)
				uniqueSet.add((Double) el);
			super.clear();
			super.addAll(uniqueSet);
			return this;
		}
		boolean has(double x) {
			return super.contains(x);
		}
		double i(int i) {
			return i >= 0 && i < super.size() ? super.get(i) : 0;
		}
		double lasti(int n) {
			return n > 0 && n <= super.size() ? super.get(super.size() - n) : 0;
			// resolved bugfix: some changes helped avoid an index-out-of-bound
			// exception
		}
		double ilast(int n) {
			return lasti(n);
		}
		double nth(int n) {
			return i(n);
		}
		double nthlast(int n) {
			return lasti(n);
		}
		double first() {
			return nth(0);
		}
		double second() {
			return nth(1);
		}
		double seclast() {
			return nthlast(2);
		}
		double last() {
			return nthlast(1);
		}
		DblArr update(int i, double x) {
			if (!has(x))
				super.add(x);
			else {
				if (i < 0 || i > super.size())
					return this;
				super.set(i, x);
			}
			return this;
		}
		DblArr shuffle() {
			Object obj = super.clone();
			Collection<?> collection = (Collection<?>) obj;
			Set<Object> set = new LinkedHashSet<>(collection);
			Set<Double> set2 = new LinkedHashSet<>();
			for (Object el : set)
				set2.add((Double) el);
			ArrayList<Double> list = new ArrayList<>(set2);
			Collections.shuffle(list, new Random(System.nanoTime()));
			super.clear();
			super.addAll(list);
			return this;
		}
		DblArr sort() {
			super.sort(null);
			return this;
		}
		DblArr sort(String condition) {
			if (not(condition)) return this;
			if (condition.matches("^(desc|r(ev)?(ersed?)?)$")) {
				sortReverse();
			} else {
				sort();
			}
			return this;
		}
		DblArr sortReverse() {
			super.sort(Collections.reverseOrder());
			return this;
		}
		DblArr reverseSort() {
			sortReverse();
			return this;
		}
		DblArr reverse() {
			java.util.List newList = list();
			Collections.reverse(newList);
			empty();
			super.addAll(newList);
			return this;
		}
		double[] array() {
			Double[] partA = super.toArray(new Double[0]);
			double[] resultantArr = new double[partA.length];
			for (int i = 0; i < partA.length; i++) {
				resultantArr[i] = partA[i];
			}
			return resultantArr;
		}
		ArrayList<Double> list() {
			ArrayList<Double> result = new ArrayList<>();
			DblArr clone = copy();
			for (int i : range(clone))
				result.add(clone.i(i));
			return result;
		}
		String string() {
			return super.toString();
		}
		DblArr slice(int x, int y) {
			if (x < 0 || x >= length() || y <= 0 || y >= length())
				return copy();
			return (DblArr)(super.subList(x, y).toArray())[0];
		}
		DblArr empty() {
			super.clear();
			return this;
		}
		boolean eq(DblArr arrB) {
			DblArr arrA = copy();
			arrA.sort();
			arrB.sort();
			return arrA.equals(arrB);
		}
		boolean compare(DblArr arrB) {
			int len = intersection(arrB).length();
			return len > len / 2;
		}
		DblArr combine(DblArr arrB) {
			DblArr arrA = copy();
			ArrayList<Double> combined = new ArrayList<>();
			combined.addAll(arrA);
			combined.addAll(arrB);
			empty();
			super.addAll(combined);
			return this;
		}
		DblArr union(DblArr arrB) {
			combine(arrB);
			return this;
		}
		DblArr intersection(DblArr arrB) {
			super.retainAll(arrB);
			return this;
		}
		DblArr negativeIntersection(DblArr arrB) {
			super.removeAll(arrB);
			return this;
		}
		DblArr copy() {
			return (DblArr) super.clone();
		}
		DblArr each(Consumer<? super Double> fn) {
			super.forEach(fn);
			return this;
		}
		void printMap() {
			System.out.println(copy());
		}
		void printAll() {
			printMap();
		}
		int length() {
			return super.size();
		}
	}
	public static DblArr dblArr(double...doubles) {
		return new DblArr(doubles);
	}
	public static DblArr DblArr(double...doubles) {
		return new DblArr(doubles);
	}
	public static final class BoolArr extends ArrayList<Boolean> {
		BoolArr() {
			super();
		}
		BoolArr(boolean... bools) {
			super();
			for (boolean b : bools)
				super.add(b);
		}
		BoolArr pushAt(int i, boolean... bools) {
			if (i >= 0 && i <= super.size() && 0 != len(bools)) {
				for (boolean b : bools)
					super.add(i, b);
			}
			return this;
		}
		BoolArr pushStart(boolean... bools) {
			if (0 != len(bools))
				pushAt(0, bools);
			return this;
		}
		BoolArr push(boolean... bools) {
			if (0 != len(bools))
				pushAt(super.size(), bools);
			return this;
		}
		boolean shift() {
			if (super.isEmpty())
				return false;
			boolean removed = super.get(0);
			super.remove(0);
			return removed;
		}
		boolean pop(int... indexes) {
			if (super.isEmpty())
				return false;
			for (int i : indexes) {
				if (i >= 0 && i < length()) {
					super.remove(i);
					return super.get(i);
				}
			}
			return false;
		}
		boolean pop(boolean... bools) {
			if (super.isEmpty())
				return false;
			for (boolean b : bools) {
				if (has(b))
					super.remove(Boolean.valueOf(b));
			}
			return bools[0];
		}
		BoolArr popIf(Predicate<? super Boolean> fn) {
			super.removeIf(fn);
			return this;
		}
		BoolArr filterOut(Predicate<? super Boolean> fn) {
			super.removeIf(fn);
			return this;
		}
		BoolArr keepIf(Predicate<? super Boolean> fn) {
			super.removeIf(fn.negate());
			return this;
		}
		BoolArr filter(Predicate<? super Boolean> fn) {
			super.removeIf(fn.negate());
			return this;
		}
		BoolArr map(UnaryOperator<Boolean> fn) {
			super.replaceAll(fn);
			return this;
		}
		BoolArr unique() {
			Object obj = super.clone();
			Collection<?> collection = (Collection<?>) obj;
			Set<Object> set = new LinkedHashSet<>(collection);
			Set<Boolean> uniqueSet = new LinkedHashSet<>();
			for (Object el : set)
				uniqueSet.add((Boolean) el);
			super.clear();
			super.addAll(uniqueSet);
			return this;
		}
		boolean has(boolean x) {
			return super.contains(x);
		}
		boolean i(int i) {
			return i >= 0 && i < super.size() ? super.get(i) : false;
		}
		boolean lasti(int n) {
			return n > 0 && n <= super.size()
				   ? super.get(super.size() - n)
				   : false;
			// resolved bugfix: some changes helped avoid an index-out-of-bound
			// exception
		}
		boolean ilast(int n) {
			return lasti(n);
		}
		boolean nth(int n) {
			return i(n);
		}
		boolean nthlast(int n) {
			return lasti(n);
		}
		boolean first() {
			return nth(0);
		}
		boolean second() {
			return nth(1);
		}
		boolean seclast() {
			return nthlast(2);
		}
		boolean last() {
			return nthlast(1);
		}
		BoolArr update(int i, boolean x) {
			if (!has(x))
				super.add(x);
			else {
				if (i < 0 || i > super.size())
					return this;
				super.set(i, x);
			}
			return this;
		}
		BoolArr shuffle() {
			Object obj = super.clone();
			Collection<?> collection = (Collection<?>) obj;
			Set<Object> set = new LinkedHashSet<>(collection);
			Set<Boolean> set2 = new LinkedHashSet<>();
			for (Object el : set)
				set2.add((Boolean) el);
			ArrayList<Boolean> list = new ArrayList<>(set2);
			Collections.shuffle(list, new Random(System.nanoTime()));
			super.clear();
			super.addAll(list);
			return this;
		}
		BoolArr sort() {
			super.sort(null);
			return this;
		}
		BoolArr sort(String condition) {
			if (not(condition)) return this;
			if (condition.matches("^(desc|r(ev)?(ersed?)?)$")) {
				sortReverse();
			} else {
				sort();
			}
			return this;
		}
		BoolArr sortReverse() {
			super.sort(Collections.reverseOrder());
			return this;
		}
		BoolArr reverseSort() {
			sortReverse();
			return this;
		}
		BoolArr reverse() {
			java.util.List newList = list();
			Collections.reverse(newList);
			empty();
			super.addAll(newList);
			return this;
		}
		boolean[] array() {
			Boolean[] partA = super.toArray(new Boolean[0]);
			boolean[] resultantArr = new boolean[partA.length];
			for (int i = 0; i < partA.length; i++) {
				resultantArr[i] = partA[i];
			}
			return resultantArr;
		}
		ArrayList<Boolean> list() {
			ArrayList<Boolean> result = new ArrayList<>();
			BoolArr clone = copy();
			for (int i : range(clone))
				result.add(clone.i(i));
			return result;
		}
		String string() {
			return super.toString();
		}
		BoolArr slice(int x, int y) {
			if (x < 0 || x >= length() || y <= 0 || y >= length())
				return copy();
			return (BoolArr)(super.subList(x, y).toArray())[0];
		}
		BoolArr empty() {
			super.clear();
			return this;
		}
		boolean eq(BoolArr arrB) {
			BoolArr arrA = copy();
			arrA.sort();
			arrB.sort();
			return arrA.equals(arrB);
		}
		boolean compare(BoolArr arrB) {
			int len = intersection(arrB).length();
			return len > len / 2;
		}
		BoolArr combine(BoolArr arrB) {
			BoolArr arrA = copy();
			ArrayList<Boolean> combined = new ArrayList<>();
			combined.addAll(arrA);
			combined.addAll(arrB);
			empty();
			super.addAll(combined);
			return this;
		}
		BoolArr union(BoolArr arrB) {
			combine(arrB);
			return this;
		}
		BoolArr intersection(BoolArr arrB) {
			super.retainAll(arrB);
			return this;
		}
		BoolArr negativeIntersection(BoolArr arrB) {
			super.removeAll(arrB);
			return this;
		}
		BoolArr copy() {
			return (BoolArr) super.clone();
		}
		BoolArr each(Consumer<? super Boolean> fn) {
			super.forEach(fn);
			return this;
		}
		void printMap() {
			System.out.println(copy());
		}
		void printAll() {
			printMap();
		}
		int length() {
			return super.size();
		}
	}
	public static BoolArr boolArr(boolean...bools) {
		return new BoolArr(bools);
	}
	public static BoolArr BoolArr(boolean...bools) {
		return new BoolArr(bools);
	}
	public static boolean runTask(Runnable fn) {
		if (not(fn))
			return false;
		new Thread(fn).run();
		return true;
	}
	public static void setTimeout(Runnable fn, int delay) {
		new Thread(() -> {
			try {
				Thread.sleep(delay < 1000 ? delay * 1000 : delay);
			} catch (InterruptedException e) {
				print("The timeout was interrupted by a background task.");
			}
			SwingUtilities.invokeLater(fn);
		}).start();
	}
	public static void delay(Runnable fn, int delay) {
		setTimeout(fn, delay);
	}
	public static boolean sw(Object src, Object cond1, Runnable sol1,
							 Object cond2, Runnable sol2, Object cond3, Runnable sol3,
							 Object cond4, Runnable sol4, Object cond5, Runnable sol5,
							 Object cond6, Runnable sol6, Object cond7, Runnable sol7,
							 Object cond8, Runnable sol8, Object cond9, Runnable sol9,
							 Object cond10, Runnable sol10) {
		if (src instanceof Number || src instanceof Character) {
			double srcDbl = src instanceof Character ? (char)src : Dbl(Str(src));
			if (cond1 instanceof String) {
				if (!in(Str(cond1), "(?<=[<>=])\\-?\\d")) {
					print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
					return false;
				}
				double middleware = Dbl(Str(cond1).replaceAll("[^\\-\\d\\.]", ""));
				cond1 = String(cond1).replaceAll("[^<>=]", "");
				if (eq(cond1, ">")) {
					if (srcDbl > middleware) {
						if (!isNull(sol1))
							new Thread(sol1).run();
						return true;
					}
				} else if (eq(cond1, ">=")) {
					if (srcDbl >= middleware) {
						if (!isNull(sol1))
							new Thread(sol1).run();
						return true;
					}
				} else if (eq(cond1, "<")) {
					if (srcDbl < middleware) {
						if (!isNull(sol1))
							new Thread(sol1).run();
						return true;
					}
				} else if (eq(cond1, "<=")) {
					if (srcDbl <= middleware) {
						if (!isNull(sol1))
							new Thread(sol1).run();
						return true;
					}
				} else if (eq(cond1, "==")) {
					if (srcDbl == middleware) {
						if (!isNull(sol1))
							new Thread(sol1).run();
						return true;
					}
				}
			} else if (cond1 instanceof Number) {
				if (eq(srcDbl, Dbl(Str(cond1)))) {
					if (!isNull(sol1))
						new Thread(sol1).run();
					return true;
				}
			} else if (cond1 instanceof Character) {
				if (eq((char)src, (char)cond1)) {
					if (!isNull(sol1))
						new Thread(sol1).run();
					return true;
				}
			} else if (isNull(cond1)) {
				// NEEDED TO HANDLE NULL CASES: do nothing in this scenario
			} else {
				print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
				return false;
			}
			if (cond2 instanceof String) {
				if (!in(Str(cond2), "(?<=[<>=])\\-?\\d|else")) {
					print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
					return false;
				}
				double middleware2 = Dbl(
										 String(cond2).replaceAll("[^\\-\\d\\.]", ""));
				cond2 = String(cond2).replaceAll("[^<>=else]", "");
				if (eq(cond2, ">")) {
					if (srcDbl > middleware2) {
						if (!isNull(sol2))
							new Thread(sol2).run();
						return true;
					}
				} else if (eq(cond2, ">=")) {
					if (srcDbl >= middleware2) {
						if (!isNull(sol2))
							new Thread(sol2).run();
						return true;
					}
				} else if (eq(cond2, "<")) {
					if (srcDbl < middleware2) {
						if (!isNull(sol2))
							new Thread(sol2).run();
						return true;
					}
				} else if (eq(cond2, "<=")) {
					if (srcDbl <= middleware2) {
						if (!isNull(sol2))
							new Thread(sol2).run();
						return true;
					}
				} else if (eq(cond2, "==")) {
					if (srcDbl == middleware2) {
						if (!isNull(sol2))
							new Thread(sol2).run();
						return true;
					}
				} else if (eq(cond2, "else")) {
					if (!isNull(sol2))
						new Thread(sol2).run();
					return false;
				}
			} else if (cond2 instanceof Number) {
				if (eq(srcDbl, Dbl(Str(cond2)))) {
					if (!isNull(sol2))
						new Thread(sol2).run();
					return true;
				}
			} else if (cond2 instanceof Character) {
				if (eq((char)src, (char)cond2)) {
					if (!isNull(sol2))
						new Thread(sol2).run();
					return true;
				}
			} else if (isNull(cond2)) {
				// NEEDED TO HANDLE NULL CASES: do nothing in this scenario
			} else {
				print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
				return false;
			}
			if (cond3 instanceof String) {
				if (!in(Str(cond3), "(?<=[<>=])\\-?\\d|else")) {
					print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
					return false;
				}
				double middleware3 = Dbl(
										 String(cond3).replaceAll("[^\\-\\d\\.]", ""));
				cond3 = String(cond3).replaceAll("[^<>=else]", "");
				if (eq(cond3, ">")) {
					if (srcDbl > middleware3) {
						if (!isNull(sol3))
							new Thread(sol3).run();
						return true;
					}
				} else if (eq(cond3, ">=")) {
					if (srcDbl >= middleware3) {
						if (!isNull(sol3))
							new Thread(sol3).run();
						return true;
					}
				} else if (eq(cond3, "<")) {
					if (srcDbl < middleware3) {
						if (!isNull(sol3))
							new Thread(sol3).run();
						return true;
					}
				} else if (eq(cond3, "<=")) {
					if (srcDbl <= middleware3) {
						if (!isNull(sol3))
							new Thread(sol3).run();
						return true;
					}
				} else if (eq(cond3, "==")) {
					if (srcDbl == middleware3) {
						if (!isNull(sol3))
							new Thread(sol3).run();
						return true;
					}
				} else if (eq(cond3, "else")) {
					if (!isNull(sol3))
						new Thread(sol3).run();
					return false;
				}
			} else if (cond3 instanceof Number) {
				if (eq(srcDbl, Dbl(Str(cond3)))) {
					if (!isNull(sol3))
						new Thread(sol3).run();
					return true;
				}
			} else if (cond3 instanceof Character) {
				if (eq((char)src, (char)cond3)) {
					if (!isNull(sol3))
						new Thread(sol3).run();
					return true;
				}
			} else if (isNull(cond3)) {
				// NEEDED TO HANDLE NULL CASES: do nothing in this scenario
			} else {
				print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
				return false;
			}
			if (cond4 instanceof String) {
				if (!in(Str(cond4), "(?<=[<>=])\\-?\\d|else")) {
					print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
					return false;
				}
				double middleware4 = Dbl(
										 String(cond4).replaceAll("[^\\-\\d\\.]", ""));
				cond4 = String(cond4).replaceAll("[^<>=else]", "");
				if (eq(cond4, ">")) {
					if (srcDbl > middleware4) {
						if (!isNull(sol4))
							new Thread(sol4).run();
						return true;
					}
				} else if (eq(cond4, ">=")) {
					if (srcDbl >= middleware4) {
						if (!isNull(sol4))
							new Thread(sol4).run();
						return true;
					}
				} else if (eq(cond4, "<")) {
					if (srcDbl < middleware4) {
						if (!isNull(sol4))
							new Thread(sol4).run();
						return true;
					}
				} else if (eq(cond4, "<=")) {
					if (srcDbl <= middleware4) {
						if (!isNull(sol4))
							new Thread(sol4).run();
						return true;
					}
				} else if (eq(cond4, "==")) {
					if (srcDbl == middleware4) {
						if (!isNull(sol4))
							new Thread(sol4).run();
						return true;
					}
				} else if (eq(cond4, "else")) {
					if (!isNull(sol4))
						new Thread(sol4).run();
					return false;
				}
			} else if (cond4 instanceof Number) {
				if (eq(srcDbl, Dbl(Str(cond4)))) {
					if (!isNull(sol4))
						new Thread(sol4).run();
					return true;
				}
			} else if (cond4 instanceof Character) {
				if (eq((char)src, (char)cond4)) {
					if (!isNull(sol4))
						new Thread(sol4).run();
					return true;
				}
			} else if (isNull(cond4)) {
				// NEEDED TO HANDLE NULL CASES: do nothing in this scenario
			} else {
				print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
				return false;
			}
			if (cond5 instanceof String) {
				if (!in(Str(cond5), "(?<=[<>=])\\-?\\d|else")) {
					print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
					return false;
				}
				double middleware5 = Dbl(
										 String(cond5).replaceAll("[^\\-\\d\\.]", ""));
				cond5 = String(cond5).replaceAll("[^<>=else]", "");
				if (eq(cond5, ">")) {
					if (srcDbl > middleware5) {
						if (!isNull(sol5))
							new Thread(sol5).run();
						return true;
					}
				} else if (eq(cond5, ">=")) {
					if (srcDbl >= middleware5) {
						if (!isNull(sol5))
							new Thread(sol5).run();
						return true;
					}
				} else if (eq(cond5, "<")) {
					if (srcDbl < middleware5) {
						if (!isNull(sol5))
							new Thread(sol5).run();
						return true;
					}
				} else if (eq(cond5, "<=")) {
					if (srcDbl <= middleware5) {
						if (!isNull(sol5))
							new Thread(sol5).run();
						return true;
					}
				} else if (eq(cond5, "==")) {
					if (srcDbl == middleware5) {
						if (!isNull(sol5))
							new Thread(sol5).run();
						return true;
					}
				} else if (eq(cond5, "else")) {
					if (!isNull(sol5))
						new Thread(sol5).run();
					return false;
				}
			} else if (cond5 instanceof Number) {
				if (eq(srcDbl, Dbl(Str(cond5)))) {
					if (!isNull(sol5))
						new Thread(sol5).run();
					return true;
				}
			} else if (cond5 instanceof Character) {
				if (eq((char)src, (char)cond5)) {
					if (!isNull(sol5))
						new Thread(sol5).run();
					return true;
				}
			} else if (isNull(cond5)) {
				// NEEDED TO HANDLE NULL CASES: do nothing in this scenario
			} else {
				print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
				return false;
			}
			if (cond6 instanceof String) {
				if (!in(Str(cond6), "(?<=[<>=])\\-?\\d|else")) {
					print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
					return false;
				}
				double middleware6 = Dbl(
										 String(cond6).replaceAll("[^\\-\\d\\.]", ""));
				cond6 = String(cond6).replaceAll("[^<>=else]", "");
				if (eq(cond6, ">")) {
					if (srcDbl > middleware6) {
						if (!isNull(sol6))
							new Thread(sol6).run();
						return true;
					}
				} else if (eq(cond6, ">=")) {
					if (srcDbl >= middleware6) {
						if (!isNull(sol6))
							new Thread(sol6).run();
						return true;
					}
				} else if (eq(cond6, "<")) {
					if (srcDbl < middleware6) {
						if (!isNull(sol6))
							new Thread(sol6).run();
						return true;
					}
				} else if (eq(cond6, "<=")) {
					if (srcDbl <= middleware6) {
						if (!isNull(sol6))
							new Thread(sol6).run();
						return true;
					}
				} else if (eq(cond6, "==")) {
					if (srcDbl == middleware6) {
						if (!isNull(sol6))
							new Thread(sol6).run();
						return true;
					}
				} else if (eq(cond6, "else")) {
					if (!isNull(sol6))
						new Thread(sol6).run();
					return false;
				}
			} else if (cond6 instanceof Number) {
				if (eq(srcDbl, Dbl(Str(cond6)))) {
					if (!isNull(sol6))
						new Thread(sol6).run();
					return true;
				}
			} else if (cond6 instanceof Character) {
				if (eq((char)src, (char)cond6)) {
					if (!isNull(sol6))
						new Thread(sol6).run();
					return true;
				}
			} else if (isNull(cond6)) {
				// NEEDED TO HANDLE NULL CASES: do nothing in this scenario
			} else {
				print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
				return false;
			}
			if (cond7 instanceof String) {
				if (!in(Str(cond7), "(?<=[<>=])\\-?\\d|else")) {
					print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
					return false;
				}
				double middleware7 = Dbl(
										 String(cond7).replaceAll("[^\\-\\d\\.]", ""));
				cond7 = String(cond7).replaceAll("[^<>=else]", "");
				if (eq(cond7, ">")) {
					if (srcDbl > middleware7) {
						if (!isNull(sol7))
							new Thread(sol7).run();
						return true;
					}
				} else if (eq(cond7, ">=")) {
					if (srcDbl >= middleware7) {
						if (!isNull(sol7))
							new Thread(sol7).run();
						return true;
					}
				} else if (eq(cond7, "<")) {
					if (srcDbl < middleware7) {
						if (!isNull(sol7))
							new Thread(sol7).run();
						return true;
					}
				} else if (eq(cond7, "<=")) {
					if (srcDbl <= middleware7) {
						if (!isNull(sol7))
							new Thread(sol7).run();
						return true;
					}
				} else if (eq(cond7, "==")) {
					if (srcDbl == middleware7) {
						if (!isNull(sol7))
							new Thread(sol7).run();
						return true;
					}
				} else if (eq(cond7, "else")) {
					if (!isNull(sol7))
						new Thread(sol7).run();
					return false;
				}
			} else if (cond7 instanceof Number) {
				if (eq(srcDbl, Dbl(Str(cond7)))) {
					if (!isNull(sol7))
						new Thread(sol7).run();
					return true;
				}
			} else if (cond7 instanceof Character) {
				if (eq((char)src, (char)cond7)) {
					if (!isNull(sol7))
						new Thread(sol7).run();
					return true;
				}
			} else if (isNull(cond7)) {
				// NEEDED TO HANDLE NULL CASES: do nothing in this scenario
			} else {
				print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
				return false;
			}
			if (cond8 instanceof String) {
				if (!in(Str(cond8), "(?<=[<>=])\\-?\\d|else")) {
					print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
					return false;
				}
				double middleware8 = Dbl(
										 String(cond8).replaceAll("[^\\-\\d\\.]", ""));
				cond8 = String(cond8).replaceAll("[^<>=else]", "");
				if (eq(cond8, ">")) {
					if (srcDbl > middleware8) {
						if (!isNull(sol8))
							new Thread(sol8).run();
						return true;
					}
				} else if (eq(cond8, ">=")) {
					if (srcDbl >= middleware8) {
						if (!isNull(sol8))
							new Thread(sol8).run();
						return true;
					}
				} else if (eq(cond8, "<")) {
					if (srcDbl < middleware8) {
						if (!isNull(sol8))
							new Thread(sol8).run();
						return true;
					}
				} else if (eq(cond8, "<=")) {
					if (srcDbl <= middleware8) {
						if (!isNull(sol8))
							new Thread(sol8).run();
						return true;
					}
				} else if (eq(cond8, "==")) {
					if (srcDbl == middleware8) {
						if (!isNull(sol8))
							new Thread(sol8).run();
						return true;
					}
				} else if (eq(cond8, "else")) {
					if (!isNull(sol8))
						new Thread(sol8).run();
					return false;
				}
			} else if (cond8 instanceof Number) {
				if (eq(srcDbl, Dbl(Str(cond8)))) {
					if (!isNull(sol8))
						new Thread(sol8).run();
					return true;
				}
			} else if (cond8 instanceof Character) {
				if (eq((char)src, (char)cond8)) {
					if (!isNull(sol8))
						new Thread(sol8).run();
					return true;
				}
			} else if (isNull(cond8)) {
				// NEEDED TO HANDLE NULL CASES: do nothing in this scenario
			} else {
				print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
				return false;
			}
			if (cond9 instanceof String) {
				if (!in(Str(cond9), "(?<=[<>=])\\-?\\d|else")) {
					print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
					return false;
				}
				double middleware9 = Dbl(
										 String(cond9).replaceAll("[^\\-\\d\\.]", ""));
				cond9 = String(cond9).replaceAll("[^<>=else]", "");
				if (eq(cond9, ">")) {
					if (srcDbl > middleware9) {
						if (!isNull(sol9))
							new Thread(sol9).run();
						return true;
					}
				} else if (eq(cond9, ">=")) {
					if (srcDbl >= middleware9) {
						if (!isNull(sol9))
							new Thread(sol9).run();
						return true;
					}
				} else if (eq(cond9, "<")) {
					if (srcDbl < middleware9) {
						if (!isNull(sol9))
							new Thread(sol9).run();
						return true;
					}
				} else if (eq(cond9, "<=")) {
					if (srcDbl <= middleware9) {
						if (!isNull(sol9))
							new Thread(sol9).run();
						return true;
					}
				} else if (eq(cond9, "==")) {
					if (srcDbl == middleware9) {
						if (!isNull(sol9))
							new Thread(sol9).run();
						return true;
					}
				} else if (eq(cond9, "else")) {
					if (!isNull(sol9))
						new Thread(sol9).run();
					return false;
				}
			} else if (cond9 instanceof Number) {
				if (eq(srcDbl, Dbl(Str(cond9)))) {
					if (!isNull(sol9))
						new Thread(sol9).run();
					return true;
				}
			} else if (cond9 instanceof Character) {
				if (eq((char)src, (char)cond9)) {
					if (!isNull(sol9))
						new Thread(sol9).run();
					return true;
				}
			} else if (isNull(cond9)) {
				// NEEDED TO HANDLE NULL CASES: do nothing in this scenario
			} else {
				print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
				return false;
			}
			if (cond10 instanceof String) {
				if (!in(Str(cond10), "(?<=[<>=])\\-?\\d|else")) {
					print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
					return false;
				}
				double middleware10 = Dbl(
										  String(cond10).replaceAll("[^\\-\\d\\.]", ""));
				cond10 = String(cond10).replaceAll("[^<>=else]", "");
				if (eq(cond10, ">")) {
					if (srcDbl > middleware10) {
						if (!isNull(sol10))
							new Thread(sol10).run();
						return true;
					}
				} else if (eq(cond10, ">=")) {
					if (srcDbl >= middleware10) {
						if (!isNull(sol10))
							new Thread(sol10).run();
						return true;
					}
				} else if (eq(cond10, "<")) {
					if (srcDbl < middleware10) {
						if (!isNull(sol10))
							new Thread(sol10).run();
						return true;
					}
				} else if (eq(cond10, "<=")) {
					if (srcDbl <= middleware10) {
						if (!isNull(sol10))
							new Thread(sol10).run();
						return true;
					}
				} else if (eq(cond10, "==")) {
					if (srcDbl == middleware10) {
						if (!isNull(sol10))
							new Thread(sol10).run();
						return true;
					}
				} else if (eq(cond10, "else")) {
					if (!isNull(sol10))
						new Thread(sol10).run();
					return false;
				}
			} else if (cond10 instanceof Number) {
				if (eq(srcDbl, Dbl(Str(cond10)))) {
					if (!isNull(sol10))
						new Thread(sol10).run();
					return true;
				}
			} else if (cond10 instanceof Character) {
				if (eq((char)src, (char)cond10)) {
					if (!isNull(sol10))
						new Thread(sol10).run();
					return true;
				}
			} else if (isNull(cond10)) {
				// NEEDED TO HANDLE NULL CASES: do nothing in this scenario
			} else {
				print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
				return false;
			}
		} else if (src instanceof String) {
			if (cond1 instanceof String) {
				if (eq((String) src, (String) cond1)) {
					if (!isNull(sol1))
						new Thread(sol1).run();
					return true;
				}
			} else if (isNull(cond1)) {
				// NEEDED TO HANDLE NULL CASES: do nothing in this scenario
			} else {
				print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
				return false;
			}
			if (cond2 instanceof String) {
				if (eq((String) src, (String) cond2)) {
					if (!isNull(sol2))
						new Thread(sol2).run();
					return true;
				} else if (eq((String) cond2, "else")) {
					if (!isNull(sol2))
						new Thread(sol2).run();
					return false;
				}
			} else if (isNull(cond2)) {
				// NEEDED TO HANDLE NULL CASES: do nothing in this scenario
			} else {
				print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
				return false;
			}
			if (cond3 instanceof String) {
				if (eq((String) src, (String) cond3)) {
					if (!isNull(sol3))
						new Thread(sol3).run();
					return true;
				} else if (eq((String) cond3, "else")) {
					if (!isNull(sol3))
						new Thread(sol3).run();
					return false;
				}
			} else if (isNull(cond3)) {
				// NEEDED TO HANDLE NULL CASES: do nothing in this scenario
			} else {
				print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
				return false;
			}
			if (cond4 instanceof String) {
				if (eq((String) src, (String) cond4)) {
					if (!isNull(sol4))
						new Thread(sol4).run();
					return true;
				} else if (eq((String) cond4, "else")) {
					if (!isNull(sol4))
						new Thread(sol4).run();
					return false;
				}
			} else if (isNull(cond4)) {
				// NEEDED TO HANDLE NULL CASES: do nothing in this scenario
			} else {
				print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
				return false;
			}
			if (cond5 instanceof String) {
				if (eq((String) src, (String) cond5)) {
					if (!isNull(sol5))
						new Thread(sol5).run();
					return true;
				} else if (eq((String) cond5, "else")) {
					if (!isNull(sol5))
						new Thread(sol5).run();
					return false;
				}
			} else if (isNull(cond5)) {
				// NEEDED TO HANDLE NULL CASES: do nothing in this scenario
			} else {
				print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
				return false;
			}
			if (cond6 instanceof String) {
				if (eq((String) src, (String) cond6)) {
					if (!isNull(sol6))
						new Thread(sol6).run();
					return true;
				} else if (eq((String) cond6, "else")) {
					if (!isNull(sol6))
						new Thread(sol6).run();
					return false;
				}
			} else if (isNull(cond6)) {
				// NEEDED TO HANDLE NULL CASES: do nothing in this scenario
			} else {
				print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
				return false;
			}
			if (cond7 instanceof String) {
				if (eq((String) src, (String) cond7)) {
					if (!isNull(sol7))
						new Thread(sol7).run();
					return true;
				} else if (eq((String) cond7, "else")) {
					if (!isNull(sol7))
						new Thread(sol7).run();
					return false;
				}
			} else if (isNull(cond7)) {
				// NEEDED TO HANDLE NULL CASES: do nothing in this scenario
			} else {
				print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
				return false;
			}
			if (cond8 instanceof String) {
				if (eq((String) src, (String) cond8)) {
					if (!isNull(sol8))
						new Thread(sol8).run();
					return true;
				} else if (eq((String) cond8, "else")) {
					if (!isNull(sol8))
						new Thread(sol8).run();
					return false;
				}
			} else if (isNull(cond8)) {
				// NEEDED TO HANDLE NULL CASES: do nothing in this scenario
			} else {
				print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
				return false;
			}
			if (cond9 instanceof String) {
				if (eq((String) src, (String) cond9)) {
					if (!isNull(sol9))
						new Thread(sol9).run();
					return true;
				} else if (eq((String) cond9, "else")) {
					if (!isNull(sol9))
						new Thread(sol9).run();
					return false;
				}
			} else if (isNull(cond9)) {
				// NEEDED TO HANDLE NULL CASES: do nothing in this scenario
			} else {
				print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
				return false;
			}
			if (cond10 instanceof String) {
				if (eq((String) src, (String) cond10)) {
					if (!isNull(sol10))
						new Thread(sol10).run();
					return true;
				} else if (eq((String) cond10, "else")) {
					if (!isNull(sol10))
						new Thread(sol10).run();
					return false;
				}
			} else if (isNull(cond10)) {
				// NEEDED TO HANDLE NULL CASES: do nothing in this scenario
			} else {
				print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
				return false;
			}
		} else if (src instanceof Boolean) {
			if (cond1 instanceof Boolean) {
				if (eq((boolean) src, (boolean) cond1)) {
					if (!isNull(sol1))
						new Thread(sol1).run();
					return true;
				}
			} else if (isNull(cond1)) {
				// NEEDED TO HANDLE NULL CASES: do nothing in this scenario
			} else {
				print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
				return false;
			}
			if (cond2 instanceof Boolean) {
				if (eq((boolean) src, (boolean) cond2)) {
					if (!isNull(sol2))
						new Thread(sol2).run();
					return true;
				}
			} else if (cond2 instanceof String) {
				cond2 = Str(cond2).replaceAll("[^else]", "");
				if (eq(cond2, "else")) {
					if (!isNull(sol2))
						new Thread(sol2).run();
					return false;
				}
			} else if (isNull(cond2)) {
				// NEEDED TO HANDLE NULL CASES: do nothing in this scenario
			} else {
				print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
				return false;
			}
			if (cond3 instanceof Boolean) {
				if (eq((boolean) src, (boolean) cond3)) {
					if (!isNull(sol3))
						new Thread(sol3).run();
					return true;
				}
			} else if (cond3 instanceof String) {
				cond3 = Str(cond3).replaceAll("[^else]", "");
				if (eq(cond3, "else")) {
					if (!isNull(sol3))
						new Thread(sol3).run();
					return false;
				}
			} else if (isNull(cond3)) {
				// NEEDED TO HANDLE NULL CASES: do nothing in this scenario
			} else {
				print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
				return false;
			}
			if (cond4 instanceof Boolean) {
				if (eq((boolean) src, (boolean) cond4)) {
					if (!isNull(sol4))
						new Thread(sol4).run();
					return true;
				}
			} else if (cond4 instanceof String) {
				cond4 = Str(cond4).replaceAll("[^else]", "");
				if (eq(cond4, "else")) {
					if (!isNull(sol4))
						new Thread(sol4).run();
					return false;
				}
			} else if (isNull(cond4)) {
				// NEEDED TO HANDLE NULL CASES: do nothing in this scenario
			} else {
				print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
				return false;
			}
			if (cond5 instanceof Boolean) {
				if (eq((boolean) src, (boolean) cond5)) {
					if (!isNull(sol5))
						new Thread(sol5).run();
					return true;
				}
			} else if (cond5 instanceof String) {
				cond5 = Str(cond5).replaceAll("[^else]", "");
				if (eq(cond5, "else")) {
					if (!isNull(sol5))
						new Thread(sol5).run();
					return false;
				}
			} else if (isNull(cond5)) {
				// NEEDED TO HANDLE NULL CASES: do nothing in this scenario
			} else {
				print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
				return false;
			}
			if (cond6 instanceof Boolean) {
				if (eq((boolean) src, (boolean) cond6)) {
					if (!isNull(sol6))
						new Thread(sol6).run();
					return true;
				}
			} else if (cond6 instanceof String) {
				cond6 = Str(cond6).replaceAll("[^else]", "");
				if (eq(cond6, "else")) {
					if (!isNull(sol6))
						new Thread(sol6).run();
					return false;
				}
			} else if (isNull(cond6)) {
				// NEEDED TO HANDLE NULL CASES: do nothing in this scenario
			} else {
				print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
				return false;
			}
			if (cond7 instanceof Boolean) {
				if (eq((boolean) src, (boolean) cond7)) {
					if (!isNull(sol7))
						new Thread(sol7).run();
					return true;
				}
			} else if (cond7 instanceof String) {
				cond7 = Str(cond7).replaceAll("[^else]", "");
				if (eq(cond7, "else")) {
					if (!isNull(sol7))
						new Thread(sol7).run();
					return false;
				}
			} else if (isNull(cond7)) {
				// NEEDED TO HANDLE NULL CASES: do nothing in this scenario
			} else {
				print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
				return false;
			}
			if (cond8 instanceof Boolean) {
				if (eq((boolean) src, (boolean) cond8)) {
					if (!isNull(sol8))
						new Thread(sol8).run();
					return true;
				}
			} else if (cond8 instanceof String) {
				cond8 = Str(cond8).replaceAll("[^else]", "");
				if (eq(cond8, "else")) {
					if (!isNull(sol8))
						new Thread(sol8).run();
					return false;
				}
			} else if (isNull(cond8)) {
				// NEEDED TO HANDLE NULL CASES: do nothing in this scenario
			} else {
				print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
				return false;
			}
			if (cond9 instanceof Boolean) {
				if (eq((boolean) src, (boolean) cond9)) {
					if (!isNull(sol9))
						new Thread(sol9).run();
					return true;
				}
			} else if (cond9 instanceof String) {
				cond9 = Str(cond9).replaceAll("[^else]", "");
				if (eq(cond9, "else")) {
					if (!isNull(sol9))
						new Thread(sol9).run();
					return false;
				}
			} else if (isNull(cond9)) {
				// NEEDED TO HANDLE NULL CASES: do nothing in this scenario
			} else {
				print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
				return false;
			}
			if (cond10 instanceof Boolean) {
				if (eq((boolean) src, (boolean) cond10)) {
					if (!isNull(sol10))
						new Thread(sol10).run();
					return true;
				}
			} else if (cond10 instanceof String) {
				cond10 = Str(cond10).replaceAll("[^else]", "");
				if (eq(cond10, "else")) {
					if (!isNull(sol10))
						new Thread(sol10).run();
					return false;
				}
			} else if (isNull(cond10)) {
				// NEEDED TO HANDLE NULL CASES: do nothing in this scenario
			} else {
				print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
				return false;
			}
		} else {
			print("[KL.LogicalError.UnlikelyTypesSeen]\nThe source can either only be a string, number, or boolean.");
		}
		return false;
	}
	public static boolean sw(Object src, Object cond1, Runnable sol1,
							 Object cond2, Runnable sol2, Object cond3, Runnable sol3,
							 Object cond4, Runnable sol4, Object cond5, Runnable sol5,
							 Object cond6, Runnable sol6, Object cond7, Runnable sol7,
							 Object cond8, Runnable sol8, Object cond9, Runnable sol9) {
		return sw(src, cond1, sol1, cond2, sol2, cond3, sol3, cond4, sol4,
				  cond5, sol5, cond6, sol6, cond7, sol7, cond8, sol8, cond9, sol9,
				  null, null);
	}
	public static boolean sw(Object src, Object cond1, Runnable sol1,
							 Object cond2, Runnable sol2, Object cond3, Runnable sol3,
							 Object cond4, Runnable sol4, Object cond5, Runnable sol5,
							 Object cond6, Runnable sol6, Object cond7, Runnable sol7,
							 Object cond8, Runnable sol8) {
		return sw(src, cond1, sol1, cond2, sol2, cond3, sol3, cond4, sol4,
				  cond5, sol5, cond6, sol6, cond7, sol7, cond8, sol8, null, null,
				  null, null);
	}
	public static boolean sw(Object src, Object cond1, Runnable sol1,
							 Object cond2, Runnable sol2, Object cond3, Runnable sol3,
							 Object cond4, Runnable sol4, Object cond5, Runnable sol5,
							 Object cond6, Runnable sol6, Object cond7, Runnable sol7) {
		return sw(src, cond1, sol1, cond2, sol2, cond3, sol3, cond4, sol4,
				  cond5, sol5, cond6, sol6, cond7, sol7, null, null, null, null,
				  null, null);
	}
	public static boolean sw(Object src, Object cond1, Runnable sol1,
							 Object cond2, Runnable sol2, Object cond3, Runnable sol3,
							 Object cond4, Runnable sol4, Object cond5, Runnable sol5,
							 Object cond6, Runnable sol6) {
		return sw(src, cond1, sol1, cond2, sol2, cond3, sol3, cond4, sol4,
				  cond5, sol5, cond6, sol6, null, null, null, null, null, null,
				  null, null);
	}
	public static boolean sw(Object src, Object cond1, Runnable sol1,
							 Object cond2, Runnable sol2, Object cond3, Runnable sol3,
							 Object cond4, Runnable sol4, Object cond5, Runnable sol5) {
		return sw(src, cond1, sol1, cond2, sol2, cond3, sol3, cond4, sol4,
				  cond5, sol5, null, null, null, null, null, null, null, null,
				  null, null);
	}
	public static boolean sw(Object src, Object cond1, Runnable sol1,
							 Object cond2, Runnable sol2, Object cond3, Runnable sol3,
							 Object cond4, Runnable sol4) {
		return sw(src, cond1, sol1, cond2, sol2, cond3, sol3, cond4, sol4, null,
				  null, null, null, null, null, null, null, null, null, null,
				  null);
	}
	public static boolean sw(Object src, Object cond1, Runnable sol1,
							 Object cond2, Runnable sol2, Object cond3, Runnable sol3) {
		return sw(src, cond1, sol1, cond2, sol2, cond3, sol3, null, null, null,
				  null, null, null, null, null, null, null, null, null, null,
				  null);
	}
	public static boolean sw(Object src, Object cond1, Runnable sol1,
							 Object cond2, Runnable sol2) {
		return sw(src, cond1, sol1, cond2, sol2, null, null, null, null, null,
				  null, null, null, null, null, null, null, null, null, null,
				  null);
	}
	public static boolean sw(Object src, Object cond1, Runnable sol1) {
		return sw(src, cond1, sol1, null, null, null, null, null, null, null,
				  null, null, null, null, null, null, null, null, null, null,
				  null);
	}
	public static void sw(boolean cond1, Runnable sol1, boolean cond2,
						  Runnable sol2, boolean cond3, Runnable sol3, boolean cond4,
						  Runnable sol4, boolean cond5, Runnable sol5, boolean cond6,
						  Runnable sol6, boolean cond7, Runnable sol7, boolean cond8,
						  Runnable sol8, boolean cond9, Runnable sol9, boolean cond10,
						  Runnable sol10) {
		if (is(cond1))
			new Thread(sol1).run();
		else if (is(cond2))
			new Thread(sol2).run();
		else if (is(cond3))
			new Thread(sol3).run();
		else if (is(cond4))
			new Thread(sol4).run();
		else if (is(cond5))
			new Thread(sol5).run();
		else if (is(cond6))
			new Thread(sol6).run();
		else if (is(cond7))
			new Thread(sol7).run();
		else if (is(cond8))
			new Thread(sol8).run();
		else if (is(cond9))
			new Thread(sol9).run();
		else if (is(cond10))
			new Thread(sol10).run();
		return;
	}
	public static void sw(boolean cond1, Runnable sol1, boolean cond2,
						  Runnable sol2, boolean cond3, Runnable sol3, boolean cond4,
						  Runnable sol4, boolean cond5, Runnable sol5, boolean cond6,
						  Runnable sol6, boolean cond7, Runnable sol7, boolean cond8,
						  Runnable sol8, boolean cond9, Runnable sol9) {
		sw(cond1, sol1, cond2, sol2, cond3, sol3, cond4, sol4, cond5, sol5,
		   cond6, sol6, cond7, sol7, cond8, sol8, cond9, sol9, false,
		   null);
	}
	public static void sw(boolean cond1, Runnable sol1, boolean cond2,
						  Runnable sol2, boolean cond3, Runnable sol3, boolean cond4,
						  Runnable sol4, boolean cond5, Runnable sol5, boolean cond6,
						  Runnable sol6, boolean cond7, Runnable sol7, boolean cond8,
						  Runnable sol8) {
		sw(cond1, sol1, cond2, sol2, cond3, sol3, cond4, sol4, cond5, sol5,
		   cond6, sol6, cond7, sol7, cond8, sol8, false, null, false,
		   null);
	}
	public static void sw(boolean cond1, Runnable sol1, boolean cond2,
						  Runnable sol2, boolean cond3, Runnable sol3, boolean cond4,
						  Runnable sol4, boolean cond5, Runnable sol5, boolean cond6,
						  Runnable sol6, boolean cond7, Runnable sol7) {
		sw(cond1, sol1, cond2, sol2, cond3, sol3, cond4, sol4, cond5, sol5,
		   cond6, sol6, cond7, sol7, false, null, false, null, false,
		   null);
	}
	public static void sw(boolean cond1, Runnable sol1, boolean cond2,
						  Runnable sol2, boolean cond3, Runnable sol3, boolean cond4,
						  Runnable sol4, boolean cond5, Runnable sol5, boolean cond6,
						  Runnable sol6) {
		sw(cond1, sol1, cond2, sol2, cond3, sol3, cond4, sol4, cond5, sol5,
		   cond6, sol6, false, null, false, null, false, null, false,
		   null);
	}
	public static void sw(boolean cond1, Runnable sol1, boolean cond2,
						  Runnable sol2, boolean cond3, Runnable sol3, boolean cond4,
						  Runnable sol4, boolean cond5, Runnable sol5) {
		sw(cond1, sol1, cond2, sol2, cond3, sol3, cond4, sol4, cond5, sol5,
		   false, null, false, null, false, null, false, null, false,
		   null);
	}
	public static void sw(boolean cond1, Runnable sol1, boolean cond2,
						  Runnable sol2, boolean cond3, Runnable sol3, boolean cond4,
						  Runnable sol4) {
		sw(cond1, sol1, cond2, sol2, cond3, sol3, cond4, sol4, false, null,
		   false, null, false, null, false, null, false, null, false,
		   null);
	}
	public static void sw(boolean cond1, Runnable sol1, boolean cond2,
						  Runnable sol2, boolean cond3, Runnable sol3) {
		sw(cond1, sol1, cond2, sol2, cond3, sol3, false, null, false, null,
		   false, null, false, null, false, null, false, null, false,
		   null);
	}
	public static void sw(boolean cond1, Runnable sol1, boolean cond2,
						  Runnable sol2) {
		sw(cond1, sol1, cond2, sol2, false, null, false, null, false, null,
		   false, null, false, null, false, null, false, null, false,
		   null);
	}
	public static void sw(boolean cond1, Runnable sol1) {
		sw(cond1, sol1, false, null, false, null, false, null, false, null,
		   false, null, false, null, false, null, false, null, false,
		   null);
	}
	public static final boolean Yes = true, No = !Yes;
	public static String Else = "else";
	public static int[] range(int n) {
		IntArr arr = new IntArr();
		if (not(n) || n < 1)
			return arr.array();
		for (int i = 0; i < n; i++)
			arr.add(i);
		return arr.array();
	}
	public static double[] range(double n) {
		DblArr arr = new DblArr();
		if (not(n) || n < 1.1)
			return arr.array();
		for (double i = 0; i < n; i += .1)
			arr.add(i);
		return arr.array();
	}
	public static int[] range(int m, int n) {
		IntArr arr = new IntArr();
		if (not(m) || not(n) || eq(m, n))
			return arr.array();
		if (m > n) {
			for (int i = m; i >= n; i--)
				arr.add(i);
		} else {
			for (int i = m; i <= n; i++)
				arr.add(i);
		}
		return arr.array();
	}
	public static String[] range(String m, String n) {
		StrArr arr = new StrArr();
		if (not(m) || not(n) || eq(m, n) || !eq(m, "[A-Za-z]")
				|| !eq(n, "[A-Za-z]"))
			return arr.array();
		int charCodeOfM = (int) m.charAt(0), charCodeOfN = (int) n.charAt(0);
		if (charCodeOfM > charCodeOfN) {
			for (int i = charCodeOfM; i >= charCodeOfN; i--)
				arr.add(Str((char) i));
		} else {
			for (int i = charCodeOfM; i <= charCodeOfN; i++)
				arr.add(Str((char) i));
		}
		return arr.array();
	}
	public static char[] range(char m, char n) {
		return join(range(Str(m), Str(n)), "").toCharArray();
	}
	public static double[] range(double m, double n) {
		DblArr arr = new DblArr();
		if (not(m) || not(n) || eq(m, n))
			return arr.array();
		if (m > n) {
			for (double i = m; i >= n; i -= .1)
				arr.add(Dbl(setPrecision(i)));
		} else {
			for (double i = m; i <= n; i += .1)
				arr.add(Dbl(setPrecision(i)));
		}
		return arr.array();
	}
	public static int[] range(int n, boolean reverse) {
		if (not(n) || isNeg(n)) return new int[] {};
		if (reverse)
			return range(n, 1);
		return range(n);
	}
	public static int[] range(int m, int n, boolean reverse) {
		if (not(m) || not(n) || eq(m, n)) return new int[] {};
		if (reverse)
			return range(n, m);
		return range(m, n);
	}
	public static double[] range(double n, boolean reverse) {
		if (not(n) || isNeg(n)) return new double[] {};
		if (reverse)
			return range(n, 1);
		return range(n);
	}
	public static double[] range(double m, double n, boolean reverse) {
		if (not(m) || not(n) || eq(m, n)) return new double[] {};
		if (reverse)
			return range(n, m);
		return range(m, n);
	}
	public static String[] range(String m, String n, boolean reverse) {
		if (not(m) || not(n) || eq(m, n)) return new String[] {};
		if (reverse)
			return range(n, m);
		return range(m, n);
	}
	public static char[] range(char m, char n, boolean reverse) {
		if (not(m) || not(n) || eq(m, n)) return new char[] {};
		if (reverse)
			return range(n, m);
		return range(m, n);
	}
	public static int[] range(String str) {
		return range(len(str));
	}
	public static int[] range(char[] arr) {
		return range(len(arr));
	}
	public static int[] range(String[] arr) {
		return range(len(arr));
	}
	public static int[] range(int[] arr) {
		return range(len(arr));
	}
	public static int[] range(long[] arr) {
		return range(len(arr));
	}
	public static int[] range(float[] arr) {
		return range(len(arr));
	}
	public static int[] range(double[] arr) {
		return range(len(arr));
	}
	public static int[] range(boolean[] arr) {
		return range(len(arr));
	}
	public static int[] range(Object[] arr) {
		return range(len(arr));
	}
	public static int[] range(StrArr arr) {
		return range(len(arr));
	}
	public static int[] range(IntArr arr) {
		return range(len(arr));
	}
	public static int[] range(LongArr arr) {
		return range(len(arr));
	}
	public static int[] range(FltArr arr) {
		return range(len(arr));
	}
	public static int[] range(DblArr arr) {
		return range(len(arr));
	}
	public static int[] range(BoolArr arr) {
		return range(len(arr));
	}
	public static int[] idx(String str) {
		return range(str);
	}
	public static int[] idx(char[] arr) {
		return range(arr);
	}
	public static int[] idx(String[] arr) {
		return range(arr);
	}
	public static int[] idx(int[] arr) {
		return range(arr);
	}
	public static int[] idx(long[] arr) {
		return range(arr);
	}
	public static int[] idx(float[] arr) {
		return range(arr);
	}
	public static int[] idx(double[] arr) {
		return range(arr);
	}
	public static int[] idx(boolean[] arr) {
		return range(arr);
	}
	public static int[] idx(Object[] arr) {
		return range(arr);
	}
	public static int[] idx(StrArr arr) {
		return range(arr);
	}
	public static int[] idx(IntArr arr) {
		return range(arr);
	}
	public static int[] idx(LongArr arr) {
		return range(arr);
	}
	public static int[] idx(FltArr arr) {
		return range(arr);
	}
	public static int[] idx(DblArr arr) {
		return range(arr);
	}
	public static int[] idx(BoolArr arr) {
		return range(arr);
	}
	public static void each(String[] iterable,
							ObjIntConsumer<String> consumer) {
		int i = 0;
		for (String item : iterable) {
			consumer.accept(item, i);
			i++;
		}
	}
	public static void each(StrArr iterable, ObjIntConsumer<String> consumer) {
		int i = 0;
		for (String item : iterable) {
			consumer.accept(item, i);
			i++;
		}
	}
	public static void each(int[] iterable, ObjIntConsumer<Integer> consumer) {
		int i = 0;
		for (int item : iterable) {
			consumer.accept(item, i);
			i++;
		}
	}
	public static void each(IntArr iterable, ObjIntConsumer<Integer> consumer) {
		int i = 0;
		for (int item : iterable) {
			consumer.accept(item, i);
			i++;
		}
	}
	public static void each(long[] iterable, ObjIntConsumer<Long> consumer) {
		int i = 0;
		for (long item : iterable) {
			consumer.accept(item, i);
			i++;
		}
	}
	public static void each(LongArr iterable, ObjIntConsumer<Long> consumer) {
		int i = 0;
		for (long item : iterable) {
			consumer.accept(item, i);
			i++;
		}
	}
	public static void each(float[] iterable, ObjIntConsumer<Float> consumer) {
		int i = 0;
		for (float item : iterable) {
			consumer.accept(item, i);
			i++;
		}
	}
	public static void each(FltArr iterable, ObjIntConsumer<Float> consumer) {
		int i = 0;
		for (float item : iterable) {
			consumer.accept(item, i);
			i++;
		}
	}
	public static void each(double[] iterable,
							ObjIntConsumer<Double> consumer) {
		int i = 0;
		for (double item : iterable) {
			consumer.accept(item, i);
			i++;
		}
	}
	public static void each(DblArr iterable, ObjIntConsumer<Double> consumer) {
		int i = 0;
		for (double item : iterable) {
			consumer.accept(item, i);
			i++;
		}
	}
	public static void each(boolean[] iterable,
							ObjIntConsumer<Boolean> consumer) {
		int i = 0;
		for (boolean item : iterable) {
			consumer.accept(item, i);
			i++;
		}
	}
	public static void each(BoolArr iterable,
							ObjIntConsumer<Boolean> consumer) {
		int i = 0;
		for (boolean item : iterable) {
			consumer.accept(item, i);
			i++;
		}
	}
	public static void each(Object[] iterable,
							ObjIntConsumer<Object> consumer) {
		int i = 0;
		for (Object item : iterable) {
			consumer.accept(item, i);
			i++;
		}
	}
	public static void forEach(String[] iterable,
							   ObjIntConsumer<String> consumer) {
		each(iterable, consumer);
	}
	public static void forEach(StrArr iterable,
							   ObjIntConsumer<String> consumer) {
		each(iterable, consumer);
	}
	public static void forEach(int[] iterable,
							   ObjIntConsumer<Integer> consumer) {
		each(iterable, consumer);
	}
	public static void forEach(IntArr iterable,
							   ObjIntConsumer<Integer> consumer) {
		each(iterable, consumer);
	}
	public static void forEach(long[] iterable, ObjIntConsumer<Long> consumer) {
		each(iterable, consumer);
	}
	public static void forEach(LongArr iterable,
							   ObjIntConsumer<Long> consumer) {
		each(iterable, consumer);
	}
	public static void forEach(float[] iterable,
							   ObjIntConsumer<Float> consumer) {
		each(iterable, consumer);
	}
	public static void forEach(FltArr iterable,
							   ObjIntConsumer<Float> consumer) {
		each(iterable, consumer);
	}
	public static void forEach(double[] iterable,
							   ObjIntConsumer<Double> consumer) {
		each(iterable, consumer);
	}
	public static void forEach(DblArr iterable,
							   ObjIntConsumer<Double> consumer) {
		each(iterable, consumer);
	}
	public static void forEach(boolean[] iterable,
							   ObjIntConsumer<Boolean> consumer) {
		each(iterable, consumer);
	}
	public static void forEach(BoolArr iterable,
							   ObjIntConsumer<Boolean> consumer) {
		each(iterable, consumer);
	}
	public static void forEach(Object[] iterable,
							   ObjIntConsumer<Object> consumer) {
		each(iterable, consumer);
	}
	public static void repeat(Runnable fn, int times) {
		for (; times > 0; times--)
			new Thread(fn).run();
	}
	public static String repeat(String s, int times) {
		if (not(s) || not(times) || isNeg(times)) return s;
		String org = s;
		for (; times > 0; times--)
			s += org;
		return s;
	}
	public static String repeat(String s) {
		return repeat(s, 1);
	}
	public static char[] map(char[] arr, Function<Character, Character> func) {
		if (not(arr) || not(func))
			return arr;
		char[] result = new char[arr.length];
		for (int i = 0; i < arr.length; i++) {
			result[i] = func.apply(arr[i]);
		}
		return result;
	}
	public static String[] map(String[] arr, Function<String, String> func) {
		if (not(arr) || not(func))
			return arr;
		String[] result = new String[arr.length];
		for (int i = 0; i < arr.length; i++) {
			result[i] = func.apply(arr[i]);
		}
		return result;
	}
	public static int[] map(int[] arr, IntUnaryOperator func) {
		if (not(arr) || not(func))
			return arr;
		return Arrays.stream(arr).map(func).toArray();
	}
	public static long[] map(long[] arr, LongUnaryOperator func) {
		if (not(arr) || not(func))
			return arr;
		return Arrays.stream(arr).map(func).toArray();
	}
	public static float[] map(float[] arr, Function<Float, Float> func) {
		if (not(arr) || not(func))
			return arr;
		float[] result = new float[arr.length];
		for (int i = 0; i < arr.length; i++) {
			result[i] = func.apply(arr[i]);
		}
		return result;
	}
	public static double[] map(double[] arr, DoubleUnaryOperator func) {
		if (not(arr) || not(func))
			return arr;
		return Arrays.stream(arr).map(func).toArray();
	}
	public static String[] popIf(String[] array, Predicate<String> condition) {
		return new StrArr(array).popIf(condition).array();
	}
	public static int[] popIf(int[] array, Predicate<Integer> condition) {
		return new IntArr(array).popIf(condition).array();
	}
	public static long[] popIf(long[] array, Predicate<Long> condition) {
		return new LongArr(array).popIf(condition).array();
	}
	public static float[] popIf(float[] array, Predicate<Float> condition) {
		return new FltArr(array).popIf(condition).array();
	}
	public static double[] popIf(double[] array, Predicate<Double> condition) {
		return new DblArr(array).popIf(condition).array();
	}
	public static boolean[] popIf(boolean[] array,
								  Predicate<Boolean> condition) {
		return new BoolArr(array).popIf(condition).array();
	}
	public static StrArr popIf(StrArr list, Predicate<String> condition) {
		return list.popIf(condition);
	}
	public static IntArr popIf(IntArr list, Predicate<Integer> condition) {
		return list.popIf(condition);
	}
	public static LongArr popIf(LongArr list, Predicate<Long> condition) {
		return list.popIf(condition);
	}
	public static FltArr popIf(FltArr list, Predicate<Float> condition) {
		return list.popIf(condition);
	}
	public static DblArr popIf(DblArr list, Predicate<Double> condition) {
		return list.popIf(condition);
	}
	public static BoolArr popIf(BoolArr list, Predicate<Boolean> condition) {
		return list.popIf(condition);
	}
	public static String[] keepIf(String[] array, Predicate<String> condition) {
		return new StrArr(array).keepIf(condition).array();
	}
	public static int[] keepIf(int[] array, Predicate<Integer> condition) {
		return new IntArr(array).keepIf(condition).array();
	}
	public static long[] keepIf(long[] array, Predicate<Long> condition) {
		return new LongArr(array).keepIf(condition).array();
	}
	public static float[] keepIf(float[] array, Predicate<Float> condition) {
		return new FltArr(array).keepIf(condition).array();
	}
	public static double[] keepIf(double[] array, Predicate<Double> condition) {
		return new DblArr(array).keepIf(condition).array();
	}
	public static boolean[] keepIf(boolean[] array,
								   Predicate<Boolean> condition) {
		return new BoolArr(array).keepIf(condition).array();
	}
	public static StrArr keepIf(StrArr list, Predicate<String> condition) {
		return list.keepIf(condition);
	}
	public static IntArr keepIf(IntArr list, Predicate<Integer> condition) {
		return list.keepIf(condition);
	}
	public static LongArr keepIf(LongArr list, Predicate<Long> condition) {
		return list.keepIf(condition);
	}
	public static FltArr keepIf(FltArr list, Predicate<Float> condition) {
		return list.keepIf(condition);
	}
	public static DblArr keepIf(DblArr list, Predicate<Double> condition) {
		return list.keepIf(condition);
	}
	public static BoolArr keepIf(BoolArr list, Predicate<Boolean> condition) {
		return list.keepIf(condition);
	}
	public static String[] filterOut(String[] array,
									 Predicate<String> condition) {
		return popIf(array, condition);
	}
	public static int[] filterOut(int[] array, Predicate<Integer> condition) {
		return popIf(array, condition);
	}
	public static long[] filterOut(long[] array, Predicate<Long> condition) {
		return popIf(array, condition);
	}
	public static float[] filterOut(float[] array, Predicate<Float> condition) {
		return popIf(array, condition);
	}
	public static double[] filterOut(double[] array,
									 Predicate<Double> condition) {
		return popIf(array, condition);
	}
	public static boolean[] filterOut(boolean[] array,
									  Predicate<Boolean> condition) {
		return popIf(array, condition);
	}
	public static StrArr filterOut(StrArr list, Predicate<String> condition) {
		return popIf(list, condition);
	}
	public static IntArr filterOut(IntArr list, Predicate<Integer> condition) {
		return popIf(list, condition);
	}
	public static LongArr filterOut(LongArr list, Predicate<Long> condition) {
		return popIf(list, condition);
	}
	public static FltArr filterOut(FltArr list, Predicate<Float> condition) {
		return popIf(list, condition);
	}
	public static DblArr filterOut(DblArr list, Predicate<Double> condition) {
		return popIf(list, condition);
	}
	public static BoolArr filterOut(BoolArr list,
									Predicate<Boolean> condition) {
		return popIf(list, condition);
	}
	public static String[] filter(String[] array, Predicate<String> condition) {
		return keepIf(array, condition);
	}
	public static int[] filter(int[] array, Predicate<Integer> condition) {
		return keepIf(array, condition);
	}
	public static long[] filter(long[] array, Predicate<Long> condition) {
		return keepIf(array, condition);
	}
	public static float[] filter(float[] array, Predicate<Float> condition) {
		return keepIf(array, condition);
	}
	public static double[] filter(double[] array, Predicate<Double> condition) {
		return keepIf(array, condition);
	}
	public static boolean[] filter(boolean[] array,
								   Predicate<Boolean> condition) {
		return keepIf(array, condition);
	}
	public static StrArr filter(StrArr list, Predicate<String> condition) {
		return keepIf(list, condition);
	}
	public static IntArr filter(IntArr list, Predicate<Integer> condition) {
		return keepIf(list, condition);
	}
	public static LongArr filter(LongArr list, Predicate<Long> condition) {
		return keepIf(list, condition);
	}
	public static FltArr filter(FltArr list, Predicate<Float> condition) {
		return keepIf(list, condition);
	}
	public static DblArr filter(DblArr list, Predicate<Double> condition) {
		return keepIf(list, condition);
	}
	public static BoolArr filter(BoolArr list, Predicate<Boolean> condition) {
		return keepIf(list, condition);
	}
	public static String[] onlyPop(String[] array,
								   Predicate<String> condition) {
		return popIf(array, condition);
	}
	public static int[] onlyPop(int[] array, Predicate<Integer> condition) {
		return popIf(array, condition);
	}
	public static long[] onlyPop(long[] array, Predicate<Long> condition) {
		return popIf(array, condition);
	}
	public static float[] onlyPop(float[] array, Predicate<Float> condition) {
		return popIf(array, condition);
	}
	public static double[] onlyPop(double[] array,
								   Predicate<Double> condition) {
		return popIf(array, condition);
	}
	public static boolean[] onlyPop(boolean[] array,
									Predicate<Boolean> condition) {
		return popIf(array, condition);
	}
	public static StrArr onlyPop(StrArr list, Predicate<String> condition) {
		return popIf(list, condition);
	}
	public static IntArr onlyPop(IntArr list, Predicate<Integer> condition) {
		return popIf(list, condition);
	}
	public static LongArr onlyPop(LongArr list, Predicate<Long> condition) {
		return popIf(list, condition);
	}
	public static FltArr onlyPop(FltArr list, Predicate<Float> condition) {
		return popIf(list, condition);
	}
	public static DblArr onlyPop(DblArr list, Predicate<Double> condition) {
		return popIf(list, condition);
	}
	public static BoolArr onlyPop(BoolArr list, Predicate<Boolean> condition) {
		return popIf(list, condition);
	}
	public static String[] onlyKeep(String[] array,
									Predicate<String> condition) {
		return keepIf(array, condition);
	}
	public static int[] onlyKeep(int[] array, Predicate<Integer> condition) {
		return keepIf(array, condition);
	}
	public static long[] onlyKeep(long[] array, Predicate<Long> condition) {
		return keepIf(array, condition);
	}
	public static float[] onlyKeep(float[] array, Predicate<Float> condition) {
		return keepIf(array, condition);
	}
	public static double[] onlyKeep(double[] array,
									Predicate<Double> condition) {
		return keepIf(array, condition);
	}
	public static boolean[] onlyKeep(boolean[] array,
									 Predicate<Boolean> condition) {
		return keepIf(array, condition);
	}
	public static StrArr onlyKeep(StrArr list, Predicate<String> condition) {
		return keepIf(list, condition);
	}
	public static IntArr onlyKeep(IntArr list, Predicate<Integer> condition) {
		return keepIf(list, condition);
	}
	public static LongArr onlyKeep(LongArr list, Predicate<Long> condition) {
		return keepIf(list, condition);
	}
	public static FltArr onlyKeep(FltArr list, Predicate<Float> condition) {
		return keepIf(list, condition);
	}
	public static DblArr onlyKeep(DblArr list, Predicate<Double> condition) {
		return keepIf(list, condition);
	}
	public static BoolArr onlyKeep(BoolArr list, Predicate<Boolean> condition) {
		return keepIf(list, condition);
	}
	// Date functions
	public static String nthDay(int n) {
		String days[] = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday",
						 "Friday", "Saturday"
						};
		return days[n];
	}
	public static String nthMonth(int n) {
		String months[] = {"January", "February", "March", "April", "May",
						   "June", "July", "August", "September", "October", "November",
						   "December"
						  };
		return months[n];
	}
	public static String formattedDate(Date dt) {
		int dayOfWeek = dt.getDay(), monthOfYear = dt.getMonth();
		String day, month;
		String date = dt.toLocaleString();
		String ampm = date.substring(date.length() - 2);
		date = date.substring(0, date.length() - 6) + " " + ampm;
		month = nthMonth(monthOfYear);
		date = month + " " + date.substring(4);
		day = nthDay(dayOfWeek);
		date = day + ", " + date;
		return date;
	}
	public static String now() {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * (3600 * 1000))); // fix 5-hour bug
		String date = formattedDate(dt);
		return date;
	}
	public static String now(boolean shortened) {
		if (!shortened)
			return now();
		String parts[] = now().split(", ");
		parts[0] = slice(parts[0], 0, 3);
		parts[1] = slice(split(parts[1], " ")[0], 0, 3) + " "
				   + split(parts[1], " ")[1];
		String time = slice(parts, len(parts) - 1)[0];
		String x[] = {time, join(slice(parts, 0, len(parts) - 1), ", ")};
		String result = join(x, ", ");
		return result;
	}
	public static String getDate() {
		String parts[] = now().split(", ");
		return parts[1] + ", " + parts[2];
	}
	public static String getDay() {
		return now().split(", ")[0];
	}
	public static String getMonth() {
		return now().split(", ")[1].split(" ")[0];
	}
	public static String getYear() {
		return now().split(", ")[2];
	}
	public static String getTime() {
		return now().split(", ")[3];
	}
	public static String getSeason() {
		String m = slice(getMonth(), 0, 3).toLowerCase();
		switch (m) {
		case "may" :
		case "jun" :
		case "jul" :
		case "aug" :
			return "Summer";
		case "sep" :
		case "oct" :
			return "Spring";
		case "nov" :
		case "dec" :
		case "jan" :
		case "feb" :
			return "Winter";
		default :
			return "Fall/Autumn";
		}
	}
	public static String yesterday() {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int) 36e5))); // fix 5-hour bug
		dt.setTime(dt.getTime() - ((int) 36e5 * 24)); // decrement 24 hours or
		// (3.6*10⁶)*24
		// milliseconds
		String date = formattedDate(dt);
		String parts[] = date.split(", ");
		date = parts[0] + ", " + parts[1] + ", " + parts[2];
		return date;
	}
	public static String dayBeforeYesterday() {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int) 36e5))); // fix 5-hour bug
		dt.setTime(dt.getTime() - ((int) 72e5 * 24)); // decrement 48 hours or
		// (7.2*10⁶)*24
		// milliseconds
		String date = formattedDate(dt);
		String parts[] = date.split(", ");
		date = parts[0] + ", " + parts[1] + ", " + parts[2];
		return date;
	}
	public static String twoDaysAgo() {
		return dayBeforeYesterday();
	}
	public static String tomorrow() {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int)(36e2 * 1e3))));  // fix 5-hour bug
		dt.setTime(dt.getTime() + ((int) 36e5 * 24)); // increment 24 hours or
		// (3.6*10⁶)*24
		// milliseconds
		String date = formattedDate(dt);
		String parts[] = date.split(", ");
		date = parts[0] + ", " + parts[1] + ", " + parts[2];
		return date;
	}
	public static String dayAfterTomorrow() {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int) 36e5))); // fix 5-hour bug
		dt.setTime(dt.getTime() + ((int) 72e5 * 24)); // increment 48 hours or
		// (7.2*10⁶)*24
		// milliseconds
		String date = formattedDate(dt);
		String parts[] = date.split(", ");
		date = parts[0] + ", " + parts[1] + ", " + parts[2];
		return date;
	}
	public static String twoDaysLater() {
		return dayAfterTomorrow();
	}
	public static String lastMonth() {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int) 36e5))); // fix 5-hour bug
		dt.setMonth(dt.getMonth() - 1); // decrement a month
		String date = formattedDate(dt);
		date = date.split(", ")[1].split(" ")[0];
		return date;
	}
	public static String lastMonthOf(String date) {
		Date dt = new Date(date);
		dt.setTime(dt.getTime() + (5 * ((int) 36e5))); // fix 5-hour bug
		dt.setMonth(dt.getMonth() - 1); // decrement a month
		date = formattedDate(dt);
		date = date.split(", ")[1].split(" ")[0];
		return date;
	}
	public static String nextMonth() {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int) 36e5))); // fix 5-hour bug
		dt.setMonth(dt.getMonth() + 1); // increment a month
		String date = formattedDate(dt);
		String parts[] = date.split(", ");
		date = date.split(", ")[1].split(" ")[0];
		return date;
	}
	public static String nextMonthOf(String date) {
		Date dt = new Date(date);
		dt.setTime(dt.getTime() + (5 * ((int) 36e5))); // fix 5-hour bug
		dt.setMonth(dt.getMonth() + 1); // increment a month
		date = formattedDate(dt);
		String parts[] = date.split(", ");
		date = date.split(", ")[1].split(" ")[0];
		return date;
	}
	public static String lastYear() {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int) 36e5))); // fix 5-hour bug
		dt.setYear(dt.getYear() - 1); // decrement a year
		String date = formattedDate(dt);
		String parts[] = date.split(", ");
		date = date.split(", ")[2];
		return date;
	}
	public static String lastYearOf(String date) {
		Date dt = new Date(date);
		dt.setTime(dt.getTime() + (5 * ((int) 36e5))); // fix 5-hour bug
		dt.setYear(dt.getYear() - 1); // decrement a year
		date = formattedDate(dt);
		date = date.split(", ")[2];
		return date;
	}
	public static String nextYear() {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int) 36e5))); // fix 5-hour bug
		dt.setYear(dt.getYear() + 1); // increment a year
		String date = formattedDate(dt);
		date = date.split(", ")[2];
		return date;
	}
	public static String nextYear(String date) {
		Date dt = new Date(date);
		dt.setTime(dt.getTime() + (5 * ((int) 36e5))); // fix 5-hour bug
		dt.setYear(dt.getYear() + 1); // increment a year
		date = formattedDate(dt);
		date = date.split(", ")[2];
		return date;
	}
	public static String age2bday(int age) {
		Date dt = new Date();
		// dt.setTime(dt.getTime()+(5*((int)36e5))); //fix 5-hour bug
		String bday = "" + ((dt.getYear() + 1900) - age); // adding 1900 helps
		// resolve a bug
		return bday;
	}
	public static int bday2age(String date) {
		Date dt = new Date(date);
		dt.setTime(dt.getTime() + (5 * ((int) 36e5))); // fix 5-hour bug
		int age = new Date().getYear() - dt.getYear();
		return age;
	}
	public static String date2day(String date) {
		Date dt = new Date(date);
		dt.setTime(dt.getTime() + (5 * ((int) 36e5))); // fix 5-hour bug
		date = formattedDate(dt);
		date = date.split(", ")[0];
		return date;
	}
	public static String date2month(String date) {
		Date dt = new Date(date);
		dt.setTime(dt.getTime() + (5 * ((int) 36e5))); // fix 5-hour bug
		date = formattedDate(dt);
		date = date.split(", ")[1].split(" ")[0];
		return date;
	}
	public static String timeGreet() {
		String greeting;
		int h = new Date().getHours() + 5; // fix 5-hour bug along the way
		if (h >= 20)
			greeting = "Good night";
		else if (h >= 16)
			greeting = "Good evening";
		else if (h >= 12)
			greeting = "Good afternoon";
		else if (h >= 0 && h <= 4)
			greeting = "Good new day";
		else
			greeting = "Good morning";
		return greeting;
	}
	public static String lastOfMonth(int m) {
		Date dt = new Date();
		KL dt2 = new KL();
		dt.setTime(dt.getTime() + (5 * ((int) 36e5))); // fix 5-hour bug for
		// better accuracy
		String result = "" + ("" + dt2.nthMonth(m - 1) + " "
							  + new Date(new Date().getYear(), m, 0).getDate());
		return result;
	}
	public static boolean isWeekend() {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int) 36e5))); // fix 5-hour bug
		return dt.getDay() % 6 == 0;
	}
	public static boolean isLeapYear() {
		return (1900 + new Date().getYear()) % 4 == 0;
	}
	public static int nextLeapYear() {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int) 36e5))); // fix 5-hour bug for
		// better accuracy
		int i = 0;
		if (dt.getYear() % 4 == 0)
			dt.setYear(dt.getYear() + 1); // ignore current year, if it's leap
		while (dt.getYear() % 4 != 0) {
			dt.setYear((dt.getYear()) + i);
			i++;
		}
		int result = (1900 + dt.getYear()); // comes with a bug fix
		return result;
	}
	public static String dateBefore(int n) {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int) 36e5))); // fix 5-hour bug
		dt.setDate(dt.getDate() - Math.abs(n));
		String date = formattedDate(dt);
		String parts[] = date.split(", ");
		date = parts[0] + ", " + parts[1] + ", " + parts[2];
		return date;
	}
	public static String dateAfter(int n) {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int) 36e5))); // fix 5-hour bug
		dt.setDate(dt.getDate() + Math.abs(n));
		String date = formattedDate(dt);
		String parts[] = date.split(", ");
		date = parts[0] + ", " + parts[1] + ", " + parts[2];
		return date;
	}
	public static String minsAgo(int n) {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int) 36e5))); // fix 5-hour bug
		dt.setTime(dt.getTime() - (n * (int) 60e3));
		String time = formattedDate(dt);
		time = time.split(", ")[3];
		return time;
	}
	public static String minsLater(int n) {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int) 36e5))); // fix 5-hour bug
		dt.setTime(dt.getTime() + (n * (int) 60e3));
		String time = formattedDate(dt);
		time = time.split(", ")[3];
		return time;
	}
	public static String hoursAgo(int n) {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int) 36e5))); // first fix the 5-hour
		// bug
		dt.setTime(dt.getTime() - (n * (int) 36e5));
		String time = formattedDate(dt);
		time = time.split(", ")[3];
		return time;
	}
	public static String hoursLater(int n) {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int) 36e5))); // first fix the 5-hour
		// bug
		dt.setTime(dt.getTime() + (n * (int) 36e5));
		String time = formattedDate(dt);
		time = time.split(", ")[3];
		return time;
	}
	public static String nthHour(int n) {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int) 36e5))); // fix 5-hour bug
		dt.setTime(
			dt.getTime() - (int) 36e5 * dt.getHours() + (n * (int) 36e5));
		String time = formattedDate(dt);
		time = time.split(", ")[3];
		return time;
	}
	public static String date() {
		return now();
	}
	// utilities
	public static void println(Object... args) {
		each(args, (arg, i) -> {
			if (arg instanceof Character) arg = "'" + arg + "'";
			if (arg instanceof Double) arg = setPrecision((double)arg);
			System.out.print(arg + " ");
		});
	}
	public static void print(Object... args) {
		// don't change this line
		println(args);
		System.out.print("\n");
	}
	public static void printf(String str, Object... args) {
		print(f(str, args));
	}
	public static void printf(int n) {
		print(f(n));
	}
	public static void printf(long n) {
		print(f(n));
	}
	public static void printf(float n) {
		print(f(n));
	}
	public static void printf(double n) {
		print(f(n));
	}
	// printing arrays
	public static void printArr(char[] arr) {
		print("[");
		for (char arg : arr)
			print("\t'" + arg + "', ");
		print("]");
	}
	public static void printArr(String[] arr) {
		print("[");
		for (String arg : arr)
			print("\t\"" + arg + "\", ");
		print("]");
	}
	public static void printArr(int[] arr) {
		print(Arrays.toString(arr));
	}
	public static void printArr(long[] arr) {
		print(Arrays.toString(arr));
	}
	public static void printArr(float[] arr) {
		print(Arrays.toString(arr));
	}
	public static void printArr(double[] arr) {
		print(Arrays.toString(arr));
	}
	public static void printArr(boolean[] arr) {
		print(Arrays.toString(arr));
	}
	public static void printArr(Object[] arr) {
		print(Arrays.toString(arr));
	}
	public static void printArr(StrArr arr) {
		print(arr.toString());
	}
	public static void printArr(IntArr arr) {
		print(arr.toString());
	}
	public static void printArr(LongArr arr) {
		print(arr.toString());
	}
	public static void printArr(FltArr arr) {
		print(arr.toString());
	}
	public static void printArr(DblArr arr) {
		print(arr.toString());
	}
	public static void printArr(BoolArr arr) {
		print(arr.toString());
	}
	public static void printArr(Obj_S o) {
		print(o.toString());
	}
	public static void printArr(Obj_I o) {
		print(o.toString());
	}
	public static void printArr(Obj_L o) {
		print(o.toString());
	}
	public static void printArr(Obj_F o) {
		print(o.toString());
	}
	public static void printArr(Obj_D o) {
		print(o.toString());
	}
	public static void printArr(Obj_B o) {
		print(o.toString());
	}
	public static void printArr(Tree_S t) {
		print(t.toString());
	}
	public static void printArr(Tree_I t) {
		print(t.toString());
	}
	public static void printArr(Tree_SL t) {
		print(t.toString());
	}
	public static void printArr(Tree_L t) {
		print(t.toString());
	}
	public static void printArr(Tree_SF t) {
		print(t.toString());
	}
	public static void printArr(Tree_F t) {
		print(t.toString());
	}
	public static void printArr(Tree_SD t) {
		print(t.toString());
	}
	public static void printArr(Tree_D t) {
		print(t.toString());
	}
	public static void printArr(Tree_SB t) {
		print(t.toString());
	}
	public static void printArr(Tree_B t) {
		print(t.toString());
	}
	public static void printAll(String arr[]) {
		printArr(arr);
	}
	public static void printAll(int arr[]) {
		printArr(arr);
	}
	public static void printAll(long arr[]) {
		printArr(arr);
	}
	public static void printAll(float arr[]) {
		printArr(arr);
	}
	public static void printAll(double arr[]) {
		printArr(arr);
	}
	public static void printAll(boolean arr[]) {
		printArr(arr);
	}
	public static void printAll(Object arr[]) {
		printArr(arr);
	}
	public static void printAll(StrArr arr) {
		printArr(arr);
	}
	public static void printAll(IntArr arr) {
		printArr(arr);
	}
	public static void printAll(LongArr arr) {
		printArr(arr);
	}
	public static void printAll(FltArr arr) {
		printArr(arr);
	}
	public static void printAll(DblArr arr) {
		printArr(arr);
	}
	public static void printAll(BoolArr arr) {
		printArr(arr);
	}
	public static void printAll(Obj_S o) {
		printArr(o);
	}
	public static void printAll(Obj_I o) {
		printArr(o);
	}
	public static void printAll(Obj_L o) {
		printArr(o);
	}
	public static void printAll(Obj_F o) {
		printArr(o);
	}
	public static void printAll(Obj_D o) {
		printArr(o);
	}
	public static void printAll(Obj_B o) {
		printArr(o);
	}
	public static void printAll(Tree_S t) {
		printArr(t);
	}
	public static void printAll(Tree_I t) {
		printArr(t);
	}
	public static void printAll(Tree_SL t) {
		printArr(t);
	}
	public static void printAll(Tree_L t) {
		printArr(t);
	}
	public static void printAll(Tree_SF t) {
		printArr(t);
	}
	public static void printAll(Tree_F t) {
		printArr(t);
	}
	public static void printAll(Tree_SD t) {
		printArr(t);
	}
	public static void printAll(Tree_D t) {
		printArr(t);
	}
	public static void printAll(Tree_SB t) {
		printArr(t);
	}
	public static void printAll(Tree_B t) {
		printArr(t);
	}
	public static void printEach(String arr[]) {
		printArr(arr);
	}
	public static void printEach(int arr[]) {
		printArr(arr);
	}
	public static void printEach(long arr[]) {
		printArr(arr);
	}
	public static void printEach(float arr[]) {
		printArr(arr);
	}
	public static void printEach(double arr[]) {
		printArr(arr);
	}
	public static void printEach(boolean arr[]) {
		printArr(arr);
	}
	public static void printEach(Object arr[]) {
		printArr(arr);
	}
	public static void printEach(StrArr arr) {
		printArr(arr);
	}
	public static void printEach(IntArr arr) {
		printArr(arr);
	}
	public static void printEach(LongArr arr) {
		printArr(arr);
	}
	public static void printEach(FltArr arr) {
		printArr(arr);
	}
	public static void printEach(DblArr arr) {
		printArr(arr);
	}
	public static void printEach(BoolArr arr) {
		printArr(arr);
	}
	public static void printEach(Obj_S o) {
		printArr(o);
	}
	public static void printEach(Obj_I o) {
		printArr(o);
	}
	public static void printEach(Obj_L o) {
		printArr(o);
	}
	public static void printEach(Obj_F o) {
		printArr(o);
	}
	public static void printEach(Obj_D o) {
		printArr(o);
	}
	public static void printEach(Obj_B o) {
		printArr(o);
	}
	public static void printEach(Tree_S t) {
		printArr(t);
	}
	public static void printEach(Tree_I t) {
		printArr(t);
	}
	public static void printEach(Tree_SL t) {
		printArr(t);
	}
	public static void printEach(Tree_L t) {
		printArr(t);
	}
	public static void printEach(Tree_SF t) {
		printArr(t);
	}
	public static void printEach(Tree_F t) {
		printArr(t);
	}
	public static void printEach(Tree_SD t) {
		printArr(t);
	}
	public static void printEach(Tree_D t) {
		printArr(t);
	}
	public static void printEach(Tree_SB t) {
		printArr(t);
	}
	public static void printEach(Tree_B t) {
		printArr(t);
	}
	// getting user input
	public static String ask(String s) {
		print(s);
		Scanner input = new Scanner(System.in);
		String x = input.nextLine();
		return x;
	}
	public static int askI(String s) {
		print(s);
		Scanner input = new Scanner(System.in);
		int x = input.nextInt();
		return x;
	}
	public static int askC(String s) {
		print(s);
		Scanner input = new Scanner(System.in);
		char x = input.next().charAt(0);
		return x;
	}
	public static long askL(String s) {
		print(s);
		Scanner input = new Scanner(System.in);
		long x = input.nextLong();
		return x;
	}
	public static float askF(String s) {
		print(s);
		Scanner input = new Scanner(System.in);
		float x = input.nextFloat();
		return x;
	}
	public static double askD(String s) {
		print(s);
		Scanner input = new Scanner(System.in);
		double x = input.nextDouble();
		return x;
	}
	public static int askInt(String s) {
		return askI(s);
	}
	public static int askChar(String s) {
		return askC(s);
	}
	public static long askLong(String s) {
		return askL(s);
	}
	public static float askFloat(String s) {
		return askF(s);
	}
	public static double askDouble(String s) {
		return askD(s);
	}
	public static void br(int n) {
		for (; n > 0; n--)
			print("\n");
	}
	public static void br() {
		br(1);
	}
	public static String String(String arg) {
		// if already a string, return as/is
		return arg;
	}
	public static String String(char arg) {
		String result = ("" + arg);
		return result;
	}
	public static String String(int arg) {
		String result = ("" + arg);
		return result;
	}
	public static String String(long arg) {
		String result = ("" + arg);
		return result;
	}
	public static String String(float arg) {
		String result = ("" + arg);
		return result;
	}
	public static String String(double arg) {
		String result = ("" + arg);
		return result;
	}
	public static String String(boolean arg) {
		String result = ("" + arg);
		return result;
	}
	public static String String(Object arg) {
		String result = ("" + arg);
		return result;
	}
	public static String String(String[] arr) {
		return Arrays.toString(arr);
	}
	public static String String(int[] arr) {
		return Arrays.toString(arr);
	}
	public static String String(char[] arr) {
		return Arrays.toString(arr);
	}
	public static String String(long[] arr) {
		return Arrays.toString(arr);
	}
	public static String String(float[] arr) {
		return Arrays.toString(arr);
	}
	public static String String(double[] arr) {
		return Arrays.toString(arr);
	}
	public static String String(boolean[] arr) {
		return Arrays.toString(arr);
	}
	public static String String(Object[] arr) {
		return Arrays.toString(arr);
	}
	public static String String(StrArr arr) {
		return arr.toString();
	}
	public static String String(IntArr arr) {
		return arr.toString();
	}
	public static String String(LongArr arr) {
		return arr.toString();
	}
	public static String String(FltArr arr) {
		return arr.toString();
	}
	public static String String(DblArr arr) {
		return arr.toString();
	}
	public static String String(BoolArr arr) {
		return arr.toString();
	}
	public static String String(Obj_S o) {
		return o.toString();
	}
	public static String String(Obj_I o) {
		return o.toString();
	}
	public static String String(Obj_L o) {
		return o.toString();
	}
	public static String String(Obj_F o) {
		return o.toString();
	}
	public static String String(Obj_D o) {
		return o.toString();
	}
	public static String String(Obj_B o) {
		return o.toString();
	}
	public static String String(Tree_S t) {
		return t.toString();
	}
	public static String String(Tree_I t) {
		return t.toString();
	}
	public static String String(Tree_SL t) {
		return t.toString();
	}
	public static String String(Tree_L t) {
		return t.toString();
	}
	public static String String(Tree_SF t) {
		return t.toString();
	}
	public static String String(Tree_F t) {
		return t.toString();
	}
	public static String String(Tree_SD t) {
		return t.toString();
	}
	public static String String(Tree_D t) {
		return t.toString();
	}
	public static String String(Tree_SB t) {
		return t.toString();
	}
	public static String String(Tree_B t) {
		return t.toString();
	}
	public static String Str(String arg) {
		return String(arg);
	}
	public static String Str(char arg) {
		return String(arg);
	}
	public static String Str(int arg) {
		return String(arg);
	}
	public static String Str(long arg) {
		return String(arg);
	}
	public static String Str(float arg) {
		return String(arg);
	}
	public static String Str(double arg) {
		return String(arg);
	}
	public static String Str(boolean arg) {
		return String(arg);
	}
	public static String Str(Object arg) {
		String result = ("" + arg);
		return result;
	}
	public static String Str(String[] arr) {
		return String(arr);
	}
	public static String Str(int[] arr) {
		return String(arr);
	}
	public static String Str(char[] arr) {
		return String(arr);
	}
	public static String Str(long[] arr) {
		return String(arr);
	}
	public static String Str(float[] arr) {
		return String(arr);
	}
	public static String Str(double[] arr) {
		return String(arr);
	}
	public static String Str(boolean[] arr) {
		return String(arr);
	}
	public static String Str(Object[] arg) {
		return String(arg);
	}
	public static String Str(StrArr arr) {
		return String(arr);
	}
	public static String Str(IntArr arr) {
		return String(arr);
	}
	public static String Str(LongArr arr) {
		return String(arr);
	}
	public static String Str(FltArr arr) {
		return String(arr);
	}
	public static String Str(DblArr arr) {
		return String(arr);
	}
	public static String Str(BoolArr arr) {
		return String(arr);
	}
	public static String Str(Obj_S o) {
		return String(o);
	}
	public static String Str(Obj_I o) {
		return String(o);
	}
	public static String Str(Obj_L o) {
		return String(o);
	}
	public static String Str(Obj_F o) {
		return String(o);
	}
	public static String Str(Obj_D o) {
		return String(o);
	}
	public static String Str(Obj_B o) {
		return String(o);
	}
	public static String Str(Tree_S t) {
		return String(t);
	}
	public static String Str(Tree_I t) {
		return String(t);
	}
	public static String Str(Tree_SL t) {
		return String(t);
	}
	public static String Str(Tree_L t) {
		return String(t);
	}
	public static String Str(Tree_SF t) {
		return String(t);
	}
	public static String Str(Tree_F t) {
		return String(t);
	}
	public static String Str(Tree_SD t) {
		return String(t);
	}
	public static String Str(Tree_D t) {
		return String(t);
	}
	public static String Str(Tree_SB t) {
		return String(t);
	}
	public static String Str(Tree_B t) {
		return String(t);
	}
	public static String concat(Object... args) {
		String result = "";
		for (var arg : args)
			result += ("" + arg);
		return result;
	}
	public static String cat(Object... args) {
		return concat(args);
	}
	public static String[] Arr(String... items) {
		int length = items.length;
		String[] arr = new String[length];
		for (int i = 0; i < length; i++)
			arr[i] = items[i];
		return arr;
	}
	public static int[] Arr(int... items) {
		int length = items.length;
		int[] arr = new int[length];
		for (int i = 0; i < length; i++)
			arr[i] = items[i];
		return arr;
	}
	public static long[] Arr(long... items) {
		int length = items.length;
		long[] arr = new long[length];
		for (int i = 0; i < length; i++)
			arr[i] = items[i];
		return arr;
	}
	public static float[] Arr(float... items) {
		int length = items.length;
		float[] arr = new float[length];
		for (int i = 0; i < length; i++)
			arr[i] = items[i];
		return arr;
	}
	public static double[] Arr(double... items) {
		int length = items.length;
		double[] arr = new double[length];
		for (int i = 0; i < length; i++)
			arr[i] = items[i];
		return arr;
	}
	public static boolean[] Arr(boolean... items) {
		int length = items.length;
		boolean[] arr = new boolean[length];
		for (int i = 0; i < length; i++)
			arr[i] = items[i];
		return arr;
	}
	public static Object[] Arr(Object... items) {
		int length = items.length;
		Object[] arr = new Object[length];
		for (int i = 0; i < length; i++)
			arr[i] = items[i];
		return arr;
	}
	public static String[] Arr(Obj_S o) {
		return o.array();
	}
	public static int[] Arr(Obj_I o) {
		return o.array();
	}
	public static long[] Arr(Obj_L o) {
		return o.array();
	}
	public static float[] Arr(Obj_F o) {
		return o.array();
	}
	public static double[] Arr(Obj_D o) {
		return o.array();
	}
	public static boolean[] Arr(Obj_B o) {
		return o.array();
	}
	public static int[] Arr(Tree_S t) {
		return t.array();
	}
	public static String[] Arr(Tree_I t) {
		return t.array();
	}
	public static long[] Arr(Tree_SL t) {
		return t.array();
	}
	public static long[] Arr(Tree_L t) {
		return t.array();
	}
	public static float[] Arr(Tree_SF t) {
		return t.array();
	}
	public static float[] Arr(Tree_F t) {
		return t.array();
	}
	public static double[] Arr(Tree_SD t) {
		return t.array();
	}
	public static double[] Arr(Tree_D t) {
		return t.array();
	}
	public static boolean[] Arr(Tree_SB t) {
		return t.array();
	}
	public static boolean[] Arr(Tree_B t) {
		return t.array();
	}
	public static char[] Chars(String str) {
		char[] result = str.toCharArray();
		return result;
	}
	public static char Char(String str) {
		char result = Chars(str)[0];
		return result;
	}
	public static char Char(int n) {
		char result = (char) n;
		if (!isAlpha(result))
			return '\0';
		return result;
	}
	public static char Char(String str, int n) {
		char result = Chars(str)[n];
		return result;
	}
	public static char nthCharOf(String str, int n) {
		if (n < 0 || n >= len(str))
			return '\0';
		char result = Chars(str)[n];
		return result;
	}
	public static char nthLastCharOf(String str, int n) {
		if (n <= 0 || n > len(str))
			return '\0';
		// tested, no edits please; in the case of reverse indexes, this IS the
		// way the
		// "if" condition is meant to be, i.e. the '=' sign stays
		char result = nthCharOf(str, len(str) - n);
		return result;
	}
	public static char secondLastCharOf(String str) {
		char result = nthLastCharOf(str, 2);
		return result;
	}
	public static char lastCharOf(String str) {
		char result = nthLastCharOf(str, 1);
		return result;
	}
	public static String[] split(String str) {
		String[] returnValue = str.split("");
		return returnValue;
	}
	public static String[] split(String str, String delimiting_str_or_regex) {
		String[] returnValue = str.split(delimiting_str_or_regex);
		return returnValue;
	}
	public static String[] splitIntoWords(String str) {
		String[] returnValue = split(str, "[^a-zA-Z'\\-]|\\-(?![a-zA-Z]{2,})");
		return returnValue;
	}
	public static String join(String[] stringedArray, String with) {
		String returnValue = String.join(with, stringedArray);
		return returnValue;
	}
	public static String join(int[] intArray, String with) {
		String[] midProcessedArray = new String[intArray.length];
		for (int i : range(intArray))
			midProcessedArray[i] = "" + intArray[i];
		String returnValue = String.join(with, midProcessedArray);
		return returnValue;
	}
	public static String join(long[] arr, String with) {
		String[] midProcessedArray = new String[arr.length];
		for (int i : range(arr))
			midProcessedArray[i] = "" + arr[i];
		String returnValue = String.join(with, midProcessedArray);
		return returnValue;
	}
	public static String join(float[] arr, String with) {
		String[] midProcessedArray = new String[arr.length];
		for (int i : range(arr))
			midProcessedArray[i] = "" + arr[i];
		String returnValue = String.join(with, midProcessedArray);
		return returnValue;
	}
	public static String join(double[] arr, String with) {
		String[] midProcessedArray = new String[arr.length];
		for (int i : range(arr))
			midProcessedArray[i] = "" + arr[i];
		String returnValue = String.join(with, midProcessedArray);
		return returnValue;
	}
	public static String join(boolean[] arr, String with) {
		String[] midProcessedArray = new String[arr.length];
		for (int i : range(arr))
			midProcessedArray[i] = "" + arr[i];
		String returnValue = String.join(with, midProcessedArray);
		return returnValue;
	}
	public static String join(String[] array) {
		String halfProcessed = join(array, ", ");
		String returnValue = replace(halfProcessed, "(?<=,)(\\s)(?=\\w+$)",
									 "$1and$1");
		// helps return a string in the American format of joining: a, b, and c
		// for
		// three items
		returnValue = sentCase(returnValue);
		return returnValue;
	}
	public static String join(int[] array) {
		String halfProcessed = join(array, ", ");
		String returnValue = replace(halfProcessed, "(?<=,)(\\s)(?=\\w+$)",
									 "$1and$1");
		// helps return a string in the American format of joining: a, b, and c
		// for
		// three items
		returnValue = sentCase(returnValue);
		return returnValue;
	}
	public static String join(long[] array) {
		String halfProcessed = join(array, ", ");
		String returnValue = replace(halfProcessed, "(?<=,)(\\s)(?=\\w+$)",
									 "$1and$1");
		// helps return a string in the American format of joining: a, b, and c
		// for
		// three items
		returnValue = sentCase(returnValue);
		return returnValue;
	}
	public static String join(float[] array) {
		String halfProcessed = join(array, ", ");
		String returnValue = replace(halfProcessed, "(?<=,)(\\s)(?=\\w+$)",
									 "$1and$1");
		// helps return a string in the American format of joining: a, b, and c
		// for
		// three items
		returnValue = sentCase(returnValue);
		return returnValue;
	}
	public static String join(double[] array) {
		String halfProcessed = join(array, ", ");
		String returnValue = replace(halfProcessed, "(?<=,)(\\s)(?=\\w+$)",
									 "$1and$1");
		// helps return a string in the American format of joining: a, b, and c
		// for
		// three items
		returnValue = sentCase(returnValue);
		return returnValue;
	}
	public static String join(boolean[] array) {
		String halfProcessed = join(array, ", ");
		String returnValue = replace(halfProcessed, "(?<=,)(\\s)(?=\\w+$)",
									 "$1and$1");
		// helps return a string in the American format of joining: a, b, and c
		// for
		// three items
		returnValue = sentCase(returnValue);
		return returnValue;
	}
	public static String join(StrArr stringedArray, String with) {
		String returnValue = String.join(with, stringedArray.array());
		return returnValue;
	}
	public static boolean eq(String x, String y) {
		y = y.replaceAll("^\\^|\\$$", "");
		return match(x, "^(" + y + ")$");
	}
	public static boolean eq(String x, String y, boolean strict) {
		if (!strict)
			return eq(x, y);
		else {
			y = y.replaceAll("^\\^|\\$$", "");
			return x.equals(y) || match(x, "^(" + y + ")$", true);
		}
	}
	public static boolean uneq(String x, String y) {
		return !eq(x, y);
	}
	public static boolean uneq(String x, String y, boolean strict) {
		return !eq(x, y, strict);
	}
	// numbers
	public static int Int(String arg, int base) {
		try {
			return Integer.parseInt(arg.replaceAll("(?<=\\d)\\.\\d+", ""), base);
		} catch (Exception err) {
			return 0;
		}
	}
	public static int Int(String arg) {
		return Int(arg, 10);
	}
	public static int Int(int n) {
		return n;
	}
	public static int Int(long n) {
		return (int) n;
	}
	public static int Int(float n) {
		return (int) n;
	}
	public static int Int(double n) {
		return (int) n;
	}
	public static int Int(Number n) {
		return n.intValue();
	}
	public static int Int(boolean b) {
		return b == true ? 1 : 0;
	}
	public static long Long(String arg) {
		return (long) Int(arg);
	}
	public static long Long(int n) {
		return (long) n;
	}
	public static long Long(long n) {
		return n;
	}
	public static long Long(float n) {
		return (long) n;
	}
	public static long Long(double n) {
		return (long) n;
	}
	public static long Long(Number n) {
		return n.longValue();
	}
	public static long Long(boolean b) {
		return b == true ? 1 : 0;
	}
	public static float Flt(String arg) {
		try {
			return Float.parseFloat(arg.replaceAll("[^\\-\\d\\.]", ""));
		} catch (Exception err) {
			return 0;
		}
	}
	public static float Flt(int n) {
		return (float) n;
	}
	public static float Flt(long n) {
		return (float) n;
	}
	public static float Flt(float n) {
		return n;
	}
	public static float Flt(double n) {
		return (float) n;
	}
	public static float Flt(Number n) {
		return n.floatValue();
	}
	public static float Flt(boolean b) {
		return b == true ? 1 : 0;
	}
	public static double Dbl(String arg) {
		try {
			return Double.parseDouble(arg.replaceAll("[^\\-\\d\\.]", ""));
		} catch (Exception err) {
			return 0;
		}
	}
	public static double Dbl(int arg) {
		return (double) arg;
	}
	public static double Dbl(long arg) {
		return (double) arg;
	}
	public static double Dbl(float arg) {
		return (double) arg;
	}
	public static double Dbl(double arg) {
		return arg;
	}
	public static double Dbl(Number n) {
		return n.doubleValue();
	}
	public static double Dbl(boolean b) {
		return b == true ? 1 : 0;
	}
	public static double Double(String arg) {
		return Dbl(arg);
	}
	public static double Double(int arg) {
		return Dbl(arg);
	}
	public static double Double(long arg) {
		return Dbl(arg);
	}
	public static double Double(float arg) {
		return Dbl(arg);
	}
	public static double Double(double arg) {
		return arg;
	}
	public static double Double(Number n) {
		return Dbl(n);
	}
	public static double Double(boolean arg) {
		return Dbl(arg);
	}
	public static double setPrecision(double n, int decimalPlaces) {
		if (not(n) || not(decimalPlaces) || isNeg(decimalPlaces)) return n;
		DecimalFormat formatter = new DecimalFormat("#." + repeat("0", decimalPlaces));
		return Dbl(formatter.format(n));
	}
	public static double setPrecision(double n) {
		return setPrecision(n, 2);
	}
	public static <T> java.util.List<T> List(T args) {
		return Arrays.asList(args);
	}
	public static <T> java.util.List<T> List(T... args) {
		return Arrays.asList(args);
	}
	// may or MAY NOT work, as working with generic types can be unpredictable,
	// as
	// learned from the mistakes in the past. So, here are some backup plans:
	public static java.util.List<String> List(String... arg) {
		return Arrays.asList(arg);
	}
	public static java.util.List<Integer> List(Integer... arg) {
		return Arrays.asList(arg);
	}
	public static java.util.List<Long> List(Long... arg) {
		return Arrays.asList(arg);
	}
	public static java.util.List<Float> List(Float... arg) {
		return Arrays.asList(arg);
	}
	public static java.util.List<Double> List(Double... arg) {
		return Arrays.asList(arg);
	}
	public static java.util.List<Boolean> List(Boolean... arg) {
		return Arrays.asList(arg);
	}
	public static boolean isIntLike(String s) {
		try {
			return Integer.parseInt(s) % 1 == 0;
		} catch (Exception err) {
			return false;
		}
	}
	public static boolean isFltLike(String s) {
		try {
			return Float.parseFloat(s) % 1 != 0;
		} catch (Exception err) {
			return false;
		}
	}
	public static boolean isDblLike(String s) {
		try {
			return Double.parseDouble(s) % 1 != 0;
		} catch (Exception err) {
			return false;
		}
	}
	public static boolean isAlpha(char c) {
		return c >= 65 && c <= 122;
	}
	public static boolean isPos(int n) {
		return n > 0;
	}
	public static boolean isPos(long n) {
		return n > 0;
	}
	public static boolean isPos(float n) {
		return n > 0;
	}
	public static boolean isPos(double n) {
		return n > 0;
	}
	public static boolean isNeg(int n) {
		return n < 0;
	}
	public static boolean isNeg(long n) {
		return n < 0;
	}
	public static boolean isNeg(float n) {
		return n < 0;
	}
	public static boolean isNeg(double n) {
		return n < 0;
	}
	public static int Pos(int n) {
		return Math.abs(n);
	}
	public static long Pos(long n) {
		return Math.abs(n);
	}
	public static float Pos(float n) {
		return Math.abs(n);
	}
	public static double Pos(double n) {
		return Math.abs(n);
	}
	public static int Neg(int n) {
		return -Pos(n);
	}
	public static long Neg(long n) {
		return -Pos(n);
	}
	public static float Neg(float n) {
		return -Pos(n);
	}
	public static double Neg(double n) {
		return -Pos(n);
	}
	public static boolean Neg(boolean b) {
		return not(b);
	}
	public static int reverse(int n) {
		return n > 0 ? Neg(n) : Pos(n);
	}
	public static long reverse(long n) {
		return n > 0 ? Neg(n) : Pos(n);
	}
	public static float reverse(float n) {
		return n > 0 ? Neg(n) : Pos(n);
	}
	public static double reverse(double n) {
		return n > 0 ? Neg(n) : Pos(n);
	}
	public static double sum(int... ns) {
		int acc = 0;
		for (int next = 0; next < ns.length; next++)
			acc += ns[next];
		return acc;
	}
	public static double sum(long... ns) {
		long acc = 0;
		for (int next = 0; next < ns.length; next++)
			acc += ns[next];
		return acc;
	}
	public static double sum(float... ns) {
		float acc = 0;
		for (int next = 0; next < ns.length; next++)
			acc += ns[next];
		return acc;
	}
	public static double sum(double... ns) {
		double acc = 0;
		for (int next = 0; next < ns.length; next++)
			acc += ns[next];
		return acc;
	}
	public static double sum(IntArr ns) {
		int acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc += ns.array()[next];
		return acc;
	}
	public static double sum(LongArr ns) {
		long acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc += ns.array()[next];
		return acc;
	}
	public static double sum(FltArr ns) {
		float acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc += ns.array()[next];
		return acc;
	}
	public static double sum(DblArr ns) {
		double acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc += ns.array()[next];
		return acc;
	}
	public static double sum(Tree_S ns) {
		double acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc += ns.array()[next];
		return acc;
	}
	public static double sum(Tree_SL ns) {
		double acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc += ns.array()[next];
		return acc;
	}
	public static double sum(Tree_L ns) {
		double acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc += ns.array()[next];
		return acc;
	}
	public static double sum(Tree_SF ns) {
		double acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc += ns.array()[next];
		return acc;
	}
	public static double sum(Tree_F ns) {
		double acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc += ns.array()[next];
		return acc;
	}
	public static double sum(Tree_SD ns) {
		double acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc += ns.array()[next];
		return acc;
	}
	public static double sum(Tree_D ns) {
		double acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc += ns.array()[next];
		return acc;
	}
	public static double difference(int... ns) {
		int acc = ns[0];
		for (int next = 1; next < ns.length; next++)
			acc -= ns[next];
		return acc;
	}
	public static double difference(long... ns) {
		long acc = ns[0];
		for (int next = 1; next < ns.length; next++)
			acc -= ns[next];
		return acc;
	}
	public static double difference(float... ns) {
		float acc = ns[0];
		for (int next = 1; next < ns.length; next++)
			acc -= ns[next];
		return acc;
	}
	public static double difference(double... ns) {
		double acc = ns[0];
		for (int next = 1; next < ns.length; next++)
			acc -= ns[next];
		return acc;
	}
	public static double difference(IntArr ns) {
		int acc = ns.i(0);
		for (int next = 1; next < ns.length(); next++)
			acc -= ns.array()[next];
		return acc;
	}
	public static double difference(LongArr ns) {
		long acc = ns.i(0);
		for (int next = 1; next < ns.length(); next++)
			acc -= ns.array()[next];
		return acc;
	}
	public static double difference(FltArr ns) {
		float acc = ns.i(0);
		for (int next = 1; next < ns.length(); next++)
			acc -= ns.array()[next];
		return acc;
	}
	public static double difference(DblArr ns) {
		double acc = ns.i(0);
		for (int next = 1; next < ns.length(); next++)
			acc -= ns.array()[next];
		return acc;
	}
	public static double difference(Tree_S ns) {
		double acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc -= ns.array()[next];
		return acc;
	}
	public static double difference(Tree_SL ns) {
		double acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc -= ns.array()[next];
		return acc;
	}
	public static double difference(Tree_L ns) {
		double acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc -= ns.array()[next];
		return acc;
	}
	public static double difference(Tree_SF ns) {
		double acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc -= ns.array()[next];
		return acc;
	}
	public static double difference(Tree_F ns) {
		double acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc -= ns.array()[next];
		return acc;
	}
	public static double difference(Tree_SD ns) {
		double acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc -= ns.array()[next];
		return acc;
	}
	public static double difference(Tree_D ns) {
		double acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc -= ns.array()[next];
		return acc;
	}
	public static double product(int... ns) {
		int acc = ns[0];
		for (int next = 1; next < ns.length; next++)
			acc *= ns[next];
		return acc;
	}
	public static double product(long... ns) {
		long acc = ns[0];
		for (int next = 1; next < ns.length; next++)
			acc *= ns[next];
		return acc;
	}
	public static double product(float... ns) {
		float acc = ns[0];
		for (int next = 1; next < ns.length; next++)
			acc *= ns[next];
		return acc;
	}
	public static double product(double... ns) {
		double acc = ns[0];
		for (int next = 1; next < ns.length; next++)
			acc *= ns[next];
		return acc;
	}
	public static double product(IntArr ns) {
		int acc = ns.i(0);
		for (int next = 1; next < ns.length(); next++)
			acc *= ns.array()[next];
		return acc;
	}
	public static double product(LongArr ns) {
		long acc = ns.i(0);
		for (int next = 1; next < ns.length(); next++)
			acc *= ns.array()[next];
		return acc;
	}
	public static double product(FltArr ns) {
		float acc = ns.i(0);
		for (int next = 1; next < ns.length(); next++)
			acc *= ns.array()[next];
		return acc;
	}
	public static double product(DblArr ns) {
		double acc = ns.i(0);
		for (int next = 1; next < ns.length(); next++)
			acc *= ns.array()[next];
		return acc;
	}
	public static double product(Tree_S ns) {
		double acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc *= ns.array()[next];
		return acc;
	}
	public static double product(Tree_SL ns) {
		double acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc *= ns.array()[next];
		return acc;
	}
	public static double product(Tree_L ns) {
		double acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc *= ns.array()[next];
		return acc;
	}
	public static double product(Tree_SF ns) {
		double acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc *= ns.array()[next];
		return acc;
	}
	public static double product(Tree_F ns) {
		double acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc *= ns.array()[next];
		return acc;
	}
	public static double product(Tree_SD ns) {
		double acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc *= ns.array()[next];
		return acc;
	}
	public static double product(Tree_D ns) {
		double acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc *= ns.array()[next];
		return acc;
	}
	public static double quotient(int... ns) {
		int acc = ns[0];
		for (int next = 1; next < ns.length; next++)
			acc /= ns[next];
		return acc;
	}
	public static double quotient(long... ns) {
		long acc = ns[0];
		for (int next = 1; next < ns.length; next++)
			acc /= ns[next];
		return acc;
	}
	public static double quotient(float... ns) {
		float acc = ns[0];
		for (int next = 1; next < ns.length; next++)
			acc /= ns[next];
		return acc;
	}
	public static double quotient(double... ns) {
		double acc = ns[0];
		for (int next = 1; next < ns.length; next++)
			acc /= ns[next];
		return acc;
	}
	public static double quotient(IntArr ns) {
		int acc = ns.i(0);
		for (int next = 1; next < ns.length(); next++)
			acc /= ns.array()[next];
		return acc;
	}
	public static double quotient(LongArr ns) {
		long acc = ns.i(0);
		for (int next = 1; next < ns.length(); next++)
			acc /= ns.array()[next];
		return acc;
	}
	public static double quotient(FltArr ns) {
		float acc = ns.i(0);
		for (int next = 1; next < ns.length(); next++)
			acc /= ns.array()[next];
		return acc;
	}
	public static double quotient(DblArr ns) {
		double acc = ns.i(0);
		for (int next = 1; next < ns.length(); next++)
			acc /= ns.array()[next];
		return acc;
	}
	public static double quotient(Tree_S ns) {
		double acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc /= ns.array()[next];
		return acc;
	}
	public static double quotient(Tree_SL ns) {
		double acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc /= ns.array()[next];
		return acc;
	}
	public static double quotient(Tree_L ns) {
		double acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc /= ns.array()[next];
		return acc;
	}
	public static double quotient(Tree_SF ns) {
		double acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc /= ns.array()[next];
		return acc;
	}
	public static double quotient(Tree_F ns) {
		double acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc /= ns.array()[next];
		return acc;
	}
	public static double quotient(Tree_SD ns) {
		double acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc /= ns.array()[next];
		return acc;
	}
	public static double quotient(Tree_D ns) {
		double acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc /= ns.array()[next];
		return acc;
	}
	public static int pow(int n, int power) {
		return (int) Math.pow(n, power);
	}
	public static double sq(double n) {
		return n * n;
	}
	public static double sqrt(double n) {
		return Math.sqrt(n);
	}
	public static double cb(double n) {
		return sq(n) * n;
	}
	public static double cbrt(double n) {
		return Math.cbrt(n);
	}
	public static double area(double w, double h) {
		return w * h;
	}
	public static double tria(double w, double h) {
		return .5 * area(w, h);
	}
	public static int min(int... nums) {
		IntSummaryStatistics stat = Arrays.stream(nums).summaryStatistics();
		return stat.getMin();
	}
	public static long min(long... nums) {
		LongSummaryStatistics stat = Arrays.stream(nums).summaryStatistics();
		return stat.getMin();
	}
	public static double min(double... nums) {
		DoubleSummaryStatistics stat = Arrays.stream(nums).summaryStatistics();
		return stat.getMin();
	}
	public static int min(IntArr nums) {
		IntSummaryStatistics stat = Arrays.stream(nums.array())
									.summaryStatistics();
		return stat.getMin();
	}
	public static long min(LongArr nums) {
		LongSummaryStatistics stat = Arrays.stream(nums.array())
									 .summaryStatistics();
		return stat.getMin();
	}
	public static double min(DblArr nums) {
		DoubleSummaryStatistics stat = Arrays.stream(nums.array())
									   .summaryStatistics();
		return stat.getMin();
	}
	public static int min(Tree_S nums) {
		IntSummaryStatistics stat = Arrays.stream(nums.array())
									.summaryStatistics();
		return stat.getMin();
	}
	public static long min(Tree_SL nums) {
		LongSummaryStatistics stat = Arrays.stream(nums.array())
									 .summaryStatistics();
		return stat.getMin();
	}
	public static long min(Tree_L nums) {
		LongSummaryStatistics stat = Arrays.stream(nums.array())
									 .summaryStatistics();
		return stat.getMin();
	}
	public static double min(Tree_SD nums) {
		DoubleSummaryStatistics stat = Arrays.stream(nums.array())
									   .summaryStatistics();
		return stat.getMin();
	}
	public static double min(Tree_D nums) {
		DoubleSummaryStatistics stat = Arrays.stream(nums.array())
									   .summaryStatistics();
		return stat.getMin();
	}
	public static int max(int... nums) {
		IntSummaryStatistics stat = Arrays.stream(nums).summaryStatistics();
		return stat.getMax();
	}
	public static long max(long... nums) {
		LongSummaryStatistics stat = Arrays.stream(nums).summaryStatistics();
		return stat.getMax();
	}
	public static double max(double... nums) {
		DoubleSummaryStatistics stat = Arrays.stream(nums).summaryStatistics();
		return stat.getMax();
	}
	public static int max(IntArr nums) {
		IntSummaryStatistics stat = Arrays.stream(nums.array())
									.summaryStatistics();
		return stat.getMax();
	}
	public static long max(LongArr nums) {
		LongSummaryStatistics stat = Arrays.stream(nums.array())
									 .summaryStatistics();
		return stat.getMax();
	}
	public static double max(DblArr nums) {
		DoubleSummaryStatistics stat = Arrays.stream(nums.array())
									   .summaryStatistics();
		return stat.getMax();
	}
	public static int max(Tree_S nums) {
		IntSummaryStatistics stat = Arrays.stream(nums.array())
									.summaryStatistics();
		return stat.getMax();
	}
	public static long max(Tree_SL nums) {
		LongSummaryStatistics stat = Arrays.stream(nums.array())
									 .summaryStatistics();
		return stat.getMax();
	}
	public static long max(Tree_L nums) {
		LongSummaryStatistics stat = Arrays.stream(nums.array())
									 .summaryStatistics();
		return stat.getMax();
	}
	public static double max(Tree_SD nums) {
		DoubleSummaryStatistics stat = Arrays.stream(nums.array())
									   .summaryStatistics();
		return stat.getMax();
	}
	public static double max(Tree_D nums) {
		DoubleSummaryStatistics stat = Arrays.stream(nums.array())
									   .summaryStatistics();
		return stat.getMax();
	}
	public static double mod(double n1, double n2) {
		if (n2 > n1) {
			// swap
			n1 += n2;
			n2 = n1 - n2;
			n1 -= n2;
		}
		return Math.abs(n1 % n2);
	}
	public static boolean isPerfectMod(double n1, double n2) {
		return mod(n1, n2) == 0;
	}
	public static int[] divisorsOf(int n) {
		IntArr result = new IntArr();
		for (int i = 2; i < n; i++) {
			if (isPerfectMod(n, i))
				result.add(i);
		}
		return result.array();
	}
	public static long[] divisorsOf(long n) {
		LongArr result = new LongArr();
		for (long i = 2; i < n; i++) {
			if (isPerfectMod(n, i))
				result.add(i);
		}
		return result.array();
	}
	public static double[] divisorsOf(double n) {
		DblArr result = new DblArr();
		for (double i = 2; i < n; i++) {
			if (isPerfectMod(n, i))
				result.add(i);
		}
		return result.array();
	}
	public static boolean isDivisorOf(int n1, int n2) {
		return isPerfectMod(n1, n2);
	}
	public static boolean isDivisorOf(long n1, long n2) {
		return isPerfectMod(n1, n2);
	}
	public static boolean isDivisorOf(double n1, double n2) {
		return isPerfectMod(n1, n2);
	}
	public static boolean isEven(int n) {
		return isPerfectMod(n, 2);
	}
	public static boolean isEven(long n) {
		return isPerfectMod(n, 2);
	}
	public static boolean isOdd(int n) {
		return !isPerfectMod(n, 2);
	}
	public static boolean isOdd(long n) {
		return !isPerfectMod(n, 2);
	}
	public static boolean isPrime(double n) {
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
	public static String th(long n) {
		String result = Str(n);
		int size = len(result);
		char seclast_char = size - 2 >= 0 ? result.charAt(size - 2) : '\0';
		char last_char = size - 1 >= 0 ? result.charAt(size - 1) : '\0';
		String last_two = Str(seclast_char) + Str(last_char);
		if (n > 14 && n < 111) {
			switch (last_char) {
			case '1' :
				result += "st";
				break;
			case '2' :
				result += "nd";
				break;
			case '3' :
				result += "rd";
				break;
			default :
				result += "th";
			}
		} else {
			if (eq(last_two, "11") || eq(last_two, "12") || eq(last_two, "13"))
				result += "th";
			else {
				switch (last_char) {
				case '1' :
					result += "st";
					break;
				case '2' :
					result += "nd";
					break;
				case '3' :
					result += "rd";
					break;
				default :
					result += "th";
				}
			}
		}
		return result;
	}
	// let's set up some currency variables
	public static double zr = 1e3, lc = 1e5, cr = 1e7, ar = 1e9, kh = 1e11;
	public static double K = 1e3, M = 1e6, B = 1e9, T = 1e12, qd = 1e15,
						 qt = 1e18, sx = 1e21, sp = 1e24, oc = 1e27, nn = 1e30, dc = 1e33;
	public static String fpkr(int amount) {
		double floats = amount % 1;
		long amountFix = Long(amount - floats);
		StringBuilder stringBuilder = new StringBuilder();
		char[] amountArray = Str(amountFix).toCharArray();
		int a = 0, b = 0;
		for (int i = amountArray.length - 1; i >= 0; i--) {
			if (a < 3) {
				stringBuilder.append(amountArray[i]);
				a++;
			} else if (b < 2) {
				if (b == 0) {
					stringBuilder.append(",");
					stringBuilder.append(amountArray[i]);
					b++;
				} else {
					stringBuilder.append(amountArray[i]);
					b = 0;
				}
			}
		}
		return replace(
				   stringBuilder.reverse().toString() + "."
				   + sliceToAfter(Str(floats), "."),
				   "(?<=\\.\\d{2})\\d+", "");
	}
	public static String fpkr(long amount) {
		double floats = amount % 1;
		long amountFix = Long(amount - floats);
		StringBuilder stringBuilder = new StringBuilder();
		char[] amountArray = Str(amountFix).toCharArray();
		int a = 0, b = 0;
		for (int i = amountArray.length - 1; i >= 0; i--) {
			if (a < 3) {
				stringBuilder.append(amountArray[i]);
				a++;
			} else if (b < 2) {
				if (b == 0) {
					stringBuilder.append(",");
					stringBuilder.append(amountArray[i]);
					b++;
				} else {
					stringBuilder.append(amountArray[i]);
					b = 0;
				}
			}
		}
		return replace(
				   stringBuilder.reverse().toString() + "."
				   + sliceToAfter(Str(floats), "."),
				   "(?<=\\.\\d{2})\\d+", "");
	}
	public static String fpkr(float amount) {
		double floats = amount % 1;
		long amountFix = Long(amount - floats);
		StringBuilder stringBuilder = new StringBuilder();
		char[] amountArray = Str(amountFix).toCharArray();
		int a = 0, b = 0;
		for (int i = amountArray.length - 1; i >= 0; i--) {
			if (a < 3) {
				stringBuilder.append(amountArray[i]);
				a++;
			} else if (b < 2) {
				if (b == 0) {
					stringBuilder.append(",");
					stringBuilder.append(amountArray[i]);
					b++;
				} else {
					stringBuilder.append(amountArray[i]);
					b = 0;
				}
			}
		}
		return replace(
				   stringBuilder.reverse().toString() + "."
				   + sliceToAfter(Str(floats), "."),
				   "(?<=\\.\\d{2})\\d+", "");
	}
	public static String fpkr(double amount) {
		double floats = amount % 1;
		long amountFix = Long(amount - floats);
		StringBuilder stringBuilder = new StringBuilder();
		char[] amountArray = Str(amountFix).toCharArray();
		int a = 0, b = 0;
		for (int i = amountArray.length - 1; i >= 0; i--) {
			if (a < 3) {
				stringBuilder.append(amountArray[i]);
				a++;
			} else if (b < 2) {
				if (b == 0) {
					stringBuilder.append(",");
					stringBuilder.append(amountArray[i]);
					b++;
				} else {
					stringBuilder.append(amountArray[i]);
					b = 0;
				}
			}
		}
		return replace(
				   stringBuilder.reverse().toString() + "."
				   + sliceToAfter(Str(floats), "."),
				   "(?<=\\.\\d{2})\\d+", "");
	}
	public static String fus(int n) {
		return NumberFormat
			   .getCurrencyInstance(new Locale.Builder().setLanguage("en")
									.setRegion("US").build())
			   .format(n).replaceAll("[^\\d\\,\\.]", "");
	}
	public static String fus(long n) {
		return NumberFormat
			   .getCurrencyInstance(new Locale.Builder().setLanguage("en")
									.setRegion("US").build())
			   .format(n).replaceAll("[^\\d\\,\\.]", "");
	}
	public static String fus(float n) {
		return NumberFormat
			   .getCurrencyInstance(new Locale.Builder().setLanguage("en")
									.setRegion("US").build())
			   .format(n).replaceAll("[^\\d\\,\\.]", "");
	}
	public static String fus(double n) {
		return NumberFormat
			   .getCurrencyInstance(new Locale.Builder().setLanguage("en")
									.setRegion("US").build())
			   .format(n).replaceAll("[^\\d\\,\\.]", "");
	}
	public static String f(int n) {
		return fpkr(n);
	}
	public static String f(long n) {
		return fpkr(n);
	}
	public static String f(float n) {
		return fpkr(n);
	}
	public static String f(double n) {
		return fpkr(n);
	}
	public static <T> String f(String s, T... args) {
		if (not(s) || args.length == 0) return s;
		s = s.replaceAll("%f", "%.2f");
		return String.format(s, args);
	}
	public static String pkr(int n) {
		String formattedN = fpkr(n);
		String result = "Rs. " + formattedN;
		return result;
	}
	public static String pkr(long n) {
		String formattedN = fpkr(n);
		String result = "Rs. " + formattedN;
		return result;
	}
	public static String pkr(float n) {
		String formattedN = fpkr(n);
		String result = "Rs. " + formattedN;
		return result;
	}
	public static String pkr(double n) {
		String formattedN = fpkr(n);
		String result = "Rs. " + formattedN;
		return result;
	}
	public static String usd(int n) {
		String formattedN = fus(n);
		String result = "US$ " + formattedN;
		return result;
	}
	public static String usd(long n) {
		String formattedN = fus(n);
		String result = "US$ " + formattedN;
		return result;
	}
	public static String usd(float n) {
		String formattedN = fus(n);
		String result = "US$ " + formattedN;
		return result;
	}
	public static String usd(double n) {
		String formattedN = fus(n);
		String result = "US$ " + formattedN;
		return result;
	}
	public static String curr(int n, String locale) {
		String formattedN = fus(n);
		if (startsWith(locale, "pk|rs"))
			return pkr(n);
		else if (startsWith(locale, "us"))
			return usd(n);
		else if (len(locale) >= 1 && len(locale) <= 4)
			return trim(titleCase(locale)) + " " + formattedN;
		return formattedN;
	}
	public static String curr(long n, String locale) {
		String formattedN = fus(n);
		if (startsWith(locale, "pk|rs"))
			return pkr(n);
		else if (startsWith(locale, "us"))
			return usd(n);
		else if (len(locale) >= 1 && len(locale) < 4)
			return trim(titleCase(locale)) + " " + formattedN;
		return formattedN;
	}
	public static String curr(float n, String locale) {
		String formattedN = fus(n);
		if (startsWith(locale, "pk|rs"))
			return pkr(n);
		else if (startsWith(locale, "us"))
			return usd(n);
		else if (len(locale) >= 1 && len(locale) < 4)
			return trim(titleCase(locale)) + " " + formattedN;
		return formattedN;
	}
	public static String curr(double n, String locale) {
		String formattedN = fus(n);
		if (startsWith(locale, "pk|rs"))
			return pkr(n);
		else if (startsWith(locale, "us"))
			return usd(n);
		else if (len(locale) >= 1 && len(locale) < 4)
			return trim(titleCase(locale)) + " " + formattedN;
		return formattedN;
	}
	public static String pksuffix(int n) {
		n -= n % 1;
		String formattedN = fpkr(n);
		String[] parts = split(formattedN, ",");
		int size = len(parts);
		if (n < 800 || n > 99 * kh)
			return formattedN;
		String result = "";
		switch (size) {
		case 1 :
		case 2 :
			result = Str(n / zr) + "zr";
			break;
		case 3 :
			result = Str(n / lc) + "lc";
			break;
		case 4 :
			result = Str(n / cr) + "cr";
			break;
		case 5 :
			result = Str(n / ar) + "ar";
			break;
		case 6 :
			result = Str(n / kh) + "kh";
			break;
		}
		return result;
	}
	public static String pksuffix(long n) {
		n -= n % 1;
		String formattedN = fpkr(n);
		String[] parts = split(formattedN, ",");
		int size = len(parts);
		if (n < 800 || n > 99 * kh)
			return formattedN;
		String result = "";
		switch (size) {
		case 1 :
		case 2 :
			result = Str(n / zr) + "zr";
			break;
		case 3 :
			result = Str(n / lc) + "lc";
			break;
		case 4 :
			result = Str(n / cr) + "cr";
			break;
		case 5 :
			result = Str(n / ar) + "ar";
			break;
		case 6 :
			result = Str(n / kh) + "kh";
			break;
		}
		return result;
	}
	public static String pksuffix(float n) {
		n -= n % 1;
		String formattedN = fpkr(n);
		String[] parts = split(formattedN, ",");
		int size = len(parts);
		if (n < 800 || n > 99 * kh)
			return formattedN;
		String result = "";
		switch (size) {
		case 1 :
		case 2 :
			result = Str(n / zr) + "zr";
			break;
		case 3 :
			result = Str(n / lc) + "lc";
			break;
		case 4 :
			result = Str(n / cr) + "cr";
			break;
		case 5 :
			result = Str(n / ar) + "ar";
			break;
		case 6 :
			result = Str(n / kh) + "kh";
			break;
		}
		return result;
	}
	public static String pksuffix(double n) {
		n -= n % 1;
		String formattedN = fpkr(n);
		String[] parts = split(formattedN, ",");
		int size = len(parts);
		if (n < 800 || n > 99 * kh)
			return formattedN;
		String result = "";
		switch (size) {
		case 1 :
		case 2 :
			result = Str(n / zr) + "zr";
			break;
		case 3 :
			result = Str(n / lc) + "lc";
			break;
		case 4 :
			result = Str(n / cr) + "cr";
			break;
		case 5 :
			result = Str(n / ar) + "ar";
			break;
		case 6 :
			result = Str(n / kh) + "kh";
			break;
		}
		return result;
	}
	public static String ussuffix(int n) {
		n -= n % 1;
		String formattedN = fus(n);
		String[] parts = split(formattedN, ",");
		int size = len(parts);
		if (n < 800 || n > 99 * dc)
			return formattedN;
		String result = "";
		switch (size) {
		case 1 :
		case 2 :
			result = Str(n / K) + "k";
			break;
		case 3 :
			result = Str(n / M) + "M";
			break;
		case 4 :
			result = Str(n / B) + "B";
			break;
		case 5 :
			result = Str(n / T) + "T";
			break;
		case 6 :
			result = Str(n / qd) + "qd";
			break;
		case 7 :
			result = Str(n / qt) + "qt";
			break;
		case 8 :
			result = Str(n / sx) + "sx";
			break;
		case 9 :
			result = Str(n / sp) + "sp";
			break;
		case 10 :
			result = Str(n / oc) + "oc";
			break;
		case 11 :
			result = Str(n / nn) + "nn";
			break;
		case 12 :
			result = Str(n / dc) + "dc";
			break;
		}
		return result;
	}
	public static String ussuffix(long n) {
		n -= n % 1;
		String formattedN = fus(n);
		String[] parts = split(formattedN, ",");
		int size = len(parts);
		if (n < 800 || n > 99 * dc)
			return formattedN;
		String result = "";
		switch (size) {
		case 1 :
		case 2 :
			result = Str(n / K) + "k";
			break;
		case 3 :
			result = Str(n / M) + "M";
			break;
		case 4 :
			result = Str(n / B) + "B";
			break;
		case 5 :
			result = Str(n / T) + "T";
			break;
		case 6 :
			result = Str(n / qd) + "qd";
			break;
		case 7 :
			result = Str(n / qt) + "qt";
			break;
		case 8 :
			result = Str(n / sx) + "sx";
			break;
		case 9 :
			result = Str(n / sp) + "sp";
			break;
		case 10 :
			result = Str(n / oc) + "oc";
			break;
		case 11 :
			result = Str(n / nn) + "nn";
			break;
		case 12 :
			result = Str(n / dc) + "dc";
			break;
		}
		return result;
	}
	public static String ussuffix(float n) {
		n -= n % 1;
		String formattedN = fus(n);
		String[] parts = split(formattedN, ",");
		int size = len(parts);
		if (n < 800 || n > 99 * dc)
			return formattedN;
		String result = "";
		switch (size) {
		case 1 :
		case 2 :
			result = Str(n / K) + "k";
			break;
		case 3 :
			result = Str(n / M) + "M";
			break;
		case 4 :
			result = Str(n / B) + "B";
			break;
		case 5 :
			result = Str(n / T) + "T";
			break;
		case 6 :
			result = Str(n / qd) + "qd";
			break;
		case 7 :
			result = Str(n / qt) + "qt";
			break;
		case 8 :
			result = Str(n / sx) + "sx";
			break;
		case 9 :
			result = Str(n / sp) + "sp";
			break;
		case 10 :
			result = Str(n / oc) + "oc";
			break;
		case 11 :
			result = Str(n / nn) + "nn";
			break;
		case 12 :
			result = Str(n / dc) + "dc";
			break;
		}
		return result;
	}
	public static String ussuffix(double n) {
		n -= n % 1;
		String formattedN = fus(n);
		String[] parts = split(formattedN, ",");
		int size = len(parts);
		if (n < 800 || n > 99 * dc)
			return formattedN;
		String result = "";
		switch (size) {
		case 1 :
		case 2 :
			result = Str(n / K) + "k";
			break;
		case 3 :
			result = Str(n / M) + "M";
			break;
		case 4 :
			result = Str(n / B) + "B";
			break;
		case 5 :
			result = Str(n / T) + "T";
			break;
		case 6 :
			result = Str(n / qd) + "qd";
			break;
		case 7 :
			result = Str(n / qt) + "qt";
			break;
		case 8 :
			result = Str(n / sx) + "sx";
			break;
		case 9 :
			result = Str(n / sp) + "sp";
			break;
		case 10 :
			result = Str(n / oc) + "oc";
			break;
		case 11 :
			result = Str(n / nn) + "nn";
			break;
		case 12 :
			result = Str(n / dc) + "dc";
			break;
		}
		return result;
	}
	public static String toRoman(int n) {
		Tree_I tree = new Tree_I();
		tree.add(1, "I").add(4, "IV").add(5, "V").add(9, "IX").add(10, "X")
		.add(40, "XL").add(50, "L").add(90, "XC").add(100, "C")
		.add(400, "CD").add(500, "D").add(900, "CM").add(1000, "M")
		.add(4000, "M_V").add(9000, "I_X").add(10000, "_X");
		int x = tree.floorKey(n);
		if (n != x)
			return tree.get(x) + toRoman(n - x);
		return tree.get(n);
	}
	public static int fibonacci(int n) {
		if (n < 2)
			return n;
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
	public static int[] fibonacciSequence(int n) {
		IntArr result = new IntArr();
		for (int i : range(n))
			result.push(fibonacci(i + 1));
		return result.array();
	}
	public static double percentify(double n1, double n2) {
		if (n1 < n2)
			return Math.round(n1 / n2 * 100.0) / 100.0;
		else
			return Math.round(n1 * (n2 * .01) * 100.0) / 100.0;
	}
	final static double infinity = Double.POSITIVE_INFINITY;
	public static boolean isNull(Object o) {
		return o == null;
	}
	public static boolean isNull(Object... objs) {
		int count = 0;
		for (Object o : objs) {
			if (o == null)
				count++;
		}
		return count > 0;
	}
	public static boolean isInfinity(double n) {
		return n == infinity || n == Double.NEGATIVE_INFINITY || isNull(n);
	}
	public static boolean isNl(Object o) {
		return isNull(o);
	}
	public static boolean isInf(double n) {
		return isInfinity(n);
	}
	public static boolean isnl(Object o) {
		return isNull(o);
	}
	public static boolean isinf(double n) {
		return isInfinity(n);
	}
	public static int round(int n) {
		return n;
	}
	public static long round(long n) {
		return n;
	}
	public static int round(float n) {
		return (int) Math.round(n);
	}
	public static int round(double n) {
		return (int) Math.round(n);
	}
	public static double celciusToFarhenheit(double c) {
		return (double) round(1.8 * c + 32);
	}
	public static double farhenheitToCelcius(double f) {
		return (double) round(((f - 32) * 5) / 9);
	}
	public static double cToF(double c) {
		return celciusToFarhenheit(c);
	}
	public static double fToC(double f) {
		return farhenheitToCelcius(f);
	}
	public static boolean eq(char x, char y) {
		return x == y;
	}
	public static boolean eq(int x, int y) {
		return x == y;
	}
	public static boolean eq(long x, long y) {
		return x == y;
	}
	public static boolean eq(float x, float y) {
		return x == y;
	}
	public static boolean eq(double x, double y) {
		return x == y;
	}
	public static boolean eq(boolean x, boolean y) {
		return x == y;
	}
	public static boolean eq(Object x, Object y) {
		return x.equals(y);
	}
	public static boolean eq(String[] x, String[] y) {
		return Arrays.equals(x, y);
	}
	public static boolean eq(int[] x, int[] y) {
		return Arrays.equals(x, y);
	}
	public static boolean eq(long[] x, long[] y) {
		return Arrays.equals(x, y);
	}
	public static boolean eq(float[] x, float[] y) {
		return Arrays.equals(x, y);
	}
	public static boolean eq(double[] x, double[] y) {
		return Arrays.equals(x, y);
	}
	public static boolean eq(boolean[] x, boolean[] y) {
		return Arrays.equals(x, y);
	}
	public static boolean eq(Object[] x, Object[] y) {
		return Arrays.equals(x, y);
	}
	public static boolean eq(StrArr x, StrArr y) {
		return x.eq(y);
	}
	public static boolean eq(IntArr x, IntArr y) {
		return x.eq(y);
	}
	public static boolean eq(LongArr x, LongArr y) {
		return x.eq(y);
	}
	public static boolean eq(FltArr x, FltArr y) {
		return x.eq(y);
	}
	public static boolean eq(DblArr x, DblArr y) {
		return x.eq(y);
	}
	public static boolean eq(BoolArr x, BoolArr y) {
		return x.eq(y);
	}
	public static boolean eq(Tree_S x, Tree_S y) {
		return x.equals(y);
	}
	public static boolean eq(Tree_I x, Tree_I y) {
		return x.equals(y);
	}
	public static boolean eq(Tree_SL x, Tree_SL y) {
		return x.equals(y);
	}
	public static boolean eq(Tree_L x, Tree_L y) {
		return x.equals(y);
	}
	public static boolean eq(Tree_SF x, Tree_SF y) {
		return x.equals(y);
	}
	public static boolean eq(Tree_F x, Tree_F y) {
		return x.equals(y);
	}
	public static boolean eq(Tree_SD x, Tree_SD y) {
		return x.equals(y);
	}
	public static boolean eq(Tree_D x, Tree_D y) {
		return x.equals(y);
	}
	public static boolean eq(Tree_SB x, Tree_SB y) {
		return x.equals(y);
	}
	public static boolean eq(Tree_B x, Tree_B y) {
		return x.equals(y);
	}
	public static boolean uneq(char x, char y) {
		return !eq(x, y);
	}
	public static boolean uneq(int x, int y) {
		return !eq(x, y);
	}
	public static boolean uneq(long x, long y) {
		return !eq(x, y);
	}
	public static boolean uneq(float x, float y) {
		return !eq(x, y);
	}
	public static boolean uneq(double x, double y) {
		return !eq(x, y);
	}
	public static boolean uneq(boolean x, boolean y) {
		return !eq(x, y);
	}
	public static boolean uneq(Object x, Object y) {
		return !eq(x, y);
	}
	public static boolean uneq(String[] x, String[] y) {
		return !eq(x, y);
	}
	public static boolean uneq(int[] x, int[] y) {
		return !eq(x, y);
	}
	public static boolean uneq(long[] x, long[] y) {
		return !eq(x, y);
	}
	public static boolean uneq(float[] x, float[] y) {
		return !eq(x, y);
	}
	public static boolean uneq(double[] x, double[] y) {
		return !eq(x, y);
	}
	public static boolean uneq(boolean[] x, boolean[] y) {
		return !eq(x, y);
	}
	public static boolean uneq(Object[] x, Object[] y) {
		return !eq(x, y);
	}
	public static boolean uneq(StrArr x, StrArr y) {
		return !eq(x, y);
	}
	public static boolean uneq(IntArr x, IntArr y) {
		return !eq(x, y);
	}
	public static boolean uneq(LongArr x, LongArr y) {
		return !eq(x, y);
	}
	public static boolean uneq(FltArr x, FltArr y) {
		return !eq(x, y);
	}
	public static boolean uneq(DblArr x, DblArr y) {
		return !eq(x, y);
	}
	public static boolean uneq(BoolArr x, BoolArr y) {
		return !eq(x, y);
	}
	public static boolean uneq(Tree_S x, Tree_S y) {
		return !eq(x, y);
	}
	public static boolean uneq(Tree_I x, Tree_I y) {
		return !eq(x, y);
	}
	public static boolean uneq(Tree_SL x, Tree_SL y) {
		return !eq(x, y);
	}
	public static boolean uneq(Tree_L x, Tree_L y) {
		return !eq(x, y);
	}
	public static boolean uneq(Tree_SF x, Tree_SF y) {
		return !eq(x, y);
	}
	public static boolean uneq(Tree_F x, Tree_F y) {
		return !eq(x, y);
	}
	public static boolean uneq(Tree_SD x, Tree_SD y) {
		return !eq(x, y);
	}
	public static boolean uneq(Tree_D x, Tree_D y) {
		return !eq(x, y);
	}
	public static boolean uneq(Tree_SB x, Tree_SB y) {
		return !eq(x, y);
	}
	public static boolean uneq(Tree_B x, Tree_B y) {
		return !eq(x, y);
	}
	public static boolean both(String... strings) {
		int count = 0;
		for (String s : strings) {
			if (is(s))
				count += 1;
		}
		return count == len(strings);
	}
	public static boolean both(int... ints) {
		int count = 0;
		for (int n : ints) {
			if (is(n))
				count += 1;
		}
		return count == len(ints);
	}
	public static boolean both(long... longs) {
		int count = 0;
		for (long n : longs) {
			if (is(n))
				count += 1;
		}
		return count == len(longs);
	}
	public static boolean both(float... floats) {
		int count = 0;
		for (float n : floats) {
			if (is(n))
				count += 1;
		}
		return count == len(floats);
	}
	public static boolean both(double... doubles) {
		int count = 0;
		for (double n : doubles) {
			if (is(n))
				count += 1;
		}
		return count == len(doubles);
	}
	public static boolean both(boolean... bools) {
		int count = 0;
		for (boolean bool : bools) {
			if (is(bool))
				count += 1;
		}
		return count == len(bools);
	}
	public static boolean either(String... strings) {
		int count = 0;
		for (String s : strings) {
			if (is(s))
				count += 1;
		}
		return count > 0;
	}
	public static boolean either(int... ints) {
		int count = 0;
		for (int n : ints) {
			if (is(n))
				count += 1;
		}
		return count > 0;
	}
	public static boolean either(long... longs) {
		int count = 0;
		for (long n : longs) {
			if (is(n))
				count += 1;
		}
		return count > 0;
	}
	public static boolean either(float... floats) {
		int count = 0;
		for (float n : floats) {
			if (is(n))
				count += 1;
		}
		return count > 0;
	}
	public static boolean either(double... doubles) {
		int count = 0;
		for (double n : doubles) {
			if (is(n))
				count += 1;
		}
		return count > 0;
	}
	public static boolean either(boolean... bools) {
		int count = 0;
		for (boolean bool : bools) {
			if (is(bool))
				count += 1;
		}
		return count > 0;
	}
	public static boolean either(Object... objs) {
		int count = 0;
		for (Object obj : objs) {
			if (is(obj))
				count += 1;
		}
		return count > 0;
	}
	public static boolean any(String... strings) {
		return either(strings);
	}
	public static boolean any(int... ints) {
		return either(ints);
	}
	public static boolean any(long... longs) {
		return either(longs);
	}
	public static boolean any(float... floats) {
		return either(floats);
	}
	public static boolean any(double... doubles) {
		return either(doubles);
	}
	public static boolean any(boolean... bools) {
		return either(bools);
	}
	public static boolean any(Object... objs) {
		return either(objs);
	}
	public static boolean neither(String... strings) {
		int count = 0;
		for (String s : strings) {
			if (not(s))
				count += 1;
		}
		return count == len(strings);
	}
	public static boolean neither(int... ints) {
		int count = 0;
		for (int n : ints) {
			if (not(n))
				count += 1;
		}
		return count == len(ints);
	}
	public static boolean neither(long... longs) {
		int count = 0;
		for (long n : longs) {
			if (not(n))
				count += 1;
		}
		return count == len(longs);
	}
	public static boolean neither(float... floats) {
		int count = 0;
		for (float n : floats) {
			if (not(n))
				count += 1;
		}
		return count == len(floats);
	}
	public static boolean neither(double... doubles) {
		int count = 0;
		for (double n : doubles) {
			if (not(n))
				count += 1;
		}
		return count == len(doubles);
	}
	public static boolean neither(boolean... bools) {
		int count = 0;
		for (boolean bool : bools) {
			if (not(bool))
				count += 1;
		}
		return count == len(bools);
	}
	public static boolean neither(Object... objs) {
		int count = 0;
		for (Object obj : objs) {
			if (not(obj))
				count += 1;
		}
		return count == len(objs);
	}
	public static boolean not(String s) {
		return isnl(s) || isEmpty(s);
	}
	public static boolean not(char c) {
		return isnl(c);
	}
	public static boolean not(int n) {
		return isnl(n) || 0 == n;
	}
	public static boolean not(long n) {
		return isnl(n) || 0 == n;
	}
	public static boolean not(float n) {
		return isnl(n) || 0 == n;
	}
	public static boolean not(double n) {
		return isnl(n) || 0 == n;
	}
	public static boolean not(boolean condition) {
		return isnl(condition) || !condition;
	}
	public static boolean not(Object o) {
		return isnl(o);
	}
	public static boolean not(String[] arr) {
		return isnl(arr) || isEmpty(arr);
	}
	public static boolean not(int[] arr) {
		return isnl(arr) || isEmpty(arr);
	}
	public static boolean not(long[] arr) {
		return isnl(arr) || isEmpty(arr);
	}
	public static boolean not(float[] arr) {
		return isnl(arr) || isEmpty(arr);
	}
	public static boolean not(double[] arr) {
		return isnl(arr) || isEmpty(arr);
	}
	public static boolean not(boolean[] arr) {
		return isnl(arr) || isEmpty(arr);
	}
	public static boolean not(Object[] arr) {
		return isnl(arr) || isEmpty(arr);
	}
	public static boolean not(StrArr arr) {
		return isnl(arr) || isEmpty(arr);
	}
	public static boolean not(IntArr arr) {
		return isnl(arr) || isEmpty(arr);
	}
	public static boolean not(LongArr arr) {
		return isnl(arr) || isEmpty(arr);
	}
	public static boolean not(FltArr arr) {
		return isnl(arr) || isEmpty(arr);
	}
	public static boolean not(DblArr arr) {
		return isnl(arr) || isEmpty(arr);
	}
	public static boolean not(BoolArr arr) {
		return isnl(arr) || isEmpty(arr);
	}
	public static boolean not(Obj_S o) {
		return isnl(o) || isEmpty(o);
	}
	public static boolean not(Obj_I o) {
		return isnl(o) || isEmpty(o);
	}
	public static boolean not(Obj_L o) {
		return isnl(o) || isEmpty(o);
	}
	public static boolean not(Obj_F o) {
		return isnl(o) || isEmpty(o);
	}
	public static boolean not(Obj_D o) {
		return isnl(o) || isEmpty(o);
	}
	public static boolean not(Obj_B o) {
		return isnl(o) || isEmpty(o);
	}
	public static boolean not(Tree_S t) {
		return isnl(t) || isEmpty(t);
	}
	public static boolean not(Tree_I t) {
		return isnl(t) || isEmpty(t);
	}
	public static boolean not(Tree_SL t) {
		return isnl(t) || isEmpty(t);
	}
	public static boolean not(Tree_L t) {
		return isnl(t) || isEmpty(t);
	}
	public static boolean not(Tree_SF t) {
		return isnl(t) || isEmpty(t);
	}
	public static boolean not(Tree_F t) {
		return isnl(t) || isEmpty(t);
	}
	public static boolean not(Tree_SD t) {
		return isnl(t) || isEmpty(t);
	}
	public static boolean not(Tree_D t) {
		return isnl(t) || isEmpty(t);
	}
	public static boolean not(Tree_SB t) {
		return isnl(t) || isEmpty(t);
	}
	public static boolean not(Tree_B t) {
		return isnl(t) || isEmpty(t);
	}
	public static boolean is(char c) {
		return !not(c);
	}
	public static boolean is(String s) {
		return !not(s);
	}
	public static boolean is(int n) {
		return !not(n);
	}
	public static boolean is(long n) {
		return !not(n);
	}
	public static boolean is(float n) {
		return !not(n);
	}
	public static boolean is(double n) {
		return !not(n);
	}
	public static boolean is(boolean condition) {
		return !not(condition);
	}
	public static boolean is(Object o) {
		return !not(o);
	}
	public static boolean is(String[] arr) {
		return !not(arr);
	}
	public static boolean is(int[] arr) {
		return !not(arr);
	}
	public static boolean is(long[] arr) {
		return !not(arr);
	}
	public static boolean is(float[] arr) {
		return !not(arr);
	}
	public static boolean is(double[] arr) {
		return !not(arr);
	}
	public static boolean is(boolean[] arr) {
		return !not(arr);
	}
	public static boolean is(Object[] arr) {
		return !not(arr);
	}
	public static boolean is(StrArr arr) {
		return !not(arr);
	}
	public static boolean is(IntArr arr) {
		return !not(arr);
	}
	public static boolean is(LongArr arr) {
		return !not(arr);
	}
	public static boolean is(FltArr arr) {
		return !not(arr);
	}
	public static boolean is(DblArr arr) {
		return !not(arr);
	}
	public static boolean is(BoolArr arr) {
		return !not(arr);
	}
	public static boolean is(Obj_S o) {
		return !not(o);
	}
	public static boolean is(Obj_I o) {
		return !not(o);
	}
	public static boolean is(Obj_L o) {
		return !not(o);
	}
	public static boolean is(Obj_F o) {
		return !not(o);
	}
	public static boolean is(Obj_D o) {
		return !not(o);
	}
	public static boolean is(Obj_B o) {
		return !not(o);
	}
	public static boolean is(Tree_S t) {
		return !not(t);
	}
	public static boolean is(Tree_I t) {
		return !not(t);
	}
	public static boolean is(Tree_SL t) {
		return !not(t);
	}
	public static boolean is(Tree_L t) {
		return !not(t);
	}
	public static boolean is(Tree_SF t) {
		return !not(t);
	}
	public static boolean is(Tree_F t) {
		return !not(t);
	}
	public static boolean is(Tree_SD t) {
		return !not(t);
	}
	public static boolean is(Tree_D t) {
		return !not(t);
	}
	public static boolean is(Tree_SB t) {
		return !not(t);
	}
	public static boolean is(Tree_B t) {
		return !not(t);
	}
	public static boolean xor(boolean a, boolean b) {
		return a || b && !(a && b);
	}
	public static boolean implies(boolean a, boolean b) {
		return a && !b ? false : true;
	}
	public static int randInt() {
		int number = ThreadLocalRandom.current().nextInt(0, 99);
		return number;
	}
	public static int randInt(int end) {
		if (not(end)) return 0;
		int number = ThreadLocalRandom.current().nextInt(0, end);
		return number;
	}
	public static int randInt(int start, int end) {
		if (not(start) || not(end) || eq(start, end)) return 0;
		int number = ThreadLocalRandom.current().nextInt(start, end);
		return number;
	}
	public static int randPin(int len) {
	    String str = "";
	    if (not(len) || len < 4) len = 4;
	    if (isInf(len) || len > 8) len = 8;
	    while (len > 0) {
	        str += "" + randInt(10);
	        len--;
	    }
	    int result = Int(str);
	    return result;
	}
	public static int randPin() {
	    return randPin(4);
	}
	public static int randOTP(int len) {
	    return randPin(len);
	}
	public static int randOTP() {
	    return randPin();
	}
	public static double randFlt() {
		double number = randInt() * .3;
		return number;
	}
	public static double randFlt(int end) {
		if (not(end)) return 0;
		double number = randInt(end) * .3;
		return number;
	}
	public static double randFlt(int start, int end) {
		if (not(start) || not(end) || eq(start, end)) return 0;
		double number = randInt(start, end) * .3;
		return number;
	}
	public static double randDbl() {
		return (double)randFlt();
	}
	public static double randDbl(int end) {
		if (not(end)) return 0;
		return (double)randFlt(end);
	}
	public static double randDbl(int start, int end) {
		if (not(start) || not(end) || eq(start, end)) return 0;
		return (double)randFlt(start, end);
	}
	public static String randPct() {
		Number[] nums = {randInt(100), randDbl()};
		return randFrom(nums) + "%";
	}
	public static String randStr(int len) {
		final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnop"
						  + "qrstuvwxyz\\+=";
		SecureRandom rnd = new SecureRandom();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}
	public static String randStr() {
		return randStr(randInt(8, 32));
	}
	public static char randChar(int low, int high) {
		if (low < 0)
			low = 0;
		if (high > 127)
			high = 127;
		return (char) randInt(low, high);
	}
	public static char randChar() {
		return randChar(47, 127);
	}
	public static String randId() {
		return UUID.randomUUID().toString();
	}
	public static String randItem(String arr[]) {
		return arr[randInt(arr.length)];
	}
	public static int randItem(int arr[]) {
		return arr[randInt(arr.length)];
	}
	public static long randItem(long arr[]) {
		return arr[randInt(arr.length)];
	}
	public static float randItem(float arr[]) {
		return arr[randInt(arr.length)];
	}
	public static double randItem(double arr[]) {
		return arr[randInt(arr.length)];
	}
	public static boolean randItem(boolean arr[]) {
		return arr[randInt(arr.length)];
	}
	public static Object randItem(Object arr[]) {
		return arr[randInt(arr.length)];
	}
	public static String randItem(StrArr arr) {
		return arr.i(randInt(arr.length()));
	}
	public static int randItem(IntArr arr) {
		return arr.i(randInt(arr.length()));
	}
	public static long randItem(LongArr arr) {
		return arr.i(randInt(arr.length()));
	}
	public static float randItem(FltArr arr) {
		return arr.i(randInt(arr.length()));
	}
	public static double randItem(DblArr arr) {
		return arr.i(randInt(arr.length()));
	}
	public static boolean randItem(BoolArr arr) {
		return arr.i(randInt(arr.length()));
	}
	public static String randItem(Obj_S arr) {
		return arr.i(randInt(arr.length()));
	}
	public static int randItem(Obj_I arr) {
		return arr.i(randInt(arr.length()));
	}
	public static long randItem(Obj_L arr) {
		return arr.i(randInt(arr.length()));
	}
	public static float randItem(Obj_F arr) {
		return arr.i(randInt(arr.length()));
	}
	public static double randItem(Obj_D arr) {
		return arr.i(randInt(arr.length()));
	}
	public static boolean randItem(Obj_B arr) {
		return arr.i(randInt(arr.length()));
	}
	public static int randItem(Tree_S t) {
		return t.i(randInt(t.length()));
	}
	public static String randItem(Tree_I t) {
		return t.i(randInt(t.length()));
	}
	public static long randItem(Tree_SL t) {
		return t.i(randInt(t.length()));
	}
	public static long randItem(Tree_L t) {
		return t.i(randInt(t.length()));
	}
	public static float randItem(Tree_SF t) {
		return t.i(randInt(t.length()));
	}
	public static float randItem(Tree_F t) {
		return t.i(randInt(t.length()));
	}
	public static double randItem(Tree_SD t) {
		return t.i(randInt(t.length()));
	}
	public static double randItem(Tree_D t) {
		return t.i(randInt(t.length()));
	}
	public static boolean randItem(Tree_SB t) {
		return t.i(randInt(t.length()));
	}
	public static boolean randItem(Tree_B t) {
		return t.i(randInt(t.length()));
	}
	public static String randFrom(String arr[]) {
		return randItem(arr);
	}
	public static int randFrom(int arr[]) {
		return randItem(arr);
	}
	public static long randFrom(long arr[]) {
		return randItem(arr);
	}
	public static float randFrom(float arr[]) {
		return randItem(arr);
	}
	public static double randFrom(double arr[]) {
		return randItem(arr);
	}
	public static boolean randFrom(boolean arr[]) {
		return randItem(arr);
	}
	public static Object randFrom(Object arr[]) {
		return randItem(arr);
	}
	public static String randFrom(StrArr arr) {
		return randItem(arr);
	}
	public static int randFrom(IntArr arr) {
		return randItem(arr);
	}
	public static long randFrom(LongArr arr) {
		return randItem(arr);
	}
	public static float randFrom(FltArr arr) {
		return randItem(arr);
	}
	public static double randFrom(DblArr arr) {
		return randItem(arr);
	}
	public static boolean randFrom(BoolArr arr) {
		return randItem(arr);
	}
	public static int randFrom(Tree_S t) {
		return randItem(t);
	}
	public static String randFrom(Tree_I t) {
		return randItem(t);
	}
	public static long randFrom(Tree_SL t) {
		return randItem(t);
	}
	public static long randFrom(Tree_L t) {
		return randItem(t);
	}
	public static float randFrom(Tree_SF t) {
		return randItem(t);
	}
	public static float randFrom(Tree_F t) {
		return randItem(t);
	}
	public static double randFrom(Tree_SD t) {
		return randItem(t);
	}
	public static double randFrom(Tree_D t) {
		return randItem(t);
	}
	public static boolean randFrom(Tree_SB t) {
		return randItem(t);
	}
	public static boolean randFrom(Tree_B t) {
		return randItem(t);
	}
	public static String randFrom(Obj_S o) {
		return randItem(o);
	}
	public static int randFrom(Obj_I o) {
		return randItem(o);
	}
	public static long randFrom(Obj_L o) {
		return randItem(o);
	}
	public static float randFrom(Obj_F o) {
		return randItem(o);
	}
	public static double randFrom(Obj_D o) {
		return randItem(o);
	}
	public static boolean randFrom(Obj_B o) {
		return randItem(o);
	}
	public static String anyOf(String arr[]) {
		return randItem(arr);
	}
	public static int anyOf(int arr[]) {
		return randItem(arr);
	}
	public static long anyOf(long arr[]) {
		return randItem(arr);
	}
	public static float anyOf(float arr[]) {
		return randItem(arr);
	}
	public static double anyOf(double arr[]) {
		return randItem(arr);
	}
	public static boolean anyOf(boolean arr[]) {
		return randItem(arr);
	}
	public static Object anyOf(Object arr[]) {
		return arr[randInt(arr.length)];
	}
	public static String anyOf(StrArr arr) {
		return randItem(arr);
	}
	public static int anyOf(IntArr arr) {
		return randItem(arr);
	}
	public static long anyOf(LongArr arr) {
		return randItem(arr);
	}
	public static float anyOf(FltArr arr) {
		return randItem(arr);
	}
	public static double anyOf(DblArr arr) {
		return randItem(arr);
	}
	public static boolean anyOf(BoolArr arr) {
		return randItem(arr);
	}
	public static int anyOf(Tree_S t) {
		return randItem(t);
	}
	public static String anyOf(Tree_I t) {
		return randItem(t);
	}
	public static long anyOf(Tree_SL t) {
		return randItem(t);
	}
	public static long anyOf(Tree_L t) {
		return randItem(t);
	}
	public static float anyOf(Tree_SF t) {
		return randItem(t);
	}
	public static float anyOf(Tree_F t) {
		return randItem(t);
	}
	public static double anyOf(Tree_SD t) {
		return randItem(t);
	}
	public static double anyOf(Tree_D t) {
		return randItem(t);
	}
	public static boolean anyOf(Tree_SB t) {
		return randItem(t);
	}
	public static boolean anyOf(Tree_B t) {
		return randItem(t);
	}
	public static String anyOf(Obj_S o) {
		return randItem(o);
	}
	public static int anyOf(Obj_I o) {
		return randItem(o);
	}
	public static long anyOf(Obj_L o) {
		return randItem(o);
	}
	public static float anyOf(Obj_F o) {
		return randItem(o);
	}
	public static double anyOf(Obj_D o) {
		return randItem(o);
	}
	public static boolean anyOf(Obj_B o) {
		return randItem(o);
	}
	public static int[] noDuplicates(int[] arr) {
		return IntStream.of(arr).distinct().toArray();
	}
	public static long[] noDuplicates(long[] arr) {
		return LongStream.of(arr).distinct().toArray();
	}
	public static double[] noDuplicates(double[] arr) {
		return DoubleStream.of(arr).distinct().toArray();
	}
	public static StrArr noDuplicates(StrArr arr) {
		return arr.unique();
	}
	public static IntArr noDuplicates(IntArr arr) {
		return arr.unique();
	}
	public static LongArr noDuplicates(LongArr arr) {
		return arr.unique();
	}
	public static FltArr noDuplicates(FltArr arr) {
		return arr.unique();
	}
	public static DblArr noDuplicates(DblArr arr) {
		return arr.unique();
	}
	public static BoolArr noDuplicates(BoolArr arr) {
		return arr.unique();
	}
	public static String replace(String str, String to_replace,
								 String regex_to_replace_with) {
		return str.replaceAll(to_replace, regex_to_replace_with);
	}
	public static String replaceOne(String str, String to_replace,
									String regex_to_replace_with) {
		return str.replaceFirst(to_replace, regex_to_replace_with);
	}
	public static String remove(String str, String re) {
		return replace(str, re, "");
	}
	public static String slice(String str) {
		return remove(str, "^\\s+|\\s+$");
	}
	public static String[] slice(String arr[]) {
		return arr.clone();
	}
	public static int[] slice(int arr[]) {
		return arr.clone();
	}
	public static long[] slice(long arr[]) {
		return arr.clone();
	}
	public static float[] slice(float arr[]) {
		return arr.clone();
	}
	public static double[] slice(double arr[]) {
		return arr.clone();
	}
	public static boolean[] slice(boolean arr[]) {
		return arr.clone();
	}
	public static StrArr slice(StrArr arr) {
		return arr.copy();
	}
	public static IntArr slice(IntArr arr) {
		return arr.copy();
	}
	public static LongArr slice(LongArr arr) {
		return arr.copy();
	}
	public static FltArr slice(FltArr arr) {
		return arr.copy();
	}
	public static DblArr slice(DblArr arr) {
		return arr.copy();
	}
	public static BoolArr slice(BoolArr arr) {
		return arr.copy();
	}
	public static String slice(String str, int start) {
		if (start < 0 || start >= len(str))
			return str;
		return str.substring(start, len(str));
	}
	public static String[] slice(String oldArr[], int start) {
		String newArr[] = Arrays.copyOfRange(oldArr.clone(), start,
											 len(oldArr));
		return newArr;
	}
	public static int[] slice(int oldArr[], int start) {
		int newArr[] = Arrays.copyOfRange(oldArr.clone(), start, len(oldArr));
		return newArr;
	}
	public static long[] slice(long oldArr[], int start) {
		long newArr[] = Arrays.copyOfRange(oldArr.clone(), start, len(oldArr));
		return newArr;
	}
	public static float[] slice(float oldArr[], int start) {
		float newArr[] = Arrays.copyOfRange(oldArr.clone(), start, len(oldArr));
		return newArr;
	}
	public static double[] slice(double oldArr[], int start) {
		double newArr[] = Arrays.copyOfRange(oldArr.clone(), start,
											 len(oldArr));
		return newArr;
	}
	public static boolean[] slice(boolean oldArr[], int start) {
		boolean newArr[] = Arrays.copyOfRange(oldArr.clone(), start,
											  len(oldArr));
		return newArr;
	}
	public static StrArr slice(StrArr arr, int start) {
		return arr.slice(start, arr.length());
	}
	public static IntArr slice(IntArr arr, int start) {
		return arr.slice(start, arr.length());
	}
	public static LongArr slice(LongArr arr, int start) {
		return arr.slice(start, arr.length());
	}
	public static FltArr slice(FltArr arr, int start) {
		return arr.slice(start, arr.length());
	}
	public static DblArr slice(DblArr arr, int start) {
		return arr.slice(start, arr.length());
	}
	public static BoolArr slice(BoolArr arr, int start) {
		return arr.slice(start, arr.length());
	}
	public static String slice(String str, int start, int end) {
		if (start < 0 || start >= len(str) || end <= 0 || end >= len(str))
			return str;
		return str.substring(start, end);
	}
	public static String[] slice(String oldArr[], int start, int end) {
		String newArr[] = Arrays.copyOfRange(oldArr.clone(), start, end);
		return newArr;
	}
	public static int[] slice(int oldArr[], int start, int end) {
		int newArr[] = Arrays.copyOfRange(oldArr.clone(), start, end);
		return newArr;
	}
	public static long[] slice(long oldArr[], int start, int end) {
		long newArr[] = Arrays.copyOfRange(oldArr.clone(), start, end);
		return newArr;
	}
	public static float[] slice(float oldArr[], int start, int end) {
		float newArr[] = Arrays.copyOfRange(oldArr.clone(), start, end);
		return newArr;
	}
	public static double[] slice(double oldArr[], int start, int end) {
		double newArr[] = Arrays.copyOfRange(oldArr.clone(), start, end);
		return newArr;
	}
	public static boolean[] slice(boolean oldArr[], int start, int end) {
		boolean newArr[] = Arrays.copyOfRange(oldArr.clone(), start, end);
		return newArr;
	}
	public static StrArr slice(StrArr arr, int start, int end) {
		return arr.slice(start, end);
	}
	public static IntArr slice(IntArr arr, int start, int end) {
		return arr.slice(start, end);
	}
	public static LongArr slice(LongArr arr, int start, int end) {
		return arr.slice(start, end);
	}
	public static FltArr slice(FltArr arr, int start, int end) {
		return arr.slice(start, end);
	}
	public static DblArr slice(DblArr arr, int start, int end) {
		return arr.slice(start, end);
	}
	public static BoolArr slice(BoolArr arr, int start, int end) {
		return arr.slice(start, end);
	}
	public static String sliceEnd(String str, int start) {
		return slice(str, str.length() - start);
	}
	public static String[] sliceEnd(String[] arr, int start) {
		return slice(arr, len(arr) - start);
	}
	public static int[] sliceEnd(int[] arr, int start) {
		return slice(arr, len(arr) - start);
	}
	public static long[] sliceEnd(long[] arr, int start) {
		return slice(arr, len(arr) - start);
	}
	public static float[] sliceEnd(float[] arr, int start) {
		return slice(arr, len(arr) - start);
	}
	public static double[] sliceEnd(double[] arr, int start) {
		return slice(arr, len(arr) - start);
	}
	public static boolean[] sliceEnd(boolean[] arr, int start) {
		return slice(arr, len(arr) - start);
	}
	public static StrArr sliceEnd(StrArr arr, int start) {
		return slice(arr, len(arr) - start);
	}
	public static IntArr sliceEnd(IntArr arr, int start) {
		return slice(arr, len(arr) - start);
	}
	public static LongArr sliceEnd(LongArr arr, int start) {
		return slice(arr, len(arr) - start);
	}
	public static FltArr sliceEnd(FltArr arr, int start) {
		return slice(arr, len(arr) - start);
	}
	public static DblArr sliceEnd(DblArr arr, int start) {
		return slice(arr, len(arr) - start);
	}
	public static BoolArr sliceEnd(BoolArr arr, int start) {
		return slice(arr, len(arr) - start);
	}
	public static String trim(String str) {
		return slice(str);
	}
	public static String[] trim(String[] arr) {
		return slice(arr);
	}
	public static int[] trim(int[] arr) {
		return slice(arr);
	}
	public static long[] trim(long[] arr) {
		return slice(arr);
	}
	public static float[] trim(float[] arr) {
		return slice(arr);
	}
	public static double[] trim(double[] arr) {
		return slice(arr);
	}
	public static boolean[] trim(boolean[] arr) {
		return slice(arr);
	}
	public static StrArr trim(StrArr arr) {
		return slice(arr);
	}
	public static IntArr trim(IntArr arr) {
		return slice(arr);
	}
	public static LongArr trim(LongArr arr) {
		return slice(arr);
	}
	public static FltArr trim(FltArr arr) {
		return slice(arr);
	}
	public static DblArr trim(DblArr arr) {
		return slice(arr);
	}
	public static BoolArr trim(BoolArr arr) {
		return slice(arr);
	}
	public static String trim(String str, int start) {
		return slice(str, start);
	}
	public static String[] trim(String[] arr, int start) {
		return slice(arr, start);
	}
	public static int[] trim(int[] arr, int start) {
		return slice(arr, start);
	}
	public static long[] trim(long[] arr, int start) {
		return slice(arr, start);
	}
	public static float[] trim(float[] arr, int start) {
		return slice(arr, start);
	}
	public static double[] trim(double[] arr, int start) {
		return slice(arr, start);
	}
	public static boolean[] trim(boolean[] arr, int start) {
		return slice(arr, start);
	}
	public static StrArr trim(StrArr arr, int start) {
		return slice(arr, start);
	}
	public static IntArr trim(IntArr arr, int start) {
		return slice(arr, start);
	}
	public static LongArr trim(LongArr arr, int start) {
		return slice(arr, start);
	}
	public static FltArr trim(FltArr arr, int start) {
		return slice(arr, start);
	}
	public static DblArr trim(DblArr arr, int start) {
		return slice(arr, start);
	}
	public static BoolArr trim(BoolArr arr, int start) {
		return slice(arr, start);
	}
	public static String trim(String str, int start, int end) {
		return slice(str, start, end);
	}
	public static String[] trim(String[] arr, int start, int end) {
		return slice(arr, start, end);
	}
	public static int[] trim(int[] arr, int start, int end) {
		return slice(arr, start, end);
	}
	public static long[] trim(long[] arr, int start, int end) {
		return slice(arr, start, end);
	}
	public static float[] trim(float[] arr, int start, int end) {
		return slice(arr, start, end);
	}
	public static double[] trim(double[] arr, int start, int end) {
		return slice(arr, start, end);
	}
	public static boolean[] trim(boolean[] arr, int start, int end) {
		return slice(arr, start, end);
	}
	public static StrArr trim(StrArr arr, int start, int end) {
		return slice(arr, start, end);
	}
	public static IntArr trim(IntArr arr, int start, int end) {
		return slice(arr, start, end);
	}
	public static LongArr trim(LongArr arr, int start, int end) {
		return slice(arr, start, end);
	}
	public static FltArr trim(FltArr arr, int start, int end) {
		return slice(arr, start, end);
	}
	public static DblArr trim(DblArr arr, int start, int end) {
		return slice(arr, start, end);
	}
	public static BoolArr trim(BoolArr arr, int start, int end) {
		return slice(arr, start, end);
	}
	public static String trimEnd(String str, int start) {
		return sliceEnd(str, start);
	}
	public static String[] trimEnd(String[] arr, int start) {
		return sliceEnd(arr, start);
	}
	public static int[] trimEnd(int[] arr, int start) {
		return sliceEnd(arr, start);
	}
	public static long[] trimEnd(long[] arr, int start) {
		return sliceEnd(arr, start);
	}
	public static float[] trimEnd(float[] arr, int start) {
		return sliceEnd(arr, start);
	}
	public static double[] trimEnd(double[] arr, int start) {
		return sliceEnd(arr, start);
	}
	public static boolean[] trimEnd(boolean[] arr, int start) {
		return sliceEnd(arr, start);
	}
	public static StrArr trimEnd(StrArr arr, int start) {
		return sliceEnd(arr, start);
	}
	public static IntArr trimEnd(IntArr arr, int start) {
		return sliceEnd(arr, start);
	}
	public static LongArr trimEnd(LongArr arr, int start) {
		return sliceEnd(arr, start);
	}
	public static FltArr trimEnd(FltArr arr, int start) {
		return sliceEnd(arr, start);
	}
	public static DblArr trimEnd(DblArr arr, int start) {
		return sliceEnd(arr, start);
	}
	public static BoolArr trimEnd(BoolArr arr, int start) {
		return sliceEnd(arr, start);
	}
	public static String sliceTo(String str, String thatSpecificPart) {
		int index = indexOf(str, thatSpecificPart);
		if (index < 0 || index == -1)
			return str;
		return slice(str, index);
	}
	public static String sliceToAfter(String str, String thatSpecificPart) {
		int index = indexOf(str, thatSpecificPart);
		if (index < 0)
			return str;
		String retrievedString = sliceTo(str, thatSpecificPart);
		return slice(retrievedString, len(thatSpecificPart));
	}
	public static boolean startsWith(String str, String re) {
		Pattern pattern = Pattern.compile("^(" + re + ")",
										  Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(str);
		return !!matcher.find();
	}
	public static boolean endsWith(String str, String re) {
		Pattern pattern = Pattern.compile("(" + re + ")$",
										  Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(str);
		return !!matcher.find();
	}
	public static boolean endsWith(String[] arr, String lookupStr) {
		if (not(len(arr)))
			return false;
		return arr[len(arr) - 1].equals(lookupStr);
	}
	public static boolean endsWith(int[] arr, int lookupInt) {
		if (not(len(arr)))
			return false;
		return arr[len(arr) - 1] == lookupInt;
	}
	public static boolean endsWith(long[] arr, long lookupLong) {
		if (not(len(arr)))
			return false;
		return arr[len(arr) - 1] == lookupLong;
	}
	public static boolean endsWith(float[] arr, float lookupFloat) {
		if (not(len(arr)))
			return false;
		return arr[len(arr) - 1] == lookupFloat;
	}
	public static boolean endsWith(double[] arr, double lookupDbl) {
		if (not(len(arr)))
			return false;
		return arr[len(arr) - 1] == lookupDbl;
	}
	public static boolean endsWith(boolean[] arr, boolean lookupBool) {
		if (not(len(arr)))
			return false;
		return arr[len(arr) - 1] == lookupBool;
	}
	public static boolean endsWith(StrArr arr, String lookupStr) {
		if (not(len(arr)))
			return false;
		return arr.last() == lookupStr;
	}
	public static boolean endsWith(IntArr arr, int lookupInt) {
		if (not(len(arr)))
			return false;
		return arr.last() == lookupInt;
	}
	public static boolean endsWith(LongArr arr, long lookupLong) {
		if (not(len(arr)))
			return false;
		return arr.last() == lookupLong;
	}
	public static boolean endsWith(FltArr arr, float lookupFlt) {
		if (not(len(arr)))
			return false;
		return arr.last() == lookupFlt;
	}
	public static boolean endsWith(DblArr arr, double lookupDbl) {
		if (not(len(arr)))
			return false;
		return arr.last() == lookupDbl;
	}
	public static boolean endsWith(BoolArr arr, boolean lookupBool) {
		if (not(len(arr)))
			return false;
		return arr.last() == lookupBool;
	}
	public static boolean endsWith(Tree_S tree, int lookupInt) {
		if (not(len(tree)))
			return false;
		return tree.last() == lookupInt;
	}
	public static boolean endsWith(Tree_I tree, String lookupStr) {
		if (not(len(tree)))
			return false;
		return tree.last() == lookupStr;
	}
	public static boolean endsWith(Tree_SL tree, long lookupLong) {
		if (not(len(tree)))
			return false;
		return tree.last() == lookupLong;
	}
	public static boolean endsWith(Tree_L tree, long lookupLong) {
		if (not(len(tree)))
			return false;
		return tree.last() == lookupLong;
	}
	public static String nth(StrArr arr, int n) {
		return n >= 0 && n < len(arr) ? arr.i(n) : "";
	}
	public static int nth(IntArr arr, int n) {
		return n >= 0 && n < len(arr) ? arr.i(n) : 0;
	}
	public static long nth(LongArr arr, int n) {
		return n >= 0 && n < len(arr) ? arr.i(n) : 0;
	}
	public static float nth(FltArr arr, int n) {
		return n >= 0 && n < len(arr) ? arr.i(n) : 0;
	}
	public static double nth(DblArr arr, int n) {
		return n >= 0 && n < len(arr) ? arr.i(n) : 0;
	}
	public static boolean nth(BoolArr arr, int n) {
		return n >= 0 && n < len(arr) ? arr.i(n) : false;
	}
	public static String firstOf(StrArr arr) {
		if (not(len(arr)))
			return "";
		return arr.first();
	}
	public static String secondOf(StrArr arr) {
		if (not(len(arr)))
			return "";
		return arr.second();
	}
	public static int firstOf(IntArr arr) {
		if (not(len(arr)))
			return 0;
		return arr.first();
	}
	public static int secondOf(IntArr arr) {
		if (not(len(arr)))
			return 0;
		return arr.second();
	}
	public static float firstOf(LongArr arr) {
		if (not(len(arr)))
			return 0;
		return arr.first();
	}
	public static float secondOf(LongArr arr) {
		if (not(len(arr)))
			return 0;
		return arr.second();
	}
	public static float firstOf(FltArr arr) {
		if (not(len(arr)))
			return 0;
		return arr.first();
	}
	public static float secondOf(FltArr arr) {
		if (not(len(arr)))
			return 0;
		return arr.second();
	}
	public static double firstOf(DblArr arr) {
		if (not(len(arr)))
			return 0;
		return arr.first();
	}
	public static double secondOf(DblArr arr) {
		if (not(len(arr)))
			return 0;
		return arr.second();
	}
	public static boolean firstOf(BoolArr arr) {
		if (not(len(arr)))
			return false;
		return arr.first();
	}
	public static boolean secondOf(BoolArr arr) {
		if (not(len(arr)))
			return false;
		return arr.second();
	}
	public static String nthLastOf(String str, int n) {
		return n > 0 && n <= len(str)
			   ? ("" + str.toCharArray()[len(str) - n])
			   : "";
	}
	public static char nthLastOf(char[] arr, int n) {
		return n > 0 && n <= len(arr) ? arr[len(arr) - n] : '\0';
	}
	public static String nthLastOf(String[] arr, int n) {
		return n > 0 && n <= len(arr) ? arr[len(arr) - n] : "";
	}
	public static int nthLastOf(int[] arr, int n) {
		return n > 0 && n <= len(arr) ? arr[len(arr) - n] : 0;
	}
	public static long nthLastOf(long[] arr, int n) {
		return n > 0 && n <= len(arr) ? arr[len(arr) - n] : 0;
	}
	public static float nthLastOf(float[] arr, int n) {
		return n > 0 && n <= len(arr) ? arr[len(arr) - n] : 0;
	}
	public static double nthLastOf(double[] arr, int n) {
		return n > 0 && n <= len(arr) ? arr[len(arr) - n] : 0;
	}
	public static boolean nthLastOf(boolean[] arr, int n) {
		return n > 0 && n <= len(arr) ? arr[len(arr) - n] : false;
	}
	public static String nthLastOf(StrArr arr, int n) {
		return n > 0 && n <= len(arr) ? arr.lasti(n) : "";
	}
	public static int nthLastOf(IntArr arr, int n) {
		return n > 0 && n <= len(arr) ? arr.lasti(n) : 0;
	}
	public static long nthLastOf(LongArr arr, int n) {
		return n > 0 && n <= len(arr) ? arr.lasti(n) : 0;
	}
	public static float nthLastOf(FltArr arr, int n) {
		return n > 0 && n <= len(arr) ? arr.lasti(n) : 0;
	}
	public static double nthLastOf(DblArr arr, int n) {
		return n > 0 && n <= len(arr) ? arr.lasti(n) : 0;
	}
	public static boolean nthLastOf(BoolArr arr, int n) {
		return n > 0 && n <= len(arr) ? arr.lasti(n) : false;
	}
	public static String secondLastOf(String str) {
		return len(str) - 2 >= 0 ? ("" + str.toCharArray()[len(str) - 2]) : "";
	}
	public static String secondLastOf(String[] arr) {
		return len(arr) - 2 >= 0 ? arr[len(arr) - 2] : "";
	}
	public static int secondLastOf(int[] arr) {
		return len(arr) - 2 >= 0 ? arr[len(arr) - 2] : 0;
	}
	public static long secondLastOf(long[] arr) {
		return len(arr) - 2 >= 0 ? arr[len(arr) - 2] : 0;
	}
	public static float secondLastOf(float[] arr) {
		return len(arr) - 2 >= 0 ? arr[len(arr) - 2] : 0;
	}
	public static double secondLastOf(double[] arr) {
		return len(arr) - 2 >= 0 ? arr[len(arr) - 2] : 0;
	}
	public static boolean secondLastOf(boolean[] arr) {
		return len(arr) - 2 >= 0 ? arr[len(arr) - 2] : false;
	}
	public static String lastOf(String str) {
		return len(str) - 1 >= 0 ? ("" + str.toCharArray()[len(str) - 1]) : "";
	}
	public static String lastOf(String[] arr) {
		return len(arr) - 1 >= 0 ? arr[len(arr) - 1] : "";
	}
	public static int lastOf(int[] arr) {
		return len(arr) - 1 >= 0 ? arr[len(arr) - 1] : 0;
	}
	public static long lastOf(long[] arr) {
		return len(arr) - 1 >= 0 ? arr[len(arr) - 1] : 0;
	}
	public static float lastOf(float[] arr) {
		return len(arr) - 1 >= 0 ? arr[len(arr) - 1] : 0;
	}
	public static double lastOf(double[] arr) {
		return len(arr) - 1 >= 0 ? arr[len(arr) - 1] : 0;
	}
	public static boolean lastOf(boolean[] arr) {
		return len(arr) - 1 >= 0 ? arr[len(arr) - 1] : false;
	}
	public static String secondLastOf(StrArr arr) {
		return len(arr) - 2 >= 0 ? arr.seclast() : "";
	}
	public static String lastOf(StrArr arr) {
		return len(arr) - 1 >= 0 ? arr.last() : "";
	}
	public static int secondLastOf(IntArr arr) {
		return len(arr) - 2 >= 0 ? arr.seclast() : 0;
	}
	public static int lastOf(IntArr arr) {
		return len(arr) - 1 >= 0 ? arr.last() : 0;
	}
	public static float secondLastOf(LongArr arr) {
		return len(arr) - 2 >= 0 ? arr.seclast() : 0;
	}
	public static float lastOf(LongArr arr) {
		return len(arr) - 1 >= 0 ? arr.last() : 0;
	}
	public static float secondLastOf(FltArr arr) {
		return len(arr) - 2 >= 0 ? arr.seclast() : 0;
	}
	public static float lastOf(FltArr arr) {
		return len(arr) - 1 >= 0 ? arr.last() : 0;
	}
	public static double secondLastOf(DblArr arr) {
		return len(arr) - 2 >= 0 ? arr.seclast() : 0;
	}
	public static double lastOf(DblArr arr) {
		return len(arr) - 1 >= 0 ? arr.last() : 0;
	}
	public static boolean secondLastOf(BoolArr arr) {
		return len(arr) - 2 >= 0 ? arr.seclast() : false;
	}
	public static boolean lastOf(BoolArr arr) {
		return len(arr) - 1 >= 0 ? arr.last() : false;
	}
	public static int indexOf(String inStr, String lookupStr) {
		return inStr.indexOf(lookupStr);
	}
	public static int indexOf(String inStr, char lookupCh) {
		for (int i = 0; i < len(inStr); i++) {
			if (inStr.toCharArray()[i] == lookupCh)
				return i;
		}
		return -1;
	}
	public static int lastIndexOf(String inStr, String lookupStr) {
		return inStr.lastIndexOf(lookupStr);
	}
	public static int lastIndexOf(String inStr, char lookupCh) {
		for (int i = len(inStr) - 1; i >= 0; i--) {
			if (inStr.toCharArray()[i] == lookupCh)
				return i;
		}
		return -1;
	}
	public static int indexOf(String[] inStrArr, String lookupStr) {
		for (int i = 0; i < len(inStrArr); i++) {
			if (inStrArr[i].equals(lookupStr))
				return i;
		}
		return -1;
	}
	public static int lastIndexOf(String[] inStrArr, String lookupStr) {
		for (int i = len(inStrArr) - 1; i >= 0; i--) {
			if (inStrArr[i].equals(lookupStr))
				return i;
		}
		return -1;
	}
	public static int indexOf(int[] inIntArr, int lookupInt) {
		for (int i = 0; i < len(inIntArr); i++) {
			if (inIntArr[i] == lookupInt)
				return i;
		}
		return -1;
	}
	public static int lastIndexOf(int[] inIntArr, int lookupInt) {
		for (int i = len(inIntArr) - 1; i >= 0; i--) {
			if (inIntArr[i] == lookupInt)
				return i;
		}
		return -1;
	}
	public static int indexOf(long[] inLongArr, long lookupLong) {
		for (int i = 0; i < len(inLongArr); i++) {
			if (inLongArr[i] == lookupLong)
				return i;
		}
		return -1;
	}
	public static int lastIndexOf(long[] inLongArr, long lookupLong) {
		for (int i = len(inLongArr) - 1; i >= 0; i--) {
			if (inLongArr[i] == lookupLong)
				return i;
		}
		return -1;
	}
	public static int indexOf(float[] inFltArr, float lookupFlt) {
		for (int i = 0; i < len(inFltArr); i++) {
			if (inFltArr[i] == lookupFlt)
				return i;
		}
		return -1;
	}
	public static int lastIndexOf(float[] inFloatArr, float lookupFloat) {
		for (int i = len(inFloatArr) - 1; i >= 0; i--) {
			if (inFloatArr[i] == lookupFloat)
				return i;
		}
		return -1;
	}
	public static int indexOf(double[] inDblArr, double lookupDbl) {
		for (int i = 0; i < len(inDblArr); i++) {
			if (inDblArr[i] == lookupDbl)
				return i;
		}
		return -1;
	}
	public static int lastIndexOf(double[] inDblArr, double lookupDbl) {
		for (int i = len(inDblArr) - 1; i >= 0; i--) {
			if (inDblArr[i] == lookupDbl)
				return i;
		}
		return -1;
	}
	public static int indexOf(boolean[] inBoolArr, boolean lookupBool) {
		for (int i = 0; i < len(inBoolArr); i++) {
			if (inBoolArr[i] == lookupBool)
				return i;
		}
		return -1;
	}
	public static int lastIndexOf(boolean[] inBoolArr, boolean lookupBool) {
		for (int i = len(inBoolArr) - 1; i >= 0; i--) {
			if (inBoolArr[i] == lookupBool)
				return i;
		}
		return -1;
	}
	public static int indexOf(StrArr arr, String s) {
		return arr.indexOf(s);
	}
	public static int lastIndexOf(StrArr arr, String s) {
		return arr.lastIndexOf(s);
	}
	public static int indexOf(IntArr arr, int n) {
		return arr.indexOf(n);
	}
	public static int lastIndexOf(IntArr arr, int n) {
		return arr.lastIndexOf(n);
	}
	public static int indexOf(LongArr arr, long n) {
		return arr.indexOf(n);
	}
	public static int lastIndexOf(LongArr arr, long n) {
		return arr.lastIndexOf(n);
	}
	public static int indexOf(FltArr arr, float n) {
		return arr.indexOf(n);
	}
	public static int lastIndexOf(FltArr arr, float n) {
		return arr.lastIndexOf(n);
	}
	public static int indexOf(DblArr arr, double n) {
		return arr.indexOf(n);
	}
	public static int lastIndexOf(DblArr arr, double n) {
		return arr.lastIndexOf(n);
	}
	public static int indexOf(BoolArr arr, boolean b) {
		return arr.indexOf(b);
	}
	public static int lastIndexOf(BoolArr arr, boolean b) {
		return arr.lastIndexOf(b);
	}
	public static int numberOfOccurrencesIn(String inStr, char lookupCh) {
		int occurrences = 0;
		for (int i = 0; i < len(inStr); i++) {
			if (inStr.toCharArray()[i] == lookupCh)
				occurrences++;
		}
		return occurrences;
	}
	public static int numberOfOccurrencesIn(String inStr, String lookupStr) {
		int occurrences = 0;
		for (int i = 0; i < len(inStr); i++) {
			if (inStr.toCharArray()[i] == lookupStr.charAt(0))
				occurrences++;
		}
		return occurrences;
	}
	public static int numberOfOccurrencesIn(String[] inStrArr,
											String lookupStr) {
		int occurrences = 0;
		for (int i = 0; i < len(inStrArr); i++) {
			if (inStrArr[i].equals(lookupStr))
				occurrences++;
		}
		return occurrences;
	}
	public static int numberOfOccurrencesIn(int[] inIntArr, int lookupInt) {
		int occurrences = 0;
		for (int i = 0; i < len(inIntArr); i++) {
			if (inIntArr[i] == lookupInt)
				occurrences++;
		}
		return occurrences;
	}
	public static int numberOfOccurrencesIn(long[] inLongArr, long lookupLong) {
		int occurrences = 0;
		for (int i = 0; i < len(inLongArr); i++) {
			if (inLongArr[i] == lookupLong)
				occurrences++;
		}
		return occurrences;
	}
	public static int numberOfOccurrencesIn(float[] inFltArr, float lookupFlt) {
		int occurrences = 0;
		for (int i = 0; i < len(inFltArr); i++) {
			if (inFltArr[i] == lookupFlt)
				occurrences++;
		}
		return occurrences;
	}
	public static int numberOfOccurrencesIn(double[] inDblArr,
											double lookupDbl) {
		int occurrences = 0;
		for (int i = 0; i < len(inDblArr); i++) {
			if (inDblArr[i] == lookupDbl)
				occurrences++;
		}
		return occurrences;
	}
	public static int numberOfOccurrencesIn(boolean[] inBoolArr,
											boolean lookupBool) {
		int occurrences = 0;
		for (int i = 0; i < len(inBoolArr); i++) {
			if (inBoolArr[i] == lookupBool)
				occurrences++;
		}
		return occurrences;
	}
	public static boolean in(String inStr, char ch) {
		return indexOf(inStr, ch) >= 0;
	}
	public static boolean in(String strA, String strB) {
		return indexOf(lower(strA), lower(strB)) >= 0 || match(strA, strB);
	}
	public static boolean in(String[] arr, String str) {
		return indexOf(arr, str) >= 0;
	}
	public static boolean in(int[] arr, int n) {
		return indexOf(arr, n) >= 0;
	}
	public static boolean in(long[] arr, long n) {
		return indexOf(arr, n) >= 0;
	}
	public static boolean in(float[] arr, float n) {
		return indexOf(arr, n) >= 0;
	}
	public static boolean in(double[] arr, double n) {
		return indexOf(arr, n) >= 0;
	}
	public static boolean in(boolean[] arr, boolean bool) {
		return indexOf(arr, bool) >= 0;
	}
	public static boolean in(Object[] arr, Object targetValue) {
		if (arr == null || targetValue == null) {
			return false;
		}
		for (Object element : arr) {
			if (targetValue.equals(element)) {
				return true;
			}
		}
		return false;
	}
	public static boolean contains(String str, char lookupCh) {
		return in(str, lookupCh);
	}
	public static boolean contains(String str, String lookupStr) {
		return in(str, lookupStr);
	}
	public static boolean contains(String[] arr, String lookupStr) {
		return in(arr, lookupStr);
	}
	public static boolean contains(int[] arr, int lookupInt) {
		return in(arr, lookupInt);
	}
	public static boolean contains(long[] arr, long lookupLong) {
		return in(arr, lookupLong);
	}
	public static boolean contains(float[] arr, float lookupFloat) {
		return in(arr, lookupFloat);
	}
	public static boolean contains(double[] arr, double lookupDbl) {
		return in(arr, lookupDbl);
	}
	public static boolean contains(boolean[] arr, boolean lookupBool) {
		return in(arr, lookupBool);
	}
	public static boolean contains(Object[] arr, Object targetValue) {
		return in(arr, targetValue);
	}
	public static boolean match(String str, String re, boolean... bools) {
		if (re.equals(".") || re.equals("*") || re.equals("+")
				|| re.equals("?"))
			re = "\\" + re;
		re = re.replaceAll("(?<!\\\\)\\.(?![*+])", "\\\\.")
			 .replaceAll("%w", "[A-Za-z]+").replaceAll("%c", "[A-Za-z]")
			 .replaceAll("%s", "[A-Za-z][\\\\w]+")
			 .replaceAll("%d", "\\\\d+");
		//System.out.println("00"+re);
		// modification precaution: it has been tested, and hence learned,
		// the
		// double-escaping remains AS-IS
		// escape tricky characters, if they're the only content: helps avoid
		// false positives as a "." or a "*" alone, can match just anything;.
		// Needless to say, these quantifiers, along with a "+" and an
		// optionality quantifier, i.e. a "?" quantifier, might also cause
		// memory heap to exceed
		// plus, handling both, standard and custom, format specifiers
		boolean strict = false;
		if (is(bools))
			strict = bools[0] == true;
		Pattern pattern = Pattern.compile(re,
										  strict ? 0 : Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(str);
		return !!matcher.find();
	}
	public static String findMatch(String str, String re, boolean... bools) {
		if (re.equals(".") || re.equals("*") || re.equals("+")
				|| re.equals("?")) {
			re = "\\" + re;
		}
		re = re.replaceAll("(?<!\\\\)\\.(?![*+])", "\\\\.")
			 .replaceAll("%w", "[A-Za-z]+").replaceAll("%c", "[A-Za-z]")
			 .replaceAll("%s", "[A-Za-z][\\\\w]+")
			 .replaceAll("%d", "\\\\d+");
		// modification precaution: it has been tested, and hence learned,
		// the
		// double-escaping remains AS-IS
		// escape tricky characters, if they're the only content: helps avoid
		// false positives as a "." or a "*" alone, can match just anything;.
		// Needless to say, these quantifiers, along with a "+" and an
		// optionality quantifier, i.e. a "?" quantifier, might also cause
		// memory heap to exceed
		// plus, handling both, standard and custom, format specifiers
		boolean strict = false;
		if (is(bools)) {
			strict = bools[0] == true;
		}
		Pattern pattern = Pattern.compile("(" + re + ")",
										  strict ? 0 : Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(str);
		if (!matcher.find())
			return "";
		return matcher.group();
	}
	public static String[] findMatches(String str, String re, boolean... bools) {
		if (re.equals(".") || re.equals("*") || re.equals("+")
				|| re.equals("?")) {
			re = "\\" + re;
		}
		re = re.replaceAll("(?<!\\\\)\\.(?![*+])", "\\\\.")
			 .replaceAll("%w", "[A-Za-z]+").replaceAll("%c", "[A-Za-z]")
			 .replaceAll("%s", "[A-Za-z][\\\\w]+")
			 .replaceAll("%d", "\\\\d+")
			 .replaceAll("%f", "([\\\\d])*[\\\\.]\\\\d+");
		// modification precaution: it has been tested, and hence learned,
		// the
		// double-escaping remains AS-IS
		// escape tricky characters, if they're the only content: helps avoid
		// false positives as a "." or a "*" alone, can match just anything;.
		// Needless to say, these quantifiers, along with a "+" and an
		// optionality quantifier, i.e. a "?" quantifier, might also cause
		// memory heap to exceed
		// plus, handling both, standard and custom, format specifiers
		boolean strict = false;
		if (is(bools)) {
			strict = bools[0] == true;
		}
		Pattern pattern = Pattern.compile("(" + re + ")", strict ? 0 : Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(str);
		StrArr arr = new StrArr();
		while (matcher.find())
			arr.push(matcher.group());
		return arr.array();
	}
	public static int[] intsOf(String s) {
		IntArr arr = new IntArr();
		String[] matches = findMatches(s, "(?<!\\.)(\\d+)(?!\\.)");
		for (int i : range(matches))
			arr.push(Int(matches[i]));
		return arr.array();
	}
	public static int[] intsOf(Object... objs) {
		IntArr resultantArr = new IntArr();
		for (Object obj : objs) {
			if (obj instanceof Integer)
				resultantArr.push((int) obj);
		}
		return resultantArr.array();
	}
	public static float[] fltsOf(String s) {
		FltArr arr = new FltArr();
		String[] matches = findMatches(s, "\\d*\\.\\d+");
		for (int i : range(matches))
			arr.push(Flt(matches[i]));
		return arr.array();
	}
	public static float[] fltsOf(Object... objs) {
		FltArr resultantArr = new FltArr();
		for (Object obj : objs) {
			if (obj instanceof Float)
				resultantArr.push((float) obj);
		}
		return resultantArr.array();
	}
	public static double[] dblsOf(String s) {
		DblArr arr = new DblArr();
		String[] matches = findMatches(s, "[\\d]*\\.\\d+");
		for (int i : range(matches))
			arr.push(Dbl(matches[i]));
		return arr.array();
	}
	public static double[] dblsOf(Object... objs) {
		DblArr resultantArr = new DblArr();
		for (Object obj : objs) {
			if (obj instanceof Double)
				resultantArr.push((double) obj);
		}
		return resultantArr.array();
	}
	public static int[] findInts(String s) {
		return intsOf(s);
	}
	public static int[] findInts(Object... objs) {
		return intsOf(objs);
	}
	public static float[] findFlts(String s) {
		return fltsOf(s);
	}
	public static float[] findFlts(Object... objs) {
		return fltsOf(objs);
	}
	public static double[] findDbls(String s) {
		return dblsOf(s);
	}
	public static double[] findDbls(Object... objs) {
		return dblsOf(objs);
	}
	public static boolean intsIn(String s) {
		return intsOf(s).length > 0;
	}
	public static boolean intsIn(Object... objs) {
		return intsOf(objs).length > 0;
	}
	public static boolean fltsIn(String s) {
		return fltsOf(s).length > 0;
	}
	public static boolean fltsIn(Object... objs) {
		return fltsOf(objs).length > 0;
	}
	public static boolean dblsIn(String s) {
		return dblsOf(s).length > 0;
	}
	public static boolean dblsIn(Object... objs) {
		return dblsOf(objs).length > 0;
	}
	public static boolean match(String[] arrA, String[] arrB) {
		return Arrays.compare(arrA, arrB) >= 0;
		// returns a negative value if true, just like with most functions in C,
		// or C++
	}
	public static boolean match(int[] arrA, int[] arrB) {
		return Arrays.compare(arrA, arrB) >= 0;
		// returns a negative value if true, just like with most functions in C,
		// or C++
	}
	public static boolean match(long[] arrA, long[] arrB) {
		return Arrays.compare(arrA, arrB) >= 0;
		// returns a negative value if true, just like with most functions in C,
		// or C++
	}
	public static boolean match(float[] arrA, float[] arrB) {
		return Arrays.compare(arrA, arrB) >= 0;
		// returns a negative value if true, just like with most functions in C,
		// or C++
	}
	public static boolean match(double[] arrA, double[] arrB) {
		return Arrays.compare(arrA, arrB) >= 0;
		// returns a negative value if true, just like with most functions in C,
		// or C++
	}
	public static boolean match(boolean[] arrA, boolean[] arrB) {
		return Arrays.compare(arrA, arrB) >= 0;
		// returns a negative value if true, just like with most functions in C,
		// or C++
	}
	public static boolean compare(String strA, String strB) {
		return match(strA, strB);
	}
	public static boolean compare(String[] arrA, String[] arrB) {
		return match(arrA, arrB);
	}
	public static boolean compare(int[] arrA, int[] arrB) {
		return match(arrA, arrB);
	}
	public static boolean compare(long[] arrA, long[] arrB) {
		return match(arrA, arrB);
	}
	public static boolean compare(float[] arrA, float[] arrB) {
		return match(arrA, arrB);
	}
	public static boolean compare(double[] arrA, double[] arrB) {
		return match(arrA, arrB);
	}
	public static boolean compare(boolean[] arrA, boolean[] arrB) {
		return match(arrA, arrB);
	}
	public static String[] clone(String[] arr) {
		return slice(arr);
	}
	public static int[] clone(int[] arr) {
		return slice(arr);
	}
	public static long[] clone(long[] arr) {
		return slice(arr);
	}
	public static float[] clone(float[] arr) {
		return slice(arr);
	}
	public static double[] clone(double[] arr) {
		return slice(arr);
	}
	public static boolean[] clone(boolean[] arr) {
		return slice(arr);
	}
	public static StrArr clone(StrArr arr) {
		return slice(arr);
	}
	public static IntArr clone(IntArr arr) {
		return slice(arr);
	}
	public static LongArr clone(LongArr arr) {
		return slice(arr);
	}
	public static FltArr clone(FltArr arr) {
		return slice(arr);
	}
	public static DblArr clone(DblArr arr) {
		return slice(arr);
	}
	public static BoolArr clone(BoolArr arr) {
		return slice(arr);
	}
	public static Tree_S clone(Tree_S arr) {
		return arr.copy();
	}
	public static String[] copyArr(String[] arr) {
		return clone(arr);
	}
	public static int[] copyArr(int[] arr) {
		return clone(arr);
	}
	public static long[] copyArr(long[] arr) {
		return clone(arr);
	}
	public static float[] copyArr(float[] arr) {
		return clone(arr);
	}
	public static double[] copyArr(double[] arr) {
		return clone(arr);
	}
	public static boolean[] copyArr(boolean[] arr) {
		return clone(arr);
	}
	public static StrArr copyArr(StrArr arr) {
		return clone(arr);
	}
	public static IntArr copyArr(IntArr arr) {
		return clone(arr);
	}
	public static LongArr copyArr(LongArr arr) {
		return clone(arr);
	}
	public static FltArr copyArr(FltArr arr) {
		return clone(arr);
	}
	public static DblArr copyArr(DblArr arr) {
		return clone(arr);
	}
	public static BoolArr copyArr(BoolArr arr) {
		return clone(arr);
	}
	public static String[] combine(String[] arrA, String[] arrB) {
		int length1 = arrA.length;
		int length2 = arrB.length;
		String[] result = new String[length1 + length2];
		System.arraycopy(arrA, 0, result, 0, length1);
		System.arraycopy(arrB, 0, result, length1, length2);
		return result;
	}
	public static int[] combine(int[] arrA, int[] arrB) {
		return IntStream.concat(Arrays.stream(arrA), Arrays.stream(arrB))
			   .toArray();
	}
	public static long[] combine(long[] arrA, long[] arrB) {
		return LongStream.concat(Arrays.stream(arrA), Arrays.stream(arrB))
			   .toArray();
	}
	public static float[] combine(float[] arrA, float[] arrB) {
		int length1 = arrA.length;
		int length2 = arrB.length;
		float[] result = new float[length1 + length2];
		System.arraycopy(arrA, 0, result, 0, length1);
		System.arraycopy(arrB, 0, result, length1, length2);
		return result;
	}
	public static double[] combine(double[] arrA, double[] arrB) {
		return DoubleStream.concat(Arrays.stream(arrA), Arrays.stream(arrB))
			   .toArray();
	}
	public static boolean[] combine(boolean[] arrA, boolean[] arrB) {
		int length1 = arrA.length;
		int length2 = arrB.length;
		boolean[] result = new boolean[length1 + length2];
		System.arraycopy(arrA, 0, result, 0, length1);
		System.arraycopy(arrB, 0, result, length1, length2);
		return result;
	}
	public static StrArr combine(StrArr arrA, StrArr arrB) {
		return arrA.combine(arrB);
	}
	public static IntArr combine(IntArr arrA, IntArr arrB) {
		return arrA.combine(arrB);
	}
	public static LongArr combine(LongArr arrA, LongArr arrB) {
		return arrA.combine(arrB);
	}
	public static FltArr combine(FltArr arrA, FltArr arrB) {
		return arrA.combine(arrB);
	}
	public static DblArr combine(DblArr arrA, DblArr arrB) {
		return arrA.combine(arrB);
	}
	public static BoolArr combine(BoolArr arrA, BoolArr arrB) {
		return arrA.combine(arrB);
	}
	public static String[] intersection(String[] arrA, String[] arrB) {
		StrArr result = new StrArr();
		for (int i : range(arrA)) {
			for (int j : range(arrB)) {
				if (eq(arrA[i], arrB[j]))
					result.push(arrA[i]);
			}
		}
		return result.array();
	}
	public static int[] intersection(int[] arrA, int[] arrB) {
		IntArr result = new IntArr();
		for (int i : range(arrA)) {
			for (int j : range(arrB)) {
				if (eq(arrA[i], arrB[j]))
					result.push(arrA[i]);
			}
		}
		return result.array();
	}
	public static long[] intersection(long[] arrA, long[] arrB) {
		LongArr result = new LongArr();
		for (int i : range(arrA)) {
			for (int j : range(arrB)) {
				if (eq(arrA[i], arrB[j]))
					result.push(arrA[i]);
			}
		}
		return result.array();
	}
	public static float[] intersection(float[] arrA, float[] arrB) {
		FltArr result = new FltArr();
		for (int i : range(arrA)) {
			for (int j : range(arrB)) {
				if (eq(arrA[i], arrB[j]))
					result.push(arrA[i]);
			}
		}
		return result.array();
	}
	public static double[] intersection(double[] arrA, double[] arrB) {
		DblArr result = new DblArr();
		for (int i : range(arrA)) {
			for (int j : range(arrB)) {
				if (eq(arrA[i], arrB[j]))
					result.push(arrA[i]);
			}
		}
		return result.array();
	}
	public static boolean[] intersection(boolean[] arrA, boolean[] arrB) {
		BoolArr result = new BoolArr();
		for (int i : range(arrA)) {
			for (int j : range(arrB)) {
				if (eq(arrA[i], arrB[j]))
					result.push(arrA[i]);
			}
		}
		return result.array();
	}
	public static StrArr intersection(StrArr arrA, StrArr arrB) {
		return arrA.intersection(arrB);
	}
	public static IntArr intersection(IntArr arrA, IntArr arrB) {
		return arrA.intersection(arrB);
	}
	public static LongArr intersection(LongArr arrA, LongArr arrB) {
		return arrA.intersection(arrB);
	}
	public static FltArr intersection(FltArr arrA, FltArr arrB) {
		return arrA.intersection(arrB);
	}
	public static DblArr intersection(DblArr arrA, DblArr arrB) {
		return arrA.intersection(arrB);
	}
	public static BoolArr intersection(BoolArr arrA, BoolArr arrB) {
		return arrA.intersection(arrB);
	}
	public static String[] keepIfMatch(String[] arrA, String... arrB) {
		return intersection(arrA, arrB);
	}
	public static int[] keepIfMatch(int[] arrA, int... arrB) {
		return intersection(arrA, arrB);
	}
	public static long[] keepIfMatch(long[] arrA, long... arrB) {
		return intersection(arrA, arrB);
	}
	public static float[] keepIfMatch(float[] arrA, float... arrB) {
		return intersection(arrA, arrB);
	}
	public static double[] keepIfMatch(double[] arrA, double... arrB) {
		return intersection(arrA, arrB);
	}
	public static boolean[] keepIfMatch(boolean[] arrA, boolean... arrB) {
		return intersection(arrA, arrB);
	}
	public static StrArr keepIfMatch(StrArr arrA, StrArr arrB) {
		return intersection(arrA, arrB);
	}
	public static IntArr keepIfMatch(IntArr arrA, IntArr arrB) {
		return intersection(arrA, arrB);
	}
	public static LongArr keepIfMatch(LongArr arrA, LongArr arrB) {
		return intersection(arrA, arrB);
	}
	public static FltArr keepIfMatch(FltArr arrA, FltArr arrB) {
		return intersection(arrA, arrB);
	}
	public static DblArr keepIfMatch(DblArr arrA, DblArr arrB) {
		return intersection(arrA, arrB);
	}
	public static BoolArr keepIfMatch(BoolArr arrA, BoolArr arrB) {
		return intersection(arrA, arrB);
	}
	public static String[] onlyKeep(String[] arrA, String... arrB) {
		return intersection(arrA, arrB);
	}
	public static int[] onlyKeep(int[] arrA, int... arrB) {
		return intersection(arrA, arrB);
	}
	public static long[] onlyKeep(long[] arrA, long... arrB) {
		return intersection(arrA, arrB);
	}
	public static float[] onlyKeep(float[] arrA, float... arrB) {
		return intersection(arrA, arrB);
	}
	public static double[] onlyKeep(double[] arrA, double... arrB) {
		return intersection(arrA, arrB);
	}
	public static boolean[] onlyKeep(boolean[] arrA, boolean... arrB) {
		return intersection(arrA, arrB);
	}
	public static StrArr onlyKeep(StrArr arrA, StrArr arrB) {
		return intersection(arrA, arrB);
	}
	public static IntArr onlyKeep(IntArr arrA, IntArr arrB) {
		return intersection(arrA, arrB);
	}
	public static LongArr onlyKeep(LongArr arrA, LongArr arrB) {
		return intersection(arrA, arrB);
	}
	public static FltArr onlyKeep(FltArr arrA, FltArr arrB) {
		return intersection(arrA, arrB);
	}
	public static DblArr onlyKeep(DblArr arrA, DblArr arrB) {
		return intersection(arrA, arrB);
	}
	public static BoolArr onlyKeep(BoolArr arrA, BoolArr arrB) {
		return intersection(arrA, arrB);
	}
	public static String[] negativeIntersection(String[] arrA, String... arrB) {
		StrArr result = new StrArr(arrA);
		for (int i : range(arrB)) {
			if (in(arrA, arrB[i]))
				result.pop(arrB[i]);
		}
		return result.array();
	}
	public static int[] negativeIntersection(int[] arrA, int... arrB) {
		IntArr result = new IntArr(arrA);
		for (int i : range(arrB)) {
			if (in(arrA, arrB[i]))
				result.pop(arrB[i]);
		}
		return result.array();
	}
	public static long[] negativeIntersection(long[] arrA, long... arrB) {
		LongArr result = new LongArr(arrA);
		for (int i : range(arrB)) {
			if (in(arrA, arrB[i]))
				result.pop(arrB[i]);
		}
		return result.array();
	}
	public static float[] negativeIntersection(float[] arrA, float... arrB) {
		FltArr result = new FltArr(arrA);
		for (int i : range(arrB)) {
			if (in(arrA, arrB[i]))
				result.pop(arrB[i]);
		}
		return result.array();
	}
	public static double[] negativeIntersection(double[] arrA, double... arrB) {
		DblArr result = new DblArr(arrA);
		for (int i : range(arrB)) {
			if (in(arrA, arrB[i]))
				result.pop(arrB[i]);
		}
		return result.array();
	}
	public static boolean[] negativeIntersection(boolean[] arrA,
			boolean... arrB) {
		BoolArr result = new BoolArr(arrA);
		for (int i : range(arrB)) {
			if (in(arrA, arrB[i]))
				result.pop(arrB[i]);
		}
		return result.array();
	}
	public static StrArr negativeIntersection(StrArr arrA, StrArr arrB) {
		return arrA.negativeIntersection(arrB);
	}
	public static IntArr negativeIntersection(IntArr arrA, IntArr arrB) {
		return arrA.negativeIntersection(arrB);
	}
	public static LongArr negativeIntersection(LongArr arrA, LongArr arrB) {
		return arrA.negativeIntersection(arrB);
	}
	public static FltArr negativeIntersection(FltArr arrA, FltArr arrB) {
		return arrA.negativeIntersection(arrB);
	}
	public static DblArr negativeIntersection(DblArr arrA, DblArr arrB) {
		return arrA.negativeIntersection(arrB);
	}
	public static BoolArr negativeIntersection(BoolArr arrA, BoolArr arrB) {
		return arrA.negativeIntersection(arrB);
	}
	public static String[] popIfMatch(String[] arrA, String... arrB) {
		return negativeIntersection(arrA, arrB);
	}
	public static int[] popIfMatch(int[] arrA, int... arrB) {
		return negativeIntersection(arrA, arrB);
	}
	public static long[] popIfMatch(long[] arrA, long... arrB) {
		return negativeIntersection(arrA, arrB);
	}
	public static float[] popIfMatch(float[] arrA, float... arrB) {
		return negativeIntersection(arrA, arrB);
	}
	public static double[] popIfMatch(double[] arrA, double... arrB) {
		return negativeIntersection(arrA, arrB);
	}
	public static boolean[] popIfMatch(boolean[] arrA, boolean... arrB) {
		return negativeIntersection(arrA, arrB);
	}
	public static StrArr popIfMatch(StrArr arrA, StrArr arrB) {
		return negativeIntersection(arrA, arrB);
	}
	public static IntArr popIfMatch(IntArr arrA, IntArr arrB) {
		return negativeIntersection(arrA, arrB);
	}
	public static LongArr popIfMatch(LongArr arrA, LongArr arrB) {
		return negativeIntersection(arrA, arrB);
	}
	public static FltArr popIfMatch(FltArr arrA, FltArr arrB) {
		return negativeIntersection(arrA, arrB);
	}
	public static DblArr popIfMatch(DblArr arrA, DblArr arrB) {
		return negativeIntersection(arrA, arrB);
	}
	public static BoolArr popIfMatch(BoolArr arrA, BoolArr arrB) {
		return negativeIntersection(arrA, arrB);
	}
	public static String[] popAll(String[] arrA, String... arrB) {
		return negativeIntersection(arrA, arrB);
	}
	public static int[] popAll(int[] arrA, int... arrB) {
		return negativeIntersection(arrA, arrB);
	}
	public static long[] popAll(long[] arrA, long... arrB) {
		return negativeIntersection(arrA, arrB);
	}
	public static float[] popAll(float[] arrA, float... arrB) {
		return negativeIntersection(arrA, arrB);
	}
	public static double[] popAll(double[] arrA, double... arrB) {
		return negativeIntersection(arrA, arrB);
	}
	public static boolean[] popAll(boolean[] arrA, boolean... arrB) {
		return negativeIntersection(arrA, arrB);
	}
	public static StrArr popAll(StrArr arrA, StrArr arrB) {
		return negativeIntersection(arrA, arrB);
	}
	public static IntArr popAll(IntArr arrA, IntArr arrB) {
		return negativeIntersection(arrA, arrB);
	}
	public static LongArr popAll(LongArr arrA, LongArr arrB) {
		return negativeIntersection(arrA, arrB);
	}
	public static FltArr popAll(FltArr arrA, FltArr arrB) {
		return negativeIntersection(arrA, arrB);
	}
	public static DblArr popAll(DblArr arrA, DblArr arrB) {
		return negativeIntersection(arrA, arrB);
	}
	public static BoolArr popAll(BoolArr arrA, BoolArr arrB) {
		return negativeIntersection(arrA, arrB);
	}
	public static String[] onlyPop(String[] arrA, String... arrB) {
		return negativeIntersection(arrA, arrB);
	}
	public static int[] onlyPop(int[] arrA, int... arrB) {
		return negativeIntersection(arrA, arrB);
	}
	public static long[] onlyPop(long[] arrA, long... arrB) {
		return negativeIntersection(arrA, arrB);
	}
	public static float[] onlyPop(float[] arrA, float... arrB) {
		return negativeIntersection(arrA, arrB);
	}
	public static double[] onlyPop(double[] arrA, double... arrB) {
		return negativeIntersection(arrA, arrB);
	}
	public static boolean[] onlyPop(boolean[] arrA, boolean... arrB) {
		return negativeIntersection(arrA, arrB);
	}
	public static StrArr onlyPop(StrArr arrA, StrArr arrB) {
		return negativeIntersection(arrA, arrB);
	}
	public static IntArr onlyPop(IntArr arrA, IntArr arrB) {
		return negativeIntersection(arrA, arrB);
	}
	public static LongArr onlyPop(LongArr arrA, LongArr arrB) {
		return negativeIntersection(arrA, arrB);
	}
	public static FltArr onlyPop(FltArr arrA, FltArr arrB) {
		return negativeIntersection(arrA, arrB);
	}
	public static DblArr onlyPop(DblArr arrA, DblArr arrB) {
		return negativeIntersection(arrA, arrB);
	}
	public static BoolArr onlyPop(BoolArr arrA, BoolArr arrB) {
		return negativeIntersection(arrA, arrB);
	}
	public static String upper(String s) {
		s = s.toUpperCase();
		return s;
	}
	public static String[] upper(String... arr) {
		if (not(arr)) return arr;
		arr = map(arr, KL::upper);
		return arr;
	}
	public static char upper(char c) {
		c = Str(c).toUpperCase().charAt(0);
		return c;
	}
	public static char[] upper(char... arr) {
		if (not(arr)) return arr;
		arr = map(arr, KL::upper);
		return arr;
	}
	public static String lower(String s) {
		s = s.toLowerCase();
		return s;
	}
	public static String[] lower(String... arr) {
		if (not(arr)) return arr;
		arr = map(arr, KL::lower);
		return arr;
	}
	public static char lower(char c) {
		c = Str(c).toLowerCase().charAt(0);
		return c;
	}
	public static boolean inUpper(String s) {
		return upper(s).equals(s);
	}
	public static boolean inUpper(char c) {
		return upper(c) == c;
	}
	public static boolean notInUpper(String s) {
		return !inUpper(s);
	}
	public static boolean notInUpper(char c) {
		return !inUpper(c);
	}
	public static boolean inLower(String s) {
		return lower(s).equals(s);
	}
	public static boolean inLower(char c) {
		return lower(c) == c;
	}
	public static boolean notInLower(String s) {
		return !inLower(s);
	}
	public static boolean notInLower(char c) {
		return !inLower(c);
	}
	public static String sentCase(String input) {
		input = (input.toUpperCase().substring(0, 1)
				 + (!in(input, "[A-Z]{2,}") ? input.toLowerCase() : input)
				 .substring(1))
				.replaceAll("(?<!\\w)i(?!\\w)", "I");
		return input;
	}
	public static String[] sentCase(String... inputs) {
		inputs = map(inputs, KL::sentCase);
		return inputs;
	}
	public static String titleCase(String input) {
		String[] parts = input.split("");
		String result = "";
		boolean nextTitleCase = true;
		for (String c : parts) {
			if (eq(c, " ")) {
				nextTitleCase = true;
			} else if (nextTitleCase) {
				c = upper(c);
				nextTitleCase = false;
			}
			result += "" + c;
		}
		return result;
	}
	public static String[] titleCase(String... inputs) {
		inputs = map(inputs, KL::titleCase);
		return inputs;
	}
	public static String reverse(String str) {
		return new StringBuilder(str).reverse().toString();
	}
	public static int len(String str) {
		return str.trim().length();
	}
	public static int len(int n) {
		int result = 0;
		while (n > 0) {
			n /= 10;
			result++;
		}
		return result;
	}
	public static int len(long n) {
		int result = 0;
		while (n > 0) {
			n /= 10;
			result++;
		}
		return result;
	}
	public static int len(char[] arr) {
		return arr.length;
	}
	public static int len(String arr[]) {
		return arr.length;
	}
	public static int len(int arr[]) {
		return arr.length;
	}
	public static int len(long arr[]) {
		return arr.length;
	}
	public static int len(float arr[]) {
		return arr.length;
	}
	public static int len(double arr[]) {
		return arr.length;
	}
	public static int len(boolean arr[]) {
		return arr.length;
	}
	public static int len(Object arr[]) {
		return arr.length;
	}
	public static int len(StrArr arr) {
		return arr.length();
	}
	public static int len(IntArr arr) {
		return arr.length();
	}
	public static int len(LongArr arr) {
		return arr.length();
	}
	public static int len(FltArr arr) {
		return arr.length();
	}
	public static int len(DblArr arr) {
		return arr.length();
	}
	public static int len(BoolArr arr) {
		return arr.length();
	}
	public static int len(Obj_S o) {
		return o.length();
	}
	public static int len(Obj_I o) {
		return o.length();
	}
	public static int len(Obj_L o) {
		return o.length();
	}
	public static int len(Obj_F o) {
		return o.length();
	}
	public static int len(Obj_D o) {
		return o.length();
	}
	public static int len(Obj_B o) {
		return o.length();
	}
	public static int len(Tree_S t) {
		return t.length();
	}
	public static int len(Tree_I t) {
		return t.length();
	}
	public static int len(Tree_SL t) {
		return t.length();
	}
	public static int len(Tree_L t) {
		return t.length();
	}
	public static int len(Tree_SF t) {
		return t.length();
	}
	public static int len(Tree_F t) {
		return t.length();
	}
	public static int len(Tree_SD t) {
		return t.length();
	}
	public static int len(Tree_D t) {
		return t.length();
	}
	public static int len(Tree_SB t) {
		return t.length();
	}
	public static int len(Tree_B t) {
		return t.length();
	}
	public static int size(String str) {
		return len(str);
	}
	public static int size(int n) {
		return len(n);
	}
	public static int size(long n) {
		return len(n);
	}
	public static int size(String arr[]) {
		return len(arr);
	}
	public static int size(int arr[]) {
		return len(arr);
	}
	public static int size(long arr[]) {
		return len(arr);
	}
	public static int size(float arr[]) {
		return len(arr);
	}
	public static int size(double arr[]) {
		return len(arr);
	}
	public static int size(boolean arr[]) {
		return len(arr);
	}
	public static int size(StrArr arr) {
		return len(arr);
	}
	public static int size(IntArr arr) {
		return len(arr);
	}
	public static int size(LongArr arr) {
		return len(arr);
	}
	public static int size(FltArr arr) {
		return len(arr);
	}
	public static int size(DblArr arr) {
		return len(arr);
	}
	public static int size(BoolArr arr) {
		return len(arr);
	}
	public static int size(Obj_S o) {
		return len(o);
	}
	public static int size(Obj_I o) {
		return len(o);
	}
	public static int size(Obj_L o) {
		return len(o);
	}
	public static int size(Obj_F o) {
		return len(o);
	}
	public static int size(Obj_D o) {
		return len(o);
	}
	public static int size(Obj_B o) {
		return len(o);
	}
	public static int size(Tree_S t) {
		return len(t);
	}
	public static int size(Tree_I t) {
		return len(t);
	}
	public static int size(Tree_SL t) {
		return len(t);
	}
	public static int size(Tree_L t) {
		return len(t);
	}
	public static int size(Tree_SF t) {
		return len(t);
	}
	public static int size(Tree_F t) {
		return len(t);
	}
	public static int size(Tree_SD t) {
		return len(t);
	}
	public static int size(Tree_D t) {
		return len(t);
	}
	public static int size(Tree_SB t) {
		return len(t);
	}
	public static int size(Tree_B t) {
		return len(t);
	}
	public static boolean isEmpty(String s) {
		return 0 == len(s);
	}
	public static boolean isEmpty(String[] arr) {
		return 0 == len(arr);
	}
	public static boolean isEmpty(int[] arr) {
		return 0 == len(arr);
	}
	public static boolean isEmpty(long[] arr) {
		return 0 == len(arr);
	}
	public static boolean isEmpty(float[] arr) {
		return 0 == len(arr);
	}
	public static boolean isEmpty(double[] arr) {
		return 0 == len(arr);
	}
	public static boolean isEmpty(boolean[] arr) {
		return 0 == len(arr);
	}
	public static boolean isEmpty(Object[] arr) {
		return 0 == len(arr);
	}
	public static boolean isEmpty(StrArr arr) {
		return 0 == len(arr) || arr.isEmpty();
	}
	public static boolean isEmpty(IntArr arr) {
		return 0 == len(arr) || arr.isEmpty();
	}
	public static boolean isEmpty(LongArr arr) {
		return 0 == len(arr) || arr.isEmpty();
	}
	public static boolean isEmpty(FltArr arr) {
		return 0 == len(arr) || arr.isEmpty();
	}
	public static boolean isEmpty(DblArr arr) {
		return 0 == len(arr) || arr.isEmpty();
	}
	public static boolean isEmpty(BoolArr arr) {
		return 0 == len(arr) || arr.isEmpty();
	}
	public static boolean isEmpty(Obj_S o) {
		return 0 == len(o) || o.isEmpty();
	}
	public static boolean isEmpty(Obj_I o) {
		return 0 == len(o) || o.isEmpty();
	}
	public static boolean isEmpty(Obj_L o) {
		return 0 == len(o) || o.isEmpty();
	}
	public static boolean isEmpty(Obj_F o) {
		return 0 == len(o) || o.isEmpty();
	}
	public static boolean isEmpty(Obj_D o) {
		return 0 == len(o) || o.isEmpty();
	}
	public static boolean isEmpty(Obj_B o) {
		return 0 == len(o) || o.isEmpty();
	}
	public static boolean isEmpty(Tree_S t) {
		return 0 == len(t) || t.isEmpty();
	}
	public static boolean isEmpty(Tree_I t) {
		return 0 == len(t) || t.isEmpty();
	}
	public static boolean isEmpty(Tree_SL t) {
		return 0 == len(t) || t.isEmpty();
	}
	public static boolean isEmpty(Tree_L t) {
		return 0 == len(t) || t.isEmpty();
	}
	public static boolean isEmpty(Tree_SF t) {
		return 0 == len(t) || t.isEmpty();
	}
	public static boolean isEmpty(Tree_F t) {
		return 0 == len(t) || t.isEmpty();
	}
	public static boolean isEmpty(Tree_SD t) {
		return 0 == len(t) || t.isEmpty();
	}
	public static boolean isEmpty(Tree_D t) {
		return 0 == len(t) || t.isEmpty();
	}
	public static boolean isEmpty(Tree_SB t) {
		return 0 == len(t) || t.isEmpty();
	}
	public static boolean isEmpty(Tree_B t) {
		return 0 == len(t) || t.isEmpty();
	}
	// Arrays
	public static String type(Object o) {
		if (isNull(o))
			return "null";
		String middleware = o.getClass().toString();
		if (!in(middleware, "\\."))
			return "unidentified";
		String result = middleware.split("\\.")[2].toLowerCase();
		return result;
	}
	public static boolean type(Object obj, String guessedType) {
		if (not(obj) || not(guessedType))
			return false;
		return startsWith(type(obj), guessedType);
	}
	// let's set up some "type"-helpers for the function
	public static String Str = "string", Int = "integer", Char = "character",
						 Long = "long", Flt = "float", Dbl = "double", Bool = "boolean";
	public static int[] intArrToIntArr(Integer[] inputArr) {
		int length = inputArr.length;
		int resultingArr[] = new int[length];
		for (int i = 0; i < length; i++)
			resultingArr[i] = inputArr[i];
		return resultingArr;
	}
	public static long[] longArrToLongArr(Long[] inputArr) {
		int length = inputArr.length;
		long resultingArr[] = new long[length];
		for (int i = 0; i < length; i++)
			resultingArr[i] = inputArr[i];
		return resultingArr;
	}
	public static float[] floatArrToFloatArr(Float[] inputArr) {
		int length = inputArr.length;
		float resultingArr[] = new float[length];
		for (int i = 0; i < length; i++)
			resultingArr[i] = inputArr[i];
		return resultingArr;
	}
	public static double[] dblArrToDblArr(Double[] inputArr) {
		int length = inputArr.length;
		double resultingArr[] = new double[length];
		for (int i = 0; i < length; i++)
			resultingArr[i] = inputArr[i];
		return resultingArr;
	}
	public static boolean[] boolArrToBoolArr(Boolean[] inputArr) {
		int length = inputArr.length;
		boolean resultingArr[] = new boolean[length];
		for (int i = 0; i < length; i++)
			resultingArr[i] = inputArr[i];
		return resultingArr;
	}
	public static String[] reverse(String[] arr) {
		return new StrArr(arr).reverse().array();
	}
	public static int[] reverse(int[] arr) {
		return new IntArr(arr).reverse().array();
	}
	public static long[] reverse(long[] arr) {
		return new LongArr(arr).reverse().array();
	}
	public static float[] reverse(float[] arr) {
		return new FltArr(arr).reverse().array();
	}
	public static double[] reverse(double[] arr) {
		return new DblArr(arr).reverse().array();
	}
	public static boolean[] reverse(boolean[] arr) {
		return new BoolArr(arr).reverse().array();
	}
	public static StrArr reverse(StrArr arr) {
		return arr.reverse();
	}
	public static IntArr reverse(IntArr arr) {
		return arr.reverse();
	}
	public static LongArr reverse(LongArr arr) {
		return arr.reverse();
	}
	public static FltArr reverse(FltArr arr) {
		return arr.reverse();
	}
	public static DblArr reverse(DblArr arr) {
		return arr.reverse();
	}
	public static BoolArr reverse(BoolArr arr) {
		return arr.reverse();
	}
	public static String[] sort(String[] arr) {
		return new StrArr(arr).sort().array();
	}
	public static String[] sort(String[] arr, String condition) {
		if (not(arr) || not(condition)) return arr;
		return new StrArr(arr).sort(condition).array();
	}
	public static int[] sort(int[] arr) {
		return new IntArr(arr).sort().array();
	}
	public static int[] sort(int[] arr, String condition) {
		if (not(arr) || not(condition)) return arr;
		return new IntArr(arr).sort(condition).array();
	}
	public static long[] sort(long[] arr) {
		return new LongArr(arr).sort().array();
	}
	public static long[] sort(long[] arr, String condition) {
		if (not(arr) || not(condition)) return arr;
		return new LongArr(arr).sort(condition).array();
	}
	public static float[] sort(float[] arr) {
		return new FltArr(arr).sort().array();
	}
	public static float[] sort(float[] arr, String condition) {
		if (not(arr) || not(condition)) return arr;
		return new FltArr(arr).sort(condition).array();
	}
	public static double[] sort(double[] arr) {
		return new DblArr(arr).sort().array();
	}
	public static double[] sort(double[] arr, String condition) {
		if (not(arr) || not(condition)) return arr;
		return new DblArr(arr).sort(condition).array();
	}
	public static boolean[] sort(boolean[] arr) {
		return new BoolArr(arr).sort().array();
	}
	public static boolean[] sort(boolean[] arr, String condition) {
		if (not(arr) || not(condition)) return arr;
		return new BoolArr(arr).sort(condition).array();
	}
	public static StrArr sort(StrArr arr) {
		return arr.sort();
	}
	public static StrArr sort(StrArr arr, String condition) {
		return new StrArr(sort(arr.array(), condition));
	}
	public static IntArr sort(IntArr arr) {
		return arr.sort();
	}
	public static IntArr sort(IntArr arr, String condition) {
		if (not(arr) || not(condition)) return arr;
		return arr.sort(condition);
	}
	public static LongArr sort(LongArr arr) {
		return arr.sort();
	}
	public static LongArr sort(LongArr arr, String condition) {
		if (not(arr) || not(condition)) return arr;
		return arr.sort(condition);
	}
	public static FltArr sort(FltArr arr) {
		return arr.sort();
	}
	public static FltArr sort(FltArr arr, String condition) {
		if (not(arr) || not(condition)) return arr;
		return arr.sort(condition);
	}
	public static DblArr sort(DblArr arr) {
		return arr.sort();
	}
	public static DblArr sort(DblArr arr, String condition) {
		if (not(arr) || not(condition)) return arr;
		return arr.sort(condition);
	}
	public static BoolArr sort(BoolArr arr) {
		return arr.sort();
	}
	public static BoolArr sort(BoolArr arr, String condition) {
		if (not(arr) || not(condition)) return arr;
		return arr.sort(condition);
	}
	public static String[] sortReverse(String[] arr) {
		return new StrArr(arr).sortReverse().array();
	}
	public static int[] sortReverse(int[] arr) {
		return new IntArr(arr).sortReverse().array();
	}
	public static long[] sortReverse(long[] arr) {
		return new LongArr(arr).sortReverse().array();
	}
	public static float[] sortReverse(float[] arr) {
		return new FltArr(arr).sortReverse().array();
	}
	public static double[] sortReverse(double[] arr) {
		return new DblArr(arr).sortReverse().array();
	}
	public static boolean[] sortReverse(boolean[] arr) {
		return new BoolArr(arr).sortReverse().array();
	}
	public static StrArr sortReverse(StrArr arr) {
		return arr.sortReverse();
	}
	public static IntArr sortReverse(IntArr arr) {
		return arr.sortReverse();
	}
	public static LongArr sortReverse(LongArr arr) {
		return arr.sortReverse();
	}
	public static FltArr sortReverse(FltArr arr) {
		return arr.sortReverse();
	}
	public static DblArr sortReverse(DblArr arr) {
		return arr.sortReverse();
	}
	public static BoolArr sortReverse(BoolArr arr) {
		return arr.sortReverse();
	}
	public static String[] reverseSort(String[] arr) {
		return sortReverse(arr);
	}
	public static int[] reverseSort(int[] arr) {
		return sortReverse(arr);
	}
	public static long[] reverseSort(long[] arr) {
		return sortReverse(arr);
	}
	public static float[] reverseSort(float[] arr) {
		return sortReverse(arr);
	}
	public static double[] reverseSort(double[] arr) {
		return sortReverse(arr);
	}
	public static boolean[] reverseSort(boolean[] arr) {
		return sortReverse(arr);
	}
	public static StrArr reverseSort(StrArr arr) {
		return sortReverse(arr);
	}
	public static IntArr reverseSort(IntArr arr) {
		return sortReverse(arr);
	}
	public static LongArr reverseSort(LongArr arr) {
		return sortReverse(arr);
	}
	public static FltArr reverseSort(FltArr arr) {
		return sortReverse(arr);
	}
	public static DblArr reverseSort(DblArr arr) {
		return sortReverse(arr);
	}
	public static BoolArr reverseSort(BoolArr arr) {
		return sortReverse(arr);
	}
	public static String shuffle(String str) {
		char[] chars = str.toCharArray();
		Random random = new Random();
		for (int i = chars.length - 1; i > 0; i--) {
			int j = random.nextInt(i + 1);
			char temp = chars[i];
			chars[i] = chars[j];
			chars[j] = temp;
		}
		String result = new String(chars);
		return result;
	}
	public static String[] shuffle(String[] arr) {
		Random rnd = new Random();
		for (int i = arr.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			String temp = arr[index];
			arr[index] = arr[i];
			arr[i] = temp;
		}
		return arr;
	}
	public static int[] shuffle(int[] arr) {
		Random rnd = new Random();
		for (int i = arr.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			int temp = arr[index];
			arr[index] = arr[i];
			arr[i] = temp;
		}
		return arr;
	}
	public static long[] shuffle(long[] arr) {
		Random rnd = new Random();
		for (int i = arr.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			long temp = arr[index];
			arr[index] = arr[i];
			arr[i] = temp;
		}
		return arr;
	}
	public static float[] shuffle(float[] arr) {
		Random rnd = new Random();
		for (int i = arr.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			float temp = arr[index];
			arr[index] = arr[i];
			arr[i] = temp;
		}
		return arr;
	}
	public static double[] shuffle(double[] arr) {
		Random rnd = new Random();
		for (int i = arr.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			double temp = arr[index];
			arr[index] = arr[i];
			arr[i] = temp;
		}
		return arr;
	}
	public static boolean[] shuffle(boolean[] arr) {
		Random rnd = new Random();
		for (int i = arr.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			boolean temp = arr[index];
			arr[index] = arr[i];
			arr[i] = temp;
		}
		return arr;
	}
	public static StrArr shuffle(StrArr arr) {
		return arr.shuffle();
	}
	public static IntArr shuffle(IntArr arr) {
		return arr.shuffle();
	}
	public static LongArr shuffle(LongArr arr) {
		return arr.shuffle();
	}
	public static FltArr shuffle(FltArr arr) {
		return arr.shuffle();
	}
	public static DblArr shuffle(DblArr arr) {
		return arr.shuffle();
	}
	public static BoolArr shuffle(BoolArr arr) {
		return arr.shuffle();
	}
	private static String[] ctss = {"Abbottabad", "Adilpur", "Ahmadpur East",
									"Ahmadpur Sial", "Akora", "Aliabad", "Alik Ghund", "Alipur",
									"Alizai", "Alpurai", "Aman Garh", "Amirabad", "Arifwala",
									"Ashanagro Koto", "Athmuqam", "Attock City", "Awaran", "Baddomalhi",
									"Badin", "Baffa", "Bagarji", "Bagh", "Bahawalnagar", "Bahawalnagar",
									"Bahawalpur", "Bakhri Ahmad Khan", "Bandhi", "Bannu", "Barishal",
									"Barkhan", "Basirpur", "Basti Dosa", "Bat Khela", "Battagram",
									"Begowala", "Bela", "Berani", "Bhag", "Bhakkar", "Bhalwal", "Bhan",
									"Bhawana", "Bhera", "Bhimbar", "Bhiria", "Bhit Shah", "Bhopalwala",
									"Bozdar Wada", "Bulri", "Burewala", "Chak", "Chak Azam Sahu",
									"Chak Five Hundred Seventy-five", "Chak Jhumra",
									"Chak One Hundred Twenty Nine Left", "Chak Thirty-one -Eleven Left",
									"Chak Two Hundred Forty-nine Thal Development Authority", "Chakwal",
									"Chaman", "Chamber", "Charsadda", "Chawinda", "Chenab Nagar",
									"Cherat Cantonement", "Chhor", "Chichawatni", "Chilas", "Chiniot",
									"Chishtian", "Chitral", "Choa Saidan Shah", "Chowki Jamali",
									"Chuchar-kana Mandi", "Chuhar Jamali", "Chunian", "Dadhar", "Dadu",
									"Daggar", "Daira Din Panah", "Dajal", "Dalbandin", "Dandot RS",
									"Daromehar", "Darya Khan", "Darya Khan Marri", "Daska Kalan",
									"Dasu", "Daud Khel", "Daulatpur", "Daultala", "Daur",
									"Dera Alahyar", "Dera Bugti", "Dera Ghazi Khan", "Dera Ismail Khan",
									"Dera Murad Jamali", "Dhanot", "Dhaunkal", "Dhoro Naro", "Digri",
									"Dijkot", "Dinan Bashnoian Wala", "Dinga", "Dipalpur", "Diplo",
									"Doaba", "Dokri", "Duki", "Dullewala", "Dunga Bunga", "Dunyapur",
									"Eidgah", "Eminabad", "Faisalabad", "Faqirwali", "Faruka",
									"Fazilpur", "Fort Abbas", "Gadani", "Gakuch", "Gambat", "Gandava",
									"Garh Maharaja", "Garhi Khairo", "Garhiyasin", "Ghauspur", "Ghotki",
									"Gilgit", "Gojra", "Goth Garelo", "Goth Phulji", "Goth Radhan",
									"Gujar Khan", "Gujranwala", "Gujrat", "Gulishah Kach", "Gwadar",
									"Hadali", "Hafizabad", "Hala", "Hangu", "Haripur", "Harnai",
									"Harnoli", "Harunabad", "Hasilpur", "Hattian Bala", "Haveli Lakha",
									"Havelian", "Hazro City", "Hingorja", "Hujra Shah Muqim",
									"Hyderabad", "Islamabad", "Islamkot", "Jacobabad", "Jahanian Shah",
									"Jalalpur Jattan", "Jalalpur Pirwala", "Jampur", "Jamshoro", "Jand",
									"Jandiala Sher Khan", "Jaranwala", "Jati", "Jatoi Shimali",
									"Jauharabad", "Jhang City", "Jhang Sadr", "Jhawarian", "Jhelum",
									"Jhol", "Jiwani", "Johi", "Jam Sahib", "Kabirwala", "Kadhan",
									"Kahna Nau", "Kahror Pakka", "Kahuta", "Kakad Wari Dir Upper",
									"Kalabagh", "Kalaswala", "Kalat", "Kaleke Mandi", "Kallar Kahar",
									"Kalur Kot", "Kamalia", "Kamar Mushani", "Kambar", "Kamoke",
									"Kamra", "Kandhkot", "Kandiari", "Kandiaro", "Kanganpur", "Karachi",
									"Karak", "Karaundi", "Kario Ghanwar", "Karor", "Kashmor", "Kasur",
									"Keshupur", "Keti Bandar", "Khadan Khak", "Khadro", "Khairpur",
									"Khairpur Mir\'s", "Khairpur Nathan Shah", "Khairpur Tamewah",
									"Khalabat", "Khandowa", "Khanewal", "Khangah Dogran", "Khangarh",
									"Khanpur", "Khanpur Mahar", "Kharan", "Kharian", "Khewra",
									"Khurrianwala", "Khushab", "Khuzdar", "Kohat", "Kohlu", "Kot Addu",
									"Kot Diji", "Kot Ghulam Muhammad", "Kot Malik Barkhurdar",
									"Kot Mumin", "Kot Radha Kishan", "Kot Rajkour", "Kot Samaba",
									"Kot Sultan", "Kotli", "Kotli Loharan", "Kotri", "Kulachi",
									"Kundian", "Kunjah", "Kunri", "Lachi", "Ladhewala Waraich",
									"Lahore", "Lakhi", "Lakki", "Lala Musa", "Lalian", "Landi Kotal",
									"Larkana", "Layyah", "Liliani", "Lodhran", "Loralai", "Mach",
									"Madeji", "Mailsi", "Malakand", "Malakwal", "Malakwal City",
									"Malir Cantonment", "Mamu Kanjan", "Mananwala", "Mandi Bahauddin",
									"Mangla", "Mankera", "Mansehra", "Mardan", "Mastung", "Matiari",
									"Matli", "Mehar", "Mehmand Chak", "Mehrabpur", "Mian Channun",
									"Mianke Mor", "Mianwali", "Minchianabad", "Mingora", "Miran Shah",
									"Miro Khan", "Mirpur Bhtoro", "Mirpur Khas", "Mirpur Mathelo",
									"Mirpur Sakro", "Mirwah Gorchani", "Mitha Tiwana", "Mithi", "Moro",
									"Moza Shahwala", "Multan", "Muridke", "Murree", "Musa Khel Bazar",
									"Mustafabad", "Muzaffargarh", "Muzaffarabad", "Nabisar",
									"Nankana Sahib", "Narang Mandi", "Narowal", "Nasirabad", "Naudero",
									"Naukot", "Naushahra Virkan", "Naushahro Firoz", "Nawabshah",
									"Nazir Town", "New Badah", "New Mirpur", "Noorabad", "Nowshera",
									"Nowshera Cantonment", "Nushki", "Okara", "Ormara", "Pabbi",
									"Pad Idan", "Paharpur", "Pakpattan", "Panjgur", "Pano Aqil",
									"Parachinar", "Pasni", "Pasrur", "Pattoki", "Peshawar", "Phalia",
									"Pind Dadan Khan", "Pindi Bhattian", "Pindi Gheb", "Pir Jo Goth",
									"Pir Mahal", "Pishin", "Pithoro", "Qadirpur Ran", "Qila Abdullah",
									"Qila Saifullah", "Quetta", "Rahim Yar Khan", "Raiwind",
									"Raja Jang", "Rajanpur", "Rajo Khanani", "Ranipur", "Rasulnagar",
									"Ratodero", "Rawala Kot", "Rawalpindi", "Renala Khurd",
									"Risalpur Cantonment", "Rohri", "Rojhan", "Rustam", "Saddiqabad",
									"Sahiwal", "Sahiwal", "Saidu Sharif", "Sakrand", "Samaro",
									"Sambrial", "Sanghar", "Sangla Hill", "Sanjwal", "Sann",
									"Sarai Alamgir", "Sarai Naurang", "Sarai Sidhu", "Sargodha",
									"Sehwan", "Setharja Old", "Shabqadar", "Shahdad Kot", "Shahdadpur",
									"Shahkot", "Shahpur", "Shahpur Chakar", "Shahr Sultan",
									"Shakargarh", "Sharqpur Sharif", "Shekhupura", "Shikarpur",
									"Shingli Bala", "Shinpokh", "Shorkot", "Shujaabad", "Sialkot",
									"Sibi", "Sillanwali", "Sinjhoro", "Skardu", "Sobhodero", "Sodhri",
									"Sohbatpur", "Sukheke Mandi", "Sukkur", "Surab", "Surkhpur",
									"Swabi", "Sita Road", "Talagang", "Talamba", "Talhar",
									"Tandlianwala", "Tando Adam", "Tando Alahyar", "Tando Bago",
									"Tando Jam", "Tando Mitha Khan", "Tando Muhammad Khan", "Tangi",
									"Tangwani", "Tank", "Taunsa", "Thal", "Tharu Shah", "Thatta",
									"Thul", "Timargara", "Toba Tek Singh", "Topi", "Turbat", "Ubauro",
									"Umarkot", "Upper Dir", "Usta Muhammad", "Uthal", "Utmanzai",
									"Vihari", "Wana", "Warah", "Wazirabad", "Yazman", "Zafarwal",
									"Zahir Pir", "Zaida", "Zhob", "Ziarat"
								   },
							wdss = {"documentary", "compliment", "insult", "vocalist",
									"pianist", "violinist", "thirst", "hunger", "brevity",
									"longevity", "sanity", "insanity", "bikini", "panty",
									"hymen", "synthesis", "dementia", "amnesia", "blood sugar",
									"fever", "flu", "diarrhea", "glucose", "Latino", "Latina",
									"anesthetics", "anesthesia", "Cannabis", "oasis", "desert",
									"dessert", "hemoglobin", "cardiographer", "carpenter",
									"oceanic", "terran", "abroad", "absorbing", "abstract",
									"academic", "accelerated", "accented", "accountant",
									"acquainted", "acute", "obtuse", "protective", "possessive",
									"real", "unreal", "realistic", "unrealistic", "imagined",
									"delusional", "addicting", "addictive", "adjustable",
									"admired", "adult", "adverse", "advised", "aerosol",
									"afraid", "creeped out", "horrified", "horrific",
									"terrified", "terrific", "devastated", "frustrated",
									"aggravated", "aggressive", "agreeable", "alienate",
									"aligned", "all-round", "alleged", "almond", "alright",
									"altruistic", "ambient", "ambivalent", "amiable", "amino",
									"amorphous", "amused", "anatomical", "ancestral", "angelic",
									"angrier", "answerable", "antiquarian", "antiretroviral",
									"appellate", "applicable", "apportioned", "approachable",
									"appropriated", "archer", "aroused", "arrested",
									"assertive", "assigned", "athletic", "atrocious",
									"attained", "authoritarian", "autobiographical",
									"avaricious", "avocado", "awake", "awesome", "backstage",
									"backwoods", "balding", "bandaged", "banded", "banned",
									"barreled", "battle", "beaten", "begotten", "beguiled",
									"bellied", "belted", "beneficent", "besieged", "betting",
									"big-money", "biggest", "biochemical", "bipolar",
									"blackened", "blame", "blessed", "blindfolded", "bloat",
									"blocked", "blooded", "blue-collar", "blushing", "boastful",
									"bolder", "bolstered", "bonnie", "bored", "boundary",
									"bounded", "bounding", "branched", "brawling", "brazen",
									"breeding", "bridged", "brimming", "brimstone", "broadest",
									"broiled", "broker", "bronze", "bruising", "buffy",
									"bullied", "bungling", "burial", "buttery", "candied",
									"canonical", "cantankerous", "cardinal", "carefree",
									"caretaker", "casual", "cathartic", "causal", "chapel",
									"characterized", "charcoal", "cheeky", "cherished",
									"chipotle", "chirping", "chivalrous", "circumstantial",
									"civic", "civil", "civilised", "clanking", "clapping",
									"claptrap", "classless", "cleansed", "cleric", "cloistered",
									"codified", "colloquial", "colour", "combat", "combined",
									"comely", "commissioned", "commonplace", "commuter",
									"commuting", "comparable", "complementary", "compromising",
									"conceding", "concentrated", "conceptual", "conditioned",
									"confederate", "confident", "confidential", "confining",
									"confuse", "congressional", "consequential", "conservative",
									"constituent", "contaminated", "contemporaneous",
									"contraceptive", "convertible", "convex", "cooked",
									"coronary", "corporatist", "correlated", "corroborated",
									"cosmic", "cover", "crash", "crypto", "culminate",
									"cushioned", "dandy", "dashing", "dazzled", "decreased",
									"decrepit", "dedicated", "defaced", "defective",
									"defenseless", "deluded", "deodorant", "departed",
									"depress", "designing", "despairing", "destitute",
									"detective", "determined", "devastating", "deviant",
									"devilish", "devoted", "diagonal", "dictated", "didactic",
									"differentiated", "diffused", "dirtier", "disabling",
									"disconnected", "discovered", "disdainful", "diseased",
									"disfigured", "disheartened", "disheveled", "disillusioned",
									"disparate", "dissident", "doable", "doctrinal", "doing",
									"dotted", "double-blind", "downbeat", "dozen", "draining",
									"draught", "dread", "dried", "dropped", "dulled",
									"duplicate", "eaten", "echoing", "economical", "elaborated",
									"elastic", "elective", "electoral", "elven", "embryo",
									"emerald", "emergency", "emissary", "emotional", "employed",
									"enamel", "encased", "encrusted", "endangered", "engraved",
									"engrossing", "enlarged", "enlisted", "enlivened",
									"ensconced", "entangled", "enthralling", "entire",
									"envious", "eradicated", "eroded", "esoteric", "essential",
									"evaporated", "ever-present", "evergreen", "everlasting",
									"exacting", "exasperated", "excess", "exciting",
									"executable", "existent", "exonerated", "exorbitant",
									"exponential", "export", "extraordinary", "exultant",
									"exulting", "facsimile", "fading", "fainter", "fallacious",
									"faltering", "famous", "fancier", "fast-growing", "fated",
									"favourable", "fearless", "feathered", "fellow",
									"fermented", "ferocious", "fiddling", "filling", "firmer",
									"fitted", "flammable", "flawed", "fledgling", "fleshy",
									"flexible", "flickering", "floral", "flowering", "flowing",
									"foggy", "folic", "foolhardy", "foolish", "footy",
									"forehand", "forked", "formative", "formulaic",
									"foul-mouthed", "fractional", "fragrant", "fraudulent",
									"freakish", "freckled", "freelance", "freight", "fresh",
									"fretted", "frugal", "indiscriminate", "indomitable",
									"inert", "inflate", "inform", "inheriting", "injured",
									"injurious", "inking", "inoffensive", "insane",
									"insensible", "insidious", "insincere", "insistent",
									"insolent", "insufferable", "intemperate", "interdependent",
									"interesting", "interfering", "intern", "interpreted",
									"intersecting", "intolerable", "intolerant", "intuitive",
									"irresolute", "irritate", "jealous", "jerking", "joining",
									"joint", "journalistic", "joyful", "keyed", "knowing",
									"lacklustre", "laden", "lagging", "lamented", "laughable",
									"layered", "leather", "leathern", "leery", "left-footed",
									"legible", "leisure", "lessening", "liberating",
									"life-size", "lifted", "lightest", "limitless", "listening",
									"literary", "liver", "livid", "lobster", "locked",
									"long-held", "long-lasting", "long-running", "oversize",
									"overworked", "oyster", "paced", "panting", "paralyzed",
									"paramount", "parental", "parted", "partisan", "passive",
									"edible", "eatable", "kissable", "killable", "pastel"
								   },
							ntltss = {"Afghan", "Egyptian", "Alantic", "Albanian", "Algerian",
									  "Virgin Islander", "American Samoan", "Andorran", "Angolan",
									  "Anguillan", "Antarctic", "Antiguan and Barbudan",
									  "Equatorial Guinean", "Argentine; Argentinian", "Armenian",
									  "Aruban", "Azerbaijani", "Ethiopian", "Australian",
									  "Bahamian", "Bahraini", "Bangladeshi", "Barbadian",
									  "Belarusian", "Belgian", "Belizean", "Beninese",
									  "Bermudian", "Bhutanese", "Bolivian", "Bosnian",
									  "Botswanan", "of Bouvet Island", "Brazilian",
									  "of the British Indian Ocean Territory",
									  "British Virgin Islander", "Bruneian", "Bulgarian",
									  "Burkinabe", "Burundian", "Cape Verdean", "Chilean",
									  "Chinese", "of Clipperton Island", "Cook Islander",
									  "Costa Rican", "Ivorian", "Curacaoan", "Danish", "German",
									  "Dominican", "Djiboutian", "Ecuadorian",
									  "Salvadorian; Salvadoran", "Eritrean", "Estonian",
									  "Falklander", "Faroese", "Fijian", "Finnish", "French",
									  "of the French Southern and Antarctic Lands", "Guianese",
									  "Polynesian", "Gabonese", "Gambian", "Georgian", "Ghanaian",
									  "Gibraltarian", "Grenadian", "Greek", "Greenlandic",
									  "Guadeloupean", "Guamanian", "Guatemalan", "Guernsey",
									  "Guinean", "Bissau-Guinean", "Guyanese", "Haitian",
									  "of the Heard Island and McDonald Islands",
									  "of the Holy See/of the Vatican", "Honduran",
									  "Hong Kong Chinese", "Indian", "Indonesian", "Manx",
									  "Iraqi", "Iranian", "Irish", "Icelandic", "Israeli",
									  "Italian", "Jamaican", "Japanese", "Yemeni", "Jersey",
									  "Jordanian", "Caymanian", "Cambodian", "Cameroonian",
									  "Canadian", "Kazakh", "Qatari", "Kenyan", "Kyrgyz",
									  "Kiribatian", "of the Cocos (Keeling) Islands", "Colombian",
									  "Comorian", "Congolese", "Croatian", "Cuban", "Kuwaiti",
									  "Lao; Laotian", "Mesotho", "Latvian", "Lebanese",
									  "Liberian", "Libyan", "Liechtensteiners", "Lithuanian",
									  "Luxembourgish", "Macanese", "Malagasy", "Malawian",
									  "Malaysian", "Maldivian", "Malian", "Maltese", "Moroccan",
									  "Marshallese", "Martinican", "Mauritanian", "Mauritian",
									  "Mahoran", "Mexican", "Micronesian", "Moldovan",
									  "Monegasque", "Mongolian", "Montenegrin", "Montserratian",
									  "Mozambican", "Burmese", "Namibian", "Nauruan", "Nepalese",
									  "New Caledonian", "New Zealander", "Nicaraguan", "Dutch",
									  "Nigerien", "Nigerian", "Niuean", "North Korean",
									  "Marian Islander", "Norfolk Islander", "Norwegian", "Omani",
									  "Austrian", "Pakistani", "Palauan", "Panamanian",
									  "Papua New Guinean", "Paraguayan", "Peruvian", "Filipino",
									  "Pitcairner", "Polish", "Portuguese", "Puerto Rican",
									  "Reunionese", "Rwandan; Rwandese", "Romanian", "Russian",
									  "Solomon Islander", "Zambian", "Samoan", "Sammarinese",
									  "Sao Tomean", "Saudi Arabian", "Swedish", "Swiss",
									  "Senegalese", "Serbian", "Seychellois", "Sierra Leonean",
									  "Zimbabwean", "Singaporean", "Slovak", "Slovenian",
									  "Somali; Somalian", "Spanish", "Sri Lankan",
									  "Saint Barthelemian",
									  "of Saint Helena, Ascension and Tristan da Cunha",
									  "of Saint Kitts and Nevis", "Saint Lucian",
									  "of Saint Martin", "of Sint Maarten",
									  "of Saint Pierre and Miquelon",
									  "Vincentian; of Saint Vincent and the Grenadines",
									  "South African", "Sudanese",
									  "of South Georgia and the South Sandwich Islands",
									  "South Korean", "South Sudanese", "Surinamese",
									  "of Svalbard, of Jan Mayen", "Swazi", "Syrian", "Tajik",
									  "Taiwanese", "Tanzanian", "Thai", "East Timorese",
									  "Togolese", "Tokelauan", "Tongan", "of Trinidad and Tobago",
									  "Chadian", "Czech", "Tunisian", "Turkish", "Turkmen",
									  "of the Turks and Caicos Islands", "Tuvaluan", "Ugandan",
									  "Ukrainian", "Hungarian", "Uruguayan", "Uzbek", "Vanuatuan",
									  "Venezuelan", "Emirian",
									  "American; The United States of America", "British",
									  "Vietnamese", "of the Wallis and Futuna Islands",
									  "of Christmas Island", "Sahrawi", "Central African",
									  "Cypriot"
									 },
							rfnss = {"+92 (308) 215 2441", "+92 (305) 205 3250",
									 "+92 (314) 763 2228", "+92 (323) 267 3234",
									 "+92 (320) 005 8284", "+92 (312) 486 1408",
									 "+92 (313) 556 6782", "+92 (312) 188 8504",
									 "+92 (321) 517 0564", "+92 (300) 215 0018",
									 "+92 (331) 066 8182", "+92 (305) 621 8357",
									 "+92 (312) 303 6683", "+92 (330) 315 6554",
									 "+92 (318) 702 7462", "+92 (307) 083 6477",
									 "+92 (333) 585 3443", "+92 (315) 547 0136",
									 "+92 (327) 660 2848", "+92 (330) 144 4028",
									 "+92 (323) 276 4840", "+92 (327) 738 8321",
									 "+92 (305) 812 7050", "+92 (324) 620 5556",
									 "+92 (310) 681 7606", "+92 (336) 286 8600",
									 "+92 (333) 241 8207", "+92 (322) 527 1520",
									 "+92 (303) 510 4857", "+92 (337) 650 1744",
									 "+92 (321) 331 4144", "+92 (301) 515 4836",
									 "+92 (332) 460 3760", "+92 (333) 168 2174",
									 "+92 (304) 272 1350", "+92 (320) 375 3538",
									 "+92 (336) 516 5606", "+92 (330) 088 7340",
									 "+92 (317) 523 7275", "+92 (314) 128 3831",
									 "+92 (326) 825 7157", "+92 (302) 115 2032",
									 "+92 (336) 362 6505", "+92 (313) 627 6536",
									 "+92 (302) 832 5304", "+92 (300) 131 4753",
									 "+92 (311) 588 0281", "+92 (337) 412 0180",
									 "+92 (321) 601 7236", "+92 (306) 075 0548",
									 "+92 (336) 744 6742", "+92 (335) 684 5677",
									 "+92 (323) 753 4302", "+92 (322) 864 6866",
									 "+92 (301) 077 0316", "+92 (320) 080 7036",
									 "+92 (327) 613 3783", "+92 (334) 138 2771",
									 "+92 (330) 343 8104", "+92 (325) 201 0684",
									 "+92 (337) 775 7221", "+92 (311) 857 5310",
									 "+92 (322) 615 5255", "+92 (310) 731 2176",
									 "+92 (323) 412 7433", "+92 (323) 180 3238",
									 "+92 (318) 704 5111", "+92 (321) 485 2814",
									 "+92 (334) 611 2074", "+92 (314) 343 0881",
									 "+92 (300) 537 3177", "+92 (310) 187 8100",
									 "+92 (320) 878 2262", "+92 (324) 785 1028",
									 "+92 (313) 070 1354", "+92 (318) 204 0637",
									 "+92 (328) 877 2626", "+92 (318) 018 4006",
									 "+92 (306) 104 1463", "+92 (313) 862 3726",
									 "+92 (318) 388 7683", "+92 (330) 738 5730",
									 "+92 (316) 166 6803", "+92 (313) 271 3641",
									 "+92 (307) 718 8285", "+92 (306) 256 2360",
									 "+92 (321) 104 8067", "+92 (300) 884 5048",
									 "+92 (307) 085 3035", "+92 (335) 446 3531",
									 "+92 (322) 647 3410", "+92 (328) 760 2861",
									 "+92 (327) 772 6701", "+92 (300) 211 6834",
									 "+92 (333) 515 7716", "+92 (314) 534 3700",
									 "+92 (330) 078 1205", "+92 (304) 316 1564",
									 "+92 (338) 782 0723", "+92 (318) 250 1765",
									 "+92 (300) 125 7551", "+92 (330) 715 6381",
									 "+92 (306) 366 6305", "+92 (330) 548 0703",
									 "+92 (324) 818 1781", "+92 (334) 057 4635",
									 "+92 (327) 646 3800"
									},
							rgynss = {"Ahmed Raza", "Bilal Tariq", "Usman Siddiqi",
									  "Omar Farooq", "Waleed Kamal", "Talha Iqbal",
									  "Faisal Latif", "Hassan Jameel", "Adnan Bashir",
									  "Kashif Rauf", "Imran Saeed", "Adeel Qureshi",
									  "Zeeshan Hashmi", "Shoaib Nadeem", "Noman Shahid",
									  "Faizan Khalid", "Hammad Zubair", "Naveed Aslam",
									  "Waqar Mehmood", "Sarmad Sheikh", "Tariq Anwar",
									  "Junaid Riaz", "Sufyan Abbas", "Shahzad Hussain",
									  "Mudassir Younas", "Jawad Hamid", "Ammar Khalil",
									  "Rizwan Waheed", "Hasnain Saleem", "Basit Jamal",
									  "Sheraz Ahmed", "Umer Shahbaz", "Arsalan Hashim",
									  "Raheel Sultan", "Fahad Zaman", "Sajid Irfan", "Owais Rauf",
									  "Sarfaraz Kamran", "Khizar Ali", "Ahsan Waseem",
									  "Tauseef Haroon", "Murtaza Shah", "Maaz Asif",
									  "Samiullah Arif", "Nabeel Qamar", "Taimoor Rauf",
									  "Atif Nawaz", "Hashir Siddiqui", "Zubair Imran",
									  "Abrar Hussain", "Farhan Waseem", "Umair Tariq", "Arif Ali",
									  "Shayan Latif", "Irfan Khalid", "Hamza Masood",
									  "Sameer Riaz", "Shoaib Hanif", "Adil Jameel", "Ahmed Saeed",
									  "Mudassir Kamal", "Haris Younas", "Noman Waqar",
									  "Waseem Abbas", "Faizan Rauf", "Mubashir Jamil",
									  "Sohail Shahzad", "Ubaid Latif", "Sikandar Saeed",
									  "Hasham Khalid", "Farrukh Hussain", "Zain Qureshi",
									  "Arslan Abbas", "Muzammil Tariq", "Usama Rasheed",
									  "Adeel Sultan", "Taha Iqbal", "Kamil Arshad", "Danish Rauf",
									  "Talal Farooq", "Sarmad Mehmood", "Shoaib Azhar",
									  "Omer Siddiqi", "Dawood Mushtaq", "Ammar Waheed",
									  "Fasih Shah", "Adnan Khalil", "Imran Waseem",
									  "Waleed Anwar", "Yasir Rauf", "Arham Bashir",
									  "Shehryar Latif", "Azhar Siddiqui", "Jibran Hussain",
									  "Hassan Qamar", "Usman Kamal", "Tariq Yousaf",
									  "Owais Farooq", "Raheel Bashir", "Waqas Khalid",
									  "Faisal Shah", "Bilal Latif", "Zeeshan Abbas",
									  "Faizan Hussain", "Mudassir Farooq", "Kashif Khalid",
									  "Abrar Tariq", "Umair Siddiqi", "Hamza Jameel",
									  "Nabeel Usman", "Khalil Laghari", "Murtaza Waseem",
									  "Sajid Waheed", "Noman Riaz", "Hashir Hussain",
									  "Sheraz Rauf", "Ahmed Tariq", "Atif Bashir",
									  "Omar Siddiqui", "Irfan Khalil", "Raheel Jamil",
									  "Tauseef Rauf", "Hammad Abbas", "Hasnain Kamran",
									  "Waleed Hussain", "Taimoor Abbas", "Mudassir Waheed",
									  "Umer Khalid", "Khurram Anwar", "Junaid Bashir",
									  "Shayan Rauf", "Ahmed Hanif", "Bilal Hussain", "Umair Riaz",
									  "Zubair Khalid", "Adeel Haroon", "Sajid Qamar",
									  "Faizan Latif", "Hammad Saleem", "Shoaib Tariq",
									  "Noman Anwar", "Fahad Hussain", "Hashim Waseem",
									  "Hamza Abbas", "Arsalan Khalid", "Taha Rasheed",
									  "Usama Farooq", "Sarim Bashir", "Khizar Waheed",
									  "Mudassir Khalid", "Waqas Rauf", "Tariq Hussain",
									  "Jawad Siddiqui", "Shehryar Abbas", "Naveed Tariq",
									  "Muzammil Jamil", "Zeeshan Khalid", "Atif Hussain",
									  "Sarmad Waqar", "Shoaib Khalid", "Ahmed Qureshi",
									  "Raheel Abbas", "Hammad Riaz", "Sheraz Bashir",
									  "Danish Khalid", "Adil Waheed", "Hashir Tariq",
									  "Faizan Waseem", "Usman Abbas", "Khurram Latif",
									  "Owais Siddiqui", "Mudassir Hussain", "Tauseef Khalid",
									  "Farrukh Waseem", "Umer Saleem", "Hamza Rauf",
									  "Shoaib Kamran", "Bilal Abbas", "Sajid Tariq",
									  "Faizan Shahbaz", "Hasnain Abbas", "Abrar Khalid",
									  "Ahmed Farooq", "Atif Khalid", "Irfan Waseem",
									  "Junaid Tariq", "Umair Saleem", "Arsalan Hussain",
									  "Waleed Abbas", "Adnan Waseem", "Sheraz Khalid",
									  "Mudassir Abbas", "Shoaib Rauf", "Omar Hussain",
									  "Raheel Khalid", "Hammad Waseem", "Waseem Farooq",
									  "Hasham Tariq", "Faisal Khalid", "Kashif Abbas",
									  "Tauseef Abbas", "Hamza Saleem", "Zeeshan Waseem",
									  "Sarmad Hussain", "Bilal Khalid", "Umair Abbas",
									  "Mudassir Riaz", "Adil Khalid", "Ahmed Abbas",
									  "Owais Hussain"
									 },
							rglnss = {"Ayesha Waleed", "Fatima Kamal", "Hira Latif",
									  "Sana Farooq", "Mahnoor Tariq", "Faiza Tehseem",
									  "Fozia Mehshar", "Iqra Siddiqui", "Laiba Aslam",
									  "Anum Riaz", "Saba Kiani", "Hafsa Saeed", "Sidra Hashmi",
									  "Zunaira Naz", "Sadaf Bhutto", "Kiran Jameel", "Rida Abbas",
									  "Nimra Waseem", "Huma Tariq", "Samina Khalid",
									  "Zeenat Rauf", "Amna Waheed", "Neelam Hashmi",
									  "Aiman Qamar", "Romaisa Hussain", "Fareeda Asif",
									  "Sania Anwar", "Humaisa Khalil", "Asma Riaz",
									  "Sadia Kamran", "Sehrish Waseem", "Uzma Tariq",
									  "Mehwish Latif", "Hina Abbas", "Areeba Waqar",
									  "Tanzeela Jafar", "Anila Saleem", "Mahira Umer",
									  "Bushra Nadeem", "Zoya Mehmood", "Nida Hashim",
									  "Sumaira Yasir", "Mahnoor Hussain", "Komal Saeed",
									  "Laiba Waseem", "Amina Abbas", "Rida Jameel",
									  "Saeeka Haroon", "Zainab Farooq", "Fatima Hussain",
									  "Hafsa Mehmood", "Minal Khawar", "Yumna Tariq",
									  "Ayeza Barkat", "Asia Farhan", "Kinza Jamal",
									  "Mehwish Touseef", "Rimsha Ibrahim", "Neelam Saeed",
									  "Hira Khalid", "Amna Riaz", "Iqra Farooq", "Anum Abbas",
									  "Mehwish Iqrar", "Sumaiya Tariq", "Romaisa Khalil",
									  "Faiza Waseem", "Bushra Farooq", "Sadia Abbas",
									  "Hiba Hussain", "Afshan Siddiqui", "Sana Basit",
									  "Areeba Khalid", "Maira Waseem", "Nimra Hussain",
									  "Sehrish Saleem", "Amna Jameel", "Zoya Khalid",
									  "Mehreen Tariq", "Aiman Abbas", "Komal Riaz", "Hira Saleem",
									  "Palwasha Moazzam", "Laiba Nayyar", "Minahal Tahir",
									  "Mehwish Shuja", "Javeria Feroze", "Zara Munawwar",
									  "Fiza Jatoi", "Fatima Riaz", "Zainab Alvi",
									  "Tanzeela Abbas", "Kiran Waseem", "Ayesha Khalid",
									  "Samina Hussain", "Sadia Waseem", "Bisma Majeed",
									  "Areeba Latif", "Sehrish Tariq", "Hafsa Waseem",
									  "Hina Tariq", "Zoya Saleem", "Maham Khalid", "Muneera Rauf",
									  "Bushra Tariq", "Zeenat Hussain", "Areeba Saleem",
									  "Kainat Rizvi", "Sumaiya Hussain", "Sadia Khalid",
									  "Mahnoor Irshad", "Fatima Jameel", "Sakina Hilaj",
									  "Iqra Danyal", "Hina Riaz", "Neha Saleem", "Mehwish Khalid",
									  "Asma Waseem", "Romaisa Tariq", "Laiba Khalid",
									  "Komal Noor", "Bushra Waseem", "Zainab Tariq",
									  "Sadia Saleem", "Kiran Jamshed", "Uzmia Sayyad",
									  "Komal Hussain", "Maryam Raza", "Romaisa Haroon",
									  "Mehwish Abbas", "Maham Riaz", "Sumaiya Khalid",
									  "Anila Anjum", "Areeba Hussain"
									 },
							areas_in_karachi = {"Askari 1", "Askari 2", "Askari 3", "Askari 4",
												"Askari 5", "Bahria Town - Precinct 1",
												"Bahria Town - Precinct 10", "Bahria Town - Precinct 11",
												"Bahria Town - Precinct 12", "Bahria Town - Precinct 13",
												"Bahria Town - Precinct 14", "Bahria Town - Precinct 15",
												"Bahria Town - Precinct 16", "Bahria Town - Precinct 17",
												"Bahria Town - Precinct 18", "Bahria Town - Precinct 19",
												"Bahria Town - Precinct 2", "Bahria Town - Precinct 20",
												"Bahria Town - Precinct 21", "Bahria Town - Precinct 22",
												"Bahria Town - Precinct 23", "Bahria Town - Precinct 24",
												"Bahria Town - Precinct 25", "Bahria Town - Precinct 26",
												"Bahria Town - Precinct 27", "Bahria Town - Precinct 28",
												"Bahria Town - Precinct 29", "Bahria Town - Precinct 3",
												"Bahria Town - Precinct 30", "Bahria Town - Precinct 31",
												"Bahria Town - Precinct 32", "Bahria Town - Precinct 33",
												"Bahria Town - Precinct 4", "Bahria Town - Precinct 5",
												"Bahria Town - Precinct 6", "Bahria Town - Precinct 7",
												"Bahria Town - Precinct 8", "Bahria Town - Precinct 9",
												"BufferZone - Sector 15 A 1", "BufferZone - Sector 15 A 2",
												"BufferZone - Sector 15 A 3", "BufferZone - Sector 15 A 4",
												"BufferZone - Sector 15 A 5", "BufferZone - Sector 15 B",
												"BufferZone - Sector 16 A", "BufferZone - Sector 16 B",
												"Cantonment", "Clifton - Block 1", "Clifton - Block 2",
												"Clifton - Block 3", "Clifton - Block 4",
												"Clifton - Block 5", "Clifton - Block 6",
												"Clifton - Block 7", "Clifton - Block 8",
												"Clifton - Block 9", "Clifton - Kehkashan", "DHA - Phase 1",
												"DHA - Phase 2", "DHA - Phase 3", "DHA - Phase 4",
												"DHA - Phase 5", "DHA - Phase 6", "DHA - Phase 7",
												"DHA - Phase 8", "DHA - Phase 9", "F.B Area - Azizabad",
												"F.B Area - B1 Area", "F.B Area - B Area",
												"F.B Area - Block 1", "F.B Area - Block 10",
												"F.B Area - Block 11", "F.B Area - Block 12",
												"F.B Area - Block 13", "F.B Area - Block 14",
												"F.B Area - Block 15", "F.B Area - Block 16",
												"F.B Area - Block 17", "F.B Area - Block 18",
												"F.B Area - Block 19", "F.B Area - Block 2",
												"F.B Area - Block 20", "F.B Area - Block 21",
												"F.B Area - Block 22", "F.B Area - Block 3",
												"F.B Area - Block 4", "F.B Area - Block 5",
												"F.B Area - Block 6", "F.C Area - C1 Area",
												"F.C Area - C Area", "Garden - Garden East",
												"Garden - Garden West", "Garden - Soldier Bazaar",
												"Gulistan-e-Johar - Block 1", "Gulistan-e-Johar - Block 10",
												"Gulistan-e-Johar - Block 11",
												"Gulistan-e-Johar - Block 12",
												"Gulistan-e-Johar - Block 13",
												"Gulistan-e-Johar - Block 14",
												"Gulistan-e-Johar - Block 15",
												"Gulistan-e-Johar - Block 16",
												"Gulistan-e-Johar - Block 17",
												"Gulistan-e-Johar - Block 18",
												"Gulistan-e-Johar - Block 19", "Gulistan-e-Johar - Block 2",
												"Gulistan-e-Johar - Block 20", "Gulistan-e-Johar - Block 3",
												"Gulistan-e-Johar - Block 4", "Gulistan-e-Johar - Block 5",
												"Gulistan-e-Johar - Block 6", "Gulistan-e-Johar - Block 7",
												"Gulistan-e-Johar - Block 8", "Gulistan-e-Johar - Block 9",
												"Gulshan-e-Hadeed - Data Nagar",
												"Gulshan-e-Hadeed - EIDU Goth",
												"Gulshan-e-Hadeed - Gulshan-e-Mauzzam",
												"Gulshan-e-Hadeed - Gulshan-e-Rehman",
												"Gulshan-e-Hadeed - Mehran Road",
												"Gulshan-e-Hadeed - Phase 1", "Gulshan-e-Hadeed - Phase 2",
												"Gulshan-e-Hadeed - Phase 3",
												"Gulshan-e-Hadeed - PTCL Satellite Station",
												"Gulshan-e-Hadeed - Shah Latif Town",
												"Gulshan-e-Hadeed - Shahnawaz Goth",
												"Gulshan-e-Hadeed - Shah Town",
												"Gulshan-e-Hadeed - Steel Town",
												"Gulshan-e-Iqbal - Adamjee Nagar",
												"Gulshan-e-Iqbal - Block 1", "Gulshan-e-Iqbal - Block 10",
												"Gulshan-e-Iqbal - Block 11", "Gulshan-e-Iqbal - Block 12",
												"Gulshan-e-Iqbal - Block 13", "Gulshan-e-Iqbal - Block 14",
												"Gulshan-e-Iqbal - Block 15", "Gulshan-e-Iqbal - Block 16",
												"Gulshan-e-Iqbal - Block 17", "Gulshan-e-Iqbal - Block 18",
												"Gulshan-e-Iqbal - Block 19", "Gulshan-e-Iqbal - Block 2",
												"Gulshan-e-Iqbal - Block 3", "Gulshan-e-Iqbal - Block 4",
												"Gulshan-e-Iqbal - Block 5", "Gulshan-e-Iqbal - Block 6",
												"Gulshan-e-Iqbal - Block 7", "Gulshan-e-Iqbal - Block 8",
												"Gulshan-e-Iqbal - Block 9",
												"Gulshan-e-Iqbal - Civic Center",
												"Gulshan-e-Iqbal - Dhoraji",
												"Korangi - Abdullah Shah Noorani Pahari Colony",
												"Korangi - Korangi Industrial Area",
												"Korangi - Nasir Colony",
												"Korangi - PAF Base Korangi Creek", "Korangi - Zaman Town",
												"Korangi - Zia Colony", "Landhi - Alflah Housing Society",
												"Landhi - Awami Colony", "Landhi - Bagh-e-Korangi",
												"Landhi - Bakhtawar Goth", "Landhi - Barmi Colony",
												"Landhi - Bhutto Nagar", "Landhi - Future Colony",
												"Landhi - Gulshan-e-Rafi", "Landhi - Ilyas Goth",
												"Landhi - Labour Colony", "Landhi - Landhi Industrial Area",
												"Landhi - Muslimabad Colony",
												"Landhi - Muzaffarabad Colony", "Landhi - Punjab Town",
												"Landhi - Qasim Town", "Landhi - Sadat Colony",
												"Landhi - Shah Khalid Colony", "Landhi - Sharafi Goth",
												"Landhi - Zamanabad", "Liaquatabad - Block 1",
												"Liaquatabad - Block 10", "Liaquatabad - Block 2",
												"Liaquatabad - Block 3", "Liaquatabad - Block 4",
												"Liaquatabad - Block 5", "Liaquatabad - Block 6",
												"Liaquatabad - Block 7", "Liaquatabad - Block 8",
												"Liaquatabad - Block 9", "Malir - Malir Halt",
												"Malir - Malir Cantt", "Nazimabad - Block 1",
												"Nazimabad - Block 2", "Nazimabad - Block 3",
												"Nazimabad - Block 4", "Nazimabad - Block 5",
												"North Karachi - Sector 10",
												"North Karachi - Sector 11 - A",
												"North Karachi - Sector 11 - B",
												"North Karachi - Sector 11 - C 1",
												"North Karachi - Sector 11 - C 2",
												"North Karachi - Sector 11 - C 3",
												"North Karachi - Sector 11 - E",
												"North Karachi - Sector 11 - H",
												"North Karachi - Sector 11 - I",
												"North Karachi - Sector 11 - K",
												"North Karachi - Sector 11 - L", "North Karachi - Sector 2",
												"North Karachi - Sector 3", "North Karachi - Sector 4",
												"North Karachi - Sector 5 - A 1",
												"North Karachi - Sector 5 - A 2",
												"North Karachi - Sector 5 - A 3",
												"North Karachi - Sector 5 - A 4",
												"North Karachi - Sector 5 - B 1",
												"North Karachi - Sector 5 - B 2",
												"North Karachi - Sector 5 - B 3",
												"North Karachi - Sector 5 - B 4",
												"North Karachi - Sector 5 - C 1",
												"North Karachi - Sector 5 - C 2",
												"North Karachi - Sector 5 - C 3",
												"North Karachi - Sector 5 - C 4",
												"North Karachi - Sector 5 - I",
												"North Karachi - Sector 5 - J",
												"North Karachi - Sector 5 - K",
												"North Karachi - Sector 5 - L",
												"North Karachi - Sector 5 - M", "North Karachi - Sector 6",
												"North Karachi - Sector 7 - D 1",
												"North Karachi - Sector 7 - D 2",
												"North Karachi - Sector 7 - D 3",
												"North Karachi - Sector 7 - D 4",
												"North Karachi - Sector 8", "North Karachi - Sector 9",
												"North Nazimabad - Block A", "North Nazimabad - Block B",
												"North Nazimabad - Block C", "North Nazimabad - Block D",
												"North Nazimabad - Block E", "North Nazimabad - Block F",
												"North Nazimabad - Block G", "North Nazimabad - Block H",
												"North Nazimabad - Block I", "North Nazimabad - Block J",
												"North Nazimabad - Block K", "North Nazimabad - Block L",
												"North Nazimabad - Block M", "North Nazimabad - Block N",
												"North Nazimabad - Block O", "North Nazimabad - Block P",
												"North Nazimabad - Block Q", "North Nazimabad - Block R",
												"North Nazimabad - Block S", "North Nazimabad - Block T",
												"Old Town - Bhimpora", "Old Town - Bohra Pir",
												"Old Town - Bombay Bazar", "Old Town - Jodia Bazar",
												"Old Town - Kagzi Bazar", "Old Town - Kakri Ground",
												"Old Town - Kamil Gali", "Old Town - Khada Market",
												"Old Town - Kharadar", "Old Town - Lee Market",
												"Old Town - Mithadar", "Old Town - Nanwara",
												"Old Town - Nishter Road", "Old Town - Pan Mandi",
												"Old Town - Ramswami", "Old Town - Ranchorline",
												"Orangi Town - Banaras Town", "Orangi Town - Bangla Bazaar",
												"Orangi Town - Bilal Colony", "Orangi Town - Katti Pahari",
												"Orangi Town - Moria Goth Orangi", "Orangi Town - Orangi",
												"Orangi Town - Sector 14 - A",
												"Orangi Town - Sector 14 - C", "Orangi Town - Thorani Goth",
												"Baldiya Town", "Baloch Colony", "Civil Line", "FC Area",
												"Firdous Colony", "Gulshan-e-Maymar", "Hawksbay",
												"I.I Chundrigar", "Jamshed Road", "K.D.A Officers",
												"Kemari", "Liyari", "M.A Jinnah Rd", "Manora",
												"New Karachi", "New Surjani", "PIB Colony", "Pipri Goth",
												"Rizvia Society", "Saddar", "Scheme 33", "Shabbirabad",
												"P.E.C.H.S - Block 1", "P.E.C.H.S - Block 2",
												"P.E.C.H.S - Block 3", "P.E.C.H.S - Block 4",
												"P.E.C.H.S - Block 5", "P.E.C.H.S - Block 6",
												"P.E.C.H.S - Khalid Bin Walid", "P.E.C.H.S - Tariq Road",
												"S.I.T.E - Golimar", "S.I.T.E - S.I.T.E",
												"Shah Faisal Colony - Aswan Town",
												"Shah Faisal Colony - Gulshan-e-Asghar",
												"Shah Faisal Colony - Shah Faisal Colony 1",
												"Shah Faisal Colony - Shah Faisal Colony 5",
												"F.B Area - Block 7", "F.B Area - Block 9",
												"P.E.C.H.S - Block 7", "Aram Bagh", "Bath Island",
												"University Road", "Bahadurabad", "Shah Faisal Colony - 4",
												"Banglore Town", "Fowler Lines",
												"Shah Faisal Colony - Shamsi Society", "Gulshan-e-Jamal",
												"Shah Faisal Colony - 3", "Shah Faisal Colony - Green Town",
												"Darwaish Colony", "Korangi - Sector 31 B",
												"Firdous Colony", "North Nazimabad - Block W",
												"K.A.E.C.H.S", "Mehmoodabad", "Korangi - Mehran Town",
												"Landhi Town - 36 B", "Karachi Memon Society",
												"Madras Cooperative Housing Society", "Shahrah-e-Faisal",
												"Korangi - Sector 41 B", "Clifton - Delhi Colony",
												"Korangi - Sector 32 B", "Dhoraji - Adamjee Nagar",
												"Bhimpura", "Dhoraji - CP& Berar Society",
												"Shahra-e-Faisal - Umar Colony", "Model Colony",
												"Gulshan-e-Shamim", "Clifton - Shah Rasool Colony",
												"North Karachi - Sector 12 C",
												"Jail Road - Hyderabad Colony", "Napier Quarter",
												"Gulzar-e-Hijri", "North Karachi - Sector 12 A",
												"Shahra-e-Faisal - Jinnah Housing Society",
												"K.D.A Scheme 1", "Clifton - Punjab Colony",
												"Korangi - Sector 31 D", "Clifton - Zamzama",
												"Parsi Colony", "Qayyumabad", "Khokrapar",
												"Shah Faisal Colony - Muslimabad Malir City",
												"F.B Area - Block 8", "Nanak Wara", "Mohammad Ali Society",
												"Manzoor Colony", "Dalmia", "Defence View - Phase 1",
												"Defence View - Phase 2", "KDA Officers Housing Society",
												"Karimabad", "Soldier Bazar", "Hussainabad",
												"Sharfabad Society", "Gharibabad",
												"Sindhi Muslim Cooperative Housing Society"
											   },
	rndcts = {
		"Your heart is the size of an ocean. Go find yourself in its hidden depths.",
		"Thinking is the capital, enterprise is the way, hard work is the solution.",
		"If you can't make it good, at least make it look good.",
		"Heart be brave. If you cannot be brave, just go. Love's glory is not a small thing.",
		"If you are out to describe the truth, leave elegance to the tailor.",
		"O man you are busy working for the world, and the world is busy trying to turn you out.",
		"While children are struggling to be unique, the world around them is trying all means to make them look like everybody else.",
		"These capitalists generally act harmoniously and in concert, to fleece the people.",
		"I don't believe in failure. It is not failure if you enjoyed the process.",
		"Wear gratitude like a cloak and it will feed every corner of your life.",
		"If you even dream of beating me you'd better wake up and apologize.",
		"I will praise any man that will praise me.",
		"One of the greatest diseases is to be nobody to anybody.",
		"I'm so fast that last night I turned off the light switch in my hotel room and was in bed before the room was dark.",
		"People must learn to hate and if they can learn to hate, they can be taught to love.",
		"Everyone has been made for some particular work, and the desire for that work has been put in every heart.",
		"The less of the world, the freer you live.",
		"Respond to every call that excites your spirit.",
		"The way to get started is to quit talking and begin doing.",
		"Speak any language, turkish, greek, persian, arabic, but always speak with love.",
		"Knowledge is of two kinds: that which is absorbed and that which is heard. And that which is heard does not profit if it is not absorbed.",
		"When I am silent, I have thunder hidden inside.",
		"Technological progress is like an axe in the hands of a pathological criminal.",
		"No one would choose a friendless existence on condition of having all the other things in the world.",
		"Life is a gamble. You can get hurt, but people die in plane crashes, lose their arms and legs in car accidents; people die every day. Same with fighters: some die, some get hurt, some go on. You just don't let yourself believe it will happen to you.",
		"Let us sacrifice our today so that our children can have a better tomorrow.",
		"Your task is not to seek for love, but merely to seek and find all the barriers within yourself that you have built against it.",
		"Everything in the universe is within you. Ask all from yourself.",
		"I'm not a handsome guy, but I can give my hand to someone who needs help. Beauty is in the heart, not in the face.",
		"A good head and a good heart are always a formidable combination.",
		"The soul never thinks without a picture.",
		"Let the beauty we love be what we do. There are hundreds of ways to kneel and kiss the ground.",
		"Success is dependent upon the glands - sweat glands."
	},
	rkuniss = {"Aga Khan University",
			   "Air War College Institute, Karachi",
			   "Baqai Medical University",
			   "Benazir Bhutto Shaheed University Lyari",
			   "Commecs Institute of Business & Emerging Sciences",
			   "Dadabhoy Institute of Higher Education",
			   "Dawood University of Engineering & Technology",
			   "DHA Suffa University", "DOW University of Health Sciences",
			   "Emaan Institute of Management & Sciences, Karachi",
			   "Greenwich University", "Habib University",
			   "Hamdard University", "ILMA University", "Indus University",
			   "Indus Valley School of Art & Architecture",
			   "Institute of Business Administration",
			   "Institute of Business Management", "Iqra University",
			   "Jinnah Sindh Medical University",
			   "Jinnah University for Women",
			   "Karachi Institute of Economics & Technology",
			   "Karachi Institute of Technology and Entrepreneurship (KITE), "
			   + "Karachi",
			   "Karachi School of Business and Leadership",
			   "KASB Institute of Technology",
			   "Malir University of Science & Technology, Karachi",
			   "Metropolitan University Karachi",
			   "Millennium Institute of Technology and Entrepreneurship, Karachi",
			   "Muhammad Ali Jinnah University",
			   "NED University of Engineering & Technology",
			   "Newport Institute of Communications & Economics",
			   "Pakistan Naval Academy",
			   "Preston Institute of Management, Science & Technology",
			   "Preston University",
			   "Salim Habib University (Former Barret Hodgson University), "
			   + "Karachi",
			   "Shaheed Benazir Bhutto City University",
			   "Shaheed Benazir Bhutto Dewan University",
			   "Shaheed Zulfikar Ali Bhutto Institute of Science & Technology",
			   "Shaheed Zulfiqar Ali Bhutto University of Law",
			   "Sindh Institute of Management & Technology",
			   "Sindh Institute of Medical Sciences",
			   "Sindh Madresatul Islam University",
			   "Sir Syed University of Engineering & Technology",
			   "Sohail University, Karachi",
			   "Textile Institute of Pakistan",
			   "The Nazeer Hussain University", "UIT University, Karachi",
			   "University of Karachi", "Zia-ud-Din University"
			  },
	rjbss = {"Accountant", "Banker", "Pilot", "Marine Pilot", "Doctor",
			 "Nurse", "Physician", "Laboratorian",
			 "Psychiatrist/Psychologist", "Dermatologist",
			 "Gynecologist", "Cardiologist", "Surgeon",
			 "Ophthalmologist", "Pediatrician", "Watchman", "Tailor",
			 "Designer", "Photographer", "Model", "Fashion Designer",
			 "Makeup Artist", "Dressmaker", "Content Writer",
			 "Police Officer", "Undercover Police Officer",
			 "Prison Officer/Jailer", "Reporter", "Journalist",
			 "Investigator", "Laborer", "Data Analyst", "Data Scientist",
			 "Saleswo/man", "Tele-saleswo/man", "Developer", "Engineer",
			 "Plumber", "Human Resources Manager", "Legal Counsel",
			 "Judge", "Lawyer", "Travel Guide", "Scientist", "Goldsmith",
			 "Blacksmith", "Lumberjack", "White-hat hacker",
			 "Black-hat hacker", "Caretaker", "Nanny", "Fisher",
			 "Architect", "Software Architect", "Farmer",
			 "Agriculture Engineer", "Software Engineer",
			 "Support Specialist", "Systems Analyst",
			 "Technical Support Engineer", "Web Developer",
			 "Web Designer", "Animator", "Filmmaker", "Actor",
			 "Comedian", "Director", "Vocalist", "Musician",
			 "Bedroom Musician/DJ", "Songwriter", "Screenwriter",
			 "Barber", "Barista/Bartender", "Tattooist", "Electrician",
			 "Vehicle Technician", "Cartoonist", "Cook",
			 "Travel Advisor", "Translator", "Relationship Counselor",
			 "accountant", "actor", "actuary",
			 "adhesive bonding machine tender", "adjudicator",
			 "administrative assistant",
			 "administrative services manager",
			 "adult education teacher", "advertising manager",
			 "advertising sales agent", "aerobics instructor",
			 "aerospace engineer", "aerospace engineering technician",
			 "agent", "agricultural engineer",
			 "agricultural equipment operator", "agricultural grader",
			 "agricultural inspector", "agricultural manager",
			 "agricultural sciences teacher", "agricultural sorter",
			 "agricultural technician", "agricultural worker",
			 "air conditioning installer", "air conditioning mechanic",
			 "air traffic controller",
			 "aircraft cargo handling supervisor", "aircraft mechanic",
			 "aircraft service technician", "airline copilot",
			 "airline pilot", "ambulance dispatcher", "ambulance driver",
			 "amusement machine servicer", "anesthesiologist",
			 "animal breeder", "animal control worker",
			 "animal scientist", "animal trainer", "animator",
			 "answering service operator", "anthropologist",
			 "apparel patternmaker", "apparel worker", "arbitrator",
			 "archeologist", "architect", "architectural drafter",
			 "architectural manager", "archivist", "art director",
			 "art teacher", "artist", "assembler", "astronomer",
			 "athlete", "athletic trainer", "ATM machine repairer",
			 "atmospheric scientist", "attendant",
			 "audio and video equipment technician",
			 "audio-visual and multimedia collections specialist",
			 "audiologist", "auditor", "author",
			 "auto damage insurance appraiser",
			 "automotive and watercraft service attendant",
			 "automotive glass installer", "automotive mechanic",
			 "avionics technician", "back-end developer",
			 "baggage porter", "bailiff", "baker", "barback", "barber",
			 "bartender", "basic education teacher",
			 "behavioral disorder counselor", "bellhop",
			 "bench carpenter", "bicycle repairer",
			 "bill and account collector", "billing and posting clerk",
			 "biochemist", "biological technician",
			 "biomedical engineer", "biophysicist", "blaster",
			 "blending machine operator", "blockmason",
			 "boiler operator", "boilermaker", "bookkeeper",
			 "boring machine tool tender", "brazer", "brickmason",
			 "bridge and lock tender", "broadcast news analyst",
			 "broadcast technician", "brokerage clerk", "budget analyst",
			 "building inspector", "bus mechanic", "butcher", "buyer",
			 "cabinetmaker", "cafeteria attendant", "cafeteria cook",
			 "camera operator", "camera repairer",
			 "cardiovascular technician", "cargo agent", "carpenter",
			 "carpet installer", "cartographer", "cashier", "caster",
			 "ceiling tile installer", "cellular equipment installer",
			 "cement mason", "channeling machine operator", "chauffeur",
			 "checker", "chef", "chemical engineer",
			 "chemical plant operator", "chemist", "chemistry teacher",
			 "chief executive", "child social worker",
			 "childcare worker", "chiropractor", "choreographer",
			 "civil drafter", "civil engineer",
			 "civil engineering technician", "claims adjuster",
			 "claims examiner", "claims investigator", "cleaner",
			 "clinical laboratory technician",
			 "clinical laboratory technologist", "clinical psychologist",
			 "coating worker", "coatroom attendant", "coil finisher",
			 "coil taper", "coil winder", "Coach",
			 "coin machine servicer", "commercial diver",
			 "commercial pilot", "commodities sales agent",
			 "communications equipment operator",
			 "communications teacher", "community association manager",
			 "community service manager",
			 "compensation and benefits manager", "compliance officer",
			 "composer", "computer hardware engineer",
			 "computer network architect", "computer operator",
			 "computer programmer", "computer science teacher",
			 "computer support specialist",
			 "computer systems administrator",
			 "computer systems analyst", "concierge", "conciliator",
			 "concrete finisher", "conservation science teacher",
			 "conservation scientist", "conservation worker",
			 "conservator", "construction inspector",
			 "construction manager", "construction painter",
			 "construction worker", "continuous mining machine operator",
			 "convention planner", "conveyor operator", "cook",
			 "cooling equipment operator", "copy marker",
			 "correctional officer", "correctional treatment specialist",
			 "correspondence clerk", "correspondent", "cosmetologist",
			 "cost estimator", "costume attendant",
			 "counseling psychologist", "counselor", "courier",
			 "court reporter", "craft artist", "crane operator",
			 "credit analyst", "credit checker", "credit counselor",
			 "criminal investigator", "criminal justice teacher",
			 "crossing guard", "curator", "custom sewer",
			 "customer service representative", "cutter",
			 "textile worker", "therapist", "ticket agent",
			 "ticket taker", "tile setter", "timekeeping clerk",
			 "timing device assembler", "tire builder", "tire changer",
			 "tire repairer", "title abstractor", "title examiner",
			 "title searcher", "tobacco roasting machine operator",
			 "tool filer", "tool grinder", "tool maker",
			 "tool sharpener", "tour guide", "tower equipment installer",
			 "tower operator", "track switch repairer",
			 "tractor operator", "tractor-trailer truck driver",
			 "traffic clerk", "traffic technician",
			 "training and development manager",
			 "training and development specialist", "transit police",
			 "translator", "transportation equipment painter",
			 "transportation inspector",
			 "transportation security screener", "transportation worker",
			 "trapper", "travel agent", "travel clerk", "travel guide",
			 "tree pruner", "tree trimmer", "trimmer", "truck loader",
			 "truck mechanic", "tuner", "turning machine tool operator",
			 "tutor", "typist", "umpire", "undertaker", "upholsterer",
			 "urban planner", "usher", "UX designer", "valve installer",
			 "vending machine servicer", "veterinarian",
			 "veterinary assistant", "veterinary technician",
			 "vocational counselor", "vocational education teacher",
			 "waiter", "waitress", "watch repairer",
			 "water treatment plant operator", "weaving machine setter",
			 "web developer", "weigher", "welder", "wellhead pumper",
			 "wholesale buyer", "wildlife biologist", "window trimmer",
			 "wood patternmaker", "woodworker", "word processor",
			 "writer", "yardmaster", "zoologist"
			};
	public static String randNationality() {
		return randFrom(ntltss);
	}
	public static String fakeNationality() {
		return randNationality();
	}
	public static String randCity() {
		return randFrom(ctss);
	}
	public static String randAreaInKarachi() {
		return randFrom(areas_in_karachi);
	}
	public static String randKarachiArea() {
		return randAreaInKarachi();
	}
	public static String randKarachiUniversity() {
		return randFrom(rkuniss);
	}
	public static String randPhone() {
		return randFrom(rfnss);
	}
	public static String randJob() {
		return randFrom(rjbss);
	}
	public static String randGirlName() {
		return randFrom(rglnss);
	}
	public static String randGuyName() {
		return randFrom(rgynss);
	}
	public static String randWord() {
		return randFrom(wdss);
	}
	public static String randSentence() {
		return randFrom(rndcts);
	}
	static String fakeNationality = "", randAreaInKarachi = "";
	public static final String randNationality = fakeNationality = fakeNationality(),
							   randCity = randCity(),
							   randKarachiArea = randAreaInKarachi = randAreaInKarachi(),
							   randKarachiUniversity = randKarachiUniversity(),
							   randJob = randJob(), randPhone = randPhone(),
							   randGirlName = randGirlName(), randGuyName = randGuyName(),
							   randWord = randWord(), randSentence = randSentence();
	// Files
	public static boolean createFile(String fname) {
		try {
			File myFile = new File(fname);
			if (myFile.createNewFile()) {
				System.out.println("\n[KL FileReader]: File \""
								   + myFile.getName() + "\" created successfully");
				return true;
			} else {
				print("\n[KL FileReader]: File either already exists, or you "
					  + "do not have enough permissions to create a new file "
					  + "in this directory.\n");
			}
		} catch (IOException e) {
			print("\n[KL FileReader]: Something went wrong.\n");
		}
		return false;
	}
	public static boolean createFile(String fname, String content) {
		try {
			File myFile = new File(fname);
			FileWriter fr = new FileWriter(fname);
			fr.write(content);
			print("\n[KL FileReader]: File \"" + myFile.getName()
				  + "\" created successfully");
			fr.close();
			return true;
		} catch (IOException e) {
			print("\n[KL FileReader]: Something went wrong. File creation "
				  + "failed.\n");
		}
		return false;
	}
	public static boolean newFile(String fname) {
		return createFile(fname);
	}
	public static boolean newFile(String fname, String content) {
		return createFile(fname, content);
	}
	public static boolean deleteFile(String fname) {
		File myFile = new File(fname);
		String msgOnSuccess = "\n[KL FileReader]: File \"" + myFile.getPath()
							  + "\" deleted successfully.\n",
							  msgOnFailure = "\n[KL FileReader]: Task failed, no such file/folder!\n";
		if (!myFile.exists()) {
			print(msgOnFailure);
			return false;
		}
		if (myFile.isDirectory()) {
			for (File c : myFile.listFiles())
				deleteFile(c.toString());
		}
		myFile.delete();
		print(msgOnSuccess);
		return true;
	}
	public static boolean removeFile(String fname) {
		return deleteFile(fname);
	}
	public static boolean deleteFolder(String fname) {
		return deleteFile(fname);
	}
	public static boolean removeFolder(String fname) {
		return deleteFile(fname);
	}
	public static boolean renameFile(String fname, String destinationString) {
		try {
			File myFile = new File(fname);
			File destinationFile = new File(destinationString);
			if (myFile.renameTo(destinationFile)) {
				print("\n[KL FileReader]: File " + myFile.getName()
					  + " was successfully moved/renamed to "
					  + destinationFile.getPath());
				return true;
			} else {
				print("\n[KL FileReader]: You do not have enough permissions "
					  + "to move/rename this file.\n");
				IOException e = new IOException();
				throw e;
			}
		} catch (IOException e) {
			print("\n[KL FileReader]: Something went wrong.\n");
		}
		return false;
	}
	public static boolean moveFile(String from, String to) {
		return renameFile(from, to);
	}
	public static String readFile(String fname) {
		String data = "";
		try {
			File myObj = new File(fname);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine())
				data += myReader.nextLine();
			myReader.close();
		} catch (FileNotFoundException e) {
			print("\n[KL FileReader]: Something went wrong.\n");
		}
		return data;
	}
	public static boolean copyFile(String from, String to) {
		File fileToCopy = new File(from);
		File destination = new File(to);
		try {
			Files.copy(fileToCopy.toPath(), destination.toPath(),
					   StandardCopyOption.REPLACE_EXISTING);
			return true;
		} catch (IOException e) {
			System.out.println("\n[KL FileReader]: File Failed to copy!\n");
		}
		return false;
	}
	public static boolean createFolder(String folderName) {
		File fileFolder = new File(folderName);
		return fileFolder.mkdirs();
	}
	public static boolean newFolder(String folderName) {
		return createFolder(folderName);
	}
	public static void main(String[] args) {
		String[] arr = {"hi", "Hola", "hallo", "bonjour", "zoo", "YiPPe yay"};
		arr = sort(arr, "desc");
		arr = lower(arr);
		char[] chars = Chars(lastOf(arr));
		printArr(upper(chars));
		printArr(sentCase(arr));
	}
}