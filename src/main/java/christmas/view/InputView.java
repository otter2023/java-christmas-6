package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Menu;
import christmas.util.Parser;

import java.util.Map;

public class InputView {

    public int readDate() {

        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String dateByString = Console.readLine();

        if (!dateByString.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }

        int date = Integer.parseInt(dateByString);

        if (!(date >= 1 && date <= 31)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
        return date;
    }

    public Map<Menu, Integer> readMenu() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        String menuLineUp = Console.readLine();

        if (!menuLineUp.matches("^0-9[ㄱ-ㅎ|가-힣]*$")) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }

        return Parser.splitMenu(menuLineUp);
    }

}
