package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    @Test
    void StringEqual() {
        assertThat(
                new Lotto(Arrays.asList(
                        new LottoNumber(1),
                        new LottoNumber(6),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5)
                )).toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    void duplicate() {
        assertThatThrownBy(() -> {
            new Lotto(Arrays.asList(
                    new LottoNumber(1),
                    new LottoNumber(1),
                    new LottoNumber(2),
                    new LottoNumber(3),
                    new LottoNumber(4),
                    new LottoNumber(5)));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void invalid_번호개수() {
        assertThatThrownBy(() -> {
            new Lotto(Arrays.asList(
                    new LottoNumber(1),
                    new LottoNumber(5),
                    new LottoNumber(45),
                    new LottoNumber(2),
                    new LottoNumber(3),
                    new LottoNumber(7),
                    new LottoNumber(9)));
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            new Lotto(Arrays.asList(
                    new LottoNumber(1),
                    new LottoNumber(5),
                    new LottoNumber(45),
                    new LottoNumber(2),
                    new LottoNumber(3)));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void invalid_범위() {
        assertThatThrownBy(() -> {
            new Lotto(Arrays.asList(
                    new LottoNumber(0),
                    new LottoNumber(3),
                    new LottoNumber(5),
                    new LottoNumber(45),
                    new LottoNumber(2),
                    new LottoNumber(4)));
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            new Lotto(Arrays.asList(
                    new LottoNumber(1),
                    new LottoNumber(3),
                    new LottoNumber(5),
                    new LottoNumber(46),
                    new LottoNumber(2),
                    new LottoNumber(4)));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void sort() {
        Lotto lotto = new Lotto(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(4),
                new LottoNumber(3),
                new LottoNumber(5),
                new LottoNumber(6)));

        assertThat(lotto).isEqualTo(new Lotto(Arrays.asList(
                new LottoNumber(2),
                new LottoNumber(1),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6))));
    }

    @Test
    void create() {
        Lotto lotto = new Lotto(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)));
        assertThat(lotto).isEqualTo(new Lotto(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6))));
    }
}
