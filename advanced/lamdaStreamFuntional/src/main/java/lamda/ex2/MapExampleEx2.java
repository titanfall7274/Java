package lamda.ex2;

import java.util.ArrayList;
import java.util.List;

public class MapExampleEx2 {

    public static List<String> map(List<String> list, StringFuncion func) {
        ArrayList<String> result = new ArrayList<>();
        for (String str : list) {
            result.add(func.apply(str));
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> list = List.of("hello", "java", "lambda");

        // 1. 모든 문자열을 대문자로 변경
        List<String> result1 = map(list, str -> str.toUpperCase());
        System.out.println("result1 = " + result1);

        // 2. 특수 문자 데코 str >> ***str***
        List<String> result2 = map(list, str -> "***" + str + "***");
        System.out.println("result2 = " + result2);
    }
}
