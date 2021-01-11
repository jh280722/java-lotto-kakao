package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @Test
    void getSize() {
        Lottos lottos = Lottos.getLottosInstance(3);
        assertThat(lottos.size()).isEqualTo(3);
    }

    @Test
    void create() {
        Lottos lottos = new Lottos(Arrays.asList(
                Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
                Lotto.of(Arrays.asList(11, 14, 3, 34, 37, 44)),
                Lotto.of(Arrays.asList(21, 9, 7, 17, 5, 34))));

        assertThat(lottos).isEqualTo(new Lottos(Arrays.asList(
                Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
                Lotto.of(Arrays.asList(11, 14, 3, 34, 37, 44)),
                Lotto.of(Arrays.asList(21, 9, 7, 17, 5, 34)))));
    }
}
