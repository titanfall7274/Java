package lamda.ex2;

import java.util.ArrayList;
import java.util.List;

public class ReduceExampleEx1 {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4);

        // 1. 합(+)
        int result = map(list, 0, new MyReducer() {
            @Override
            public int reduce(int a, int b) {
                return a + b;
            }
        });
        System.out.println("result = " + result);

        // 2. 곱(*)
        int result2 = map(list, 1, new MyReducer() {
            @Override
            public int reduce(int a, int b) {
                return a * b;
            }
        });
        System.out.println("result2 = " + result2);
    }

    private static int map(List<Integer> list, int initial, MyReducer myReducer) {
        int result = initial;
        for (Integer val : list) {
            result = myReducer.reduce(result, val);
        }
        return result;
    }
}
