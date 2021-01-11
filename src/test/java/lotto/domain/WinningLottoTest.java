package lotto.domain;

import lotto.utils.LottoResult;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {
    @Test
    void 로또번호일치() {
        WinningLotto winningLotto = new WinningLotto(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)), LottoNumber.of(10));

        assertThat(winningLotto.confirmLotto(Lotto.of(Arrays.asList(5, 6, 7, 8, 9, 10))))
                .isEqualTo(LottoResult.NOTHING);
        assertThat(winningLotto.confirmLotto(Lotto.of(Arrays.asList(5, 6, 7, 8, 9, 4))))
                .isEqualTo(LottoResult.FIFTH);
        assertThat(winningLotto.confirmLotto(Lotto.of(Arrays.asList(5, 6, 7, 8, 3, 4))))
                .isEqualTo(LottoResult.FOURTH);
        assertThat(winningLotto.confirmLotto(Lotto.of(Arrays.asList(5, 6, 9, 2, 3, 4))))
                .isEqualTo(LottoResult.THIRD);
        assertThat(winningLotto.confirmLotto(Lotto.of(Arrays.asList(2, 3, 4, 5, 6, 10))))
                .isEqualTo(LottoResult.SECOND);
        assertThat(winningLotto.confirmLotto(Lotto.of(Arrays.asList(2, 3, 4, 5, 6, 1))))
                .isEqualTo(LottoResult.FIRST);
    }

    @Test
    void create() {
        WinningLotto winningLotto = new WinningLotto(
                Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)), LottoNumber.of(37));
        assertThat(winningLotto)
                .isEqualTo(new WinningLotto(Lotto.of(Arrays.asList(2, 3, 4, 5, 6, 1)), LottoNumber.of(37)));
    }
}
