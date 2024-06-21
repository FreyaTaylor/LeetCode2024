package src._JavaBasic.MultiThread.ThreadSynchronizationDemo;

import java.util.concurrent.Phaser;

public class PhaserRegisterExample {



    static class Worker implements Runnable {
        private final Phaser phaser;
        private final int workerNumber;

        public Worker(Phaser phaser, int workerNumber) {
            this.phaser = phaser;
            this.workerNumber = workerNumber;
        }

        @Override
        public void run() {
            try {
                System.out.println("Worker " + workerNumber + " 正在执行任务。");
                // 模拟工作线程的工作
                Thread.sleep((int) (Math.random() * 1000));

                // 参与者到达屏障点
                phaser.arriveAndAwaitAdvance();
                System.out.println("Worker " + workerNumber + " 完成了任务，当前阶段: " + phaser.getPhase());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }


    public static void main(String[] args) {
        // 创建一个 Phaser，初始参与者数量为 2
        Phaser phaser = new Phaser(2);

        // 创建两个初始工作线程
        for (int i = 1; i <= 2; i++) {
            new Thread(new Worker(phaser, i), "Worker-" + i).start();
        }

        phaser.awaitAdvance(phaser.getPhase()); // 等待直到参与者数量达到 3 并且所有参与者都到达
        // 此时所有工作线程都已启动，并且 Phaser 已经进入下一个阶段
        System.out.println("所有参与者都已到达，当前阶段---: " + phaser.getPhase()+phaser.getRegisteredParties());

        // 主线程在第一个阶段增加一个参与者
        phaser.register(); // 增加参与者数量

        // 创建第三个工作线程
        new Thread(new Worker(phaser, 3), "Worker-3").start();

        for (int i = 1; i <= 2; i++) {
            new Thread(new Worker(phaser, i), "Worker-" + i).start();
        }

        System.out.println(phaser.getRegisteredParties());


        // 主线程等待所有参与者完成第一个阶段
        phaser.awaitAdvance(phaser.getPhase()); // 等待直到参与者数量达到 3 并且所有参与者都到达
        // 此时所有工作线程都已启动，并且 Phaser 已经进入下一个阶段
        System.out.println("所有参与者都已到达，当前阶段: " + phaser.getPhase()+phaser.getRegisteredParties());
    }





}

