package thread.executer.future;

import java.util.Random;
import java.util.concurrent.*;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class CallableMainV2 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue><>());
        ExecutorService es = Executors.newFixedThreadPool(1);

        log("submit() 호출");
        Future<Integer> future = es.submit(new MyCallable());
        log("future 즉시 반환, future = " + future);
        log("future.get() [블로킹] 메서드 호출 시작 -> main 스레드 WAITING");

        log("future.get() [블로킹] 메서드 호출 완료 -> main 스레드 RUNNABLE");
        Integer result = future.get();
        log("result value = " + result);
        log("future 완료, future = " + future);
        es.close();
    }

    private static class MyCallable implements Callable<Integer> {

        int value;

        @Override
        public Integer call() throws InterruptedException {
            log("Callable 시작");
            sleep(2000);
            value = new Random().nextInt(10);
            log("create value = " + value);
            log("Callable 종료");
            return value;
        }
    }
}
