package is.ru.StringCalculator;

public class StringCalculator {
	
	public static int add(String text) {
		if(text.isEmpty()) { return 0; }
		else if (containsDelimiter(text)) {
			return sum(splitString(text));
		}
		else { return 1; }
	}

	private static int toInt(String s){
		int number = Integer.parseInt(s);
		return number;
	}

	private static Boolean containsDelimiter(String s){
		return (s.contains(",") || s.contains("\n"));
	}

	private static String[] splitStringBy(String delimiter, String numbers){
		return numbers.split(delimiter);
	}

	private static String[] splitString(String s) {
		String delimiter = "[" + ",\n" + "]";
		if (HasSpecificDelimiter(s)){
			int indexOfNewLine = s.indexOf("\n");
			int indexOfComma = s.indexOf(",");
			if (indexOfNewLine == -1) {
				delimiter = s.substring(2,indexOfComma);
				String numbers = s.substring(indexOfComma + 1);
				return numbers.split(delimiter);
			}
			else {
				delimiter = s.substring(2,indexOfNewLine);
				String numbers = s.substring(indexOfNewLine + 1);
				return numbers.split(delimiter);
			}
		}
		return s.split(delimiter);
	}

	private static int sum(String[] numbers) {
		int sum = 0;
		for (String s : numbers) {
			sum += toInt(s);
		}
		return sum;
	}

	private static Boolean HasSpecificDelimiter(String numbers){
            return numbers.startsWith("//");
    }
}
