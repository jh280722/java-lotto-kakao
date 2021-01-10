package lotto.domain;

import lotto.utils.LottoResult;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {
    @Test
    void 로또번호일치() {
        WinningLotto winningLotto = new WinningLotto(
                new Lotto(Arrays.asList(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6)
                )),
                new LottoNumber(10));

        assertThat(winningLotto.confirmLotto(new Lotto(Arrays.asList(
                new LottoNumber(5),
                new LottoNumber(6),
                new LottoNumber(7),
                new LottoNumber(8),
                new LottoNumber(9),
                new LottoNumber(10)
        )))).isEqualTo(LottoResult.NOTHING);
        assertThat(winningLotto.confirmLotto(new Lotto(Arrays.asList(
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6),
                new LottoNumber(7),
                new LottoNumber(8),
                new LottoNumber(9)
        )))).isEqualTo(LottoResult.FIFTH);
        assertThat(winningLotto.confirmLotto(new Lotto(Arrays.asList(
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6),
                new LottoNumber(7),
                new LottoNumber(8)
        )))).isEqualTo(LottoResult.FOURTH);
        assertThat(winningLotto.confirmLotto(new Lotto(Arrays.asList(
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6),
                new LottoNumber(9)
        )))).isEqualTo(LottoResult.THIRD);
        assertThat(winningLotto.confirmLotto(new Lotto(Arrays.asList(
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6),
                new LottoNumber(10)
        )))).isEqualTo(LottoResult.SECOND);
        assertThat(winningLotto.confirmLotto(new Lotto(Arrays.asList(
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6),
                new LottoNumber(1)
        )))).isEqualTo(LottoResult.FIRST);
    }

    @Test
    void create() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        )), new LottoNumber(37));
        assertThat(winningLotto)
                .isEqualTo(new WinningLotto(new Lotto(Arrays.asList(
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6),
                        new LottoNumber(1)
                )), new LottoNumber(37)));
    }
}
