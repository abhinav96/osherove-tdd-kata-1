package abhinav.tdd.kata;

public class StringCalculator
{
    public int add(final String numbers) {
        if (!numbers.isEmpty()) {
            if (!numbers.contains(",")) {
                return Integer.parseInt(numbers);
            }
            final int firstNum = Integer.parseInt(numbers.substring(0, numbers.indexOf(",")));
            final int secondNum = Integer.parseInt(numbers.substring(numbers.indexOf(",") + 1));
            return firstNum + secondNum;
        }
        return 0;
    }
}
