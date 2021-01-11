package lotto.domain;

import lotto.domain.result.LottoResult;
import lotto.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LottoSimulation {
    private final WinningLotto winningLotto;

    public LottoSimulation(String winningLottoText, String bonusBall) {
        this.winningLotto = initWinningLotto(StringUtils.splitDigit(winningLottoText), bonusBall);
    }

    private WinningLotto initWinningLotto(String[] lottoNumbers, String bonusBall) {
        List<Integer> lotto = new ArrayList<>();
        for (String lottoNumber : lottoNumbers) {
            lotto.add(StringUtils.parseInt(lottoNumber));
        }
        return WinningLotto.of(lotto, bonusBall);
    }

    public List<LottoResult> match(Lottos lottos) {
        return lottos.match(winningLotto);
    }
}
