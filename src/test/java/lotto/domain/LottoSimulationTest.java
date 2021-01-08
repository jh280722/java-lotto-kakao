package lotto.domain;

import lotto.utils.Result;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoSimulationTest {
    @Test
    void getYield2() {
        LottoResults lottoResults = new LottoResults(Arrays.asList(
                Result.FIFTH,
                Result.SECOND
        ));
        LottoSimulation lottoSimulation = new LottoSimulation(14000,lottoResults);

        assertThat(lottoSimulation.getYield()).isEqualTo((double) 30005000 / 14000);
    }

    @Test
    void getYield() {
        LottoResults lottoResults = new LottoResults(Arrays.asList(
                Result.FIFTH
        ));
        LottoSimulation lottoSimulation = new LottoSimulation(14000,lottoResults);

        assertThat(lottoSimulation.getYield()).isEqualTo((double) 5000 / 14000);
    }
}
