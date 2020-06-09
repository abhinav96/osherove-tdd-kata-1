package abhinav.tdd.kata;

public class StringCalculator
{
    public int add(final String numbers) {
        if (!numbers.isEmpty()) {
            return Integer.parseInt(numbers);
        }
        return 0;
    }
}
