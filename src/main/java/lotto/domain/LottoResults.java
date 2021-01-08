package lotto.domain;

import lotto.utils.Result;

import java.util.List;

public class LottoResults {
    private final List<Result> lottoResults;
    private static final long FIFTH_REWARD = 5000;
    private static final long FOURTH_REWARD = 50000;
    private static final long THIRD_REWARD = 1500000;
    private static final long SECOND_REWARD = 30000000;
    private static final long FIRST_REWARD = 2000000000;

    public LottoResults(List<Result> results) {
        lottoResults = results;
    }

    public static Result mapResult(int count, boolean bonus) {
        if (count == 6) return Result.FIRST;
        if (count == 5 && bonus) return Result.SECOND;
        if (count == 5) return Result.THIRD;
        if (count == 4) return Result.FOURTH;
        if (count == 3) return Result.FIFTH;
        return Result.NOTHING;
    }

    public int getResultCount(Result result) {
        return (int) lottoResults.stream()
                .filter(lottoResult -> lottoResult.equals(result))
                .count();
    }

    public long getReward() {
        long reward = 0;
        reward += getResultCount(Result.FIRST) * FIRST_REWARD;
        reward += getResultCount(Result.SECOND) * SECOND_REWARD;
        reward += getResultCount(Result.THIRD) * THIRD_REWARD;
        reward += getResultCount(Result.FOURTH) * FOURTH_REWARD;
        reward += getResultCount(Result.FIFTH) * FIFTH_REWARD;
        return reward;
    }

    @Override
    public String toString() {
        StringBuilder resultString = new StringBuilder();
        resultString.append("3개 일치 (" + FIFTH_REWARD + "원)- " + getResultCount(Result.FIFTH) + "개\n");
        resultString.append("4개 일치 (" + FOURTH_REWARD + "원)- " + getResultCount(Result.FOURTH) + "개\n");
        resultString.append("5개 일치 (" + THIRD_REWARD + "원)- " + getResultCount(Result.THIRD) + "개\n");
        resultString.append("5개 일치, 보너스 볼 일치(" + SECOND_REWARD + "원)- " + getResultCount(Result.SECOND) + "개\n");
        resultString.append("6개일일치 (" + FIRST_REWARD + "원)- " + getResultCount(Result.FIRST) + "개");

        return resultString.toString();
    }
}
