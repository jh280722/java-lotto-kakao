package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RandomNoTest {
    @Test
    void invalid() {
        assertThatThrownBy(() -> {
            new RandomNo(0);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            new RandomNo(46);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void create() {
        assertThat(new RandomNo(5)).isEqualTo(new RandomNo(5));
    }
}
