package christmas.domain;

public enum Gift {
    CHAMPAGNE("샴페인"),
    NONE("없음");

    public final String koreanName;

    Gift(String koreanName) {
        this.koreanName = koreanName;
    }
}
