package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DigitTest {
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
