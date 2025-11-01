package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

import java.util.List;

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
}
