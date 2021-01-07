package lotto.domain;

import java.util.*;

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
        List<Integer> number1to45 = new ArrayList<>();
        for (int i = 1; i <= SCOPE; ++i) {
            number1to45.add(i);
        }

        Collections.shuffle(number1to45);
        return number1to45.subList(0, number);
    }
}
