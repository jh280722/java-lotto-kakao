package lotto.domain;

import lotto.domain.result.LottoResult;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {
    @Test
    void matchLotto() {
        WinningLotto winningLotto = WinningLotto.of(Arrays.asList(1, 2, 3, 4, 5, 6), "10");

        assertThat(winningLotto.match(Lotto.of(Arrays.asList(5, 6, 7, 8, 9, 10))))
                .isEqualTo(LottoResult.NOTHING);
        assertThat(winningLotto.match(Lotto.of(Arrays.asList(5, 6, 7, 8, 9, 4))))
                .isEqualTo(LottoResult.FIFTH);
        assertThat(winningLotto.match(Lotto.of(Arrays.asList(5, 6, 7, 8, 3, 4))))
                .isEqualTo(LottoResult.FOURTH);
        assertThat(winningLotto.match(Lotto.of(Arrays.asList(5, 6, 9, 2, 3, 4))))
                .isEqualTo(LottoResult.THIRD);
        assertThat(winningLotto.match(Lotto.of(Arrays.asList(2, 3, 4, 5, 6, 10))))
                .isEqualTo(LottoResult.SECOND);
        assertThat(winningLotto.match(Lotto.of(Arrays.asList(2, 3, 4, 5, 6, 1))))
                .isEqualTo(LottoResult.FIRST);
    }
}
