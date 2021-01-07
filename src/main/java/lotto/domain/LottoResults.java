package lotto.domain;

import lotto.utils.Result;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoResults {
    private List<Result> lottoResults;

    public LottoResults() {
        this(Arrays.asList());
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

    public void add(int count, boolean bonus) {
        lottoResults.add(mapResult(count, bonus));
    }

    public List<Result> getLottoResults() {
        return lottoResults;
    }

}
