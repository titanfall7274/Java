package stream.basic;

import java.util.List;

public class ImmutableMain {

    public static void main(String[] args) {
        List<Integer> originList = List.of(1, 2, 3, 4, 5);

        System.out.println("originList = " + originList);

        List<Integer> filteredList = originList.stream()
                .filter(n -> n % 2 == 0)
                .toList();

        System.out.println("filteredList = " + filteredList);

        // originList는 스트림을 사용해도 원본이 변경되지 않는다.
        System.out.println("originList = " + originList);

    }
}
