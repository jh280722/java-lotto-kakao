package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final Map<Integer, LottoNumber> LOTTO_NUMBERS = new HashMap<>();
    private final int lottoNumber;

    static {
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            LOTTO_NUMBERS.put(i, new LottoNumber(i));
        }
    }

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber of(String lottoNumberText) {
        try {
            int lottoNumber = Integer.parseInt(lottoNumberText.trim());
            return of(lottoNumber);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자와 , 만 입력 가능합니다.");
        }
    }

    public static LottoNumber of(int lottoNumber) {
        if (LOTTO_NUMBERS.get(lottoNumber) == null)
            throw new IllegalArgumentException(
                    MIN_LOTTO_NUMBER + " ~ " + MAX_LOTTO_NUMBER + " 범위의 숫자만 입력 가능합니다.");
        return LOTTO_NUMBERS.get(lottoNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return this.lottoNumber - lottoNumber.lottoNumber;
    }
}
