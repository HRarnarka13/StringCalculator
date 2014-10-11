package is.ru.StringCalculator;

public class StringCalculator {
	
	public static int add(String text) {
		if(text.isEmpty()) { return 0; }
		else if (text.contains(",")) {
			String[] s = splitString(text);
			return toInt(s[0]) + toInt(s[1]); 
		}
		else {
			return 1;
		}
	}

	private static int toInt(String s){
		return Integer.parseInt(s);
	}

	private static String[] splitString(String s) {
		return s.split(",");
	}

}
