package src._JavaBasic.MultiThread.ThreadPoolExecutorDemo;

import java.util.concurrent.*;

public class DynamicThreadPool {
    private static final int CORE_POOL_SIZE = 10;
    private static final int MAX_POOL_SIZE = 100;
    private static final int QUEUE_CAPACITY = 50;
    private static final int BUSY_RATIO = 70;

    private ThreadPoolExecutor executor;

    public DynamicThreadPool() {
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();
        this.executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                0L,
                TimeUnit.MILLISECONDS,
                workQueue
        );
    }

    public void execute(Runnable command) {
        executor.execute(command);
        dynamicAdjustPoolSize();
    }

    /**
     * dynamicAdjustPoolSize 方法是在 execute 方法中被调用的。
     * 每当你提交一个新任务给线程池时，execute 方法会被执行，
     * 随后会触发 dynamicAdjustPoolSize 方法来检查并根据当前的线程池状态动态调整线程数量。
     */
    private void dynamicAdjustPoolSize() {
        int activeCount = executor.getActiveCount();
        int queueSize = executor.getQueue().size();
        double busyRatio = (double) activeCount / executor.getCorePoolSize();

        if (queueSize > QUEUE_CAPACITY && busyRatio < BUSY_RATIO) {
            int newPoolSize = Math.min(executor.getCorePoolSize() + 5, MAX_POOL_SIZE);
            executor.setCorePoolSize(newPoolSize);
            System.out.println("Increased pool size to " + newPoolSize);
        }
    }

    public static void main(String[] args) {
        DynamicThreadPool dynamicThreadPool = new DynamicThreadPool();

        // 模拟提交任务
        for (int i = 0; i < 600; i++) {
            int finalI = i;
            dynamicThreadPool.execute(() -> {
                // 模拟任务执行
                System.out.println("Task " + finalI + " is running on thread " + Thread.currentThread().getName());
                // 模拟任务执行时间
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
    }
}
