package lamda.lambda1;

// 단일 추상 메서드(SAM)가 아닌 경우
// 복합 추상 메서드로서 해당 인터페이스에는 람다를 사용할 수 없다.

// 인터페이스는 기본적으로 abstract가 생략되어있다.

// 애노테이션에 대해 컴파일 에러를 발생시킨다!
//@FunctionalInterface // Multiple non-overriding abstract methods found in NotSameInterface
public interface NotSameInterface {
    void run();

    void go(); // 실수로 누군가 추가시 컴파일 오류 발생
}
