package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.*;
import lotto.service.LottoService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoServiceTest extends NsTest {

    LottoService service = new LottoService();

    @Test
    void 구매_금액_검증_정상_테스트() {
        PurchaseMoney money = service.validatePurchaseMoney("8000");

        assertThat(money.getMoney()).isEqualTo(8000);
        assertThat(money.lottoCount(money.getMoney())).isEqualTo(8);
    }

    @Test
    void 구매_금액_숫자_예외_테스트() {
        assertThatThrownBy(() -> service.validatePurchaseMoney("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구매_금액_검증_단위_예외_테스트() {
        assertThatThrownBy(() -> service.validatePurchaseMoney("1250"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호_파싱_정상_테스트() {
        List<Integer> result = service.parseWinningNumber("1,2,3,4,5,6");

        assertThat(result).containsExactly(1,2,3,4,5,6);
    }

    @Test
    void 당첨_번호_파싱_예외_테스트() {
        assertThatThrownBy(() -> service.parseWinningNumber("a,b,c"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호_파싱_정상_테스트() {
        int result = service.parseBonusNumber("7");

        assertThat(result).isEqualTo(7);
    }

    @Test
    void 보너스번호_파싱_예외_테스트() {
        assertThatThrownBy(() -> service.parseBonusNumber("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_정상_발행_테스트() {
        PurchaseMoney money = new PurchaseMoney("8000");
        Lottos lottos = service.generateLottos(money);

        assertThat(lottos.getLotto()).hasSize(8);

        assertThat(lottos.getLotto().get(0).getNumbers()).hasSize(6);
    }

    @Test
    void 등수_계산_정상_테스트() {
        List<Lotto> lottosList = new ArrayList<>(
                List.of(
                        new Lotto(List.of(1,2,3,4,5,6)),
                        new Lotto(List.of(10,11,12,13,14,15))
                )
        );

        Lottos lottos = new Lottos(lottosList);

        WinningLotto winningLotto = new WinningLotto(
                new Lotto(List.of(1,2,3,4,5,6)),
                7);

        Map<Rank, Integer> result = service.calculateResult(lottos, winningLotto);

        assertThat(result.get(Rank.RANK_1)).isEqualTo(1);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
