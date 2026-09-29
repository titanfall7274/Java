package lamda.lambda1;

import lamda.Procedure;

public class InstanceMain {

    public static void main(String[] args) {
        Procedure procedure1 = new Procedure() {
            @Override
            public void run() {
                System.out.println("Hello! lambda");
            }
        };

        // 익명 함수는 *$n 로 구분하게 됩니다.
        // class lamda.lambda1.InstanceMain$1
        System.out.println("class.class = " + procedure1.getClass());

        // lamda.lambda1.InstanceMain$1@85ede7b
        System.out.println("class.instance = " + procedure1);

        // 람다를 사용하면 new 연산자를 사용하지는 않지만 익명 클래스처럼 인스턴스가 생성됩니다.
        Procedure procedure2 = () -> System.out.println("Hello! lamda");

        // 람다를 통해 생성된 객체는 $$로 구분하며 뒤에 복잡한 문자가 붙습니다.
        // class lamda.lambda1.InstanceMain$$Lambda/0x000001e0b8001000
        System.out.println("class.class = " + procedure2.getClass());
        // lamda.lambda1.InstanceMain$$Lambda/0x000001e0b8001000@1be6f5c3
        System.out.println("class.instance = " + procedure2);
    }
}
