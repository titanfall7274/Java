package stream.basic;

import lamda.lambda5.mystream.MyStreamV3;

import java.util.List;

public class LazyEvalMain2 {

    public static void main(String[] args) {
        List<Integer> data = List.of(1, 2, 3, 4, 5, 6);

        // 즉시(EAGER) 연산
        ex1(data); // 최종연산인 toList(), forEach()를 호출하지 않아도 바로바로 실행된다.

        // LAZY 연산
        ex2(data); // 지연 연산이 적용되어 최종 연산을 수행하지 않을경우 아예 수행되지 않습니다.
    }

    private static void ex1(List<Integer> data) {
        System.out.println("== MyStreamV3 시작 ===");
        MyStreamV3.of(data)
                .filter(i -> {
                    boolean isEven = i % 2 == 0;
                    if (isEven) {
                        System.out.println("filter() 실행: " + i + "(" + isEven + ")");
                    }
                    return isEven;
                })
                .map(i -> {
                    int mapped = i * 10;
                    System.out.println("map() 실행: " + i + " -> " + mapped);
                    return mapped;
                });

        System.out.println("== MyStreamV3 종료 ==");
    }

    private static void ex2(List<Integer> data) {
        System.out.println("== Stream API 시작 ==");
        data.stream()
                .filter(i -> {
                    boolean isEven = (i % 2) == 0;
                    System.out.println("filter() 실행: " + i + "(" + isEven + ")");
                    return isEven;
                })
                .map(i -> {
                    int mapped = i * 10;
                    System.out.println("map() 실행:" + i + " -> " + mapped);
                    return mapped;
                });

        System.out.println("=== Stream API 종료 ===");
    }
}
