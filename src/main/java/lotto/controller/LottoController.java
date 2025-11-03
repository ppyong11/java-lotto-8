package lotto.controller;

import lotto.domain.*;
import lotto.service.LottoService;
import lotto.view.IOview;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final LottoService service;

    public LottoController(LottoService service) {
        this.service = service;
    }

    public void run() {
        PurchaseMoney purchaseMoney;
        while (true) {
            try {
                String input = IOview.inputMoney();
                purchaseMoney = service.validatePurchaseMoney(input);
                break;
            } catch (IllegalArgumentException e) {
                IOview.outputErrror(e.getMessage());
            }
        }

        Lottos lottos = service.generateLottos(purchaseMoney);

        IOview.outputBuyLottos(
                purchaseMoney.lottoCount(purchaseMoney.getMoney()),
                lottos.getLotto()
        );

        Lotto winningNumber;
        while (true) {
            try {
                String input = IOview.inputWinNumber();
                List<Integer> numbers = service.parseWinningNumber(input);
                winningNumber = new Lotto(numbers);
                break;
            } catch (IllegalArgumentException e) {
                IOview.outputErrror(e.getMessage());
            }
        }

        WinningLotto winningLotto;
        while (true) {
            try {
                String input = IOview.inputBonusNumber();
                int bonusNumbers = service.parseBonusNumber(input);
                winningLotto = new WinningLotto(winningNumber, bonusNumbers);
                break;
            } catch (IllegalArgumentException e) {
                IOview.outputErrror(e.getMessage());
            }
        }

        Map<Rank, Integer> result = service.calculateResult(lottos, winningLotto);

        PrizeMoney prizeMoney = PrizeMoney.from(result);
        double rate = prizeMoney.rate(purchaseMoney);

        IOview.outputResult(result, rate);
    }
}
