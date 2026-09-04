package thread.start;

public class DeamonThreadMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": main() start");

        DaemonThread daemonThread = new DaemonThread();
        daemonThread.setDaemon(true); // daemon Thread 여부
        System.out.println(Thread.currentThread().getName() + ": run() before");

        daemonThread.start(); // 데몬이라 10초를 기다리지 않고 바로 실행이 종료된다.
        System.out.println(Thread.currentThread().getName() + ": run() after");
        System.out.println(Thread.currentThread().getName() + ": main() end");
    }

    private static class DaemonThread extends Thread {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ": run()");

            try {
                Thread.sleep(10000); // 10초간 실행
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName() + ": run() end");

        }
    }
}
