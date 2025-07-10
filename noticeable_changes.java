public static void println(Object... args) {
		if (len(args) >= 2 && !isNull(args[0]) && args[0] instanceof String
				&& in(Str(args[0]), "[\\%\\$\\{\\}]")) {
			new KL().printf((String) args[0], slice(args, 1));
			return;
		} else if (len(args) == 1 && in(Str(args[0]), "[\\%\\$\\{\\}]")) {
			new KL().printf((String) args[0], new String[]{});
			return;
		}
		if (len(args) == 1 && !isNull(args[0]) && isArr(args[0])) {
			printArr(args[0]);
			return;







public static boolean type(Object obj, String guessedType) {
		if (not(guessedType))
			return false;
		return len(guessedType) < 3
				? startsWith(type(obj), guessedType)
				: in(type(obj), guessedType);
	}
	// ^this one stays too
	public static void type(Object src, Object cond1, Runnable sol1,
			Object cond2, Runnable sol2, Object cond3, Runnable sol3,
			Object cond4, Runnable sol4, Object cond5, Runnable sol5,
			Object cond6, Runnable sol6, Object cond7, Runnable sol7,
			Object cond8, Runnable sol8, Object cond9, Runnable sol9,
			Object cond10, Runnable sol10) {
		if (not(src))
			return;
		sw(type(src), cond1, sol1, cond2, sol2, cond3, sol3, cond4, sol4, cond5,
				sol5, cond6, sol6, cond7, sol7, cond8, sol8, cond9, sol9,
				cond10, sol10);
	}
	public static void type(Object src, Object cond1, Runnable sol1,
			Object cond2, Runnable sol2, Object cond3, Runnable sol3,
			Object cond4, Runnable sol4, Object cond5, Runnable sol5,
			Object cond6, Runnable sol6, Object cond7, Runnable sol7,
			Object cond8, Runnable sol8, Object cond9, Runnable sol9) {
		if (not(src))
			return;
		sw(type(src), cond1, sol1, cond2, sol2, cond3, sol3, cond4, sol4, cond5,
				sol5, cond6, sol6, cond7, sol7, cond8, sol8, cond9, sol9);
	}
	public static void type(Object src, Object cond1, Runnable sol1,
			Object cond2, Runnable sol2, Object cond3, Runnable sol3,
			Object cond4, Runnable sol4, Object cond5, Runnable sol5,
			Object cond6, Runnable sol6, Object cond7, Runnable sol7,
			Object cond8, Runnable sol8) {
		if (not(src))
			return;
		sw(type(src), cond1, sol1, cond2, sol2, cond3, sol3, cond4, sol4, cond5,
				sol5, cond6, sol6, cond7, sol7, cond8, sol8);
	}
	public static void type(Object src, Object cond1, Runnable sol1,
			Object cond2, Runnable sol2, Object cond3, Runnable sol3,
			Object cond4, Runnable sol4, Object cond5, Runnable sol5,
			Object cond6, Runnable sol6, Object cond7, Runnable sol7) {
		if (not(src))
			return;
		sw(type(src), cond1, sol1, cond2, sol2, cond3, sol3, cond4, sol4, cond5,
				sol5, cond6, sol6, cond7, sol7);
	}
	public static void type(Object src, Object cond1, Runnable sol1,
			Object cond2, Runnable sol2, Object cond3, Runnable sol3,
			Object cond4, Runnable sol4, Object cond5, Runnable sol5,
			Object cond6, Runnable sol6) {
		if (not(src))
			return;
		sw(type(src), cond1, sol1, cond2, sol2, cond3, sol3, cond4, sol4, cond5,
				sol5, cond6, sol6);
	}
	public static void type(Object src, Object cond1, Runnable sol1,
			Object cond2, Runnable sol2, Object cond3, Runnable sol3,
			Object cond4, Runnable sol4, Object cond5, Runnable sol5) {
		if (not(src))
			return;
		sw(type(src), cond1, sol1, cond2, sol2, cond3, sol3, cond4, sol4, cond5,
				sol5);
	}
	public static void type(Object src, Object cond1, Runnable sol1,
			Object cond2, Runnable sol2, Object cond3, Runnable sol3,
			Object cond4, Runnable sol4) {
		if (not(src))
			return;
		sw(type(src), cond1, sol1, cond2, sol2, cond3, sol3, cond4, sol4);
	}
	public static void type(Object src, Object cond1, Runnable sol1,
			Object cond2, Runnable sol2, Object cond3, Runnable sol3) {
		if (not(src))
			return;
		sw(type(src), cond1, sol1, cond2, sol2, cond3, sol3);
	}
	public static void type(Object src, Object cond1, Runnable sol1,
			Object cond2, Runnable sol2) {
		if (not(src))
			return;
		sw(type(src), cond1, sol1, cond2, sol2);
	}
	public static void type(Object src, Object cond1, Runnable sol1) {
		if (not(src))
			return;
		sw(type(src), cond1, sol1);
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













// for numeric operations
		String catchNumericValuesWithOperator = "(?<=\\&)(?<operandA>\\-?\\d*\\.?\\d+)(?<op>[\\+\\-\\*\\×\\/\\÷])(?<operandB>\\-?\\d*\\.?\\d+)";
		while (in(s, catchNumericValuesWithOperator)) {
			String[] numericMatchesWithOperators = findMatches(s,
					catchNumericValuesWithOperator);
			if (in(s, catchNumericValuesWithOperator)) {
				for (String m : numericMatchesWithOperators) {
					String[] parts = m
							.split("(?<=\\d)[\\+\\-\\*\\×\\/\\÷](?=\\d)");
					double operandA = Dbl(parts[0]), operandB = Dbl(parts[1]);
					String op = m.replaceAll(
							"[^\\+\\-\\*\\×\\/\\÷]|^[\\+\\-\\*\\×\\/\\÷]", "");
					double result = 0;
					switch (op) {
						case "+" :
							result = operandA + operandB;
							break;
						case "-" :
							result = operandA - operandB;
							break;
						case "*" :
						case "×" :
							result = operandA * operandB;
							break;
						case "/" :
						case "÷" :
							result = operandA / operandB;
							break;
					}
					s = replaceFirst(s, catchNumericValuesWithOperator,
							Str(result));
				}
			}
		}
		s = s.replaceAll("&(?=\\-?\\d*\\.?\\d+)", "");
		// cleaning up to make up for the numeric results, removing the &
		// operator
		s = sentCase(s);