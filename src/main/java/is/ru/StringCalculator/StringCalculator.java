package is.ru.StringCalculator;

public class StringCalculator {
	
	public static int add(String text) {
		if(text.isEmpty()) { return 0; }
		else if (text.startsWith("//")) {
			int indexOfNewLine = text.indexOf("\n");
			int indexOfComma = text.indexOf(",");
			if (indexOfNewLine == -1) {
				String delimiter = text.substring(2,indexOfComma);
				String numbers = text.substring(indexOfComma + 1);
				return sum(splitStringBy(delimiter,numbers));
			}
			else {
				String delimiter = text.substring(2,indexOfNewLine);
				String numbers = text.substring(indexOfNewLine + 1);
				return sum(splitStringBy(delimiter,numbers));
			}
			
		}
		else if (text.contains(",") || text.contains("\n")) {
			return sum(splitString(text));
		}
		else {
			return 1;
		}
	}

	private static int toInt(String s){
		return Integer.parseInt(s);
	}

	private static String[] splitStringBy(String delimiter, String numbers){
		return numbers.split(delimiter);
	}

	private static String[] splitString(String s) {
		return s.split("[,\n]");
	}

	private static int sum(String[] numbers) {
		int sum = 0;
		for (String s : numbers) {
			sum += toInt(s);
		}
		return sum;
	}
}
