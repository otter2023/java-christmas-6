package christmas.domain;

public enum Badge {
    STAR("스타"),
    TREE("트리"),
    SANTA("산타"),
    NONE("없음");

    public final String koreanName;

    Badge(String koreanName) {
        this.koreanName = koreanName;
    }
}
