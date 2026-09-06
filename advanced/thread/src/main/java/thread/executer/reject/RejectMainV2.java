package thread.executer.reject;

import thread.executer.RunnableTask;

import java.util.concurrent.*;

import static thread.executer.ExecuterUtils.printState;
import static util.MyLogger.log;

public class RejectMainV2 {
    public static void main(String[] args) {
        ExecutorService es = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS
                , new SynchronousQueue<>(), new ThreadPoolExecutor.DiscardPolicy());

        es.submit(new RunnableTask("task1"));
        printState(es);
        
        try {
            es.submit(new RunnableTask("task2")); // 조용히 버려진다.
        } catch (RejectedExecutionException e) {
            log("요청 초과");
            log(e);
        }

        es.close();
    }
}
