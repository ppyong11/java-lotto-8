package lotto.service.util;

import lotto.exception.ErrorMessage;

import java.util.Arrays;
import java.util.List;

public class NumberParse {
    public static final String DELIMITER = ",";

    public static List<Integer> winningNumberParse(String input) {
        validateWinningNumber(input);

        try {
            return Arrays.stream(input.split(DELIMITER))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage());
        }
    }

    public static int bounsNumberParse(String input) {
        validateNotBlank(input);

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage());
        }
    }

    private static void validateWinningNumber(String input) {
        validateNotBlank(input);

        if (!input.contains(DELIMITER)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DELIMITER.getMessage());
        }
    }

    private static void validateNotBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_INPUT.getMessage());
        }
    }
}
