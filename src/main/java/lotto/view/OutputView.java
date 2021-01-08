package lotto.view;

import lotto.DTO.LottoResults;
import lotto.domain.Lottos;
import lotto.domain.Price;
import lotto.utils.LottoResult;

public class OutputView {
    public static void printLottos(Lottos lottos) {
        System.out.println(lottos);
    }

    public static void printYield(LottoResults lottoResults) {
        System.out.println("총 수익률은 " + String.format("%.2f", lottoResults.getYield()) + "입니다.");
    }

    public static void printLottoCount(Price price) {
        System.out.println(price.count() + "개를 구매했습니다.");
    }

    public static void printLottoResults(LottoResults lottoResults) {
        StringBuilder lottoResultsString = new StringBuilder();
        lottoResultsString.append("3개 일치 (" + LottoResult.FIFTH.getReward() + "원)- " + lottoResults.getResultCount(LottoResult.FIFTH) + "개\n");
        lottoResultsString.append("4개 일치 (" + LottoResult.FOURTH.getReward() + "원)- " + lottoResults.getResultCount(LottoResult.FOURTH) + "개\n");
        lottoResultsString.append("5개 일치 (" + LottoResult.THIRD.getReward() + "원)- " + lottoResults.getResultCount(LottoResult.THIRD) + "개\n");
        lottoResultsString.append("5개 일치, 보너스 볼 일치(" + LottoResult.SECOND.getReward() + "원)- " + lottoResults.getResultCount(LottoResult.SECOND) + "개\n");
        lottoResultsString.append("6개일일치 (" + LottoResult.FIRST.getReward() + "원)- " + lottoResults.getResultCount(LottoResult.FIRST) + "개");

        System.out.println(lottoResultsString);
    }
}
