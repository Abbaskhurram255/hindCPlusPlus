class lafz {
	String str = "";
	String[] words = {};
	lafz() {
		this.str = "";
	}
	lafz(Object... objs) {
		this.str = "";
		for (Object o : objs) {
			if (o != null) this.str += " "+o;
		}
		trim();
		words = split("[^a-zA-Z'\\-]+|\\-(?![a-zA-Z]{2,})");
	}
	lafz concat(Object... objs) {
		for (Object o : objs) {
			if (o != null) this.str += " "+o;
		}
		trim();
		return this;
	}
	lafz cat(Object... objs) {
		concat(objs);
		return this;
	}
	lafz add(Object... objs) {
		concat(objs);
		return this;
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
	String firstWord() {
		if (length() == 0 || words.length == 0) return "";
		return words[0];
	}
	String secWord() {
		if (length() == 0 || words.length == 0) return "";
		if (words.length < 2) return words[0];
		return words[1];
	}
	String secondWord() {
		return secWord();
	}
	String secLastWord() {
		if (length() == 0 || words.length == 0) return "";
		if (words.length < 3) return words[0];
		return words[words.length-2];
	}
	String lastWord() {
		if (length() == 0 || words.length == 0) return "";
		return words[words.length-1];
	}
	String nthWord(int i) {
		if (length() == 0 || words.length == 0 || i >= words.length) return "";
		if (i >= length()) return words[words.length - 1];
		if (i < 0) {
			i = Math.abs(i);
			if (i > 0 && i <= words.length)
                return lasti(i);
            return words[0];
        }
		return words[i];
	}
	String nthLastWord(int i) {
		if (length() == 0 || words.length == 0) return "";
		if (i <= 0) return words[0];
		if (i > words.length) return words[words.length-1];
		return words[words.length-i];
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
	String join() {
		if (isEmpty()) return "";
		if (words.length < 2)
			return nthWord(0);
		String halfProcessed = String.join(", ", words);
		String returnValue = halfProcessed.replaceAll("(?<=,)(\\s)(?=\\w+$)",
				"$1and$1");
		returnValue = new lafz(returnValue).sentCase().str();
		return returnValue;
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
	public String str() {
		return toString();
	}
}
class Str extends lafz {
	Str() {
		this.str = "";
	}
	Str(Object... objs) {
		this.str = "";
		for (Object o : objs) {
			if (o != null) this.str += " "+o;
		}
		trim();
		words = split("[^a-zA-Z'\\-]+|\\-(?![a-zA-Z]{2,})");
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
		System.out.println(name.lastWord());
		System.out.println(lafz("boyfriends", "love", "money").join());
	}
}