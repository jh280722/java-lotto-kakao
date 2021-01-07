package lotto.domain;

import java.util.Objects;
import java.util.Random;

public class RandomNo {
    public static final int SCOPE = 45;
    private static final Random random = new Random();
    private final Digit randomNo;

    public RandomNo() {
        this(random.nextInt(SCOPE) + 1);
    }

    public RandomNo(int randomNo) {
        this.randomNo = new Digit(randomNo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RandomNo randomNo1 = (RandomNo) o;
        return Objects.equals(randomNo, randomNo1.randomNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(randomNo);
    }
}
