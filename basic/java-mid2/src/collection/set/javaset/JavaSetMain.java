package collection.set.javaset;

import java.util.*;

public class JavaSetMain {

    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();

        run(hashSet);
        run(linkedHashSet);
        run(treeSet);
    }

    private static void run(Set<String> set) {
        System.out.println("set = " + set.getClass());

        set.add("C");
        set.add("A");
        set.add("B");
        set.add("1");
        set.add("2");

        System.out.println("set = " + set);
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}
