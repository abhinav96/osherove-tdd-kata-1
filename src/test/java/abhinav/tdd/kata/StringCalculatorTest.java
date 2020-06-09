package abhinav.tdd.kata;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StringCalculatorTest 
{
    @Test
    public void emptyStringShouldReturnZero()
    {
        final StringCalculator calculator = new StringCalculator();
        final int answer = calculator.add("");
        assertEquals(0, answer);
    }

    @Test
    public void singleNumberShouldReturnTheNumberItself()
    {
        final StringCalculator calculator = new StringCalculator();
        final int inputNum = 5;
        final int answer = calculator.add(String.valueOf(inputNum));
        assertEquals(inputNum, answer);
    }

    @Test
    public void multipleNumbersShouldReturnTheirSum() {
        final StringCalculator calculator = new StringCalculator();
        final int sum = calculator.add("1,2");
        assertEquals(3, sum);
    }

    @Test
    public void onlySpacesShouldReturnZero() {
        final StringCalculator calculator = new StringCalculator();
        final int answer = calculator.add("   ");
        assertEquals(0, answer);
    }

    @Test
    public void singleNumberWithExtraSpacesShouldReturnTheNumber() {
        final StringCalculator calculator = new StringCalculator();
        final int answer = calculator.add("  1 ");
        assertEquals(1, answer);
    }

    @Test
    public void twoNumbersWithSpacesShouldReturnTheirSum() {
        final StringCalculator calculator = new StringCalculator();
        final int answer = calculator.add(" 1 , 2 ");
        assertEquals(3, answer);
    }

}
