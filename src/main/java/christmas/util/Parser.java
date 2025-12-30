package christmas.util;

import christmas.domain.Menu;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Parser {
    public static Map<Menu, Integer> splitMenu(String menuLineUp) {

        String[] splitMenuLineUP = menuLineUp.split(Pattern.quote(","));
        Map<Menu, Integer> menus = new HashMap<>();

        for (String menuAndCount : splitMenuLineUP) {
            String[] split = menuAndCount.split(Pattern.quote("-"));

            if (!split[1].matches("^[0-9]+$")){
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }

            Menu menu = Menu.from(split[0]);
            int count = Integer.parseInt(split[1]);

            if (menus.containsKey(menu)) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }

            if (!(count >= 1)) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }

            menus.put(menu, count);
        }

        return menus;
    }
}
