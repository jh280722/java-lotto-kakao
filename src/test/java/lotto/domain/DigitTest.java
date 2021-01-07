package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DigitTest {
    @Test
    void StringEqual() {
        assertThat(new Digit(3).toString()).isEqualTo("3");
    }

    @Test
    void invalid_범위() {
        assertThatThrownBy(() -> {
            new Digit(0);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            new Digit(46);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
