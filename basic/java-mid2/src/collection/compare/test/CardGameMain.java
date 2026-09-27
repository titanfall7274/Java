package collection.compare.test;

public class CardGameMain {
    public static void main(String[] args) throws InterruptedException {

        Deck deck = new Deck();

        Player player1 = enter("player1");
        Player player2 = enter("player2");

        loading();

        play(deck, player1, player2);

        player1.showHand();
        player2.showHand();

        Player winner = getWinner(player1, player2);
        printResult(winner);

    }

    private static void printResult(Player winner) {
        if (winner != null) {
            System.out.println(winner.getName() + " 승리");
        } else {
            System.out.println("무승부");
        }
    }

    private static void play(Deck deck, Player player1, Player player2) {
        System.out.println("게임이 시작되었습니다. 각 플레이어는 번갈아가며 카드를 뽑아주시기 바랍니다.");
        for (int i = 0; i < 5; i++) {
            draw(deck, player1);
            draw(deck, player2);
        }
    }

    // 합계가 같으면 null(무승부)
    private static Player getWinner(Player player1, Player player2) {
        int total1 = player1.totalNumber();
        int total2 = player2.totalNumber();

        if (total1 > total2) {
            return player1;
        } else if (total1 == total2) {
            return null;
        } else {
            return player2;
        }
    }

    private static void draw(Deck deck, Player player) {
        Card card = player.drawCard(deck);
        System.out.println("[" + player.getName() + "]: " + card);
    }

    private static void loading() throws InterruptedException {
        System.out.println("3초 후 게임이 시작됩니다.");
        for (int i = 3; i > 0; i--) {
            Thread.sleep(1000);
            System.out.println(i);
        }
    }

    private static Player enter(String name) {
        Player player = new Player(name);
        System.out.println("[" + player.getName() + "] 님이 입장했습니다.");
        return player;
    }
}
