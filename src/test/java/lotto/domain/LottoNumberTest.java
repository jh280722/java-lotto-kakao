package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @Test
    void cacheNumber() {
        assertThat(LottoNumber.of(3) == LottoNumber.of(3)).isTrue();
    }

    @Test
    void StringEqual() {
        assertThat(LottoNumber.of(3).toString()).isEqualTo("3");
    }

    @Test
    void invalidRange() {
        assertThatThrownBy(() -> {
            LottoNumber.of(0);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            LottoNumber.of(46);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
