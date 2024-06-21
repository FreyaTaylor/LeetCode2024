package src._JavaBasic.MultiThread.ThreadSynchronizationDemo;

import java.util.concurrent.Phaser;

public class PhaserArriveAndDeregisterExample {
    public static void main(String[] args) {
        // 创建一个 Phaser，初始参与者数量为 3
        Phaser phaser = new Phaser(3);

        // 创建三个工作线程
        for (int i = 1; i <= 3; i++) {
            int workerId = i;
            new Thread(() -> {
                try {
                    // 执行工作
                    System.out.println("Worker " + workerId + " is working-1.");
                    Thread.sleep((long) (Math.random() * 200));

                    // 工作完成后，调用 arriveAndDeregister 减少参与者数量
                    if(workerId==1){
                        phaser.arriveAndDeregister();
                        System.out.println("Worker " + workerId + " has finished and deregistered.");
                    }else {
                        phaser.arrive();
                        System.out.println("Worker " + workerId + " has finished.");
                    }


                    // 执行工作
                    System.out.println("Worker " + workerId + " is working-2.");
                    Thread.sleep((long) (Math.random() * 200));

                    phaser.arrive();
                    System.out.println("Worker " + workerId + " has finished.");



                    // 可以选择在这里继续执行或退出
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }).start();
        }

        phaser.awaitAdvance(phaser.getPhase());
        System.out.println("所有线程的第一阶段任务完成。");

        // phaser.awaitAdvance(phaser.getPhase() + 1);
        // 会立即返回而不是等待，因为它认为传入的参数阶段已经超出了当前阶段。
        phaser.awaitAdvance(phaser.getPhase());
        System.out.println("所有线程的第二阶段任务完成。");

        // 此时参与者数量已经减少到 1，可以进行其他操作
        System.out.println("All workers have finished their tasks, current phase is " + phaser.getPhase());
    }
}