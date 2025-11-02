package lotto.service.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

public class LottoGenerator {
    private static final int ROW_SIZE = 6;
    private static final int MIN = 1;
    private static final int MAX = 45;

    public static Lotto generate() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(MIN, MAX, ROW_SIZE));
    }
}
