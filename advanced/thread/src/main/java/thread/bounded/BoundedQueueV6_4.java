package thread.bounded;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static util.MyLogger.log;

public class BoundedQueueV6_4 implements BoundedQueue {

    private BlockingQueue<String> queue;

    private final Lock lock = new ReentrantLock();
    private final Condition producerCondition = lock.newCondition();
    private final Condition consumerCondition = lock.newCondition();

    public BoundedQueueV6_4(int max) {
        this.queue = new ArrayBlockingQueue<>(max);
    }

    @Override
    public void put(String data) {
        boolean result = queue.add(data); // java.lang.IllegalStateException: Queue full
        log("저장 시도 결과 = " + result);
    }

    @Override
    public String take() {
        String result = queue.remove(); // java.util.NoSuchElemetException
        log("제거 시도 결과 = " + result);
        return result;
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
