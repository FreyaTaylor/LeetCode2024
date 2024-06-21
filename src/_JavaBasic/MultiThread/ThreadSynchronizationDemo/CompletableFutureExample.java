package src._JavaBasic.MultiThread.ThreadSynchronizationDemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {

    public static void main(String[] args) {
        // 任务 1，不依赖于其他任务，立即执行
        CompletableFuture<Void> task1 = CompletableFuture.runAsync(() -> {
            System.out.println("执行任务 1");
            // 模拟一些工作
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // 任务 2，依赖于任务 1
        CompletableFuture<Void> task2 = task1.thenRun(() -> {
            System.out.println("执行任务 2");
            // 模拟一些工作
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // 任务 3，也依赖于任务 1
        CompletableFuture<Void> task3 = task1.thenRun(() -> {
            System.out.println("执行任务 3");
            // 模拟一些工作
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // 任务 4，依赖于任务 2
        CompletableFuture<Void> task4 = task2.thenRun(() -> {
            System.out.println("执行任务 4");
            // 模拟一些工作
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // 任务 5，需要等待任务 3 和 4 都完成
        CompletableFuture<Void> task5 = CompletableFuture.allOf(task3, task4).thenRun(() -> {
            System.out.println("执行任务 5");
            // 模拟一些工作
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // 等待任务 5 完成（或任意任务失败）
        try {
            task5.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}