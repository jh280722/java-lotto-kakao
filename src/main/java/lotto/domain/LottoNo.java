package lotto.domain;

import java.util.Objects;

public class LottoNo {
    private static final int MIN_LOTTO_NO = 1;
    private static final int MAX_LOTTO_NO = 45;
    private final int lottoNo;

    public LottoNo(String lottoNoText) {
        try {
            this.lottoNo = Integer.parseInt(lottoNoText.trim());
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자와 , 만 사용해주세요.");
        }
    }

    public LottoNo(int lottoNo) {
        if (isInvalidRange(lottoNo)) {
            throw new IllegalArgumentException("로또 숫자는 1~45 사이로만 입력해주세요.");
        }
        this.lottoNo = lottoNo;
    }

    private boolean isInvalidRange(int lottoNo) {
        return lottoNo < MIN_LOTTO_NO || lottoNo > MAX_LOTTO_NO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNo digit1 = (LottoNo) o;
        return lottoNo == digit1.lottoNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNo);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNo);
    }
}
