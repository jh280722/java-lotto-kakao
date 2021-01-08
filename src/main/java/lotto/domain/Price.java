package lotto.domain;

public class Price {
    private static final int ZERO = 0;
    private static final int DIV_NO = 1000;
    private final long price;

    public Price(int price) {
        if (isNegative(price)) {
            throw new IllegalArgumentException("가격은 음수가 될 수 없습니다.");
        }
        this.price = price;
    }

    private boolean isNegative(int price) {
        return price < ZERO;
    }

    public int count() {
        return (int) (price / DIV_NO);
    }

    public long getPrice() {
        return price;
    }
}
