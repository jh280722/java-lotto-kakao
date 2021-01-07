package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<Integer> digits;

    public Lotto(List<Integer> digits) {
        if (isInvalidNumberOfDigits(digits)) {
            throw new IllegalArgumentException("숫자는 6개만 입력해주세요.");
        }
        if (isInvalidRange(digits)) {
            throw new IllegalArgumentException("로또 숫자는 1~45 사이로만 입력해주세요.");
        }
        Collections.sort(digits);
        this.digits = digits;
    }

    private boolean isInvalidNumberOfDigits(List<Integer> digits) {
        return digits.size() != 6;
    }

    private boolean isInvalidRange(List<Integer> digits) {
        boolean flag = false;
        for (int digit : digits) {
            flag = flag || isInvalidRange(digit);
        }
        return flag;
    }

    private boolean isInvalidRange(int digit) {
        return (digit < 1 || digit > 45);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(digits, lotto.digits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(digits);
    }
}
