package src._JavaBasic.MultiThread.ThreadSynchronizationDemo;

import java.util.concurrent.*;

public class CallerRunsPolicyExample {
    public static void main(String[] args) {
        // 创建一个固定大小的线程池
        ExecutorService executor = new ThreadPoolExecutor(
                2, // 核心线程数
                2, // 最大线程数
                0L, // 非核心线程空闲时间
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(2) // 任务队列容量为2
        );

        // 设置拒绝策略为 CallerRunsPolicy
        ((ThreadPoolExecutor) executor).setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        // 提交4个任务到线程池，前两个将由线程池中的线程执行
        for (int i = 0; i < 4; i++) {
            int finalI = i;
            executor.execute(() -> {
                System.out.println("执行任务: " + finalI + " 由线程 " + Thread.currentThread().getName());
            });
        }
    }
}
