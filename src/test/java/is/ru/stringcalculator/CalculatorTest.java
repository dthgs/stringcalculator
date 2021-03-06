package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }

	@Test
    public void testMoreMultipleNumbers(){
    	assertEquals(10, Calculator.add("1,2,3,4"));
    }

    @Test
	public void testNewLine(){
		assertEquals(3, Calculator.add("1\n2"));
	}

	@Test
	public void testNewLine2(){
		assertEquals(10, Calculator.add("1\n2\n3\n4"));
	}

	@Test
	public void testNewLine3(){
		assertEquals(10, Calculator.add("1\n2,3\n4"));
	}

	@Test
	public void testDifferentDelimiter(){
		assertEquals(10, Calculator.add("//;\n1;2;3;4"));
	}

	@Test
	public void testNegativesNotAllowed() {
	try { Calculator.add("-1,2"); }
	catch (final Exception e) { assertEquals("For input string: \"-1,2\"", e.getMessage()); }
	}

	@Test
	public void testIgnoreNumbersBiggerThan1000(){
		assertEquals(3, Calculator.add("1001,1\n2"));
	}
}