package lamda.lambda3;

import java.util.function.Function;

public class TargetType2 {

    public static void main(String[] args) {
        // 앞서 이야기한 문제들을 해결하기 위해 자바는
        // java.util.function 패키지에 다양한 기본 함수형 인터페이스들을 제공한다.

        // 자바가 기본으로 제공하는 Function 사용
        Function<String, String> upperCase = s -> s.toUpperCase();
        String result1 = upperCase.apply("hello");
        System.out.println("result1 = " + result1);

        Function<Integer, Integer> square = n -> n * n;
        Integer result2 = square.apply(3);
        System.out.println("result2 = " + result2);

//        upperCase = square;
    }
}
