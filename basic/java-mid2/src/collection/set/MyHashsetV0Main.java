package collection.set;

public class MyHashsetV0Main {

    public static void main(String[] args) {
        MyHashSetV0 hashset = new MyHashSetV0();
        hashset.add(1); // O(1)
        hashset.add(2); // O(n)
        hashset.add(3); // O(n)
        hashset.add(4); // O(n)
        hashset.add(5); // O(n)
        System.out.println(hashset);
        boolean result = hashset.add(4); // O(n)
        System.out.println("중복 저장 결과: " + result);

        System.out.println("hashset.size() = " + hashset.size()); // O(1)
        System.out.println("hashset.contains(3) = " + hashset.contains(3)); // O(n)
        System.out.println("hashset.contains(99) = " + hashset.contains(99)); // O(n)
    }
}
