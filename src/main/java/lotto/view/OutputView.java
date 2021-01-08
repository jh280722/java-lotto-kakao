package lotto.view;

import lotto.DTO.LottoResults;
import lotto.domain.Lottos;
import lotto.domain.Price;

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

    public static void printResult(LottoResults lottoResults) {
        System.out.println(lottoResults);
    }
}
