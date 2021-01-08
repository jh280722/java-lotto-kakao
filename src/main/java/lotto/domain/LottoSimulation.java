package lotto.domain;

import lotto.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LottoSimulation {
    private final Price price;
    private final WinningLotto winningLotto;
    private final Lottos lottos;
    private LottoResults lottoResults;

    public LottoSimulation(Price price, String text, String bonusBall) {
        this.price = price;
        this.winningLotto = initWinningLotto(StringUtils.splitDigit(text), bonusBall);
        this.lottos = Lottos.getLottosInstance(this.price.count());
    }

    public LottoSimulation(int price, LottoResults lottoResults) {
        this.price = new Price(price);
        this.lottoResults = lottoResults;
        this.lottos = null;
        this.winningLotto = null;
    }

    private WinningLotto initWinningLotto(String[] lottoNumbers, String bonusBall) {
        List<LottoNumber> lotto = new ArrayList<>();

        for (String lottoNumber : lottoNumbers) {
            lotto.add(new LottoNumber(lottoNumber));
        }

        return new WinningLotto(new Lotto(lotto), new LottoNumber(bonusBall));
    }

    public void confirm() {
        lottoResults = lottos.allCompare(winningLotto);
    }

    public double getYield() {
        return (double) lottoResults.getReward() / price.getPrice();
    }

    public LottoResults getLottoResults() {
        return lottoResults;
    }
}
