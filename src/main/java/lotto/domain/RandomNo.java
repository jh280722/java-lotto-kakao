package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class RandomNo {
    public static final int SCOPE = 45;
    private static final Random random = new Random();

    public static int getInstance() {
        return getInstance(random.nextInt(SCOPE) + 1);
    }

    public static int getInstance(int number) {
        return number;
    }

    public static List<Integer> generateRandomNos(int number) {
        List<Integer> digits = new ArrayList<>();
        for (int i = 0; i < number; ++i) {
            digits.add(getInstance());
        }
        return digits;
    }
}
