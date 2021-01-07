package lotto.domain;

import java.util.Objects;

public class WinningLotto {
    private final BonusBall bonusBall;
    private final Lotto winningLotto;

    public WinningLotto(Lotto winningLotto) {
        this(new BonusBall(37), winningLotto);
    }

    public WinningLotto(BonusBall bonusBall, Lotto winningLotto) {
        this.bonusBall = bonusBall;
        this.winningLotto = winningLotto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(winningLotto, that.winningLotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLotto);
    }
}
