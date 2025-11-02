package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.exception.ErrorMessage;
import lotto.service.validator.Validator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ValidatorTest extends NsTest {
    @Test
    void 당첨_번호_정상_파싱_검증_테스트() {
        assertThatNoException()
                .isThrownBy(() -> Validator.validateWinningNumbers(List.of(1,2,3,4,5,6)));
    }

    @Test
    void 당첨_번호_개수_예외_테스트() {
        assertThatThrownBy(() -> Validator.validateWinningNumbers(List.of(1,2,3,4,5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_COUNT.getMessage());
    }

    @Test
    void 당첨_번호_범위_예외_테스트() {
        assertThatThrownBy(() -> Validator.validateWinningNumbers(List.of(1,2,3,4,5,67)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.OUT_OF_RANGE.getMessage());
    }

    @Test
    void 당첨_번호_중복_예외_테스트() {
        assertThatThrownBy(() -> Validator.validateWinningNumbers(List.of(1,2,3,4,5,5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATED_NUMBER.getMessage());
    }

    @Test
    void 보너스_번호_정상_검증_테스트() {
        List<Integer> winningNumbers = new ArrayList<>(List.of(1,2,3,4,5,6));
        int bonusNumber = 12;

        assertThatNoException()
                .isThrownBy(() -> Validator.validateBonusNumber(bonusNumber, winningNumbers));
    }

    @Test
    void 보너스_번호_당첨_번호_중복_테스트() {
        List<Integer> winningNumbers = new ArrayList<>(List.of(1,2,3,4,5,6));
        int bonusNumber = 6;

        assertThatThrownBy(() -> Validator.validateBonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATED_BONUS_NUMBER.getMessage());
    }

    @Test
    void 보너스_번호_범위_예외_테스트() {
        List<Integer> winningNumbers = new ArrayList<>(List.of(1,2,3,4,5,6));
        int bonusNumber = 47;

        assertThatThrownBy(() -> Validator.validateBonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.OUT_OF_RANGE.getMessage());
    }

    @Test
    void 구입_금액_정상_파싱_테스트() {
        int parseMoney = Validator.parseInt("2000");

        assertThat(parseMoney).isEqualTo(2000);
    }

    @Test
    void 구입_금액_숫자_예외_테스트() {
        assertThatThrownBy(() -> Validator.parseInt("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_NUMBER.getMessage());
    }

    @Test
    void 구입_금액_정상_단위_테스트() {
        assertThatNoException()
                .isThrownBy(() -> Validator.validateMoneyUnit(2000));
    }

    @Test
    void 구입_금액_단위_예외_테스트() {
        assertThatThrownBy(() -> Validator.validateMoneyUnit(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_MONEY_UNIT.getMessage());

        assertThatThrownBy(() -> Validator.validateMoneyUnit(-1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_MONEY_UNIT.getMessage());

        assertThatThrownBy(() -> Validator.validateMoneyUnit(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_MONEY_UNIT.getMessage());
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
