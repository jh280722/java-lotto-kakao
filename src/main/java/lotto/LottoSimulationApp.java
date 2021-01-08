package lotto;

import lotto.DTO.LottoResults;
import lotto.domain.LottoSimulation;
import lotto.domain.Lottos;
import lotto.domain.Price;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoSimulationApp {
    public static void main(String[] args) {
        Price price = new Price(InputView.getPrice());
        OutputView.printLottoCount(price);

        Lottos lottos = Lottos.getLottosInstance(price.count());
        OutputView.printLottos(lottos);

        String winningLottoText = InputView.getWinningLottoNo();
        String bonusBall = InputView.getBonusBall();

        LottoSimulation lotto = new LottoSimulation(price, winningLottoText, bonusBall);

        LottoResults lottoResults = lotto.confirm();
        OutputView.printLottoResults(lottoResults);
        OutputView.printYield(lottoResults);
    }
}
