package lamda.lambda1;

public class SamMain {

    public static void main(String[] args) {
        SamInterface samInterface = () -> {
            System.out.println("sam");
        };
        samInterface.run();

        /** 자바에서 람다는 하나의 함수이다. 람다를 인터페이스에 담고싶다면 하나의 메서드(함수) 선언만 존재해야 합니다. */

        // Compile Error
        // incompatible types: lambda.lambda1.NotSamInterface is not a functional interface
        // Multiple non-overriding abstract methods found in NotSameInterface
        /*NotSameInterface notSameInterface = () -> {
            System.out.println("not sam");
        };

        notSameInterface.run();
        notSameInterface.go();*/
    }
}
