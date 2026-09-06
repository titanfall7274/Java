package thread.executer.future;

import java.util.Random;
import java.util.concurrent.*;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class CallableMainV1 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue><>());
        ExecutorService es = Executors.newFixedThreadPool(1);

        Future<Integer> future = es.submit(new MyCallable());
        Integer result = future.get();
        log("result value = " + result);

        System.out.println();
        Integer result2 = es.submit(new MyCallable()).get();
        log("result2 value = " + result);
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
