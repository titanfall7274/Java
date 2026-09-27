package collection.iterable;

import java.util.*;

public class JavaIterableMain {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        printAll(list.iterator());
        printAll(set.iterator());
        foreach(list);
        foreach(set);
    }

    private static void foreach(Iterable<Integer> iterable) {
        System.out.println(iterable.getClass()); // class java.util.ArrayList 구현체
        for (Integer i : iterable) {
            System.out.println(i);
        }
    }

    public static void printAll(Iterator<Integer> iterator) {
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println("\n" + iterator.getClass()); // class java.util.ArrayList$Itr 중첩 클래스
    }

}
