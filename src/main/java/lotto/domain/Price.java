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

    public Price(String priceString) {
        try {
            this.price = Integer.parseInt(priceString.trim());
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
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
