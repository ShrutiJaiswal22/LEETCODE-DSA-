import java.util.*;

class TaskManager {
    private static class Task {
        int userId, taskId, priority;
        Task(int u, int t, int p) {
            userId = u; taskId = t; priority = p;
        }
    }

    // Max-heap: higher priority first, if tie -> higher taskId
    private PriorityQueue<Task> maxHeap;
    // Maps taskId -> [userId, priority]
    private Map<Integer, int[]> taskMap;

    public TaskManager(List<List<Integer>> tasks) {
        maxHeap = new PriorityQueue<>((a, b) -> {
            if (a.priority != b.priority) return b.priority - a.priority;
            return b.taskId - a.taskId;
        });
        taskMap = new HashMap<>();

        for (List<Integer> t : tasks) {
            int userId = t.get(0), taskId = t.get(1), priority = t.get(2);
            taskMap.put(taskId, new int[]{userId, priority});
            maxHeap.offer(new Task(userId, taskId, priority));
        }
    }

    public void add(int userId, int taskId, int priority) {
        taskMap.put(taskId, new int[]{userId, priority});
        maxHeap.offer(new Task(userId, taskId, priority));
    }

    public void edit(int taskId, int newPriority) {
        int[] info = taskMap.get(taskId);
        int userId = info[0];
        // update in map
        taskMap.put(taskId, new int[]{userId, newPriority});
        // push updated version into heap
        maxHeap.offer(new Task(userId, taskId, newPriority));
    }

    public void rmv(int taskId) {
        taskMap.remove(taskId);
        // lazy deletion (old heap entries ignored later)
    }

    public int execTop() {
        while (!maxHeap.isEmpty()) {
            Task top = maxHeap.poll();
            if (!taskMap.containsKey(top.taskId)) continue; // removed
            int[] info = taskMap.get(top.taskId);
            int userId = info[0], priority = info[1];
            // ensure both userId and priority match the latest map entry
            if (userId != top.userId || priority != top.priority) continue;
            // valid task -> remove & return userId
            taskMap.remove(top.taskId);
            return userId;
        }
        return -1; // no tasks available
    }
}
