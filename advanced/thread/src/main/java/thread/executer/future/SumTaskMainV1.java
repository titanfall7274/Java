package thread.executer.future;

import static util.MyLogger.log;

public class SumTaskMainV1 {
    public static void main(String[] args) throws InterruptedException {
        SumTask task1 = new SumTask(1, 50);
        SumTask task2 = new SumTask(51, 100);
        Thread thread1 = new Thread(task1, "Thread-1");
        Thread thread2 = new Thread(task2, "Thread-2");

        thread1.start();
        thread2.start();

        log("join() - main 스레드가 thread1, thread2 종료까지 대기");
        thread1.join();
        thread2.join();
        log("main 스레드 대기 완료");

        log("task1.value = " + task1.value);
        log("task2.value = " + task2.value);
        int sum = task1.value + task2.value;

        log("task1 + task2 = " + sum);
        log("end");
    }

    private static class SumTask implements Runnable {
        int start, end;
        int value = 0;

        public SumTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            log("run start");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum += i;
            }
            value = sum;
        }
    }
}
