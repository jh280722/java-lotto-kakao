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
    public static final long DEFAULT_COUNT = 0L;
    private final Map<LottoResult, Long> LOTTO_RESULTS;
    private final Money price;
    private final Money reward;

    private LottoResults(Map<LottoResult, Long> lottoResults, Money price) {
        this.LOTTO_RESULTS = Collections.unmodifiableMap(lottoResults);
        this.price = price;
        this.reward = calculateReward();
    }

    public static LottoResults of(List<LottoResult> lottoResults, Money price) {
        Map<LottoResult, Long> lotto_Results = lottoResults.stream()
                .collect(groupingBy(Function.identity(), counting()));
        fillDefaultCount(lotto_Results);
        return new LottoResults(lotto_Results, price);
    }

    private static void fillDefaultCount(Map<LottoResult, Long> lotto_Results) {
        for (LottoResult lottoResult : LottoResult.values()) {
            lotto_Results.putIfAbsent(lottoResult, DEFAULT_COUNT);
        }
    }

    private Money calculateReward() {
        long reward = INITIAL_REWARD;
        for (Map.Entry<LottoResult, Long> entry : LOTTO_RESULTS.entrySet()) {
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

    public Map<LottoResult, Long> getLOTTO_RESULTS() {
        return LOTTO_RESULTS;
    }
}
