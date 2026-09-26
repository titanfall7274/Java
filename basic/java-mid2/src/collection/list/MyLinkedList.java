package collection.list;

import collection.link.MyLinkedListV3;

public class MyLinkedList<E> implements MyList<E> {

    private static class Node<E> {
        E item;
        Node<E> next;

        public Node(E item) {
            this.item = item;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "item=" + item +
                    ", next=" + next +
                    '}';
        }
    }

    private Node<E> first;
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    private Node<E> getLastNode() {
        Node<E> x = first;

        while (x.next != null) {
            x = x.next;
        }

        return x;
    }


    @Override
    public void add(E e) {
        Node<E> newNode = new Node<E>(e);
        if (first == null) {
            first = newNode;
        } else {
            Node<E> lastNode = getLastNode();
            lastNode.next = newNode;
        }

        size++;
    }

    @Override
    public void add(int index, E e) {
        Node<E> newNode = new Node(e);

        if(index == 0) {
            first = newNode;
        } else {
            Node<E> prev = getNode(index - 1);

            newNode.next = prev.next;
            prev.next = newNode;
        }

        size++;
    }

    private Node<E> getNode(int index) {
        Node<E> x = first;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }

        return x;
    }

    @Override
    public E get(int index) {
        return getNode(index).item;
    }

    @Override
    public E set(int index, E element) {
        Node<E> x = getNode(index);
        E oldValue = x.item;

        x.item = element;
        return oldValue;
    }

    @Override
    public E remove(int index) {
        Node<E> removeNode = getNode(index);
        E removedItem = removeNode.item;

        if(index == 0) {
            first = removeNode.next;
        } else {
            Node<E> prev = getNode(index - 1);
            prev.next = removeNode.next;
        }

        removeNode.item = null;
        removeNode.next = null;

        size--;
        return removedItem;
    }

    @Override
    public int indexOf(E o) {
        int index = 0;
        for (Node<E> x = first; x != null; x = x.next) {
            if (o.equals(x.item)) return index;
            index++;
        }
        return -1;
    }
}
