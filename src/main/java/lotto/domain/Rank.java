package lotto.domain;

public enum Rank {
    RANK_5(3, 5_000),
    RANK_4(4, 50_000),
    RANK_3(5, 1_500_000),
    RANK_2(5, 30_000_000, true),
    RANK_1(6, 2_000_000_000),
    NONE(0, 0);

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

    public long getWinningAmount() {
        return winningAmount;
    }

    public static Rank valueOf(int matchCount, boolean bonusMatch) {
        if (matchCount == 3) return RANK_5;
        if (matchCount == 4) return RANK_4;
        if (matchCount == 5 && bonusMatch) return RANK_2;
        if (matchCount == 5) return RANK_3;
        if (matchCount == 6) return RANK_1;
        return NONE;
    }

    public String toString(int lottoCount) {
        if (this.matchBonus) {
            return String.format("%d개 일치, 보너스 볼 일치 (%,d원) - %d개", this.matchCount, this.winningAmount, lottoCount);
        }
        return String.format("%d개 일치 (%,d원) - %d개", this.matchCount, this.winningAmount, lottoCount);
    }
}
