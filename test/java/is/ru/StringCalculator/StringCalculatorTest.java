package is.ru.StringCalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StringCalculatorTest {
	
	public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("is.ru.StringCalculatorTest");
	}
	
	@Test
	public void test() {
		assertEquals(0, StringCalculator.add(""));
	}
}
