package lotto;

import lotto.controller.LottoSimulationController;
import lotto.domain.Lottos;
import lotto.domain.Money;

public class LottoSimulationApp {
    public static void main(String[] args) {
        LottoSimulationController lottoSimulationController = new LottoSimulationController();
        Money price = lottoSimulationController.getPrice();

        Lottos lottos = lottoSimulationController.buyLottoTickets(price);

        lottoSimulationController.printLottoSimulationResult(lottos, price);
    }
}
