package lotto;

import lotto.domain.*;
import lotto.domain.result.LottoResults;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoSimulationApp {
    public static void main(String[] args) {
        Money price = Money.of(InputView.getPrice());
        LottoTicketCount autoLottoTicketCount = LottoTicketCount.of(price.countLotto());
        LottoTicketCount manualLottoTicketCount = LottoTicketCount.of(InputView.getManualLottoTicketCount());

        OutputView.printBuyingManualLotto();
        autoLottoTicketCount = autoLottoTicketCount.useLottoTicket(manualLottoTicketCount);

        Lottos lottos = buyLottoTickets(autoLottoTicketCount, manualLottoTicketCount);

        LottoSimulation lottoSimulation = new LottoSimulation(InputView.getWinningLottoNo(), InputView.getBonusBall());
        LottoResults lottoResults = LottoResults.of(lottoSimulation.match(lottos), price);

        OutputView.printLottoResults(lottoResults);
    }

    public static Lottos buyLottoTickets(LottoTicketCount autoLottoTicketCount, LottoTicketCount manualLottoTicketCount) {
        Lottos lottos = new Lottos();

        for (int i = 0; i < manualLottoTicketCount.getLottoTicketCount(); i++) {
            lottos.addManualLotto(Lotto.of(InputView.getManualLotto()));
        }
        lottos.addRandomLottos(autoLottoTicketCount);

        OutputView.printLottoCount(manualLottoTicketCount, autoLottoTicketCount);
        OutputView.printLottos(lottos);

        return lottos;
    }
}
