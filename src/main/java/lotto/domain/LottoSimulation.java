package lotto.domain;

import lotto.DTO.LottoResults;
import lotto.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LottoSimulation {
    private final Price price;
    private final WinningLotto winningLotto;
    private final Lottos lottos;

    public LottoSimulation(Price price, String text, String bonusBall) {
        this.price = price;
        this.winningLotto = initWinningLotto(StringUtils.splitDigit(text), bonusBall);
        this.lottos = Lottos.getLottosInstance(this.price.count());
    }

    private WinningLotto initWinningLotto(String[] lottoNumbers, String bonusBall) {
        List<LottoNumber> lotto = new ArrayList<>();

        for (String lottoNumber : lottoNumbers) {
            lotto.add(new LottoNumber(lottoNumber));
        }

        return new WinningLotto(new Lotto(lotto), new LottoNumber(bonusBall));
    }

    public LottoResults confirm() {
        return new LottoResults(lottos.allCompare(winningLotto), price);
    }
}
