package lotto.domain;

import java.util.*;

public class RandomNo {
    public static final int ZERO = 0;
    public static final int SCOPE = 45;

    public static List<Integer> generateRandomNos(final int lottoNumberSize) {
        List<Integer> lottoNos = new ArrayList<>();
        for (int i = 1; i <= SCOPE; ++i) {
            lottoNos.add(i);
        }

        Collections.shuffle(lottoNos);
        return lottoNos.subList(ZERO, lottoNumberSize);
    }
}
