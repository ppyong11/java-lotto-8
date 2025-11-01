package lotto.exception;

public enum ErrorMessage {

    BLANK_INPUT("[ERROR] 값이 입력되지 않았습니다."),
    INVALID_DELIMITER("[ERROR] 구분자는 쉼표(,)여야 합니다."),
    NOT_NUMBER("[ERROR] 입력 값은 숫자여야 합니다."),
    OUT_OF_RANGE("[ERROR] 숫자는 1부터 45 사이여야 합니다."),
    DUPLICATED_NUMBER("[ERROR] 중복된 번호가 있습니다."),
    DUPLICATED_BONUS_NUMBER("[ERROR] 당첨 번호와 중복되는 번호입니다."),
    INVALID_COUNT("[ERROR] 당첨 번호는 6개여야 합니다."),
    INVALID_BONUS_COUNT("[ERROR] 보너스 번호는 1개여야 합니다."),
    INVALID_MONEY_UNIT("[ERROR] 구매 금액은 1,000원 단위여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
