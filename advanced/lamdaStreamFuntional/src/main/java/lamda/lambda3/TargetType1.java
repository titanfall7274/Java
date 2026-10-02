package lamda.lambda3;

public class TargetType1 {

    public static void main(String[] args) {
        // 우리가 만든 제네릭을 활용한 Genericfunction은 코드 중복을 줄이고 유지보수성을 높여준다.

        // 단,
        // 1. 모든 개발자들이 비슷한 함수형 인터페이스를 개발해야한다. 즉, 비슷한 모양의 GenericFunction이 많이 만들어질 것이다.
        FunctionA<Integer, String> functionA = n -> "value = " + n;
        String result1 = functionA.apply(2);
        System.out.println("result1 = " + result1);

        FunctionB<Integer, String> functionB = n -> "value = " + n;
        String result2 = functionB.apply(3);
        System.out.println("result2 = " + result2);

        // 2. 개발자 A가 만든 함수형 인터페스와 개발자 B가 만든 함수형 인터페이스는 서로 호환되지 않는다.
        // 이미 만들어진 FunctionA 인스턴스를 FunctionB에 대입: 불가능
        // 자바 타입 시스템상 전혀 다른 인터페이스이므로 서로 호환되지 않는다.
//        FunctionB targetB = functionA;
    }

    @FunctionalInterface
    interface FunctionA<T, R> {
        R apply(T s);
    }

    @FunctionalInterface
    interface FunctionB<T, R> {
        R apply(T s);
    }
}
