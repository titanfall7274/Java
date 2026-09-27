package collection.deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class DequeQueueMain {

    public static void main(String[] args) {
        // Queue는 Queue인터페이스가 있어 제한이 가능하다.
        Queue<Integer> queue = new ArrayDeque<>();
//        Deque<Integer> queue = new LinkedList<>();

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println("queue = " + queue);

        System.out.println("queue.peek() = " + queue.peek());

        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue = " + queue);

    }
}
