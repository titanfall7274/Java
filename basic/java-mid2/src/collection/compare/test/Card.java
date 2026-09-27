package collection.compare.test;

public class Card implements Comparable<Card> {

    private final Emblem emblem;
    private final int number; // 1 ~ 13

    public Card(Emblem emblem, int number) {
        this.emblem = emblem;
        this.number = number;
    }

    public Emblem getEmblem() {
        return emblem;
    }

    public int getNumber() {
        return number;
    }

    // 숫자 오름차순, 숫자가 같으면 문양 순서(♠ ♥ ♦ ♣ = enum 선언 순서)
    @Override
    public int compareTo(Card anotherCard) {
        // 숫자가 같은지 먼저 비교하고, 그다음 마크를 비교하도록 지정
        if (this.number != anotherCard.number) {
            return Integer.compare(this.number, anotherCard.number);
        }
        return this.emblem.compareTo(anotherCard.emblem);
    }

    @Override
    public String toString() {
        return number + "(" + emblem.getIcon() + ")";
    }
}
