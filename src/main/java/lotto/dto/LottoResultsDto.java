package lotto.dto;

import lotto.domain.result.LottoResult;
import lotto.domain.result.LottoResults;

import java.util.Map;
import java.util.TreeMap;

public class LottoResultsDto {
    private final Map<LottoResult, Long> LOTTO_RESULTS;
    private final double yieid;

    private LottoResultsDto(Map<LottoResult, Long> lotto_results, double yield) {
        this.LOTTO_RESULTS = lotto_results;
        this.yieid = yield;
    }

    public static LottoResultsDto from(LottoResults lottoResults) {
        Map<LottoResult, Long> sortedLottoResults = new TreeMap<>(lottoResults.getLOTTO_RESULTS())
                .descendingMap();
        return new LottoResultsDto(sortedLottoResults, lottoResults.getYield());
    }

    public Map<LottoResult, Long> getLOTTO_RESULTS() {
        return LOTTO_RESULTS;
    }

    public double getYieid() {
        return yieid;
    }
}
