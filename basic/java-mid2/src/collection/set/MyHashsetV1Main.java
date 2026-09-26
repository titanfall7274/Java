package collection.set;

public class MyHashsetV1Main {

    public static void main(String[] args) {
        MyHashSetV1 set = new MyHashSetV1(10);
        set.add(1);
        set.add(2);
        set.add(5);
        set.add(8);
        set.add(14);
        set.add(99);
        boolean result = set.add(9);
        System.out.println("result = " + result);
        System.out.println(set);

        // 검색
        int searchValue = 9;
        boolean contains = set.contains(searchValue);
        System.out.println("contains = " + contains);

        // 삭제
        boolean removeResult = set.remove(searchValue);
        System.out.println("removeResult = " + removeResult);
        System.out.println(set);
    }
}
