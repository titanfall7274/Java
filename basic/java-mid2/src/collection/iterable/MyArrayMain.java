package collection.iterable;

import java.util.Iterator;

public class MyArrayMain {

    public static void main(String[] args) {
        MyArray myArray = new MyArray(new int[]{1, 2, 3, 4});
        System.out.println("myArray = " + myArray);
        Iterator<Integer> iterator = myArray.iterator();
        System.out.println("iterator = " + iterator);
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            System.out.println("iterator = " + value);
        }

        System.out.println("for-each 사용"); // iterable을 가지고 있어야 향상된 for문 사용을 가능하게 해줍니다.
        for (int value : myArray) {
            System.out.println("value = " + value);
        }
        // 해당 코드는 컴파일 시점에
        /*while(iterator.hasNext()) {
            Integer value = iterator.next();
            System.out.println("value = " + value);
        }*/
        // 다음과 같이 코드를 변경한다.
    }
}
