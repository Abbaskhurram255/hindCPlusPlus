import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;
import java.util.function.*;
import java.io.*;
import java.security.SecureRandom;
import java.nio.file.*;
import java.text.*;
//GUI
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class KL {
	//GUI
	public static class GUI extends JFrame {
		GUI() {
			super();
			exitOnClose();
			resizable();
			super.setLayout(new BorderLayout());
		}
		GUI(String title) {
			super();
			super.setTitle(title);
		}
		void title(String title) {
			super.setTitle(title);
		}
		void visible() {
			super.setVisible(true);
		}
		void invisible() {
			super.setVisible(false);
		}
		void appear() {
			visible();
		}
		void display() {
			visible();
		}
		void start() {
			visible();
		}
		void disappear() {
			invisible();
		}
		void size(int w, int h) {
			super.setSize(w, h);
		}
		void resizable() {
			super.setResizable(true);
		}
		void notResizable() {
			super.setResizable(true);
		}
		void bg(Color clr) {
			super.setBackground(clr);
		}
		void exitOnClose() {
			super.setDefaultCloseOperation(super.EXIT_ON_CLOSE);
		}

	}


	public static class Label extends JLabel {
		Label() {
			super.setOpaque(true);
		}
		Label(String name) {
			super.setOpaque(true);
		}
		void bg(Color clr) {
			super.setBackground(clr);
		}
		void fg(Color clr) {
			super.setForeground(clr);
		}
		void font(String fontFamily, int fontWidth, int x) {
			super.setFont(new Font(fontFamily, fontWidth, x));
		}
		void alignx(int pos) {
			super.setHorizontalAlignment(pos);
		}
		void aligny(int pos) {
			super.setVerticalAlignment(pos);
		}
		void text(String s) {
			super.setText(s);
		}
	}

	public static class BordLay extends BorderLayout {
		BordLay() {
			super();
		}
	}

	public static class GridLay extends GridLayout {
		GridLay(int rows, int columns) {
			super(rows, columns);
		}
		GridLay(int rows, int columns, int hgap, int vgap) {
			super(rows, columns, hgap, vgap);
		}
	}

	public static class Panel extends JPanel {
		Panel() {
			super();
		}
		void lay(LayoutManager mgr) {
			super.setLayout(mgr);
		}
	}

	//general
	public static class Error extends Exception {
		Error(String msg) {
			super(msg);
		}
	}
	public static class Object_S extends HashMap<String, String> {
		Object_S() {
			super();
		}
		Object_S(String k1, String v1, String k2, String v2, String k3, String v3, String k4, String v4, String k5, String v5) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
		}
		Object_S(String k1, String v1, String k2, String v2, String k3, String v3, String k4, String v4) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
		}
		Object_S(String k1, String v1, String k2, String v2, String k3, String v3) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
		}
		Object_S(String k1, String v1, String k2, String v2) {
			super.put(k1, v1);
			super.put(k2, v2);
		}
		Object_S(String k1, String v1) {
			super.put(k1, v1);
		}
		String key(String k) {
			return super.get(k);
		}
		String k(String k) {
			return super.get(k);
		}
		String val(String k) {
			return super.get(k);
		}
		String v(String k) {
			return super.get(k);
		}
		void add(String k, String v) {
			super.put(k, v);
		}
		String delete (String k) {
			String v = super.get(k);
			super.remove(k);
			return v;
		}
		void push(String k, String v) {
			add(k, v);
		}
		String pop(String k) {
			return delete (k);
		}
		boolean hasKey(String k) {
			return super.containsKey(k);
		}
		boolean hasValue(String v) {
			return super.containsValue(v);
		}
		void set(String k, String v) {
			if (!super.containsKey(k)) super.put(k, v);
			else super.replace(k, v);
		}
		void update(String k, String v) {
			set(k, v);
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
	public static class Object_I extends HashMap<String, Integer> {
		Object_I() {
			super();
		}
		Object_I(String k1, Integer v1, String k2, Integer v2, String k3, Integer v3, String k4, Integer v4, String k5, Integer v5) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
		}
		Object_I(String k1, Integer v1, String k2, Integer v2, String k3, Integer v3, String k4, Integer v4) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
		}
		Object_I(String k1, Integer v1, String k2, Integer v2, String k3, Integer v3) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
		}
		Object_I(String k1, Integer v1, String k2, Integer v2) {
			super.put(k1, v1);
			super.put(k2, v2);
		}
		Object_I(String k, Integer v) {
			super.put(k, v);
		}
		int key(String k) {
			return super.get(k);
		}
		int k(String k) {
			return super.get(k);
		}
		int val(String k) {
			return super.get(k);
		}
		int v(String k) {
			return super.get(k);
		}
		void add(String k, Integer v) {
			super.put(k, v);
		}
		int delete (String k) {
			int v = super.get(k);
			super.remove(k);
			return v;
		}
		void push(String k, int v) {
			add(k, v);
		}
		int pop(String k) {
			return delete (k);
		}
		boolean hasKey(String k) {
			return super.containsKey(k);
		}
		boolean hasValue(Integer v) {
			return super.containsValue(v);
		}
		void set(String k, Integer v) {
			if (!super.containsKey(k)) super.put(k, v);
			else super.replace(k, v);
		}
		void update(String k, Integer v) {
			set(k, v);
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
	public static class Object_L extends HashMap<String, Long> {
		Object_L() {
			super();
		}
		Object_L(String k1, Long v1, String k2, Long v2, String k3, Long v3, String k4, Long v4, String k5, Long v5) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
		}
		Object_L(String k1, Long v1, String k2, Long v2, String k3, Long v3, String k4, Long v4) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
		}
		Object_L(String k1, Long v1, String k2, Long v2, String k3, Long v3) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
		}
		Object_L(String k1, Long v1, String k2, Long v2) {
			super.put(k1, v1);
			super.put(k2, v2);
		}
		Object_L(String k, Long v) {
			super.put(k, v);
		}
		long key(String k) {
			return super.get(k);
		}
		long k(String k) {
			return super.get(k);
		}
		long val(String k) {
			return super.get(k);
		}
		long v(String k) {
			return super.get(k);
		}
		void add(String k, Long v) {
			super.put(k, v);
		}
		long delete (String k) {
			return super.remove(k);
		}
		void push(String k, long v) {
			add(k, v);
		}
		long pop(String k) {
			return delete (k);
		}
		boolean hasKey(String k) {
			return super.containsKey(k);
		}
		boolean hasValue(Long v) {
			return super.containsValue(v);
		}
		void set(String k, Long v) {
			if (!super.containsKey(k)) super.put(k, v);
			else super.replace(k, v);
		}
		void update(String k, Long v) {
			set(k, v);
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
	public static class Object_F extends HashMap<String, Float> {
		Object_F() {
			super();
		}
		Object_F(String k1, Float v1, String k2, Float v2, String k3, Float v3, String k4, Float v4, String k5, Float v5) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
		}
		Object_F(String k1, Float v1, String k2, Float v2, String k3, Float v3, String k4, Float v4) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
		}
		Object_F(String k1, Float v1, String k2, Float v2, String k3, Float v3) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
		}
		Object_F(String k1, Float v1, String k2, Float v2) {
			super.put(k1, v1);
			super.put(k2, v2);
		}
		Object_F(String k1, Float v1) {
			super.put(k1, v1);
		}
		float key(String k) {
			return super.get(k);
		}
		float k(String k) {
			return super.get(k);
		}
		float val(String k) {
			return super.get(k);
		}
		float v(String k) {
			return super.get(k);
		}
		void add(String k, Float v) {
			super.put(k, v);
		}
		float delete (String k) {
			return super.remove(k);
		}
		void push(String k, float v) {
			add(k, v);
		}
		float pop(String k) {
			return delete (k);
		}
		boolean hasKey(String k) {
			return super.containsKey(k);
		}
		boolean hasValue(Float v) {
			return super.containsValue(v);
		}
		void set(String k, Float v) {
			if (!super.containsKey(k)) super.put(k, v);
			else super.replace(k, v);
		}
		void update(String k, Float v) {
			set(k, v);
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
	public static class Object_D extends HashMap<String, Double> {
		Object_D() {
			super();
		}
		Object_D(String k1, Double v1, String k2, Double v2, String k3, Double v3, String k4, Double v4, String k5, Double v5) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
		}
		Object_D(String k1, Double v1, String k2, Double v2, String k3, Double v3, String k4, Double v4) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
		}
		Object_D(String k1, Double v1, String k2, Double v2, String k3, Double v3) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
		}
		Object_D(String k1, Double v1, String k2, Double v2) {
			super.put(k1, v1);
			super.put(k2, v2);
		}
		Object_D(String k, Double v) {
			super.put(k, v);
		}
		double key(String k) {
			return super.get(k);
		}
		double k(String k) {
			return super.get(k);
		}
		double val(String k) {
			return super.get(k);
		}
		double v(String k) {
			return super.get(k);
		}
		void add(String k, Double v) {
			super.put(k, v);
		}
		double delete (String k) {
			return super.remove(k);
		}
		void push(String k, double v) {
			add(k, v);
		}
		double pop(String k) {
			return delete (k);
		}
		boolean hasKey(String k) {
			return super.containsKey(k);
		}
		boolean hasValue(Double v) {
			return super.containsValue(v);
		}
		void set(String k, Double v) {
			if (!super.containsKey(k)) super.put(k, v);
			else super.replace(k, v);
		}
		void update(String k, Double v) {
			set(k, v);
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
	public static class Object_B extends HashMap<String, Boolean> {
		Object_B() {
			super();
		}
		Object_B(String k1, Boolean v1, String k2, Boolean v2, String k3, Boolean v3, String k4, Boolean v4, String k5, Boolean v5) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
		}
		Object_B(String k1, Boolean v1, String k2, Boolean v2, String k3, Boolean v3, String k4, Boolean v4) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
		}
		Object_B(String k1, Boolean v1, String k2, Boolean v2, String k3, Boolean v3) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
		}
		Object_B(String k1, Boolean v1, String k2, Boolean v2) {
			super.put(k1, v1);
			super.put(k2, v2);
		}
		Object_B(String k, Boolean v) {
			super.put(k, v);
		}
		boolean key(String k) {
			return super.get(k);
		}
		boolean k(String k) {
			return super.get(k);
		}
		boolean val(String k) {
			return super.get(k);
		}
		boolean v(String k) {
			return super.get(k);
		}
		void add(String k, Boolean v) {
			super.put(k, v);
		}
		boolean delete (String k) {
			return super.remove(k);
		}
		void push(String k, Boolean v) {
			add(k, v);
		}
		boolean pop(String k) {
			return delete (k);
		}
		boolean hasKey(String k) {
			return super.containsKey(k);
		}
		boolean hasValue(Boolean v) {
			return super.containsValue(v);
		}
		void set(String k, Boolean v) {
			if (!super.containsKey(k)) super.put(k, v);
			else super.replace(k, v);
		}
		void update(String k, Boolean v) {
			set(k, v);
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
	public static class Obj_S extends Object_S {
		Obj_S() {
			super();
		}
		Obj_S(String k1, String v1, String k2, String v2, String k3, String v3, String k4, String v4, String k5, String v5) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
		}
		Obj_S(String k1, String v1, String k2, String v2, String k3, String v3, String k4, String v4) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
		}
		Obj_S(String k1, String v1, String k2, String v2, String k3, String v3) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
		}
		Obj_S(String k1, String v1, String k2, String v2) {
			super.put(k1, v1);
			super.put(k2, v2);
		}
		Obj_S(String k, String v) {
			super.put(k, v);
		}
	}
	public static class Obj_I extends Object_I {
		Obj_I() {
			super();
		}
		Obj_I(String k1, Integer v1, String k2, Integer v2, String k3, Integer v3, String k4, Integer v4, String k5, Integer v5) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
		}
		Obj_I(String k1, Integer v1, String k2, Integer v2, String k3, Integer v3, String k4, Integer v4) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
		}
		Obj_I(String k1, Integer v1, String k2, Integer v2, String k3, Integer v3) {
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
	}
	public static class Obj_L extends Object_L {
		Obj_L() {
			super();
		}
		Obj_L(String k1, Long v1, String k2, Long v2, String k3, Long v3, String k4, Long v4, String k5, Long v5) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
		}
		Obj_L(String k1, Long v1, String k2, Long v2, String k3, Long v3, String k4, Long v4) {
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
	}
	public static class Obj_F extends Object_F {
		Obj_F() {
			super();
		}
		Obj_F(String k1, Float v1, String k2, Float v2, String k3, Float v3, String k4, Float v4, String k5, Float v5) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
		}
		Obj_F(String k1, Float v1, String k2, Float v2, String k3, Float v3, String k4, Float v4) {
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
	}
	public static class Obj_D extends Object_D {
		Obj_D() {
			super();
		}
		Obj_D(String k1, Double v1, String k2, Double v2, String k3, Double v3, String k4, Double v4, String k5, Double v5) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
		}
		Obj_D(String k1, Double v1, String k2, Double v2, String k3, Double v3, String k4, Double v4) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
		}
		Obj_D(String k1, Double v1, String k2, Double v2, String k3, Double v3) {
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
	}
	public static class Obj_B extends Object_B {
		Obj_B() {
			super();
		}
		Obj_B(String k1, Boolean v1, String k2, Boolean v2, String k3, Boolean v3, String k4, Boolean v4, String k5, Boolean v5) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
			super.put(k5, v5);
		}
		Obj_B(String k1, Boolean v1, String k2, Boolean v2, String k3, Boolean v3, String k4, Boolean v4) {
			super.put(k1, v1);
			super.put(k2, v2);
			super.put(k3, v3);
			super.put(k4, v4);
		}
		Obj_B(String k1, Boolean v1, String k2, Boolean v2, String k3, Boolean v3) {
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
	}

	public static class Str_Arr extends ArrayList<String> {
		Str_Arr() {
			super();
		}
		Str_Arr(String... strings) {
			super();
			for (String s : strings) super.add(s);
		}
		void pushAt(int i, String... strings) {
			for (String s : strings) super.add(s);
		}
		void push(String... strings) {
			pushAt(0, strings);
		}
		String shift() {
		    String removed = super.get(0);
		    super.remove(0);
		    return removed;
		}
		boolean pop(boolean... bools) {
			if (super.isEmpty()) return false;
			for (boolean b : bools) {
			    if (!has(b)) return false;
			    super.remove(b);
			}
			return true;
			//return bools[0];
		}
		boolean pop(int... indexes) {
			if (super.isEmpty()) return false;
			for (int i : indexes) {
				if (i < 0 || i > super.size()) return false;
				super.remove(i);
			}
			return true;
			//return super.get(indexes[0]);
		}
		void popEvery(Predicate<? super Boolean> fn) {
		    super.removeIf(fn);
		}
		void popEach(Predicate<? super Boolean> fn) {
		    popEvery(fn);
		}
		void popIf(Predicate<? super Boolean> fn) {
		    popEvery(fn);
		}
		void map(UnaryOperator<Boolean> fn) {
		    super.replaceAll(fn);
		}
		void unique() {
			Object obj = super.clone();
			Collection<?> collection = (Collection<?>) obj;
			Set<Object> set = new LinkedHashSet<>(collection);
			Set<Boolean> uniqueSet = new LinkedHashSet<>();
			for (Object el : set) uniqueSet.add((Boolean) el);
			super.clear();
			super.addAll(uniqueSet);
		}
		boolean has(boolean x) {
			return super.contains(x);
		}
		boolean index(int i) {
			return i >= 0 && i < super.size() ? super.get(i) : false;
		}
		void update(int i, String x) {
			if (!has(x)) super.add(x);
			else super.set(i, x);
		}
		void sort() {
			super.sort(null);
		}
		void sortReverse() {
			super.sort(Collections.reverseOrder());
		}
		void reverseSort() {
			sortReverse();
		}
		void reverse() {
			sortReverse();
		}
		Str_Arr array() {
			return (Str_Arr)(super.toArray())[0];
		}
		String string() {
			return super.toString();
		}
		Str_Arr slice(int x, int y) {
			return (Str_Arr)(super.subList(x, y).toArray())[0];
		}
		Str_Arr copy() {
			return (Str_Arr)super.clone();
		}
		void each(Consumer<? super String> fn) {
			super.forEach(fn);
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
	public static class Int_Arr extends ArrayList<Integer> {
		Int_Arr() {
			super();
		}
		Int_Arr(int... nums) {
			super();
			for (int n : nums) super.add(n);
		}
		void pushAt(int i, boolean... bools) {
			for (boolean b : bools) super.add(b);
		}
		void push(boolean... bools) {
			pushAt(0, bools);
		}
		int shift() {
		    int removed = super.get(0);
		    super.remove(0);
		    return removed;
		}
		boolean pop(boolean... bools) {
			if (super.isEmpty()) return false;
			for (boolean b : bools) {
			    if (!has(b)) return false;
			    super.remove(b);
			}
			return true;
			//return bools[0];
		}
		boolean pop(int... indexes) {
			if (super.isEmpty()) return false;
			for (int i : indexes) {
				if (i < 0 || i > super.size()) return false;
				super.remove(i);
			}
			return true;
			//return super.get(indexes[0]);
		}
		void popEvery(Predicate<? super Boolean> fn) {
		    super.removeIf(fn);
		}
		void popEach(Predicate<? super Boolean> fn) {
		    popEvery(fn);
		}
		void popIf(Predicate<? super Boolean> fn) {
		    popEvery(fn);
		}
		void map(UnaryOperator<Boolean> fn) {
		    super.replaceAll(fn);
		}
		void unique() {
			Object obj = super.clone();
			Collection<?> collection = (Collection<?>) obj;
			Set<Object> set = new LinkedHashSet<>(collection);
			Set<Boolean> uniqueSet = new LinkedHashSet<>();
			for (Object el : set) uniqueSet.add((Boolean) el);
			super.clear();
			super.addAll(uniqueSet);
		}
		boolean has(boolean x) {
			return super.contains(x);
		}
		boolean index(int i) {
			return i >= 0 && i < super.size() ? super.get(i) : false;
		}
		void update(int i, int x) {
			if (!has(x)) super.add(x);
			else super.set(i, x);
		}
		void sort() {
			super.sort(null);
		}
		void sortReverse() {
			super.sort(Collections.reverseOrder());
		}
		void reverseSort() {
			sortReverse();
		}
		void reverse() {
			sortReverse();
		}
		Int_Arr array() {
			return (Int_Arr)(super.toArray())[0];
		}
		String string() {
			return super.toString();
		}
		Int_Arr slice(int x, int y) {
			return (Int_Arr)(super.subList(x, y).toArray())[0];
		}
		Int_Arr copy() {
			return (Int_Arr)super.clone();
		}
		void each(Consumer<? super Integer> fn) {
			super.forEach(fn);
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
	public static class Lng_Arr extends ArrayList<Long> {
		Lng_Arr() {
			super();
		}
		Lng_Arr(long... nums) {
			super();
			for (long n : nums) super.add(n);
		}
		void pushAt(int i, boolean... bools) {
			for (boolean b : bools) super.add(b);
		}
		void push(boolean... bools) {
			pushAt(0, bools);
		}
		long shift() {
		    long removed = super.get(0);
		    super.remove(0);
		    return removed;
		}
		boolean pop(boolean... bools) {
			if (super.isEmpty()) return false;
			for (boolean b : bools) {
			    if (!has(b)) return false;
			    super.remove(b);
			}
			return true;
			//return bools[0];
		}
		boolean pop(int... indexes) {
			if (super.isEmpty()) return false;
			for (int i : indexes) {
				if (i < 0 || i > super.size()) return false;
				super.remove(i);
			}
			return true;
			//return super.get(indexes[0]);
		}
		void popEvery(Predicate<? super Boolean> fn) {
		    super.removeIf(fn);
		}
		void popEach(Predicate<? super Boolean> fn) {
		    popEvery(fn);
		}
		void popIf(Predicate<? super Boolean> fn) {
		    popEvery(fn);
		}
		void map(UnaryOperator<Boolean> fn) {
		    super.replaceAll(fn);
		}
		void unique() {
			Object obj = super.clone();
			Collection<?> collection = (Collection<?>) obj;
			Set<Object> set = new LinkedHashSet<>(collection);
			Set<Boolean> uniqueSet = new LinkedHashSet<>();
			for (Object el : set) uniqueSet.add((Boolean) el);
			super.clear();
			super.addAll(uniqueSet);
		}
		boolean has(boolean x) {
			return super.contains(x);
		}
		boolean index(int i) {
			return i >= 0 && i < super.size() ? super.get(i) : false;
		}
		void update(int i, long x) {
			if (!has(x)) super.add(x);
			else super.set(i, x);
		}
		void sort() {
			super.sort(null);
		}
		void sortReverse() {
			super.sort(Collections.reverseOrder());
		}
		void reverseSort() {
			sortReverse();
		}
		void reverse() {
			sortReverse();
		}
		Lng_Arr array() {
			return (Lng_Arr)(super.toArray())[0];
		}
		String string() {
			return super.toString();
		}
		Lng_Arr slice(int x, int y) {
			return (Lng_Arr)(super.subList(x, y).toArray())[0];
		}
		Lng_Arr copy() {
			return (Lng_Arr)super.clone();
		}
		void each(Consumer<? super Long> fn) {
			super.forEach(fn);
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
	public static class Flt_Arr extends ArrayList<Float> {
		Flt_Arr() {
			super();
		}
		Flt_Arr(float... nums) {
			super();
			for (float n : nums) super.add(n);
		}
		void pushAt(int i, float... floats) {
			for (float f : floats) super.add(f);
		}
		void push(float... floats) {
			pushAt(0, floats);
		}
		float shift() {
		    float removed = super.get(0);
		    super.remove(0);
		    return removed;
		}
		float pop(float... floats) {
			if (super.isEmpty()) return 0;
			for (float f : floats) {
			    if (!has(f)) return 0;
			    super.remove(b);
			}
			return bools[0];
		}
		float pop(int... indexes) {
			float firstRemoved = super.get(indexes[0]);
			if (super.isEmpty()) return 0;
			for (int i : indexes) {
				if (i < 0 || i > super.size()) return 0;
				super.remove(i);
			}
			return firstRemoved;
		}
		void popEvery(Predicate<? super Float> fn) {
		    super.removeIf(fn);
		}
		void popEach(Predicate<? super Float> fn) {
		    popEvery(fn);
		}
		void popIf(Predicate<? super Float> fn) {
		    popEvery(fn);
		}
		void map(UnaryOperator<Float> fn) {
		    super.replaceAll(fn);
		}
		void unique() {
			Object obj = super.clone();
			Collection<?> collection = (Collection<?>) obj;
			Set<Object> set = new LinkedHashSet<>(collection);
			Set<Float> uniqueSet = new LinkedHashSet<>();
			for (Object el : set) uniqueSet.add((Float) el);
			super.clear();
			super.addAll(uniqueSet);
		}
		boolean has(float x) {
			return super.contains(x);
		}
		float index(int i) {
			return i >= 0 && i < super.size() ? super.get(i) : 0;
		}
		void update(int i, float x) {
			if (!has(x)) super.add(x);
			else super.set(i, x);
		}
		void sort() {
			super.sort(null);
		}
		void sortReverse() {
			super.sort(Collections.reverseOrder());
		}
		void reverseSort() {
			sortReverse();
		}
		void reverse() {
			sortReverse();
		}
		Flt_Arr array() {
			return (Flt_Arr)(super.toArray())[0];
		}
		String string() {
			return super.toString();
		}
		Flt_Arr slice(int x, int y) {
			return (Flt_Arr)(super.subList(x, y).toArray())[0];
		}
		Flt_Arr copy() {
			return (Flt_Arr)super.clone();
		}
		void each(Consumer<? super Float> fn) {
			super.forEach(fn);
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
	public static class Dbl_Arr extends ArrayList<Double> {
		Dbl_Arr() {
			super();
		}
		Dbl_Arr(double... nums) {
			super();
			for (double n : nums) super.add(n);
		}
		void pushAt(int i, double... doubles) {
			for (double d : doubles) super.add(d);
		}
		void push(double... doubles) {
			pushAt(0, doubles);
		}
		double shift() {
		    double removed = super.get(0);
		    super.remove(0);
		    return removed;
		}
		double pop(double... doubles) {
			if (super.isEmpty()) return 0;
			for (double d : doubles) {
			    if (!has(d)) return 0;
			    super.remove(d);
			}
			return doubles[0];
		}
		double pop(int... indexes) {
			double firstRemoved = super.get(indexes[0]);
			if (super.isEmpty()) return 0;
			for (int i : indexes) {
				if (i < 0 || i > super.size()) return 0;
				super.remove(i);
			}
			return firstRemoved;
		}
		void popEvery(Predicate<? super Double> fn) {
		    super.removeIf(fn);
		}
		void popEach(Predicate<? super Double> fn) {
		    popEvery(fn);
		}
		void popIf(Predicate<? super Double> fn) {
		    popEvery(fn);
		}
		void map(UnaryOperator<Double> fn) {
		    super.replaceAll(fn);
		}
		void unique() {
			Object obj = super.clone();
			Collection<?> collection = (Collection<?>) obj;
			Set<Object> set = new LinkedHashSet<>(collection);
			Set<Double> uniqueSet = new LinkedHashSet<>();
			for (Object el : set) uniqueSet.add((Double) el);
			super.clear();
			super.addAll(uniqueSet);
		}
		boolean has(double x) {
			return super.contains(x);
		}
		double index(int i) {
			return i >= 0 && i < super.size() ? super.get(i) : 0;
		}
		void update(int i, double x) {
			if (!has(x)) super.add(x);
			else super.set(i, x);
		}
		void sort() {
			super.sort(null);
		}
		void sortReverse() {
			super.sort(Collections.reverseOrder());
		}
		void reverseSort() {
			sortReverse();
		}
		void reverse() {
			sortReverse();
		}
		Dbl_Arr array() {
			return (Dbl_Arr)(super.toArray())[0];
		}
		String string() {
			return super.toString();
		}
		Dbl_Arr slice(int x, int y) {
			return (Dbl_Arr)(super.subList(x, y).toArray())[0];
		}
		Dbl_Arr copy() {
			return (Dbl_Arr)super.clone();
		}
		void each(Consumer<? super Double> fn) {
			super.forEach(fn);
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
	public static class Bool_Arr extends ArrayList<Boolean> {
		Bool_Arr() {
			super();
		}
		Bool_Arr(boolean... bools) {
			super();
			for (boolean b : bools) super.add(b);
		}
		void pushAt(int i, boolean... bools) {
			for (boolean b : bools) super.add(b);
		}
		void push(boolean... bools) {
			pushAt(0, bools);
		}
		boolean shift() {
		    boolean removed = super.get(0);
		    super.remove(0);
		    return removed;
		}
		boolean pop(boolean... bools) {
			if (super.isEmpty()) return false;
			for (boolean b : bools) {
			    if (!has(b)) return false;
			    super.remove(b);
			}
			return true;
		}
		boolean pop(int... indexes) {
			if (super.isEmpty()) return false;
			for (int i : indexes) {
				if (i < 0 || i > super.size()) return false;
				super.remove(i);
			}
			return true;
		}
		void popEvery(Predicate<? super Boolean> fn) {
		    super.removeIf(fn);
		}
		void popEach(Predicate<? super Boolean> fn) {
		    popEvery(fn);
		}
		void popIf(Predicate<? super Boolean> fn) {
		    popEvery(fn);
		}
		void map(UnaryOperator<Boolean> fn) {
		    super.replaceAll(fn);
		}
		void unique() {
			Object obj = super.clone();
			Collection<?> collection = (Collection<?>) obj;
			Set<Object> set = new LinkedHashSet<>(collection);
			Set<Boolean> uniqueSet = new LinkedHashSet<>();
			for (Object el : set) uniqueSet.add((Boolean) el);
			super.clear();
			super.addAll(uniqueSet);
		}
		boolean has(boolean x) {
			return super.contains(x);
		}
		boolean index(int i) {
			return i >= 0 && i < super.size() ? super.get(i) : false;
		}
		void update(int i, boolean x) {
			if (!has(x)) super.add(x);
			else super.set(i, x);
		}
		void sort() {
			super.sort(null);
		}
		void sortReverse() {
			super.sort(Collections.reverseOrder());
		}
		void reverseSort() {
			sortReverse();
		}
		void reverse() {
			sortReverse();
		}
		Bool_Arr array() {
			return (Bool_Arr)(super.toArray())[0];
		}
		String string() {
			return super.toString();
		}
		Bool_Arr slice(int x, int y) {
			return (Bool_Arr)(super.subList(x, y).toArray())[0];
		}
		Bool_Arr copy() {
			return (Bool_Arr)super.clone();
		}
		void each(Consumer<? super Boolean> fn) {
			super.forEach(fn);
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
	public static class Str_Array extends Str_Arr {
		Str_Array() {
			super();
		}
		Str_Array(String... strings) {
			super();
			for (String s : strings) super.add(s);
		}
		Str_Array array() {
			return (Str_Array)(super.toArray())[0];
		}
		Str_Array slice(int x, int y) {
			return (Str_Array)(super.subList(x, y).toArray())[0];
		}
		Str_Array copy() {
			return (Str_Array)super.clone();
		}
	}
	public static class String_Arr extends Str_Arr {
		String_Arr() {
			super();
		}
		String_Arr(String... strings) {
			super();
			for (String s : strings) super.add(s);
		}
		String_Arr array() {
			return (String_Arr)(super.toArray())[0];
		}
		String_Arr slice(int x, int y) {
			return (String_Arr)(super.subList(x, y).toArray())[0];
		}
		String_Arr copy() {
			return (String_Arr)super.clone();
		}
	}
	public static class String_Array extends Str_Arr {
		String_Array() {
			super();
		}
		String_Array(String... strings) {
			super();
			for (String s : strings) super.add(s);
		}
		String_Array array() {
			return (String_Array)(super.toArray())[0];
		}
		String_Array slice(int x, int y) {
			return (String_Array)(super.subList(x, y).toArray())[0];
		}
		String_Array copy() {
			return (String_Array)super.clone();
		}
	}
	public static class Int_Array extends Int_Arr {
		Int_Array() {
			super();
		}
		Int_Array(int... nums) {
			super();
			for (int n : nums) super.add(n);
		}
		Int_Array array() {
			return (Int_Array)(super.toArray())[0];
		}
		Int_Array slice(int x, int y) {
			return (Int_Array)(super.subList(x, y).toArray())[0];
		}
		Int_Array copy() {
			return (Int_Array)super.clone();
		}
	}
	public static class Integer_Arr extends Int_Arr {
		Integer_Arr() {
			super();
		}
		Integer_Arr(int... nums) {
			super();
			for (int n : nums) super.add(n);
		}
		Integer_Arr array() {
			return (Integer_Arr)(super.toArray())[0];
		}
		Integer_Arr slice(int x, int y) {
			return (Integer_Arr)(super.subList(x, y).toArray())[0];
		}
		Integer_Arr copy() {
			return (Integer_Arr)super.clone();
		}
	}
	public static class Integer_Array extends Int_Arr {
		Integer_Array() {
			super();
		}
		Integer_Array(int... nums) {
			super();
			for (int n : nums) super.add(n);
		}
		Integer_Array array() {
			return (Integer_Array)(super.toArray())[0];
		}
		Integer_Array slice(int x, int y) {
			return (Integer_Array)(super.subList(x, y).toArray())[0];
		}
		Integer_Array copy() {
			return (Integer_Array)super.clone();
		}
	}
	public static class Lng_Array extends Lng_Arr {
		Lng_Array() {
			super();
		}
		Lng_Array(long... nums) {
			super();
			for (long n : nums) super.add(n);
		}
		Lng_Array array() {
			return (Lng_Array)(super.toArray())[0];
		}
		Lng_Array slice(int x, int y) {
			return (Lng_Array)(super.subList(x, y).toArray())[0];
		}
		Lng_Array copy() {
			return (Lng_Array)super.clone();
		}
	}
	public static class Long_Arr extends Lng_Arr {
		Long_Arr() {
			super();
		}
		Long_Arr(long... nums) {
			super();
			for (long n : nums) super.add(n);
		}
		Long_Arr array() {
			return (Long_Arr)(super.toArray())[0];
		}
		Long_Arr slice(int x, int y) {
			return (Long_Arr)(super.subList(x, y).toArray())[0];
		}
		Long_Arr copy() {
			return (Long_Arr)super.clone();
		}
	}
	public static class Long_Array extends Lng_Arr {
		Long_Array() {
			super();
		}
		Long_Array(long... nums) {
			super();
			for (long n : nums) super.add(n);
		}
		Long_Array array() {
			return (Long_Array)(super.toArray())[0];
		}
		Long_Array slice(int x, int y) {
			return (Long_Array)(super.subList(x, y).toArray())[0];
		}
		Long_Array copy() {
			return (Long_Array)super.clone();
		}
	}
	public static class Flt_Array extends Flt_Arr {
		Flt_Array() {
			super();
		}
		Flt_Array(float... nums) {
			super();
			for (float n : nums) super.add(n);
		}
		Flt_Array array() {
			return (Flt_Array)(super.toArray())[0];
		}
		Flt_Array slice(int x, int y) {
			return (Flt_Array)(super.subList(x, y).toArray())[0];
		}
		Flt_Array copy() {
			return (Flt_Array)super.clone();
		}
	}
	public static class Float_Arr extends Flt_Arr {
		Float_Arr() {
			super();
		}
		Float_Arr(float... nums) {
			super();
			for (float n : nums) super.add(n);
		}
		Float_Arr array() {
			return (Float_Arr)(super.toArray())[0];
		}
		Float_Arr slice(int x, int y) {
			return (Float_Arr)(super.subList(x, y).toArray())[0];
		}
		Float_Arr copy() {
			return (Float_Arr)super.clone();
		}
	}
	public static class Float_Array extends Flt_Arr {
		Float_Array() {
			super();
		}
		Float_Array(float... nums) {
			super();
			for (float n : nums) super.add(n);
		}
		Float_Array array() {
			return (Float_Array)(super.toArray())[0];
		}
		Float_Array slice(int x, int y) {
			return (Float_Array)(super.subList(x, y).toArray())[0];
		}
		Float_Array copy() {
			return (Float_Array)super.clone();
		}
	}
	public static class Dbl_Array extends Dbl_Arr {
		Dbl_Array() {
			super();
		}
		Dbl_Array(double... nums) {
			super();
			for (double n : nums) super.add(n);
		}
		Dbl_Array array() {
			return (Dbl_Array)(super.toArray())[0];
		}
		Dbl_Array slice(int x, int y) {
			return (Dbl_Array)(super.subList(x, y).toArray())[0];
		}
		Dbl_Array copy() {
			return (Dbl_Array)super.clone();
		}
	}
	public static class Double_Arr extends Dbl_Arr {
		Double_Arr() {
			super();
		}
		Double_Arr(double... nums) {
			super();
			for (double n : nums) super.add(n);
		}
		Double_Arr array() {
			return (Double_Arr)(super.toArray())[0];
		}
		Double_Arr slice(int x, int y) {
			return (Double_Arr)(super.subList(x, y).toArray())[0];
		}
		Double_Arr copy() {
			return (Double_Arr)super.clone();
		}
	}
	public static class Double_Array extends Dbl_Arr {
		Double_Array() {
			super();
		}
		Double_Array(double... nums) {
			super();
			for (double n : nums) super.add(n);
		}
		Double_Array array() {
			return (Double_Array)(super.toArray())[0];
		}
		Double_Array slice(int x, int y) {
			return (Double_Array)(super.subList(x, y).toArray())[0];
		}
		Double_Array copy() {
			return (Double_Array)super.clone();
		}
	}
	public static class Bool_Array extends Bool_Arr {
		Bool_Array() {
			super();
		}
		Bool_Array(boolean... bools) {
			super();
			for (boolean b : bools) super.add(b);
		}
		Bool_Array array() {
			return (Bool_Array)(super.toArray())[0];
		}
		Bool_Array slice(int x, int y) {
			return (Bool_Array)(super.subList(x, y).toArray())[0];
		}
		Bool_Array copy() {
			return (Bool_Array)super.clone();
		}
	}
	public static class Boolean_Arr extends Bool_Arr {
		Boolean_Arr() {
			super();
		}
		Boolean_Arr(boolean... bools) {
			super();
			for (boolean b : bools) super.add(b);
		}
		Boolean_Arr array() {
			return (Boolean_Arr)(super.toArray())[0];
		}
		Boolean_Arr slice(int x, int y) {
			return (Boolean_Arr)(super.subList(x, y).toArray())[0];
		}
		Boolean_Arr copy() {
			return (Boolean_Arr)super.clone();
		}
	}
	public static class Boolean_Array extends Bool_Arr {
		Boolean_Array() {
			super();
		}
		Boolean_Array(boolean... bools) {
			super();
			for (boolean b : bools) super.add(b);
		}
		Boolean_Array array() {
			return (Boolean_Array)(super.toArray())[0];
		}
		Boolean_Array slice(int x, int y) {
			return (Boolean_Array)(super.subList(x, y).toArray())[0];
		}
		Boolean_Array copy() {
			return (Boolean_Array)super.clone();
		}
	}

	public static Int_Arr range(int n) {
		Int_Arr arr = new Int_Arr();
		for (int i = 0; i < n; i++) arr.add(i);
		return arr;
	}
	public static void repeat(Runnable fn, int times) {
		for (; times > 0; times--) new Thread(fn).run();
	}
	public static String repeat(String s, int times) {
		String org = s;
		for (; times > 0; times--) s += org;
		return s;
	}
	public static String repeat(String s) {
		return repeat(s, 1);
	}

	//Date functions
	public static String nthDay(int n) {
		String days[] = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		return days[n];
	}
	public static String nthMonth(int n) {
		String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
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
		dt.setTime(dt.getTime() + (5 * (3600 * 1000))); //fix 5-hour bug
		String date = formattedDate(dt);
		return date;
	}
	public static String now(boolean shortened) {
		if (!shortened) return now();
		String parts[] = now().split(", ");
		parts[0] = slice(parts[0], 0, 3);
		parts[1] = slice(split(parts[1], " ")[0], 0, 3) + " " + split(parts[1], " ")[1];
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
		case "may":
		case "jun":
		case "jul":
		case "aug":
			return "Summer";
		case "sep":
		case "oct":
			return "Spring";
		case "nov":
		case "dec":
		case "jan":
		case "feb":
			return "Winter";
		default:
			return "Fall/Autumn";
		}
	}
	public static String yesterday() {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int)36e5))); //fix 5-hour bug
		dt.setTime(dt.getTime() - ((int)36e5 * 24)); //decrement 24 hours or (3.6*10⁶)*24 milliseconds
		String date = formattedDate(dt);
		String parts[] = date.split(", ");
		date = parts[0] + ", " + parts[1] + ", " + parts[2];
		return date;
	}
	public static String dayBeforeYesterday() {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int)36e5))); //fix 5-hour bug
		dt.setTime(dt.getTime() - ((int)72e5 * 24)); //decrement 48 hours or (7.2*10⁶)*24 milliseconds
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
		dt.setTime(dt.getTime() + (5 * ((int)(36e2 * 1e3)))); //fix 5-hour bug
		dt.setTime(dt.getTime() + ((int)36e5 * 24)); //increment 24 hours or (3.6*10⁶)*24 milliseconds
		String date = formattedDate(dt);
		String parts[] = date.split(", ");
		date = parts[0] + ", " + parts[1] + ", " + parts[2];
		return date;
	}
	public static String dayAfterTomorrow() {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int)36e5))); //fix 5-hour bug
		dt.setTime(dt.getTime() + ((int)72e5 * 24)); //increment 48 hours or (7.2*10⁶)*24 milliseconds
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
		dt.setTime(dt.getTime() + (5 * ((int)36e5))); //fix 5-hour bug
		dt.setMonth(dt.getMonth() - 1); //decrement a month
		String date = formattedDate(dt);
		date = date.split(", ")[1].split(" ")[0];
		return date;
	}
	public static String lastMonthOf(String date) {
		Date dt = new Date(date);
		dt.setTime(dt.getTime() + (5 * ((int)36e5))); //fix 5-hour bug
		dt.setMonth(dt.getMonth() - 1); //decrement a month
		date = formattedDate(dt);
		date = date.split(", ")[1].split(" ")[0];
		return date;
	}
	public static String nextMonth() {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int)36e5))); //fix 5-hour bug
		dt.setMonth(dt.getMonth() + 1); //increment a month
		String date = formattedDate(dt);
		String parts[] = date.split(", ");
		date = date.split(", ")[1].split(" ")[0];
		return date;
	}
	public static String nextMonthOf(String date) {
		Date dt = new Date(date);
		dt.setTime(dt.getTime() + (5 * ((int)36e5))); //fix 5-hour bug
		dt.setMonth(dt.getMonth() + 1); //increment a month
		date = formattedDate(dt);
		String parts[] = date.split(", ");
		date = date.split(", ")[1].split(" ")[0];
		return date;
	}
	public static String lastYear() {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int)36e5))); //fix 5-hour bug
		dt.setYear(dt.getYear() - 1); //decrement a year
		String date = formattedDate(dt);
		String parts[] = date.split(", ");
		date = date.split(", ")[2];
		return date;
	}
	public static String lastYearOf(String date) {
		Date dt = new Date(date);
		dt.setTime(dt.getTime() + (5 * ((int)36e5))); //fix 5-hour bug
		dt.setYear(dt.getYear() - 1); //decrement a year
		date = formattedDate(dt);
		date = date.split(", ")[2];
		return date;
	}
	public static String nextYear() {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int)36e5))); //fix 5-hour bug
		dt.setYear(dt.getYear() + 1); //increment a year
		String date = formattedDate(dt);
		date = date.split(", ")[2];
		return date;
	}
	public static String nextYear(String date) {
		Date dt = new Date(date);
		dt.setTime(dt.getTime() + (5 * ((int)36e5))); //fix 5-hour bug
		dt.setYear(dt.getYear() + 1); //increment a year
		date = formattedDate(dt);
		date = date.split(", ")[2];
		return date;
	}
	public static String age2bday(int age) {
		Date dt = new Date();
		//dt.setTime(dt.getTime()+(5*((int)36e5))); //fix 5-hour bug
		String bday = "" + ((dt.getYear() + 1900) - age); //adding 1900 helps resolve a bug
		return bday;
	}
	public static int bday2age(String date) {
		Date dt = new Date(date);
		dt.setTime(dt.getTime() + (5 * ((int)36e5))); //fix 5-hour bug
		int age = new Date().getYear() - dt.getYear();
		return age;
	}
	public static String date2day(String date) {
		Date dt = new Date(date);
		dt.setTime(dt.getTime() + (5 * ((int)36e5))); //fix 5-hour bug
		date = formattedDate(dt);
		date = date.split(", ")[0];
		return date;
	}
	public static String date2month(String date) {
		Date dt = new Date(date);
		dt.setTime(dt.getTime() + (5 * ((int)36e5))); //fix 5-hour bug
		date = formattedDate(dt);
		date = date.split(", ")[1].split(" ")[0];
		return date;
	}
	public static String timeGreet() {
		String greeting;
		int h = new Date().getHours() + 5; //fix 5-hour bug along the way
		if (h >= 20) greeting = "Good night";
		else if (h >= 16) greeting = "Good evening";
		else if (h >= 12) greeting = "Good afternoon";
		else if (h >= 0 && h <= 4) greeting = "Good new day";
		else greeting = "Good morning";
		return greeting;
	}
	public static String lastOfMonth(int m) {
		Date dt = new Date();
		KL dt2 = new KL();
		dt.setTime(dt.getTime() + (5 * ((int)36e5))); //fix 5-hour bug for better accuracy
		String result = "" + ("" + dt2.nthMonth(m - 1) + " " + new Date(new Date().getYear(), m, 0).getDate());
		return result;
	}
	public static boolean isWeekend() {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int)36e5))); //fix 5-hour bug
		return dt.getDay() % 6 == 0;
	}
	public static boolean isLeapYear() {
		return (1900 + new Date().getYear()) % 4 == 0;
	}
	public static int nextLeapYear() {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int)36e5))); //fix 5-hour bug for better accuracy
		int i = 0;
		if (dt.getYear() % 4 == 0) dt.setYear(dt.getYear() + 1); //ignore current year, if it's leap
		while (dt.getYear() % 4 != 0) {
			dt.setYear((dt.getYear()) + i);
			i++;
		}
		int result = (1900 + dt.getYear()); //comes with a bug fix
		return result;
	}
	public static String dateBefore(int n) {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int)36e5))); //fix 5-hour bug
		dt.setDate(dt.getDate() - Math.abs(n));
		String date = formattedDate(dt);
		String parts[] = date.split(", ");
		date = parts[0] + ", " + parts[1] + ", " + parts[2];
		return date;
	}
	public static String dateAfter(int n) {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int)36e5))); //fix 5-hour bug
		dt.setDate(dt.getDate() + Math.abs(n));
		String date = formattedDate(dt);
		String parts[] = date.split(", ");
		date = parts[0] + ", " + parts[1] + ", " + parts[2];
		return date;
	}
	public static String minsAgo(int n) {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int)36e5))); //fix 5-hour bug
		dt.setTime(dt.getTime() - (n * (int)60e3));
		String time = formattedDate(dt);
		time = time.split(", ")[3];
		return time;
	}
	public static String minsLater(int n) {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int)36e5))); //fix 5-hour bug
		dt.setTime(dt.getTime() + (n * (int)60e3));
		String time = formattedDate(dt);
		time = time.split(", ")[3];
		return time;
	}
	public static String hoursAgo(int n) {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int)36e5))); //first fix the 5-hour bug
		dt.setTime(dt.getTime() - (n * (int)36e5));
		String time = formattedDate(dt);
		time = time.split(", ")[3];
		return time;
	}
	public static String hoursLater(int n) {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int)36e5))); //first fix the 5-hour bug
		dt.setTime(dt.getTime() + (n * (int)36e5));
		String time = formattedDate(dt);
		time = time.split(", ")[3];
		return time;
	}
	public static String nthHour(int n) {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int)36e5))); //fix 5-hour bug
		dt.setTime(dt.getTime() - (int)36e5 * dt.getHours() + (n * (int)36e5));
		String time = formattedDate(dt);
		time = time.split(", ")[3];
		return time;
	}
	public static String date() {
		return now();
	}


	//utilities
	public static void print(String... args) {
		System.out.print("\n");
		String arguments = String.join(" ", args);
		System.out.print(arguments);
	}
	public static void print(int... args) {
		System.out.print("\n");
		for (int arg : args) {
			System.out.print(arg);
		}
	}
	public static void print(char... args) {
		System.out.print("\n");
		for (char arg : args) {
			System.out.print(arg);
		}
	}
	public static void print(long... args) {
		System.out.print("\n");
		for (long arg : args) {
			System.out.print(arg);
		}
	}
	public static void print(float... args) {
		System.out.print("\n");
		for (float arg : args) {
			System.out.print(arg);
		}
	}
	public static void print(double... args) {
		System.out.print("\n");
		for (double arg : args) {
			System.out.print(arg);
		}
	}
	public static void print(boolean... args) {
		System.out.print("\n");
		for (boolean arg : args) {
			System.out.print(arg);
		}
	}
	public static void println(String... args) {
		String arguments = String.join(" ", args);
		System.out.print(arguments);
	}
	public static void println(int... args) {
		for (int arg : args) {
			System.out.print(arg);
		}
	}
	public static void println(char... args) {
		for (char arg : args) {
			System.out.print(arg);
		}
	}
	public static void println(long... args) {
		for (long arg : args) {
			System.out.print(arg);
		}
	}
	public static void println(float... args) {
		for (float arg : args) {
			System.out.print(arg);
		}
	}
	public static void println(double... args) {
		for (double arg : args) {
			System.out.print(arg);
		}
	}
	public static void println(boolean... args) {
		for (boolean arg : args) {
			System.out.print(arg);
		}
	}

	//printing arrays
	public static void printArr(String arr[]) {
		print(Arrays.toString(arr));
	}
	public static void printArr(int arr[]) {
		print(Arrays.toString(arr));
	}
	public static void printArr(Int_Arr arr) {
		print(arr.toString());
	}
	public static void printArr(long arr[]) {
		print(Arrays.toString(arr));
	}
	public static void printArr(float arr[]) {
		print(Arrays.toString(arr));
	}
	public static void printArr(double arr[]) {
		print(Arrays.toString(arr));
	}
	public static void printArr(boolean arr[]) {
		print(Arrays.toString(arr));
	}
	public static void printAll(String arr[]) {
		print(Arrays.toString(arr));
	}
	public static void printAll(int arr[]) {
		print(Arrays.toString(arr));
	}
	public static void printAll(long arr[]) {
		print(Arrays.toString(arr));
	}
	public static void printAll(float arr[]) {
		print(Arrays.toString(arr));
	}
	public static void printAll(double arr[]) {
		print(Arrays.toString(arr));
	}
	public static void printAll(boolean arr[]) {
		print(Arrays.toString(arr));
	}
	public static void printEach(String arr[]) {
		print(Arrays.toString(arr));
	}
	public static void printEach(int arr[]) {
		print(Arrays.toString(arr));
	}
	public static void printEach(long arr[]) {
		print(Arrays.toString(arr));
	}
	public static void printEach(float arr[]) {
		print(Arrays.toString(arr));
	}
	public static void printEach(double arr[]) {
		print(Arrays.toString(arr));
	}
	public static void printEach(boolean arr[]) {
		print(Arrays.toString(arr));
	}

	//getting user input
	public static String scan(String s) {
		print(s);
		Scanner input = new Scanner(System.in);
		String x = input.nextLine();
		return x;
	}
	public static int scani(String s) {
		print(s);
		Scanner input = new Scanner(System.in);
		int x = input.nextInt();
		return x;
	}
	public static long scanl(String s) {
		print(s);
		Scanner input = new Scanner(System.in);
		long x = input.nextLong();
		return x;
	}
	public static float scanf(String s) {
		print(s);
		Scanner input = new Scanner(System.in);
		float x = input.nextFloat();
		return x;
	}
	public static double scand(String s) {
		print(s);
		Scanner input = new Scanner(System.in);
		double x = input.nextDouble();
		return x;
	}
	public static String ask(String s) {
		return scan(s);
	}
	public static int aski(String s) {
		return scani(s);
	}
	public static long askl(String s) {
		return scanl(s);
	}
	public static float askf(String s) {
		return scanf(s);
	}
	public static double askd(String s) {
		return scand(s);
	}
	public static void br(int n) {
		for (; n > 0; n--) print("\n");
	}
	public static void br() {
		br(1);
	}
	public static void next() {
		br(1);
	}
	public static String String(String arg) {
		//if already a string, return as/is
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
	public static char[] Chars(String str) {
		char[] result = str.toCharArray();
		return result;
	}
	public static char Char(String str) {
		char result = Chars(str)[0];
		return result;
	}
	public static char Char(String str, int n) {
		char result = Chars(str)[n];
		return result;
	}
	public static char nthCharOf(String str, int n) {
		char result = Chars(str)[n];
		return result;
	}
	public static char nthLastCharOf(String str, int n) {
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
	public static String[] str2array(String str) {
		String arr[] = {str};
		return arr;
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
	public static boolean eq(String x, String y) {
		return x.equalsIgnoreCase(y);
	}
	public static boolean uneq(String x, String y) {
		return !eq(x, y);
	}


	//numbers
	public static int Int(String arg) {
		try {
			return Integer.parseInt(arg.replaceAll("(?<=\\d)\\.\\d+", ""));
		} catch (Exception err) {
			return 0;
		}
	}
	public static int Int(int n) {
		return n;
	}
	public static int Int(long n) {
		return (int)n;
	}
	public static int Int(float n) {
		return (int)n;
	}
	public static int Int(double n) {
		return (int)n;
	}
	public static float Flt(String arg) {
		try {
			return Float.parseFloat(arg.replaceAll("[^\\d\\.]", ""));
		} catch (Exception err) {
			return 0;
		}
	}
	public static float Flt(int n) {
		return (float)n;
	}
	public static float Flt(long n) {
		return (float)n;
	}
	public static float Flt(float n) {
		return n;
	}
	public static float Flt(double n) {
		return (float)n;
	}
	public static long Lng(String arg) {
		return (long)Flt(arg);
	}
	public static long Lng(int n) {
		return (long)n;
	}
	public static long Lng(long n) {
		return n;
	}
	public static long Lng(float n) {
		return (long)n;
	}
	public static long Lng(double n) {
		return (long)n;
	}
	public static long Long(String arg) {
		return Lng(arg);
	}
	public static double Dbl(String arg) {
		return (double)Flt(arg);
	}
	public static double Dbl(int arg) {
		return (double)arg;
	}
	public static double Dbl(long arg) {
		return (double)arg;
	}
	public static double Dbl(float arg) {
		return (double)arg;
	}
	public static double Dbl(double arg) {
		return arg;
	}
	public static double Double(String arg) {
		return (double)Flt(arg);
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
	public static double sum(double... ns) {
		double acc = 0;
		for (int next = 0; next < ns.length; next++) acc += ns[next];
		return acc;
	}
	public static double diff(double... ns) {
		double acc = ns[0];
		for (int next = 1; next < ns.length; next++) acc -= ns[next];
		return acc;
	}
	public static double prd(double... ns) {
		double acc = ns[0];
		for (int next = 1; next < ns.length; next++) acc *= ns[next];
		return acc;
	}
	public static double quo(double... ns) {
		double acc = ns[0];
		for (int next = 1; next < ns.length; next++) acc /= ns[next];
		return acc;
	}
	public static double pow(double n, double power) {
		return Math.pow(n, power);
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
	public static double rect(double w, double h) {
		return area(w, h);
	}
	public static double tria(double w, double h) {
		return .5 * rect(w, h);
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
	public static double mod(double n1, double n2) {
		if (n2 > n1) {
			//swap
			n1 += n2;
			n2 = n1 - n2;
			n1 -= n2;
		}
		return Math.abs(n1 % n2);
	}
	public static boolean isperfmod(double n1, double n2) {
		return mod(n1, n2) == 0;
	}
	public static Int_Arr divisorsOf(int n) {
		Int_Arr arr = new Int_Arr();
		for (int i = 2; i < n; i++) {
			if (isperfmod(n, i)) arr.add(i);
		}
		return arr;
	}
	public static boolean isDivisorOf(double n1, double n2) {
		return isperfmod(n1, n2);
	}
	public static boolean iseven(double n) {
		return isperfmod(n, 2);
	}
	public static boolean isodd(double n) {
		return !isperfmod(n, 2);
	}
	public static int isprime(int n) {
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0) return 0;
		}
		return 1;
	}
	public static String th(long n) {
		String result = Str(n);
		int size = len(result);
		char seclast_char = size - 2 >= 0 ? result.charAt(size - 2) : '\0';
		char last_char = size - 1 >= 0 ? result.charAt(size - 1) : '\0';
		String last_two = Str(seclast_char) + Str(last_char);
		if (n > 14 && n < 111) {
			switch (last_char) {
			case '1':
				result += "st";
				break;
			case '2':
				result += "nd";
				break;
			case '3':
				result += "rd";
				break;
			default:
				result += "th";
			}
		} else {
			if (eq(last_two, "11") || eq(last_two,  "12") || eq(last_two, "13")) result += "th";
			else {
				switch (last_char) {
				case '1':
					result += "st";
					break;
				case '2':
					result += "nd";
					break;
				case '3':
					result += "rd";
					break;
				default:
					result += "th";
				}
			}
		}
		return result;
	}
	//let's set up some currency variables
	public static double zr = 1e3,
						 lc = 1e5,
						 cr = 1e7,
						 ar = 1e9,
						 kh = 1e11;
	public static double K = 1e3,
						 M = 1e6,
						 B = 1e9,
						 T = 1e12,
						 qd = 1e15,
						 qt = 1e18,
						 sx = 1e21,
						 sp = 1e24,
						 oc = 1e27,
						 nn = 1e30,
						 dc = 1e33;

	public static String fpkr(int amount) {
		double floats = amount % 1;
		long amountFix = Lng(amount - floats);
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
		return replace(stringBuilder.reverse().toString() + "." + sliceToAfter(Str(floats), "."), "(?<=\\.\\d{2})\\d+", "");
	}
	public static String fpkr(long amount) {
		double floats = amount % 1;
		long amountFix = Lng(amount - floats);
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
		return replace(stringBuilder.reverse().toString() + "." + sliceToAfter(Str(floats), "."), "(?<=\\.\\d{2})\\d+", "");
	}
	public static String fpkr(float amount) {
		double floats = amount % 1;
		long amountFix = Lng(amount - floats);
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
		return replace(stringBuilder.reverse().toString() + "." + sliceToAfter(Str(floats), "."), "(?<=\\.\\d{2})\\d+", "");
	}
	public static String fpkr(double amount) {
		double floats = amount % 1;
		long amountFix = Lng(amount - floats);
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
		return replace(stringBuilder.reverse().toString() + "." + sliceToAfter(Str(floats), "."), "(?<=\\.\\d{2})\\d+", "");
	}
	public static String farabic(int n) {
		return NumberFormat.getCurrencyInstance(new Locale.Builder().setLanguage("ar").setRegion("AR").build()).format(n).replaceAll("\\w|٫٠٠$", "").substring(1);
	}
	public static String farabic(long n) {
		return NumberFormat.getCurrencyInstance(new Locale.Builder().setLanguage("ar").setRegion("AR").build()).format(n).replaceAll("\\w|٫٠٠$", "").substring(1);
	}
	public static String farabic(float n) {
		return NumberFormat.getCurrencyInstance(new Locale.Builder().setLanguage("ar").setRegion("AR").build()).format(n).replaceAll("\\w|٫٠٠$", "").substring(1);
	}
	public static String farabic(double n) {
		return NumberFormat.getCurrencyInstance(new Locale.Builder().setLanguage("ar").setRegion("AR").build()).format(n).replaceAll("\\w|٫٠٠$", "").substring(1);
	}
	public static String fintl(int n) {
		return NumberFormat.getCurrencyInstance(new Locale.Builder().setLanguage("en").setRegion("US").build()).format(n).replaceAll("[^\\d\\,\\.]", "");
	}
	public static String fintl(long n) {
		return NumberFormat.getCurrencyInstance(new Locale.Builder().setLanguage("en").setRegion("US").build()).format(n).replaceAll("[^\\d\\,\\.]", "");
	}
	public static String fintl(float n) {
		return NumberFormat.getCurrencyInstance(new Locale.Builder().setLanguage("en").setRegion("US").build()).format(n).replaceAll("[^\\d\\,\\.]", "");
	}
	public static String fintl(double n) {
		return NumberFormat.getCurrencyInstance(new Locale.Builder().setLanguage("en").setRegion("US").build()).format(n).replaceAll("[^\\d\\,\\.]", "");
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
		String formattedN = fintl(n);
		String result = "US$ " + formattedN;
		return result;
	}
	public static String usd(long n) {
		String formattedN = fintl(n);
		String result = "US$ " + formattedN;
		return result;
	}
	public static String usd(float n) {
		String formattedN = fintl(n);
		String result = "US$ " + formattedN;
		return result;
	}
	public static String usd(double n) {
		String formattedN = fintl(n);
		String result = "US$ " + formattedN;
		return result;
	}
	public static String curr(int n, String locale) {
		String formattedN = fintl(n);
		if (startsWith(locale, "pk")) return pkr(n);
		else if (startsWith(locale, "us")) return usd(n);
		else if (len(locale) >= 1 && len(locale) < 4) return locale + " " + formattedN;
		return formattedN;
	}
	public static String curr(long n, String locale) {
		String formattedN = fintl(n);
		if (startsWith(locale, "pk")) return pkr(n);
		else if (startsWith(locale, "us")) return usd(n);
		else if (len(locale) >= 1 && len(locale) < 4) return locale + " " + formattedN;
		return formattedN;
	}
	public static String curr(float n, String locale) {
		String formattedN = fintl(n);
		if (startsWith(locale, "pk")) return pkr(n);
		else if (startsWith(locale, "us")) return usd(n);
		else if (len(locale) >= 1 && len(locale) < 4) return locale + " " + formattedN;
		return formattedN;
	}
	public static String curr(double n, String locale) {
		String formattedN = fintl(n);
		if (startsWith(locale, "pk")) return pkr(n);
		else if (startsWith(locale, "us")) return usd(n);
		else if (len(locale) >= 1 && len(locale) < 4) return upper(locale) + " " + formattedN;
		return formattedN;
	}
	public static String pksuffix(int n) {
		n -= n % 1;
		String formattedN = fpkr(n);
		String[] parts = split(formattedN, ",");
		int size = len(parts);
		if (n < 800 || n > 99 * kh) return formattedN;
		String result = "";
		switch (size) {
		case 1:
		case 2:
			result = Str(n / zr) + "zr";
			break;
		case 3:
			result = Str(n / lc) +  "lc";
			break;
		case 4:
			result = Str(n / cr) +  "cr";
			break;
		case 5:
			result = Str(n / ar) +  "ar";
			break;
		case 6:
			result = Str(n / kh) +  "kh";
			break;
		}
		return result;
	}
	public static String pksuffix(long n) {
		n -= n % 1;
		String formattedN = fpkr(n);
		String[] parts = split(formattedN, ",");
		int size = len(parts);
		if (n < 800 || n > 99 * kh) return formattedN;
		String result = "";
		switch (size) {
		case 1:
		case 2:
			result = Str(n / zr) + "zr";
			break;
		case 3:
			result = Str(n / lc) +  "lc";
			break;
		case 4:
			result = Str(n / cr) +  "cr";
			break;
		case 5:
			result = Str(n / ar) +  "ar";
			break;
		case 6:
			result = Str(n / kh) +  "kh";
			break;
		}
		return result;
	}
	public static String pksuffix(float n) {
		n -= n % 1;
		String formattedN = fpkr(n);
		String[] parts = split(formattedN, ",");
		int size = len(parts);
		if (n < 800 || n > 99 * kh) return formattedN;
		String result = "";
		switch (size) {
		case 1:
		case 2:
			result = Str(n / zr) + "zr";
			break;
		case 3:
			result = Str(n / lc) +  "lc";
			break;
		case 4:
			result = Str(n / cr) +  "cr";
			break;
		case 5:
			result = Str(n / ar) +  "ar";
			break;
		case 6:
			result = Str(n / kh) +  "kh";
			break;
		}
		return result;
	}
	public static String pksuffix(double n) {
		n -= n % 1;
		String formattedN = fpkr(n);
		String[] parts = split(formattedN, ",");
		int size = len(parts);
		if (n < 800 || n > 99 * kh) return formattedN;
		String result = "";
		switch (size) {
		case 1:
		case 2:
			result = Str(n / zr) + "zr";
			break;
		case 3:
			result = Str(n / lc) +  "lc";
			break;
		case 4:
			result = Str(n / cr) +  "cr";
			break;
		case 5:
			result = Str(n / ar) +  "ar";
			break;
		case 6:
			result = Str(n / kh) +  "kh";
			break;
		}
		return result;
	}
	public static String ussuffix(int n) {
		n -= n % 1;
		String formattedN = fintl(n);
		String[] parts = split(formattedN, ",");
		int size = len(parts);
		if (n < 800 || n > 99 * dc) return formattedN;
		String result = "";
		switch (size) {
		case 1:
		case 2:
			result = Str(n / K) + "k";
			break;
		case 3:
			result = Str(n / M) +  "M";
			break;
		case 4:
			result = Str(n / B) +  "B";
			break;
		case 5:
			result = Str(n / T) +  "T";
			break;
		case 6:
			result = Str(n / qd) +  "qd";
			break;
		case 7:
			result = Str(n / qt) +  "qt";
			break;
		case 8:
			result = Str(n / sx) +  "sx";
			break;
		case 9:
			result = Str(n / sp) +  "sp";
			break;
		case 10:
			result = Str(n / oc) +  "oc";
			break;
		case 11:
			result = Str(n / nn) +  "nn";
			break;
		case 12:
			result = Str(n / dc) +  "dc";
			break;
		}
		return result;
	}
	public static String ussuffix(long n) {
		n -= n % 1;
		String formattedN = fintl(n);
		String[] parts = split(formattedN, ",");
		int size = len(parts);
		if (n < 800 || n > 99 * dc) return formattedN;
		String result = "";
		switch (size) {
		case 1:
		case 2:
			result = Str(n / K) + "k";
			break;
		case 3:
			result = Str(n / M) +  "M";
			break;
		case 4:
			result = Str(n / B) +  "B";
			break;
		case 5:
			result = Str(n / T) +  "T";
			break;
		case 6:
			result = Str(n / qd) +  "qd";
			break;
		case 7:
			result = Str(n / qt) +  "qt";
			break;
		case 8:
			result = Str(n / sx) +  "sx";
			break;
		case 9:
			result = Str(n / sp) +  "sp";
			break;
		case 10:
			result = Str(n / oc) +  "oc";
			break;
		case 11:
			result = Str(n / nn) +  "nn";
			break;
		case 12:
			result = Str(n / dc) +  "dc";
			break;
		}
		return result;
	}
	public static String ussuffix(float n) {
		n -= n % 1;
		String formattedN = fintl(n);
		String[] parts = split(formattedN, ",");
		int size = len(parts);
		if (n < 800 || n > 99 * dc) return formattedN;
		String result = "";
		switch (size) {
		case 1:
		case 2:
			result = Str(n / K) + "k";
			break;
		case 3:
			result = Str(n / M) +  "M";
			break;
		case 4:
			result = Str(n / B) +  "B";
			break;
		case 5:
			result = Str(n / T) +  "T";
			break;
		case 6:
			result = Str(n / qd) +  "qd";
			break;
		case 7:
			result = Str(n / qt) +  "qt";
			break;
		case 8:
			result = Str(n / sx) +  "sx";
			break;
		case 9:
			result = Str(n / sp) +  "sp";
			break;
		case 10:
			result = Str(n / oc) +  "oc";
			break;
		case 11:
			result = Str(n / nn) +  "nn";
			break;
		case 12:
			result = Str(n / dc) +  "dc";
			break;
		}
		return result;
	}
	public static String ussuffix(double n) {
		n -= n % 1;
		String formattedN = fintl(n);
		String[] parts = split(formattedN, ",");
		int size = len(parts);
		if (n < 800 || n > 99 * dc) return formattedN;
		String result = "";
		switch (size) {
		case 1:
		case 2:
			result = Str(n / K) + "k";
			break;
		case 3:
			result = Str(n / M) +  "M";
			break;
		case 4:
			result = Str(n / B) +  "B";
			break;
		case 5:
			result = Str(n / T) +  "T";
			break;
		case 6:
			result = Str(n / qd) +  "qd";
			break;
		case 7:
			result = Str(n / qt) +  "qt";
			break;
		case 8:
			result = Str(n / sx) +  "sx";
			break;
		case 9:
			result = Str(n / sp) +  "sp";
			break;
		case 10:
			result = Str(n / oc) +  "oc";
			break;
		case 11:
			result = Str(n / nn) +  "nn";
			break;
		case 12:
			result = Str(n / dc) +  "dc";
			break;
		}
		return result;
	}
	public static int fibonacci(int n) {
		if (n < 2) return n;
		return fibonacci(n - 2) + fibonacci(n - 1);
	}
	public static double pct(double n1, double n2) {
		if (n1 < n2) return Math.round(n1 / n2 * 100.0) / 100.0;
		else return Math.round(n1 * (n2 * .01) * 100.0) / 100.0;
	}
	final static double infinity = Double.POSITIVE_INFINITY;
	public static int round(int n) {
		return n;
	}
	public static long round(long n) {
		return n;
	}
	public static int round(float n) {
		return (int)Math.round(n);
	}
	public static int round(double n) {
		return (int)Math.round(n);
	}
	public static double celciusToFarhenheit(double c) {
		return (double)round(1.8 * c + 32);
	}
	public static double farhenheitToCelcius(double f) {
		return (double)round(((f - 32) * 5) / 9);
	}
	public static double cToF(double c) {
		return celciusToFarhenheit(c);
	}
	public static double fToC(double f) {
		return farhenheitToCelcius(f);
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
	public static boolean both(String... strings) {
		int count = 0;
		for (String s : strings) {
			if (is(s)) count += 1;
		}
		return count == len(strings);
	}
	public static boolean both(int... ints) {
		int count = 0;
		for (int n : ints) {
			if (is(n)) count += 1;
		}
		return count == len(ints);
	}
	public static boolean both(long... longs) {
		int count = 0;
		for (long n : longs) {
			if (is(n)) count += 1;
		}
		return count == len(longs);
	}
	public static boolean both(float... floats) {
		int count = 0;
		for (float n : floats) {
			if (is(n)) count += 1;
		}
		return count == len(floats);
	}
	public static boolean both(double... doubles) {
		int count = 0;
		for (double n : doubles) {
			if (is(n)) count += 1;
		}
		return count == len(doubles);
	}
	public static boolean both(boolean... bools) {
		int count = 0;
		for (boolean bool : bools) {
			if (is(bool)) count += 1;
		}
		return count == len(bools);
	}
	public static boolean either(String... strings) {
		int count = 0;
		for (String s : strings) {
			if (is(s)) count += 1;
		}
		return count > 0;
	}
	public static boolean either(int... ints) {
		int count = 0;
		for (int n : ints) {
			if (is(n)) count += 1;
		}
		return count > 0;
	}
	public static boolean either(long... longs) {
		int count = 0;
		for (long n : longs) {
			if (is(n)) count += 1;
		}
		return count > 0;
	}
	public static boolean either(float... floats) {
		int count = 0;
		for (float n : floats) {
			if (is(n)) count += 1;
		}
		return count > 0;
	}
	public static boolean either(double... doubles) {
		int count = 0;
		for (double n : doubles) {
			if (is(n)) count += 1;
		}
		return count > 0;
	}
	public static boolean either(boolean... bools) {
		int count = 0;
		for (boolean bool : bools) {
			if (is(bool)) count += 1;
		}
		return count > 0;
	}
	public static boolean neither(String... strings) {
		int count = 0;
		for (String s : strings) {
			if (not(s)) count += 1;
		}
		return count == len(strings);
	}
	public static boolean neither(int... ints) {
		int count = 0;
		for (int n : ints) {
			if (not(n)) count += 1;
		}
		return count == len(ints);
	}
	public static boolean neither(long... longs) {
		int count = 0;
		for (long n : longs) {
			if (not(n)) count += 1;
		}
		return count == len(longs);
	}
	public static boolean neither(float... floats) {
		int count = 0;
		for (float n : floats) {
			if (not(n)) count += 1;
		}
		return count == len(floats);
	}
	public static boolean neither(double... doubles) {
		int count = 0;
		for (double n : doubles) {
			if (not(n)) count += 1;
		}
		return count == len(doubles);
	}
	public static boolean neither(boolean... bools) {
		int count = 0;
		for (boolean bool : bools) {
			if (not(bool)) count += 1;
		}
		return count == len(bools);
	}
	public static boolean not(String s) {
		return isEmpty(s);
	}
	public static boolean not(int n) {
		return 0 == n;
	}
	public static boolean not(long n) {
		return 0 == n;
	}
	public static boolean not(float n) {
		return 0 == n;
	}
	public static boolean not(double n) {
		return 0 == n;
	}
	public static boolean not(boolean condition) {
		return !condition;
	}
	public static boolean not(String[] arr) {
		return isEmpty(arr);
	}
	public static boolean not(int[] arr) {
		return isEmpty(arr);
	}
	public static boolean not(long[] arr) {
		return isEmpty(arr);
	}
	public static boolean not(float[] arr) {
		return isEmpty(arr);
	}
	public static boolean not(double[] arr) {
		return isEmpty(arr);
	}
	public static boolean not(boolean[] arr) {
		return isEmpty(arr);
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
	public static boolean xor(boolean a, boolean b) {
		return a || b && !(a && b);
	}
	public static boolean implies(boolean a, boolean b) {
		return a && !b ? false : true;
	}
	public static int randInt() {
		int number = ThreadLocalRandom.current().nextInt(0, 199);
		return number;
	}
	public static int randInt(int end) {
		int number = ThreadLocalRandom.current().nextInt(0, end);
		return number;
	}
	public static int randInt(int start, int end) {
		int number = ThreadLocalRandom.current().nextInt(start, end);
		return number;
	}
	public static double randFlt() {
		double number = randInt() * .3;
		return number;
	}
	public static double randFlt(int end) {
		double number = randInt(end) * .3;
		return number;
	}
	public static double randFlt(int start, int end) {
		double number = randInt(start, end) * .3;
		return number;
	}
	public static String randStr(int len) {
		final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz\\+=";
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
		if (low < 0) low = 0;
		if (high > 127) high = 127;
		return (char)randInt(low, high);
	}
	public static char randChar() {
		return randChar(47, 127);
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
	public static String any(String arr[]) {
		return randItem(arr);
	}
	public static int any(int arr[]) {
		return randItem(arr);
	}
	public static long any(long arr[]) {
		return randItem(arr);
	}
	public static float any(float arr[]) {
		return randItem(arr);
	}
	public static double any(double arr[]) {
		return randItem(arr);
	}
	public static boolean any(boolean arr[]) {
		return randItem(arr);
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
	public static String replace(String str, String to_replace, String regex_to_replace_with) {
		return str.replaceAll(to_replace, regex_to_replace_with);
	}
	public static String replaceOne(String str, String to_replace, String regex_to_replace_with) {
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
	public static Str_Arr slice(Str_Arr arr) {
		return arr.copy();
	}
	public static Int_Arr slice(Int_Arr arr) {
		return arr.copy();
	}
	public static Lng_Arr slice(Lng_Arr arr) {
		return arr.copy();
	}
	public static Flt_Arr slice(Flt_Arr arr) {
		return arr.copy();
	}
	public static Dbl_Arr slice(Dbl_Arr arr) {
		return arr.copy();
	}
	public static Bool_Arr slice(Bool_Arr arr) {
		return arr.copy();
	}
	public static String slice(String str, int start) {
		return str.substring(start, str.length());
	}
	public static String[] slice(String oldArr[], int start) {
		String newArr[] = Arrays.copyOfRange(oldArr.clone(), start, len(oldArr));
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
		double newArr[] = Arrays.copyOfRange(oldArr.clone(), start, len(oldArr));
		return newArr;
	}
	public static boolean[] slice(boolean oldArr[], int start) {
		boolean newArr[] = Arrays.copyOfRange(oldArr.clone(), start, len(oldArr));
		return newArr;
	}
	public static String slice(String str, int start, int end) {
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
	public static String sliceTo(String str, String thatSpecificPart) {
		int index = indexOf(str, thatSpecificPart);
		if (index < 0) return str;
		return slice(str, index);
	}
	public static String sliceToAfter(String str, String thatSpecificPart) {
		int index = indexOf(str, thatSpecificPart);
		if (index < 0) return str;
		String retrievedString = sliceTo(str, thatSpecificPart);
		return slice(retrievedString, len(thatSpecificPart));
	}
	public static boolean startsWith(String strA, String strB) {
		return lower(strA).startsWith(lower(strB));
	}
	public static boolean endsWith(String strA, String strB) {
		return lower(strA).endsWith(lower(strB));
	}
	public static boolean endsWith(String[] arr, String lookupStr) {
		return arr[len(arr) - 1].equals(lookupStr);
	}
	public static boolean endsWith(int[] arr, int lookupInt) {
		return arr[len(arr) - 1] == lookupInt;
	}
	public static boolean endsWith(long[] arr, long lookupLong) {
		return arr[len(arr) - 1] == lookupLong;
	}
	public static boolean endsWith(float[] arr, float lookupFloat) {
		return arr[len(arr) - 1] == lookupFloat;
	}
	public static boolean endsWith(double[] arr, double lookupDbl) {
		return arr[len(arr) - 1] == lookupDbl;
	}
	public static boolean endsWith(boolean[] arr, boolean lookupBool) {
		return arr[len(arr) - 1] == lookupBool;
	}
	public static String nthLastOf(String str, int n) {
		return "" + str.toCharArray()[len(str) - n];
	}
	public static String nthLastOf(String[] arr, int n) {
		return arr[len(arr) - n];
	}
	public static int nthLastOf(int[] arr, int n) {
		return arr[len(arr) - n];
	}
	public static long nthLastOf(long[] arr, int n) {
		return arr[len(arr) - n];
	}
	public static float nthLastOf(float[] arr, int n) {
		return arr[len(arr) - n];
	}
	public static double nthLastOf(double[] arr, int n) {
		return arr[len(arr) - n];
	}
	public static boolean nthLastOf(boolean[] arr, int n) {
		return arr[len(arr) - n];
	}
	public static String secondLastOf(String str) {
		return "" + str.toCharArray()[len(str) - 2];
	}
	public static String secondLastOf(String[] arr) {
		return arr[len(arr) - 2];
	}
	public static int secondLastOf(int[] arr) {
		return arr[len(arr) - 2];
	}
	public static long secondLastOf(long[] arr) {
		return arr[len(arr) - 2];
	}
	public static float secondLastOf(float[] arr) {
		return arr[len(arr) - 2];
	}
	public static double secondLastOf(double[] arr) {
		return arr[len(arr) - 2];
	}
	public static boolean secondLastOf(boolean[] arr) {
		return arr[len(arr) - 2];
	}
	public static String lastOf(String str) {
		return "" + str.toCharArray()[len(str) - 1];
	}
	public static String lastOf(String[] arr) {
		return arr[len(arr) - 1];
	}
	public static int lastOf(int[] arr) {
		return arr[len(arr) - 1];
	}
	public static long lastOf(long[] arr) {
		return arr[len(arr) - 1];
	}
	public static float lastOf(float[] arr) {
		return arr[len(arr) - 1];
	}
	public static double lastOf(double[] arr) {
		return arr[len(arr) - 1];
	}
	public static boolean lastOf(boolean[] arr) {
		return arr[len(arr) - 1];
	}
	public static int indexOf(String inStr, String lookupStr) {
		return inStr.indexOf(lookupStr);
	}
	public static int indexOf(String inStr, char lookupCh) {
		for (int i = 0; i < len(inStr); i++) {
			if (inStr.toCharArray()[i] == lookupCh) return i;
		}
		return -1;
	}
	public static int lastIndexOf(String inStr, String lookupStr) {
		return inStr.lastIndexOf(lookupStr);
	}
	public static int lastIndexOf(String inStr, char lookupCh) {
		for (int i = len(inStr) - 1; i >= 0; i--) {
			if (inStr.toCharArray()[i] == lookupCh) return i;
		}
		return -1;
	}
	public static int indexOf(String[] inStrArr, String lookupStr) {
		for (int i = 0; i < len(inStrArr); i++) {
			if (inStrArr[i].equals(lookupStr)) return i;
		}
		return -1;
	}
	public static int lastIndexOf(String[] inStrArr, String lookupStr) {
		for (int i = len(inStrArr) - 1; i >= 0; i--) {
			if (inStrArr[i].equals(lookupStr)) return i;
		}
		return -1;
	}
	public static int indexOf(int[] inIntArr, int lookupInt) {
		for (int i = 0; i < len(inIntArr); i++) {
			if (inIntArr[i] == lookupInt) return i;
		}
		return -1;
	}
	public static int lastIndexOf(int[] inIntArr, int lookupInt) {
		for (int i = len(inIntArr) - 1; i >= 0; i--) {
			if (inIntArr[i] == lookupInt) return i;
		}
		return -1;
	}
	public static int indexOf(long[] inLongArr, long lookupLong) {
		for (int i = 0; i < len(inLongArr); i++) {
			if (inLongArr[i] == lookupLong) return i;
		}
		return -1;
	}
	public static int lastIndexOf(long[] inLongArr, long lookupLong) {
		for (int i = len(inLongArr) - 1; i >= 0; i--) {
			if (inLongArr[i] == lookupLong) return i;
		}
		return -1;
	}
	public static int indexOf(float[] inFltArr, float lookupFlt) {
		for (int i = 0; i < len(inFltArr); i++) {
			if (inFltArr[i] == lookupFlt) return i;
		}
		return -1;
	}
	public static int lastIndexOf(float[] inFloatArr, float lookupFloat) {
		for (int i = len(inFloatArr) - 1; i >= 0; i--) {
			if (inFloatArr[i] == lookupFloat) return i;
		}
		return -1;
	}
	public static int indexOf(double[] inDblArr, double lookupDbl) {
		for (int i = 0; i < len(inDblArr); i++) {
			if (inDblArr[i] == lookupDbl) return i;
		}
		return -1;
	}
	public static int lastIndexOf(double[] inDblArr, double lookupDbl) {
		for (int i = len(inDblArr) - 1; i >= 0; i--) {
			if (inDblArr[i] == lookupDbl) return i;
		}
		return -1;
	}
	public static int indexOf(boolean[] inBoolArr, boolean lookupBool) {
		for (int i = 0; i < len(inBoolArr); i++) {
			if (inBoolArr[i] == lookupBool) return i;
		}
		return -1;
	}
	public static int lastIndexOf(boolean[] inBoolArr, boolean lookupBool) {
		for (int i = len(inBoolArr) - 1; i >= 0; i--) {
			if (inBoolArr[i] == lookupBool) return i;
		}
		return -1;
	}
	public static int numberOfOccurrencesIn(String inStr, char lookupCh) {
		int occurrences = 0;
		for (int i = 0; i < len(inStr); i++) {
			if (inStr.toCharArray()[i] == lookupCh) occurrences++;
		}
		return occurrences;
	}
	public static int numberOfOccurrencesIn(String inStr, String lookupStr) {
		int occurrences = 0;
		for (int i = 0; i < len(inStr); i++) {
			if (inStr.toCharArray()[i] == lookupStr.charAt(0)) occurrences++;
		}
		return occurrences;
	}
	public static int numberOfOccurrencesIn(String[] inStrArr, String lookupStr) {
		int occurrences = 0;
		for (int i = 0; i < len(inStrArr); i++) {
			if (inStrArr[i].equals(lookupStr)) occurrences++;
		}
		return occurrences;
	}
	public static int numberOfOccurrencesIn(int[] inIntArr, int lookupInt) {
		int occurrences = 0;
		for (int i = 0; i < len(inIntArr); i++) {
			if (inIntArr[i] == lookupInt) occurrences++;
		}
		return occurrences;
	}
	public static int numberOfOccurrencesIn(long[] inLongArr, long lookupLong) {
		int occurrences = 0;
		for (int i = 0; i < len(inLongArr); i++) {
			if (inLongArr[i] == lookupLong) occurrences++;
		}
		return occurrences;
	}
	public static int numberOfOccurrencesIn(float[] inFltArr, float lookupFlt) {
		int occurrences = 0;
		for (int i = 0; i < len(inFltArr); i++) {
			if (inFltArr[i] == lookupFlt) occurrences++;
		}
		return occurrences;
	}
	public static int numberOfOccurrencesIn(double[] inDblArr, double lookupDbl) {
		int occurrences = 0;
		for (int i = 0; i < len(inDblArr); i++) {
			if (inDblArr[i] == lookupDbl) occurrences++;
		}
		return occurrences;
	}
	public static int numberOfOccurrencesIn(boolean[] inBoolArr, boolean lookupBool) {
		int occurrences = 0;
		for (int i = 0; i < len(inBoolArr); i++) {
			if (inBoolArr[i] == lookupBool) occurrences++;
		}
		return occurrences;
	}
	public static boolean in(String inStr, char ch) {
		return indexOf(inStr, ch) >= 0;
	}
	public static boolean in(String strA, String strB) {
		return indexOf(lower(strA), lower(strB)) >= 0;
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
	public static boolean match(String str, String re) {
		return str.toLowerCase().matches(re.toLowerCase());
	}
	public static boolean match(String[] arrA, String[] arrB) {
		return Arrays.compare(arrA, arrB) == 0;
		//returns a negative value if true, just like with most functions in C, or C++
	}
	public static boolean match(int[] arrA, int[] arrB) {
		return Arrays.compare(arrA, arrB) == 0;
		//returns a negative value if true, just like with most functions in C, or C++
	}
	public static boolean match(long[] arrA, long[] arrB) {
		return Arrays.compare(arrA, arrB) == 0;
		//returns a negative value if true, just like with most functions in C, or C++
	}
	public static boolean match(float[] arrA, float[] arrB) {
		return Arrays.compare(arrA, arrB) == 0;
		//returns a negative value if true, just like with most functions in C, or C++
	}
	public static boolean match(double[] arrA, double[] arrB) {
		return Arrays.compare(arrA, arrB) == 0;
		//returns a negative value if true, just like with most functions in C, or C++
	}
	public static boolean match(boolean[] arrA, boolean[] arrB) {
		return Arrays.compare(arrA, arrB) == 0;
		//returns a negative value if true, just like with most functions in C, or C++
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
	public static boolean compare(boolean [] arrA, boolean[] arrB) {
		return match(arrA, arrB);
	}
	public static String[] clone(String[] arr) {
		return arr.clone();
	}
	public static int[] clone(int[] arr) {
		return arr.clone();
	}
	public static long[] clone(long[] arr) {
		return arr.clone();
	}
	public static float[] clone(float[] arr) {
		return arr.clone();
	}
	public static double[] clone(double[] arr) {
		return arr.clone();
	}
	public static boolean[] clone(boolean[] arr) {
		return arr.clone();
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
	public static String upper(String s) {
		s = s.toUpperCase();
		return s;
	}
	public static char upper(char c) {
		c = Str(c).toUpperCase().charAt(0);
		return c;
	}
	public static String lower(String s) {
		s = s.toLowerCase();
		return s;
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
		input = (input.toUpperCase().substring(0, 1) + input.toLowerCase().substring(1)).replaceAll("(?<!\\w)i(?!\\w)", "I");
		return input;
	}
	public static String titleCase(String input) {
		StringBuilder titleCased = new StringBuilder(input.length());
		boolean nextTitleCase = true;
		for (char c : input.toCharArray()) {
			if (Character.isSpaceChar(c)) {
				nextTitleCase = true;
			} else if (nextTitleCase) {
				c = Character.toTitleCase(c);
				nextTitleCase = false;
			}
			titleCased.append(c);
		}
		return titleCased.toString();
	}
	public static String reverse(String str) {
		return new StringBuilder(str).reverse().toString();
	}
	public static int len(String str) {
		return str.length();
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
	public static boolean isEmpty(String s) {
		return 0 == len(s);
	}
	public static boolean isEmpty(int n) {
		return 0 == len(n);
	}
	public static boolean isEmpty(long n) {
		return 0 == len(n);
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

	//Arrays
	public static String[] reverse(String[] data) {
		for (int left = 0, right = data.length - 1; left < right; left++, right--) {
			String temp = data[left];
			data[left]  = data[right];
			data[right] = temp;
		}
		return data;
	}
	public static int[] reverse(int[] data) {
		for (int left = 0, right = data.length - 1; left < right; left++, right--) {
			int temp = data[left];
			data[left]  = data[right];
			data[right] = temp;
		}
		return data;
	}
	public static long[] reverse(long[] data) {
		for (int left = 0, right = data.length - 1; left < right; left++, right--) {
			long temp = data[left];
			data[left]  = data[right];
			data[right] = temp;
		}
		return data;
	}
	public static float[] reverse(float[] data) {
		for (int left = 0, right = data.length - 1; left < right; left++, right--) {
			float temp = data[left];
			data[left]  = data[right];
			data[right] = temp;
		}
		return data;
	}
	public static double[] reverse(double[] data) {
		for (int left = 0, right = data.length - 1; left < right; left++, right--) {
			double temp = data[left];
			data[left]  = data[right];
			data[right] = temp;
		}
		return data;
	}
	public static boolean[] reverse(boolean[] data) {
		for (int left = 0, right = data.length - 1; left < right; left++, right--) {
			boolean temp = data[left];
			data[left]  = data[right];
			data[right] = temp;
		}
		return data;
	}
	public static void sort(String[] arr) {
		Arrays.sort(arr);
	}
	public static void sort(int[] arr) {
		Arrays.sort(arr);
	}
	public static void sort(long[] arr) {
		Arrays.sort(arr);
	}
	public static void sort(float[] arr) {
		Arrays.sort(arr);
	}
	public static void sort(double[] arr) {
		Arrays.sort(arr);
	}
	public static void sortDesc(int arr[]) {
		int size = arr.length;
		for (int i : arr) {
			boolean swappingNeeded = false;
			for (int j = 0; j < size - i - 1; j++) {
				if (arr[j] < arr[j + 1]) {
					swappingNeeded = true;
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			if (!swappingNeeded) break;
		}
	}
	public static void sortDesc(long arr[]) {
		int size = arr.length;
		for (long i : arr) {
			boolean swappingNeeded = false;
			for (int j = 0; j < size - i - 1; j++) {
				if (arr[j] < arr[j + 1]) {
					swappingNeeded = true;
					long temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			if (!swappingNeeded) break;
		}
	}
	public static void sortDesc(float arr[]) {
		int size = arr.length;
		for (float i : arr) {
			boolean swappingNeeded = false;
			for (int j = 0; j < size - i - 1; j++) {
				if (arr[j] < arr[j + 1]) {
					swappingNeeded = true;
					float temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			if (!swappingNeeded) break;
		}
	}
	public static void sortDesc(double arr[]) {
		int size = arr.length;
		for (double i : arr) {
			boolean swappingNeeded = false;
			for (int j = 0; j < size - i - 1; j++) {
				if (arr[j] < arr[j + 1]) {
					swappingNeeded = true;
					double temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			if (!swappingNeeded) break;
		}
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

	private static final String[] ctss = {"Abbottabad", "Adilpur", "Ahmadpur East", "Ahmadpur Sial", "Akora", "Aliabad", "Alik Ghund", "Alipur", "Alizai", "Alpurai", "Aman Garh", "Amirabad", "Arifwala", "Ashanagro Koto", "Athmuqam", "Attock City", "Awaran", "Baddomalhi", "Badin", "Baffa", "Bagarji", "Bagh", "Bahawalnagar", "Bahawalnagar", "Bahawalpur", "Bakhri Ahmad Khan", "Bandhi", "Bannu", "Barishal", "Barkhan", "Basirpur", "Basti Dosa", "Bat Khela", "Battagram", "Begowala", "Bela", "Berani", "Bhag", "Bhakkar", "Bhalwal", "Bhan", "Bhawana", "Bhera", "Bhimbar", "Bhiria", "Bhit Shah", "Bhopalwala", "Bozdar Wada", "Bulri", "Burewala", "Chak", "Chak Azam Sahu", "Chak Five Hundred Seventy-five", "Chak Jhumra", "Chak One Hundred Twenty Nine Left", "Chak Thirty-one -Eleven Left", "Chak Two Hundred Forty-nine Thal Development Authority", "Chakwal", "Chaman", "Chamber", "Charsadda", "Chawinda", "Chenab Nagar", "Cherat Cantonement", "Chhor", "Chichawatni", "Chilas", "Chiniot", "Chishtian", "Chitral", "Choa Saidan Shah", "Chowki Jamali", "Chuchar-kana Mandi", "Chuhar Jamali", "Chunian", "Dadhar", "Dadu", "Daggar", "Daira Din Panah", "Dajal", "Dalbandin", "Dandot RS", "Daromehar", "Darya Khan", "Darya Khan Marri", "Daska Kalan", "Dasu", "Daud Khel", "Daulatpur", "Daultala", "Daur", "Dera Allahyar", "Dera Bugti", "Dera Ghazi Khan", "Dera Ismail Khan", "Dera Murad Jamali", "Dhanot", "Dhaunkal", "Dhoro Naro", "Digri", "Dijkot", "Dinan Bashnoian Wala", "Dinga", "Dipalpur", "Diplo", "Doaba", "Dokri", "Duki", "Dullewala", "Dunga Bunga", "Dunyapur", "Eidgah", "Eminabad", "Faisalabad", "Faqirwali", "Faruka", "Fazilpur", "Fort Abbas", "Gadani", "Gakuch", "Gambat", "Gandava", "Garh Maharaja", "Garhi Khairo", "Garhiyasin", "Ghauspur", "Ghotki", "Gilgit", "Gojra", "Goth Garelo", "Goth Phulji", "Goth Radhan", "Gujar Khan", "Gujranwala", "Gujrat", "Gulishah Kach", "Gwadar", "Hadali", "Hafizabad", "Hala", "Hangu", "Haripur", "Harnai", "Harnoli", "Harunabad", "Hasilpur", "Hattian Bala", "Haveli Lakha", "Havelian", "Hazro City", "Hingorja", "Hujra Shah Muqim", "Hyderabad", "Islamabad", "Islamkot", "Jacobabad", "Jahanian Shah", "Jalalpur Jattan", "Jalalpur Pirwala", "Jampur", "Jamshoro", "Jand", "Jandiala Sher Khan", "Jaranwala", "Jati", "Jatoi Shimali", "Jauharabad", "Jhang City", "Jhang Sadr", "Jhawarian", "Jhelum", "Jhol", "Jiwani", "Johi", "Jam Sahib", "Kabirwala", "Kadhan", "Kahna Nau", "Kahror Pakka", "Kahuta", "Kakad Wari Dir Upper", "Kalabagh", "Kalaswala", "Kalat", "Kaleke Mandi", "Kallar Kahar", "Kalur Kot", "Kamalia", "Kamar Mushani", "Kambar", "Kamoke", "Kamra", "Kandhkot", "Kandiari", "Kandiaro", "Kanganpur", "Karachi", "Karak", "Karaundi", "Kario Ghanwar", "Karor", "Kashmor", "Kasur", "Keshupur", "Keti Bandar", "Khadan Khak", "Khadro", "Khairpur", "Khairpur Mir\'s", "Khairpur Nathan Shah", "Khairpur Tamewah", "Khalabat", "Khandowa", "Khanewal", "Khangah Dogran", "Khangarh", "Khanpur", "Khanpur Mahar", "Kharan", "Kharian", "Khewra", "Khurrianwala", "Khushab", "Khuzdar", "Kohat", "Kohlu", "Kot Addu", "Kot Diji", "Kot Ghulam Muhammad", "Kot Malik Barkhurdar", "Kot Mumin", "Kot Radha Kishan", "Kot Rajkour", "Kot Samaba", "Kot Sultan", "Kotli", "Kotli Loharan", "Kotri", "Kulachi", "Kundian", "Kunjah", "Kunri", "Lachi", "Ladhewala Waraich", "Lahore", "Lakhi", "Lakki", "Lala Musa", "Lalian", "Landi Kotal", "Larkana", "Layyah", "Liliani", "Lodhran", "Loralai", "Mach", "Madeji", "Mailsi", "Malakand", "Malakwal", "Malakwal City", "Malir Cantonment", "Mamu Kanjan", "Mananwala", "Mandi Bahauddin", "Mangla", "Mankera", "Mansehra", "Mardan", "Mastung", "Matiari", "Matli", "Mehar", "Mehmand Chak", "Mehrabpur", "Mian Channun", "Mianke Mor", "Mianwali", "Minchianabad", "Mingora", "Miran Shah", "Miro Khan", "Mirpur Bhtoro", "Mirpur Khas", "Mirpur Mathelo", "Mirpur Sakro", "Mirwah Gorchani", "Mitha Tiwana", "Mithi", "Moro", "Moza Shahwala", "Multan", "Muridke", "Murree", "Musa Khel Bazar", "Mustafabad", "Muzaffargarh", "Muzaffarabad", "Nabisar", "Nankana Sahib", "Narang Mandi", "Narowal", "Nasirabad", "Naudero", "Naukot", "Naushahra Virkan", "Naushahro Firoz", "Nawabshah", "Nazir Town", "New Badah", "New Mirpur", "Noorabad", "Nowshera", "Nowshera Cantonment", "Nushki", "Okara", "Ormara", "Pabbi", "Pad Idan", "Paharpur", "Pakpattan", "Panjgur", "Pano Aqil", "Parachinar", "Pasni", "Pasrur", "Pattoki", "Peshawar", "Phalia", "Pind Dadan Khan", "Pindi Bhattian", "Pindi Gheb", "Pir Jo Goth", "Pir Mahal", "Pishin", "Pithoro", "Qadirpur Ran", "Qila Abdullah", "Qila Saifullah", "Quetta", "Rahim Yar Khan", "Raiwind", "Raja Jang", "Rajanpur", "Rajo Khanani", "Ranipur", "Rasulnagar", "Ratodero", "Rawala Kot", "Rawalpindi", "Renala Khurd", "Risalpur Cantonment", "Rohri", "Rojhan", "Rustam", "Saddiqabad", "Sahiwal", "Sahiwal", "Saidu Sharif", "Sakrand", "Samaro", "Sambrial", "Sanghar", "Sangla Hill", "Sanjwal", "Sann", "Sarai Alamgir", "Sarai Naurang", "Sarai Sidhu", "Sargodha", "Sehwan", "Setharja Old", "Shabqadar", "Shahdad Kot", "Shahdadpur", "Shahkot", "Shahpur", "Shahpur Chakar", "Shahr Sultan", "Shakargarh", "Sharqpur Sharif", "Shekhupura", "Shikarpur", "Shingli Bala", "Shinpokh", "Shorkot", "Shujaabad", "Sialkot", "Sibi", "Sillanwali", "Sinjhoro", "Skardu", "Sobhodero", "Sodhri", "Sohbatpur", "Sukheke Mandi", "Sukkur", "Surab", "Surkhpur", "Swabi", "Sita Road", "Talagang", "Talamba", "Talhar", "Tandlianwala", "Tando Adam", "Tando Allahyar", "Tando Bago", "Tando Jam", "Tando Mitha Khan", "Tando Muhammad Khan", "Tangi", "Tangwani", "Tank", "Taunsa", "Thal", "Tharu Shah", "Thatta", "Thul", "Timargara", "Toba Tek Singh", "Topi", "Turbat", "Ubauro", "Umarkot", "Upper Dir", "Usta Muhammad", "Uthal", "Utmanzai", "Vihari", "Wana", "Warah", "Wazirabad", "Yazman", "Zafarwal", "Zahir Pir", "Zaida", "Zhob", "Ziarat"},
								  wdss = {"Armor", "Barrymore", "Cabot", "Catholicism", "Chihuahua", "Christianity", "Easter", "Frenchman", "Lowry", "Mayor", "Orientalism", "Pharaoh", "Pueblo", "Pullman", "Saturday", "Sister", "Snead", "Syrah", "Tuesday", "Woodward", "abbey", "absence", "absorption", "abstinence", "absurdity", "abundance", "acceptance", "accessibility", "accommodation", "accomplice", "accountability", "accounting", "accreditation", "accuracy", "acquiescence", "acreage", "actress", "actuality", "adage", "adaptation", "adherence", "adjustment", "adoption", "adultery", "advancement", "advert", "advertisement", "advertising", "advice", "aesthetics", "affinity", "aggression", "agriculture", "aircraft", "airtime", "allegation", "allegiance", "allegory", "allergy", "allies", "alligator", "allocation", "allotment", "altercation", "ambulance", "ammonia", "anatomy", "anemia", "ankle", "announcement", "annoyance", "annuity", "anomaly", "anthropology", "anxiety", "apartheid", "apologise", "apostle", "apparatus", "appeasement", "appellation", "appendix", "applause", "appointment", "appraisal", "archery", "archipelago", "architecture", "ardor", "arrears", "arrow", "artisan", "artistry", "ascent", "assembly", "assignment", "association", "asthma", "atheism", "attacker", "attraction", "attractiveness", "auspices", "authority", "avarice", "aversion", "aviation", "babbling", "backlash", "baker", "ballet", "balls", "banjo", "baron", "barrier", "barrister", "bases", "basin", "basis", "battery", "battling", "bedtime", "beginner", "begun", "bending", "bicycle", "billing", "bingo", "biography", "biology", "birthplace", "blackberry", "blather", "blossom", "boardroom", "boasting", "bodyguard", "boldness", "bomber", "bondage", "bonding", "bones", "bonus", "bookmark", "boomer", "booty", "bounds", "bowling", "brainstorming", "breadth", "breaker", "brewer", "brightness", "broccoli", "broth", "brotherhood", "browsing", "brunch", "brunt", "building", "bullion", "bureaucracy", "burglary", "buyout", "by-election", "cabal", "cabbage", "calamity", "campaign", "canonization", "captaincy", "carcass", "carrier", "cartridge", "cassette", "catfish", "caught", "celebrity", "cemetery", "certainty", "certification", "charade", "chasm", "check-in", "cheerleader", "cheesecake", "chemotherapy", "chili", "China", "chivalry", "cholera", "cilantro", "circus", "civilisation", "civility", "clearance", "clearing", "clerk", "climber", "closeness", "clothing", "clutches", "coaster", "coconut", "coding", "collaborator", "colleague", "college", "collision", "colors", "combustion", "comedian", "comer", "commander", "commemoration", "commenter", "commissioner", "commune", "competition", "completeness", "complexity", "computing", "comrade", "concur", "condominium", "conduit", "confidant", "configuration", "confiscation", "conflagration", "conflict", "consist", "consistency", "consolidation", "conspiracy", "constable", "consul", "consultancy", "contentment", "contents", "contractor", "conversation", "cornerstone", "corpus", "correlation", "councilman", "counselor", "countdown", "countryman", "coverage", "covering", "coyote", "cracker", "creator", "criminality", "crocodile", "cropping", "cross-examination", "crossover", "crossroads", "culprit", "cumin", "curator", "curfew", "cursor", "custard", "cutter", "cyclist", "cyclone", "cylinder", "cynicism", "daddy", "damsel", "darkness", "dawning", "daybreak", "dealing", "dedication", "deduction", "defection", "deference", "deficiency", "definition", "deflation", "degeneration", "delegation", "delicacy", "delirium", "deliverance", "demeanor", "demon", "demonstration", "denomination", "dentist", "departure", "depletion", "depression", "designation", "despotism", "detention", "developer", "devolution", "dexterity", "diagnosis", "dialect", "differentiation", "digger", "digress", "dioxide", "diploma", "disability", "disarmament", "discord", "discovery", "dishonesty", "dismissal", "disobedience", "dispatcher", "disservice", "distribution", "distributor", "diver", "diversity", "docking", "dollar", "dominance", "domination", "dominion", "donkey", "doorstep", "doorway", "dossier", "downside", "drafting", "drank", "drilling", "driver", "drumming", "drunkenness", "duchess", "ducking", "dugout", "dumps", "dwelling", "dynamics", "eagerness", "earnestness", "earnings", "eater", "editor", "effectiveness", "electricity", "elements", "eloquence", "emancipation", "embodiment", "embroidery", "emperor", "employment", "encampment", "enclosure", "encouragement", "endangerment", "enlightenment", "enthusiasm", "environment", "environs", "envoy", "epilepsy", "equation", "equator", "error", "espionage", "estimation", "evacuation", "exaggeration", "examination", "exclamation", "expediency", "exploitation", "extinction", "eyewitness", "falls", "fascism", "fastball", "*****", "feedback", "ferocity", "fertilization", "fetish", "finale", "firing", "fixing", "flashing", "flask", "flora", "fluke", "folklore", "follower", "foothold", "footing", "forefinger", "forefront", "forgiveness", "formality", "formation", "formula", "foyer", "fragmentation", "framework", "fraud", "freestyle", "frequency", "friendliness", "fries", "frigate", "fulfillment", "function", "functionality", "fundraiser", "fusion", "futility", "gallantry", "gallery", "genesis", "genitals", "girlfriend", "boyfriend", "glamor", "chemistry", "glitter", "sparkles", "glucose", "sugar", "sugardaddy", "vase", "bracelet", "bra", "neck", "kiss", "pleasure", "google", "grandeur", "grappling", "greens", "gridlock", "grocer", "groundwork", "grouping", "gunman", "gusto", "habitation", "hacker", "hallway", "hamburger", "hammock", "handling", "hands", "handshake", "happiness", "hardship", "headcount", "header", "headquarters", "heads", "headset", "hearth", "hearts", "heath", "hegemony", "height", "hello", "helper", "helping", "helplessness", "hierarchy", "hoarding", "hockey", "homeland", "homer", "honesty", "horror", "horseman", "hostility", "housing", "humility", "hurricane", "iceberg", "ignition", "illness", "illustration", "illustrator", "immunity", "immunization", "imperialism", "imprisonment", "inaccuracy", "inaction", "inactivity", "inauguration", "indecency", "indicator", "inevitability", "infamy", "infiltration", "influx", "iniquity", "innocence", "innovation", "insanity", "inspiration", "instruction", "instructor", "insurer", "interact", "intercession", "intercourse", "intermission", "interpretation", "intersection", "interval", "intolerance", "intruder", "invasion", "investment", "involvement", "irritation", "iteration", "jenny", "jogging", "jones", "joseph", "juggernaut", "juncture", "jurisprudence", "juror", "kangaroo", "kingdom", "knocking", "laborer", "larceny", "laurels", "layout", "leadership", "leasing", "legislation", "leopard", "liberation", "licence", "lifeblood", "lifeline", "ligament", "lighting", "likeness", "line-up", "lineage", "liner", "lineup", "liquidation", "listener", "literature", "litigation", "litre", "loathing", "locality", "lodging", "logic", "longevity", "lookout", "lordship", "lustre", "ma\'am", "machinery", "madness", "magnificence", "mahogany", "mailing", "mainframe", "maintenance", "majority", "manga", "mango", "manifesto", "mantra", "manufacturer", "maple", "martin", "martyrdom", "mathematician", "matrix", "matron", "mayhem", "mayor", "means", "meantime", "measurement", "mechanics", "mediator", "medics", "melodrama", "memory", "mentality", "metaphysics", "method", "meter", "miner", "mirth", "misconception", "misery", "mishap", "misunderstanding", "mobility", "molasses", "momentum", "monarchy", "monument", "morale", "mortality", "motto", "mouthful", "mouthpiece", "mover", "movie", "mowing", "murderer", "musician", "mutation", "mythology", "narration", "narrator", "nationality", "negligence", "neighborhood", "neighbor", "nervousness", "networking", "nexus", "nightmare", "nobility", "nobody", "noodle", "normalcy", "notification", "nourishment", "novella", "nucleus", "nuisance", "nursery", "nutrition", "nylon", "oasis", "obscenity", "obscurity", "observer", "offense", "onslaught", "operation", "opportunity", "opposition", "oracle", "orchestra", "organisation", "organizer", "orientation", "originality", "ounce", "outage", "outcome", "outdoors", "outfield", "outing", "outpost", "outset", "overseer", "owner", "oxygen", "pairing", "panther", "paradox", "parliament", "parsley", "parson", "passenger", "pasta", "patchwork", "pathos", "patriotism", "pendulum", "penguin", "permission", "persona", "perusal", "pessimism", "peter", "philosopher", "phosphorus", "phrasing", "physique", "piles", "plateau", "playing", "plaza", "plethora", "plurality", "pneumonia", "pointer", "poker", "policeman", "polling", "poster", "posterity", "posting", "postponement", "potassium", "pottery", "poultry", "pounding", "pragmatism", "precedence", "precinct", "preoccupation", "pretense", "priesthood", "prisoner", "privacy", "probation", "proceeding", "proceedings", "processing", "processor", "progression", "projection", "prominence", "propensity", "prophecy", "prorogation", "prospectus", "protein", "prototype", "providence", "provider", "provocation", "proximity", "puberty", "publicist", "publicity", "publisher", "pundit", "putting", "quantity", "quart", "quitting", "Chihuahua", "quorum", "racism", "radiance", "ralph", "rancher", "ranger", "rapidity", "rapport", "ratification", "rationality", "reaction", "reader", "reassurance", "rebirth", "receptor", "recipe", "recognition", "recourse", "recreation", "rector", "recurrence", "redemption", "redistribution", "redundancy", "refinery", "reformer", "refrigerator", "regularity", "regulator", "reinforcement", "reins", "reinstatement", "relativism", "relaxation", "rendition", "repayment", "repentance", "repertoire", "repository", "republic", "reputation", "resentment", "residency", "resignation", "restaurant", "resurgence", "retailer", "retention", "retirement", "reviewer", "riches", "righteousness", "roadblock", "robber", "rocks", "rubbing", "runoff", "saloon", "salvation", "sarcasm", "saucer", "savior", "scarcity", "scenario", "scenery", "schism", "scholarship", "schoolboy", "schooner", "scissors", "scolding", "scooter", "scouring", "scrimmage", "scrum", "seating", "sediment", "seduction", "seeder", "seizure", "self-confidence", "self-control", "self-respect", "semicolon", "semiconductor", "semifinal", "senator", "sending", "serenity", "seriousness", "servitude", "sesame", "setup", "sewing", "sharpness", "shoplifting", "shopping", "siding", "sidewalk", "simplicity", "simulation", "sinking", "skate", "sloth", "slugger", "snack", "snail", "snapshot", "snark", "soccer", "solemnity", "solicitation", "solitude", "somewhere", "sophistication", "sorcery", "souvenir", "spaghetti", "specification", "specimen", "specs", "spectacle", "specter", "speculation", "*****", "spoiler", "squad", "squid", "staging", "stagnation", "staircase", "stairway", "stamina", "standpoint", "standstill", "stanza", "statement", "stillness", "stimulus", "stocks", "stole", "stoppage", "story", "storyteller", "stylus", "subcommittee", "subscription", "subsidy", "suburb", "success", "sufferer", "supposition", "suspension", "sweater", "sweepstakes", "swimmer", "syndrome", "synopsis", "syntax", "system", "tablespoon", "taker", "tavern", "technology", "telephony", "template", "tempo", "tendency", "tendon", "terrier", "terror", "terry", "theater", "theology", "therapy", "thicket", "thoroughfare", "threshold", "thriller", "thunderstorm", "ticker", "tiger", "tights", "tossing", "touchdown", "tourist", "tourney", "toxicity", "tracing", "tractor", "translation", "transmission", "transmitter", "trauma", "traveler", "treadmill", "trilogy", "trout", "tuning", "twenties", "tycoon", "tyrant", "ultimatum", "antidote", "underwear", "unhappiness", "unification", "university", "rise", "uprising", "downfall", "vaccination", "validity", "vampire", "vanguard", "variation", "vegetation", "verification", "viability", "vicinity", "victory", "beauty", "viewpoint", "viewport", "villa", "vanilla", "vindication", "violation", "vocalist", "vogue", "volcano", "voltage", "vomiting", "vulnerability", "waistcoat", "waitress", "wardrobe", "warmth", "watchdog", "wealth", "weariness", "whereabouts", "whisky", "whiteness", "widget", "width", "windfall", "wiring", "witchcraft", "withholding", "womanhood", "words", "workman", "laborer", "lumberjack", "youngster", "mobile phone", "telephone", "Television", "information", "technology", "automobile", "picture", "movie", "document", "documentary", "compliment", "insult", "vocalist", "pianist", "violinist", "thirst", "hunger", "brevity", "longevity", "sanity", "insanity", "bikini", "panty", "*****", "hymen", "synthesis", "dementia", "amnesia", "blood sugar", "fever", "flu", "diarrhea", "glucose", "Latino", "Latina", "anesthetics", "anesthesia", "Cannabis", "oasis", "desert", "dessert", "hemoglobin", "cardiographer", "carpenter", "oceanic", "terran", "abroad", "absorbing", "abstract", "academic", "accelerated", "accented", "accountant", "acquainted", "acute", "obtuse", "protective", "possessive", "real", "unreal", "realistic", "unrealistic", "imagined", "delusional", "addicting", "addictive", "adjustable", "admired", "adult", "adverse", "advised", "aerosol", "afraid", "creeped out", "horrified", "horrific", "terrified", "terrific", "devastated", "frustrated", "aggravated", "aggressive", "agreeable", "alienate", "aligned", "all-round", "alleged", "almond", "alright", "altruistic", "ambient", "ambivalent", "amiable", "amino", "amorphous", "amused", "anatomical", "ancestral", "angelic", "angrier", "answerable", "antiquarian", "antiretroviral", "appellate", "applicable", "apportioned", "approachable", "appropriated", "archer", "aroused", "arrested", "assertive", "assigned", "athletic", "atrocious", "attained", "authoritarian", "autobiographical", "avaricious", "avocado", "awake", "awesome", "backstage", "backwoods", "balding", "bandaged", "banded", "banned", "barreled", "battle", "beaten", "begotten", "beguiled", "bellied", "belted", "beneficent", "besieged", "betting", "big-money", "biggest", "biochemical", "bipolar", "blackened", "blame", "blessed", "blindfolded", "bloat", "blocked", "blooded", "blue-collar", "blushing", "boastful", "bolder", "bolstered", "bonnie", "bored", "boundary", "bounded", "bounding", "branched", "brawling", "brazen", "breeding", "bridged", "brimming", "brimstone", "broadest", "broiled", "broker", "bronze", "bruising", "buffy", "bullied", "bungling", "burial", "buttery", "candied", "canonical", "cantankerous", "cardinal", "carefree", "caretaker", "casual", "cathartic", "causal", "chapel", "characterized", "charcoal", "cheeky", "cherished", "chipotle", "chirping", "chivalrous", "circumstantial", "civic", "civil", "civilised", "clanking", "clapping", "claptrap", "classless", "cleansed", "cleric", "cloistered", "codified", "colloquial", "colour", "combat", "combined", "comely", "commissioned", "commonplace", "commuter", "commuting", "comparable", "complementary", "compromising", "conceding", "concentrated", "conceptual", "conditioned", "confederate", "confident", "confidential", "confining", "confuse", "congressional", "consequential", "conservative", "constituent", "contaminated", "contemporaneous", "contraceptive", "convertible", "convex", "cooked", "coronary", "corporatist", "correlated", "corroborated", "cosmic", "cover", "crash", "crypto", "culminate", "cushioned", "dandy", "dashing", "dazzled", "decreased", "decrepit", "dedicated", "defaced", "defective", "defenseless", "deluded", "deodorant", "departed", "depress", "designing", "despairing", "destitute", "detective", "determined", "devastating", "deviant", "devilish", "devoted", "diagonal", "dictated", "didactic", "differentiated", "diffused", "dirtier", "disabling", "disconnected", "discovered", "disdainful", "diseased", "disfigured", "disheartened", "disheveled", "disillusioned", "disparate", "dissident", "doable", "doctrinal", "doing", "dotted", "double-blind", "downbeat", "dozen", "draining", "draught", "dread", "dried", "dropped", "dulled", "duplicate", "eaten", "echoing", "economical", "elaborated", "elastic", "elective", "electoral", "elven", "embryo", "emerald", "emergency", "emissary", "emotional", "employed", "enamel", "encased", "encrusted", "endangered", "engraved", "engrossing", "enlarged", "enlisted", "enlivened", "ensconced", "entangled", "enthralling", "entire", "envious", "eradicated", "eroded", "esoteric", "essential", "evaporated", "ever-present", "evergreen", "everlasting", "exacting", "exasperated", "excess", "exciting", "executable", "existent", "exonerated", "exorbitant", "exponential", "export", "extraordinary", "exultant", "exulting", "facsimile", "fading", "fainter", "faith-based", "fallacious", "faltering", "famous", "fancier", "fast-growing", "fated", "favourable", "fearless", "feathered", "fellow", "fermented", "ferocious", "fiddling", "filling", "firmer", "fitted", "flammable", "flawed", "fledgling", "fleshy", "flexible", "flickering", "floral", "flowering", "flowing", "foggy", "folic", "foolhardy", "foolish", "footy", "forehand", "forked", "formative", "formulaic", "foul-mouthed", "fractional", "fragrant", "fraudulent", "freakish", "freckled", "freelance", "freight", "fresh", "fretted", "frugal", "fulfilling", "fuming", "funded", "funny", "garbled", "gathered", "geologic", "geometric", "gibberish", "gilded", "ginger", "glare", "glaring", "gleaming", "glorified", "glorious", "goalless", "gold-plated", "goody", "grammatical", "grande", "grateful", "gratuitous", "graven", "greener", "grinding", "grizzly", "groaning", "grudging", "guaranteed", "gusty", "half-breed", "hand-held", "handheld", "hands-off", "hard-pressed", "harlot", "healing", "healthier", "healthiest", "heart", "heart-shaped", "heathen", "hedonistic", "heralded", "herbal", "high-density", "high-performance", "high-res", "high-yield", "hissy", "hitless", "holiness", "homesick", "honorable", "hooded", "hopeless", "horrendous", "horrible", "hot-button", "huddled", "human", "humbling", "humid", "humiliating", "hypnotized", "idealistic", "idiosyncratic", "ignited", "illustrated", "illustrative", "imitated", "immense", "immersive", "immigrant", "immoral", "impassive", "impressionable", "improbable", "impulsive", "in-between", "in-flight", "inattentive", "inbound", "inbounds", "incalculable", "incomprehensible", "indefatigable", "indigo", "indiscriminate", "indomitable", "inert", "inflate", "inform", "inheriting", "injured", "injurious", "inking", "inoffensive", "insane", "insensible", "insidious", "insincere", "insistent", "insolent", "insufferable", "intemperate", "interdependent", "interesting", "interfering", "intern", "interpreted", "intersecting", "intolerable", "intolerant", "intuitive", "irresolute", "irritate", "jealous", "jerking", "joining", "joint", "journalistic", "joyful", "keyed", "knowing", "lacklustre", "laden", "lagging", "lamented", "laughable", "layered", "leather", "leathern", "leery", "left-footed", "legible", "leisure", "lessening", "liberating", "life-size", "lifted", "lightest", "limitless", "listening", "literary", "liver", "livid", "lobster", "locked", "long-held", "long-lasting", "long-running", "long-suffering", "loudest", "loveliest", "low-budget", "low-carb", "lowering", "lucid", "luckless", "lusty", "luxurious", "magazine", "maniac", "manmade", "maroon", "mastered", "mated", "material", "materialistic", "meaningful", "measuring", "mediaeval", "medical", "meditated", "medley", "melodic", "memorable", "tasty", "delicious", "inspiring", "motivational", "default", "good", "bad", "neutral", "fine", "okay", "alright", "memorial", "metabolic", "metallic", "metallurgical", "metering", "midair", "midterm", "midway", "mighty", "migrating", "mind-blowing", "mind-boggling", "major", "minor", "visual", "visible", "audible", "mirrored", "misguided", "misshapen", "joyful", "mixed", "twisted", "mitigated", "mixed", "modernized", "molecular", "monarch", "monastic", "morbid", "motley", "motorized", "mounted", "multi-million", "multidisciplinary", "muscled", "muscular", "muted", "mysterious", "mythic", "nail-biting", "natural", "nauseous", "negative", "networked", "neurological", "neutered", "newest", "night", "nitrous", "no-fly", "noncommercial", "nonsense", "north", "nuanced", "occurring", "offensive", "oldest", "oncoming", "one-eyed", "one-year", "onstage", "onward", "opaque", "open-ended", "operating", "opportunist", "opposing", "opt-in", "ordinate", "outdone", "outlaw", "outsized", "overboard", "overheated", "oversize", "overworked", "oyster", "paced", "panting", "paralyzed", "paramount", "parental", "parted", "partisan", "passive", "edible", "eatable", "kissable", "killable", "pastel", "patriot", "peacekeeping", "pedestrian", "peevish", "penal", "penned", "pensive", "perceptual", "perky", "permissible", "pernicious", "perpetuate", "perplexed", "pervasive", "petrochemical", "philosophical", "picturesque", "pillaged", "piped", "piquant", "pitching", "plausible", "pliable", "plumb", "politician", "polygamous", "poorest", "portmanteau", "posed", "positive", "possible", "postpartum", "prank", "pre-emptive", "precocious", "predicted", "premium", "preparatory", "prerequisite", "prescient", "preserved", "presidential", "pressed", "pressurized", "presumed", "prewar", "priced", "pricier", "primal", "primer", "primetime", "printed", "private", "problem", "procedural", "process", "prodigious", "professional", "programmed", "progressive", "prolific", "promising", "promulgated", "pronged", "proportionate", "protracted", "pulled", "pulsed", "purgatory", "quick", "rapid-fire", "raunchy", "razed", "reactive", "readable", "realizing", "recognised", "recovering", "recurrent", "recycled", "redeemable", "reflecting", "regal", "registering", "reliable", "reminiscent", "remorseless", "removable", "renewable", "repeating", "repellent", "reserve", "resigned", "respectful", "rested", "restrict", "resultant", "retaliatory", "retiring", "revelatory", "reverend", "reversing", "revolving", "ridiculous", "right-hand", "ringed", "risque", "robust", "roomful", "rotating", "roused", "rubber", "run-down", "running", "runtime", "rustling", "safest", "salient", "sanctioned", "saute", "saved", "scandalized", "scarlet", "scattering", "sceptical", "scheming", "scoundrel", "scratched", "scratchy", "scrolled", "seated", "second-best", "segregated", "self-taught", "semiautomatic", "senior", "sensed", "sentient", "sexier", "shadowy", "shaken", "shaker", "shameless", "shaped", "shiny", "shipped", "shivering", "shoestring", "short", "short-lived", "signed", "simplest", "simplistic", "sizable", "skeleton", "skinny", "skirting", "skyrocketed", "slamming", "slanting", "slapstick", "sleek", "sleepless", "sleepy", "slender", "slimmer", "smacking", "smokeless", "smothered", "smouldering", "snuff", "socialized", "solid-state", "sometime", "sought", "spanking", "sparing", "spattered", "specialized", "specific", "speedy", "spherical", "spiky", "spineless", "sprung", "squint", "stainless", "standing", "starlight", "startled", "stately", "statewide", "stereoscopic", "sticky", "stimulant", "stinky", "stoked", "stolen", "storied", "strained", "strapping", "strengthened", "stubborn", "stylized", "suave", "subjective", "subjugated", "subordinate", "succeeding", "suffering", "summary", "sunset", "sunshine", "supernatural", "supervisory", "supply-side", "surrogate", "suspended", "suspenseful", "swarthy", "sweating", "sweeping", "swinging", "swooning", "sympathize", "synchronized", "synonymous", "synthetic", "tailed", "tallest", "tangible", "tanked", "tarry", "technical", "tectonic", "telepathic", "tenderest", "territorial", "testimonial", "theistic", "thicker", "threatening", "tight-lipped", "timed", "timely", "timid", "torrent", "totalled", "tougher", "traditional", "transformed", "trapped", "traveled", "traverse", "treated", "trial", "trunk", "trusting", "trying", "twisted", "two-lane", "tyrannical", "unaided", "unassisted", "unassuming", "unattractive", "uncapped", "uncomfortable", "uncontrolled", "uncooked", "uncooperative", "underground", "undersea", "undisturbed", "unearthly", "uneasy", "unequal", "unfazed", "unfinished", "unforeseen", "unforgivable", "unidentified", "unimaginative", "uninspired", "unintended", "uninvited", "universal", "unmasked", "unorthodox", "unparalleled", "unpleasant", "unprincipled", "unread", "unreasonable", "unregulated", "unreliable", "unremitting", "unsafe", "unsanitary", "unsealed", "unsuccessful", "unsupervised", "untimely", "unwary", "unwrapped", "uppity", "upstart", "useless", "utter", "valiant", "valid", "valued", "vanilla", "vaulting", "vaunted", "veering", "vegetative", "vented", "verbal", "verifying", "veritable", "versed", "vinyl", "virgin", "visceral", "visual", "voluptuous", "walk-on", "wanton", "warlike", "washed", "waterproof", "waved", "weakest", "well-bred", "well-chosen", "well-informed", "wet", "wheeled", "whirlwind", "widen", "widening", "willful", "willing", "winnable", "winningest", "wireless", "wistful", "woeful", "wooded", "woodland", "wordless", "workable", "worldly", "worldwide", "worst-case", "worsted", "worthless", "able", "abnormal", "absent-minded", "above average", "adventurous", "affectionate", "agile", "agreeable", "alert", "amazing", "ambitious", "amiable", "amusing", "analytical", "angelic", "apathetic", "apprehensive", "ardent", "artificial", "artistic", "assertive", "attentive", "average", "awesome", "awful", "balanced", "beautiful", "below average", "beneficent", "blue", "blunt", "boisterous", "brave", "bright", "brilliant", "buff", "callous", "candid", "cantankerous", "capable", "careful", "careless", "caustic", "cautious", "charming", "childish", "childlike", "cheerful", "chic", "churlish", "circumspect", "civil", "clean", "clever", "clumsy", "coherent", "cold", "competent", "composed", "conceited", "condescending", "confident", "confused", "conscientious", "considerate", "content", "cool", "cool-headed", "cooperative", "cordial", "courageous", "cowardly", "crabby", "crafty", "cranky", "crass", "critical", "cruel", "curious", "cynical", "dainty", "decisive", "deep", "deferential", "deft", "delicate", "demonic", "dependent", "delightful", "demure", "depressed", "devoted", "dextrous", "diligent", "direct", "dirty", "disagreeable", "discerning", "discreet", "disruptive", "distant", "distraught", "distrustful", "dowdy", "dramatic", "dreary", "drowsy", "drugged", "drunk", "dull", "dutiful", "eager", "earnest", "easy-going", "efficient", "egotistical", "elfin", "emotional", "energetic", "enterprising", "enthusiastic", "evasive", "even-tempered", "exacting", "excellent", "excitable", "experienced", "fabulous", "fastidious", "ferocious", "fervent", "fiery", "flabby", "flaky", "flashy", "frank", "friendly", "funny", "fussy", "generous", "gentle", "gloomy", "glutinous", "good", "grave", "great", "groggy", "grouchy", "guarded", "hateful", "hearty", "helpful", "hesitant", "hot-headed", "hypercritical", "hysterical", "idiotic", "idle", "illogical", "imaginative", "immature", "immodest", "impatient", "imperturbable", "impetuous", "impractical", "impressionable", "impressive", "impulsive", "inactive", "incisive", "incompetent", "inconsiderate", "inconsistent", "independent", "indiscreet", "indolent", "indefatigable", "industrious", "inexperienced", "insensitive", "inspiring", "intelligent", "interesting", "intolerant", "inventive", "irascible", "irritable", "irritating", "jocular", "jovial", "joyous", "judgmental", "keen", "kind", "lame", "lazy", "lean", "leery", "lethargic", "level-headed", "listless", "lithe", "lively", "local", "logical", "long-winded", "lovable", "love-lorn", "lovely", "maternal", "mature", "mean", "meddlesome", "mercurial", "methodical", "meticulous", "mild", "miserable", "modest", "moronic", "morose", "motivated", "musical", "naive", "nasty", "natural", "naughty", "negative", "nervous", "noisy", "normal", "nosy", "numb", "obliging", "obnoxious", "old-fashioned", "one-sided", "orderly", "ostentatious", "outgoing", "outspoken", "passionate", "passive", "paternal", "paternalistic", "patient", "peaceful", "peevish", "pensive", "persevering", "persnickety", "petulant", "picky", "plain", "plain-speaking", "playful", "pleasant", "plucky", "polite", "popular", "positive", "powerful", "practical", "prejudiced", "pretty", "proficient", "proud", "provocative", "prudent", "punctual", "quarrelsome", "querulous", "quick", "quick-tempered", "quiet", "realistic", "reassuring", "reclusive", "reliable", "reluctant", "resentful", "reserved", "resigned", "resourceful", "respected", "respectful", "responsible", "restless", "revered", "ridiculous", "sad", "sassy", "saucy", "sedate", "self-assured", "selfish", "sensible", "sensitive", "sentimental", "serene", "serious", "sharp", "short-tempered", "shrewd", "shy", "silly", "sincere", "sleepy", "slight", "sloppy", "slothful", "slovenly", "slow", "smart", "snazzy", "sneering", "snobby", "somber", "sober", "sophisticated", "soulful", "soulless", "sour", "spirited", "spiteful", "stable", "staid", "steady", "stern", "stoic", "striking", "strong", "stupid", "sturdy", "subtle", "sullen", "sulky", "supercilious", "superficial", "surly", "suspicious", "sweet", "tactful", "tactless", "talented", "testy", "thinking", "thoughtful", "thoughtless", "timid", "tired", "tolerant", "touchy", "tranquil", "ugly", "unaffected", "unbalanced", "uncertain", "uncooperative", "undependable", "unemotional", "unfriendly", "unguarded", "unhelpful", "unimaginative", "unmotivated", "unpleasant", "unpopular", "unreliable", "unsophisticated", "unstable", "unsure", "unthinking", "unwilling", "venal", "versatile", "vigilant", "warm", "warmhearted", "wary", "watchful", "weak", "well-behaved", "well-developed", "well-intentioned", "well-respected", "well-rounded", "willing", "wonderful", "volcanic", "vulnerable", "zealous", "abandoned", "absent minded", "abused", "accepted", "accomplished", "accusatory", "accused", "admired", "adored", "adrift", "affectionate", "afraid", "aggravated", "aggressive", "agitated", "alarmed", "alert", "alienated", "alive", "alluring", "alone", "aloof", "amazed", "ambushed", "amused", "angry", "annoyed", "antagonistic", "anxious", "apathetic", "apologetic", "appalled", "appreciated", "appreciative", "apprehensive", "aroused", "ashamed", "astonished", "attacked", "attractive", "awake", "aware", "awe", "awed", "awestruck", "awkward", "bad", "baffled", "barren", "bashful", "beaten", "belittled", "benevolent", "berated", "betrayed", "bewildered", "bitchy", "bitter", "bittersweet", "blah", "blamed", "blank", "blissful", "blue", "bold", "bored", "bothered", "bouncy", "brave", "broken", "brooding", "bummed", "burdened", "burned-out", "callous", "calm", "capable", "carefree", "careless", "caring", "caustic", "cautious", "censored", "centered", "certain", "challenged", "charmed", "cheated", "cheerful", "cherished", "childish", "chipper", "choleric", "clean", "clear", "clever", "close", "closed", "clueless", "clumsy", "cold", "comfortable", "committed", "compassionate", "competent", "competitive", "complacent", "complete", "concerned", "condemned", "condescension", "confident", "confining", "confused", "considerate", "contemplative", "contempt", "contemptuous", "content", "controlled", "conventional", "convicted", "cornered", "courageous", "cowardly", "cranky", "crappy", "crazy", "critical", "cross", "crushed", "curious", "cynical", "daring", "dark", "dashed", "dazed", "dead", "deceived", "dedicated", "defeated", "defenseless", "defensive", "defiant", "degraded", "dejected", "delicate", "delighted", "demoralized", "dependent", "depressed", "deprived", "derisive", "deserted", "desired", "desolate", "despair", "desperate", "destroyed", "detached", "determined", "devastated", "devious", "devoted", "didactic", "different", "difficult", "dignified", "dirty", "disappointed", "disbelieving", "discarded", "disconnected", "discontent", "discontented", "discouraged", "disdainful", "disgraced", "disgusted", "disheartened", "dishonest", "disillusioned", "dismal", "dismayed", "disobedient", "disorganized", "disposable", "distant", "distracted", "distressed", "disturbed", "ditzy", "dorky", "doubtful", "down", "drained", "dreamy", "dreary", "dropped", "drunk", "dull", "dumb", "eager", "earnest", "ecstatic", "edgy", "effective", "elated", "embarassed", "embarrassed", "empathetic", "empowered", "empty", "enchanted", "encouraged", "energetic", "energized", "enlightened", "enraged", "enriched", "entertained", "enthralled", "enthusiastic", "envious", "erudite", "evasive", "evil", "exasperated", "excited", "excluded", "exhausted", "exhilarated", "expectant", "exploited", "exposed", "exuberant", "faithful", "fake", "fanciful", "fantastic", "fatalistic", "fatigued", "fearful", "fearless", "feisty", "fine", "flirty", "flustered", "foolish", "foreboding", "forgiven", "forgiving", "forgotten", "forthright", "fortunate", "framed", "frantic", "free", "friendly", "frightened", "frisky", "frustrated", "fulfilled", "full", "funny", "furious", "futile", "geeky", "generous", "gentle", "giddy", "giggly", "giving", "glad", "gloomy", "glorious", "good", "grateful", "great", "grieving", "groggy", "grouchy", "grumpy", "guarded", "guilty", "gullible", "handicapped", "happy", "harmonious", "hateful", "haughty", "haunted", "haunting", "healthy", "heard", "heartbroken", "heavy-hearted", "helpful", "helpless", "hesitant", "high", "honored", "hopeful", "hopeless", "horrible", "horrified", "hospitable", "hostile", "hot", "humble", "humiliated", "hungry", "hurt", "hyper", "hysterical", "idealistic", "idiotic", "idyllic", "ignorant", "ignored", "imaginative", "immune", "impatient", "impelled", "imperfect", "impertinent", "important", "impressed", "impulsive", "inadequate", "inattentive", "incensed", "inclusive", "incompetent", "incomplete", "incredulous", "indebted", "indecisive", "independent", "indescribable", "indifferent", "indignant", "industrious", "inept", "inferior", "inflated", "informed", "infuriated", "inhibited", "innocent", "innovative", "inquisitive", "insane", "insecure", "insensitive", "insidious", "insignificant", "insulted", "intense", "interested", "interrogated", "interrupted", "intimate", "intimidated", "intrigued", "invigorated", "invisible", "involved", "irate", "irked", "irrational", "irresponsible", "irritated", "isolated", "jaded", "jealous", "jinxed", "jolly", "jovial", "joyful", "joyous", "jubilant", "judged", "judgmental", "jumpy", "just", "justified", "kidded", "kind", "knowledgeable", "late", "lazy", "leery", "left", "let", "lethargic", "liable", "liberated", "liberating", "lifeless", "light-hearted", "liked", "listened", "listless", "logical", "lonely", "loose", "lost", "lousy", "lovable", "loved", "loving", "lucky", "lyrical", "mad", "malicious", "manipulated", "matter", "fact", "mean", "meditative", "melancholic", "melancholy", "mellow", "merciless", "merry", "mischievous", "miserable", "misinterpreted", "mistreated", "misunderstood", "mixed", "mocked", "mocking", "modest", "molested", "moody", "morose", "motivated", "mournful", "moved", "mystified", "naive", "nasty", "naughty", "nauseated", "needed", "needy", "negative", "neglected", "nerdy", "nervous", "neurotic", "nightmarish", "nonchalant", "nostalgic", "not", "specified", "noticed", "numb", "obeyed", "objective", "obligated", "obvious", "odd", "offended", "okay", "old", "open", "oppressed", "optimistic", "ornery", "control", "outraged", "overcome", "overjoyed", "overloaded", "overwhelmed", "overworked", "owned", "painful", "pampered", "panicky", "paralyzed", "passionate", "passive", "patient", "patronizing", "peaceful", "peeved", "pensive", "perky", "perplexed", "persecuted", "pessimistic", "pestered", "petrified", "petty", "phony", "pious", "pissed", "off", "playful", "pleased", "poor", "positive", "possessive", "powerful", "powerless", "practical", "predatory", "pressured", "private", "productive", "protected", "protective", "proud", "provoked", "prudish", "punished", "pushy", "puzzled", "questioned", "quiet", "quixotic", "quizzical", "rambunctious", "realistic", "reassured", "rebellious", "reborn", "receptive", "reckless", "recognized", "reconciled", "recumbent", "reflective", "refreshed", "regretful", "rejected", "rejuvenated", "relaxed", "released", "relieved", "reluctant", "reminiscent", "remorse", "renewed", "replaced", "replenished", "repressed", "rescued", "resentful", "reserved", "resistant", "resourceful", "respected", "responsible", "restless", "restricted", "revengeful", "reverent", "revitalized", "ribald", "rich", "ridicule", "ridiculous", "right", "rigid", "robbed", "romantic", "rotten", "rushed", "sabotaged", "sad", "safe", "sarcastic", "sardonic", "sassy", "satiated", "satiric", "satisfied", "saved", "scared", "scolded", "scorned", "secure", "seductive", "selfish", "self-assured", "self-centered", "self-confident", "self-conscious", "self-destructive", "self-reliant", "sensitive", "sentimental", "serene", "serious", "*****", "shaken", "shamed", "sheepish", "shocked", "shunned", "shy", "sick", "silenced", "silly", "sincere", "sinful", "skeptical", "skillful", "slandered", "sleepy", "sluggish", "small", "smart", "smothered", "solemn", "somber", "soothed", "sorry", "special", "spiteful", "splendid", "spunky", "squashed", "stifled", "stimulated", "stingy", "strained", "stressed", "stretched", "strong", "stubborn", "stumped", "stunned", "stupid", "submissive", "successful", "suffocated", "suicidal", "sullen", "sunk", "super", "superior", "supported", "sure", "surly", "surprised", "suspenseful", "suspicious", "sympathetic", "tacky", "tactful", "talented", "talkative", "tame", "tarnished", "tasteful", "tearful", "teased", "tenacious", "tender", "tense", "tepid", "terrible", "terrific", "terrified", "terrifying", "tested", "testy", "thankful", "thoughtful", "threatened", "threatening", "thrifty", "thrilled", "tired", "tormented", "torn", "tortured", "touched", "tough", "tragic", "tranquil", "transformed", "trapped", "treasured", "trembly", "tremendous", "tricked", "troubled", "trusted", "trustful", "ugly", "unaccepted", "unappreciated", "unbalanced", "unburdened", "uncanny", "uncomfortable", "unconcerned", "uneven", "unfit", "unfriendly", "united", "unjust", "unknown", "unneeded", "unpleasant", "unreal", "unruly", "unwise", "up", "uplifted", "used", "useless", "vacant", "vague", "vain", "valid", "valued", "vengeful", "vexed", "vicious", "victimized", "victorious", "violated", "violent", "vivacious", "vivid", "void", "wacky", "warlike", "warm", "warmhearted", "warned", "wary", "wasted", "weak", "wealthy", "weary", "weird", "welcoming", "whimsical", "whole", "wild", "willful", "wishful", "witty", "worldly", "worried", "worse", "worthy", "wounded", "wrong", "yearning", "yellow", "yielding", "young", "youthful", "zany", "zealous"},
								  ntltss = {"Afghan", "Egyptian", "Alantic", "Albanian", "Algerian", "Virgin Islander", "American Samoan", "Andorran", "Angolan", "Anguillan", "Antarctic", "Antiguan and Barbudan", "Equatorial Guinean", "Argentine; Argentinian", "Armenian", "Aruban", "Azerbaijani", "Ethiopian", "Australian", "Bahamian", "Bahraini", "Bangladeshi", "Barbadian", "Belarusian", "Belgian", "Belizean", "Beninese", "Bermudian", "Bhutanese", "Bolivian", "Bosnian", "Botswanan", "of Bouvet Island", "Brazilian", "of the British Indian Ocean Territory", "British Virgin Islander", "Bruneian", "Bulgarian", "Burkinabe", "Burundian", "Cape Verdean", "Chilean", "Chinese", "of Clipperton Island", "Cook Islander", "Costa Rican", "Ivorian", "Curacaoan", "Danish", "German", "Dominican", "Djiboutian", "Ecuadorian", "Salvadorian; Salvadoran", "Eritrean", "Estonian", "Falklander", "Faroese", "Fijian", "Finnish", "French", "of the French Southern and Antarctic Lands", "Guianese", "Polynesian", "Gabonese", "Gambian", "Georgian", "Ghanaian", "Gibraltarian", "Grenadian", "Greek", "Greenlandic", "Guadeloupean", "Guamanian", "Guatemalan", "Guernsey", "Guinean", "Bissau-Guinean", "Guyanese", "Haitian", "of the Heard Island and McDonald Islands", "of the Holy See/of the Vatican", "Honduran", "Hong Kong Chinese", "Indian", "Indonesian", "Manx", "Iraqi", "Iranian", "Irish", "Icelandic", "Israeli", "Italian", "Jamaican", "Japanese", "Yemeni", "Jersey", "Jordanian", "Caymanian", "Cambodian", "Cameroonian", "Canadian", "Kazakh", "Qatari", "Kenyan", "Kyrgyz", "Kiribatian", "of the Cocos (Keeling) Islands", "Colombian", "Comorian", "Congolese", "Croatian", "Cuban", "Kuwaiti", "Lao; Laotian", "Mesotho", "Latvian", "Lebanese", "Liberian", "Libyan", "Liechtensteiners", "Lithuanian", "Luxembourgish", "Macanese", "Malagasy", "Malawian", "Malaysian", "Maldivian", "Malian", "Maltese", "Moroccan", "Marshallese", "Martinican", "Mauritanian", "Mauritian", "Mahoran", "Mexican", "Micronesian", "Moldovan", "Monegasque", "Mongolian", "Montenegrin", "Montserratian", "Mozambican", "Burmese", "Namibian", "Nauruan", "Nepalese", "New Caledonian", "New Zealander", "Nicaraguan", "Dutch", "Nigerien", "Nigerian", "Niuean", "North Korean", "Marian Islander", "Norfolk Islander", "Norwegian", "Omani", "Austrian", "Pakistani", "Palauan", "Panamanian", "Papua New Guinean", "Paraguayan", "Peruvian", "Filipino", "Pitcairner", "Polish", "Portuguese", "Puerto Rican", "Reunionese", "Rwandan; Rwandese", "Romanian", "Russian", "Solomon Islander", "Zambian", "Samoan", "Sammarinese", "Sao Tomean", "Saudi Arabian", "Swedish", "Swiss", "Senegalese", "Serbian", "Seychellois", "Sierra Leonean", "Zimbabwean", "Singaporean", "Slovak", "Slovenian", "Somali; Somalian", "Spanish", "Sri Lankan", "Saint Barthelemian", "of Saint Helena, Ascension and Tristan da Cunha", "of Saint Kitts and Nevis", "Saint Lucian", "of Saint Martin", "of Sint Maarten", "of Saint Pierre and Miquelon", "Vincentian; of Saint Vincent and the Grenadines", "South African", "Sudanese", "of South Georgia and the South Sandwich Islands", "South Korean", "South Sudanese", "Surinamese", "of Svalbard, of Jan Mayen", "Swazi", "Syrian", "Tajik", "Taiwanese", "Tanzanian", "Thai", "East Timorese", "Togolese", "Tokelauan", "Tongan", "of Trinidad and Tobago", "Chadian", "Czech", "Tunisian", "Turkish", "Turkmen", "of the Turks and Caicos Islands", "Tuvaluan", "Ugandan", "Ukrainian", "Hungarian", "Uruguayan", "Uzbek", "Vanuatuan", "Venezuelan", "Emirian", "American; The United States of America", "British", "Vietnamese", "of the Wallis and Futuna Islands", "of Christmas Island", "Sahrawi", "Central African", "Cypriot"},
								  rfnss = {"+92 (337) 705 2471", "+92 (304) 856 3453", "+92 (334) 462 6112", "+92 (318) 133 8724", "+92 (305) 578 5856", "+92 (310) 462 5351", "+92 (312) 731 7316", "+92 (333) 853 8132", "+92 (325) 818 0176", "+92 (307) 531 4378", "+92 (308) 231 0403", "+92 (324) 113 2465", "+92 (308) 350 1245", "+92 (304) 778 1655", "+92 (308) 212 6486", "+92 (337) 003 6218", "+92 (318) 388 5662", "+92 (311) 032 8777", "+92 (317) 457 2031", "+92 (303) 475 4653", "+92 (313) 246 8410", "+92 (308) 215 2441", "+92 (305) 205 3250", "+92 (314) 763 2228", "+92 (323) 267 3234", "+92 (320) 005 8284", "+92 (312) 486 1408", "+92 (313) 556 6782", "+92 (312) 188 8504", "+92 (321) 517 0564", "+92 (300) 215 0018", "+92 (331) 066 8182", "+92 (305) 621 8357", "+92 (312) 303 6683", "+92 (330) 315 6554", "+92 (318) 702 7462", "+92 (307) 083 6477", "+92 (333) 585 3443", "+92 (315) 547 0136", "+92 (327) 660 2848", "+92 (330) 144 4028", "+92 (323) 276 4840", "+92 (327) 738 8321", "+92 (305) 812 7050", "+92 (324) 620 5556", "+92 (310) 681 7606", "+92 (336) 286 8600", "+92 (333) 241 8207", "+92 (322) 527 1520", "+92 (303) 510 4857", "+92 (337) 650 1744", "+92 (321) 331 4144", "+92 (301) 515 4836", "+92 (332) 460 3760", "+92 (333) 168 2174", "+92 (304) 272 1350", "+92 (320) 375 3538", "+92 (336) 516 5606", "+92 (330) 088 7340", "+92 (317) 523 7275", "+92 (314) 128 3831", "+92 (326) 825 7157", "+92 (302) 115 2032", "+92 (336) 362 6505", "+92 (313) 627 6536", "+92 (302) 832 5304", "+92 (300) 131 4753", "+92 (311) 588 0281", "+92 (337) 412 0180", "+92 (321) 601 7236", "+92 (306) 075 0548", "+92 (336) 744 6742", "+92 (335) 684 5677", "+92 (323) 753 4302", "+92 (322) 864 6866", "+92 (301) 077 0316", "+92 (320) 080 7036", "+92 (327) 613 3783", "+92 (334) 138 2771", "+92 (330) 343 8104", "+92 (325) 201 0684", "+92 (337) 775 7221", "+92 (311) 857 5310", "+92 (322) 615 5255", "+92 (310) 731 2176", "+92 (323) 412 7433", "+92 (323) 180 3238", "+92 (318) 704 5111", "+92 (321) 485 2814", "+92 (334) 611 2074", "+92 (314) 343 0881", "+92 (300) 537 3177", "+92 (310) 187 8100", "+92 (320) 878 2262", "+92 (324) 785 1028", "+92 (313) 070 1354", "+92 (318) 204 0637", "+92 (328) 877 2626", "+92 (318) 018 4006", "+92 (306) 104 1463", "+92 (313) 862 3726", "+92 (318) 388 7683", "+92 (330) 738 5730", "+92 (316) 166 6803", "+92 (313) 271 3641", "+92 (307) 718 8285", "+92 (306) 256 2360", "+92 (321) 104 8067", "+92 (300) 884 5048", "+92 (307) 085 3035", "+92 (335) 446 3531", "+92 (322) 647 3410", "+92 (328) 760 2861", "+92 (327) 772 6701", "+92 (300) 211 6834", "+92 (333) 515 7716", "+92 (314) 534 3700", "+92 (330) 078 1205", "+92 (304) 316 1564", "+92 (338) 782 0723", "+92 (318) 250 1765", "+92 (300) 125 7551", "+92 (330) 715 6381", "+92 (306) 366 6305", "+92 (330) 548 0703", "+92 (324) 818 1781", "+92 (334) 057 4635", "+92 (327) 646 3800", "+92 (337) 112 4745", "+92 (334) 312 5800", "+92 (332) 323 4057", "+92 (323) 141 4625", "+92 (321) 725 5403", "+92 (306) 316 7326", "+92 (326) 857 5082", "+92 (311) 733 5287", "+92 (310) 288 5856", "+92 (318) 744 6625", "+92 (302) 038 3437", "+92 (300) 543 5048", "+92 (311) 524 0182", "+92 (310) 517 5147", "+92 (336) 677 5164", "+92 (333) 544 3314", "+92 (301) 158 0516", "+92 (320) 663 3225", "+92 (324) 267 5737", "+92 (334) 134 1455", "+92 (315) 612 3858", "+92 (317) 457 4026", "+92 (310) 135 2187", "+92 (312) 026 5570", "+92 (305) 642 0803", "+92 (318) 188 8582", "+92 (312) 247 0835", "+92 (322) 565 2507", "+92 (322) 604 7714", "+92 (308) 777 5758", "+92 (334) 408 6214", "+92 (303) 463 8153", "+92 (326) 681 5836", "+92 (337) 751 8272", "+92 (301) 361 7477", "+92 (313) 360 1062", "+92 (302) 147 0657", "+92 (310) 071 1840", "+92 (305) 862 3122", "+92 (330) 021 0070", "+92 (302) 746 8830", "+92 (337) 872 0571", "+92 (312) 421 4418", "+92 (326) 767 1476", "+92 (338) 868 0422", "+92 (304) 742 2570", "+92 (322) 603 5815", "+92 (336) 134 4630", "+92 (332) 213 3405", "+92 (328) 770 5337", "+92 (334) 377 0753", "+92 (332) 536 0507", "+92 (333) 577 3367", "+92 (314) 873 0856", "+92 (313) 223 7860", "+92 (333) 858 4750", "+92 (313) 014 7425", "+92 (336) 510 7005", "+92 (306) 682 0351", "+92 (311) 462 1763", "+92 (331) 013 6165", "+92 (305) 633 2143", "+92 (303) 481 7545", "+92 (300) 640 4238", "+92 (307) 154 7560", "+92 (305) 231 6152", "+92 (327) 820 1002", "+92 (300) 384 2010", "+92 (302) 882 2088", "+92 (314) 621 3515", "+92 (305) 243 8763", "+92 (327) 326 3071", "+92 (333) 105 7024", "+92 (332) 544 1170", "+92 (322) 830 3481", "+92 (310) 368 7228", "+92 (312) 034 5444", "+92 (324) 387 8832", "+92 (311) 658 7085", "+92 (333) 471 6534", "+92 (318) 511 2514", "+92 (306) 478 6607", "+92 (324) 702 4308", "+92 (336) 360 1744", "+92 (312) 513 8375", "+92 (334) 686 7874", "+92 (306) 627 6338", "+92 (332) 460 7558", "+92 (316) 817 8703", "+92 (300) 601 1281", "+92 (336) 617 8334", "+92 (335) 780 7855", "+92 (304) 482 7718", "+92 (336) 768 6462", "+92 (311) 105 6765", "+92 (321) 106 0335", "+92 (336) 527 7517", "+92 (317) 505 6640", "+92 (312) 666 2872", "+92 (310) 408 1200", "+92 (310) 146 4768", "+92 (308) 267 4746", "+92 (325) 507 4071", "+92 (327) 543 6632", "+92 (334) 167 4164", "+92 (301) 788 8214", "+92 (337) 445 8301", "+92 (322) 363 8213", "+92 (313) 307 8076", "+92 (302) 147 4655", "+92 (308) 733 2787", "+92 (323) 603 8653", "+92 (326) 063 5886", "+92 (303) 214 8782", "+92 (306) 135 6700", "+92 (331) 764 0407", "+92 (338) 245 1083", "+92 (327) 387 7425", "+92 (334) 518 1635", "+92 (336) 844 1154", "+92 (331) 607 8080", "+92 (317) 847 4253", "+92 (304) 034 4855", "+92 (311) 676 5521", "+92 (328) 162 1822", "+92 (316) 780 8086", "+92 (303) 513 8441", "+92 (324) 777 0074", "+92 (336) 162 6318", "+92 (323) 282 2211", "+92 (325) 712 2150", "+92 (313) 082 2570", "+92 (308) 406 7281", "+92 (333) 735 6170", "+92 (314) 502 5084", "+92 (337) 485 0163", "+92 (325) 380 8500", "+92 (315) 674 0704", "+92 (326) 808 7182", "+92 (338) 760 7774", "+92 (305) 307 2061", "+92 (336) 535 3642", "+92 (302) 727 4036", "+92 (300) 338 0680", "+92 (306) 074 0122", "+92 (325) 560 7146", "+92 (321) 532 6483", "+92 (318) 742 5523", "+92 (322) 160 5367", "+92 (331) 218 5540", "+92 (307) 263 0607", "+92 (328) 740 7545", "+92 (334) 081 0154", "+92 (323) 740 6273", "+92 (306) 168 2305", "+92 (338) 747 0835", "+92 (323) 066 8320", "+92 (338) 438 3555", "+92 (300) 346 0563", "+92 (320) 634 7562", "+92 (330) 316 1011", "+92 (300) 351 7074", "+92 (313) 758 8350", "+92 (313) 727 2310", "+92 (331) 371 0261", "+92 (305) 370 5643", "+92 (314) 475 8816", "+92 (311) 281 3765", "+92 (325) 662 4084", "+92 (310) 033 4327", "+92 (313) 530 7815", "+92 (327) 380 8188", "+92 (308) 070 8470", "+92 (323) 418 6367", "+92 (317) 233 5022", "+92 (301) 516 1310", "+92 (327) 836 1122", "+92 (326) 888 3055", "+92 (317) 648 1424", "+92 (332) 563 1855", "+92 (300) 453 1100", "+92 (336) 810 8634", "+92 (320) 055 6327", "+92 (314) 586 4743", "+92 (301) 106 3066", "+92 (308) 578 0821", "+92 (322) 047 4055", "+92 (310) 354 2234", "+92 (323) 771 8476", "+92 (312) 012 0767", "+92 (320) 455 4883", "+92 (322) 073 0140", "+92 (300) 677 1541", "+92 (330) 210 6046", "+92 (314) 722 4560", "+92 (331) 784 2382", "+92 (303) 273 8846", "+92 (331) 024 2853", "+92 (330) 454 8617", "+92 (317) 757 1833", "+92 (308) 334 3602", "+92 (316) 705 0848", "+92 (327) 174 5515", "+92 (308) 561 1524", "+92 (317) 165 3512", "+92 (334) 458 5500", "+92 (307) 264 5644", "+92 (313) 735 4003", "+92 (300) 554 0808", "+92 (327) 801 3402", "+92 (308) 857 7614", "+92 (304) 041 1408", "+92 (323) 772 7663", "+92 (337) 543 3248", "+92 (335) 017 2204", "+92 (313) 574 0726", "+92 (328) 572 5058", "+92 (311) 426 2002", "+92 (325) 006 8227", "+92 (307) 180 3504", "+92 (301) 370 2756", "+92 (300) 536 2556", "+92 (336) 562 4745", "+92 (335) 456 8361", "+92 (327) 356 5473", "+92 (305) 766 2753", "+92 (336) 010 0246", "+92 (311) 626 7526", "+92 (302) 860 4252", "+92 (322) 084 0662", "+92 (304) 101 0800", "+92 (316) 146 2018", "+92 (320) 235 7701", "+92 (338) 414 8473", "+92 (312) 441 2302", "+92 (306) 424 1504", "+92 (313) 652 7648", "+92 (314) 551 6166", "+92 (302) 804 5450", "+92 (334) 382 6883", "+92 (304) 448 6162", "+92 (331) 813 1683", "+92 (316) 562 4504", "+92 (303) 536 6031", "+92 (338) 772 3065", "+92 (331) 280 5101", "+92 (335) 220 0570", "+92 (317) 402 3502", "+92 (321) 752 0763", "+92 (330) 617 7136", "+92 (302) 083 2232", "+92 (300) 307 4675", "+92 (301) 401 8434", "+92 (303) 265 0173", "+92 (323) 752 2184", "+92 (302) 751 5347", "+92 (320) 764 1510", "+92 (314) 717 2422", "+92 (303) 631 6215", "+92 (334) 583 5180", "+92 (322) 725 4143", "+92 (320) 860 6378", "+92 (323) 756 6850", "+92 (302) 028 7823", "+92 (303) 868 0017", "+92 (316) 316 5303", "+92 (303) 088 8025", "+92 (307) 587 5757", "+92 (301) 256 3062", "+92 (316) 111 1886", "+92 (338) 146 8025", "+92 (312) 847 2754", "+92 (325) 456 0504", "+92 (333) 041 6237", "+92 (315) 411 8384", "+92 (314) 772 4233", "+92 (338) 307 1476", "+92 (300) 781 3662", "+92 (324) 150 3080", "+92 (311) 136 5282", "+92 (326) 672 2210", "+92 (323) 076 1370", "+92 (305) 210 4504", "+92 (323) 834 8236", "+92 (302) 425 4403", "+92 (318) 336 1325", "+92 (335) 340 1847", "+92 (316) 165 7848", "+92 (303) 121 8036", "+92 (322) 014 0663", "+92 (303) 178 6580", "+92 (315) 604 1032", "+92 (318) 777 7127", "+92 (303) 801 0731", "+92 (324) 874 4252", "+92 (323) 772 5020", "+92 (324) 123 5511", "+92 (324) 361 3683", "+92 (303) 001 5461", "+92 (304) 682 8504", "+92 (332) 562 5224", "+92 (304) 262 8807", "+92 (305) 314 8151", "+92 (331) 254 1780", "+92 (307) 577 5812", "+92 (301) 008 5052", "+92 (337) 183 3788", "+92 (330) 357 2760", "+92 (315) 167 5753", "+92 (322) 267 3232", "+92 (313) 075 3123", "+92 (338) 477 0012", "+92 (317) 130 5726", "+92 (326) 281 4226", "+92 (333) 568 8062", "+92 (317) 422 1660", "+92 (301) 720 8626", "+92 (302) 410 5526", "+92 (326) 844 4805", "+92 (301) 723 3603", "+92 (328) 830 4776", "+92 (305) 488 1204", "+92 (332) 407 0326", "+92 (301) 747 4714", "+92 (333) 112 8873", "+92 (308) 464 8353", "+92 (322) 377 1834", "+92 (323) 112 7256", "+92 (302) 057 2273", "+92 (328) 111 4086", "+92 (314) 754 5812", "+92 (337) 065 0672", "+92 (327) 304 5525", "+92 (331) 706 7060", "+92 (326) 842 0557", "+92 (318) 757 5610", "+92 (322) 262 7500", "+92 (308) 487 4450", "+92 (310) 325 5215", "+92 (315) 273 2531", "+92 (328) 525 4201", "+92 (301) 268 2380", "+92 (303) 255 6243", "+92 (318) 176 6448", "+92 (300) 530 5801", "+92 (318) 774 2284", "+92 (317) 240 7745", "+92 (303) 676 6783", "+92 (330) 717 1205", "+92 (336) 737 4067", "+92 (322) 524 6531", "+92 (303) 405 3577", "+92 (322) 758 4304", "+92 (305) 837 4377", "+92 (323) 655 6411", "+92 (312) 658 0070", "+92 (324) 535 2735", "+92 (334) 527 6220", "+92 (302) 445 5428", "+92 (317) 086 7076", "+92 (316) 341 8151", "+92 (317) 112 5715", "+92 (314) 740 6752", "+92 (304) 155 0421", "+92 (306) 061 8135", "+92 (324) 760 5853", "+92 (326) 385 2458", "+92 (338) 644 4116", "+92 (312) 467 0330", "+92 (332) 164 8136", "+92 (332) 338 6288", "+92 (305) 176 7874", "+92 (337) 135 0287", "+92 (327) 837 2660", "+92 (334) 634 6377", "+92 (334) 863 5246", "+92 (315) 478 0036", "+92 (302) 148 0766", "+92 (330) 642 7017", "+92 (333) 756 1563", "+92 (304) 270 5240", "+92 (327) 345 3262", "+92 (315) 165 5068", "+92 (312) 675 3868", "+92 (328) 868 7680", "+92 (304) 473 8118", "+92 (318) 415 3416", "+92 (311) 881 5740", "+92 (313) 302 7407", "+92 (307) 738 4570", "+92 (311) 541 8247", "+92 (300) 644 0706", "+92 (334) 708 5770", "+92 (301) 442 4742", "+92 (313) 753 5365", "+92 (315) 651 4668", "+92 (316) 616 6408", "+92 (334) 112 6355", "+92 (324) 422 7760", "+92 (336) 786 4805", "+92 (338) 860 4180", "+92 (317) 404 1136", "+92 (333) 506 7452", "+92 (331) 885 5308", "+92 (327) 883 1783", "+92 (306) 331 1388", "+92 (301) 421 3682", "+92 (318) 025 1434", "+92 (333) 122 3674", "+92 (314) 657 6471", "+92 (306) 180 2386", "+92 (315) 572 5133", "+92 (311) 620 3644", "+92 (318) 451 6657", "+92 (327) 868 4180", "+92 (327) 315 1422", "+92 (325) 655 6065", "+92 (312) 653 7064", "+92 (324) 168 2330", "+92 (325) 233 0561", "+92 (330) 726 8615", "+92 (316) 076 2140", "+92 (325) 782 5605", "+92 (332) 652 6485", "+92 (322) 807 1788", "+92 (305) 656 1200", "+92 (317) 514 6875", "+92 (313) 577 4641", "+92 (325) 802 4317", "+92 (323) 530 4064", "+92 (316) 265 6040", "+92 (331) 882 5661", "+92 (312) 652 6383", "+92 (307) 804 3032", "+92 (334) 753 7100", "+92 (317) 787 6787", "+92 (312) 567 6467", "+92 (300) 210 0430", "+92 (325) 313 2488", "+92 (311) 284 7758", "+92 (325) 440 7610", "+92 (336) 136 3610", "+92 (302) 021 3846", "+92 (310) 878 6343", "+92 (331) 727 3114", "+92 (306) 350 5763", "+92 (316) 622 0084", "+92 (322) 743 7554", "+92 (307) 757 3552", "+92 (325) 104 4534", "+92 (306) 747 0562", "+92 (330) 741 7754", "+92 (321) 513 6244", "+92 (304) 678 1280", "+92 (308) 018 3212", "+92 (311) 238 3186", "+92 (318) 450 4783", "+92 (302) 362 2165", "+92 (323) 576 3067", "+92 (328) 006 8543", "+92 (318) 306 5310", "+92 (326) 533 7647", "+92 (330) 845 8535", "+92 (325) 217 0370", "+92 (336) 746 1107", "+92 (312) 624 5734", "+92 (306) 286 0504", "+92 (301) 063 5608", "+92 (325) 641 3545", "+92 (311) 785 5360", "+92 (331) 808 5821", "+92 (331) 257 3212", "+92 (320) 871 1021", "+92 (313) 054 6555", "+92 (327) 133 2437", "+92 (336) 210 8837", "+92 (301) 062 0603", "+92 (308) 673 3162", "+92 (327) 547 5486", "+92 (317) 571 8081", "+92 (303) 517 0081", "+92 (326) 065 5272", "+92 (335) 261 7380", "+92 (335) 346 1654", "+92 (328) 571 1571", "+92 (300) 125 7047", "+92 (320) 712 7327", "+92 (332) 564 7345", "+92 (322) 256 1152", "+92 (320) 830 7246", "+92 (300) 806 2421", "+92 (301) 434 7814", "+92 (314) 076 8230", "+92 (325) 168 2023", "+92 (336) 466 6411", "+92 (335) 470 7667", "+92 (334) 447 2776", "+92 (302) 708 3706", "+92 (302) 852 5785", "+92 (336) 522 8808", "+92 (314) 180 7243", "+92 (308) 470 5136", "+92 (333) 084 8324", "+92 (330) 437 0843", "+92 (328) 810 1775", "+92 (313) 708 1215", "+92 (317) 756 8871", "+92 (317) 232 8002", "+92 (306) 024 7223", "+92 (338) 241 8280", "+92 (323) 870 0517", "+92 (336) 064 0476", "+92 (318) 616 5257", "+92 (301) 043 1286", "+92 (332) 178 6454", "+92 (318) 322 5100", "+92 (318) 184 4084", "+92 (334) 768 8286", "+92 (312) 626 6142", "+92 (333) 326 6448", "+92 (318) 521 5065", "+92 (322) 381 5162", "+92 (327) 056 2443", "+92 (316) 384 0387", "+92 (331) 157 8358", "+92 (333) 751 6550", "+92 (305) 563 3313", "+92 (324) 220 1570", "+92 (321) 057 0564", "+92 (302) 853 8342", "+92 (325) 002 4156", "+92 (322) 274 6885", "+92 (308) 574 2308", "+92 (303) 782 2721", "+92 (313) 267 8741", "+92 (327) 877 4073", "+92 (321) 831 3254", "+92 (318) 037 4838", "+92 (317) 254 0628", "+92 (331) 344 1636", "+92 (332) 273 5453", "+92 (318) 161 8138", "+92 (338) 315 8803", "+92 (330) 378 8120", "+92 (327) 125 6506", "+92 (338) 631 4447", "+92 (310) 504 1341", "+92 (337) 303 1074", "+92 (303) 416 3713", "+92 (322) 821 7811", "+92 (331) 872 3252", "+92 (318) 604 6676", "+92 (316) 383 1662", "+92 (317) 485 6302", "+92 (313) 715 3725", "+92 (336) 035 3047", "+92 (310) 101 4524", "+92 (305) 463 8322", "+92 (305) 366 1783", "+92 (325) 388 5600", "+92 (325) 746 6638", "+92 (322) 833 8176", "+92 (305) 356 3327", "+92 (311) 560 5884", "+92 (338) 171 4428", "+92 (305) 340 2644", "+92 (324) 147 0156", "+92 (333) 420 5426", "+92 (318) 165 2608", "+92 (326) 184 5407", "+92 (316) 111 8046", "+92 (314) 624 7880", "+92 (313) 084 7725", "+92 (328) 063 2444", "+92 (334) 618 7113", "+92 (337) 276 0888", "+92 (327) 528 8026", "+92 (312) 310 0130", "+92 (317) 721 0874", "+92 (308) 847 1172", "+92 (300) 428 8126", "+92 (302) 077 3722", "+92 (314) 325 2543", "+92 (313) 506 1302", "+92 (305) 122 3737", "+92 (302) 752 6357", "+92 (324) 022 6028", "+92 (338) 222 7078", "+92 (320) 213 7517", "+92 (331) 213 8817", "+92 (310) 068 5358", "+92 (338) 620 5566", "+92 (335) 626 8240", "+92 (315) 652 1817", "+92 (332) 846 6577", "+92 (335) 885 7711", "+92 (317) 887 6852", "+92 (306) 000 3508", "+92 (302) 874 1686", "+92 (314) 762 2085", "+92 (337) 844 7485", "+92 (330) 777 1026", "+92 (336) 716 4556", "+92 (301) 108 6281", "+92 (335) 254 1552", "+92 (311) 054 3172", "+92 (333) 552 0287", "+92 (303) 186 8664", "+92 (325) 041 6053", "+92 (301) 514 7068", "+92 (336) 823 2382", "+92 (307) 353 0800", "+92 (333) 704 3385", "+92 (310) 437 4860", "+92 (321) 585 5306", "+92 (317) 407 7052", "+92 (314) 302 1804", "+92 (323) 408 8585", "+92 (335) 354 4567", "+92 (301) 376 5687", "+92 (326) 467 4706", "+92 (301) 821 2724", "+92 (304) 034 4315", "+92 (335) 716 3762", "+92 (308) 133 5733", "+92 (337) 284 0511", "+92 (324) 341 2386", "+92 (328) 235 4226", "+92 (316) 126 8582", "+92 (302) 242 2400", "+92 (318) 340 6838", "+92 (322) 256 2733", "+92 (335) 374 3860", "+92 (334) 715 5133", "+92 (306) 317 2016", "+92 (320) 828 8337", "+92 (328) 534 2567", "+92 (326) 617 6452", "+92 (314) 720 4233", "+92 (317) 023 4610", "+92 (314) 713 7561", "+92 (328) 222 1817", "+92 (335) 283 2364", "+92 (332) 363 6001", "+92 (326) 540 1332", "+92 (316) 624 0821", "+92 (336) 052 4752", "+92 (310) 514 6312", "+92 (323) 112 3030", "+92 (300) 263 2664", "+92 (328) 037 1480", "+92 (317) 538 0664", "+92 (336) 631 3570", "+92 (303) 410 4255", "+92 (332) 450 1286", "+92 (310) 537 6050", "+92 (300) 200 1104", "+92 (336) 175 6245", "+92 (301) 852 4125", "+92 (334) 276 6570", "+92 (337) 673 8378", "+92 (306) 041 1858", "+92 (325) 443 2745", "+92 (310) 277 2755", "+92 (330) 161 2625", "+92 (320) 364 2646", "+92 (337) 048 3076", "+92 (311) 565 0688", "+92 (303) 445 1032", "+92 (327) 263 6168", "+92 (324) 784 1040", "+92 (320) 572 0418", "+92 (333) 482 1875", "+92 (338) 544 5218", "+92 (306) 618 5530", "+92 (320) 000 2431", "+92 (328) 346 4248", "+92 (332) 241 7422", "+92 (305) 440 0012", "+92 (324) 451 2733", "+92 (318) 255 4867", "+92 (302) 738 4437", "+92 (332) 427 0108", "+92 (321) 300 0483", "+92 (302) 680 1783", "+92 (313) 533 7440", "+92 (333) 605 7573", "+92 (322) 606 4167", "+92 (334) 818 6024", "+92 (333) 053 6064", "+92 (333) 245 4261", "+92 (300) 423 7811", "+92 (321) 128 1720", "+92 (328) 265 3640", "+92 (337) 888 3112", "+92 (326) 761 5407", "+92 (320) 155 7256", "+92 (320) 404 0628", "+92 (333) 180 1576", "+92 (318) 046 1405", "+92 (335) 167 6683", "+92 (317) 007 1388", "+92 (337) 540 5800", "+92 (333) 043 8586", "+92 (322) 788 8264", "+92 (308) 307 2054", "+92 (315) 011 7121", "+92 (333) 822 8314", "+92 (337) 660 5386", "+92 (332) 535 5188", "+92 (333) 328 5115", "+92 (337) 228 5066", "+92 (323) 412 4062", "+92 (314) 134 6276", "+92 (327) 507 2674", "+92 (307) 271 8722", "+92 (325) 348 0843", "+92 (325) 380 8821", "+92 (335) 070 7356", "+92 (330) 416 5243", "+92 (334) 022 5371", "+92 (324) 703 3150", "+92 (310) 430 7387", "+92 (336) 308 8663", "+92 (311) 116 3886", "+92 (338) 572 2043", "+92 (326) 715 5632", "+92 (316) 287 4021", "+92 (314) 304 1511", "+92 (333) 150 1405", "+92 (318) 774 6731", "+92 (322) 810 2760", "+92 (304) 038 5777", "+92 (312) 210 7703", "+92 (321) 074 6620", "+92 (316) 381 0633", "+92 (314) 258 1186", "+92 (338) 100 7238", "+92 (320) 556 5551", "+92 (316) 306 2785", "+92 (332) 221 1403", "+92 (324) 626 2883", "+92 (316) 246 2304", "+92 (332) 648 0665", "+92 (332) 243 1842", "+92 (308) 486 6277", "+92 (315) 238 6624", "+92 (315) 357 2316", "+92 (305) 775 7086", "+92 (327) 373 1063", "+92 (328) 247 3277", "+92 (318) 154 2306", "+92 (325) 018 0763", "+92 (336) 606 1040", "+92 (326) 403 0727", "+92 (315) 250 5275", "+92 (308) 066 1265", "+92 (333) 568 1424", "+92 (300) 786 2857", "+92 (323) 435 1550", "+92 (333) 727 8435", "+92 (310) 881 5112", "+92 (307) 882 5312", "+92 (302) 445 8778", "+92 (311) 800 0008", "+92 (317) 640 7531", "+92 (333) 237 6177", "+92 (318) 464 0016", "+92 (305) 006 1547", "+92 (322) 875 7103", "+92 (301) 556 0062", "+92 (336) 871 6340", "+92 (322) 065 3615", "+92 (316) 823 7423", "+92 (318) 444 7450", "+92 (303) 666 6444", "+92 (336) 070 6183", "+92 (320) 016 2208", "+92 (322) 622 0766", "+92 (333) 537 5127", "+92 (330) 377 4220", "+92 (313) 405 2686", "+92 (323) 406 6056", "+92 (300) 037 8734", "+92 (305) 848 4165", "+92 (321) 704 8336", "+92 (303) 182 0734", "+92 (316) 225 5822", "+92 (307) 046 6381", "+92 (337) 788 2286", "+92 (338) 042 2458", "+92 (336) 778 4674", "+92 (306) 203 7522", "+92 (315) 370 0243", "+92 (300) 038 1033", "+92 (322) 083 3875", "+92 (316) 148 6546", "+92 (300) 668 2808", "+92 (323) 430 2560", "+92 (320) 414 7440", "+92 (300) 800 6458", "+92 (314) 470 1187", "+92 (325) 327 8826", "+92 (327) 547 4614", "+92 (337) 774 7418", "+92 (314) 011 6573", "+92 (306) 580 1362", "+92 (337) 131 8866", "+92 (312) 276 3010", "+92 (328) 753 2824", "+92 (305) 273 1681", "+92 (338) 886 4573", "+92 (314) 136 2268", "+92 (323) 380 3355", "+92 (314) 824 8845", "+92 (334) 431 2253", "+92 (307) 156 7677", "+92 (333) 117 0783", "+92 (331) 013 5573", "+92 (300) 870 5171", "+92 (338) 028 5733", "+92 (335) 118 7133", "+92 (312) 463 5666", "+92 (331) 440 6131", "+92 (316) 487 3805", "+92 (326) 624 0734", "+92 (314) 863 7845", "+92 (316) 181 2687", "+92 (301) 835 2063", "+92 (331) 882 5684", "+92 (333) 110 8655", "+92 (305) 583 0513", "+92 (301) 864 0378", "+92 (307) 834 2234", "+92 (302) 288 0455", "+92 (316) 843 1038", "+92 (304) 765 1721", "+92 (321) 547 6215", "+92 (312) 507 5302", "+92 (338) 832 2811", "+92 (314) 575 4485", "+92 (314) 045 7821", "+92 (313) 330 7751", "+92 (313) 458 1023", "+92 (312) 237 1866", "+92 (328) 158 5722", "+92 (301) 663 6682", "+92 (313) 044 2852", "+92 (331) 108 2005", "+92 (331) 230 4222", "+92 (323) 437 2121", "+92 (324) 727 5827", "+92 (303) 356 2517", "+92 (333) 284 0116", "+92 (300) 821 0324", "+92 (310) 552 0533", "+92 (334) 616 7264", "+92 (325) 056 4214", "+92 (334) 353 3453", "+92 (338) 185 7472", "+92 (327) 830 4315", "+92 (325) 183 3332", "+92 (301) 802 7623", "+92 (333) 257 3838", "+92 (317) 502 8321", "+92 (300) 226 5635", "+92 (308) 535 3013", "+92 (313) 472 6065", "+92 (307) 016 1843", "+92 (301) 661 1410", "+92 (331) 543 0253", "+92 (328) 284 0678"},
								  rgynss = {"Ahmed Raza", "Bilal Tariq", "Usman Siddiqi", "Omar Farooq", "Waleed Kamal", "Talha Iqbal", "Faisal Latif", "Hassan Jameel", "Adnan Bashir", "Kashif Rauf", "Imran Saeed", "Adeel Qureshi", "Zeeshan Hashmi", "Shoaib Nadeem", "Noman Shahid", "Faizan Khalid", "Hammad Zubair", "Naveed Aslam", "Waqar Mehmood", "Sarmad Sheikh", "Tariq Anwar", "Junaid Riaz", "Sufyan Abbas", "Shahzad Hussain", "Mudassir Younas", "Jawad Hamid", "Ammar Khalil", "Rizwan Waheed", "Hasnain Saleem", "Basit Jamal", "Sheraz Ahmed", "Umer Shahbaz", "Arsalan Hashim", "Raheel Sultan", "Fahad Zaman", "Sajid Irfan", "Owais Rauf", "Sarfaraz Kamran", "Khizar Ali", "Ahsan Waseem", "Tauseef Haroon", "Murtaza Shah", "Maaz Asif", "Samiullah Arif", "Nabeel Qamar", "Taimoor Rauf", "Atif Nawaz", "Hashir Siddiqui", "Zubair Imran", "Abrar Hussain", "Farhan Waseem", "Umair Tariq", "Arif Ali", "Shayan Latif", "Irfan Khalid", "Hamza Masood", "Sameer Riaz", "Shoaib Hanif", "Adil Jameel", "Ahmed Saeed", "Mudassir Kamal", "Haris Younas", "Noman Waqar", "Waseem Abbas", "Faizan Rauf", "Mubashir Jamil", "Sohail Shahzad", "Ubaid Latif", "Sikandar Saeed", "Hasham Khalid", "Farrukh Hussain", "Zain Qureshi", "Arslan Abbas", "Muzammil Tariq", "Usama Rasheed", "Adeel Sultan", "Taha Iqbal", "Kamil Arshad", "Danish Rauf", "Talal Farooq", "Sarmad Mehmood", "Shoaib Azhar", "Omer Siddiqi", "Dawood Mushtaq", "Ammar Waheed", "Fasih Shah", "Adnan Khalil", "Imran Waseem", "Waleed Anwar", "Yasir Rauf", "Arham Bashir", "Shehryar Latif", "Azhar Siddiqui", "Jibran Hussain", "Hassan Qamar", "Usman Kamal", "Tariq Yousaf", "Owais Farooq", "Raheel Bashir", "Waqas Khalid", "Faisal Shah", "Bilal Latif", "Zeeshan Abbas", "Faizan Hussain", "Mudassir Farooq", "Kashif Khalid", "Abrar Tariq", "Umair Siddiqi", "Hamza Jameel", "Nabeel Usman", "Khalil Laghari", "Murtaza Waseem", "Sajid Waheed", "Noman Riaz", "Hashir Hussain", "Sheraz Rauf", "Ahmed Tariq", "Atif Bashir", "Omar Siddiqui", "Irfan Khalil", "Raheel Jamil", "Tauseef Rauf", "Hammad Abbas", "Hasnain Kamran", "Waleed Hussain", "Taimoor Abbas", "Mudassir Waheed", "Umer Khalid", "Khurram Anwar", "Junaid Bashir", "Shayan Rauf", "Ahmed Hanif", "Bilal Hussain", "Umair Riaz", "Zubair Khalid", "Adeel Haroon", "Sajid Qamar", "Faizan Latif", "Hammad Saleem", "Shoaib Tariq", "Noman Anwar", "Fahad Hussain", "Hashim Waseem", "Hamza Abbas", "Arsalan Khalid", "Taha Rasheed", "Usama Farooq", "Sarim Bashir", "Khizar Waheed", "Mudassir Khalid", "Waqas Rauf", "Tariq Hussain", "Jawad Siddiqui", "Shehryar Abbas", "Naveed Tariq", "Muzammil Jamil", "Zeeshan Khalid", "Atif Hussain", "Sarmad Waqar", "Shoaib Khalid", "Ahmed Qureshi", "Raheel Abbas", "Hammad Riaz", "Sheraz Bashir", "Danish Khalid", "Adil Waheed", "Hashir Tariq", "Faizan Waseem", "Usman Abbas", "Khurram Latif", "Owais Siddiqui", "Mudassir Hussain", "Tauseef Khalid", "Farrukh Waseem", "Umer Saleem", "Hamza Rauf", "Shoaib Kamran", "Bilal Abbas", "Sajid Tariq", "Faizan Shahbaz", "Hasnain Abbas", "Abrar Khalid", "Ahmed Farooq", "Atif Khalid", "Irfan Waseem", "Junaid Tariq", "Umair Saleem", "Arsalan Hussain", "Waleed Abbas", "Adnan Waseem", "Sheraz Khalid", "Mudassir Abbas", "Shoaib Rauf", "Omar Hussain", "Raheel Khalid", "Hammad Waseem", "Waseem Farooq", "Hasham Tariq", "Faisal Khalid", "Kashif Abbas", "Tauseef Abbas", "Hamza Saleem", "Zeeshan Waseem", "Sarmad Hussain", "Bilal Khalid", "Umair Abbas", "Mudassir Riaz", "Adil Khalid", "Ahmed Abbas", "Owais Hussain"},
								  rglnss = {"Ayesha Waleed", "Fatima Kamal", "Hira Latif", "Sana Farooq", "Mahnoor Tariq", "Faiza Tehseem", "Fozia Mehshar", "Iqra Siddiqui", "Laiba Aslam", "Anum Riaz", "Saba Kiani", "Hafsa Saeed", "Sidra Hashmi", "Zunaira Naz", "Sadaf Bhutto", "Kiran Jameel", "Rida Abbas", "Nimra Waseem", "Huma Tariq", "Samina Khalid", "Zeenat Rauf", "Amna Waheed", "Neelam Hashmi", "Aiman Qamar", "Romaisa Hussain", "Fareeda Asif", "Sania Anwar", "Humaisa Khalil", "Asma Riaz", "Sadia Kamran", "Sehrish Waseem", "Uzma Tariq", "Mehwish Latif", "Hina Abbas", "Areeba Waqar", "Tanzeela Jafar", "Anila Saleem", "Mahira Umer", "Bushra Nadeem", "Zoya Mehmood", "Nida Hashim", "Sumaira Yasir", "Mahnoor Hussain", "Komal Saeed", "Laiba Waseem", "Amina Abbas", "Rida Jameel", "Saeeka Haroon", "Zainab Farooq", "Fatima Hussain", "Hafsa Mehmood", "Minal Khawar", "Yumna Tariq", "Ayeza Barkat", "Asia Farhan", "Kinza Jamal", "Mehwish Touseef", "Rimsha Ibrahim", "Neelam Saeed", "Hira Khalid", "Amna Riaz", "Iqra Farooq", "Anum Abbas", "Mehwish Iqrar", "Sumaiya Tariq", "Romaisa Khalil", "Faiza Waseem", "Bushra Farooq", "Sadia Abbas", "Hiba Hussain", "Afshan Siddiqui", "Sana Basit", "Areeba Khalid", "Maira Waseem", "Nimra Hussain", "Sehrish Saleem", "Amna Jameel", "Zoya Khalid", "Mehreen Tariq", "Aiman Abbas", "Komal Riaz", "Hira Saleem", "Palwasha Moazzam", "Laiba Nayyar", "Minahal Tahir", "Mehwish Shuja", "Javeria Feroze", "Zara Munawwar", "Fiza Jatoi", "Fatima Riaz", "Zainab Alvi", "Tanzeela Abbas", "Kiran Waseem", "Ayesha Khalid", "Samina Hussain", "Sadia Waseem", "Bisma Majeed", "Areeba Latif", "Sehrish Tariq", "Hafsa Waseem", "Hina Tariq", "Zoya Saleem", "Maham Khalid", "Muneera Rauf", "Bushra Tariq", "Zeenat Hussain", "Areeba Saleem", "Kainat Rizvi", "Sumaiya Hussain", "Sadia Khalid", "Mahnoor Irshad", "Fatima Jameel", "Sakina Hilaj", "Iqra Danyal", "Hina Riaz", "Neha Saleem", "Mehwish Khalid", "Asma Waseem", "Romaisa Tariq", "Laiba Khalid", "Komal Noor", "Bushra Waseem", "Zainab Tariq", "Sadia Saleem", "Kiran Jamshed", "Uzmia Sayyad", "Komal Hussain", "Maryam Raza", "Romaisa Haroon", "Mehwish Abbas", "Maham Riaz", "Sumaiya Khalid", "Anila Anjum", "Areeba Hussain"},
								  areas_in_karachi = {"Askari 1", "Askari 2", "Askari 3", "Askari 4", "Askari 5", "Bahria Town - Precinct 1", "Bahria Town - Precinct 10", "Bahria Town - Precinct 11", "Bahria Town - Precinct 12", "Bahria Town - Precinct 13", "Bahria Town - Precinct 14", "Bahria Town - Precinct 15", "Bahria Town - Precinct 16", "Bahria Town - Precinct 17", "Bahria Town - Precinct 18", "Bahria Town - Precinct 19", "Bahria Town - Precinct 2", "Bahria Town - Precinct 20", "Bahria Town - Precinct 21", "Bahria Town - Precinct 22", "Bahria Town - Precinct 23", "Bahria Town - Precinct 24", "Bahria Town - Precinct 25", "Bahria Town - Precinct 26", "Bahria Town - Precinct 27", "Bahria Town - Precinct 28", "Bahria Town - Precinct 29", "Bahria Town - Precinct 3", "Bahria Town - Precinct 30", "Bahria Town - Precinct 31", "Bahria Town - Precinct 32", "Bahria Town - Precinct 33", "Bahria Town - Precinct 4", "Bahria Town - Precinct 5", "Bahria Town - Precinct 6", "Bahria Town - Precinct 7", "Bahria Town - Precinct 8", "Bahria Town - Precinct 9", "BufferZone - Sector 15 A 1", "BufferZone - Sector 15 A 2", "BufferZone - Sector 15 A 3", "BufferZone - Sector 15 A 4", "BufferZone - Sector 15 A 5", "BufferZone - Sector 15 B", "BufferZone - Sector 16 A", "BufferZone - Sector 16 B", "Cantonment", "Clifton - Block 1", "Clifton - Block 2", "Clifton - Block 3", "Clifton - Block 4", "Clifton - Block 5", "Clifton - Block 6", "Clifton - Block 7", "Clifton - Block 8", "Clifton - Block 9", "Clifton - Kehkashan", "DHA - Phase 1", "DHA - Phase 2", "DHA - Phase 3", "DHA - Phase 4", "DHA - Phase 5", "DHA - Phase 6", "DHA - Phase 7", "DHA - Phase 8", "DHA - Phase 9", "F.B Area - Azizabad", "F.B Area - B1 Area", "F.B Area - B Area", "F.B Area - Block 1", "F.B Area - Block 10", "F.B Area - Block 11", "F.B Area - Block 12", "F.B Area - Block 13", "F.B Area - Block 14", "F.B Area - Block 15", "F.B Area - Block 16", "F.B Area - Block 17", "F.B Area - Block 18", "F.B Area - Block 19", "F.B Area - Block 2", "F.B Area - Block 20", "F.B Area - Block 21", "F.B Area - Block 22", "F.B Area - Block 3", "F.B Area - Block 4", "F.B Area - Block 5", "F.B Area - Block 6", "F.C Area - C1 Area", "F.C Area - C Area", "Garden - Garden East", "Garden - Garden West", "Garden - Soldier Bazaar", "Gulistan-e-Johar - Block 1", "Gulistan-e-Johar - Block 10", "Gulistan-e-Johar - Block 11", "Gulistan-e-Johar - Block 12", "Gulistan-e-Johar - Block 13", "Gulistan-e-Johar - Block 14", "Gulistan-e-Johar - Block 15", "Gulistan-e-Johar - Block 16", "Gulistan-e-Johar - Block 17", "Gulistan-e-Johar - Block 18", "Gulistan-e-Johar - Block 19", "Gulistan-e-Johar - Block 2", "Gulistan-e-Johar - Block 20", "Gulistan-e-Johar - Block 3", "Gulistan-e-Johar - Block 4", "Gulistan-e-Johar - Block 5", "Gulistan-e-Johar - Block 6", "Gulistan-e-Johar - Block 7", "Gulistan-e-Johar - Block 8", "Gulistan-e-Johar - Block 9", "Gulshan-e-Hadeed - Data Nagar", "Gulshan-e-Hadeed - EIDU Goth", "Gulshan-e-Hadeed - Gulshan-e-Mauzzam", "Gulshan-e-Hadeed - Gulshan-e-Rehman", "Gulshan-e-Hadeed - Mehran Road", "Gulshan-e-Hadeed - Phase 1", "Gulshan-e-Hadeed - Phase 2", "Gulshan-e-Hadeed - Phase 3", "Gulshan-e-Hadeed - PTCL Satellite Station", "Gulshan-e-Hadeed - Shah Latif Town", "Gulshan-e-Hadeed - Shahnawaz Goth", "Gulshan-e-Hadeed - Shah Town", "Gulshan-e-Hadeed - Steel Town", "Gulshan-e-Hadeed - TCP Godowns", "Gulshan-e-Iqbal - Adamjee Nagar", "Gulshan-e-Iqbal - Block 1", "Gulshan-e-Iqbal - Block 10", "Gulshan-e-Iqbal - Block 11", "Gulshan-e-Iqbal - Block 12", "Gulshan-e-Iqbal - Block 13", "Gulshan-e-Iqbal - Block 14", "Gulshan-e-Iqbal - Block 15", "Gulshan-e-Iqbal - Block 16", "Gulshan-e-Iqbal - Block 17", "Gulshan-e-Iqbal - Block 18", "Gulshan-e-Iqbal - Block 19", "Gulshan-e-Iqbal - Block 2", "Gulshan-e-Iqbal - Block 3", "Gulshan-e-Iqbal - Block 4", "Gulshan-e-Iqbal - Block 5", "Gulshan-e-Iqbal - Block 6", "Gulshan-e-Iqbal - Block 7", "Gulshan-e-Iqbal - Block 8", "Gulshan-e-Iqbal - Block 9", "Gulshan-e-Iqbal - Civic Center", "Gulshan-e-Iqbal - Dhoraji", "Korangi - Abdullah Shah Noorani Pahari Colony", "Korangi - Korangi Industrial Area", "Korangi - Nasir Colony", "Korangi - PAF Base Korangi Creek", "Korangi - Zaman Town", "Korangi - Zia Colony", "Landhi - Alflah Housing Society", "Landhi - Awami Colony", "Landhi - Bagh-e-Korangi", "Landhi - Bakhtawar Goth", "Landhi - Barmi Colony", "Landhi - Bhutto Nagar", "Landhi - Future Colony", "Landhi - Gulshan-e-Rafi", "Landhi - Ilyas Goth", "Landhi - Labour Colony", "Landhi - Landhi Industrial Area", "Landhi - Muslimabad Colony", "Landhi - Muzaffarabad Colony", "Landhi - Punjab Town", "Landhi - Qasim Town", "Landhi - Sadat Colony", "Landhi - Shah Khalid Colony", "Landhi - Sharafi Goth", "Landhi - Zamanabad", "Liaquatabad - Block 1", "Liaquatabad - Block 10", "Liaquatabad - Block 2", "Liaquatabad - Block 3", "Liaquatabad - Block 4", "Liaquatabad - Block 5", "Liaquatabad - Block 6", "Liaquatabad - Block 7", "Liaquatabad - Block 8", "Liaquatabad - Block 9", "Malir - Malir Halt", "Malir - Malir Cantt", "Nazimabad - Block 1", "Nazimabad - Block 2", "Nazimabad - Block 3", "Nazimabad - Block 4", "Nazimabad - Block 5", "North Karachi - Sector 10", "North Karachi - Sector 11 - A", "North Karachi - Sector 11 - B", "North Karachi - Sector 11 - C 1", "North Karachi - Sector 11 - C 2", "North Karachi - Sector 11 - C 3", "North Karachi - Sector 11 - E", "North Karachi - Sector 11 - H", "North Karachi - Sector 11 - I", "North Karachi - Sector 11 - K", "North Karachi - Sector 11 - L", "North Karachi - Sector 2", "North Karachi - Sector 3", "North Karachi - Sector 4", "North Karachi - Sector 5 - A 1", "North Karachi - Sector 5 - A 2", "North Karachi - Sector 5 - A 3", "North Karachi - Sector 5 - A 4", "North Karachi - Sector 5 - B 1", "North Karachi - Sector 5 - B 2", "North Karachi - Sector 5 - B 3", "North Karachi - Sector 5 - B 4", "North Karachi - Sector 5 - C 1", "North Karachi - Sector 5 - C 2", "North Karachi - Sector 5 - C 3", "North Karachi - Sector 5 - C 4", "North Karachi - Sector 5 - I", "North Karachi - Sector 5 - J", "North Karachi - Sector 5 - K", "North Karachi - Sector 5 - L", "North Karachi - Sector 5 - M", "North Karachi - Sector 6", "North Karachi - Sector 7 - D 1", "North Karachi - Sector 7 - D 2", "North Karachi - Sector 7 - D 3", "North Karachi - Sector 7 - D 4", "North Karachi - Sector 8", "North Karachi - Sector 9", "North Nazimabad - Block A", "North Nazimabad - Block B", "North Nazimabad - Block C", "North Nazimabad - Block D", "North Nazimabad - Block E", "North Nazimabad - Block F", "North Nazimabad - Block G", "North Nazimabad - Block H", "North Nazimabad - Block I", "North Nazimabad - Block J", "North Nazimabad - Block K", "North Nazimabad - Block L", "North Nazimabad - Block M", "North Nazimabad - Block N", "North Nazimabad - Block O", "North Nazimabad - Block P", "North Nazimabad - Block Q", "North Nazimabad - Block R", "North Nazimabad - Block S", "North Nazimabad - Block T", "Old Town - Bhimpora", "Old Town - Bohra Pir", "Old Town - Bombay Bazar", "Old Town - Jodia Bazar", "Old Town - Kagzi Bazar", "Old Town - Kakri Ground", "Old Town - Kamil Gali", "Old Town - Khada Market", "Old Town - Kharadar", "Old Town - Lee Market", "Old Town - Mithadar", "Old Town - Nanwara", "Old Town - Nishter Road", "Old Town - Pan Mandi", "Old Town - Ramswami", "Old Town - Ranchorline", "Orangi Town - Banaras Town", "Orangi Town - Bangla Bazaar", "Orangi Town - Bilal Colony", "Orangi Town - Katti Pahari", "Orangi Town - Moria Goth Orangi", "Orangi Town - Orangi", "Orangi Town - Sector 14 - A", "Orangi Town - Sector 14 - C", "Orangi Town - Thorani Goth", "Baldiya Town", "Baloch Colony", "Civil Line", "FC Area", "Firdous Colony", "Gulshan-e-Maymar", "Hawksbay", "I.I Chundrigar", "Jamshed Road", "K.D.A Officers", "Kemari", "Liyari", "M.A Jinnah Rd", "Manora", "New Karachi", "New Surjani", "PIB Colony", "Pipri Goth", "Rizvia Society", "Saddar", "Scheme 33", "Shabbirabad", "P.E.C.H.S - Block 1", "P.E.C.H.S - Block 2", "P.E.C.H.S - Block 3", "P.E.C.H.S - Block 4", "P.E.C.H.S - Block 5", "P.E.C.H.S - Block 6", "P.E.C.H.S - Khalid Bin Walid", "P.E.C.H.S - Tariq Road", "S.I.T.E - Golimar", "S.I.T.E - S.I.T.E", "Shah Faisal Colony - Aswan Town", "Shah Faisal Colony - Gulshan-e-Asghar", "Shah Faisal Colony - Shah Faisal Colony 1", "Shah Faisal Colony - Shah Faisal Colony 5", "F.B Area - Block 7", "F.B Area - Block 9", "P.E.C.H.S - Block 7", "Aram Bagh", "Bath Island", "University Road", "Bahadurabad", "Shah Faisal Colony - 4", "Banglore Town", "Fowler Lines", "Shah Faisal Colony - Shamsi Society", "Gulshan-e-Jamal", "Shah Faisal Colony - 3", "Shah Faisal Colony - Green Town", "Darwaish Colony", "Korangi - Sector 31 B", "Firdous Colony", "North Nazimabad - Block W", "K.A.E.C.H.S", "Mehmoodabad", "Korangi - Mehran Town", "Landhi Town - 36 B", "Karachi Memon Society", "Madras Cooperative Housing Society", "Shahrah-e-Faisal", "Korangi - Sector 41 B", "Clifton - Delhi Colony", "Korangi - Sector 32 B", "Dhoraji - Adamjee Nagar", "Bhimpura", "Dhoraji - CP& Berar Society", "Shahra-e-Faisal - Umar Colony", "Model Colony", "Gulshan-e-Shamim", "Clifton - Shah Rasool Colony", "North Karachi - Sector 12 C", "Jail Road - Hyderabad Colony", "Napier Quarter", "Gulzar-e-Hijri", "North Karachi - Sector 12 A", "Shahra-e-Faisal - Jinnah Housing Society", "K.D.A Scheme 1", "Clifton - Punjab Colony", "Korangi - Sector 31 D", "Clifton - Zamzama", "Parsi Colony", "Qayyumabad", "Khokrapar", "Shah Faisal Colony - Muslimabad Malir City", "F.B Area - Block 8", "Nanak Wara", "Mohammad Ali Society", "Manzoor Colony", "Dalmia", "Defence View - Phase 1", "Defence View - Phase 2", "KDA Officers Housing Society", "Karimabad", "Soldier Bazar", "Hussainabad", "Sharfabad Society", "Gharibabad", "Sindhi Muslim Cooperative Housing Society"},
								  rndcts = {"Your heart is the size of an ocean. Go find yourself in its hidden depths.", "The bay of bengal is hit frequently by cyclones. The months of november and may, in particular, are dangerous in this regard.", "Thinking is the capital, enterprise is the way, hard work is the solution.", "If you can\'t make it good, at least make it look good.", "Heart be brave. If you cannot be brave, just go. Love\'s glory is not a small thing.", "It is bad for a young man to sin; but it is worse for an old man to sin.", "If you are out to describe the truth, leave elegance to the tailor.", "O man you are busy working for the world, and the world is busy trying to turn you out.", "While children are struggling to be unique, the world around them is trying all means to make them look like everybody else.", "These capitalists generally act harmoniously and in concert, to fleece the people.", "I don\'t believe in failure. It is not failure if you enjoyed the process.", "Do not get elated at any victory, for all such victory is subject to the will of god.", "Wear gratitude like a cloak and it will feed every corner of your life.", "If you even dream of beating me you\'d better wake up and apologize.", "I will praise any man that will praise me.", "One of the greatest diseases is to be nobody to anybody.", "I\'m so fast that last night I turned off the light switch in my hotel room and was in bed before the room was dark.", "People must learn to hate and if they can learn to hate, they can be taught to love.", "Everyone has been made for some particular work, and the desire for that work has been put in every heart.", "The less of the world, the freer you live.", "Respond to every call that excites your spirit.", "The way to get started is to quit talking and begin doing.", "God doesn\'t require us to succeed, he only requires that you try.", "Speak any language, turkish, greek, persian, arabic, but always speak with love.", "Happiness comes towards those which believe in him.", "Knowledge is of two kinds: that which is absorbed and that which is heard. And that which is heard does not profit if it is not absorbed.", "When I am silent, I have thunder hidden inside.", "Technological progress is like an axe in the hands of a pathological criminal.", "No one would choose a friendless existence on condition of having all the other things in the world.", "Life is a gamble. You can get hurt, but people die in plane crashes, lose their arms and legs in car accidents; people die every day. Same with fighters: some die, some get hurt, some go on. You just don\'t let yourself believe it will happen to you.", "The end of life is to be like god, and the soul following god will be like him.", "Let us sacrifice our today so that our children can have a better tomorrow.", "Your task is not to seek for love, but merely to seek and find all the barriers within yourself that you have built against it.", "In every religion there is love, yet love has no religion.", "Everything in the universe is within you. Ask all from yourself.", "I\'m not a handsome guy, but I can give my hand to someone who needs help. Beauty is in the heart, not in the face.", "What do I wear in bed? Why, chanel no. 5, of course.", "A good head and a good heart are always a formidable combination.", "The soul never thinks without a picture.", "In your light I learn how to love. In your beauty, how to make poems. You dance inside my chest where no-one sees you, but sometimes I do, and that sight becomes this art.", "Let the beauty we love be what we do. There are hundreds of ways to kneel and kiss the ground.", "If you like your brother and he\'s prospering, you\'ll be pleased for him.", "Success is dependent upon the glands - sweat glands.", "Champions are not generated from the championship. Champion is generated from something they have in them, desires, dreams, and visions.", "No matter what is the environment around you, it is always possible to maintain your brand of integrity.", "Applause waits on success.", "Just as courage imperils life, fear protects it.", "It\'s better to be a lion for a day than a sheep all your life.", "The devil\'s voice is sweet to hear.", "Sometimes the people with the worst past, create the best future.", "Every day, nay every moment, try to do some good deed.", "No matter what people tell you, words and ideas can change the world.", "Champions have to have the skill and the will. But the will must be stronger than the skill.", "Men occasionally stumble over the truth, but most of them pick themselves up and hurry off as if nothing had happened.", "Goodbyes are only for those who love with their eyes. Because for those who love with heart and soul there is no such thing as separation.", "The best revenge is to improve yourself.", "Success is a personal standard, reaching for the highest that is in us, becoming all that we can be.", "When you have really exhausted an experience you always reverence and love it.", "Now you see me, now you don\'t. George thinks he will, but I know he won\'t!", "Elegance does not consist in putting on a new dress.", "It is always consoling to think of suicide: in that way one gets through many a bad night.", "Eating words has never given me indigestion.", "India has to be transformed into a developed nation, a prosperous nation and a healthy nation, with a value system.", "It\'s not bragging if you can back it up.", "I wish people would love everybody else the way they love me. It would be a better world.", "Why do I want my wife to show off her panties when the wind blows? Horses show their behinds, and cows and mules, not humans.", "Words are only painted fire; a look is the fire itself.", "Words, without power, is mere philosophy.", "The cure for pain is in the pain.", "Whatever happens, just keep smiling and lose yourself in love.", "Do the right thing. It will gratify some people and astonish the rest.", "Only the soul knows what love is.", "Earning of livelihood by following some profession is better than living on charity.", "Burdens are the foundations of ease and bitter things the forerunners of pleasure.", "Too many have dispensed with generosity in order to practice charity.", "Even the greatest was once a beginner. Don\'t be afraid to take that first step.", "No great intellectual thing was ever done by great effort.", "To fight against one\'s desires is the greatest of all fights.", "Innovation distinguishes between a leader and a follower.", "We enjoy the process far more than the proceeds.", "When I started counting my blessings, my whole life turned around.", "This being human is a guest house. Every morning a new arrival. Welcome and entertain them all!", "All my life I\'ve looked at words as though I were seeing them for the first time.", "Waiting is painful. Forgetting is painful. But not knowing which to do is the worse kind of suffering.", "Never allow someone to be your priority while allowing yourself to be their option.", "To jaw-jaw is always better than to war-war.", "That\'s the real trouble with the world, too many people grow up", "It is easier to stay out than get out.", "The worst man is the one who sees himself as the best.", "The world breaks everyone, and afterward, some are strong at the broken places.", "Rule no.1: never lose money. Rule no.2: never forget rule no.1.", "Convergence of our views on global trade issues under the wto and our common resolve to combat terrorism provide a valuable base for mutual understanding.", "Whenever you find yourself on the side of the majority, it is time to pause and reflect.", "Whatever is done for love always occurs beyond good and evil.", "Things should be made as simple as possible, but not any simpler.", "Stop acting so small. You are the universe in ecstatic motion.", "All truth is simple... Is that not doubly a lie?", "Money is only a tool. It will take you wherever you wish, but it will not replace you as the driver.", "The fight is won or lost far away from witnesses - behind the lines, in the gym, and out there on the road, long before I dance under those lights.", "He who avoids complaint invites happiness.", "We are the mirror - as well as the face in it.", "Yesterday I was clever, so I wanted to change the world. Today I am wise, so I am changing myself.", "For 2,500 years, india has never invaded anybody.", "If past history was all there was to the game, the richest people would be librarians.", "Your souls are precious and can only be equal to the price of paradise, therefore sell them only at that price.", "A wise man can learn more from a foolish question than a fool can learn from a wise answer.", "If allah wants for a people ill, he gives them debates and takes away from them actions.", "He who builds a masjid in the way of allah, god will build a house for him in the paradise.", "Love is blind; friendship closes its eyes.", "Don\'t go around saying the world owes you a living. The world owes you nothing. It was here first.", "An alert and learned man will take advice from any event.", "I don\'t count my sit-ups. I only start counting when it starts hurting. When I feel pain, that\'s when I start counting, because that\'s when it really counts.", "The wound is the place where the light enters you.", "Luxury is an obstacle, and so is the fatness of the body.", "Come, come, whoever you are. Wanderer, worshiper, lover of leaving. It doesn\'t matter. Ours is not a caravan of despair. Come, even if you have broken your vows a thousand times. Come, yet again, come, come.", "The golden age is before us, not behind us.", "Fiction is the truth inside the lie.", "Believe you can and you\'re halfway there.", "All the great things are simple, and many can be expressed in a single word: freedom, justice, honor, duty, mercy, hope.", "Allah\'s the arabic term for god. Stand up for god, fight for god, work for god and do the right thing, and go the right way, things will end up in your corner.", "Anger is never without a reason, but seldom with a good one.", "Good actions are a guard against the blows of adversity.", "Use the same measure for selling that you use for purchasing.", "The secret of getting ahead is getting started", "I don\'t know the key to success, but the key to failure is trying to please everybody.", "Real loss is only possible when you love something more than you love yourself.", "This is the first convention of the space age - where a candidate can promise the moon and mean it.", "I don\'t like that man. I must get to know him better.", "To shipbrokers, coal was black gold.", "History, despite its wrenching pain, cannot be unlived, but if faced with courage, need not be lived again.", "Success is not achieved by winning all the time. Real success comes when we rise after we fall. Some mountains are higher than others. Some roads steeper than the next. There are hardships and setbacks but you cannot let them stop you. Even on the steepest road you must not turn back.", "A riot is the language of the unheard.", "The law is reason, free from passion.", "The people who abandon jihad fall a victim to humility and degradation.", "We are all born with a divine fire in us. Our efforts should be to give wings to this fire and fill the world with the glow of its goodness.", "Woman was god\'s second mistake.", "All black americans have slave names. They have white names; names that the slave master has given to them.", "I\'m most proud of my family.", "And you? When will you begin that long journey into yourself?", "How many lessons there are and how little they are taken.", "The best way to make your dreams come true is to wake up.", "What one writer can make in the solitude of one room is something no power can easily destroy.", "If there is something to pardon in everything, there is also something to condemn.", "At home I am a nice guy: but I don\'t want the world to know. Humble people, I\'ve found, don\'t get very far.", "No amount of guilt can change the past and no amount of worrying can change the future.", "Not the ones speaking the same language, but the ones sharing the same feeling understand each other.", "It is better to deserve honors and not have them than to have them and not deserve them.", "Success is a lousy teacher. It seduces smart people into thinking they can\'t lose.", "Cursed is the man who dies, but the evil done by him survives.", "The quality, not the longevity, of one\'s life is what is important.", "Age is whatever you think it is. You are as old as you think you are.", "Derivatives are financial weapons of mass destruction.", "Don\'t you know yet? It is your light that lights the worlds.", "Hold on to your salah, because if you lose that, you will lose everything else.", "I am not this hair. I am not this skin. I am the soul that lives within.", "Be faithful in small things because it is in them that your strength lies.", "He who sleeps without offering the night prayer, may he never enjoy a sound sleep.", "I was influenced a lot by those around me - there was a lot of singing that went on in the cotton fields.", "Greed is permanent slavery.", "Everything that we see is a shadow cast by that which we do not see.", "To the master\'s honor all must turn, each in its track, without a sound, forever tracing newton\'s ground.", "Women are the field that produces our nation. And if you can\'t protect your women, you can\'t protect your nation.", "To give victory to the right, not bloody bullets, but peaceful ballots only, are necessary.", "The ache for home lives in all of us, the safe place where we can go as we are and not be questioned.", "Don\'t be distracted by criticism. Remember ~ the only taste of success some people have is when they take a bite out of you.", "Words are a pretext. It is the inner bond that draws one person to another, not words.", "Where there is no struggle, there is no strength.", "The function of muscle is to pull and not to push, except in the case of the genitals and the tongue.", "Through love, all pain will turn to medicine.", "Do not be embarrassed by your failures, learn from them and start over.", "I know where I\'m going and I know the truth, and I don\'t have to be what you want me to be. I\'m free to be what I want.", "He who prays five times a day is in the protection of god, and he who is protected by god cannot be harmed by anyone.", "I find hope in the darkest of days, and focus in the brightest. I do not judge the universe.", "The wisest among you is he whose sustenance is the fear of allah.", "Because I cannot sleep I make music in the night.", "Strive not to be a success, but rather to be of value.", "If you tell the truth, you don\'t have to remember anything.", "Disneyland will never be completed. It will continue to grow as long as there is imagination left in the world.", "If you have good thoughts they will shine out of your face like sunbeams and you will always look lovely.", "If you wish to be a mine of jewels, open the deep ocean within your heart.", "Let me alone, and go in search of someone else.", "A true friend is one who sees a fault, gives you advice and who defends you in your absence.", "You can tell whether a man is clever by his answers. You can tell whether a man is wise by his questions.", "No one changes the world who isn\'t obsessed.", "The best deed of a great man is to forgive and forget.", "One may sometimes tell a lie, but the grimace that accompanies it tells the truth.", "Do not hate what you do not know, for the greater part of knowledge consists of what you do not know.", "Love begins at home, and it is not how much we do... But how much love we put in that action.", "My religion is very simple. My religion is kindness.", "There are forces in life working for you and against you. One must distinguish the beneficial forces from the malevolent ones and choose correctly between them.", "Beware of little expenses. A small leak will sink a great ship.", "All my life through, the new sights of nature made me rejoice like a child.", "He who indulges in falsehood will find the paths of paradise shut to him.", "Man is descended from a hairy, tailed quadruped, probably arboreal in its habits.", "The minute I heard my first love story, I started looking for you.", "People of the world don\'t look at themselves, and so they blame one another.", "The truth. It is a beautiful and terrible thing, and must therefore be treated with great caution.", "The object of the superior man is truth.", "Live amongst people in such a manner that if you die they weep over you and if you are alive they crave for your company.", "Pride in the case of a rich man is bad, but pride in the case of a poor man is worse.", "Tell me and I forget. Teach me and I remember. Involve me and I learn.", "Why is it that we rejoice at a birth and grieve at a funeral? It is because we are not the person involved.", "If you have a particular faith or religion, that is good. But you can survive without it.", "You don\'t want no pie in the sky when you die, you want something here on the ground while you\'re still around.", "Don\'t be satisfied with stories, how things have gone with others. Unfold your own myth.", "Purify your eyes, and see the pure world. Your life will fill with radiant forms.", "Associating with the wise and the knowledgeable people adds to the prestige of a person.", "There is no darkness but ignorance.", "All great achievements require time.", "One does not leave a convivial party before closing time.", "You are not only responsible for what you say, but also for what you do not say.", "So go ahead. Fall down. The world looks different from the ground.", "When we lose one blessing, another is often most unexpectedly given in its place.", "Intelligence is the wife, imagination is the mistress, memory is the servant.", "It is a matter of shame that in the morning the birds should be awake earlier than you.", "What doesn\'t kill us makes us stronger.", "The weakest man is the one who is able to correct his moral defects, but doesn\'t take action.", "I do not need the idea of god to explain the world I live in.", "The highest person is he who is of most use to humankind.", "Common sense is the collection of prejudices acquired by age eighteen.", "Do not let your difficulties fill you with anxiety, after all it is only in the darkest nights that stars shine more brightly.", "Preserve the sayings of those people who are indifferent to the world. They say only that what allah wishes them to say.", "I hated every minute of training, but I said, \"don\'t quit. Suffer now and live the rest of your life as a champion.\"", "The only way to do news on television is not to be terrified of it.", "It is a mistake to look too far ahead. Only one link of the chain of destiny can be handled at a time.", "I\'ll destroy you. I am the master of disaster.", "I fear the day when the kuffar are proud of their falsehood, and the muslims are shy of their faith.", "Stay in college, get the knowledge. And stay there until you\'re through. If they can make penicillin out of moldy bread, they can sure make something out of you.", "Those who dare to fail miserably can achieve greatly.", "You show your worth by what you seek.", "Acquire knowledge before you become leaders and pride prevents you from learning and you live in ignorance.", "Fear is the main source of superstition, and one of the main sources of cruelty. To conquer fear is the beginning of wisdom.", "If a free society cannot help the many who are poor, it cannot save the few who are rich.", "As he was valiant, I honour him. But as he was ambitious, I slew him.", "Who\'s gonna dare to be great?", "He who keeps his own counsel keeps his affairs in his own hands.", "To whatever extent a person\'s knowledge increases, his attention will be turned more towards his soul.", "If an ignorant person is attracted by the things of the world, that is bad. But if a learned person is thus attracted, it is worse.", "Surely silence can sometimes be the most eloquent reply.", "Once your mind stretches to a new level it never goes back to its original dimension.", "I was saying \"I\'m the greatest\" long before I believed it.", "Our peace shall stand as firm as rocky mountains.", "Only buy something that you\'d be perfectly happy to hold if the market shut down for 10 years.", "Intellectual property has the shelf life of a banana.", "He who understands humanity seeks solitude.", "I was not created to be occupied by eating delicious foods like tied up cattle.", "Time stays long enough for anyone who will use it.", "I feel the same way about disco as I do about herpes.", "Civilization is the limitless multiplication of unnecessary necessities.", "If you hear a voice within you say \'you cannot paint \' then by all means paint, and that voice will be silenced.", "When one has not had a good father, one must create one.", "I\'ve learned that people will forget what you said, people will forget what you did, but people will never forget how you made them feel.", "If we cannot now end our differences, at least we can help make the world safe for diversity.", "The cautious seldom err.", "Admiration for a quality or an art can be so strong that it deters us from striving to possess it.", "I myself prefer my new zealand eggs for breakfast.", "To line only for some unknown future is superficial.", "Money is the barometer of a society\'s virtue.", "Convictions are more dangerous foes of truth than lies.", "I have not failed. I\'ve just found 10 000 ways that won\'t work.", "Maybe a thing that you do not like is really in your interest. It is possible that a thing that you may desire may be against your interest.", "People always ask me, \'were you funny as a child?\' well, no, I was an accountant.", "I\'m not an expert on the arms race.", "Sit with those who love allah, for that enlightens the mind.", "You cannot perform in a manner inconsistent with the way you see yourself.", "I say that the most liberating thing about beauty is realizing that you are the beholder.", "Happiness in intelligent people is the rarest thing I know.", "A person who never made a mistake never tried anything new.", "In the big leagues everyone has ability. It always comes down to mind games. Who ever is more mentally strong-wins.", "Don\'t take rest after your first victory because if you fail in second, more lips are waiting to say that your first victory was just luck.", "Stop learning. Start knowing.", "One of the greatest discoveries a man makes, one of his great surprises, is to find he can do what he was afraid he couldn\'t do.", "You are never too old to set another goal or to dream a new dream.", "Keep your eyes on the stars, and your feet on the ground.", "I know of only one duty, and that is to love.", "God helps those who help themselves.", "You are not just the drop in the ocean. You are the mighty ocean in the drop.", "Teaching is a very noble profession that shapes the character, caliber, and future of an individual. If the people remember me as a good teacher, that will be the biggest honour for me.", "A man should never neglect his family for business.", "Isn\'t it strange that I who have written only unpopular books should be such a popular fellow?", "Drag your thoughts away from your troubles... By the ears, by the heels, or any other way you can manage it.", "The greatest discovery of all time is that a person can change his future by merely changing his attitude.", "Whoever listens to slander is himself a slanderer.", "The best way to find out if you can trust somebody is to trust them.", "Take account of your deeds before they are taken account of.", "Faith is taking the first step even when you don\'t see the whole staircase.", "To give thanks in solitude is enough. Thanksgiving has wings and goes where it must go. Your prayer knows much more about it than you do.", "Those who dare to fail miserably can achieve greatly.", "Like your body your mind also gets tired so refresh it by wise sayings.", "God helps those who fear him.", "During civil disturbance adopt such an attitude that people do not attach any importance to you - they neither burden you with complicated affairs, nor try to derive any advantage out of you.", "Whether you think that you can, or that you can\'t, you are usually right.", "O! Let me not be mad, not mad, sweet heaven; keep me in temper; I would not be mad!", "The man with no imagination has no wings.", "Today, india is a nuclear weapons state.", "The public is merely a multiplied \"Me.\"", "If a man could have half of his wishes, he would double his troubles.", "There are no moral phenomena at all, but only a moral interpretation of phenomena.", "To say \"I love you\" one must first be able to say the \"I.\"", "Patience to faith is like the head to the body. The person who has no patience has not faith.", "Nations are born in the hearts of poets, they prosper and die in the hands of politicians.", "Rivers, ponds, lakes and streams - they all have different names, but they all contain water. Just as religions do - they all contain truths.", "The time has come to turn your heart into a temple of fire. Your essence is gold hidden in dust. To reveal its splendor you need to burn in the fire of love.", "Only last week I murdered a rock, injured a stone and hospitalized a brick.", "If you would have a faithful servant, and one that you like, serve yourself.", "If all you can do is crawl, start crawling.", "Extreme hopes are born from extreme misery.", "When a person cannot deceive himself the chances are against his being able to deceive other people.", "I am the greatest. I said that even before I knew I was. Don\'t tell me I can\'t do something. Don\'t tell me it\'s impossible. Don\'t tell me I\'m not the greatest. I\'m the double greatest.", "Geologists have a saying - rocks remember.", "Be silent, only the hand of god can remove the burdens of your heart.", "Peace cannot be kept by force; it can only be achieved by understanding.", "The best way to get a bad law repealed is to enforce it strictly.", "Wherever you are, and whatever you do, be in love.", "Should I kill myself, or have a cup of coffee?", "It is very dangerous to have your self-worth riding on your results as an athlete.", "No part of the education of a politician is more indispensable than the fighting of elections.", "War is never a lasting solution for any problem.", "I never think of the future - it comes soon enough.", "At the end of my life, with just one breath left, if you come, I\'ll sit up and sing.", "Indigestion is charged by god with enforcing morality on the stomach.", "Fear allah, for he alone lives; all other things are liable to perish.", "I once had a thousand desires. But in my one desire to know you, all else melted away.", "God forbid, men should be jealous of knowledge as they are jealous of women.", "I wish they would only take me as I am.", "I have lived on the lip of insanity, wanting to know reasons, knocking on a door. It opens. I\'ve been knocking from the inside.", "Once you replace negative thoughts with positive ones, you\'ll start having positive results.", "What is wanted is not the will to believe, but the will to find out, which is the exact opposite.", "I\'m going to show you how great I am!", "In the depth of winter I finally learned that there was in me an invincible summer.", "He who fears to weep, should learn to be kind to those who weep.", "The criminal is trying to solve his immediate problems.", "It is very easy to defeat someone, but it is very hard to win someone.", "A casual stroll through the lunatic asylum shows that faith does not prove anything.", "Things may come to those who wait, but only the things left by those who hustle.", "No sanction can stand against ignited minds.", "Understanding the knowledge and wisdom of the qur\'an is by far, higher than memorizing.", "Gratitude is the wine for the soul. Go on. Get drunk.", "All of our dreams can come true.", "The days of life pass away like clouds, so do good while you are alive.", "Once the choice is made, do not look back, do not second-guess your decisions.", "Tear off the mask. Your face is glorious.", "How hard, how bitter it is to become a man!", "Conduct, which involves a decision of the ultimate fate of the agent cannot be based on illusions.", "I don\'t know who my grandfather was; I am much more concerned to know what his grandson will be.", "Look for the answer inside your question.", "Adversity makes men, and prosperity makes monsters.", "Our greatest weakness lies in giving up. The most certain way to succeed is always to try just one more time.", "It is better to remain silent and be thought a fool than to open one\'s mouth and remove all doubt.", "He who has never learned to obey cannot be a good commander.", "You cannot create experience. You must undergo it.", "I am grateful for all my victories, but I am especially grateful for my losses, because they only made me work harder.", "No legacy is so rich as honesty.", "The outcome of fear is disappointment and shyness is frustration.", "All my life through, the new sights of nature made me rejoice like a child.", "He who avoids complaint invites happiness.", "Work with integrity and succeed with integrity.", "You were born with potential. You were born with goodness and trust. You were born with ideals and dreams. You were born with greatness. You were born with wings. You are not meant for crawling, so don\'t. You have wings. Learn to use them and fly.", "Move, but don\'t move the way fear makes you move.", "It does not matter how slowly you go as long as you do not stop.", "There is no nobility with bad manners.", "You should not quarrel with your neighbor, for he will remain where he is, but your high handedness will become the talk of the people.", "Never stop fighting until you arrive at your destined place - that is, the unique you. Have an aim in life, continuously acquire knowledge, work hard, and have perseverance to realise the great life.", "I like to see a man proud of the place in which he lives. I like to see a man live so that his place will be proud of him.", "Let me define a leader. He must have vision and passion and not be afraid of any problem. Instead, he should know how to defeat it. Most importantly, he must work with integrity.", "Whatever your heart clings to and confides in, that is really your god.", "Dogs never bite me. Humans do.", "Your successes and happiness are forgiven you only if you generously consent to share them.", "When a person really desires something, all the universe conspires to help that person to realize his dream.", "I didn\'t fail the test, I just found 100 ways to do it wrong.", "One who thinks and reflects develops his foresight and vision.", "When red-haired people are above a certain social grade their hair is auburn.", "I have held many things in my hands, and I have lost them all; but whatever I have placed in god\'s hands, that I still possess.", "Always remember you are braver than you believe, stronger than you seem, smarter than you think and twice as beautiful as you\'d ever imagined. Yesterday I was clever, so I wanted to change the world. Today I am wise, so I am changing myself.", "That which you do not wish for yourself, do not impose on others.", "I am the greatest, I said that even before I knew I was.", "There is no labor a person does that is undignified; if they do it right.", "The people themselves, and not their servants, can safely reverse their own deliberate decisions.", "I hated every minute of training, but I said, \'don\'t quit. Suffer now and live the rest of your life as a champion.\'", "We shall draw from the heart of suffering itself the means of inspiration and survival.", "When the solution is simple, god is answering.", "I have a theory that the truth is never told during the nine-to-five hours.", "Democracy is when the indigent, and not the men of property, are the rulers.", "You\'re not going to enjoy every minute of the journey, but the success you\'ll find at the end will make it all worth it.", "It\'s hard to be humble when you\'re as great as I am.", "There is no knowledge and science like pondering and thought; and there is no prosperity and advancement like knowledge and science.", "If we did all the things we are capable of, we would literally astound ourselves.", "Be like a tree and let the dead leaves drop.", "Don\'t find fault, find a remedy.", "A friend cannot be considered a friend until he is tested in three occasions: in timeof need, behind your back, and after your death.", "I\'m too fast. I\'m too smart. I\'m too pretty.", "You cannot create experience. You must undergo it.", "Indignation is a submission of our thoughts, but not of our desires.", "Sir, my concern is not whether god is on our side; my greatest concern is to be on god\'s side, for god is always right.", "At times one remains faithful to a cause only because its opponents do not cease to be insipid.", "I put my heart and my soul into my work, and have lost my mind in the process.", "In a competition of love we\'ll all share in the victory, no matter who comes first.", "Some are born great, some achieve greatness, and some have greatness thrust upon them.", "There is no capital more useful than intellect and wisdom, and there is no indigence more injurious than ignorance and unawareness.", "There is a voice that doesn\'t use words. Listen.", "If a sheep dies on the shore of the euphrates I fear lest allah ask me to account for it on the day of resurrection.", "Do not deceive or be faithless even with your enemy.", "Pondering must turn out to be your cash asset, regardless of whichever ups and downs you occur throughout in the everyday living.", "Building capacity dissolves differences. It irons out inequalities.", "All your anxiety is because of your desire for harmony. Seek disharmony, then you will gain peace.", "As long as you are pure of heart, you speak the truth.", "Most people spend more time and energy going around problems than in trying to solve them.", "If you judge people, you have no time to love them.", "Talent in cheaper than table salt. What separates the talented individual from the successful one is a lot of hard work.", "The world we have created is a product of our thinking.", "When a hundred men stand together, each of them loses his mind and gets another one.", "Fanatics are picturesque, mankind would rather see gestures than listen to reasons.", "Every day is different, and some days are better than others, but no matter how challenging the day, I get up and live it.", "The educated southerner has no use for an \'r\', except at the beginning of a word.", "To love is to act.", "My dream is of a place and a time where america will once again be seen as the last best hope of earth.", "What comes, will go. What is found, will be lost again. But what you are is beyond coming and going and beyond description.", "Dreams are not those which comes while we are sleeping, but dreams are those when u don\'t sleep before fulfilling them.", "To fear love is to fear life, and those who fear life are already three parts dead.", "Expect the best. Prepare for the worst. Capitalize on what comes.", "My soul is my guide, for my soul is of that abode. I will not speak of the earthly. I am of the unknown.", "Many marriages would be better if the husband and the wife clearly understood that they are on the same side.", "Try not to resist the changes that come your way. Instead let life live through you. And do not worry that your life is turning upside down. How do you know that the side you are used to is better than the one to come?", "Religions have different names, and they all contain truth, expressed in different ways forms and times.", "All that I am, or hope to be, I owe to my angel mother.", "Doing as others told me, I was blind. Coming when others called me, I was lost. Then I left everyone, myself as well. Then I found everyone, myself as well.", "Happiness is when what you think, what you say, and what you do are in harmony.", "Nothing will work unless you do.", "My books are like water; those of the great geniuses are wine. (fortunately) everybody drinks water.", "Grief can be the garden of compassion. If you keep your heart open through everything, your pain can become your greatest ally in your life\'s search for love and wisdom.", "To be alone means that you avoid bad company. But to have a true friend is better than being alone.", "I am the greatest.", "Only a man who knows what it is like to be defeated can reach down to the bottom of his soul and come up with the extra ounce of power it takes to win when the match is even.", "Riches without faith are the greatest poverty.", "I\'m the most recognized and loved man that ever lived cuz there weren\'t no satellites when jesus and moses were around, so people far away in the villages didn\'t know about them.", "The lord prefers common-looking people. That is why he makes so many of them.", "Whether you love god or you love a human being, if you love enough you will come into the presence of love itself.", "O allah do not give me in excess lest I may be disobedient.", "Eros will have naked bodies; friendship naked personalities.", "In a democracy, the well-being, individuality and happiness of every citizen is important for the overall prosperity, peace and happiness of the nation.", "The happiest of people is the one under whose care people are happy because of him, and the most miserable of people is the one under whose care people are miserable because of him.", "He who guards his secrets retains control in his own hands.", "Success is not achieved by winning all the time. Real success comes when we rise after we fall.", "Humility is not thinking less of yourself, it\'s thinking of yourself less.", "No amount of worrying can change the future. Go easy on yourself, for the outcome of all affairs is determined by god\'s decree. If something is meant to go elsewhere, it will never come your way, but if it is yours by destiny, from you it cannot flee.", "Fear him, whom you hate.", "The word of god is the medicine of the heart.", "Do you think god gets stoned? I think so... Look at the platypus.", "The good life is one inspired by love and guided by knowledge.", "I believe in christianity as I believe that the sun has risen: not only because I see it, but because by it I see everything else.", "The airplane has had a big impact on my life.", "We make a living by what we get, but we make a life by what we give.", "Indifference and neglect often do much more damage than outright dislike.", "When I am silent, I fall into the place where everything is music.", "A word to the wise ain\'t necessary - it\'s the stupid ones that need the advice.", "Always consider your intellect to be lacking; otherwise too much faith in it surely leads to error.", "That\'s okay, I\'m still the greatest.", "When I look into the future, it\'s so bright it burns my eyes.", "I\'m gonna whup whoever stole my bike!", "To be a great champion you must believe you are the best. If you\'re not, pretend you are.", "Get up sucker and fight. Get up and fight.", "We shall require a substantially new manner of thinking if mankind is to survive.", "I try to build a full personality for each of our cartoon characters - to make them personalities.", "Without freedom, no art; art lives only on the restraints it imposes on itself, and dies of all others.", "When you\'re right, nobody remembers. When you\'re wrong, nobody forgets.", "We have one life; it soon will be past; what we do for god is all that will last.", "When we practice loving kindness and compassion we are the first ones to profit.", "I never gave up on country music because I knew what I was doing was not that bad.", "Israel, as the jewish state, must disappear from the map.", "The world is a dangerous place to live; not because of the people who are evil, but because of the people who don\'t do anything about it.", "It is not best that we should all think alike; it is a difference of opinion that makes horse races.", "Intense love does not measure, it just gives.", "A penny saved is a penny earned.", "Whatever purifies you is the right path, I will not try to define it.", "Coming together is a beginning; keeping together is progress; working together is success.", "Total commitment is the common denominator among all successful men and women.", "Rest but never quit. Even the sun has a sinking spell each evening. But it always rises the next morning. At sunrise, every soul is born again.", "You can have no dominion greater or less than that over yourself.", "I want you to be concerned about your next door neighbor. Do you know your next door neighbor?", "I shook up the world.", "I learned that every mortal will taste death. But only some will taste life.", "Parkinson\'s is my toughest fight. No, it doesn\'t hurt. It\'s hard to explain. I\'m being tested to see if I\'ll keep praying, to see if I\'ll keep my faith. All great people are tested by god.", "You have been a prisoner of a little pond I am the ocean and its turbulent flood come merge with me leave this world of ignorance.", "Do not share the knowledge with which you have been blessed with everyone in general, as you do with some people in particular; and know that there are some men in whom allah, may he he glorified, has placed hidden secrets, which they are forbidden to reveal.", "Your heart knows the way. Run in that direction.", "The angel is free because of his knowledge, the beast because of his ignorance. Between the two remains the son of man to struggle.", "I like not fair terms and a villain\'s mind.", "Our abode in this world is transitory, our life therein is but a loan, our breaths are numbered and our indolence is manifest.", "All credibility, all good conscience, all evidence of truth come only from the senses.", "Once spirit was god, then it became man, and now it is even becoming mob.", "Wealth tends to create enemies, whereas knowledge tends to warm hearts.", "Be afraid of a dignified man when he is hungry and a wicked man when his belly is full.", "Nothing says holidays, like a cheese log.", "A man wrapped up in himself makes a very small bundle.", "There is a candle in your heart, ready to be kindled. There is a void in your soul, ready to be filled. You feel it, don\'t you?", "I am the literary equivalent of a big mac and fries.", "To forgive an oppressor is oppression upon the oppressed.", "Our death is our wedding with eternity.", "Imagination is more important than knowledge.", "When proven wrong, the wise will correct themselves and the ignorants will just keep arguing.", "Grieving? Don\'t. With time, whatever you\'ve lost might come \'round in some other form.", "The breeze at dawn has secrets to tell you. Don\'t go back to sleep.", "Positive thinking will let you do everything better than negative thinking will.", "Design is not just what it looks like and feels like. Design is how it works.", "Contentment is a wealth that is never exhausted.", "There is nothing outside of yourself, look within. Everything you want is there. You are that."};
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
	public static String randPhone() {
		return randFrom(rfnss);
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
	static String fakeNationality = "",
				  randAreaInKarachi = "";

	public static final String randNationality = fakeNationality = fakeNationality(),
							   randCity = randCity(),
							   randKarachiArea = randAreaInKarachi = randAreaInKarachi(),
							   randPhone = randPhone(),
							   randGirlName = randGirlName(),
							   randGuyName = randGuyName(),
							   randWord = randWord(),
							   randSentence = randSentence();


	//Files
	public static boolean createFile(String fname) {
		try {
			File myFile = new File(fname);
			if (myFile.createNewFile()) {
				System.out.println("\n[KL FileReader]: File \"" + myFile.getName() + "\" created successfully");
				return true;
			} else {
				print("\n[KL FileReader]: File either already exists, or you do not have enough permissions to create a new file in this directory.\n");
			}
		} catch (IOException e) {
			print("\n[KL FileReader]: Something went wrong.\n");
			e.printStackTrace();
		}
		return false;
	}
	public static boolean createFile(String fname, String content) {
		try {
			File myFile = new File(fname);
			FileWriter fr = new FileWriter(fname);
			fr.write(content);
			print("\n[KL FileReader]: File \"" + myFile.getName() + "\" created successfully");
			fr.close();
			return true;
		} catch (IOException e) {
			print("\n[KL FileReader]: Something went wrong. File creation failed.\n");
			e.printStackTrace();
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
		String msgOnSuccess = "\n[KL FileReader]: File \"" + myFile.getPath() + "\" deleted successfully.\n",
			   msgOnFailure = "\n[KL FileReader]: Task failed, no such file/folder!\n";
		if (!myFile.exists()) {
			print(msgOnFailure);
			return false;
		}
		if (myFile.isDirectory()) {
			for (File c : myFile.listFiles()) deleteFile(c.toString());
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
				print("\n[KL FileReader]: File " + myFile.getName() + " was successfully moved/renamed to " + destinationFile.getPath());
				return true;
			} else {
				print("\n[KL FileReader]: You do not have enough permissions to move/rename this file.\n");
				IOException e = new IOException();
				throw e;
			}
		} catch (IOException e) {
			print("\n[KL FileReader]: Something went wrong.\n");
			e.printStackTrace();
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
			e.printStackTrace();
		}
		return data;
	}
	public static boolean copyFile(String from, String to) {
		File fileToCopy = new File(from);
		File destination = new File(to);
		try {
			Files.copy(fileToCopy.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
			return true;
		} catch (IOException e) {
			System.out.println("\n[KL FileReader]: Failed to copy!\n");
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

	/*
	public static void main(String[] args) {
		//createFile("g.txt","hi");
		deleteFile("g.txt");
		String name = scan("Please enter your name: ");
		next();
		int age = scani("And age? ");
		next();
		print("---- * ----");
		next();
		print("Name:", name, "\nAge:", Str(age));
		String arrayOfTextChunks[] = {"hi", "this", "is", "me"};
		int nums[] = {1, 2, 5, 3, 6, 7, 8, 4, 9, 10};
		sort(nums);
		String collectedChunks = join(arrayOfTextChunks, "+");
		print(collectedChunks);
		print(randInt());

	    print(randItem(arrayOfTextChunks));
	    //print(len(nums));
	    printAll(nums);
	}
	*/
	public static void main
	(String[] args) {
		//print(sentCase("hi love, how's it going? i am trying."));
		//createFolder("g");
		/*
		String contents = readFile("Book.java");
		print(contents);
		*/
		//deleteFolder("g");
		//print(getSeason());
		//print(upper(replace(trim("     Hi there love"), " ", "-")));
		//print(endsWith("hello world", "rld"));
		/*
		Object_S languages = new Object_S("key", "value", "fruit", "banana", "car", "porsche");
		Object_D constants = new Object_D("g", 9.8);
		constants.add("pi", 3.15);
		constants.set("pi", 3.16);
		constants.update("pi", 3.14);
		constants.printMap();
		languages.add("java", "enterprise");
		languages.add("python", "ml/ai")
		languages.add("javascript", "frontend");
		languages.printMap();
		//iterating through keys
		System.out.print("\n\nKeys: ");
		for (String key : languages.keys()) {
			System.out.print(key);
			System.out.print(", ");
		}

		//iterating through values
		System.out.print("\n\nValues: ");
		for (var value : languages.values()) {
			System.out.print(value);
			System.out.print(", ");
		}
		*/
		/*
		int nums[] = {1, 2, 5, 3, 6, 7, 8, 4, 9, 10};
		int nums_sorted[] = copyArr(nums);
		sort(nums_sorted);
		print("Nums: ");
		printArr(nums);
		br(1);
		print("Nums, sorted: ");
		printArr(nums_sorted);
		*/
		/*
		print(now());
		print(getSeason());
		print(getMonth());
		*/
		//print(sliceToAfter("This is a lovely evening we shouldn't miss", "lovely "));
		//for (int i : range(500)) print(th(i));
		//printArr(divisorsOf(80));
		//repeat(() -> print("hi"), 5);
		//print(pkr(1001510000000.294));
		//double x = 8000.5;
		//print(curr(x, "JP¥"));
		//double x = 80143000000000000000000000000000000.0;
		///print(ussuffix(x));
		print(randPhone);
	}
}