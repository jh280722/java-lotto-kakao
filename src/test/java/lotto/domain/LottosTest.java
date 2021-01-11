package lotto.domain;

import lotto.domain.result.LottoResult;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @Test
    void match2() {
        WinningLotto winningLotto = WinningLotto.of(Arrays.asList(1,2,3,4,5,6),"7");

        Lottos lottos = new Lottos(Arrays.asList(
                Lotto.of(Arrays.asList(1,2,3,4,5,6)),
                Lotto.of(Arrays.asList(1,2,3,4,5,7))
        ));
        assertThat(lottos.match(winningLotto))
                .isEqualTo(Arrays.asList(LottoResult.FIRST, LottoResult.SECOND));
    }

    @Test
    void match() {
        WinningLotto winningLotto = WinningLotto.of(Arrays.asList(1,2,3,4,5,6),"7");

        Lottos lottos = new Lottos(Arrays.asList(
                Lotto.of(Arrays.asList(1,2,3,4,5,6))
        ));
        assertThat(lottos.match(winningLotto))
                .isEqualTo(Arrays.asList(LottoResult.FIRST));
    }

    @Test
    void getSize() {
        Lottos lottos = Lottos.createRandomLottos(3);
        assertThat(lottos.size()).isEqualTo(3);
    }
}
