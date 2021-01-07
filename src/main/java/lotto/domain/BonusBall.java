package lotto.domain;

import java.util.Objects;

public class BonusBall {
    private final int bonusBall;

    public BonusBall(int bonusBall) {
        if (isInvalidRange(bonusBall)) {
            throw new IllegalArgumentException("로또 숫자는 1~45 사이로만 입력해주세요.");
        }
        this.bonusBall = bonusBall;
    }

    private boolean isInvalidRange(int digit) {
        return (digit < 1 || digit > 45);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BonusBall bonusBall1 = (BonusBall) o;
        return bonusBall == bonusBall1.bonusBall;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bonusBall);
    }
}
