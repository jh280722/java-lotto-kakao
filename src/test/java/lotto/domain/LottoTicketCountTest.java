package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketCountTest {
    @Test
    void stringException() {
        assertThatThrownBy(() -> LottoTicketCount.of("5w"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void negativeException() {
        assertThatThrownBy(() -> LottoTicketCount.of(5).useLottoTicket(LottoTicketCount.of(6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void useLottoTicket() {
        assertThat(LottoTicketCount.of(5).useLottoTicket(LottoTicketCount.of(5)).getLottoTicketCount())
                .isEqualTo(LottoTicketCount.of(0).getLottoTicketCount());
    }
}
