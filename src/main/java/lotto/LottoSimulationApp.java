package lotto;

import lotto.domain.result.LottoResults;
import lotto.domain.LottoSimulation;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoSimulationApp {
    public static void main(String[] args) {
        Money price = Money.of(InputView.getPrice());
        OutputView.printLottoCount(price);

        Lottos lottos = Lottos.createRandomLottos(price.countLottoTicket());
        OutputView.printLottos(lottos);

        String winningLottoText = InputView.getWinningLottoNo();
        String bonusBall = InputView.getBonusBall();

        LottoSimulation lottoSimulation = new LottoSimulation(price, winningLottoText, bonusBall);
        LottoResults lottoResults = lottoSimulation.match();

        OutputView.printLottoResults(lottoResults);
        OutputView.printYield(lottoResults);
    }
}
