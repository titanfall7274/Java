package lamda.lambda4;

import java.util.function.*;

public class PrimitiveFunction {

    public static void main(String[] args) {
        // 기본형 매개변수,
        // 1. IntFunction<R> R apply(int value);
        IntFunction<String> function = x -> "숫자: " + x;
        System.out.println("function.apply(3) = " + function.apply(3));

        // 2. LongFunction<R> R apply(long value);
        LongFunction<String> longFunction = x -> "숫자: " + x;
        System.out.println("longFunction.apply(2.3) = " + longFunction.apply((long) 2.3));

        // 3. DoubleFunction<R> R apply(double value);
        DoubleFunction<String> doubleFunction = x -> "숫자: " + x;
        System.out.println("doubleFunction.apply(3.2) = " + doubleFunction.apply(3.2));


        // 기본형 반환,
        // 1. ToIntFunction<T> int applyAsInt(T value);
        // ToLongFunction, ToDoubleFunction
        ToIntFunction<String> toIntFunction = s -> s.length();
        System.out.println("toIntFunction.applyAsInt(\"hello\") = " + toIntFunction.applyAsInt("hello"));

        // 기본형 매개변수, 기본형 반환
        IntToLongFunction intToLongFunction = x -> x * 100L;
        System.out.println("intToLongFunction.applyAsLong(3) = " + intToLongFunction.applyAsLong(3));

        // IntUnaryOperator: int -> int
        IntUnaryOperator intUnaryOperator = x -> x * 100;
        System.out.println("intUnaryOperator.applyAsInt(10) = " + intUnaryOperator.applyAsInt(10));

        // intConsumer, IntSupplier, IntPredicate
    }
}
