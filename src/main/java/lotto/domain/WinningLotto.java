package lotto.domain;

import lotto.domain.result.LottoResult;

public class WinningLotto {
    private final LottoNumber bonusBall;
    private final Lotto winningLotto;

    private WinningLotto(Lotto winningLotto, LottoNumber bonusBall) {
        if (winningLotto.contains(bonusBall)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호가 중복됩니다.");
        }
        this.bonusBall = bonusBall;
        this.winningLotto = winningLotto;
    }

    public static WinningLotto of(String winningLotto, String bonusBall) {
        return new WinningLotto(Lotto.of(winningLotto), LottoNumber.of(bonusBall));
    }

    public LottoResult match(Lotto lotto) {
        return LottoResult.mapResult(winningLotto.countMatchingNumber(lotto), lotto.contains(bonusBall));
    }
}
