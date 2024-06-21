package src._JavaBasic.MultiThread.ThreadSynchronizationDemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        // 初始化 CountDownLatch，计数器设置为 3
        // 这意味着主线程将等待三个工作线程完成它们的任务。
        // 如果设置成4，但是后续只开启了3个能够以latch--的线程，则4个预期完成不了，该线程不会执行。
        final CountDownLatch latch = new CountDownLatch(3);

        // 创建并启动三个线程执行任务
        for (int i = 0; i < 3; i++) {
            new Thread(new Worker(latch, i)).start();
        }

        // 主线程等待所有工作线程完成
        latch.await(); // 等待计数器递减到 0
        System.out.println("所有任务完成，主线程继续执行。");
    }
}

class Worker implements Runnable {
    private final CountDownLatch latch;
    private final int taskNumber;

    public Worker(CountDownLatch latch, int taskNumber) {
        this.latch = latch;
        this.taskNumber = taskNumber;
    }

    @Override
    public void run() {
        try {
            System.out.println("任务 " + taskNumber + " 正在执行。");
            // 模拟任务执行时间
            TimeUnit.SECONDS.sleep(2);
            System.out.println("任务 " + taskNumber + " 完成。");
            // 任务完成后，计数器递减
            latch.countDown();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
