package lotto.domain;

import lotto.utils.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringUtilsTest {
    @Test
    void convertToIntegerList() {
        assertThat(StringUtils.convertToIntegerList("1,2,3,4,5,6".split(",")))
                .isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    void parseIntException() {
        assertThat(StringUtils.parseInt("23")).isEqualTo(23);

        assertThatThrownBy(() -> {
            StringUtils.parseInt("2f");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
