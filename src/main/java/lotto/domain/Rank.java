package lotto.domain;

public enum Rank {
    RANK_5(3, 5_000),
    RANK_4(4, 50_000),
    RANK_3(5, 1_500_000),
    RANK_2(5, 30_000_000, true),
    RANK_1(6, 2_000_000_000);

    private final int matchCount;
    private final long winningAmount;
    private final boolean matchBonus;

    Rank(int matchCount, long winningAmount) {
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
        this.matchBonus = false;
    }

    Rank(int matchCount, long winningAmount, boolean matchBonus) {
        this.winningAmount = winningAmount;
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
    }

    public String toString(int lottoCount) {
        if (this.matchBonus) {
            return String.format("%d개 일치, 보너스 볼 일치 (%,d원) - %d개", this.matchCount, this.winningAmount, lottoCount);
        }
        return String.format("%d개 일치 (%,d원) - %d개", this.matchCount, this.winningAmount, lottoCount);
    }
}
