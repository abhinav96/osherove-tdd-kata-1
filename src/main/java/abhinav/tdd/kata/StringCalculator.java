package abhinav.tdd.kata;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator
{
    private static final String DEFAULT_SEPARATOR = "[,\n]";

    public int add(final String input) {
        if (!input.trim().isEmpty()) {
            final String separator = getSeparator(input);
            final String numbers = preProcessInput(input);

            final List<Integer> parsedNumbers = parseToIntegers(numbers, separator);

            validateNumbers(parsedNumbers);

            return addNumbers(parsedNumbers);
        }
        return 0;
    }

    private String preProcessInput(String input) {
        return input.startsWith("//") ? 
            input.substring(4) : input;
    }

    private String getSeparator(String input) {
        return input.startsWith("//") ?
            Pattern.quote(input.substring(2, 3)) : DEFAULT_SEPARATOR;
    }

    private int addNumbers(final List<Integer> parsedNumbers) {
        return parsedNumbers.stream().collect(Collectors.summingInt(Integer::valueOf));
    }

    private void validateNumbers(final List<Integer> parsedNumbers) {
        final List<Integer> negativeNumbers =
            parsedNumbers.stream().filter(i -> i < 0).collect(Collectors.toList());
        
        if (negativeNumbers.size() > 0) {
            throw new IllegalArgumentException("negatives not allowed, " + negativeNumbers);
        }
    }

    private List<Integer> parseToIntegers(String input, String separator) {
        final String[] separatedNums = input.split(separator);
        final List<Integer> allNumbers =
         Arrays.stream(separatedNums)
                .map(n -> n.trim())
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
        return allNumbers;
    }

}
