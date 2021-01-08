package lotto.utils;

public enum LottoResult {
    FIFTH, FOURTH, FIRST, THIRD, SECOND, NOTHING;

    public static final long ZERO = 0;
    private static final long FIFTH_REWARD = 5000;
    private static final long FOURTH_REWARD = 50000;
    private static final long THIRD_REWARD = 1500000;
    private static final long SECOND_REWARD = 30000000;
    private static final long FIRST_REWARD = 2000000000;

    public static LottoResult mapResult(int count, boolean bonus) {
        if (count == 6) return FIRST;
        if (count == 5 && bonus) return SECOND;
        if (count == 5) return THIRD;
        if (count == 4) return FOURTH;
        if (count == 3) return FIFTH;
        return NOTHING;
    }

    public long getReward() {
        if (this == FIRST) return FIRST_REWARD;
        if (this == SECOND) return SECOND_REWARD;
        if (this == THIRD) return THIRD_REWARD;
        if (this == FOURTH) return FOURTH_REWARD;
        if (this == FIFTH) return FIFTH_REWARD;
        return ZERO;
    }
}
