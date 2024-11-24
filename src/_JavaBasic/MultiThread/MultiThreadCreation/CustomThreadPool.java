package src._JavaBasic.MultiThread.MultiThreadCreation;

import java.util.concurrent.*;

public class CustomThreadPool {

    public static void main(String[] args) {
        // 自定义线程池参数
        int corePoolSize = 5;        // 核心线程数
        int maximumPoolSize = 10;    // 最大线程数
        long keepAliveTime = 2;      // 非核心线程空闲存活时间（单位：秒）
        TimeUnit unit = TimeUnit.SECONDS; // 时间单位
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(20); // 工作队列
        ThreadFactory threadFactory = new CustomThreadFactory(); // 线程工厂
        RejectedExecutionHandler handler = new CustomRejectedExecutionHandler(); // 拒绝策略

        // 创建自定义线程池
        ExecutorService executorService = new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                unit,
                workQueue,
                threadFactory,
                handler
        );

        // 提交任务到线程池
        for (int i = 0; i < 15; i++) {
            int finalI = i;
            executorService.submit(() -> {
                System.out.println("执行任务: " + finalI + ", 线程: " + Thread.currentThread().getName());
            });
        }

        // 关闭线程池
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }

    // 自定义线程工厂CustomThreadFactory，用于设置线程名称、优先级和守护状态。
    static class CustomThreadFactory implements ThreadFactory {
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setName("Custom-Thread-" + t.getId());
            t.setPriority(Thread.NORM_PRIORITY);
            t.setDaemon(true);
            return t;
        }
    }

    // 当任务不能被执行时，将任务打印出来，并尝试在调用者线程中运行它。
    static class CustomRejectedExecutionHandler implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("任务 " + r.toString() + " 被拒绝.");
            if (!executor.isShutdown()) {
                r.run();
            }
        }
    }
}