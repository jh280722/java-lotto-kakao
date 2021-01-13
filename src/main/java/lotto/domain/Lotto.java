package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private final List<LottoNumber> lotto;

    private Lotto(List<LottoNumber> lotto) {
        if (isInvalidNumberOfDigits(lotto)) {
            throw new IllegalArgumentException("숫자는 6개만 입력해주세요.");
        }
        if (isDuplicate(lotto)) {
            throw new IllegalArgumentException("숫자는 중복되면 안 됩니다.");
        }
        Collections.sort(lotto);
        this.lotto = lotto;
    }

    public static Lotto of(List<Integer> lotto) {
        return new Lotto(lotto.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList()));
    }

    private boolean isDuplicate(List<LottoNumber> lotto) {
        return lotto.stream()
                .distinct()
                .count() != lotto.size();
    }

    private boolean isInvalidNumberOfDigits(List<LottoNumber> lotto) {
        return lotto.size() != LOTTO_SIZE;
    }

    public int countMatchingNumber(Lotto lotto) {
        return (int) this.lotto.stream()
                .filter(lotto::contains)
                .count();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber);
    }

    @Override
    public String toString() {
        StringJoiner strJoiner = new StringJoiner(", ", "[", "]");

        for (LottoNumber lottoNumber : lotto) {
            strJoiner.add(lottoNumber.toString());
        }

        return strJoiner.toString();
    }
}
