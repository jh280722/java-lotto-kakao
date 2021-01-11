package lotto.DTO;

import lotto.domain.Price;
import lotto.utils.LottoResult;

import java.util.List;

public class LottoResults {
    private final List<LottoResult> lottoResults;
    private final Price price;

    public LottoResults(List<LottoResult> lottoResults, Price price) {
        this.lottoResults = lottoResults;
        this.price = price;
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
        return (double) getReward() / price.getPrice();
    }
}
