package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class LottosTest extends NsTest {
    @Test
    void 객체_정상_생성_테스트() {
        List<Lotto> lottos = new ArrayList<>(
            List.of(
                new Lotto(List.of(1,2,3,4,5,6)),
                new Lotto(List.of(2,3,4,5,6,7))
            )
        );
        assertThatCode(() -> new Lottos(lottos))
                .doesNotThrowAnyException();
    }

    @Test
    void 당첨_등수_맵_생성_테스트() {
        Lotto winning = new Lotto(List.of(1,2,3,4,5,6));
        WinningLotto winningLotto = new WinningLotto(winning, 7);

        List<Lotto> lottos = new ArrayList<>(
                List.of(
                        new Lotto(List.of(1,2,3,4,5,6)),
                        new Lotto(List.of(2,3,4,5,6,7))
                )
        );

        Lottos lottos1 = new Lottos(lottos);

        Map<Rank, Integer> rankCount = lottos1.createResults(winningLotto);

        assertThat(rankCount.size()).isEqualTo(2); // 1등, 2등
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
