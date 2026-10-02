package lamda.lambda6;

public class CaptureMain {

    public static void main(String[] args) {
        final int final1 = 10; // 명시적으로 final
        int final2 = 20; // 사실상(final): 제할당(값 변경) 없음
        int changedVar = 30; // 값이 변경되는 변수

        // 1. 익명 클래스에서의 캡처 - 지역변수는 반드시 final 혹은 사실상 final인 변수만 캡처할 수 있다.
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("익명 클래스 - final1: " + final1);
                System.out.println("익명 클래스 - final2: " + final2);

                // 컴파일 오류
//                System.out.println("익명 클래스 - changeVar: " + changedVar);
            }
        };

        // 2. 람다 표현식에서의 캡처 - 지역변수는 반드시 final 혹은 사실상 final인 변수만 캡처할 수 있다.
        Runnable lambda = () -> {
            System.out.println("람다 - final1: " + final1);
            System.out.println("람다 - final2: " + final2);

            // 컴파일 오류
//            System.out.println("람다 - chnagedVar: " + changedVar);
        };

        // chnagedBar 값을 변경해서 "사실상 final"이 아님
//        changedVar++;

        // 실행
        runnable.run();
        System.out.println("--------------------");
        lambda.run();
    }
}
