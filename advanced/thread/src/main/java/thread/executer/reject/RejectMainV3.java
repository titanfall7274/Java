package thread.executer.reject;

import thread.executer.RunnableTask;

import java.util.concurrent.*;

import static thread.executer.ExecuterUtils.printState;
import static util.MyLogger.log;

public class RejectMainV3 {
    public static void main(String[] args) {
        ExecutorService es = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS
                , new SynchronousQueue<>(), new ThreadPoolExecutor.CallerRunsPolicy());

        es.submit(new RunnableTask("task1"));
        printState(es);

        es.submit(new RunnableTask("task2")); // 해당 요청을 보낸 스레드가 작업을 실행


        es.close();
    }
}
