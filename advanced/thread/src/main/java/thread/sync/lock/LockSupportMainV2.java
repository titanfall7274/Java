package thread.sync.lock;

import java.util.concurrent.locks.LockSupport;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class LockSupportMainV2 {
    public static void main(String[] args) {
        ParkTest parkTest = new ParkTest();
        Thread thread = new Thread(parkTest, "Thread-1");
        thread.start();

        sleep(100);
        log("Thread-1 state: " + thread.getState());


    }

    static class ParkTest implements Runnable {
        @Override
        public void run() {
            log("park 시작");
            LockSupport.parkNanos(2_000_000_000); // 2초
            log("park 종료, state: " + Thread.currentThread().getState());
            log("interrupt state: " + Thread.currentThread().isInterrupted());
        }
    }
}
