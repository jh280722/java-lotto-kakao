package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNoTest {
    @Test
    void StringEqual() {
        assertThat(new LottoNo(3).toString()).isEqualTo("3");
    }

    @Test
    void invalid_범위() {
        assertThatThrownBy(() -> {
            new LottoNo(0);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            new LottoNo(46);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
