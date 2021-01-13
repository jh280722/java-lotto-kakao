package lotto.controller;

import lotto.domain.*;
import lotto.domain.result.LottoResults;
import lotto.utils.StringUtils;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoSimulationController {
    private static final int LOTTO_NUMBER_SIZE = 6;

    public Money getPrice() {
        return Money.of(InputView.getPrice());
    }

    public Lottos buyLottoTickets(Money price) {
        int lottoTicketCount = price.countLotto();
        int manualLottoTicketCount = StringUtils.parseInt(InputView.getManualLottoTicketCount());
        OutputView.printBuyingManualLotto();

        int autoLottoTicketCount = getAutoLottoTicketCount(lottoTicketCount, manualLottoTicketCount);

        Lottos lottos = new Lottos();
        buyManualLotto(manualLottoTicketCount, lottos);
        buyAutoLotto(autoLottoTicketCount, lottos);

        OutputView.printLottoCount(manualLottoTicketCount, autoLottoTicketCount);
        OutputView.printLottos(lottos);

        return lottos;
    }

    private void buyAutoLotto(int autoLottoTicketCount, Lottos lottos) {
        for (int i = 0; i < autoLottoTicketCount; i++) {
            lottos.addLotto(Lotto.of(RandomNo.generateRandomNumbers(LOTTO_NUMBER_SIZE)));
        }
    }

    private void buyManualLotto(int manualLottoTicketCount, Lottos lottos) {
        for (int i = 0; i < manualLottoTicketCount; i++) {
            lottos.addLotto(Lotto.of(StringUtils
                    .convertToIntegerList(InputView.getManualLotto().split(","))));
        }
    }

    private int getAutoLottoTicketCount(int LottoTicketCount, int manualLottoTicketCount) {
        if (LottoTicketCount < manualLottoTicketCount) {
            throw new IllegalArgumentException("사용하려는 로또 티켓이 가진 로또 티켓보다 많습니다.");
        }
        return LottoTicketCount - manualLottoTicketCount;
    }

    public void printLottoSimulationResult(Lottos lottos, Money price) {
        WinningLotto winningLotto = WinningLotto.of(
                StringUtils.convertToIntegerList(InputView.getWinningLottoNo().split(",")),InputView.getBonusBall());
        LottoResults lottoResults = LottoResults.of(lottos.match(winningLotto), price);

        OutputView.printLottoResults(lottoResults);
    }
}
