package lotto.domain;

import lotto.DTO.LottoResults;
import lotto.utils.LottoResult;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultsTest {
    @Test
    void getYield2() {
        LottoResults lottoResults = new LottoResults(Arrays.asList(
                LottoResult.FIFTH,
                LottoResult.SECOND
        ), new Price(14000));

        assertThat(lottoResults.getYield()).isEqualTo((double) 30005000 / 14000);
    }

    @Test
    void getYield() {
        LottoResults lottoResults = new LottoResults(Arrays.asList(
                LottoResult.FIFTH
        ), new Price(14000));

        assertThat(lottoResults.getYield()).isEqualTo((double) 5000 / 14000);
    }

    @Test
    void getReward2() {
        LottoResults lottoResults = new LottoResults(Arrays.asList(
                LottoResult.FIFTH
        ), new Price(0));

        assertThat(lottoResults.getReward()).isEqualTo(5000);
    }

    @Test
    void getReward() {
        LottoResults lottoResults = new LottoResults(Arrays.asList(
                LottoResult.FIFTH,
                LottoResult.FIFTH,
                LottoResult.FOURTH,
                LottoResult.FIRST,
                LottoResult.THIRD,
                LottoResult.SECOND
        ), new Price(0));

        assertThat(lottoResults.getReward()).isEqualTo(2031560000L);
    }

    @Test
    void getResultCount() {
        LottoResults lottoResults = new LottoResults(Arrays.asList(
                LottoResult.FIFTH,
                LottoResult.FIFTH,
                LottoResult.FOURTH,
                LottoResult.FIRST,
                LottoResult.THIRD
        ), new Price(0));

        assertThat(lottoResults.getResultCount(LottoResult.FIFTH)).isEqualTo(2);
        assertThat(lottoResults.getResultCount(LottoResult.FOURTH)).isEqualTo(1);
        assertThat(lottoResults.getResultCount(LottoResult.SECOND)).isEqualTo(0);
        assertThat(lottoResults.getResultCount(LottoResult.FIRST)).isEqualTo(1);
    }

    @Test
    void result() {
        assertThat(LottoResult.mapResult(2, false)).isEqualTo(LottoResult.NOTHING);
        assertThat(LottoResult.mapResult(3, false)).isEqualTo(LottoResult.FIFTH);
        assertThat(LottoResult.mapResult(4, false)).isEqualTo(LottoResult.FOURTH);
        assertThat(LottoResult.mapResult(4, true)).isEqualTo(LottoResult.FOURTH);
        assertThat(LottoResult.mapResult(5, false)).isEqualTo(LottoResult.THIRD);
        assertThat(LottoResult.mapResult(5, true)).isEqualTo(LottoResult.SECOND);
        assertThat(LottoResult.mapResult(6, false)).isEqualTo(LottoResult.FIRST);
        assertThat(LottoResult.mapResult(6, true)).isEqualTo(LottoResult.FIRST);
    }
}
