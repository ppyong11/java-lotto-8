package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.exception.ErrorMessage;
import lotto.service.util.NumberParse;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class NumberParseTest extends NsTest {
    @Test
    void 당첨_번호_정상_입력_테스트() {
        String input = "1, 2, 3, 4, 5, 6";
        List<Integer> numbers = NumberParse.winningNumberParse(input);

        assertThat(numbers).isEqualTo(List.of(1,2,3,4,5,6));
    }

    @Test
    void 당첨_번호_구분자_예외_테스트() {
        assertThatThrownBy(() -> NumberParse.winningNumberParse("1.2.3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_DELIMITER.getMessage());

        assertThatThrownBy(() -> NumberParse.winningNumberParse("123"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_DELIMITER.getMessage());
    }

    @Test
    void 당첨_번호_숫자_예외_테스트() {

        assertThatThrownBy(() -> NumberParse.winningNumberParse("1.,2.,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_NUMBER.getMessage());

        assertThatThrownBy(() -> NumberParse.winningNumberParse("a, b, c"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_NUMBER.getMessage());
    }

    @Test
    void 당첨_번호_빈값_예외_테스트() {

        assertThatThrownBy(() -> NumberParse.winningNumberParse(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BLANK_INPUT.getMessage());

        assertThatThrownBy(() -> NumberParse.winningNumberParse(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BLANK_INPUT.getMessage());
    }

    @Test
    void 보너스_번호_정상_입력_테스트() {
        int bonusNumber = NumberParse.bounsNumberParse("12");

        assertThat(bonusNumber).isEqualTo(12);
    }

    @Test
    void 보너스_번호_숫자_예외_테스트() {
        assertThatThrownBy(() -> NumberParse.bounsNumberParse("1,2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_NUMBER.getMessage());

        assertThatThrownBy(() -> NumberParse.bounsNumberParse("ab"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_NUMBER.getMessage());
    }

    @Test
    void 보너스_번호_빈값_예외_테스트() {
        assertThatThrownBy(() -> NumberParse.bounsNumberParse(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BLANK_INPUT.getMessage());

        assertThatThrownBy(() -> NumberParse.bounsNumberParse(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BLANK_INPUT.getMessage());
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
