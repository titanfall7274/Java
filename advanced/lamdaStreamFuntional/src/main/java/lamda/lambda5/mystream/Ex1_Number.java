package lamda.lambda5.mystream;

import lamda.lambda5.filter.GenericFilter;
import lamda.lambda5.map.GenericMapper;

import java.util.ArrayList;
import java.util.List;

public class Ex1_Number {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 짝수만 남기고, 남은 값의 2배를 반환
        List<Integer> directResult = direct(numbers);
        System.out.println("directResult = " + directResult);

        List<Integer> lambdaResult = lambda(numbers);
        System.out.println("lambdaResult = " + lambdaResult);
    }

    // 명령형 프로그래밍
    private static List<Integer> direct(List<Integer> list) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int integer : list) {
            boolean isEven = integer % 2 == 0;
            if(isEven) {
                int value = integer * 2;
                result.add(value);
            }
        }
        return result;
    }

    // 함수형 프로그래밍
    private static List<Integer> lambda(List<Integer> list) {
        List<Integer> filter = GenericFilter.filter(list, n -> n % 2 == 0);
        return GenericMapper.map(filter, n -> n * 2);
    }
}
