package lamda.start;

import java.util.Random;

public class Ex1Main {
    public static void helloDice() {
        long statNs = System.nanoTime();

        int randomValue = new Random().nextInt(6) + 1;
        System.out.println("주사위 = " + randomValue);

        long endNs = System.nanoTime();
        System.out.println("실행 시간: " + (endNs - statNs) + "ns");
    }

    public static void helloSum() {
        long statNs = System.nanoTime();

        for (int i = 1; i <= 3; i++) {
            System.out.println("i = " + i);
        }

        long endNs = System.nanoTime();
        System.out.println("실행 시간: " + (endNs - statNs) + "ns");
    }

    public static void helloDiceAndSum(int bound, int index) {
        long statNs = System.nanoTime();

        int randomValue = new Random().nextInt(bound) + 1;
        System.out.println("주사위 = " + randomValue);

        for (int i = 1; i <= index; i++) {
            System.out.println("i = " + i);
        }

        long endNs = System.nanoTime();
        System.out.println("실행 시간: " + (endNs - statNs) + "ns");

    }
    public static void main(String[] args) {
//        helloDice();
//        helloSum();

        helloDiceAndSum(6, 3);
    }
}
