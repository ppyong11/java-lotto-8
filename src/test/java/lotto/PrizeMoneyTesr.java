package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.PrizeMoney;
import lotto.domain.PurchaseMoney;
import lotto.domain.Rank;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
public class PrizeMoneyTesr extends NsTest {
    @Test
    void 객체_생성_테스트() {
        Map<Rank, Integer> results = new EnumMap<>(Rank.class);
        results.put(Rank.RANK_5, 3);
        results.put(Rank.RANK_4, 2);

        PrizeMoney prizeMoney = PrizeMoney.from(results);

        assertThat(prizeMoney.getAmount()).isEqualTo(115000);
    }

    @Test
    void 수익률_계산_테스트() {
        Map<Rank, Integer> results = new EnumMap<>(Rank.class);
        results.put(Rank.RANK_5, 1);

        PrizeMoney prizeMoney = PrizeMoney.from(results);

        PurchaseMoney money = new PurchaseMoney("8000");

        assertThat(prizeMoney.rate(money)).isEqualTo(62.5);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
