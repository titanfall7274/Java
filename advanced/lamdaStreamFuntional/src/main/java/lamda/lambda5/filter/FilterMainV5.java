package lamda.lambda5.filter;

import java.util.List;

public class FilterMainV5 {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 숫자 사용 필터
        // 1. 짝수만 거르기
        List<Integer> evnes = GenericFilter.filter(numbers, n -> n % 2 == 0);
        System.out.println("evnes = " + evnes);

        // 2. 홀수만 거르기
        List<Integer> odds = GenericFilter.filter(numbers, n -> n % 2 == 1);
        System.out.println("odds = " + odds);

        // 문자 사용 필터
        List<String> strings = List.of("A", "BB", "CCC");
        List<String> stringResult = GenericFilter.filter(strings, s -> s.length() >= 2);
        System.out.println("stringResult = " + stringResult);
    }
}
