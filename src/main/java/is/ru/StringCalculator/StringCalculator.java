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
		int number = Integer.parseInt(s);
		if (NumberToBig(number)) { return 0; }
		return number;
	}

	private static String ToString(int i) {
		return Integer.toString(i);
	}

	private static Boolean ContainsDelimiter(String s){
		return (s.contains(",") || s.contains("\n"));
	}

	private static String[] SplitString(String s) {
		String delimiter = "[" + ",\n" + "]";
		if (HasSpecificDelimiter(s)){
			int indexOfNewLine = s.indexOf("\n");
			if (indexOfNewLine == 3) {
				delimiter = "[" + s.substring(2, indexOfNewLine) + "]";
				String numbers = s.substring(indexOfNewLine + 1);
				return numbers.split(delimiter);
			}
			else {
				int numberOfDelimeter = NumberOfOccurences(s, "[");
				String numbers = s.substring(indexOfNewLine + 1);
				if (numberOfDelimeter < 2) {
					delimiter = "[" + s.substring(3, indexOfNewLine - 1) + "]+";
					return numbers.split(delimiter);	
				}
				else {
					delimiter = "";
					String temp = s.substring(2, indexOfNewLine);
					try {
						while(temp.charAt(0) == '['){
							delimiter += temp.substring(1, temp.indexOf("]"));
							temp = temp.substring(temp.indexOf("]") + 1);
						}
					} catch(StringIndexOutOfBoundsException e) {
						delimiter = "["+ delimiter + "]+";
						return numbers.split(delimiter);
					}
				}
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
		Boolean containsNegavite = false;
		ArrayList<Integer> negaviteNumbers = new ArrayList<Integer>();
		for (String n : numbers) {
			int num = ToInt(n);
			if(num < 0) {
				containsNegavite = true;
				negaviteNumbers.add(num);
			}
		}
		if(containsNegavite) {
			ThrowException(negaviteNumbers);
		}
	}

	private static void ThrowException(ArrayList<Integer> negaviteNumbers) {
		String exceptionMessage = "Negatives not allowed: ";
		if(negaviteNumbers.size() == 1) {
			exceptionMessage = AppendToString(exceptionMessage, ToString(negaviteNumbers.get(0)));
		}
		else {
			for(int j = 0; j < negaviteNumbers.size(); j++) {
				exceptionMessage = AppendToString(exceptionMessage, ToString(negaviteNumbers.get(j)));
				exceptionMessage = AppendToString(exceptionMessage, ",");
			}
			// cut of the comma in the end of the string
			exceptionMessage = exceptionMessage.substring(0, exceptionMessage.length() - 1); 
		}
		throw new IllegalArgumentException(exceptionMessage);
	}

	private static Boolean NumberToBig(int number){
		return number > 1000;
	}

	private static String AppendToString(String prefix, String suffix) {
		return prefix + suffix;
	}

	private static Boolean HasSpecificDelimiter(String numbers){
            return numbers.startsWith("//");
    }

    private static int NumberOfOccurences(String s, String n){
		int counter = 0; 
		for(int i = 0; i < s.length(); i++) {
			if(s.substring(i, i+1).equals(n)){
				counter++;
			}
		}
		return counter;
	}
}
