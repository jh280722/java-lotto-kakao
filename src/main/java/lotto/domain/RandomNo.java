package lotto.domain;

import java.util.*;

public class RandomNo {
    public static final int SCOPE = 45;

    public static List<Integer> generateRandomNos(int number) {
        List<Integer> number1to45 = new ArrayList<>();
        for (int i = 1; i <= SCOPE; ++i) {
            number1to45.add(i);
        }

        Collections.shuffle(number1to45);
        return number1to45.subList(0, number);
    }
}
