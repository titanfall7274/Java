package collection.array;

public class MyArrayListV3Main {

    public static void main(String[] args) {
        MyArrayListV3 list = new MyArrayListV3();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list);

        list.add(3, "addLast");
        System.out.println(list);

        list.add(0, "addFirst");
        System.out.println(list);

        Object removed = list.remove(4);
        System.out.println("removed = " + removed);
        System.out.println(list);

        Object removed1 = list.remove(0);
        System.out.println("removed1 = " + removed1);
        System.out.println(list);
    }
}
