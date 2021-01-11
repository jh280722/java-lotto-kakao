package lotto.domain;

import lotto.domain.result.LottoResult;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
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
