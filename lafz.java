
import java.util.*;
import java.util.regex.*;

class lafz {
	String str = "";
	String[] words = {};
	lafz() {
		this.str = "";
	}
	lafz(Object... objs) {
		this.str = "";
		for (Object o : objs) {
			if (o != null)
				this.str += " " + o;
		}
		trim();
		words = split("[^a-zA-Z'\\-]+|\\-(?![a-zA-Z]{2,})");
	}
	lafz concat(Object... objs) {
		for (Object o : objs) {
			if (o == null)
				continue;
			if (o != null)
				this.str += " " + o;
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
	String sentCase() {
		if (isEmpty())
			return "";
		String result = (str.toUpperCase().substring(0, 1)
				+ str.toLowerCase().substring(1))
				.replaceAll("(?<!\\w)i(?!\\w)", "I");
		return result;
	}
	String titleCase() {
		if (isEmpty())
			return "";
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
		return titleCased.toString();
	}
	String sent() {
		return sentCase();
	}
	String title() {
		return titleCase();
	}
	String toUpperCase() {
		return str.toUpperCase();
	}
	String toUpperCase(Locale locale) {
		try {
			return str.toUpperCase(locale);
		} catch (Exception e) {
			return "";
		}
	}
	String toLowerCase() {
		return str.toLowerCase();
	}
	String toLowerCase(Locale locale) {
		try {
			return str.toLowerCase(locale);
		} catch (Exception e) {
			return "";
		}
	}
	String toUpper() {
		return toUpperCase();
	}
	String toLower() {
		return toLowerCase();
	}
	String upper() {
		return toUpper();
	}
	String lower() {
		return toLower();
	}
	String reverse() {
		String reversed = new StringBuilder(str).reverse().toString();
		return reversed;
	}
	String rev() {
		return reverse();
	}
	String[] split(String _with, int maxSplits) {
		if (_with == null)
			_with = "";
		String[] splitted = str.split(_with, maxSplits);
		if (_with.equals("") && (splitted.length > 0 && splitted[0].equals("")))
			splitted = Arrays.copyOfRange(splitted.clone(), 1, splitted.length);
		return splitted;
	}
	String[] split(String _with) {
		if (_with == null)
			_with = "";
		String[] splitted = str.split(_with);
		if (_with.equals("") && (splitted.length > 0 && splitted[0].equals("")))
			splitted = Arrays.copyOfRange(splitted.clone(), 1, splitted.length);
		return splitted;
	}
	String i(int i) {
		if (isEmpty())
			return "";
		if (i >= length())
			return split()[length() - 1];
		if (i < 0) {
			i = Math.abs(i);
			if (i > 0 && i <= length())
				return lasti(i);
			return split()[0];
		}
		return split()[i];
	}
	String lasti(int i) {
		if (isEmpty())
			return "";
		if (i <= 0)
			return split()[0];
		if (i > length())
			return split()[length() - 1];
		return split()[length() - i];
	}
	int wordCount() {
		return words.length;
	}
	boolean hasWords() {
		return wordCount() > 0;
	}
	boolean noWords() {
		return !hasWords();
	}
	String[] splitIntoWords() {
		return words;
	}
	String firstWord() {
		if (length() == 0 || words.length == 0)
			return "";
		return words[0];
	}
	String secWord() {
		if (length() == 0 || words.length == 0)
			return "";
		if (words.length < 2)
			return words[0];
		return words[1];
	}
	String secondWord() {
		return secWord();
	}
	String secLastWord() {
		if (length() == 0 || words.length == 0)
			return "";
		if (words.length < 3)
			return words[0];
		return words[words.length - 2];
	}
	String secondLastWord() {
		return secLastWord();
	}
	String lastWord() {
		if (length() == 0 || words.length == 0)
			return "";
		return words[words.length - 1];
	}
	String nthWord(int i) {
		if (length() == 0 || words.length == 0 || i >= words.length)
			return "";
		if (i >= length())
			return words[words.length - 1];
		if (i < 0) {
			i = Math.abs(i);
			if (i > 0 && i <= words.length)
				return lasti(i);
			return words[0];
		}
		return words[i];
	}
	String nthLastWord(int i) {
		if (length() == 0 || words.length == 0)
			return "";
		if (i <= 0)
			return words[0];
		if (i > words.length)
			return words[words.length - 1];
		return words[words.length - i];
	}
	String[] split() {
		String[] splitted = str.split("");
		splitted = Arrays.copyOfRange(splitted.clone(), 1, splitted.length);
		return splitted;
		// TESTED, AND CONCLUDED: java split(""), unlike JavaScript's, returns
		// an extra empty string at the beginning of the array returned after
		// the split, we don't need that
	}
	String[] array() {
		return split();
	}
	String[] arr() {
		return split();
	}
	String[] toArray() {
		return split();
	}
	Object[] toStrArr() {
		return (Object[]) splitIntoWords();
		// replace the `Object[]` part with `new StrArr($rest)`
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
	char charAt(int i) {
		String charInStringForm = i(i);
		if (charInStringForm.equals(""))
			return '\0';
		char character = charInStringForm.toCharArray()[0];
		return character;
	}
	char at(int i) {
		return charAt(i);
	}
	char c(int i) {
		return charAt(i);
	}
	int codePointAt(int i) {
		if (i < 0 || i >= length())
			return 0;
		return str.codePointAt(i);
	}
	int codePointBefore(int i) {
		if (i < 0 || i >= length())
			return 0;
		return str.codePointBefore(i);
	}
	int codePointCount(int begin, int end) {
		if (begin < 0 || begin >= length() || end < 0 || end >= length()
				|| begin >= end)
			return 0;
		return str.codePointCount(begin, end);
	}
	int compareTo(String s) {
		if (s == null)
			return -1;
		return str.compareTo(s);
	}
	int compareToIgnoreCase(String s) {
		if (s == null)
			return -1;
		return str.compareToIgnoreCase(s);
	}
	boolean contains(CharSequence s) {
		if (s == null)
			return false;
		return str.contains(s);
	}
	boolean contentEquals(CharSequence s) {
		if (s == null)
			return false;
		return str.contentEquals(s);
	}
	boolean contentEquals(StringBuilder s) {
		if (s == null)
			return false;
		return str.contentEquals(s);
	}
	static String copyValueOf(char[] data) {
		if (data == null)
			return "";
		return String.copyValueOf(data);
	}
	static String copyValueOf(char[] data, int offset, int count) {
		if (data == null)
			return "";
		return String.copyValueOf(data, offset, count);
	}
	static String valueOf(char[] data) {
		if (data == null)
			return "";
		return String.valueOf(data);
	}
	static String valueOf(char[] data, int offset, int count) {
		if (data == null)
			return "";
		return String.valueOf(data, offset, count);
	}
	static String valueOf(Object o) {
		return "" + o;
	}
	static String format(Locale locale, String stringWithFormatSpecifiers,
			Object... args) {
		if (locale == null || stringWithFormatSpecifiers == null
				|| args == null)
			return "";
		try {
			return String.format(locale, stringWithFormatSpecifiers, args);
		} catch (IllegalFormatException e) {
			return "";
		}
	}
	static String format(String stringWithFormatSpecifiers, Object... args) {
		if (stringWithFormatSpecifiers == null || args == null)
			return "";
		if (args.length == 0)
			return stringWithFormatSpecifiers;
		try {
			return String.format(stringWithFormatSpecifiers, args);
		} catch (IllegalFormatException e) {
			return "";
		}
	}
	String format(Object... args) {
		if (!str.contains("%") || args == null)
			return str;
		try {
			return String.format(str, args);
		} catch (IllegalFormatException e) {
			return str;
		}
	}
	byte[] getBytes() {
		try {
			return str.getBytes();
		} catch (Exception e) {
			return new byte[0];
		}
	}
	byte[] getBytes(java.nio.charset.Charset c) {
		try {
			return str.getBytes(c);
		} catch (Exception e) {
			return new byte[0];
		}
	}
	byte[] getBytes(String charsetName) {
		try {
			return str.getBytes(charsetName);
		} catch (Exception e) {
			return new byte[0];
		}
	}
	void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) {
		try {
			str.getChars(srcBegin, srcEnd, dst, dstBegin);
		} catch (Exception e) {
		}
	}
	String intern() {
		try {
			return str.intern();
		} catch (Exception e) {
			return "";
		}
	}
	int indexOf(char ch) {
		return KL.indexOf(str, ch);
	}
	int indexOf(char ch, int start) {
		return KL.indexOf(str, ch, start);
	}
	int indexOf(String re) {
		return KL.indexOf(str, re);
	}
	int indexOf(String re, int start) {
		return KL.indexOf(str, re, start);
	}
	int lastIndexOf(char ch) {
		return KL.lastIndexOf(str, ch);
	}
	int lastIndexOf(int ch, int start) {
		return KL.lastIndexOf(str, ch, start);
	}
	int lastIndexOf(String re) {
		return KL.lastIndexOf(str, re);
	}
	int lastIndexOf(String re, int start) {
		return KL.lastIndexOf(str, re, start);
	}
	CharSequence subSequence(int start, int end) {
		if (start < 0 || end > length() || start >= length() || start >= end)
			return "";
		try {
			return str.subSequence(start, end);
		} catch (Exception e) {
			return "";
		}
	}
	// @TODO: match, matches, slice, substring
	// continue by searching KL for RegEx: String \w+\(String \w+
	int offsetByCodePoints(int index, int codePointOffset) {
		try {
			return str.offsetByCodePoints(index, codePointOffset);
		} catch (Exception e) {
			return 0;
		}
	}
	boolean regionMatches(boolean ignoreCase, int toffset, String other,
			int ooffset, int len) {
		try {
			return str.regionMatches(ignoreCase, toffset, other, ooffset, len);
		} catch (Exception e) {
			return false;
		}
	}
	boolean regionMatches(int toffset, String other, int ooffset, int len) {
		try {
			return str.regionMatches(toffset, other, ooffset, len);
		} catch (Exception e) {
			return false;
		}
	}
	public static String join(CharSequence delimiter,
			CharSequence... elements) {
		try {
			return String.join(delimiter, elements);
		} catch (Exception e) {
			return "";
		}
	}
	public static String join(CharSequence delimiter,
			Iterable<? extends CharSequence> elements) {
		try {
			return String.join(delimiter, elements);
		} catch (Exception e) {
			return "";
		}
	}
	String join() {
		if (isEmpty())
			return "";
		if (words.length < 2)
			return nthWord(0);
		String halfProcessed = String.join(", ", words);
		String returnValue = halfProcessed.replaceAll("(?<=,)(\\s)(?=\\w+$)",
				"$1and$1");
		returnValue = new lafz(returnValue).sentCase();
		return returnValue;
	}
	String replace(String re, String _with) {
		if (isEmpty())
			return "";
		if (re == null || re.length() == 0 || _with == null)
			return str;
		// leave the check of _with, let it be blank sometimes, to allow
		// replacement of the looked up re with a blank string
		try {
			return str.replaceAll(re, _with);
		} catch (PatternSyntaxException | StackOverflowError e) {
			return str;
		}
	}
	String replace(CharSequence re, CharSequence _with) {
		return replace(re.toString(), _with.toString());
	}
	String replace(char oldChar, char newChar) {
		return replace("" + oldChar, "" + newChar);
	}
	String replaceFirst(String re, String _with) {
		if (isEmpty())
			return "";
		if (re == null || re.length() == 0 || _with == null)
			return str;
		// leave the check of _with, let it be blank sometimes, to allow
		// replacement of the looked up re with a blank string
		try {
			return str.replaceFirst(re, _with);
		} catch (PatternSyntaxException | StackOverflowError e) {
			return str;
		}
	}
	String replaceAll(String re, String _with) {
		return replace(re, _with);
	}
	String remove(String re) {
		return replace(re, "");
	}
	String removeAll(String re) {
		return remove(re);
	}
	String replaceFirstWord(String _with) {
		if (isEmpty())
			return "";
		if (noWords() || _with == null)
			return str;
		return replace(firstWord(), _with);
	}
	String replaceSecondWord(String _with) {
		if (isEmpty())
			return "";
		if (noWords() || _with == null)
			return str;
		return replace(secondWord(), _with);
	}
	String replaceSecondLastWord(String _with) {
		if (isEmpty())
			return "";
		if (noWords() || _with == null)
			return str;
		return replace(secondLastWord(), _with);
	}
	String replaceLastWord(String _with) {
		if (isEmpty())
			return "";
		if (noWords() || _with == null)
			return str;
		return replace(lastWord(), _with);
	}
	String replaceNthWord(String _with, int n) {
		if (isEmpty())
			return "";
		if (noWords() || _with == null || n < 0 || n >= wordCount())
			return str;
		return replace(nthWord(n), _with);
	}

	String encode() {
		return KL.encode(str);
	}
	String cypher() {
		return KL.cypher(str);
	}
	String lock() {
		return KL.lock(str);
	}
	String encode(Object salt) {
		return KL.encode(str, salt);
	}
	String cypher(Object salt) {
		return KL.cypher(str, salt);
	}
	String lock(Object salt) {
		return KL.lock(str, salt);
	}
	String decode() {
		return KL.decode(str);
	}
	String decypher() {
		return KL.decypher(str);
	}
	String unlock() {
		return KL.unlock(str);
	}
	String decode(Object salt) {
		return KL.decode(str, salt);
	}
	String decypher(Object salt) {
		return KL.decypher(str, salt);
	}
	String unlock(Object salt) {
		return KL.unlock(str, salt);
	}
	String encodeUrl(String s) {
		return KL.encodeUrl(s);
	}
	String decodeUrl(String s) {
		return KL.decodeUrl(s);
	}

	int length() {
		if (str == null)
			str = "";
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
		if (str == null)
			return "";
		return str;
	}
	public String string() {
		return toString();
	}
	public String str() {
		return toString();
	}
}
class str extends lafz {
	str() {
		this.str = "";
	}
	str(Object... objs) {
		this.str = "";
		for (Object o : objs) {
			if (o != null)
				this.str += " " + o;
		}
		trim();
		words = split("[^a-zA-Z'\\-]+|\\-(?![a-zA-Z]{2,})");
	}
}

class Main {
	public static lafz lafz(Object... objs) {
		return new lafz(objs);
	}
	public static lafz $(Object... objs) {
		return new lafz(objs);
	}
	public static str str(Object... objs) {
		return new str(objs);
	}
	public static void main(String[] args) {
		lafz salaam = $("  hi", "there", "love!", "I'm", 23);
		lafz greeting2 = $("hi", " boyfriends");
		str name = str("mehrunisa ji");
		System.out.println(salaam.sentCase());
		System.out.println(name.i(-12));
		System.out.println(name.lastWord());
		System.out.println(lafz("boyfriends", "love", "money").join());
		System.out.println(lafz("boyfriends", "love", "money").join());
	}
}