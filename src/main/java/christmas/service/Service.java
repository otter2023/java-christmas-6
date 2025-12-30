package christmas.service;

import christmas.domain.*;

import java.util.Map;

public class Service {

    public Order makeOrder(int date, Map<Menu, Integer> menus) {
        int totalCount = 0;
        for (int count : menus.values()) {
            totalCount += count;
        }

        if (totalCount > 20) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }

        checkOnlyDrink(menus);

        int originalValue = calculateOriginalValue(menus);
        int[] discounts = calculateDiscountValue(menus, date);
        int discountValue = calculateDiscount(discounts);

        Gift gift = checkPresentChampagne(originalValue);
        Badge badge = giveEventBadge(discountValue, gift);
        boolean isEvent = checkEventCase(originalValue);

        if (!isEvent) {
            return new Order(menus, originalValue, Gift.NONE, new int[]{0, 0, 0, 0}, 0, Badge.NONE);
        }

        return new Order(menus, originalValue, gift, discounts, discountValue, badge);
    }

    public void checkOnlyDrink(Map<Menu, Integer> menus) {
        boolean isOnlyDrink = true;
        for (Menu menu : menus.keySet()) {
            if (menu.category != Category.DRINK) {
                isOnlyDrink = false;
            }
        }

        if (isOnlyDrink) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public boolean checkEventCase(int originalValue) {
        return originalValue >= 10000;
    }

    public Gift checkPresentChampagne(int value) {
        if (value >= 120000) {
            return Gift.CHAMPAGNE;
        }
        return Gift.NONE;
    }

    public Badge giveEventBadge(int value, Gift gift) {
        if (gift == Gift.CHAMPAGNE) {
            value += 25000;
        }
        if (value >= 20000) {
            return Badge.SANTA;
        }
        if (value >= 10000) {
            return Badge.TREE;
        }
        if (value >= 5000) {
            return Badge.STAR;
        }
        return Badge.NONE;
    }

    public int calculateOriginalValue(Map<Menu, Integer> menus) {
        int value = 0;
        for (Map.Entry<Menu, Integer> menu : menus.entrySet()) {
            int count = menu.getValue();
            value += (count * menu.getKey().value);
        }

        return value;
    }

    public int[] calculateDiscountValue(Map<Menu, Integer> menus, int date) {
        int value = 0;
        int[] discounts = {0, 0, 0, 0};

        for (Map.Entry<Menu, Integer> menu : menus.entrySet()) {
            int count = menu.getValue();

            if (checkWeekday(date)) {
                discounts[1] = discountWeekday(menu.getKey(), count);
            }
            if (checkHoliday(date)) {
                discounts[2] = discountHoliday(menu.getKey(), count);
            }
            if (checkStar(date)) {
                discounts[3] = discountStar(value);
            }
            if (checkDDay(date)) {
                discounts[0] = discountDDay(value, date);
            }
        }

        return discounts;
    }


    public int calculateDiscount(int[] discounts) {
        int value = 0;
        for (int discount : discounts) {
            value += discount;
        }
        return value;
    }

    public boolean checkWeekday(int date) {
        return !(date % 7 == 1 || date % 7 == 2);
    }

    public boolean checkHoliday(int date) {
        return date % 7 == 1 || date % 7 == 2;
    }

    public boolean checkStar(int date) {
        return date % 7 == 3 || date == 25;
    }

    public boolean checkDDay(int date) {
        return date <= 25;
    }


    public int discountWeekday(Menu menu, int count) {
        if (menu.category == Category.DESSERT) {
            return 2023 * count;
        }

        return 0;
    }

    public int discountHoliday(Menu menu, int count) {
        if (menu.category == Category.MAIN) {
            return 2023 * count;
        }

        return 0;
    }

    public int discountStar(int value) {
        return 1000;
    }

    public int discountDDay(int value, int date) {
        return 900 + (date * 100);
    }

}
