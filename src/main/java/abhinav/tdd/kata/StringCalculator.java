package abhinav.tdd.kata;

import java.util.Arrays;

public class StringCalculator
{
    private static final String SEPARATOR = "[,\n]";

    public int add(final String numbers) {
        if (!numbers.trim().isEmpty()) {
            final String[] separatedNums = numbers.split(SEPARATOR);
            return Arrays.stream(separatedNums)
                    .map(n -> n.trim())
                    .mapToInt(Integer::parseInt)
                    .sum();
        }
        return 0;
    }

}
