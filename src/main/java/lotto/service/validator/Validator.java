package lotto.service.validator;

import lotto.exception.ErrorMessage;

import java.util.HashSet;
import java.util.List;

public class Validator {

    public static void validateParsedValue(List<Integer> winningNumbers) {
        validateCount(winningNumbers);
        validateDuplicate(winningNumbers);
        validateRange(winningNumbers);
    }

    private static void validateCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COUNT.getMessage());
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER.getMessage());
        }
    }

    private static void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.getMessage());
            }
        }
    }
}
