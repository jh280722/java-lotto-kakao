package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    void sort() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 4, 3, 5, 6));
        assertThat(lotto).isEqualTo(new Lotto(Arrays.asList(2, 1, 3, 4, 5, 6)));
    }

    @Test
    void create() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto).isEqualTo(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }
}
