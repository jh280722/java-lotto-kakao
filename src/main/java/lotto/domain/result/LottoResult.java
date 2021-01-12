package lotto.domain.result;

import java.util.Arrays;

import static lotto.domain.result.BonusBallCondition.*;

public enum LottoResult {
    FIRST(6,DONT_CARE, 2_000_000_000L, "6개 일치 (2000000000원)-"),
    SECOND(5, CONTAIN_BONUS, 30_000_000L, "5개 일치, 보너스 볼 일치(30000000원)-"),
    THIRD(5, NOT_CONTAIN_BONUS, 1_500_000L, "5개 일치 (1500000원)-"),
    FOURTH(4, DONT_CARE, 50_000L, "4개 일치 (50000원)-"),
    FIFTH(3, DONT_CARE, 5_000L, "3개 일치 (5000원)-"),
    NOTHING(0, DONT_CARE, 0L, "");

    private final int matchNumber;
    private final BonusBallCondition condition;
    private final long reward;
    private final String rewardExplain;

    LottoResult(int matchNumber, BonusBallCondition bonusBallCondition, long reward, String rewardExplain) {
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
}
