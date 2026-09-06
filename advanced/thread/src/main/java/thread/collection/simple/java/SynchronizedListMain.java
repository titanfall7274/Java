package thread.collection.simple.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedListMain {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("data1");
        list.add("data2");
        list.add("data3");

        System.out.println(list.getClass());
        System.out.println("list = " + list);

        List<String> list2 = Collections.synchronizedList(new ArrayList<>());
        list2.add("data1");
        list2.add("data2");
        list2.add("data3");

        System.out.println(list2.getClass());
        System.out.println("list2 = " + list2);

    }
}
