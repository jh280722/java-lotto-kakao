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
                new Lotto(Arrays.asList(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6))),
                new Lotto(Arrays.asList(
                        new LottoNumber(11),
                        new LottoNumber(14),
                        new LottoNumber(3),
                        new LottoNumber(34),
                        new LottoNumber(37),
                        new LottoNumber(44))),
                new Lotto(Arrays.asList(
                        new LottoNumber(21),
                        new LottoNumber(9),
                        new LottoNumber(7),
                        new LottoNumber(17),
                        new LottoNumber(5),
                        new LottoNumber(34))
                )));

        assertThat(lottos).isEqualTo(new Lottos(Arrays.asList(
                new Lotto(Arrays.asList(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6))),
                new Lotto(Arrays.asList(
                        new LottoNumber(11),
                        new LottoNumber(14),
                        new LottoNumber(3),
                        new LottoNumber(34),
                        new LottoNumber(37),
                        new LottoNumber(44))),
                new Lotto(Arrays.asList(
                        new LottoNumber(21),
                        new LottoNumber(9),
                        new LottoNumber(7),
                        new LottoNumber(17),
                        new LottoNumber(5),
                        new LottoNumber(34))
                ))));
    }
}
