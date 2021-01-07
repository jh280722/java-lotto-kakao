package lotto.domain;

import lotto.utils.Result;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultsTest {
    @Test
    void getReward2() {
        LottoResults lottoResults = new LottoResults(Arrays.asList(
                Result.THREE
        ));

        assertThat(lottoResults.getReward()).isEqualTo(5000);
    }

    @Test
    void getReward() {
        LottoResults lottoResults = new LottoResults(Arrays.asList(
                Result.THREE,
                Result.THREE,
                Result.FOUR,
                Result.SIX,
                Result.FIVE,
                Result.BONUSFIVE
        ));

        assertThat(lottoResults.getReward()).isEqualTo(2031560000L);
    }

    @Test
    void getResultCount() {
        LottoResults lottoResults = new LottoResults(Arrays.asList(
                Result.THREE,
                Result.THREE,
                Result.FOUR,
                Result.SIX,
                Result.FIVE
        ));

        assertThat(lottoResults.getResultCount(Result.THREE)).isEqualTo(2);
        assertThat(lottoResults.getResultCount(Result.FOUR)).isEqualTo(1);
        assertThat(lottoResults.getResultCount(Result.BONUSFIVE)).isEqualTo(0);
        assertThat(lottoResults.getResultCount(Result.SIX)).isEqualTo(1);
    }

    @Test
    void result() {
        assertThat(LottoResults.mapResult(2, false)).isEqualTo(Result.UNDERTHREE);
        assertThat(LottoResults.mapResult(3, false)).isEqualTo(Result.THREE);
        assertThat(LottoResults.mapResult(4, false)).isEqualTo(Result.FOUR);
        assertThat(LottoResults.mapResult(4, true)).isEqualTo(Result.FOUR);
        assertThat(LottoResults.mapResult(5, false)).isEqualTo(Result.FIVE);
        assertThat(LottoResults.mapResult(5, true)).isEqualTo(Result.BONUSFIVE);
        assertThat(LottoResults.mapResult(6, false)).isEqualTo(Result.SIX);
        assertThat(LottoResults.mapResult(6, true)).isEqualTo(Result.SIX);
    }
}
