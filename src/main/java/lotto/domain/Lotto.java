package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        if (isInvalidNumberOfDigits(lottoNumbers)) {
            throw new IllegalArgumentException("숫자는 6개만 입력해주세요.");
        }
        if (isDuplicate(lottoNumbers)) {
            throw new IllegalArgumentException("숫자는 중복되면 안 됩니다.");
        }
        Collections.sort(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private boolean isDuplicate(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .distinct()
                .count() != lottoNumbers.size();
    }

    private boolean isInvalidNumberOfDigits(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.size() != 6;
    }

    public int matchCount(Lotto lotto) {
        return (int) lottoNumbers.stream()
                .filter(lotto::contains)
                .count();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        StringJoiner strJoiner = new StringJoiner(", ", "[", "]");

        for (LottoNumber lottoNumber : lottoNumbers) {
            strJoiner.add(lottoNumber.toString());
        }

        return strJoiner.toString();
    }
}
