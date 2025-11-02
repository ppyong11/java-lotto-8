package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest extends NsTest {

    @Test
    void 객체_정상_생성_테스트() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        int bonusNumber = 12;

        assertThatNoException()
                .isThrownBy(() -> new WinningLotto(lotto, bonusNumber));
    }

    @Test
    void 보너스_번호_중복_테스트() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        int bonusNumber = 6;

        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATED_BONUS_NUMBER.getMessage());
    }

    @Test
    void 보너스_번호_범위_예외_테스트() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        int bonusNumber = 47;

        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.OUT_OF_RANGE.getMessage());
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
