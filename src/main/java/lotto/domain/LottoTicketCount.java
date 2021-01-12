package lotto.domain;

public class LottoTicketCount {
    private final int lottoTicketCount;

    private LottoTicketCount(int lottoTicketCount) {
        this.lottoTicketCount = lottoTicketCount;
    }

    public static LottoTicketCount of(String lottoTicketCount) {
        try {
            return LottoTicketCount.of(Integer.parseInt(lottoTicketCount.trim()));
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }

    public static LottoTicketCount of(int lottoTicketCount) {
        return new LottoTicketCount(lottoTicketCount);
    }

    public LottoTicketCount useLottoTicket(LottoTicketCount useLottoTicketCount) {
        checkUsePossible(useLottoTicketCount);
        return LottoTicketCount.of(lottoTicketCount - useLottoTicketCount.getLottoTicketCount());
    }

    private void checkUsePossible(LottoTicketCount useLottoTicketCount) {
        if (lottoTicketCount < useLottoTicketCount.lottoTicketCount) {
            throw new IllegalArgumentException("사용하려는 로또 티켓이 가진 로또 티켓보다 많습니다.");
        }
    }

    public int getLottoTicketCount() {
        return lottoTicketCount;
    }
}
