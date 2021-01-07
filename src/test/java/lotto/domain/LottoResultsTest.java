package lotto.domain;

import lotto.utils.Result;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultsTest {
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
