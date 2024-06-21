package src._JavaBasic.MultiThread.ThreadSynchronizationDemo;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierReusabilityExample {
    public static void main(String[] args) {
        final int numberOfThreads = 4;
        final CyclicBarrier barrier = new CyclicBarrier(numberOfThreads);

        // 创建并启动多个线程
        for (int i = 0; i < numberOfThreads; i++) {
            new Thread(new Worker(barrier, i), "Worker-" + i).start();
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
                // 执行任务
                System.out.println("Worker " + workerNumber + " is working-1.");
                TimeUnit.SECONDS.sleep((int) (Math.random() * 4));
                // 到达屏障点
                barrier.await();
                System.out.println("Worker " + workerNumber + " is working-2.");
                TimeUnit.SECONDS.sleep((int) (Math.random() * 4));
                // 到达屏障点
                barrier.await();
                System.out.println("Worker " + workerNumber + " is working-3.");
                TimeUnit.SECONDS.sleep((int) (Math.random() * 4));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


