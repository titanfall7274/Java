package collection.link;

public class MyLinkedListMainV2 {

    public static void main(String[] args) {
        MyLinkedListV2 list = new MyLinkedListV2();

        System.out.println("==데이터 추가==");

        // 마지막에 추가 O(n)
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list);

        // 첫번째 항목에 추가, 삭제 O(1)
        System.out.println("첫 번째 항목에 추가");
        list.add(0, "d");
        System.out.println(list);

        // 첫 번째 항목에 삭제 O(1)
        System.out.println("첫 번째 항목 삭제");
        Object removed = list.remove(0);
        System.out.println("removed = " + removed);
        System.out.println(list);

        // 중간 항목에 추가, 삭제
        list.add(1, "e"); // O(n)
        System.out.println(list);
        Object removed1 = list.remove(1);// O(n);
        System.out.println("removed1 = " + removed1);
        System.out.println(list);
    }
}
