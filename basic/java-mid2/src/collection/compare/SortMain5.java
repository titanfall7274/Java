package collection.compare;

import java.util.*;

public class SortMain5 {

    public static void main(String[] args) {
        MyUser myUser1 = new MyUser("a", 30);
        MyUser myUser2 = new MyUser("b", 20);
        MyUser myUser3 = new MyUser("c", 10);

        // 넣을때 정렬되므로 그냥 출력하면 됨
        Set<MyUser> treeSet = new TreeSet<>();
        treeSet.add(myUser1);
        treeSet.add(myUser2);
        treeSet.add(myUser3);

        System.out.println("Comparable 기본 정렬");
        System.out.println(treeSet); // 나이 기준으로 정렬되었음

        TreeSet<MyUser> treeSet2 = new TreeSet<>(new IdComparator().reversed());
        treeSet2.add(myUser1);
        treeSet2.add(myUser2);
        treeSet2.add(myUser3);

        System.out.println("IdComparator 정렬");
        System.out.println(treeSet2);
    }
}
