package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
