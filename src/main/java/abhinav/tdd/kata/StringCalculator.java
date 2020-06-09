package abhinav.tdd.kata;

public class StringCalculator
{
    private static final String SEPARATOR = ",";

    public int add(final String numbers) {
        if (!numbers.trim().isEmpty()) {
            if (isSingleNumber(numbers)) {
                return Integer.parseInt(numbers.trim());
            }
            return addTwoNumbers(numbers);
        }
        return 0;
    }

    private int addTwoNumbers(final String numbers) {
        final int firstNum = Integer.parseInt(numbers.substring(0, numbers.indexOf(SEPARATOR)).trim());
        final int secondNum = Integer.parseInt(numbers.substring(numbers.indexOf(SEPARATOR) + 1).trim());
        return firstNum + secondNum;
    }

    private boolean isSingleNumber(final String numbers) {
        return !numbers.contains(SEPARATOR);
    }
}
