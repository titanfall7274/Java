package lamda.lambda4;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class OperatorMain {

    public static void main(String[] args) {
        // UnaryOperator
        Function<Integer, Integer> square1 = x -> x * x;
        UnaryOperator<Integer> square2 = x -> x * x;

        System.out.println("square1.apply(2) = " + square1.apply(2));
        System.out.println("square2.apply(3) = " + square2.apply(3));

        // BinaryOperator
        BiFunction<Integer, Integer, Integer> additional1 = (a, b) -> a + b;
        BinaryOperator<Integer> additional2 = (a, b) -> a + b;

        System.out.println("additional1.apply(1, 2) = " + additional1.apply(1, 2));
        System.out.println("additional2.apply(3, 4) = " + additional2.apply(3, 4));
    }
}
