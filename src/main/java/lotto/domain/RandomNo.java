package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNo {
    public static final int ZERO = 0;
    public static final int SCOPE = 45;

    public static List<LottoNumber> generateRandomNos(final int lottoNumberSize) {
        List<LottoNumber> lottoNos = new ArrayList<>();

        for (int i = 1; i <= SCOPE; i++) {
            lottoNos.add(new LottoNumber(i));
        }

        Collections.shuffle(lottoNos);
        return lottoNos.subList(ZERO, lottoNumberSize);
    }
}
