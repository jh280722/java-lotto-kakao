package lotto.domain;

import java.util.Objects;

public class Money {
    private static final int DIV_NO = 1000;
    public static final int MINIMUM_MONEY = 0;
    private final long money;

    private Money(long money) {
        if (isInvalid(money)) {
            throw new IllegalArgumentException("형식이 맞지 않습니다.");
        }
        this.money = money;
    }

    public static Money of(String moneyString) {
        try {
            return Money.of(Integer.parseInt(moneyString.trim()));
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }
    public static Money of(long money) {
        return new Money(money);
    }

    private boolean isInvalid(long money) {
        return money < MINIMUM_MONEY;
    }

    public int countLotto() {
        return (int) (money / DIV_NO);
    }

    public long getMoney() {
        return money;
    }

    public double getYield(Money price) {
        return (double) money / price.getMoney();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
