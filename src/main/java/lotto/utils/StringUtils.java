package lotto.utils;

public class StringUtils {
    public static String[] splitDigit(String text) {
        return text.split(",");
    }
    public static int parseInt(String text) {
        try {
            return Integer.parseInt(text.trim());
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }
}
