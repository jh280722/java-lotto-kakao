package lotto.domain.result;

import java.util.function.Function;

public enum BonusBallCondition {
    CONTAIN_BONUS(bonus -> bonus == true),
    NOT_CONTAIN_BONUS(bonus -> bonus == false),
    DONT_CARE(bonus -> true);

    private final Function<Boolean, Boolean> checkCondition;

    BonusBallCondition(Function<Boolean, Boolean> checkCondition) {
        this.checkCondition = checkCondition;
    }

    public boolean check(boolean bonus) {
        return checkCondition.apply(bonus);
    }
}
