package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusBallTest {
    @Test
    void invalid_범위() {
        assertThatThrownBy(() -> {
            new BonusBall(46);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void create() {
        BonusBall bonusBall = new BonusBall(36);
        assertThat(bonusBall).isEqualTo(new BonusBall(36));
    }
}
