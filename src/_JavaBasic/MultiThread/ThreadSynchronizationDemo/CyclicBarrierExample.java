package src._JavaBasic.MultiThread.ThreadSynchronizationDemo;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        // 初始化 CyclicBarrier，需要等待的线程数为 4
        final CyclicBarrier barrier = new CyclicBarrier(4, () -> {
            System.out.println("所有线程都已到达屏障点，可以继续执行。");
        });

//        final CyclicBarrier barrier = new CyclicBarrier(4);
                // 创建并启动四个线程执行任务
        for (int i = 0; i < 4; i++) {
            new Thread(new Worker(barrier, i)).start();
        }
    }


    static class Worker implements Runnable {
        private final CyclicBarrier barrier;
        private final int workerNumber;

        public Worker(CyclicBarrier barrier, int workerNumber) {
            this.barrier = barrier;
            this.workerNumber = workerNumber;
        }

        @Override
        public void run() {
            try {
                System.out.println("Worker " + workerNumber + " 正在执行任务。");
                // 模拟任务执行时间
                TimeUnit.SECONDS.sleep((int)(Math.random() * 3));
                // 等待其他线程到达屏障点
                barrier.await();
                System.out.println("Worker " + workerNumber + " 通过了屏障点，继续执行。");
                // 执行通过屏障点后的任务
                TimeUnit.SECONDS.sleep((int)(Math.random() * 3));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

