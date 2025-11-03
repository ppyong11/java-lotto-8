package lotto.service;

import lotto.domain.*;
import lotto.service.util.LottoGenerator;
import lotto.service.util.NumberParse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoService {

    public PurchaseMoney validatePurchaseMoney(String money) {
        return new PurchaseMoney(money);
    }

    public List<Integer> parseWinningNumber(String number) {
        return NumberParse.winningNumberParse(number);
    }

    public int parseBonusNumber(String input) {
        return NumberParse.bounsNumberParse(input);
    }

    public Lottos generateLottos(PurchaseMoney purchaseMoney) {
        int count = purchaseMoney.lottoCount(purchaseMoney.getMoney());
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(LottoGenerator.generate());
        }

        return new Lottos(lottos);
    }

    public Map<Rank, Integer> calculateResult(Lottos lottos, WinningLotto winningLotto) {
        return lottos.createResults(winningLotto);
    }
}
