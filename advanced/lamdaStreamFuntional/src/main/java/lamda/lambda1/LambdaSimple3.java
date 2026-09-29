package lamda.lambda1;

import lamda.MyFunction;

public class LambdaSimple3 {

    public static void main(String[] args) {

        // 타입 생략 전
        MyFunction myFunction1 = (int a, int b) -> {
            return a + b;
        };
        int result1 = myFunction1.apply(1, 2);
        System.out.println("result1 = " + result1);

        MyFunction myFunction2 = (int a, int b) -> a + b;
        System.out.println("myFunction2.apply(2, 3) = " + myFunction2.apply(2, 3));

        MyFunction myFunction3 = (a, b) -> a + b;
        System.out.println("myFunction3.apply(3, 4) = " + myFunction3.apply(3, 4));
    }
}
