package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.result.LottoResult;
import lotto.domain.result.LottoResults;

import java.util.Comparator;
import java.util.List;

public class OutputView {
    private static final String LINE_BREAK = "\n";

    public static void printLottos(Lottos lottos) {
        StringBuilder lottosString = new StringBuilder();

        for (Lotto lotto : lottos.getLottos()) {
            lottosString.append(lotto);
            lottosString.append(LINE_BREAK);
        }

        System.out.println(lottosString);
    }

    public static void printLottoResults(LottoResults lottoResults) {
        StringBuilder lottoResultsString = new StringBuilder();
        lottoResultsString.append("당첨 통계")
                .append(LINE_BREAK)
                .append("---------")
                .append(LINE_BREAK);

        for (LottoResult lottoResult : getReversedLottoResult()) {
            lottoResultsString.append(lottoResult.getRewardExplain())
                .append(lottoResults.getCount(lottoResult))
                .append("개")
                .append(LINE_BREAK);
        }
        System.out.println(lottoResultsString);
        System.out.println("총 수익률은 " + String.format("%.2f", lottoResults.getYield()) + "입니다.");
    }

    private static List<LottoResult> getReversedLottoResult() {
        List<LottoResult> lottoResultValues = LottoResult.notNothingValues();
        lottoResultValues.sort(Comparator.comparing(LottoResult::getMatchNumber));
        return lottoResultValues;
    }

    public static void printBuyingManualLotto() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public static void printLottoCount(int manualLottoCount, int lottoCount) {
        System.out.println("수동으로 " + manualLottoCount + "장, 자동으로 " + lottoCount + "개를 구매했습니다.");
    }
}
