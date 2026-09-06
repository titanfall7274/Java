package thread.executer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

import static util.MyLogger.log;

public abstract class ExecuterUtils {

    public static void printState(ExecutorService executerService) {
        // 캐스팅 생략
        if(executerService instanceof ThreadPoolExecutor poolExecutor) {
            int pool = poolExecutor.getPoolSize();
            int active = poolExecutor.getActiveCount();
            int queuedTasks = poolExecutor.getQueue().size();
            long completedTask = poolExecutor.getCompletedTaskCount();
            log("[pool = " + pool + ", active= " + active + "," +
                    " queuedTask= " + queuedTasks + ", completedTask= " + completedTask + "]");
        } else {
            log(executerService); // 구현체가 다른 경우
        }
    }

    public static void printState(ExecutorService executerService, String taskName) {
        // 캐스팅 생략
        if(executerService instanceof ThreadPoolExecutor poolExecutor) {
            int pool = poolExecutor.getPoolSize();
            int active = poolExecutor.getActiveCount();
            int queuedTasks = poolExecutor.getQueue().size();
            long completedTask = poolExecutor.getCompletedTaskCount();
            log(taskName + "[pool = " + pool + ", active= " + active + "," +
                    " queuedTask= " + queuedTasks + ", completedTask= " + completedTask + "]");
        } else {
            log(executerService); // 구현체가 다른 경우
        }
    }
}
