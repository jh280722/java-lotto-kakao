package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoSimulationTest {
    @Test
    void create() {
        LottoSimulation lottoSimulation = new LottoSimulation(14000, "1, 2, 3, 4, 5, 6", 37);
    }
}
