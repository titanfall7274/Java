package collection.set.test;

import java.util.*;

public class UniqueNamesTest1 {

    public static void main(String[] args) {
        // 여러 정수가 입력된다. 여기서 중복 값을 제거하고 값을 출력하라
        Integer[] inputArr = {30, 20, 20, 10, 10};

        // 중복을 제거하고 출력하며, 출력 순서는 상관없다.
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        // return new ArrayList<>(a)
        List<Integer> list2 = List.of(1, 2, 3);
        // return ImmutableCollections.listFromTrustedArray(e1, e2, e3);
        HashSet<Integer> hashSet = new HashSet<>(List.of(inputArr));
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();


        for (Integer input : inputArr) {
            hashSet.add(input);
            linkedHashSet.add(input);
            treeSet.add(input);
        }

        System.out.println("integerHashSet = " + hashSet);
        for (Integer integer : hashSet) {
            System.out.print(integer + " ");
        }
        System.out.println("\nlinkedHashSet = " + linkedHashSet);
        for (Integer integer : linkedHashSet) {
            System.out.print(integer + " ");
        }
        System.out.println("\ntreeSet = " + treeSet);
        for (Integer integer : treeSet) {
            System.out.print(integer + " ");
        }


    }
}
