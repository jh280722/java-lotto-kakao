package lotto.DTO;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Price;
import lotto.domain.WinningLotto;
import lotto.utils.LottoResult;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.List;

public class LottoResults {
    private final List<LottoResult> lottoResults;
    private final long reward;
    private final Price price;
    private final double yield;

    public LottoResults(List<LottoResult> lottoResults, Price price) {
        this.lottoResults = lottoResults;
        this.price = price;
        reward = getReward();
        yield= (double) reward / price.getPrice();
    }

    public int getResultCount(LottoResult result) {
        return (int) lottoResults.stream()
                .filter(lottoResult -> lottoResult.equals(result))
                .count();
    }

    public long getReward() {
        long reward = 0;
        for (LottoResult lottoResult : lottoResults) {
            reward += lottoResult.getReward();
        }
        return reward;
    }

    public double getYield() {
        return yield;
    }

    @Override
    public String toString() {
        StringBuilder resultString = new StringBuilder();
        resultString.append("3개 일치 (" + LottoResult.FIFTH.getReward() + "원)- " + getResultCount(LottoResult.FIFTH) + "개\n");
        resultString.append("4개 일치 (" + LottoResult.FOURTH.getReward() + "원)- " + getResultCount(LottoResult.FOURTH) + "개\n");
        resultString.append("5개 일치 (" + LottoResult.THIRD.getReward() + "원)- " + getResultCount(LottoResult.THIRD) + "개\n");
        resultString.append("5개 일치, 보너스 볼 일치(" + LottoResult.SECOND.getReward() + "원)- " + getResultCount(LottoResult.SECOND) + "개\n");
        resultString.append("6개일일치 (" + LottoResult.FIRST.getReward() + "원)- " + getResultCount(LottoResult.FIRST) + "개");

        return resultString.toString();
    }
}
