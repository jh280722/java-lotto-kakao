package lotto.domain;

import lotto.utils.Result;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultsTest {
    @Test
    void getReward2() {
        LottoResults lottoResults = new LottoResults(Arrays.asList(
                Result.FIFTH
        ));

        assertThat(lottoResults.getReward()).isEqualTo(5000);
    }

    @Test
    void getReward() {
        LottoResults lottoResults = new LottoResults(Arrays.asList(
                Result.FIFTH,
                Result.FIFTH,
                Result.FOURTH,
                Result.FIRST,
                Result.THIRD,
                Result.SECOND
        ));

        assertThat(lottoResults.getReward()).isEqualTo(2031560000L);
    }

    @Test
    void getResultCount() {
        LottoResults lottoResults = new LottoResults(Arrays.asList(
                Result.FIFTH,
                Result.FIFTH,
                Result.FOURTH,
                Result.FIRST,
                Result.THIRD
        ));

        assertThat(lottoResults.getResultCount(Result.FIFTH)).isEqualTo(2);
        assertThat(lottoResults.getResultCount(Result.FOURTH)).isEqualTo(1);
        assertThat(lottoResults.getResultCount(Result.SECOND)).isEqualTo(0);
        assertThat(lottoResults.getResultCount(Result.FIRST)).isEqualTo(1);
    }

    @Test
    void result() {
        assertThat(LottoResults.mapResult(2, false)).isEqualTo(Result.NOTHING);
        assertThat(LottoResults.mapResult(3, false)).isEqualTo(Result.FIFTH);
        assertThat(LottoResults.mapResult(4, false)).isEqualTo(Result.FOURTH);
        assertThat(LottoResults.mapResult(4, true)).isEqualTo(Result.FOURTH);
        assertThat(LottoResults.mapResult(5, false)).isEqualTo(Result.THIRD);
        assertThat(LottoResults.mapResult(5, true)).isEqualTo(Result.SECOND);
        assertThat(LottoResults.mapResult(6, false)).isEqualTo(Result.FIRST);
        assertThat(LottoResults.mapResult(6, true)).isEqualTo(Result.FIRST);
    }
}
