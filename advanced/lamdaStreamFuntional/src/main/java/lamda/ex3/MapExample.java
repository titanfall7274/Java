package lamda.ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MapExample {

    public static void main(String[] args) {
        List<String> words = List.of("hello", "java", "lambda");
        System.out.println("원본 리스트: " + words);

        // 1. 대문자 변환
        List<String> upperList = map(words, s -> s.toUpperCase());
        System.out.println("upperList = " + upperList);

        // 2. 앞 뒤에 *** 붙이기 (람다로 작성)
        List<String> decoratedList = map(words, s -> "***" + s + "***");
        System.out.println("decoratedList = " + decoratedList);
    }

    private static List<String> map(List<String> list, Function<String, String> function) {
        ArrayList<String> result = new ArrayList<String>();

        for (String str : list) {
            result.add(function.apply(str));
        }

        return result;
    }
}
