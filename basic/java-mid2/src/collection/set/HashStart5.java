package collection.set;

import java.util.Arrays;
import java.util.LinkedList;

public class HashStart5 {

    static final int CAPACITY = 10;

    public static void main(String[] args) {
        LinkedList<Integer>[] buckets = new LinkedList[CAPACITY];
        for (int i = 0; i < CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }

        add(buckets, 1);
        add(buckets, 2);
        add(buckets, 5);
        add(buckets, 8);
        add(buckets, 14);
        add(buckets, 99); // 9: [99]
        add(buckets, 9); // 중복 9: [99, 9] 저장
        System.out.println(Arrays.toString(buckets));

        // 검색 - searchValue > hashIndex > buckets[hashIndex] > [99, 9] 탐색 > true
        boolean contains = contains(buckets, 9);
        System.out.println("contains 9 = " + contains);
    }

    private static void add(LinkedList<Integer>[] buckets, int value) {
        int hashIndex = hashIndex(value);
        LinkedList<Integer> bucket = buckets[hashIndex]; // O(1)

        // 중복 검사
        if(!bucket.contains(value)) {
            bucket.add(value);
        }
    }

    private static boolean contains(LinkedList<Integer>[] buckets, int searchValue) {
        int hashIndex = hashIndex(searchValue);
        LinkedList<Integer> bucket = buckets[hashIndex]; // O(1)
        return bucket.contains(hashIndex); // O(n)
    }

    static int hashIndex(int value) {
        return value % CAPACITY;
    }
}
