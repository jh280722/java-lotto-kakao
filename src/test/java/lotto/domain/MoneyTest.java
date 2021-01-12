package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {
    @Test
    void getYield() {
        assertThat(Money.of(15000).getYield(Money.of(5000))).isEqualTo(3.0);
    }

    @Test
    void countLottoTicket() {
        assertThat(Money.of(1000).countLottoTicket()).isEqualTo(1);
        assertThat(Money.of(999).countLottoTicket()).isEqualTo(0);
    }

    @Test
    void negative() {
        assertThatThrownBy(() -> {
            Money.of(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
