import java.util.*;
import java.io.*;
import java.util.concurrent.*;
import java.security.SecureRandom;
import java.nio.file.*;


public class KL {
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
			long v = super.get(k);
			super.remove(k);
			return v;
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
			float v = super.get(k);
			super.remove(k);
			return v;
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
			double v = super.get(k);
			super.remove(k);
			return v;
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
			boolean v = super.get(k);
			super.remove(k);
			return v;
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
	}

	//Date functions
	public String nthDay(int n) {
		String days[] = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		return days[n];
	}
	public String nthMonth(int n) {
		String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		return months[n];
	}
	public String formattedDate(Date dt) {
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
	public String now() {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * (3600 * 1000))); //fix 5-hour bug
		String date = formattedDate(dt);
		return date;
	}
	public String getDate() {
		String parts[] = now().split(", ");
		return parts[1] + ", " + parts[2];
	}
	public String getDay() {
		return now().split(", ")[0];
	}
	public String getMonth() {
		return now().split(", ")[1].split(" ")[0];
	}
	public String getYear() {
		return now().split(", ")[2];
	}
	public String getTime() {
		return now().split(", ")[3];
	}
	public static String getSeason() {
		String m = new KL().getMonth().toLowerCase();
		if (m == "may" || m == "jun" || m == "jul" || m == "aug") return "Summer";
		else if (m == "sep" || m == "oct") return "Spring";
		else if (m == "nov" || m == "dec" || m == "jan" || m == "feb") return "Winter";
		else return "Fall/Autumn";
	}
	public String yesterday() {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int)36e5))); //fix 5-hour bug
		dt.setTime(dt.getTime() - ((int)36e5 * 24)); //decrement 24 hours or (3.6*10⁶)*24 milliseconds
		String date = formattedDate(dt);
		String parts[] = date.split(", ");
		date = parts[0] + ", " + parts[1] + ", " + parts[2];
		return date;
	}
	public String dayBeforeYesterday() {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int)36e5))); //fix 5-hour bug
		dt.setTime(dt.getTime() - ((int)72e5 * 24)); //decrement 48 hours or (7.2*10⁶)*24 milliseconds
		String date = formattedDate(dt);
		String parts[] = date.split(", ");
		date = parts[0] + ", " + parts[1] + ", " + parts[2];
		return date;
	}
	public String twoDaysAgo() {
		return new KL().dayBeforeYesterday();
	}
	public String tomorrow() {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int)(36e2 * 1e3)))); //fix 5-hour bug
		dt.setTime(dt.getTime() + ((int)36e5 * 24)); //increment 24 hours or (3.6*10⁶)*24 milliseconds
		String date = formattedDate(dt);
		String parts[] = date.split(", ");
		date = parts[0] + ", " + parts[1] + ", " + parts[2];
		return date;
	}
	public String dayAfterTomorrow() {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int)36e5))); //fix 5-hour bug
		dt.setTime(dt.getTime() + ((int)72e5 * 24)); //increment 48 hours or (7.2*10⁶)*24 milliseconds
		String date = formattedDate(dt);
		String parts[] = date.split(", ");
		date = parts[0] + ", " + parts[1] + ", " + parts[2];
		return date;
	}
	public String twoDaysLater() {
		return new KL().dayAfterTomorrow();
	}
	public String lastMonth() {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int)36e5))); //fix 5-hour bug
		dt.setMonth(dt.getMonth() - 1); //decrement a month
		String date = formattedDate(dt);
		date = date.split(", ")[1].split(" ")[0];
		return date;
	}
	public String lastMonthOf(String date) {
		Date dt = new Date(date);
		dt.setTime(dt.getTime() + (5 * ((int)36e5))); //fix 5-hour bug
		dt.setMonth(dt.getMonth() - 1); //decrement a month
		date = formattedDate(dt);
		date = date.split(", ")[1].split(" ")[0];
		return date;
	}
	public String nextMonth() {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int)36e5))); //fix 5-hour bug
		dt.setMonth(dt.getMonth() + 1); //increment a month
		String date = formattedDate(dt);
		String parts[] = date.split(", ");
		date = date.split(", ")[1].split(" ")[0];
		return date;
	}
	public String nextMonthOf(String date) {
		Date dt = new Date(date);
		dt.setTime(dt.getTime() + (5 * ((int)36e5))); //fix 5-hour bug
		dt.setMonth(dt.getMonth() + 1); //increment a month
		date = formattedDate(dt);
		String parts[] = date.split(", ");
		date = date.split(", ")[1].split(" ")[0];
		return date;
	}
	public String lastYear() {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int)36e5))); //fix 5-hour bug
		dt.setYear(dt.getYear() - 1); //decrement a year
		String date = formattedDate(dt);
		String parts[] = date.split(", ");
		date = date.split(", ")[2];
		return date;
	}
	public String lastYearOf(String date) {
		Date dt = new Date(date);
		dt.setTime(dt.getTime() + (5 * ((int)36e5))); //fix 5-hour bug
		dt.setYear(dt.getYear() - 1); //decrement a year
		date = formattedDate(dt);
		date = date.split(", ")[2];
		return date;
	}
	public String nextYear() {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int)36e5))); //fix 5-hour bug
		dt.setYear(dt.getYear() + 1); //increment a year
		String date = formattedDate(dt);
		date = date.split(", ")[2];
		return date;
	}
	public String nextYear(String date) {
		Date dt = new Date(date);
		dt.setTime(dt.getTime() + (5 * ((int)36e5))); //fix 5-hour bug
		dt.setYear(dt.getYear() + 1); //increment a year
		date = formattedDate(dt);
		date = date.split(", ")[2];
		return date;
	}
	public String age2bday(int age) {
		Date dt = new Date();
		//dt.setTime(dt.getTime()+(5*((int)36e5))); //fix 5-hour bug
		String bday = "" + ((dt.getYear() + 1900) - age); //adding 1900 helps resolve a bug
		return bday;
	}
	public int bday2age(String date) {
		Date dt = new Date(date);
		dt.setTime(dt.getTime() + (5 * ((int)36e5))); //fix 5-hour bug
		int age = new Date().getYear() - dt.getYear();
		return age;
	}
	public String date2day(String date) {
		Date dt = new Date(date);
		dt.setTime(dt.getTime() + (5 * ((int)36e5))); //fix 5-hour bug
		date = formattedDate(dt);
		date = date.split(", ")[0];
		return date;
	}
	public String date2month(String date) {
		Date dt = new Date(date);
		dt.setTime(dt.getTime() + (5 * ((int)36e5))); //fix 5-hour bug
		date = formattedDate(dt);
		date = date.split(", ")[1].split(" ")[0];
		return date;
	}
	public String timeGreet() {
		String greeting;
		int h = new Date().getHours() + 5; //fix 5-hour bug along the way
		if (h >= 20) greeting = "Good night";
		else if (h >= 16) greeting = "Good evening";
		else if (h >= 12) greeting = "Good afternoon";
		else if (h >= 0 && h <= 4) greeting = "Good new day";
		else greeting = "Good morning";
		return greeting;
	}
	public String lastOfMonth(int m) {
		Date dt = new Date();
		KL dt2 = new KL();
		dt.setTime(dt.getTime() + (5 * ((int)36e5))); //fix 5-hour bug for better accuracy
		String result = "" + ("" + dt2.nthMonth(m - 1) + " " + new Date(new Date().getYear(), m, 0).getDate());
		return result;
	}
	public boolean isWeekend() {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int)36e5))); //fix 5-hour bug
		return dt.getDay() % 6 == 0;
	}
	public boolean isLeapYear() {
		return (1900 + new Date().getYear()) % 4 == 0;
	}
	public int nextLeapYear() {
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
	public String dateBefore(int n) {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int)36e5))); //fix 5-hour bug
		dt.setDate(dt.getDate() - Math.abs(n));
		String date = new KL().formattedDate(dt);
		String parts[] = date.split(", ");
		date = parts[0] + ", " + parts[1] + ", " + parts[2];
		return date;
	}
	public String dateAfter(int n) {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int)36e5))); //fix 5-hour bug
		dt.setDate(dt.getDate() + Math.abs(n));
		String date = new KL().formattedDate(dt);
		String parts[] = date.split(", ");
		date = parts[0] + ", " + parts[1] + ", " + parts[2];
		return date;
	}
	public String minsAgo(int n) {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int)36e5))); //fix 5-hour bug
		dt.setTime(dt.getTime() - (n * (int)60e3));
		String time = new KL().formattedDate(dt);
		time = time.split(", ")[3];
		return time;
	}
	public String minsLater(int n) {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int)36e5))); //fix 5-hour bug
		dt.setTime(dt.getTime() + (n * (int)60e3));
		String time = new KL().formattedDate(dt);
		time = time.split(", ")[3];
		return time;
	}
	public String hoursAgo(int n) {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int)36e5))); //first fix the 5-hour bug
		dt.setTime(dt.getTime() - (n * (int)36e5));
		String time = new KL().formattedDate(dt);
		time = time.split(", ")[3];
		return time;
	}
	public String hoursLater(int n) {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int)36e5))); //first fix the 5-hour bug
		dt.setTime(dt.getTime() + (n * (int)36e5));
		String time = new KL().formattedDate(dt);
		time = time.split(", ")[3];
		return time;
	}
	public String nthHour(int n) {
		Date dt = new Date();
		dt.setTime(dt.getTime() + (5 * ((int)36e5))); //fix 5-hour bug
		dt.setTime(dt.getTime() - (int)36e5 * dt.getHours() + (n * (int)36e5));
		String time = new KL().formattedDate(dt);
		time = time.split(", ")[3];
		return time;
	}
	public String date() {
		return new KL().now();
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
	public static void println(char... args) {
		for (char arg : args) {
			System.out.print(arg);
		}
	}
	public static void printb(int... args) {
		System.out.print("\n");
		for (int arg : args) {
			System.out.print(arg == 1 ? "true" : "false");
		}
	}
	public static void printbln(int... args) {
		for (int arg : args) {
			System.out.print(arg == 1 ? "true" : "false");
		}
	}
	//printing arrays
	public static void printArr(String arr[]) {
		print(Arrays.toString(arr));
	}
	public static void printArr(int arr[]) {
		print(Arrays.toString(arr));
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
	public static String[] split(String str, String delimiting_str_or_regex) {
		String[] returnValue = str.split(delimiting_str_or_regex);
		return returnValue;
	}
	public static String[] splitIntoWords(String str) {
		String[] returnValue = str.split("[^a-zA-Z'\\-]|\\-(?![a-zA-Z]{2,})");
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
	public static boolean isNeg(int n) {
		return n < 0;
	}
	public static int Pos(int n) {
		return Math.abs(n);
	}
	public static int Neg(int n) {
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
	public static double cb(double n) {
		return sq(n) * n;
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
	public static double max(double n1, double n2) {
		return Math.max(n1, n2);
	}
	public static double max(double n1, double n2, double n3) {
		return max(max(n1, n2), n3);
	}
	public static double max(double n1, double n2, double n3, double n4) {
		return max(max(n1, n2, n3), n4);
	}
	public static double max(double n1, double n2, double n3, double n4, double n5) {
		return max(max(n1, n2, n3, n4), n5);
	}
	public static double min(double n1, double n2) {
		return Math.min(n1, n2);
	}
	public static double min(double n1, double n2, double n3) {
		return min(min(n1, n2), n3);
	}
	public static double min(double n1, double n2, double n3, double n4) {
		return min(min(n1, n2, n3), n4);
	}
	public static double min(double n1, double n2, double n3, double n4, double n5) {
		return min(min(n1, n2, n3, n4), n5);
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
	public static String replace(String str, String to_replace, String regex_to_replace_with) {
		return str.replaceAll(to_replace, regex_to_replace_with);
	}
	public static String replaceOne(String str, String to_replace, String regex_to_replace_with) {
		return str.replaceFirst(to_replace, regex_to_replace_with);
	}
	public static String remove(String str, String re) {
		return replace(str, re, "");
	}
	public static boolean isUpper(String s) {
		return s.toUpperCase().equals(s);
	}
	public static boolean inUpper(String s) {
		return isUpper(s);
	}
	public static boolean isLower(String s) {
		return s.toLowerCase().equals(s);
	}
	public static boolean inLower(String s) {
		return isLower(s);
	}
	public static String slice(String str) {
		return remove(str, "^\\s+|\\s+$");
	}
	public static String slice(String str, int start) {
		return str.substring(start, str.length());
	}
	public static String slice(String str, int start, int end) {
		return str.substring(start, end);
	}
	public static String sliceEnd(String str, int end) {
		return str.substring(0, str.length() - end);
	}
	public static String trim(String str) {
		return slice(str);
	}
	public static String trim(String str, int start) {
		return str.substring(start, str.length());
	}
	public static String trim(String str, int start, int end) {
		return str.substring(start, end);
	}
	public static String trimEnd(String str, int end) {
		return str.substring(0, str.length() - end);
	}
	public static boolean startsWith(String strA, String strB) {
		return strA.startsWith(strB);
	}
	public static boolean endsWith(String strA, String strB) {
		return strA.endsWith(strB);
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
		return indexOf(strA, strB) >= 0;
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
		
	}
}