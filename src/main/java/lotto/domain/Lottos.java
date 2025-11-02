package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottoes;

    public Lottos(List<Lotto> lottoes) {
        this.lottoes = lottoes;
    }

    public List<Lotto> getLotto() {
        return lottoes;
    }

}
