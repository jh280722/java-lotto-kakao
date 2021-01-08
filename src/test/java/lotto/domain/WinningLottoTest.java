package lotto.domain;

import lotto.utils.Result;
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

        assertThat(winningLotto.compare(new Lotto(Arrays.asList(
                new LottoNumber(5),
                new LottoNumber(6),
                new LottoNumber(7),
                new LottoNumber(8),
                new LottoNumber(9),
                new LottoNumber(10)
        )))).isEqualTo(Result.NOTHING);
        assertThat(winningLotto.compare(new Lotto(Arrays.asList(
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6),
                new LottoNumber(7),
                new LottoNumber(8),
                new LottoNumber(9)
        )))).isEqualTo(Result.FIFTH);
        assertThat(winningLotto.compare(new Lotto(Arrays.asList(
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6),
                new LottoNumber(7),
                new LottoNumber(8)
        )))).isEqualTo(Result.FOURTH);
        assertThat(winningLotto.compare(new Lotto(Arrays.asList(
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6),
                new LottoNumber(9)
        )))).isEqualTo(Result.THIRD);
        assertThat(winningLotto.compare(new Lotto(Arrays.asList(
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6),
                new LottoNumber(10)
        )))).isEqualTo(Result.SECOND);
        assertThat(winningLotto.compare(new Lotto(Arrays.asList(
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6),
                new LottoNumber(1)
        )))).isEqualTo(Result.FIRST);
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
