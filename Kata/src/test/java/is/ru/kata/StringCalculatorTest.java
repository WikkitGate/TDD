package is.ru.kata;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringCalculatorTest{
	@Test
	public void addEmptyString(){
		StringCalculator sc = new StringCalculator();
		assertEquals(0, sc.add());
	}
