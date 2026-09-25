package collection.array;

import java.util.Arrays;

public class MyArrayListV4<E> {

    private static final int DEFAULT_CAPACITY = 5;

    private Object[] elementData;
    private int size = 0;

    public MyArrayListV4() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayListV4(int initialCapacity) {
        elementData = new Object[initialCapacity];
    }

    public int size() {
        return size;
    }

    public void add(E e) {
        if (size == elementData.length) {
            grow(); // 크기를 2배로 증가 및 레퍼런스 변경
        }
        elementData[size] = e;
        size++;
    }
    
    public void add(int index, E e) {
        if (size == elementData.length) {
            grow(); // 크기를 2배로 증가 및 레퍼런스 변경
        }
        shiftRightFrom(index);
        elementData[index] = e;
        size++;
    }

    private void shiftRightFrom(int index) {
        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
    }

    private void grow() {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity * 2;

        // 배열을 새로 만들고 기존의 배열을 새로운 배열에 복사
    /*
        Object[] newArr = new Object[newCapacity];
        for (int i = 0; i < oldCapacity; i++) {
            newArr[i] = elementData[i];
        }
*/
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) elementData[index];
    }

    public E set(int index, E element) {
        E oldValue = get(index);
        elementData[index] = element;
        return oldValue;
    }

    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elementData[i])) {
                return i;
            }
        }
        return -1;
    }

    public E remove(int index) {
        E oldValue = get(index);
        siftLeftFrom(index);

        size--;
        elementData[size] = null;
        return oldValue;
    }

    private void siftLeftFrom(int index) {
        for (int i = index; i < elementData.length - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
    }

    @Override
    public String toString() {
//        [1, 2, 3, null, null]; // size = 3
//        [1, 2, 3] 만 출력
        return Arrays.toString(Arrays.copyOf(elementData, size)) +
                " size = " + size + " capacity = " + elementData.length;
    }
}
