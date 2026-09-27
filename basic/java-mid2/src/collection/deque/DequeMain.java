package collection.deque;

import java.util.ArrayDeque;
import java.util.Deque;

// Double Ended Queue
public class DequeMain {

    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
//        Deque<Integer> deque = new LinkedList<>();

        // 데이터 추가
        deque.offer(1); // offerLast 호출
        deque.offerFirst(2);
        deque.offerLast(3);
        System.out.println("deque = " + deque);

        // 단순 조회 peek()
        System.out.println("deque.peek() = " + deque.peek());
        System.out.println("deque.peek() = " + deque.peek());

        // 다음 꺼낼 데이터 조회
        System.out.println("deque.poll() = " + deque.poll()); // pollFirst() 호출
        System.out.println("deque.pollLast() = " + deque.pollLast());
        System.out.println("deque.pollFirst() = " + deque.pollFirst());
        System.out.println("deque = " + deque);
    }
}
