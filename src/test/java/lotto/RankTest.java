package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.Rank;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class RankTest extends NsTest {
    @Test
    void 등수_포맷_문자열_테스트() {
        assertThat(Rank.RANK_2.toString(5)).isEqualTo(
            "5개 일치, 보너스 볼 일치 (30,000,000원) - 5개"
            );

        assertThat(Rank.RANK_1.toString(0)).isEqualTo(
                "6개 일치 (2,000,000,000원) - 0개"
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
