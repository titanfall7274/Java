package collection.list;

public class BatchProcessor {

//    private final MyArrayList<Integer> list = new MyArrayList<>(); // 연결리스트
//    private final MyLinkedList<Integer> list = new MyLinkedList<>(); // 링크드 리스트
    private final MyList<Integer> list;

    // 밖에서 나중에 의존관계를 결정하여 주입
    public BatchProcessor(MyList<Integer> list) {
        this.list = list;
    }

    public void logic(int size) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(0, i); // 앞에 추가 O(n)
        }

        long endTime = System.currentTimeMillis();
        System.out.println("크기: " + size + ", 계산 시간: " + (endTime - startTime) + "ms");
    }
}
