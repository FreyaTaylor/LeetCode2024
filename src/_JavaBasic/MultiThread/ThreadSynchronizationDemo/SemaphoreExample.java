package src._JavaBasic.MultiThread.ThreadSynchronizationDemo;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static void main(String[] args) {
        // 创建一个 Semaphore 对象，初始许可数量为 3
        final Semaphore semaphore = new Semaphore(3);

        // 创建并启动多个线程，模拟对共享资源的访问
        for (int i = 0; i < 5; i++) {
            final int identifier = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        // 尝试获取一个许可
                        semaphore.acquire();
                        System.out.println("线程 " + identifier + " 获得了许可，正在访问资源。");

                        // 模拟使用资源的时间
                        Thread.sleep((long) (Math.random() * 5000));

                        // 释放许可
                        semaphore.release();
                        System.out.println("线程 " + identifier + " 释放了许可。");
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }).start();
        }
    }
}
