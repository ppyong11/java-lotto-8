package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private final List<Lotto> lottoes;

    public Lottos(List<Lotto> lottoes) {
        this.lottoes = lottoes;
    }

    public List<Lotto> getLotto() {
        return lottoes;
    }

    public Map<Rank, Integer> createResults(WinningLotto winningLotto) {
        Map<Rank, Integer> results = new EnumMap<>(Rank.class);

        // Rank 이미 있으면 +1, 아니면 키 생성 후 +1
        for (Lotto lotto : lottoes) {
            Rank rank = winningLotto.setResults(lotto);
            results.merge(rank, 1, Integer::sum);
            }
        return results;
    }
}
