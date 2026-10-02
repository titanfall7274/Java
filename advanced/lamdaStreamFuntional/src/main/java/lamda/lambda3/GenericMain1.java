package lamda.lambda3;

public class GenericMain1 {
    public static void main(String[] args) {
        StringFunction upperCase = s -> s.toUpperCase();
        String result1 = upperCase.apply("hello");
        System.out.println("result1 = " + result1);

        IntegerFunction square = n -> n * n;
        int result2 = square.apply(2);
        System.out.println("result2 = " + result2);

        // 이렇게 둘다 하나의 인자를 입력받고, 결과를 반환하게 된다.
        // 다만 입력받는 타입과 반환 타입이 다를뿐인데 이때마다 계속 함수형 인터페이스를 만들어야 하는가?
        // Object 클래스로 입력을 받으면 매개변수 입력은 해결이 된다.
    }

    @FunctionalInterface
    interface StringFunction{
        String apply(String str);
    }

    @FunctionalInterface
    interface IntegerFunction{
        int apply(int i);
    }
}
