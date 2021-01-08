package lotto.domain;

import lotto.utils.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lottos {
    public static final int LIMIT_NUMBER = 6;
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos getLottosInstance(int limitNumber) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < limitNumber; ++i) {
            lottos.add(new Lotto(RandomNo.generateRandomNos(LIMIT_NUMBER)));
        }

        return new Lottos(lottos);
    }

    public int size() {
        return lottos.size();
    }

    public LottoResults allCompare(WinningLotto winningLotto) {
        List<Result> results = new ArrayList<>();

        for (Lotto lotto : lottos) {
            results.add(winningLotto.compare(lotto));
        }
        return new LottoResults(results);
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

    @Override
    public String toString() {
        StringBuilder lottosString = new StringBuilder();
        for (Lotto lotto : lottos) {
            lottosString.append(lotto);
            lottosString.append('\n');
        }

        return lottosString.toString();
    }
}
