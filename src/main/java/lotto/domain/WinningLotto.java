package lotto.domain;

import lotto.domain.result.LottoResult;

import java.util.List;

public class WinningLotto {
    private final LottoNumber bonusBall;
    private final Lotto winningLotto;

    private WinningLotto(Lotto winningLotto, LottoNumber bonusBall) {
        this.bonusBall = bonusBall;
        this.winningLotto = winningLotto;
    }

    public static WinningLotto of(List<Integer> winningLotto, String bonusBall) {
        return new WinningLotto(Lotto.of(winningLotto), LottoNumber.of(bonusBall));
    }

    public LottoResult match(Lotto lotto) {
        return LottoResult.mapResult(winningLotto.countMatchingNumber(lotto), lotto.contains(bonusBall));
    }
}
