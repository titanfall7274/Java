package lamda.lambda1;

// 해당 어노테이션을 통해 컴파일 타임에서 단 하나의 추상 메서드임 즉 함수형 인터페이스임을 보장할 수 있다.
@FunctionalInterface
public interface SamInterface {
    void run();
}
