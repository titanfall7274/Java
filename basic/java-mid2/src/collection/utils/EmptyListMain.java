package collection.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EmptyListMain {

    public static void main(String[] args) {
        // 빈리스트 생성
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        // 빈 불변 리스트 생성
        List<Object> list3 = Collections.emptyList(); // java 5
        List<Object> list4 = List.of(); // java 9

        System.out.println("list3.getClass() = " + list3.getClass());
        System.out.println("list4.getClass() = " + list4.getClass());

        Integer[] arr = {1, 2, 3, 4, 5};
        List<Integer> list5 = Arrays.asList(1, 2, 3);
        List<Integer> list6 = List.of(1, 2, 3);

        List<Integer> arrList = Arrays.asList(arr); // 원본 배열 사이드 이펙트
        List<Integer> arrOf = List.of(arr); // 원본 배열 복사

        System.out.println("arr = " + Arrays.toString(arr));
        System.out.println("arrList = " + arrList);

        arr[0] = 2;

        System.out.println("arr = " + Arrays.toString(arr));
        System.out.println("arrList = " + arrList);

        System.out.println("arr = " + Arrays.toString(arr));
        System.out.println("arrOf = " + arrOf);
    }
}
