package abhinav.tdd.kata;

public class StringCalculator
{
    private static final String SEPARATOR = ",";

    public int add(final String numbers) {
        if (!numbers.isEmpty()) {
            if (isSingleNumber(numbers)) {
                return Integer.parseInt(numbers);
            }
            return addTwoNumbers(numbers);
        }
        return 0;
    }

    private int addTwoNumbers(final String numbers) {
        final int firstNum = Integer.parseInt(numbers.substring(0, numbers.indexOf(SEPARATOR)));
        final int secondNum = Integer.parseInt(numbers.substring(numbers.indexOf(SEPARATOR) + 1));
        return firstNum + secondNum;
    }

    private boolean isSingleNumber(final String numbers) {
        return !numbers.contains(SEPARATOR);
    }
}
