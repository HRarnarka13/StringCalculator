package is.ru.StringCalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StringCalculatorTest {
	
	public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("is.ru.StringCalculatorTest");
	}
	
	@Test
	public void testEmptyString() {
		assertEquals(0, StringCalculator.add(""));
	}
	@Test
	public void testOneNumber() {
		assertEquals(1, StringCalculator.add("1"));
	}
	@Test
	public void testTwoNumbers() {
		assertEquals(3, StringCalculator.add("1,2"));
	}
	@Test
	public void testMoreNumbersWithCommasAndNewLines() {
		assertEquals(6, StringCalculator.add("1\n2,3"));
	}
	
	@Test
	public void testDelimiter() {
		assertEquals(3, StringCalculator.add("//;\n1;2"));
	}
	@Test
	public void testDelimiter2() {
		assertEquals(3, StringCalculator.add("//@,1@2"));
	}

}
