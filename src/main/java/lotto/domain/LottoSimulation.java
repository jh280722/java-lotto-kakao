package lotto.domain;

import lotto.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LottoSimulation {
    private final Price price;
    private final WinningLotto winningLotto;
    private final Lottos lottos;
    private LottoResults lottoResults;
    
    public LottoSimulation(int price, String text, int bonusBall) {
        this.price = new Price(price);
        this.winningLotto = initWinningLotto(StringUtils.splitDigit(text), bonusBall);
        this.lottos = Lottos.getInstance(this.price.count());
    }

    private WinningLotto initWinningLotto(String[] digits, int bonusBall) {
        List<Integer> lotto = new ArrayList<>();

        for (String digit : digits) {
            lotto.add(Integer.parseInt(digit.trim()));
        }

        return new WinningLotto(new Lotto(lotto), new Digit(bonusBall));
    }

    public void confirm() {
        lottoResults = lottos.allCompare(winningLotto);
    }
}
