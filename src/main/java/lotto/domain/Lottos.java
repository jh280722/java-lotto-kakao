package lotto.domain;

import lotto.domain.result.LottoResult;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos() {
        this(new ArrayList<>());
    }
    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
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
