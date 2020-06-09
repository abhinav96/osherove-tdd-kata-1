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
}
