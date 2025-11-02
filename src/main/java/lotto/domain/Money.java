package lotto.domain;

import lotto.exception.ErrorMessage;

public class Money {
    private final int money;

    public Money(String input) {
        int parsed = parseInt(input);
        validateMoneyUnit(parsed);
        this.money = parsed;
    }

    public int getMoney() {
        return money;
    }

    public int lottoCount(int money) {
        return money / 1000;
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage());
        }
    }

    private void validateMoneyUnit(int money) {
        if (money < 1000 || money % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY_UNIT.getMessage());
        }
    }

}
