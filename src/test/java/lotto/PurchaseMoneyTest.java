package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.PurchaseMoney;
import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PurchaseMoneyTest extends NsTest {
    @Test
    void 객체_정상_생성_테스트() {
        assertThatCode(() -> new PurchaseMoney("2000"))
                .doesNotThrowAnyException();
    }

    @Test
    void 구입_금액_숫자_예외_테스트() {
        assertThatThrownBy(() -> new PurchaseMoney("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_NUMBER.getMessage());
    }

    @Test
    void 구입_금액_단위_예외_테스트() {
        assertThatThrownBy(() -> new PurchaseMoney("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_MONEY_UNIT.getMessage());

        assertThatThrownBy(() -> new PurchaseMoney("-1000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_MONEY_UNIT.getMessage());

        assertThatThrownBy(() -> new PurchaseMoney("1500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_MONEY_UNIT.getMessage());
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
