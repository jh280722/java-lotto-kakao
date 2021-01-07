package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lottos {
    public static final int NUMBER = 6;
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos getInstance(int number) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < number; ++i) {
            lottos.add(new Lotto(RandomNo.generateRandomNos(NUMBER)));
        }

        return new Lottos(lottos);
    }

    public int size() {
        return lottos.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
