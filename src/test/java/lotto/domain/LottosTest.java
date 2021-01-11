package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @Test
    void getSize() {
        Lottos lottos = Lottos.createRandomLottos(3);
        assertThat(lottos.size()).isEqualTo(3);
    }
}
