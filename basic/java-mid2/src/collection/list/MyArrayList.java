package collection.list;

import java.util.Arrays;

public class MyArrayList<E> implements MyList<E> {

    private final int DEFAULT_CAPACIRY = 5;

    private Object[] elementData;
    private int size = 0;

    public MyArrayList() {
        elementData = new Object[DEFAULT_CAPACIRY];
    }

    public MyArrayList(int initialCapacity) {
        this.elementData = new Object[initialCapacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E e) {
        if (size == elementData.length) {
            grow();
        }
        elementData[size] = e;
        size++;
    }

    @Override
    public void add(int index, E e) {
        if (size == elementData.length) {
            grow();
        }
        for (int i = elementData.length - 1; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
        elementData[index] = e;
        size++;
    }

    private void grow() {
        int oldLength = elementData.length;
        int newLength = oldLength * 2;

        elementData = Arrays.copyOf(this.elementData, newLength);
    }

    @Override
    public E get(int index) {
        return (E) elementData[index]; // (E)타입 캐스팅 필요
    }

    @Override
    public E set(int index, E newValue) {
        E oldValue = get(index);
        elementData[index] = newValue;
        return oldValue;
    }

    @Override
    public E remove(int index) {
        E removeValue = get(index);
        for (int i = index; i < elementData.length - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        size--;
        elementData[size] = null;
        return removeValue;
    }

    @Override
    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elementData[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elementData, size)) +
                " size = " + size + " capacity = " + elementData.length;

    }
}
