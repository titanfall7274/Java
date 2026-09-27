package collection.compare.test;

public enum Emblem {
    SPADE("\u2660"),   // ♠
    HEART("\u2665"),   // ♥
    DIAMOND("\u2666"), // ♦
    CLOVER("\u2663");  // ♣

    private final String icon;

    Emblem(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }
}
