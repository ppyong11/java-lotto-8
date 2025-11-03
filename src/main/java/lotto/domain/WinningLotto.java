package lotto.domain;

import lotto.exception.ErrorMessage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningLotto {
    private final Lotto winningNumber;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        validateBonusNumber(lotto.getNumbers(), bonusNumber);
        this.winningNumber = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Rank setResults(Lotto lotto) {
        int matchCount = lotto.matchCount(winningNumber.getNumbers());
        boolean bonusMatch = lotto.containsBonus(bonusNumber);
        return Rank.valueOf(matchCount, bonusMatch);
    }

    private void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_BONUS_NUMBER.getMessage());
        }

        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.getMessage());
        }
    }

}
