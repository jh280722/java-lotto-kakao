package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.result.LottoResult;
import lotto.dto.LottoResultsDto;

import java.util.Map;

public class OutputView {
    public static final String LINE_BREAK = "\n";

    public static void printLottos(Lottos lottos) {
        StringBuilder lottosString = new StringBuilder();

        for (Lotto lotto : lottos.getLottos()) {
            lottosString.append(lotto);
            lottosString.append(LINE_BREAK);
        }

        System.out.println(lottosString);
    }

    public static void printYield(LottoResultsDto lottoResults) {
        System.out.println("총 수익률은 " + String.format("%.2f", lottoResults.getYieid()) + "입니다.");
    }

    public static void printLottoCount(Money price) {
        System.out.println(price.countLottoTicket() + "개를 구매했습니다.");
    }

    public static void printLottoResults(LottoResultsDto lottoResults) {
        StringBuilder lottoResultsString = new StringBuilder();
        lottoResultsString.append("당첨 통계")
                .append(LINE_BREAK)
                .append("---------")
                .append(LINE_BREAK);

        for (Map.Entry<LottoResult, Long> entry : lottoResults.getLOTTO_RESULTS().entrySet()) {
            lottoResultsString.append(entry.getKey().getRewardExplain())
                    .append(entry.getValue())
                    .append(LINE_BREAK);
        }
        System.out.println(lottoResultsString);
    }
}
