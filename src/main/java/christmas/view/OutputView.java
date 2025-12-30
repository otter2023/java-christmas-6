package christmas.view;

import christmas.domain.Badge;
import christmas.domain.Gift;
import christmas.domain.Menu;
import christmas.domain.Order;

import java.util.Map;

public class OutputView {
    public void init(){
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printOrder(Order order, int date) {
        System.out.println("12월 " + date + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println();

        printMenu(order.menus);
        printOriginalValue(order.originalValue);

        printGift(order.gift);
        printDiscounts(order.discounts, order.gift);

        printDiscountValue(order.originalValue - order.discountValue);

        printBadge(order.badge);
    }

    private void printGift(Gift gift) {
        System.out.println("<증정 메뉴>");
        System.out.print(gift.koreanName);
        if (gift == Gift.CHAMPAGNE) {
            System.out.print(" 1개");
        }
        System.out.println();
        System.out.println();
    }

    private void printBadge(Badge badge) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(badge.koreanName);
    }

    private void printDiscountValue(int value) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.printf("%,d원\n", value);
        System.out.println();
    }

    public void printDiscounts(int[] discounts, Gift gift) {
        System.out.println("<혜택 내역>");
        if (discounts[0] == 0 && discounts[1] == 0 && discounts[2] == 0 && discounts[3] == 0) {
            System.out.println("없음");
        }
        if (discounts[0] != 0) {
            System.out.printf("크리스마스 디데이 할인: -%,d원\n", discounts[0]);
        }
        if (discounts[1] != 0) {
            System.out.printf("평일 할인: -%,d원\n", discounts[1]);
        }
        if (discounts[2] != 0) {
            System.out.printf("주말 할인: -%,d원\n", discounts[2]);
        }
        if (discounts[3] != 0) {
            System.out.printf("특별 할인: -%,d원\n", discounts[3]);
        }
        if (gift == Gift.CHAMPAGNE) {
            System.out.println("증정 이벤트: -25,000원");
        }
        System.out.println();

        int value = 0;
        for (int discount : discounts) {
            value += discount;
        }
        if (gift == Gift.CHAMPAGNE) {
            value += 25000;
        }

        System.out.println("<총혜택 금액>");
        System.out.printf("%,d원\n", value);
        System.out.println();

    }

    public void printMenu(Map<Menu, Integer> menus) {
        System.out.println("<주문 메뉴>");
        for (Map.Entry<Menu, Integer> menu : menus.entrySet()) {
            System.out.println(menu.getKey().koreanName + " " + menu.getValue() + "개");
        }
        System.out.println();
    }

    public void printOriginalValue(int value) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.printf("%,d원\n", value);
        System.out.println();
    }


}
