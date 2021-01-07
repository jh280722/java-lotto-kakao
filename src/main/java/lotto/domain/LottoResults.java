package lotto.domain;

import lotto.utils.Result;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoResults {
    private final List<Result> lottoResults;
    private static final long THREE_PRICE = 5000;
    private static final long FOUR_PRICE = 50000;
    private static final long FIVE_PRICE = 1500000;
    private static final long BONUSFIVE_PRICE = 30000000;
    private static final long SIX_PRICE = 2000000000;

    public LottoResults() {
        this(Collections.emptyList());
    }

    public LottoResults(List<Result> results) {
        lottoResults = results;
    }

    public static Result mapResult(int count, boolean bonus) {
        if (count == 3) return Result.THREE;
        if (count == 4) return Result.FOUR;
        if (count == 5 && bonus) return Result.BONUSFIVE;
        if (count == 5) return Result.FIVE;
        if (count == 6) return Result.SIX;
        return Result.UNDERTHREE;
    }

    public int getResultCount(Result result) {
        return (int) lottoResults.stream()
                .filter(lottoResult -> lottoResult.equals(result))
                .count();
    }

    public long getReward() {
        long reward = 0;
        reward += getResultCount(Result.THREE) * THREE_PRICE;
        reward += getResultCount(Result.FOUR) * FOUR_PRICE;
        reward += getResultCount(Result.FIVE) * FIVE_PRICE;
        reward += getResultCount(Result.BONUSFIVE) * BONUSFIVE_PRICE;
        reward += getResultCount(Result.SIX) * SIX_PRICE;
        return reward;
    }

    @Override
    public String toString() {
        StringBuilder resultString = new StringBuilder();
        resultString.append("3개 일치 (" + THREE_PRICE + "원)- " + getResultCount(Result.THREE) + "개\n");
        resultString.append("4개 일치 (" + FOUR_PRICE + "원)- " + getResultCount(Result.FOUR) + "개\n");
        resultString.append("5개 일치 (" + FIVE_PRICE + "원)- " + getResultCount(Result.FIVE) + "개\n");
        resultString.append("5개 일치, 보너스 볼 일치(" + BONUSFIVE_PRICE + "원)- " + getResultCount(Result.BONUSFIVE) + "개\n");
        resultString.append("6개일일치 (" + SIX_PRICE + "원)- " + getResultCount(Result.SIX) + "개");

        return resultString.toString();
    }
}
