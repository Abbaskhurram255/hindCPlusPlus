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