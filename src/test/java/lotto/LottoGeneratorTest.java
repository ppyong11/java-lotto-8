package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.Lotto;
import lotto.service.util.LottoGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class LottoGeneratorTest extends NsTest {
    @Test
    void 랜덤_값_조건_검증_테스트() {
        assertThat(LottoGenerator.generate()).isInstanceOf(Lotto.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
