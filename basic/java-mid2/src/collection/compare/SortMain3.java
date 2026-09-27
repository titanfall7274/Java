package collection.compare;

import java.util.Arrays;

public class SortMain3 {

    public static void main(String[] args) {
        MyUser myUser1 = new MyUser("a", 30);
        MyUser myUser2 = new MyUser("b", 20);
        MyUser myUser3 = new MyUser("c", 10);

        MyUser[] array = {myUser1, myUser2, myUser3};

        System.out.println("기본 데이터");
        System.out.println(Arrays.toString(array));

        System.out.println("Comparable 기본 정렬");
        Arrays.sort(array); // a, b, c 정렬에서 >> 나이 기준 오름차순 정렬
        System.out.println("array = " + Arrays.toString(array));

        // 추가 id 기준
        System.out.println("IdComparator 정렬");
        Arrays.sort(array, new IdComparator());
        System.out.println(Arrays.toString(array));

        Arrays.sort(array, new IdComparator().reversed());
        System.out.println("array = " + Arrays.toString(array));
    }
}
