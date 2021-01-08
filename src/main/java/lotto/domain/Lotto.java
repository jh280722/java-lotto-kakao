package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNo> lottoNos;

    public Lotto(List<Integer> lottoNos) {
        if (isInvalidNumberOfDigits(lottoNos)) {
            throw new IllegalArgumentException("숫자는 6개만 입력해주세요.");
        }
        if (isDuplicate(lottoNos)) {
            throw new IllegalArgumentException("숫자는 중복되면 안 됩니다.");
        }
        Collections.sort(lottoNos);
        this.lottoNos = mapIntegerToDigit(lottoNos);
    }

    private boolean isDuplicate(List<Integer> lottoNos) {
        return lottoNos.stream()
                .distinct()
                .count() != lottoNos.size();
    }

    private List<LottoNo> mapIntegerToDigit(List<Integer> lottoNos) {
        return lottoNos.stream()
                .map(LottoNo::new)
                .collect(Collectors.toList());
    }

    private boolean isInvalidNumberOfDigits(List<Integer> lottoNos) {
        return lottoNos.size() != 6;
    }

    public int matchCount(Lotto lotto) {
        return (int) lottoNos.stream()
                .filter(lotto::contains)
                .count();
    }

    public boolean contains(LottoNo lottoNo) {
        return lottoNos.contains(lottoNo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNos, lotto.lottoNos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNos);
    }

    @Override
    public String toString() {
        StringJoiner strJoiner = new StringJoiner(", ", "[", "]");

        for (LottoNo digit : lottoNos) {
            strJoiner.add(digit.toString());
        }

        return strJoiner.toString();
    }
}
