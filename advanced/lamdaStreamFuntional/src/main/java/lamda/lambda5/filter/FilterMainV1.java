package lamda.lambda5.filter;

import java.util.ArrayList;
import java.util.List;

public class FilterMainV1 {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 1. 짝수만 거르기
        List<Integer> evens = filterEvenNumber(numbers);
        System.out.println("evens = " + evens);

        // 2. 홀수만 거르기
        List<Integer> odds = filterOddNumber(numbers);
        System.out.println("odds = " + odds);

        // 두 개의 문제를 해결하는데 있어 두개의 함수 작성이 필요하다.
        // 이걸 하나로 합치려면 어떻게 해야할까?
        // 람다를 통해 작동을 정의해서 넘기면 된다!
    }

    // 1. 짝수를 거르는 필터
    private static List<Integer> filterEvenNumber(List<Integer> list) {
        ArrayList<Integer> filtered = new ArrayList<>();

        for (Integer number : list) {
            boolean testResult = number % 2 == 0;
            if(testResult) {
                filtered.add(number);
            }
        }

        return filtered;
    }

    // 2. 홀수를 거르는 필터
    private static List<Integer> filterOddNumber(List<Integer> list) {
        ArrayList<Integer> filtered = new ArrayList<>();

        for (Integer number : list) {
            boolean testResult = number % 2 == 1;
            if(testResult) {
                filtered.add(number);
            }
        }

        return filtered;
    }

}
