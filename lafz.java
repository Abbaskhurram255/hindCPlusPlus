class lafz {
	String str;
	lafz() {
		this.str = "";
	}
	lafz(Object... objs) {
		this.str = "";
		for (Object o : objs) {
			if (o != null) this.str += " "+o;
		}
		trim();
	}
	lafz trim() {
		this.str = this.str.trim();
		return this;
	}
	lafz sentCase() {
		this.str = (str.toUpperCase().substring(0, 1)
				 + str.toLowerCase().substring(1))
				.replaceAll("(?<!\\w)i(?!\\w)", "I");
		return this;
	}
	lafz titleCase() {
		StringBuilder titleCased = new StringBuilder(str.length());
		boolean nextTitleCase = true;
		for (char c : str.toCharArray()) {
			if (Character.isSpaceChar(c)) {
				nextTitleCase = true;
			} else if (nextTitleCase) {
				c = Character.toTitleCase(c);
				nextTitleCase = false;
			}
			titleCased.append(c);
		}
		this.str = titleCased.toString();
		return this;
	}
	lafz sent() {
		return sentCase();
	}
	lafz title() {
		return titleCase();
	}
	lafz reverse() {
		this.str = new StringBuilder(str).reverse().toString();
		return this;
	}
	String[] split(String _with, int maxSplits) {
		return str.split(_with, maxSplits);
	}
	String[] split(String _with) {
		return str.split(_with);
	}
	String i(int i) {
		if (isEmpty()) return "";
		if (i >= length()) return split()[length() - 1];
		if (i < 0) {
			i = Math.abs(i);
			if (i > 0 && i <= length())
                return lasti(i);
            return split()[0];
        }
		return split()[i];
	}
	String lasti(int i) {
		if (isEmpty()) return "";
		if (i <= 0) return split()[0];
		if (i > length()) return split()[length()-1];
		return split()[length()-i];
	}
	String[] split() {
		return str.split("");
	}
	String[] array() {
		return str.split("");
	}
	String[] toArray() {
		return array();
	}
	char[] toCharArray() {
		return str.toCharArray();
	}
	char[] toChars() {
		return toCharArray();
	}
	char[] chars() {
		return toCharArray();
	}
	lafz toUpperCase() {
		this.str = str.toUpperCase();
		return this;
	}
	lafz toLowerCase() {
		this.str = str.toLowerCase();
		return this;
	}
	lafz toUpper() {
		toUpperCase();
		return this;
	}
	lafz toLower() {
		toLowerCase();
		return this;
	}
	lafz upper() {
		toUpperCase();
		return this;
	}
	lafz lower() {
		toLowerCase();
		return this;
	}
	int length() {
		if (str == null) str = "";
		return str.trim().length();
	}
	int len() {
		return length();
	}
	int size() {
		return length();
	}
	boolean isEmpty() {
		return str.isEmpty();
	}
	public String toString() {
		if (str != null) return str;
		return "";
	}
	public String string() {
		return toString();
	}
}
class Str extends lafz {
	Str(Object... objs) {
		this.str = "";
		for (Object o : objs) {
			if (o != null) this.str += " "+o;
		}
		trim();
	}
}


public class Main {
	public static lafz lafz(Object... objs) {
	    return new lafz(objs);
    }
    public static lafz $(Object... objs) {
	    return new lafz(objs);
    }
    public static Str Str(Object... objs) {
	    return new Str(objs);
    }
	public static void main(String[] args) {
		lafz salaam = $("  hi", "there", "love!", "I'm", 23);
		lafz greeting2 = $("hi", " boyfriends");
		Str name = Str("mehrunisa ji");
		System.out.println(salaam.sentCase());
		System.out.println(name.i(-12));
	}
}