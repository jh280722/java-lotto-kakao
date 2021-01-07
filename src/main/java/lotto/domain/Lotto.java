package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<Integer> digits;

    public Lotto(List<Integer> digits) {
        Collections.sort(digits);
        this.digits = digits;
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
