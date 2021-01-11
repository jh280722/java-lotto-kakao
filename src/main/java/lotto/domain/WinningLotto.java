package lotto.domain;

import lotto.domain.result.LottoResult;

public class WinningLotto {
    private final LottoNumber bonusBall;
    private final Lotto winningLotto;

    public WinningLotto(Lotto winningLotto, LottoNumber bonusBall) {
        this.bonusBall = bonusBall;
        this.winningLotto = winningLotto;
    }

    public LottoResult match(Lotto lotto) {
        return LottoResult.mapResult(winningLotto.countMatchingNumber(lotto), lotto.contains(bonusBall));
    }
}
