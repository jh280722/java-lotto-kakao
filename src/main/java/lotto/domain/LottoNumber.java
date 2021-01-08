package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private final int lottoNumber;

    public LottoNumber(String lottoNumberText) {
        try {
            this.lottoNumber = Integer.parseInt(lottoNumberText.trim());
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자와 , 만 사용해주세요.");
        }
    }

    public LottoNumber(int lottoNo) {
        if (isInvalidRange(lottoNo)) {
            throw new IllegalArgumentException("로또 숫자는 1~45 사이로만 입력해주세요.");
        }
        this.lottoNumber = lottoNo;
    }

    private boolean isInvalidRange(int lottoNumber) {
        return lottoNumber < MIN_LOTTO_NUMBER || lottoNumber > MAX_LOTTO_NUMBER;
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber digit1 = (LottoNumber) o;
        return lottoNumber == digit1.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        if (this.lottoNumber < lottoNumber.getLottoNumber())
            return -1;
        if (this.lottoNumber > lottoNumber.getLottoNumber())
            return 1;
        return 0;
    }
}
