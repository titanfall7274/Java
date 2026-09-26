package collection.list;

public class BatchProcessorMain {

    public static void main(String[] args) {
//        MyList<Integer> integerList = new MyArrayList<>();
        MyList<Integer> integerList = new MyLinkedList<>();

        BatchProcessor batchProcessor = new BatchProcessor(integerList);
        batchProcessor.logic(50_000); // ArrayList: 2658ms, LinkedList: 5ms
    }
}
