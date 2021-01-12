package lotto.domain.result;

import lotto.domain.Money;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class LottoResults {
    private static final long INITIAL_REWARD = 0L;
    private final Map<LottoResult, Long> lottoResultsAndCount;
    private final Money price;
    private final Money reward;

    private LottoResults(Map<LottoResult, Long> lottoResults, Money price) {
        this.lottoResultsAndCount = Collections.unmodifiableMap(lottoResults);
        this.price = price;
        this.reward = calculateReward();
    }

    public static LottoResults of(List<LottoResult> lottoResults, Money price) {
        Map<LottoResult, Long> lottoResultsAndCount = lottoResults.stream()
                .collect(groupingBy(Function.identity(), counting()));
        return new LottoResults(lottoResultsAndCount, price);
    }

    private Money calculateReward() {
        long reward = INITIAL_REWARD;
        for (Map.Entry<LottoResult, Long> entry : lottoResultsAndCount.entrySet()) {
            reward += entry.getKey().getReward() * entry.getValue();
        }
        return Money.of(reward);
    }

    public double getYield() {
        return reward.getYield(price);
    }

    public Money getReward() {
        return reward;
    }

    public long getCount(LottoResult lottoResult) {
        if (lottoResultsAndCount.get(lottoResult) == null) {
            return 0;
        }
        return lottoResultsAndCount.get(lottoResult);
    }
}
