package is.ru.StringCalculator;
import java.util.ArrayList;

public class StringCalculator {
	
	public static int add(String text) {
		if(text.isEmpty()) { return 0; }
		else if (ContainsDelimiter(text)) {
			return Sum(SplitString(text));
		}
		else { return 1; }
	}

	private static int ToInt(String s){
		return Integer.parseInt(s);
	}

	private static Boolean ContainsDelimiter(String s){
		return (s.contains(",") || s.contains("\n"));
	}

	private static String[] SplitString(String s) {
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

	private static int Sum(String[] numbers) {
		int sum = 0;
		CheckNegavite(numbers);
		for (String n : numbers) {
			sum += ToInt(n);
		}
		return sum;
	}

	private static void CheckNegavite(String[] numbers) {
		int i = 0;
		Boolean negavite = false;
		ArrayList<Integer> negaviteNumbers = new ArrayList<Integer>();
		for (String n : numbers) {
			int num = ToInt(n);
			if(num < 0) {
				negavite = true;
				negaviteNumbers.add(num);
			}
		}
		if(negavite) {
			String exceptionMessage = "Negatives not allowed: ";
			if(negaviteNumbers.size() == 1) {
				exceptionMessage += Integer.toString(negaviteNumbers.get(0));
			}
			else {
				for(int j = 0; j < negaviteNumbers.size(); j++) {
					exceptionMessage += (Integer.toString(negaviteNumbers.get(j)) + ",");
				}
				exceptionMessage = exceptionMessage.substring(0, exceptionMessage.length() - 1);
			}
			throw new IllegalArgumentException(exceptionMessage);
		}
	}

	private static Boolean HasSpecificDelimiter(String numbers){
            return numbers.startsWith("//");
    }
}
