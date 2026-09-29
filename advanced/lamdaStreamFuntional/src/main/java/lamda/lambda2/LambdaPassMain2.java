package lamda.lambda2;

import lamda.MyFunction;

// 2. 람다를 메서드(함수)에 전달하기
public class LambdaPassMain2 {

    public static void main(String[] args) {
        MyFunction add = (a, b) -> a + b;
        MyFunction sub = (a, b) -> a - b;

        System.out.println("변수를 통해 전달");
        calculate(add);
        calculate(sub);

        System.out.println("람다를 직접 전달");
        calculate((a, b) -> a + b);
        calculate((a, b) -> a - b);
    }

    // 여기서 calculate라는 함수의 매개변수는 MyFuncion이라는 함수형 인터페이스이다. 때문에 람다를 전달할 수 있다.
    static void calculate(MyFunction function) {
        int a = 1;
        int b = 2;

        System.out.println("계산 시작");
        int result = function.apply(a, b);
        System.out.println("계산 결과: " + result);
    }
}
