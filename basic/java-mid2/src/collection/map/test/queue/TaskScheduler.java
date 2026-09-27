package collection.map.test.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class TaskScheduler {

    Queue<Task> tasks = new ArrayDeque<>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public int getRemainingTasks() {
        return tasks.size();
    }

    public void processNextTask() {
        Task task = tasks.poll();
        if (task != null) {
            task.execute();
        }
    }
}
