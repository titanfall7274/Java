package lamda.lambda3;

public class GenericMain6 {

    public static void main(String[] args) {
        GenericFunction<String, String> upperCase = s -> s.toUpperCase();
        GenericFunction<String, Integer> stringLength = s -> s.length();
        GenericFunction<Integer, Integer> square = x -> x * x;
        GenericFunction<Integer, Boolean> isEven = x -> x % 2 == 0;

        System.out.println("upperCase.apply(\"hello\") = " + upperCase.apply("hello"));
        System.out.println("stringLength.apply(\"hello\") = " + stringLength.apply("hello"));
        System.out.println("square.apply(3) = " + square.apply(3));
        System.out.println("isEven.apply(3) = " + isEven.apply(3));
    }

    @FunctionalInterface
    interface GenericFunction<T, R> {
        R apply(T s);
    }
}
