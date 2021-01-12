package lotto.domain;

import lotto.domain.result.LottoResult;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    public static final int LIMIT_NUMBER = 6;
    private final List<Lotto> lottos;

    public Lottos() {
        this(new ArrayList<>());
    }
    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void addManualLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public void addRandomLottos(LottoTicketCount lottoTicketNumber) {
        for (int i = 0; i < lottoTicketNumber.getLottoTicketCount(); ++i) {
            lottos.add(Lotto.of(RandomNo.generateRandomNumbers(LIMIT_NUMBER)));
        }
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
