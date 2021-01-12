package lotto.utils;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {
    public static int parseInt(String text) {
        try {
            return Integer.parseInt(text.trim());
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }
    public static List<Integer> convertToIntegerList(String[] strings) {
        List<Integer> IntegerList = new ArrayList<>();
        for (String string : strings) {
            IntegerList.add(StringUtils.parseInt(string));
        }
        return IntegerList;
    }
}
