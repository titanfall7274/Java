package lamda.lambda4;

public class TriMain {

    public static void main(String[] args) {
        TriFunction<Integer, Integer, Integer, Integer> trifunction = (a, b, c) -> a + b + c;
        System.out.println("trifunction.apply(1, 2, 3) = " + trifunction.apply(1, 2, 3));

    }

    @FunctionalInterface
    private interface TriFunction<A, B, C, R> {
        R apply(A a, B b, C c);
    }
}
