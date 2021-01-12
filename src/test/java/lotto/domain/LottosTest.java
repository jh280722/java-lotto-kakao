package lotto.domain;

import lotto.domain.result.LottoResult;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @Test
    void match2() {
        WinningLotto winningLotto = WinningLotto.of("1,2,3,4,5,6","7");

        Lottos lottos = new Lottos(Arrays.asList(
                Lotto.of(Arrays.asList(1,2,3,4,5,6)),
                Lotto.of(Arrays.asList(1,2,3,4,5,7))
        ));
        assertThat(lottos.match(winningLotto))
                .isEqualTo(Arrays.asList(LottoResult.FIRST, LottoResult.SECOND));
    }

    @Test
    void match() {
        WinningLotto winningLotto = WinningLotto.of("1,2,3,4,5,6","7");

        Lottos lottos = new Lottos(Arrays.asList(
                Lotto.of(Arrays.asList(1,2,3,4,5,6))
        ));
        assertThat(lottos.match(winningLotto))
                .isEqualTo(Arrays.asList(LottoResult.FIRST));
    }

    @Test
    void addManualLotto() {
        Lottos lottos = new Lottos();
        lottos.addManualLotto(Lotto.of("8, 21, 23, 41, 42, 43"));
        lottos.addManualLotto(Lotto.of("3, 5, 11, 16, 32, 38"));
        lottos.addManualLotto(Lotto.of("7, 11, 16, 35, 36, 44"));
        assertThat(lottos.size()).isEqualTo(3);
    }

    @Test
    void addRandomLottos() {
        Lottos lottos = new Lottos();
        lottos.addRandomLottos(LottoTicketCount.of(3));
        assertThat(lottos.size()).isEqualTo(3);
    }
}
