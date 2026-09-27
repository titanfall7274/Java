package collection.deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DequeStackMain {

    public static void main(String[] args) {
        // Stack은 따로 interface가 없어 제한이 불가능하다. 사용할때 주의가 필요하다.
        Deque<Integer> stack = new ArrayDeque<>();
//        Deque<Integer> deque = new LinkedList<>();

        // 데이터 추가
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("deque = " + stack);

        System.out.println("deque.peek() = " + stack.peek());

        // 데이터 꺼내기
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack = " + stack);

    }
}
