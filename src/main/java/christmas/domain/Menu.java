package christmas.domain;

public enum Menu {
    SOUP("양송이수프", Category.APPETIZER, 6000),
    TAPAS("타파스", Category.APPETIZER, 5500),
    SALAD("시저샐러드", Category.APPETIZER, 8000),
    STEAK("티본스테이크", Category.MAIN, 55000),
    BBQ("바비큐립", Category.MAIN, 54000),
    SEAFOOD_PASTA("해산물파스타", Category.MAIN, 35000),
    CHRISTMAS_PASTA("크리스마스파스타", Category.MAIN, 25000),
    CAKE("초코케이크", Category.DESSERT, 15000),
    ICE_CREAM("아이스크림", Category.DESSERT, 5000),
    COKE("제로콜라", Category.DRINK, 3000),
    WINE("레드와인", Category.DRINK, 60000),
    CHAMPAGNE("샴페인", Category.DRINK, 25000);

    public final String koreanName;
    public final Category category;
    public final int value;

    Menu(String koreanName, Category category, int value) {
        this.koreanName = koreanName;
        this.category = category;
        this.value = value;
    }

    public static Menu from(String inputName) {
        for (Menu menu : Menu.values()){
            if (menu.koreanName.equals((inputName))){
                return menu;
            }
        }

        throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }
}
