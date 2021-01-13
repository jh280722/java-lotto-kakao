package lotto.domain.result;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.result.BonusBallCondition.*;

public enum LottoResult implements Comparable<LottoResult> {
    FIRST(1, 6, DONT_CARE, 2_000_000_000L, "6개 일치 (2000000000원)-"),
    SECOND(2, 5, CONTAIN_BONUS, 30_000_000L, "5개 일치, 보너스 볼 일치(30000000원)-"),
    THIRD(3, 5, NOT_CONTAIN_BONUS, 1_500_000L, "5개 일치 (1500000원)-"),
    FOURTH(4, 4, DONT_CARE, 50_000L, "4개 일치 (50000원)-"),
    FIFTH(5, 3, DONT_CARE, 5_000L, "3개 일치 (5000원)-"),
    NOTHING(6, 0, DONT_CARE, 0L, "");

    private final int rank;
    private final int matchNumber;
    private final BonusBallCondition condition;
    private final long reward;
    private final String rewardExplain;

    LottoResult(int rank, int matchNumber, BonusBallCondition bonusBallCondition, long reward, String rewardExplain) {
        this.rank = rank;
        this.matchNumber = matchNumber;
        this.condition = bonusBallCondition;
        this.reward = reward;
        this.rewardExplain = rewardExplain;
    }

    public static LottoResult mapResult(int matchNumber, boolean bonus) {
        return Arrays.stream(values())
                .filter(lottoResult ->
                        (lottoResult.matchNumber == matchNumber) && lottoResult.condition.check(bonus))
                .findFirst()
                .orElse(NOTHING);
    }

    public long getReward() {
        return reward;
    }

    public String getRewardExplain() {
        return rewardExplain;
    }

    public static List<LottoResult> getPrize() {
        List<LottoResult> lottoResultValues = Arrays.stream(LottoResult.values())
                .filter(lottoResult -> lottoResult != LottoResult.NOTHING)
                .collect(Collectors.toList());
        lottoResultValues.sort(Comparator.comparing(LottoResult::getRank).reversed());
        return lottoResultValues;
    }

    public int getRank() {
        return rank;
    }
}
