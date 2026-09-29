package lamda.ex2;

import java.util.ArrayList;
import java.util.List;

public class FilterExampleEx1 {

    public static List<Integer> filter(List<Integer> list, MyPredicate predicate) {
        List<Integer> result = new ArrayList<>();

        for (Integer val : list) {
            if(predicate.test(val)) {
                result.add(val);
            }
        }

        return result;
    }
    public static void main(String[] args) {
        List<Integer> list = List.of(-3, -2, -1, 1, 2, 3, 5);

        // 1. 음수만
        MyPredicate negative = new MyPredicate() {
            @Override
            public boolean test(int value) {
                return value < 0;
            }
        };
        List<Integer> result1 = filter(list, negative);
        System.out.println("result = " + result1);

        // 짝수만
        MyPredicate even = new MyPredicate() {
            @Override
            public boolean test(int value) {
                return value % 2 == 0;
            }
        };
        List<Integer> result2 = filter(list, even);
        System.out.println("result2 = " + result2);
    }
}
