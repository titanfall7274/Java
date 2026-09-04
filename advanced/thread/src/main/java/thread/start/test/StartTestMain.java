package thread.start.test;

import static util.MyLogger.log;

public class StartTestMain {
    public static void main(String[] args) {
        log("main() start");

        CounterThread counterThread = new CounterThread();
        counterThread.start();

        log("main() end");
    }

    private static class CounterThread extends Thread {
        @Override
        public void run() {
            log("run() start");
            for (int i = 1; i <= 5; i++) {
                log("value: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            log("run() end");
        }
    }
}
