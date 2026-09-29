package lamda.start;

public class Ex0Main {

    public static void helloJava() {
        System.out.println("프로그램 시작");
        System.out.println("Hello Java");
        System.out.println("프로그램 종료");
    }

    public static void helloSpring() {
        System.out.println("프로그램 시작");
        System.out.println("Hello Spring");
        System.out.println("프로그램 종료");
    }

    public static void hello(String message) {
        System.out.println("프로그램 시작");
        System.out.println(message);
        System.out.println("프로그램 종료");
    }

    public static void main(String[] args) {
//        helloJava();
//        helloSpring();

        // 여기서 변하는 값은 문자값(Value)라고 한다.
        // 메서드의 동작을 달리하고, 재사용성을 높이는 방법을 값 매개변수화(Value Parameterization)
        hello("Hello Java");
        hello("Hello Spring");
    }
}
