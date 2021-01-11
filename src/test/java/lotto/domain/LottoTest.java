package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    @Test
    void StringEqual() {
        assertThat(Lotto.of(Arrays.asList(6, 2, 3, 4, 5, 1)).toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    void duplicate() {
        assertThatThrownBy(() -> {
            Lotto.of(Arrays.asList(1, 1, 3, 4, 5, 6));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void invalidLottoSize() {
        assertThatThrownBy(() -> {
            Lotto.of(Arrays.asList(1, 5, 45, 2, 3, 7, 9));
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            Lotto.of(Arrays.asList(1, 5, 45, 2, 3));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void invalidRange() {
        assertThatThrownBy(() -> {
            Lotto.of(Arrays.asList(0, 2, 3, 4, 5, 6));
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            Lotto.of(Arrays.asList(1, 3, 5, 46, 2, 4));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
