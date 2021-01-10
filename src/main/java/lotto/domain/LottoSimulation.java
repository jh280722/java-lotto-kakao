package lotto.domain;

import lotto.DTO.LottoResults;
import lotto.utils.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
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
        Arrays.stream(lottoNumbers)
                .map(lottoNumber -> new LottoNumber(lottoNumber))
                .forEach(lotto::add);

        return new WinningLotto(new Lotto(lotto), new LottoNumber(bonusBall));
    }

    public LottoResults confirmLottos() {
        return new LottoResults(lottos.allConfirm(winningLotto), price);
    }
}
