package lamda.lambda5.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilterMainV2 {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 1. 짝수만 거르기
        Predicate<Integer> evenPredicate = n -> n % 2 == 0;
        List<Integer> evens = filter(numbers, evenPredicate);
        System.out.println("evens = " + evens);

        // 2. 홀수만 거르기
        Predicate<Integer> oddPredicate = n -> n % 2 == 1;
        List<Integer> odds = filter(numbers, oddPredicate);
        System.out.println("odds = " + odds);
    }

    // 술어의 작업에 따른 결과를 반환하는 필터
    private static List<Integer> filter(List<Integer> list, Predicate<Integer> predicate) {
        ArrayList<Integer> filtered = new ArrayList<>();

        for (Integer number : list) {
            boolean testResult = predicate.test(number);
            if(testResult) {
                filtered.add(number);
            }
        }

        return filtered;
    }
}
