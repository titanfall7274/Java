package lamda.lambda1;

import lamda.Procedure;

public class LambdaSimple2 {

    public static void main(String[] args) {

        // void run() {} 안에서 return 생략이 가능합니다.
        Procedure procedure1 = () -> {
            System.out.println("hello! lambda");
        };

        procedure1.run();

        // 단일 표현식은 중괄호 생략 가능
        Procedure procedure2 = () -> System.out.println("hello! lambda");
        procedure2.run();
    }
}
