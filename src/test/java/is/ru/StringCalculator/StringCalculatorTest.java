package is.ru.StringCalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import static org.hamcrest.core.IsEqual.equalTo;

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
		assertEquals(3, StringCalculator.add("//#,1#2"));
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();
 
	@Test
	public void throwsExceptionWhenNegativeNumber() {
    // arrange
    	thrown.expect(IllegalArgumentException.class);
    	thrown.expectMessage(equalTo("Negatives not allowed: -1"));
    	// act
    	StringCalculator.add("-1,2");
	}

	@Test
	public void throwsExceptionWhenNegativeNumbers() {
    // arrange
    	thrown.expect(IllegalArgumentException.class);
    	thrown.expectMessage(equalTo("Negatives not allowed: -4,-5"));
    	// act
    	StringCalculator.add("2,-4,3,-5");
	}
	
	@Test
	public void testBigNumbers() {
		assertEquals(2, StringCalculator.add("1001,2"));
	}



}
