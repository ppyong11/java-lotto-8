package lotto.domain;

import java.util.Map;

public class PrizeMoney {
    private final long amount;

    public PrizeMoney(long amount) {
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }

    public static PrizeMoney from(Map<Rank, Integer> results) {
        long sum = 0;

        for (Map.Entry<Rank, Integer> entry : results.entrySet()) {
            sum += (entry.getKey().getWinningAmount() * entry.getValue());
        }

        return new PrizeMoney(sum);
    }

    public double rate(PurchaseMoney purchaseMoney) {
        return (double) amount / purchaseMoney.getMoney() * 100;
    }
}
