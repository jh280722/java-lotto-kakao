package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNo {
    public static final int FIRST_INDEX = 0;
    public static final int SCOPE = 45;

    public static List<Integer> generateRandomNumbers(final int lottoNumberSize) {
        List<Integer> lottoNumbers = new ArrayList<>();

        for (int i = 1; i <= SCOPE; i++) {
            lottoNumbers.add(i);
        }

        Collections.shuffle(lottoNumbers);
        return lottoNumbers.subList(FIRST_INDEX, lottoNumberSize);
    }
}
