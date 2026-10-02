package lamda.ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilterExampleEx2 {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(-3, -2, -1, 1, 2, 3, 5);
        System.out.println("원본 리스트: " + numbers);

        // 1. 음수(negative)만 뽑아내기
        List<Integer> negatives = filter(numbers, value -> value < 0);
        System.out.println("negatives = " + negatives);

        // 2. 짝수(even)만 뽑아내기
        List<Integer> evens = filter(numbers, value -> value % 2 == 0);
        System.out.println("evens = " + evens);
    }

    private static List<Integer> filter(List<Integer> list, Predicate<Integer> predicate) {
        ArrayList<Integer> result = new ArrayList<>();

        for (Integer val : list) {
            if(predicate.test(val)) {
                result.add(val);
            }
        }
        return result;
    }
}
