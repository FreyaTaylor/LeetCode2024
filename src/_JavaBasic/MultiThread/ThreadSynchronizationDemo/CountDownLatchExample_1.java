package src._JavaBasic.MultiThread.ThreadSynchronizationDemo;


import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample_1 {
    public static void main(String[] args) throws InterruptedException {
        final int threadCount = 5; // 假设我们有5个线程需要同步
        final CountDownLatch latch = new CountDownLatch(threadCount);

        // 创建并启动线程
        for (int i = 0; i < threadCount; i++) {
            int finalI = i; // 用于线程安全地在 lambda 表达式中使用变量 i
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        // 模拟线程工作
                        System.out.println("线程 " + finalI + " 达到同步点之前。");
                        Thread.sleep((int) (Math.random() * 1000)); // 随机等待
                        latch.countDown(); // 线程完成任务，减少计数器
                        System.out.println("线程 " + finalI + " 达到同步点。");
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }).start();
        }

        // 等待所有线程达到同步点
        latch.await();
        System.out.println("所有线程都达到了同步点，继续主线程的执行。");
    }
}