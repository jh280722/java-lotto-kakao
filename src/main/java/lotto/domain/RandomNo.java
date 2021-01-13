package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNo {
    private static final int FIRST_INDEX = 0;
    private static final int SCOPE = 45;

    public static List<Integer> generateRandomNumbers(final int lottoNumberSize) {
        List<Integer> lottoNumbers = new ArrayList<>();

        for (int i = 1; i <= SCOPE; i++) {
            lottoNumbers.add(i);
        }

        Collections.shuffle(lottoNumbers);
        return lottoNumbers.subList(FIRST_INDEX, lottoNumberSize);
    }
}
