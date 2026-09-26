package collection.set;

public class MyHashsetV3Main {

    public static void main(String[] args) {
        MySet<String> set = new MyHashSetV3<>();

        set.add("A");
        set.add("B");
        set.add("C");
        System.out.println("set = " + set);

        // 검색
        String searchValue = "A";
        System.out.println("searchValue = " + searchValue);
        boolean result = set.contains(searchValue);
        System.out.println("contains = " + result);

        MySet<Integer> integerSet = new MyHashSetV3<>();
        integerSet.add(1);
//        integerSet.add("A");
    }
}
