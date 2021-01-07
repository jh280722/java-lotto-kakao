package lotto.domain;

import lotto.utils.Result;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    @Test
    void duplicate() {
        assertThatThrownBy(() -> {
            new Lotto(Arrays.asList(1, 1, 2, 3, 4, 5));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void invalid_번호개수() {
        assertThatThrownBy(() -> {
            new Lotto(Arrays.asList(1, 5, 45, 2, 3, 7, 9));
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            new Lotto(Arrays.asList(1, 5, 45, 2, 3));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void invalid_범위() {
        assertThatThrownBy(() -> {
            new Lotto(Arrays.asList(0, 3, 5, 45, 2, 4));
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            new Lotto(Arrays.asList(1, 3, 5, 46, 2, 4));
        }).isInstanceOf(IllegalArgumentException.class);
    }

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
