package collection.compare.test;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final String name;
    private final List<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>(); // 손패는 플레이어가 직접 만든다
    }

    public String getName() {
        return name;
    }

    // 덱에서 한 장 뽑아 손패에 넣고, 뽑은 카드를 돌려준다
    public Card drawCard(Deck deck) {
        Card card = deck.drawCard();
        hand.add(card);
        return card;
    }

    // 카드 숫자의 합계가 큰 사람이 승리한다.
    public int totalNumber() {
        int total = 0;
        for (Card card : hand) {
            total += card.getNumber();
        }
        return total;
    }

    public void showHand() {
        hand.sort(null); // Card의 compareTo 기준으로 정렬
        System.out.println(name + "의 카드: " + hand + ", 합계: " + totalNumber());
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hand=" + hand +
                '}';
    }
}
