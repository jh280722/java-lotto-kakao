package lotto.domain;

import lotto.domain.result.LottoResult;
import lotto.domain.result.LottoResults;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultsTest {
    @Test
    void calculateReward2() {
        LottoResults lottoResults = LottoResults.of(Arrays.asList(
                LottoResult.NOTHING
        ), Money.of(14000));

        assertThat(lottoResults.getReward()).isEqualTo(Money.of(0));
    }

    @Test
    void calculateReward() {
        LottoResults lottoResults = LottoResults.of(Arrays.asList(
                LottoResult.FIFTH,
                LottoResult.SECOND
        ), Money.of(14000));

        assertThat(lottoResults.getReward()).isEqualTo(Money.of(30005000));
    }

    @Test
    void getYield2() {
        LottoResults lottoResults = LottoResults.of(Arrays.asList(
                LottoResult.FIFTH,
                LottoResult.SECOND
        ), Money.of(14000));

        assertThat(lottoResults.getYield()).isEqualTo((double) 30005000 / 14000);
    }

    @Test
    void getYield() {
        LottoResults lottoResults = LottoResults.of(Arrays.asList(
                LottoResult.FIFTH
        ), Money.of(14000));

        assertThat(lottoResults.getYield()).isEqualTo((double) 5000 / 14000);
    }

    @Test
    void getReward2() {
        LottoResults lottoResults = LottoResults.of(Arrays.asList(
                LottoResult.FIFTH
        ), Money.of(0));

        assertThat(lottoResults.getReward()).isEqualTo(Money.of(5000));
    }

    @Test
    void getReward() {
        LottoResults lottoResults = LottoResults.of(Arrays.asList(
                LottoResult.FIFTH,
                LottoResult.FIFTH,
                LottoResult.FOURTH,
                LottoResult.FIRST,
                LottoResult.THIRD,
                LottoResult.SECOND
        ), Money.of(0));

        assertThat(lottoResults.getReward()).isEqualTo(Money.of(2031560000L));
    }

    @Test
    void mapResult() {
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
