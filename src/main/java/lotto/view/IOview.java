package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.List;
import java.util.Map;

public class IOview {
    public static String inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }
    public static String inputWinNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }
    public static String inputBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static void outputBuyLottos(int count, List<Lotto> lottos) {
        System.out.println();
        System.out.println(count + "개를 구매했습니다.");

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers().toString());
        }
        System.out.println();
    }

    public static void outputResult(Map<Rank, Integer> results, double rate) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        for (Rank rank : Rank.values()) {
            if (rank == Rank.NONE) {
                continue;
            }
            int count = results.getOrDefault(rank, 0); // 자동 언박싱
            System.out.println(rank.toString(count));
        }
        System.out.printf("총 수익률은 %.1f%%입니다.%n",rate);
    }

    public static void outputErrror(String message) {
        System.out.println(message);
    }
}
