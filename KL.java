package jcalculator;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.lang.reflect.*;
import java.net.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import javax.crypto.*;
import javax.crypto.spec.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.*;
@SuppressWarnings("all")
public class KL {
	public static class money {
		private double amnt;
		private String curr;
		money() {
			this.amnt = 0;
			this.curr = "Rs. ";
		}
		money(double amnt) {
			this.amnt = not(amnt) ? 0 : amnt;
			this.curr = "Rs. ";
		}
		money(double amnt, String curr) {
			this.amnt = not(amnt) || isinf(amnt) ? 0 : amnt;
			this.curr = not(this.curr) || len(this.curr) < 1
					|| len(this.curr) > 4 ? "Rs. " : titleCase(curr);
		}
		money curr(String curr) {
			this.curr = not(curr) || len(curr) < 1 || len(curr) > 4
					? "Rs. "
					: titleCase(curr);
			return this;
		}
		money amount(double newAmnt) {
			this.amnt = isinf(newAmnt) ? this.amnt : newAmnt;
			return this;
		}
		money set(double newAmnt) {
			amount(newAmnt);
			return this;
		}
		money add(double... nums) {
			each(nums, (n, i) -> this.amnt += n);
			return this;
		}
		money give(double... nums) {
			add(nums);
			return this;
		}
		money plus(double... nums) {
			add(nums);
			return this;
		}
		money deposit(double... nums) {
			add(nums);
			return this;
		}
		money minus(double... nums) {
			each(nums, (n, i) -> this.amnt -= n);
			return this;
		}
		money take(double... nums) {
			minus(nums);
			return this;
		}
		money sub(double... nums) {
			minus(nums);
			return this;
		}
		money withdraw(double... nums) {
			minus(nums);
			return this;
		}
		money times(double... nums) {
			each(nums, (n, i) -> this.amnt *= n);
			return this;
		}
		money mul(double... nums) {
			times(nums);
			return this;
		}
		money div(double... nums) {
			each(nums, (n, i) -> this.amnt /= n);
			return this;
		}
		money quotient(double... nums) {
			div(nums);
			return this;
		}
		public String suffix(boolean... bools) {
			boolean forceInternational = bools.length > 0 ? bools[0] : false;
			this.curr = trim(this.curr) + " ";
			if (in(this.curr, "pk|in|rs"))
				return "Rs. " + (forceInternational
						? ussuffix(amnt)
						: pksuffix(amnt));
			if (in(this.curr, "us"))
				return "USD " + ussuffix(amnt);
			return this.curr + (forceInternational
					|| (is(this.curr) && !in(this.curr, "pk|in|rs"))
							? ussuffix(amnt)
							: pksuffix(amnt));
		}
		public String toString() {
			this.curr = trim(this.curr) + " ";
			if (not(this.curr) || in(this.curr, "pk|in|rs"))
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
		public String str() {
			return string();
		}
		public String string(boolean suffixMode) {
			return toString(suffixMode);
		}
		public String str(boolean suffixMode) {
			return string(suffixMode);
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
	public static final class pesa extends money {
		pesa() {
			super.amnt = 0;
			super.curr = "Rs. ";
		}
		pesa(double amnt) {
			super.amnt = isinf(amnt) ? 0 : amnt;
			super.curr = "Rs. ";
		}
		pesa(double amnt, String curr) {
			super.amnt = not(amnt) || isinf(amnt) ? 0 : amnt;
			super.curr = not(super.curr) || len(super.curr) < 1
					|| len(super.curr) > 4 ? "Rs. " : titleCase(curr);
		}
	}
	public static final class kmath {
		public static double pi = 3.141592653589793, c = 2.99792e8,
				earthsGravity = 9.80665, earthsMass = 5.9722e24,
				earthsRadius = 6.378137e3;
		public static String cUnit = "m/s", earthsGravityUnit = "m/s^2",
				earthsMassUnit = "km", earthsRadiusUnit = "km";
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
		final String ofXAlgo = "AES";
		try {
			SecretKeySpec secretKey = new SecretKeySpec(
					key.getBytes(StandardCharsets.UTF_8), ofXAlgo);
			Cipher cipher = Cipher.getInstance(ofXAlgo);
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			byte[] encryptedBytes = cipher
					.doFinal(data.getBytes(StandardCharsets.UTF_8));
			return Base64.getEncoder().encodeToString(encryptedBytes);
		} catch (Exception err) {
			return data;
		}
	}
	public static String decrypt(String encryptedData, String key) {
		final String ofXAlgo = "AES";
		try {
			SecretKeySpec secretKey = new SecretKeySpec(
					key.getBytes(StandardCharsets.UTF_8), ofXAlgo);
			Cipher cipher = Cipher.getInstance(ofXAlgo);
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			byte[] decryptedBytes = cipher
					.doFinal(Base64.getDecoder().decode(encryptedData));
			return new String(decryptedBytes, StandardCharsets.UTF_8);
		} catch (Exception err) {
			print("[KL.Decryptor.BadArguments]:\nFailed to decrypt the message.");
			return "";
		}
	}
	public static boolean internet() {
		try {
			URL url = url("https://java.com/");
			URLConnection conn = url.openConnection();
			conn.connect();
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	public static objS parseJson(String jsonString) {
		objS map = new objS();
		if (not(jsonString))
			return map;
		jsonString = jsonString.trim();;
		if (!jsonString.startsWith("{") || !jsonString.endsWith("}")) {
			map.add("status", "notok").add("error", "yes");
			return map;
		}
		jsonString = jsonString.substring(1, jsonString.length() - 1);
		String[] keyValuePairs = jsonString.split("\\s*,\\s*");
		for (String pair : keyValuePairs) {
			String[] parts = pair.split("[\\[\\]\\s\\w]*:[\\[\\]\\s\\w]*", 2);
			if (parts.length == 2) {
				String key = parts[0].replaceAll("[\"\\{\\[\\]\\}]+", "")
						.trim();
				String value = parts[1].replaceAll("[\"\\{\\[\\]\\}]+", "")
						.replaceAll("\\w+:\\s*", "").trim();
				if (key.length() != 0 && in(key, "[a-zA-Z]+")
						&& value.length() != 0 && in(value, "[a-zA-Z]+"))
					map.add(key, value);
			}
		}
		map.add("status", "ok").add("error", "no");
		return map;
	}
	public static objS fetch(String url) {
		objS map = new objS();
		try {
			URL urlString = url(url);
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
				String jsonString = respBuilder.toString().trim();
				map = parseJson(jsonString);
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
	public static objS silentFetch(String url) {
		objS map = new objS();
		try {
			URL urlString = url(url);
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
				String jsonString = respBuilder.toString().trim();
				map = parseJson(jsonString);
				map.add("response", "200").add("status", "ok").add("error",
						"no");
				return map;
			} else {
				map.add("response", Str(statusCode)).add("status", "notok")
						.add("error", "yes");
			}
			connection.disconnect();
		} catch (IOException e) {
			map.add("response", "404").add("status", "notok").add("error",
					"yes");
		}
		return map;
	}
	public String getPath(String to) {
		if (not(to))
			return "";
		return getClass().getResource(to).toString();
	}
	public String filePath(String filename) {
		return getPath(filename);
	}
	public String pathTo(String filename) {
		return getPath(filename);
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
	// gui
	public static class gui extends JFrame {
		private static final long serialVersionUID = 1L;
		gui() {
			super();
			exitOnClose();
			resizable();
			super.setLayout(new BorderLayout());
		}
		gui(String title) {
			super();
			exitOnClose();
			resizable();
			title(title);
			super.setLayout(new BorderLayout());
		}
		gui(String title, int w, int h) {
			super();
			exitOnClose();
			resizable();
			title(title);
			size(w, h);
			super.setLayout(new BorderLayout());
		}
		gui title(String title) {
			super.setTitle(title);
			return this;
		}
		gui kaTitle(String title) {
			title(title);
			return this;
		}
		gui size(int w, int h) {
			if (w < 100 || h < 100 || w > 10e3 || h > 10e3)
				super.setSize(400, 600);
			else
				super.setSize(w, h);
			super.setLocationRelativeTo(null);
			return this;
		}
		gui size(String WxH) {
			if (not(WxH) || !eq(WxH, "\\d{3,4}+[Xx]\\d{3,4}"))
				return this;
			String[] parts = WxH.split("[Xx]");
			int w = Int(parts[0]), h = Int(parts[1]);
			size(w, h);
			return this;
		}
		gui kiSize(int w, int h) {
			size(w, h);
			return this;
		}
		gui kiSize(String WxH) {
			size(WxH);
			return this;
		}
		gui start() {
			Dimension res = super.getSize();
			int width = res.width, height = res.height;
			if (width < 100 || height < 100 || width > 10e3 || height > 10e3)
				size(400, 600);
			super.setVisible(true);
			return this;
		}
		gui start(int w, int h) {
			size(w, h);
			super.setVisible(true);
			return this;
		}
		gui shuru() {
			start();
			return this;
		}
		gui shuru(int w, int h) {
			start(w, h);
			return this;
		}
		gui appear() {
			start();
			return this;
		}
		gui disappear() {
			super.setVisible(false);
			return this;
		}
		gui resizable() {
			super.setResizable(true);
			return this;
		}
		gui notResizable() {
			super.setResizable(false);
			return this;
		}
		gui resizableNaHo() {
			notResizable();
			return this;
		}
		gui onTop(boolean b) {
			super.setAlwaysOnTop(b);
			return this;
		}
		gui onTop() {
			onTop(true);
			return this;
		}
		gui offTop() {
			onTop(false);
			return this;
		}
		gui alwaysOnTop(boolean b) {
			onTop(b);
			return this;
		}
		gui alwaysOnTop() {
			onTop();
			return this;
		}
		boolean isOnTop() {
			return super.isAlwaysOnTop();
		}
		gui hameshaTopPe(boolean b) {
			onTop(b);
			return this;
		}
		gui hameshaTopPe() {
			onTop();
			return this;
		}
		gui topPe(boolean b) {
			onTop(b);
			return this;
		}
		gui hameshaTopPeHe() {
			isOnTop();
			return this;
		}
		gui topPeHe() {
			isOnTop();
			return this;
		}
		gui add(Component... components) {
			for (Component c : components) {
				if (c == null)
					continue;
				super.add(c);
			}
			return this;
		}
		gui opacity(double o) {
			if (o < 0 || o > 100)
				return this;
			if (o > 1)
				super.setOpacity((float) o / 100);
			else if (o >= 0 && o <= 1)
				super.setOpacity((float) o);
			return this;
		}
		gui cursor(int c) {
			super.setCursor(new Cursor(c));
			return this;
		}
		gui cursor(Cursor crsrObj) {
			super.setCursor(crsrObj);
			return this;
		}
		gui bg(Color clr) {
			super.setBackground(clr);
			return this;
		}
		gui setBg(Color clr) {
			bg(clr);
			return this;
		}
		gui icon(String address) {
			// set title-bar icon
			try {
				super.setIconImage(new ImageIcon(address).getImage());
			} catch (Exception e) {

			}
			return this;
		}
		gui font(String fontFamily, int fontSize) {
			super.setFont(new Font(fontFamily, Font.PLAIN, fontSize));
			return this;
		}
		gui font(String fontFamily, int fontSize, int fontWidth) {
			super.setFont(new Font(fontFamily, fontWidth, fontSize));
			return this;
		}
		gui font(String fontFamily, int fontSize, boolean bold,
				boolean italic) {
			super.setFont(new Font(fontFamily, bold && italic
					? Font.BOLD | Font.ITALIC
					: bold ? Font.BOLD : italic ? Font.ITALIC : Font.PLAIN,
					fontSize));
			return this;
		}
		gui font(String fontFamily, int fontSize, boolean bold) {
			font(fontFamily, fontSize, bold, false);
			return this;
		}
		gui font(String fontFamily, int fontSize, int bold, int italic) {
			super.setFont(new Font(fontFamily,
					bold == 1 && italic == 1
							? Font.BOLD | Font.ITALIC
							: bold == 1
									? Font.BOLD
									: italic == 1 ? Font.ITALIC : Font.PLAIN,
					fontSize));
			return this;
		}
		gui font(Font fnt) {
			super.setFont(fnt);
			return this;
		}
		boolean openUrl(String urlString) {
			try {
				if (!isUrl(urlString))
					return false;
				Desktop.getDesktop().browse(new URI(urlString));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		double mouseX() {
			return MouseInfo.getPointerInfo().getLocation().getX();
		}
		double mouseY() {
			return MouseInfo.getPointerInfo().getLocation().getY();
		}
		gui exitOnClose() {
			super.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
			this.on("close", () -> {
				boolean confirmed = this
						.confirm("Are you sure you want to close?");
				if (confirmed)
					super.dispose();
			});
			return this;
		}
		gui on(String k, Runnable action) {
			if (KL.in(k, "\\w{3,}\\|\\w{3,}")) {
				String[] keys = k.split("\\|");
				for (var key : keys) {
					on(key, action);
				}
			}
			if (KL.is(k) && KL.is(action)) {
				super.addKeyListener(new KeyAdapter() {
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
							new Thread(action).run();
						}
					}
				});
				super.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						int button = -1;
						if (KL.eq(k, "(m(ouse)?)?\\W?click")
								|| KL.eq(k, "(m(ouse)?)?\\W?clickl")
								|| KL.eq(k, "(m(ouse)?)?\\W?lclick"))
							button = MouseEvent.BUTTON1;
						else if (KL.eq(k, "(m(ouse)?)?\\W?clickm")
								|| KL.eq(k, "(m(ouse)?)?\\W?clickw")
								|| KL.eq(k, "(m(ouse)?)?\\W?mclick")
								|| KL.eq(k, "(m(ouse)?)?\\W?wclick"))
							button = MouseEvent.BUTTON2;
						else if (KL.eq(k, "(m(ouse)?)?\\W?clickr")
								|| KL.eq(k, "(m(ouse)?)?\\W?rclick"))
							button = MouseEvent.BUTTON3;
						if (e.getButton() == button) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseReleased(MouseEvent e) {
						if (KL.eq(k, "(m(ouse)?)\\W?release")) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseEntered(MouseEvent e) {
						if (KL.eq(k, "(m(ouse)?)\\W?(enter|in)")) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseExited(MouseEvent e) {
						if (KL.eq(k, "(m(ouse)?)\\W?(leave|out)")) {
							new Thread(action).run();
						}
					}
				});
				super.addMouseMotionListener(new MouseMotionAdapter() {
					@Override
					public void mouseDragged(MouseEvent e) {
						if (KL.eq(k, "(m(ouse)?)?\\W?drag")) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseMoved(MouseEvent e) {
						if (KL.eq(k, "(m(ouse)?)\\W?move")) {
							new Thread(action).run();
						}
					}
				});
				super.addMouseWheelListener(new MouseWheelListener() {
					@Override
					public void mouseWheelMoved(MouseWheelEvent e) {
						if (KL.eq(k, "(m(ouse)?)\\W?wheel")) {
							new Thread(action).run();
						}
					}
				});
				super.addWindowListener(new WindowAdapter() {
					@Override
					public void windowOpened(WindowEvent e) {
						if (KL.eq(k, "launch|start")) {
							new Thread(action).run();
						}
					}
					@Override
					public void windowClosing(WindowEvent e) {
						if (KL.eq(k, "exit|close")) {
							new Thread(action).run();
						}
					}
					// there's a difference between these two
					@Override
					public void windowClosed(WindowEvent e) {
						if (KL.eq(k, "exited|closed|(after|post)\\W?close")) {
							new Thread(action).run();
						}
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
		gui state(String newState) {
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
		gui min() {
			state("min");
			return this;
		}
		gui max() {
			state("max");
			return this;
		}
		gui message(String message) {
			if (this.isOnTop())
				offTop();
			JOptionPane.showMessageDialog(null, message, "Message",
					JOptionPane.INFORMATION_MESSAGE);
			return this;
		}
		gui message(String title, String message) {
			if (this.isOnTop())
				offTop();
			JOptionPane.showMessageDialog(null, message, title,
					JOptionPane.INFORMATION_MESSAGE);
			return this;
		}
		gui message(String title, String message, String iconAddress) {
			if (this.isOnTop())
				offTop();
			JOptionPane.showMessageDialog(null, message, title,
					JOptionPane.INFORMATION_MESSAGE, new icon(iconAddress));
			return this;
		}
		gui message(String title, String message, Icon ico) {
			if (this.isOnTop())
				offTop();
			JOptionPane.showMessageDialog(null, message, title,
					JOptionPane.INFORMATION_MESSAGE, ico);
			return this;
		}
		gui error(String message) {
			if (this.isOnTop())
				offTop();
			JOptionPane.showMessageDialog(null, message, "Error",
					JOptionPane.ERROR_MESSAGE);
			return this;
		}
		gui error(String title, String message) {
			if (this.isOnTop())
				offTop();
			JOptionPane.showMessageDialog(null, message, title,
					JOptionPane.ERROR_MESSAGE);
			return this;
		}
		gui error(String title, String message, String iconAddress) {
			if (this.isOnTop())
				offTop();
			JOptionPane.showMessageDialog(null, message, title,
					JOptionPane.ERROR_MESSAGE, new icon(iconAddress));
			return this;
		}
		gui error(String title, String message, Icon ico) {
			if (this.isOnTop())
				offTop();
			JOptionPane.showMessageDialog(null, message, title,
					JOptionPane.ERROR_MESSAGE, ico);
			return this;
		}
		gui warn(String message) {
			if (this.isOnTop())
				offTop();
			JOptionPane.showMessageDialog(null, message, "Warning",
					JOptionPane.WARNING_MESSAGE);
			return this;
		}
		gui warn(String title, String message) {
			if (this.isOnTop())
				offTop();
			JOptionPane.showMessageDialog(null, message, title,
					JOptionPane.WARNING_MESSAGE);
			return this;
		}
		gui warn(String title, String message, String iconAddress) {
			if (this.isOnTop())
				offTop();
			JOptionPane.showMessageDialog(null, message, title,
					JOptionPane.WARNING_MESSAGE, new icon(iconAddress));
			return this;
		}
		gui warn(String title, String message, Icon ico) {
			if (this.isOnTop())
				offTop();
			JOptionPane.showMessageDialog(null, message, title,
					JOptionPane.WARNING_MESSAGE, ico);
			return this;
		}
		boolean confirm(String message) {
			if (this.isOnTop())
				offTop();
			return (JOptionPane.showConfirmDialog(null, message, "Confirmation",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE) == 0);
		}
		boolean confirm(String title, String message) {
			if (this.isOnTop())
				offTop();
			return (JOptionPane.showConfirmDialog(null, message, title,
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE) == 0);
		}
		boolean confirm(String title, String message, String iconAddress) {
			if (this.isOnTop())
				offTop();
			return (JOptionPane.showConfirmDialog(null, message, title,
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
					new icon(iconAddress)) == 0);
		}
		boolean confirm(String title, String message, Icon ico) {
			if (this.isOnTop())
				offTop();
			return (JOptionPane.showConfirmDialog(null, message, title,
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
					ico) == 0);
		}
		boolean confirmCancellable(String message) {
			if (this.isOnTop())
				offTop();
			return (JOptionPane.showConfirmDialog(null, message, "Confirmation",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE) == 0);
		}
		boolean confirmCancellable(String title, String message) {
			if (this.isOnTop())
				offTop();
			return (JOptionPane.showConfirmDialog(null, message, title,
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE) == 0);
		}
		boolean confirmCancellable(String title, String message,
				String iconAddress) {
			if (this.isOnTop())
				offTop();
			return (JOptionPane.showConfirmDialog(null, message, title,
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, new icon(iconAddress)) == 0);
		}
		boolean confirmCancellable(String title, String message, Icon ico) {
			if (this.isOnTop())
				offTop();
			return (JOptionPane.showConfirmDialog(null, message, title,
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, ico) == 0);
		}
		String ask(String message) {
			if (this.isOnTop())
				offTop();
			return JOptionPane.showInputDialog(null, message, "Input",
					JOptionPane.QUESTION_MESSAGE);
		}
		String ask(String title, String message) {
			if (this.isOnTop())
				offTop();
			return JOptionPane.showInputDialog(null, message, title,
					JOptionPane.QUESTION_MESSAGE);
		}
		int askInt(String message) {
			return Int(this.ask(message));
		}
		int askInt(String title, String message) {
			return Int(this.ask(title, message));
		}
		long askLong(String message) {
			return Long(this.ask(message));
		}
		long askLong(String title, String message) {
			return Long(this.ask(title, message));
		}
		float askFlt(String message) {
			return Flt(this.ask(message));
		}
		float askFlt(String title, String message) {
			return Flt(this.ask(title, message));
		}
		double askDbl(String message) {
			return Dbl(this.ask(message));
		}
		double askDbl(String title, String message) {
			return Dbl(this.ask(title, message));
		}
	}
	public static class label extends JLabel {
		private static final long serialVersionUID = 1L;
		public static int top = TOP, left = LEFT, bottom = BOTTOM,
				right = RIGHT, center = CENTER, east = EAST, west = WEST,
				north = NORTH, south = SOUTH, northeast = NORTH_EAST,
				northwest = NORTH_WEST, southeast = SOUTH_EAST,
				southwest = SOUTH_WEST, y = VERTICAL, x = HORIZONTAL;
		label() {
			super();
			super.setOpaque(true);
		}
		label(String text) {
			super(text);
			super.setOpaque(true);
		}
		label(String text, int alignment) {
			super(text, alignment);
			super.setOpaque(true);
		}
		label(Icon image) {
			super(image);
			super.setOpaque(true);
		}
		label(Icon image, int alignment) {
			super(image, alignment);
			super.setOpaque(true);
		}
		label(String text, Icon icon, int horizontalAlignment) {
			super(text, icon, horizontalAlignment);
			super.setOpaque(true);
		}
		label bg(Color clr) {
			super.setBackground(clr);
			return this;
		}
		label fg(Color clr) {
			super.setForeground(clr);
			return this;
		}
		label setBg(Color clr) {
			bg(clr);
			return this;
		}
		label setFg(Color clr) {
			fg(clr);
			return this;
		}
		label add(Component... components) {
			for (Component c : components) {
				if (c == null)
					continue;
				super.add(c);
			}
			return this;
		}
		label cursor(int c) {
			super.setCursor(new Cursor(c));
			return this;
		}
		label cursor(Cursor crsrObj) {
			super.setCursor(crsrObj);
			return this;
		}
		label font(String fontFamily, int fontSize) {
			super.setFont(new Font(fontFamily, Font.PLAIN, fontSize));
			return this;
		}
		label font(String fontFamily, int fontSize, int fontWidth) {
			super.setFont(new Font(fontFamily, fontWidth, fontSize));
			return this;
		}
		label font(String fontFamily, int fontSize, boolean bold,
				boolean italic) {
			super.setFont(new Font(fontFamily, bold && italic
					? Font.BOLD | Font.ITALIC
					: bold ? Font.BOLD : italic ? Font.ITALIC : Font.PLAIN,
					fontSize));
			return this;
		}
		label font(String fontFamily, int fontSize, boolean bold) {
			font(fontFamily, fontSize, bold, false);
			return this;
		}
		label font(String fontFamily, int fontSize, int bold, int italic) {
			super.setFont(new Font(fontFamily,
					bold == 1 && italic == 1
							? Font.BOLD | Font.ITALIC
							: bold == 1
									? Font.BOLD
									: italic == 1 ? Font.ITALIC : Font.PLAIN,
					fontSize));
			return this;
		}
		label font(Font fnt) {
			super.setFont(fnt);
			return this;
		}
		label alignx(int pos) {
			super.setHorizontalAlignment(pos);
			return this;
		}
		label aligny(int pos) {
			super.setVerticalAlignment(pos);
			return this;
		}
		String text() {
			return super.getText();
		}
		label text(String s) {
			super.setText(s);
			return this;
		}
		label on(String k, Runnable action) {
			if (KL.in(k, "\\w{3,}\\|\\w{3,}")) {
				String[] keys = k.split("\\|");
				for (var key : keys) {
					on(key, action);
				}
			}
			if (KL.is(k) && KL.is(action)) {
				super.addKeyListener(new KeyAdapter() {
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
							new Thread(action).run();
						}
					}
				});
				super.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						int button = -1;
						if (KL.eq(k, "(m(ouse)?)?\\W?click")
								|| KL.eq(k, "(m(ouse)?)?\\W?clickl")
								|| KL.eq(k, "(m(ouse)?)?\\W?lclick"))
							button = MouseEvent.BUTTON1;
						else if (KL.eq(k, "(m(ouse)?)?\\W?clickm")
								|| KL.eq(k, "(m(ouse)?)?\\W?clickw")
								|| KL.eq(k, "(m(ouse)?)?\\W?mclick")
								|| KL.eq(k, "(m(ouse)?)?\\W?wclick"))
							button = MouseEvent.BUTTON2;
						else if (KL.eq(k, "(m(ouse)?)?\\W?clickr")
								|| KL.eq(k, "(m(ouse)?)?\\W?rclick"))
							button = MouseEvent.BUTTON3;
						if (e.getButton() == button) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseReleased(MouseEvent e) {
						if (KL.eq(k, "(m(ouse)?)\\W?release")) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseEntered(MouseEvent e) {
						if (KL.eq(k, "(m(ouse)?)\\W?(enter|in)")) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseExited(MouseEvent e) {
						if (KL.eq(k, "(m(ouse)?)\\W?(leave|out)")) {
							new Thread(action).run();
						}
					}
				});
				super.addMouseMotionListener(new MouseMotionAdapter() {
					@Override
					public void mouseDragged(MouseEvent e) {
						if (KL.eq(k, "(m(ouse)?)?\\W?drag")) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseMoved(MouseEvent e) {
						if (KL.eq(k, "(m(ouse)?)\\W?move")) {
							new Thread(action).run();
						}
					}
				});
				super.addMouseWheelListener(new MouseWheelListener() {
					@Override
					public void mouseWheelMoved(MouseWheelEvent e) {
						if (KL.eq(k, "(m(ouse)?)\\W?wheel")) {
							new Thread(action).run();
						}
					}
				});
			}
			return this;
		}
		label addToolTip(String textToDisplayOnHover) {
			super.setToolTipText(textToDisplayOnHover);
			return this;
		}
		label removeToolTip() {
			super.setToolTipText(null);
			return this;
		}
		label toolTip(String textToDisplayOnHover) {
			addToolTip(textToDisplayOnHover);
			return this;
		}
		label toolTip() {
			removeToolTip();
			return this;
		}
		public String toolTipText() {
			return super.getToolTipText();
		}
	}
	public static class bordLay extends BorderLayout {
		private static final long serialVersionUID = 1L;
		bordLay() {
			super();
		}
		bordLay(int hgap, int vgap) {
			super(hgap, vgap);
		}
		public static String center = CENTER, east = EAST, right = east,
				west = WEST, left = west, north = NORTH, top = north,
				south = SOUTH, bottom = south;
	}
	public static class gridLay extends GridLayout {
		private static final long serialVersionUID = 1L;
		gridLay() {
			super();
		}
		gridLay(int rows, int columns) {
			super(rows, columns);
		}
		gridLay(int rows, int columns, int hgap, int vgap) {
			super(rows, columns, hgap, vgap);
		}
	}
	public static class gridBagLay extends GridBagLayout {
		private static final long serialVersionUID = 1L;
		gridBagLay() {
			super();
		}
	}
	public static class gridBagSettings extends GridBagConstraints {
		private static final long serialVersionUID = 1L;
		gridBagSettings() {
			super();
		}
	}
	public static class flowLay extends FlowLayout {
		private static final long serialVersionUID = 1L;
		flowLay() {
			super();
		}
		flowLay(int align) {
			super(align);
		}
		flowLay(int align, int hgap, int vgap) {
			super(align, hgap, vgap);
		}
	}
	public static class cardLay extends CardLayout {
		private static final long serialVersionUID = 1L;
		cardLay() {
			super();
		}
		cardLay(int hgap, int vgap) {
			super(hgap, vgap);
		}
	}
	public static class boxLay extends BoxLayout {
		private static final long serialVersionUID = 1L;
		boxLay(Container target, int axis) {
			super(target, axis);
		}
	}
	public static class panel extends JPanel {
		private static final long serialVersionUID = 1L;
		panel() {
			super();
		}
		panel(LayoutManager layout) {
			super(layout);
		}
		panel(boolean isDoubleBuffered) {
			super(isDoubleBuffered);
		}
		panel(LayoutManager layout, boolean isDoubleBuffered) {
			super(layout, isDoubleBuffered);
		}
		panel lay(LayoutManager layout) {
			super.setLayout(layout);
			return this;
		}
		panel setLay(LayoutManager layout) {
			lay(layout);
			return this;
		}
		panel layout(LayoutManager layout) {
			lay(layout);
			return this;
		}
		panel bg(Color clr) {
			super.setBackground(clr);
			return this;
		}
		panel fg(Color clr) {
			super.setForeground(clr);
			return this;
		}
		panel setBg(Color clr) {
			bg(clr);
			return this;
		}
		panel setFg(Color clr) {
			fg(clr);
			return this;
		}
		panel add(Component... components) {
			for (Component c : components) {
				if (c == null)
					continue;
				super.add(c);
			}
			return this;
		}
		panel cursor(int c) {
			super.setCursor(new Cursor(c));
			return this;
		}
		panel cursor(Cursor crsrObj) {
			super.setCursor(crsrObj);
			return this;
		}
		panel font(String fontFamily, int fontSize) {
			super.setFont(new Font(fontFamily, Font.PLAIN, fontSize));
			return this;
		}
		panel font(String fontFamily, int fontSize, int fontWidth) {
			super.setFont(new Font(fontFamily, fontWidth, fontSize));
			return this;
		}
		panel font(String fontFamily, int fontSize, boolean bold,
				boolean italic) {
			super.setFont(new Font(fontFamily, bold && italic
					? Font.BOLD | Font.ITALIC
					: bold ? Font.BOLD : italic ? Font.ITALIC : Font.PLAIN,
					fontSize));
			return this;
		}
		panel font(String fontFamily, int fontSize, boolean bold) {
			font(fontFamily, fontSize, bold, false);
			return this;
		}
		panel font(String fontFamily, int fontSize, int bold, int italic) {
			super.setFont(new Font(fontFamily,
					bold == 1 && italic == 1
							? Font.BOLD | Font.ITALIC
							: bold == 1
									? Font.BOLD
									: italic == 1 ? Font.ITALIC : Font.PLAIN,
					fontSize));
			return this;
		}
		panel font(Font fnt) {
			super.setFont(fnt);
			return this;
		}
		panel border(LineBorder brdr) {
			super.setBorder(brdr);
			return this;
		}
		panel on(String k, Runnable action) {
			if (KL.in(k, "\\w{3,}\\|\\w{3,}")) {
				String[] keys = k.split("\\|");
				for (var key : keys) {
					on(key, action);
				}
			}
			if (KL.is(k) && KL.is(action)) {
				super.addKeyListener(new KeyAdapter() {
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
							new Thread(action).run();
						}
					}
				});
				super.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						int button = -1;
						if (KL.eq(k, "(m(ouse)?)?\\W?click")
								|| KL.eq(k, "(m(ouse)?)?\\W?clickl")
								|| KL.eq(k, "(m(ouse)?)?\\W?lclick"))
							button = MouseEvent.BUTTON1;
						else if (KL.eq(k, "(m(ouse)?)?\\W?clickm")
								|| KL.eq(k, "(m(ouse)?)?\\W?clickw")
								|| KL.eq(k, "(m(ouse)?)?\\W?mclick")
								|| KL.eq(k, "(m(ouse)?)?\\W?wclick"))
							button = MouseEvent.BUTTON2;
						else if (KL.eq(k, "(m(ouse)?)?\\W?clickr")
								|| KL.eq(k, "(m(ouse)?)?\\W?rclick"))
							button = MouseEvent.BUTTON3;
						if (e.getButton() == button) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseReleased(MouseEvent e) {
						if (KL.eq(k, "(m(ouse)?)\\W?release")) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseEntered(MouseEvent e) {
						if (KL.eq(k, "(m(ouse)?)\\W?(enter|in)")) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseExited(MouseEvent e) {
						if (KL.eq(k, "(m(ouse)?)\\W?(leave|out)")) {
							new Thread(action).run();
						}
					}
				});
				super.addMouseMotionListener(new MouseMotionAdapter() {
					@Override
					public void mouseDragged(MouseEvent e) {
						if (KL.eq(k, "(m(ouse)?)?\\W?drag")) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseMoved(MouseEvent e) {
						if (KL.eq(k, "(m(ouse)?)\\W?move")) {
							new Thread(action).run();
						}
					}
				});
				super.addMouseWheelListener(new MouseWheelListener() {
					@Override
					public void mouseWheelMoved(MouseWheelEvent e) {
						if (KL.eq(k, "(m(ouse)?)\\W?wheel")) {
							new Thread(action).run();
						}
					}
				});
			}
			return this;
		}
		panel addToolTip(String textToDisplayOnHover) {
			super.setToolTipText(textToDisplayOnHover);
			return this;
		}
		panel removeToolTip() {
			super.setToolTipText(null);
			return this;
		}
		panel toolTip(String textToDisplayOnHover) {
			addToolTip(textToDisplayOnHover);
			return this;
		}
		panel toolTip() {
			removeToolTip();
			return this;
		}
		public String toolTipText() {
			return super.getToolTipText();
		}
	}
	public static class btn extends JButton {
		private static final long serialVersionUID = 1L;
		btn() {
			super();
			super.setFocusable(false);
		}
		btn(String text) {
			super(text);
			super.setFocusable(false);
		}
		btn(Action a) {
			super(a);
			super.setFocusable(false);
		}
		btn(Icon i) {
			super(i);
			super.setFocusable(false);
		}
		btn(String text, Icon i) {
			super(text, i);
			super.setFocusable(false);
		}
		btn(String text, ActionListener listener) {
			super(text);
			super.setFocusable(false);
			click(listener);
		}
		btn(String text, ActionListener listener, Color bg, Color fg) {
			this(text, listener);
			bg(bg);
			fg(fg);
		}
		btn click(ActionListener listener) {
			super.addActionListener(listener);
			return this;
		}
		btn offClick(ActionListener listener) {
			super.removeActionListener(listener);
			return this;
		}
		btn bg(Color clr) {
			super.setBackground(clr);
			return this;
		}
		btn fg(Color clr) {
			super.setForeground(clr);
			return this;
		}
		btn setBg(Color clr) {
			bg(clr);
			return this;
		}
		btn setFg(Color clr) {
			fg(clr);
			return this;
		}
		btn img(Icon ico) {
			super.setIcon(ico);
			return this;
		}
		btn img(String address) {
			img(new image(address));
			return this;
		}
		btn icon(Icon ico) {
			this.img(ico);
			return this;
		}
		btn icon(String address) {
			this.img(address);
			return this;
		}
		btn setImage(Icon ico) {
			this.img(ico);
			return this;
		}
		btn setImage(String address) {
			this.img(address);
			return this;
		}
		btn cursor(int c) {
			super.setCursor(new Cursor(c));
			return this;
		}
		btn cursor(Cursor crsrObj) {
			super.setCursor(crsrObj);
			return this;
		}
		btn font(String fontFamily, int fontSize) {
			super.setFont(new Font(fontFamily, Font.PLAIN, fontSize));
			return this;
		}
		btn font(String fontFamily, int fontSize, int fontWidth) {
			super.setFont(new Font(fontFamily, fontWidth, fontSize));
			return this;
		}
		btn font(String fontFamily, int fontSize, boolean bold,
				boolean italic) {
			super.setFont(new Font(fontFamily, bold && italic
					? Font.BOLD | Font.ITALIC
					: bold ? Font.BOLD : italic ? Font.ITALIC : Font.PLAIN,
					fontSize));
			return this;
		}
		btn font(String fontFamily, int fontSize, boolean bold) {
			font(fontFamily, fontSize, bold, false);
			return this;
		}
		btn font(String fontFamily, int fontSize, int bold, int italic) {
			super.setFont(new Font(fontFamily,
					bold == 1 && italic == 1
							? Font.BOLD | Font.ITALIC
							: bold == 1
									? Font.BOLD
									: italic == 1 ? Font.ITALIC : Font.PLAIN,
					fontSize));
			return this;
		}
		btn font(Font fnt) {
			super.setFont(fnt);
			return this;
		}
		btn border(LineBorder brdr) {
			super.setBorder(brdr);
			return this;
		}
		btn alignx(int pos) {
			super.setHorizontalAlignment(pos);
			return this;
		}
		btn aligny(int pos) {
			super.setVerticalAlignment(pos);
			return this;
		}
		String text() {
			return super.getText();
		}
		btn text(String s) {
			super.setText(s);
			return this;
		}
		btn on(String evt, ActionListener action) {
			if (KL.is(evt) && KL.is(action) && KL.eq(evt, "click"))
				click(action);
			return this;
		}
		btn addToolTip(String textToDisplayOnHover) {
			super.setToolTipText(textToDisplayOnHover);
			return this;
		}
		btn removeToolTip() {
			super.setToolTipText(null);
			return this;
		}
		btn toolTip(String textToDisplayOnHover) {
			addToolTip(textToDisplayOnHover);
			return this;
		}
		btn toolTip() {
			removeToolTip();
			return this;
		}
		public String toolTipText() {
			return super.getToolTipText();
		}
	}
	public static class toggleBtn extends JToggleButton {
		private static final long serialVersionUID = 1L;
		toggleBtn() {
			super();
			super.setFocusable(false);
		}
		toggleBtn(Action a) {
			super(a);
			super.setFocusable(false);
		}
		toggleBtn(String text) {
			super(text);
			super.setFocusable(false);
		}
		toggleBtn(String text, boolean selected) {
			super(text, selected);
			super.setFocusable(false);
		}
		toggleBtn(Icon i) {
			super(i);
			super.setFocusable(false);
		}
		toggleBtn(Icon i, boolean selected) {
			super(i, selected);
		}
		toggleBtn(String text, Icon i) {
			super(text, i);
			super.setFocusable(false);
		}
		toggleBtn(String text, Icon i, boolean selected) {
			super(text, i, selected);
		}
		toggleBtn(String text, ActionListener listener) {
			super(text);
			super.setFocusable(false);
			click(listener);
		}
		toggleBtn(String text, ActionListener listener, Color bg, Color fg) {
			this(text, listener);
			bg(bg);
			fg(fg);
		}
		toggleBtn click(ActionListener listener) {
			super.addActionListener(listener);
			return this;
		}
		toggleBtn offClick(ActionListener listener) {
			super.removeActionListener(listener);
			return this;
		}
		toggleBtn bg(Color clr) {
			super.setBackground(clr);
			return this;
		}
		toggleBtn fg(Color clr) {
			super.setForeground(clr);
			return this;
		}
		toggleBtn setBg(Color clr) {
			bg(clr);
			return this;
		}
		toggleBtn setFg(Color clr) {
			fg(clr);
			return this;
		}
		toggleBtn img(Icon ico) {
			super.setIcon(ico);
			return this;
		}
		toggleBtn img(String address) {
			img(new image(address));
			return this;
		}
		toggleBtn icon(Icon ico) {
			this.img(ico);
			return this;
		}
		toggleBtn icon(String address) {
			this.img(address);
			return this;
		}
		toggleBtn setImage(Icon ico) {
			this.img(ico);
			return this;
		}
		toggleBtn setImage(String address) {
			this.img(address);
			return this;
		}
		toggleBtn cursor(int c) {
			super.setCursor(new Cursor(c));
			return this;
		}
		toggleBtn cursor(Cursor crsrObj) {
			super.setCursor(crsrObj);
			return this;
		}
		toggleBtn font(String fontFamily, int fontSize) {
			super.setFont(new Font(fontFamily, Font.PLAIN, fontSize));
			return this;
		}
		toggleBtn font(String fontFamily, int fontSize, int fontWidth) {
			super.setFont(new Font(fontFamily, fontWidth, fontSize));
			return this;
		}
		toggleBtn font(String fontFamily, int fontSize, boolean bold,
				boolean italic) {
			super.setFont(new Font(fontFamily, bold && italic
					? Font.BOLD | Font.ITALIC
					: bold ? Font.BOLD : italic ? Font.ITALIC : Font.PLAIN,
					fontSize));
			return this;
		}
		toggleBtn font(String fontFamily, int fontSize, boolean bold) {
			font(fontFamily, fontSize, bold, false);
			return this;
		}
		toggleBtn font(String fontFamily, int fontSize, int bold, int italic) {
			super.setFont(new Font(fontFamily,
					bold == 1 && italic == 1
							? Font.BOLD | Font.ITALIC
							: bold == 1
									? Font.BOLD
									: italic == 1 ? Font.ITALIC : Font.PLAIN,
					fontSize));
			return this;
		}
		toggleBtn font(Font fnt) {
			super.setFont(fnt);
			return this;
		}
		toggleBtn border(LineBorder brdr) {
			super.setBorder(brdr);
			return this;
		}
		toggleBtn alignx(int pos) {
			super.setHorizontalAlignment(pos);
			return this;
		}
		toggleBtn aligny(int pos) {
			super.setVerticalAlignment(pos);
			return this;
		}
		String text() {
			return super.getText();
		}
		toggleBtn text(String s) {
			super.setText(s);
			return this;
		}
		toggleBtn on(String evt, ActionListener action) {
			if (KL.is(evt) && KL.is(action) && KL.eq(evt, "click"))
				click(action);
			return this;
		}
		toggleBtn addToolTip(String textToDisplayOnHover) {
			super.setToolTipText(textToDisplayOnHover);
			return this;
		}
		toggleBtn removeToolTip() {
			super.setToolTipText(null);
			return this;
		}
		toggleBtn toolTip(String textToDisplayOnHover) {
			addToolTip(textToDisplayOnHover);
			return this;
		}
		toggleBtn toolTip() {
			removeToolTip();
			return this;
		}
		public String toolTipText() {
			return super.getToolTipText();
		}
	}
	public static class radioBtn extends JRadioButton {
		private static final long serialVersionUID = 1L;
		radioBtn() {
			super();
			super.setFocusable(false);
		}
		radioBtn(Action a) {
			super(a);
			super.setFocusable(false);
		}
		radioBtn(String text) {
			super(text);
			super.setFocusable(false);
		}
		radioBtn(String text, boolean selected) {
			super(text, selected);
			super.setFocusable(false);
		}
		radioBtn(Icon i) {
			super(i);
			super.setFocusable(false);
		}
		radioBtn(Icon i, boolean selected) {
			super(i, selected);
		}
		radioBtn(String text, Icon i) {
			super(text, i);
			super.setFocusable(false);
		}
		radioBtn(String text, Icon i, boolean selected) {
			super(text, i, selected);
		}
		radioBtn(String text, ActionListener listener) {
			super(text);
			super.setFocusable(false);
			click(listener);
		}
		radioBtn(String text, ActionListener listener, Color bg, Color fg) {
			this(text, listener);
			bg(bg);
			fg(fg);
		}
		radioBtn click(ActionListener listener) {
			super.addActionListener(listener);
			return this;
		}
		radioBtn offClick(ActionListener listener) {
			super.removeActionListener(listener);
			return this;
		}
		radioBtn bg(Color clr) {
			super.setBackground(clr);
			return this;
		}
		radioBtn fg(Color clr) {
			super.setForeground(clr);
			return this;
		}
		radioBtn setBg(Color clr) {
			bg(clr);
			return this;
		}
		radioBtn setFg(Color clr) {
			fg(clr);
			return this;
		}
		radioBtn img(Icon ico) {
			super.setIcon(ico);
			return this;
		}
		radioBtn img(String address) {
			img(new image(address));
			return this;
		}
		radioBtn icon(Icon ico) {
			this.img(ico);
			return this;
		}
		radioBtn icon(String address) {
			this.img(address);
			return this;
		}
		radioBtn setImage(Icon ico) {
			this.img(ico);
			return this;
		}
		radioBtn setImage(String address) {
			this.img(address);
			return this;
		}
		radioBtn cursor(int c) {
			super.setCursor(new Cursor(c));
			return this;
		}
		radioBtn cursor(Cursor crsrObj) {
			super.setCursor(crsrObj);
			return this;
		}
		radioBtn font(String fontFamily, int fontSize) {
			super.setFont(new Font(fontFamily, Font.PLAIN, fontSize));
			return this;
		}
		radioBtn font(String fontFamily, int fontSize, int fontWidth) {
			super.setFont(new Font(fontFamily, fontWidth, fontSize));
			return this;
		}
		radioBtn font(String fontFamily, int fontSize, boolean bold,
				boolean italic) {
			super.setFont(new Font(fontFamily, bold && italic
					? Font.BOLD | Font.ITALIC
					: bold ? Font.BOLD : italic ? Font.ITALIC : Font.PLAIN,
					fontSize));
			return this;
		}
		radioBtn font(String fontFamily, int fontSize, boolean bold) {
			font(fontFamily, fontSize, bold, false);
			return this;
		}
		radioBtn font(String fontFamily, int fontSize, int bold, int italic) {
			super.setFont(new Font(fontFamily,
					bold == 1 && italic == 1
							? Font.BOLD | Font.ITALIC
							: bold == 1
									? Font.BOLD
									: italic == 1 ? Font.ITALIC : Font.PLAIN,
					fontSize));
			return this;
		}
		radioBtn font(Font fnt) {
			super.setFont(fnt);
			return this;
		}
		radioBtn border(LineBorder brdr) {
			super.setBorder(brdr);
			return this;
		}
		radioBtn alignx(int pos) {
			super.setHorizontalAlignment(pos);
			return this;
		}
		radioBtn aligny(int pos) {
			super.setVerticalAlignment(pos);
			return this;
		}
		String text() {
			return super.getText();
		}
		radioBtn text(String s) {
			super.setText(s);
			return this;
		}
		radioBtn on(String evt, ActionListener action) {
			if (KL.is(evt) && KL.is(action) && KL.eq(evt, "click"))
				click(action);
			return this;
		}
		radioBtn addToolTip(String textToDisplayOnHover) {
			super.setToolTipText(textToDisplayOnHover);
			return this;
		}
		radioBtn removeToolTip() {
			super.setToolTipText(null);
			return this;
		}
		radioBtn toolTip(String textToDisplayOnHover) {
			addToolTip(textToDisplayOnHover);
			return this;
		}
		radioBtn toolTip() {
			removeToolTip();
			return this;
		}
		public String toolTipText() {
			return super.getToolTipText();
		}
	}
	public static class radioBtnItem extends JRadioButtonMenuItem {
		private static final long serialVersionUID = 1L;
		radioBtnItem() {
			super();
			super.setFocusable(false);
		}
		radioBtnItem(Action a) {
			super(a);
			super.setFocusable(false);
		}
		radioBtnItem(String text) {
			super(text);
			super.setFocusable(false);
		}
		radioBtnItem(String text, boolean selected) {
			super(text, selected);
			super.setFocusable(false);
		}
		radioBtnItem(Icon i) {
			super(i);
			super.setFocusable(false);
		}
		radioBtnItem(Icon i, boolean selected) {
			super(i, selected);
		}
		radioBtnItem(String text, Icon i) {
			super(text, i);
			super.setFocusable(false);
		}
		radioBtnItem(String text, Icon i, boolean selected) {
			super(text, i, selected);
		}
		radioBtnItem(String text, ActionListener listener) {
			super(text);
			super.setFocusable(false);
			click(listener);
		}
		radioBtnItem(String text, ActionListener listener, Color bg, Color fg) {
			this(text, listener);
			bg(bg);
			fg(fg);
		}
		radioBtnItem click(ActionListener listener) {
			super.addActionListener(listener);
			return this;
		}
		radioBtnItem offClick(ActionListener listener) {
			super.removeActionListener(listener);
			return this;
		}
		radioBtnItem bg(Color clr) {
			super.setBackground(clr);
			return this;
		}
		radioBtnItem fg(Color clr) {
			super.setForeground(clr);
			return this;
		}
		radioBtnItem setBg(Color clr) {
			bg(clr);
			return this;
		}
		radioBtnItem setFg(Color clr) {
			fg(clr);
			return this;
		}
		radioBtnItem img(Icon ico) {
			super.setIcon(ico);
			return this;
		}
		radioBtnItem img(String address) {
			img(new image(address));
			return this;
		}
		radioBtnItem icon(Icon ico) {
			this.img(ico);
			return this;
		}
		radioBtnItem icon(String address) {
			this.img(address);
			return this;
		}
		radioBtnItem setImage(Icon ico) {
			this.img(ico);
			return this;
		}
		radioBtnItem setImage(String address) {
			this.img(address);
			return this;
		}
		radioBtnItem cursor(int c) {
			super.setCursor(new Cursor(c));
			return this;
		}
		radioBtnItem cursor(Cursor crsrObj) {
			super.setCursor(crsrObj);
			return this;
		}
		radioBtnItem font(String fontFamily, int fontSize) {
			super.setFont(new Font(fontFamily, Font.PLAIN, fontSize));
			return this;
		}
		radioBtnItem font(String fontFamily, int fontSize, int fontWidth) {
			super.setFont(new Font(fontFamily, fontWidth, fontSize));
			return this;
		}
		radioBtnItem font(String fontFamily, int fontSize, boolean bold,
				boolean italic) {
			super.setFont(new Font(fontFamily, bold && italic
					? Font.BOLD | Font.ITALIC
					: bold ? Font.BOLD : italic ? Font.ITALIC : Font.PLAIN,
					fontSize));
			return this;
		}
		radioBtnItem font(String fontFamily, int fontSize, boolean bold) {
			font(fontFamily, fontSize, bold, false);
			return this;
		}
		radioBtnItem font(String fontFamily, int fontSize, int bold,
				int italic) {
			super.setFont(new Font(fontFamily,
					bold == 1 && italic == 1
							? Font.BOLD | Font.ITALIC
							: bold == 1
									? Font.BOLD
									: italic == 1 ? Font.ITALIC : Font.PLAIN,
					fontSize));
			return this;
		}
		radioBtnItem font(Font fnt) {
			super.setFont(fnt);
			return this;
		}
		radioBtnItem border(LineBorder brdr) {
			super.setBorder(brdr);
			return this;
		}
		radioBtnItem alignx(int pos) {
			super.setHorizontalAlignment(pos);
			return this;
		}
		radioBtnItem aligny(int pos) {
			super.setVerticalAlignment(pos);
			return this;
		}
		String text() {
			return super.getText();
		}
		radioBtnItem text(String s) {
			super.setText(s);
			return this;
		}
		radioBtnItem on(String evt, ActionListener action) {
			if (KL.is(evt) && KL.is(action) && KL.eq(evt, "click"))
				click(action);
			return this;
		}
		radioBtnItem addToolTip(String textToDisplayOnHover) {
			super.setToolTipText(textToDisplayOnHover);
			return this;
		}
		radioBtnItem removeToolTip() {
			super.setToolTipText(null);
			return this;
		}
		radioBtnItem toolTip(String textToDisplayOnHover) {
			addToolTip(textToDisplayOnHover);
			return this;
		}
		radioBtnItem toolTip() {
			removeToolTip();
			return this;
		}
		public String toolTipText() {
			return super.getToolTipText();
		}
	}
	public static class checkBox extends JCheckBox {
		private static final long serialVersionUID = 1L;
		checkBox() {
			super();
			super.setFocusable(false);
		}
		checkBox(Action a) {
			super(a);
			super.setFocusable(false);
		}
		checkBox(String text) {
			super(text);
			super.setFocusable(false);
		}
		checkBox(String text, boolean selected) {
			super(text, selected);
			super.setFocusable(false);
		}
		checkBox(Icon i) {
			super(i);
			super.setFocusable(false);
		}
		checkBox(Icon i, boolean selected) {
			super(i, selected);
		}
		checkBox(String text, Icon i) {
			super(text, i);
			super.setFocusable(false);
		}
		checkBox(String text, Icon i, boolean selected) {
			super(text, i, selected);
		}
		checkBox(String text, ActionListener listener) {
			super(text);
			super.setFocusable(false);
			click(listener);
		}
		checkBox(String text, ActionListener listener, Color bg, Color fg) {
			this(text, listener);
			bg(bg);
			fg(fg);
		}
		checkBox click(ActionListener listener) {
			super.addActionListener(listener);
			return this;
		}
		checkBox offClick(ActionListener listener) {
			super.removeActionListener(listener);
			return this;
		}
		checkBox bg(Color clr) {
			super.setBackground(clr);
			return this;
		}
		checkBox fg(Color clr) {
			super.setForeground(clr);
			return this;
		}
		checkBox setBg(Color clr) {
			bg(clr);
			return this;
		}
		checkBox setFg(Color clr) {
			fg(clr);
			return this;
		}
		checkBox img(Icon ico) {
			super.setIcon(ico);
			return this;
		}
		checkBox img(String address) {
			img(new image(address));
			return this;
		}
		checkBox icon(Icon ico) {
			this.img(ico);
			return this;
		}
		checkBox icon(String address) {
			this.img(address);
			return this;
		}
		checkBox setImage(Icon ico) {
			this.img(ico);
			return this;
		}
		checkBox setImage(String address) {
			this.img(address);
			return this;
		}
		checkBox cursor(int c) {
			super.setCursor(new Cursor(c));
			return this;
		}
		checkBox cursor(Cursor crsrObj) {
			super.setCursor(crsrObj);
			return this;
		}
		checkBox font(String fontFamily, int fontSize) {
			super.setFont(new Font(fontFamily, Font.PLAIN, fontSize));
			return this;
		}
		checkBox font(String fontFamily, int fontSize, int fontWidth) {
			super.setFont(new Font(fontFamily, fontWidth, fontSize));
			return this;
		}
		checkBox font(String fontFamily, int fontSize, boolean bold,
				boolean italic) {
			super.setFont(new Font(fontFamily, bold && italic
					? Font.BOLD | Font.ITALIC
					: bold ? Font.BOLD : italic ? Font.ITALIC : Font.PLAIN,
					fontSize));
			return this;
		}
		checkBox font(String fontFamily, int fontSize, boolean bold) {
			font(fontFamily, fontSize, bold, false);
			return this;
		}
		checkBox font(String fontFamily, int fontSize, int bold, int italic) {
			super.setFont(new Font(fontFamily,
					bold == 1 && italic == 1
							? Font.BOLD | Font.ITALIC
							: bold == 1
									? Font.BOLD
									: italic == 1 ? Font.ITALIC : Font.PLAIN,
					fontSize));
			return this;
		}
		checkBox font(Font fnt) {
			super.setFont(fnt);
			return this;
		}
		checkBox border(LineBorder brdr) {
			super.setBorder(brdr);
			return this;
		}
		checkBox alignx(int pos) {
			super.setHorizontalAlignment(pos);
			return this;
		}
		checkBox aligny(int pos) {
			super.setVerticalAlignment(pos);
			return this;
		}
		String text() {
			return super.getText();
		}
		checkBox text(String s) {
			super.setText(s);
			return this;
		}
		checkBox on(String evt, ActionListener action) {
			if (KL.is(evt) && KL.is(action) && KL.eq(evt, "click"))
				click(action);
			return this;
		}
		checkBox addToolTip(String textToDisplayOnHover) {
			super.setToolTipText(textToDisplayOnHover);
			return this;
		}
		checkBox removeToolTip() {
			super.setToolTipText(null);
			return this;
		}
		checkBox toolTip(String textToDisplayOnHover) {
			addToolTip(textToDisplayOnHover);
			return this;
		}
		checkBox toolTip() {
			removeToolTip();
			return this;
		}
		public String toolTipText() {
			return super.getToolTipText();
		}
	}
	public static class checkBoxItem extends JCheckBoxMenuItem {
		private static final long serialVersionUID = 1L;
		checkBoxItem() {
			super();
			super.setFocusable(false);
		}
		checkBoxItem(Action a) {
			super(a);
			super.setFocusable(false);
		}
		checkBoxItem(String text) {
			super(text);
			super.setFocusable(false);
		}
		checkBoxItem(String text, boolean selected) {
			super(text, selected);
			super.setFocusable(false);
		}
		checkBoxItem(Icon i) {
			super(i);
			super.setFocusable(false);
		}
		checkBoxItem(String text, Icon i) {
			super(text, i);
			super.setFocusable(false);
		}
		checkBoxItem(String text, Icon i, boolean selected) {
			super(text, i, selected);
		}
		checkBoxItem(String text, ActionListener listener) {
			super(text);
			super.setFocusable(false);
			click(listener);
		}
		checkBoxItem(String text, ActionListener listener, Color bg, Color fg) {
			this(text, listener);
			bg(bg);
			fg(fg);
		}
		checkBoxItem click(ActionListener listener) {
			super.addActionListener(listener);
			return this;
		}
		checkBoxItem offClick(ActionListener listener) {
			super.removeActionListener(listener);
			return this;
		}
		checkBoxItem bg(Color clr) {
			super.setBackground(clr);
			return this;
		}
		checkBoxItem fg(Color clr) {
			super.setForeground(clr);
			return this;
		}
		checkBoxItem setBg(Color clr) {
			bg(clr);
			return this;
		}
		checkBoxItem setFg(Color clr) {
			fg(clr);
			return this;
		}
		checkBoxItem img(Icon ico) {
			super.setIcon(ico);
			return this;
		}
		checkBoxItem img(String address) {
			img(new image(address));
			return this;
		}
		checkBoxItem icon(Icon ico) {
			this.img(ico);
			return this;
		}
		checkBoxItem icon(String address) {
			this.img(address);
			return this;
		}
		checkBoxItem setImage(Icon ico) {
			this.img(ico);
			return this;
		}
		checkBoxItem setImage(String address) {
			this.img(address);
			return this;
		}
		checkBoxItem cursor(int c) {
			super.setCursor(new Cursor(c));
			return this;
		}
		checkBoxItem cursor(Cursor crsrObj) {
			super.setCursor(crsrObj);
			return this;
		}
		checkBoxItem font(String fontFamily, int fontSize) {
			super.setFont(new Font(fontFamily, Font.PLAIN, fontSize));
			return this;
		}
		checkBoxItem font(String fontFamily, int fontSize, int fontWidth) {
			super.setFont(new Font(fontFamily, fontWidth, fontSize));
			return this;
		}
		checkBoxItem font(String fontFamily, int fontSize, boolean bold,
				boolean italic) {
			super.setFont(new Font(fontFamily, bold && italic
					? Font.BOLD | Font.ITALIC
					: bold ? Font.BOLD : italic ? Font.ITALIC : Font.PLAIN,
					fontSize));
			return this;
		}
		checkBoxItem font(String fontFamily, int fontSize, boolean bold) {
			font(fontFamily, fontSize, bold, false);
			return this;
		}
		checkBoxItem font(String fontFamily, int fontSize, int bold,
				int italic) {
			super.setFont(new Font(fontFamily,
					bold == 1 && italic == 1
							? Font.BOLD | Font.ITALIC
							: bold == 1
									? Font.BOLD
									: italic == 1 ? Font.ITALIC : Font.PLAIN,
					fontSize));
			return this;
		}
		checkBoxItem font(Font fnt) {
			super.setFont(fnt);
			return this;
		}
		checkBoxItem border(LineBorder brdr) {
			super.setBorder(brdr);
			return this;
		}
		checkBoxItem alignx(int pos) {
			super.setHorizontalAlignment(pos);
			return this;
		}
		checkBoxItem aligny(int pos) {
			super.setVerticalAlignment(pos);
			return this;
		}
		String text() {
			return super.getText();
		}
		checkBoxItem text(String s) {
			super.setText(s);
			return this;
		}
		checkBoxItem on(String evt, ActionListener action) {
			if (KL.is(evt) && KL.is(action) && KL.eq(evt, "click"))
				click(action);
			return this;
		}
		checkBoxItem addToolTip(String textToDisplayOnHover) {
			super.setToolTipText(textToDisplayOnHover);
			return this;
		}
		checkBoxItem removeToolTip() {
			super.setToolTipText(null);
			return this;
		}
		checkBoxItem toolTip(String textToDisplayOnHover) {
			addToolTip(textToDisplayOnHover);
			return this;
		}
		checkBoxItem toolTip() {
			removeToolTip();
			return this;
		}
		public String toolTipText() {
			return super.getToolTipText();
		}
	}
	public static class menuBar extends JMenuBar {
		private static final long serialVersionUID = 1L;
		menuBar() {
			super();
			super.setFocusable(false);
		}
		menuBar(JMenu... menus) {
			this();
			if (menus == null)
				return;
			for (JMenu item : menus) {
				if (item == null)
					continue;
				super.add(item);
			}
		}
		menuBar bg(Color clr) {
			super.setBackground(clr);
			return this;
		}
		menuBar fg(Color clr) {
			super.setForeground(clr);
			return this;
		}
		menuBar setBg(Color clr) {
			bg(clr);
			return this;
		}
		menuBar setFg(Color clr) {
			fg(clr);
			return this;
		}
		menuBar cursor(int c) {
			super.setCursor(new Cursor(c));
			return this;
		}
		menuBar cursor(Cursor crsrObj) {
			super.setCursor(crsrObj);
			return this;
		}
		menuBar font(String fontFamily, int fontSize) {
			super.setFont(new Font(fontFamily, Font.PLAIN, fontSize));
			return this;
		}
		menuBar font(String fontFamily, int fontSize, int fontWidth) {
			super.setFont(new Font(fontFamily, fontWidth, fontSize));
			return this;
		}
		menuBar font(String fontFamily, int fontSize, boolean bold,
				boolean italic) {
			super.setFont(new Font(fontFamily, bold && italic
					? Font.BOLD | Font.ITALIC
					: bold ? Font.BOLD : italic ? Font.ITALIC : Font.PLAIN,
					fontSize));
			return this;
		}
		menuBar font(String fontFamily, int fontSize, boolean bold) {
			font(fontFamily, fontSize, bold, false);
			return this;
		}
		menuBar font(String fontFamily, int fontSize, int bold, int italic) {
			super.setFont(new Font(fontFamily,
					bold == 1 && italic == 1
							? Font.BOLD | Font.ITALIC
							: bold == 1
									? Font.BOLD
									: italic == 1 ? Font.ITALIC : Font.PLAIN,
					fontSize));
			return this;
		}
		menuBar font(Font fnt) {
			super.setFont(fnt);
			return this;
		}
		menuBar border(LineBorder brdr) {
			super.setBorder(brdr);
			return this;
		}
		menuBar addToolTip(String textToDisplayOnHover) {
			super.setToolTipText(textToDisplayOnHover);
			return this;
		}
		menuBar removeToolTip() {
			super.setToolTipText(null);
			return this;
		}
		menuBar toolTip(String textToDisplayOnHover) {
			addToolTip(textToDisplayOnHover);
			return this;
		}
		menuBar toolTip() {
			removeToolTip();
			return this;
		}
		public String toolTipText() {
			return super.getToolTipText();
		}
	}
	public static class menu extends JMenu {
		private static final long serialVersionUID = 1L;
		menu() {
			super();
			super.setFocusable(false);
		}
		menu(Action a) {
			super(a);
			super.setFocusable(false);
		}
		menu(String text) {
			super(text);
			super.setFocusable(false);
		}
		menu(String text, boolean canBeTornOff) {
			super(text, canBeTornOff);
			super.setFocusable(false);
		}
		menu(String text, ActionListener listener) {
			super(text);
			super.setFocusable(false);
			click(listener);
		}
		menu(String text, ActionListener listener, Color bg, Color fg) {
			this(text, listener);
			bg(bg);
			fg(fg);
		}
		menu(JMenuItem... menuItems) {
			super();
			if (menuItems == null)
				return;
			for (JMenuItem item : menuItems) {
				if (item == null)
					continue;
				super.add(item);
			}
		}
		menu click(ActionListener listener) {
			super.addActionListener(listener);
			return this;
		}
		menu offClick(ActionListener listener) {
			super.removeActionListener(listener);
			return this;
		}
		menu bg(Color clr) {
			super.setBackground(clr);
			return this;
		}
		menu fg(Color clr) {
			super.setForeground(clr);
			return this;
		}
		menu setBg(Color clr) {
			bg(clr);
			return this;
		}
		menu setFg(Color clr) {
			fg(clr);
			return this;
		}
		menu img(Icon ico) {
			super.setIcon(ico);
			return this;
		}
		menu img(String address) {
			img(new image(address));
			return this;
		}
		menu icon(Icon ico) {
			this.img(ico);
			return this;
		}
		menu icon(String address) {
			this.img(address);
			return this;
		}
		menu setImage(Icon ico) {
			this.img(ico);
			return this;
		}
		menu setImage(String address) {
			this.img(address);
			return this;
		}
		menu cursor(int c) {
			super.setCursor(new Cursor(c));
			return this;
		}
		menu cursor(Cursor crsrObj) {
			super.setCursor(crsrObj);
			return this;
		}
		menu font(String fontFamily, int fontSize) {
			super.setFont(new Font(fontFamily, Font.PLAIN, fontSize));
			return this;
		}
		menu font(String fontFamily, int fontSize, int fontWidth) {
			super.setFont(new Font(fontFamily, fontWidth, fontSize));
			return this;
		}
		menu font(String fontFamily, int fontSize, boolean bold,
				boolean italic) {
			super.setFont(new Font(fontFamily, bold && italic
					? Font.BOLD | Font.ITALIC
					: bold ? Font.BOLD : italic ? Font.ITALIC : Font.PLAIN,
					fontSize));
			return this;
		}
		menu font(String fontFamily, int fontSize, boolean bold) {
			font(fontFamily, fontSize, bold, false);
			return this;
		}
		menu font(String fontFamily, int fontSize, int bold, int italic) {
			super.setFont(new Font(fontFamily,
					bold == 1 && italic == 1
							? Font.BOLD | Font.ITALIC
							: bold == 1
									? Font.BOLD
									: italic == 1 ? Font.ITALIC : Font.PLAIN,
					fontSize));
			return this;
		}
		menu font(Font fnt) {
			super.setFont(fnt);
			return this;
		}
		menu border(LineBorder brdr) {
			super.setBorder(brdr);
			return this;
		}
		menu alignx(int pos) {
			super.setHorizontalAlignment(pos);
			return this;
		}
		menu aligny(int pos) {
			super.setVerticalAlignment(pos);
			return this;
		}
		String text() {
			return super.getText();
		}
		menu text(String s) {
			super.setText(s);
			return this;
		}
		menu on(String evt, ActionListener action) {
			if (KL.is(evt) && KL.is(action) && KL.eq(evt, "click"))
				click(action);
			return this;
		}
		menu addToolTip(String textToDisplayOnHover) {
			super.setToolTipText(textToDisplayOnHover);
			return this;
		}
		menu removeToolTip() {
			super.setToolTipText(null);
			return this;
		}
		menu toolTip(String textToDisplayOnHover) {
			addToolTip(textToDisplayOnHover);
			return this;
		}
		menu toolTip() {
			removeToolTip();
			return this;
		}
		public String toolTipText() {
			return super.getToolTipText();
		}
	}
	public static class menuItem extends JMenuItem {
		private static final long serialVersionUID = 1L;
		menuItem() {
			super();
			super.setFocusable(false);
		}
		menuItem(Action a) {
			super(a);
			super.setFocusable(false);
		}
		menuItem(String text) {
			super(text);
			super.setFocusable(false);
		}
		menuItem(String text, int mnemonic) {
			super(text, mnemonic);
			super.setFocusable(false);
		}
		menuItem(Icon i) {
			super(i);
			super.setFocusable(false);
		}
		menuItem(String text, Icon i) {
			super(text, i);
			super.setFocusable(false);
		}
		menuItem(String text, ActionListener listener) {
			super(text);
			super.setFocusable(false);
			click(listener);
		}
		menuItem(String text, ActionListener listener, Color bg, Color fg) {
			this(text, listener);
			bg(bg);
			fg(fg);
		}
		menuItem click(ActionListener listener) {
			super.addActionListener(listener);
			return this;
		}
		menuItem offClick(ActionListener listener) {
			super.removeActionListener(listener);
			return this;
		}
		menuItem bg(Color clr) {
			super.setBackground(clr);
			return this;
		}
		menuItem fg(Color clr) {
			super.setForeground(clr);
			return this;
		}
		menuItem setBg(Color clr) {
			bg(clr);
			return this;
		}
		menuItem setFg(Color clr) {
			fg(clr);
			return this;
		}
		menuItem img(Icon ico) {
			super.setIcon(ico);
			return this;
		}
		menuItem img(String address) {
			img(new image(address));
			return this;
		}
		menuItem icon(Icon ico) {
			this.img(ico);
			return this;
		}
		menuItem icon(String address) {
			this.img(address);
			return this;
		}
		menuItem setImage(Icon ico) {
			this.img(ico);
			return this;
		}
		menuItem setImage(String address) {
			this.img(address);
			return this;
		}
		menuItem cursor(int c) {
			super.setCursor(new Cursor(c));
			return this;
		}
		menuItem cursor(Cursor crsrObj) {
			super.setCursor(crsrObj);
			return this;
		}
		menuItem font(String fontFamily, int fontSize) {
			super.setFont(new Font(fontFamily, Font.PLAIN, fontSize));
			return this;
		}
		menuItem font(String fontFamily, int fontSize, int fontWidth) {
			super.setFont(new Font(fontFamily, fontWidth, fontSize));
			return this;
		}
		menuItem font(String fontFamily, int fontSize, boolean bold,
				boolean italic) {
			super.setFont(new Font(fontFamily, bold && italic
					? Font.BOLD | Font.ITALIC
					: bold ? Font.BOLD : italic ? Font.ITALIC : Font.PLAIN,
					fontSize));
			return this;
		}
		menuItem font(String fontFamily, int fontSize, boolean bold) {
			font(fontFamily, fontSize, bold, false);
			return this;
		}
		menuItem font(String fontFamily, int fontSize, int bold, int italic) {
			super.setFont(new Font(fontFamily,
					bold == 1 && italic == 1
							? Font.BOLD | Font.ITALIC
							: bold == 1
									? Font.BOLD
									: italic == 1 ? Font.ITALIC : Font.PLAIN,
					fontSize));
			return this;
		}
		menuItem font(Font fnt) {
			super.setFont(fnt);
			return this;
		}
		menuItem border(LineBorder brdr) {
			super.setBorder(brdr);
			return this;
		}
		menuItem alignx(int pos) {
			super.setHorizontalAlignment(pos);
			return this;
		}
		menuItem aligny(int pos) {
			super.setVerticalAlignment(pos);
			return this;
		}
		String text() {
			return super.getText();
		}
		menuItem text(String s) {
			super.setText(s);
			return this;
		}
		menuItem on(String evt, ActionListener action) {
			if (KL.is(evt) && KL.is(action) && KL.eq(evt, "click"))
				click(action);
			return this;
		}
		menuItem addToolTip(String textToDisplayOnHover) {
			super.setToolTipText(textToDisplayOnHover);
			return this;
		}
		menuItem removeToolTip() {
			super.setToolTipText(null);
			return this;
		}
		menuItem toolTip(String textToDisplayOnHover) {
			addToolTip(textToDisplayOnHover);
			return this;
		}
		menuItem toolTip() {
			removeToolTip();
			return this;
		}
		public String toolTipText() {
			return super.getToolTipText();
		}
	}
	public static class contextMenu extends JPopupMenu {
		private static final long serialVersionUID = 1L;
		contextMenu() {
			super();
			super.setFocusable(false);
		}
		contextMenu(String text) {
			super(text);
			super.setFocusable(false);
		}
		contextMenu(String text, Color bg) {
			this(text);
			bg(bg);
		}
		contextMenu(String... items) {
			super();
			if (items == null)
				return;
			for (String item : items) {
				if (item == null)
					continue;
				super.add(item);
			}
		}
		contextMenu bg(Color clr) {
			super.setBackground(clr);
			return this;
		}
		contextMenu fg(Color clr) {
			super.setForeground(clr);
			return this;
		}
		contextMenu setBg(Color clr) {
			bg(clr);
			return this;
		}
		contextMenu setFg(Color clr) {
			fg(clr);
			return this;
		}
		contextMenu cursor(int c) {
			super.setCursor(new Cursor(c));
			return this;
		}
		contextMenu cursor(Cursor crsrObj) {
			super.setCursor(crsrObj);
			return this;
		}
		contextMenu font(String fontFamily, int fontSize) {
			super.setFont(new Font(fontFamily, Font.PLAIN, fontSize));
			return this;
		}
		contextMenu font(String fontFamily, int fontSize, int fontWidth) {
			super.setFont(new Font(fontFamily, fontWidth, fontSize));
			return this;
		}
		contextMenu font(String fontFamily, int fontSize, boolean bold,
				boolean italic) {
			super.setFont(new Font(fontFamily, bold && italic
					? Font.BOLD | Font.ITALIC
					: bold ? Font.BOLD : italic ? Font.ITALIC : Font.PLAIN,
					fontSize));
			return this;
		}
		contextMenu font(String fontFamily, int fontSize, boolean bold) {
			font(fontFamily, fontSize, bold, false);
			return this;
		}
		contextMenu font(String fontFamily, int fontSize, int bold,
				int italic) {
			super.setFont(new Font(fontFamily,
					bold == 1 && italic == 1
							? Font.BOLD | Font.ITALIC
							: bold == 1
									? Font.BOLD
									: italic == 1 ? Font.ITALIC : Font.PLAIN,
					fontSize));
			return this;
		}
		contextMenu font(Font fnt) {
			super.setFont(fnt);
			return this;
		}
		contextMenu border(LineBorder brdr) {
			super.setBorder(brdr);
			return this;
		}
		contextMenu addToolTip(String textToDisplayOnHover) {
			super.setToolTipText(textToDisplayOnHover);
			return this;
		}
		contextMenu removeToolTip() {
			super.setToolTipText(null);
			return this;
		}
		contextMenu toolTip(String textToDisplayOnHover) {
			addToolTip(textToDisplayOnHover);
			return this;
		}
		contextMenu toolTip() {
			removeToolTip();
			return this;
		}
		public String toolTipText() {
			return super.getToolTipText();
		}
	}
	public static class dropDown extends JComboBox {
		private static final long serialVersionUID = 1L;
		int size = 0;
		dropDown() {
			super();
			super.setFocusable(false);
		}
		<T> dropDown(T... items) {
			super(items);
			size = items.length;
		}
		<T> dropDown(Vector<T> itemsOfTypeVector) {
			super(itemsOfTypeVector);
			size = itemsOfTypeVector.size();
		}
		<T> dropDown(ComboBoxModel<T> model) {
			super(model);
			size = model.getSize();
		}
		dropDown add(int i) {
			if (i < 0 || i >= size)
				return this;
			super.setSelectedIndex(i);
			return this;
		}
		dropDown select(int i) {
			if (i < 0 || i >= size)
				return this;
			super.setSelectedIndex(i);
			return this;
		}
		dropDown bg(Color clr) {
			super.setBackground(clr);
			return this;
		}
		dropDown fg(Color clr) {
			super.setForeground(clr);
			return this;
		}
		dropDown setBg(Color clr) {
			bg(clr);
			return this;
		}
		dropDown setFg(Color clr) {
			fg(clr);
			return this;
		}
		dropDown cursor(int c) {
			super.setCursor(new Cursor(c));
			return this;
		}
		dropDown cursor(Cursor crsrObj) {
			super.setCursor(crsrObj);
			return this;
		}
		dropDown font(String fontFamily, int fontSize) {
			super.setFont(new Font(fontFamily, Font.PLAIN, fontSize));
			return this;
		}
		dropDown font(String fontFamily, int fontSize, int fontWidth) {
			super.setFont(new Font(fontFamily, fontWidth, fontSize));
			return this;
		}
		dropDown font(String fontFamily, int fontSize, boolean bold,
				boolean italic) {
			super.setFont(new Font(fontFamily, bold && italic
					? Font.BOLD | Font.ITALIC
					: bold ? Font.BOLD : italic ? Font.ITALIC : Font.PLAIN,
					fontSize));
			return this;
		}
		dropDown font(String fontFamily, int fontSize, boolean bold) {
			font(fontFamily, fontSize, bold, false);
			return this;
		}
		dropDown font(String fontFamily, int fontSize, int bold, int italic) {
			super.setFont(new Font(fontFamily,
					bold == 1 && italic == 1
							? Font.BOLD | Font.ITALIC
							: bold == 1
									? Font.BOLD
									: italic == 1 ? Font.ITALIC : Font.PLAIN,
					fontSize));
			return this;
		}
		dropDown font(Font fnt) {
			super.setFont(fnt);
			return this;
		}
		dropDown border(LineBorder brdr) {
			super.setBorder(brdr);
			return this;
		}
		dropDown addToolTip(String textToDisplayOnHover) {
			super.setToolTipText(textToDisplayOnHover);
			return this;
		}
		dropDown removeToolTip() {
			super.setToolTipText(null);
			return this;
		}
		dropDown toolTip(String textToDisplayOnHover) {
			addToolTip(textToDisplayOnHover);
			return this;
		}
		dropDown toolTip() {
			removeToolTip();
			return this;
		}
		public String toolTipText() {
			return super.getToolTipText();
		}
	}

	public static class txtField extends JTextField {
		private static final long serialVersionUID = 1L;
		txtField() {
			super();
		}
		txtField(String text) {
			super(text);
		}
		txtField(int columns) {
			super(columns);
		}
		txtField(String text, int columns) {
			super(text, columns);
		}
		txtField(Document doc, String text, int columns) {
			super(doc, text, columns);
		}
		txtField cursor(int c) {
			super.setCursor(new Cursor(c));
			return this;
		}
		txtField cursor(Cursor crsrObj) {
			super.setCursor(crsrObj);
			return this;
		}
		txtField border(LineBorder brdr) {
			super.setBorder(brdr);
			return this;
		}
		String text() {
			return super.getText();
		}
		txtField text(String s) {
			super.setText(s);
			return this;
		}
		String val() {
			return text();
		}
		txtField val(String s) {
			text(s);
			return this;
		}
		String value() {
			return text();
		}
		txtField value(String s) {
			text(s);
			return this;
		}
		txtField on(String k, Runnable action) {
			if (KL.in(k, "\\w{3,}\\|\\w{3,}")) {
				String[] keys = k.split("\\|");
				for (var key : keys) {
					on(key, action);
				}
			}
			if (KL.is(k) && KL.is(action)) {
				super.addKeyListener(new KeyAdapter() {
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
							new Thread(action).run();
						}
					}
				});
				super.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						int button = -1;
						if (KL.eq(k, "(m(ouse)?)?\\W?click")
								|| KL.eq(k, "(m(ouse)?)?\\W?clickl")
								|| KL.eq(k, "(m(ouse)?)?\\W?lclick"))
							button = MouseEvent.BUTTON1;
						else if (KL.eq(k, "(m(ouse)?)?\\W?clickm")
								|| KL.eq(k, "(m(ouse)?)?\\W?clickw")
								|| KL.eq(k, "(m(ouse)?)?\\W?mclick")
								|| KL.eq(k, "(m(ouse)?)?\\W?wclick"))
							button = MouseEvent.BUTTON2;
						else if (KL.eq(k, "(m(ouse)?)?\\W?clickr")
								|| KL.eq(k, "(m(ouse)?)?\\W?rclick"))
							button = MouseEvent.BUTTON3;
						if (e.getButton() == button) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseReleased(MouseEvent e) {
						if (KL.eq(k, "(m(ouse)?)\\W?release")) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseEntered(MouseEvent e) {
						if (KL.eq(k, "(m(ouse)?)\\W?(enter|in)")) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseExited(MouseEvent e) {
						if (KL.eq(k, "(m(ouse)?)\\W?(leave|out)")) {
							new Thread(action).run();
						}
					}
				});
				super.addMouseMotionListener(new MouseMotionAdapter() {
					@Override
					public void mouseDragged(MouseEvent e) {
						if (KL.eq(k, "(m(ouse)?)?\\W?drag")) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseMoved(MouseEvent e) {
						if (KL.eq(k, "(m(ouse)?)\\W?move")) {
							new Thread(action).run();
						}
					}
				});
				super.addMouseWheelListener(new MouseWheelListener() {
					@Override
					public void mouseWheelMoved(MouseWheelEvent e) {
						if (KL.eq(k, "(m(ouse)?)\\W?wheel")) {
							new Thread(action).run();
						}
					}
				});
			}
			return this;
		}
		txtField addToolTip(String textToDisplayOnHover) {
			super.setToolTipText(textToDisplayOnHover);
			return this;
		}
		txtField removeToolTip() {
			super.setToolTipText(null);
			return this;
		}
		txtField toolTip(String textToDisplayOnHover) {
			addToolTip(textToDisplayOnHover);
			return this;
		}
		txtField toolTip() {
			removeToolTip();
			return this;
		}
		public String toolTipText() {
			return super.getToolTipText();
		}
	}
	public static class txtArea extends JTextArea {
		private static final long serialVersionUID = 1L;
		txtArea() {
			super();
		}
		txtArea(String text) {
			super(text);
		}
		txtArea(int rows, int columns) {
			super(rows, columns);
		}
		txtArea(String text, int rows, int columns) {
			super(text, rows, columns);
		}
		txtArea(Document doc, String text, int rows, int columns) {
			super(doc, text, rows, columns);
		}
		txtArea cursor(int c) {
			super.setCursor(new Cursor(c));
			return this;
		}
		txtArea cursor(Cursor crsrObj) {
			super.setCursor(crsrObj);
			return this;
		}
		txtArea border(LineBorder brdr) {
			super.setBorder(brdr);
			return this;
		}
		String text() {
			return super.getText();
		}
		txtArea text(String s) {
			super.setText(s);
			return this;
		}
		String val() {
			return text();
		}
		txtArea val(String s) {
			text(s);
			return this;
		}
		String value() {
			return text();
		}
		txtArea value(String s) {
			text(s);
			return this;
		}
		txtArea on(String k, Runnable action) {
			if (KL.in(k, "\\w{3,}\\|\\w{3,}")) {
				String[] keys = k.split("\\|");
				for (var key : keys) {
					on(key, action);
				}
			}
			if (KL.is(k) && KL.is(action)) {
				super.addKeyListener(new KeyAdapter() {
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
							new Thread(action).run();
						}
					}
				});
				super.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						int button = -1;
						if (KL.eq(k, "(m(ouse)?)?\\W?click")
								|| KL.eq(k, "(m(ouse)?)?\\W?clickl")
								|| KL.eq(k, "(m(ouse)?)?\\W?lclick"))
							button = MouseEvent.BUTTON1;
						else if (KL.eq(k, "(m(ouse)?)?\\W?clickm")
								|| KL.eq(k, "(m(ouse)?)?\\W?clickw")
								|| KL.eq(k, "(m(ouse)?)?\\W?mclick")
								|| KL.eq(k, "(m(ouse)?)?\\W?wclick"))
							button = MouseEvent.BUTTON2;
						else if (KL.eq(k, "(m(ouse)?)?\\W?clickr")
								|| KL.eq(k, "(m(ouse)?)?\\W?rclick"))
							button = MouseEvent.BUTTON3;
						if (e.getButton() == button) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseReleased(MouseEvent e) {
						if (KL.eq(k, "(m(ouse)?)\\W?release")) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseEntered(MouseEvent e) {
						if (KL.eq(k, "(m(ouse)?)\\W?(enter|in)")) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseExited(MouseEvent e) {
						if (KL.eq(k, "(m(ouse)?)\\W?(leave|out)")) {
							new Thread(action).run();
						}
					}
				});
				super.addMouseMotionListener(new MouseMotionAdapter() {
					@Override
					public void mouseDragged(MouseEvent e) {
						if (KL.eq(k, "(m(ouse)?)?\\W?drag")) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseMoved(MouseEvent e) {
						if (KL.eq(k, "(m(ouse)?)\\W?move")) {
							new Thread(action).run();
						}
					}
				});
				super.addMouseWheelListener(new MouseWheelListener() {
					@Override
					public void mouseWheelMoved(MouseWheelEvent e) {
						if (KL.eq(k, "(m(ouse)?)\\W?wheel")) {
							new Thread(action).run();
						}
					}
				});
			}
			return this;
		}
		txtArea addToolTip(String textToDisplayOnHover) {
			super.setToolTipText(textToDisplayOnHover);
			return this;
		}
		txtArea removeToolTip() {
			super.setToolTipText(null);
			return this;
		}
		txtArea toolTip(String textToDisplayOnHover) {
			addToolTip(textToDisplayOnHover);
			return this;
		}
		txtArea toolTip() {
			removeToolTip();
			return this;
		}
		public String toolTipText() {
			return super.getToolTipText();
		}
	}
	public static class txtPane extends JTextPane {
		private static final long serialVersionUID = 1L;
		txtPane() {
			super();
		}
		txtPane(StyledDocument doc) {
			super(doc);
		}
		txtPane cursor(int c) {
			super.setCursor(new Cursor(c));
			return this;
		}
		txtPane cursor(Cursor crsrObj) {
			super.setCursor(crsrObj);
			return this;
		}
		txtPane border(LineBorder brdr) {
			super.setBorder(brdr);
			return this;
		}
		String text() {
			return super.getText();
		}
		txtPane text(String s) {
			super.setText(s);
			return this;
		}
		String val() {
			return text();
		}
		txtPane val(String s) {
			text(s);
			return this;
		}
		String value() {
			return text();
		}
		txtPane value(String s) {
			text(s);
			return this;
		}
		txtPane on(String k, Runnable action) {
			if (KL.in(k, "\\w{3,}\\|\\w{3,}")) {
				String[] keys = k.split("\\|");
				for (var key : keys) {
					on(key, action);
				}
			}
			if (KL.is(k) && KL.is(action)) {
				super.addKeyListener(new KeyAdapter() {
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
							new Thread(action).run();
						}
					}
				});
				super.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						int button = -1;
						if (KL.eq(k, "(m(ouse)?)?\\W?click")
								|| KL.eq(k, "(m(ouse)?)?\\W?clickl")
								|| KL.eq(k, "(m(ouse)?)?\\W?lclick"))
							button = MouseEvent.BUTTON1;
						else if (KL.eq(k, "(m(ouse)?)?\\W?clickm")
								|| KL.eq(k, "(m(ouse)?)?\\W?clickw")
								|| KL.eq(k, "(m(ouse)?)?\\W?mclick")
								|| KL.eq(k, "(m(ouse)?)?\\W?wclick"))
							button = MouseEvent.BUTTON2;
						else if (KL.eq(k, "(m(ouse)?)?\\W?clickr")
								|| KL.eq(k, "(m(ouse)?)?\\W?rclick"))
							button = MouseEvent.BUTTON3;
						if (e.getButton() == button) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseReleased(MouseEvent e) {
						if (KL.eq(k, "(m(ouse)?)\\W?release")) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseEntered(MouseEvent e) {
						if (KL.eq(k, "(m(ouse)?)\\W?(enter|in)")) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseExited(MouseEvent e) {
						if (KL.eq(k, "(m(ouse)?)\\W?(leave|out)")) {
							new Thread(action).run();
						}
					}
				});
				super.addMouseMotionListener(new MouseMotionAdapter() {
					@Override
					public void mouseDragged(MouseEvent e) {
						if (KL.eq(k, "(m(ouse)?)?\\W?drag")) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseMoved(MouseEvent e) {
						if (KL.eq(k, "(m(ouse)?)\\W?move")) {
							new Thread(action).run();
						}
					}
				});
				super.addMouseWheelListener(new MouseWheelListener() {
					@Override
					public void mouseWheelMoved(MouseWheelEvent e) {
						if (KL.eq(k, "(m(ouse)?)\\W?wheel")) {
							new Thread(action).run();
						}
					}
				});
			}
			return this;
		}
		txtPane addToolTip(String textToDisplayOnHover) {
			super.setToolTipText(textToDisplayOnHover);
			return this;
		}
		txtPane removeToolTip() {
			super.setToolTipText(null);
			return this;
		}
		txtPane toolTip(String textToDisplayOnHover) {
			addToolTip(textToDisplayOnHover);
			return this;
		}
		txtPane toolTip() {
			removeToolTip();
			return this;
		}
		public String toolTipText() {
			return super.getToolTipText();
		}
	}
	public static class pwdField extends JPasswordField {
		private static final long serialVersionUID = 1L;
		pwdField() {
			super();
		}
		pwdField(String text) {
			super(text);
		}
		pwdField(int columns) {
			super(columns);
		}
		pwdField(String text, int columns) {
			super(text, columns);
		}
		pwdField(Document doc, String text, int columns) {
			super(doc, text, columns);
		}
		pwdField cursor(int c) {
			super.setCursor(new Cursor(c));
			return this;
		}
		pwdField cursor(Cursor crsrObj) {
			super.setCursor(crsrObj);
			return this;
		}
		pwdField border(LineBorder brdr) {
			super.setBorder(brdr);
			return this;
		}
		String text() {
			return new String(super.getPassword());
		}
		pwdField text(String text) {
			super.setText(text);
			return this;
		}
		String val() {
			return text();
		}
		pwdField val(String s) {
			text(s);
			return this;
		}
		String value() {
			return text();
		}
		pwdField value(String s) {
			text(s);
			return this;
		}
		pwdField on(String k, Runnable action) {
			if (KL.in(k, "\\w{3,}\\|\\w{3,}")) {
				String[] keys = k.split("\\|");
				for (var key : keys) {
					on(key, action);
				}
			}
			if (KL.is(k) && KL.is(action)) {
				super.addKeyListener(new KeyAdapter() {
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
							new Thread(action).run();
						}
					}
				});
				super.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						int button = -1;
						if (KL.eq(k, "(m(ouse)?)?\\W?click")
								|| KL.eq(k, "(m(ouse)?)?\\W?clickl")
								|| KL.eq(k, "(m(ouse)?)?\\W?lclick"))
							button = MouseEvent.BUTTON1;
						else if (KL.eq(k, "(m(ouse)?)?\\W?clickm")
								|| KL.eq(k, "(m(ouse)?)?\\W?clickw")
								|| KL.eq(k, "(m(ouse)?)?\\W?mclick")
								|| KL.eq(k, "(m(ouse)?)?\\W?wclick"))
							button = MouseEvent.BUTTON2;
						else if (KL.eq(k, "(m(ouse)?)?\\W?clickr")
								|| KL.eq(k, "(m(ouse)?)?\\W?rclick"))
							button = MouseEvent.BUTTON3;
						if (e.getButton() == button) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseReleased(MouseEvent e) {
						if (KL.eq(k, "(m(ouse)?)\\W?release")) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseEntered(MouseEvent e) {
						if (KL.eq(k, "(m(ouse)?)\\W?(enter|in)")) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseExited(MouseEvent e) {
						if (KL.eq(k, "(m(ouse)?)\\W?(leave|out)")) {
							new Thread(action).run();
						}
					}
				});
				super.addMouseMotionListener(new MouseMotionAdapter() {
					@Override
					public void mouseDragged(MouseEvent e) {
						if (KL.eq(k, "(m(ouse)?)?\\W?drag")) {
							new Thread(action).run();
						}
					}
					@Override
					public void mouseMoved(MouseEvent e) {
						if (KL.eq(k, "(m(ouse)?)\\W?move")) {
							new Thread(action).run();
						}
					}
				});
				super.addMouseWheelListener(new MouseWheelListener() {
					@Override
					public void mouseWheelMoved(MouseWheelEvent e) {
						if (KL.eq(k, "(m(ouse)?)\\W?wheel")) {
							new Thread(action).run();
						}
					}
				});
			}
			return this;
		}
		pwdField addToolTip(String textToDisplayOnHover) {
			super.setToolTipText(textToDisplayOnHover);
			return this;
		}
		pwdField removeToolTip() {
			super.setToolTipText(null);
			return this;
		}
		pwdField toolTip(String textToDisplayOnHover) {
			addToolTip(textToDisplayOnHover);
			return this;
		}
		pwdField toolTip() {
			removeToolTip();
			return this;
		}
		public String toolTipText() {
			return super.getToolTipText();
		}
	}
	public static class icon extends ImageIcon {
		icon() {
			super();
		}
		icon(byte[] imageData) {
			super(imageData);
		}
		icon(Image image) {
			super(image);
		}
		icon(String filename) {
			super(filename);
		}
		icon(URL urlObject) {
			super(urlObject);
		}
		icon(String urlString, boolean isUrl) {
			this(url(urlString));
		}
	}
	public static class image extends icon {
		image() {
			super();
		}
		image(byte[] imageData) {
			super(imageData);
		}
		image(Image image) {
			super(image);
		}
		image(String filename) {
			super(filename);
		}
		image(URL urlObject) {
			super(urlObject);
		}
		image(String urlString, boolean isUrl) {
			this(url(urlString));
		}
	}
	public static class img extends image {
		img() {
			super();
		}
		img(byte[] imageData) {
			super(imageData);
		}
		img(Image image) {
			super(image);
		}
		img(String filename) {
			super(filename);
		}
		img(URL urlObject) {
			super(urlObject);
		}
		img(String urlString, boolean isUrl) {
			this(url(urlString));
		}
	}
	public static class lineBorder extends LineBorder {
		lineBorder(Color color) {
			super(color);
		}
		lineBorder(Color color, int thickness) {
			super(color, thickness);
		}
		lineBorder(Color color, int thickness, boolean roundedCorners) {
			super(color, thickness, roundedCorners);
		}
	}
	public static class clr extends Color {
		private static final long serialVersionUID = 1L;
		clr() {
			super(0, 0, 0);
		}
		clr(int rgb) {
			super(rgb);
		}
		clr(int rgb, boolean includesAlphaAtEnd) {
			super(rgb, includesAlphaAtEnd);
		}
		clr(Color c) {
			this(c.getRGB());
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
			super((float) r, (float) g, (float) b);
		}
		clr(double r, double g, double b, double a) {
			super((float) r, (float) g, (float) b, (float) a);
			/*
			 * @params all in the floating range: 0 to 1
			 */
		}
		clr(String hexStringWithOrWithoutAlpha, boolean hasApha) {
			this(from(hexStringWithOrWithoutAlpha), hasApha);
			/*
			 * @param hexString in the range: (#|0x)000 thru (#|0x)ffffff clr
			 * red = clr("red
			 */
		}
		clr(String hexStringWithoutAlpha) {
			this(from(hexStringWithoutAlpha), false);
			/*
			 * @param hexString in the range: (#|0x)000 thru (#|0x)ffffff
			 */
		}
		public static int from(String hex) {
			hex = hex.replaceAll("^(0x|#)", "");
			if (not(hex) || !eq(hex, "([a-f0-9]{3,4}){1,2}") || len(hex) == 5
					|| len(hex) == 7)
				return 0;
			int len = len(hex);
			int r, g, b, a = 255;
			if (len == 8) {
				a = Int(slice(hex, 6, 8), 16);
				r = Int(slice(hex, 0, 2), 16);
				g = Int(slice(hex, 2, 4), 16);
				b = Int(slice(hex, 4, 6), 16);
				return a << 24 | r << 16 | g << 8 | b;
				// the order stays as-is
			} else if (len == 6) {
				r = Int(slice(hex, 0, 2), 16);
				g = Int(slice(hex, 2, 4), 16);
				b = Int(slice(hex, 4, 6), 16);
				return r << 16 | g << 8 | b;
				// the order stays as-is
			} else if (len == 4) {
				a = Int(slice(hex, 3, 4), 16) * 17;
				r = Int(slice(hex, 0, 1), 16) * 17;
				g = Int(slice(hex, 1, 2), 16) * 17;
				b = Int(slice(hex, 2, 3), 16) * 17;
				return a << 24 | r << 16 | g << 8 | b;
				// the order stays as-is
			}
			r = Int(slice(hex, 0, 1), 16) * 17;
			g = Int(slice(hex, 1, 2), 16) * 17;
			b = Int(slice(hex, 2, 3), 16) * 17;
			return r << 16 | g << 8 | b;
			// the order stays as-is
		}
		public static final clr apple = new clr("#6ecb3c"),
				applegreen = new clr("#76cd26"), apricot = new clr("#ffb16d"),
				aqua = new clr("#13eac9"), aquablue = new clr("#02d8e9"),
				aquagreen = new clr("#12e193"), aquamarine = new clr("#04d8b2"),
				armygreen = new clr("#4b5d16"), asparagus = new clr("#77ab56"),
				aubergine = new clr("#3d0734"), auburn = new clr("#9a3001"),
				avocado = new clr("#90b134"), avocadogreen = new clr("#87a922"),
				azul = new clr("#1d5dec"), azure = new clr("#069af3"),
				babyblue = new clr("#a2cffe"), babygreen = new clr("#8cff9e"),
				babypink = new clr("#ffb7ce"), babypoo = new clr("#ab9004"),
				babypurple = new clr("#ca9bf7"),
				barbiepink = new clr("#fe46a5"), beige = new clr("#e6daa6"),
				black = new clr("#000000"), blood = new clr("#770001"),
				bloodorange = new clr("#fe4b03"), bloodred = new clr("#980002"),
				blue = new clr("#0343df"), blue100 = new clr("#bbdefb"),
				blue200 = new clr("#90caf9"), blue300 = new clr("#64b5f6"),
				blue400 = new clr("#42a5f5"), blue50 = new clr("#e3f2fd"),
				blue500 = new clr("#2196f3"), blue600 = new clr("#1e88e5"),
				blue700 = new clr("#1976d2"), blue800 = new clr("#1565c0"),
				blue900 = new clr("#0d47a1"), blueblue = new clr("#2242c7"),
				blueextra1 = new clr("#82b1ff"),
				blueextra2 = new clr("#448aff"),
				blueextra3 = new clr("#2979ff"),
				blueextra4 = new clr("#2962ff"), bluegray = new clr("#85a3b2"),
				bluegreen = new clr("#017a79"), bluepurple = new clr("#5a06ef"),
				blueviolet = new clr("#5d06e9"),
				bluewithahintofpurple = new clr("#533cc6"),
				blueberry = new clr("#464196"),
				bluegray100 = new clr("#cfd8dc"),
				bluegray200 = new clr("#b0bec5"),
				bluegray300 = new clr("#90a4ae"),
				bluegray400 = new clr("#78909c"),
				bluegray50 = new clr("#eceff1"),
				bluegray500 = new clr("#607d8b"),
				bluegray600 = new clr("#546e7a"),
				bluegray700 = new clr("#455a64"),
				bluegray800 = new clr("#37474f"),
				bluegray900 = new clr("#263238"),
				blueygray = new clr("#89a0b0"), blueygreen = new clr("#2bb179"),
				blueypurple = new clr("#6241c7"), bluish = new clr("#2976bb"),
				bluishgray = new clr("#748b97"),
				bluishgreen = new clr("#10a674"),
				bluishpurple = new clr("#703be7"), blurple = new clr("#5539cc"),
				blush = new clr("#f29e8e"), blushpink = new clr("#fe828c"),
				brick = new clr("#a03623"), brickorange = new clr("#c14a09"),
				brickred = new clr("#8f1402"), bronze = new clr("#a87900"),
				brown = new clr("#653700"), brown100 = new clr("#d7ccc8"),
				brown200 = new clr("#bcaaa4"), brown300 = new clr("#a1887f"),
				brown400 = new clr("#8d6e63"), brown50 = new clr("#efebe9"),
				brown500 = new clr("#795548"), brown600 = new clr("#6d4c41"),
				brown700 = new clr("#5d4037"), brown800 = new clr("#4e342e"),
				brown900 = new clr("#3e2723"), browngray = new clr("#8d8468"),
				browngreen = new clr("#706c11"),
				brownorange = new clr("#b96902"), brownred = new clr("#922b05"),
				brownyellow = new clr("#b29705"), brownish = new clr("#9c6d57"),
				brownishgray = new clr("#86775f"),
				brownishgreen = new clr("#6a6e09"),
				brownishorange = new clr("#cb7723"),
				brownishpink = new clr("#c27e79"),
				brownishpurple = new clr("#76424e"),
				brownishred = new clr("#9e3623"),
				brownishyellow = new clr("#c9b003"),
				brownygreen = new clr("#6f6c0a"),
				brownyorange = new clr("#ca6b02"), bruise = new clr("#7e4071"),
				bubblegumpink = new clr("#fe83cc"),
				bubblegum = new clr("#ff6cb5"), burgundy = new clr("#610023"),
				butter = new clr("#ffff81"), cadetblue = new clr("#4e7496"),
				camel = new clr("#c69f59"), candypink = new clr("#ff63e9"),
				caramel = new clr("#af6f09"), cherry = new clr("#cf0234"),
				cherryred = new clr("#f7022a"), chestnut = new clr("#742802"),
				chocolate = new clr("#3d1c02"),
				chocolatebrown = new clr("#411900"),
				cinnamon = new clr("#ac4f06"), cocoa = new clr("#875f42"),
				coffee = new clr("#a6814c"), copper = new clr("#b66325"),
				coral = new clr("#fc5a50"), coralpink = new clr("#ff6163"),
				cornflower = new clr("#6a79f7"),
				cornflowerblue = new clr("#5170d7"),
				cranberry = new clr("#9e003a"), cream = new clr("#ffffc2"),
				custard = new clr("#fffd78"), cyan = new clr("#00ffff"),
				cyan100 = new clr("#b2ebf2"), cyan200 = new clr("#80deea"),
				cyan300 = new clr("#4dd0e1"), cyan400 = new clr("#26c6da"),
				cyan50 = new clr("#e0f7fa"), cyan500 = new clr("#00bcd4"),
				cyan600 = new clr("#00acc1"), cyan700 = new clr("#0097a7"),
				cyan800 = new clr("#00838f"), cyan900 = new clr("#006064"),
				cyanextra1 = new clr("#84ffff"),
				cyanextra2 = new clr("#18ffff"),
				cyanextra3 = new clr("#00e5ff"),
				cyanextra4 = new clr("#00b8d4"), dandelion = new clr("#fedf08"),
				dark = new clr("#1b2431"), darkaqua = new clr("#05696b"),
				darkaquamarine = new clr("#017371"),
				darkbeige = new clr("#ac9362"), darkblue = new clr("#030764"),
				darkbluegray = new clr("#1f3b4d"),
				darkbluegreen = new clr("#005249"),
				darkbrown = new clr("#341c02"), darkcoral = new clr("#cf524e"),
				darkcream = new clr("#fff39a"), darkcyan = new clr("#0a888a"),
				darkforestgreen = new clr("#002d04"),
				darkfuchsia = new clr("#9d0759"), darkgold = new clr("#b59410"),
				darkgrassgreen = new clr("#388004"),
				darkgray = new clr("#363737"),
				darkgrayblue = new clr("#29465b"),
				darkgreen = new clr("#054907"),
				darkgreenblue = new clr("#1f6357"),
				darkhotpink = new clr("#d90166"),
				darkindigo = new clr("#1f0954"), darkkhaki = new clr("#9b8f55"),
				darklavender = new clr("#856798"),
				darklilac = new clr("#9c6da5"), darklime = new clr("#84b701"),
				darklimegreen = new clr("#7ebd01"),
				darkmagenta = new clr("#960056"),
				darkmaroon = new clr("#3c0008"), darkmauve = new clr("#874c62"),
				darkmint = new clr("#48c072"),
				darkmintgreen = new clr("#20c073"),
				darkmustard = new clr("#a88905"), darknavy = new clr("#000435"),
				darknavyblue = new clr("#00022e"),
				darkolive = new clr("#373e02"),
				darkolivegreen = new clr("#3c4d03"),
				darkorange = new clr("#c65102"),
				darkpastelgreen = new clr("#56ae57"),
				darkpeach = new clr("#de7e5d"),
				darkperiwinkle = new clr("#665fd1"),
				darkpink = new clr("#cb416b"), darkplum = new clr("#3f012c"),
				darkpurple = new clr("#35063e"), darkred = new clr("#840000"),
				darkrose = new clr("#b5485d"),
				darkroyalblue = new clr("#02066f"),
				darkseagreen = new clr("#11875d"),
				darkskyblue = new clr("#448ee4"),
				darkslateblue = new clr("#214761"),
				darktan = new clr("#af884a"), darktaupe = new clr("#7f684e"),
				darkteal = new clr("#014d4e"),
				darkturquoise = new clr("#045c5a"),
				darkviolet = new clr("#34013f"),
				darkyellow = new clr("#d5b60a"),
				darkyellowgreen = new clr("#728f02"),
				darkerblue = new clr("#011288"),
				darkergreen = new clr("#087804"),
				darkerpink = new clr("#c4387f"),
				darkerpurple = new clr("#5f1b6b"),
				darkishblue = new clr("#014182"),
				darkishgreen = new clr("#287c37"),
				darkishpink = new clr("#da467d"),
				darkishpurple = new clr("#751973"),
				darkishred = new clr("#a90308"), deepaqua = new clr("#08787f"),
				deepblue = new clr("#040273"), deepbrown = new clr("#410200"),
				deepgreen = new clr("#02590f"),
				deeplavender = new clr("#8d5eb7"),
				deepmagenta = new clr("#a0025c"),
				deeporange = new clr("#dc4d01"), deeppink = new clr("#cb0162"),
				deeppurple = new clr("#36013f"), deepred = new clr("#9a0200"),
				deeprose = new clr("#c74767"), deepseablue = new clr("#015482"),
				deepskyblue = new clr("#0d75f8"), deepteal = new clr("#00555a"),
				deepturquoise = new clr("#017374"),
				deepviolet = new clr("#490648"),
				deeporange100 = new clr("#ffccbc"),
				deeporange200 = new clr("#ffab91"),
				deeporange300 = new clr("#ff8a65"),
				deeporange400 = new clr("#ff7043"),
				deeporange50 = new clr("#fbe9e7"),
				deeporange500 = new clr("#ff5722"),
				deeporange600 = new clr("#f4511e"),
				deeporange700 = new clr("#e64a19"),
				deeporange800 = new clr("#d84315"),
				deeporange900 = new clr("#bf360c"),
				deeporangeextra1 = new clr("#ff9e80"),
				deeporangeextra2 = new clr("#ff6e40"),
				deeporangeextra3 = new clr("#ff3d00"),
				deeporangeextra4 = new clr("#dd2c00"),
				deeppurple100 = new clr("#d1c4e9"),
				deeppurple200 = new clr("#b39ddb"),
				deeppurple300 = new clr("#9575cd"),
				deeppurple400 = new clr("#7e57c2"),
				deeppurple50 = new clr("#ede7f6"),
				deeppurple500 = new clr("#673ab7"),
				deeppurple600 = new clr("#5e35b1"),
				deeppurple700 = new clr("#512da8"),
				deeppurple800 = new clr("#4527a0"),
				deeppurple900 = new clr("#311b92"),
				deeppurpleextra1 = new clr("#b388ff"),
				deeppurpleextra2 = new clr("#7c4dff"),
				deeppurpleextra3 = new clr("#651fff"),
				deeppurpleextra4 = new clr("#6200ea"),
				fuchsia = new clr("#ed0dd9"), gold = new clr("#dbb40c"),
				golden = new clr("#f5bf03"), goldenbrown = new clr("#b27a01"),
				goldenrod = new clr("#fac205"),
				goldenyellow = new clr("#fec615"), grape = new clr("#6c3461"),
				grapepurple = new clr("#5d1451"),
				grapefruit = new clr("#fd5956"), grass = new clr("#5cac2d"),
				grassgreen = new clr("#3f9b0b"), gray = new clr("#929591"),
				gray100 = new clr("#f5f5f5"), gray200 = new clr("#eeeeee"),
				gray300 = new clr("#e0e0e0"), gray400 = new clr("#bdbdbd"),
				gray50 = new clr("#fafafa"), gray500 = new clr("#9e9e9e"),
				gray600 = new clr("#757575"), gray700 = new clr("#616161"),
				gray800 = new clr("#424242"), gray900 = new clr("#212121"),
				grayblue = new clr("#77a1b5"), graybrown = new clr("#7f7053"),
				graygreen = new clr("#86a17d"), graypink = new clr("#c3909b"),
				graypurple = new clr("#826d8c"), grayteal = new clr("#5e9b8a"),
				grayish = new clr("#a8a495"), grayishblue = new clr("#5e819d"),
				grayishbrown = new clr("#7a6a4f"),
				grayishgreen = new clr("#82a67d"),
				grayishpink = new clr("#c88d94"),
				grayishpurple = new clr("#887191"),
				grayishteal = new clr("#719f91"), green = new clr("#15b01a"),
				green100 = new clr("#c8e6c9"), green200 = new clr("#a5d6a7"),
				green300 = new clr("#81c784"), green400 = new clr("#66bb6a"),
				green50 = new clr("#e8f5e9"), green500 = new clr("#4caf50"),
				green600 = new clr("#43a047"), green700 = new clr("#388e3c"),
				green800 = new clr("#2e7d32"), green900 = new clr("#1b5e20"),
				greenagain = new clr("#16d43f"),
				greenapple = new clr("#5edc1f"), greenblue = new clr("#23c48b"),
				greenbrown = new clr("#544e03"),
				greenextra1 = new clr("#b9f6ca"),
				greenextra2 = new clr("#69f0ae"),
				greenextra3 = new clr("#00e676"),
				greenextra4 = new clr("#00c853"),
				greengray = new clr("#77926f"), greenteal = new clr("#0cb577"),
				greenyellow = new clr("#b5ce08"), greenish = new clr("#40a368"),
				greenishbeige = new clr("#c9d179"),
				greenishblue = new clr("#0b8b87"),
				greenishbrown = new clr("#696112"),
				greenishcyan = new clr("#2afeb7"),
				greenishgray = new clr("#96ae8d"),
				greenishtan = new clr("#bccb7a"),
				greenishteal = new clr("#32bf84"),
				greenishturquoise = new clr("#00fbb0"),
				greenishyellow = new clr("#cdfd02"),
				greenyblue = new clr("#42b395"),
				greenybrown = new clr("#696006"),
				greenygray = new clr("#7ea07a"),
				greenyyellow = new clr("#c6f808"),
				hotgreen = new clr("#25ff29"), hotmagenta = new clr("#f504c9"),
				hotpink = new clr("#ff028d"), hotpurple = new clr("#cb00f5"),
				ice = new clr("#d6fffa"), iceblue = new clr("#d7fffe"),
				ickygreen = new clr("#8fae22"), indianred = new clr("#850e04"),
				indigo = new clr("#380282"), indigo100 = new clr("#c5cae9"),
				indigo200 = new clr("#9fa8da"), indigo300 = new clr("#7986cb"),
				indigo400 = new clr("#5c6bc0"), indigo50 = new clr("#e8eaf6"),
				indigo500 = new clr("#3f51b5"), indigo600 = new clr("#3949ab"),
				indigo700 = new clr("#303f9f"), indigo800 = new clr("#283593"),
				indigo900 = new clr("#1a237e"), indigoblue = new clr("#3a18b1"),
				indigoextra1 = new clr("#8c9eff"),
				indigoextra2 = new clr("#536dfe"),
				indigoextra3 = new clr("#3d5afe"),
				indigoextra4 = new clr("#304ffe"), iris = new clr("#6258c4"),
				irishgreen = new clr("#019529"),
				junglegreen = new clr("#048243"), khaki = new clr("#aaa662"),
				khakigreen = new clr("#728639"), kiwi = new clr("#9cef43"),
				kiwigreen = new clr("#8ee53f"), lavender = new clr("#c79fef"),
				lavenderblue = new clr("#8b88f8"),
				lavenderpink = new clr("#dd85d7"),
				lawngreen = new clr("#4da409"), leaf = new clr("#71aa34"),
				leafgreen = new clr("#5ca904"), leafygreen = new clr("#51b73b"),
				leather = new clr("#ac7434"), lemon = new clr("#fdff52"),
				lemongreen = new clr("#adf802"), lemonlime = new clr("#bffe28"),
				lemonyellow = new clr("#fdff38"), lichen = new clr("#8fb67b"),
				lightaqua = new clr("#8cffdb"),
				lightaquamarine = new clr("#7bfdc7"),
				lightbeige = new clr("#fffeb6"), lightblue = new clr("#7bc8f6"),
				lightbluegray = new clr("#b7c9e2"),
				lightbluegreen = new clr("#7efbb3"),
				lightbluishgreen = new clr("#76fda8"),
				lightbrightgreen = new clr("#53fe5c"),
				lightbrown = new clr("#ad8150"),
				lightburgundy = new clr("#a8415b"),
				lightcyan = new clr("#acfffc"),
				lighteggplant = new clr("#894585"),
				lightforestgreen = new clr("#4f9153"),
				lightgold = new clr("#fddc5c"),
				lightgrassgreen = new clr("#9af764"),
				lightgray = new clr("#d8dcd6"),
				lightgrayblue = new clr("#9dbcd4"),
				lightgraygreen = new clr("#b7e1a1"),
				lightgreen = new clr("#76ff7b"),
				lightgreenblue = new clr("#56fca2"),
				lightgreenishblue = new clr("#63f7b4"),
				lightindigo = new clr("#6d5acf"),
				lightkhaki = new clr("#e6f2a2"),
				lightlavendar = new clr("#efc0fe"),
				lightlavender = new clr("#dfc5fe"),
				lightlightblue = new clr("#cafffb"),
				lightlightgreen = new clr("#c8ffb0"),
				lightlime = new clr("#aefd6c"),
				lightlimegreen = new clr("#b9ff66"),
				lightmagenta = new clr("#fa5ff7"),
				lightmaroon = new clr("#a24857"),
				lightmauve = new clr("#c292a1"), lightmint = new clr("#b6ffbb"),
				lightmintgreen = new clr("#a6fbb2"),
				lightmustard = new clr("#f7d560"),
				lightnavy = new clr("#155084"),
				lightnavyblue = new clr("#2e5a88"),
				lightneongreen = new clr("#4efd54"),
				lightolive = new clr("#acbf69"),
				lightolivegreen = new clr("#a4be5c"),
				lightorange = new clr("#fdaa48"),
				lightpastelgreen = new clr("#b2fba5"),
				lightpeagreen = new clr("#c4fe82"),
				lightpeach = new clr("#ffd8b1"),
				lightperiwinkle = new clr("#c1c6fc"),
				lightpink = new clr("#ffd1df"), lightplum = new clr("#9d5783"),
				lightpurple = new clr("#bf77f6"), lightred = new clr("#ff474c"),
				lightrose = new clr("#ffc5cb"),
				lightroyalblue = new clr("#3a2efe"),
				lightsage = new clr("#bcecac"),
				lightsalmon = new clr("#fea993"),
				lightseagreen = new clr("#98f6b0"),
				lightseafoam = new clr("#a0febf"),
				lightseafoamgreen = new clr("#a7ffb5"),
				lightskyblue = new clr("#c6fcff"),
				lighttan = new clr("#fbeeac"), lightteal = new clr("#90e4c1"),
				lightturquoise = new clr("#7ef4cc"),
				lighturple = new clr("#b36ff6"),
				lightviolet = new clr("#d6b4fc"),
				lightyellow = new clr("#fffe7a"),
				lightyellowgreen = new clr("#ccfd7f"),
				lightyellowishgreen = new clr("#c2ff89"),
				lightblue100 = new clr("#b3e5fc"),
				lightblue200 = new clr("#81d4fa"),
				lightblue300 = new clr("#4fc3f7"),
				lightblue400 = new clr("#29b6f6"),
				lightblue50 = new clr("#e1f5fe"),
				lightblue500 = new clr("#03a9f4"),
				lightblue600 = new clr("#039be5"),
				lightblue700 = new clr("#0288d1"),
				lightblue800 = new clr("#0277bd"),
				lightblue900 = new clr("#01579b"),
				lightblueextra1 = new clr("#80d8ff"),
				lightblueextra2 = new clr("#40c4ff"),
				lightblueextra3 = new clr("#00b0ff"),
				lightblueextra4 = new clr("#0091ea"),
				lightergreen = new clr("#75fd63"),
				lighterpurple = new clr("#a55af4"),
				lightgreen100 = new clr("#dcedc8"),
				lightgreen200 = new clr("#c5e1a5"),
				lightgreen300 = new clr("#aed581"),
				lightgreen400 = new clr("#9ccc65"),
				lightgreen50 = new clr("#f1f8e9"),
				lightgreen500 = new clr("#8bc34a"),
				lightgreen600 = new clr("#7cb342"),
				lightgreen700 = new clr("#689f38"),
				lightgreen800 = new clr("#558b2f"),
				lightgreen900 = new clr("#33691e"),
				lightgreenextra1 = new clr("#ccff90"),
				lightgreenextra2 = new clr("#b2ff59"),
				lightgreenextra3 = new clr("#76ff03"),
				lightgreenextra4 = new clr("#64dd17"),
				lightishblue = new clr("#3d7afd"),
				lightishgreen = new clr("#61e160"),
				lightishpurple = new clr("#a552e6"),
				lightishred = new clr("#fe2f4a"), lime = new clr("#aaff32"),
				lime100 = new clr("#f0f4c3"), lime200 = new clr("#e6ee9c"),
				lime300 = new clr("#dce775"), lime400 = new clr("#d4e157"),
				lime50 = new clr("#f9fbe7"), lime500 = new clr("#cddc39"),
				lime600 = new clr("#c0ca33"), lime700 = new clr("#afb42b"),
				lime800 = new clr("#9e9d24"), lime900 = new clr("#827717"),
				limeextra1 = new clr("#f4ff81"),
				limeextra2 = new clr("#eeff41"),
				limeextra3 = new clr("#c6ff00"),
				limeextra4 = new clr("#aeea00"), limegreen = new clr("#89fe05"),
				limeyellow = new clr("#d0fe1d"), lipstick = new clr("#d5174e"),
				lipstickred = new clr("#c0022f"), magenta = new clr("#c20078"),
				mahogany = new clr("#4a0100"), maize = new clr("#f4d054"),
				mango = new clr("#ffa62b"), manilla = new clr("#fffa86"),
				marigold = new clr("#fcc006"), marine = new clr("#042e60"),
				marineblue = new clr("#01386a"), maroon = new clr("#650021"),
				mediumblue = new clr("#2c6fbb"),
				mediumbrown = new clr("#7f5112"),
				mediumgray = new clr("#7d7f7c"),
				mediumgreen = new clr("#39ad48"),
				mediumpink = new clr("#f36196"),
				mediumpurple = new clr("#9e43a2"), melon = new clr("#ff7855"),
				merlot = new clr("#730039"), metallicblue = new clr("#4f738e"),
				midblue = new clr("#276ab3"), midgreen = new clr("#50a747"),
				midnight = new clr("#03012d"),
				midnightblue = new clr("#020035"),
				midnightpurple = new clr("#280137"),
				militarygreen = new clr("#667c3e"),
				milkchocolate = new clr("#7f4e1e"), mint = new clr("#9ffeb0"),
				mintgreen = new clr("#8fff9f"), mintygreen = new clr("#0bf77d"),
				mushroom = new clr("#ba9e88"), mustard = new clr("#ceb301"),
				mustardbrown = new clr("#ac7e04"),
				mustardgreen = new clr("#a8b504"),
				mustardyellow = new clr("#d2bd0a"),
				mutedblue = new clr("#3b719f"), mutedgreen = new clr("#5fa052"),
				mutedpink = new clr("#d1768f"),
				mutedpurple = new clr("#805b87"),
				nastygreen = new clr("#70b23f"), navy = new clr("#01153e"),
				navyblue = new clr("#001146"), navygreen = new clr("#35530a"),
				neonblue = new clr("#04d9ff"), neongreen = new clr("#0cff0c"),
				neonpink = new clr("#fe019a"), neonpurple = new clr("#bc13fe"),
				neonred = new clr("#ff073a"), neonyellow = new clr("#cfff04"),
				niceblue = new clr("#107ab0"), nightblue = new clr("#040348"),
				ocean = new clr("#017b92"), oceanblue = new clr("#03719c"),
				oceangreen = new clr("#3d9973"), ocre = new clr("#c69c04"),
				offblue = new clr("#5684ae"), offgreen = new clr("#6ba353"),
				offwhite = new clr("#ffffe4"), offyellow = new clr("#f1f33f"),
				oldpink = new clr("#c77986"), oldrose = new clr("#c87f89"),
				olive = new clr("#6e750e"), orange = new clr("#f97306"),
				orange100 = new clr("#ffe0b2"), orange200 = new clr("#ffcc80"),
				orange300 = new clr("#ffb74d"), orange400 = new clr("#ffa726"),
				orange50 = new clr("#fff3e0"), orange500 = new clr("#ff9800"),
				orange600 = new clr("#fb8c00"), orange700 = new clr("#f57c00"),
				orange800 = new clr("#ef6c00"), orange900 = new clr("#e65100"),
				orangebrown = new clr("#be6400"),
				orangeextra1 = new clr("#ffd180"),
				orangeextra2 = new clr("#ffab40"),
				orangeextra3 = new clr("#ff9100"),
				orangeextra4 = new clr("#ff6d00"),
				orangepink = new clr("#ff6f52"), orangered = new clr("#fe420f"),
				orangeyellow = new clr("#ffad01"),
				orangeish = new clr("#fd8d49"),
				orangeybrown = new clr("#b16002"),
				orangeyred = new clr("#fa4224"),
				orangeyyellow = new clr("#fdb915"),
				orangish = new clr("#fc824a"),
				orangishbrown = new clr("#b25f03"),
				orangishred = new clr("#f43605"), orchid = new clr("#c875c4"),
				peach = new clr("#ffb07c"), peachypink = new clr("#ff9a8a"),
				peacockblue = new clr("#016795"), pear = new clr("#cbf85f"),
				pink = new clr("#ff81c0"), pink100 = new clr("#f8bbd0"),
				pink200 = new clr("#f48fb1"), pink300 = new clr("#f06292"),
				pink400 = new clr("#ec407a"), pink50 = new clr("#fce4ec"),
				pink500 = new clr("#e91e63"), pink600 = new clr("#d81b60"),
				pink700 = new clr("#c2185b"), pink800 = new clr("#ad1457"),
				pink900 = new clr("#880e4f"), pinkextra1 = new clr("#ff80ab"),
				pinkextra2 = new clr("#ff4081"),
				pinkextra3 = new clr("#f50057"),
				pinkextra4 = new clr("#c51162"),
				pinkpurple = new clr("#ef1de7"), pinkred = new clr("#f5054f"),
				pinkish = new clr("#d46a7e"), pinkishbrown = new clr("#b17261"),
				pinkishgray = new clr("#c8aca9"),
				pinkishorange = new clr("#ff724c"),
				pinkishpurple = new clr("#d648d7"),
				pinkishred = new clr("#f10c45"), pinky = new clr("#fc86aa"),
				pinkypurple = new clr("#c94cbe"), pinkyred = new clr("#fc2647"),
				pissyellow = new clr("#ddd618"), pistachio = new clr("#c0fa8b"),
				plum = new clr("#580f41"), plumpurple = new clr("#4e0550"),
				purple = new clr("#7e1e9c"), purple100 = new clr("#e1bee7"),
				purple200 = new clr("#ce93d8"), purple300 = new clr("#ba68c8"),
				purple400 = new clr("#ab47bc"), purple50 = new clr("#f3e5f5"),
				purple500 = new clr("#9c27b0"), purple600 = new clr("#8e24aa"),
				purple700 = new clr("#7b1fa2"), purple800 = new clr("#6a1b9a"),
				purple900 = new clr("#4a148c"), purpleblue = new clr("#5d21d0"),
				purplebrown = new clr("#673a3f"),
				purpleextra1 = new clr("#ea80fc"),
				purpleextra2 = new clr("#e040fb"),
				purpleextra3 = new clr("#d500f9"),
				purpleextra4 = new clr("#aa00ff"),
				purplegray = new clr("#866f85"),
				purplepink = new clr("#d725de"), purplered = new clr("#990147"),
				purpleish = new clr("#98568d"),
				purpleishblue = new clr("#6140ef"),
				purpleishpink = new clr("#df4ec8"),
				purpley = new clr("#8756e4"), purpleyblue = new clr("#5f34e7"),
				purpleygray = new clr("#947e94"),
				purpleypink = new clr("#c83cb9"), purplish = new clr("#94568c"),
				purplishblue = new clr("#601ef9"),
				purplishbrown = new clr("#6b4247"),
				purplishgray = new clr("#7a687f"),
				purplishpink = new clr("#ce5dae"),
				purplishred = new clr("#b0054b"), purply = new clr("#983fb2"),
				purplyblue = new clr("#661aee"),
				purplypink = new clr("#f075e6"), red = new clr("#e50000"),
				red100 = new clr("#ffcdd2"), red200 = new clr("#ef9a9a"),
				red300 = new clr("#e57373"), red400 = new clr("#ef5350"),
				red50 = new clr("#ffebee"), red500 = new clr("#f44336"),
				red600 = new clr("#e53935"), red700 = new clr("#d32f2f"),
				red800 = new clr("#c62828"), red900 = new clr("#b71c1c"),
				redbrown = new clr("#8b2e16"), redextra1 = new clr("#ff8a80"),
				redextra2 = new clr("#ff5252"), redextra3 = new clr("#ff1744"),
				redextra4 = new clr("#d50000"), redorange = new clr("#fd3c06"),
				redpink = new clr("#fa2a55"), redpurple = new clr("#820747"),
				redviolet = new clr("#9e0168"), redwine = new clr("#8c0034"),
				reddish = new clr("#c44240"), reddishbrown = new clr("#7f2b0a"),
				reddishgray = new clr("#997570"),
				reddishorange = new clr("#f8481c"),
				reddishpink = new clr("#fe2c54"),
				reddishpurple = new clr("#910951"), rosa = new clr("#fe86a4"),
				rose = new clr("#cf6275"), rosepink = new clr("#f7879a"),
				rosered = new clr("#be013c"), rosypink = new clr("#f6688e"),
				rouge = new clr("#ab1239"), saffron = new clr("#feb209"),
				sand = new clr("#e2ca76"), sandbrown = new clr("#cba560"),
				sandyellow = new clr("#fce166"), sea = new clr("#3c9992"),
				seablue = new clr("#047495"), seagreen = new clr("#53fca1"),
				sepia = new clr("#985e2b"), shockingpink = new clr("#fe02a2"),
				silver = new clr("#c5c9c7"), sky = new clr("#82cafc"),
				skyblue = new clr("#75bbfd"), slate = new clr("#516572"),
				slateblue = new clr("#5b7c99"), slategray = new clr("#59656d"),
				slategreen = new clr("#658d6d"), steel = new clr("#738595"),
				steelblue = new clr("#5a7d9a"), steelgray = new clr("#6f828a"),
				stone = new clr("#ada587"), stormyblue = new clr("#507b9c"),
				straw = new clr("#fcf679"), strawberry = new clr("#fb2943"),
				sunflower = new clr("#ffc512"),
				sunfloweryellow = new clr("#ffda03"), tan = new clr("#d1b26f"),
				tanbrown = new clr("#ab7e4c"), tangreen = new clr("#a9be70"),
				tangerine = new clr("#ff9408"), taupe = new clr("#b9a281"),
				teal = new clr("#029386"), teal100 = new clr("#b2dfdb"),
				teal200 = new clr("#80cbc4"), teal300 = new clr("#4db6ac"),
				teal400 = new clr("#26a69a"), teal50 = new clr("#e0f2f1"),
				teal500 = new clr("#009688"), teal600 = new clr("#00897b"),
				teal700 = new clr("#00796b"), teal800 = new clr("#00695c"),
				teal900 = new clr("#004d40"), tealblue = new clr("#01889f"),
				tealextra1 = new clr("#a7ffeb"),
				tealextra2 = new clr("#64ffda"),
				tealextra3 = new clr("#1de9b6"),
				tealextra4 = new clr("#00bfa5"), tealgreen = new clr("#25a36f"),
				tealish = new clr("#24bca8"), tealishgreen = new clr("#0cdc73"),
				tomato = new clr("#ef4026"), tomatored = new clr("#ec2d01"),
				turquoise = new clr("#06c2ac"),
				turquoiseblue = new clr("#06b1c4"),
				turquoisegreen = new clr("#04f489"), umber = new clr("#b26400"),
				verydarkblue = new clr("#000133"),
				verydarkbrown = new clr("#1d0200"),
				verydarkgreen = new clr("#062e03"),
				verydarkpurple = new clr("#2a0134"),
				verylightblue = new clr("#d5ffff"),
				verylightbrown = new clr("#d3b683"),
				verylightgreen = new clr("#d1ffbd"),
				verylightpink = new clr("#fff4f2"),
				verylightpurple = new clr("#f6cefc"),
				violet = new clr("#9a0eea"), violetblue = new clr("#510ac9"),
				violetpink = new clr("#fb5ffc"), violetred = new clr("#a50055"),
				viridian = new clr("#1e9167"), vividblue = new clr("#152eff"),
				vividgreen = new clr("#2fef10"),
				vividpurple = new clr("#9900fa"), wheat = new clr("#fbdd7e"),
				white = new clr("#ffffff"), wine = new clr("#80013f"),
				winered = new clr("#7b0323"), yellow = new clr("#ffff14"),
				yellow100 = new clr("#fff9c4"), yellow200 = new clr("#fff59d"),
				yellow300 = new clr("#fff176"), yellow400 = new clr("#ffee58"),
				yellow50 = new clr("#fffde7"), yellow500 = new clr("#ffeb3b"),
				yellow600 = new clr("#fdd835"), yellow700 = new clr("#fbc02d"),
				yellow800 = new clr("#f9a825"), yellow900 = new clr("#f57f17"),
				yellowbrown = new clr("#b79400"),
				yellowextra1 = new clr("#ffff8d"),
				yellowextra2 = new clr("#ffff00"),
				yellowextra3 = new clr("#ffea00"),
				yellowextra4 = new clr("#ffd600"),
				yellowgreen = new clr("#bbf90f"),
				yellowochre = new clr("#cb9d06"),
				yelloworange = new clr("#fcb001"),
				yellowtan = new clr("#ffe36e"), yellowish = new clr("#faee66"),
				yellowishbrown = new clr("#9b7a01"),
				yellowishgreen = new clr("#b0dd16"),
				yellowishorange = new clr("#ffab0f"),
				yellowishtan = new clr("#fcfc81"),
				yellowybrown = new clr("#ae8b0c"),
				yellowygreen = new clr("#bff128");
	}
	public static final class font extends Font {
		font(String fontFamily, int fontSize) {
			super(fontFamily, Font.PLAIN, fontSize);
		}
		font(String fontFamily, int fontSize, int fontWidth) {
			super(fontFamily, fontWidth, fontSize);
		}
		font(String fontFamily, int fontSize, boolean bold, boolean italic) {
			super(fontFamily, bold && italic
					? Font.BOLD | Font.ITALIC
					: bold ? Font.BOLD : italic ? Font.ITALIC : Font.PLAIN,
					fontSize);
		}
		font(String fontFamily, int fontSize, boolean bold) {
			this(fontFamily, fontSize, bold, false);
		}
		font(String fontFamily, int fontSize, int bold, int italic) {
			super(fontFamily,
					bold == 1 && italic == 1
							? Font.BOLD | Font.ITALIC
							: bold == 1
									? Font.BOLD
									: italic == 1 ? Font.ITALIC : Font.PLAIN,
					fontSize);
		}
	}
	public static class file extends File {
		file(File parent, String child) {
			super(parent, child);
		}
		file(String path) {
			super(path);
		}
		file(String parent, String child) {
			super(parent, child);
		}
		file(URI uri) {
			super(uri);
		}
		String string() {
			return super.toString();
		}
		String str() {
			return string();
		}
		String path() {
			return super.getPath();
		}
		String absolutePath() {
			return super.getAbsolutePath();
		}
		String absPath() {
			return absolutePath();
		}
		boolean isFolder() {
			return super.isDirectory();
		}
		// @static methods
		public static boolean create(String fname, String content) {
			if (not(fname) || not(content))
				return false;
			if (in(fname, "(?<=\\w)\\s*[\\|\\+\\&\\,\\;]\\s*(?=\\w)")) {
				for (String subFileName : fname
						.split("\\s*[\\|\\+\\&\\,\\;]\\s*")) {
					create(subFileName, content);
				}
				return true;
				// since we have got some exception handling, let's just guess
				// everything works as expected, I mean one can't return null
				// here, if I could I would, it has to be a boolean. Can't be
				// false either. False negatives? Not my thing. Neither are
				// false positives, but not much choice left other than to give
				// either a false negative, or a false positive.
			}
			try {
				File myFile = new File(fname);
				FileWriter fr = new FileWriter(fname);
				fr.write(content);
				print("[KL.file.JobSuccess]:\nFile \"" + myFile.getName()
						+ "\" created successfully.");
				fr.close();
				return true;
			} catch (IOException e) {
				print("[KL.file.JobFailed]: Something went wrong. File creation "
						+ "failed.");
			}
			return false;
		}
		public static boolean create(String fname) {
			if (not(fname))
				return false;
			return create(fname, "");
			// creates a blank file
		}
		public static boolean createFolder(String folderName) {
			if (not(folderName))
				return false;
			if (in(folderName, "(?<=\\w)\\s*[\\|\\+\\&\\,\\;]\\s*(?=\\w)")) {
				for (String folder : folderName
						.split("\\s*[\\|\\+\\&\\,\\;]\\s*")) {
					createFolder(folder);
				}
				return true;
				// since we have got some exception handling, let's just guess
				// everything works as expected, I mean one can't return null
				// here, if I could I would, it has to be a boolean. Can't be
				// false either. False negatives? Not my thing. Neither are
				// false positives, but not much choice left other than to give
				// either a false negative, or a false positive.
			}
			try {
				File fileFolder = new File(folderName);
				return fileFolder.mkdirs();
				// mkdirs is used to make both directories, and subdirectories
			} catch (Exception e) {
				print("[KL.file.JobFailed]:\nFolder failed to create.");
			}
			return false;
		}
		public static boolean newFolder(String folderName) {
			return createFolder(folderName);
		}
		public static boolean createDirectory(String folderName) {
			return createFolder(folderName);
		}
		public static boolean newDirectory(String folderName) {
			return createFolder(folderName);
		}
		public static String read(String fname) {
			if (not(fname))
				return "";
			try {
				File myFile = new File(fname);
				if (!myFile.exists())
					return "";
				Scanner myReader = new Scanner(myFile);
				String data = "";
				while (myReader.hasNextLine())
					data += myReader.nextLine();
				myReader.close();
				return data;
			} catch (IOException e) {
				print("[KL.file.JobFailed]:\nSomething went wrong. Failed to read the file.");
				return "";
			}
		}
		public static objS readJson(String fname) {
			return parseJson(read(fname));
		}
		public static boolean append(String fname, String content) {
			if (not(fname) || not(content))
				return false;
			if (in(fname, "(?<=\\w)\\s*[\\|\\+\\&\\,\\;]\\s*(?=\\w)")) {
				for (String subFileName : fname
						.split("\\s*[\\|\\+\\&\\,\\;]\\s*")) {
					append(subFileName, content);
				}
				return true;
				// since we have got some exception handling, let's just guess
				// everything works as expected, I mean one can't return null
				// here, if I could I would, it has to be a boolean. Can't be
				// false either. False negatives? Not my thing. Neither are
				// false positives, but not much choice left other than to give
				// either a false negative, or a false positive.
			}
			// order matters
			File file = new File(fname);
			if (file == null || !file.exists())
				return false;
			try (FileWriter writer = new FileWriter(fname, true)) {
				writer.write(content);
				writer.flush();
				print("[KL.file.JobSuccess]:\nAppending to file \"%s\" was successful.",
						fname);
				return true;
			} catch (Exception e) {
				print("[KL.file.JobFailed]:\nFailed to append to file \"%s\"",
						fname);
			}
			return false;
			// this method is different than createFile, and unlike the former,
			// this one will append some new content to an existing file,
			// instead of replacing the old content with the new one, which, if
			// the file exists, is the case for createFile method
		}
		public static boolean appendTo(String fname, String content) {
			return append(fname, content);
		}
		public static boolean push(String fname, String content) {
			return append(fname, content);
		}
		public static boolean add(String fname, String content) {
			return append(fname, content);
		}
		public static boolean delete(String fname) {
			if (not(fname))
				return false;
			if (in(fname, "(?<=\\w)\\s*[\\|\\+\\&\\,\\;]\\s*(?=\\w)")) {
				for (String subFileName : fname
						.split("\\s*[\\|\\+\\&\\,\\;]\\s*")) {
					delete(subFileName);
					// refers to the delete method that belongs to this class,
					// not the delete that belonged to the original File class
				}
				return true;
				// since we have got some exception handling, let's just guess
				// everything works as expected, I mean one can't return null
				// here, if I could I would, it has to be a boolean. Can't be
				// false either. False negatives? Not my thing. Neither are
				// false positives, but not much choice left other than to give
				// either a false negative, or a false positive.
			}
			File myFile = new File(fname);
			String msgOnSuccess = "[KL.file.JobSuccess]:\nFile \""
					+ myFile.getPath() + "\" deleted successfully.",
					msgOnFailure = new KL().f(
							"[KL.file.JobFailed]:\nFile \"%s\" failed to delete. No such file, or folder!",
							fname);
			if (myFile == null || !myFile.exists()) {
				print(msgOnFailure);
				return false;
			}
			if (myFile.isDirectory()) {
				for (File f : myFile.listFiles())
					delete(f.toString());
			}
			myFile.delete();
			// NOTICE: this delete method refers to the delete METHOD OF THE
			// PARENT CLASS File, not of the current "file" class, because
			// that'd just make a highly recursive, infinite loop you can never
			// get out of
			print(msgOnSuccess);
			return true;
		}
		public static boolean remove(String fname) {
			return delete(fname);
		}
		public static boolean deleteFolder(String fname) {
			return delete(fname);
			// the deleteFile method can delete anything: be it a folder, or
			// directory
		}
		public static boolean removeFolder(String fname) {
			return delete(fname);
		}
		public static boolean rename(String fname, String destinationString) {
			if (not(fname) || not(destinationString))
				return false;
			if (in(fname, "(?<=\\w)\\s*[\\|\\+\\&\\,\\;]\\s*(?=\\w)")
					&& in(destinationString, "[\\\\\\/]")) {
				for (String subFileName : fname
						.split("\\s*[\\|\\+\\&\\,\\;]\\s*")) {
					rename(subFileName, destinationString);
					// makes no sense in the form of a file-renaming function
					// anymore, but in the case of a file mover (that's quite
					// right, moving is possible with the exact same function if
					// you pass in the folder name + separator), it does make
					// sense in the case where want to move multiple files to
					// the same specific directory
				}
				return true;
				// since we have got some exception handling, let's just guess
				// everything works as expected, I mean one can't return null
				// here, if I could I would, it has to be a boolean. Can't be
				// false either. False negatives? Not my thing. Neither are
				// false positives, but not much choice left other than to give
				// either a false negative, or a false positive.
			}
			try {
				File myFile = new File(fname);
				if (myFile == null || !myFile.exists())
					throw new FileNotFoundException();
				File destinationFile = new File(destinationString);
				if (myFile.renameTo(destinationFile)) {
					print("\n[KL.file.JobSuccess]:\nFile " + myFile.getName()
							+ " was successfully moved/renamed to "
							+ destinationFile.getPath());
					return true;
				}
				print("[KL.file.JobFailed]:\nYou do not have enough permissions "
						+ "to move/rename this file.");
			} catch (FileNotFoundException e) {
				print("[KL.file.JobFailed]:\nNothing to rename.");
			}
			return false;
		}
		public static boolean move(String from, String to) {
			return rename(from, to);
		}
		public static boolean copy(String from, String to, boolean overwrite) {
			if (not(from) || not(to))
				return false;
			// order matters, this check always comes first
			if (in(from, "(?<=\\w)\\s*[\\|\\+\\&\\,\\;]\\s*(?=\\w)")) {
				for (String subFileName : from
						.split("\\s*[\\|\\+\\&\\,\\;]\\s*")) {
					copy(subFileName, to, overwrite);
				}
				return true;
				// since we have got some exception handling, let's just guess
				// everything works as expected, I mean one can't return null
				// here, if I could I would, it has to be a boolean. Can't be
				// false either. False negatives? Not my thing. Neither are
				// false positives, but not much choice left other than to give
				// either a false negative, or a false positive.
			}
			File fileToCopy = new File(from);
			File destination = new File(to);
			// order matter, this check SHOULD come after
			if (isNull(fileToCopy) || !fileToCopy.exists())
				return false;
			try {
				if (!overwrite) {
					Files.copy(fileToCopy.toPath(), destination.toPath());
				} else {
					Files.copy(fileToCopy.toPath(), destination.toPath(),
							StandardCopyOption.REPLACE_EXISTING);
				}
				return true;
			} catch (IOException e) {
				print("[KL.file.JobFailed]:\nFile failed to copy!");
			}
			return false;
		}
		public static boolean copy(String from, String to) {
			return copy(from, to, true);
		}
	}
	// some global font variables for the ease of access, only handy if you
	// extend
	// the library class with your own
	int Bold, Italic, BoldItalic, Plain, BOLD, ITALIC, BOLDITALIC, PLAIN,
			bold = Bold = BOLD = Font.BOLD, plain = Plain = PLAIN = Font.PLAIN,
			italic = Italic = ITALIC = Font.ITALIC,
			bolditalic = BoldItalic = BOLDITALIC = Bold | Italic;
	// making some colors globally accessible, for ease
	// standard
	public static clr red = new clr(clr.red), green = new clr(clr.green),
			blue = new clr(clr.blue), pink = new clr(clr.pink),
			magenta = new clr(clr.magenta), orange = new clr(clr.orange),
			lightgray = new clr(clr.lightGray), gray = new clr(clr.gray),
			darkgray = new clr(clr.darkGray), cyan = new clr(clr.cyan),
			yellow = new clr(clr.yellow), white = new clr(clr.white),
			black = new clr(clr.black);
	public static class colors extends clr {

	}
	public static class clrs extends clr {

	}
	// some other syntax candies
	public static pesa rakam() {
		return new pesa();
	}
	public static pesa rakam(double amnt) {
		return new pesa(amnt);
	}
	public static pesa rakam(double amnt, String curr) {
		return new pesa(amnt, curr);
	}
	public static pesa pesa() {
		return new pesa();
	}
	public static pesa pesa(double amnt) {
		return new pesa(amnt);
	}
	public static pesa pesa(double amnt, String curr) {
		return new pesa(amnt, curr);
	}
	public static pesa naiRakam() {
		return new pesa();
	}
	public static pesa naiRakam(double amnt) {
		return new pesa(amnt);
	}
	public static pesa naiRakam(double amnt, String curr) {
		return new pesa(amnt, curr);
	}
	public static bordLay bordLay() {
		return new bordLay();
	}
	public static bordLay bordLay(int hgap, int vgap) {
		return new bordLay(hgap, vgap);
	}
	public static bordLay nayaBordLay() {
		return new bordLay();
	}
	public static bordLay nayaBordLay(int hgap, int vgap) {
		return new bordLay(hgap, vgap);
	}
	public static gridLay gridLay() {
		return new gridLay();
	}
	public static gridLay gridLay(int rows, int columns) {
		return new gridLay(rows, columns);
	}
	public static gridLay gridLay(int rows, int columns, int hgap, int vgap) {
		return new gridLay(rows, columns, hgap, vgap);
	}
	public static gridLay nayaGridLay() {
		return new gridLay();
	}
	public static gridLay nayaGridLay(int rows, int columns) {
		return new gridLay(rows, columns);
	}
	public static gridLay nayaGridLay(int rows, int columns, int hgap,
			int vgap) {
		return new gridLay(rows, columns, hgap, vgap);
	}
	public static gridBagLay gridBagLay() {
		return new gridBagLay();
	}
	public static gridBagSettings gridBagSettings() {
		return new gridBagSettings();
	}
	public static gridBagLay nayaGridBagLay() {
		return new gridBagLay();
	}
	public static gridBagSettings naiGridBagSettings() {
		return new gridBagSettings();
	}
	public static flowLay flowLay() {
		return new flowLay();
	}
	public static flowLay flowLay(int align) {
		return new flowLay(align);
	}
	public static flowLay flowLay(int align, int hgap, int vgap) {
		return new flowLay(align, hgap, vgap);
	}
	public static flowLay nayaFlowLay() {
		return new flowLay();
	}
	public static flowLay nayaFlowLay(int align) {
		return new flowLay(align);
	}
	public static flowLay nayaFlowLay(int align, int hgap, int vgap) {
		return new flowLay(align, hgap, vgap);
	}
	public static cardLay cardLay() {
		return new cardLay();
	}
	public static cardLay cardLay(int hgap, int vgap) {
		return new cardLay(hgap, vgap);
	}
	public static cardLay nayaCardLay() {
		return new cardLay();
	}
	public static cardLay nayaCardLay(int hgap, int vgap) {
		return new cardLay(hgap, vgap);
	}
	public static boxLay boxLay(Container target, int axis) {
		return new boxLay(target, axis);
	}
	public static boxLay nayaBoxLay(Container target, int axis) {
		return new boxLay(target, axis);
	}
	public static lineBorder lineBorder(Color color) {
		return new lineBorder(color);
	}
	public static lineBorder lineBorder(Color color, int thickness) {
		return new lineBorder(color, thickness);
	}
	public static lineBorder lineBorder(Color color, int thickness,
			boolean roundedCorners) {
		return new lineBorder(color, thickness, roundedCorners);
	}
	public static lineBorder nayaLineBorder(Color color) {
		return new lineBorder(color);
	}
	public static lineBorder nayaLineBorder(Color color, int thickness) {
		return new lineBorder(color, thickness);
	}
	public static lineBorder nayaLineBorder(Color color, int thickness,
			boolean roundedCorners) {
		return new lineBorder(color, thickness, roundedCorners);
	}
	public static font font(String fontFamily, int fontSize) {
		return new font(fontFamily, Font.PLAIN, fontSize);
	}
	public static font font(String fontFamily, int fontSize, int fontWidth) {
		return new font(fontFamily, fontWidth, fontSize);
	}
	public static font font(String fontFamily, int fontSize, boolean bold,
			boolean italic) {
		return new font(fontFamily,
				bold && italic
						? Font.BOLD | Font.ITALIC
						: bold ? Font.BOLD : italic ? Font.ITALIC : Font.PLAIN,
				fontSize);
	}
	public static font font(String fontFamily, int fontSize, boolean bold) {
		return new font(fontFamily, fontSize, bold, false);
	}
	public static font font(String fontFamily, int fontSize, int bold,
			int italic) {
		return new font(fontFamily,
				bold == 1 && italic == 1
						? Font.BOLD | Font.ITALIC
						: bold == 1
								? Font.BOLD
								: italic == 1 ? Font.ITALIC : Font.PLAIN,
				fontSize);
	}
	public static file file(File parent, String child) {
		return new file(parent, child);
	}
	public static file file(String path) {
		return new file(path);
	}
	public static file file(String parent, String child) {
		return new file(parent, child);
	}
	public static file file(URI uri) {
		return new file(uri);
	}
	public static panel panel() {
		return new panel();
	}
	public static panel panel(LayoutManager layout) {
		return new panel(layout);
	}
	public static panel panel(boolean isDoubleBuffered) {
		return new panel(isDoubleBuffered);
	}
	public static panel panel(LayoutManager layout, boolean isDoubleBuffered) {
		return new panel(layout, isDoubleBuffered);
	}
	public static panel nayaPanel() {
		return new panel();
	}
	public static panel nayaPanel(LayoutManager layout) {
		return new panel(layout);
	}
	public static panel nayaPanel(boolean isDoubleBuffered) {
		return new panel(isDoubleBuffered);
	}
	public static panel nayaPanel(LayoutManager layout,
			boolean isDoubleBuffered) {
		return new panel(layout, isDoubleBuffered);
	}
	public static label label() {
		return new label();
	}
	public static label label(String text) {
		return new label(text);
	}
	public static label label(String text, int alignment) {
		return new label(text, alignment);
	}
	public static label nayaLabel() {
		return new label();
	}
	public static label nayaLabel(String text) {
		return new label(text);
	}
	public static label nayaLabel(String text, int alignment) {
		return new label(text, alignment);
	}
	public static txtField txtField() {
		return new txtField();
	}
	public static txtField txtField(String text) {
		return new txtField(text);
	}
	public static txtField txtField(int columns) {
		return new txtField(columns);
	}
	public static txtField txtField(String text, int columns) {
		return new txtField(text, columns);
	}
	public static txtField txtField(Document doc, String text, int columns) {
		return new txtField(doc, text, columns);
	}
	public static txtField naiTxtField() {
		return new txtField();
	}
	public static txtField naiTxtField(String text) {
		return new txtField(text);
	}
	public static txtField naiTxtField(int columns) {
		return new txtField(columns);
	}
	public static txtField naiTxtField(String text, int columns) {
		return new txtField(text, columns);
	}
	public static txtField naiTxtField(Document doc, String text, int columns) {
		return new txtField(doc, text, columns);
	}
	public static pwdField pwdField() {
		return new pwdField();
	}
	public static pwdField pwdField(String text) {
		return new pwdField(text);
	}
	public static pwdField pwdField(int columns) {
		return new pwdField(columns);
	}
	public static pwdField pwdField(String text, int columns) {
		return new pwdField(text, columns);
	}
	public static pwdField pwdField(Document doc, String text, int columns) {
		return new pwdField(doc, text, columns);
	}
	public static pwdField naiPwdField() {
		return new pwdField();
	}
	public static pwdField naiPwdField(String text) {
		return new pwdField(text);
	}
	public static pwdField naiPwdField(int columns) {
		return new pwdField(columns);
	}
	public static pwdField naiPwdField(String text, int columns) {
		return new pwdField(text, columns);
	}
	public static pwdField naiPwdField(Document doc, String text, int columns) {
		return new pwdField(doc, text, columns);
	}
	public static icon icon() {
		return new icon();
	}
	public static icon icon(byte[] imageData) {
		return new icon(imageData);
	}
	public static icon icon(Image image) {
		try {
			return new icon(image);
		} catch (Exception e) {
			return null;
		}
	}
	public static icon icon(String filename) {
		try {
			return new icon(filename);
		} catch (Exception e) {
			return null;
		}
	}
	public static icon icon(String urlString, boolean isUrl) {
		try {
			return new icon(urlString, isUrl);
		} catch (Exception e) {
			return null;
		}
	}
	public static icon icon(URL urlObject) {
		try {
			return new icon(urlObject);
		} catch (Exception e) {
			return null;
		}
	}
	public static icon naiIcon() {
		return new icon();
	}
	public static icon naiIcon(byte[] imageData) {
		return new icon(imageData);
	}
	public static icon naiIcon(Image image) {
		try {
			return new icon(image);
		} catch (Exception e) {
			return null;
		}
	}
	public static icon naiIcon(String filename) {
		try {
			return new icon(filename);
		} catch (Exception e) {
			return null;
		}
	}
	public static icon naiIcon(String urlString, boolean isUrl) {
		try {
			return new icon(urlString, isUrl);
		} catch (Exception e) {
			return null;
		}
	}
	public static icon naiIcon(URL urlObject) {
		try {
			return new icon(urlObject);
		} catch (Exception e) {
			return null;
		}
	}
	public static image image() {
		return new image();
	}
	public static image image(byte[] imageData) {
		return new image(imageData);
	}
	public static image image(Image image) {
		try {
			return new image(image);
		} catch (Exception e) {
			return null;
		}
	}
	public static image image(String filename) {
		try {
			return new image(filename);
		} catch (Exception e) {
			return null;
		}
	}
	public static image image(String urlString, boolean isUrl) {
		try {
			return new image(urlString, isUrl);
		} catch (Exception e) {
			return null;
		}
	}
	public static image image(URL urlObject) {
		try {
			return new image(urlObject);
		} catch (Exception e) {
			return null;
		}
	}
	public static image naiImage() {
		return new image();
	}
	public static image naiImage(byte[] imageData) {
		return new image(imageData);
	}
	public static image naiImage(Image image) {
		try {
			return new image(image);
		} catch (Exception e) {
			return null;
		}
	}
	public static image naiImage(String filename) {
		try {
			return new image(filename);
		} catch (Exception e) {
			return null;
		}
	}
	public static image naiImage(String urlString, boolean isUrl) {
		try {
			return new image(urlString, isUrl);
		} catch (Exception e) {
			return null;
		}
	}
	public static image naiImage(URL urlObject) {
		try {
			return new image(urlObject);
		} catch (Exception e) {
			return null;
		}
	}
	public static img img() {
		return new img();
	}
	public static img img(byte[] imageData) {
		return new img(imageData);
	}
	public static img img(Image image) {
		try {
			return new img(image);
		} catch (Exception e) {
			return null;
		}
	}
	public static img img(String filename) {
		try {
			return new img(filename);
		} catch (Exception e) {
			return null;
		}
	}
	public static img img(String urlString, boolean isUrl) {
		try {
			return new img(urlString, isUrl);
		} catch (Exception e) {
			return null;
		}
	}
	public static img img(URL urlObject) {
		try {
			return new img(urlObject);
		} catch (Exception e) {
			return null;
		}
	}
	public static img naiImg() {
		return new img();
	}
	public static img naiImg(byte[] imageData) {
		return new img(imageData);
	}
	public static img naiImg(Image image) {
		try {
			return new img(image);
		} catch (Exception e) {
			return null;
		}
	}
	public static img naiImg(String filename) {
		try {
			return new img(filename);
		} catch (Exception e) {
			return null;
		}
	}
	public static img naiImg(String urlString, boolean isUrl) {
		try {
			return new img(urlString, isUrl);
		} catch (Exception e) {
			return null;
		}
	}
	public static img naiImg(URL urlObject) {
		try {
			return new img(urlObject);
		} catch (Exception e) {
			return null;
		}
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
		if (len == 8 || len == 4)
			return new clr(hexString, true);
		return new clr(hexString, false);
		/*
		 * @params all in the hex range: (0x|#)?000 thru (0x|#)?ffffffff
		 */
	}
	public static clr nayaClr(int rgb) {
		return new clr(rgb);
	}
	public static clr nayaClr(int rgb, boolean includesAlphaAtEnd) {
		return new clr(rgb, includesAlphaAtEnd);
	}
	public static clr nayaClr(int r, int g, int b) {
		return new clr(r, g, b);
	}
	public static clr nayaClr(int r, int g, int b, int a) {
		return new clr(r, g, b, a);
		/*
		 * @params all in the integer range: 0 to 255
		 */
	}
	public static clr nayaClr(double r, double g, double b) {
		return new clr(r, g, b);
	}
	public static clr nayaClr(double r, double g, double b, double a) {
		return new clr(r, g, b, a);
		/*
		 * @params all in the floating range: 0 to 1
		 */
	}
	public static clr nayaClr(String hexString) {
		hexString = hexString.replaceAll("^(0x|#)", "");
		int len = len(hexString);
		if (len == 8 || len == 4)
			return new clr(hexString, true);
		return new clr(hexString, false);
		/*
		 * @params all in the hex range: (0x|#)?000 thru (0x|#)?ffffffff
		 */
	}
	public static gui gui() {
		return new gui();
	}
	public static gui gui(String t) {
		return new gui(t);
	}
	public static gui gui(String t, int w, int h) {
		return new gui(t, w, h);
	}
	public static gui nayaGUI() {
		return new gui();
	}
	public static gui nayaGUI(String t) {
		return new gui(t);
	}
	public static gui nayaGUI(String t, int w, int h) {
		return new gui(t, w, h);
	}
	public static btn btn() {
		return new btn();
	}
	public static btn btn(String txt) {
		return new btn(txt);
	}
	public static btn btn(String txt, ActionListener actionOnClick) {
		return new btn(txt, actionOnClick);
	}
	public static btn btn(Action a) {
		return new btn(a);
	}
	public static btn btn(Icon i) {
		return new btn(i);
	}
	public static btn btn(String text, Icon i) {
		return new btn(text, i);
	}
	public static btn nayaBtn() {
		return new btn();
	}
	public static btn nayaBtn(String txt) {
		return new btn(txt);
	}
	public static btn nayaBtn(String txt, ActionListener actionOnClick) {
		return new btn(txt, actionOnClick);
	}
	public static btn nayaBtn(Action a) {
		return new btn(a);
	}
	public static btn nayaBtn(Icon i) {
		return new btn(i);
	}
	public static btn nayaBtn(String text, Icon i) {
		return new btn(text, i);
	}
	public static URL url(String address) {
		try {
			return URI.create(address).toURL();
		} catch (IllegalArgumentException | IOException e) {
			print("[KL.Exception.MalformedURL]\nBad URL!");
		}
		return null;
	}
	public static URL URL(String address) {
		return url(address);
	}
	// general
	public static final class objS extends HashMap<String, String> {
		objS() {
			super();
		}
		objS(String k1, String v1, String k2, String v2, String k3, String v3,
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
		objS(String k1, String v1, String k2, String v2, String k3, String v3,
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
		objS(String k1, String v1, String k2, String v2, String k3, String v3,
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
		objS(String k1, String v1, String k2, String v2, String k3, String v3,
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
		objS(String k1, String v1, String k2, String v2, String k3, String v3,
				String k4, String v4, String k5, String v5, String k6,
				String v6) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
			super.put(k6, v6);
		}
		objS(String k1, String v1, String k2, String v2, String k3, String v3,
				String k4, String v4, String k5, String v5) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
		}
		objS(String k1, String v1, String k2, String v2, String k3, String v3,
				String k4, String v4) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
		}
		objS(String k1, String v1, String k2, String v2, String k3, String v3) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
		}
		objS(String k1, String v1, String k2, String v2) {
			super.put(k1, v1);
			super.put(k2, v2);
		}
		objS(String k1, String v1) {
			super.put(k1, v1);
		}
		objS copy() {
			return (objS) super.clone();
		}
		objS slice() {
			return copy();
		}
		String random() {
			if (super.isEmpty())
				return "";
			return i(randInt(length()));
		}
		String rand() {
			return random();
		}
		String any() {
			return random();
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
		boolean has(String o) {
			return hasKey(o) || hasValue(o);
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
			if (n >= 0 && n < length())
				return keyArray()[n];
			else if (n < 0) {
				// Shorter than 0, huh? Let's posi-tize the number, and see if
				// it's under the size of the array. If it is, we'll try and
				// fetch the elements in reverse order
				n = Pos(n);
				if (n <= length())
					return nthLastKey(n);
			}
			return "";
		}
		String nthValue(int n) {
			if (n >= 0 && n < length())
				return array()[n];
			else if (n < 0) {
				// Shorter than 0, huh? Let's posi-tize the number, and see if
				// it's under the size of the array. If it is, we'll try and
				// fetch the elements in reverse order
				n = Pos(n);
				if (n <= length())
					return nthLastValue(n);
			}
			return "";
		}
		String nthLastKey(int n) {
			return n > 0 && n <= length() ? keyArray()[length() - n] : "";
			// resolved bugfix: some changes helped avoid an index-out-of-bound
			// exception
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
		objS set(String k, String v) {
			if (!super.containsKey(k))
				super.put(k, v);
			else
				super.replace(k, v);
			return this;
		}
		objS add(String k, String v) {
			set(k, v);
			return this;
		}
		String delete(String k) {
			String v = hasKey(k) ? super.get(k) : null;
			super.remove(k);
			return v;
		}
		objS push(String k, String v) {
			add(k, v);
			return this;
		}
		String pop(String k) {
			return delete(k);
		}
		objS update(String k, String v) {
			set(k, v);
			return this;
		}
		Set<String> keys() {
			return super.keySet();
		}
		Set<Map.Entry<String, String>> entries() {
			return super.entrySet();
		}
		boolean compare(objS arrB) {
			int oldLen = length(), newLen = intersection(arrB).length();
			return newLen > oldLen / 2;
		}
		objS intersection(objS other) {
			if (other == null) {
				return new objS();
			}
			objS result = new objS();
			for (String key : super.keySet()) {
				if (other.containsKey(key)
						&& other.get(key).equals(super.get(key))) {
					result.put(key, super.get(key));
				}
			}
			return result;
		}
		objS negativeIntersection(objS other) {
			if (other == null) {
				return copy();
			}
			objS result = copy();
			result.keySet().removeAll(other.intersection(copy()).keySet());
			return result;
		}
		objS keyIntersection(objS other) {
			if (other == null) {
				return new objS();
			}
			objS result = new objS();
			for (String key : super.keySet()) {
				if (other.containsKey(key)) {
					result.put(key, super.get(key));
				}
			}
			return result;
		}
		objS negativeKeyIntersection(objS other) {
			if (other == null) {
				return copy();
			}
			objS result = copy();
			result.keySet().removeAll(other.keySet());
			return result;
		}
		objS valueIntersection(objS other) {
			if (other == null) {
				return new objS();
			}
			objS result = new objS();
			for (String key1 : super.keySet()) {
				for (String key2 : other.keySet()) {
					if (super.get(key1).equals(other.get(key2))) {
						result.put(key1, super.get(key1));
					}
				}
			}
			return result;
		}
		objS negativeValueIntersection(objS other) {
			if (other == null) {
				return copy();
			}
			objS result = copy();
			result.entrySet()
					.removeIf(entry -> other.containsValue(entry.getValue()));
			return result;
		}
		objS slice(int start) {
			if (super.isEmpty()) {
				return new objS();
			}
			if (start < 0) {
				start = 0;
			}
			if (start >= super.size()) {
				return new objS();
			}
			objS subMap = new objS();
			int index = 0;
			for (String key : super.keySet()) {
				if (index >= start) {
					subMap.put(key, super.get(key));
				}
				index++;
			}
			return subMap;
		}
		objS slice(int start, int end) {
			if (super.isEmpty()) {
				return new objS();
			}
			if (start < 0) {
				start = 0;
			}
			if (end > super.size()) {
				end = super.size();
			}
			if (start > end) {
				int temp = start;
				start = end;
				end = temp;
			}
			objS subMap = new objS();
			int index = 0;
			for (String key : super.keySet()) {
				if (index >= start && index < end) {
					subMap.put(key, super.get(key));
				}
				index++;
			}
			return subMap;
		}
		objS sliceKeep(int end) {
			if (super.isEmpty()) {
				return new objS();
			}
			if (not(end) || isNeg(end)) {
				return new objS();
			}
			if (end > super.size()) {
				end = super.size();
			}
			objS subMap = new objS();
			int index = 0;
			for (String key : super.keySet()) {
				if (index < end) {
					subMap.put(key, super.get(key));
				}
				index++;
			}
			return subMap;
		}
		objS sliceEnd(int earlyEnd) {
			if (super.isEmpty() || earlyEnd <= 0 || earlyEnd > super.size()) {
				if (earlyEnd <= 0) {
					return (objS) super.clone();
				} else {
					return new objS();
				}
			}
			int start = super.size() - earlyEnd;
			objS subMap = new objS();
			int index = 0;
			for (String key : super.keySet()) {
				if (index >= start) {
					subMap.put(key, super.get(key));
				}
				index++;
			}
			return subMap;
		}
		objS mapIfPresent(String key, Function<String, String> fn) {
			if (not(fn))
				return this;
			super.computeIfPresent(key, (k, v) -> fn.apply(v));
			return this;
		}
		objS mapIfPresent(String key,
				BiFunction<? super String, ? super String, ? extends String> fn) {
			if (not(fn))
				return this;
			super.computeIfPresent(key, fn);
			return this;
		}
		objS map(String value, Function<String, String> fn) {
			if (!super.containsValue(value) || isNull(value) || fn == null) {
				return this;
			}
			for (String key : this.keySet()) {
				if (this.get(key).equals(value)) {
					String newValue = fn.apply(this.get(key));
					if (isNull(newValue)) {
						this.remove(key);
					} else {
						this.put(key, newValue);
					}
				}
			}
			return this;
		}
		objS mapKey(String key, Function<String, String> fn) {
			if (key == null || fn == null || !this.containsKey(key)) {
				return this;
			}
			String newKey = fn.apply(key);
			if (newKey == null) {
				this.remove(key);
			} else if (!newKey.equals(key)) {
				this.put(newKey, this.remove(key));
			}
			return this;
		}
		objS mapKey(Function<String, String> fn) {
			HashMap<String, String> newMap = new HashMap<>();
			super.forEach((k, v) -> newMap.put(fn.apply(k), v));
			super.clear();
			super.putAll(newMap);
			return this;
		}
		objS map(Function<String, String> fn) {
			super.replaceAll((k, v) -> fn.apply(v));
			return this;
		}
		objS map(
				BiFunction<? super String, ? super String, ? extends String> fn) {
			super.replaceAll(fn);
			return this;
		}
		objS eachKey(Consumer<String> fn) {
			super.keySet().forEach(fn);
			return this;
		}
		objS each(Consumer<String> fn) {
			super.values().forEach(fn);
			return this;
		}
		objS each(BiConsumer<? super String, ? super String> fn) {
			super.forEach(fn);
			return this;
		}
		objS combine(objS... others) {
			if (not(others))
				return this;
			for (objS other : others) {
				if (not(other))
					continue;
				super.putAll(other);
			}
			return this;
		}
		objS union(objS... others) {
			combine(others);
			return this;
		}
		objS cat(objS... others) {
			combine(others);
			return this;
		}
		objS concat(objS... others) {
			combine(others);
			return this;
		}
		objS join(objS... others) {
			combine(others);
			return this;
		}
		String join() {
			return string();
		}
		String join(String s) {
			if (not(s) || not(length()))
				return string();
			return KL.join(array(), s);
		}
		String string() {
			return super.toString();
		}
		String str() {
			return string();
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
	public static objS objS(String k1, String v1, String k2, String v2,
			String k3, String v3, String k4, String v4, String k5, String v5,
			String k6, String v6, String k7, String v7, String k8, String v8,
			String k9, String v9, String k10, String v10) {
		return new objS(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8, k9, v9, k10, v10);
	}
	public static objS objS(String k1, String v1, String k2, String v2,
			String k3, String v3, String k4, String v4, String k5, String v5,
			String k6, String v6, String k7, String v7, String k8, String v8,
			String k9, String v9) {
		return new objS(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8, k9, v9);
	}
	public static objS objS(String k1, String v1, String k2, String v2,
			String k3, String v3, String k4, String v4, String k5, String v5,
			String k6, String v6, String k7, String v7, String k8, String v8) {
		return new objS(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8);
	}
	public static objS objS(String k1, String v1, String k2, String v2,
			String k3, String v3, String k4, String v4, String k5, String v5,
			String k6, String v6, String k7, String v7) {
		return new objS(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7);
	}
	public static objS objS(String k1, String v1, String k2, String v2,
			String k3, String v3, String k4, String v4, String k5, String v5,
			String k6, String v6) {
		return new objS(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
	}
	public static objS objS(String k1, String v1, String k2, String v2,
			String k3, String v3, String k4, String v4, String k5, String v5) {
		return new objS(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
	}
	public static objS objS(String k1, String v1, String k2, String v2,
			String k3, String v3, String k4, String v4) {
		return new objS(k1, v1, k2, v2, k3, v3, k4, v4);
	}
	public static objS objS(String k1, String v1, String k2, String v2,
			String k3, String v3) {
		return new objS(k1, v1, k2, v2, k3, v3);
	}
	public static objS objS(String k1, String v1, String k2, String v2) {
		return new objS(k1, v1, k2, v2);
	}
	public static objS objS(String k1, String v1) {
		return new objS(k1, v1);
	}
	public static final class objI extends HashMap<String, Integer> {
		objI() {
			super();
		}
		objI(String k1, Integer v1, String k2, Integer v2, String k3,
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
		objI(String k1, Integer v1, String k2, Integer v2, String k3,
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
		objI(String k1, Integer v1, String k2, Integer v2, String k3,
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
		objI(String k1, Integer v1, String k2, Integer v2, String k3,
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
		objI(String k1, Integer v1, String k2, Integer v2, String k3,
				Integer v3, String k4, Integer v4, String k5, Integer v5,
				String k6, Integer v6) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
			super.put(k6, v6);
		}
		objI(String k1, Integer v1, String k2, Integer v2, String k3,
				Integer v3, String k4, Integer v4, String k5, Integer v5) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
		}
		objI(String k1, Integer v1, String k2, Integer v2, String k3,
				Integer v3, String k4, Integer v4) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
		}
		objI(String k1, Integer v1, String k2, Integer v2, String k3,
				Integer v3) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
		}
		objI(String k1, Integer v1, String k2, Integer v2) {
			super.put(k1, v1);
			super.put(k2, v2);
		}
		objI(String k, Integer v) {
			super.put(k, v);
		}
		objI copy() {
			return (objI) super.clone();
		}
		objI slice() {
			return copy();
		}
		int random() {
			if (super.isEmpty())
				return 0;
			return i(randInt(length()));
		}
		int rand() {
			return random();
		}
		int any() {
			return random();
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
		boolean has(Object o) {
			if (o instanceof String)
				return hasKey((String) o);
			else if (o instanceof Integer)
				return hasValue((Integer) o);
			return false;
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
			if (n >= 0 && n < length())
				return keyArray()[n];
			else if (n < 0) {
				// Shorter than 0, huh? Let's posi-tize the number, and see if
				// it's under the size of the array. If it is, we'll try and
				// fetch the elements in reverse order
				n = Pos(n);
				if (n <= length())
					return nthLastKey(n);
			}
			return "";
		}
		int nthValue(int n) {
			if (n >= 0 && n < length())
				return array()[n];
			else if (n < 0) {
				// Shorter than 0, huh? Let's posi-tize the number, and see if
				// it's under the size of the array. If it is, we'll try and
				// fetch the elements in reverse order
				n = Pos(n);
				if (n <= length())
					return nthLastValue(n);
			}
			return 0;
		}
		String nthLastKey(int n) {
			return n > 0 && n <= length() ? keyArray()[length() - n] : "";
			// resolved bugfix: some changes helped avoid an index-out-of-bound
			// exception
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
		objI set(String k, Integer v) {
			if (!super.containsKey(k))
				super.put(k, v);
			else
				super.replace(k, v);
			return this;
		}
		objI add(String k, Integer v) {
			set(k, v);
			return this;
		}
		int delete(String k) {
			int v = hasKey(k) ? super.get(k) : null;
			super.remove(k);
			return v;
		}
		objI push(String k, int v) {
			add(k, v);
			return this;
		}
		int pop(String k) {
			return delete(k);
		}
		objI update(String k, Integer v) {
			set(k, v);
			return this;
		}
		Set<String> keys() {
			return super.keySet();
		}
		Set<Map.Entry<String, Integer>> entries() {
			return super.entrySet();
		}
		boolean compare(objI arrB) {
			int oldLen = length(), newLen = intersection(arrB).length();
			return newLen > oldLen / 2;
		}
		objI intersection(objI other) {
			if (other == null) {
				return new objI();
			}
			objI result = new objI();
			for (String key : super.keySet()) {
				if (other.containsKey(key)
						&& other.get(key).equals(super.get(key))) {
					result.put(key, super.get(key));
				}
			}
			return result;
		}
		objI negativeIntersection(objI other) {
			if (other == null) {
				return copy();
			}
			objI result = copy();
			result.keySet().removeAll(other.intersection(copy()).keySet());
			return result;
		}
		objI keyIntersection(objI other) {
			if (other == null) {
				return new objI();
			}
			objI result = new objI();
			for (String key : super.keySet()) {
				if (other.containsKey(key)) {
					result.put(key, super.get(key));
				}
			}
			return result;
		}
		objI negativeKeyIntersection(objI other) {
			if (other == null) {
				return copy();
			}
			objI result = copy();
			result.keySet().removeAll(other.keySet());
			return result;
		}
		objI valueIntersection(objI other) {
			if (other == null) {
				return new objI();
			}
			objI result = new objI();
			for (String key1 : super.keySet()) {
				for (String key2 : other.keySet()) {
					if (super.get(key1).equals(other.get(key2))) {
						result.put(key1, super.get(key1));
					}
				}
			}
			return result;
		}
		objI negativeValueIntersection(objI other) {
			if (other == null) {
				return copy();
			}
			objI result = copy();
			result.entrySet()
					.removeIf(entry -> other.containsValue(entry.getValue()));
			return result;
		}
		objI slice(int start) {
			if (super.isEmpty()) {
				return new objI();
			}
			if (start < 0) {
				start = 0;
			}
			if (start >= super.size()) {
				return new objI();
			}
			objI subMap = new objI();
			int index = 0;
			for (String key : super.keySet()) {
				if (index >= start) {
					subMap.put(key, super.get(key));
				}
				index++;
			}
			return subMap;
		}
		objI slice(int start, int end) {
			if (super.isEmpty()) {
				return new objI();
			}
			if (start < 0) {
				start = 0;
			}
			if (end > super.size()) {
				end = super.size();
			}
			if (start > end) {
				int temp = start;
				start = end;
				end = temp;
			}
			objI subMap = new objI();
			int index = 0;
			for (String key : super.keySet()) {
				if (index >= start && index < end) {
					subMap.put(key, super.get(key));
				}
				index++;
			}
			return subMap;
		}
		objI sliceKeep(int end) {
			if (super.isEmpty()) {
				return new objI();
			}
			if (not(end) || isNeg(end)) {
				return new objI();
			}
			if (end > super.size()) {
				end = super.size();
			}
			objI subMap = new objI();
			int index = 0;
			for (String key : super.keySet()) {
				if (index < end) {
					subMap.put(key, super.get(key));
				}
				index++;
			}
			return subMap;
		}
		objI sliceEnd(int earlyEnd) {
			if (super.isEmpty() || earlyEnd <= 0 || earlyEnd > super.size()) {
				if (earlyEnd <= 0) {
					return (objI) super.clone();
				} else {
					return new objI();
				}
			}
			int start = super.size() - earlyEnd;
			objI subMap = new objI();
			int index = 0;
			for (String key : super.keySet()) {
				if (index >= start) {
					subMap.put(key, super.get(key));
				}
				index++;
			}
			return subMap;
		}
		objI mapIfPresent(String key, Function<Integer, Integer> fn) {
			if (not(fn))
				return this;
			super.computeIfPresent(key, (k, v) -> fn.apply(v));
			return this;
		}
		objI mapIfPresent(int value, Function<Integer, Integer> fn) {
			return map(value, fn);
		}
		objI mapIfPresent(String key,
				BiFunction<? super String, ? super Integer, ? extends Integer> fn) {
			if (not(fn))
				return this;
			super.computeIfPresent(key, fn);
			return this;
		}
		objI map(int value, Function<Integer, Integer> fn) {
			if (!super.containsValue(value) || isNull(value) || fn == null) {
				return this;
			}
			for (String key : this.keySet()) {
				if (this.get(key).equals(value)) {
					int newValue = fn.apply(this.get(key));
					if (isNull(newValue)) {
						this.remove(key);
					} else {
						this.put(key, newValue);
					}
				}
			}
			return this;
		}
		objI mapKey(String key, Function<String, String> fn) {
			if (key == null || fn == null || !this.containsKey(key)) {
				return this;
			}
			String newKey = fn.apply(key);
			if (newKey == null) {
				this.remove(key);
			} else if (!newKey.equals(key)) {
				this.put(newKey, this.remove(key));
			}
			return this;
		}
		objI mapKey(Function<String, String> fn) {
			HashMap<String, Integer> newMap = new HashMap<>();
			super.forEach((k, v) -> newMap.put(fn.apply(k), v));
			super.clear();
			super.putAll(newMap);
			return this;
		}
		objI map(Function<Integer, Integer> fn) {
			super.replaceAll((k, v) -> fn.apply(v));
			return this;
		}
		objI map(
				BiFunction<? super String, ? super Integer, ? extends Integer> fn) {
			super.replaceAll(fn);
			return this;
		}
		objI eachKey(Consumer<String> fn) {
			super.keySet().forEach(fn);
			return this;
		}
		objI each(Consumer<Integer> fn) {
			super.values().forEach(fn);
			return this;
		}
		objI each(BiConsumer<? super String, ? super Integer> fn) {
			super.forEach(fn);
			return this;
		}
		objI combine(objI... others) {
			if (not(others))
				return this;
			for (objI other : others) {
				if (not(other))
					continue;
				super.putAll(other);
			}
			return this;
		}
		objI union(objI... others) {
			combine(others);
			return this;
		}
		objI cat(objI... others) {
			combine(others);
			return this;
		}
		objI concat(objI... others) {
			combine(others);
			return this;
		}
		objI join(objI... others) {
			combine(others);
			return this;
		}
		String join() {
			return string();
		}
		String join(String s) {
			if (not(s) || not(length()))
				return string();
			return KL.join(array(), s);
		}
		String string() {
			return super.toString();
		}
		String str() {
			return string();
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
	public static objI objI(String k1, int v1, String k2, int v2, String k3,
			int v3, String k4, int v4, String k5, int v5, String k6, int v6,
			String k7, int v7, String k8, int v8, String k9, int v9, String k10,
			int v10) {
		return new objI(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8, k9, v9, k10, v10);
	}
	public static objI objI(String k1, int v1, String k2, int v2, String k3,
			int v3, String k4, int v4, String k5, int v5, String k6, int v6,
			String k7, int v7, String k8, int v8, String k9, int v9) {
		return new objI(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8, k9, v9);
	}
	public static objI objI(String k1, int v1, String k2, int v2, String k3,
			int v3, String k4, int v4, String k5, int v5, String k6, int v6,
			String k7, int v7, String k8, int v8) {
		return new objI(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8);
	}
	public static objI objI(String k1, int v1, String k2, int v2, String k3,
			int v3, String k4, int v4, String k5, int v5, String k6, int v6,
			String k7, int v7) {
		return new objI(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7);
	}
	public static objI objI(String k1, int v1, String k2, int v2, String k3,
			int v3, String k4, int v4, String k5, int v5, String k6, int v6) {
		return new objI(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
	}
	public static objI objI(String k1, int v1, String k2, int v2, String k3,
			int v3, String k4, int v4, String k5, int v5) {
		return new objI(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
	}
	public static objI objI(String k1, int v1, String k2, int v2, String k3,
			int v3, String k4, int v4) {
		return new objI(k1, v1, k2, v2, k3, v3, k4, v4);
	}
	public static objI objI(String k1, int v1, String k2, int v2, String k3,
			int v3) {
		return new objI(k1, v1, k2, v2, k3, v3);
	}
	public static objI objI(String k1, int v1, String k2, int v2) {
		return new objI(k1, v1, k2, v2);
	}
	public static objI objI(String k1, int v1) {
		return new objI(k1, v1);
	}
	public static final class objL extends HashMap<String, Long> {
		objL() {
			super();
		}
		objL(String k1, Long v1, String k2, Long v2, String k3, Long v3,
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
		objL(String k1, Long v1, String k2, Long v2, String k3, Long v3,
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
		objL(String k1, Long v1, String k2, Long v2, String k3, Long v3,
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
		objL(String k1, Long v1, String k2, Long v2, String k3, Long v3,
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
		objL(String k1, Long v1, String k2, Long v2, String k3, Long v3,
				String k4, Long v4, String k5, Long v5, String k6, Long v6) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
			super.put(k6, v6);
		}
		objL(String k1, Long v1, String k2, Long v2, String k3, Long v3,
				String k4, Long v4, String k5, Long v5) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
		}
		objL(String k1, Long v1, String k2, Long v2, String k3, Long v3,
				String k4, Long v4) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
		}
		objL(String k1, Long v1, String k2, Long v2, String k3, Long v3) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
		}
		objL(String k1, Long v1, String k2, Long v2) {
			super.put(k1, v1);
			super.put(k2, v2);
		}
		objL(String k, Long v) {
			super.put(k, v);
		}
		objL copy() {
			return (objL) super.clone();
		}
		objL slice() {
			return copy();
		}
		long random() {
			if (super.isEmpty())
				return 0;
			return i(randInt(length()));
		}
		long rand() {
			return random();
		}
		long any() {
			return random();
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
			if (n >= 0 && n < length())
				return keyArray()[n];
			else if (n < 0) {
				// Shorter than 0, huh? Let's posi-tize the number, and see if
				// it's under the size of the array. If it is, we'll try and
				// fetch the elements in reverse order
				n = Pos(n);
				if (n <= length())
					return nthLastKey(n);
			}
			return "";
		}
		long nthValue(int n) {
			if (n >= 0 && n < length())
				return array()[n];
			else if (n < 0) {
				// Shorter than 0, huh? Let's posi-tize the number, and see if
				// it's under the size of the array. If it is, we'll try and
				// fetch the elements in reverse order
				n = Pos(n);
				if (n <= length())
					return nthLastValue(n);
			}
			return 0;
		}
		String nthLastKey(int n) {
			return n > 0 && n <= length() ? keyArray()[length() - n] : "";
			// resolved bugfix: some changes helped avoid an index-out-of-bound
			// exception
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
		boolean has(Object o) {
			if (o instanceof String)
				return hasKey((String) o);
			else if (o instanceof Long)
				return hasValue((Long) o);
			return false;
		}
		objL set(String k, Long v) {
			if (!super.containsKey(k))
				super.put(k, v);
			else
				super.replace(k, v);
			return this;
		}
		objL add(String k, Long v) {
			set(k, v);
			return this;
		}
		long delete(String k) {
			return super.remove(k);
		}
		objL push(String k, long v) {
			add(k, v);
			return this;
		}
		long pop(String k) {
			return delete(k);
		}
		objL update(String k, Long v) {
			set(k, v);
			return this;
		}
		Set<String> keys() {
			return super.keySet();
		}
		Set<Map.Entry<String, Long>> entries() {
			return super.entrySet();
		}
		boolean compare(objL arrB) {
			int oldLen = length(), newLen = intersection(arrB).length();
			return newLen > oldLen / 2;
		}
		objL intersection(objL other) {
			if (other == null) {
				return new objL();
			}
			objL result = new objL();
			for (String key : super.keySet()) {
				if (other.containsKey(key)
						&& other.get(key).equals(super.get(key))) {
					result.put(key, super.get(key));
				}
			}
			return result;
		}
		objL negativeIntersection(objL other) {
			if (other == null) {
				return copy();
			}
			objL result = copy();
			result.keySet().removeAll(other.intersection(copy()).keySet());
			return result;
		}
		objL keyIntersection(objL other) {
			if (other == null) {
				return new objL();
			}
			objL result = new objL();
			for (String key : super.keySet()) {
				if (other.containsKey(key)) {
					result.put(key, super.get(key));
				}
			}
			return result;
		}
		objL negativeKeyIntersection(objL other) {
			if (other == null) {
				return copy();
			}
			objL result = copy();
			result.keySet().removeAll(other.keySet());
			return result;
		}
		objL valueIntersection(objL other) {
			if (other == null) {
				return new objL();
			}
			objL result = new objL();
			for (String key1 : super.keySet()) {
				for (String key2 : other.keySet()) {
					if (super.get(key1).equals(other.get(key2))) {
						result.put(key1, super.get(key1));
					}
				}
			}
			return result;
		}
		objL negativeValueIntersection(objL other) {
			if (other == null) {
				return copy();
			}
			objL result = copy();
			result.entrySet()
					.removeIf(entry -> other.containsValue(entry.getValue()));
			return result;
		}
		objL slice(int start) {
			if (super.isEmpty()) {
				return new objL();
			}
			if (start < 0) {
				start = 0;
			}
			if (start >= super.size()) {
				return new objL();
			}
			objL subMap = new objL();
			int index = 0;
			for (String key : super.keySet()) {
				if (index >= start) {
					subMap.put(key, super.get(key));
				}
				index++;
			}
			return subMap;
		}
		objL slice(int start, int end) {
			if (super.isEmpty()) {
				return new objL();
			}
			if (start < 0) {
				start = 0;
			}
			if (end > super.size()) {
				end = super.size();
			}
			if (start > end) {
				int temp = start;
				start = end;
				end = temp;
			}
			objL subMap = new objL();
			int index = 0;
			for (String key : super.keySet()) {
				if (index >= start && index < end) {
					subMap.put(key, super.get(key));
				}
				index++;
			}
			return subMap;
		}
		objL sliceKeep(int end) {
			if (super.isEmpty()) {
				return new objL();
			}
			if (not(end) || isNeg(end)) {
				return new objL();
			}
			if (end > super.size()) {
				end = super.size();
			}
			objL subMap = new objL();
			int index = 0;
			for (String key : super.keySet()) {
				if (index < end) {
					subMap.put(key, super.get(key));
				}
				index++;
			}
			return subMap;
		}
		objL sliceEnd(int earlyEnd) {
			if (super.isEmpty() || earlyEnd <= 0 || earlyEnd > super.size()) {
				if (earlyEnd <= 0) {
					return (objL) super.clone();
				} else {
					return new objL();
				}
			}
			int start = super.size() - earlyEnd;
			objL subMap = new objL();
			int index = 0;
			for (String key : super.keySet()) {
				if (index >= start) {
					subMap.put(key, super.get(key));
				}
				index++;
			}
			return subMap;
		}
		objL mapIfPresent(String key, Function<Long, Long> fn) {
			if (not(fn))
				return this;
			super.computeIfPresent(key, (k, v) -> fn.apply(v));
			return this;
		}
		objL mapIfPresent(long value, Function<Long, Long> fn) {
			return map(value, fn);
		}
		objL mapIfPresent(String key,
				BiFunction<? super String, ? super Long, ? extends Long> fn) {
			if (not(fn))
				return this;
			super.computeIfPresent(key, fn);
			return this;
		}
		objL map(long value, Function<Long, Long> fn) {
			if (!super.containsValue(value) || isNull(value) || fn == null) {
				return this;
			}
			for (String key : this.keySet()) {
				if (this.get(key).equals(value)) {
					long newValue = fn.apply(this.get(key));
					if (isNull(newValue)) {
						this.remove(key);
					} else {
						this.put(key, newValue);
					}
				}
			}
			return this;
		}
		objL mapKey(String key, Function<String, String> fn) {
			if (key == null || fn == null || !this.containsKey(key)) {
				return this;
			}
			String newKey = fn.apply(key);
			if (newKey == null) {
				this.remove(key);
			} else if (!newKey.equals(key)) {
				this.put(newKey, this.remove(key));
			}
			return this;
		}
		objL mapKey(Function<String, String> fn) {
			HashMap<String, Long> newMap = new HashMap<>();
			super.forEach((k, v) -> newMap.put(fn.apply(k), v));
			super.clear();
			super.putAll(newMap);
			return this;
		}
		objL map(Function<Long, Long> fn) {
			super.replaceAll((k, v) -> fn.apply(v));
			return this;
		}
		objL map(BiFunction<? super String, ? super Long, ? extends Long> fn) {
			super.replaceAll(fn);
			return this;
		}
		objL eachKey(Consumer<String> fn) {
			super.keySet().forEach(fn);
			return this;
		}
		objL each(Consumer<Long> fn) {
			super.values().forEach(fn);
			return this;
		}
		objL each(BiConsumer<? super String, ? super Long> fn) {
			super.forEach(fn);
			return this;
		}
		objL combine(objL... others) {
			if (not(others))
				return this;
			for (objL other : others) {
				if (not(other))
					continue;
				super.putAll(other);
			}
			return this;
		}
		objL union(objL... others) {
			combine(others);
			return this;
		}
		objL cat(objL... others) {
			combine(others);
			return this;
		}
		objL concat(objL... others) {
			combine(others);
			return this;
		}
		objL join(objL... others) {
			combine(others);
			return this;
		}
		String join() {
			return string();
		}
		String join(String s) {
			if (not(s) || not(length()))
				return string();
			return KL.join(array(), s);
		}
		String string() {
			return super.toString();
		}
		String str() {
			return string();
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
	public static objL objL(String k1, long v1, String k2, long v2, String k3,
			long v3, String k4, long v4, String k5, long v5, String k6, long v6,
			String k7, long v7, String k8, long v8, String k9, long v9,
			String k10, long v10) {
		return new objL(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8, k9, v9, k10, v10);
	}
	public static objL objL(String k1, long v1, String k2, long v2, String k3,
			long v3, String k4, long v4, String k5, long v5, String k6, long v6,
			String k7, long v7, String k8, long v8, String k9, long v9) {
		return new objL(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8, k9, v9);
	}
	public static objL objL(String k1, long v1, String k2, long v2, String k3,
			long v3, String k4, long v4, String k5, long v5, String k6, long v6,
			String k7, long v7, String k8, long v8) {
		return new objL(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8);
	}
	public static objL objL(String k1, long v1, String k2, long v2, String k3,
			long v3, String k4, long v4, String k5, long v5, String k6, long v6,
			String k7, long v7) {
		return new objL(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7);
	}
	public static objL objL(String k1, long v1, String k2, long v2, String k3,
			long v3, String k4, long v4, String k5, long v5, String k6,
			long v6) {
		return new objL(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
	}
	public static objL objL(String k1, long v1, String k2, long v2, String k3,
			long v3, String k4, long v4, String k5, long v5) {
		return new objL(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
	}
	public static objL objL(String k1, long v1, String k2, long v2, String k3,
			long v3, String k4, long v4) {
		return new objL(k1, v1, k2, v2, k3, v3, k4, v4);
	}
	public static objL objL(String k1, long v1, String k2, long v2, String k3,
			long v3) {
		return new objL(k1, v1, k2, v2, k3, v3);
	}
	public static objL objL(String k1, long v1, String k2, long v2) {
		return new objL(k1, v1, k2, v2);
	}
	public static objL objL(String k1, long v1) {
		return new objL(k1, v1);
	}
	public static final class objF extends HashMap<String, Float> {
		objF() {
			super();
		}
		objF(String k1, Float v1, String k2, Float v2, String k3, Float v3,
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
		objF(String k1, Float v1, String k2, Float v2, String k3, Float v3,
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
		objF(String k1, Float v1, String k2, Float v2, String k3, Float v3,
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
		objF(String k1, Float v1, String k2, Float v2, String k3, Float v3,
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
		objF(String k1, Float v1, String k2, Float v2, String k3, Float v3,
				String k4, Float v4, String k5, Float v5, String k6, Float v6) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
			super.put(k6, v6);
		}
		objF(String k1, Float v1, String k2, Float v2, String k3, Float v3,
				String k4, Float v4, String k5, Float v5) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
		}
		objF(String k1, Float v1, String k2, Float v2, String k3, Float v3,
				String k4, Float v4) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
		}
		objF(String k1, Float v1, String k2, Float v2, String k3, Float v3) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
		}
		objF(String k1, Float v1, String k2, Float v2) {
			super.put(k1, v1);
			super.put(k2, v2);
		}
		objF(String k1, Float v1) {
			super.put(k1, v1);
		}
		objF copy() {
			return (objF) super.clone();
		}
		objF slice() {
			return copy();
		}
		float random() {
			if (super.isEmpty())
				return 0;
			return i(randInt(length()));
		}
		float rand() {
			return random();
		}
		float any() {
			return random();
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
			if (n >= 0 && n < length())
				return keyArray()[n];
			else if (n < 0) {
				// Shorter than 0, huh? Let's posi-tize the number, and see if
				// it's under the size of the array. If it is, we'll try and
				// fetch the elements in reverse order
				n = Pos(n);
				if (n <= length())
					return nthLastKey(n);
			}
			return "";
		}
		float nthValue(int n) {
			if (n >= 0 && n < length())
				return array()[n];
			else if (n < 0) {
				// Shorter than 0, huh? Let's posi-tize the number, and see if
				// it's under the size of the array. If it is, we'll try and
				// fetch the elements in reverse order
				n = Pos(n);
				if (n <= length())
					return nthLastValue(n);
			}
			return 0;
		}
		String nthLastKey(int n) {
			return n > 0 && n <= length() ? keyArray()[length() - n] : "";
			// resolved bugfix: some changes helped avoid an index-out-of-bound
			// exception
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
		boolean has(Object o) {
			if (o instanceof String)
				return hasKey((String) o);
			else if (o instanceof Float)
				return hasValue((Float) o);
			return false;
		}
		objF set(String k, Float v) {
			if (!super.containsKey(k))
				super.put(k, v);
			else
				super.replace(k, v);
			return this;
		}
		objF add(String k, Float v) {
			set(k, v);
			return this;
		}
		float delete(String k) {
			return super.remove(k);
		}
		objF push(String k, float v) {
			add(k, v);
			return this;
		}
		float pop(String k) {
			return delete(k);
		}
		objF update(String k, Float v) {
			set(k, v);
			return this;
		}
		Set<String> keys() {
			return super.keySet();
		}
		Set<Map.Entry<String, Float>> entries() {
			return super.entrySet();
		}
		boolean compare(objF arrB) {
			int oldLen = length(), newLen = intersection(arrB).length();
			return newLen > oldLen / 2;
		}
		objF intersection(objF other) {
			if (other == null) {
				return new objF();
			}
			objF result = new objF();
			for (String key : super.keySet()) {
				if (other.containsKey(key)
						&& other.get(key).equals(super.get(key))) {
					result.put(key, super.get(key));
				}
			}
			return result;
		}
		objF negativeIntersection(objF other) {
			if (other == null) {
				return copy();
			}
			objF result = copy();
			result.keySet().removeAll(other.intersection(copy()).keySet());
			return result;
		}
		objF keyIntersection(objF other) {
			if (other == null) {
				return new objF();
			}
			objF result = new objF();
			for (String key : super.keySet()) {
				if (other.containsKey(key)) {
					result.put(key, super.get(key));
				}
			}
			return result;
		}
		objF negativeKeyIntersection(objF other) {
			if (other == null) {
				return copy();
			}
			objF result = copy();
			result.keySet().removeAll(other.keySet());
			return result;
		}
		objF valueIntersection(objF other) {
			if (other == null) {
				return new objF();
			}
			objF result = new objF();
			for (String key1 : super.keySet()) {
				for (String key2 : other.keySet()) {
					if (super.get(key1).equals(other.get(key2))) {
						result.put(key1, super.get(key1));
					}
				}
			}
			return result;
		}
		objF negativeValueIntersection(objF other) {
			if (other == null) {
				return copy();
			}
			objF result = copy();
			result.entrySet()
					.removeIf(entry -> other.containsValue(entry.getValue()));
			return result;
		}
		objF slice(int start) {
			if (super.isEmpty()) {
				return new objF();
			}
			if (start < 0) {
				start = 0;
			}
			if (start >= super.size()) {
				return new objF();
			}
			objF subMap = new objF();
			int index = 0;
			for (String key : super.keySet()) {
				if (index >= start) {
					subMap.put(key, super.get(key));
				}
				index++;
			}
			return subMap;
		}
		objF slice(int start, int end) {
			if (super.isEmpty()) {
				return new objF();
			}
			if (start < 0) {
				start = 0;
			}
			if (end > super.size()) {
				end = super.size();
			}
			if (start > end) {
				int temp = start;
				start = end;
				end = temp;
			}
			objF subMap = new objF();
			int index = 0;
			for (String key : super.keySet()) {
				if (index >= start && index < end) {
					subMap.put(key, super.get(key));
				}
				index++;
			}
			return subMap;
		}
		objF sliceKeep(int end) {
			if (super.isEmpty()) {
				return new objF();
			}
			if (not(end) || isNeg(end)) {
				return new objF();
			}
			if (end > super.size()) {
				end = super.size();
			}
			objF subMap = new objF();
			int index = 0;
			for (String key : super.keySet()) {
				if (index < end) {
					subMap.put(key, super.get(key));
				}
				index++;
			}
			return subMap;
		}
		objF sliceEnd(int earlyEnd) {
			if (super.isEmpty() || earlyEnd <= 0 || earlyEnd > super.size()) {
				if (earlyEnd <= 0) {
					return (objF) super.clone();
				} else {
					return new objF();
				}
			}
			int start = super.size() - earlyEnd;
			objF subMap = new objF();
			int index = 0;
			for (String key : super.keySet()) {
				if (index >= start) {
					subMap.put(key, super.get(key));
				}
				index++;
			}
			return subMap;
		}
		objF mapIfPresent(String key, Function<Float, Float> fn) {
			if (not(fn))
				return this;
			super.computeIfPresent(key, (k, v) -> fn.apply(v));
			return this;
		}
		objF mapIfPresent(float value, Function<Float, Float> fn) {
			return map(value, fn);
		}
		objF mapIfPresent(String key,
				BiFunction<? super String, ? super Float, ? extends Float> fn) {
			if (not(fn))
				return this;
			super.computeIfPresent(key, fn);
			return this;
		}
		objF map(float value, Function<Float, Float> fn) {
			if (!super.containsValue(value) || isNull(value) || fn == null) {
				return this;
			}
			for (String key : this.keySet()) {
				if (this.get(key).equals(value)) {
					float newValue = fn.apply(this.get(key));
					if (isNull(newValue)) {
						this.remove(key);
					} else {
						this.put(key, newValue);
					}
				}
			}
			return this;
		}
		objF mapKey(String key, Function<String, String> fn) {
			if (key == null || fn == null || !this.containsKey(key)) {
				return this;
			}
			String newKey = fn.apply(key);
			if (newKey == null) {
				this.remove(key);
			} else if (!newKey.equals(key)) {
				this.put(newKey, this.remove(key));
			}
			return this;
		}
		objF mapKey(Function<String, String> fn) {
			HashMap<String, Float> newMap = new HashMap<>();
			super.forEach((k, v) -> newMap.put(fn.apply(k), v));
			super.clear();
			super.putAll(newMap);
			return this;
		}
		objF map(Function<Float, Float> fn) {
			super.replaceAll((k, v) -> fn.apply(v));
			return this;
		}
		objF map(
				BiFunction<? super String, ? super Float, ? extends Float> fn) {
			super.replaceAll(fn);
			return this;
		}
		objF eachKey(Consumer<String> fn) {
			super.keySet().forEach(fn);
			return this;
		}
		objF each(Consumer<Float> fn) {
			super.values().forEach(fn);
			return this;
		}
		objF each(BiConsumer<? super String, ? super Float> fn) {
			super.forEach(fn);
			return this;
		}
		objF combine(objF... others) {
			if (not(others))
				return this;
			for (objF other : others) {
				if (not(other))
					continue;
				super.putAll(other);
			}
			return this;
		}
		objF union(objF... others) {
			combine(others);
			return this;
		}
		objF cat(objF... others) {
			combine(others);
			return this;
		}
		objF concat(objF... others) {
			combine(others);
			return this;
		}
		objF join(objF... others) {
			combine(others);
			return this;
		}
		String join() {
			return string();
		}
		String join(String s) {
			if (not(s) || not(length()))
				return string();
			return KL.join(array(), s);
		}
		String string() {
			return super.toString();
		}
		String str() {
			return string();
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
	public static objF objF(String k1, float v1, String k2, float v2, String k3,
			float v3, String k4, float v4, String k5, float v5, String k6,
			float v6, String k7, float v7, String k8, float v8, String k9,
			float v9, String k10, float v10) {
		return new objF(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8, k9, v9, k10, v10);
	}
	public static objF objF(String k1, float v1, String k2, float v2, String k3,
			float v3, String k4, float v4, String k5, float v5, String k6,
			float v6, String k7, float v7, String k8, float v8, String k9,
			float v9) {
		return new objF(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8, k9, v9);
	}
	public static objF objF(String k1, float v1, String k2, float v2, String k3,
			float v3, String k4, float v4, String k5, float v5, String k6,
			float v6, String k7, float v7, String k8, float v8) {
		return new objF(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8);
	}
	public static objF objF(String k1, float v1, String k2, float v2, String k3,
			float v3, String k4, float v4, String k5, float v5, String k6,
			float v6, String k7, float v7) {
		return new objF(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7);
	}
	public static objF objF(String k1, float v1, String k2, float v2, String k3,
			float v3, String k4, float v4, String k5, float v5, String k6,
			float v6) {
		return new objF(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
	}
	public static objF objF(String k1, float v1, String k2, float v2, String k3,
			float v3, String k4, float v4, String k5, float v5) {
		return new objF(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
	}
	public static objF objF(String k1, float v1, String k2, float v2, String k3,
			float v3, String k4, float v4) {
		return new objF(k1, v1, k2, v2, k3, v3, k4, v4);
	}
	public static objF objF(String k1, float v1, String k2, float v2, String k3,
			float v3) {
		return new objF(k1, v1, k2, v2, k3, v3);
	}
	public static objF objF(String k1, float v1, String k2, float v2) {
		return new objF(k1, v1, k2, v2);
	}
	public static objF objF(String k1, float v1) {
		return new objF(k1, v1);
	}
	public static final class objD extends HashMap<String, Double> {
		objD() {
			super();
		}
		objD(String k1, Double v1, String k2, Double v2, String k3, Double v3,
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
		objD(String k1, Double v1, String k2, Double v2, String k3, Double v3,
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
		objD(String k1, Double v1, String k2, Double v2, String k3, Double v3,
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
		objD(String k1, Double v1, String k2, Double v2, String k3, Double v3,
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
		objD(String k1, Double v1, String k2, Double v2, String k3, Double v3,
				String k4, Double v4, String k5, Double v5, String k6,
				Double v6) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
			super.put(k6, v6);
		}
		objD(String k1, Double v1, String k2, Double v2, String k3, Double v3,
				String k4, Double v4, String k5, Double v5) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
		}
		objD(String k1, Double v1, String k2, Double v2, String k3, Double v3,
				String k4, Double v4) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
		}
		objD(String k1, Double v1, String k2, Double v2, String k3, Double v3) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
		}
		objD(String k1, Double v1, String k2, Double v2) {
			super.put(k1, v1);
			super.put(k2, v2);
		}
		objD(String k, Double v) {
			super.put(k, v);
		}
		objD copy() {
			return (objD) super.clone();
		}
		objD slice() {
			return copy();
		}
		double random() {
			if (super.isEmpty())
				return 0;
			return i(randInt(length()));
		}
		double rand() {
			return random();
		}
		double any() {
			return random();
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
			if (n >= 0 && n < length())
				return keyArray()[n];
			else if (n < 0) {
				// Shorter than 0, huh? Let's posi-tize the number, and see if
				// it's under the size of the array. If it is, we'll try and
				// fetch the elements in reverse order
				n = Pos(n);
				if (n <= length())
					return nthLastKey(n);
			}
			return "";
		}
		double nthValue(int n) {
			if (n >= 0 && n < length())
				return array()[n];
			else if (n < 0) {
				// Shorter than 0, huh? Let's posi-tize the number, and see if
				// it's under the size of the array. If it is, we'll try and
				// fetch the elements in reverse order
				n = Pos(n);
				if (n <= length())
					return nthLastValue(n);
			}
			return 0;
		}
		String nthLastKey(int n) {
			return n > 0 && n <= length() ? keyArray()[length() - n] : "";
			// resolved bugfix: some changes helped avoid an index-out-of-bound
			// exception
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
		boolean has(Object o) {
			if (o instanceof String)
				return hasKey((String) o);
			else if (o instanceof Double)
				return hasValue((Double) o);
			return false;
		}
		objD set(String k, Double v) {
			if (!super.containsKey(k))
				super.put(k, v);
			else
				super.replace(k, v);
			return this;
		}
		objD add(String k, Double v) {
			set(k, v);
			return this;
		}
		double delete(String k) {
			return super.remove(k);
		}
		objD push(String k, double v) {
			add(k, v);
			return this;
		}
		double pop(String k) {
			return delete(k);
		}
		objD update(String k, Double v) {
			set(k, v);
			return this;
		}
		Set<String> keys() {
			return super.keySet();
		}
		Set<Map.Entry<String, Double>> entries() {
			return super.entrySet();
		}
		boolean compare(objD arrB) {
			int oldLen = length(), newLen = intersection(arrB).length();
			return newLen > oldLen / 2;
		}
		objD intersection(objD other) {
			if (other == null) {
				return new objD();
			}
			objD result = new objD();
			for (String key : super.keySet()) {
				if (other.containsKey(key)
						&& other.get(key).equals(super.get(key))) {
					result.put(key, super.get(key));
				}
			}
			return result;
		}
		objD negativeIntersection(objD other) {
			if (other == null) {
				return copy();
			}
			objD result = copy();
			result.keySet().removeAll(other.intersection(copy()).keySet());
			return result;
		}
		objD keyIntersection(objD other) {
			if (other == null) {
				return new objD();
			}
			objD result = new objD();
			for (String key : super.keySet()) {
				if (other.containsKey(key)) {
					result.put(key, super.get(key));
				}
			}
			return result;
		}
		objD negativeKeyIntersection(objD other) {
			if (other == null) {
				return copy();
			}
			objD result = copy();
			result.keySet().removeAll(other.keySet());
			return result;
		}
		objD valueIntersection(objD other) {
			if (other == null) {
				return new objD();
			}
			objD result = new objD();
			for (String key1 : super.keySet()) {
				for (String key2 : other.keySet()) {
					if (super.get(key1).equals(other.get(key2))) {
						result.put(key1, super.get(key1));
					}
				}
			}
			return result;
		}
		objD negativeValueIntersection(objD other) {
			if (other == null) {
				return copy();
			}
			objD result = copy();
			result.entrySet()
					.removeIf(entry -> other.containsValue(entry.getValue()));
			return result;
		}
		objD slice(int start) {
			if (super.isEmpty()) {
				return new objD();
			}
			if (start < 0) {
				start = 0;
			}
			if (start >= super.size()) {
				return new objD();
			}
			objD subMap = new objD();
			int index = 0;
			for (String key : super.keySet()) {
				if (index >= start) {
					subMap.put(key, super.get(key));
				}
				index++;
			}
			return subMap;
		}
		objD slice(int start, int end) {
			if (super.isEmpty()) {
				return new objD();
			}
			if (start < 0) {
				start = 0;
			}
			if (end > super.size()) {
				end = super.size();
			}
			if (start > end) {
				int temp = start;
				start = end;
				end = temp;
			}
			objD subMap = new objD();
			int index = 0;
			for (String key : super.keySet()) {
				if (index >= start && index < end) {
					subMap.put(key, super.get(key));
				}
				index++;
			}
			return subMap;
		}
		objD sliceKeep(int end) {
			if (super.isEmpty()) {
				return new objD();
			}
			if (not(end) || isNeg(end)) {
				return new objD();
			}
			if (end > super.size()) {
				end = super.size();
			}
			objD subMap = new objD();
			int index = 0;
			for (String key : super.keySet()) {
				if (index < end) {
					subMap.put(key, super.get(key));
				}
				index++;
			}
			return subMap;
		}
		objD sliceEnd(int earlyEnd) {
			if (super.isEmpty() || earlyEnd <= 0 || earlyEnd > super.size()) {
				if (earlyEnd <= 0) {
					return (objD) super.clone();
				} else {
					return new objD();
				}
			}
			int start = super.size() - earlyEnd;
			objD subMap = new objD();
			int index = 0;
			for (String key : super.keySet()) {
				if (index >= start) {
					subMap.put(key, super.get(key));
				}
				index++;
			}
			return subMap;
		}
		objD mapIfPresent(String key, Function<Double, Double> fn) {
			if (not(fn))
				return this;
			super.computeIfPresent(key, (k, v) -> fn.apply(v));
			return this;
		}
		objD mapIfPresent(double value, Function<Double, Double> fn) {
			return map(value, fn);
		}
		objD mapIfPresent(String key,
				BiFunction<? super String, ? super Double, ? extends Double> fn) {
			if (not(fn))
				return this;
			super.computeIfPresent(key, fn);
			return this;
		}
		objD map(double value, Function<Double, Double> fn) {
			if (!super.containsValue(value) || isNull(value) || fn == null) {
				return this;
			}
			for (String key : this.keySet()) {
				if (this.get(key).equals(value)) {
					double newValue = fn.apply(this.get(key));
					if (isNull(newValue)) {
						this.remove(key);
					} else {
						this.put(key, newValue);
					}
				}
			}
			return this;
		}
		objD mapKey(String key, Function<String, String> fn) {
			if (key == null || fn == null || !this.containsKey(key)) {
				return this;
			}
			String newKey = fn.apply(key);
			if (newKey == null) {
				this.remove(key);
			} else if (!newKey.equals(key)) {
				this.put(newKey, this.remove(key));
			}
			return this;
		}
		objD mapKey(Function<String, String> fn) {
			HashMap<String, Double> newMap = new HashMap<>();
			super.forEach((k, v) -> newMap.put(fn.apply(k), v));
			super.clear();
			super.putAll(newMap);
			return this;
		}
		objD map(Function<Double, Double> fn) {
			super.replaceAll((k, v) -> fn.apply(v));
			return this;
		}
		objD map(
				BiFunction<? super String, ? super Double, ? extends Double> fn) {
			super.replaceAll(fn);
			return this;
		}
		objD eachKey(Consumer<String> fn) {
			super.keySet().forEach(fn);
			return this;
		}
		objD each(Consumer<Double> fn) {
			super.values().forEach(fn);
			return this;
		}
		objD each(BiConsumer<? super String, ? super Double> fn) {
			super.forEach(fn);
			return this;
		}
		objD combine(objD... others) {
			if (not(others))
				return this;
			for (objD other : others) {
				if (not(other))
					continue;
				super.putAll(other);
			}
			return this;
		}
		objD union(objD... others) {
			combine(others);
			return this;
		}
		objD cat(objD... others) {
			combine(others);
			return this;
		}
		objD concat(objD... others) {
			combine(others);
			return this;
		}
		objD join(objD... others) {
			combine(others);
			return this;
		}
		String join() {
			return string();
		}
		String join(String s) {
			if (not(s) || not(length()))
				return string();
			return KL.join(array(), s);
		}
		String string() {
			return super.toString();
		}
		String str() {
			return string();
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
	public static objD objD(String k1, double v1, String k2, double v2,
			String k3, double v3, String k4, double v4, String k5, double v5,
			String k6, double v6, String k7, double v7, String k8, double v8,
			String k9, double v9, String k10, double v10) {
		return new objD(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8, k9, v9, k10, v10);
	}
	public static objD objD(String k1, double v1, String k2, double v2,
			String k3, double v3, String k4, double v4, String k5, double v5,
			String k6, double v6, String k7, double v7, String k8, double v8,
			String k9, double v9) {
		return new objD(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8, k9, v9);
	}
	public static objD objD(String k1, double v1, String k2, double v2,
			String k3, double v3, String k4, double v4, String k5, double v5,
			String k6, double v6, String k7, double v7, String k8, double v8) {
		return new objD(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8);
	}
	public static objD objD(String k1, double v1, String k2, double v2,
			String k3, double v3, String k4, double v4, String k5, double v5,
			String k6, double v6, String k7, double v7) {
		return new objD(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7);
	}
	public static objD objD(String k1, double v1, String k2, double v2,
			String k3, double v3, String k4, double v4, String k5, double v5,
			String k6, double v6) {
		return new objD(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
	}
	public static objD objD(String k1, double v1, String k2, double v2,
			String k3, double v3, String k4, double v4, String k5, double v5) {
		return new objD(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
	}
	public static objD objD(String k1, double v1, String k2, double v2,
			String k3, double v3, String k4, double v4) {
		return new objD(k1, v1, k2, v2, k3, v3, k4, v4);
	}
	public static objD objD(String k1, double v1, String k2, double v2,
			String k3, double v3) {
		return new objD(k1, v1, k2, v2, k3, v3);
	}
	public static objD objD(String k1, double v1, String k2, double v2) {
		return new objD(k1, v1, k2, v2);
	}
	public static objD objD(String k1, double v1) {
		return new objD(k1, v1);
	}
	public static final class objB extends HashMap<String, Boolean> {
		objB() {
			super();
		}
		objB(String k1, Boolean v1, String k2, Boolean v2, String k3,
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
		objB(String k1, Boolean v1, String k2, Boolean v2, String k3,
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
		objB(String k1, Boolean v1, String k2, Boolean v2, String k3,
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
		objB(String k1, Boolean v1, String k2, Boolean v2, String k3,
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
		objB(String k1, Boolean v1, String k2, Boolean v2, String k3,
				Boolean v3, String k4, Boolean v4, String k5, Boolean v5,
				String k6, Boolean v6) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
			super.put(k6, v6);
		}
		objB(String k1, Boolean v1, String k2, Boolean v2, String k3,
				Boolean v3, String k4, Boolean v4, String k5, Boolean v5) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
		}
		objB(String k1, Boolean v1, String k2, Boolean v2, String k3,
				Boolean v3, String k4, Boolean v4) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
		}
		objB(String k1, Boolean v1, String k2, Boolean v2, String k3,
				Boolean v3) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
		}
		objB(String k1, Boolean v1, String k2, Boolean v2) {
			super.put(k1, v1);
			super.put(k2, v2);
		}
		objB(String k, Boolean v) {
			super.put(k, v);
		}
		objB copy() {
			return (objB) super.clone();
		}
		objB slice() {
			return copy();
		}
		boolean random() {
			if (super.isEmpty())
				return false;
			return i(randInt(length()));
		}
		boolean rand() {
			return random();
		}
		boolean any() {
			return random();
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
			if (n >= 0 && n < length())
				return keyArray()[n];
			else if (n < 0) {
				// Shorter than 0, huh? Let's posi-tize the number, and see if
				// it's under the size of the array. If it is, we'll try and
				// fetch the elements in reverse order
				n = Pos(n);
				if (n <= length())
					return nthLastKey(n);
			}
			return "";
		}
		boolean nthValue(int n) {
			if (n >= 0 && n < length())
				return array()[n];
			else if (n < 0) {
				// Shorter than 0, huh? Let's posi-tize the number, and see if
				// it's under the size of the array. If it is, we'll try and
				// fetch the elements in reverse order
				n = Pos(n);
				if (n <= length())
					return nthLastValue(n);
			}
			return false;
		}
		String nthLastKey(int n) {
			return n > 0 && n <= length() ? keyArray()[length() - n] : "";
			// resolved bugfix: some changes helped avoid an index-out-of-bound
			// exception
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
		boolean has(Object o) {
			if (o instanceof String)
				return hasKey((String) o);
			else if (o instanceof Boolean)
				return hasValue((Boolean) o);
			return false;
		}
		objB set(String k, Boolean v) {
			if (!super.containsKey(k))
				super.put(k, v);
			else
				super.replace(k, v);
			return this;
		}
		objB add(String k, Boolean v) {
			set(k, v);
			return this;
		}
		boolean delete(String k) {
			return super.remove(k);
		}
		objB push(String k, Boolean v) {
			add(k, v);
			return this;
		}
		boolean pop(String k) {
			return delete(k);
		}
		objB update(String k, Boolean v) {
			set(k, v);
			return this;
		}
		Set<String> keys() {
			return super.keySet();
		}
		Set<Map.Entry<String, Boolean>> entries() {
			return super.entrySet();
		}
		boolean compare(objB arrB) {
			int oldLen = length(), newLen = intersection(arrB).length();
			return newLen > oldLen / 2;
		}
		objB intersection(objB other) {
			if (other == null) {
				return new objB();
			}
			objB result = new objB();
			for (String key : super.keySet()) {
				if (other.containsKey(key)
						&& other.get(key).equals(super.get(key))) {
					result.put(key, super.get(key));
				}
			}
			return result;
		}
		objB negativeIntersection(objB other) {
			if (other == null) {
				return copy();
			}
			objB result = copy();
			result.keySet().removeAll(other.intersection(copy()).keySet());
			return result;
		}
		objB keyIntersection(objB other) {
			if (other == null) {
				return new objB();
			}
			objB result = new objB();
			for (String key : super.keySet()) {
				if (other.containsKey(key)) {
					result.put(key, super.get(key));
				}
			}
			return result;
		}
		objB negativeKeyIntersection(objB other) {
			if (other == null) {
				return copy();
			}
			objB result = copy();
			result.keySet().removeAll(other.keySet());
			return result;
		}
		objB valueIntersection(objB other) {
			if (other == null) {
				return new objB();
			}
			objB result = new objB();
			for (String key1 : super.keySet()) {
				for (String key2 : other.keySet()) {
					if (super.get(key1).equals(other.get(key2))) {
						result.put(key1, super.get(key1));
					}
				}
			}
			return result;
		}
		objB negativeValueIntersection(objB other) {
			if (other == null) {
				return copy();
			}
			objB result = copy();
			result.entrySet()
					.removeIf(entry -> other.containsValue(entry.getValue()));
			return result;
		}
		objB slice(int start) {
			if (super.isEmpty()) {
				return new objB();
			}
			if (start < 0) {
				start = 0;
			}
			if (start >= super.size()) {
				return new objB();
			}
			objB subMap = new objB();
			int index = 0;
			for (String key : super.keySet()) {
				if (index >= start) {
					subMap.put(key, super.get(key));
				}
				index++;
			}
			return subMap;
		}
		objB slice(int start, int end) {
			if (super.isEmpty()) {
				return new objB();
			}
			if (start < 0) {
				start = 0;
			}
			if (end > super.size()) {
				end = super.size();
			}
			if (start > end) {
				int temp = start;
				start = end;
				end = temp;
			}
			objB subMap = new objB();
			int index = 0;
			for (String key : super.keySet()) {
				if (index >= start && index < end) {
					subMap.put(key, super.get(key));
				}
				index++;
			}
			return subMap;
		}
		objB sliceKeep(int end) {
			if (super.isEmpty()) {
				return new objB();
			}
			if (not(end) || isNeg(end)) {
				return new objB();
			}
			if (end > super.size()) {
				end = super.size();
			}
			objB subMap = new objB();
			int index = 0;
			for (String key : super.keySet()) {
				if (index < end) {
					subMap.put(key, super.get(key));
				}
				index++;
			}
			return subMap;
		}
		objB sliceEnd(int earlyEnd) {
			if (super.isEmpty() || earlyEnd <= 0 || earlyEnd > super.size()) {
				if (earlyEnd <= 0) {
					return (objB) super.clone();
				} else {
					return new objB();
				}
			}
			int start = super.size() - earlyEnd;
			objB subMap = new objB();
			int index = 0;
			for (String key : super.keySet()) {
				if (index >= start) {
					subMap.put(key, super.get(key));
				}
				index++;
			}
			return subMap;
		}
		objB mapIfPresent(String key, Function<Boolean, Boolean> fn) {
			if (not(fn))
				return this;
			super.computeIfPresent(key, (k, v) -> fn.apply(v));
			return this;
		}
		objB mapIfPresent(boolean value, Function<Boolean, Boolean> fn) {
			return map(value, fn);
		}
		objB mapIfPresent(String key,
				BiFunction<? super String, ? super Boolean, ? extends Boolean> fn) {
			if (not(fn))
				return this;
			super.computeIfPresent(key, fn);
			return this;
		}
		objB map(boolean value, Function<Boolean, Boolean> fn) {
			if (!super.containsValue(value) || isNull(value) || fn == null) {
				return this;
			}
			for (String key : this.keySet()) {
				if (this.get(key).equals(value)) {
					boolean newValue = fn.apply(this.get(key));
					if (isNull(newValue)) {
						this.remove(key);
					} else {
						this.put(key, newValue);
					}
				}
			}
			return this;
		}
		objB mapKey(String key, Function<String, String> fn) {
			if (key == null || fn == null || !this.containsKey(key)) {
				return this;
			}
			String newKey = fn.apply(key);
			if (newKey == null) {
				this.remove(key);
			} else if (!newKey.equals(key)) {
				this.put(newKey, this.remove(key));
			}
			return this;
		}
		objB mapKey(Function<String, String> fn) {
			HashMap<String, Boolean> newMap = new HashMap<>();
			super.forEach((k, v) -> newMap.put(fn.apply(k), v));
			super.clear();
			super.putAll(newMap);
			return this;
		}
		objB map(Function<Boolean, Boolean> fn) {
			super.replaceAll((k, v) -> fn.apply(v));
			return this;
		}
		objB map(
				BiFunction<? super String, ? super Boolean, ? extends Boolean> fn) {
			super.replaceAll(fn);
			return this;
		}
		objB eachKey(Consumer<String> fn) {
			super.keySet().forEach(fn);
			return this;
		}
		objB each(Consumer<Boolean> fn) {
			super.values().forEach(fn);
			return this;
		}
		objB each(BiConsumer<? super String, ? super Boolean> fn) {
			super.forEach(fn);
			return this;
		}
		objB combine(objB... others) {
			if (not(others))
				return this;
			for (objB other : others) {
				if (not(other))
					continue;
				super.putAll(other);
			}
			return this;
		}
		objB union(objB... others) {
			combine(others);
			return this;
		}
		objB cat(objB... others) {
			combine(others);
			return this;
		}
		objB concat(objB... others) {
			combine(others);
			return this;
		}
		objB join(objB... others) {
			combine(others);
			return this;
		}
		String join() {
			return string();
		}
		String join(String s) {
			if (not(s) || not(length()))
				return string();
			return KL.join(array(), s);
		}
		String string() {
			return super.toString();
		}
		String str() {
			return string();
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
	public static objB objB(String k1, boolean v1, String k2, boolean v2,
			String k3, boolean v3, String k4, boolean v4, String k5, boolean v5,
			String k6, boolean v6, String k7, boolean v7, String k8, boolean v8,
			String k9, boolean v9, String k10, boolean v10) {
		return new objB(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8, k9, v9, k10, v10);
	}
	public static objB objB(String k1, boolean v1, String k2, boolean v2,
			String k3, boolean v3, String k4, boolean v4, String k5, boolean v5,
			String k6, boolean v6, String k7, boolean v7, String k8, boolean v8,
			String k9, boolean v9) {
		return new objB(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8, k9, v9);
	}
	public static objB objB(String k1, boolean v1, String k2, boolean v2,
			String k3, boolean v3, String k4, boolean v4, String k5, boolean v5,
			String k6, boolean v6, String k7, boolean v7, String k8,
			boolean v8) {
		return new objB(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8);
	}
	public static objB objB(String k1, boolean v1, String k2, boolean v2,
			String k3, boolean v3, String k4, boolean v4, String k5, boolean v5,
			String k6, boolean v6, String k7, boolean v7) {
		return new objB(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7);
	}
	public static objB objB(String k1, boolean v1, String k2, boolean v2,
			String k3, boolean v3, String k4, boolean v4, String k5, boolean v5,
			String k6, boolean v6) {
		return new objB(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
	}
	public static objB objB(String k1, boolean v1, String k2, boolean v2,
			String k3, boolean v3, String k4, boolean v4, String k5,
			boolean v5) {
		return new objB(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
	}
	public static objB objB(String k1, boolean v1, String k2, boolean v2,
			String k3, boolean v3, String k4, boolean v4) {
		return new objB(k1, v1, k2, v2, k3, v3, k4, v4);
	}
	public static objB objB(String k1, boolean v1, String k2, boolean v2,
			String k3, boolean v3) {
		return new objB(k1, v1, k2, v2, k3, v3);
	}
	public static objB objB(String k1, boolean v1, String k2, boolean v2) {
		return new objB(k1, v1, k2, v2);
	}
	public static objB objB(String k1, boolean v1) {
		return new objB(k1, v1);
	}
	public static final class obj extends HashMap<String, Object> {
		obj() {
			super();
		}
		obj(String k1, Object v1, String k2, Object v2, String k3, Object v3,
				String k4, Object v4, String k5, Object v5, String k6,
				Object v6, String k7, Object v7, String k8, Object v8,
				String k9, Object v9, String k10, Object v10) {
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
		obj(String k1, Object v1, String k2, Object v2, String k3, Object v3,
				String k4, Object v4, String k5, Object v5, String k6,
				Object v6, String k7, Object v7, String k8, Object v8,
				String k9, Object v9) {
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
		obj(String k1, Object v1, String k2, Object v2, String k3, Object v3,
				String k4, Object v4, String k5, Object v5, String k6,
				Object v6, String k7, Object v7, String k8, Object v8) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
			super.put(k6, v6);
			super.put(k7, v7);
			super.put(k8, v8);
		}
		obj(String k1, Object v1, String k2, Object v2, String k3, Object v3,
				String k4, Object v4, String k5, Object v5, String k6,
				Object v6, String k7, Object v7) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
			super.put(k6, v6);
			super.put(k7, v7);
		}
		obj(String k1, Object v1, String k2, Object v2, String k3, Object v3,
				String k4, Object v4, String k5, Object v5, String k6,
				Object v6) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
			super.put(k6, v6);
		}
		obj(String k1, Object v1, String k2, Object v2, String k3, Object v3,
				String k4, Object v4, String k5, Object v5) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
		}
		obj(String k1, Object v1, String k2, Object v2, String k3, Object v3,
				String k4, Object v4) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
		}
		obj(String k1, Object v1, String k2, Object v2, String k3, Object v3) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
		}
		obj(String k1, Object v1, String k2, Object v2) {
			super.put(k1, v1);
			super.put(k2, v2);
		}
		obj(String k, Object v) {
			super.put(k, v);
		}
		obj copy() {
			return (obj) super.clone();
		}
		obj slice() {
			return copy();
		}
		Object random() {
			if (super.isEmpty())
				return false;
			return i(randInt(length()));
		}
		String random(String type) {
			if (not(isStr(random())))
				return "";
			return (String) random();
		}
		int random(int type) {
			if (not(isInt(random())))
				return 0;
			return (int) random();
		}
		long random(long type) {
			if (not(isLong(random())))
				return 0;
			return (long) random();
		}
		float random(float type) {
			if (not(isFlt(random())))
				return 0;
			return (float) random();
		}
		double random(double type) {
			if (not(isDbl(random())))
				return 0;
			return (double) random();
		}
		boolean random(boolean type) {
			if (not(isBool(random())))
				return false;
			return (boolean) random();
		}
		Object rand() {
			return random();
		}
		String rand(String type) {
			return random(type);
		}
		int rand(int type) {
			return random(type);
		}
		long rand(long type) {
			return random(type);
		}
		float rand(float type) {
			return random(type);
		}
		double rand(double type) {
			return random(type);
		}
		boolean rand(boolean type) {
			return random(type);
		}
		Object any() {
			return random();
		}
		String any(String type) {
			return random(type);
		}
		int any(int type) {
			return random(type);
		}
		long any(long type) {
			return random(type);
		}
		float any(float type) {
			return random(type);
		}
		double any(double type) {
			return random(type);
		}
		boolean any(boolean type) {
			return random(type);
		}
		Object key(String k) {
			return hasKey(k) ? super.get(k) : null;
			// will take a key in the form of a string, but RETURN AN OBJECT
		}
		String key(String k, String type) {
			if (not(isStr(key(k))))
				return "";
			return (String) key(k);
		}
		int key(String k, int type) {
			if (not(isInt(key(k))))
				return 0;
			return (int) key(k);
		}
		long key(String k, long type) {
			if (not(isLong(key(k))))
				return 0;
			return (long) key(k);
		}
		float key(String k, float type) {
			if (not(isFlt(key(k))))
				return 0;
			return (float) key(k);
		}
		double key(String k, double type) {
			if (not(isDbl(key(k))))
				return 0;
			return (double) key(k);
		}
		boolean key(String k, boolean type) {
			if (not(isBool(key(k))))
				return false;
			return (boolean) key(k);
		}
		Object k(String k) {
			return key(k);
		}
		String k(String k, String type) {
			return key(k, type);
		}
		int k(String k, int type) {
			return key(k, type);
		}
		long k(String k, long type) {
			return key(k, type);
		}
		float k(String k, float type) {
			return key(k, type);
		}
		double k(String k, double type) {
			return key(k, type);
		}
		boolean k(String k, boolean type) {
			return key(k, type);
		}
		Object val(String k) {
			return key(k);
		}
		String val(String k, String type) {
			return key(k, type);
		}
		int val(String k, int type) {
			return key(k, type);
		}
		long val(String k, long type) {
			return key(k, type);
		}
		float val(String k, float type) {
			return key(k, type);
		}
		double val(String k, double type) {
			return key(k, type);
		}
		boolean val(String k, boolean type) {
			return key(k, type);
		}
		Object v(String k) {
			return key(k);
		}
		String v(String k, String type) {
			return key(k, type);
		}
		int v(String k, int type) {
			return key(k, type);
		}
		long v(String k, long type) {
			return key(k, type);
		}
		float v(String k, float type) {
			return key(k, type);
		}
		double v(String k, double type) {
			return key(k, type);
		}
		boolean v(String k, boolean type) {
			return key(k, type);
		}
		String[] keyArray() {
			Object[] keysObj = super.keySet().toArray();
			String[] keys = new String[keysObj.length];
			for (int i : range(keysObj))
				keys[i] = (String) keysObj[i];
			return keys;
		}
		Object[] array() {
			Object[] values = super.values().toArray();
			return values;
		}
		String nthKey(int n) {
			if (n >= 0 && n < length())
				return keyArray()[n];
			else if (n < 0) {
				// Shorter than 0, huh? Let's posi-tize the number, and see if
				// it's under the size of the array. If it is, we'll try and
				// fetch the elements in reverse order
				n = Pos(n);
				if (n <= length())
					return nthLastKey(n);
			}
			return "";
		}
		Object nthValue(int n) {
			if (n >= 0 && n < length())
				return array()[n];
			else if (n < 0) {
				// Shorter than 0, huh? Let's posi-tize the number, and see if
				// it's under the size of the array. If it is, we'll try and
				// fetch the elements in reverse order
				n = Pos(n);
				if (n <= length())
					return nthLastValue(n);
			}
			return none;
		}
		String nthValue(int n, String type) {
			if (not(isStr(nthValue(n))))
				return "";
			return (String) nthValue(n);
		}
		int nthValue(int n, int type) {
			if (not(isInt(nthValue(n))))
				return 0;
			return (int) nthValue(n);
		}
		long nthValue(int n, long type) {
			if (not(isLong(nthValue(n))))
				return 0;
			return (long) nthValue(n);
		}
		float nthValue(int n, float type) {
			if (not(isFlt(nthValue(n))))
				return 0;
			return (float) nthValue(n);
		}
		double nthValue(int n, double type) {
			if (not(isDbl(nthValue(n))))
				return 0;
			return (double) nthValue(n);
		}
		boolean nthValue(int n, boolean type) {
			if (not(isBool(nthValue(n))))
				return false;
			return (boolean) nthValue(n);
		}
		String nthLastKey(int n) {
			return n > 0 && n <= length() ? keyArray()[length() - n] : "";
			// resolved bugfix: some changes helped avoid an index-out-of-bound
			// exception
		}
		Object nthLastValue(int n) {
			return n > 0 && n <= length() ? array()[length() - n] : false;
			// resolved bugfix: some changes helped avoid an index-out-of-bound
			// exception
		}
		String nthLastValue(int n, String type) {
			if (not(isStr(nthLastValue(n))))
				return "";
			return (String) nthLastValue(n);
		}
		int nthLastValue(int n, int type) {
			if (not(isInt(nthLastValue(n))))
				return 0;
			return (int) nthLastValue(n);
		}
		long nthLastValue(int n, long type) {
			if (not(isLong(nthLastValue(n))))
				return 0;
			return (long) nthLastValue(n);
		}
		float nthLastValue(int n, float type) {
			if (not(isFlt(nthLastValue(n))))
				return 0;
			return (float) nthLastValue(n);
		}
		double nthLastValue(int n, double type) {
			if (not(isDbl(nthLastValue(n))))
				return 0;
			return (double) nthLastValue(n);
		}
		boolean nthLastValue(int n, boolean type) {
			if (not(isBool(nthLastValue(n))))
				return false;
			return (boolean) nthLastValue(n);
		}
		Object i(int n) {
			return nthValue(n);
		}
		String i(int n, String type) {
			if (not(isStr(i(n))))
				return "";
			return (String) i(n);
		}
		int i(int n, int type) {
			if (not(isInt(i(n))))
				return 0;
			return (int) i(n);
		}
		long i(int n, long type) {
			if (not(isLong(i(n))))
				return 0;
			return (long) i(n);
		}
		float i(int n, float type) {
			if (not(isFlt(i(n))))
				return 0;
			return (float) i(n);
		}
		double i(int n, double type) {
			if (not(isDbl(i(n))))
				return 0;
			return (double) i(n);
		}
		boolean i(int n, boolean type) {
			if (not(isBool(i(n))))
				return false;
			return (boolean) i(n);
		}
		Object lasti(int n) {
			return nthLastValue(n);
		}
		String lasti(int n, String type) {
			if (not(isStr(lasti(n))))
				return "";
			return (String) lasti(n);
		}
		int lasti(int n, int type) {
			if (not(isInt(lasti(n))))
				return 0;
			return (int) lasti(n);
		}
		long lasti(int n, long type) {
			if (not(isLong(lasti(n))))
				return 0;
			return (long) lasti(n);
		}
		float lasti(int n, float type) {
			if (not(isFlt(lasti(n))))
				return 0;
			return (float) lasti(n);
		}
		double lasti(int n, double type) {
			if (not(isDbl(lasti(n))))
				return 0;
			return (double) lasti(n);
		}
		boolean lasti(int n, boolean type) {
			if (not(isBool(lasti(n))))
				return false;
			return (boolean) lasti(n);
		}
		Object ilast(int n) {
			return lasti(n);
		}
		String ilast(int n, String type) {
			return lasti(n, type);
		}
		int ilast(int n, int type) {
			return lasti(n, type);
		}
		long ilast(int n, long type) {
			return lasti(n, type);
		}
		float ilast(int n, float type) {
			return lasti(n, type);
		}
		double ilast(int n, double type) {
			return lasti(n, type);
		}
		boolean ilast(int n, boolean type) {
			return lasti(n, type);
		}
		Object nth(int n) {
			return i(n);
		}
		String nth(int n, String type) {
			return i(n, type);
		}
		int nth(int n, int type) {
			return i(n, type);
		}
		long nth(int n, long type) {
			return i(n, type);
		}
		float nth(int n, float type) {
			return i(n, type);
		}
		double nth(int n, double type) {
			return i(n, type);
		}
		boolean nth(int n, boolean type) {
			return i(n, type);
		}
		Object nthlast(int n) {
			return lasti(n);
		}
		String nthlast(int n, String type) {
			return lasti(n, type);
		}
		int nthlast(int n, int type) {
			return lasti(n, type);
		}
		long nthlast(int n, long type) {
			return lasti(n, type);
		}
		float nthlast(int n, float type) {
			return lasti(n, type);
		}
		double nthlast(int n, double type) {
			return lasti(n, type);
		}
		boolean nthlast(int n, boolean type) {
			return lasti(n, type);
		}
		Object first() {
			return nth(0);
		}
		String first(String type) {
			if (not(isStr(first())))
				return "";
			return (String) first();
		}
		int first(int type) {
			if (not(isInt(first())))
				return 0;
			return (int) first();
		}
		long first(long type) {
			if (not(isLong(first())))
				return 0;
			return (long) first();
		}
		float first(float type) {
			if (not(isFlt(first())))
				return 0;
			return (float) first();
		}
		double first(double type) {
			if (not(isDbl(first())))
				return 0;
			return (double) first();
		}
		boolean first(boolean type) {
			if (not(isBool(first())))
				return false;
			return (boolean) first();
		}
		Object second() {
			return nth(1);
		}
		String second(String type) {
			if (not(isStr(second())))
				return "";
			return (String) second();
		}
		int second(int type) {
			if (not(isInt(second())))
				return 0;
			return (int) second();
		}
		long second(long type) {
			if (not(isLong(second())))
				return 0;
			return (long) second();
		}
		float second(float type) {
			if (not(isFlt(second())))
				return 0;
			return (float) second();
		}
		double second(double type) {
			if (not(isDbl(second())))
				return 0;
			return (double) second();
		}
		boolean second(boolean type) {
			if (not(isBool(second())))
				return false;
			return (boolean) second();
		}
		Object seclast() {
			return nthlast(2);
		}
		String seclast(String type) {
			if (not(isStr(seclast())))
				return "";
			return (String) seclast();
		}
		int seclast(int type) {
			if (not(isInt(seclast())))
				return 0;
			return (int) seclast();
		}
		long seclast(long type) {
			if (not(isLong(seclast())))
				return 0;
			return (long) seclast();
		}
		float seclast(float type) {
			if (not(isFlt(seclast())))
				return 0;
			return (float) seclast();
		}
		double seclast(double type) {
			if (not(isDbl(seclast())))
				return 0;
			return (double) seclast();
		}
		boolean seclast(boolean type) {
			if (not(isBool(seclast())))
				return false;
			return (boolean) seclast();
		}
		Object last() {
			return nthlast(1);
		}
		String last(String type) {
			if (not(isStr(last())))
				return "";
			return (String) last();
		}
		int last(int type) {
			if (not(isInt(last())))
				return 0;
			return (int) last();
		}
		long last(long type) {
			if (not(isLong(last())))
				return 0;
			return (long) last();
		}
		float last(float type) {
			if (not(isFlt(last())))
				return 0;
			return (float) last();
		}
		double last(double type) {
			if (not(isDbl(last())))
				return 0;
			return (double) last();
		}
		boolean last(boolean type) {
			if (not(isBool(last())))
				return false;
			return (boolean) last();
		}
		boolean hasKey(String k) {
			return super.containsKey(k);
		}
		boolean hasValue(Object v) {
			return super.containsValue(v);
		}
		boolean has(Object o) {
			if (o instanceof String)
				return hasKey((String) o);
			return hasValue(o);
		}
		obj set(String k, Object v) {
			if (!super.containsKey(k))
				super.put(k, v);
			else
				super.replace(k, v);
			return this;
		}
		obj add(String k, Object v) {
			set(k, v);
			return this;
		}
		Object delete(String k) {
			return super.remove(k);
		}
		obj push(String k, Object v) {
			add(k, v);
			return this;
		}
		Object pop(String k) {
			return delete(k);
		}
		obj update(String k, Object v) {
			set(k, v);
			return this;
		}
		Set<String> keys() {
			return super.keySet();
		}
		Set<Map.Entry<String, Object>> entries() {
			return super.entrySet();
		}
		boolean compare(obj arrB) {
			int oldLen = length(), newLen = intersection(arrB).length();
			return newLen > oldLen / 2;
		}
		obj intersection(obj other) {
			if (other == null) {
				return new obj();
			}
			obj result = new obj();
			for (String key : super.keySet()) {
				if (other.containsKey(key)
						&& other.get(key).equals(super.get(key))) {
					result.put(key, super.get(key));
				}
			}
			return result;
		}
		obj negativeIntersection(obj other) {
			if (other == null) {
				return copy();
			}
			obj result = copy();
			result.keySet().removeAll(other.intersection(copy()).keySet());
			return result;
		}
		obj keyIntersection(obj other) {
			if (other == null) {
				return new obj();
			}
			obj result = new obj();
			for (String key : super.keySet()) {
				if (other.containsKey(key)) {
					result.put(key, super.get(key));
				}
			}
			return result;
		}
		obj negativeKeyIntersection(obj other) {
			if (other == null) {
				return copy();
			}
			obj result = copy();
			result.keySet().removeAll(other.keySet());
			return result;
		}
		obj valueIntersection(obj other) {
			if (other == null) {
				return new obj();
			}
			obj result = new obj();
			for (String key1 : super.keySet()) {
				for (String key2 : other.keySet()) {
					if (super.get(key1).equals(other.get(key2))) {
						result.put(key1, super.get(key1));
					}
				}
			}
			return result;
		}
		obj negativeValueIntersection(obj other) {
			if (other == null) {
				return copy();
			}
			obj result = copy();
			result.entrySet()
					.removeIf(entry -> other.containsValue(entry.getValue()));
			return result;
		}
		obj slice(int start) {
			if (super.isEmpty()) {
				return new obj();
			}
			if (start < 0) {
				start = 0;
			}
			if (start >= super.size()) {
				return new obj();
			}
			obj subMap = new obj();
			int index = 0;
			for (String key : super.keySet()) {
				if (index >= start) {
					subMap.put(key, super.get(key));
				}
				index++;
			}
			return subMap;
		}
		obj slice(int start, int end) {
			if (super.isEmpty()) {
				return new obj();
			}
			if (start < 0) {
				start = 0;
			}
			if (end > super.size()) {
				end = super.size();
			}
			if (start > end) {
				int temp = start;
				start = end;
				end = temp;
			}
			obj subMap = new obj();
			int index = 0;
			for (String key : super.keySet()) {
				if (index >= start && index < end) {
					subMap.put(key, super.get(key));
				}
				index++;
			}
			return subMap;
		}
		obj sliceKeep(int end) {
			if (super.isEmpty()) {
				return new obj();
			}
			if (not(end) || isNeg(end)) {
				return new obj();
			}
			if (end > super.size()) {
				end = super.size();
			}
			obj subMap = new obj();
			int index = 0;
			for (String key : super.keySet()) {
				if (index < end) {
					subMap.put(key, super.get(key));
				}
				index++;
			}
			return subMap;
		}
		obj sliceEnd(int earlyEnd) {
			if (super.isEmpty() || earlyEnd <= 0 || earlyEnd > super.size()) {
				if (earlyEnd <= 0) {
					return (obj) super.clone();
				} else {
					return new obj();
				}
			}
			int start = super.size() - earlyEnd;
			obj subMap = new obj();
			int index = 0;
			for (String key : super.keySet()) {
				if (index >= start) {
					subMap.put(key, super.get(key));
				}
				index++;
			}
			return subMap;
		}
		obj mapIfPresent(Object value, Function<Object, Object> fn) {
			return map(value, fn);
		}
		obj mapIfPresent(String key,
				BiFunction<? super String, ? super Object, ? extends Object> fn) {
			if (not(fn))
				return this;
			super.computeIfPresent(key, fn);
			return this;
		}
		obj map(Object value, Function<Object, Object> fn) {
			if (!super.containsValue(value) || isNull(value) || fn == null) {
				return this;
			}
			for (String key : this.keySet()) {
				if (this.get(key).equals(value)) {
					Object newValue = fn.apply(this.get(key));
					if (isNull(newValue)) {
						this.remove(key);
					} else {
						this.put(key, newValue);
					}
				}
			}
			return this;
		}
		obj mapKey(String key, Function<String, String> fn) {
			if (not(key) || not(fn) || !this.containsKey(key)) {
				return this;
			}
			String newKey = fn.apply(key);
			if (not(newKey)) {
				this.remove(key);
			} else if (!newKey.equals(key)) {
				this.put(newKey, this.remove(key));
			}
			return this;
		}
		obj mapKey(Function<String, String> fn) {
			HashMap<String, Object> newMap = new HashMap<>();
			super.forEach((k, v) -> newMap.put(fn.apply(k), v));
			super.clear();
			super.putAll(newMap);
			return this;
		}
		obj map(Function<Object, Object> fn) {
			super.replaceAll((k, v) -> fn.apply(v));
			return this;
		}
		obj map(BiFunction<? super String, ? super Object, ? extends Object> fn) {
			super.replaceAll(fn);
			return this;
		}
		obj eachKey(Consumer<String> fn) {
			super.keySet().forEach(fn);
			return this;
		}
		obj each(Consumer<Object> fn) {
			super.values().forEach(fn);
			return this;
		}
		obj each(BiConsumer<? super String, ? super Object> fn) {
			super.forEach(fn);
			return this;
		}
		obj combine(obj... others) {
			if (not(others))
				return this;
			for (obj other : others) {
				if (not(other))
					continue;
				super.putAll(other);
			}
			return this;
		}
		obj union(obj... others) {
			combine(others);
			return this;
		}
		obj cat(obj... others) {
			combine(others);
			return this;
		}
		obj concat(obj... others) {
			combine(others);
			return this;
		}
		obj join(obj... others) {
			combine(others);
			return this;
		}
		String join() {
			return string();
		}
		String join(String s) {
			if (not(s) || not(length()))
				return string();
			return KL.join(array(), s);
		}
		String string() {
			return super.toString();
		}
		String str() {
			return string();
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
	public static obj obj(String k1, Object v1, String k2, Object v2, String k3,
			Object v3, String k4, Object v4, String k5, Object v5, String k6,
			Object v6, String k7, Object v7, String k8, Object v8, String k9,
			Object v9, String k10, Object v10) {
		return new obj(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8, k9, v9, k10, v10);
	}
	public static obj obj(String k1, Object v1, String k2, Object v2, String k3,
			Object v3, String k4, Object v4, String k5, Object v5, String k6,
			Object v6, String k7, Object v7, String k8, Object v8, String k9,
			Object v9) {
		return new obj(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8, k9, v9);
	}
	public static obj obj(String k1, Object v1, String k2, Object v2, String k3,
			Object v3, String k4, Object v4, String k5, Object v5, String k6,
			Object v6, String k7, Object v7, String k8, Object v8) {
		return new obj(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8);
	}
	public static obj obj(String k1, Object v1, String k2, Object v2, String k3,
			Object v3, String k4, Object v4, String k5, Object v5, String k6,
			Object v6, String k7, Object v7) {
		return new obj(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7);
	}
	public static obj obj(String k1, Object v1, String k2, Object v2, String k3,
			Object v3, String k4, Object v4, String k5, Object v5, String k6,
			Object v6) {
		return new obj(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
	}
	public static obj obj(String k1, Object v1, String k2, Object v2, String k3,
			Object v3, String k4, Object v4, String k5, Object v5) {
		return new obj(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
	}
	public static obj obj(String k1, Object v1, String k2, Object v2, String k3,
			Object v3, String k4, Object v4) {
		return new obj(k1, v1, k2, v2, k3, v3, k4, v4);
	}
	public static obj obj(String k1, Object v1, String k2, Object v2, String k3,
			Object v3) {
		return new obj(k1, v1, k2, v2, k3, v3);
	}
	public static obj obj(String k1, Object v1, String k2, Object v2) {
		return new obj(k1, v1, k2, v2);
	}
	public static obj obj(String k1, Object v1) {
		return new obj(k1, v1);
	}
	public static class tree<Key, Value> extends TreeMap<Key, Value> {
		public static final long serialVersionUID = 1L;
		tree() {
			super();
		}
		tree(Key k1, Value v1, Key k2, Value v2, Key k3, Value v3, Key k4,
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
		tree(Key k1, Value v1, Key k2, Value v2, Key k3, Value v3, Key k4,
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
		tree(Key k1, Value v1, Key k2, Value v2, Key k3, Value v3, Key k4,
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
		tree(Key k1, Value v1, Key k2, Value v2, Key k3, Value v3, Key k4,
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
		tree(Key k1, Value v1, Key k2, Value v2, Key k3, Value v3, Key k4,
				Value v4, Key k5, Value v5, Key k6, Value v6) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
			super.put(k6, v6);
		}
		tree(Key k1, Value v1, Key k2, Value v2, Key k3, Value v3, Key k4,
				Value v4, Key k5, Value v5) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
		}
		tree(Key k1, Value v1, Key k2, Value v2, Key k3, Value v3, Key k4,
				Value v4) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
		}
		tree(Key k1, Value v1, Key k2, Value v2, Key k3, Value v3) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
		}
		tree(Key k1, Value v1, Key k2, Value v2) {
			super.put(k1, v1);
			super.put(k2, v2);
		}
		tree(Key k1, Value v1) {
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
		tree<Key, Value> set(Key k, Value v) {
			if (!super.containsKey(k))
				super.put(k, v);
			else
				super.replace(k, v);
			return this;
		}
		tree<Key, Value> add(Key k, Value v) {
			set(k, v);
			return this;
		}
		Value delete(Key k) {
			Value v = hasKey(k) ? super.get(k) : null;
			super.remove(k);
			return v;
		}
		tree<Key, Value> push(Key k, Value v) {
			add(k, v);
			return this;
		}
		Value pop(Key k) {
			return delete(k);
		}
		tree<Key, Value> update(Key k, Value v) {
			set(k, v);
			return this;
		}
		Set<Key> keys() {
			return super.keySet();
		}
		Set<Map.Entry<Key, Value>> entries() {
			return super.entrySet();
		}
		tree<Key, Value> mapIfPresent(Key key, Function<Value, Value> fn) {
			if (not(fn))
				return this;
			super.computeIfPresent(key, (k, v) -> fn.apply(v));
			return this;
		}
		tree<Key, Value> mapIfPresent(Key key,
				BiFunction<? super Key, ? super Value, ? extends Value> fn) {
			if (not(fn))
				return this;
			super.computeIfPresent(key, fn);
			return this;
		}
		tree<Key, Value> mapKey(Function<Key, Key> fn) {
			HashMap<Key, Value> newMap = new HashMap<>();
			super.forEach((k, v) -> newMap.put(fn.apply(k), v));
			super.clear();
			super.putAll(newMap);
			return this;
		}
		tree<Key, Value> mapKey(Key key, Function<Key, Key> fn) {
			if (key == null || fn == null || !this.containsKey(key)) {
				return this;
			}
			Key newKey = fn.apply(key);
			if (newKey == null) {
				this.remove(key);
			} else if (!newKey.equals(key)) {
				Value value = this.get(key);
				super.remove(key);
				super.put(newKey, value);
			}
			return this;
		}
		tree<Key, Value> map(Value value, Function<Value, Value> fn) {
			if (!super.containsValue(value) || isNull(value) || fn == null) {
				return this;
			}
			for (Key key : this.keySet()) {
				if (this.get(key).equals(value)) {
					Value newValue = fn.apply(this.get(key));
					if (isNull(newValue)) {
						this.remove(key);
					} else {
						this.put(key, newValue);
					}
				}
			}
			return this;
		}
		tree<Key, Value> map(Function<Value, Value> fn) {
			super.replaceAll((k, v) -> fn.apply(v));
			return this;
		}
		tree<Key, Value> map(
				BiFunction<? super Key, ? super Value, ? extends Value> fn) {
			super.replaceAll(fn);
			return this;
		}
		tree<Key, Value> eachKey(Consumer<Key> fn) {
			super.keySet().forEach(fn);
			return this;
		}
		tree<Key, Value> each(Consumer<Value> fn) {
			super.values().forEach(fn);
			return this;
		}
		tree<Key, Value> each(BiConsumer<? super Key, ? super Value> fn) {
			super.forEach(fn);
			return this;
		}
		tree<Key, Value> slice(int start) {
			if (super.isEmpty()) {
				return new tree<>();
			}
			if (start < 0) {
				start = 0;
			}
			if (start >= super.size()) {
				return new tree<>();
			}
			tree<Key, Value> subMap = new tree<>();
			int index = 0;
			for (Key key : super.keySet()) {
				if (index >= start) {
					subMap.put(key, super.get(key));
				}
				index++;
			}
			return subMap;
		}
		tree<Key, Value> slice(int start, int end) {
			if (super.isEmpty()) {
				return new tree<>();
			}
			if (start < 0) {
				start = 0;
			}
			if (end > super.size()) {
				end = super.size();
			}
			if (start > end) {
				int temp = start;
				start = end;
				end = temp;
			}
			tree<Key, Value> subMap = new tree<>();
			int index = 0;
			for (Key key : super.keySet()) {
				if (index >= start && index < end) {
					subMap.put(key, super.get(key));
				}
				index++;
			}
			return subMap;
		}
		tree<Key, Value> sliceKeep(int end) {
			if (super.isEmpty()) {
				return new tree<>();
			}
			if (not(end) || isNeg(end)) {
				return new tree<>();
			}
			if (end > super.size()) {
				end = super.size();
			}
			tree<Key, Value> subMap = new tree<>();
			int index = 0;
			for (Key key : super.keySet()) {
				if (index < end) {
					subMap.put(key, super.get(key));
				}
				index++;
			}
			return subMap;
		}
		tree<Key, Value> sliceEnd(int earlyEnd) {
			if (super.isEmpty() || earlyEnd <= 0 || earlyEnd > super.size()) {
				return (tree<Key, Value>) super.clone();
			}
			int start = super.size() - earlyEnd;
			tree<Key, Value> subMap = new tree<>();
			int index = 0;
			for (Key key : super.keySet()) {
				if (index >= start) {
					subMap.put(key, super.get(key));
				}
				index++;
			}
			return subMap;
		}
		boolean compare(tree<Key, Value> arrB) {
			int oldLen = length(), newLen = intersection(arrB).length();
			return newLen > oldLen / 2;
		}
		tree<Key, Value> intersection(tree<Key, Value> other) {
			if (other == null) {
				return new tree<>();
			}
			tree<Key, Value> result = new tree<>();
			for (Key key : super.keySet()) {
				if (other.containsKey(key)
						&& other.get(key).equals(super.get(key))) {
					result.put(key, super.get(key));
				}
			}
			return result;
		}
		tree<Key, Value> negativeIntersection(tree<Key, Value> other) {
			if (other == null) {
				return (tree<Key, Value>) super.clone();
			}
			tree<Key, Value> result = (tree<Key, Value>) super.clone();
			result.keySet().removeAll(other
					.intersection((tree<Key, Value>) super.clone()).keySet());
			return result;
		}
		tree<Key, Value> keyIntersection(tree<Key, Value> other) {
			if (other == null) {
				return new tree<>();
			}
			tree<Key, Value> result = new tree<>();
			for (Key key : super.keySet()) {
				if (other.containsKey(key)) {
					result.put(key, super.get(key));
				}
			}
			return result;
		}
		tree<Key, Value> negativeKeyIntersection(tree<Key, Value> other) {
			if (other == null) {
				return (tree<Key, Value>) super.clone();
			}
			tree<Key, Value> result = (tree<Key, Value>) super.clone();
			result.keySet().removeAll(other.keySet());
			return result;
		}
		tree<Key, Value> valueIntersection(tree<Key, Value> other) {
			if (other == null) {
				return new tree<>();
			}
			tree<Key, Value> result = new tree<>();
			for (Key key1 : super.keySet()) {
				for (Key key2 : other.keySet()) {
					if (super.get(key1).equals(other.get(key2))) {
						result.put(key1, super.get(key1));
					}
				}
			}
			return result;
		}
		tree<Key, Value> negativeValueIntersection(tree<Key, Value> other) {
			if (other == null) {
				return (tree<Key, Value>) super.clone();
			}
			tree<Key, Value> result = (tree<Key, Value>) super.clone();
			result.entrySet()
					.removeIf(entry -> other.containsValue(entry.getValue()));
			return result;
		}
		String string() {
			return super.toString();
		}
		String str() {
			return string();
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
	public static class treeI extends tree<Integer, String> {
		public static final long serialVersionUID = 1L;
		treeI() {
			super();
		}
		treeI(int k1, String v1, int k2, String v2, int k3, String v3, int k4,
				String v4, int k5, String v5, int k6, String v6, int k7,
				String v7, int k8, String v8, int k9, String v9, int k10,
				String v10) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8,
					v8, k9, v9, k10, v10);
		}
		treeI(int k1, String v1, int k2, String v2, int k3, String v3, int k4,
				String v4, int k5, String v5, int k6, String v6, int k7,
				String v7, int k8, String v8, int k9, String v9) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8,
					v8, k9, v9);
		}
		treeI(int k1, String v1, int k2, String v2, int k3, String v3, int k4,
				String v4, int k5, String v5, int k6, String v6, int k7,
				String v7, int k8, String v8) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8,
					v8);
		}
		treeI(int k1, String v1, int k2, String v2, int k3, String v3, int k4,
				String v4, int k5, String v5, int k6, String v6, int k7,
				String v7) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7);
		}
		treeI(int k1, String v1, int k2, String v2, int k3, String v3, int k4,
				String v4, int k5, String v5, int k6, String v6) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
		}
		treeI(int k1, String v1, int k2, String v2, int k3, String v3, int k4,
				String v4, int k5, String v5) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
		}
		treeI(int k1, String v1, int k2, String v2, int k3, String v3, int k4,
				String v4) {
			super(k1, v1, k2, v2, k3, v3, k4, v4);
		}
		treeI(int k1, String v1, int k2, String v2, int k3, String v3) {
			super(k1, v1, k2, v2, k3, v3);
		}
		treeI(int k1, String v1, int k2, String v2) {
			super(k1, v1, k2, v2);
		}
		treeI(int k1, String v1) {
			super(k1, v1);
		}
		treeI copy() {
			return (treeI) super.clone();
		}
		treeI slice() {
			return copy();
		}
		String random() {
			if (super.isEmpty())
				return "";
			return i(randInt(length()));
		}
		String rand() {
			return random();
		}
		String any() {
			return random();
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
			if (n >= 0 && n < length())
				return keyArray()[n];
			else if (n < 0) {
				// Shorter than 0, huh? Let's posi-tize the number, and see if
				// it's under the size of the array. If it is, we'll try and
				// fetch the elements in reverse order
				n = Pos(n);
				if (n <= length())
					return nthLastKey(n);
			}
			return 0;
		}
		String nthValue(int n) {
			if (n >= 0 && n < length())
				return array()[n];
			else if (n < 0) {
				// Shorter than 0, huh? Let's posi-tize the number, and see if
				// it's under the size of the array. If it is, we'll try and
				// fetch the elements in reverse order
				n = Pos(n);
				if (n <= length())
					return nthLastValue(n);
			}
			return "";
		}
		int nthLastKey(int n) {
			return n > 0 && n <= length() ? keyArray()[length() - n] : 0;
			// bugfixed
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
		treeI combine(treeI... trees) {
			if (not(trees))
				return this;
			for (treeI tree : trees) {
				if (not(tree))
					continue;
				super.putAll(tree);
			}
			return this;
		}
		treeI union(treeI... trees) {
			combine(trees);
			return this;
		}
		treeI cat(treeI... trees) {
			combine(trees);
			return this;
		}
		treeI concat(treeI... trees) {
			combine(trees);
			return this;
		}
		treeI join(treeI... trees) {
			combine(trees);
			return this;
		}
		String join() {
			return string();
		}
		String join(String s) {
			if (not(s) || not(length()))
				return string();
			return KL.join(array(), s);
		}
		boolean has(Object o) {
			if (o instanceof Integer)
				return super.hasKey((Integer) o);
			else if (o instanceof String)
				return super.hasValue((String) o);
			return false;
		}
	}
	public static treeI treeI(int k1, String v1, int k2, String v2, int k3,
			String v3, int k4, String v4, int k5, String v5, int k6, String v6,
			int k7, String v7, int k8, String v8, int k9, String v9, int k10,
			String v10) {
		return new treeI(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8, k9, v9, k10, v10);
	}
	public static treeI treeI(int k1, String v1, int k2, String v2, int k3,
			String v3, int k4, String v4, int k5, String v5, int k6, String v6,
			int k7, String v7, int k8, String v8, int k9, String v9) {
		return new treeI(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8, k9, v9);
	}
	public static treeI treeI(int k1, String v1, int k2, String v2, int k3,
			String v3, int k4, String v4, int k5, String v5, int k6, String v6,
			int k7, String v7, int k8, String v8) {
		return new treeI(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8);
	}
	public static treeI treeI(int k1, String v1, int k2, String v2, int k3,
			String v3, int k4, String v4, int k5, String v5, int k6, String v6,
			int k7, String v7) {
		return new treeI(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7,
				v7);
	}
	public static treeI treeI(int k1, String v1, int k2, String v2, int k3,
			String v3, int k4, String v4, int k5, String v5, int k6,
			String v6) {
		return new treeI(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
	}
	public static treeI treeI(int k1, String v1, int k2, String v2, int k3,
			String v3, int k4, String v4, int k5, String v5) {
		return new treeI(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
	}
	public static treeI treeI(int k1, String v1, int k2, String v2, int k3,
			String v3, int k4, String v4) {
		return new treeI(k1, v1, k2, v2, k3, v3, k4, v4);
	}
	public static treeI treeI(int k1, String v1, int k2, String v2, int k3,
			String v3) {
		return new treeI(k1, v1, k2, v2, k3, v3);
	}
	public static treeI treeI(int k1, String v1, int k2, String v2) {
		return new treeI(k1, v1, k2, v2);
	}
	public static treeI treeI(int k1, String v1) {
		return new treeI(k1, v1);
	}
	public static class treeL extends tree<Integer, Long> {
		public static final long serialVersionUID = 1L;
		treeL() {
			super();
		}
		treeL(int k1, long v1, int k2, long v2, int k3, long v3, int k4,
				long v4, int k5, long v5, int k6, long v6, int k7, long v7,
				int k8, long v8, int k9, long v9, int k10, long v10) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8,
					v8, k9, v9, k10, v10);
		}
		treeL(int k1, long v1, int k2, long v2, int k3, long v3, int k4,
				long v4, int k5, long v5, int k6, long v6, int k7, long v7,
				int k8, long v8, int k9, long v9) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8,
					v8, k9, v9);
		}
		treeL(int k1, long v1, int k2, long v2, int k3, long v3, int k4,
				long v4, int k5, long v5, int k6, long v6, int k7, long v7,
				int k8, long v8) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8,
					v8);
		}
		treeL(int k1, long v1, int k2, long v2, int k3, long v3, int k4,
				long v4, int k5, long v5, int k6, long v6, int k7, long v7) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7);
		}
		treeL(int k1, long v1, int k2, long v2, int k3, long v3, int k4,
				long v4, int k5, long v5, int k6, long v6) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
		}
		treeL(int k1, long v1, int k2, long v2, int k3, long v3, int k4,
				long v4, int k5, long v5) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
		}
		treeL(int k1, long v1, int k2, long v2, int k3, long v3, int k4,
				long v4) {
			super(k1, v1, k2, v2, k3, v3, k4, v4);
		}
		treeL(int k1, long v1, int k2, long v2, int k3, long v3) {
			super(k1, v1, k2, v2, k3, v3);
		}
		treeL(int k1, long v1, int k2, long v2) {
			super(k1, v1, k2, v2);
		}
		treeL(int k1, long v1) {
			super(k1, v1);
		}
		treeL copy() {
			return (treeL) super.clone();
		}
		treeL slice() {
			return copy();
		}
		long random() {
			if (super.isEmpty())
				return 0;
			return i(randInt(length()));
		}
		long rand() {
			return random();
		}
		long any() {
			return random();
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
			if (n >= 0 && n < length())
				return keyArray()[n];
			else if (n < 0) {
				// Shorter than 0, huh? Let's posi-tize the number, and see if
				// it's under the size of the array. If it is, we'll try and
				// fetch the elements in reverse order
				n = Pos(n);
				if (n <= length())
					return nthLastKey(n);
			}
			return 0;
		}
		long nthValue(int n) {
			if (n >= 0 && n < length())
				return array()[n];
			else if (n < 0) {
				// Shorter than 0, huh? Let's posi-tize the number, and see if
				// it's under the size of the array. If it is, we'll try and
				// fetch the elements in reverse order
				n = Pos(n);
				if (n <= length())
					return nthLastValue(n);
			}
			return 0;
		}
		int nthLastKey(int n) {
			return n > 0 && n <= length() ? keyArray()[length() - n] : 0;
			// bugfixed
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
		treeL combine(treeL... trees) {
			if (not(trees))
				return this;
			for (treeL tree : trees) {
				if (not(tree))
					continue;
				super.putAll(tree);
			}
			return this;
		}
		treeL union(treeL... trees) {
			combine(trees);
			return this;
		}
		treeL cat(treeL... trees) {
			combine(trees);
			return this;
		}
		treeL concat(treeL... trees) {
			combine(trees);
			return this;
		}
		treeL join(treeL... trees) {
			combine(trees);
			return this;
		}
		String join() {
			return string();
		}
		String join(String s) {
			if (not(s) || not(length()))
				return string();
			return KL.join(array(), s);
		}
		boolean has(Object o) {
			if (o instanceof Integer)
				return super.hasKey((Integer) o);
			else if (o instanceof Long)
				return super.hasValue((Long) o);
			return false;
		}
	}
	public static treeL treeL(int k1, long v1, int k2, long v2, int k3, long v3,
			int k4, long v4, int k5, long v5, int k6, long v6, int k7, long v7,
			int k8, long v8, int k9, long v9, int k10, long v10) {
		return new treeL(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8, k9, v9, k10, v10);
	}
	public static treeL treeL(int k1, long v1, int k2, long v2, int k3, long v3,
			int k4, long v4, int k5, long v5, int k6, long v6, int k7, long v7,
			int k8, long v8, int k9, long v9) {
		return new treeL(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8, k9, v9);
	}
	public static treeL treeL(int k1, long v1, int k2, long v2, int k3, long v3,
			int k4, long v4, int k5, long v5, int k6, long v6, int k7, long v7,
			int k8, long v8) {
		return new treeL(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8);
	}
	public static treeL treeL(int k1, long v1, int k2, long v2, int k3, long v3,
			int k4, long v4, int k5, long v5, int k6, long v6, int k7,
			long v7) {
		return new treeL(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7,
				v7);
	}
	public static treeL treeL(int k1, long v1, int k2, long v2, int k3, long v3,
			int k4, long v4, int k5, long v5, int k6, long v6) {
		return new treeL(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
	}
	public static treeL treeL(int k1, long v1, int k2, long v2, int k3, long v3,
			int k4, long v4, int k5, long v5) {
		return new treeL(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
	}
	public static treeL treeL(int k1, long v1, int k2, long v2, int k3, long v3,
			int k4, long v4) {
		return new treeL(k1, v1, k2, v2, k3, v3, k4, v4);
	}
	public static treeL treeL(int k1, long v1, int k2, long v2, int k3,
			long v3) {
		return new treeL(k1, v1, k2, v2, k3, v3);
	}
	public static treeL treeL(int k1, long v1, int k2, long v2) {
		return new treeL(k1, v1, k2, v2);
	}
	public static treeL treeL(int k1, long v1) {
		return new treeL(k1, v1);
	}
	public static class treeF extends tree<Integer, Float> {
		public static final long serialVersionUID = 1L;
		treeF() {
			super();
		}
		treeF(int k1, float v1, int k2, float v2, int k3, float v3, int k4,
				float v4, int k5, float v5, int k6, float v6, int k7, float v7,
				int k8, float v8, int k9, float v9, int k10, float v10) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8,
					v8, k9, v9, k10, v10);
		}
		treeF(int k1, float v1, int k2, float v2, int k3, float v3, int k4,
				float v4, int k5, float v5, int k6, float v6, int k7, float v7,
				int k8, float v8, int k9, float v9) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8,
					v8, k9, v9);
		}
		treeF(int k1, float v1, int k2, float v2, int k3, float v3, int k4,
				float v4, int k5, float v5, int k6, float v6, int k7, float v7,
				int k8, float v8) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8,
					v8);
		}
		treeF(int k1, float v1, int k2, float v2, int k3, float v3, int k4,
				float v4, int k5, float v5, int k6, float v6, int k7,
				float v7) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7);
		}
		treeF(int k1, float v1, int k2, float v2, int k3, float v3, int k4,
				float v4, int k5, float v5, int k6, float v6) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
		}
		treeF(int k1, float v1, int k2, float v2, int k3, float v3, int k4,
				float v4, int k5, float v5) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
		}
		treeF(int k1, float v1, int k2, float v2, int k3, float v3, int k4,
				float v4) {
			super(k1, v1, k2, v2, k3, v3, k4, v4);
		}
		treeF(int k1, float v1, int k2, float v2, int k3, float v3) {
			super(k1, v1, k2, v2, k3, v3);
		}
		treeF(int k1, float v1, int k2, float v2) {
			super(k1, v1, k2, v2);
		}
		treeF(int k1, float v1) {
			super(k1, v1);
		}
		treeF copy() {
			return (treeF) super.clone();
		}
		treeF slice() {
			return copy();
		}
		float random() {
			if (super.isEmpty())
				return 0;
			return i(randInt(length()));
		}
		float rand() {
			return random();
		}
		float any() {
			return random();
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
			if (n >= 0 && n < length())
				return keyArray()[n];
			else if (n < 0) {
				// Shorter than 0, huh? Let's posi-tize the number, and see if
				// it's under the size of the array. If it is, we'll try and
				// fetch the elements in reverse order
				n = Pos(n);
				if (n <= length())
					return nthLastKey(n);
			}
			return 0;
		}
		float nthValue(int n) {
			if (n >= 0 && n < length())
				return array()[n];
			else if (n < 0) {
				// Shorter than 0, huh? Let's posi-tize the number, and see if
				// it's under the size of the array. If it is, we'll try and
				// fetch the elements in reverse order
				n = Pos(n);
				if (n <= length())
					return nthLastValue(n);
			}
			return 0;
		}
		int nthLastKey(int n) {
			return n > 0 && n <= length() ? keyArray()[length() - n] : 0;
			// bugfixed
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
		treeF combine(treeF... trees) {
			if (not(trees))
				return this;
			for (treeF tree : trees) {
				if (not(tree))
					continue;
				super.putAll(tree);
			}
			return this;
		}
		treeF union(treeF... trees) {
			combine(trees);
			return this;
		}
		treeF cat(treeF... trees) {
			combine(trees);
			return this;
		}
		treeF concat(treeF... trees) {
			combine(trees);
			return this;
		}
		treeF join(treeF... trees) {
			combine(trees);
			return this;
		}
		String join() {
			return string();
		}
		String join(String s) {
			if (not(s) || not(length()))
				return string();
			return KL.join(array(), s);
		}
		boolean has(Object o) {
			if (o instanceof Integer)
				return super.hasKey((Integer) o);
			else if (o instanceof Float)
				return super.hasValue((Float) o);
			return false;
		}
	}
	public static treeF treeF(int k1, float v1, int k2, float v2, int k3,
			float v3, int k4, float v4, int k5, float v5, int k6, float v6,
			int k7, float v7, int k8, float v8, int k9, float v9, int k10,
			float v10) {
		return new treeF(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8, k9, v9, k10, v10);
	}
	public static treeF treeF(int k1, float v1, int k2, float v2, int k3,
			float v3, int k4, float v4, int k5, float v5, int k6, float v6,
			int k7, float v7, int k8, float v8, int k9, float v9) {
		return new treeF(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8, k9, v9);
	}
	public static treeF treeF(int k1, float v1, int k2, float v2, int k3,
			float v3, int k4, float v4, int k5, float v5, int k6, float v6,
			int k7, float v7, int k8, float v8) {
		return new treeF(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8);
	}
	public static treeF treeF(int k1, float v1, int k2, float v2, int k3,
			float v3, int k4, float v4, int k5, float v5, int k6, float v6,
			int k7, float v7) {
		return new treeF(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7,
				v7);
	}
	public static treeF treeF(int k1, float v1, int k2, float v2, int k3,
			float v3, int k4, float v4, int k5, float v5, int k6, float v6) {
		return new treeF(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
	}
	public static treeF treeF(int k1, float v1, int k2, float v2, int k3,
			float v3, int k4, float v4, int k5, float v5) {
		return new treeF(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
	}
	public static treeF treeF(int k1, float v1, int k2, float v2, int k3,
			float v3, int k4, float v4) {
		return new treeF(k1, v1, k2, v2, k3, v3, k4, v4);
	}
	public static treeF treeF(int k1, float v1, int k2, float v2, int k3,
			float v3) {
		return new treeF(k1, v1, k2, v2, k3, v3);
	}
	public static treeF treeF(int k1, float v1, int k2, float v2) {
		return new treeF(k1, v1, k2, v2);
	}
	public static treeF treeF(int k1, float v1) {
		return new treeF(k1, v1);
	}
	public static class treeD extends tree<Integer, Double> {
		public static final long serialVersionUID = 1L;
		treeD() {
			super();
		}
		treeD(int k1, double v1, int k2, double v2, int k3, double v3, int k4,
				double v4, int k5, double v5, int k6, double v6, int k7,
				double v7, int k8, double v8, int k9, double v9, int k10,
				double v10) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8,
					v8, k9, v9, k10, v10);
		}
		treeD(int k1, double v1, int k2, double v2, int k3, double v3, int k4,
				double v4, int k5, double v5, int k6, double v6, int k7,
				double v7, int k8, double v8, int k9, double v9) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8,
					v8, k9, v9);
		}
		treeD(int k1, double v1, int k2, double v2, int k3, double v3, int k4,
				double v4, int k5, double v5, int k6, double v6, int k7,
				double v7, int k8, double v8) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8,
					v8);
		}
		treeD(int k1, double v1, int k2, double v2, int k3, double v3, int k4,
				double v4, int k5, double v5, int k6, double v6, int k7,
				double v7) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7);
		}
		treeD(int k1, double v1, int k2, double v2, int k3, double v3, int k4,
				double v4, int k5, double v5, int k6, double v6) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
		}
		treeD(int k1, double v1, int k2, double v2, int k3, double v3, int k4,
				double v4, int k5, double v5) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
		}
		treeD(int k1, double v1, int k2, double v2, int k3, double v3, int k4,
				double v4) {
			super(k1, v1, k2, v2, k3, v3, k4, v4);
		}
		treeD(int k1, double v1, int k2, double v2, int k3, double v3) {
			super(k1, v1, k2, v2, k3, v3);
		}
		treeD(int k1, double v1, int k2, double v2) {
			super(k1, v1, k2, v2);
		}
		treeD(int k1, double v1) {
			super(k1, v1);
		}
		treeD copy() {
			return (treeD) super.clone();
		}
		treeD slice() {
			return copy();
		}
		double random() {
			if (super.isEmpty())
				return 0;
			return i(randInt(length()));
		}
		double rand() {
			return random();
		}
		double any() {
			return random();
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
			if (n >= 0 && n < length())
				return keyArray()[n];
			else if (n < 0) {
				// Shorter than 0, huh? Let's posi-tize the number, and see if
				// it's under the size of the array. If it is, we'll try and
				// fetch the elements in reverse order
				n = Pos(n);
				if (n <= length())
					return nthLastKey(n);
			}
			return 0;
		}
		double nthValue(int n) {
			if (n >= 0 && n < length())
				return array()[n];
			else if (n < 0) {
				// Shorter than 0, huh? Let's posi-tize the number, and see if
				// it's under the size of the array. If it is, we'll try and
				// fetch the elements in reverse order
				n = Pos(n);
				if (n <= length())
					return nthLastValue(n);
			}
			return 0;
		}
		int nthLastKey(int n) {
			return n > 0 && n <= length() ? keyArray()[length() - n] : 0;
			// bugfixed
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
		treeD combine(treeD... trees) {
			if (not(trees))
				return this;
			for (treeD tree : trees) {
				if (not(tree))
					continue;
				super.putAll(tree);
			}
			return this;
		}
		treeD union(treeD... trees) {
			combine(trees);
			return this;
		}
		treeD cat(treeD... trees) {
			combine(trees);
			return this;
		}
		treeD concat(treeD... trees) {
			combine(trees);
			return this;
		}
		treeD join(treeD... trees) {
			combine(trees);
			return this;
		}
		String join() {
			return string();
		}
		String join(String s) {
			if (not(s) || not(length()))
				return string();
			return KL.join(array(), s);
		}
		boolean has(Object o) {
			if (o instanceof Integer)
				return super.hasKey((Integer) o);
			else if (o instanceof Double)
				return super.hasValue((Double) o);
			return false;
		}
	}
	public static treeD treeD(int k1, double v1, int k2, double v2, int k3,
			double v3, int k4, double v4, int k5, double v5, int k6, double v6,
			int k7, double v7, int k8, double v8, int k9, double v9, int k10,
			double v10) {
		return new treeD(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8, k9, v9, k10, v10);
	}
	public static treeD treeD(int k1, double v1, int k2, double v2, int k3,
			double v3, int k4, double v4, int k5, double v5, int k6, double v6,
			int k7, double v7, int k8, double v8, int k9, double v9) {
		return new treeD(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8, k9, v9);
	}
	public static treeD treeD(int k1, double v1, int k2, double v2, int k3,
			double v3, int k4, double v4, int k5, double v5, int k6, double v6,
			int k7, double v7, int k8, double v8) {
		return new treeD(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8);
	}
	public static treeD treeD(int k1, double v1, int k2, double v2, int k3,
			double v3, int k4, double v4, int k5, double v5, int k6, double v6,
			int k7, double v7) {
		return new treeD(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7,
				v7);
	}
	public static treeD treeD(int k1, double v1, int k2, double v2, int k3,
			double v3, int k4, double v4, int k5, double v5, int k6,
			double v6) {
		return new treeD(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
	}
	public static treeD treeD(int k1, double v1, int k2, double v2, int k3,
			double v3, int k4, double v4, int k5, double v5) {
		return new treeD(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
	}
	public static treeD treeD(int k1, double v1, int k2, double v2, int k3,
			double v3, int k4, double v4) {
		return new treeD(k1, v1, k2, v2, k3, v3, k4, v4);
	}
	public static treeD treeD(int k1, double v1, int k2, double v2, int k3,
			double v3) {
		return new treeD(k1, v1, k2, v2, k3, v3);
	}
	public static treeD treeD(int k1, double v1, int k2, double v2) {
		return new treeD(k1, v1, k2, v2);
	}
	public static treeD treeD(int k1, double v1) {
		return new treeD(k1, v1);
	}
	public static class treeB extends tree<Integer, Boolean> {
		public static final long serialVersionUID = 1L;
		treeB() {
			super();
		}
		treeB(int k1, boolean v1, int k2, boolean v2, int k3, boolean v3,
				int k4, boolean v4, int k5, boolean v5, int k6, boolean v6,
				int k7, boolean v7, int k8, boolean v8, int k9, boolean v9,
				int k10, boolean v10) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8,
					v8, k9, v9, k10, v10);
		}
		treeB(int k1, boolean v1, int k2, boolean v2, int k3, boolean v3,
				int k4, boolean v4, int k5, boolean v5, int k6, boolean v6,
				int k7, boolean v7, int k8, boolean v8, int k9, boolean v9) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8,
					v8, k9, v9);
		}
		treeB(int k1, boolean v1, int k2, boolean v2, int k3, boolean v3,
				int k4, boolean v4, int k5, boolean v5, int k6, boolean v6,
				int k7, boolean v7, int k8, boolean v8) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8,
					v8);
		}
		treeB(int k1, boolean v1, int k2, boolean v2, int k3, boolean v3,
				int k4, boolean v4, int k5, boolean v5, int k6, boolean v6,
				int k7, boolean v7) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7);
		}
		treeB(int k1, boolean v1, int k2, boolean v2, int k3, boolean v3,
				int k4, boolean v4, int k5, boolean v5, int k6, boolean v6) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
		}
		treeB(int k1, boolean v1, int k2, boolean v2, int k3, boolean v3,
				int k4, boolean v4, int k5, boolean v5) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
		}
		treeB(int k1, boolean v1, int k2, boolean v2, int k3, boolean v3,
				int k4, boolean v4) {
			super(k1, v1, k2, v2, k3, v3, k4, v4);
		}
		treeB(int k1, boolean v1, int k2, boolean v2, int k3, boolean v3) {
			super(k1, v1, k2, v2, k3, v3);
		}
		treeB(int k1, boolean v1, int k2, boolean v2) {
			super(k1, v1, k2, v2);
		}
		treeB(int k1, boolean v1) {
			super(k1, v1);
		}
		treeB copy() {
			return (treeB) super.clone();
		}
		treeB slice() {
			return copy();
		}
		boolean random() {
			if (super.isEmpty())
				return false;
			return i(randInt(length()));
		}
		boolean rand() {
			return random();
		}
		boolean any() {
			return random();
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
			if (n >= 0 && n < length())
				return keyArray()[n];
			else if (n < 0) {
				// Shorter than 0, huh? Let's posi-tize the number, and see if
				// it's under the size of the array. If it is, we'll try and
				// fetch the elements in reverse order
				n = Pos(n);
				if (n <= length())
					return nthLastKey(n);
			}
			return 0;
		}
		boolean nthValue(int n) {
			if (n >= 0 && n < length())
				return array()[n];
			else if (n < 0) {
				// Shorter than 0, huh? Let's posi-tize the number, and see if
				// it's under the size of the array. If it is, we'll try and
				// fetch the elements in reverse order
				n = Pos(n);
				if (n <= length())
					return nthLastValue(n);
			}
			return false;
		}
		int nthLastKey(int n) {
			return n > 0 && n <= length() ? keyArray()[length() - n] : 0;
			// bugfixed
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
		treeB combine(treeB... trees) {
			if (not(trees))
				return this;
			for (treeB tree : trees) {
				if (not(tree))
					continue;
				super.putAll(tree);
			}
			return this;
		}
		treeB union(treeB... trees) {
			combine(trees);
			return this;
		}
		treeB cat(treeB... trees) {
			combine(trees);
			return this;
		}
		treeB concat(treeB... trees) {
			combine(trees);
			return this;
		}
		treeB join(treeB... trees) {
			combine(trees);
			return this;
		}
		String join() {
			return string();
		}
		String join(String s) {
			if (not(s) || not(length()))
				return string();
			return KL.join(array(), s);
		}
		boolean has(Object o) {
			if (o instanceof Integer)
				return super.hasKey((Integer) o);
			else if (o instanceof Boolean)
				return super.hasValue((Boolean) o);
			return false;
		}
	}
	public static treeB treeB(int k1, boolean v1, int k2, boolean v2, int k3,
			boolean v3, int k4, boolean v4, int k5, boolean v5, int k6,
			boolean v6, int k7, boolean v7, int k8, boolean v8, int k9,
			boolean v9, int k10, boolean v10) {
		return new treeB(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8, k9, v9, k10, v10);
	}
	public static treeB treeB(int k1, boolean v1, int k2, boolean v2, int k3,
			boolean v3, int k4, boolean v4, int k5, boolean v5, int k6,
			boolean v6, int k7, boolean v7, int k8, boolean v8, int k9,
			boolean v9) {
		return new treeB(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8, k9, v9);
	}
	public static treeB treeB(int k1, boolean v1, int k2, boolean v2, int k3,
			boolean v3, int k4, boolean v4, int k5, boolean v5, int k6,
			boolean v6, int k7, boolean v7, int k8, boolean v8) {
		return new treeB(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8);
	}
	public static treeB treeB(int k1, boolean v1, int k2, boolean v2, int k3,
			boolean v3, int k4, boolean v4, int k5, boolean v5, int k6,
			boolean v6, int k7, boolean v7) {
		return new treeB(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7,
				v7);
	}
	public static treeB treeB(int k1, boolean v1, int k2, boolean v2, int k3,
			boolean v3, int k4, boolean v4, int k5, boolean v5, int k6,
			boolean v6) {
		return new treeB(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
	}
	public static treeB treeB(int k1, boolean v1, int k2, boolean v2, int k3,
			boolean v3, int k4, boolean v4, int k5, boolean v5) {
		return new treeB(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
	}
	public static treeB treeB(int k1, boolean v1, int k2, boolean v2, int k3,
			boolean v3, int k4, boolean v4) {
		return new treeB(k1, v1, k2, v2, k3, v3, k4, v4);
	}
	public static treeB treeB(int k1, boolean v1, int k2, boolean v2, int k3,
			boolean v3) {
		return new treeB(k1, v1, k2, v2, k3, v3);
	}
	public static treeB treeB(int k1, boolean v1, int k2, boolean v2) {
		return new treeB(k1, v1, k2, v2);
	}
	public static treeB treeB(int k1, boolean v1) {
		return new treeB(k1, v1);
	}
	public static class treeDS extends tree<Double, String> {
		public static final long serialVersionUID = 1L;
		treeDS() {
			super();
		}
		treeDS(double k1, String v1, double k2, String v2, double k3, String v3,
				double k4, String v4, double k5, String v5, double k6,
				String v6, double k7, String v7, double k8, String v8,
				double k9, String v9, double k10, String v10) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8,
					v8, k9, v9, k10, v10);
		}
		treeDS(double k1, String v1, double k2, String v2, double k3, String v3,
				double k4, String v4, double k5, String v5, double k6,
				String v6, double k7, String v7, double k8, String v8,
				double k9, String v9) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8,
					v8, k9, v9);
		}
		treeDS(double k1, String v1, double k2, String v2, double k3, String v3,
				double k4, String v4, double k5, String v5, double k6,
				String v6, double k7, String v7, double k8, String v8) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8,
					v8);
		}
		treeDS(double k1, String v1, double k2, String v2, double k3, String v3,
				double k4, String v4, double k5, String v5, double k6,
				String v6, double k7, String v7) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7);
		}
		treeDS(double k1, String v1, double k2, String v2, double k3, String v3,
				double k4, String v4, double k5, String v5, double k6,
				String v6) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
		}
		treeDS(double k1, String v1, double k2, String v2, double k3, String v3,
				double k4, String v4, double k5, String v5) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
		}
		treeDS(double k1, String v1, double k2, String v2, double k3, String v3,
				double k4, String v4) {
			super(k1, v1, k2, v2, k3, v3, k4, v4);
		}
		treeDS(double k1, String v1, double k2, String v2, double k3,
				String v3) {
			super(k1, v1, k2, v2, k3, v3);
		}
		treeDS(double k1, String v1, double k2, String v2) {
			super(k1, v1, k2, v2);
		}
		treeDS(double k1, String v1) {
			super(k1, v1);
		}
		treeDS copy() {
			return (treeDS) super.clone();
		}
		treeDS slice() {
			return copy();
		}
		String random() {
			if (super.isEmpty())
				return "";
			return i(randInt(length()));
		}
		String rand() {
			return random();
		}
		String any() {
			return random();
		}
		double[] keyArray() {
			Object[] objArray = super.keySet().toArray();
			double[] resultantArr = new double[objArray.length];
			for (int i = 0; i < objArray.length; i++) {
				resultantArr[i] = (double) objArray[i];
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
		double nthKey(int n) {
			if (n >= 0 && n < length())
				return keyArray()[n];
			else if (n < 0) {
				// Shorter than 0, huh? Let's posi-tize the number, and see if
				// it's under the size of the array. If it is, we'll try and
				// fetch the elements in reverse order
				n = Pos(n);
				if (n <= length())
					return nthLastKey(n);
			}
			return 0;
		}
		String nthValue(int n) {
			if (n >= 0 && n < length())
				return array()[n];
			else if (n < 0) {
				// Shorter than 0, huh? Let's posi-tize the number, and see if
				// it's under the size of the array. If it is, we'll try and
				// fetch the elements in reverse order
				n = Pos(n);
				if (n <= length())
					return nthLastValue(n);
			}
			return "";
		}
		double nthLastKey(int n) {
			return n > 0 && n <= length() ? keyArray()[length() - n] : 0;
			// bugfixed
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
		treeDS combine(treeDS... trees) {
			if (not(trees))
				return this;
			for (treeDS tree : trees) {
				if (not(tree))
					continue;
				super.putAll(tree);
			}
			return this;
		}
		treeDS union(treeDS... trees) {
			combine(trees);
			return this;
		}
		treeDS cat(treeDS... trees) {
			combine(trees);
			return this;
		}
		treeDS concat(treeDS... trees) {
			combine(trees);
			return this;
		}
		treeDS join(treeDS... trees) {
			combine(trees);
			return this;
		}
		String join() {
			return string();
		}
		String join(String s) {
			if (not(s) || not(length()))
				return string();
			return KL.join(array(), s);
		}
		boolean has(Object o) {
			if (o instanceof Double)
				return super.hasKey((double) o);
			else if (o instanceof String)
				return super.hasValue((String) o);
			return false;
		}
	}
	public static treeDS treeDS(double k1, String v1, double k2, String v2,
			double k3, String v3, double k4, String v4, double k5, String v5,
			double k6, String v6, double k7, String v7, double k8, String v8,
			double k9, String v9, double k10, String v10) {
		return new treeDS(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7,
				v7, k8, v8, k9, v9, k10, v10);
	}
	public static treeDS treeDS(double k1, String v1, double k2, String v2,
			double k3, String v3, double k4, String v4, double k5, String v5,
			double k6, String v6, double k7, String v7, double k8, String v8,
			double k9, String v9) {
		return new treeDS(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7,
				v7, k8, v8, k9, v9);
	}
	public static treeDS treeDS(double k1, String v1, double k2, String v2,
			double k3, String v3, double k4, String v4, double k5, String v5,
			double k6, String v6, double k7, String v7, double k8, String v8) {
		return new treeDS(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7,
				v7, k8, v8);
	}
	public static treeDS treeDS(double k1, String v1, double k2, String v2,
			double k3, String v3, double k4, String v4, double k5, String v5,
			double k6, String v6, double k7, String v7) {
		return new treeDS(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7,
				v7);
	}
	public static treeDS treeDS(double k1, String v1, double k2, String v2,
			double k3, String v3, double k4, String v4, double k5, String v5,
			double k6, String v6) {
		return new treeDS(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
	}
	public static treeDS treeDS(double k1, String v1, double k2, String v2,
			double k3, String v3, double k4, String v4, double k5, String v5) {
		return new treeDS(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
	}
	public static treeDS treeDS(double k1, String v1, double k2, String v2,
			double k3, String v3, double k4, String v4) {
		return new treeDS(k1, v1, k2, v2, k3, v3, k4, v4);
	}
	public static treeDS treeDS(double k1, String v1, double k2, String v2,
			double k3, String v3) {
		return new treeDS(k1, v1, k2, v2, k3, v3);
	}
	public static treeDS treeDS(double k1, String v1, double k2, String v2) {
		return new treeDS(k1, v1, k2, v2);
	}
	public static treeDS treeDS(double k1, String v1) {
		return new treeDS(k1, v1);
	}
	public static class treeDI extends tree<Double, Integer> {
		public static final long serialVersionUID = 1L;
		treeDI() {
			super();
		}
		treeDI(double k1, int v1, double k2, int v2, double k3, int v3,
				double k4, int v4, double k5, int v5, double k6, int v6,
				double k7, int v7, double k8, int v8, double k9, int v9,
				double k10, int v10) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8,
					v8, k9, v9, k10, v10);
		}
		treeDI(double k1, int v1, double k2, int v2, double k3, int v3,
				double k4, int v4, double k5, int v5, double k6, int v6,
				double k7, int v7, double k8, int v8, double k9, int v9) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8,
					v8, k9, v9);
		}
		treeDI(double k1, int v1, double k2, int v2, double k3, int v3,
				double k4, int v4, double k5, int v5, double k6, int v6,
				double k7, int v7, double k8, int v8) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8,
					v8);
		}
		treeDI(double k1, int v1, double k2, int v2, double k3, int v3,
				double k4, int v4, double k5, int v5, double k6, int v6,
				double k7, int v7) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7);
		}
		treeDI(double k1, int v1, double k2, int v2, double k3, int v3,
				double k4, int v4, double k5, int v5, double k6, int v6) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
		}
		treeDI(double k1, int v1, double k2, int v2, double k3, int v3,
				double k4, int v4, double k5, int v5) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
		}
		treeDI(double k1, int v1, double k2, int v2, double k3, int v3,
				double k4, int v4) {
			super(k1, v1, k2, v2, k3, v3, k4, v4);
		}
		treeDI(double k1, int v1, double k2, int v2, double k3, int v3) {
			super(k1, v1, k2, v2, k3, v3);
		}
		treeDI(double k1, int v1, double k2, int v2) {
			super(k1, v1, k2, v2);
		}
		treeDI(double k1, int v1) {
			super(k1, v1);
		}
		treeDI copy() {
			return (treeDI) super.clone();
		}
		treeDI slice() {
			return copy();
		}
		int random() {
			if (super.isEmpty())
				return 0;
			return i(randInt(length()));
		}
		int rand() {
			return random();
		}
		int any() {
			return random();
		}
		double[] keyArray() {
			Object[] objArray = super.keySet().toArray();
			double[] resultantArr = new double[objArray.length];
			for (int i = 0; i < objArray.length; i++) {
				resultantArr[i] = (double) objArray[i];
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
		double nthKey(int n) {
			if (n >= 0 && n < length())
				return keyArray()[n];
			else if (n < 0) {
				// Shorter than 0, huh? Let's posi-tize the number, and see if
				// it's under the size of the array. If it is, we'll try and
				// fetch the elements in reverse order
				n = Pos(n);
				if (n <= length())
					return nthLastKey(n);
			}
			return 0;
		}
		int nthValue(int n) {
			if (n >= 0 && n < length())
				return array()[n];
			else if (n < 0) {
				// Shorter than 0, huh? Let's posi-tize the number, and see if
				// it's under the size of the array. If it is, we'll try and
				// fetch the elements in reverse order
				n = Pos(n);
				if (n <= length())
					return nthLastValue(n);
			}
			return 0;
		}
		double nthLastKey(int n) {
			return n > 0 && n <= length() ? keyArray()[length() - n] : 0;
			// bugfixed
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
		treeDI combine(treeDI... trees) {
			if (not(trees))
				return this;
			for (treeDI tree : trees) {
				if (not(tree))
					continue;
				super.putAll(tree);
			}
			return this;
		}
		treeDI union(treeDI... trees) {
			combine(trees);
			return this;
		}
		treeDI cat(treeDI... trees) {
			combine(trees);
			return this;
		}
		treeDI concat(treeDI... trees) {
			combine(trees);
			return this;
		}
		treeDI join(treeDI... trees) {
			combine(trees);
			return this;
		}
		String join() {
			return string();
		}
		String join(String s) {
			if (not(s) || not(length()))
				return string();
			return KL.join(array(), s);
		}
		boolean has(Object o) {
			if (o instanceof Double)
				return super.hasKey((double) o);
			else if (o instanceof Integer)
				return super.hasValue((Integer) o);
			return false;
		}
	}
	public static class treeDL extends tree<Double, Long> {
		public static final long serialVersionUID = 1L;
		treeDL() {
			super();
		}
		treeDL(double k1, long v1, double k2, long v2, double k3, long v3,
				double k4, long v4, double k5, long v5, double k6, long v6,
				double k7, long v7, double k8, long v8, double k9, long v9,
				double k10, long v10) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8,
					v8, k9, v9, k10, v10);
		}
		treeDL(double k1, long v1, double k2, long v2, double k3, long v3,
				double k4, long v4, double k5, long v5, double k6, long v6,
				double k7, long v7, double k8, long v8, double k9, long v9) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8,
					v8, k9, v9);
		}
		treeDL(double k1, long v1, double k2, long v2, double k3, long v3,
				double k4, long v4, double k5, long v5, double k6, long v6,
				double k7, long v7, double k8, long v8) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8,
					v8);
		}
		treeDL(double k1, long v1, double k2, long v2, double k3, long v3,
				double k4, long v4, double k5, long v5, double k6, long v6,
				double k7, long v7) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7);
		}
		treeDL(double k1, long v1, double k2, long v2, double k3, long v3,
				double k4, long v4, double k5, long v5, double k6, long v6) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
		}
		treeDL(double k1, long v1, double k2, long v2, double k3, long v3,
				double k4, long v4, double k5, long v5) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
		}
		treeDL(double k1, long v1, double k2, long v2, double k3, long v3,
				double k4, long v4) {
			super(k1, v1, k2, v2, k3, v3, k4, v4);
		}
		treeDL(double k1, long v1, double k2, long v2, double k3, long v3) {
			super(k1, v1, k2, v2, k3, v3);
		}
		treeDL(double k1, long v1, double k2, long v2) {
			super(k1, v1, k2, v2);
		}
		treeDL(double k1, long v1) {
			super(k1, v1);
		}
		treeDL copy() {
			return (treeDL) super.clone();
		}
		treeDL slice() {
			return copy();
		}
		long random() {
			if (super.isEmpty())
				return 0;
			return i(randInt(length()));
		}
		long rand() {
			return random();
		}
		long any() {
			return random();
		}
		double[] keyArray() {
			Object[] objArray = super.keySet().toArray();
			double[] resultantArr = new double[objArray.length];
			for (int i = 0; i < objArray.length; i++) {
				resultantArr[i] = (double) objArray[i];
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
		double nthKey(int n) {
			if (n >= 0 && n < length())
				return keyArray()[n];
			else if (n < 0) {
				// Shorter than 0, huh? Let's posi-tize the number, and see if
				// it's under the size of the array. If it is, we'll try and
				// fetch the elements in reverse order
				n = Pos(n);
				if (n <= length())
					return nthLastKey(n);
			}
			return 0;
		}
		long nthValue(int n) {
			if (n >= 0 && n < length())
				return array()[n];
			else if (n < 0) {
				// Shorter than 0, huh? Let's posi-tize the number, and see if
				// it's under the size of the array. If it is, we'll try and
				// fetch the elements in reverse order
				n = Pos(n);
				if (n <= length())
					return nthLastValue(n);
			}
			return 0;
		}
		double nthLastKey(int n) {
			return n > 0 && n <= length() ? keyArray()[length() - n] : 0;
			// bugfixed
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
		treeDL combine(treeDL... trees) {
			if (not(trees))
				return this;
			for (treeDL tree : trees) {
				if (not(tree))
					continue;
				super.putAll(tree);
			}
			return this;
		}
		treeDL union(treeDL... trees) {
			combine(trees);
			return this;
		}
		treeDL cat(treeDL... trees) {
			combine(trees);
			return this;
		}
		treeDL concat(treeDL... trees) {
			combine(trees);
			return this;
		}
		treeDL join(treeDL... trees) {
			combine(trees);
			return this;
		}
		String join() {
			return string();
		}
		String join(String s) {
			if (not(s) || not(length()))
				return string();
			return KL.join(array(), s);
		}
		boolean has(Object o) {
			if (o instanceof Double)
				return super.hasKey((double) o);
			else if (o instanceof Long)
				return super.hasValue((Long) o);
			return false;
		}
	}
	public static treeDL treeDL(double k1, long v1, double k2, long v2,
			double k3, long v3, double k4, long v4, double k5, long v5,
			double k6, long v6, double k7, long v7, double k8, long v8,
			double k9, long v9, double k10, long v10) {
		return new treeDL(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7,
				v7, k8, v8, k9, v9, k10, v10);
	}
	public static treeDL treeDL(double k1, long v1, double k2, long v2,
			double k3, long v3, double k4, long v4, double k5, long v5,
			double k6, long v6, double k7, long v7, double k8, long v8,
			double k9, long v9) {
		return new treeDL(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7,
				v7, k8, v8, k9, v9);
	}
	public static treeDL treeDL(double k1, long v1, double k2, long v2,
			double k3, long v3, double k4, long v4, double k5, long v5,
			double k6, long v6, double k7, long v7, double k8, long v8) {
		return new treeDL(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7,
				v7, k8, v8);
	}
	public static treeDL treeDL(double k1, long v1, double k2, long v2,
			double k3, long v3, double k4, long v4, double k5, long v5,
			double k6, long v6, double k7, long v7) {
		return new treeDL(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7,
				v7);
	}
	public static treeDL treeDL(double k1, long v1, double k2, long v2,
			double k3, long v3, double k4, long v4, double k5, long v5,
			double k6, long v6) {
		return new treeDL(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
	}
	public static treeDL treeDL(double k1, long v1, double k2, long v2,
			double k3, long v3, double k4, long v4, double k5, long v5) {
		return new treeDL(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
	}
	public static treeDL treeDL(double k1, long v1, double k2, long v2,
			double k3, long v3, double k4, long v4) {
		return new treeDL(k1, v1, k2, v2, k3, v3, k4, v4);
	}
	public static treeDL treeDL(double k1, long v1, double k2, long v2,
			double k3, long v3) {
		return new treeDL(k1, v1, k2, v2, k3, v3);
	}
	public static treeDL treeDL(double k1, long v1, double k2, long v2) {
		return new treeDL(k1, v1, k2, v2);
	}
	public static treeDL treeDL(double k1, long v1) {
		return new treeDL(k1, v1);
	}
	public static class treeDF extends tree<Double, Float> {
		public static final long serialVersionUID = 1L;
		treeDF() {
			super();
		}
		treeDF(double k1, float v1, double k2, float v2, double k3, float v3,
				double k4, float v4, double k5, float v5, double k6, float v6,
				double k7, float v7, double k8, float v8, double k9, float v9,
				double k10, float v10) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8,
					v8, k9, v9, k10, v10);
		}
		treeDF(double k1, float v1, double k2, float v2, double k3, float v3,
				double k4, float v4, double k5, float v5, double k6, float v6,
				double k7, float v7, double k8, float v8, double k9, float v9) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8,
					v8, k9, v9);
		}
		treeDF(double k1, float v1, double k2, float v2, double k3, float v3,
				double k4, float v4, double k5, float v5, double k6, float v6,
				double k7, float v7, double k8, float v8) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8,
					v8);
		}
		treeDF(double k1, float v1, double k2, float v2, double k3, float v3,
				double k4, float v4, double k5, float v5, double k6, float v6,
				double k7, float v7) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7);
		}
		treeDF(double k1, float v1, double k2, float v2, double k3, float v3,
				double k4, float v4, double k5, float v5, double k6, float v6) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
		}
		treeDF(double k1, float v1, double k2, float v2, double k3, float v3,
				double k4, float v4, double k5, float v5) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
		}
		treeDF(double k1, float v1, double k2, float v2, double k3, float v3,
				double k4, float v4) {
			super(k1, v1, k2, v2, k3, v3, k4, v4);
		}
		treeDF(double k1, float v1, double k2, float v2, double k3, float v3) {
			super(k1, v1, k2, v2, k3, v3);
		}
		treeDF(double k1, float v1, double k2, float v2) {
			super(k1, v1, k2, v2);
		}
		treeDF(double k1, float v1) {
			super(k1, v1);
		}
		treeDF copy() {
			return (treeDF) super.clone();
		}
		treeDF slice() {
			return copy();
		}
		float random() {
			if (super.isEmpty())
				return 0;
			return i(randInt(length()));
		}
		float rand() {
			return random();
		}
		float any() {
			return random();
		}
		double[] keyArray() {
			Object[] objArray = super.keySet().toArray();
			double[] resultantArr = new double[objArray.length];
			for (int i = 0; i < objArray.length; i++) {
				resultantArr[i] = (double) objArray[i];
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
		double nthKey(int n) {
			if (n >= 0 && n < length())
				return keyArray()[n];
			else if (n < 0) {
				// Shorter than 0, huh? Let's posi-tize the number, and see if
				// it's under the size of the array. If it is, we'll try and
				// fetch the elements in reverse order
				n = Pos(n);
				if (n <= length())
					return nthLastKey(n);
			}
			return 0;
		}
		float nthValue(int n) {
			if (n >= 0 && n < length())
				return array()[n];
			else if (n < 0) {
				// Shorter than 0, huh? Let's posi-tize the number, and see if
				// it's under the size of the array. If it is, we'll try and
				// fetch the elements in reverse order
				n = Pos(n);
				if (n <= length())
					return nthLastValue(n);
			}
			return 0;
		}
		double nthLastKey(int n) {
			return n > 0 && n <= length() ? keyArray()[length() - n] : 0;
			// bugfixed
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
		treeDF combine(treeDF... trees) {
			if (not(trees))
				return this;
			for (treeDF tree : trees) {
				if (not(tree))
					continue;
				super.putAll(tree);
			}
			return this;
		}
		treeDF union(treeDF... trees) {
			combine(trees);
			return this;
		}
		treeDF cat(treeDF... trees) {
			combine(trees);
			return this;
		}
		treeDF concat(treeDF... trees) {
			combine(trees);
			return this;
		}
		treeDF join(treeDF... trees) {
			combine(trees);
			return this;
		}
		String join() {
			return string();
		}
		String join(String s) {
			if (not(s) || not(length()))
				return string();
			return KL.join(array(), s);
		}
		boolean has(Object o) {
			if (o instanceof Double)
				return super.hasKey((double) o);
			else if (o instanceof Float)
				return super.hasValue((Float) o);
			return false;
		}
	}
	public static treeDF treeDF(double k1, float v1, double k2, float v2,
			double k3, float v3, double k4, float v4, double k5, float v5,
			double k6, float v6, double k7, float v7, double k8, float v8,
			double k9, float v9, double k10, float v10) {
		return new treeDF(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7,
				v7, k8, v8, k9, v9, k10, v10);
	}
	public static treeDF treeDF(double k1, float v1, double k2, float v2,
			double k3, float v3, double k4, float v4, double k5, float v5,
			double k6, float v6, double k7, float v7, double k8, float v8,
			double k9, float v9) {
		return new treeDF(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7,
				v7, k8, v8, k9, v9);
	}
	public static treeDF treeDF(double k1, float v1, double k2, float v2,
			double k3, float v3, double k4, float v4, double k5, float v5,
			double k6, float v6, double k7, float v7, double k8, float v8) {
		return new treeDF(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7,
				v7, k8, v8);
	}
	public static treeDF treeDF(double k1, float v1, double k2, float v2,
			double k3, float v3, double k4, float v4, double k5, float v5,
			double k6, float v6, double k7, float v7) {
		return new treeDF(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7,
				v7);
	}
	public static treeDF treeDF(double k1, float v1, double k2, float v2,
			double k3, float v3, double k4, float v4, double k5, float v5,
			double k6, float v6) {
		return new treeDF(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
	}
	public static treeDF treeDF(double k1, float v1, double k2, float v2,
			double k3, float v3, double k4, float v4, double k5, float v5) {
		return new treeDF(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
	}
	public static treeDF treeDF(double k1, float v1, double k2, float v2,
			double k3, float v3, double k4, float v4) {
		return new treeDF(k1, v1, k2, v2, k3, v3, k4, v4);
	}
	public static treeDF treeDF(double k1, float v1, double k2, float v2,
			double k3, float v3) {
		return new treeDF(k1, v1, k2, v2, k3, v3);
	}
	public static treeDF treeDF(double k1, float v1, double k2, float v2) {
		return new treeDF(k1, v1, k2, v2);
	}
	public static treeDF treeDF(double k1, float v1) {
		return new treeDF(k1, v1);
	}
	public static class treeDB extends tree<Double, Boolean> {
		public static final long serialVersionUID = 1L;
		treeDB() {
			super();
		}
		treeDB(double k1, boolean v1, double k2, boolean v2, double k3,
				boolean v3, double k4, boolean v4, double k5, boolean v5,
				double k6, boolean v6, double k7, boolean v7, double k8,
				boolean v8, double k9, boolean v9, double k10, boolean v10) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8,
					v8, k9, v9, k10, v10);
		}
		treeDB(double k1, boolean v1, double k2, boolean v2, double k3,
				boolean v3, double k4, boolean v4, double k5, boolean v5,
				double k6, boolean v6, double k7, boolean v7, double k8,
				boolean v8, double k9, boolean v9) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8,
					v8, k9, v9);
		}
		treeDB(double k1, boolean v1, double k2, boolean v2, double k3,
				boolean v3, double k4, boolean v4, double k5, boolean v5,
				double k6, boolean v6, double k7, boolean v7, double k8,
				boolean v8) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8,
					v8);
		}
		treeDB(double k1, boolean v1, double k2, boolean v2, double k3,
				boolean v3, double k4, boolean v4, double k5, boolean v5,
				double k6, boolean v6, double k7, boolean v7) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7);
		}
		treeDB(double k1, boolean v1, double k2, boolean v2, double k3,
				boolean v3, double k4, boolean v4, double k5, boolean v5,
				double k6, boolean v6) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
		}
		treeDB(double k1, boolean v1, double k2, boolean v2, double k3,
				boolean v3, double k4, boolean v4, double k5, boolean v5) {
			super(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
		}
		treeDB(double k1, boolean v1, double k2, boolean v2, double k3,
				boolean v3, double k4, boolean v4) {
			super(k1, v1, k2, v2, k3, v3, k4, v4);
		}
		treeDB(double k1, boolean v1, double k2, boolean v2, double k3,
				boolean v3) {
			super(k1, v1, k2, v2, k3, v3);
		}
		treeDB(double k1, boolean v1, double k2, boolean v2) {
			super(k1, v1, k2, v2);
		}
		treeDB(double k1, boolean v1) {
			super(k1, v1);
		}
		treeDB copy() {
			return (treeDB) super.clone();
		}
		treeDB slice() {
			return copy();
		}
		boolean random() {
			if (super.isEmpty())
				return false;
			return i(randInt(length()));
		}
		boolean rand() {
			return random();
		}
		boolean any() {
			return random();
		}
		double[] keyArray() {
			Object[] objArray = super.keySet().toArray();
			double[] resultantArr = new double[objArray.length];
			for (int i = 0; i < objArray.length; i++) {
				resultantArr[i] = (double) objArray[i];
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
		double nthKey(int n) {
			if (n >= 0 && n < length())
				return keyArray()[n];
			else if (n < 0) {
				// Shorter than 0, huh? Let's posi-tize the number, and see if
				// it's under the size of the array. If it is, we'll try and
				// fetch the elements in reverse order
				n = Pos(n);
				if (n <= length())
					return nthLastKey(n);
			}
			return 0;
		}
		boolean nthValue(int n) {
			if (n >= 0 && n < length())
				return array()[n];
			else if (n < 0) {
				// Shorter than 0, huh? Let's posi-tize the number, and see if
				// it's under the size of the array. If it is, we'll try and
				// fetch the elements in reverse order
				n = Pos(n);
				if (n <= length())
					return nthLastValue(n);
			}
			return false;
		}
		double nthLastKey(int n) {
			return n > 0 && n <= length() ? keyArray()[length() - n] : 0;
			// bugfixed
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
		treeDB combine(treeDB... trees) {
			if (not(trees))
				return this;
			for (treeDB tree : trees) {
				if (not(tree))
					continue;
				super.putAll(tree);
			}
			return this;
		}
		treeDB union(treeDB... trees) {
			combine(trees);
			return this;
		}
		treeDB cat(treeDB... trees) {
			combine(trees);
			return this;
		}
		treeDB concat(treeDB... trees) {
			combine(trees);
			return this;
		}
		treeDB join(treeDB... trees) {
			combine(trees);
			return this;
		}
		String join() {
			return string();
		}
		String join(String s) {
			if (not(s) || not(length()))
				return string();
			return KL.join(array(), s);
		}
		boolean has(Object o) {
			if (o instanceof Double)
				return super.hasKey((double) o);
			else if (o instanceof Boolean)
				return super.hasValue((Boolean) o);
			return false;
		}
	}
	public static treeDB treeDB(double k1, boolean v1, double k2, boolean v2,
			double k3, boolean v3, double k4, boolean v4, double k5, boolean v5,
			double k6, boolean v6, double k7, boolean v7, double k8, boolean v8,
			double k9, boolean v9, double k10, boolean v10) {
		return new treeDB(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7,
				v7, k8, v8, k9, v9, k10, v10);
	}
	public static treeDB treeDB(double k1, boolean v1, double k2, boolean v2,
			double k3, boolean v3, double k4, boolean v4, double k5, boolean v5,
			double k6, boolean v6, double k7, boolean v7, double k8, boolean v8,
			double k9, boolean v9) {
		return new treeDB(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7,
				v7, k8, v8, k9, v9);
	}
	public static treeDB treeDB(double k1, boolean v1, double k2, boolean v2,
			double k3, boolean v3, double k4, boolean v4, double k5, boolean v5,
			double k6, boolean v6, double k7, boolean v7, double k8,
			boolean v8) {
		return new treeDB(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7,
				v7, k8, v8);
	}
	public static treeDB treeDB(double k1, boolean v1, double k2, boolean v2,
			double k3, boolean v3, double k4, boolean v4, double k5, boolean v5,
			double k6, boolean v6, double k7, boolean v7) {
		return new treeDB(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7,
				v7);
	}
	public static treeDB treeDB(double k1, boolean v1, double k2, boolean v2,
			double k3, boolean v3, double k4, boolean v4, double k5, boolean v5,
			double k6, boolean v6) {
		return new treeDB(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
	}
	public static treeDB treeDB(double k1, boolean v1, double k2, boolean v2,
			double k3, boolean v3, double k4, boolean v4, double k5,
			boolean v5) {
		return new treeDB(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
	}
	public static treeDB treeDB(double k1, boolean v1, double k2, boolean v2,
			double k3, boolean v3, double k4, boolean v4) {
		return new treeDB(k1, v1, k2, v2, k3, v3, k4, v4);
	}
	public static treeDB treeDB(double k1, boolean v1, double k2, boolean v2,
			double k3, boolean v3) {
		return new treeDB(k1, v1, k2, v2, k3, v3);
	}
	public static treeDB treeDB(double k1, boolean v1, double k2, boolean v2) {
		return new treeDB(k1, v1, k2, v2);
	}
	public static treeDB treeDB(double k1, boolean v1) {
		return new treeDB(k1, v1);
	}
	public static final class strArr extends ArrayList<String> {
		strArr() {
			super();
		}
		strArr(String... strings) {
			super();
			for (String s : strings)
				super.add(s);
		}
		strArr pushAt(int i, String... strings) {
			if (i >= 0 && i <= super.size() && 0 != len(strings)) {
				for (String s : strings) {
					if (!KL.isEmpty(s))
						super.add(i, s);
				}
			}
			return this;
		}
		strArr pushStart(String... strings) {
			if (0 != len(strings))
				pushAt(0, strings);
			return this;
		}
		strArr push(String... strings) {
			if (0 != len(strings))
				pushAt(super.size(), strings);
			return this;
		}
		strArr push(String[]... stringArrays) {
			// this one's for appending entire arrays, for ease of pushing
			if (not(stringArrays))
				return this;
			for (int i : range(stringArrays)) {
				if (!KL.isNull(stringArrays[i]))
					pushAt(super.size(), stringArrays[i]);
			}
			return this;
		}
		strArr push(strArr... arrays) {
			return combine(arrays);
		}
		strArr pop(String[]... arrays) {
			return negativeIntersection(arrays);
		}
		strArr pop(strArr... arrays) {
			return negativeIntersection(arrays);
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
		strArr popIf(Predicate<? super String> fn) {
			super.removeIf(fn);
			return this;
		}
		strArr filterOut(Predicate<? super String> fn) {
			super.removeIf(fn);
			return this;
		}
		strArr keepIf(Predicate<? super String> fn) {
			super.removeIf(fn.negate());
			return this;
		}
		strArr filter(Predicate<? super String> fn) {
			super.removeIf(fn.negate());
			return this;
		}
		strArr map(UnaryOperator<String> fn) {
			super.replaceAll(fn);
			return this;
		}
		strArr unique() {
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
			if (i >= 0 && i < length())
				return array()[i];
			else if (i < 0) {
				// Shorter than 0, huh? Let's posi-tize the number, and see if
				// it's under the size of the array. If it is, we'll try and
				// fetch the elements in reverse order
				i = Pos(i);
				if (i <= length())
					return lasti(i);
			}
			return "";
		}
		String lasti(int n) {
			return !isNull(n) && n > 0 && n <= super.size()
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
		strArr update(int i, String x) {
			if (isNull(i) || isNull(x))
				return this;
			if (!has(x))
				super.add(x);
			else {
				if (i < 0 || i >= super.size())
					return this;
				super.set(i, x);
			}
			return this;
		}
		strArr shuffle() {
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
		strArr sort() {
			java.util.List newList = list();
			Collections.sort(newList, String.CASE_INSENSITIVE_ORDER);
			empty();
			super.addAll(newList);
			return this;
		}
		strArr sort(String condition) {
			if (not(condition))
				return this;
			if (condition.matches("^len(gth)?(:asc)?$")) {
				super.sort((s1, s2) -> len(s1) - len(s2));
			} else if (condition
					.matches("^len(gth)?:(desc|r(ev)?(ersed?)?)$")) {
				super.sort((s1, s2) -> len(s2) - len(s1));
			} else if (condition.matches("^(desc|r(ev)?(ersed?)?)$")) {
				sortReverse();
			} else {
				sort();
			}
			return this;
		}
		strArr sortReverse() {
			java.util.List newList = list();
			Collections.sort(newList, String.CASE_INSENSITIVE_ORDER.reversed());
			empty();
			super.addAll(newList);
			return this;
		}
		strArr reverseSort() {
			sortReverse();
			return this;
		}
		strArr reverse() {
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
			strArr clone = copy();
			for (int i : range(clone))
				result.add(clone.i(i));
			return result;
		}
		String string() {
			return super.toString();
		}
		String str() {
			return string();
		}
		strArr slice(int x, int y) {
			if (isNull(x) || not(y) || y < x || x == y || x < 0 || x >= length()
					|| y <= 0 || y >= length())
				return copy();
			return new strArr(KL.slice(array(), x, y));
		}
		strArr slice(int x) {
			if (super.isEmpty() || not(x) || x < 0 || x >= length())
				return copy();
			return slice(x, length());
		}
		strArr slice() {
			return copy();
		}
		strArr sliceKeep(int x) {
			if (super.isEmpty() || not(x) || x < 0 || x >= length())
				return copy();
			return slice(0, x);
		}
		strArr sliceRight(int x) {
			if (super.isEmpty() || not(x) || x < 0 || x >= length())
				return copy();
			return slice(length() - x);
		}
		strArr sliceEnd(int x) {
			if (super.isEmpty() || not(x) || x < 0 || x >= length())
				return copy();
			return slice(0, length() - x);
		}
		strArr sliceOff(int x) {
			if (super.isEmpty() || not(x) || x < 0 || x >= length())
				return copy();
			return sliceEnd(x);
		}
		strArr sliceOut(int x) {
			if (super.isEmpty() || not(x) || x < 0 || x >= length())
				return copy();
			return sliceEnd(x);
		}
		String random() {
			if (super.isEmpty())
				return "";
			return i(randInt(length()));
		}
		String rand() {
			return random();
		}
		String any() {
			return random();
		}
		strArr empty() {
			super.clear();
			return this;
		}
		boolean eq(strArr arrB) {
			if (not(arrB))
				return false;
			strArr arrA = copy();
			arrA.sort();
			arrB.sort();
			return arrA.equals(arrB);
		}
		boolean compare(strArr arrB) {
			int oldLen = length(), newLen = intersection(arrB).length();
			return newLen > oldLen / 2;
		}
		strArr combine(strArr... arrays) {
			strArr arrA = copy();
			if (not(arrays))
				return arrA;
			for (strArr arrB : arrays) {
				if (not(arrB))
					continue;
				super.addAll(arrB);
			}
			return this;
		}
		strArr combine(String[]... arrays) {
			strArr arrA = copy();
			if (not(arrays))
				return arrA;
			for (String[] arrB : arrays)
				combine(new strArr(arrB));
			return this;
		}
		strArr union(strArr... arrays) {
			combine(arrays);
			return this;
		}
		strArr union(String[]... arrays) {
			combine(arrays);
			return this;
		}
		strArr cat(strArr... arrays) {
			combine(arrays);
			return this;
		}
		strArr cat(String[]... arrays) {
			combine(arrays);
			return this;
		}
		strArr concat(strArr... arrays) {
			combine(arrays);
			return this;
		}
		strArr concat(String[]... arrays) {
			combine(arrays);
			return this;
		}
		strArr join(strArr... arrays) {
			combine(arrays);
			return this;
		}
		strArr join(String[]... arrays) {
			combine(arrays);
			return this;
		}
		String join() {
			return string();
		}
		String join(String s) {
			if (not(s) || not(length()))
				return string();
			return KL.join(array(), s);
		}
		strArr intersection(strArr... arrays) {
			if (not(arrays))
				return this;
			for (strArr arrB : arrays) {
				if (not(arrB))
					return this;
				super.retainAll(arrB);
			}
			return this;
		}
		strArr intersection(String[]... arrays) {
			if (not(arrays))
				return this;
			for (String[] arrB : arrays)
				intersection(new strArr(arrB));
			return this;
		}
		strArr negativeIntersection(strArr... arrays) {
			if (not(arrays))
				return this;
			for (strArr arrB : arrays) {
				if (not(arrB))
					return this;
				super.removeAll(arrB);
			}
			return this;
		}
		strArr negativeIntersection(String[]... arrays) {
			if (not(arrays))
				return this;
			for (String[] arrB : arrays)
				negativeIntersection(new strArr(arrB));
			return this;
		}
		strArr map(String oldVal, String newVal) {
			int index = super.indexOf(oldVal);
			if (not(oldVal) || not(newVal) || isNeg(index))
				return this;
			super.set(index, newVal);
			return this;
		}
		strArr update(String oldVal, String newVal) {
			return map(oldVal, newVal);
		}
		strArr copy() {
			return (strArr) super.clone();
		}
		strArr each(Consumer<? super String> fn) {
			if (not(fn))
				return this;
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
	public static strArr strArr(String... strings) {
		return new strArr(strings);
	}
	public static final class intArr extends ArrayList<Integer> {
		intArr() {
			super();
		}
		intArr(int... nums) {
			super();
			for (int n : nums)
				super.add(n);
		}
		intArr pushAt(int i, int... ints) {
			if (i >= 0 && i <= super.size() && 0 != len(ints)) {
				for (int n : ints)
					super.add(i, n);
			}
			return this;
		}
		intArr pushStart(int... ints) {
			if (0 != len(ints))
				pushAt(0, ints);
			return this;
		}
		intArr push(int... ints) {
			if (0 != len(ints))
				pushAt(super.size(), ints);
			return this;
		}
		intArr push(int[]... intArrays) {
			// this one's for appending entire arrays, for ease of pushing
			if (not(intArrays))
				return this;
			for (int i : range(intArrays)) {
				if (!KL.isNull(intArrays[i]))
					pushAt(super.size(), intArrays[i]);
			}
			return this;
		}
		intArr push(intArr... arrays) {
			return combine(arrays);
		}
		intArr pop(int[]... arrays) {
			return negativeIntersection(arrays);
		}
		intArr pop(intArr... arrays) {
			return negativeIntersection(arrays);
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
		intArr popIf(Predicate<? super Integer> fn) {
			super.removeIf(fn);
			return this;
		}
		intArr filterOut(Predicate<? super Integer> fn) {
			super.removeIf(fn);
			return this;
		}
		intArr keepIf(Predicate<? super Integer> fn) {
			super.removeIf(fn.negate());
			return this;
		}
		intArr filter(Predicate<? super Integer> fn) {
			super.removeIf(fn.negate());
			return this;
		}
		intArr map(UnaryOperator<Integer> fn) {
			super.replaceAll(fn);
			return this;
		}
		intArr unique() {
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
			if (i >= 0 && i < length())
				return array()[i];
			else if (i < 0) {
				// Shorter than 0, huh? Let's posi-tize the number, and see if
				// it's under the size of the array. If it is, we'll try and
				// fetch the elements in reverse order
				i = Pos(i);
				if (i <= length())
					return lasti(i);
			}
			return 0;
		}
		int lasti(int n) {
			return !isNull(n) && n > 0 && n <= super.size()
					? super.get(super.size() - n)
					: 0;
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
		intArr shuffle() {
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
		intArr sort() {
			super.sort(null);
			return this;
		}
		intArr sort(String condition) {
			if (not(condition))
				return this;
			if (condition.matches("^len(gth)?(:asc)?$")) {
				super.sort((s1, s2) -> len(s1) - len(s2));
			} else if (condition
					.matches("^len(gth)?:(desc|r(ev)?(ersed?)?)$")) {
				super.sort((s1, s2) -> len(s2) - len(s1));
			} else if (condition.matches("^(desc|r(ev)?(ersed?)?)$")) {
				sortReverse();
			} else {
				sort();
			}
			return this;
		}
		intArr sortReverse() {
			super.sort(Collections.reverseOrder());
			return this;
		}
		intArr reverseSort() {
			sortReverse();
			return this;
		}
		intArr reverse() {
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
			intArr clone = copy();
			for (int i : range(clone))
				result.add(clone.i(i));
			return result;
		}
		String string() {
			return super.toString();
		}
		String str() {
			return string();
		}
		intArr slice(int x, int y) {
			if (isNull(x) || not(y) || y < x || x == y || x < 0 || x >= length()
					|| y <= 0 || y >= length())
				return copy();
			return new intArr(KL.slice(array(), x, y));
		}
		intArr slice(int x) {
			if (super.isEmpty() || not(x) || x < 0 || x >= length())
				return copy();
			return slice(x, length());
		}
		intArr slice() {
			return copy();
		}
		intArr sliceKeep(int x) {
			if (super.isEmpty() || not(x) || x < 0 || x >= length())
				return copy();
			return slice(0, x);
		}
		intArr sliceRight(int x) {
			if (super.isEmpty() || not(x) || x < 0 || x >= length())
				return copy();
			return slice(length() - x);
		}
		intArr sliceEnd(int x) {
			if (super.isEmpty() || not(x) || x < 0 || x >= length())
				return copy();
			return slice(0, length() - x);
		}
		intArr sliceOff(int x) {
			if (super.isEmpty() || not(x) || x < 0 || x >= length())
				return copy();
			return sliceEnd(x);
		}
		intArr sliceOut(int x) {
			if (super.isEmpty() || not(x) || x < 0 || x >= length())
				return copy();
			return sliceEnd(x);
		}
		int random() {
			if (super.isEmpty())
				return 0;
			return i(randInt(length()));
		}
		int rand() {
			return random();
		}
		int any() {
			return random();
		}
		intArr empty() {
			super.clear();
			return this;
		}
		boolean eq(intArr arrB) {
			if (not(arrB))
				return false;
			intArr arrA = copy();
			arrA.sort();
			arrB.sort();
			return arrA.equals(arrB);
		}
		boolean compare(intArr arrB) {
			int oldLen = length(), newLen = intersection(arrB).length();
			return newLen > oldLen / 2;
		}
		intArr combine(intArr... arrays) {
			intArr arrA = copy();
			if (not(arrays))
				return arrA;
			for (intArr arrB : arrays) {
				if (not(arrB))
					continue;
				super.addAll(arrB);
			}
			return this;
		}
		intArr combine(int[]... arrays) {
			intArr arrA = copy();
			if (not(arrays))
				return arrA;
			for (int[] arrB : arrays)
				combine(new intArr(arrB));
			return this;
		}
		intArr union(intArr... arrays) {
			combine(arrays);
			return this;
		}
		intArr union(int[]... arrays) {
			combine(arrays);
			return this;
		}
		intArr cat(intArr... arrays) {
			combine(arrays);
			return this;
		}
		intArr cat(int[]... arrays) {
			combine(arrays);
			return this;
		}
		intArr concat(intArr... arrays) {
			combine(arrays);
			return this;
		}
		intArr concat(int[]... arrays) {
			combine(arrays);
			return this;
		}
		intArr join(intArr... arrays) {
			combine(arrays);
			return this;
		}
		intArr join(int[]... arrays) {
			combine(arrays);
			return this;
		}
		String join() {
			return string();
		}
		String join(String s) {
			if (not(s) || not(length()))
				return string();
			return KL.join(array(), s);
		}
		intArr intersection(intArr... arrays) {
			if (not(arrays))
				return this;
			for (intArr arrB : arrays) {
				if (not(arrB))
					return this;
				super.retainAll(arrB);
			}
			return this;
		}
		intArr intersection(int[]... arrays) {
			if (not(arrays))
				return this;
			for (int[] arrB : arrays)
				intersection(new intArr(arrB));
			return this;
		}
		intArr negativeIntersection(intArr... arrays) {
			if (not(arrays))
				return this;
			for (intArr arrB : arrays) {
				if (not(arrB))
					return this;
				super.removeAll(arrB);
			}
			return this;
		}
		intArr negativeIntersection(int[]... arrays) {
			if (not(arrays))
				return this;
			for (int[] arrB : arrays)
				negativeIntersection(new intArr(arrB));
			return this;
		}
		intArr map(int oldVal, int newVal) {
			int index = super.indexOf(oldVal);
			if (not(oldVal) || not(newVal) || isNeg(index))
				return this;
			super.set(index, newVal);
			return this;
		}
		intArr copy() {
			return (intArr) super.clone();
		}
		intArr each(Consumer<? super Integer> fn) {
			if (not(fn))
				return this;
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
	public static intArr intArr(int... ints) {
		return new intArr(ints);
	}
	public static final class longArr extends ArrayList<Long> {
		longArr() {
			super();
		}
		longArr(long... nums) {
			super();
			for (long n : nums)
				super.add(n);
		}
		longArr pushAt(int i, long... longs) {
			if (i >= 0 && i <= super.size() && 0 != len(longs)) {
				for (long l : longs)
					super.add(i, l);
			}
			return this;
		}
		longArr pushStart(long... longs) {
			if (0 != len(longs))
				pushAt(0, longs);
			return this;
		}
		longArr push(long... longs) {
			if (0 != len(longs))
				pushAt(super.size(), longs);
			return this;
		}
		longArr push(long[]... longArrays) {
			// this one's for appending entire arrays, for ease of pushing
			if (not(longArrays))
				return this;
			for (int i : range(longArrays)) {
				if (!KL.isNull(longArrays[i]))
					pushAt(super.size(), longArrays[i]);
			}
			return this;
		}
		longArr push(longArr... arrays) {
			return combine(arrays);
		}
		longArr pop(long[]... arrays) {
			return negativeIntersection(arrays);
		}
		longArr pop(longArr... arrays) {
			return negativeIntersection(arrays);
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
		longArr popIf(Predicate<? super Long> fn) {
			super.removeIf(fn);
			return this;
		}
		longArr filterOut(Predicate<? super Long> fn) {
			super.removeIf(fn);
			return this;
		}
		longArr keepIf(Predicate<? super Long> fn) {
			super.removeIf(fn.negate());
			return this;
		}
		longArr filter(Predicate<? super Long> fn) {
			super.removeIf(fn.negate());
			return this;
		}
		longArr map(UnaryOperator<Long> fn) {
			super.replaceAll(fn);
			return this;
		}
		longArr unique() {
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
			if (i >= 0 && i < length())
				return array()[i];
			else if (i < 0) {
				// Shorter than 0, huh? Let's posi-tize the number, and see if
				// it's under the size of the array. If it is, we'll try and
				// fetch the elements in reverse order
				i = Pos(i);
				if (i <= length())
					return lasti(i);
			}
			return 0;
		}
		long lasti(int n) {
			return !isNull(n) && n > 0 && n <= super.size()
					? super.get(super.size() - n)
					: 0;
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
		longArr update(int i, long x) {
			if (isNull(i) || isNull(x))
				return this;
			if (!has(x))
				super.add(x);
			else {
				if (i < 0 || i >= super.size())
					return this;
				super.set(i, x);
			}
			return this;
		}
		longArr shuffle() {
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
		longArr sort() {
			super.sort(null);
			return this;
		}
		longArr sort(String condition) {
			if (not(condition))
				return this;
			if (condition.matches("^len(gth)?(:asc)?$")) {
				super.sort((s1, s2) -> len(s1) - len(s2));
			} else if (condition
					.matches("^len(gth)?:(desc|r(ev)?(ersed?)?)$")) {
				super.sort((s1, s2) -> len(s2) - len(s1));
			} else if (condition.matches("^(desc|r(ev)?(ersed?)?)$")) {
				sortReverse();
			} else {
				sort();
			}
			return this;
		}
		longArr sortReverse() {
			super.sort(Collections.reverseOrder());
			return this;
		}
		longArr reverseSort() {
			sortReverse();
			return this;
		}
		longArr reverse() {
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
			longArr clone = copy();
			for (int i : range(clone))
				result.add(clone.i(i));
			return result;
		}
		String string() {
			return super.toString();
		}
		String str() {
			return string();
		}
		longArr slice(int x, int y) {
			if (isNull(x) || not(y) || y < x || x == y || x < 0 || x >= length()
					|| y <= 0 || y >= length())
				return copy();
			return new longArr(KL.slice(array(), x, y));
		}
		longArr slice(int x) {
			if (super.isEmpty() || not(x) || x < 0 || x >= length())
				return copy();
			return slice(x, length());
		}
		longArr slice() {
			return copy();
		}
		longArr sliceKeep(int x) {
			if (super.isEmpty() || not(x) || x < 0 || x >= length())
				return copy();
			return slice(0, x);
		}
		longArr sliceRight(int x) {
			if (super.isEmpty() || not(x) || x < 0 || x >= length())
				return copy();
			return slice(length() - x);
		}
		longArr sliceEnd(int x) {
			if (super.isEmpty() || not(x) || x < 0 || x >= length())
				return copy();
			return slice(0, length() - x);
		}
		longArr sliceOff(int x) {
			if (super.isEmpty() || not(x) || x < 0 || x >= length())
				return copy();
			return sliceEnd(x);
		}
		longArr sliceOut(int x) {
			if (super.isEmpty() || not(x) || x < 0 || x >= length())
				return copy();
			return sliceEnd(x);
		}
		long random() {
			if (super.isEmpty())
				return 0;
			return i(randInt(length()));
		}
		long rand() {
			return random();
		}
		long any() {
			return random();
		}
		longArr empty() {
			super.clear();
			return this;
		}
		boolean eq(longArr arrB) {
			if (not(arrB))
				return false;
			longArr arrA = copy();
			arrA.sort();
			arrB.sort();
			return arrA.equals(arrB);
		}
		boolean compare(longArr arrB) {
			int oldLen = length(), newLen = intersection(arrB).length();
			return newLen > oldLen / 2;
		}
		longArr combine(longArr... arrays) {
			longArr arrA = copy();
			if (not(arrays))
				return arrA;
			for (longArr arrB : arrays) {
				if (not(arrB))
					continue;
				super.addAll(arrB);
			}
			return this;
		}
		longArr combine(long[]... arrays) {
			longArr arrA = copy();
			if (not(arrays))
				return arrA;
			for (long[] arrB : arrays)
				combine(new longArr(arrB));
			return this;
		}
		longArr union(longArr... arrays) {
			combine(arrays);
			return this;
		}
		longArr union(long[]... arrays) {
			combine(arrays);
			return this;
		}
		longArr cat(longArr... arrays) {
			combine(arrays);
			return this;
		}
		longArr cat(long[]... arrays) {
			combine(arrays);
			return this;
		}
		longArr concat(longArr... arrays) {
			combine(arrays);
			return this;
		}
		longArr concat(long[]... arrays) {
			combine(arrays);
			return this;
		}
		longArr join(longArr... arrays) {
			combine(arrays);
			return this;
		}
		longArr join(long[]... arrays) {
			combine(arrays);
			return this;
		}
		String join() {
			return string();
		}
		String join(String s) {
			if (not(s) || not(length()))
				return string();
			return KL.join(array(), s);
		}
		longArr intersection(longArr... arrays) {
			if (not(arrays))
				return this;
			for (longArr arrB : arrays) {
				if (not(arrB))
					return this;
				super.retainAll(arrB);
			}
			return this;
		}
		longArr intersection(long[]... arrays) {
			if (not(arrays))
				return this;
			for (long[] arrB : arrays)
				intersection(new longArr(arrB));
			return this;
		}
		longArr negativeIntersection(longArr... arrays) {
			if (not(arrays))
				return this;
			for (longArr arrB : arrays) {
				if (not(arrB))
					return this;
				super.removeAll(arrB);
			}
			return this;
		}
		longArr negativeIntersection(long[]... arrays) {
			if (not(arrays))
				return this;
			for (long[] arrB : arrays)
				negativeIntersection(new longArr(arrB));
			return this;
		}
		longArr map(long oldVal, long newVal) {
			int index = super.indexOf(oldVal);
			if (not(oldVal) || not(newVal) || isNeg(index))
				return this;
			super.set(index, newVal);
			return this;
		}
		longArr update(long oldVal, long newVal) {
			return map(oldVal, newVal);
		}
		longArr copy() {
			return (longArr) super.clone();
		}
		longArr each(Consumer<? super Long> fn) {
			if (not(fn))
				return this;
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
	public static longArr longArr(long... longs) {
		return new longArr(longs);
	}
	public static final class fltArr extends ArrayList<Float> {
		fltArr() {
			super();
		}
		fltArr(float... nums) {
			super();
			for (float n : nums)
				super.add(n);
		}
		fltArr pushAt(int i, float... floats) {
			if (i >= 0 && i <= super.size() && 0 != len(floats)) {
				for (float f : floats)
					super.add(i, f);
			}
			return this;
		}
		fltArr pushStart(float... floats) {
			if (0 != len(floats))
				pushAt(0, floats);
			return this;
		}
		fltArr push(float... floats) {
			if (0 != len(floats))
				pushAt(super.size(), floats);
			return this;
		}
		fltArr push(float[]... fltArrays) {
			// this one's for appending entire arrays, for ease of pushing
			if (not(fltArrays))
				return this;
			for (int i : range(fltArrays)) {
				if (!KL.isNull(fltArrays[i]))
					pushAt(super.size(), fltArrays[i]);
			}
			return this;
		}
		fltArr push(fltArr... arrays) {
			return combine(arrays);
		}
		fltArr pop(float[]... arrays) {
			return negativeIntersection(arrays);
		}
		fltArr pop(fltArr... arrays) {
			return negativeIntersection(arrays);
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
		fltArr popIf(Predicate<? super Float> fn) {
			super.removeIf(fn);
			return this;
		}
		fltArr filterOut(Predicate<? super Float> fn) {
			super.removeIf(fn);
			return this;
		}
		fltArr keepIf(Predicate<? super Float> fn) {
			super.removeIf(fn.negate());
			return this;
		}
		fltArr filter(Predicate<? super Float> fn) {
			super.removeIf(fn.negate());
			return this;
		}
		fltArr map(UnaryOperator<Float> fn) {
			super.replaceAll(fn);
			return this;
		}
		fltArr unique() {
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
			if (i >= 0 && i < length())
				return array()[i];
			else if (i < 0) {
				// Shorter than 0, huh? Let's posi-tize the number, and see if
				// it's under the size of the array. If it is, we'll try and
				// fetch the elements in reverse order
				i = Pos(i);
				if (i <= length())
					return lasti(i);
			}
			return 0;
		}
		float lasti(int n) {
			return !isNull(n) && n > 0 && n <= super.size()
					? super.get(super.size() - n)
					: 0;
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
		fltArr update(int i, float x) {
			if (isNull(i) || isNull(x))
				return this;
			if (!has(x))
				super.add(x);
			else {
				if (i < 0 || i >= super.size())
					return this;
				super.set(i, x);
			}
			return this;
		}
		fltArr shuffle() {
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
		fltArr sort() {
			super.sort(null);
			return this;
		}
		fltArr sort(String condition) {
			if (not(condition))
				return this;
			if (condition.matches("^(desc|r(ev)?(ersed?)?)$")) {
				sortReverse();
			} else {
				sort();
			}
			return this;
		}
		fltArr sortReverse() {
			super.sort(Collections.reverseOrder());
			return this;
		}
		fltArr reverseSort() {
			sortReverse();
			return this;
		}
		fltArr reverse() {
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
			fltArr clone = copy();
			for (int i : range(clone))
				result.add(clone.i(i));
			return result;
		}
		String string() {
			return super.toString();
		}
		String str() {
			return string();
		}
		fltArr slice(int x, int y) {
			if (isNull(x) || not(y) || y < x || x == y || x < 0 || x >= length()
					|| y <= 0 || y >= length())
				return copy();
			return new fltArr(KL.slice(array(), x, y));
		}
		fltArr slice(int x) {
			if (super.isEmpty() || not(x) || x < 0 || x >= length())
				return copy();
			return slice(x, length());
		}
		fltArr slice() {
			return copy();
		}
		fltArr sliceKeep(int x) {
			if (super.isEmpty() || not(x) || x < 0 || x >= length())
				return copy();
			return slice(0, x);
		}
		fltArr sliceRight(int x) {
			if (super.isEmpty() || not(x) || x < 0 || x >= length())
				return copy();
			return slice(length() - x);
		}
		fltArr sliceEnd(int x) {
			if (super.isEmpty() || not(x) || x < 0 || x >= length())
				return copy();
			return slice(0, length() - x);
		}
		fltArr sliceOff(int x) {
			if (super.isEmpty() || not(x) || x < 0 || x >= length())
				return copy();
			return sliceEnd(x);
		}
		fltArr sliceOut(int x) {
			if (super.isEmpty() || not(x) || x < 0 || x >= length())
				return copy();
			return sliceEnd(x);
		}
		float random() {
			if (super.isEmpty())
				return 0;
			return i(randInt(length()));
		}
		float rand() {
			return random();
		}
		float any() {
			return random();
		}
		fltArr empty() {
			super.clear();
			return this;
		}
		boolean eq(fltArr arrB) {
			if (not(arrB))
				return false;
			fltArr arrA = copy();
			arrA.sort();
			arrB.sort();
			return arrA.equals(arrB);
		}
		boolean compare(fltArr arrB) {
			int oldLen = length(), newLen = intersection(arrB).length();
			return newLen > oldLen / 2;
		}
		fltArr combine(fltArr... arrays) {
			fltArr arrA = copy();
			if (not(arrays))
				return arrA;
			for (fltArr arrB : arrays) {
				if (not(arrB))
					continue;
				super.addAll(arrB);
			}
			return this;
		}
		fltArr combine(float[]... arrays) {
			fltArr arrA = copy();
			if (not(arrays))
				return arrA;
			for (float[] arrB : arrays)
				combine(new fltArr(arrB));
			return this;
		}
		fltArr union(fltArr... arrays) {
			combine(arrays);
			return this;
		}
		fltArr union(float[]... arrays) {
			combine(arrays);
			return this;
		}
		fltArr cat(fltArr... arrays) {
			combine(arrays);
			return this;
		}
		fltArr cat(float[]... arrays) {
			combine(arrays);
			return this;
		}
		fltArr concat(fltArr... arrays) {
			combine(arrays);
			return this;
		}
		fltArr concat(float[]... arrays) {
			combine(arrays);
			return this;
		}
		fltArr join(fltArr... arrays) {
			combine(arrays);
			return this;
		}
		fltArr join(float[]... arrays) {
			combine(arrays);
			return this;
		}
		String join() {
			return string();
		}
		String join(String s) {
			if (not(s) || not(length()))
				return string();
			return KL.join(array(), s);
		}
		fltArr intersection(fltArr... arrays) {
			if (not(arrays))
				return this;
			for (fltArr arrB : arrays) {
				if (not(arrB))
					return this;
				super.retainAll(arrB);
			}
			return this;
		}
		fltArr intersection(float[]... arrays) {
			if (not(arrays))
				return this;
			for (float[] arrB : arrays)
				intersection(new fltArr(arrB));
			return this;
		}
		fltArr negativeIntersection(fltArr... arrays) {
			if (not(arrays))
				return this;
			for (fltArr arrB : arrays) {
				if (not(arrB))
					return this;
				super.removeAll(arrB);
			}
			return this;
		}
		fltArr negativeIntersection(float[]... arrays) {
			if (not(arrays))
				return this;
			for (float[] arrB : arrays)
				negativeIntersection(new fltArr(arrB));
			return this;
		}
		fltArr map(float oldVal, float newVal) {
			int index = super.indexOf(oldVal);
			if (not(oldVal) || not(newVal) || isNeg(index))
				return this;
			super.set(index, newVal);
			return this;
		}
		fltArr update(float oldVal, float newVal) {
			return map(oldVal, newVal);
		}
		fltArr copy() {
			return (fltArr) super.clone();
		}
		fltArr each(Consumer<? super Float> fn) {
			if (not(fn))
				return this;
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
	public static fltArr fltArr(float... floats) {
		return new fltArr(floats);
	}
	public static final class dblArr extends ArrayList<Double> {
		dblArr() {
			super();
		}
		dblArr(double... doubles) {
			super();
			for (double d : doubles)
				super.add(d);
		}
		dblArr pushAt(int i, double... doubles) {
			if (i >= 0 && i <= super.size() && 0 != len(doubles)) {
				for (double d : doubles)
					super.add(i, d);
			}
			return this;
		}
		dblArr pushStart(double... doubles) {
			if (0 != len(doubles))
				pushAt(0, doubles);
			return this;
		}
		dblArr push(double... doubles) {
			if (0 != len(doubles))
				pushAt(super.size(), doubles);
			return this;
		}
		dblArr push(double[]... dblArrays) {
			// this one's for appending entire arrays, for ease of pushing
			if (not(dblArrays))
				return this;
			for (int i : range(dblArrays)) {
				if (!KL.isNull(dblArrays[i]))
					pushAt(super.size(), dblArrays[i]);
			}
			return this;
		}
		dblArr push(dblArr... arrays) {
			return combine(arrays);
		}
		dblArr pop(double[]... arrays) {
			return negativeIntersection(arrays);
		}
		dblArr pop(dblArr... arrays) {
			return negativeIntersection(arrays);
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
		dblArr popIf(Predicate<? super Double> fn) {
			super.removeIf(fn);
			return this;
		}
		dblArr filterOut(Predicate<? super Double> fn) {
			super.removeIf(fn);
			return this;
		}
		dblArr keepIf(Predicate<? super Double> fn) {
			super.removeIf(fn.negate());
			return this;
		}
		dblArr filter(Predicate<? super Double> fn) {
			super.removeIf(fn.negate());
			return this;
		}
		dblArr map(UnaryOperator<Double> fn) {
			super.replaceAll(fn);
			return this;
		}
		dblArr unique() {
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
			if (i >= 0 && i < length())
				return array()[i];
			else if (i < 0) {
				// Shorter than 0, huh? Let's posi-tize the number, and see if
				// it's under the size of the array. If it is, we'll try and
				// fetch the elements in reverse order
				i = Pos(i);
				if (i <= length())
					return lasti(i);
			}
			return 0;
		}
		double lasti(int n) {
			return !isNull(n) && n > 0 && n <= super.size()
					? super.get(super.size() - n)
					: 0;
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
		dblArr update(int i, double x) {
			if (isNull(i) || isNull(x))
				return this;
			if (!has(x))
				super.add(x);
			else {
				if (i < 0 || i >= super.size())
					return this;
				super.set(i, x);
			}
			return this;
		}
		dblArr shuffle() {
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
		dblArr sort() {
			super.sort(null);
			return this;
		}
		dblArr sort(String condition) {
			if (not(condition))
				return this;
			if (condition.matches("^(desc|r(ev)?(ersed?)?)$")) {
				sortReverse();
			} else {
				sort();
			}
			return this;
		}
		dblArr sortReverse() {
			super.sort(Collections.reverseOrder());
			return this;
		}
		dblArr reverseSort() {
			sortReverse();
			return this;
		}
		dblArr reverse() {
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
			dblArr clone = copy();
			for (int i : range(clone))
				result.add(clone.i(i));
			return result;
		}
		String string() {
			return super.toString();
		}
		String str() {
			return string();
		}
		dblArr slice(int x, int y) {
			if (isNull(x) || not(y) || y < x || x == y || x < 0 || x >= length()
					|| y <= 0 || y >= length())
				return copy();
			return new dblArr(KL.slice(array(), x, y));
		}
		dblArr slice(int x) {
			if (super.isEmpty() || not(x) || x < 0 || x >= length())
				return copy();
			return slice(x, length());
		}
		dblArr slice() {
			return copy();
		}
		dblArr sliceKeep(int x) {
			if (super.isEmpty() || not(x) || x < 0 || x >= length())
				return copy();
			return slice(0, x);
		}
		dblArr sliceRight(int x) {
			if (super.isEmpty() || not(x) || x < 0 || x >= length())
				return copy();
			return slice(length() - x);
		}
		dblArr sliceEnd(int x) {
			if (super.isEmpty() || not(x) || x < 0 || x >= length())
				return copy();
			return slice(0, length() - x);
		}
		dblArr sliceOff(int x) {
			if (super.isEmpty() || not(x) || x < 0 || x >= length())
				return copy();
			return sliceEnd(x);
		}
		dblArr sliceOut(int x) {
			if (super.isEmpty() || not(x) || x < 0 || x >= length())
				return copy();
			return sliceEnd(x);
		}
		double random() {
			if (super.isEmpty())
				return 0;
			return i(randInt(length()));
		}
		double rand() {
			return random();
		}
		double any() {
			return random();
		}
		dblArr empty() {
			super.clear();
			return this;
		}
		boolean eq(dblArr arrB) {
			if (not(arrB))
				return false;
			dblArr arrA = copy();
			arrA.sort();
			arrB.sort();
			return arrA.equals(arrB);
		}
		boolean compare(dblArr arrB) {
			int oldLen = length(), newLen = intersection(arrB).length();
			return newLen > oldLen / 2;
		}
		dblArr combine(dblArr... arrays) {
			dblArr arrA = copy();
			if (not(arrays))
				return arrA;
			for (dblArr arrB : arrays) {
				if (not(arrB))
					continue;
				super.addAll(arrB);
			}
			return this;
		}
		dblArr combine(double[]... arrays) {
			dblArr arrA = copy();
			if (not(arrays))
				return arrA;
			for (double[] arrB : arrays)
				combine(new dblArr(arrB));
			return this;
		}
		dblArr union(dblArr... arrays) {
			combine(arrays);
			return this;
		}
		dblArr union(double[]... arrays) {
			combine(arrays);
			return this;
		}
		dblArr cat(dblArr... arrays) {
			combine(arrays);
			return this;
		}
		dblArr cat(double[]... arrays) {
			combine(arrays);
			return this;
		}
		dblArr concat(dblArr... arrays) {
			combine(arrays);
			return this;
		}
		dblArr concat(double[]... arrays) {
			combine(arrays);
			return this;
		}
		dblArr join(dblArr... arrays) {
			combine(arrays);
			return this;
		}
		dblArr join(double[]... arrays) {
			combine(arrays);
			return this;
		}
		String join() {
			return string();
		}
		String join(String s) {
			if (not(s) || not(length()))
				return string();
			return KL.join(array(), s);
		}
		dblArr intersection(dblArr... arrays) {
			if (not(arrays))
				return this;
			for (dblArr arrB : arrays) {
				if (not(arrB))
					return this;
				super.retainAll(arrB);
			}
			return this;
		}
		dblArr intersection(double[]... arrays) {
			if (not(arrays))
				return this;
			for (double[] arrB : arrays)
				intersection(new dblArr(arrB));
			return this;
		}
		dblArr negativeIntersection(dblArr... arrays) {
			if (not(arrays))
				return this;
			for (dblArr arrB : arrays) {
				if (not(arrB))
					return this;
				super.removeAll(arrB);
			}
			return this;
		}
		dblArr negativeIntersection(double[]... arrays) {
			if (not(arrays))
				return this;
			for (double[] arrB : arrays)
				negativeIntersection(new dblArr(arrB));
			return this;
		}
		dblArr map(double oldVal, double newVal) {
			int index = super.indexOf(oldVal);
			if (not(oldVal) || not(newVal) || isNeg(index))
				return this;
			super.set(index, newVal);
			return this;
		}
		dblArr update(double oldVal, double newVal) {
			return map(oldVal, newVal);
		}
		dblArr copy() {
			return (dblArr) super.clone();
		}
		dblArr each(Consumer<? super Double> fn) {
			if (not(fn))
				return this;
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
	public static dblArr dblArr(double... doubles) {
		return new dblArr(doubles);
	}
	public static final class boolArr extends ArrayList<Boolean> {
		boolArr() {
			super();
		}
		boolArr(boolean... bools) {
			super();
			for (boolean b : bools)
				super.add(b);
		}
		boolArr pushAt(int i, boolean... bools) {
			if (i >= 0 && i <= super.size() && 0 != len(bools)) {
				for (boolean b : bools)
					super.add(i, b);
			}
			return this;
		}
		boolArr pushStart(boolean... bools) {
			if (0 != len(bools))
				pushAt(0, bools);
			return this;
		}
		boolArr push(boolean... bools) {
			if (0 != len(bools))
				pushAt(super.size(), bools);
			return this;
		}
		boolArr push(boolean[]... boolArrays) {
			// this one's for appending entire arrays, for ease of pushing
			if (not(boolArrays))
				return this;
			for (int i : range(boolArrays)) {
				if (!KL.isNull(boolArrays[i]))
					pushAt(super.size(), boolArrays[i]);
			}
			return this;
		}
		boolArr push(boolArr... arrays) {
			return combine(arrays);
		}
		boolArr pop(boolean[]... arrays) {
			return negativeIntersection(arrays);
		}
		boolArr pop(boolArr... arrays) {
			return negativeIntersection(arrays);
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
		boolArr popIf(Predicate<? super Boolean> fn) {
			super.removeIf(fn);
			return this;
		}
		boolArr filterOut(Predicate<? super Boolean> fn) {
			super.removeIf(fn);
			return this;
		}
		boolArr keepIf(Predicate<? super Boolean> fn) {
			super.removeIf(fn.negate());
			return this;
		}
		boolArr filter(Predicate<? super Boolean> fn) {
			super.removeIf(fn.negate());
			return this;
		}
		boolArr map(UnaryOperator<Boolean> fn) {
			super.replaceAll(fn);
			return this;
		}
		boolArr unique() {
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
			if (i >= 0 && i < length())
				return array()[i];
			else if (i < 0) {
				// Shorter than 0, huh? Let's posi-tize the number, and see if
				// it's under the size of the array. If it is, we'll try and
				// fetch the elements in reverse order
				i = Pos(i);
				if (i <= length())
					return lasti(i);
			}
			return false;
		}
		boolean lasti(int n) {
			return !isNull(n) && n > 0 && n <= super.size()
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
		boolArr update(int i, boolean x) {
			if (isNull(i) || isNull(x))
				return this;
			if (!has(x))
				super.add(x);
			else {
				if (i < 0 || i >= super.size())
					return this;
				super.set(i, x);
			}
			return this;
		}
		boolArr shuffle() {
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
		boolArr sort() {
			super.sort(null);
			return this;
		}
		boolArr sort(String condition) {
			if (not(condition))
				return this;
			if (condition.matches("^(desc|r(ev)?(ersed?)?)$")) {
				sortReverse();
			} else {
				sort();
			}
			return this;
		}
		boolArr sortReverse() {
			super.sort(Collections.reverseOrder());
			return this;
		}
		boolArr reverseSort() {
			sortReverse();
			return this;
		}
		boolArr reverse() {
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
			boolArr clone = copy();
			for (int i : range(clone))
				result.add(clone.i(i));
			return result;
		}
		String string() {
			return super.toString();
		}
		String str() {
			return string();
		}
		boolArr slice(int x, int y) {
			if (isNull(x) || not(y) || y < x || x == y || x < 0 || x >= length()
					|| y <= 0 || y >= length())
				return copy();
			return new boolArr(KL.slice(array(), x, y));
		}
		boolArr slice(int x) {
			if (super.isEmpty() || not(x) || x < 0 || x >= length())
				return copy();
			return slice(x, length());
		}
		boolArr slice() {
			return copy();
		}
		boolArr sliceKeep(int x) {
			if (super.isEmpty() || not(x) || x < 0 || x >= length())
				return copy();
			return slice(0, x);
		}
		boolArr sliceRight(int x) {
			if (super.isEmpty() || not(x) || x < 0 || x >= length())
				return copy();
			return slice(length() - x);
		}
		boolArr sliceEnd(int x) {
			if (super.isEmpty() || not(x) || x < 0 || x >= length())
				return copy();
			return slice(0, length() - x);
		}
		boolArr sliceOff(int x) {
			if (super.isEmpty() || not(x) || x < 0 || x >= length())
				return copy();
			return sliceEnd(x);
		}
		boolArr sliceOut(int x) {
			if (super.isEmpty() || not(x) || x < 0 || x >= length())
				return copy();
			return sliceEnd(x);
		}
		boolean random() {
			if (super.isEmpty())
				return false;
			return i(randInt(length()));
		}
		boolean rand() {
			return random();
		}
		boolean any() {
			return random();
		}
		boolArr empty() {
			super.clear();
			return this;
		}
		boolean eq(boolArr arrB) {
			if (not(arrB))
				return false;
			boolArr arrA = copy();
			arrA.sort();
			arrB.sort();
			return arrA.equals(arrB);
		}
		boolean compare(boolArr arrB) {
			int oldLen = length(), newLen = intersection(arrB).length();
			return newLen > oldLen / 2;
		}
		boolArr combine(boolArr... arrays) {
			boolArr arrA = copy();
			if (not(arrays))
				return arrA;
			for (boolArr arrB : arrays) {
				if (not(arrB))
					continue;
				super.addAll(arrB);
			}
			return this;
		}
		boolArr combine(boolean[]... arrays) {
			boolArr arrA = copy();
			if (not(arrays))
				return arrA;
			for (boolean[] arrB : arrays)
				combine(new boolArr(arrB));
			return this;
		}
		boolArr union(boolArr... arrays) {
			combine(arrays);
			return this;
		}
		boolArr union(boolean[]... arrays) {
			combine(arrays);
			return this;
		}
		boolArr cat(boolArr... arrays) {
			combine(arrays);
			return this;
		}
		boolArr cat(boolean[]... arrays) {
			combine(arrays);
			return this;
		}
		boolArr concat(boolArr... arrays) {
			combine(arrays);
			return this;
		}
		boolArr concat(boolean[]... arrays) {
			combine(arrays);
			return this;
		}
		boolArr join(boolArr... arrays) {
			combine(arrays);
			return this;
		}
		boolArr join(boolean[]... arrays) {
			combine(arrays);
			return this;
		}
		String join() {
			return string();
		}
		String join(String s) {
			if (not(s) || not(length()))
				return string();
			return KL.join(array(), s);
		}
		boolArr intersection(boolArr... arrays) {
			if (not(arrays))
				return this;
			for (boolArr arrB : arrays) {
				if (not(arrB))
					return this;
				super.retainAll(arrB);
			}
			return this;
		}
		boolArr intersection(boolean[]... arrays) {
			if (not(arrays))
				return this;
			for (boolean[] arrB : arrays)
				intersection(new boolArr(arrB));
			return this;
		}
		boolArr negativeIntersection(boolArr... arrays) {
			if (not(arrays))
				return this;
			for (boolArr arrB : arrays) {
				if (not(arrB))
					return this;
				super.removeAll(arrB);
			}
			return this;
		}
		boolArr negativeIntersection(boolean[]... arrays) {
			if (not(arrays))
				return this;
			for (boolean[] arrB : arrays)
				negativeIntersection(new boolArr(arrB));
			return this;
		}
		boolArr map(boolean oldVal, boolean newVal) {
			int index = super.indexOf(oldVal);
			if (not(oldVal) || not(newVal) || isNeg(index))
				return this;
			super.set(index, newVal);
			return this;
		}
		boolArr update(boolean oldVal, boolean newVal) {
			return map(oldVal, newVal);
		}
		boolArr copy() {
			return (boolArr) super.clone();
		}
		boolArr each(Consumer<? super Boolean> fn) {
			if (not(fn))
				return this;
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
	public static boolArr boolArr(boolean... bools) {
		return new boolArr(bools);
	}
	public static boolean runTask(Runnable fn) {
		if (not(fn))
			return false;
		new Thread(fn).run();
		return true;
	}
	private static final Map<Integer, Thread> timeoutThreads = new ConcurrentHashMap<>();
	private static int timeoutId = 0, iterationsDone = 0;
	public static int setTimeout(Runnable fn, int delay) {
		if (isNull(fn) || isNull(delay) || isInf(delay) || isNeg(delay))
			return -1;
		timeoutId++;
		Thread thread = new Thread(() -> {
			try {
				Thread.sleep(delay < 1000 ? delay * 1000 : delay);
			} catch (InterruptedException e) {
				print("[KL.Info.InterruptedTimeout]:\nThe timeout was interrupted, either intentionally or by a background task.");
				return;
			}
			SwingUtilities.invokeLater(fn);
		});
		timeoutThreads.put(timeoutId, thread);
		thread.start();
		return timeoutId;
	}
	public static void clearTimeout(int id) {
		Thread thread = timeoutThreads.remove(id);
		if (thread != null) {
			thread.interrupt();
		}
	}
	public static void delay(Runnable fn, int delay) {
		setTimeout(fn, delay);
	}
	public static void clearDelay(int id) {
		clearTimeout(id);
	}
	private static final Map<Integer, Thread> intervalThreads = new ConcurrentHashMap<>();
	private static int intervalId = 0;
	public static int setInterval(Runnable fn, int interval) {
		if (isNull(fn) || isNull(interval) || isInf(interval)
				|| isNeg(interval))
			return -1;
		intervalId++;
		Thread thread = new Thread(() -> {
			while (!Thread.currentThread().isInterrupted()) {
				try {
					Thread.sleep(interval < 1000 ? interval * 1000 : interval);
				} catch (InterruptedException e) {
					print("[KL.Info.InterruptedInterval]:\nThe interval was interrupted, either intentionally or by a background task.");
					break;
				}
				SwingUtilities.invokeLater(fn);
			}
		});
		intervalThreads.put(intervalId, thread);
		thread.start();
		return intervalId;
	}
	public static int setInterval(Runnable fn, int interval,
			int maxIterations) {
		if (isNull(fn) || isNull(interval) || isInf(interval) || isNeg(interval)
				|| isNull(maxIterations) || isInf(maxIterations)
				|| isNeg(maxIterations) || not(maxIterations))
			return -1;
		intervalId++;
		Thread thread = new Thread(() -> {
			while (!Thread.currentThread().isInterrupted()) {
				try {
					if (iterationsDone < maxIterations) {
						Thread.sleep(
								interval < 1000 ? interval * 1000 : interval);
						iterationsDone++;
					} else
						clearInterval(intervalId);
				} catch (InterruptedException e) {
					print("[KL.Info.InterruptedInterval]:\nThe interval was interrupted, either intentionally or by a background task.");
					break;
				}
				SwingUtilities.invokeLater(fn);
			}
		});
		intervalThreads.put(intervalId, thread);
		thread.start();
		return intervalId;
	}
	public static void clearInterval(int id) {
		Thread thread = intervalThreads.remove(id);
		if (thread != null) {
			thread.interrupt();
		}
	}
	public static boolean sw(Object src, Object cond1, Runnable sol1,
			Object cond2, Runnable sol2, Object cond3, Runnable sol3,
			Object cond4, Runnable sol4, Object cond5, Runnable sol5,
			Object cond6, Runnable sol6, Object cond7, Runnable sol7,
			Object cond8, Runnable sol8, Object cond9, Runnable sol9,
			Object cond10, Runnable sol10) {
		if (src instanceof Number || src instanceof Character) {
			double srcDbl = src instanceof Character
					? (char) src
					: Dbl(Str(src));
			if (cond1 instanceof String) {
				if (!in(Str(cond1), "(?<=[<>=])\\-?\\d*\\.?\\d")) {
					print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
					return false;
				}
				String cond1B = "";
				boolean either = false, both = false;
				if (in(Str(cond1),
						"\\s*[\\&\\|]{1,2}\\s*(?=[<>=]{1,2}\\-?\\d*\\.?\\d+)")) {
					String op = Str(cond1).replaceAll("[^\\&\\|]", "");
					if (in(op.replaceAll("[\\&]", ""), "\\|"))
						either = true;
					else
						both = true;
					String[] parts = Str(cond1).split("\\s*[\\&\\|]+\\s*");
					cond1 = parts[0];
					cond1B = parts[1];
				}
				double middleware = Dbl(
						Str(cond1).replaceAll("[^\\-\\d\\.]", "")),
						middlewareB = Dbl(
								Str(cond1B).replaceAll("[^\\-\\d\\.]", ""));
				cond1 = String(cond1).replaceAll("[^<>=]", "");
				cond1B = String(cond1B).replaceAll("[^<>=]", "");

				if (either) {
					if (eq(cond1, ">")) {
						if (eq(cond1B, ">")) {
							if (srcDbl > middleware || srcDbl > middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						} else if (eq(cond1B, ">=")) {
							if (srcDbl > middleware || srcDbl >= middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						} else if (eq(cond1B, "<")) {
							if (srcDbl > middleware || srcDbl < middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						} else if (eq(cond1B, "<=")) {
							if (srcDbl > middleware || srcDbl <= middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						} else if (eq(cond1B, "==")) {
							if (srcDbl > middleware || srcDbl == middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						}
					} else if (eq(cond1, ">=")) {
						if (eq(cond1B, ">")) {
							if (srcDbl >= middleware || srcDbl > middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						} else if (eq(cond1B, ">=")) {
							if (srcDbl >= middleware || srcDbl >= middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						} else if (eq(cond1B, "<")) {
							if (srcDbl >= middleware || srcDbl < middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						} else if (eq(cond1B, "<=")) {
							if (srcDbl >= middleware || srcDbl <= middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						} else if (eq(cond1B, "==")) {
							if (srcDbl >= middleware || srcDbl == middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						}
					} else if (eq(cond1, "<")) {
						if (eq(cond1B, ">")) {
							if (srcDbl < middleware || srcDbl > middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						} else if (eq(cond1B, ">=")) {
							if (srcDbl < middleware || srcDbl >= middlewareB) {

								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						} else if (eq(cond1B, "<")) {
							if (srcDbl < middleware || srcDbl < middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						} else if (eq(cond1B, "<=")) {
							if (srcDbl < middleware || srcDbl <= middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						} else if (eq(cond1B, "==")) {
							if (srcDbl < middleware || srcDbl == middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						}
					} else if (eq(cond1, "<=")) {
						if (eq(cond1B, ">")) {
							if (srcDbl <= middleware || srcDbl > middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						} else if (eq(cond1B, ">=")) {
							if (srcDbl <= middleware || srcDbl >= middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						} else if (eq(cond1B, "<")) {
							if (srcDbl <= middleware || srcDbl < middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						} else if (eq(cond1B, "<=")) {
							if (srcDbl <= middleware || srcDbl <= middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						} else if (eq(cond1B, "==")) {
							if (srcDbl <= middleware || srcDbl == middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						}
					} else if (eq(cond1, "==")) {
						if (eq(cond1B, ">")) {
							if (srcDbl == middleware || srcDbl > middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						} else if (eq(cond1B, ">=")) {
							if (srcDbl == middleware || srcDbl >= middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						} else if (eq(cond1B, "<")) {
							if (srcDbl == middleware || srcDbl < middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						} else if (eq(cond1B, "<=")) {
							if (srcDbl == middleware || srcDbl <= middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						} else if (eq(cond1B, "==")) {
							if (srcDbl == middleware || srcDbl == middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						}
					}
				} else if (both) {
					if (eq(cond1, ">")) {
						if (eq(cond1B, ">")) {
							if (srcDbl > middleware && srcDbl > middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						} else if (eq(cond1B, ">=")) {
							if (srcDbl > middleware && srcDbl >= middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						} else if (eq(cond1B, "<")) {
							if (srcDbl > middleware && srcDbl < middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						} else if (eq(cond1B, "<=")) {
							if (srcDbl > middleware && srcDbl <= middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						} else if (eq(cond1B, "==")) {
							if (srcDbl > middleware && srcDbl == middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						}
					} else if (eq(cond1, ">=")) {
						if (eq(cond1B, ">")) {
							if (srcDbl >= middleware && srcDbl > middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						} else if (eq(cond1B, ">=")) {
							if (srcDbl >= middleware && srcDbl >= middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						} else if (eq(cond1B, "<")) {
							if (srcDbl >= middleware && srcDbl < middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						} else if (eq(cond1B, "<=")) {
							if (srcDbl >= middleware && srcDbl <= middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						} else if (eq(cond1B, "==")) {
							if (srcDbl >= middleware && srcDbl == middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						}
					} else if (eq(cond1, "<")) {
						if (eq(cond1B, ">")) {
							if (srcDbl < middleware && srcDbl > middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						} else if (eq(cond1B, ">=")) {
							if (srcDbl < middleware && srcDbl >= middlewareB) {

								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						} else if (eq(cond1B, "<")) {
							if (srcDbl < middleware && srcDbl < middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						} else if (eq(cond1B, "<=")) {
							if (srcDbl < middleware && srcDbl <= middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						} else if (eq(cond1B, "==")) {
							if (srcDbl < middleware && srcDbl == middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						}
					} else if (eq(cond1, "<=")) {
						if (eq(cond1B, ">")) {
							if (srcDbl <= middleware && srcDbl > middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						} else if (eq(cond1B, ">=")) {
							if (srcDbl <= middleware && srcDbl >= middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						} else if (eq(cond1B, "<")) {
							if (srcDbl <= middleware && srcDbl < middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						} else if (eq(cond1B, "<=")) {
							if (srcDbl <= middleware && srcDbl <= middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						} else if (eq(cond1B, "==")) {
							if (srcDbl <= middleware && srcDbl == middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						}
					} else if (eq(cond1, "==")) {
						if (eq(cond1B, ">")) {
							if (srcDbl == middleware && srcDbl > middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						} else if (eq(cond1B, ">=")) {
							if (srcDbl == middleware && srcDbl >= middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						} else if (eq(cond1B, "<")) {
							if (srcDbl == middleware && srcDbl < middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						} else if (eq(cond1B, "<=")) {
							if (srcDbl == middleware && srcDbl <= middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						} else if (eq(cond1B, "==")) {
							if (srcDbl == middleware && srcDbl == middlewareB) {
								if (!isNull(sol1))
									new Thread(sol1).run();
								return true;
							}
						}
					}
				} else {
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
				}
			} else if (cond1 instanceof Number) {
				if (eq(srcDbl, Dbl(Str(cond1)))) {
					if (!isNull(sol1))
						new Thread(sol1).run();
					return true;
				}
			} else if (cond1 instanceof Character) {
				if (eq((char) src, (char) cond1)) {
					if (!isNull(sol1))
						new Thread(sol1).run();
					return true;
				}
			} else if (isNull(cond1)) {
				// NEEDED TO HANDLE NULL CASES: do nothing in this case, this
				// block only exists to BLOCK AWAY NULL references, and MUST
				// STAY!!
			} else {
				print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
				return false;
			}
			if (cond2 instanceof String) {
				if (!in(Str(cond2), "(?<=[<>=])\\-?\\d*\\.?\\d|else")) {
					print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
					return false;
				}
				String cond2B = "";
				boolean either = false, both = false;
				if (in(Str(cond2),
						"\\s*[\\&\\|]{1,2}\\s*(?=[<>=]{1,2}\\-?\\d*\\.?\\d+)")) {
					String op = Str(cond2).replaceAll("[^\\&\\|]", "");
					if (in(op.replaceAll("[\\&]", ""), "\\|"))
						either = true;
					else
						both = true;
					String[] parts = Str(cond2).split("\\s*[\\&\\|]+\\s*");
					cond2 = parts[0];
					cond2B = parts[1];
				}
				double middleware2 = Dbl(
						Str(cond2).replaceAll("[^\\-\\d\\.]", "")),
						middleware2B = Dbl(
								Str(cond2B).replaceAll("[^\\-\\d\\.]", ""));
				cond2 = String(cond2).replaceAll("[^<>=else]", "");
				cond2B = String(cond2B).replaceAll("[^<>=]", "");
				if (either) {
					if (eq(cond2, ">")) {
						if (eq(cond2B, ">")) {
							if (srcDbl > middleware2 || srcDbl > middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						} else if (eq(cond2B, ">=")) {
							if (srcDbl > middleware2
									|| srcDbl >= middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						} else if (eq(cond2B, "<")) {
							if (srcDbl > middleware2 || srcDbl < middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						} else if (eq(cond2B, "<=")) {
							if (srcDbl > middleware2
									|| srcDbl <= middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						} else if (eq(cond2B, "==")) {
							if (srcDbl > middleware2
									|| srcDbl == middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						}
					} else if (eq(cond2, ">=")) {
						if (eq(cond2B, ">")) {
							if (srcDbl >= middleware2
									|| srcDbl > middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						} else if (eq(cond2B, ">=")) {
							if (srcDbl >= middleware2
									|| srcDbl >= middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						} else if (eq(cond2B, "<")) {
							if (srcDbl >= middleware2
									|| srcDbl < middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						} else if (eq(cond2B, "<=")) {
							if (srcDbl >= middleware2
									|| srcDbl <= middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						} else if (eq(cond2B, "==")) {
							if (srcDbl >= middleware2
									|| srcDbl == middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						}
					} else if (eq(cond2, "<")) {
						if (eq(cond2B, ">")) {
							if (srcDbl < middleware2 || srcDbl > middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						} else if (eq(cond2B, ">=")) {
							if (srcDbl < middleware2
									|| srcDbl >= middleware2B) {

								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						} else if (eq(cond2B, "<")) {
							if (srcDbl < middleware2 || srcDbl < middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						} else if (eq(cond2B, "<=")) {
							if (srcDbl < middleware2
									|| srcDbl <= middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						} else if (eq(cond2B, "==")) {
							if (srcDbl < middleware2
									|| srcDbl == middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						}
					} else if (eq(cond2, "<=")) {
						if (eq(cond2B, ">")) {
							if (srcDbl <= middleware2
									|| srcDbl > middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						} else if (eq(cond2B, ">=")) {
							if (srcDbl <= middleware2
									|| srcDbl >= middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						} else if (eq(cond2B, "<")) {
							if (srcDbl <= middleware2
									|| srcDbl < middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						} else if (eq(cond2B, "<=")) {
							if (srcDbl <= middleware2
									|| srcDbl <= middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						} else if (eq(cond2B, "==")) {
							if (srcDbl <= middleware2
									|| srcDbl == middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						}
					} else if (eq(cond2, "==")) {
						if (eq(cond2B, ">")) {
							if (srcDbl == middleware2
									|| srcDbl > middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						} else if (eq(cond2B, ">=")) {
							if (srcDbl == middleware2
									|| srcDbl >= middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						} else if (eq(cond2B, "<")) {
							if (srcDbl == middleware2
									|| srcDbl < middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						} else if (eq(cond2B, "<=")) {
							if (srcDbl == middleware2
									|| srcDbl <= middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						} else if (eq(cond2B, "==")) {
							if (srcDbl == middleware2
									|| srcDbl == middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						}
					}
				} else if (both) {
					if (eq(cond2, ">")) {
						if (eq(cond2B, ">")) {
							if (srcDbl > middleware2 && srcDbl > middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						} else if (eq(cond2B, ">=")) {
							if (srcDbl > middleware2
									&& srcDbl >= middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						} else if (eq(cond2B, "<")) {
							if (srcDbl > middleware2 && srcDbl < middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						} else if (eq(cond2B, "<=")) {
							if (srcDbl > middleware2
									&& srcDbl <= middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						} else if (eq(cond2B, "==")) {
							if (srcDbl > middleware2
									&& srcDbl == middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						}
					} else if (eq(cond2, ">=")) {
						if (eq(cond2B, ">")) {
							if (srcDbl >= middleware2
									&& srcDbl > middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						} else if (eq(cond2B, ">=")) {
							if (srcDbl >= middleware2
									&& srcDbl >= middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						} else if (eq(cond2B, "<")) {
							if (srcDbl >= middleware2
									&& srcDbl < middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						} else if (eq(cond2B, "<=")) {
							if (srcDbl >= middleware2
									&& srcDbl <= middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						} else if (eq(cond2B, "==")) {
							if (srcDbl >= middleware2
									&& srcDbl == middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						}
					} else if (eq(cond2, "<")) {
						if (eq(cond2B, ">")) {
							if (srcDbl < middleware2 && srcDbl > middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						} else if (eq(cond2B, ">=")) {
							if (srcDbl < middleware2
									&& srcDbl >= middleware2B) {

								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						} else if (eq(cond2B, "<")) {
							if (srcDbl < middleware2 && srcDbl < middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						} else if (eq(cond2B, "<=")) {
							if (srcDbl < middleware2
									&& srcDbl <= middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						} else if (eq(cond2B, "==")) {
							if (srcDbl < middleware2
									&& srcDbl == middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						}
					} else if (eq(cond2, "<=")) {
						if (eq(cond2B, ">")) {
							if (srcDbl <= middleware2
									&& srcDbl > middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						} else if (eq(cond2B, ">=")) {
							if (srcDbl <= middleware2
									&& srcDbl >= middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						} else if (eq(cond2B, "<")) {
							if (srcDbl <= middleware2
									&& srcDbl < middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						} else if (eq(cond2B, "<=")) {
							if (srcDbl <= middleware2
									&& srcDbl <= middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						} else if (eq(cond2B, "==")) {
							if (srcDbl <= middleware2
									&& srcDbl == middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						}
					} else if (eq(cond2, "==")) {
						if (eq(cond2B, ">")) {
							if (srcDbl == middleware2
									&& srcDbl > middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						} else if (eq(cond2B, ">=")) {
							if (srcDbl == middleware2
									&& srcDbl >= middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						} else if (eq(cond2B, "<")) {
							if (srcDbl == middleware2
									&& srcDbl < middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						} else if (eq(cond2B, "<=")) {
							if (srcDbl == middleware2
									&& srcDbl <= middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						} else if (eq(cond2B, "==")) {
							if (srcDbl == middleware2
									&& srcDbl == middleware2B) {
								if (!isNull(sol2))
									new Thread(sol2).run();
								return true;
							}
						}
					}
				} else {
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
				}
			} else if (cond2 instanceof Number) {
				if (eq(srcDbl, Dbl(Str(cond2)))) {
					if (!isNull(sol2))
						new Thread(sol2).run();
					return true;
				}
			} else if (cond2 instanceof Character) {
				if (eq((char) src, (char) cond2)) {
					if (!isNull(sol2))
						new Thread(sol2).run();
					return true;
				}
			} else if (isNull(cond2)) {
				// NEEDED TO HANDLE NULL CASES: do nothing in this case, this
				// block only exists to BLOCK AWAY NULL references, and MUST
				// STAY!!
			} else {
				print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
				return false;
			}
			if (cond3 instanceof String) {
				if (!in(Str(cond3), "(?<=[<>=])\\-?\\d*\\.?\\d|else")) {
					print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
					return false;
				}
				String cond3B = "";
				boolean either = false, both = false;
				if (in(Str(cond3),
						"\\s*[\\&\\|]{1,2}\\s*(?=[<>=]\\-?\\d*\\.?\\d)")) {
					String op = Str(cond3).replaceAll("[^\\&\\|]", "");
					if (in(op.replaceAll("[\\&]", ""), "\\|"))
						either = true;
					else
						both = true;
					String[] parts = Str(cond3).split("\\s*[\\&\\|]+\\s*");
					cond3 = parts[0];
					cond3B = parts[1];
				}
				double middleware3 = Dbl(
						Str(cond3).replaceAll("[^\\-\\d\\.]", "")),
						middleware3B = Dbl(
								Str(cond3B).replaceAll("[^\\-\\d\\.]", ""));
				cond3 = String(cond3).replaceAll("[^<>=else]", "");
				cond3B = String(cond3B).replaceAll("[^<>=]", "");

				if (either) {
					if (eq(cond3, ">")) {
						if (eq(cond3B, ">")) {
							if (srcDbl > middleware3 || srcDbl > middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						} else if (eq(cond3B, ">=")) {
							if (srcDbl > middleware3
									|| srcDbl >= middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						} else if (eq(cond3B, "<")) {
							if (srcDbl > middleware3 || srcDbl < middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						} else if (eq(cond3B, "<=")) {
							if (srcDbl > middleware3
									|| srcDbl <= middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						} else if (eq(cond3B, "==")) {
							if (srcDbl > middleware3
									|| srcDbl == middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						}
					} else if (eq(cond3, ">=")) {
						if (eq(cond3B, ">")) {
							if (srcDbl >= middleware3
									|| srcDbl > middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						} else if (eq(cond3B, ">=")) {
							if (srcDbl >= middleware3
									|| srcDbl >= middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						} else if (eq(cond3B, "<")) {
							if (srcDbl >= middleware3
									|| srcDbl < middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						} else if (eq(cond3B, "<=")) {
							if (srcDbl >= middleware3
									|| srcDbl <= middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						} else if (eq(cond3B, "==")) {
							if (srcDbl >= middleware3
									|| srcDbl == middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						}
					} else if (eq(cond3, "<")) {
						if (eq(cond3B, ">")) {
							if (srcDbl < middleware3 || srcDbl > middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						} else if (eq(cond3B, ">=")) {
							if (srcDbl < middleware3
									|| srcDbl >= middleware3B) {

								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						} else if (eq(cond3B, "<")) {
							if (srcDbl < middleware3 || srcDbl < middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						} else if (eq(cond3B, "<=")) {
							if (srcDbl < middleware3
									|| srcDbl <= middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						} else if (eq(cond3B, "==")) {
							if (srcDbl < middleware3
									|| srcDbl == middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						}
					} else if (eq(cond3, "<=")) {
						if (eq(cond3B, ">")) {
							if (srcDbl <= middleware3
									|| srcDbl > middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						} else if (eq(cond3B, ">=")) {
							if (srcDbl <= middleware3
									|| srcDbl >= middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						} else if (eq(cond3B, "<")) {
							if (srcDbl <= middleware3
									|| srcDbl < middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						} else if (eq(cond3B, "<=")) {
							if (srcDbl <= middleware3
									|| srcDbl <= middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						} else if (eq(cond3B, "==")) {
							if (srcDbl <= middleware3
									|| srcDbl == middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						}
					} else if (eq(cond3, "==")) {
						if (eq(cond3B, ">")) {
							if (srcDbl == middleware3
									|| srcDbl > middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						} else if (eq(cond3B, ">=")) {
							if (srcDbl == middleware3
									|| srcDbl >= middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						} else if (eq(cond3B, "<")) {
							if (srcDbl == middleware3
									|| srcDbl < middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						} else if (eq(cond3B, "<=")) {
							if (srcDbl == middleware3
									|| srcDbl <= middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						} else if (eq(cond3B, "==")) {
							if (srcDbl == middleware3
									|| srcDbl == middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						}
					}
				} else if (both) {
					if (eq(cond3, ">")) {
						if (eq(cond3B, ">")) {
							if (srcDbl > middleware3 && srcDbl > middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						} else if (eq(cond3B, ">=")) {
							if (srcDbl > middleware3
									&& srcDbl >= middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						} else if (eq(cond3B, "<")) {
							if (srcDbl > middleware3 && srcDbl < middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						} else if (eq(cond3B, "<=")) {
							if (srcDbl > middleware3
									&& srcDbl <= middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						} else if (eq(cond3B, "==")) {
							if (srcDbl > middleware3
									&& srcDbl == middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						}
					} else if (eq(cond3, ">=")) {
						if (eq(cond3B, ">")) {
							if (srcDbl >= middleware3
									&& srcDbl > middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						} else if (eq(cond3B, ">=")) {
							if (srcDbl >= middleware3
									&& srcDbl >= middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						} else if (eq(cond3B, "<")) {
							if (srcDbl >= middleware3
									&& srcDbl < middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						} else if (eq(cond3B, "<=")) {
							if (srcDbl >= middleware3
									&& srcDbl <= middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						} else if (eq(cond3B, "==")) {
							if (srcDbl >= middleware3
									&& srcDbl == middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						}
					} else if (eq(cond3, "<")) {
						if (eq(cond3B, ">")) {
							if (srcDbl < middleware3 && srcDbl > middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						} else if (eq(cond3B, ">=")) {
							if (srcDbl < middleware3
									&& srcDbl >= middleware3B) {

								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						} else if (eq(cond3B, "<")) {
							if (srcDbl < middleware3 && srcDbl < middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						} else if (eq(cond3B, "<=")) {
							if (srcDbl < middleware3
									&& srcDbl <= middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						} else if (eq(cond3B, "==")) {
							if (srcDbl < middleware3
									&& srcDbl == middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						}
					} else if (eq(cond3, "<=")) {
						if (eq(cond3B, ">")) {
							if (srcDbl <= middleware3
									&& srcDbl > middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						} else if (eq(cond3B, ">=")) {
							if (srcDbl <= middleware3
									&& srcDbl >= middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						} else if (eq(cond3B, "<")) {
							if (srcDbl <= middleware3
									&& srcDbl < middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						} else if (eq(cond3B, "<=")) {
							if (srcDbl <= middleware3
									&& srcDbl <= middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						} else if (eq(cond3B, "==")) {
							if (srcDbl <= middleware3
									&& srcDbl == middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						}
					} else if (eq(cond3, "==")) {
						if (eq(cond3B, ">")) {
							if (srcDbl == middleware3
									&& srcDbl > middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						} else if (eq(cond3B, ">=")) {
							if (srcDbl == middleware3
									&& srcDbl >= middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						} else if (eq(cond3B, "<")) {
							if (srcDbl == middleware3
									&& srcDbl < middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						} else if (eq(cond3B, "<=")) {
							if (srcDbl == middleware3
									&& srcDbl <= middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						} else if (eq(cond3B, "==")) {
							if (srcDbl == middleware3
									&& srcDbl == middleware3B) {
								if (!isNull(sol3))
									new Thread(sol3).run();
								return true;
							}
						}
					}
				} else {
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
				}
			} else if (cond3 instanceof Number) {
				if (eq(srcDbl, Dbl(Str(cond3)))) {
					if (!isNull(sol3))
						new Thread(sol3).run();
					return true;
				}
			} else if (cond3 instanceof Character) {
				if (eq((char) src, (char) cond3)) {
					if (!isNull(sol3))
						new Thread(sol3).run();
					return true;
				}
			} else if (isNull(cond3)) {
				// NEEDED TO HANDLE NULL CASES: do nothing in this case, this
				// block only exists to BLOCK AWAY NULL references, and MUST
				// STAY!!
			} else {
				print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
				return false;
			}
			if (cond4 instanceof String) {
				if (!in(Str(cond4), "(?<=[<>=])\\-?\\d|else")) {
					print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
					return false;
				}
				if (!in(Str(cond4), "(?<=[<>=])\\-?\\d*\\.?\\d")) {
					print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
					return false;
				}
				String cond4B = "";
				boolean either = false, both = false;
				if (in(Str(cond4),
						"\\s*[\\&\\|]{1,2}\\s*(?=[<>=]\\-?\\d*\\.?\\d)")) {
					String op = Str(cond4).replaceAll("[^\\&\\|]", "");
					if (in(op.replaceAll("[\\&]", ""), "\\|"))
						either = true;
					else
						both = true;
					String[] parts = Str(cond4).split("\\s*[\\&\\|]+\\s*");
					cond4 = parts[0];
					cond4B = parts[1];
				}
				double middleware4 = Dbl(
						Str(cond4).replaceAll("[^\\-\\d\\.]", "")),
						middleware4B = Dbl(
								Str(cond4B).replaceAll("[^\\-\\d\\.]", ""));
				cond4 = String(cond4).replaceAll("[^<>=else]", "");
				cond4B = String(cond4B).replaceAll("[^<>=]", "");

				if (either) {
					if (eq(cond4, ">")) {
						if (eq(cond4B, ">")) {
							if (srcDbl > middleware4 || srcDbl > middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						} else if (eq(cond4B, ">=")) {
							if (srcDbl > middleware4
									|| srcDbl >= middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						} else if (eq(cond4B, "<")) {
							if (srcDbl > middleware4 || srcDbl < middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						} else if (eq(cond4B, "<=")) {
							if (srcDbl > middleware4
									|| srcDbl <= middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						} else if (eq(cond4B, "==")) {
							if (srcDbl > middleware4
									|| srcDbl == middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						}
					} else if (eq(cond4, ">=")) {
						if (eq(cond4B, ">")) {
							if (srcDbl >= middleware4
									|| srcDbl > middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						} else if (eq(cond4B, ">=")) {
							if (srcDbl >= middleware4
									|| srcDbl >= middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						} else if (eq(cond4B, "<")) {
							if (srcDbl >= middleware4
									|| srcDbl < middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						} else if (eq(cond4B, "<=")) {
							if (srcDbl >= middleware4
									|| srcDbl <= middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						} else if (eq(cond4B, "==")) {
							if (srcDbl >= middleware4
									|| srcDbl == middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						}
					} else if (eq(cond4, "<")) {
						if (eq(cond4B, ">")) {
							if (srcDbl < middleware4 || srcDbl > middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						} else if (eq(cond4B, ">=")) {
							if (srcDbl < middleware4
									|| srcDbl >= middleware4B) {

								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						} else if (eq(cond4B, "<")) {
							if (srcDbl < middleware4 || srcDbl < middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						} else if (eq(cond4B, "<=")) {
							if (srcDbl < middleware4
									|| srcDbl <= middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						} else if (eq(cond4B, "==")) {
							if (srcDbl < middleware4
									|| srcDbl == middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						}
					} else if (eq(cond4, "<=")) {
						if (eq(cond4B, ">")) {
							if (srcDbl <= middleware4
									|| srcDbl > middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						} else if (eq(cond4B, ">=")) {
							if (srcDbl <= middleware4
									|| srcDbl >= middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						} else if (eq(cond4B, "<")) {
							if (srcDbl <= middleware4
									|| srcDbl < middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						} else if (eq(cond4B, "<=")) {
							if (srcDbl <= middleware4
									|| srcDbl <= middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						} else if (eq(cond4B, "==")) {
							if (srcDbl <= middleware4
									|| srcDbl == middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						}
					} else if (eq(cond4, "==")) {
						if (eq(cond4B, ">")) {
							if (srcDbl == middleware4
									|| srcDbl > middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						} else if (eq(cond4B, ">=")) {
							if (srcDbl == middleware4
									|| srcDbl >= middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						} else if (eq(cond4B, "<")) {
							if (srcDbl == middleware4
									|| srcDbl < middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						} else if (eq(cond4B, "<=")) {
							if (srcDbl == middleware4
									|| srcDbl <= middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						} else if (eq(cond4B, "==")) {
							if (srcDbl == middleware4
									|| srcDbl == middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						}
					}
				} else if (both) {
					if (eq(cond4, ">")) {
						if (eq(cond4B, ">")) {
							if (srcDbl > middleware4 && srcDbl > middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						} else if (eq(cond4B, ">=")) {
							if (srcDbl > middleware4
									&& srcDbl >= middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						} else if (eq(cond4B, "<")) {
							if (srcDbl > middleware4 && srcDbl < middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						} else if (eq(cond4B, "<=")) {
							if (srcDbl > middleware4
									&& srcDbl <= middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						} else if (eq(cond4B, "==")) {
							if (srcDbl > middleware4
									&& srcDbl == middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						}
					} else if (eq(cond4, ">=")) {
						if (eq(cond4B, ">")) {
							if (srcDbl >= middleware4
									&& srcDbl > middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						} else if (eq(cond4B, ">=")) {
							if (srcDbl >= middleware4
									&& srcDbl >= middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						} else if (eq(cond4B, "<")) {
							if (srcDbl >= middleware4
									&& srcDbl < middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						} else if (eq(cond4B, "<=")) {
							if (srcDbl >= middleware4
									&& srcDbl <= middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						} else if (eq(cond4B, "==")) {
							if (srcDbl >= middleware4
									&& srcDbl == middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						}
					} else if (eq(cond4, "<")) {
						if (eq(cond4B, ">")) {
							if (srcDbl < middleware4 && srcDbl > middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						} else if (eq(cond4B, ">=")) {
							if (srcDbl < middleware4
									&& srcDbl >= middleware4B) {

								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						} else if (eq(cond4B, "<")) {
							if (srcDbl < middleware4 && srcDbl < middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						} else if (eq(cond4B, "<=")) {
							if (srcDbl < middleware4
									&& srcDbl <= middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						} else if (eq(cond4B, "==")) {
							if (srcDbl < middleware4
									&& srcDbl == middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						}
					} else if (eq(cond4, "<=")) {
						if (eq(cond4B, ">")) {
							if (srcDbl <= middleware4
									&& srcDbl > middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						} else if (eq(cond4B, ">=")) {
							if (srcDbl <= middleware4
									&& srcDbl >= middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						} else if (eq(cond4B, "<")) {
							if (srcDbl <= middleware4
									&& srcDbl < middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						} else if (eq(cond4B, "<=")) {
							if (srcDbl <= middleware4
									&& srcDbl <= middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						} else if (eq(cond4B, "==")) {
							if (srcDbl <= middleware4
									&& srcDbl == middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						}
					} else if (eq(cond4, "==")) {
						if (eq(cond4B, ">")) {
							if (srcDbl == middleware4
									&& srcDbl > middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						} else if (eq(cond4B, ">=")) {
							if (srcDbl == middleware4
									&& srcDbl >= middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						} else if (eq(cond4B, "<")) {
							if (srcDbl == middleware4
									&& srcDbl < middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						} else if (eq(cond4B, "<=")) {
							if (srcDbl == middleware4
									&& srcDbl <= middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						} else if (eq(cond4B, "==")) {
							if (srcDbl == middleware4
									&& srcDbl == middleware4B) {
								if (!isNull(sol4))
									new Thread(sol4).run();
								return true;
							}
						}
					}
				} else {
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
				}
			} else if (cond4 instanceof Number) {
				if (eq(srcDbl, Dbl(Str(cond4)))) {
					if (!isNull(sol4))
						new Thread(sol4).run();
					return true;
				}
			} else if (cond4 instanceof Character) {
				if (eq((char) src, (char) cond4)) {
					if (!isNull(sol4))
						new Thread(sol4).run();
					return true;
				}
			} else if (isNull(cond4)) {
				// NEEDED TO HANDLE NULL CASES: do nothing in this case, this
				// block only exists to BLOCK AWAY NULL references, and MUST
				// STAY!!
			} else {
				print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
				return false;
			}
			if (cond5 instanceof String) {
				if (!in(Str(cond5), "(?<=[<>=])\\-?\\d|else")) {
					print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
					return false;
				}
				String cond5B = "";
				boolean either = false, both = false;
				if (in(Str(cond5),
						"\\s*[\\&\\|]{1,2}\\s*(?=[<>=]\\-?\\d*\\.?\\d)")) {
					String op = Str(cond5).replaceAll("[^\\&\\|]", "");
					if (in(op.replaceAll("[\\&]", ""), "\\|"))
						either = true;
					else
						both = true;
					String[] parts = Str(cond5).split("\\s*[\\&\\|]+\\s*");
					cond5 = parts[0];
					cond5B = parts[1];
				}
				double middleware5 = Dbl(
						Str(cond5).replaceAll("[^\\-\\d\\.]", "")),
						middleware5B = Dbl(
								Str(cond5B).replaceAll("[^\\-\\d\\.]", ""));
				cond5 = String(cond5).replaceAll("[^<>=else]", "");
				cond5B = String(cond5B).replaceAll("[^<>=]", "");

				if (either) {
					if (eq(cond5, ">")) {
						if (eq(cond5B, ">")) {
							if (srcDbl > middleware5 || srcDbl > middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						} else if (eq(cond5B, ">=")) {
							if (srcDbl > middleware5
									|| srcDbl >= middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						} else if (eq(cond5B, "<")) {
							if (srcDbl > middleware5 || srcDbl < middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						} else if (eq(cond5B, "<=")) {
							if (srcDbl > middleware5
									|| srcDbl <= middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						} else if (eq(cond5B, "==")) {
							if (srcDbl > middleware5
									|| srcDbl == middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						}
					} else if (eq(cond5, ">=")) {
						if (eq(cond5B, ">")) {
							if (srcDbl >= middleware5
									|| srcDbl > middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						} else if (eq(cond5B, ">=")) {
							if (srcDbl >= middleware5
									|| srcDbl >= middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						} else if (eq(cond5B, "<")) {
							if (srcDbl >= middleware5
									|| srcDbl < middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						} else if (eq(cond5B, "<=")) {
							if (srcDbl >= middleware5
									|| srcDbl <= middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						} else if (eq(cond5B, "==")) {
							if (srcDbl >= middleware5
									|| srcDbl == middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						}
					} else if (eq(cond5, "<")) {
						if (eq(cond5B, ">")) {
							if (srcDbl < middleware5 || srcDbl > middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						} else if (eq(cond5B, ">=")) {
							if (srcDbl < middleware5
									|| srcDbl >= middleware5B) {

								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						} else if (eq(cond5B, "<")) {
							if (srcDbl < middleware5 || srcDbl < middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						} else if (eq(cond5B, "<=")) {
							if (srcDbl < middleware5
									|| srcDbl <= middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						} else if (eq(cond5B, "==")) {
							if (srcDbl < middleware5
									|| srcDbl == middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						}
					} else if (eq(cond5, "<=")) {
						if (eq(cond5B, ">")) {
							if (srcDbl <= middleware5
									|| srcDbl > middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						} else if (eq(cond5B, ">=")) {
							if (srcDbl <= middleware5
									|| srcDbl >= middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						} else if (eq(cond5B, "<")) {
							if (srcDbl <= middleware5
									|| srcDbl < middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						} else if (eq(cond5B, "<=")) {
							if (srcDbl <= middleware5
									|| srcDbl <= middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						} else if (eq(cond5B, "==")) {
							if (srcDbl <= middleware5
									|| srcDbl == middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						}
					} else if (eq(cond5, "==")) {
						if (eq(cond5B, ">")) {
							if (srcDbl == middleware5
									|| srcDbl > middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						} else if (eq(cond5B, ">=")) {
							if (srcDbl == middleware5
									|| srcDbl >= middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						} else if (eq(cond5B, "<")) {
							if (srcDbl == middleware5
									|| srcDbl < middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						} else if (eq(cond5B, "<=")) {
							if (srcDbl == middleware5
									|| srcDbl <= middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						} else if (eq(cond5B, "==")) {
							if (srcDbl == middleware5
									|| srcDbl == middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						}
					}
				} else if (both) {
					if (eq(cond5, ">")) {
						if (eq(cond5B, ">")) {
							if (srcDbl > middleware5 && srcDbl > middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						} else if (eq(cond5B, ">=")) {
							if (srcDbl > middleware5
									&& srcDbl >= middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						} else if (eq(cond5B, "<")) {
							if (srcDbl > middleware5 && srcDbl < middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						} else if (eq(cond5B, "<=")) {
							if (srcDbl > middleware5
									&& srcDbl <= middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						} else if (eq(cond5B, "==")) {
							if (srcDbl > middleware5
									&& srcDbl == middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						}
					} else if (eq(cond5, ">=")) {
						if (eq(cond5B, ">")) {
							if (srcDbl >= middleware5
									&& srcDbl > middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						} else if (eq(cond5B, ">=")) {
							if (srcDbl >= middleware5
									&& srcDbl >= middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						} else if (eq(cond5B, "<")) {
							if (srcDbl >= middleware5
									&& srcDbl < middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						} else if (eq(cond5B, "<=")) {
							if (srcDbl >= middleware5
									&& srcDbl <= middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						} else if (eq(cond5B, "==")) {
							if (srcDbl >= middleware5
									&& srcDbl == middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						}
					} else if (eq(cond5, "<")) {
						if (eq(cond5B, ">")) {
							if (srcDbl < middleware5 && srcDbl > middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						} else if (eq(cond5B, ">=")) {
							if (srcDbl < middleware5
									&& srcDbl >= middleware5B) {

								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						} else if (eq(cond5B, "<")) {
							if (srcDbl < middleware5 && srcDbl < middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						} else if (eq(cond5B, "<=")) {
							if (srcDbl < middleware5
									&& srcDbl <= middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						} else if (eq(cond5B, "==")) {
							if (srcDbl < middleware5
									&& srcDbl == middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						}
					} else if (eq(cond5, "<=")) {
						if (eq(cond5B, ">")) {
							if (srcDbl <= middleware5
									&& srcDbl > middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						} else if (eq(cond5B, ">=")) {
							if (srcDbl <= middleware5
									&& srcDbl >= middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						} else if (eq(cond5B, "<")) {
							if (srcDbl <= middleware5
									&& srcDbl < middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						} else if (eq(cond5B, "<=")) {
							if (srcDbl <= middleware5
									&& srcDbl <= middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						} else if (eq(cond5B, "==")) {
							if (srcDbl <= middleware5
									&& srcDbl == middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						}
					} else if (eq(cond5, "==")) {
						if (eq(cond5B, ">")) {
							if (srcDbl == middleware5
									&& srcDbl > middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						} else if (eq(cond5B, ">=")) {
							if (srcDbl == middleware5
									&& srcDbl >= middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						} else if (eq(cond5B, "<")) {
							if (srcDbl == middleware5
									&& srcDbl < middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						} else if (eq(cond5B, "<=")) {
							if (srcDbl == middleware5
									&& srcDbl <= middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						} else if (eq(cond5B, "==")) {
							if (srcDbl == middleware5
									&& srcDbl == middleware5B) {
								if (!isNull(sol5))
									new Thread(sol5).run();
								return true;
							}
						}
					}
				} else {
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
				}
			} else if (cond5 instanceof Number) {
				if (eq(srcDbl, Dbl(Str(cond5)))) {
					if (!isNull(sol5))
						new Thread(sol5).run();
					return true;
				}
			} else if (cond5 instanceof Character) {
				if (eq((char) src, (char) cond5)) {
					if (!isNull(sol5))
						new Thread(sol5).run();
					return true;
				}
			} else if (isNull(cond5)) {
				// NEEDED TO HANDLE NULL CASES: do nothing in this case, this
				// block only exists to BLOCK AWAY NULL references, and MUST
				// STAY!!
			} else {
				print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
				return false;
			}
			if (cond6 instanceof String) {
				if (!in(Str(cond6), "(?<=[<>=])\\-?\\d*\\.?\\d|else")) {
					print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
					return false;
				}
				String cond6B = "";
				boolean either = false, both = false;
				if (in(Str(cond6),
						"\\s*[\\&\\|]{1,2}\\s*(?=[<>=]\\-?\\d*\\.?\\d)")) {
					String op = Str(cond6).replaceAll("[^\\&\\|]", "");
					if (in(op.replaceAll("[\\&]", ""), "\\|"))
						either = true;
					else
						both = true;
					String[] parts = Str(cond6).split("\\s*[\\&\\|]+\\s*");
					cond6 = parts[0];
					cond6B = parts[1];
				}
				double middleware6 = Dbl(
						Str(cond6).replaceAll("[^\\-\\d\\.]", "")),
						middleware6B = Dbl(
								Str(cond6B).replaceAll("[^\\-\\d\\.]", ""));
				cond6 = String(cond6).replaceAll("[^<>=else]", "");
				cond6B = String(cond6B).replaceAll("[^<>=]", "");

				if (either) {
					if (eq(cond6, ">")) {
						if (eq(cond6B, ">")) {
							if (srcDbl > middleware6 || srcDbl > middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						} else if (eq(cond6B, ">=")) {
							if (srcDbl > middleware6
									|| srcDbl >= middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						} else if (eq(cond6B, "<")) {
							if (srcDbl > middleware6 || srcDbl < middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						} else if (eq(cond6B, "<=")) {
							if (srcDbl > middleware6
									|| srcDbl <= middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						} else if (eq(cond6B, "==")) {
							if (srcDbl > middleware6
									|| srcDbl == middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						}
					} else if (eq(cond6, ">=")) {
						if (eq(cond6B, ">")) {
							if (srcDbl >= middleware6
									|| srcDbl > middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						} else if (eq(cond6B, ">=")) {
							if (srcDbl >= middleware6
									|| srcDbl >= middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						} else if (eq(cond6B, "<")) {
							if (srcDbl >= middleware6
									|| srcDbl < middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						} else if (eq(cond6B, "<=")) {
							if (srcDbl >= middleware6
									|| srcDbl <= middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						} else if (eq(cond6B, "==")) {
							if (srcDbl >= middleware6
									|| srcDbl == middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						}
					} else if (eq(cond6, "<")) {
						if (eq(cond6B, ">")) {
							if (srcDbl < middleware6 || srcDbl > middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						} else if (eq(cond6B, ">=")) {
							if (srcDbl < middleware6
									|| srcDbl >= middleware6B) {

								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						} else if (eq(cond6B, "<")) {
							if (srcDbl < middleware6 || srcDbl < middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						} else if (eq(cond6B, "<=")) {
							if (srcDbl < middleware6
									|| srcDbl <= middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						} else if (eq(cond6B, "==")) {
							if (srcDbl < middleware6
									|| srcDbl == middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						}
					} else if (eq(cond6, "<=")) {
						if (eq(cond6B, ">")) {
							if (srcDbl <= middleware6
									|| srcDbl > middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						} else if (eq(cond6B, ">=")) {
							if (srcDbl <= middleware6
									|| srcDbl >= middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						} else if (eq(cond6B, "<")) {
							if (srcDbl <= middleware6
									|| srcDbl < middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						} else if (eq(cond6B, "<=")) {
							if (srcDbl <= middleware6
									|| srcDbl <= middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						} else if (eq(cond6B, "==")) {
							if (srcDbl <= middleware6
									|| srcDbl == middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						}
					} else if (eq(cond6, "==")) {
						if (eq(cond6B, ">")) {
							if (srcDbl == middleware6
									|| srcDbl > middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						} else if (eq(cond6B, ">=")) {
							if (srcDbl == middleware6
									|| srcDbl >= middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						} else if (eq(cond6B, "<")) {
							if (srcDbl == middleware6
									|| srcDbl < middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						} else if (eq(cond6B, "<=")) {
							if (srcDbl == middleware6
									|| srcDbl <= middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						} else if (eq(cond6B, "==")) {
							if (srcDbl == middleware6
									|| srcDbl == middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						}
					}
				} else if (both) {
					if (eq(cond6, ">")) {
						if (eq(cond6B, ">")) {
							if (srcDbl > middleware6 && srcDbl > middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						} else if (eq(cond6B, ">=")) {
							if (srcDbl > middleware6
									&& srcDbl >= middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						} else if (eq(cond6B, "<")) {
							if (srcDbl > middleware6 && srcDbl < middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						} else if (eq(cond6B, "<=")) {
							if (srcDbl > middleware6
									&& srcDbl <= middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						} else if (eq(cond6B, "==")) {
							if (srcDbl > middleware6
									&& srcDbl == middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						}
					} else if (eq(cond6, ">=")) {
						if (eq(cond6B, ">")) {
							if (srcDbl >= middleware6
									&& srcDbl > middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						} else if (eq(cond6B, ">=")) {
							if (srcDbl >= middleware6
									&& srcDbl >= middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						} else if (eq(cond6B, "<")) {
							if (srcDbl >= middleware6
									&& srcDbl < middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						} else if (eq(cond6B, "<=")) {
							if (srcDbl >= middleware6
									&& srcDbl <= middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						} else if (eq(cond6B, "==")) {
							if (srcDbl >= middleware6
									&& srcDbl == middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						}
					} else if (eq(cond6, "<")) {
						if (eq(cond6B, ">")) {
							if (srcDbl < middleware6 && srcDbl > middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						} else if (eq(cond6B, ">=")) {
							if (srcDbl < middleware6
									&& srcDbl >= middleware6B) {

								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						} else if (eq(cond6B, "<")) {
							if (srcDbl < middleware6 && srcDbl < middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						} else if (eq(cond6B, "<=")) {
							if (srcDbl < middleware6
									&& srcDbl <= middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						} else if (eq(cond6B, "==")) {
							if (srcDbl < middleware6
									&& srcDbl == middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						}
					} else if (eq(cond6, "<=")) {
						if (eq(cond6B, ">")) {
							if (srcDbl <= middleware6
									&& srcDbl > middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						} else if (eq(cond6B, ">=")) {
							if (srcDbl <= middleware6
									&& srcDbl >= middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						} else if (eq(cond6B, "<")) {
							if (srcDbl <= middleware6
									&& srcDbl < middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						} else if (eq(cond6B, "<=")) {
							if (srcDbl <= middleware6
									&& srcDbl <= middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						} else if (eq(cond6B, "==")) {
							if (srcDbl <= middleware6
									&& srcDbl == middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						}
					} else if (eq(cond6, "==")) {
						if (eq(cond6B, ">")) {
							if (srcDbl == middleware6
									&& srcDbl > middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						} else if (eq(cond6B, ">=")) {
							if (srcDbl == middleware6
									&& srcDbl >= middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						} else if (eq(cond6B, "<")) {
							if (srcDbl == middleware6
									&& srcDbl < middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						} else if (eq(cond6B, "<=")) {
							if (srcDbl == middleware6
									&& srcDbl <= middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						} else if (eq(cond6B, "==")) {
							if (srcDbl == middleware6
									&& srcDbl == middleware6B) {
								if (!isNull(sol6))
									new Thread(sol6).run();
								return true;
							}
						}
					}
				} else {
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
				}
			} else if (cond6 instanceof Number) {
				if (eq(srcDbl, Dbl(Str(cond6)))) {
					if (!isNull(sol6))
						new Thread(sol6).run();
					return true;
				}
			} else if (cond6 instanceof Character) {
				if (eq((char) src, (char) cond6)) {
					if (!isNull(sol6))
						new Thread(sol6).run();
					return true;
				}
			} else if (isNull(cond6)) {
				// NEEDED TO HANDLE NULL CASES: do nothing in this case, this
				// block only exists to BLOCK AWAY NULL references, and MUST
				// STAY!!
			} else {
				print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
				return false;
			}
			if (cond7 instanceof String) {
				if (!in(Str(cond7), "(?<=[<>=])\\-?\\d*\\.?\\d|else")) {
					print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
					return false;
				}
				String cond7B = "";
				boolean either = false, both = false;
				if (in(Str(cond7),
						"\\s*[\\&\\|]{1,2}\\s*(?=[<>=]\\-?\\d*\\.?\\d)")) {
					String op = Str(cond7).replaceAll("[^\\&\\|]", "");
					if (in(op.replaceAll("[\\&]", ""), "\\|"))
						either = true;
					else
						both = true;
					String[] parts = Str(cond7).split("\\s*[\\&\\|]+\\s*");
					cond7 = parts[0];
					cond7B = parts[1];
				}
				double middleware7 = Dbl(
						Str(cond7).replaceAll("[^\\-\\d\\.]", "")),
						middleware7B = Dbl(
								Str(cond7B).replaceAll("[^\\-\\d\\.]", ""));
				cond7 = String(cond7).replaceAll("[^<>=else]", "");
				cond7B = String(cond7B).replaceAll("[^<>=]", "");

				if (either) {
					if (eq(cond7, ">")) {
						if (eq(cond7B, ">")) {
							if (srcDbl > middleware7 || srcDbl > middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						} else if (eq(cond7B, ">=")) {
							if (srcDbl > middleware7
									|| srcDbl >= middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						} else if (eq(cond7B, "<")) {
							if (srcDbl > middleware7 || srcDbl < middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						} else if (eq(cond7B, "<=")) {
							if (srcDbl > middleware7
									|| srcDbl <= middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						} else if (eq(cond7B, "==")) {
							if (srcDbl > middleware7
									|| srcDbl == middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						}
					} else if (eq(cond7, ">=")) {
						if (eq(cond7B, ">")) {
							if (srcDbl >= middleware7
									|| srcDbl > middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						} else if (eq(cond7B, ">=")) {
							if (srcDbl >= middleware7
									|| srcDbl >= middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						} else if (eq(cond7B, "<")) {
							if (srcDbl >= middleware7
									|| srcDbl < middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						} else if (eq(cond7B, "<=")) {
							if (srcDbl >= middleware7
									|| srcDbl <= middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						} else if (eq(cond7B, "==")) {
							if (srcDbl >= middleware7
									|| srcDbl == middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						}
					} else if (eq(cond7, "<")) {
						if (eq(cond7B, ">")) {
							if (srcDbl < middleware7 || srcDbl > middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						} else if (eq(cond7B, ">=")) {
							if (srcDbl < middleware7
									|| srcDbl >= middleware7B) {

								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						} else if (eq(cond7B, "<")) {
							if (srcDbl < middleware7 || srcDbl < middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						} else if (eq(cond7B, "<=")) {
							if (srcDbl < middleware7
									|| srcDbl <= middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						} else if (eq(cond7B, "==")) {
							if (srcDbl < middleware7
									|| srcDbl == middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						}
					} else if (eq(cond7, "<=")) {
						if (eq(cond7B, ">")) {
							if (srcDbl <= middleware7
									|| srcDbl > middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						} else if (eq(cond7B, ">=")) {
							if (srcDbl <= middleware7
									|| srcDbl >= middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						} else if (eq(cond7B, "<")) {
							if (srcDbl <= middleware7
									|| srcDbl < middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						} else if (eq(cond7B, "<=")) {
							if (srcDbl <= middleware7
									|| srcDbl <= middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						} else if (eq(cond7B, "==")) {
							if (srcDbl <= middleware7
									|| srcDbl == middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						}
					} else if (eq(cond7, "==")) {
						if (eq(cond7B, ">")) {
							if (srcDbl == middleware7
									|| srcDbl > middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						} else if (eq(cond7B, ">=")) {
							if (srcDbl == middleware7
									|| srcDbl >= middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						} else if (eq(cond7B, "<")) {
							if (srcDbl == middleware7
									|| srcDbl < middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						} else if (eq(cond7B, "<=")) {
							if (srcDbl == middleware7
									|| srcDbl <= middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						} else if (eq(cond7B, "==")) {
							if (srcDbl == middleware7
									|| srcDbl == middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						}
					}
				} else if (both) {
					if (eq(cond7, ">")) {
						if (eq(cond7B, ">")) {
							if (srcDbl > middleware7 && srcDbl > middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						} else if (eq(cond7B, ">=")) {
							if (srcDbl > middleware7
									&& srcDbl >= middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						} else if (eq(cond7B, "<")) {
							if (srcDbl > middleware7 && srcDbl < middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						} else if (eq(cond7B, "<=")) {
							if (srcDbl > middleware7
									&& srcDbl <= middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						} else if (eq(cond7B, "==")) {
							if (srcDbl > middleware7
									&& srcDbl == middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						}
					} else if (eq(cond7, ">=")) {
						if (eq(cond7B, ">")) {
							if (srcDbl >= middleware7
									&& srcDbl > middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						} else if (eq(cond7B, ">=")) {
							if (srcDbl >= middleware7
									&& srcDbl >= middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						} else if (eq(cond7B, "<")) {
							if (srcDbl >= middleware7
									&& srcDbl < middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						} else if (eq(cond7B, "<=")) {
							if (srcDbl >= middleware7
									&& srcDbl <= middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						} else if (eq(cond7B, "==")) {
							if (srcDbl >= middleware7
									&& srcDbl == middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						}
					} else if (eq(cond7, "<")) {
						if (eq(cond7B, ">")) {
							if (srcDbl < middleware7 && srcDbl > middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						} else if (eq(cond7B, ">=")) {
							if (srcDbl < middleware7
									&& srcDbl >= middleware7B) {

								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						} else if (eq(cond7B, "<")) {
							if (srcDbl < middleware7 && srcDbl < middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						} else if (eq(cond7B, "<=")) {
							if (srcDbl < middleware7
									&& srcDbl <= middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						} else if (eq(cond7B, "==")) {
							if (srcDbl < middleware7
									&& srcDbl == middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						}
					} else if (eq(cond7, "<=")) {
						if (eq(cond7B, ">")) {
							if (srcDbl <= middleware7
									&& srcDbl > middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						} else if (eq(cond7B, ">=")) {
							if (srcDbl <= middleware7
									&& srcDbl >= middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						} else if (eq(cond7B, "<")) {
							if (srcDbl <= middleware7
									&& srcDbl < middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						} else if (eq(cond7B, "<=")) {
							if (srcDbl <= middleware7
									&& srcDbl <= middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						} else if (eq(cond7B, "==")) {
							if (srcDbl <= middleware7
									&& srcDbl == middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						}
					} else if (eq(cond7, "==")) {
						if (eq(cond7B, ">")) {
							if (srcDbl == middleware7
									&& srcDbl > middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						} else if (eq(cond7B, ">=")) {
							if (srcDbl == middleware7
									&& srcDbl >= middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						} else if (eq(cond7B, "<")) {
							if (srcDbl == middleware7
									&& srcDbl < middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						} else if (eq(cond7B, "<=")) {
							if (srcDbl == middleware7
									&& srcDbl <= middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						} else if (eq(cond7B, "==")) {
							if (srcDbl == middleware7
									&& srcDbl == middleware7B) {
								if (!isNull(sol7))
									new Thread(sol7).run();
								return true;
							}
						}
					}
				} else {
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
				}
			} else if (cond7 instanceof Number) {
				if (eq(srcDbl, Dbl(Str(cond7)))) {
					if (!isNull(sol7))
						new Thread(sol7).run();
					return true;
				}
			} else if (cond7 instanceof Character) {
				if (eq((char) src, (char) cond7)) {
					if (!isNull(sol7))
						new Thread(sol7).run();
					return true;
				}
			} else if (isNull(cond7)) {
				// NEEDED TO HANDLE NULL CASES: do nothing in this case, this
				// block only exists to BLOCK AWAY NULL references, and MUST
				// STAY!!
			} else {
				print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
				return false;
			}
			if (cond8 instanceof String) {
				if (!in(Str(cond8), "(?<=[<>=])\\-?\\d*\\.?\\d|else")) {
					print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
					return false;
				}
				String cond8B = "";
				boolean either = false, both = false;
				if (in(Str(cond8),
						"\\s*[\\&\\|]{1,2}\\s*(?=[<>=]\\-?\\d*\\.?\\d)")) {
					String op = Str(cond8).replaceAll("[^\\&\\|]", "");
					if (in(op.replaceAll("[\\&]", ""), "\\|"))
						either = true;
					else
						both = true;
					String[] parts = Str(cond8).split("\\s*[\\&\\|]+\\s*");
					cond8 = parts[0];
					cond8B = parts[1];
				}
				double middleware8 = Dbl(
						Str(cond8).replaceAll("[^\\-\\d\\.]", "")),
						middleware8B = Dbl(
								Str(cond8B).replaceAll("[^\\-\\d\\.]", ""));
				cond8 = String(cond8).replaceAll("[^<>=else]", "");
				cond8B = String(cond8B).replaceAll("[^<>=]", "");

				if (either) {
					if (eq(cond8, ">")) {
						if (eq(cond8B, ">")) {
							if (srcDbl > middleware8 || srcDbl > middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						} else if (eq(cond8B, ">=")) {
							if (srcDbl > middleware8
									|| srcDbl >= middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						} else if (eq(cond8B, "<")) {
							if (srcDbl > middleware8 || srcDbl < middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						} else if (eq(cond8B, "<=")) {
							if (srcDbl > middleware8
									|| srcDbl <= middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						} else if (eq(cond8B, "==")) {
							if (srcDbl > middleware8
									|| srcDbl == middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						}
					} else if (eq(cond8, ">=")) {
						if (eq(cond8B, ">")) {
							if (srcDbl >= middleware8
									|| srcDbl > middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						} else if (eq(cond8B, ">=")) {
							if (srcDbl >= middleware8
									|| srcDbl >= middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						} else if (eq(cond8B, "<")) {
							if (srcDbl >= middleware8
									|| srcDbl < middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						} else if (eq(cond8B, "<=")) {
							if (srcDbl >= middleware8
									|| srcDbl <= middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						} else if (eq(cond8B, "==")) {
							if (srcDbl >= middleware8
									|| srcDbl == middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						}
					} else if (eq(cond8, "<")) {
						if (eq(cond8B, ">")) {
							if (srcDbl < middleware8 || srcDbl > middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						} else if (eq(cond8B, ">=")) {
							if (srcDbl < middleware8
									|| srcDbl >= middleware8B) {

								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						} else if (eq(cond8B, "<")) {
							if (srcDbl < middleware8 || srcDbl < middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						} else if (eq(cond8B, "<=")) {
							if (srcDbl < middleware8
									|| srcDbl <= middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						} else if (eq(cond8B, "==")) {
							if (srcDbl < middleware8
									|| srcDbl == middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						}
					} else if (eq(cond8, "<=")) {
						if (eq(cond8B, ">")) {
							if (srcDbl <= middleware8
									|| srcDbl > middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						} else if (eq(cond8B, ">=")) {
							if (srcDbl <= middleware8
									|| srcDbl >= middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						} else if (eq(cond8B, "<")) {
							if (srcDbl <= middleware8
									|| srcDbl < middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						} else if (eq(cond8B, "<=")) {
							if (srcDbl <= middleware8
									|| srcDbl <= middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						} else if (eq(cond8B, "==")) {
							if (srcDbl <= middleware8
									|| srcDbl == middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						}
					} else if (eq(cond8, "==")) {
						if (eq(cond8B, ">")) {
							if (srcDbl == middleware8
									|| srcDbl > middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						} else if (eq(cond8B, ">=")) {
							if (srcDbl == middleware8
									|| srcDbl >= middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						} else if (eq(cond8B, "<")) {
							if (srcDbl == middleware8
									|| srcDbl < middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						} else if (eq(cond8B, "<=")) {
							if (srcDbl == middleware8
									|| srcDbl <= middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						} else if (eq(cond8B, "==")) {
							if (srcDbl == middleware8
									|| srcDbl == middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						}
					}
				} else if (both) {
					if (eq(cond8, ">")) {
						if (eq(cond8B, ">")) {
							if (srcDbl > middleware8 && srcDbl > middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						} else if (eq(cond8B, ">=")) {
							if (srcDbl > middleware8
									&& srcDbl >= middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						} else if (eq(cond8B, "<")) {
							if (srcDbl > middleware8 && srcDbl < middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						} else if (eq(cond8B, "<=")) {
							if (srcDbl > middleware8
									&& srcDbl <= middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						} else if (eq(cond8B, "==")) {
							if (srcDbl > middleware8
									&& srcDbl == middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						}
					} else if (eq(cond8, ">=")) {
						if (eq(cond8B, ">")) {
							if (srcDbl >= middleware8
									&& srcDbl > middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						} else if (eq(cond8B, ">=")) {
							if (srcDbl >= middleware8
									&& srcDbl >= middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						} else if (eq(cond8B, "<")) {
							if (srcDbl >= middleware8
									&& srcDbl < middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						} else if (eq(cond8B, "<=")) {
							if (srcDbl >= middleware8
									&& srcDbl <= middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						} else if (eq(cond8B, "==")) {
							if (srcDbl >= middleware8
									&& srcDbl == middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						}
					} else if (eq(cond8, "<")) {
						if (eq(cond8B, ">")) {
							if (srcDbl < middleware8 && srcDbl > middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						} else if (eq(cond8B, ">=")) {
							if (srcDbl < middleware8
									&& srcDbl >= middleware8B) {

								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						} else if (eq(cond8B, "<")) {
							if (srcDbl < middleware8 && srcDbl < middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						} else if (eq(cond8B, "<=")) {
							if (srcDbl < middleware8
									&& srcDbl <= middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						} else if (eq(cond8B, "==")) {
							if (srcDbl < middleware8
									&& srcDbl == middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						}
					} else if (eq(cond8, "<=")) {
						if (eq(cond8B, ">")) {
							if (srcDbl <= middleware8
									&& srcDbl > middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						} else if (eq(cond8B, ">=")) {
							if (srcDbl <= middleware8
									&& srcDbl >= middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						} else if (eq(cond8B, "<")) {
							if (srcDbl <= middleware8
									&& srcDbl < middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						} else if (eq(cond8B, "<=")) {
							if (srcDbl <= middleware8
									&& srcDbl <= middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						} else if (eq(cond8B, "==")) {
							if (srcDbl <= middleware8
									&& srcDbl == middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						}
					} else if (eq(cond8, "==")) {
						if (eq(cond8B, ">")) {
							if (srcDbl == middleware8
									&& srcDbl > middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						} else if (eq(cond8B, ">=")) {
							if (srcDbl == middleware8
									&& srcDbl >= middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						} else if (eq(cond8B, "<")) {
							if (srcDbl == middleware8
									&& srcDbl < middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						} else if (eq(cond8B, "<=")) {
							if (srcDbl == middleware8
									&& srcDbl <= middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						} else if (eq(cond8B, "==")) {
							if (srcDbl == middleware8
									&& srcDbl == middleware8B) {
								if (!isNull(sol8))
									new Thread(sol8).run();
								return true;
							}
						}
					}
				} else {
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
				}
			} else if (cond8 instanceof Number) {
				if (eq(srcDbl, Dbl(Str(cond8)))) {
					if (!isNull(sol8))
						new Thread(sol8).run();
					return true;
				}
			} else if (cond8 instanceof Character) {
				if (eq((char) src, (char) cond8)) {
					if (!isNull(sol8))
						new Thread(sol8).run();
					return true;
				}
			} else if (isNull(cond8)) {
				// NEEDED TO HANDLE NULL CASES: do nothing in this case, this
				// block only exists to BLOCK AWAY NULL references, and MUST
				// STAY!!
			} else {
				print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
				return false;
			}
			if (cond9 instanceof String) {
				if (!in(Str(cond9), "(?<=[<>=])\\-?\\d*\\.?\\d|else")) {
					print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
					return false;
				}
				String cond9B = "";
				boolean either = false, both = false;
				if (in(Str(cond9),
						"\\s*[\\&\\|]{1,2}\\s*(?=[<>=]\\-?\\d*\\.?\\d)")) {
					String op = Str(cond9).replaceAll("[^\\&\\|]", "");
					if (in(op.replaceAll("[\\&]", ""), "\\|"))
						either = true;
					else
						both = true;
					String[] parts = Str(cond9).split("\\s*[\\&\\|]+\\s*");
					cond9 = parts[0];
					cond9B = parts[1];
				}
				double middleware9 = Dbl(
						Str(cond9).replaceAll("[^\\-\\d\\.]", "")),
						middleware9B = Dbl(
								Str(cond9B).replaceAll("[^\\-\\d\\.]", ""));
				cond9 = String(cond9).replaceAll("[^<>=else]", "");
				cond9B = String(cond9B).replaceAll("[^<>=]", "");

				if (either) {
					if (eq(cond9, ">")) {
						if (eq(cond9B, ">")) {
							if (srcDbl > middleware9 || srcDbl > middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						} else if (eq(cond9B, ">=")) {
							if (srcDbl > middleware9
									|| srcDbl >= middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						} else if (eq(cond9B, "<")) {
							if (srcDbl > middleware9 || srcDbl < middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						} else if (eq(cond9B, "<=")) {
							if (srcDbl > middleware9
									|| srcDbl <= middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						} else if (eq(cond9B, "==")) {
							if (srcDbl > middleware9
									|| srcDbl == middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						}
					} else if (eq(cond9, ">=")) {
						if (eq(cond9B, ">")) {
							if (srcDbl >= middleware9
									|| srcDbl > middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						} else if (eq(cond9B, ">=")) {
							if (srcDbl >= middleware9
									|| srcDbl >= middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						} else if (eq(cond9B, "<")) {
							if (srcDbl >= middleware9
									|| srcDbl < middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						} else if (eq(cond9B, "<=")) {
							if (srcDbl >= middleware9
									|| srcDbl <= middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						} else if (eq(cond9B, "==")) {
							if (srcDbl >= middleware9
									|| srcDbl == middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						}
					} else if (eq(cond9, "<")) {
						if (eq(cond9B, ">")) {
							if (srcDbl < middleware9 || srcDbl > middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						} else if (eq(cond9B, ">=")) {
							if (srcDbl < middleware9
									|| srcDbl >= middleware9B) {

								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						} else if (eq(cond9B, "<")) {
							if (srcDbl < middleware9 || srcDbl < middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						} else if (eq(cond9B, "<=")) {
							if (srcDbl < middleware9
									|| srcDbl <= middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						} else if (eq(cond9B, "==")) {
							if (srcDbl < middleware9
									|| srcDbl == middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						}
					} else if (eq(cond9, "<=")) {
						if (eq(cond9B, ">")) {
							if (srcDbl <= middleware9
									|| srcDbl > middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						} else if (eq(cond9B, ">=")) {
							if (srcDbl <= middleware9
									|| srcDbl >= middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						} else if (eq(cond9B, "<")) {
							if (srcDbl <= middleware9
									|| srcDbl < middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						} else if (eq(cond9B, "<=")) {
							if (srcDbl <= middleware9
									|| srcDbl <= middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						} else if (eq(cond9B, "==")) {
							if (srcDbl <= middleware9
									|| srcDbl == middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						}
					} else if (eq(cond9, "==")) {
						if (eq(cond9B, ">")) {
							if (srcDbl == middleware9
									|| srcDbl > middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						} else if (eq(cond9B, ">=")) {
							if (srcDbl == middleware9
									|| srcDbl >= middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						} else if (eq(cond9B, "<")) {
							if (srcDbl == middleware9
									|| srcDbl < middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						} else if (eq(cond9B, "<=")) {
							if (srcDbl == middleware9
									|| srcDbl <= middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						} else if (eq(cond9B, "==")) {
							if (srcDbl == middleware9
									|| srcDbl == middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						}
					}
				} else if (both) {
					if (eq(cond9, ">")) {
						if (eq(cond9B, ">")) {
							if (srcDbl > middleware9 && srcDbl > middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						} else if (eq(cond9B, ">=")) {
							if (srcDbl > middleware9
									&& srcDbl >= middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						} else if (eq(cond9B, "<")) {
							if (srcDbl > middleware9 && srcDbl < middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						} else if (eq(cond9B, "<=")) {
							if (srcDbl > middleware9
									&& srcDbl <= middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						} else if (eq(cond9B, "==")) {
							if (srcDbl > middleware9
									&& srcDbl == middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						}
					} else if (eq(cond9, ">=")) {
						if (eq(cond9B, ">")) {
							if (srcDbl >= middleware9
									&& srcDbl > middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						} else if (eq(cond9B, ">=")) {
							if (srcDbl >= middleware9
									&& srcDbl >= middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						} else if (eq(cond9B, "<")) {
							if (srcDbl >= middleware9
									&& srcDbl < middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						} else if (eq(cond9B, "<=")) {
							if (srcDbl >= middleware9
									&& srcDbl <= middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						} else if (eq(cond9B, "==")) {
							if (srcDbl >= middleware9
									&& srcDbl == middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						}
					} else if (eq(cond9, "<")) {
						if (eq(cond9B, ">")) {
							if (srcDbl < middleware9 && srcDbl > middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						} else if (eq(cond9B, ">=")) {
							if (srcDbl < middleware9
									&& srcDbl >= middleware9B) {

								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						} else if (eq(cond9B, "<")) {
							if (srcDbl < middleware9 && srcDbl < middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						} else if (eq(cond9B, "<=")) {
							if (srcDbl < middleware9
									&& srcDbl <= middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						} else if (eq(cond9B, "==")) {
							if (srcDbl < middleware9
									&& srcDbl == middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						}
					} else if (eq(cond9, "<=")) {
						if (eq(cond9B, ">")) {
							if (srcDbl <= middleware9
									&& srcDbl > middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						} else if (eq(cond9B, ">=")) {
							if (srcDbl <= middleware9
									&& srcDbl >= middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						} else if (eq(cond9B, "<")) {
							if (srcDbl <= middleware9
									&& srcDbl < middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						} else if (eq(cond9B, "<=")) {
							if (srcDbl <= middleware9
									&& srcDbl <= middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						} else if (eq(cond9B, "==")) {
							if (srcDbl <= middleware9
									&& srcDbl == middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						}
					} else if (eq(cond9, "==")) {
						if (eq(cond9B, ">")) {
							if (srcDbl == middleware9
									&& srcDbl > middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						} else if (eq(cond9B, ">=")) {
							if (srcDbl == middleware9
									&& srcDbl >= middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						} else if (eq(cond9B, "<")) {
							if (srcDbl == middleware9
									&& srcDbl < middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						} else if (eq(cond9B, "<=")) {
							if (srcDbl == middleware9
									&& srcDbl <= middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						} else if (eq(cond9B, "==")) {
							if (srcDbl == middleware9
									&& srcDbl == middleware9B) {
								if (!isNull(sol9))
									new Thread(sol9).run();
								return true;
							}
						}
					}
				} else {
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
				}
			} else if (cond9 instanceof Number) {
				if (eq(srcDbl, Dbl(Str(cond9)))) {
					if (!isNull(sol9))
						new Thread(sol9).run();
					return true;
				}
			} else if (cond9 instanceof Character) {
				if (eq((char) src, (char) cond9)) {
					if (!isNull(sol9))
						new Thread(sol9).run();
					return true;
				}
			} else if (isNull(cond9)) {
				// NEEDED TO HANDLE NULL CASES: do nothing in this case, this
				// block only exists to BLOCK AWAY NULL references, and MUST
				// STAY!!
			} else {
				print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
				return false;
			}
			if (cond10 instanceof String) {
				if (!in(Str(cond10), "(?<=[<>=])\\-?\\d*\\.?\\d|else")) {
					print("[KL.LogicalError.UnlikelyTypesSeen]\nDue to a type conflict, current switch statement was rendered meaningless, and hence ignored.");
					return false;
				}
				String cond10B = "";
				boolean either = false, both = false;
				if (in(Str(cond10),
						"\\s*[\\&\\|]{1,2}\\s*(?=[<>=]\\-?\\d*\\.?\\d)")) {
					String op = Str(cond10).replaceAll("[^\\&\\|]", "");
					if (in(op.replaceAll("[\\&]", ""), "\\|"))
						either = true;
					else
						both = true;
					String[] parts = Str(cond10).split("\\s*[\\&\\|]+\\s*");
					cond10 = parts[0];
					cond10B = parts[1];
				}
				double middleware10 = Dbl(
						Str(cond10).replaceAll("[^\\-\\d\\.]", "")),
						middleware10B = Dbl(
								Str(cond10B).replaceAll("[^\\-\\d\\.]", ""));
				cond10 = String(cond10).replaceAll("[^<>=else]", "");
				cond10B = String(cond10B).replaceAll("[^<>=]", "");

				if (either) {
					if (eq(cond10, ">")) {
						if (eq(cond10B, ">")) {
							if (srcDbl > middleware10
									|| srcDbl > middleware10B) {
								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						} else if (eq(cond10B, ">=")) {
							if (srcDbl > middleware10
									|| srcDbl >= middleware10B) {
								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						} else if (eq(cond10B, "<")) {
							if (srcDbl > middleware10
									|| srcDbl < middleware10B) {
								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						} else if (eq(cond10B, "<=")) {
							if (srcDbl > middleware10
									|| srcDbl <= middleware10B) {
								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						} else if (eq(cond10B, "==")) {
							if (srcDbl > middleware10
									|| srcDbl == middleware10B) {
								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						}
					} else if (eq(cond10, ">=")) {
						if (eq(cond10B, ">")) {
							if (srcDbl >= middleware10
									|| srcDbl > middleware10B) {
								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						} else if (eq(cond10B, ">=")) {
							if (srcDbl >= middleware10
									|| srcDbl >= middleware10B) {

								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						} else if (eq(cond10B, "<")) {
							if (srcDbl >= middleware10
									|| srcDbl < middleware10B) {
								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						} else if (eq(cond10B, "<=")) {
							if (srcDbl >= middleware10
									|| srcDbl <= middleware10B) {
								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						} else if (eq(cond10B, "==")) {
							if (srcDbl >= middleware10
									|| srcDbl == middleware10B) {
								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						}
					} else if (eq(cond10, "<")) {
						if (eq(cond10B, ">")) {
							if (srcDbl < middleware10
									|| srcDbl > middleware10B) {
								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						} else if (eq(cond10B, ">=")) {
							if (srcDbl < middleware10
									|| srcDbl >= middleware10B) {

								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						} else if (eq(cond10B, "<")) {
							if (srcDbl < middleware10
									|| srcDbl < middleware10B) {
								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						} else if (eq(cond10B, "<=")) {
							if (srcDbl < middleware10
									|| srcDbl <= middleware10B) {
								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						} else if (eq(cond10B, "==")) {
							if (srcDbl < middleware10
									|| srcDbl == middleware10B) {
								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						}
					} else if (eq(cond10, "<=")) {
						if (eq(cond10B, ">")) {
							if (srcDbl <= middleware10
									|| srcDbl > middleware10B) {
								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						} else if (eq(cond10B, ">=")) {
							if (srcDbl <= middleware10
									|| srcDbl >= middleware10B) {

								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						} else if (eq(cond10B, "<")) {
							if (srcDbl <= middleware10
									|| srcDbl < middleware10B) {
								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						} else if (eq(cond10B, "<=")) {
							if (srcDbl <= middleware10
									|| srcDbl <= middleware10B) {
								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						} else if (eq(cond10B, "==")) {
							if (srcDbl <= middleware10
									|| srcDbl == middleware10B) {
								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						}
					} else if (eq(cond10, "==")) {
						if (eq(cond10B, ">")) {
							if (srcDbl == middleware10
									|| srcDbl > middleware10B) {
								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						} else if (eq(cond10B, ">=")) {
							if (srcDbl == middleware10
									|| srcDbl >= middleware10B) {

								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						} else if (eq(cond10B, "<")) {
							if (srcDbl == middleware10
									|| srcDbl < middleware10B) {
								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						} else if (eq(cond10B, "<=")) {
							if (srcDbl == middleware10
									|| srcDbl <= middleware10B) {
								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						} else if (eq(cond10B, "==")) {
							if (srcDbl == middleware10
									|| srcDbl == middleware10B) {
								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						}
					}
				} else if (both) {
					if (eq(cond10, ">")) {
						if (eq(cond10B, ">")) {
							if (srcDbl > middleware10
									&& srcDbl > middleware10B) {
								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						} else if (eq(cond10B, ">=")) {
							if (srcDbl > middleware10
									&& srcDbl >= middleware10B) {
								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						} else if (eq(cond10B, "<")) {
							if (srcDbl > middleware10
									&& srcDbl < middleware10B) {
								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						} else if (eq(cond10B, "<=")) {
							if (srcDbl > middleware10
									&& srcDbl <= middleware10B) {
								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						} else if (eq(cond10B, "==")) {
							if (srcDbl > middleware10
									&& srcDbl == middleware10B) {
								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						}
					} else if (eq(cond10, ">=")) {
						if (eq(cond10B, ">")) {
							if (srcDbl >= middleware10
									&& srcDbl > middleware10B) {
								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						} else if (eq(cond10B, ">=")) {
							if (srcDbl >= middleware10
									&& srcDbl >= middleware10B) {
								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						} else if (eq(cond10B, "<")) {
							if (srcDbl >= middleware10
									&& srcDbl < middleware10B) {
								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						} else if (eq(cond10B, "<=")) {
							if (srcDbl >= middleware10
									&& srcDbl <= middleware10B) {
								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						} else if (eq(cond10B, "==")) {
							if (srcDbl >= middleware10
									&& srcDbl == middleware10B) {
								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						}
					} else if (eq(cond10, "<")) {
						if (eq(cond10B, ">")) {
							if (srcDbl < middleware10
									&& srcDbl > middleware10B) {
								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						} else if (eq(cond10B, ">=")) {
							if (srcDbl < middleware10
									&& srcDbl >= middleware10B) {

								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						} else if (eq(cond10B, "<")) {
							if (srcDbl < middleware10
									&& srcDbl < middleware10B) {
								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						} else if (eq(cond10B, "<=")) {
							if (srcDbl < middleware10
									&& srcDbl <= middleware10B) {
								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						} else if (eq(cond10B, "==")) {
							if (srcDbl < middleware10
									&& srcDbl == middleware10B) {
								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						}
					} else if (eq(cond10, "<=")) {
						if (eq(cond10B, ">")) {
							if (srcDbl <= middleware10
									&& srcDbl > middleware10B) {
								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						} else if (eq(cond10B, ">=")) {
							if (srcDbl <= middleware10
									&& srcDbl >= middleware10B) {
								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						} else if (eq(cond10B, "<")) {
							if (srcDbl <= middleware10
									&& srcDbl < middleware10B) {
								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						} else if (eq(cond10B, "<=")) {
							if (srcDbl <= middleware10
									&& srcDbl <= middleware10B) {
								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						} else if (eq(cond10B, "==")) {
							if (srcDbl <= middleware10
									&& srcDbl == middleware10B) {
								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						}
					} else if (eq(cond10, "==")) {
						if (eq(cond10B, ">")) {
							if (srcDbl == middleware10
									&& srcDbl > middleware10B) {
								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						} else if (eq(cond10B, ">=")) {
							if (srcDbl == middleware10
									&& srcDbl >= middleware10B) {
								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						} else if (eq(cond10B, "<")) {
							if (srcDbl == middleware10
									&& srcDbl < middleware10B) {
								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						} else if (eq(cond10B, "<=")) {
							if (srcDbl == middleware10
									&& srcDbl <= middleware10B) {
								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						} else if (eq(cond10B, "==")) {
							if (srcDbl == middleware10
									&& srcDbl == middleware10B) {
								if (!isNull(sol10))
									new Thread(sol10).run();
								return true;
							}
						}
					}
				} else {
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
				}
			} else if (cond10 instanceof Number) {
				if (eq(srcDbl, Dbl(Str(cond10)))) {
					if (!isNull(sol10))
						new Thread(sol10).run();
					return true;
				}
			} else if (cond10 instanceof Character) {
				if (eq((char) src, (char) cond10)) {
					if (!isNull(sol10))
						new Thread(sol10).run();
					return true;
				}
			} else if (isNull(cond10)) {
				// NEEDED TO HANDLE NULL CASES: do nothing in this case, this
				// block only exists to BLOCK AWAY NULL references, and MUST
				// STAY!!
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
				// NEEDED TO HANDLE NULL CASES: do nothing in this case, this
				// block only exists to BLOCK AWAY NULL references, and MUST
				// STAY!!
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
				// NEEDED TO HANDLE NULL CASES: do nothing in this case, this
				// block only exists to BLOCK AWAY NULL references, and MUST
				// STAY!!
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
				// NEEDED TO HANDLE NULL CASES: do nothing in this case, this
				// block only exists to BLOCK AWAY NULL references, and MUST
				// STAY!!
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
				// NEEDED TO HANDLE NULL CASES: do nothing in this case, this
				// block only exists to BLOCK AWAY NULL references, and MUST
				// STAY!!
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
				// NEEDED TO HANDLE NULL CASES: do nothing in this case, this
				// block only exists to BLOCK AWAY NULL references, and MUST
				// STAY!!
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
				// NEEDED TO HANDLE NULL CASES: do nothing in this case, this
				// block only exists to BLOCK AWAY NULL references, and MUST
				// STAY!!
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
				// NEEDED TO HANDLE NULL CASES: do nothing in this case, this
				// block only exists to BLOCK AWAY NULL references, and MUST
				// STAY!!
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
				// NEEDED TO HANDLE NULL CASES: do nothing in this case, this
				// block only exists to BLOCK AWAY NULL references, and MUST
				// STAY!!
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
				// NEEDED TO HANDLE NULL CASES: do nothing in this case, this
				// block only exists to BLOCK AWAY NULL references, and MUST
				// STAY!!
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
				// NEEDED TO HANDLE NULL CASES: do nothing in this case, this
				// block only exists to BLOCK AWAY NULL references, and MUST
				// STAY!!
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
				// NEEDED TO HANDLE NULL CASES: do nothing in this case, this
				// block only exists to BLOCK AWAY NULL references, and MUST
				// STAY!!
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
				// NEEDED TO HANDLE NULL CASES: do nothing in this case, this
				// block only exists to BLOCK AWAY NULL references, and MUST
				// STAY!!
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
				// NEEDED TO HANDLE NULL CASES: do nothing in this case, this
				// block only exists to BLOCK AWAY NULL references, and MUST
				// STAY!!
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
				// NEEDED TO HANDLE NULL CASES: do nothing in this case, this
				// block only exists to BLOCK AWAY NULL references, and MUST
				// STAY!!
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
				// NEEDED TO HANDLE NULL CASES: do nothing in this case, this
				// block only exists to BLOCK AWAY NULL references, and MUST
				// STAY!!
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
				// NEEDED TO HANDLE NULL CASES: do nothing in this case, this
				// block only exists to BLOCK AWAY NULL references, and MUST
				// STAY!!
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
				// NEEDED TO HANDLE NULL CASES: do nothing in this case, this
				// block only exists to BLOCK AWAY NULL references, and MUST
				// STAY!!
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
				// NEEDED TO HANDLE NULL CASES: do nothing in this case, this
				// block only exists to BLOCK AWAY NULL references, and MUST
				// STAY!!
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
				// NEEDED TO HANDLE NULL CASES: do nothing in this case, this
				// block only exists to BLOCK AWAY NULL references, and MUST
				// STAY!!
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
				// NEEDED TO HANDLE NULL CASES: do nothing in this case, this
				// block only exists to BLOCK AWAY NULL references, and MUST
				// STAY!!
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
	public static boolean when(Object src, Object cond1, Runnable sol1,
			Object cond2, Runnable sol2, Object cond3, Runnable sol3,
			Object cond4, Runnable sol4, Object cond5, Runnable sol5,
			Object cond6, Runnable sol6, Object cond7, Runnable sol7,
			Object cond8, Runnable sol8, Object cond9, Runnable sol9,
			Object cond10, Runnable sol10) {
		return sw(src, cond1, sol1, cond2, sol2, cond3, sol3, cond4, sol4,
				cond5, sol5, cond6, sol6, cond7, sol7, cond8, sol8, cond9, sol9,
				cond10, sol10);
	}
	public static boolean when(Object src, Object cond1, Runnable sol1,
			Object cond2, Runnable sol2, Object cond3, Runnable sol3,
			Object cond4, Runnable sol4, Object cond5, Runnable sol5,
			Object cond6, Runnable sol6, Object cond7, Runnable sol7,
			Object cond8, Runnable sol8, Object cond9, Runnable sol9) {
		return sw(src, cond1, sol1, cond2, sol2, cond3, sol3, cond4, sol4,
				cond5, sol5, cond6, sol6, cond7, sol7, cond8, sol8, cond9,
				sol9);
	}
	public static boolean when(Object src, Object cond1, Runnable sol1,
			Object cond2, Runnable sol2, Object cond3, Runnable sol3,
			Object cond4, Runnable sol4, Object cond5, Runnable sol5,
			Object cond6, Runnable sol6, Object cond7, Runnable sol7,
			Object cond8, Runnable sol8) {
		return sw(src, cond1, sol1, cond2, sol2, cond3, sol3, cond4, sol4,
				cond5, sol5, cond6, sol6, cond7, sol7, cond8, sol8);
	}
	public static boolean when(Object src, Object cond1, Runnable sol1,
			Object cond2, Runnable sol2, Object cond3, Runnable sol3,
			Object cond4, Runnable sol4, Object cond5, Runnable sol5,
			Object cond6, Runnable sol6, Object cond7, Runnable sol7) {
		return sw(src, cond1, sol1, cond2, sol2, cond3, sol3, cond4, sol4,
				cond5, sol5, cond6, sol6, cond7, sol7);
	}
	public static boolean when(Object src, Object cond1, Runnable sol1,
			Object cond2, Runnable sol2, Object cond3, Runnable sol3,
			Object cond4, Runnable sol4, Object cond5, Runnable sol5,
			Object cond6, Runnable sol6) {
		return sw(src, cond1, sol1, cond2, sol2, cond3, sol3, cond4, sol4,
				cond5, sol5, cond6, sol6);
	}
	public static boolean when(Object src, Object cond1, Runnable sol1,
			Object cond2, Runnable sol2, Object cond3, Runnable sol3,
			Object cond4, Runnable sol4, Object cond5, Runnable sol5) {
		return sw(src, cond1, sol1, cond2, sol2, cond3, sol3, cond4, sol4,
				cond5, sol5);
	}
	public static boolean when(Object src, Object cond1, Runnable sol1,
			Object cond2, Runnable sol2, Object cond3, Runnable sol3,
			Object cond4, Runnable sol4) {
		return sw(src, cond1, sol1, cond2, sol2, cond3, sol3, cond4, sol4);
	}
	public static boolean when(Object src, Object cond1, Runnable sol1,
			Object cond2, Runnable sol2, Object cond3, Runnable sol3) {
		return sw(src, cond1, sol1, cond2, sol2, cond3, sol3);
	}
	public static boolean when(Object src, Object cond1, Runnable sol1,
			Object cond2, Runnable sol2) {
		return sw(src, cond1, sol1, cond2, sol2);
	}
	public static boolean when(Object src, Object cond1, Runnable sol1) {
		return sw(src, cond1, sol1);
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
	public static final boolean Yes = true, No = !Yes, On = Yes, Off = No,
			Ok = Yes, NotOk = !Ok, Fail = NotOk;
	public static Object none = null, ignore = none, pass = ignore;
	public static String Else = "else";
	// helps method sw handle default/else cases
	public static String _s = "";
	public static int _i = 0;
	public static long _l = 0;
	public static float _f = 0;
	public static double _d = 0;
	public static boolean _b = false;
	public static int[] range(int n) {
		intArr arr = new intArr();
		if (not(n) || n < 1)
			return arr.array();
		for (int i = 0; i < n; i++)
			arr.add(i);
		return arr.array();
	}
	public static double[] range(double n) {
		dblArr arr = new dblArr();
		if (not(n) || n < 1.1)
			return arr.array();
		for (double i = 0; i < n; i += .1)
			arr.add(i);
		return arr.array();
	}
	public static int[] range(int m, int n, int... optional) {
		intArr arr = new intArr();
		if (isNull(m) || isNull(n) || eq(m, n))
			return arr.array();
		int step = 1;
		if (is(optional) && len(optional) == 1) {
			step = is(optional[0]) && !isNeg(optional[0]) && !isInf(optional[0])
					? optional[0]
					: 1;
		}
		if (m > n) {
			for (int i = m; i >= n; i -= step)
				arr.add(i);
		} else {
			for (int i = m; i <= n; i += step)
				arr.add(i);
		}
		return arr.array();
	}
	public static String[] range(String m, String n, int... optional) {
		strArr arr = new strArr();
		if (isNull(m) || isNull(n) || eq(m, n) || !eq(m, "[A-Za-z]")
				|| !eq(n, "[A-Za-z]"))
			return arr.array();
		int step = 1;
		if (is(optional) && len(optional) == 1) {
			step = is(optional[0]) && !isNeg(optional[0]) && !isInf(optional[0])
					? optional[0]
					: 1;
		}
		int charCodeOfM = (int) m.charAt(0), charCodeOfN = (int) n.charAt(0);
		if (charCodeOfM > charCodeOfN) {
			for (int i = charCodeOfM; i >= charCodeOfN; i -= step)
				arr.add(Str((char) i));
		} else {
			for (int i = charCodeOfM; i <= charCodeOfN; i += step)
				arr.add(Str((char) i));
		}
		return arr.array();
	}
	public static char[] range(char m, char n) {
		if (not(m) || not(n))
			return blank.Char;
		return join(range(Str(m), Str(n)), "").toCharArray();
	}
	public static double[] range(double m, double n, int... optional) {
		dblArr arr = new dblArr();
		if (isNull(m) || isNull(n) || eq(m, n))
			return arr.array();
		int step = 1;
		if (is(optional) && len(optional) == 1) {
			step = is(optional[0]) && !isNeg(optional[0]) && !isInf(optional[0])
					? optional[0]
					: 1;
		}
		if (m > n) {
			for (double i = m; i >= n; i -= .1 * step)
				arr.add(Dbl(setPrecision(i)));
		} else {
			for (double i = m; i <= n; i += .1 * step)
				arr.add(Dbl(setPrecision(i)));
		}
		return arr.array();
	}
	public static int[] range(int n, boolean reverse) {
		if (not(n) || isNeg(n))
			return new int[]{};
		if (reverse)
			return range(n, 1);
		return range(n);
	}
	public static int[] range(int m, int n, int gap, boolean reverse) {
		if (isNull(m) || isNull(n) || eq(m, n))
			return new int[]{};
		if (reverse)
			return range(n, m, gap);
		return range(m, n, gap);
	}
	public static int[] range(int m, int n, boolean reverse) {
		if (isNull(m) || isNull(n) || eq(m, n))
			return new int[]{};
		if (reverse)
			return range(n, m);
		return range(m, n);
	}
	public static double[] range(double n, boolean reverse) {
		if (not(n) || isNeg(n))
			return new double[]{};
		if (reverse)
			return range(n, 1);
		return range(n);
	}
	public static double[] range(double m, double n, int gap, boolean reverse) {
		if (isNull(m) || isNull(n) || eq(m, n))
			return new double[]{};
		if (reverse)
			return range(n, m, gap);
		return range(m, n, gap);
	}
	public static double[] range(double m, double n, boolean reverse) {
		if (isNull(m) || isNull(n) || eq(m, n))
			return new double[]{};
		if (reverse)
			return range(n, m);
		return range(m, n);
	}
	public static String[] range(String m, String n, int gap, boolean reverse) {
		if (not(m) || not(n) || eq(m, n))
			return new String[]{};
		if (reverse)
			return range(n, m, gap);
		return range(m, n, gap);
	}
	public static String[] range(String m, String n, boolean reverse) {
		if (not(m) || not(n) || eq(m, n))
			return new String[]{};
		if (reverse)
			return range(n, m);
		return range(m, n);
	}
	public static char[] range(char m, char n, boolean reverse) {
		if (not(m) || not(n) || eq(m, n))
			return new char[]{};
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
	public static int[] range(strArr arr) {
		return range(len(arr));
	}
	public static int[] range(intArr arr) {
		return range(len(arr));
	}
	public static int[] range(longArr arr) {
		return range(len(arr));
	}
	public static int[] range(fltArr arr) {
		return range(len(arr));
	}
	public static int[] range(dblArr arr) {
		return range(len(arr));
	}
	public static int[] range(boolArr arr) {
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
	public static int[] idx(strArr arr) {
		return range(arr);
	}
	public static int[] idx(intArr arr) {
		return range(arr);
	}
	public static int[] idx(longArr arr) {
		return range(arr);
	}
	public static int[] idx(fltArr arr) {
		return range(arr);
	}
	public static int[] idx(dblArr arr) {
		return range(arr);
	}
	public static int[] idx(boolArr arr) {
		return range(arr);
	}
	public static void each(String[] iterable,
			ObjIntConsumer<String> consumer) {
		if (not(iterable) || not(consumer))
			return;
		int i = 0;
		for (String item : iterable) {
			consumer.accept(item, i);
			i++;
		}
	}
	public static void each(String[] iterable, Consumer<String> consumer) {
		if (not(iterable) || not(consumer))
			return;
		for (String item : iterable) {
			consumer.accept(item);
		}
	}
	public static void each(strArr iterable, ObjIntConsumer<String> consumer) {
		each(iterable.array(), consumer);
	}
	public static void each(strArr iterable, Consumer<String> consumer) {
		each(iterable.array(), consumer);
	}
	public static void each(int[] iterable, ObjIntConsumer<Integer> consumer) {
		if (not(iterable) || not(consumer))
			return;
		int i = 0;
		for (int item : iterable) {
			consumer.accept(item, i);
			i++;
		}
	}
	public static void each(int[] iterable, Consumer<Integer> consumer) {
		if (not(iterable) || not(consumer))
			return;
		for (int item : iterable) {
			consumer.accept(item);
		}
	}
	public static void each(intArr iterable, ObjIntConsumer<Integer> consumer) {
		each(iterable.array(), consumer);
	}
	public static void each(intArr iterable, Consumer<Integer> consumer) {
		each(iterable.array(), consumer);
	}
	public static void each(long[] iterable, ObjIntConsumer<Long> consumer) {
		if (not(iterable) || not(consumer))
			return;
		int i = 0;
		for (long item : iterable) {
			consumer.accept(item, i);
			i++;
		}
	}
	public static void each(long[] iterable, Consumer<Long> consumer) {
		if (not(iterable) || not(consumer))
			return;
		for (long item : iterable) {
			consumer.accept(item);
		}
	}
	public static void each(longArr iterable, ObjIntConsumer<Long> consumer) {
		each(iterable.array(), consumer);
	}
	public static void each(longArr iterable, Consumer<Long> consumer) {
		each(iterable.array(), consumer);
	}
	public static void each(float[] iterable, ObjIntConsumer<Float> consumer) {
		if (not(iterable) || not(consumer))
			return;
		int i = 0;
		for (float item : iterable) {
			consumer.accept(item, i);
			i++;
		}
	}
	public static void each(float[] iterable, Consumer<Float> consumer) {
		if (not(iterable) || not(consumer))
			return;
		for (float item : iterable) {
			consumer.accept(item);
		}
	}
	public static void each(fltArr iterable, ObjIntConsumer<Float> consumer) {
		each(iterable.array(), consumer);
	}
	public static void each(fltArr iterable, Consumer<Float> consumer) {
		each(iterable.array(), consumer);
	}
	public static void each(double[] iterable,
			ObjIntConsumer<Double> consumer) {
		if (not(iterable) || not(consumer))
			return;
		int i = 0;
		for (double item : iterable) {
			consumer.accept(item, i);
			i++;
		}
	}
	public static void each(double[] iterable, Consumer<Double> consumer) {
		if (not(iterable) || not(consumer))
			return;
		for (double item : iterable) {
			consumer.accept(item);
		}
	}
	public static void each(dblArr iterable, ObjIntConsumer<Double> consumer) {
		each(iterable.array(), consumer);
	}
	public static void each(dblArr iterable, Consumer<Double> consumer) {
		each(iterable.array(), consumer);
	}
	public static void each(boolean[] iterable,
			ObjIntConsumer<Boolean> consumer) {
		if (not(iterable) || not(consumer))
			return;
		int i = 0;
		for (boolean item : iterable) {
			consumer.accept(item, i);
			i++;
		}
	}
	public static void each(boolean[] iterable, Consumer<Boolean> consumer) {
		if (not(iterable) || not(consumer))
			return;
		for (boolean item : iterable) {
			consumer.accept(item);
		}
	}
	public static void each(boolArr iterable,
			ObjIntConsumer<Boolean> consumer) {
		each(iterable.array(), consumer);
	}
	public static void each(boolArr iterable, Consumer<Boolean> consumer) {
		each(iterable.array(), consumer);
	}
	public static <T> void each(T[] iterable, ObjIntConsumer<T> consumer) {
		if (not(iterable) || not(consumer))
			return;
		int i = 0;
		for (T item : iterable) {
			consumer.accept(item, i);
			i++;
		}
	}
	public static <T> void each(T[] iterable, Consumer<T> consumer) {
		if (not(iterable) || not(consumer))
			return;
		for (T item : iterable) {
			consumer.accept(item);
		}
	}
	// handling Object arrays
	// DON'T remove
	public static void forEach(String[] iterable,
			ObjIntConsumer<String> consumer) {
		each(iterable, consumer);
	}
	public static void forEach(strArr iterable,
			ObjIntConsumer<String> consumer) {
		each(iterable, consumer);
	}
	public static void forEach(int[] iterable,
			ObjIntConsumer<Integer> consumer) {
		each(iterable, consumer);
	}
	public static void forEach(intArr iterable,
			ObjIntConsumer<Integer> consumer) {
		each(iterable, consumer);
	}
	public static void forEach(long[] iterable, ObjIntConsumer<Long> consumer) {
		each(iterable, consumer);
	}
	public static void forEach(longArr iterable,
			ObjIntConsumer<Long> consumer) {
		each(iterable, consumer);
	}
	public static void forEach(float[] iterable,
			ObjIntConsumer<Float> consumer) {
		each(iterable, consumer);
	}
	public static void forEach(fltArr iterable,
			ObjIntConsumer<Float> consumer) {
		each(iterable, consumer);
	}
	public static void forEach(double[] iterable,
			ObjIntConsumer<Double> consumer) {
		each(iterable, consumer);
	}
	public static void forEach(dblArr iterable,
			ObjIntConsumer<Double> consumer) {
		each(iterable, consumer);
	}
	public static void forEach(boolean[] iterable,
			ObjIntConsumer<Boolean> consumer) {
		each(iterable, consumer);
	}
	public static void forEach(boolArr iterable,
			ObjIntConsumer<Boolean> consumer) {
		each(iterable, consumer);
	}
	public static <T> void forEach(T[] iterable, ObjIntConsumer<T> consumer) {
		each(iterable, consumer);
	}
	// handling Object arrays
	// DON'T remove
	public static void repeat(Runnable fn, int times) {
		for (; times > 0; times--)
			new Thread(fn).run();
	}
	public static String repeat(String s, int times) {
		if (not(s) || not(times) || isNeg(times))
			return s;
		String org = s;
		for (; -1 + times > 0; times--)
			s += org;
		return s;
	}
	public static String repeat(String s) {
		return repeat(s, 2);
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
	public static boolean[] map(boolean[] arr,
			Function<Boolean, Boolean> func) {
		if (not(arr) || not(func))
			return arr;
		boolean[] result = new boolean[arr.length];
		for (int i = 0; i < arr.length; i++) {
			result[i] = func.apply(arr[i]);
		}
		return result;
	}
	public static String reduce(String[] arr, BinaryOperator<String> func) {
		if (not(arr) || not(func))
			return "";
		return Arrays.stream(arr).reduce("", func);
	}
	public static int reduce(int[] arr, IntBinaryOperator func) {
		if (not(arr) || not(func))
			return 0;
		return Arrays.stream(arr).reduce(0, func);
	}
	public static long reduce(long[] arr, LongBinaryOperator func) {
		if (not(arr) || not(func))
			return 0;
		return Arrays.stream(arr).reduce(0, func);
	}
	public static double reduce(double[] arr, DoubleBinaryOperator func) {
		if (not(arr) || not(func))
			return 0;
		return Arrays.stream(arr).reduce(0, func);
	}
	public static String[] popIf(String[] array, Predicate<String> condition) {
		return new strArr(array).popIf(condition).array();
	}
	public static int[] popIf(int[] array, Predicate<Integer> condition) {
		return new intArr(array).popIf(condition).array();
	}
	public static long[] popIf(long[] array, Predicate<Long> condition) {
		return new longArr(array).popIf(condition).array();
	}
	public static float[] popIf(float[] array, Predicate<Float> condition) {
		return new fltArr(array).popIf(condition).array();
	}
	public static double[] popIf(double[] array, Predicate<Double> condition) {
		return new dblArr(array).popIf(condition).array();
	}
	public static boolean[] popIf(boolean[] array,
			Predicate<Boolean> condition) {
		return new boolArr(array).popIf(condition).array();
	}
	public static strArr popIf(strArr list, Predicate<String> condition) {
		return list.popIf(condition);
	}
	public static intArr popIf(intArr list, Predicate<Integer> condition) {
		return list.popIf(condition);
	}
	public static longArr popIf(longArr list, Predicate<Long> condition) {
		return list.popIf(condition);
	}
	public static fltArr popIf(fltArr list, Predicate<Float> condition) {
		return list.popIf(condition);
	}
	public static dblArr popIf(dblArr list, Predicate<Double> condition) {
		return list.popIf(condition);
	}
	public static boolArr popIf(boolArr list, Predicate<Boolean> condition) {
		return list.popIf(condition);
	}
	public static String[] keepIf(String[] array, Predicate<String> condition) {
		return new strArr(array).keepIf(condition).array();
	}
	public static int[] keepIf(int[] array, Predicate<Integer> condition) {
		return new intArr(array).keepIf(condition).array();
	}
	public static long[] keepIf(long[] array, Predicate<Long> condition) {
		return new longArr(array).keepIf(condition).array();
	}
	public static float[] keepIf(float[] array, Predicate<Float> condition) {
		return new fltArr(array).keepIf(condition).array();
	}
	public static double[] keepIf(double[] array, Predicate<Double> condition) {
		return new dblArr(array).keepIf(condition).array();
	}
	public static boolean[] keepIf(boolean[] array,
			Predicate<Boolean> condition) {
		return new boolArr(array).keepIf(condition).array();
	}
	public static strArr keepIf(strArr list, Predicate<String> condition) {
		return list.keepIf(condition);
	}
	public static intArr keepIf(intArr list, Predicate<Integer> condition) {
		return list.keepIf(condition);
	}
	public static longArr keepIf(longArr list, Predicate<Long> condition) {
		return list.keepIf(condition);
	}
	public static fltArr keepIf(fltArr list, Predicate<Float> condition) {
		return list.keepIf(condition);
	}
	public static dblArr keepIf(dblArr list, Predicate<Double> condition) {
		return list.keepIf(condition);
	}
	public static boolArr keepIf(boolArr list, Predicate<Boolean> condition) {
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
	public static strArr filterOut(strArr list, Predicate<String> condition) {
		return popIf(list, condition);
	}
	public static intArr filterOut(intArr list, Predicate<Integer> condition) {
		return popIf(list, condition);
	}
	public static longArr filterOut(longArr list, Predicate<Long> condition) {
		return popIf(list, condition);
	}
	public static fltArr filterOut(fltArr list, Predicate<Float> condition) {
		return popIf(list, condition);
	}
	public static dblArr filterOut(dblArr list, Predicate<Double> condition) {
		return popIf(list, condition);
	}
	public static boolArr filterOut(boolArr list,
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
	public static strArr filter(strArr list, Predicate<String> condition) {
		return keepIf(list, condition);
	}
	public static intArr filter(intArr list, Predicate<Integer> condition) {
		return keepIf(list, condition);
	}
	public static longArr filter(longArr list, Predicate<Long> condition) {
		return keepIf(list, condition);
	}
	public static fltArr filter(fltArr list, Predicate<Float> condition) {
		return keepIf(list, condition);
	}
	public static dblArr filter(dblArr list, Predicate<Double> condition) {
		return keepIf(list, condition);
	}
	public static boolArr filter(boolArr list, Predicate<Boolean> condition) {
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
	public static strArr onlyPop(strArr list, Predicate<String> condition) {
		return popIf(list, condition);
	}
	public static intArr onlyPop(intArr list, Predicate<Integer> condition) {
		return popIf(list, condition);
	}
	public static longArr onlyPop(longArr list, Predicate<Long> condition) {
		return popIf(list, condition);
	}
	public static fltArr onlyPop(fltArr list, Predicate<Float> condition) {
		return popIf(list, condition);
	}
	public static dblArr onlyPop(dblArr list, Predicate<Double> condition) {
		return popIf(list, condition);
	}
	public static boolArr onlyPop(boolArr list, Predicate<Boolean> condition) {
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
	public static strArr onlyKeep(strArr list, Predicate<String> condition) {
		return keepIf(list, condition);
	}
	public static intArr onlyKeep(intArr list, Predicate<Integer> condition) {
		return keepIf(list, condition);
	}
	public static longArr onlyKeep(longArr list, Predicate<Long> condition) {
		return keepIf(list, condition);
	}
	public static fltArr onlyKeep(fltArr list, Predicate<Float> condition) {
		return keepIf(list, condition);
	}
	public static dblArr onlyKeep(dblArr list, Predicate<Double> condition) {
		return keepIf(list, condition);
	}
	public static boolArr onlyKeep(boolArr list, Predicate<Boolean> condition) {
		return keepIf(list, condition);
	}
	// Date functions
	public static String nthDay(int n) {
		String days[] = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday",
				"Friday", "Saturday"};
		return days[n];
	}
	public static String nthMonth(int n) {
		String months[] = {"January", "February", "March", "April", "May",
				"June", "July", "August", "September", "October", "November",
				"December"};
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
		String parts[] = date.split(", ");
		parts[0] = parts[0];
		parts[1] = split(parts[1], " ")[0] + " " + split(parts[1], " ")[1];
		String time = slice(parts, len(parts) - 1)[0];
		String x[] = {time, join(slice(parts, 0, len(parts) - 1), ", ")};
		String result = join(x, ", ");
		return result;
	}
	public static String now(boolean shortened) {
		if (!shortened)
			return now();
		String parts[] = now().split(", ");
		String time = parts[0], day = sliceKeep(parts[1], 3),
				dateOfMonth = sliceKeep(parts[2], 3) + " "
						+ parts[2].split(" ")[1],
				year = parts[3];
		String result = join(new String[]{time, day, dateOfMonth, year}, ", ");
		return result;
	}
	public static String getDate() {
		String parts[] = now().split(", ");
		return parts[2] + ", " + parts[3];
	}
	public static String getDay() {
		return now().split(", ")[1];
	}
	public static String getMonth() {
		return now().split(", ")[2].split(" ")[0];
	}
	public static String getYear() {
		return now().split(", ")[3];
	}
	public static String getTime() {
		return now().split(", ")[0];
	}
	public static String getTimestamp() {
		return now(true).toUpperCase().replaceAll("\\W+", "-");
	}
	public static String timestamp() {
		return getTimestamp();
	}
	public static String timesignature() {
		return getDatestamp();
	}
	public static String getDatestamp() {
		return getTimestamp().split("(?<=[AP]M)-")[1];
	}
	public static String datestamp() {
		return getDatestamp();
	}
	public static String datesignature() {
		return getDatestamp();
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
		dt.setTime(dt.getTime() + (5 * ((int) (36e2 * 1e3)))); // fix 5-hour bug
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
		if (isNull(args) || not(args.length))
			return;
		if (!isNull(args[0]) && args[0] instanceof String
				&& in(Str(args[0]), "[\\%\\$\\&\\{\\}]")) {
			if (len(args) >= 2) {
				new KL().printf((String) args[0], slice(args, 1));
				return;
			} else {
				new KL().printf((String) args[0], '\0', "", 0, 0L, 0F, 0D, No);
				return;
			}
		}
		if (len(args) == 1 && !isNull(args[0]) && isArr(args[0])) {
			printArr(args[0]);
			return;
		} else {
			for (Object arg : args) {
				if (isNull(arg))
					continue;
				if (isArr(arg)) {
					printArr(arg);
					System.out.print(" ");
				}
				if (arg instanceof Character)
					arg = "'" + arg + "'";
				if (arg instanceof Double) {
					if (in(Str((double) arg), "(?<=\\.)\\d{3,}"))
						arg = setPrecision((double) arg, 2);
					else
						arg = setPrecision((double) arg);
				}
				System.out.print(arg + " ");
			}
		}
	}
	public static void print(Object... args) {
		println(args);
		System.out.print("\n");
	}
	public static void kaho(Object... args) {
		println(args);
		System.out.print("\n");
	}
	public void printf(String str, Object... args) {
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
	public static void printArr(Object arg) {
		if (isNull(arg))
			return;
		if (arg instanceof Object[]) {
			// if one it's of those arrays that are based on a class
			if (isArrOfStr(arg)) {
				System.out.print("[" + (!isEmpty((String[]) arg)
						? "\"" + join((String[]) arg, "\", \"") + "\""
						: "") + "]");
			} else if (isArrOfNum(arg)) {
				System.out.print("[" + join((Number[]) arg) + "]");
			} else if (isArrOfObj(arg)) {
				System.out.print("[" + join((Object[]) arg, ", ") + "]");
			}
		} else {
			if (isArrOfChar(arg)) {
				System.out.print("[" + (!isEmpty((char[]) arg)
						? "\'" + join((char[]) arg, "\', \'") + "\'"
						: "") + "]");
			} else if (isArrOfInt(arg)) {
				System.out.print("[" + join((int[]) arg) + "]");
			} else if (isArrOfLong(arg)) {
				System.out.print("[" + join((long[]) arg) + "]");
			} else if (isArrOfFlt(arg)) {
				System.out.print("[" + join((float[]) arg) + "]");
			} else if (isArrOfDbl(arg)) {
				System.out.print("[" + join((double[]) arg) + "]");
			} else if (isArrOfBool(arg)) {
				System.out.print("[" + join((boolean[]) arg) + "]");
			}
		}
		System.out.print("\n");
	}
	public static void printArr(strArr arr) {
		print(arr.toString());
	}
	public static void printArr(intArr arr) {
		print(arr.toString());
	}
	public static void printArr(longArr arr) {
		print(arr.toString());
	}
	public static void printArr(fltArr arr) {
		print(arr.toString());
	}
	public static void printArr(dblArr arr) {
		print(arr.toString());
	}
	public static void printArr(boolArr arr) {
		print(arr.toString());
	}
	public static void printArr(objS o) {
		print(o.toString());
	}
	public static void printArr(objI o) {
		print(o.toString());
	}
	public static void printArr(objL o) {
		print(o.toString());
	}
	public static void printArr(objF o) {
		print(o.toString());
	}
	public static void printArr(objD o) {
		print(o.toString());
	}
	public static void printArr(objB o) {
		print(o.toString());
	}
	public static void printArr(treeDS t) {
		print(t.toString());
	}
	public static void printArr(treeDI t) {
		print(t.toString());
	}
	public static void printArr(treeI t) {
		print(t.toString());
	}
	public static void printArr(treeDL t) {
		print(t.toString());
	}
	public static void printArr(treeL t) {
		print(t.toString());
	}
	public static void printArr(treeDF t) {
		print(t.toString());
	}
	public static void printArr(treeF t) {
		print(t.toString());
	}
	public static void printArr(treeD t) {
		print(t.toString());
	}
	public static void printArr(treeDB t) {
		print(t.toString());
	}
	public static void printArr(treeB t) {
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
	public static void printAll(strArr arr) {
		printArr(arr);
	}
	public static void printAll(intArr arr) {
		printArr(arr);
	}
	public static void printAll(longArr arr) {
		printArr(arr);
	}
	public static void printAll(fltArr arr) {
		printArr(arr);
	}
	public static void printAll(dblArr arr) {
		printArr(arr);
	}
	public static void printAll(boolArr arr) {
		printArr(arr);
	}
	public static void printAll(objS o) {
		printArr(o);
	}
	public static void printAll(objI o) {
		printArr(o);
	}
	public static void printAll(objL o) {
		printArr(o);
	}
	public static void printAll(objF o) {
		printArr(o);
	}
	public static void printAll(objD o) {
		printArr(o);
	}
	public static void printAll(objB o) {
		printArr(o);
	}
	public static void printAll(treeDI t) {
		printArr(t);
	}
	public static void printAll(treeI t) {
		printArr(t);
	}
	public static void printAll(treeDL t) {
		printArr(t);
	}
	public static void printAll(treeL t) {
		printArr(t);
	}
	public static void printAll(treeDF t) {
		printArr(t);
	}
	public static void printAll(treeF t) {
		printArr(t);
	}
	public static void printAll(treeDS t) {
		printArr(t);
	}
	public static void printAll(treeD t) {
		printArr(t);
	}
	public static void printAll(treeDB t) {
		printArr(t);
	}
	public static void printAll(treeB t) {
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
	public static String String(strArr arr) {
		return arr.toString();
	}
	public static String String(intArr arr) {
		return arr.toString();
	}
	public static String String(longArr arr) {
		return arr.toString();
	}
	public static String String(fltArr arr) {
		return arr.toString();
	}
	public static String String(dblArr arr) {
		return arr.toString();
	}
	public static String String(boolArr arr) {
		return arr.toString();
	}
	public static String String(objS o) {
		return o.toString();
	}
	public static String String(objI o) {
		return o.toString();
	}
	public static String String(objL o) {
		return o.toString();
	}
	public static String String(objF o) {
		return o.toString();
	}
	public static String String(objD o) {
		return o.toString();
	}
	public static String String(objB o) {
		return o.toString();
	}
	public static String String(treeDI t) {
		return t.toString();
	}
	public static String String(treeI t) {
		return t.toString();
	}
	public static String String(treeDL t) {
		return t.toString();
	}
	public static String String(treeL t) {
		return t.toString();
	}
	public static String String(treeDF t) {
		return t.toString();
	}
	public static String String(treeF t) {
		return t.toString();
	}
	public static String String(treeDS t) {
		return t.toString();
	}
	public static String String(treeD t) {
		return t.toString();
	}
	public static String String(treeDB t) {
		return t.toString();
	}
	public static String String(treeB t) {
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
	public static String Str(strArr arr) {
		return String(arr);
	}
	public static String Str(intArr arr) {
		return String(arr);
	}
	public static String Str(longArr arr) {
		return String(arr);
	}
	public static String Str(fltArr arr) {
		return String(arr);
	}
	public static String Str(dblArr arr) {
		return String(arr);
	}
	public static String Str(boolArr arr) {
		return String(arr);
	}
	public static String Str(objS o) {
		return String(o);
	}
	public static String Str(objI o) {
		return String(o);
	}
	public static String Str(objL o) {
		return String(o);
	}
	public static String Str(objF o) {
		return String(o);
	}
	public static String Str(objD o) {
		return String(o);
	}
	public static String Str(objB o) {
		return String(o);
	}
	public static String Str(treeDI t) {
		return String(t);
	}
	public static String Str(treeI t) {
		return String(t);
	}
	public static String Str(treeDL t) {
		return String(t);
	}
	public static String Str(treeL t) {
		return String(t);
	}
	public static String Str(treeDF t) {
		return String(t);
	}
	public static String Str(treeF t) {
		return String(t);
	}
	public static String Str(treeDS t) {
		return String(t);
	}
	public static String Str(treeD t) {
		return String(t);
	}
	public static String Str(treeDB t) {
		return String(t);
	}
	public static String Str(treeB t) {
		return String(t);
	}
	public static String concat(Object... args) {
		if (not(args))
			return "";
		String result = "";
		for (var arg : args) {
			if (isNull(arg))
				continue;
			result += ("" + arg);
		}
		return result;
	}
	public static String cat(Object... args) {
		return concat(args);
	}
	public static strArr Arr(String... items) {
		if (isNull(items) || isEmpty(items))
			return blank.strArr;
		strArr arr = new strArr(items);
		return arr;
	}
	public static intArr Arr(int... items) {
		if (isNull(items) || isEmpty(items))
			return blank.intArr;
		intArr arr = new intArr(items);
		return arr;
	}
	public static longArr Arr(long... items) {
		if (isNull(items) || isEmpty(items))
			return blank.longArr;
		longArr arr = new longArr(items);
		return arr;
	}
	public static fltArr Arr(float... items) {
		if (isNull(items) || isEmpty(items))
			return blank.fltArr;
		fltArr arr = new fltArr(items);
		return arr;
	}
	public static dblArr Arr(double... items) {
		if (isNull(items) || isEmpty(items))
			return blank.dblArr;
		dblArr arr = new dblArr(items);
		return arr;
	}
	public static boolArr Arr(boolean... items) {
		if (isNull(items) || isEmpty(items))
			return blank.boolArr;
		boolArr arr = new boolArr(items);
		return arr;
	}
	public static strArr arr(String... items) {
		return Arr(items);
	}
	public static intArr arr(int... items) {
		return Arr(items);
	}
	public static longArr arr(long... items) {
		return Arr(items);
	}
	public static fltArr arr(float... items) {
		return Arr(items);
	}
	public static dblArr arr(double... items) {
		return Arr(items);
	}
	public static boolArr arr(boolean... items) {
		return Arr(items);
	}
	public static strArr naiArr(String... items) {
		return Arr(items);
	}
	public static intArr naiArr(int... items) {
		return Arr(items);
	}
	public static longArr naiArr(long... items) {
		return Arr(items);
	}
	public static fltArr naiArr(float... items) {
		return Arr(items);
	}
	public static dblArr naiArr(double... items) {
		return Arr(items);
	}
	public static boolArr naiArr(boolean... items) {
		return Arr(items);
	}
	public static String[] Arr(objS o) {
		if (not(o))
			return blank.Str;
		return o.array();
	}
	public static int[] Arr(objI o) {
		if (not(o))
			return blank.Int;
		return o.array();
	}
	public static long[] Arr(objL o) {
		if (not(o))
			return blank.Long;
		return o.array();
	}
	public static float[] Arr(objF o) {
		if (not(o))
			return blank.Flt;
		return o.array();
	}
	public static double[] Arr(objD o) {
		if (not(o))
			return blank.Dbl;
		return o.array();
	}
	public static boolean[] Arr(objB o) {
		if (not(o))
			return blank.Bool;
		return o.array();
	}
	public static String[] Arr(treeDS t) {
		if (not(t))
			return blank.Str;
		return t.array();
	}
	public static int[] Arr(treeDI t) {
		if (not(t))
			return blank.Int;
		return t.array();
	}
	public static String[] Arr(treeI t) {
		if (not(t))
			return blank.Str;
		return t.array();
	}
	public static long[] Arr(treeDL t) {
		if (not(t))
			return blank.Long;
		return t.array();
	}
	public static long[] Arr(treeL t) {
		if (not(t))
			return blank.Long;
		return t.array();
	}
	public static float[] Arr(treeDF t) {
		if (not(t))
			return blank.Flt;
		return t.array();
	}
	public static float[] Arr(treeF t) {
		if (not(t))
			return blank.Flt;
		return t.array();
	}
	public static double[] Arr(treeD t) {
		if (not(t))
			return blank.Dbl;
		return t.array();
	}
	public static boolean[] Arr(treeDB t) {
		if (not(t))
			return blank.Bool;
		return t.array();
	}
	public static boolean[] Arr(treeB t) {
		if (not(t))
			return blank.Bool;
		return t.array();
	}
	public static String[] arr(objS o) {
		return Arr(o);
	}
	public static int[] arr(objI o) {
		return Arr(o);
	}
	public static long[] arr(objL o) {
		return Arr(o);
	}
	public static float[] arr(objF o) {
		return Arr(o);
	}
	public static double[] arr(objD o) {
		return Arr(o);
	}
	public static boolean[] arr(objB o) {
		return Arr(o);
	}
	public static String[] arr(treeDS t) {
		return Arr(t);
	}
	public static int[] arr(treeDI t) {
		return Arr(t);
	}
	public static String[] arr(treeI t) {
		return Arr(t);
	}
	public static long[] arr(treeDL t) {
		return Arr(t);
	}
	public static long[] arr(treeL t) {
		return Arr(t);
	}
	public static float[] arr(treeDF t) {
		return Arr(t);
	}
	public static float[] arr(treeF t) {
		return Arr(t);
	}
	public static double[] arr(treeD t) {
		return Arr(t);
	}
	public static boolean[] arr(treeDB t) {
		return Arr(t);
	}
	public static boolean[] arr(treeB t) {
		return Arr(t);
	}
	public static objS obj(String k1, String v1, String k2, String v2,
			String k3, String v3, String k4, String v4, String k5, String v5,
			String k6, String v6, String k7, String v7, String k8, String v8,
			String k9, String v9, String k10, String v10) {
		return new objS(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8, k9, v9, k10, v10);
	}
	public static objS obj(String k1, String v1, String k2, String v2,
			String k3, String v3, String k4, String v4, String k5, String v5,
			String k6, String v6, String k7, String v7, String k8, String v8,
			String k9, String v9) {
		return new objS(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8, k9, v9);
	}
	public static objS obj(String k1, String v1, String k2, String v2,
			String k3, String v3, String k4, String v4, String k5, String v5,
			String k6, String v6, String k7, String v7, String k8, String v8) {
		return new objS(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8);
	}
	public static objS obj(String k1, String v1, String k2, String v2,
			String k3, String v3, String k4, String v4, String k5, String v5,
			String k6, String v6, String k7, String v7) {
		return new objS(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7);
	}
	public static objS obj(String k1, String v1, String k2, String v2,
			String k3, String v3, String k4, String v4, String k5, String v5,
			String k6, String v6) {
		return new objS(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
	}
	public static objS obj(String k1, String v1, String k2, String v2,
			String k3, String v3, String k4, String v4, String k5, String v5) {
		return new objS(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
	}
	public static objS obj(String k1, String v1, String k2, String v2,
			String k3, String v3, String k4, String v4) {
		return new objS(k1, v1, k2, v2, k3, v3, k4, v4);
	}
	public static objS obj(String k1, String v1, String k2, String v2,
			String k3, String v3) {
		return new objS(k1, v1, k2, v2, k3, v3);
	}
	public static objS obj(String k1, String v1, String k2, String v2) {
		return new objS(k1, v1, k2, v2);
	}
	public static objS obj(String k1, String v1) {
		return new objS(k1, v1);
	}
	public static objI obj(String k1, int v1, String k2, int v2, String k3,
			int v3, String k4, int v4, String k5, int v5, String k6, int v6,
			String k7, int v7, String k8, int v8, String k9, int v9, String k10,
			int v10) {
		return new objI(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8, k9, v9, k10, v10);
	}
	public static objI obj(String k1, int v1, String k2, int v2, String k3,
			int v3, String k4, int v4, String k5, int v5, String k6, int v6,
			String k7, int v7, String k8, int v8, String k9, int v9) {
		return new objI(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8, k9, v9);
	}
	public static objI obj(String k1, int v1, String k2, int v2, String k3,
			int v3, String k4, int v4, String k5, int v5, String k6, int v6,
			String k7, int v7, String k8, int v8) {
		return new objI(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8);
	}
	public static objI obj(String k1, int v1, String k2, int v2, String k3,
			int v3, String k4, int v4, String k5, int v5, String k6, int v6,
			String k7, int v7) {
		return new objI(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7);
	}
	public static objI obj(String k1, int v1, String k2, int v2, String k3,
			int v3, String k4, int v4, String k5, int v5, String k6, int v6) {
		return new objI(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
	}
	public static objI obj(String k1, int v1, String k2, int v2, String k3,
			int v3, String k4, int v4, String k5, int v5) {
		return new objI(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
	}
	public static objI obj(String k1, int v1, String k2, int v2, String k3,
			int v3, String k4, int v4) {
		return new objI(k1, v1, k2, v2, k3, v3, k4, v4);
	}
	public static objI obj(String k1, int v1, String k2, int v2, String k3,
			int v3) {
		return new objI(k1, v1, k2, v2, k3, v3);
	}
	public static objI obj(String k1, int v1, String k2, int v2) {
		return new objI(k1, v1, k2, v2);
	}
	public static objI obj(String k1, int v1) {
		return new objI(k1, v1);
	}
	public static objL obj(String k1, long v1, String k2, long v2, String k3,
			long v3, String k4, long v4, String k5, long v5, String k6, long v6,
			String k7, long v7, String k8, long v8, String k9, long v9,
			String k10, long v10) {
		return new objL(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8, k9, v9, k10, v10);
	}
	public static objL obj(String k1, long v1, String k2, long v2, String k3,
			long v3, String k4, long v4, String k5, long v5, String k6, long v6,
			String k7, long v7, String k8, long v8, String k9, long v9) {
		return new objL(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8, k9, v9);
	}
	public static objL obj(String k1, long v1, String k2, long v2, String k3,
			long v3, String k4, long v4, String k5, long v5, String k6, long v6,
			String k7, long v7, String k8, long v8) {
		return new objL(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8);
	}
	public static objL obj(String k1, long v1, String k2, long v2, String k3,
			long v3, String k4, long v4, String k5, long v5, String k6, long v6,
			String k7, long v7) {
		return new objL(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7);
	}
	public static objL obj(String k1, long v1, String k2, long v2, String k3,
			long v3, String k4, long v4, String k5, long v5, String k6,
			long v6) {
		return new objL(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
	}
	public static objL obj(String k1, long v1, String k2, long v2, String k3,
			long v3, String k4, long v4, String k5, long v5) {
		return new objL(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
	}
	public static objL obj(String k1, long v1, String k2, long v2, String k3,
			long v3, String k4, long v4) {
		return new objL(k1, v1, k2, v2, k3, v3, k4, v4);
	}
	public static objL obj(String k1, long v1, String k2, long v2, String k3,
			long v3) {
		return new objL(k1, v1, k2, v2, k3, v3);
	}
	public static objL obj(String k1, long v1, String k2, long v2) {
		return new objL(k1, v1, k2, v2);
	}
	public static objL obj(String k1, long v1) {
		return new objL(k1, v1);
	}
	public static objF obj(String k1, float v1, String k2, float v2, String k3,
			float v3, String k4, float v4, String k5, float v5, String k6,
			float v6, String k7, float v7, String k8, float v8, String k9,
			float v9, String k10, float v10) {
		return new objF(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8, k9, v9, k10, v10);
	}
	public static objF obj(String k1, float v1, String k2, float v2, String k3,
			float v3, String k4, float v4, String k5, float v5, String k6,
			float v6, String k7, float v7, String k8, float v8, String k9,
			float v9) {
		return new objF(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8, k9, v9);
	}
	public static objF obj(String k1, float v1, String k2, float v2, String k3,
			float v3, String k4, float v4, String k5, float v5, String k6,
			float v6, String k7, float v7, String k8, float v8) {
		return new objF(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8);
	}
	public static objF obj(String k1, float v1, String k2, float v2, String k3,
			float v3, String k4, float v4, String k5, float v5, String k6,
			float v6, String k7, float v7) {
		return new objF(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7);
	}
	public static objF obj(String k1, float v1, String k2, float v2, String k3,
			float v3, String k4, float v4, String k5, float v5, String k6,
			float v6) {
		return new objF(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
	}
	public static objF obj(String k1, float v1, String k2, float v2, String k3,
			float v3, String k4, float v4, String k5, float v5) {
		return new objF(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
	}
	public static objF obj(String k1, float v1, String k2, float v2, String k3,
			float v3, String k4, float v4) {
		return new objF(k1, v1, k2, v2, k3, v3, k4, v4);
	}
	public static objF obj(String k1, float v1, String k2, float v2, String k3,
			float v3) {
		return new objF(k1, v1, k2, v2, k3, v3);
	}
	public static objF obj(String k1, float v1, String k2, float v2) {
		return new objF(k1, v1, k2, v2);
	}
	public static objF obj(String k1, float v1) {
		return new objF(k1, v1);
	}
	public static objD obj(String k1, double v1, String k2, double v2,
			String k3, double v3, String k4, double v4, String k5, double v5,
			String k6, double v6, String k7, double v7, String k8, double v8,
			String k9, double v9, String k10, double v10) {
		return new objD(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8, k9, v9, k10, v10);
	}
	public static objD obj(String k1, double v1, String k2, double v2,
			String k3, double v3, String k4, double v4, String k5, double v5,
			String k6, double v6, String k7, double v7, String k8, double v8,
			String k9, double v9) {
		return new objD(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8, k9, v9);
	}
	public static objD obj(String k1, double v1, String k2, double v2,
			String k3, double v3, String k4, double v4, String k5, double v5,
			String k6, double v6, String k7, double v7, String k8, double v8) {
		return new objD(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8);
	}
	public static objD obj(String k1, double v1, String k2, double v2,
			String k3, double v3, String k4, double v4, String k5, double v5,
			String k6, double v6, String k7, double v7) {
		return new objD(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7);
	}
	public static objD obj(String k1, double v1, String k2, double v2,
			String k3, double v3, String k4, double v4, String k5, double v5,
			String k6, double v6) {
		return new objD(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
	}
	public static objD obj(String k1, double v1, String k2, double v2,
			String k3, double v3, String k4, double v4, String k5, double v5) {
		return new objD(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
	}
	public static objD obj(String k1, double v1, String k2, double v2,
			String k3, double v3, String k4, double v4) {
		return new objD(k1, v1, k2, v2, k3, v3, k4, v4);
	}
	public static objD obj(String k1, double v1, String k2, double v2,
			String k3, double v3) {
		return new objD(k1, v1, k2, v2, k3, v3);
	}
	public static objD obj(String k1, double v1, String k2, double v2) {
		return new objD(k1, v1, k2, v2);
	}
	public static objD obj(String k1, double v1) {
		return new objD(k1, v1);
	}
	public static objB obj(String k1, boolean v1, String k2, boolean v2,
			String k3, boolean v3, String k4, boolean v4, String k5, boolean v5,
			String k6, boolean v6, String k7, boolean v7, String k8, boolean v8,
			String k9, boolean v9, String k10, boolean v10) {
		return new objB(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8, k9, v9, k10, v10);
	}
	public static objB obj(String k1, boolean v1, String k2, boolean v2,
			String k3, boolean v3, String k4, boolean v4, String k5, boolean v5,
			String k6, boolean v6, String k7, boolean v7, String k8, boolean v8,
			String k9, boolean v9) {
		return new objB(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8, k9, v9);
	}
	public static objB obj(String k1, boolean v1, String k2, boolean v2,
			String k3, boolean v3, String k4, boolean v4, String k5, boolean v5,
			String k6, boolean v6, String k7, boolean v7, String k8,
			boolean v8) {
		return new objB(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8);
	}
	public static objB obj(String k1, boolean v1, String k2, boolean v2,
			String k3, boolean v3, String k4, boolean v4, String k5, boolean v5,
			String k6, boolean v6, String k7, boolean v7) {
		return new objB(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7);
	}
	public static objB obj(String k1, boolean v1, String k2, boolean v2,
			String k3, boolean v3, String k4, boolean v4, String k5, boolean v5,
			String k6, boolean v6) {
		return new objB(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
	}
	public static objB obj(String k1, boolean v1, String k2, boolean v2,
			String k3, boolean v3, String k4, boolean v4, String k5,
			boolean v5) {
		return new objB(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
	}
	public static objB obj(String k1, boolean v1, String k2, boolean v2,
			String k3, boolean v3, String k4, boolean v4) {
		return new objB(k1, v1, k2, v2, k3, v3, k4, v4);
	}
	public static objB obj(String k1, boolean v1, String k2, boolean v2,
			String k3, boolean v3) {
		return new objB(k1, v1, k2, v2, k3, v3);
	}
	public static objB obj(String k1, boolean v1, String k2, boolean v2) {
		return new objB(k1, v1, k2, v2);
	}
	public static objB obj(String k1, boolean v1) {
		return new objB(k1, v1);
	}
	// treeI
	public static treeI tree(int k1, String v1, int k2, String v2, int k3,
			String v3, int k4, String v4, int k5, String v5, int k6, String v6,
			int k7, String v7, int k8, String v8, int k9, String v9, int k10,
			String v10) {
		return new treeI(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8, k9, v9, k10, v10);
	}
	public static treeI tree(int k1, String v1, int k2, String v2, int k3,
			String v3, int k4, String v4, int k5, String v5, int k6, String v6,
			int k7, String v7, int k8, String v8, int k9, String v9) {
		return new treeI(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8, k9, v9);
	}
	public static treeI tree(int k1, String v1, int k2, String v2, int k3,
			String v3, int k4, String v4, int k5, String v5, int k6, String v6,
			int k7, String v7, int k8, String v8) {
		return new treeI(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8);
	}
	public static treeI tree(int k1, String v1, int k2, String v2, int k3,
			String v3, int k4, String v4, int k5, String v5, int k6, String v6,
			int k7, String v7) {
		return new treeI(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7,
				v7);
	}
	public static treeI tree(int k1, String v1, int k2, String v2, int k3,
			String v3, int k4, String v4, int k5, String v5, int k6,
			String v6) {
		return new treeI(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
	}
	public static treeI tree(int k1, String v1, int k2, String v2, int k3,
			String v3, int k4, String v4, int k5, String v5) {
		return new treeI(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
	}
	public static treeI tree(int k1, String v1, int k2, String v2, int k3,
			String v3, int k4, String v4) {
		return new treeI(k1, v1, k2, v2, k3, v3, k4, v4);
	}
	public static treeI tree(int k1, String v1, int k2, String v2, int k3,
			String v3) {
		return new treeI(k1, v1, k2, v2, k3, v3);
	}
	public static treeI tree(int k1, String v1, int k2, String v2) {
		return new treeI(k1, v1, k2, v2);
	}
	public static treeI tree(int k1, String v1) {
		return new treeI(k1, v1);
	}
	// part B
	public static treeDS tree(double k1, String v1, double k2, String v2,
			double k3, String v3, double k4, String v4, double k5, String v5,
			double k6, String v6, double k7, String v7, double k8, String v8,
			double k9, String v9, double k10, String v10) {
		return new treeDS(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7,
				v7, k8, v8, k9, v9, k10, v10);
	}
	public static treeDS tree(double k1, String v1, double k2, String v2,
			double k3, String v3, double k4, String v4, double k5, String v5,
			double k6, String v6, double k7, String v7, double k8, String v8,
			double k9, String v9) {
		return new treeDS(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7,
				v7, k8, v8, k9, v9);
	}
	public static treeDS tree(double k1, String v1, double k2, String v2,
			double k3, String v3, double k4, String v4, double k5, String v5,
			double k6, String v6, double k7, String v7, double k8, String v8) {
		return new treeDS(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7,
				v7, k8, v8);
	}
	public static treeDS tree(double k1, String v1, double k2, String v2,
			double k3, String v3, double k4, String v4, double k5, String v5,
			double k6, String v6, double k7, String v7) {
		return new treeDS(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7,
				v7);
	}
	public static treeDS tree(double k1, String v1, double k2, String v2,
			double k3, String v3, double k4, String v4, double k5, String v5,
			double k6, String v6) {
		return new treeDS(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
	}
	public static treeDS tree(double k1, String v1, double k2, String v2,
			double k3, String v3, double k4, String v4, double k5, String v5) {
		return new treeDS(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
	}
	public static treeDS tree(double k1, String v1, double k2, String v2,
			double k3, String v3, double k4, String v4) {
		return new treeDS(k1, v1, k2, v2, k3, v3, k4, v4);
	}
	public static treeDS tree(double k1, String v1, double k2, String v2,
			double k3, String v3) {
		return new treeDS(k1, v1, k2, v2, k3, v3);
	}
	public static treeDS tree(double k1, String v1, double k2, String v2) {
		return new treeDS(k1, v1, k2, v2);
	}
	public static treeDS tree(double k1, String v1) {
		return new treeDS(k1, v1);
	}
	// treeL
	public static treeL tree(int k1, long v1, int k2, long v2, int k3, long v3,
			int k4, long v4, int k5, long v5, int k6, long v6, int k7, long v7,
			int k8, long v8, int k9, long v9, int k10, long v10) {
		return new treeL(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8, k9, v9, k10, v10);
	}
	public static treeL tree(int k1, long v1, int k2, long v2, int k3, long v3,
			int k4, long v4, int k5, long v5, int k6, long v6, int k7, long v7,
			int k8, long v8, int k9, long v9) {
		return new treeL(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8, k9, v9);
	}
	public static treeL tree(int k1, long v1, int k2, long v2, int k3, long v3,
			int k4, long v4, int k5, long v5, int k6, long v6, int k7, long v7,
			int k8, long v8) {
		return new treeL(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8);
	}
	public static treeL tree(int k1, long v1, int k2, long v2, int k3, long v3,
			int k4, long v4, int k5, long v5, int k6, long v6, int k7,
			long v7) {
		return new treeL(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7,
				v7);
	}
	public static treeL tree(int k1, long v1, int k2, long v2, int k3, long v3,
			int k4, long v4, int k5, long v5, int k6, long v6) {
		return new treeL(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
	}
	public static treeL tree(int k1, long v1, int k2, long v2, int k3, long v3,
			int k4, long v4, int k5, long v5) {
		return new treeL(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
	}
	public static treeL tree(int k1, long v1, int k2, long v2, int k3, long v3,
			int k4, long v4) {
		return new treeL(k1, v1, k2, v2, k3, v3, k4, v4);
	}
	public static treeL tree(int k1, long v1, int k2, long v2, int k3,
			long v3) {
		return new treeL(k1, v1, k2, v2, k3, v3);
	}
	public static treeL tree(int k1, long v1, int k2, long v2) {
		return new treeL(k1, v1, k2, v2);
	}
	public static treeL tree(int k1, long v1) {
		return new treeL(k1, v1);
	}
	// part B
	public static treeDL tree(double k1, long v1, double k2, long v2, double k3,
			long v3, double k4, long v4, double k5, long v5, double k6, long v6,
			double k7, long v7, double k8, long v8, double k9, long v9,
			double k10, long v10) {
		return new treeDL(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7,
				v7, k8, v8, k9, v9, k10, v10);
	}
	public static treeDL tree(double k1, long v1, double k2, long v2, double k3,
			long v3, double k4, long v4, double k5, long v5, double k6, long v6,
			double k7, long v7, double k8, long v8, double k9, long v9) {
		return new treeDL(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7,
				v7, k8, v8, k9, v9);
	}
	public static treeDL tree(double k1, long v1, double k2, long v2, double k3,
			long v3, double k4, long v4, double k5, long v5, double k6, long v6,
			double k7, long v7, double k8, long v8) {
		return new treeDL(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7,
				v7, k8, v8);
	}
	public static treeDL tree(double k1, long v1, double k2, long v2, double k3,
			long v3, double k4, long v4, double k5, long v5, double k6, long v6,
			double k7, long v7) {
		return new treeDL(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7,
				v7);
	}
	public static treeDL tree(double k1, long v1, double k2, long v2, double k3,
			long v3, double k4, long v4, double k5, long v5, double k6,
			long v6) {
		return new treeDL(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
	}
	public static treeDL tree(double k1, long v1, double k2, long v2, double k3,
			long v3, double k4, long v4, double k5, long v5) {
		return new treeDL(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
	}
	public static treeDL tree(double k1, long v1, double k2, long v2, double k3,
			long v3, double k4, long v4) {
		return new treeDL(k1, v1, k2, v2, k3, v3, k4, v4);
	}
	public static treeDL tree(double k1, long v1, double k2, long v2, double k3,
			long v3) {
		return new treeDL(k1, v1, k2, v2, k3, v3);
	}
	public static treeDL tree(double k1, long v1, double k2, long v2) {
		return new treeDL(k1, v1, k2, v2);
	}
	public static treeDL tree(double k1, long v1) {
		return new treeDL(k1, v1);
	}
	// treeF
	public static treeF tree(int k1, float v1, int k2, float v2, int k3,
			float v3, int k4, float v4, int k5, float v5, int k6, float v6,
			int k7, float v7, int k8, float v8, int k9, float v9, int k10,
			float v10) {
		return new treeF(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8, k9, v9, k10, v10);
	}
	public static treeF tree(int k1, float v1, int k2, float v2, int k3,
			float v3, int k4, float v4, int k5, float v5, int k6, float v6,
			int k7, float v7, int k8, float v8, int k9, float v9) {
		return new treeF(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8, k9, v9);
	}
	public static treeF tree(int k1, float v1, int k2, float v2, int k3,
			float v3, int k4, float v4, int k5, float v5, int k6, float v6,
			int k7, float v7, int k8, float v8) {
		return new treeF(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8);
	}
	public static treeF tree(int k1, float v1, int k2, float v2, int k3,
			float v3, int k4, float v4, int k5, float v5, int k6, float v6,
			int k7, float v7) {
		return new treeF(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7,
				v7);
	}
	public static treeF tree(int k1, float v1, int k2, float v2, int k3,
			float v3, int k4, float v4, int k5, float v5, int k6, float v6) {
		return new treeF(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
	}
	public static treeF tree(int k1, float v1, int k2, float v2, int k3,
			float v3, int k4, float v4, int k5, float v5) {
		return new treeF(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
	}
	public static treeF tree(int k1, float v1, int k2, float v2, int k3,
			float v3, int k4, float v4) {
		return new treeF(k1, v1, k2, v2, k3, v3, k4, v4);
	}
	public static treeF tree(int k1, float v1, int k2, float v2, int k3,
			float v3) {
		return new treeF(k1, v1, k2, v2, k3, v3);
	}
	public static treeF tree(int k1, float v1, int k2, float v2) {
		return new treeF(k1, v1, k2, v2);
	}
	public static treeF tree(int k1, float v1) {
		return new treeF(k1, v1);
	}
	// partB
	public static treeDF tree(double k1, float v1, double k2, float v2,
			double k3, float v3, double k4, float v4, double k5, float v5,
			double k6, float v6, double k7, float v7, double k8, float v8,
			double k9, float v9, double k10, float v10) {
		return new treeDF(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7,
				v7, k8, v8, k9, v9, k10, v10);
	}
	public static treeDF tree(double k1, float v1, double k2, float v2,
			double k3, float v3, double k4, float v4, double k5, float v5,
			double k6, float v6, double k7, float v7, double k8, float v8,
			double k9, float v9) {
		return new treeDF(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7,
				v7, k8, v8, k9, v9);
	}
	public static treeDF tree(double k1, float v1, double k2, float v2,
			double k3, float v3, double k4, float v4, double k5, float v5,
			double k6, float v6, double k7, float v7, double k8, float v8) {
		return new treeDF(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7,
				v7, k8, v8);
	}
	public static treeDF tree(double k1, float v1, double k2, float v2,
			double k3, float v3, double k4, float v4, double k5, float v5,
			double k6, float v6, double k7, float v7) {
		return new treeDF(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7,
				v7);
	}
	public static treeDF tree(double k1, float v1, double k2, float v2,
			double k3, float v3, double k4, float v4, double k5, float v5,
			double k6, float v6) {
		return new treeDF(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
	}
	public static treeDF tree(double k1, float v1, double k2, float v2,
			double k3, float v3, double k4, float v4, double k5, float v5) {
		return new treeDF(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
	}
	public static treeDF tree(double k1, float v1, double k2, float v2,
			double k3, float v3, double k4, float v4) {
		return new treeDF(k1, v1, k2, v2, k3, v3, k4, v4);
	}
	public static treeDF tree(double k1, float v1, double k2, float v2,
			double k3, float v3) {
		return new treeDF(k1, v1, k2, v2, k3, v3);
	}
	public static treeDF tree(double k1, float v1, double k2, float v2) {
		return new treeDF(k1, v1, k2, v2);
	}
	public static treeDF tree(double k1, float v1) {
		return new treeDF(k1, v1);
	}
	// treeD: exclusive
	public static treeD tree(int k1, double v1, int k2, double v2, int k3,
			double v3, int k4, double v4, int k5, double v5, int k6, double v6,
			int k7, double v7, int k8, double v8, int k9, double v9, int k10,
			double v10) {
		return new treeD(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8, k9, v9, k10, v10);
	}
	public static treeD tree(int k1, double v1, int k2, double v2, int k3,
			double v3, int k4, double v4, int k5, double v5, int k6, double v6,
			int k7, double v7, int k8, double v8, int k9, double v9) {
		return new treeD(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8, k9, v9);
	}
	public static treeD tree(int k1, double v1, int k2, double v2, int k3,
			double v3, int k4, double v4, int k5, double v5, int k6, double v6,
			int k7, double v7, int k8, double v8) {
		return new treeD(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8);
	}
	public static treeD tree(int k1, double v1, int k2, double v2, int k3,
			double v3, int k4, double v4, int k5, double v5, int k6, double v6,
			int k7, double v7) {
		return new treeD(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7,
				v7);
	}
	public static treeD tree(int k1, double v1, int k2, double v2, int k3,
			double v3, int k4, double v4, int k5, double v5, int k6,
			double v6) {
		return new treeD(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
	}
	public static treeD tree(int k1, double v1, int k2, double v2, int k3,
			double v3, int k4, double v4, int k5, double v5) {
		return new treeD(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
	}
	public static treeD tree(int k1, double v1, int k2, double v2, int k3,
			double v3, int k4, double v4) {
		return new treeD(k1, v1, k2, v2, k3, v3, k4, v4);
	}
	public static treeD tree(int k1, double v1, int k2, double v2, int k3,
			double v3) {
		return new treeD(k1, v1, k2, v2, k3, v3);
	}
	public static treeD tree(int k1, double v1, int k2, double v2) {
		return new treeD(k1, v1, k2, v2);
	}
	public static treeD tree(int k1, double v1) {
		return new treeD(k1, v1);
	}
	// treeB
	public static treeB tree(int k1, boolean v1, int k2, boolean v2, int k3,
			boolean v3, int k4, boolean v4, int k5, boolean v5, int k6,
			boolean v6, int k7, boolean v7, int k8, boolean v8, int k9,
			boolean v9, int k10, boolean v10) {
		return new treeB(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8, k9, v9, k10, v10);
	}
	public static treeB tree(int k1, boolean v1, int k2, boolean v2, int k3,
			boolean v3, int k4, boolean v4, int k5, boolean v5, int k6,
			boolean v6, int k7, boolean v7, int k8, boolean v8, int k9,
			boolean v9) {
		return new treeB(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8, k9, v9);
	}
	public static treeB tree(int k1, boolean v1, int k2, boolean v2, int k3,
			boolean v3, int k4, boolean v4, int k5, boolean v5, int k6,
			boolean v6, int k7, boolean v7, int k8, boolean v8) {
		return new treeB(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7,
				k8, v8);
	}
	public static treeB tree(int k1, boolean v1, int k2, boolean v2, int k3,
			boolean v3, int k4, boolean v4, int k5, boolean v5, int k6,
			boolean v6, int k7, boolean v7) {
		return new treeB(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7,
				v7);
	}
	public static treeB tree(int k1, boolean v1, int k2, boolean v2, int k3,
			boolean v3, int k4, boolean v4, int k5, boolean v5, int k6,
			boolean v6) {
		return new treeB(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
	}
	public static treeB tree(int k1, boolean v1, int k2, boolean v2, int k3,
			boolean v3, int k4, boolean v4, int k5, boolean v5) {
		return new treeB(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
	}
	public static treeB tree(int k1, boolean v1, int k2, boolean v2, int k3,
			boolean v3, int k4, boolean v4) {
		return new treeB(k1, v1, k2, v2, k3, v3, k4, v4);
	}
	public static treeB tree(int k1, boolean v1, int k2, boolean v2, int k3,
			boolean v3) {
		return new treeB(k1, v1, k2, v2, k3, v3);
	}
	public static treeB tree(int k1, boolean v1, int k2, boolean v2) {
		return new treeB(k1, v1, k2, v2);
	}
	public static treeB tree(int k1, boolean v1) {
		return new treeB(k1, v1);
	}
	// part B
	public static treeDB tree(double k1, boolean v1, double k2, boolean v2,
			double k3, boolean v3, double k4, boolean v4, double k5, boolean v5,
			double k6, boolean v6, double k7, boolean v7, double k8, boolean v8,
			double k9, boolean v9, double k10, boolean v10) {
		return new treeDB(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7,
				v7, k8, v8, k9, v9, k10, v10);
	}
	public static treeDB tree(double k1, boolean v1, double k2, boolean v2,
			double k3, boolean v3, double k4, boolean v4, double k5, boolean v5,
			double k6, boolean v6, double k7, boolean v7, double k8, boolean v8,
			double k9, boolean v9) {
		return new treeDB(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7,
				v7, k8, v8, k9, v9);
	}
	public static treeDB tree(double k1, boolean v1, double k2, boolean v2,
			double k3, boolean v3, double k4, boolean v4, double k5, boolean v5,
			double k6, boolean v6, double k7, boolean v7, double k8,
			boolean v8) {
		return new treeDB(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7,
				v7, k8, v8);
	}
	public static treeDB tree(double k1, boolean v1, double k2, boolean v2,
			double k3, boolean v3, double k4, boolean v4, double k5, boolean v5,
			double k6, boolean v6, double k7, boolean v7) {
		return new treeDB(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7,
				v7);
	}
	public static treeDB tree(double k1, boolean v1, double k2, boolean v2,
			double k3, boolean v3, double k4, boolean v4, double k5, boolean v5,
			double k6, boolean v6) {
		return new treeDB(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
	}
	public static treeDB tree(double k1, boolean v1, double k2, boolean v2,
			double k3, boolean v3, double k4, boolean v4, double k5,
			boolean v5) {
		return new treeDB(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
	}
	public static treeDB tree(double k1, boolean v1, double k2, boolean v2,
			double k3, boolean v3, double k4, boolean v4) {
		return new treeDB(k1, v1, k2, v2, k3, v3, k4, v4);
	}
	public static treeDB tree(double k1, boolean v1, double k2, boolean v2,
			double k3, boolean v3) {
		return new treeDB(k1, v1, k2, v2, k3, v3);
	}
	public static treeDB tree(double k1, boolean v1, double k2, boolean v2) {
		return new treeDB(k1, v1, k2, v2);
	}
	public static treeDB tree(double k1, boolean v1) {
		return new treeDB(k1, v1);
	}
	public static char[] Chars(String str) {
		if (not(str))
			return blank.Char;
		char[] result = str.toCharArray();
		return result;
	}
	public static char Char(String str) {
		if (not(str))
			return '\0';
		char result = Chars(str)[0];
		return result;
	}
	public static char Char(int n) {
		if (isNull(n))
			return '\0';
		char result = (char) n;
		return result;
	}
	public static char Char(String str, int n) {
		if (not(str) || n < 0 || n >= len(str))
			return '\0';
		char result = Chars(str)[n];
		return result;
	}
	public static char nthCharOf(String str, int n) {
		if (not(str) || n < 0 || n >= len(str))
			return '\0';
		char result = Chars(str)[n];
		return result;
	}
	public static char nthLastCharOf(String str, int n) {
		if (not(str) || n <= 0 || n > len(str))
			return '\0';
		// tested, NO EDITS please; in the case of reverse indexes, this IS the
		// way the
		// "if" condition is meant to be, i.e. the 'n <= 0' part stays as found
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
		if (not(str))
			return blank.Str;
		String[] returnValue = slice(str.split(""), 1);
		// TESTED AND LEARNED: Java split(""), unlike in JavaScript , adds an
		// extra "" character at the beginning, i.e. at index 0, of the array
		// the string has been split into. JavaScript is way better in this
		// case.
		return returnValue;
	}
	public static String[] split(String str, String delimiting_str_or_regex) {
		if (not(str) || isNull(delimiting_str_or_regex))
			return blank.Str;
		// the null check was needed here
		String[] returnValue = str.split(delimiting_str_or_regex);
		if (eq(delimiting_str_or_regex, "")
				|| (len(returnValue) > 0 && eq(returnValue[0], "")))
			returnValue = slice(returnValue, 1);
		// TESTED AND LEARNED: Java split(""), unlike in JavaScript , adds an
		// extra "" character at the beginning, i.e. at index 0, of the array
		// the string has been split into. JavaScript is way better in this
		// case.
		return returnValue;
	}
	public static String[] splitIntoWords(String str) {
		if (not(str))
			return blank.Str;
		String[] returnValue = split(str, "[^a-zA-Z'\\-]+|\\-(?![a-zA-Z]{2,})");
		return returnValue;
	}
	public static String[] wordsOf(String str) {
		return splitIntoWords(str);
	}
	public static boolean wordsIn(String str) {
		return splitIntoWords(str).length > 0;
	}
	public static String join(String[] arr, String with) {
		if (not(arr) || isNull(with))
			return "";
		String returnValue = String.join(with, arr);
		return returnValue;
	}
	public static String join(int[] arr, String with) {
		if (not(arr) || isNull(with))
			return "";
		String[] midProcessedArray = new String[arr.length];
		for (int i : range(arr))
			midProcessedArray[i] = "" + arr[i];
		String returnValue = String.join(with, midProcessedArray);
		return returnValue;
	}
	public static String join(long[] arr, String with) {
		if (not(arr) || isNull(with))
			return "";
		String[] midProcessedArray = new String[arr.length];
		for (int i : range(arr))
			midProcessedArray[i] = "" + arr[i];
		String returnValue = String.join(with, midProcessedArray);
		return returnValue;
	}
	public static String join(float[] arr, String with) {
		if (not(arr) || isNull(with))
			return "";
		String[] midProcessedArray = new String[arr.length];
		for (int i : range(arr))
			midProcessedArray[i] = "" + arr[i];
		String returnValue = String.join(with, midProcessedArray);
		return returnValue;
	}
	public static String join(double[] arr, String with) {
		if (not(arr) || isNull(with))
			return "";
		String[] midProcessedArray = new String[arr.length];
		for (int i : range(arr))
			midProcessedArray[i] = "" + arr[i];
		String returnValue = String.join(with, midProcessedArray);
		return returnValue;
	}
	public static String join(boolean[] arr, String with) {
		if (not(arr) || isNull(with))
			return "";
		String[] midProcessedArray = new String[arr.length];
		for (int i : range(arr))
			midProcessedArray[i] = "" + arr[i];
		String returnValue = String.join(with, midProcessedArray);
		return returnValue;
	}
	public static String join(Number[] arr, String with) {
		if (not(arr) || isNull(with))
			return "";
		String[] midProcessedArray = new String[arr.length];
		for (int i : range(arr))
			midProcessedArray[i] = "" + arr[i];
		String returnValue = String.join(with, midProcessedArray);
		return returnValue;
	}
	public static String join(Object[] arr, String with) {
		if (not(arr) || isNull(with))
			return "";
		String[] midProcessedArray = new String[arr.length];
		for (int i : range(arr))
			midProcessedArray[i] = "" + arr[i];
		String returnValue = String.join(with, midProcessedArray);
		return returnValue;
	}
	public static String join(strArr arr, String with) {
		if (not(arr))
			return "";
		return join(arr.array(), with);
	}
	public static String join(intArr arr, String with) {
		if (not(arr))
			return "";
		return join(arr.array(), with);
	}
	public static String join(longArr arr, String with) {
		if (not(arr))
			return "";
		return join(arr.array(), with);
	}
	public static String join(fltArr arr, String with) {
		if (not(arr))
			return "";
		return join(arr.array(), with);
	}
	public static String join(dblArr arr, String with) {
		if (not(arr))
			return "";
		return join(arr.array(), with);
	}
	public static String join(boolArr arr, String with) {
		if (not(arr))
			return "";
		return join(arr.array(), with);
	}
	public static String join(objS o, String with) {
		if (not(o))
			return "";
		return join(o.array(), with);
	}
	public static String join(objI o, String with) {
		if (not(o))
			return "";
		return join(o.array(), with);
	}
	public static String join(objL o, String with) {
		if (not(o))
			return "";
		return join(o.array(), with);
	}
	public static String join(objF o, String with) {
		if (not(o))
			return "";
		return join(o.array(), with);
	}
	public static String join(objD o, String with) {
		if (not(o))
			return "";
		return join(o.array(), with);
	}
	public static String join(objB o, String with) {
		if (not(o))
			return "";
		return join(o.array(), with);
	}
	public static String join(treeDI t, String with) {
		if (not(t))
			return "";
		return join(t.array(), with);
	}
	public static String join(treeI t, String with) {
		if (not(t))
			return "";
		return join(t.array(), with);
	}
	public static String join(treeDL t, String with) {
		if (not(t))
			return "";
		return join(t.array(), with);
	}
	public static String join(treeL t, String with) {
		if (not(t))
			return "";
		return join(t.array(), with);
	}
	public static String join(treeDF t, String with) {
		if (not(t))
			return "";
		return join(t.array(), with);
	}
	public static String join(treeF t, String with) {
		if (not(t))
			return "";
		return join(t.array(), with);
	}
	public static String join(treeDS t, String with) {
		if (not(t))
			return "";
		return join(t.array(), with);
	}
	public static String join(treeD t, String with) {
		if (not(t))
			return "";
		return join(t.array(), with);
	}
	public static String join(treeDB t, String with) {
		if (not(t))
			return "";
		return join(t.array(), with);
	}
	public static String join(treeB t, String with) {
		if (not(t))
			return "";
		return join(t.array(), with);
	}
	public static String join(String... array) {
		if (not(array))
			return "";
		String halfProcessed = join(array, ", ");
		String returnValue = replace(halfProcessed, "(?<=,)(\\s)(?=\\w+$)",
				"$1and$1");
		// helps return a string in the American format of joining: a, b, and c
		// for
		// three items
		returnValue = sentCase(returnValue);
		return returnValue;
	}
	public static String join(int... array) {
		if (not(array))
			return "";
		String halfProcessed = join(array, ", ");
		String returnValue = replace(halfProcessed, "(?<=,)(\\s)(?=\\w+$)",
				"$1and$1");
		// helps return a string in the American format of joining: a, b, and c
		// for
		// three items
		returnValue = sentCase(returnValue);
		return returnValue;
	}
	public static String join(long... array) {
		if (not(array))
			return "";
		String halfProcessed = join(array, ", ");
		String returnValue = replace(halfProcessed, "(?<=,)(\\s)(?=\\w+$)",
				"$1and$1");
		// helps return a string in the American format of joining: a, b, and c
		// for
		// three items
		returnValue = sentCase(returnValue);
		return returnValue;
	}
	public static String join(float... array) {
		if (not(array))
			return "";
		String halfProcessed = join(array, ", ");
		String returnValue = replace(halfProcessed, "(?<=,)(\\s)(?=\\w+$)",
				"$1and$1");
		// helps return a string in the American format of joining: a, b, and c
		// for
		// three items
		returnValue = sentCase(returnValue);
		return returnValue;
	}
	public static String join(double... array) {
		if (not(array))
			return "";
		String halfProcessed = join(array, ", ");
		String returnValue = replace(halfProcessed, "(?<=,)(\\s)(?=\\w+$)",
				"$1and$1");
		// helps return a string in the American format of joining: a, b, and c
		// for
		// three items
		returnValue = sentCase(returnValue);
		return returnValue;
	}
	public static String join(boolean... array) {
		if (not(array))
			return "";
		String halfProcessed = join(array, ", ");
		String returnValue = replace(halfProcessed, "(?<=,)(\\s)(?=\\w+$)",
				"$1and$1");
		// helps return a string in the American format of joining: a, b, and c
		// for
		// three items
		returnValue = sentCase(returnValue);
		return returnValue;
	}
	public static String join(Number... array) {
		if (not(array))
			return "";
		String halfProcessed = join(array, ", ");
		String returnValue = replace(halfProcessed, "(?<=,)(\\s)(?=\\w+$)",
				"$1and$1");
		// helps return a string in the American format of joining: a, b, and c
		// for
		// three items
		returnValue = sentCase(returnValue);
		return returnValue;
	}
	public static String join(Object... array) {
		if (not(array))
			return "";
		String halfProcessed = join(array, ", ");
		String returnValue = replace(halfProcessed, "(?<=,)(\\s)(?=\\w+$)",
				"$1and$1");
		// helps return a string in the American format of joining: a, b, and c
		// for
		// three items
		returnValue = sentCase(returnValue);
		return returnValue;
	}
	public static String join(strArr arr) {
		if (not(arr))
			return "";
		return join(arr.array());
	}
	public static String join(intArr arr) {
		if (not(arr))
			return "";
		return join(arr.array());
	}
	public static String join(longArr arr) {
		if (not(arr))
			return "";
		return join(arr.array());
	}
	public static String join(fltArr arr) {
		if (not(arr))
			return "";
		return join(arr.array());
	}
	public static String join(dblArr arr) {
		if (not(arr))
			return "";
		return join(arr.array());
	}
	public static String join(boolArr arr) {
		if (not(arr))
			return "";
		return join(arr.array());
	}
	public static String join(objS o) {
		if (not(o))
			return "";
		return join(o.array());
	}
	public static String join(objI o) {
		if (not(o))
			return "";
		return join(o.array());
	}
	public static String join(objL o) {
		if (not(o))
			return "";
		return join(o.array());
	}
	public static String join(objF o) {
		if (not(o))
			return "";
		return join(o.array());
	}
	public static String join(objD o) {
		if (not(o))
			return "";
		return join(o.array());
	}
	public static String join(objB o) {
		if (not(o))
			return "";
		return join(o.array());
	}
	public static String join(treeDI t) {
		if (not(t))
			return "";
		return join(t.array());
	}
	public static String join(treeI t) {
		if (not(t))
			return "";
		return join(t.array());
	}
	public static String join(treeDL t) {
		if (not(t))
			return "";
		return join(t.array());
	}
	public static String join(treeL t) {
		if (not(t))
			return "";
		return join(t.array());
	}
	public static String join(treeDF t) {
		if (not(t))
			return "";
		return join(t.array());
	}
	public static String join(treeF t) {
		if (not(t))
			return "";
		return join(t.array());
	}
	public static String join(treeDS t) {
		if (not(t))
			return "";
		return join(t.array());
	}
	public static String join(treeD t) {
		if (not(t))
			return "";
		return join(t.array());
	}
	public static String join(treeDB t) {
		if (not(t))
			return "";
		return join(t.array());
	}
	public static String join(treeB t) {
		if (not(t))
			return "";
		return join(t.array());
	}
	public static boolean eq(String x, String y) {
		if (not(x) || not(y))
			return false;
		y = y.replaceAll("^\\^|\\$$", "");
		return match(x, "^(" + y + ")$");
	}
	public static boolean eq(String x, String y, boolean strict) {
		if (not(x) || not(y))
			return false;
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
			return Integer.parseInt(arg.replaceAll("(?<=\\d)\\.\\d+", ""),
					base);
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
		if (not(n) || isNull(decimalPlaces) || isNeg(decimalPlaces))
			return n;
		String formatted = String.format("%." + Str(decimalPlaces) + "f", n);
		return Dbl(formatted);
	}
	public static double toPrecision(double n, int decimalPlaces) {
		return setPrecision(n, decimalPlaces);
	}
	public static double setPrecision(double n) {
		return setPrecision(n, 1);
	}
	public static double toPrecision(double n) {
		return setPrecision(n);
	}
	public static float setPrecision(float n, int decimalPlaces) {
		if (not(n) || isNull(decimalPlaces) || isNeg(decimalPlaces))
			return n;
		String formatted = String.format("%." + Str(decimalPlaces) + "f", n);
		return Flt(formatted);
	}
	public static float toPrecision(float n, int decimalPlaces) {
		return setPrecision(n, decimalPlaces);
	}
	public static float setPrecision(float n) {
		return setPrecision(n, 1);
	}
	public static float toPrecision(float n) {
		return setPrecision(n);
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
	public static <T> java.util.List<T> list(T... args) {
		return List(args);
	}
	// may or MAY NOT work, as working with generic types can be unpredictable,
	// as
	// learned from the mistakes in the past. So, here are some backup plans:
	public static java.util.List<String> list(String... arg) {
		return List(arg);
	}
	public static java.util.List<Integer> list(Integer... arg) {
		return List(arg);
	}
	public static java.util.List<Long> list(Long... arg) {
		return List(arg);
	}
	public static java.util.List<Float> list(Float... arg) {
		return List(arg);
	}
	public static java.util.List<Double> list(Double... arg) {
		return List(arg);
	}
	public static java.util.List<Boolean> list(Boolean... arg) {
		return List(arg);
	}
	public static boolean isIntLike(String s) {
		if (not(s))
			return false;
		try {
			return Integer.parseInt(s) % 1 == 0;
		} catch (Exception err) {
			return false;
		}
	}
	public static boolean isLongLike(String s) {
		return isIntLike(s);
	}
	public static boolean isFltLike(String s) {
		if (not(s))
			return false;
		try {
			return Float.parseFloat(s) % 1 != 0;
		} catch (Exception err) {
			return false;
		}
	}
	public static boolean isDblLike(String s) {
		if (not(s))
			return false;
		try {
			return Double.parseDouble(s) % 1 != 0;
		} catch (Exception err) {
			return false;
		}
	}
	public static boolean isChar(Object o) {
		return type(o, Char);
	}
	public static boolean isStr(Object o) {
		return type(o, Str);
	}
	public static boolean isInt(Object o) {
		return type(o, Int);
	}
	public static boolean isLong(Object o) {
		return type(o, Long);
	}
	public static boolean isFlt(Object o) {
		return type(o, Flt);
	}
	public static boolean isDbl(Object o) {
		return type(o, Dbl);
	}
	public static boolean isBool(Object o) {
		return type(o, Bool);
	}
	public static boolean isArr(Object o) {
		return type(o, Arr);
	}
	public static boolean isArrOfChar(Object o) {
		return type(o, ArrOfChar);
	}
	public static boolean isArrOfStr(Object o) {
		return type(o, ArrOfStr);
	}
	public static boolean isArrOfInt(Object o) {
		return type(o, ArrOfInt);
	}
	public static boolean isArrOfLong(Object o) {
		return type(o, ArrOfLong);
	}
	public static boolean isArrOfFlt(Object o) {
		return type(o, ArrOfFlt);
	}
	public static boolean isArrOfDbl(Object o) {
		return type(o, ArrOfDbl);
	}
	public static boolean isArrOfBool(Object o) {
		return type(o, ArrOfBool);
	}
	public static boolean isArrOfNum(Object o) {
		return type(o, ArrOfNum);
	}
	public static boolean isArrOfObj(Object o) {
		return type(o, ArrOfObj);
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
	public static int sum(int... ns) {
		if (not(ns))
			return 0;
		int acc = 0;
		for (int next = 0; next < ns.length; next++)
			acc += ns[next];
		return acc;
	}
	public static long sum(long... ns) {
		if (not(ns))
			return 0;
		long acc = 0;
		for (int next = 0; next < ns.length; next++)
			acc += ns[next];
		return acc;
	}
	public static float sum(float... ns) {
		if (not(ns))
			return 0;
		float acc = 0;
		for (int next = 0; next < ns.length; next++)
			acc += ns[next];
		return acc;
	}
	public static double sum(double... ns) {
		if (not(ns))
			return 0;
		double acc = 0;
		for (int next = 0; next < ns.length; next++)
			acc += ns[next];
		return acc;
	}
	public static int sum(intArr ns) {
		if (not(ns))
			return 0;
		int acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc += ns.array()[next];
		return acc;
	}
	public static long sum(longArr ns) {
		if (not(ns))
			return 0;
		long acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc += ns.array()[next];
		return acc;
	}
	public static float sum(fltArr ns) {
		if (not(ns))
			return 0;
		float acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc += ns.array()[next];
		return acc;
	}
	public static double sum(dblArr ns) {
		if (not(ns))
			return 0;
		double acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc += ns.array()[next];
		return acc;
	}
	public static int sum(objI ns) {
		if (not(ns))
			return 0;
		int acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc += ns.array()[next];
		return acc;
	}
	public static long sum(objL ns) {
		if (not(ns))
			return 0;
		long acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc += ns.array()[next];
		return acc;
	}
	public static float sum(objF ns) {
		if (not(ns))
			return 0;
		float acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc += ns.array()[next];
		return acc;
	}
	public static double sum(objD ns) {
		if (not(ns))
			return 0;
		double acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc += ns.array()[next];
		return acc;
	}
	public static int sum(treeDI ns) {
		if (not(ns))
			return 0;
		int acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc += ns.array()[next];
		return acc;
	}
	public static long sum(treeDL ns) {
		if (not(ns))
			return 0;
		long acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc += ns.array()[next];
		return acc;
	}
	public static long sum(treeL ns) {
		if (not(ns))
			return 0;
		long acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc += ns.array()[next];
		return acc;
	}
	public static float sum(treeDF ns) {
		if (not(ns))
			return 0;
		float acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc += ns.array()[next];
		return acc;
	}
	public static float sum(treeF ns) {
		if (not(ns))
			return 0;
		float acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc += ns.array()[next];
		return acc;
	}
	public static double sum(treeD ns) {
		if (not(ns))
			return 0;
		double acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc += ns.array()[next];
		return acc;
	}
	public static int difference(int... ns) {
		if (not(ns))
			return 0;
		int acc = ns[0];
		for (int next = 1; next < ns.length; next++)
			acc -= ns[next];
		return acc;
	}
	public static long difference(long... ns) {
		if (not(ns))
			return 0;
		long acc = ns[0];
		for (int next = 1; next < ns.length; next++)
			acc -= ns[next];
		return acc;
	}
	public static float difference(float... ns) {
		if (not(ns))
			return 0;
		float acc = ns[0];
		for (int next = 1; next < ns.length; next++)
			acc -= ns[next];
		return acc;
	}
	public static double difference(double... ns) {
		if (not(ns))
			return 0;
		double acc = ns[0];
		for (int next = 1; next < ns.length; next++)
			acc -= ns[next];
		return acc;
	}
	public static int difference(intArr ns) {
		int acc = ns.i(0);
		for (int next = 1; next < ns.length(); next++)
			acc -= ns.array()[next];
		return acc;
	}
	public static long difference(longArr ns) {
		long acc = ns.i(0);
		for (int next = 1; next < ns.length(); next++)
			acc -= ns.array()[next];
		return acc;
	}
	public static float difference(fltArr ns) {
		float acc = ns.i(0);
		for (int next = 1; next < ns.length(); next++)
			acc -= ns.array()[next];
		return acc;
	}
	public static double difference(dblArr ns) {
		double acc = ns.i(0);
		for (int next = 1; next < ns.length(); next++)
			acc -= ns.array()[next];
		return acc;
	}
	public static int difference(objI ns) {
		if (not(ns))
			return 0;
		int acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc -= ns.array()[next];
		return acc;
	}
	public static long difference(objL ns) {
		if (not(ns))
			return 0;
		long acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc -= ns.array()[next];
		return acc;
	}
	public static float difference(objF ns) {
		if (not(ns))
			return 0;
		float acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc -= ns.array()[next];
		return acc;
	}
	public static double difference(objD ns) {
		if (not(ns))
			return 0;
		double acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc -= ns.array()[next];
		return acc;
	}
	public static int difference(treeDI ns) {
		if (not(ns))
			return 0;
		int acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc -= ns.array()[next];
		return acc;
	}
	public static long difference(treeDL ns) {
		if (not(ns))
			return 0;
		long acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc -= ns.array()[next];
		return acc;
	}
	public static long difference(treeL ns) {
		if (not(ns))
			return 0;
		long acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc -= ns.array()[next];
		return acc;
	}
	public static float difference(treeDF ns) {
		if (not(ns))
			return 0;
		float acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc -= ns.array()[next];
		return acc;
	}
	public static float difference(treeF ns) {
		if (not(ns))
			return 0;
		float acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc -= ns.array()[next];
		return acc;
	}
	public static double difference(treeD ns) {
		if (not(ns))
			return 0;
		double acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc -= ns.array()[next];
		return acc;
	}
	public static int product(int... ns) {
		if (not(ns))
			return 0;
		int acc = ns[0];
		for (int next = 1; next < ns.length; next++)
			acc *= ns[next];
		return acc;
	}
	public static long product(long... ns) {
		if (not(ns))
			return 0;
		long acc = ns[0];
		for (int next = 1; next < ns.length; next++)
			acc *= ns[next];
		return acc;
	}
	public static float product(float... ns) {
		if (not(ns))
			return 0;
		float acc = ns[0];
		for (int next = 1; next < ns.length; next++)
			acc *= ns[next];
		return acc;
	}
	public static double product(double... ns) {
		if (not(ns))
			return 0;
		double acc = ns[0];
		for (int next = 1; next < ns.length; next++)
			acc *= ns[next];
		return acc;
	}
	public static int product(intArr ns) {
		if (not(ns))
			return 0;
		int acc = ns.i(0);
		for (int next = 1; next < ns.length(); next++)
			acc *= ns.array()[next];
		return acc;
	}
	public static long product(longArr ns) {
		if (not(ns))
			return 0;
		long acc = ns.i(0);
		for (int next = 1; next < ns.length(); next++)
			acc *= ns.array()[next];
		return acc;
	}
	public static float product(fltArr ns) {
		if (not(ns))
			return 0;
		float acc = ns.i(0);
		for (int next = 1; next < ns.length(); next++)
			acc *= ns.array()[next];
		return acc;
	}
	public static double product(dblArr ns) {
		if (not(ns))
			return 0;
		double acc = ns.i(0);
		for (int next = 1; next < ns.length(); next++)
			acc *= ns.array()[next];
		return acc;
	}
	public static int product(objI ns) {
		if (not(ns))
			return 0;
		int acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc *= ns.array()[next];
		return acc;
	}
	public static long product(objL ns) {
		if (not(ns))
			return 0;
		long acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc *= ns.array()[next];
		return acc;
	}
	public static float product(objF ns) {
		if (not(ns))
			return 0;
		float acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc *= ns.array()[next];
		return acc;
	}
	public static double product(objD ns) {
		if (not(ns))
			return 0;
		double acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc *= ns.array()[next];
		return acc;
	}
	public static int product(treeDI ns) {
		if (not(ns))
			return 0;
		int acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc *= ns.array()[next];
		return acc;
	}
	public static long product(treeDL ns) {
		if (not(ns))
			return 0;
		long acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc *= ns.array()[next];
		return acc;
	}
	public static long product(treeL ns) {
		if (not(ns))
			return 0;
		long acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc *= ns.array()[next];
		return acc;
	}
	public static float product(treeDF ns) {
		if (not(ns))
			return 0;
		float acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc *= ns.array()[next];
		return acc;
	}
	public static float product(treeF ns) {
		if (not(ns))
			return 0;
		float acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc *= ns.array()[next];
		return acc;
	}
	public static double product(treeD ns) {
		if (not(ns))
			return 0;
		double acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc *= ns.array()[next];
		return acc;
	}
	public static int quotient(int... ns) {
		if (not(ns))
			return 0;
		int acc = ns[0];
		for (int next = 1; next < ns.length; next++)
			acc /= ns[next];
		return acc;
	}
	public static long quotient(long... ns) {
		if (not(ns))
			return 0;
		long acc = ns[0];
		for (int next = 1; next < ns.length; next++)
			acc /= ns[next];
		return acc;
	}
	public static float quotient(float... ns) {
		if (not(ns))
			return 0;
		float acc = ns[0];
		for (int next = 1; next < ns.length; next++)
			acc /= ns[next];
		return acc;
	}
	public static double quotient(double... ns) {
		if (not(ns))
			return 0;
		double acc = ns[0];
		for (int next = 1; next < ns.length; next++)
			acc /= ns[next];
		return acc;
	}
	public static int quotient(intArr ns) {
		if (not(ns))
			return 0;
		int acc = ns.i(0);
		for (int next = 1; next < ns.length(); next++)
			acc /= ns.array()[next];
		return acc;
	}
	public static long quotient(longArr ns) {
		if (not(ns))
			return 0;
		long acc = ns.i(0);
		for (int next = 1; next < ns.length(); next++)
			acc /= ns.array()[next];
		return acc;
	}
	public static float quotient(fltArr ns) {
		if (not(ns))
			return 0;
		float acc = ns.i(0);
		for (int next = 1; next < ns.length(); next++)
			acc /= ns.array()[next];
		return acc;
	}
	public static double quotient(dblArr ns) {
		if (not(ns))
			return 0;
		double acc = ns.i(0);
		for (int next = 1; next < ns.length(); next++)
			acc /= ns.array()[next];
		return acc;
	}
	public static int quotient(objI ns) {
		if (not(ns))
			return 0;
		int acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc /= ns.array()[next];
		return acc;
	}
	public static long quotient(objL ns) {
		if (not(ns))
			return 0;
		long acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc /= ns.array()[next];
		return acc;
	}
	public static float quotient(objF ns) {
		if (not(ns))
			return 0;
		float acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc /= ns.array()[next];
		return acc;
	}
	public static double quotient(objD ns) {
		if (not(ns))
			return 0;
		double acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc /= ns.array()[next];
		return acc;
	}
	public static int quotient(treeDI ns) {
		if (not(ns))
			return 0;
		int acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc /= ns.array()[next];
		return acc;
	}
	public static long quotient(treeDL ns) {
		if (not(ns))
			return 0;
		long acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc /= ns.array()[next];
		return acc;
	}
	public static long quotient(treeL ns) {
		if (not(ns))
			return 0;
		long acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc /= ns.array()[next];
		return acc;
	}
	public static float quotient(treeDF ns) {
		if (not(ns))
			return 0;
		float acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc /= ns.array()[next];
		return acc;
	}
	public static float quotient(treeF ns) {
		if (not(ns))
			return 0;
		float acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc /= ns.array()[next];
		return acc;
	}
	public static double quotient(treeD ns) {
		if (not(ns))
			return 0;
		double acc = 0;
		for (int next = 0; next < ns.length(); next++)
			acc /= ns.array()[next];
		return acc;
	}
	public static int pow(int n, int power) {
		if (isNull(n, power))
			return 0;
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
	public static int min(intArr nums) {
		IntSummaryStatistics stat = Arrays.stream(nums.array())
				.summaryStatistics();
		return stat.getMin();
	}
	public static long min(longArr nums) {
		LongSummaryStatistics stat = Arrays.stream(nums.array())
				.summaryStatistics();
		return stat.getMin();
	}
	public static double min(dblArr nums) {
		DoubleSummaryStatistics stat = Arrays.stream(nums.array())
				.summaryStatistics();
		return stat.getMin();
	}
	public static int min(objI nums) {
		IntSummaryStatistics stat = Arrays.stream(nums.array())
				.summaryStatistics();
		return stat.getMin();
	}
	public static long min(objL nums) {
		LongSummaryStatistics stat = Arrays.stream(nums.array())
				.summaryStatistics();
		return stat.getMin();
	}
	public static double min(objD nums) {
		DoubleSummaryStatistics stat = Arrays.stream(nums.array())
				.summaryStatistics();
		return stat.getMin();
	}
	public static int min(treeDI nums) {
		IntSummaryStatistics stat = Arrays.stream(nums.array())
				.summaryStatistics();
		return stat.getMin();
	}
	public static long min(treeDL nums) {
		LongSummaryStatistics stat = Arrays.stream(nums.array())
				.summaryStatistics();
		return stat.getMin();
	}
	public static long min(treeL nums) {
		LongSummaryStatistics stat = Arrays.stream(nums.array())
				.summaryStatistics();
		return stat.getMin();
	}
	public static double min(treeD nums) {
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
	public static int max(intArr nums) {
		IntSummaryStatistics stat = Arrays.stream(nums.array())
				.summaryStatistics();
		return stat.getMax();
	}
	public static long max(longArr nums) {
		LongSummaryStatistics stat = Arrays.stream(nums.array())
				.summaryStatistics();
		return stat.getMax();
	}
	public static double max(dblArr nums) {
		DoubleSummaryStatistics stat = Arrays.stream(nums.array())
				.summaryStatistics();
		return stat.getMax();
	}
	public static int max(objI nums) {
		IntSummaryStatistics stat = Arrays.stream(nums.array())
				.summaryStatistics();
		return stat.getMax();
	}
	public static long max(objL nums) {
		LongSummaryStatistics stat = Arrays.stream(nums.array())
				.summaryStatistics();
		return stat.getMax();
	}
	public static double max(objD nums) {
		DoubleSummaryStatistics stat = Arrays.stream(nums.array())
				.summaryStatistics();
		return stat.getMax();
	}
	public static int max(treeDI nums) {
		IntSummaryStatistics stat = Arrays.stream(nums.array())
				.summaryStatistics();
		return stat.getMax();
	}
	public static long max(treeDL nums) {
		LongSummaryStatistics stat = Arrays.stream(nums.array())
				.summaryStatistics();
		return stat.getMax();
	}
	public static long max(treeL nums) {
		LongSummaryStatistics stat = Arrays.stream(nums.array())
				.summaryStatistics();
		return stat.getMax();
	}
	public static double max(treeD nums) {
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
	public static boolean isDivisorOf(int n1, int n2) {
		return isPerfectMod(n1, n2);
	}
	public static boolean isDivisorOf(long n1, long n2) {
		return isPerfectMod(n1, n2);
	}
	public static int[] divisorsOf(int n) {
		if (not(n))
			return blank.Int;
		intArr result = new intArr();
		for (int i = 2; i < n; i++) {
			if (isPerfectMod(n, i))
				result.add(i);
		}
		return result.array();
	}
	public static long[] divisorsOf(long n) {
		if (not(n))
			return blank.Long;
		longArr result = new longArr();
		for (long i = 2; i < n; i++) {
			if (isPerfectMod(n, i))
				result.add(i);
		}
		return result.array();
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
	public static String th(int n) {
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
	// since a long is just a LONG integer, this should work^
	// let's set up some currency variables
	public static double zr = 1e3, lc = 1e5, cr = 1e7, ar = 1e9, kh = 1e11;
	public static double K = 1e3, M = 1e6, B = 1e9, T = 1e12, qd = 1e15,
			qt = 1e18, sx = 1e21, sp = 1e24, oc = 1e27, nn = 1e30, dc = 1e33;
	public static String fpkr(int amount) {
		if (isNull(amount))
			return "";
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
		if (isNull(amount))
			return "";
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
		if (isNull(amount))
			return "";
		double floats = setPrecision(amount % 1);
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
		if (isNull(amount))
			return "";
		double floats = setPrecision(amount % 1);
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
		if (isNull(n))
			return "";
		return NumberFormat
				.getCurrencyInstance(new Locale.Builder().setLanguage("en")
						.setRegion("US").build())
				.format(n).replaceAll("[^\\d\\,\\.]", "");
	}
	public static String fus(long n) {
		if (isNull(n))
			return "";
		return NumberFormat
				.getCurrencyInstance(new Locale.Builder().setLanguage("en")
						.setRegion("US").build())
				.format(n).replaceAll("[^\\d\\,\\.]", "");
	}
	public static String fus(float n) {
		if (isNull(n))
			return "";
		return NumberFormat
				.getCurrencyInstance(new Locale.Builder().setLanguage("en")
						.setRegion("US").build())
				.format(n).replaceAll("[^\\d\\,\\.]", "");
	}
	public static String fus(double n) {
		if (isNull(n))
			return "";
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
	public String f(String s, Object... args) {
		if (not(s) || args.length == 0)
			return s;
		// for specifiers
		s = s.replaceAll("%l", "%d").replaceAll("%[\\.\\d]*f", "%f")
				.replaceAll("%[\\.\\d]*db(u)?", "%n$1");
		// handling exponentials
		String[] exponentialMatches = findMatches(s,
				"\\-?\\d*\\.?\\d+[Ee][\\+\\-]?\\d+");
		if (hasLen(exponentialMatches)) {
			double[] parsedNumsWithoutPowers = new double[exponentialMatches.length];
			int[] parsedExponentialPowers = new int[exponentialMatches.length];
			for (int i : range(exponentialMatches)) {
				parsedNumsWithoutPowers[i] = Dbl(exponentialMatches[i]
						.replaceAll("[Ee][\\+\\-]?\\d+$", ""));
				parsedExponentialPowers[i] = Int(findMatch(
						exponentialMatches[i], "(?<=\\d[Ee])[\\+\\-]?\\d+"));
				double[] parsedNumsWithPowers = parsedNumsWithoutPowers;
				// temporarily
				int power = parsedExponentialPowers[i];
				if (isNeg(power)) {
					while (power < 0) {
						parsedNumsWithPowers[i] /= 10;
						parsedNumsWithPowers[i] = setPrecision(
								parsedNumsWithPowers[i], 14);
						power++;
					}
				} else {
					while (power > 0) {
						parsedNumsWithPowers[i] *= 10;
						parsedNumsWithPowers[i] = setPrecision(
								parsedNumsWithPowers[i], 14);
						power--;
					}
				}
				s = s.replaceFirst(exponentialMatches[i].replaceAll(
						"([\\+\\-])", "\\\\$1"), Str(parsedNumsWithPowers[i]));
			}
		}
		String[] matches = findMatches(s,
				"%[\\%cswdifnb]((c|uc?)([\\:\\.][A-Za-z]{3,4})?|th|r)?|\\$*\\{(\\.\\d*f)?\\}");
		// printArr(matches.length > 0 ? matches : blank.Str);
		for (String m : matches) {
			for (Object arg : args) {
				if (arg instanceof Character && eq(m, "%[\\%c]|\\$*\\{\\}")) {
					s = replaceFirst(s, m, Str(arg));
				} else if (arg instanceof String
						&& eq(m, "%[\\%sw]|\\$*\\{\\}")) {
					s = replaceFirst(s, m, Str(arg));
				} else if ((arg instanceof Integer || arg instanceof Long)
						&& (in(m, "%[\\%din](th|uc?|c|r)?|\\$*\\{\\}"))) {
					if (eq(m, "%[\\%din](?!th|uc?|c)|\\$*\\{\\}")) {
						s = replaceFirst(s, m,
								Str(f(arg instanceof Integer
										? (int) arg
										: (long) arg))
										.replaceAll("\\.[0]+(?!\\d)$", ""));
					} else if (in(m, "%[din]u")) {
						if (eq(m, "%[din]uc")) {
							s = replaceFirst(s, m,
									Str(usd(arg instanceof Integer
											? (int) arg
											: (long) arg))
											.replaceAll("\\.[0]+(?!\\d)$", ""));
						} else {
							s = replaceFirst(s, "%[din]u",
									Str(fus(arg instanceof Integer
											? (int) arg
											: (long) arg))
											.replaceAll("\\.[0]+(?!\\d)$", ""));
						}
					} else if (eq(m, "%[din]th")) {
						s = replaceFirst(s, m,
								Str(th(arg instanceof Integer
										? (int) arg
										: (long) arg)));
					} else if (eq(m, "%[din]r")) {
						s = replaceFirst(s, m, Str(toRoman((int) arg)));
					} else {
						if (in(m, "%[din]c([\\:\\.][A-Za-z]{3,4})?")) {
							if (eq(m, "%[din]c([\\:\\.][A-Za-z]{3,4})")) {
								String currency = m.split("[\\:\\.]")[1];
								s = replaceFirst(s, m,
										Str(curr(arg instanceof Integer
												? (int) arg
												: (long) arg, currency))
												.replaceAll("\\.[0]+(?!\\d)$",
														""));
							} else {
								s = replaceFirst(s, m,
										Str(pkr(arg instanceof Integer
												? (int) arg
												: (long) arg)).replaceAll(
														"\\.[0]+(?!\\d)$", ""));
							}
						}
					}
				} else if (arg instanceof Float || arg instanceof Double) {
					if (in(m, "%[\\%fn]u|\\$*\\{(\\.\\d*f)?\\}")) {
						// DOESN'T work IF the % is not escaped
						if (eq(m, "%[\\%fn]uc")) {
							s = replaceFirst(s, m,
									Str(usd(setPrecision(arg instanceof Float
											? (float) arg
											: (double) arg)).replaceAll(
													"\\.[0]+(?!\\d)$", "")));
						} else {
							s = replaceFirst(s, "%[%fn]u|\\$*\\{(\\.\\d*f)?\\}",
									Str(fus(setPrecision(arg instanceof Float
											? (float) arg
											: (double) arg)).replaceAll(
													"\\.[0]+(?!\\d)$", "")));
						}
					} else if (in(m, "%[\\%fn]c?(?!u)|\\$*\\{(\\.\\d*f)?\\}")) {
						if (in(m, "%[fn]c([\\:\\.][A-Za-z]{3,4})?")) {
							if (eq(m, "%[fn]c([\\:\\.][A-Za-z]{3,4})")) {
								String currency = m.split("[\\:\\.]")[1];
								s = replaceFirst(s, m,
										Str(curr(
												arg instanceof Float
														? (float) arg
														: (double) arg,
												currency)).replaceAll(
														"\\.[0]+(?!\\d)$", ""));
							} else {
								s = replaceFirst(s, m,
										Str(pkr(arg instanceof Float
												? (float) arg
												: (double) arg)).replaceAll(
														"\\.[0]+(?!\\d)$", ""));
							}
						} else {
							s = replaceFirst(s, "%[%fn]|\\$*\\{(\\.\\d*f)?\\}",
									Str(f(setPrecision(arg instanceof Float
											? (float) arg
											: (double) arg)).replaceAll(
													"\\.[0]+(?!\\d)$", "")));
						}
					}
				} else if (arg instanceof Boolean
						&& eq(m, "%[\\%b]|\\$*\\{\\}")) {
					s = replaceFirst(s, m, Str((boolean) arg));
				}
				// replaceFirst is really what we need here, as replacing "all"
				// %b's, for instance, in the case of booleans, with the args
				// array,
				// just wouldn't work, as the first argument would get to be the
				// one
				// to replace all %b's with itself, rendering all other
				// <typename>
				// args useless
			}
		}
		// post processing...
		// for methods
		if (in(s,
				"\\$*\\{\\w+[:\\(][\\w\\.\\s,]*\\)*\\}|\\$+\\w+[:\\(][\\w\\.\\s,]*\\)*")) {
			try {
				Class<?> cls = this.getClass();
				Object valueFromMethod = new Object();
				boolean hasParams = false;
				String[] methodicalMatches = findMatches(s,
						"\\$*\\{\\w+[:\\(][\\w\\.\\s,]*\\)*\\}|\\$+\\w+[:\\(][\\w\\.\\s,]*\\)*");
				for (String m : methodicalMatches) {
					String toGet = m.replaceAll(
							"(?<=\\w)[:\\(][\\w\\.\\s,]+\\)*|[\\$\\{\\(\\)\\}]",
							"");
					if (in(m, "(?<=\\w[:\\(])[\\w\\.\\s,]+(?=\\)*)"))
						hasParams = true;
					if (!hasParams)
						valueFromMethod = cls.getMethod(toGet).invoke(this);
					else {
						boolean multiParam = false;
						String unprocessedParamString = m.replaceAll(
								"^[\\$\\w]+[:\\(](?=\\w+)|\\)*$", "");
						if (in(unprocessedParamString, "\\s*,\\s*")) {
							multiParam = true;
							String[] paramMatches = unprocessedParamString
									.split("\\s*,\\s*");
							Object[] finalParams = new Object[paramMatches.length];
							Class<?>[] paramTypes = new Class<?>[paramMatches.length];
							for (int i : range(paramMatches)) {
								String param = paramMatches[i];
								paramTypes[i] = isIntLike(param)
										? (!in(param, "(?<=\\d)[Ll]$")
												? int.class
												: long.class)
										: isFltLike(param)
												? (!in(param, "(?<=\\d)[Ff]$")
														? double.class
														: float.class)
												: eq(param, "true|false")
														? boolean.class
														: String.class;
								param = param.replaceAll("(?<=\\d)[LlFf]$", "");
								// ----------------------- NOTE
								// -----------------------------
								// Since longs can hold both ints, and longs,
								// and
								// are literally just LONG integers, LONG.CLASS
								// DOES
								// THE JOB!!
								// Same goes for floats, and doubles. A double
								// is
								// literally just a float, except with extra, or
								// double, precision.
								// ----------------------------------------------------------
								finalParams[i] = isIntLike(param)
										? Int(param)
										: isDblLike(param)
												? Dbl(param)
												: eq(param, "true|false")
														? (eq(param, "true")
																? true
																: false)
														: Str(param);
							}
							for (String param : paramMatches) {
								valueFromMethod = cls
										.getMethod(toGet, paramTypes)
										.invoke(this, finalParams);

								m = m.replaceAll("([\\$\\{\\(\\)\\}])",
										"\\\\$1");
								s = s.replaceFirst(m,
										valueFromMethod instanceof Character
												|| valueFromMethod instanceof String
												|| valueFromMethod instanceof Number
												|| valueFromMethod instanceof Boolean
														? Str(valueFromMethod)
														: m);
							}
						} else {
							Class<?> type = isIntLike(unprocessedParamString)
									? (!in(unprocessedParamString,
											"(?<=\\d)[Ll]$")
													? int.class
													: long.class)
									: isFltLike(unprocessedParamString)
											? (!in(unprocessedParamString,
													"(?<=\\d)[Ff]$")
															? double.class
															: float.class)
											: eq(unprocessedParamString,
													"true|false")
															? boolean.class
															: String.class;
							unprocessedParamString = unprocessedParamString
									.replaceAll("(?<=\\d)[LlFf]$", "");
							// ----------------------- NOTE
							// -----------------------------
							// Since longs can hold both ints, and longs, and
							// are literally just LONG integers, LONG.CLASS DOES
							// THE JOB!!
							// Same goes for floats, and doubles. A double is
							// literally just a float, except with extra, or
							// double, precision.
							// ----------------------------------------------------------
							valueFromMethod = cls.getMethod(toGet, type).invoke(
									this,
									isIntLike(unprocessedParamString)
											? Int(unprocessedParamString)
											: isDblLike(unprocessedParamString)
													? Dbl(unprocessedParamString)
													: eq(unprocessedParamString,
															"true|false")
																	? (eq(unprocessedParamString,
																			"true")
																					? true
																					: false)
																	: unprocessedParamString);
						}
					}
					m = m.replaceAll("([\\$\\{\\(\\)\\}])", "\\\\$1");
					s = s.replaceFirst(m,
							valueFromMethod instanceof Character
									|| valueFromMethod instanceof String
									|| valueFromMethod instanceof Number
									|| valueFromMethod instanceof Boolean
											? Str(valueFromMethod)
											: m);
				}
			} catch (NoSuchMethodException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException
					| SecurityException e) {

			}
		}
		// FOR FIELDS
		if (in(s, "\\$*\\{\\w+\\}|\\$+\\w+(?!\\(\\w*\\))")) {
			try {
				Class<?> cls = this.getClass();
				Object field;
				String[] fieldMatches = findMatches(s,
						"\\$*\\{\\w+\\}|\\$+\\w+");
				for (String m : fieldMatches) {
					String toGet = m.replaceAll("[\\$\\{\\}]", "");
					field = cls.getField(toGet).get(this);
					m = m.replaceAll("([\\$\\{\\}])", "\\\\$1");
					s = s.replaceFirst(m,
							field instanceof Character
									|| field instanceof String
									|| field instanceof Number
									|| field instanceof Boolean
											? Str(field)
											: m);
				}
			} catch (NoSuchFieldException | IllegalAccessException
					| SecurityException e) {

			}
		}
		// for numeric operations
		String catchNumericValuesWithOperator = "(?<=\\&)(?<operandA>\\-?\\d*\\.?\\d+)(?<op>[\\+\\-\\*\\×\\/\\÷])(?<operandB>\\-?\\d*\\.?\\d+)";
		while (in(s, catchNumericValuesWithOperator)) {
			String[] numericMatchesWithOperators = findMatches(s,
					catchNumericValuesWithOperator);
			if (in(s, catchNumericValuesWithOperator)) {
				for (String m : numericMatchesWithOperators) {
					String[] parts = m
							.split("(?<=\\d)[\\+\\-\\*\\×\\/\\÷](?=[\\.\\d]+)");
					double operandA = Dbl(parts[0]), operandB = Dbl(parts[1]);
					String op = m.replaceAll(
							"[^\\+\\-\\*\\×\\/\\÷]|^[\\+\\-\\*\\×\\/\\÷]", "");
					double result = 0;
					switch (op) {
						case "+" :
							result = setPrecision(operandA + operandB);
							break;
						case "-" :
							result = setPrecision(operandA - operandB);
							break;
						case "*" :
						case "×" :
							result = setPrecision(operandA * operandB);
							break;
						case "/" :
						case "÷" :
							result = setPrecision(operandA / operandB);
							break;
					}
					s = replaceFirst(s, catchNumericValuesWithOperator,
							Str(result).replaceAll("\\.0(?!\\d)$", ""));
				}
			}
		}
		s = s.replaceAll("&(?=\\-?\\d*\\.?\\d+)", "");
		// cleaning up to make up for the numeric results, removing the &
		// operator
		s = sentCase(s);
		return s;
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
		String result = "USD " + formattedN;
		return result;
	}
	public static String usd(long n) {
		String formattedN = fus(n);
		String result = "USD " + formattedN;
		return result;
	}
	public static String usd(float n) {
		String formattedN = fus(n);
		String result = "USD " + formattedN;
		return result;
	}
	public static String usd(double n) {
		String formattedN = fus(n);
		String result = "USD " + formattedN;
		return result;
	}
	public static String curr(int n, String locale) {
		String formattedN = fus(n);
		if (startsWith(locale, "pk|in|rs"))
			return pkr(n);
		else if (startsWith(locale, "us"))
			return usd(n);
		else if (len(locale) >= 1 && len(locale) <= 4)
			return trim(titleCase(locale)) + " " + formattedN;
		return formattedN;
	}
	public static String curr(long n, String locale) {
		String formattedN = fus(n);
		if (startsWith(locale, "pk|in|rs"))
			return pkr(n);
		else if (startsWith(locale, "us"))
			return usd(n);
		else if (len(locale) >= 1 && len(locale) < 4)
			return trim(titleCase(locale)) + " " + formattedN;
		return formattedN;
	}
	public static String curr(float n, String locale) {
		String formattedN = fus(n);
		if (startsWith(locale, "pk|in|rs"))
			return pkr(n);
		else if (startsWith(locale, "us"))
			return usd(n);
		else if (len(locale) >= 1 && len(locale) < 4)
			return trim(titleCase(locale)) + " " + formattedN;
		return formattedN;
	}
	public static String curr(double n, String locale) {
		String formattedN = fus(n);
		if (startsWith(locale, "pk|in|rs"))
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
		treeI tree = new treeI();
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
		intArr result = new intArr();
		for (int i : range(n))
			result.push(fibonacci(i + 1));
		return result.array();
	}
	public static double percentify(double n1, double n2) {
		if (not(n1) || not(n2))
			return 0;
		if (n1 < n2)
			return Math.round(n1 / n2 * 100.0) / 100.0;
		else
			return Math.round(n1 * (n2 * .01) * 100.0) / 100.0;
	}
	final static double infinity = Double.POSITIVE_INFINITY;
	public static <T> boolean isNull(T... objs) {
		if (objs == null)
			return true;
		int count = 0;
		for (Object o : objs) {
			if (o == null
					|| (o instanceof Double ? isInfinity((double) o) : false)) {
				// tested: the else false clause stays, as it gets ignored; if o
				// is a non-double, only the first condition is tested, the RHS
				// will just be ignored
				count++;
			}
		}
		return count > 0;
	}
	public static <T> boolean isNull(T[]... subArrays) {
		if (subArrays == null)
			return true;
		int count = 0;
		for (Object[] arr : subArrays) {
			if (isNull(arr))
				count++;
		}
		return count > 0;
		// to handle null arrays, not just regular objects
	}
	public static <T> boolean isNl(T... objs) {
		return isNull(objs);
	}
	public static <T> boolean isNl(T[]... subArrays) {
		return isNull(subArrays);
	}
	public static <T> boolean isnl(T... objs) {
		return isNull(objs);
	}
	public static <T> boolean isnl(T[]... subArrays) {
		return isNull(subArrays);
	}
	public static boolean isInfinity(double n) {
		return n == infinity || n == Double.NEGATIVE_INFINITY;
	}
	public static boolean isInf(double n) {
		return isInfinity(n);
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
	public static int ceil(int n) {
		return n;
	}
	public static long ceil(long n) {
		return n;
	}
	public static int ceil(float n) {
		return (int) Math.ceil(n);
	}
	public static int ceil(double n) {
		return (int) Math.ceil(n);
	}
	public static int floor(int n) {
		return n;
	}
	public static long floor(long n) {
		return n;
	}
	public static int floor(float n) {
		return (int) Math.floor(n);
	}
	public static int floor(double n) {
		return (int) Math.floor(n);
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
	public static boolean eq(strArr x, strArr y) {
		return x.eq(y);
	}
	public static boolean eq(intArr x, intArr y) {
		return x.eq(y);
	}
	public static boolean eq(longArr x, longArr y) {
		return x.eq(y);
	}
	public static boolean eq(fltArr x, fltArr y) {
		return x.eq(y);
	}
	public static boolean eq(dblArr x, dblArr y) {
		return x.eq(y);
	}
	public static boolean eq(boolArr x, boolArr y) {
		return x.eq(y);
	}
	public static boolean eq(treeDI x, treeDI y) {
		return x.equals(y);
	}
	public static boolean eq(treeI x, treeI y) {
		return x.equals(y);
	}
	public static boolean eq(treeDL x, treeDL y) {
		return x.equals(y);
	}
	public static boolean eq(treeL x, treeL y) {
		return x.equals(y);
	}
	public static boolean eq(treeDF x, treeDF y) {
		return x.equals(y);
	}
	public static boolean eq(treeF x, treeF y) {
		return x.equals(y);
	}
	public static boolean eq(treeDS x, treeDS y) {
		return x.equals(y);
	}
	public static boolean eq(treeD x, treeD y) {
		return x.equals(y);
	}
	public static boolean eq(treeDB x, treeDB y) {
		return x.equals(y);
	}
	public static boolean eq(treeB x, treeB y) {
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
	public static boolean uneq(strArr x, strArr y) {
		return !eq(x, y);
	}
	public static boolean uneq(intArr x, intArr y) {
		return !eq(x, y);
	}
	public static boolean uneq(longArr x, longArr y) {
		return !eq(x, y);
	}
	public static boolean uneq(fltArr x, fltArr y) {
		return !eq(x, y);
	}
	public static boolean uneq(dblArr x, dblArr y) {
		return !eq(x, y);
	}
	public static boolean uneq(boolArr x, boolArr y) {
		return !eq(x, y);
	}
	public static boolean uneq(treeDI x, treeDI y) {
		return !eq(x, y);
	}
	public static boolean uneq(treeI x, treeI y) {
		return !eq(x, y);
	}
	public static boolean uneq(treeDL x, treeDL y) {
		return !eq(x, y);
	}
	public static boolean uneq(treeL x, treeL y) {
		return !eq(x, y);
	}
	public static boolean uneq(treeDF x, treeDF y) {
		return !eq(x, y);
	}
	public static boolean uneq(treeF x, treeF y) {
		return !eq(x, y);
	}
	public static boolean uneq(treeDS x, treeDS y) {
		return !eq(x, y);
	}
	public static boolean uneq(treeD x, treeD y) {
		return !eq(x, y);
	}
	public static boolean uneq(treeDB x, treeDB y) {
		return !eq(x, y);
	}
	public static boolean uneq(treeB x, treeB y) {
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
	public static boolean not(String s) {
		return isnl(s) || isEmpty(s);
	}
	public static boolean not(char c) {
		return isnl(c) || isEmpty(c);
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
	public static boolean not(char[] arr) {
		return isnl(arr) || isEmpty(arr);
	}
	public static boolean not(char[]... arrays) {
		return isnl(arrays) || isEmpty(arrays);
	}
	public static boolean not(String[] arr) {
		return isnl(arr) || isEmpty(arr);
	}
	public static boolean not(String[]... arrays) {
		return isnl(arrays) || isEmpty(arrays);
	}
	public static boolean not(int[] arr) {
		return isnl(arr) || isEmpty(arr);
	}
	public static boolean not(int[]... arrays) {
		return isnl(arrays) || isEmpty(arrays);
	}
	public static boolean not(long[] arr) {
		return isnl(arr) || isEmpty(arr);
	}
	public static boolean not(long[]... arrays) {
		return isnl(arrays) || isEmpty(arrays);
	}
	public static boolean not(float[] arr) {
		return isnl(arr) || isEmpty(arr);
	}
	public static boolean not(float[]... arrays) {
		return isnl(arrays) || isEmpty(arrays);
	}
	public static boolean not(double[] arr) {
		return isnl(arr) || isEmpty(arr);
	}
	public static boolean not(double[]... arrays) {
		return isnl(arrays) || isEmpty(arrays);
	}
	public static boolean not(boolean[] arr) {
		return isnl(arr) || isEmpty(arr);
	}
	public static boolean not(boolean[]... arrays) {
		return isnl(arrays) || isEmpty(arrays);
	}
	public static boolean not(Object[]... arrays) {
		return isnl(arrays) || isEmpty(arrays);
	}
	public static boolean not(strArr arr) {
		return isnl(arr) || isEmpty(arr);
	}
	public static boolean not(intArr arr) {
		return isnl(arr) || isEmpty(arr);
	}
	public static boolean not(longArr arr) {
		return isnl(arr) || isEmpty(arr);
	}
	public static boolean not(fltArr arr) {
		return isnl(arr) || isEmpty(arr);
	}
	public static boolean not(dblArr arr) {
		return isnl(arr) || isEmpty(arr);
	}
	public static boolean not(boolArr arr) {
		return isnl(arr) || isEmpty(arr);
	}
	public static boolean not(objS o) {
		return isnl(o) || isEmpty(o);
	}
	public static boolean not(objI o) {
		return isnl(o) || isEmpty(o);
	}
	public static boolean not(objL o) {
		return isnl(o) || isEmpty(o);
	}
	public static boolean not(objF o) {
		return isnl(o) || isEmpty(o);
	}
	public static boolean not(objD o) {
		return isnl(o) || isEmpty(o);
	}
	public static boolean not(objB o) {
		return isnl(o) || isEmpty(o);
	}
	public static boolean not(treeDI t) {
		return isnl(t) || isEmpty(t);
	}
	public static boolean not(treeI t) {
		return isnl(t) || isEmpty(t);
	}
	public static boolean not(treeDL t) {
		return isnl(t) || isEmpty(t);
	}
	public static boolean not(treeL t) {
		return isnl(t) || isEmpty(t);
	}
	public static boolean not(treeDF t) {
		return isnl(t) || isEmpty(t);
	}
	public static boolean not(treeF t) {
		return isnl(t) || isEmpty(t);
	}
	public static boolean not(treeDS t) {
		return isnl(t) || isEmpty(t);
	}
	public static boolean not(treeD t) {
		return isnl(t) || isEmpty(t);
	}
	public static boolean not(treeDB t) {
		return isnl(t) || isEmpty(t);
	}
	public static boolean not(treeB t) {
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
	public static boolean is(char[] arr) {
		return !not(arr);
	}
	public static boolean is(char[]... arrays) {
		return !not(arrays);
	}
	public static boolean is(String[] arr) {
		return !not(arr);
	}
	public static boolean is(String[]... arrays) {
		return !not(arrays);
	}
	public static boolean is(int[] arr) {
		return !not(arr);
	}
	public static boolean is(int[]... arrays) {
		return !not(arrays);
	}
	public static boolean is(long[] arr) {
		return !not(arr);
	}
	public static boolean is(long[]... arrays) {
		return !not(arrays);
	}
	public static boolean is(float[] arr) {
		return !not(arr);
	}
	public static boolean is(float[]... arrays) {
		return !not(arrays);
	}
	public static boolean is(double[] arr) {
		return !not(arr);
	}
	public static boolean is(double[]... arrays) {
		return !not(arrays);
	}
	public static boolean is(boolean[] arr) {
		return !not(arr);
	}
	public static boolean is(boolean[]... arrays) {
		return !not(arrays);
	}
	public static boolean is(Object... arr) {
		return !not(arr);
	}
	public static boolean is(Object[]... arrays) {
		return !not(arrays);
	}
	public static boolean is(strArr arr) {
		return !not(arr);
	}
	public static boolean is(intArr arr) {
		return !not(arr);
	}
	public static boolean is(longArr arr) {
		return !not(arr);
	}
	public static boolean is(fltArr arr) {
		return !not(arr);
	}
	public static boolean is(dblArr arr) {
		return !not(arr);
	}
	public static boolean is(boolArr arr) {
		return !not(arr);
	}
	public static boolean is(objS o) {
		return !not(o);
	}
	public static boolean is(objI o) {
		return !not(o);
	}
	public static boolean is(objL o) {
		return !not(o);
	}
	public static boolean is(objF o) {
		return !not(o);
	}
	public static boolean is(objD o) {
		return !not(o);
	}
	public static boolean is(objB o) {
		return !not(o);
	}
	public static boolean is(treeDI t) {
		return !not(t);
	}
	public static boolean is(treeI t) {
		return !not(t);
	}
	public static boolean is(treeDL t) {
		return !not(t);
	}
	public static boolean is(treeL t) {
		return !not(t);
	}
	public static boolean is(treeDF t) {
		return !not(t);
	}
	public static boolean is(treeF t) {
		return !not(t);
	}
	public static boolean is(treeDS t) {
		return !not(t);
	}
	public static boolean is(treeD t) {
		return !not(t);
	}
	public static boolean is(treeDB t) {
		return !not(t);
	}
	public static boolean is(treeB t) {
		return !not(t);
	}
	public static boolean xor(String a, String b) {
		return (is(a) || is(b)) && !(is(a) && is(b));
	}
	public static boolean xor(int a, int b) {
		return (is(a) || is(b)) && !(is(a) && is(b));
	}
	public static boolean xor(long a, long b) {
		return (is(a) || is(b)) && !(is(a) && is(b));
	}
	public static boolean xor(float a, float b) {
		return (is(a) || is(b)) && !(is(a) && is(b));
	}
	public static boolean xor(double a, double b) {
		return (is(a) || is(b)) && !(is(a) && is(b));
	}
	public static boolean xor(boolean a, boolean b) {
		return (a || b) && !(a && b);
	}
	public static boolean implies(boolean a, boolean b) {
		return a && !b ? false : true;
	}
	public static int randInt() {
		int number = ThreadLocalRandom.current().nextInt(0, 99);
		return number;
	}
	public static int randInt(int end) {
		if (not(end) || isNeg(end))
			return 0;
		int number = ThreadLocalRandom.current().nextInt(0, end);
		return number;
	}
	public static int randInt(int start, int end) {
		if (isNull(start) || not(end) || eq(start, end) || start > end
				|| isNeg(end))
			return 0;
		int number = ThreadLocalRandom.current().nextInt(start, end);
		return number;
	}
	public static int randPin(int len) {
		String str = "";
		if (not(len) || len < 4)
			len = 4;
		if (isInf(len) || len > 8)
			len = 8;
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
		return toPrecision(number, 1);
	}
	public static double randFlt(int end) {
		if (not(end) || isNeg(end))
			return 0;
		double number = randInt(end) * .3;
		return toPrecision(number, 1);
	}
	public static double randFlt(int start, int end) {
		if (isNull(start) || not(end) || eq(start, end) || start > end
				|| isNeg(end))
			return 0;
		double number = randInt(start, end) * .3;
		return toPrecision(number, 1);
	}
	public static double randDbl() {
		return (double) randFlt();
	}
	public static double randDbl(int end) {
		if (not(end) || isNeg(end))
			return 0;
		return (double) randFlt(end);
	}
	public static double randDbl(int start, int end) {
		if (isNull(start) || not(end) || eq(start, end) || start > end
				|| isNeg(end))
			return 0;
		return (double) randFlt(start, end);
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
	public static String randUuid() {
		return UUID.randomUUID().toString();
	}
	public static String randId(int len) {
		String id = randUuid().replaceAll("-", "");
		if (not(len) || isNeg(len) || len >= len(id))
			return id;
		return id.substring(0, len);
	}
	public static String randId() {
		String id = randUuid().replaceAll("-", "");
		return id.substring(0, 8);
	}
	public static String randItem(String arr[]) {
		if (not(arr))
			return "";
		return arr[randInt(len(arr))];
	}
	public static int randItem(int arr[]) {
		if (not(arr))
			return 0;
		return arr[randInt(len(arr))];
	}
	public static long randItem(long arr[]) {
		if (not(arr))
			return 0;
		return arr[randInt(len(arr))];
	}
	public static float randItem(float arr[]) {
		if (not(arr))
			return 0;
		return arr[randInt(len(arr))];
	}
	public static double randItem(double arr[]) {
		if (not(arr))
			return 0;
		return arr[randInt(len(arr))];
	}
	public static boolean randItem(boolean arr[]) {
		if (not(arr))
			return false;
		return arr[randInt(len(arr))];
	}
	public static Object randItem(Object arr[]) {
		if (not(arr))
			return false;
		return arr[randInt(len(arr))];
	}
	public static String randItem(strArr arr) {
		if (not(arr))
			return "";
		return arr.i(randInt(arr.length()));
	}
	public static int randItem(intArr arr) {
		if (not(arr))
			return 0;
		return arr.i(randInt(arr.length()));
	}
	public static long randItem(longArr arr) {
		if (not(arr))
			return 0;
		return arr.i(randInt(arr.length()));
	}
	public static float randItem(fltArr arr) {
		if (not(arr))
			return 0;
		return arr.i(randInt(arr.length()));
	}
	public static double randItem(dblArr arr) {
		if (not(arr))
			return 0;
		return arr.i(randInt(arr.length()));
	}
	public static boolean randItem(boolArr arr) {
		if (not(arr))
			return false;
		return arr.i(randInt(arr.length()));
	}
	public static String randItem(objS arr) {
		if (not(arr))
			return "";
		return arr.i(randInt(arr.length()));
	}
	public static int randItem(objI arr) {
		if (not(arr))
			return 0;
		return arr.i(randInt(arr.length()));
	}
	public static long randItem(objL arr) {
		if (not(arr))
			return 0;
		return arr.i(randInt(arr.length()));
	}
	public static float randItem(objF arr) {
		if (not(arr))
			return 0;
		return arr.i(randInt(arr.length()));
	}
	public static double randItem(objD arr) {
		if (not(arr))
			return 0;
		return arr.i(randInt(arr.length()));
	}
	public static boolean randItem(objB arr) {
		if (not(arr))
			return false;
		return arr.i(randInt(arr.length()));
	}
	public static String randItem(treeDS t) {
		if (not(t))
			return "";
		return t.i(randInt(t.length()));
	}
	public static int randItem(treeDI t) {
		if (not(t))
			return 0;
		return t.i(randInt(t.length()));
	}
	public static String randItem(treeI t) {
		if (not(t))
			return "";
		return t.i(randInt(t.length()));
	}
	public static long randItem(treeDL t) {
		if (not(t))
			return 0;
		return t.i(randInt(t.length()));
	}
	public static long randItem(treeL t) {
		if (not(t))
			return 0;
		return t.i(randInt(t.length()));
	}
	public static float randItem(treeDF t) {
		if (not(t))
			return 0;
		return t.i(randInt(t.length()));
	}
	public static float randItem(treeF t) {
		if (not(t))
			return 0;
		return t.i(randInt(t.length()));
	}
	public static double randItem(treeD t) {
		if (not(t))
			return 0;
		return t.i(randInt(t.length()));
	}
	public static boolean randItem(treeDB t) {
		if (not(t))
			return false;
		return t.i(randInt(t.length()));
	}
	public static boolean randItem(treeB t) {
		if (not(t))
			return false;
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
	public static String randFrom(strArr arr) {
		return randItem(arr);
	}
	public static int randFrom(intArr arr) {
		return randItem(arr);
	}
	public static long randFrom(longArr arr) {
		return randItem(arr);
	}
	public static float randFrom(fltArr arr) {
		return randItem(arr);
	}
	public static double randFrom(dblArr arr) {
		return randItem(arr);
	}
	public static boolean randFrom(boolArr arr) {
		return randItem(arr);
	}
	public static String randFrom(treeDS t) {
		return randItem(t);
	}
	public static int randFrom(treeDI t) {
		return randItem(t);
	}
	public static String randFrom(treeI t) {
		return randItem(t);
	}
	public static long randFrom(treeDL t) {
		return randItem(t);
	}
	public static long randFrom(treeL t) {
		return randItem(t);
	}
	public static float randFrom(treeDF t) {
		return randItem(t);
	}
	public static float randFrom(treeF t) {
		return randItem(t);
	}
	public static double randFrom(treeD t) {
		return randItem(t);
	}
	public static boolean randFrom(treeDB t) {
		return randItem(t);
	}
	public static boolean randFrom(treeB t) {
		return randItem(t);
	}
	public static String randFrom(objS o) {
		return randItem(o);
	}
	public static int randFrom(objI o) {
		return randItem(o);
	}
	public static long randFrom(objL o) {
		return randItem(o);
	}
	public static float randFrom(objF o) {
		return randItem(o);
	}
	public static double randFrom(objD o) {
		return randItem(o);
	}
	public static boolean randFrom(objB o) {
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
	public static String anyOf(strArr arr) {
		return randItem(arr);
	}
	public static int anyOf(intArr arr) {
		return randItem(arr);
	}
	public static long anyOf(longArr arr) {
		return randItem(arr);
	}
	public static float anyOf(fltArr arr) {
		return randItem(arr);
	}
	public static double anyOf(dblArr arr) {
		return randItem(arr);
	}
	public static boolean anyOf(boolArr arr) {
		return randItem(arr);
	}
	public static String anyOf(treeDS t) {
		return randItem(t);
	}
	public static int anyOf(treeDI t) {
		return randItem(t);
	}
	public static String anyOf(treeI t) {
		return randItem(t);
	}
	public static long anyOf(treeDL t) {
		return randItem(t);
	}
	public static long anyOf(treeL t) {
		return randItem(t);
	}
	public static float anyOf(treeDF t) {
		return randItem(t);
	}
	public static float anyOf(treeF t) {
		return randItem(t);
	}
	public static double anyOf(treeD t) {
		return randItem(t);
	}
	public static boolean anyOf(treeDB t) {
		return randItem(t);
	}
	public static boolean anyOf(treeB t) {
		return randItem(t);
	}
	public static String anyOf(objS o) {
		return randItem(o);
	}
	public static int anyOf(objI o) {
		return randItem(o);
	}
	public static long anyOf(objL o) {
		return randItem(o);
	}
	public static float anyOf(objF o) {
		return randItem(o);
	}
	public static double anyOf(objD o) {
		return randItem(o);
	}
	public static boolean anyOf(objB o) {
		return randItem(o);
	}
	public static int[] noDuplicates(int[] arr) {
		if (not(arr))
			return blank.Int;
		return IntStream.of(arr).distinct().toArray();
	}
	public static long[] noDuplicates(long[] arr) {
		if (not(arr))
			return blank.Long;
		return LongStream.of(arr).distinct().toArray();
	}
	public static double[] noDuplicates(double[] arr) {
		if (not(arr))
			return blank.Dbl;
		return DoubleStream.of(arr).distinct().toArray();
	}
	public static strArr noDuplicates(strArr arr) {
		if (not(arr))
			return new strArr(blank.Str);
		return arr.unique();
	}
	public static intArr noDuplicates(intArr arr) {
		if (not(arr))
			return new intArr(blank.Int);
		return arr.unique();
	}
	public static longArr noDuplicates(longArr arr) {
		if (not(arr))
			return new longArr(blank.Long);
		return arr.unique();
	}
	public static fltArr noDuplicates(fltArr arr) {
		if (not(arr))
			return new fltArr(blank.Flt);
		return arr.unique();
	}
	public static dblArr noDuplicates(dblArr arr) {
		if (not(arr))
			return new dblArr(blank.Dbl);
		return arr.unique();
	}
	public static boolArr noDuplicates(boolArr arr) {
		if (not(arr))
			return new boolArr(blank.Bool);
		return arr.unique();
	}
	public static String replace(String str, String to_replace,
			String regex_to_replace_with) {
		if (not(str) || not(to_replace))
			return str;
		return str.replaceAll(to_replace, regex_to_replace_with);
	}
	public static String replace(String str, String to_replace,
			Function<String, String> fn) {
		if (not(str) || not(to_replace) || not(fn))
			return str;
		StringBuilder s = new StringBuilder(str);
		Pattern p = Pattern.compile(to_replace);
		Matcher matcher = p.matcher(s);
		return matcher.replaceAll(m -> fn.apply(m.group()));
	}
	public static String replaceFirst(String str, String to_replace,
			String regex_to_replace_with) {
		if (not(str) || not(to_replace))
			return str;
		return str.replaceFirst(to_replace, regex_to_replace_with);
	}
	public static String replaceOne(String str, String to_replace,
			String regex_to_replace_with) {
		if (not(str) || not(to_replace))
			return str;
		return replaceFirst(str, to_replace, regex_to_replace_with);
	}
	public static String remove(String str, String re) {
		if (not(str) || not(re))
			return str;
		return replace(str, re, "");
	}
	public static String slice(String str) {
		if (not(str))
			return "";
		return remove(str, "^\\s+|\\s+$");
		// TESTED, and proven: DOUBLE-ESCAPING WASN'T NEEDED here. As a matter
		// of fact, for some reason, it's not needed with whitespaces ("\\s") in
		// Java. Though functionally equivalent to str.trim(), I believe it's
		// better to at least try and create your own implementation.
	}
	public static String[] slice(String arr[]) {
		if (not(arr))
			return blank.Str;
		return arr.clone();
	}
	public static int[] slice(int arr[]) {
		if (not(arr))
			return blank.Int;
		return arr.clone();
	}
	public static long[] slice(long arr[]) {
		if (not(arr))
			return blank.Long;
		return arr.clone();
	}
	public static float[] slice(float arr[]) {
		if (not(arr))
			return blank.Flt;
		return arr.clone();
	}
	public static double[] slice(double arr[]) {
		if (not(arr))
			return blank.Dbl;
		return arr.clone();
	}
	public static boolean[] slice(boolean arr[]) {
		if (not(arr))
			return blank.Bool;
		return arr.clone();
	}
	public static Object[] slice(Object arr[]) {
		if (not(arr))
			return blank.Obj;
		return arr.clone();
	}
	public static strArr slice(strArr arr) {
		if (not(arr))
			return new strArr(blank.Str);
		return arr.copy();
	}
	public static intArr slice(intArr arr) {
		if (not(arr))
			return new intArr(blank.Int);
		return arr.copy();
	}
	public static longArr slice(longArr arr) {
		if (not(arr))
			return new longArr(blank.Long);
		return arr.copy();
	}
	public static fltArr slice(fltArr arr) {
		if (not(arr))
			return new fltArr(blank.Flt);
		return arr.copy();
	}
	public static dblArr slice(dblArr arr) {
		if (not(arr))
			return new dblArr(blank.Dbl);
		return arr.copy();
	}
	public static boolArr slice(boolArr arr) {
		if (not(arr))
			return new boolArr(blank.Bool);
		return arr.copy();
	}
	public static String slice(String str, int start) {
		if (not(str) || not(start) || isNeg(start) || start >= len(str))
			return slice(str);
		return str.substring(start, len(str));
	}
	public static String[] slice(String oldArr[], int start) {
		if (not(oldArr) || not(start) || isNeg(start) || start >= len(oldArr))
			return slice(oldArr);
		String newArr[] = Arrays.copyOfRange(oldArr.clone(), start,
				len(oldArr));
		return newArr;
	}
	public static int[] slice(int oldArr[], int start) {
		if (not(oldArr) || not(start) || isNeg(start) || start >= len(oldArr))
			return slice(oldArr);
		int newArr[] = Arrays.copyOfRange(oldArr.clone(), start, len(oldArr));
		return newArr;
	}
	public static long[] slice(long oldArr[], int start) {
		if (not(oldArr) || not(start) || isNeg(start) || start >= len(oldArr))
			return slice(oldArr);
		long newArr[] = Arrays.copyOfRange(oldArr.clone(), start, len(oldArr));
		return newArr;
	}
	public static float[] slice(float oldArr[], int start) {
		if (not(oldArr) || not(start) || isNeg(start) || start >= len(oldArr))
			return slice(oldArr);
		float newArr[] = Arrays.copyOfRange(oldArr.clone(), start, len(oldArr));
		return newArr;
	}
	public static double[] slice(double oldArr[], int start) {
		if (not(oldArr) || not(start) || isNeg(start) || start >= len(oldArr))
			return slice(oldArr);
		double newArr[] = Arrays.copyOfRange(oldArr.clone(), start,
				len(oldArr));
		return newArr;
	}
	public static boolean[] slice(boolean oldArr[], int start) {
		if (not(oldArr) || not(start) || isNeg(start) || start >= len(oldArr))
			return slice(oldArr);
		boolean newArr[] = Arrays.copyOfRange(oldArr.clone(), start,
				len(oldArr));
		return newArr;
	}
	public static Object[] slice(Object oldArr[], int start) {
		if (not(oldArr) || not(start) || isNeg(start) || start >= len(oldArr))
			return slice(oldArr);
		Object newArr[] = Arrays.copyOfRange(oldArr.clone(), start,
				len(oldArr));
		return newArr;
	}
	public static strArr slice(strArr arr, int start) {
		if (not(arr) || not(start) || isNeg(start) || start >= len(arr))
			return slice(arr);
		return arr.slice(start, arr.length());
	}
	public static intArr slice(intArr arr, int start) {
		if (not(arr) || not(start) || isNeg(start) || start >= len(arr))
			return slice(arr);
		return arr.slice(start, arr.length());
	}
	public static longArr slice(longArr arr, int start) {
		if (not(arr) || not(start) || isNeg(start) || start >= len(arr))
			return slice(arr);
		return arr.slice(start, arr.length());
	}
	public static fltArr slice(fltArr arr, int start) {
		if (not(arr) || not(start) || isNeg(start) || start >= len(arr))
			return slice(arr);
		return arr.slice(start, arr.length());
	}
	public static dblArr slice(dblArr arr, int start) {
		if (not(arr) || not(start) || isNeg(start) || start >= len(arr))
			return slice(arr);
		return arr.slice(start, arr.length());
	}
	public static boolArr slice(boolArr arr, int start) {
		if (not(arr) || not(start) || isNeg(start) || start >= len(arr))
			return slice(arr);
		return arr.slice(start, arr.length());
	}
	public static String slice(String str, int start, int end) {
		if (not(str) || isNull(start) || start >= len(str) || eq(start, end)
				|| end < start || not(end) || isNeg(start) || isNeg(end)
				|| end >= len(str))
			return slice(str);
		return str.substring(start, end);
	}
	public static String[] slice(String oldArr[], int start, int end) {
		if (not(oldArr) || isNull(start) || start >= len(oldArr)
				|| eq(start, end) || end < start || not(end) || isNeg(start)
				|| isNeg(end) || end >= len(oldArr))
			return slice(oldArr);
		String newArr[] = Arrays.copyOfRange(oldArr.clone(), start, end);
		return newArr;
	}
	public static int[] slice(int oldArr[], int start, int end) {
		if (not(oldArr) || isNull(start) || start >= len(oldArr)
				|| eq(start, end) || end < start || not(end) || isNeg(start)
				|| isNeg(end) || end >= len(oldArr))
			return slice(oldArr);
		int newArr[] = Arrays.copyOfRange(oldArr.clone(), start, end);
		return newArr;
	}
	public static long[] slice(long oldArr[], int start, int end) {
		if (not(oldArr) || isNull(start) || start >= len(oldArr)
				|| eq(start, end) || end < start || not(end) || isNeg(start)
				|| isNeg(end) || end >= len(oldArr))
			return slice(oldArr);
		long newArr[] = Arrays.copyOfRange(oldArr.clone(), start, end);
		return newArr;
	}
	public static float[] slice(float oldArr[], int start, int end) {
		if (not(oldArr) || isNull(start) || start >= len(oldArr)
				|| eq(start, end) || end < start || not(end) || isNeg(start)
				|| isNeg(end) || end >= len(oldArr))
			return slice(oldArr);
		float newArr[] = Arrays.copyOfRange(oldArr.clone(), start, end);
		return newArr;
	}
	public static double[] slice(double oldArr[], int start, int end) {
		if (not(oldArr) || isNull(start) || start >= len(oldArr)
				|| eq(start, end) || end < start || not(end) || isNeg(start)
				|| isNeg(end) || end >= len(oldArr))
			return slice(oldArr);
		double newArr[] = Arrays.copyOfRange(oldArr.clone(), start, end);
		return newArr;
	}
	public static boolean[] slice(boolean oldArr[], int start, int end) {
		if (not(oldArr) || isNull(start) || start >= len(oldArr)
				|| eq(start, end) || end < start || not(end) || isNeg(start)
				|| isNeg(end) || end >= len(oldArr))
			return slice(oldArr);
		boolean newArr[] = Arrays.copyOfRange(oldArr.clone(), start, end);
		return newArr;
	}
	public static Object[] slice(Object oldArr[], int start, int end) {
		if (not(oldArr) || isNull(start) || start >= len(oldArr)
				|| eq(start, end) || end < start || not(end) || isNeg(start)
				|| isNeg(end) || end >= len(oldArr))
			return slice(oldArr);
		Object newArr[] = Arrays.copyOfRange(oldArr.clone(), start, end);
		return newArr;
	}
	public static strArr slice(strArr arr, int start, int end) {
		if (not(arr) || isNull(start) || start >= len(arr) || eq(start, end)
				|| end < start || not(end) || isNeg(start) || isNeg(end)
				|| end >= len(arr))
			return slice(arr);
		return arr.slice(start, end);
	}
	public static intArr slice(intArr arr, int start, int end) {
		if (not(arr) || isNull(start) || start >= len(arr) || eq(start, end)
				|| end < start || not(end) || isNeg(start) || isNeg(end)
				|| end >= len(arr))
			return slice(arr);
		return arr.slice(start, end);
	}
	public static longArr slice(longArr arr, int start, int end) {
		if (not(arr) || isNull(start) || start >= len(arr) || eq(start, end)
				|| end < start || not(end) || isNeg(start) || isNeg(end)
				|| end >= len(arr))
			return slice(arr);
		return arr.slice(start, end);
	}
	public static fltArr slice(fltArr arr, int start, int end) {
		if (not(arr) || isNull(start) || start >= len(arr) || eq(start, end)
				|| end < start || not(end) || isNeg(start) || isNeg(end)
				|| end >= len(arr))
			return slice(arr);
		return arr.slice(start, end);
	}
	public static dblArr slice(dblArr arr, int start, int end) {
		if (not(arr) || isNull(start) || start >= len(arr) || eq(start, end)
				|| end < start || not(end) || isNeg(start) || isNeg(end)
				|| end >= len(arr))
			return slice(arr);
		return arr.slice(start, end);
	}
	public static boolArr slice(boolArr arr, int start, int end) {
		if (not(arr) || isNull(start) || start >= len(arr) || eq(start, end)
				|| end < start || not(end) || isNeg(start) || isNeg(end)
				|| end >= len(arr))
			return slice(arr);
		return arr.slice(start, end);
	}
	public static String sliceRight(String str, int start) {
		if (not(str) || not(start) || isNeg(start) || start >= len(str))
			return slice(str);
		return slice(str, len(str) - start, len(str));
	}
	public static String[] sliceRight(String[] arr, int start) {
		if (not(arr) || not(start) || isNeg(start) || start >= len(arr))
			return slice(arr);
		return slice(arr, len(arr) - start, len(arr));
	}
	public static int[] sliceRight(int[] arr, int start) {
		if (not(arr) || not(start) || isNeg(start) || start >= len(arr))
			return slice(arr);
		return slice(arr, len(arr) - start, len(arr));
	}
	public static long[] sliceRight(long[] arr, int start) {
		if (not(arr) || not(start) || isNeg(start) || start >= len(arr))
			return slice(arr);
		return slice(arr, len(arr) - start, len(arr));
	}
	public static float[] sliceRight(float[] arr, int start) {
		if (not(arr) || not(start) || isNeg(start) || start >= len(arr))
			return slice(arr);
		return slice(arr, len(arr) - start, len(arr));
	}
	public static double[] sliceRight(double[] arr, int start) {
		if (not(arr) || not(start) || isNeg(start) || start >= len(arr))
			return slice(arr);
		return slice(arr, len(arr) - start, len(arr));
	}
	public static boolean[] sliceRight(boolean[] arr, int start) {
		if (not(arr) || not(start) || isNeg(start) || start >= len(arr))
			return slice(arr);
		return slice(arr, len(arr) - start, len(arr));
	}
	public static Object[] sliceRight(Object[] arr, int start) {
		if (not(arr) || not(start) || isNeg(start) || start >= len(arr))
			return slice(arr);
		return slice(arr, len(arr) - start, len(arr));
	}
	public static strArr sliceRight(strArr arr, int start) {
		if (not(arr) || not(start) || isNeg(start) || start >= len(arr))
			return slice(arr);
		return slice(arr, len(arr) - start, len(arr));
	}
	public static intArr sliceRight(intArr arr, int start) {
		if (not(arr) || not(start) || isNeg(start) || start >= len(arr))
			return slice(arr);
		return slice(arr, len(arr) - start, len(arr));
	}
	public static longArr sliceRight(longArr arr, int start) {
		if (not(arr) || not(start) || isNeg(start) || start >= len(arr))
			return slice(arr);
		return slice(arr, len(arr) - start, len(arr));
	}
	public static fltArr sliceRight(fltArr arr, int start) {
		if (not(arr) || not(start) || isNeg(start) || start >= len(arr))
			return slice(arr);
		return slice(arr, len(arr) - start, len(arr));
	}
	public static dblArr sliceRight(dblArr arr, int start) {
		if (not(arr) || not(start) || isNeg(start) || start >= len(arr))
			return slice(arr);
		return slice(arr, len(arr) - start, len(arr));
	}
	public static boolArr sliceRight(boolArr arr, int start) {
		if (not(arr) || not(start) || isNeg(start) || start >= len(arr))
			return slice(arr);
		return slice(arr, len(arr) - start, len(arr));
	}
	public static String sliceEnd(String str, int earlyEnd) {
		if (not(str) || not(earlyEnd) || isNeg(earlyEnd)
				|| earlyEnd >= len(str))
			return slice(str);
		return slice(str, 0, len(str) - earlyEnd);
	}
	public static String[] sliceEnd(String[] arr, int earlyEnd) {
		if (not(arr) || not(earlyEnd) || isNeg(earlyEnd)
				|| earlyEnd >= len(arr))
			return slice(arr);
		return slice(arr, 0, len(arr) - earlyEnd);
	}
	public static int[] sliceEnd(int[] arr, int earlyEnd) {
		if (not(arr) || not(earlyEnd) || isNeg(earlyEnd)
				|| earlyEnd >= len(arr))
			return slice(arr);
		return slice(arr, 0, len(arr) - earlyEnd);
	}
	public static long[] sliceEnd(long[] arr, int earlyEnd) {
		if (not(arr) || not(earlyEnd) || isNeg(earlyEnd)
				|| earlyEnd >= len(arr))
			return slice(arr);
		return slice(arr, 0, len(arr) - earlyEnd);
	}
	public static float[] sliceEnd(float[] arr, int earlyEnd) {
		if (not(arr) || not(earlyEnd) || isNeg(earlyEnd)
				|| earlyEnd >= len(arr))
			return slice(arr);
		return slice(arr, 0, len(arr) - earlyEnd);
	}
	public static double[] sliceEnd(double[] arr, int earlyEnd) {
		if (not(arr) || not(earlyEnd) || isNeg(earlyEnd)
				|| earlyEnd >= len(arr))
			return slice(arr);
		return slice(arr, 0, len(arr) - earlyEnd);
	}
	public static boolean[] sliceEnd(boolean[] arr, int earlyEnd) {
		if (not(arr) || not(earlyEnd) || isNeg(earlyEnd)
				|| earlyEnd >= len(arr))
			return slice(arr);
		return slice(arr, 0, len(arr) - earlyEnd);
	}
	public static Object[] sliceEnd(Object[] arr, int earlyEnd) {
		if (not(arr) || not(earlyEnd) || isNeg(earlyEnd)
				|| earlyEnd >= len(arr))
			return slice(arr);
		return slice(arr, 0, len(arr) - earlyEnd);
	}
	public static strArr sliceEnd(strArr arr, int earlyEnd) {
		if (not(arr) || not(earlyEnd) || isNeg(earlyEnd)
				|| earlyEnd >= len(arr))
			return slice(arr);
		return slice(arr, 0, len(arr) - earlyEnd);
	}
	public static intArr sliceEnd(intArr arr, int earlyEnd) {
		if (not(arr) || not(earlyEnd) || isNeg(earlyEnd)
				|| earlyEnd >= len(arr))
			return slice(arr);
		return slice(arr, 0, len(arr) - earlyEnd);
	}
	public static longArr sliceEnd(longArr arr, int earlyEnd) {
		if (not(arr) || not(earlyEnd) || isNeg(earlyEnd)
				|| earlyEnd >= len(arr))
			return slice(arr);
		return slice(arr, 0, len(arr) - earlyEnd);
	}
	public static fltArr sliceEnd(fltArr arr, int earlyEnd) {
		if (not(arr) || not(earlyEnd) || isNeg(earlyEnd)
				|| earlyEnd >= len(arr))
			return slice(arr);
		return slice(arr, 0, len(arr) - earlyEnd);
	}
	public static dblArr sliceEnd(dblArr arr, int earlyEnd) {
		if (not(arr) || not(earlyEnd) || isNeg(earlyEnd)
				|| earlyEnd >= len(arr))
			return slice(arr);
		return slice(arr, 0, len(arr) - earlyEnd);
	}
	public static boolArr sliceEnd(boolArr arr, int earlyEnd) {
		if (not(arr) || not(earlyEnd) || isNeg(earlyEnd)
				|| earlyEnd >= len(arr))
			return slice(arr);
		return slice(arr, 0, len(arr) - earlyEnd);
	}
	public static String sliceOff(String str, int earlyEnd) {
		return sliceEnd(str, earlyEnd);
	}
	public static String[] sliceOff(String[] arr, int earlyEnd) {
		return sliceEnd(arr, earlyEnd);
	}
	public static int[] sliceOff(int[] arr, int earlyEnd) {
		return sliceEnd(arr, earlyEnd);
	}
	public static long[] sliceOff(long[] arr, int earlyEnd) {
		return sliceEnd(arr, earlyEnd);
	}
	public static float[] sliceOff(float[] arr, int earlyEnd) {
		return sliceEnd(arr, earlyEnd);
	}
	public static double[] sliceOff(double[] arr, int earlyEnd) {
		return sliceEnd(arr, earlyEnd);
	}
	public static boolean[] sliceOff(boolean[] arr, int earlyEnd) {
		return sliceEnd(arr, earlyEnd);
	}
	public static Object[] sliceOff(Object[] arr, int earlyEnd) {
		return sliceEnd(arr, earlyEnd);
	}
	public static strArr sliceOff(strArr arr, int earlyEnd) {
		return sliceEnd(arr, earlyEnd);
	}
	public static intArr sliceOff(intArr arr, int earlyEnd) {
		return sliceEnd(arr, earlyEnd);
	}
	public static longArr sliceOff(longArr arr, int earlyEnd) {
		return sliceEnd(arr, earlyEnd);
	}
	public static fltArr sliceOff(fltArr arr, int earlyEnd) {
		return sliceEnd(arr, earlyEnd);
	}
	public static dblArr sliceOff(dblArr arr, int earlyEnd) {
		return sliceEnd(arr, earlyEnd);
	}
	public static boolArr sliceOff(boolArr arr, int earlyEnd) {
		return sliceEnd(arr, earlyEnd);
	}
	public static String sliceOut(String str, int earlyEnd) {
		return sliceEnd(str, earlyEnd);
	}
	public static String[] sliceOut(String[] arr, int earlyEnd) {
		return sliceEnd(arr, earlyEnd);
	}
	public static int[] sliceOut(int[] arr, int earlyEnd) {
		return sliceEnd(arr, earlyEnd);
	}
	public static long[] sliceOut(long[] arr, int earlyEnd) {
		return sliceEnd(arr, earlyEnd);
	}
	public static float[] sliceOut(float[] arr, int earlyEnd) {
		return sliceEnd(arr, earlyEnd);
	}
	public static double[] sliceOut(double[] arr, int earlyEnd) {
		return sliceEnd(arr, earlyEnd);
	}
	public static boolean[] sliceOut(boolean[] arr, int earlyEnd) {
		return sliceEnd(arr, earlyEnd);
	}
	public static Object[] sliceOut(Object[] arr, int earlyEnd) {
		return sliceEnd(arr, earlyEnd);
	}
	public static strArr sliceOut(strArr arr, int earlyEnd) {
		return sliceEnd(arr, earlyEnd);
	}
	public static intArr sliceOut(intArr arr, int earlyEnd) {
		return sliceEnd(arr, earlyEnd);
	}
	public static longArr sliceOut(longArr arr, int earlyEnd) {
		return sliceEnd(arr, earlyEnd);
	}
	public static fltArr sliceOut(fltArr arr, int earlyEnd) {
		return sliceEnd(arr, earlyEnd);
	}
	public static dblArr sliceOut(dblArr arr, int earlyEnd) {
		return sliceEnd(arr, earlyEnd);
	}
	public static boolArr sliceOut(boolArr arr, int earlyEnd) {
		return sliceEnd(arr, earlyEnd);
	}
	public static String sliceKeep(String str, int end) {
		if (not(str) || not(end) || isNeg(end) || end >= len(str))
			return str;
		return slice(str, 0, end);
	}
	public static String[] sliceKeep(String[] arr, int end) {
		if (not(arr))
			return blank.Str;
		if (not(end) || isNeg(end) || end >= len(arr))
			return slice(arr);
		return slice(arr, 0, end);
	}
	public static int[] sliceKeep(int[] arr, int end) {
		if (not(arr))
			return blank.Int;
		if (not(end) || isNeg(end) || end >= len(arr))
			return slice(arr);
		return slice(arr, 0, end);
	}
	public static long[] sliceKeep(long[] arr, int end) {
		if (not(arr))
			return blank.Long;
		if (not(end) || isNeg(end) || end >= len(arr))
			return slice(arr);
		return slice(arr, 0, end);
	}
	public static float[] sliceKeep(float[] arr, int end) {
		if (not(arr))
			return blank.Flt;
		if (not(end) || isNeg(end) || end >= len(arr))
			return slice(arr);
		return slice(arr, 0, end);
	}
	public static double[] sliceKeep(double[] arr, int end) {
		if (not(arr))
			return blank.Dbl;
		if (not(end) || isNeg(end) || end >= len(arr))
			return slice(arr);
		return slice(arr, 0, end);
	}
	public static boolean[] sliceKeep(boolean[] arr, int end) {
		if (not(arr))
			return blank.Bool;
		if (not(end) || isNeg(end) || end >= len(arr))
			return slice(arr);
		return slice(arr, 0, end);
	}
	public static strArr sliceKeep(strArr arr, int end) {
		if (not(arr))
			return new strArr(blank.Str);
		if (not(end) || isNeg(end) || end >= len(arr))
			return slice(arr);
		return slice(arr, 0, end);
	}
	public static intArr sliceKeep(intArr arr, int end) {
		if (not(arr))
			return new intArr(blank.Int);
		if (not(end) || isNeg(end) || end >= len(arr))
			return slice(arr);
		return slice(arr, 0, end);
	}
	public static longArr sliceKeep(longArr arr, int end) {
		if (not(arr))
			return new longArr(blank.Long);
		if (not(end) || isNeg(end) || end >= len(arr))
			return slice(arr);
		return slice(arr, 0, end);
	}
	public static fltArr sliceKeep(fltArr arr, int end) {
		if (not(arr))
			return new fltArr(blank.Flt);
		if (not(end) || isNeg(end) || end >= len(arr))
			return slice(arr);
		return slice(arr, 0, end);
	}
	public static dblArr sliceKeep(dblArr arr, int end) {
		if (not(arr))
			return new dblArr(blank.Dbl);
		if (not(end) || isNeg(end) || end >= len(arr))
			return slice(arr);
		return slice(arr, 0, end);
	}
	public static boolArr sliceKeep(boolArr arr, int end) {
		if (not(arr))
			return new boolArr(blank.Bool);
		if (not(end) || isNeg(end) || end >= len(arr))
			return slice(arr);
		return slice(arr, 0, end);
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
	public static strArr trim(strArr arr) {
		return slice(arr);
	}
	public static intArr trim(intArr arr) {
		return slice(arr);
	}
	public static longArr trim(longArr arr) {
		return slice(arr);
	}
	public static fltArr trim(fltArr arr) {
		return slice(arr);
	}
	public static dblArr trim(dblArr arr) {
		return slice(arr);
	}
	public static boolArr trim(boolArr arr) {
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
	public static strArr trim(strArr arr, int start) {
		return slice(arr, start);
	}
	public static intArr trim(intArr arr, int start) {
		return slice(arr, start);
	}
	public static longArr trim(longArr arr, int start) {
		return slice(arr, start);
	}
	public static fltArr trim(fltArr arr, int start) {
		return slice(arr, start);
	}
	public static dblArr trim(dblArr arr, int start) {
		return slice(arr, start);
	}
	public static boolArr trim(boolArr arr, int start) {
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
	public static strArr trim(strArr arr, int start, int end) {
		return slice(arr, start, end);
	}
	public static intArr trim(intArr arr, int start, int end) {
		return slice(arr, start, end);
	}
	public static longArr trim(longArr arr, int start, int end) {
		return slice(arr, start, end);
	}
	public static fltArr trim(fltArr arr, int start, int end) {
		return slice(arr, start, end);
	}
	public static dblArr trim(dblArr arr, int start, int end) {
		return slice(arr, start, end);
	}
	public static boolArr trim(boolArr arr, int start, int end) {
		return slice(arr, start, end);
	}
	public static String trimRight(String str, int start) {
		return sliceRight(str, start);
	}
	public static String[] trimRight(String[] arr, int start) {
		return sliceRight(arr, start);
	}
	public static int[] trimRight(int[] arr, int start) {
		return sliceRight(arr, start);
	}
	public static long[] trimRight(long[] arr, int start) {
		return sliceRight(arr, start);
	}
	public static float[] trimRight(float[] arr, int start) {
		return sliceRight(arr, start);
	}
	public static double[] trimRight(double[] arr, int start) {
		return sliceRight(arr, start);
	}
	public static boolean[] trimRight(boolean[] arr, int start) {
		return sliceRight(arr, start);
	}
	public static strArr trimRight(strArr arr, int start) {
		return sliceRight(arr, start);
	}
	public static intArr trimRight(intArr arr, int start) {
		return sliceRight(arr, start);
	}
	public static longArr trimRight(longArr arr, int start) {
		return sliceRight(arr, start);
	}
	public static fltArr trimRight(fltArr arr, int start) {
		return sliceRight(arr, start);
	}
	public static dblArr trimRight(dblArr arr, int start) {
		return sliceRight(arr, start);
	}
	public static boolArr trimRight(boolArr arr, int start) {
		return sliceRight(arr, start);
	}
	public static String trimKeep(String str, int end) {
		return sliceKeep(str, end);
	}
	public static String[] trimKeep(String[] arr, int end) {
		return sliceKeep(arr, end);
	}
	public static int[] trimKeep(int[] arr, int end) {
		return sliceKeep(arr, end);
	}
	public static long[] trimKeep(long[] arr, int end) {
		return sliceKeep(arr, end);
	}
	public static float[] trimKeep(float[] arr, int end) {
		return sliceKeep(arr, end);
	}
	public static double[] trimKeep(double[] arr, int end) {
		return sliceKeep(arr, end);
	}
	public static boolean[] trimKeep(boolean[] arr, int end) {
		return sliceKeep(arr, end);
	}
	public static strArr trimKeep(strArr arr, int end) {
		return sliceKeep(arr, end);
	}
	public static intArr trimKeep(intArr arr, int end) {
		return sliceKeep(arr, end);
	}
	public static longArr trimKeep(longArr arr, int end) {
		return sliceKeep(arr, end);
	}
	public static fltArr trimKeep(fltArr arr, int end) {
		return sliceKeep(arr, end);
	}
	public static dblArr trimKeep(dblArr arr, int end) {
		return sliceKeep(arr, end);
	}
	public static boolArr trimKeep(boolArr arr, int end) {
		return sliceKeep(arr, end);
	}
	public static String trimEnd(String str, int earlyEnd) {
		return sliceEnd(str, earlyEnd);
	}
	public static String[] trimEnd(String[] arr, int earlyEnd) {
		return sliceEnd(arr, earlyEnd);
	}
	public static int[] trimEnd(int[] arr, int earlyEnd) {
		return sliceEnd(arr, earlyEnd);
	}
	public static long[] trimEnd(long[] arr, int earlyEnd) {
		return sliceEnd(arr, earlyEnd);
	}
	public static float[] trimEnd(float[] arr, int earlyEnd) {
		return sliceEnd(arr, earlyEnd);
	}
	public static double[] trimEnd(double[] arr, int earlyEnd) {
		return sliceEnd(arr, earlyEnd);
	}
	public static boolean[] trimEnd(boolean[] arr, int earlyEnd) {
		return sliceEnd(arr, earlyEnd);
	}
	public static strArr trimEnd(strArr arr, int earlyEnd) {
		return sliceEnd(arr, earlyEnd);
	}
	public static intArr trimEnd(intArr arr, int earlyEnd) {
		return sliceEnd(arr, earlyEnd);
	}
	public static longArr trimEnd(longArr arr, int earlyEnd) {
		return sliceEnd(arr, earlyEnd);
	}
	public static fltArr trimEnd(fltArr arr, int earlyEnd) {
		return sliceEnd(arr, earlyEnd);
	}
	public static dblArr trimEnd(dblArr arr, int earlyEnd) {
		return sliceEnd(arr, earlyEnd);
	}
	public static boolArr trimEnd(boolArr arr, int earlyEnd) {
		return sliceEnd(arr, earlyEnd);
	}
	public static String trimOff(String str, int earlyEnd) {
		return trimEnd(str, earlyEnd);
	}
	public static String[] trimOff(String[] arr, int earlyEnd) {
		return trimEnd(arr, earlyEnd);
	}
	public static int[] trimOff(int[] arr, int earlyEnd) {
		return trimEnd(arr, earlyEnd);
	}
	public static long[] trimOff(long[] arr, int earlyEnd) {
		return trimEnd(arr, earlyEnd);
	}
	public static float[] trimOff(float[] arr, int earlyEnd) {
		return trimEnd(arr, earlyEnd);
	}
	public static double[] trimOff(double[] arr, int earlyEnd) {
		return trimEnd(arr, earlyEnd);
	}
	public static boolean[] trimOff(boolean[] arr, int earlyEnd) {
		return trimEnd(arr, earlyEnd);
	}
	public static strArr trimOff(strArr arr, int earlyEnd) {
		return trimEnd(arr, earlyEnd);
	}
	public static intArr trimOff(intArr arr, int earlyEnd) {
		return trimEnd(arr, earlyEnd);
	}
	public static longArr trimOff(longArr arr, int earlyEnd) {
		return trimEnd(arr, earlyEnd);
	}
	public static fltArr trimOff(fltArr arr, int earlyEnd) {
		return trimEnd(arr, earlyEnd);
	}
	public static dblArr trimOff(dblArr arr, int earlyEnd) {
		return trimEnd(arr, earlyEnd);
	}
	public static boolArr trimOff(boolArr arr, int earlyEnd) {
		return trimEnd(arr, earlyEnd);
	}
	public static String trimOut(String str, int earlyEnd) {
		return trimEnd(str, earlyEnd);
	}
	public static String[] trimOut(String[] arr, int earlyEnd) {
		return trimEnd(arr, earlyEnd);
	}
	public static int[] trimOut(int[] arr, int earlyEnd) {
		return trimEnd(arr, earlyEnd);
	}
	public static long[] trimOut(long[] arr, int earlyEnd) {
		return trimEnd(arr, earlyEnd);
	}
	public static float[] trimOut(float[] arr, int earlyEnd) {
		return trimEnd(arr, earlyEnd);
	}
	public static double[] trimOut(double[] arr, int earlyEnd) {
		return trimEnd(arr, earlyEnd);
	}
	public static boolean[] trimOut(boolean[] arr, int earlyEnd) {
		return trimEnd(arr, earlyEnd);
	}
	public static strArr trimOut(strArr arr, int earlyEnd) {
		return trimEnd(arr, earlyEnd);
	}
	public static intArr trimOut(intArr arr, int earlyEnd) {
		return trimEnd(arr, earlyEnd);
	}
	public static longArr trimOut(longArr arr, int earlyEnd) {
		return trimEnd(arr, earlyEnd);
	}
	public static fltArr trimOut(fltArr arr, int earlyEnd) {
		return trimEnd(arr, earlyEnd);
	}
	public static dblArr trimOut(dblArr arr, int earlyEnd) {
		return trimEnd(arr, earlyEnd);
	}
	public static boolArr trimOut(boolArr arr, int earlyEnd) {
		return trimEnd(arr, earlyEnd);
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
		if (not(arr))
			return false;
		return arr[len(arr) - 1].equals(lookupStr);
	}
	public static boolean endsWith(int[] arr, int lookupInt) {
		if (not(arr))
			return false;
		return arr[len(arr) - 1] == lookupInt;
	}
	public static boolean endsWith(long[] arr, long lookupLong) {
		if (not(arr))
			return false;
		return arr[len(arr) - 1] == lookupLong;
	}
	public static boolean endsWith(float[] arr, float lookupFloat) {
		if (not(arr))
			return false;
		return arr[len(arr) - 1] == lookupFloat;
	}
	public static boolean endsWith(double[] arr, double lookupDbl) {
		if (not(arr))
			return false;
		return arr[len(arr) - 1] == lookupDbl;
	}
	public static boolean endsWith(boolean[] arr, boolean lookupBool) {
		if (not(arr))
			return false;
		return arr[len(arr) - 1] == lookupBool;
	}
	public static boolean endsWith(strArr arr, String lookupStr) {
		if (not(arr))
			return false;
		return arr.last() == lookupStr;
	}
	public static boolean endsWith(intArr arr, int lookupInt) {
		if (not(arr))
			return false;
		return arr.last() == lookupInt;
	}
	public static boolean endsWith(longArr arr, long lookupLong) {
		if (not(arr))
			return false;
		return arr.last() == lookupLong;
	}
	public static boolean endsWith(fltArr arr, float lookupFlt) {
		if (not(arr))
			return false;
		return arr.last() == lookupFlt;
	}
	public static boolean endsWith(dblArr arr, double lookupDbl) {
		if (not(arr))
			return false;
		return arr.last() == lookupDbl;
	}
	public static boolean endsWith(boolArr arr, boolean lookupBool) {
		if (not(arr))
			return false;
		return arr.last() == lookupBool;
	}
	public static boolean endsWith(treeDS tree, String lookupString) {
		if (not(tree))
			return false;
		return eq(tree.last(), lookupString);
	}
	public static boolean endsWith(treeDI tree, int lookupInt) {
		if (not(tree))
			return false;
		return tree.last() == lookupInt;
	}
	public static boolean endsWith(treeI tree, String lookupStr) {
		if (not(tree))
			return false;
		return tree.last() == lookupStr;
	}
	public static boolean endsWith(treeDL tree, long lookupLong) {
		if (not(tree))
			return false;
		return tree.last() == lookupLong;
	}
	public static boolean endsWith(treeL tree, long lookupLong) {
		if (not(tree))
			return false;
		return tree.last() == lookupLong;
	}
	public static boolean endsWith(treeDF tree, float lookupFloat) {
		if (not(tree))
			return false;
		return tree.last() == lookupFloat;
	}
	public static boolean endsWith(treeF tree, float lookupFloat) {
		if (not(tree))
			return false;
		return tree.last() == lookupFloat;
	}
	public static boolean endsWith(treeD tree, double lookupDouble) {
		if (not(tree))
			return false;
		return tree.last() == lookupDouble;
	}
	public static boolean endsWith(treeDB tree, boolean lookupBool) {
		if (not(tree))
			return false;
		return tree.last() == lookupBool;
	}
	public static boolean endsWith(treeB tree, boolean lookupBool) {
		if (not(tree))
			return false;
		return tree.last() == lookupBool;
	}
	public static String nth(strArr arr, int n) {
		return n >= 0 && n < len(arr) ? arr.i(n) : "";
	}
	public static int nth(intArr arr, int n) {
		return n >= 0 && n < len(arr) ? arr.i(n) : 0;
	}
	public static long nth(longArr arr, int n) {
		return n >= 0 && n < len(arr) ? arr.i(n) : 0;
	}
	public static float nth(fltArr arr, int n) {
		return n >= 0 && n < len(arr) ? arr.i(n) : 0;
	}
	public static double nth(dblArr arr, int n) {
		return n >= 0 && n < len(arr) ? arr.i(n) : 0;
	}
	public static boolean nth(boolArr arr, int n) {
		return n >= 0 && n < len(arr) ? arr.i(n) : false;
	}
	public static String firstOf(strArr arr) {
		if (not(arr))
			return "";
		return arr.first();
	}
	public static String secondOf(strArr arr) {
		if (not(arr))
			return "";
		return arr.second();
	}
	public static int firstOf(intArr arr) {
		if (not(arr))
			return 0;
		return arr.first();
	}
	public static int secondOf(intArr arr) {
		if (not(arr))
			return 0;
		return arr.second();
	}
	public static float firstOf(longArr arr) {
		if (not(arr))
			return 0;
		return arr.first();
	}
	public static float secondOf(longArr arr) {
		if (not(arr))
			return 0;
		return arr.second();
	}
	public static float firstOf(fltArr arr) {
		if (not(arr))
			return 0;
		return arr.first();
	}
	public static float secondOf(fltArr arr) {
		if (not(arr))
			return 0;
		return arr.second();
	}
	public static double firstOf(dblArr arr) {
		if (not(arr))
			return 0;
		return arr.first();
	}
	public static double secondOf(dblArr arr) {
		if (not(arr))
			return 0;
		return arr.second();
	}
	public static boolean firstOf(boolArr arr) {
		if (not(arr))
			return false;
		return arr.first();
	}
	public static boolean secondOf(boolArr arr) {
		if (not(arr))
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
	public static String nthLastOf(strArr arr, int n) {
		return n > 0 && n <= len(arr) ? arr.lasti(n) : "";
	}
	public static int nthLastOf(intArr arr, int n) {
		return n > 0 && n <= len(arr) ? arr.lasti(n) : 0;
	}
	public static long nthLastOf(longArr arr, int n) {
		return n > 0 && n <= len(arr) ? arr.lasti(n) : 0;
	}
	public static float nthLastOf(fltArr arr, int n) {
		return n > 0 && n <= len(arr) ? arr.lasti(n) : 0;
	}
	public static double nthLastOf(dblArr arr, int n) {
		return n > 0 && n <= len(arr) ? arr.lasti(n) : 0;
	}
	public static boolean nthLastOf(boolArr arr, int n) {
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
	public static String secondLastOf(strArr arr) {
		return len(arr) - 2 >= 0 ? arr.seclast() : "";
	}
	public static String lastOf(strArr arr) {
		return len(arr) - 1 >= 0 ? arr.last() : "";
	}
	public static int secondLastOf(intArr arr) {
		return len(arr) - 2 >= 0 ? arr.seclast() : 0;
	}
	public static int lastOf(intArr arr) {
		return len(arr) - 1 >= 0 ? arr.last() : 0;
	}
	public static float secondLastOf(longArr arr) {
		return len(arr) - 2 >= 0 ? arr.seclast() : 0;
	}
	public static float lastOf(longArr arr) {
		return len(arr) - 1 >= 0 ? arr.last() : 0;
	}
	public static float secondLastOf(fltArr arr) {
		return len(arr) - 2 >= 0 ? arr.seclast() : 0;
	}
	public static float lastOf(fltArr arr) {
		return len(arr) - 1 >= 0 ? arr.last() : 0;
	}
	public static double secondLastOf(dblArr arr) {
		return len(arr) - 2 >= 0 ? arr.seclast() : 0;
	}
	public static double lastOf(dblArr arr) {
		return len(arr) - 1 >= 0 ? arr.last() : 0;
	}
	public static boolean secondLastOf(boolArr arr) {
		return len(arr) - 2 >= 0 ? arr.seclast() : false;
	}
	public static boolean lastOf(boolArr arr) {
		return len(arr) - 1 >= 0 ? arr.last() : false;
	}
	public static String secondLastOf(objS arr) {
		return len(arr) - 2 >= 0 ? arr.seclast() : "";
	}
	public static String lastOf(objS arr) {
		return len(arr) - 1 >= 0 ? arr.last() : "";
	}
	public static int secondLastOf(objI arr) {
		return len(arr) - 2 >= 0 ? arr.seclast() : 0;
	}
	public static int lastOf(objI arr) {
		return len(arr) - 1 >= 0 ? arr.last() : 0;
	}
	public static long secondLastOf(objL arr) {
		return len(arr) - 2 >= 0 ? arr.seclast() : 0;
	}
	public static long lastOf(objL arr) {
		return len(arr) - 1 >= 0 ? arr.last() : 0;
	}
	public static float secondLastOf(objF arr) {
		return len(arr) - 2 >= 0 ? arr.seclast() : 0;
	}
	public static float lastOf(objF arr) {
		return len(arr) - 1 >= 0 ? arr.last() : 0;
	}
	public static double secondLastOf(objD arr) {
		return len(arr) - 2 >= 0 ? arr.seclast() : 0;
	}
	public static double lastOf(objD arr) {
		return len(arr) - 1 >= 0 ? arr.last() : 0;
	}
	public static boolean secondLastOf(objB arr) {
		return len(arr) - 2 >= 0 ? arr.seclast() : false;
	}
	public static boolean lastOf(objB arr) {
		return len(arr) - 1 >= 0 ? arr.last() : false;
	}
	public static String secondLastOf(treeDS arr) {
		return len(arr) - 2 >= 0 ? arr.seclast() : "";
	}
	public static String lastOf(treeDS arr) {
		return len(arr) - 1 >= 0 ? arr.last() : "";
	}
	public static int secondLastOf(treeDI arr) {
		return len(arr) - 2 >= 0 ? arr.seclast() : 0;
	}
	public static int lastOf(treeDI arr) {
		return len(arr) - 1 >= 0 ? arr.last() : 0;
	}
	public static String secondLastOf(treeI arr) {
		return len(arr) - 2 >= 0 ? arr.seclast() : "";
	}
	public static String lastOf(treeI arr) {
		return len(arr) - 1 >= 0 ? arr.last() : "";
	}
	public static long secondLastOf(treeDL arr) {
		return len(arr) - 2 >= 0 ? arr.seclast() : 0;
	}
	public static long lastOf(treeDL arr) {
		return len(arr) - 1 >= 0 ? arr.last() : 0;
	}
	public static long secondLastOf(treeL arr) {
		return len(arr) - 2 >= 0 ? arr.seclast() : 0;
	}
	public static long lastOf(treeL arr) {
		return len(arr) - 1 >= 0 ? arr.last() : 0;
	}
	public static float secondLastOf(treeDF arr) {
		return len(arr) - 2 >= 0 ? arr.seclast() : 0;
	}
	public static float lastOf(treeDF arr) {
		return len(arr) - 1 >= 0 ? arr.last() : 0;
	}
	public static float secondLastOf(treeF arr) {
		return len(arr) - 2 >= 0 ? arr.seclast() : 0;
	}
	public static float lastOf(treeF arr) {
		return len(arr) - 1 >= 0 ? arr.last() : 0;
	}
	public static double secondLastOf(treeD arr) {
		return len(arr) - 2 >= 0 ? arr.seclast() : 0;
	}
	public static double lastOf(treeD arr) {
		return len(arr) - 1 >= 0 ? arr.last() : 0;
	}
	public static boolean secondLastOf(treeDB arr) {
		return len(arr) - 2 >= 0 ? arr.seclast() : false;
	}
	public static boolean lastOf(treeDB arr) {
		return len(arr) - 1 >= 0 ? arr.last() : false;
	}
	public static boolean secondLastOf(treeB arr) {
		return len(arr) - 2 >= 0 ? arr.seclast() : false;
	}
	public static boolean lastOf(treeB arr) {
		return len(arr) - 1 >= 0 ? arr.last() : false;
	}
	public static int indexOf(String inStr, String lookupStr, int startIndex) {
		if (not(inStr) || isNull(startIndex) || isNeg(startIndex))
			return -1;
		return inStr.indexOf(lookupStr, startIndex);
	}
	public static int indexOf(String inStr, String lookupStr) {
		return indexOf(inStr, lookupStr, 0);
	}
	public static int indexOf(String inStr, char lookupCh, int startIndex) {
		if (not(inStr) || not(lookupCh) || isNull(startIndex)
				|| isNeg(startIndex))
			return -1;
		for (int i : range(inStr)) {
			if (slice(inStr, startIndex).toCharArray()[i] == lookupCh)
				return i;
		}
		return -1;
	}
	public static int indexOf(String inStr, char lookupCh) {
		return indexOf(inStr, lookupCh, 0);
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
	public static int indexOf(strArr arr, String s) {
		return arr.indexOf(s);
	}
	public static int lastIndexOf(strArr arr, String s) {
		return arr.lastIndexOf(s);
	}
	public static int indexOf(intArr arr, int n) {
		return arr.indexOf(n);
	}
	public static int lastIndexOf(intArr arr, int n) {
		return arr.lastIndexOf(n);
	}
	public static int indexOf(longArr arr, long n) {
		return arr.indexOf(n);
	}
	public static int lastIndexOf(longArr arr, long n) {
		return arr.lastIndexOf(n);
	}
	public static int indexOf(fltArr arr, float n) {
		return arr.indexOf(n);
	}
	public static int lastIndexOf(fltArr arr, float n) {
		return arr.lastIndexOf(n);
	}
	public static int indexOf(dblArr arr, double n) {
		return arr.indexOf(n);
	}
	public static int lastIndexOf(dblArr arr, double n) {
		return arr.lastIndexOf(n);
	}
	public static int indexOf(boolArr arr, boolean b) {
		return arr.indexOf(b);
	}
	public static int lastIndexOf(boolArr arr, boolean b) {
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
		if (isNull(str) || isNull(re))
			return false;
		// these null checks have to stay NULL checks, not entire `not` checks,
		// as not(re) would trim whitespace " ", which we sometimes DO need to
		// look up in a string to see if the string is more than one word, down
		// to ""
		if (re.equals(".") || re.equals("*") || re.equals("+")
				|| re.equals("?"))
			re = "\\" + re;
		try {
			re = re.replaceAll("(?<![\\.\\\\])\\.(?![*+])", "\\\\.")
					.replaceAll("(?<![\\\\\\.\\w\\)\\]\\|\\%\\$@])([\\+\\*])",
							"\\\\$1")
					.replaceAll("%%", "%").replaceAll("(?<!\\\\)%c", "[A-Za-z]")
					.replaceAll("(?<!\\\\)(%[sw]|\\{\\})", "[A-Za-z][\\\\w]+")
					.replaceAll("(?<!\\\\)%b", "(true|false)")
					.replaceAll("(?<!\\\\)%[di]", "(?<!\\.)\\\\d+(?!\\.)")
					.replaceAll("(?<!\\\\)%[\\.\\\\d]*f", "\\\\d*\\.\\\\d+")
					.replaceAll("(?<!\\\\)%n", "\\\\d+");
		} catch (Exception e) {

		}
		// modification precaution: it has been tested, and hence learned,
		// the
		// double-escaping remains AS-IS
		// THIS IS THE ONLY PART OF THE FILE WHERE YOU NEED TO ESCAPE TWICE
		// escaping tricky characters, if they're the only content: helps avoid
		// false positives as a "." or a "*" alone, can match just anything.
		// Needless to say, these quantifiers, along with a "+" and an
		// optionality quantifier, i.e. a "?" quantifier, might also cause
		// memory heap to exceed
		// plus, handling both, standard and custom, format specifiers
		boolean strict = false;
		if (is(bools))
			strict = bools[0] == true;
		Pattern pattern = Pattern.compile(re,
				strict ? 0 : Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(str.trim());
		return !!matcher.find();
	}
	public static String findMatch(String str, String re, boolean... bools) {
		if (not(str) || not(re))
			return "";
		if (re.equals(".") || re.equals("*") || re.equals("+")
				|| re.equals("?")) {
			re = "\\" + re;
		}
		try {
			re = re.replaceAll("(?<![\\.\\\\])\\.(?![*+])", "\\\\.")
					.replaceAll("(?<![\\\\\\.\\w\\)\\]\\|\\%\\$@])([\\+\\*])",
							"\\\\$1")
					.replaceAll("%%", "%").replaceAll("(?<!\\\\)%c", "[A-Za-z]")
					.replaceAll("(?<!\\\\)(%[sw]|\\{\\})", "[A-Za-z][\\\\w]+")
					.replaceAll("(?<!\\\\)%b", "(true|false)")
					.replaceAll("(?<!\\\\)%[di]", "(?<!\\.)\\\\d+(?!\\.)")
					.replaceAll("(?<!\\\\)%[\\.\\\\d]*f", "\\\\d*\\.\\\\d+")
					.replaceAll("(?<!\\\\)%n", "\\\\d+");
		} catch (Exception e) {

		}
		// modification precaution: it has been tested, and hence learned,
		// the
		// double-escaping remains AS-IS
		// THIS IS THE ONLY PART OF THE FILE WHERE YOU NEED TO ESCAPE TWICE
		// escaping tricky characters, if they're the only content: helps avoid
		// false positives as a "." or a "*" alone, can match just anything.
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
		Matcher matcher = pattern.matcher(str.trim());
		if (!matcher.find())
			return "";
		return matcher.group();
	}
	public static String[] findMatches(String str, String re,
			boolean... bools) {
		if (not(str) || not(re))
			return blank.Str;
		// blank.Str actually refers to new String[]{}. I know it could have
		// been blank.strArr, but that would have been too long, and would be
		// almost the same as typing new String[]{}. Sometimes, we're just
		// looking for conciseness.
		if (re.equals(".") || re.equals("*") || re.equals("+")
				|| re.equals("?")) {
			re = "\\" + re;
		}
		try {
			re = re.replaceAll("(?<![\\.\\\\])\\.(?![*+])", "\\\\.")
					.replaceAll("(?<![\\\\\\.\\w\\)\\]\\|\\%\\$@])([\\+\\*])",
							"\\\\$1")
					.replaceAll("%%", "%").replaceAll("(?<!\\\\)%c", "[A-Za-z]")
					.replaceAll("(?<!\\\\)(%[sw]|\\{\\})", "[A-Za-z][\\\\w]+")
					.replaceAll("(?<!\\\\)%b", "(true|false)")
					.replaceAll("(?<!\\\\)%[di]", "(?<!\\.)\\\\d+(?!\\.)")
					.replaceAll("(?<!\\\\)%[\\.\\\\d]*f", "\\\\d*\\.\\\\d+")
					.replaceAll("(?<!\\\\)%n", "\\\\d+");
		} catch (Exception e) {

		}
		// modification precaution: it has been tested, and hence learned,
		// the
		// double-escaping remains AS-IS
		// THIS IS THE ONLY PART OF THE FILE WHERE YOU NEED TO ESCAPE TWICE
		// escaping tricky characters, if they're the only content: helps avoid
		// false positives as a "." or a "*" alone, can match just anything.
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
		Matcher matcher = pattern.matcher(str.trim());
		strArr arr = new strArr();
		while (matcher.find()) {
			if (!isEmpty(matcher.group()))
				arr.push(trim(matcher.group()));
			// the isEmpty check has proven to be helpful
		}
		return arr.array();
	}
	public static int[] intsOf(String s) {
		if (not(s))
			return new int[]{};
		intArr arr = new intArr();
		String[] matches = findMatches(s, "(?<!\\.)(\\d+)(?!\\.)");
		for (int i : range(matches))
			arr.push(Int(matches[i]));
		return arr.array();
	}
	public static int[] intsOf(Number... nums) {
		if (not(nums))
			return blank.Int;
		intArr resultantArr = new intArr();
		for (Number n : nums) {
			if (!isNull(n))
				resultantArr.push(n.intValue());
		}
		return resultantArr.array();
	}
	public static int[] intsOf(Object... objs) {
		intArr resultantArr = new intArr();
		for (Object obj : objs) {
			if (obj instanceof Integer)
				resultantArr.push((int) obj);
		}
		return resultantArr.array();
	}
	public static float[] fltsOf(String s) {
		if (not(s))
			return new float[]{};
		fltArr arr = new fltArr();
		String[] matches = findMatches(s, "\\d*\\.\\d+");
		for (int i : range(matches))
			arr.push(Flt(matches[i]));
		return arr.array();
	}
	public static float[] fltsOf(Number... nums) {
		if (not(nums))
			return blank.Flt;
		fltArr resultantArr = new fltArr();
		for (Number n : nums) {
			if (!isNull(n))
				resultantArr.push(n.floatValue());
		}
		return resultantArr.array();
	}
	public static float[] fltsOf(Object... objs) {
		fltArr resultantArr = new fltArr();
		for (Object obj : objs) {
			if (obj instanceof Float)
				resultantArr.push((float) obj);
		}
		return resultantArr.array();
	}
	public static double[] dblsOf(String s) {
		if (not(s))
			return new double[]{};
		dblArr arr = new dblArr();
		String[] matches = findMatches(s, "[\\d]*\\.\\d+");
		for (int i : range(matches))
			arr.push(Dbl(matches[i]));
		return arr.array();
	}
	public static double[] dblsOf(Number... nums) {
		if (not(nums))
			return blank.Dbl;
		dblArr resultantArr = new dblArr();
		for (Number n : nums) {
			if (!isNull(n))
				resultantArr.push(n.doubleValue());
		}
		return resultantArr.array();
	}
	public static double[] dblsOf(Object... objs) {
		dblArr resultantArr = new dblArr();
		for (Object obj : objs) {
			if (obj instanceof Double)
				resultantArr.push((double) obj);
		}
		return resultantArr.array();
	}
	public static double[] numsOf(String s) {
		if (not(s))
			return new double[]{};
		dblArr arr = new dblArr();
		String[] matches = findMatches(s, "\\d*\\.?\\d+");
		for (int i : range(matches))
			arr.push(Dbl(matches[i]));
		return arr.array();
	}
	public static double[] numsOf(Object... objs) {
		dblArr resultantArr = new dblArr();
		for (Object obj : objs) {
			if (obj instanceof Number)
				resultantArr.push(setPrecision(((Number) obj).doubleValue()));
		}
		return resultantArr.array();
	}
	public static String[] emailsOf(String s) {
		if (not(s))
			return new String[]{};
		strArr arr = new strArr();
		String[] matches = findMatches(s,
				"[a-zA-Z][\\w\\.\\-\\_\\+\\!]+@[\\w]{3,}(\\.[a-zA-Z]{2,}){1,2}");
		for (int i : range(matches))
			arr.push(matches[i]);
		return arr.array();
	}
	public static String[] urlsOf(String s) {
		if (not(s))
			return new String[]{};
		strArr arr = new strArr();
		String[] matches = findMatches(s,
				"(?<proto>[a-zA-Z]{1,6}\\:[\\\\\\/]{2,3})?(?<sub>\\w{2,}\\.)?(?<domain>[\\w\\-]+)(?<suffix>\\.[a-zA-Z]{2,}){1,2}(?<route>\\/[\\S]*)?");
		for (int i : range(matches))
			arr.push(matches[i]);
		return arr.array();
	}
	public static String[] phonesOf(String s) {
		if (not(s))
			return new String[]{};
		strArr arr = new strArr();
		String[] matches = findMatches(s,
				"((?<start>\\+|0{2})?(?<country>[\\d]{1,3}))?[\\s\\(]{0,2}(?<body>(?<A>\\d{3})[\\s\\)]{0,2}(?<B>\\d{3})\\s?(?<C>\\d{4}))");
		for (int i : range(matches))
			arr.push(matches[i]);
		return arr.array();
	}
	public static String[] findUserData(String s) {
		if (not(s))
			return blank.Str;
		strArr arr = new strArr();
		arr.push(emailsOf(s), urlsOf(s), phonesOf(s));
		return arr.array();
	}
	public static boolean isEmail(String s) {
		if (not(s))
			return false;
		return eq(trim(s),
				"[a-zA-Z][\\w\\.\\-\\_\\+\\!]+@[\\w]{3,}(\\.[a-zA-Z]{2,}){1,2}");
		// apparently, Java is stupid when it comes to regular expression.
		// Learned: neither "\\s"
	}
	public static boolean isUrl(String s) {
		if (not(s))
			return false;
		return eq(trim(s),
				"(?<proto>[a-zA-Z]{1,6}\\:[\\\\\\/]{2,3})?(?<sub>\\w{2,}\\.)?(?<domain>[\\w\\-]+)(?<suffix>\\.[a-zA-Z]{2,}){1,2}(?<route>\\/[\\S]*)?");
	}
	public static boolean isPhone(String s) {
		if (not(s))
			return false;
		return eq(trim(s),
				"((?<start>\\+|0{2})?(?<country>[\\d]{1,3}))?[\\s\\(]{0,2}(?<body>(?<A>\\d{3})[\\s\\)]{0,2}(?<B>\\d{3})\\s?(?<C>\\d{4}))");
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
	public static double[] findNums(String s) {
		return numsOf(s);
	}
	public static double[] findNums(Object... objs) {
		return numsOf(objs);
	}
	public static String[] findEmails(String s) {
		return emailsOf(s);
	}
	public static String[] findUrls(String s) {
		return urlsOf(s);
	}
	public static String[] findPhones(String s) {
		return phonesOf(s);
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
	public static boolean numsIn(String s) {
		return numsOf(s).length > 0;
	}
	public static boolean numsIn(Object... objs) {
		return numsOf(objs).length > 0;
	}
	public static boolean emailsIn(String s) {
		return emailsOf(s).length > 0;
	}
	public static boolean urlsIn(String s) {
		return urlsOf(s).length > 0;
	}
	public static boolean phonesIn(String s) {
		return phonesOf(s).length > 0;
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
	public static strArr clone(strArr arr) {
		return slice(arr);
	}
	public static intArr clone(intArr arr) {
		return slice(arr);
	}
	public static longArr clone(longArr arr) {
		return slice(arr);
	}
	public static fltArr clone(fltArr arr) {
		return slice(arr);
	}
	public static dblArr clone(dblArr arr) {
		return slice(arr);
	}
	public static boolArr clone(boolArr arr) {
		return slice(arr);
	}
	public static treeDI clone(treeDI arr) {
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
	public static strArr copyArr(strArr arr) {
		return clone(arr);
	}
	public static intArr copyArr(intArr arr) {
		return clone(arr);
	}
	public static longArr copyArr(longArr arr) {
		return clone(arr);
	}
	public static fltArr copyArr(fltArr arr) {
		return clone(arr);
	}
	public static dblArr copyArr(dblArr arr) {
		return clone(arr);
	}
	public static boolArr copyArr(boolArr arr) {
		return clone(arr);
	}
	public static final class blank {
		public static String[] Str = new String[]{};
		public static int[] Int = new int[]{};
		public static char[] Ch, Char = Ch = new char[]{};
		public static long[] Long = new long[]{};
		public static float[] Flt = new float[]{};
		public static double[] Dbl = new double[]{};
		public static boolean[] Bool = new boolean[]{};
		public static Number[] Num = new Number[]{};
		public static Object[] Obj = new Object[]{};
		public static strArr strArr = new strArr();
		public static intArr intArr = new intArr();
		public static longArr longArr = new longArr();
		public static fltArr fltArr = new fltArr();
		public static dblArr dblArr = new dblArr();
		public static boolArr boolArr = new boolArr();
	}
	public static String[] combine(String[] arrA, String[]... arrays) {
		if (not(arrA) || not(arrays))
			return blank.Str;
		return combine(new strArr(arrA), arrays).array();
	}
	public static String[] combine(String[] arrA, strArr... arrays) {
		if (not(arrA) || not(arrays))
			return blank.Str;
		return combine(new strArr(arrA), arrays).array();
	}
	public static int[] combine(int[] arrA, int[]... arrays) {
		if (not(arrA) || not(arrays))
			return blank.Int;
		return combine(new intArr(arrA), arrays).array();
	}
	public static int[] combine(int[] arrA, intArr... arrays) {
		if (not(arrA) || not(arrays))
			return blank.Int;
		return combine(new intArr(arrA), arrays).array();
	}
	public static long[] combine(long[] arrA, long[]... arrays) {
		if (not(arrA) || not(arrays))
			return blank.Long;
		return combine(new longArr(arrA), arrays).array();
	}
	public static long[] combine(long[] arrA, longArr... arrays) {
		if (not(arrA) || not(arrays))
			return blank.Long;
		return combine(new longArr(arrA), arrays).array();
	}
	public static float[] combine(float[] arrA, float[]... arrays) {
		if (not(arrA) || not(arrays))
			return blank.Flt;
		return combine(new fltArr(arrA), arrays).array();
	}
	public static float[] combine(float[] arrA, fltArr... arrays) {
		if (not(arrA) || not(arrays))
			return blank.Flt;
		return combine(new fltArr(arrA), arrays).array();
	}
	public static double[] combine(double[] arrA, double[]... arrays) {
		if (not(arrA) || not(arrays))
			return blank.Dbl;
		return combine(new dblArr(arrA), arrays).array();
	}
	public static double[] combine(double[] arrA, dblArr... arrays) {
		if (not(arrA) || not(arrays))
			return blank.Dbl;
		return combine(new dblArr(arrA), arrays).array();
	}
	public static boolean[] combine(boolean[] arrA, boolean[]... arrays) {
		if (not(arrA) || not(arrays))
			return blank.Bool;
		return combine(new boolArr(arrA), arrays).array();
	}
	public static boolean[] combine(boolean[] arrA, boolArr... arrays) {
		if (not(arrA) || not(arrays))
			return blank.Bool;
		return combine(new boolArr(arrA), arrays).array();
	}
	public static strArr combine(strArr arrA, strArr... arrays) {
		return arrA.combine(arrays);
	}
	public static strArr combine(strArr arrA, String[]... arrays) {
		return arrA.combine(arrays);
	}
	public static intArr combine(intArr arrA, intArr... arrays) {
		return arrA.combine(arrays);
	}
	public static intArr combine(intArr arrA, int[]... arrays) {
		return arrA.combine(arrays);
	}
	public static longArr combine(longArr arrA, longArr... arrays) {
		return arrA.combine(arrays);
	}
	public static longArr combine(longArr arrA, long[]... arrays) {
		return arrA.combine(arrays);
	}
	public static fltArr combine(fltArr arrA, fltArr... arrays) {
		return arrA.combine(arrays);
	}
	public static fltArr combine(fltArr arrA, float[]... arrays) {
		return arrA.combine(arrays);
	}
	public static dblArr combine(dblArr arrA, dblArr... arrays) {
		return arrA.combine(arrays);
	}
	public static dblArr combine(dblArr arrA, double[]... arrays) {
		return arrA.combine(arrays);
	}
	public static boolArr combine(boolArr arrA, boolArr... arrays) {
		return arrA.combine(arrays);
	}
	public static boolArr combine(boolArr arrA, boolean[]... arrays) {
		return arrA.combine(arrays);
	}
	public static String[] concat(String[] arrA, String[]... arrays) {
		return combine(arrA, arrays);
	}
	public static String[] concat(String[] arrA, strArr... arrays) {
		return combine(arrA, arrays);
	}
	public static int[] concat(int[] arrA, int[]... arrays) {
		return combine(arrA, arrays);
	}
	public static int[] concat(int[] arrA, intArr... arrays) {
		return combine(arrA, arrays);
	}
	public static long[] concat(long[] arrA, long[]... arrays) {
		return combine(arrA, arrays);
	}
	public static long[] concat(long[] arrA, longArr... arrays) {
		return combine(arrA, arrays);
	}
	public static float[] concat(float[] arrA, float[]... arrays) {
		return combine(arrA, arrays);
	}
	public static float[] concat(float[] arrA, fltArr... arrays) {
		return combine(arrA, arrays);
	}
	public static double[] concat(double[] arrA, double[]... arrays) {
		return combine(arrA, arrays);
	}
	public static double[] concat(double[] arrA, dblArr... arrays) {
		return combine(arrA, arrays);
	}
	public static boolean[] concat(boolean[] arrA, boolean[]... arrays) {
		return combine(arrA, arrays);
	}
	public static boolean[] concat(boolean[] arrA, boolArr... arrays) {
		return combine(arrA, arrays);
	}
	public static strArr concat(strArr arrA, strArr... arrays) {
		return combine(arrA, arrays);
	}
	public static strArr concat(strArr arrA, String[]... arrays) {
		return combine(arrA, arrays);
	}
	public static intArr concat(intArr arrA, intArr... arrays) {
		return combine(arrA, arrays);
	}
	public static intArr concat(intArr arrA, int[]... arrays) {
		return combine(arrA, arrays);
	}
	public static longArr concat(longArr arrA, longArr... arrays) {
		return combine(arrA, arrays);
	}
	public static longArr concat(longArr arrA, long[]... arrays) {
		return combine(arrA, arrays);
	}
	public static fltArr concat(fltArr arrA, fltArr... arrays) {
		return combine(arrA, arrays);
	}
	public static fltArr concat(fltArr arrA, float[]... arrays) {
		return combine(arrA, arrays);
	}
	public static dblArr concat(dblArr arrA, dblArr... arrays) {
		return combine(arrA, arrays);
	}
	public static dblArr concat(dblArr arrA, double[]... arrays) {
		return combine(arrA, arrays);
	}
	public static boolArr concat(boolArr arrA, boolArr... arrays) {
		return combine(arrA, arrays);
	}
	public static boolArr concat(boolArr arrA, boolean[]... arrays) {
		return combine(arrA, arrays);
	}
	public static String[] cat(String[] arrA, String[]... arrays) {
		return combine(arrA, arrays);
	}
	public static String[] cat(String[] arrA, strArr... arrays) {
		return combine(arrA, arrays);
	}
	public static int[] cat(int[] arrA, int[]... arrays) {
		return combine(arrA, arrays);
	}
	public static int[] cat(int[] arrA, intArr... arrays) {
		return combine(arrA, arrays);
	}
	public static long[] cat(long[] arrA, long[]... arrays) {
		return combine(arrA, arrays);
	}
	public static long[] cat(long[] arrA, longArr... arrays) {
		return combine(arrA, arrays);
	}
	public static float[] cat(float[] arrA, float[]... arrays) {
		return combine(arrA, arrays);
	}
	public static float[] cat(float[] arrA, fltArr... arrays) {
		return combine(arrA, arrays);
	}
	public static double[] cat(double[] arrA, double[]... arrays) {
		return combine(arrA, arrays);
	}
	public static double[] cat(double[] arrA, dblArr... arrays) {
		return combine(arrA, arrays);
	}
	public static boolean[] cat(boolean[] arrA, boolean[]... arrays) {
		return combine(arrA, arrays);
	}
	public static boolean[] cat(boolean[] arrA, boolArr... arrays) {
		return combine(arrA, arrays);
	}
	public static strArr cat(strArr arrA, strArr... arrays) {
		return combine(arrA, arrays);
	}
	public static strArr cat(strArr arrA, String[]... arrays) {
		return combine(arrA, arrays);
	}
	public static intArr cat(intArr arrA, intArr... arrays) {
		return combine(arrA, arrays);
	}
	public static intArr cat(intArr arrA, int[]... arrays) {
		return combine(arrA, arrays);
	}
	public static longArr cat(longArr arrA, longArr... arrays) {
		return combine(arrA, arrays);
	}
	public static longArr cat(longArr arrA, long[]... arrays) {
		return combine(arrA, arrays);
	}
	public static fltArr cat(fltArr arrA, fltArr... arrays) {
		return combine(arrA, arrays);
	}
	public static fltArr cat(fltArr arrA, float[]... arrays) {
		return combine(arrA, arrays);
	}
	public static dblArr cat(dblArr arrA, dblArr... arrays) {
		return combine(arrA, arrays);
	}
	public static dblArr cat(dblArr arrA, double[]... arrays) {
		return combine(arrA, arrays);
	}
	public static boolArr cat(boolArr arrA, boolArr... arrays) {
		return combine(arrA, arrays);
	}
	public static boolArr cat(boolArr arrA, boolean[]... arrays) {
		return combine(arrA, arrays);
	}
	public static String[] merge(String[] arrA, String[]... arrays) {
		return combine(arrA, arrays);
	}
	public static String[] merge(String[] arrA, strArr... arrays) {
		return combine(arrA, arrays);
	}
	public static int[] merge(int[] arrA, int[]... arrays) {
		return combine(arrA, arrays);
	}
	public static int[] merge(int[] arrA, intArr... arrays) {
		return combine(arrA, arrays);
	}
	public static long[] merge(long[] arrA, long[]... arrays) {
		return combine(arrA, arrays);
	}
	public static long[] merge(long[] arrA, longArr... arrays) {
		return combine(arrA, arrays);
	}
	public static float[] merge(float[] arrA, float[]... arrays) {
		return combine(arrA, arrays);
	}
	public static float[] merge(float[] arrA, fltArr... arrays) {
		return combine(arrA, arrays);
	}
	public static double[] merge(double[] arrA, double[]... arrays) {
		return combine(arrA, arrays);
	}
	public static double[] merge(double[] arrA, dblArr... arrays) {
		return combine(arrA, arrays);
	}
	public static boolean[] merge(boolean[] arrA, boolean[]... arrays) {
		return combine(arrA, arrays);
	}
	public static boolean[] merge(boolean[] arrA, boolArr... arrays) {
		return combine(arrA, arrays);
	}
	public static strArr merge(strArr arrA, strArr... arrays) {
		return combine(arrA, arrays);
	}
	public static strArr merge(strArr arrA, String[]... arrays) {
		return combine(arrA, arrays);
	}
	public static intArr merge(intArr arrA, intArr... arrays) {
		return combine(arrA, arrays);
	}
	public static intArr merge(intArr arrA, int[]... arrays) {
		return combine(arrA, arrays);
	}
	public static longArr merge(longArr arrA, longArr... arrays) {
		return combine(arrA, arrays);
	}
	public static longArr merge(longArr arrA, long[]... arrays) {
		return combine(arrA, arrays);
	}
	public static fltArr merge(fltArr arrA, fltArr... arrays) {
		return combine(arrA, arrays);
	}
	public static fltArr merge(fltArr arrA, float[]... arrays) {
		return combine(arrA, arrays);
	}
	public static dblArr merge(dblArr arrA, dblArr... arrays) {
		return combine(arrA, arrays);
	}
	public static dblArr merge(dblArr arrA, double[]... arrays) {
		return combine(arrA, arrays);
	}
	public static boolArr merge(boolArr arrA, boolArr... arrays) {
		return combine(arrA, arrays);
	}
	public static boolArr merge(boolArr arrA, boolean[]... arrays) {
		return combine(arrA, arrays);
	}
	public static String[] join(String[] arrA, String[]... arrays) {
		return combine(arrA, arrays);
	}
	public static String[] join(String[] arrA, strArr... arrays) {
		return combine(arrA, arrays);
	}
	public static int[] join(int[] arrA, int[]... arrays) {
		return combine(arrA, arrays);
	}
	public static int[] join(int[] arrA, intArr... arrays) {
		return combine(arrA, arrays);
	}
	public static long[] join(long[] arrA, long[]... arrays) {
		return combine(arrA, arrays);
	}
	public static long[] join(long[] arrA, longArr... arrays) {
		return combine(arrA, arrays);
	}
	public static float[] join(float[] arrA, float[]... arrays) {
		return combine(arrA, arrays);
	}
	public static float[] join(float[] arrA, fltArr... arrays) {
		return combine(arrA, arrays);
	}
	public static double[] join(double[] arrA, double[]... arrays) {
		return combine(arrA, arrays);
	}
	public static double[] join(double[] arrA, dblArr... arrays) {
		return combine(arrA, arrays);
	}
	public static boolean[] join(boolean[] arrA, boolean[]... arrays) {
		return combine(arrA, arrays);
	}
	public static boolean[] join(boolean[] arrA, boolArr... arrays) {
		return combine(arrA, arrays);
	}
	public static strArr join(strArr arrA, strArr... arrays) {
		return combine(arrA, arrays);
	}
	public static strArr join(strArr arrA, String[]... arrays) {
		return combine(arrA, arrays);
	}
	public static intArr join(intArr arrA, intArr... arrays) {
		return combine(arrA, arrays);
	}
	public static intArr join(intArr arrA, int[]... arrays) {
		return combine(arrA, arrays);
	}
	public static longArr join(longArr arrA, longArr... arrays) {
		return combine(arrA, arrays);
	}
	public static longArr join(longArr arrA, long[]... arrays) {
		return combine(arrA, arrays);
	}
	public static fltArr join(fltArr arrA, fltArr... arrays) {
		return combine(arrA, arrays);
	}
	public static fltArr join(fltArr arrA, float[]... arrays) {
		return combine(arrA, arrays);
	}
	public static dblArr join(dblArr arrA, dblArr... arrays) {
		return combine(arrA, arrays);
	}
	public static dblArr join(dblArr arrA, double[]... arrays) {
		return combine(arrA, arrays);
	}
	public static boolArr join(boolArr arrA, boolArr... arrays) {
		return combine(arrA, arrays);
	}
	public static boolArr join(boolArr arrA, boolean[]... arrays) {
		return combine(arrA, arrays);
	}

	public static String[] add(String[] arrA, String[]... arrays) {
		return combine(arrA, arrays);
	}
	public static String[] add(String[] arrA, strArr... arrays) {
		return combine(arrA, arrays);
	}
	public static int[] add(int[] arrA, int[]... arrays) {
		return combine(arrA, arrays);
	}
	public static int[] add(int[] arrA, intArr... arrays) {
		return combine(arrA, arrays);
	}
	public static long[] add(long[] arrA, long[]... arrays) {
		return combine(arrA, arrays);
	}
	public static long[] add(long[] arrA, longArr... arrays) {
		return combine(arrA, arrays);
	}
	public static float[] add(float[] arrA, float[]... arrays) {
		return combine(arrA, arrays);
	}
	public static float[] add(float[] arrA, fltArr... arrays) {
		return combine(arrA, arrays);
	}
	public static double[] add(double[] arrA, double[]... arrays) {
		return combine(arrA, arrays);
	}
	public static double[] add(double[] arrA, dblArr... arrays) {
		return combine(arrA, arrays);
	}
	public static boolean[] add(boolean[] arrA, boolean[]... arrays) {
		return combine(arrA, arrays);
	}
	public static boolean[] add(boolean[] arrA, boolArr... arrays) {
		return combine(arrA, arrays);
	}
	public static strArr add(strArr arrA, strArr... arrays) {
		return combine(arrA, arrays);
	}
	public static strArr add(strArr arrA, String[]... arrays) {
		return combine(arrA, arrays);
	}
	public static intArr add(intArr arrA, intArr... arrays) {
		return combine(arrA, arrays);
	}
	public static intArr add(intArr arrA, int[]... arrays) {
		return combine(arrA, arrays);
	}
	public static longArr add(longArr arrA, longArr... arrays) {
		return combine(arrA, arrays);
	}
	public static longArr add(longArr arrA, long[]... arrays) {
		return combine(arrA, arrays);
	}
	public static fltArr add(fltArr arrA, fltArr... arrays) {
		return combine(arrA, arrays);
	}
	public static fltArr add(fltArr arrA, float[]... arrays) {
		return combine(arrA, arrays);
	}
	public static dblArr add(dblArr arrA, dblArr... arrays) {
		return combine(arrA, arrays);
	}
	public static dblArr add(dblArr arrA, double[]... arrays) {
		return combine(arrA, arrays);
	}
	public static boolArr add(boolArr arrA, boolArr... arrays) {
		return combine(arrA, arrays);
	}
	public static boolArr add(boolArr arrA, boolean[]... arrays) {
		return combine(arrA, arrays);
	}
	public static String[] intersection(String[] arrA, String[]... arrays) {
		if (not(arrA) || not(arrays))
			return blank.Str;
		return new strArr(arrA).intersection(arrays).array();
	}
	public static int[] intersection(int[] arrA, int[]... arrays) {
		if (not(arrA) || not(arrays))
			return blank.Int;
		return new intArr(arrA).intersection(arrays).array();
	}
	public static long[] intersection(long[] arrA, long[]... arrays) {
		if (not(arrA) || not(arrays))
			return blank.Long;
		return new longArr(arrA).intersection(arrays).array();
	}
	public static float[] intersection(float[] arrA, float[]... arrays) {
		if (not(arrA) || not(arrays))
			return blank.Flt;
		return new fltArr(arrA).intersection(arrays).array();
	}
	public static double[] intersection(double[] arrA, double[]... arrays) {
		if (not(arrA) || not(arrays))
			return blank.Dbl;
		return new dblArr(arrA).intersection(arrays).array();
	}
	public static boolean[] intersection(boolean[] arrA, boolean[]... arrays) {
		if (not(arrA) || not(arrays))
			return blank.Bool;
		return new boolArr(arrA).intersection(arrays).array();
	}
	public static strArr intersection(strArr arrA, strArr... arrays) {
		if (not(arrA) || not(arrays))
			return blank.strArr;
		return arrA.intersection(arrays);
	}
	public static intArr intersection(intArr arrA, intArr... arrays) {
		if (not(arrA) || not(arrays))
			return blank.intArr;
		return arrA.intersection(arrays);
	}
	public static longArr intersection(longArr arrA, longArr... arrays) {
		if (not(arrA) || not(arrays))
			return blank.longArr;
		return arrA.intersection(arrays);
	}
	public static fltArr intersection(fltArr arrA, fltArr... arrays) {
		if (not(arrA) || not(arrays))
			return blank.fltArr;
		return arrA.intersection(arrays);
	}
	public static dblArr intersection(dblArr arrA, dblArr... arrays) {
		if (not(arrA) || not(arrays))
			return blank.dblArr;
		return arrA.intersection(arrays);
	}
	public static boolArr intersection(boolArr arrA, boolArr... arrays) {
		if (not(arrA) || not(arrays))
			return blank.boolArr;
		return arrA.intersection(arrays);
	}
	public static String[] negativeIntersection(String[] arrA,
			String[]... arrays) {
		if (not(arrA) || not(arrays))
			return blank.Str;
		return new strArr(arrA).negativeIntersection(arrays).array();
	}
	public static int[] negativeIntersection(int[] arrA, int[]... arrays) {
		if (not(arrA) || not(arrays))
			return blank.Int;
		return new intArr(arrA).negativeIntersection(arrays).array();
	}
	public static long[] negativeIntersection(long[] arrA, long[]... arrays) {
		if (not(arrA) || not(arrays))
			return blank.Long;
		return new longArr(arrA).negativeIntersection(arrays).array();
	}
	public static float[] negativeIntersection(float[] arrA,
			float[]... arrays) {
		if (not(arrA) || not(arrays))
			return blank.Flt;
		return new fltArr(arrA).negativeIntersection(arrays).array();
	}
	public static double[] negativeIntersection(double[] arrA,
			double[]... arrays) {
		if (not(arrA) || not(arrays))
			return blank.Dbl;
		return new dblArr(arrA).negativeIntersection(arrays).array();
	}
	public static boolean[] negativeIntersection(boolean[] arrA,
			boolean[]... arrays) {
		if (not(arrA) || not(arrays))
			return blank.Bool;
		return new boolArr(arrA).negativeIntersection(arrays).array();
	}
	public static strArr negativeIntersection(strArr arrA, strArr... arrays) {
		if (not(arrA) || not(arrays))
			return blank.strArr;
		return arrA.negativeIntersection(arrays);
	}
	public static intArr negativeIntersection(intArr arrA, intArr... arrays) {
		if (not(arrA) || not(arrays))
			return blank.intArr;
		return arrA.negativeIntersection(arrays);
	}
	public static longArr negativeIntersection(longArr arrA,
			longArr... arrays) {
		if (not(arrA) || not(arrays))
			return blank.longArr;
		return arrA.negativeIntersection(arrays);
	}
	public static fltArr negativeIntersection(fltArr arrA, fltArr... arrays) {
		if (not(arrA) || not(arrays))
			return blank.fltArr;
		return arrA.negativeIntersection(arrays);
	}
	public static dblArr negativeIntersection(dblArr arrA, dblArr... arrays) {
		if (not(arrA) || not(arrays))
			return blank.dblArr;
		return arrA.negativeIntersection(arrays);
	}
	public static boolArr negativeIntersection(boolArr arrA,
			boolArr... arrays) {
		if (not(arrA) || not(arrays))
			return blank.boolArr;
		return arrA.negativeIntersection(arrays);
	}
	public static String[] keepIfMatch(String[] arrA, String[]... arrays) {
		return intersection(arrA, arrays);
	}
	public static int[] keepIfMatch(int[] arrA, int[]... arrays) {
		return intersection(arrA, arrays);
	}
	public static long[] keepIfMatch(long[] arrA, long[]... arrays) {
		return intersection(arrA, arrays);
	}
	public static float[] keepIfMatch(float[] arrA, float[]... arrays) {
		return intersection(arrA, arrays);
	}
	public static double[] keepIfMatch(double[] arrA, double[]... arrays) {
		return intersection(arrA, arrays);
	}
	public static boolean[] keepIfMatch(boolean[] arrA, boolean[]... arrays) {
		return intersection(arrA, arrays);
	}
	public static strArr keepIfMatch(strArr arrA, strArr... arrays) {
		return intersection(arrA, arrays);
	}
	public static intArr keepIfMatch(intArr arrA, intArr... arrays) {
		return intersection(arrA, arrays);
	}
	public static longArr keepIfMatch(longArr arrA, longArr... arrays) {
		return intersection(arrA, arrays);
	}
	public static fltArr keepIfMatch(fltArr arrA, fltArr... arrays) {
		return intersection(arrA, arrays);
	}
	public static dblArr keepIfMatch(dblArr arrA, dblArr... arrays) {
		return intersection(arrA, arrays);
	}
	public static boolArr keepIfMatch(boolArr arrA, boolArr... arrays) {
		return intersection(arrA, arrays);
	}
	public static String[] popIfMatch(String[] arrA, String[]... arrays) {
		return negativeIntersection(arrA, arrays);
	}
	public static int[] popIfMatch(int[] arrA, int[]... arrays) {
		return negativeIntersection(arrA, arrays);
	}
	public static long[] popIfMatch(long[] arrA, long[]... arrays) {
		return negativeIntersection(arrA, arrays);
	}
	public static float[] popIfMatch(float[] arrA, float[]... arrays) {
		return negativeIntersection(arrA, arrays);
	}
	public static double[] popIfMatch(double[] arrA, double[]... arrays) {
		return negativeIntersection(arrA, arrays);
	}
	public static boolean[] popIfMatch(boolean[] arrA, boolean[]... arrays) {
		return negativeIntersection(arrA, arrays);
	}
	public static strArr popIfMatch(strArr arrA, strArr... arrays) {
		return negativeIntersection(arrA, arrays);
	}
	public static intArr popIfMatch(intArr arrA, intArr... arrays) {
		return negativeIntersection(arrA, arrays);
	}
	public static longArr popIfMatch(longArr arrA, longArr... arrays) {
		return negativeIntersection(arrA, arrays);
	}
	public static fltArr popIfMatch(fltArr arrA, fltArr... arrays) {
		return negativeIntersection(arrA, arrays);
	}
	public static dblArr popIfMatch(dblArr arrA, dblArr... arrays) {
		return negativeIntersection(arrA, arrays);
	}
	public static boolArr popIfMatch(boolArr arrA, boolArr... arrays) {
		return negativeIntersection(arrA, arrays);
	}
	public static String[] onlyKeep(String[] arrA, String... arrB) {
		if (not(arrA) || not(arrB))
			return blank.Str;
		return intersection(arrA, arrB);
	}
	public static String[] onlyKeep(String[] arrA, int end) {
		if (not(arrA) || not(end) || isInf(end) || isNeg(end))
			return blank.Str;
		return sliceKeep(arrA, end);
	}
	public static int[] onlyKeep(int[] arrA, int... arrB) {
		if (not(arrA) || not(arrB))
			return blank.Int;
		// blank.Int is sugar for new int[]{}
		if (len(arrB) == 1) {
			int end = arrB[0];
			if (not(end) || isInf(end) || isNeg(end))
				return blank.Int;
			return sliceKeep(arrA, end);
		}
		return intersection(arrA, arrB);
	}
	public static long[] onlyKeep(long[] arrA, long... arrB) {
		return intersection(arrA, arrB);
	}
	public static long[] onlyKeep(long[] arrA, int end) {
		if (not(arrA) || not(end) || isInf(end) || isNeg(end))
			return blank.Long;
		return sliceKeep(arrA, end);
	}
	public static float[] onlyKeep(float[] arrA, float... arrB) {
		return intersection(arrA, arrB);
	}
	public static float[] onlyKeep(float[] arrA, int end) {
		if (not(arrA) || not(end) || isInf(end) || isNeg(end))
			return blank.Flt;
		return sliceKeep(arrA, end);
	}
	public static double[] onlyKeep(double[] arrA, double... arrB) {
		return intersection(arrA, arrB);
	}
	public static double[] onlyKeep(double[] arrA, int end) {
		if (not(arrA) || not(end) || isInf(end) || isNeg(end))
			return blank.Dbl;
		return sliceKeep(arrA, end);
	}
	public static boolean[] onlyKeep(boolean[] arrA, boolean... arrB) {
		return intersection(arrA, arrB);
	}
	public static boolean[] onlyKeep(boolean[] arrA, int end) {
		if (not(arrA) || not(end) || isInf(end) || isNeg(end))
			return blank.Bool;
		return sliceKeep(arrA, end);
	}
	public static strArr onlyKeep(strArr arrA, strArr arrB) {
		return intersection(arrA, arrB);
	}
	public static strArr onlyKeep(strArr arrA, int end) {
		if (not(arrA) || not(end) || isInf(end) || isNeg(end))
			return new strArr(blank.Str);
		return sliceKeep(arrA, end);
	}
	public static intArr onlyKeep(intArr arrA, intArr arrB) {
		return intersection(arrA, arrB);
	}
	public static intArr onlyKeep(intArr arrA, int end) {
		if (not(arrA) || not(end) || isInf(end) || isNeg(end))
			return new intArr(blank.Int);
		return sliceKeep(arrA, end);
	}
	public static longArr onlyKeep(longArr arrA, longArr arrB) {
		return intersection(arrA, arrB);
	}
	public static longArr onlyKeep(longArr arrA, int end) {
		if (not(arrA) || not(end) || isInf(end) || isNeg(end))
			return new longArr(blank.Long);
		return sliceKeep(arrA, end);
	}
	public static fltArr onlyKeep(fltArr arrA, fltArr arrB) {
		return intersection(arrA, arrB);
	}
	public static fltArr onlyKeep(fltArr arrA, int end) {
		if (not(arrA) || not(end) || isInf(end) || isNeg(end))
			return new fltArr(blank.Flt);
		return sliceKeep(arrA, end);
	}
	public static dblArr onlyKeep(dblArr arrA, dblArr arrB) {
		return intersection(arrA, arrB);
	}
	public static dblArr onlyKeep(dblArr arrA, int end) {
		if (not(arrA) || not(end) || isInf(end) || isNeg(end))
			return new dblArr(blank.Dbl);
		return sliceKeep(arrA, end);
	}
	public static boolArr onlyKeep(boolArr arrA, boolArr arrB) {
		return intersection(arrA, arrB);
	}
	public static boolArr onlyKeep(boolArr arrA, int end) {
		if (not(arrA) || not(end) || isInf(end) || isNeg(end))
			return new boolArr(blank.Bool);
		return sliceKeep(arrA, end);
	}
	public static String[] negativeIntersection(String[] arrA, String... arrB) {
		strArr result = new strArr(arrA);
		for (int i : range(arrB)) {
			if (in(arrA, arrB[i]))
				result.pop(arrB[i]);
		}
		return result.array();
	}
	public static int[] negativeIntersection(int[] arrA, int... arrB) {
		intArr result = new intArr(arrA);
		for (int i : range(arrB)) {
			if (in(arrA, arrB[i]))
				result.pop(arrB[i]);
		}
		return result.array();
	}
	public static long[] negativeIntersection(long[] arrA, long... arrB) {
		longArr result = new longArr(arrA);
		for (int i : range(arrB)) {
			if (in(arrA, arrB[i]))
				result.pop(arrB[i]);
		}
		return result.array();
	}
	public static float[] negativeIntersection(float[] arrA, float... arrB) {
		fltArr result = new fltArr(arrA);
		for (int i : range(arrB)) {
			if (in(arrA, arrB[i]))
				result.pop(arrB[i]);
		}
		return result.array();
	}
	public static double[] negativeIntersection(double[] arrA, double... arrB) {
		dblArr result = new dblArr(arrA);
		for (int i : range(arrB)) {
			if (in(arrA, arrB[i]))
				result.pop(arrB[i]);
		}
		return result.array();
	}
	public static boolean[] negativeIntersection(boolean[] arrA,
			boolean... arrB) {
		boolArr result = new boolArr(arrA);
		for (int i : range(arrB)) {
			if (in(arrA, arrB[i]))
				result.pop(arrB[i]);
		}
		return result.array();
	}
	public static strArr negativeIntersection(strArr arrA, strArr arrB) {
		return arrA.negativeIntersection(arrB);
	}
	public static intArr negativeIntersection(intArr arrA, intArr arrB) {
		return arrA.negativeIntersection(arrB);
	}
	public static longArr negativeIntersection(longArr arrA, longArr arrB) {
		return arrA.negativeIntersection(arrB);
	}
	public static fltArr negativeIntersection(fltArr arrA, fltArr arrB) {
		return arrA.negativeIntersection(arrB);
	}
	public static dblArr negativeIntersection(dblArr arrA, dblArr arrB) {
		return arrA.negativeIntersection(arrB);
	}
	public static boolArr negativeIntersection(boolArr arrA, boolArr arrB) {
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
	public static strArr popIfMatch(strArr arrA, strArr arrB) {
		return negativeIntersection(arrA, arrB);
	}
	public static intArr popIfMatch(intArr arrA, intArr arrB) {
		return negativeIntersection(arrA, arrB);
	}
	public static longArr popIfMatch(longArr arrA, longArr arrB) {
		return negativeIntersection(arrA, arrB);
	}
	public static fltArr popIfMatch(fltArr arrA, fltArr arrB) {
		return negativeIntersection(arrA, arrB);
	}
	public static dblArr popIfMatch(dblArr arrA, dblArr arrB) {
		return negativeIntersection(arrA, arrB);
	}
	public static boolArr popIfMatch(boolArr arrA, boolArr arrB) {
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
	public static strArr popAll(strArr arrA, strArr arrB) {
		return negativeIntersection(arrA, arrB);
	}
	public static intArr popAll(intArr arrA, intArr arrB) {
		return negativeIntersection(arrA, arrB);
	}
	public static longArr popAll(longArr arrA, longArr arrB) {
		return negativeIntersection(arrA, arrB);
	}
	public static fltArr popAll(fltArr arrA, fltArr arrB) {
		return negativeIntersection(arrA, arrB);
	}
	public static dblArr popAll(dblArr arrA, dblArr arrB) {
		return negativeIntersection(arrA, arrB);
	}
	public static boolArr popAll(boolArr arrA, boolArr arrB) {
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
	public static strArr onlyPop(strArr arrA, strArr... arrays) {
		return negativeIntersection(arrA, arrays);
	}
	public static intArr onlyPop(intArr arrA, intArr... arrays) {
		return negativeIntersection(arrA, arrays);
	}
	public static longArr onlyPop(longArr arrA, longArr... arrays) {
		return negativeIntersection(arrA, arrays);
	}
	public static fltArr onlyPop(fltArr arrA, fltArr... arrays) {
		return negativeIntersection(arrA, arrays);
	}
	public static dblArr onlyPop(dblArr arrA, dblArr... arrays) {
		return negativeIntersection(arrA, arrays);
	}
	public static boolArr onlyPop(boolArr arrA, boolArr... arrays) {
		return negativeIntersection(arrA, arrays);
	}
	public static String upper(String s) {
		s = s.toUpperCase();
		return s;
	}
	public static String[] upper(String... arr) {
		if (not(arr))
			return arr;
		arr = map(arr, KL::upper);
		return arr;
	}
	public static char upper(char c) {
		c = Str(c).toUpperCase().charAt(0);
		return c;
	}
	public static char[] upper(char... arr) {
		if (not(arr))
			return arr;
		arr = map(arr, KL::upper);
		return arr;
	}
	public static String lower(String s) {
		s = s.toLowerCase();
		return s;
	}
	public static String[] lower(String... arr) {
		if (not(arr))
			return arr;
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
		if (not(input))
			return "";
		input = (input.toUpperCase().substring(0, 1)
				+ (!in(input, "[A-Z]{2,}") ? input.toLowerCase() : input)
						.substring(1))
				.replaceAll("(?<!\\w)i(?!\\w)", "I");
		return input;
	}
	public static String[] sentCase(String... inputs) {
		if (not(inputs))
			return blank.Str;
		inputs = map(inputs, KL::sentCase);
		return inputs;
	}
	public static String titleCase(String input) {
		if (not(input))
			return "";
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
			result += c;
		}
		return result;
	}
	public static String[] titleCase(String... inputs) {
		if (not(inputs))
			return blank.Str;
		inputs = map(inputs, KL::titleCase);
		return inputs;
	}
	public static String reverse(String str) {
		if (not(str))
			return "";
		return new StringBuilder(str).reverse().toString();
	}
	public static int len(String str) {
		if (str == null)
			return 0;
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
		if (arr == null)
			return 0;
		return arr.length;
	}
	public static int len(String[] arr) {
		if (arr == null)
			return 0;
		return arr.length;
	}
	public static int len(int[] arr) {
		if (arr == null)
			return 0;
		return arr.length;
	}
	public static int len(long[] arr) {
		if (arr == null)
			return 0;
		return arr.length;
	}
	public static int len(float[] arr) {
		if (arr == null)
			return 0;
		return arr.length;
	}
	public static int len(double[] arr) {
		if (arr == null)
			return 0;
		return arr.length;
	}
	public static int len(boolean[] arr) {
		if (arr == null)
			return 0;
		return arr.length;
	}
	public static int len(Object[] arr) {
		if (arr == null)
			return 0;
		return arr.length;
	}
	public static int len(strArr arr) {
		if (arr == null)
			return 0;
		return arr.length();
	}
	public static int len(intArr arr) {
		if (arr == null)
			return 0;
		return arr.length();
	}
	public static int len(longArr arr) {
		if (arr == null)
			return 0;
		return arr.length();
	}
	public static int len(fltArr arr) {
		if (arr == null)
			return 0;
		return arr.length();
	}
	public static int len(dblArr arr) {
		if (arr == null)
			return 0;
		return arr.length();
	}
	public static int len(boolArr arr) {
		if (arr == null)
			return 0;
		return arr.length();
	}
	public static int len(objS o) {
		if (o == null)
			return 0;
		return o.length();
	}
	public static int len(objI o) {
		if (o == null)
			return 0;
		return o.length();
	}
	public static int len(objL o) {
		if (o == null)
			return 0;
		return o.length();
	}
	public static int len(objF o) {
		if (o == null)
			return 0;
		return o.length();
	}
	public static int len(objD o) {
		if (o == null)
			return 0;
		return o.length();
	}
	public static int len(objB o) {
		if (o == null)
			return 0;
		return o.length();
	}
	public static int len(treeDI t) {
		if (t == null)
			return 0;
		return t.length();
	}
	public static int len(treeI t) {
		if (t == null)
			return 0;
		return t.length();
	}
	public static int len(treeDL t) {
		if (t == null)
			return 0;
		return t.length();
	}
	public static int len(treeL t) {
		if (t == null)
			return 0;
		return t.length();
	}
	public static int len(treeDF t) {
		if (t == null)
			return 0;
		return t.length();
	}
	public static int len(treeF t) {
		if (t == null)
			return 0;
		return t.length();
	}
	public static int len(treeDS t) {
		if (t == null)
			return 0;
		return t.length();
	}
	public static int len(treeD t) {
		if (t == null)
			return 0;
		return t.length();
	}
	public static int len(treeDB t) {
		if (t == null)
			return 0;
		return t.length();
	}
	public static int len(treeB t) {
		if (t == null)
			return 0;
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
	public static int size(strArr arr) {
		return len(arr);
	}
	public static int size(intArr arr) {
		return len(arr);
	}
	public static int size(longArr arr) {
		return len(arr);
	}
	public static int size(fltArr arr) {
		return len(arr);
	}
	public static int size(dblArr arr) {
		return len(arr);
	}
	public static int size(boolArr arr) {
		return len(arr);
	}
	public static int size(objS o) {
		return len(o);
	}
	public static int size(objI o) {
		return len(o);
	}
	public static int size(objL o) {
		return len(o);
	}
	public static int size(objF o) {
		return len(o);
	}
	public static int size(objD o) {
		return len(o);
	}
	public static int size(objB o) {
		return len(o);
	}
	public static int size(treeDI t) {
		return len(t);
	}
	public static int size(treeI t) {
		return len(t);
	}
	public static int size(treeDL t) {
		return len(t);
	}
	public static int size(treeL t) {
		return len(t);
	}
	public static int size(treeDF t) {
		return len(t);
	}
	public static int size(treeF t) {
		return len(t);
	}
	public static int size(treeDS t) {
		return len(t);
	}
	public static int size(treeD t) {
		return len(t);
	}
	public static int size(treeDB t) {
		return len(t);
	}
	public static int size(treeB t) {
		return len(t);
	}
	public static boolean isEmpty(char c) {
		return '\0' == c;
	}
	public static boolean isEmpty(String s) {
		return 0 == len(s);
	}
	public static boolean isEmpty(int n) {
		return 0 == n;
	}
	public static boolean isEmpty(long n) {
		return 0 == n;
	}
	public static boolean isEmpty(float n) {
		return 0 == n;
	}
	public static boolean isEmpty(double n) {
		return 0 == n;
	}
	public static boolean isEmpty(char[] arr) {
		return 0 == len(arr);
	}
	public static boolean isEmpty(char[]... subArrays) {
		int count = 0;
		for (char[] arr : subArrays) {
			if (isEmpty((arr)))
				count++;
		}
		return count > 0;
		// to handle sub arays
	}
	public static boolean isEmpty(String[] arr) {
		return 0 == len(arr);
	}
	public static boolean isEmpty(String[]... subArrays) {
		int count = 0;
		for (String[] arr : subArrays) {
			if (isEmpty((arr)))
				count++;
		}
		return count > 0;
		// to handle sub arays
	}
	public static boolean isEmpty(int[] arr) {
		return 0 == len(arr);
	}
	public static boolean isEmpty(int[]... subArrays) {
		int count = 0;
		for (int[] arr : subArrays) {
			if (isEmpty((arr)))
				count++;
		}
		return count > 0;
		// to handle sub arays
	}
	public static boolean isEmpty(long[] arr) {
		return 0 == len(arr);
	}
	public static boolean isEmpty(long[]... subArrays) {
		int count = 0;
		for (long[] arr : subArrays) {
			if (isEmpty((arr)))
				count++;
		}
		return count > 0;
		// to handle sub arays
	}
	public static boolean isEmpty(float[] arr) {
		return 0 == len(arr);
	}
	public static boolean isEmpty(float[]... subArrays) {
		int count = 0;
		for (float[] arr : subArrays) {
			if (isEmpty((arr)))
				count++;
		}
		return count > 0;
		// to handle sub arays
	}
	public static boolean isEmpty(double[] arr) {
		return 0 == len(arr);
	}
	public static boolean isEmpty(double[]... subArrays) {
		int count = 0;
		for (double[] arr : subArrays) {
			if (isEmpty((arr)))
				count++;
		}
		return count > 0;
		// to handle sub arays
	}
	public static boolean isEmpty(boolean[] arr) {
		return 0 == len(arr);
	}
	public static boolean isEmpty(boolean[]... subArrays) {
		int count = 0;
		for (boolean[] arr : subArrays) {
			if (isEmpty((arr)))
				count++;
		}
		return count > 0;
		// to handle sub arays
	}
	public static boolean isEmpty(Object[] arr) {
		return 0 == len(arr);
	}
	public static boolean isEmpty(Object[]... subArrays) {
		int count = 0;
		for (Object[] arr : subArrays) {
			if (0 == len(arr))
				count++;
		}
		return count > 0;
		// to handle sub arays
	}
	public static boolean isEmpty(strArr arr) {
		return 0 == len(arr) || arr.isEmpty();
	}
	public static boolean isEmpty(intArr arr) {
		return 0 == len(arr) || arr.isEmpty();
	}
	public static boolean isEmpty(longArr arr) {
		return 0 == len(arr) || arr.isEmpty();
	}
	public static boolean isEmpty(fltArr arr) {
		return 0 == len(arr) || arr.isEmpty();
	}
	public static boolean isEmpty(dblArr arr) {
		return 0 == len(arr) || arr.isEmpty();
	}
	public static boolean isEmpty(boolArr arr) {
		return 0 == len(arr) || arr.isEmpty();
	}
	public static boolean isEmpty(objS o) {
		return 0 == len(o) || o.isEmpty();
	}
	public static boolean isEmpty(objI o) {
		return 0 == len(o) || o.isEmpty();
	}
	public static boolean isEmpty(objL o) {
		return 0 == len(o) || o.isEmpty();
	}
	public static boolean isEmpty(objF o) {
		return 0 == len(o) || o.isEmpty();
	}
	public static boolean isEmpty(objD o) {
		return 0 == len(o) || o.isEmpty();
	}
	public static boolean isEmpty(objB o) {
		return 0 == len(o) || o.isEmpty();
	}
	public static boolean isEmpty(treeDI t) {
		return 0 == len(t) || t.isEmpty();
	}
	public static boolean isEmpty(treeI t) {
		return 0 == len(t) || t.isEmpty();
	}
	public static boolean isEmpty(treeDL t) {
		return 0 == len(t) || t.isEmpty();
	}
	public static boolean isEmpty(treeL t) {
		return 0 == len(t) || t.isEmpty();
	}
	public static boolean isEmpty(treeDF t) {
		return 0 == len(t) || t.isEmpty();
	}
	public static boolean isEmpty(treeF t) {
		return 0 == len(t) || t.isEmpty();
	}
	public static boolean isEmpty(treeDS t) {
		return 0 == len(t) || t.isEmpty();
	}
	public static boolean isEmpty(treeD t) {
		return 0 == len(t) || t.isEmpty();
	}
	public static boolean isEmpty(treeDB t) {
		return 0 == len(t) || t.isEmpty();
	}
	public static boolean isEmpty(treeB t) {
		return 0 == len(t) || t.isEmpty();
	}
	public static boolean hasLen(char c) {
		return !isEmpty(c);
	}
	public static boolean hasLen(String s) {
		return !isEmpty(s);
	}
	public static boolean hasLen(int n) {
		return !isEmpty(n);
	}
	public static boolean hasLen(long n) {
		return !isEmpty(n);
	}
	public static boolean hasLen(float n) {
		return !isEmpty(n);
	}
	public static boolean hasLen(double n) {
		return !isEmpty(n);
	}
	public static boolean hasLen(char[] arr) {
		return !isEmpty(arr);
	}
	public static boolean hasLen(char[]... subArrays) {
		return !isEmpty(subArrays);
	}
	public static boolean hasLen(String[] arr) {
		return !isEmpty(arr);
	}
	public static boolean hasLen(String[]... subArrays) {
		return !isEmpty(subArrays);
	}
	public static boolean hasLen(int[] arr) {
		return !isEmpty(arr);
	}
	public static boolean hasLen(int[]... subArrays) {
		return !isEmpty(subArrays);
	}
	public static boolean hasLen(long[] arr) {
		return !isEmpty(arr);
	}
	public static boolean hasLen(long[]... subArrays) {
		return !isEmpty(subArrays);
	}
	public static boolean hasLen(float[] arr) {
		return !isEmpty(arr);
	}
	public static boolean hasLen(float[]... subArrays) {
		return !isEmpty(subArrays);
	}
	public static boolean hasLen(double[] arr) {
		return !isEmpty(arr);
	}
	public static boolean hasLen(double[]... subArrays) {
		return !isEmpty(subArrays);
	}
	public static boolean hasLen(boolean[] arr) {
		return !isEmpty(arr);
	}
	public static boolean hasLen(boolean[]... subArrays) {
		return !isEmpty(subArrays);
	}
	public static boolean hasLen(Object[] arr) {
		return !isEmpty(arr);
	}
	public static boolean hasLen(Object[]... subArrays) {
		return !isEmpty(subArrays);
	}
	public static boolean hasLen(strArr arr) {
		return !isEmpty(arr);
	}
	public static boolean hasLen(intArr arr) {
		return !isEmpty(arr);
	}
	public static boolean hasLen(longArr arr) {
		return !isEmpty(arr);
	}
	public static boolean hasLen(fltArr arr) {
		return !isEmpty(arr);
	}
	public static boolean hasLen(dblArr arr) {
		return !isEmpty(arr);
	}
	public static boolean hasLen(boolArr arr) {
		return !isEmpty(arr);
	}
	public static boolean hasLen(objS o) {
		return !isEmpty(o);
	}
	public static boolean hasLen(objI o) {
		return !isEmpty(o);
	}
	public static boolean hasLen(objL o) {
		return !isEmpty(o);
	}
	public static boolean hasLen(objF o) {
		return !isEmpty(o);
	}
	public static boolean hasLen(objD o) {
		return !isEmpty(o);
	}
	public static boolean hasLen(objB o) {
		return !isEmpty(o);
	}
	public static boolean hasLen(treeDI t) {
		return !isEmpty(t);
	}
	public static boolean hasLen(treeI t) {
		return !isEmpty(t);
	}
	public static boolean hasLen(treeDL t) {
		return !isEmpty(t);
	}
	public static boolean hasLen(treeL t) {
		return !isEmpty(t);
	}
	public static boolean hasLen(treeDF t) {
		return !isEmpty(t);
	}
	public static boolean hasLen(treeF t) {
		return !isEmpty(t);
	}
	public static boolean hasLen(treeDS t) {
		return !isEmpty(t);
	}
	public static boolean hasLen(treeD t) {
		return !isEmpty(t);
	}
	public static boolean hasLen(treeDB t) {
		return !isEmpty(t);
	}
	public static boolean hasLen(treeB t) {
		return !isEmpty(t);
	}
	// Arrays
	public static String type(Object o) {
		if (isNull(o))
			return "null";
		String middleware = o.getClass().toString();
		if (in(middleware, "\\s")) {
			middleware = middleware.split(" ")[1];
			if (in(middleware, "\\["))
				return replace(middleware.replaceAll("\\[", "array\\."), "\\w$",
						m -> {
							if (eq(m, "C"))
								return "char";
							// we'll fix string arrays later
							else if (eq(m, "I"))
								return "int";
							else if (eq(m, "J"))
								return "long";
							// BE CAUTIOUS: For some reason, the long arrays
							// fall under group J memory addresses. Catching I
							// just couldn't work <beware that it's been tested,
							// and failed>. Just so you know, WITH J... IT DOES
							// WORK.
							else if (eq(m, "F"))
								return "flt";
							else if (eq(m, "D"))
								return "dbl";
							else if (eq(m, "Z"))
								return "bool";
							// BE CAUTIOUS: For some reason, the bool arrays
							// fall under group Z memory addresses. Catching I
							// just couldn't work <beware that it's been tested,
							// and failed>. Just so you know, WITH Z... IT DOES
							// WORK.
							return "arr";
						}).replaceAll("Ljava\\.lang\\.|\\;", "")
						.replaceAll("String", "str").replaceAll("Number", "num")
						.replaceAll("Object", "obj");
			return middleware.toLowerCase()
					.replaceAll("(?<=\\w{3,4})arr", "Arr")
					.replaceAll("\\$", "\\.").replaceAll("\\w+\\.", "");
		}
		String result = middleware.split("\\.")[2].toLowerCase();
		// arrays that belong to a class, for instance, Number[], Object[],
		// instead leave a trailing semicolon at the end
		return result;
	}
	public static boolean type(Object obj, String guessedType) {
		if (not(guessedType))
			return false;
		return len(guessedType) < 3
				? startsWith(type(obj), guessedType)
				: in(type(obj), guessedType);
	}
	// ^this one stays too
	public static boolean type(Object src, Object cond1, Runnable sol1,
			Object cond2, Runnable sol2, Object cond3, Runnable sol3,
			Object cond4, Runnable sol4, Object cond5, Runnable sol5,
			Object cond6, Runnable sol6, Object cond7, Runnable sol7,
			Object cond8, Runnable sol8, Object cond9, Runnable sol9,
			Object cond10, Runnable sol10) {
		if (not(src))
			return false;
		return sw(type(src), cond1, sol1, cond2, sol2, cond3, sol3, cond4, sol4,
				cond5, sol5, cond6, sol6, cond7, sol7, cond8, sol8, cond9, sol9,
				cond10, sol10);
	}
	public static boolean type(Object src, Object cond1, Runnable sol1,
			Object cond2, Runnable sol2, Object cond3, Runnable sol3,
			Object cond4, Runnable sol4, Object cond5, Runnable sol5,
			Object cond6, Runnable sol6, Object cond7, Runnable sol7,
			Object cond8, Runnable sol8, Object cond9, Runnable sol9) {
		if (not(src))
			return false;
		return sw(type(src), cond1, sol1, cond2, sol2, cond3, sol3, cond4, sol4,
				cond5, sol5, cond6, sol6, cond7, sol7, cond8, sol8, cond9,
				sol9);
	}
	public static boolean type(Object src, Object cond1, Runnable sol1,
			Object cond2, Runnable sol2, Object cond3, Runnable sol3,
			Object cond4, Runnable sol4, Object cond5, Runnable sol5,
			Object cond6, Runnable sol6, Object cond7, Runnable sol7,
			Object cond8, Runnable sol8) {
		if (not(src))
			return false;
		return sw(type(src), cond1, sol1, cond2, sol2, cond3, sol3, cond4, sol4,
				cond5, sol5, cond6, sol6, cond7, sol7, cond8, sol8);
	}
	public static boolean type(Object src, Object cond1, Runnable sol1,
			Object cond2, Runnable sol2, Object cond3, Runnable sol3,
			Object cond4, Runnable sol4, Object cond5, Runnable sol5,
			Object cond6, Runnable sol6, Object cond7, Runnable sol7) {
		if (not(src))
			return false;
		return sw(type(src), cond1, sol1, cond2, sol2, cond3, sol3, cond4, sol4,
				cond5, sol5, cond6, sol6, cond7, sol7);
	}
	public static boolean type(Object src, Object cond1, Runnable sol1,
			Object cond2, Runnable sol2, Object cond3, Runnable sol3,
			Object cond4, Runnable sol4, Object cond5, Runnable sol5,
			Object cond6, Runnable sol6) {
		if (not(src))
			return false;
		return sw(type(src), cond1, sol1, cond2, sol2, cond3, sol3, cond4, sol4,
				cond5, sol5, cond6, sol6);
	}
	public static boolean type(Object src, Object cond1, Runnable sol1,
			Object cond2, Runnable sol2, Object cond3, Runnable sol3,
			Object cond4, Runnable sol4, Object cond5, Runnable sol5) {
		if (not(src))
			return false;
		return sw(type(src), cond1, sol1, cond2, sol2, cond3, sol3, cond4, sol4,
				cond5, sol5);
	}
	public static boolean type(Object src, Object cond1, Runnable sol1,
			Object cond2, Runnable sol2, Object cond3, Runnable sol3,
			Object cond4, Runnable sol4) {
		if (not(src))
			return false;
		return sw(type(src), cond1, sol1, cond2, sol2, cond3, sol3, cond4,
				sol4);
	}
	public static boolean type(Object src, Object cond1, Runnable sol1,
			Object cond2, Runnable sol2, Object cond3, Runnable sol3) {
		if (not(src))
			return false;
		return sw(type(src), cond1, sol1, cond2, sol2, cond3, sol3);
	}
	public static boolean type(Object src, Object cond1, Runnable sol1,
			Object cond2, Runnable sol2) {
		if (not(src))
			return false;
		return sw(type(src), cond1, sol1, cond2, sol2);
	}
	public static boolean type(Object src, Object cond1, Runnable sol1) {
		if (not(src))
			return false;
		return sw(type(src), cond1, sol1);
	}
	// let's set up some "type"-helpers for the function
	public static String None = "null", Ch, Str = "string", Int = "integer",
			Char = Ch = "character", Long = "long", Flt = "float",
			Dbl = "double", Bool = "boolean", Arr = "array\\.",
			ArrOfChar = "array\\.char", ArrOfStr = "array\\.str",
			ArrOfInt = "array\\.int", ArrOfLong = "array\\.long",
			ArrOfFlt = "array\\.flt", ArrOfDbl = "array\\.dbl",
			ArrOfBool = "array\\.bool", ArrOfNum = "array\\.num",
			ArrOfObj = "array\\.obj", strArr = "strArr", intArr = "intArr",
			longArr = "longArr", fltArr = "fltArr", dblArr = "dblArr",
			boolArr = "boolArr";
	public static char[] charArrToCharArr(Character[] inputArr) {
		if (not(inputArr))
			return blank.Char;
		int length = inputArr.length;
		char resultingArr[] = new char[length];
		for (int i = 0; i < length; i++)
			resultingArr[i] = inputArr[i];
		return resultingArr;
	}
	public static int[] intArrToIntArr(Integer[] inputArr) {
		if (not(inputArr))
			return blank.Int;
		int length = inputArr.length;
		int resultingArr[] = new int[length];
		for (int i = 0; i < length; i++)
			resultingArr[i] = inputArr[i];
		return resultingArr;
	}
	public static long[] longArrToLongArr(Long[] inputArr) {
		if (not(inputArr))
			return blank.Long;
		int length = inputArr.length;
		long resultingArr[] = new long[length];
		for (int i = 0; i < length; i++)
			resultingArr[i] = inputArr[i];
		return resultingArr;
	}
	public static float[] floatArrToFloatArr(Float[] inputArr) {
		if (not(inputArr))
			return blank.Flt;
		int length = inputArr.length;
		float resultingArr[] = new float[length];
		for (int i = 0; i < length; i++)
			resultingArr[i] = inputArr[i];
		return resultingArr;
	}
	public static float[] fltArrToFltArr(Float[] inputArr) {
		return floatArrToFloatArr(inputArr);
	}
	public static double[] dblArrToDblArr(Double[] inputArr) {
		if (not(inputArr))
			return blank.Dbl;
		int length = inputArr.length;
		double resultingArr[] = new double[length];
		for (int i = 0; i < length; i++)
			resultingArr[i] = inputArr[i];
		return resultingArr;
	}
	public static boolean[] boolArrToBoolArr(Boolean[] inputArr) {
		if (not(inputArr))
			return blank.Bool;
		int length = inputArr.length;
		boolean resultingArr[] = new boolean[length];
		for (int i = 0; i < length; i++)
			resultingArr[i] = inputArr[i];
		return resultingArr;
	}
	public static char[] untangle(Character[] inputArr) {
		return charArrToCharArr(inputArr);
	}
	public static int[] untangle(Integer[] inputArr) {
		return intArrToIntArr(inputArr);
	}
	public static long[] untangle(Long[] inputArr) {
		return longArrToLongArr(inputArr);
	}
	public static float[] untangle(Float[] inputArr) {
		return floatArrToFloatArr(inputArr);
	}
	public static double[] untangle(Double[] inputArr) {
		return dblArrToDblArr(inputArr);
	}
	public static boolean[] untangle(Boolean[] inputArr) {
		return boolArrToBoolArr(inputArr);
	}
	public static String[] reverse(String[] arr) {
		return new strArr(arr).reverse().array();
	}
	public static int[] reverse(int[] arr) {
		return new intArr(arr).reverse().array();
	}
	public static long[] reverse(long[] arr) {
		return new longArr(arr).reverse().array();
	}
	public static float[] reverse(float[] arr) {
		return new fltArr(arr).reverse().array();
	}
	public static double[] reverse(double[] arr) {
		return new dblArr(arr).reverse().array();
	}
	public static boolean[] reverse(boolean[] arr) {
		return new boolArr(arr).reverse().array();
	}
	public static strArr reverse(strArr arr) {
		return arr.reverse();
	}
	public static intArr reverse(intArr arr) {
		return arr.reverse();
	}
	public static longArr reverse(longArr arr) {
		return arr.reverse();
	}
	public static fltArr reverse(fltArr arr) {
		return arr.reverse();
	}
	public static dblArr reverse(dblArr arr) {
		return arr.reverse();
	}
	public static boolArr reverse(boolArr arr) {
		return arr.reverse();
	}
	public static String[] sort(String[] arr) {
		return new strArr(arr).sort().array();
	}
	public static String[] sort(String[] arr, String condition) {
		if (not(arr) || not(condition))
			return arr;
		return new strArr(arr).sort(condition).array();
	}
	public static int[] sort(int[] arr) {
		return new intArr(arr).sort().array();
	}
	public static int[] sort(int[] arr, String condition) {
		if (not(arr) || not(condition))
			return arr;
		return new intArr(arr).sort(condition).array();
	}
	public static long[] sort(long[] arr) {
		return new longArr(arr).sort().array();
	}
	public static long[] sort(long[] arr, String condition) {
		if (not(arr) || not(condition))
			return arr;
		return new longArr(arr).sort(condition).array();
	}
	public static float[] sort(float[] arr) {
		return new fltArr(arr).sort().array();
	}
	public static float[] sort(float[] arr, String condition) {
		if (not(arr) || not(condition))
			return arr;
		return new fltArr(arr).sort(condition).array();
	}
	public static double[] sort(double[] arr) {
		return new dblArr(arr).sort().array();
	}
	public static double[] sort(double[] arr, String condition) {
		if (not(arr) || not(condition))
			return arr;
		return new dblArr(arr).sort(condition).array();
	}
	public static boolean[] sort(boolean[] arr) {
		return new boolArr(arr).sort().array();
	}
	public static boolean[] sort(boolean[] arr, String condition) {
		if (not(arr) || not(condition))
			return arr;
		return new boolArr(arr).sort(condition).array();
	}
	public static strArr sort(strArr arr) {
		return arr.sort();
	}
	public static strArr sort(strArr arr, String condition) {
		return new strArr(sort(arr.array(), condition));
	}
	public static intArr sort(intArr arr) {
		return arr.sort();
	}
	public static intArr sort(intArr arr, String condition) {
		if (not(arr) || not(condition))
			return arr;
		return arr.sort(condition);
	}
	public static longArr sort(longArr arr) {
		return arr.sort();
	}
	public static longArr sort(longArr arr, String condition) {
		if (not(arr) || not(condition))
			return arr;
		return arr.sort(condition);
	}
	public static fltArr sort(fltArr arr) {
		return arr.sort();
	}
	public static fltArr sort(fltArr arr, String condition) {
		if (not(arr) || not(condition))
			return arr;
		return arr.sort(condition);
	}
	public static dblArr sort(dblArr arr) {
		return arr.sort();
	}
	public static dblArr sort(dblArr arr, String condition) {
		if (not(arr) || not(condition))
			return arr;
		return arr.sort(condition);
	}
	public static boolArr sort(boolArr arr) {
		return arr.sort();
	}
	public static boolArr sort(boolArr arr, String condition) {
		if (not(arr) || not(condition))
			return arr;
		return arr.sort(condition);
	}
	public static String[] sortReverse(String[] arr) {
		return new strArr(arr).sortReverse().array();
	}
	public static int[] sortReverse(int[] arr) {
		return new intArr(arr).sortReverse().array();
	}
	public static long[] sortReverse(long[] arr) {
		return new longArr(arr).sortReverse().array();
	}
	public static float[] sortReverse(float[] arr) {
		return new fltArr(arr).sortReverse().array();
	}
	public static double[] sortReverse(double[] arr) {
		return new dblArr(arr).sortReverse().array();
	}
	public static boolean[] sortReverse(boolean[] arr) {
		return new boolArr(arr).sortReverse().array();
	}
	public static strArr sortReverse(strArr arr) {
		return arr.sortReverse();
	}
	public static intArr sortReverse(intArr arr) {
		return arr.sortReverse();
	}
	public static longArr sortReverse(longArr arr) {
		return arr.sortReverse();
	}
	public static fltArr sortReverse(fltArr arr) {
		return arr.sortReverse();
	}
	public static dblArr sortReverse(dblArr arr) {
		return arr.sortReverse();
	}
	public static boolArr sortReverse(boolArr arr) {
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
	public static strArr reverseSort(strArr arr) {
		return sortReverse(arr);
	}
	public static intArr reverseSort(intArr arr) {
		return sortReverse(arr);
	}
	public static longArr reverseSort(longArr arr) {
		return sortReverse(arr);
	}
	public static fltArr reverseSort(fltArr arr) {
		return sortReverse(arr);
	}
	public static dblArr reverseSort(dblArr arr) {
		return sortReverse(arr);
	}
	public static boolArr reverseSort(boolArr arr) {
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
	public static strArr shuffle(strArr arr) {
		return arr.shuffle();
	}
	public static intArr shuffle(intArr arr) {
		return arr.shuffle();
	}
	public static longArr shuffle(longArr arr) {
		return arr.shuffle();
	}
	public static fltArr shuffle(fltArr arr) {
		return arr.shuffle();
	}
	public static dblArr shuffle(dblArr arr) {
		return arr.shuffle();
	}
	public static boolArr shuffle(boolArr arr) {
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
			"Zahir Pir", "Zaida", "Zhob", "Ziarat"},
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
					"blocked", "blooded", "decrepit", "dedicated", "defaced",
					"defective", "defenseless", "deluded", "deodorant",
					"departed", "depress", "fretted", "frugal",
					"indiscriminate", "indomitable", "inert", "inflate",
					"inform", "inheriting", "injured", "injurious", "inking",
					"inoffensive", "insane", "insensible", "insidious",
					"insincere", "insistent", "insolent", "insufferable",
					"intemperate", "interdependent", "interesting",
					"interfering", "intern", "interpreted", "intersecting",
					"intolerable", "intolerant", "intuitive", "irresolute",
					"irritate", "jealous", "jerking", "joining", "joint",
					"journalistic", "joyful", "keyed", "knowing", "lacklustre",
					"laden", "lagging", "lamented", "laughable", "layered",
					"leather", "leathern", "leery", "left-footed", "legible",
					"leisure", "lessening", "liberating", "life-size", "lifted",
					"lightest", "limitless", "listening", "literary", "liver",
					"livid", "lobster", "locked", "long-held", "long-lasting",
					"long-running", "oversize", "overworked", "oyster", "paced",
					"panting", "paralyzed", "paramount", "parental", "parted",
					"partisan", "passive", "edible", "eatable", "kissable",
					"palette"},
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
					"Cypriot"},
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
					"+92 (327) 646 3800"},
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
					"Umer Khalid", "Azeem Munawar", "Junaid Bashir",
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
					"Owais Hussain"},
			rglnss = {"Ayesha Waleed", "Fatima Kamal", "Hira Latif",
					"Sana Farooq", "Mahnoor Tariq", "Faiza Tehseem",
					"Fozia Mehshar", "Iqra Siddiqui", "Laiba Aslam",
					"Anum Riaz", "Saba Kiani", "Hafsa Saeed", "Sidra Hashmi",
					"Zunaira Naz", "Sadaf Bhutto", "Kiran Jameel",
					"Rida qAbbas", "Nimra Waseem", "Huma Tariq",
					"Samina Khalid", "Zeenat Rauf", "Amna Waheed",
					"Neelam Hashmi", "Aiman Qamar", "Romaisa Hussain",
					"Fareeda Asif", "Sania Anwar", "Humaisa Khalil",
					"Asma Riaz", "Sadia Kamran", "Sehrish Waseem", "Uzma Tariq",
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
					"Anila Anjum", "Areeba Hussain"},
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
					"Sindhi Muslim Cooperative Housing Society"},
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
					"Success is dependent upon the glands - sweat glands."},
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
					"University of Karachi", "Zia-ud-Din University"},
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
					"administrative services manager", "trapper",
					"travel agent", "travel clerk", "travel guide",
					"tree pruner", "tree trimmer", "trimmer", "truck loader",
					"truck mechanic", "tuner", "turning machine tool operator",
					"tutor", "typist", "umpire", "undertaker", "urban planner",
					"usher", "UX designer", "waiter/ess", "watch repairer",
					"water treatment plant operator", "weaving machine setter",
					"web developer", "weigher", "welder", "wellhead pumper",
					"wholesale buyer", "wildlife photographer",
					"window trimmer", "wood patternmaker", "woodworker",
					"word processor", "writer"};
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
	public static String randEmail(String name) {
		// @params
		// @@name means a chosen name from either array rgynss, or rglnss
		if (not(name) || not(eq(name, "[a-zA-Z]{2,}\\s[a-zA-Z]{2,}")))
			return "";
		String[] names = combine(rgynss, rglnss);
		String randName = randFrom(names);
		String addonA = randFrom(new String[]{".", "_", "-"});
		String addonB = randFrom(new String[]{addonA, ""})
				+ Str(randInt(10, 500));
		String processedName = lower(randName).replaceAll("\\s", addonA)
				+ addonB;
		String[] mailProviders = {"gmail", "yahoo", "hotmail", "outlook",
				"icloud"};
		String provider = randFrom(mailProviders);
		return processedName + "@" + provider + ".com";
	}
	public static String randEmail() {
		return randEmail(randFrom(join(rgynss, rglnss)));
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
			randEmail = randEmail(), randGirlName = randGirlName(),
			randGuyName = randGuyName(), randWord = randWord(),
			randSentence = randSentence();
	public static String name = "Ayesha";
	public static int age = 23;
	public static String _dev = "https://github.com/abbaskhurram255";
	public static obj obj = obj("name", "someone", "age", 23);

	public static void main(String[] args) {

	}
}