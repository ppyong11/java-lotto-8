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
        return Console.readLine();
    }
    public static String inputBonusNumber() {
        return Console.readLine();
    }

    public static void outputBuyLottos(int count, List<Lotto> lottos) {
        System.out.println(count + "개를 구매했습니다.");

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers().toString());
        }
    }

    public static void outputResult(Map<Rank, Integer> results) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            int count = results.getOrDefault(rank, 0); // 자동 언박싱
            System.out.println(rank.toString(count));
        }
    }
}
