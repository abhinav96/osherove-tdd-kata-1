package abhinav.tdd.kata;

import java.util.Arrays;
import java.util.regex.Pattern;

public class StringCalculator
{
    private static final String DEFAULT_SEPARATOR = "[,\n]";

    public int add(final String numbers) {
        if (!numbers.trim().isEmpty()) {
            String input = numbers;
            String separator = DEFAULT_SEPARATOR;
            if (numbers.startsWith("//")) {
                separator = Pattern.quote(numbers.substring(2, 3));
                input = numbers.substring(4);
            }
            final String[] separatedNums = input.split(separator);
            return Arrays.stream(separatedNums)
                    .map(n -> n.trim())
                    .mapToInt(Integer::parseInt)
                    .sum();
        }
        return 0;
    }

}
