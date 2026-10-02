package lamda.lambda5.map;

import java.util.List;

public class MapMainV5 {

    public static void main(String[] args) {
        List<String> list = List.of("apple", "banana", "orange");

        // String -> String
        List<String> upperCase = GenericMapper.map(list, s -> s.toUpperCase());
        System.out.println("upperCase = " + upperCase);

        // String -> Integer
        List<Integer> lengths = GenericMapper.map(list, s -> s.length());
        System.out.println("lengths = " + lengths);

        // Integer -> String
        List<Integer> integers = List.of(1, 2, 3);
        List<String> statList = GenericMapper.map(integers, n -> "*".repeat(n)); // java11
        System.out.println("statList = " + statList);
    }
}
