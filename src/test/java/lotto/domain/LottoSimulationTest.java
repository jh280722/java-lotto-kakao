package lotto.domain;

import lotto.utils.Result;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoSimulationTest {
    @Test
    void getYield2() {
        LottoResults lottoResults = new LottoResults(Arrays.asList(
                Result.THREE,
                Result.BONUSFIVE
        ));
        LottoSimulation lottoSimulation = new LottoSimulation(14000,lottoResults);

        assertThat(lottoSimulation.getYield()).isEqualTo(20);
    }

    @Test
    void getYield() {
        LottoResults lottoResults = new LottoResults(Arrays.asList(
                Result.THREE
        ));
        LottoSimulation lottoSimulation = new LottoSimulation(14000,lottoResults);

        assertThat(lottoSimulation.getYield()).isEqualTo(0.35);
    }
}
