package collection.set;

import java.util.Arrays;

public class MyHashSetV0 {

    public int[] elementData = new int[10];
    private int size = 0;

    // 데이터를 추가할 때마다 값이 있는지 중복 검사를 하느라 항상 O(n) 만큼의 연산으로 인해 입력 성능이 나쁘다.
    // O(n) + O(1)
    public boolean add(int value) {
        // 값이 있는지 중복검사 O(n)
        if(contains(value)) {
            return false;
        }

        elementData[size] = value; // O(1)
        size++;

        return true;
    }

    public boolean contains(int value) {
        for (int data : elementData) {
            if(data == value) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "MyHashSetV0{" +
                "elementData=" + Arrays.toString(Arrays.copyOf(elementData, size)) +
                ", size=" + size +
                '}';
    }
}
