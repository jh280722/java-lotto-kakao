package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PriceTest {
    @Test
    void count() {
        assertThat(new Price(1000).count()).isEqualTo(1);
        assertThat(new Price(999).count()).isEqualTo(0);
    }

    @Test
    void negative() {
        assertThatThrownBy(() -> {
            new Price(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
