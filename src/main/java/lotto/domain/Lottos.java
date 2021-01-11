package lotto.domain;

import lotto.domain.result.LottoResult;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    public static final int LIMIT_NUMBER = 6;
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos createRandomLottos(int limitNumber) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < limitNumber; ++i) {
            lottos.add(new Lotto(RandomNo.generateRandomNumbers(LIMIT_NUMBER)));
        }

        return new Lottos(lottos);
    }

    public int size() {
        return lottos.size();
    }

    public List<LottoResult> match(WinningLotto winningLotto) {
        List<LottoResult> lottoResults = new ArrayList<>();
        for (Lotto lotto : lottos) {
            lottoResults.add(winningLotto.match(lotto));
        }
        return lottoResults;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
