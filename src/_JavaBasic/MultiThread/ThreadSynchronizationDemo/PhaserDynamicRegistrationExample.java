package src._JavaBasic.MultiThread.ThreadSynchronizationDemo;

import java.util.concurrent.Phaser;



public class PhaserDynamicRegistrationExample {

        public static void main(String[] args) throws InterruptedException {
            // 创建一个Phaser实例，初始时注册3个线程（不包括主线程）
            Phaser phaser = new Phaser(3);

            // 创建并启动3个线程
            for (int i = 0; i < 3; i++) {
                int threadNum = i + 1; // 为了在输出中区分线程
                new Thread(() -> {
                    System.out.println("线程" + threadNum + "：已经准备好，等待其他线程。");

                    System.out.println("线程" + threadNum + "：第一阶段任务完成。");
                    // 线程在此等待，直到所有线程都到达这个屏障点
                    phaser.arriveAndAwaitAdvance();



                    // 模拟第二阶段的任务
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }

                    System.out.println("线程" + threadNum + "：第二阶段任务完成。");
                    // 再次到达屏障点，等待其他线程
                    phaser.arriveAndAwaitAdvance();



                    // 模拟第三阶段的任务
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }

                    System.out.println("线程" + threadNum + "：第三阶段任务完成，Phaser任务结束。");
                    // 最后一次到达屏障点，所有线程都完成后Phaser将自动进入终止状态
                    phaser.arriveAndAwaitAdvance();


                }).start();
            }

            phaser.awaitAdvance(phaser.getPhase());
            System.out.println("所有线程的第一阶段任务完成。");

            // phaser.awaitAdvance(phaser.getPhase() + 1);
            // 会立即返回而不是等待，因为它认为传入的参数阶段已经超出了当前阶段。
            phaser.awaitAdvance(phaser.getPhase());
            System.out.println("所有线程的第二阶段任务完成。");

            phaser.awaitAdvance(phaser.getPhase());
            System.out.println("所有线程的第三阶段任务完成，整个任务结束。");
        }
    }
