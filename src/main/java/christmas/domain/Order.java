package christmas.domain;

import java.util.Map;

public class Order {
    public Map<Menu, Integer> menus;
    public int originalValue;
    public Gift gift;
    public int[] discounts;
    public int discountValue;
    public Badge badge;

    public Order(Map<Menu, Integer> menus, int originalValue, Gift gift, int[] discounts, int discountValue, Badge badge) {
        this.menus = menus;
        this.originalValue = originalValue;
        this.gift = gift;
        this.discounts = discounts;
        this.discountValue = discountValue;
        this.badge = badge;
    }
}
