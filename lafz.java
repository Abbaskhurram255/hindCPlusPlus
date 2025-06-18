public class lafz {
	String str;
	lafz() {
		this.str = "";
	}
	lafz(Object... objs) {
		this.str = "";
		for (Object o : objs) this.str += " "+o;
		trim();
	}
	lafz trim() {
		str = str.trim();
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
	lafz reverse() {
		this.str = new StringBuilder(str).reverse().toString();
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
	int length = length();
	int len = length();
	int size = length();
	public String toString() {
		if (str == null) return "";
		return str;
	}
}


class Main {
	public static lafz lafz(Object... objs) {
	    return new lafz(objs);
    }
    public static lafz $(Object... objs) {
	    return new lafz(objs);
    }
	public static void main(String[] args) {
		lafz salaam = $("  hi", "there", "love!", "I'm", 23);
		System.out.println(salaam.sentCase());
	}
}