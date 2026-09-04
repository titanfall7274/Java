package thread.sync.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class LockSupportMainV1 {
    public static void main(String[] args) {
        ParkTest parkTest = new ParkTest();
        Thread thread = new Thread(parkTest, "Thread-1");
        thread.start();

        sleep(100);
        log("Thread-1 state: " + thread.getState());

//        log("main -> unpark(Thread-1)");
//        LockSupport.unpark(thread);
        thread.interrupt();
    }

    static class ParkTest implements Runnable {
        @Override
        public void run() {
            log("park 시작");
            LockSupport.park();
            log("park 종료, state: " + Thread.currentThread().getState());
            log("interrupt state: " + Thread.currentThread().isInterrupted());
        }
    }
}
