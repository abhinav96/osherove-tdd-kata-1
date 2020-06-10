package abhinav.tdd.kata;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
            final List<Integer> allNumbers =
             Arrays.stream(separatedNums)
                    .map(n -> n.trim())
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());
            
            final List<Integer> negativeNumbers =
                allNumbers.stream().filter(i -> i < 0).collect(Collectors.toList());
            
            if (negativeNumbers.size() > 0) {
                throw new IllegalArgumentException("negatives not allowed, " + negativeNumbers);
            }

            return allNumbers.stream().collect(Collectors.summingInt(Integer::valueOf));
        }
        return 0;
    }

}
