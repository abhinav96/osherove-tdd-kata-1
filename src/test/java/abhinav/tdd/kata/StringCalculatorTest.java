package abhinav.tdd.kata;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StringCalculatorTest 
{
    private void testAdd(final String input, final int expectedOutput) {
        final StringCalculator calculator = new StringCalculator();
        final int actualOutput = calculator.add(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void emptyStringShouldReturnZero()
    {
        testAdd("", 0);
    }

    @Test
    public void singleNumberShouldReturnTheNumberItself()
    {
        testAdd("5", 5);
    }

    @Test
    public void twoNumbersShouldReturnTheirSum() {
        testAdd("1,2", 3);
    }

    @Test
    public void onlySpacesShouldReturnZero() {
        testAdd("   ", 0);
    }

    @Test
    public void singleNumberWithExtraSpacesShouldReturnTheNumber() {
        testAdd("  1 ", 1);
    }

    @Test
    public void twoNumbersWithSpacesShouldReturnTheirSum() {
        testAdd(" 1 , 2 ", 3);
    }

    @Test
    public void moreThanTwoNumbersShouldReturnTheirSum() {
        testAdd("1,1,1", 3);
        testAdd("1,2,3", 6);
        testAdd("1,1,1,1", 4);
    }

    @Test
    public void numbersSeparatedByNewLineShouldReturnTheirSum() {
        testAdd("1\n2\n3", 6);
        testAdd("1\n2,3", 6);
    }

    @Test
    public void customDelimiterInFirstLineShouldBeHonoured() {
        testAdd("//;\n1;2", 3);
        testAdd("//;\n1;2;3", 6);
        testAdd("//*\n1*2", 3);
        testAdd("//*\n1*2*3", 6);
    }

}
