package src._JavaBasic.MultiThread.ThreadSynchronizationDemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


//        // 任务 1，不依赖于其他任务，立即执行
//        CompletableFuture<Void> task1 = CompletableFuture.runAsync(() -> {
//            System.out.println("执行任务 1");
//            // 模拟一些工作
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        // 任务 2，依赖于任务 1
//        CompletableFuture<Void> task2 = task1.thenRun(() -> {
//            System.out.println("执行任务 2");
//            // 模拟一些工作
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        // 任务 3，也依赖于任务 1
//        CompletableFuture<Void> task3 = task1.thenRun(() -> {
//            System.out.println("执行任务 3");
//            // 模拟一些工作
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        // 任务 4，依赖于任务 2
//        CompletableFuture<Void> task4 = task2.thenRun(() -> {
//            System.out.println("执行任务 4");
//            // 模拟一些工作
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        // 任务 5，需要等待任务 3 和 4 都完成
//        CompletableFuture<Void> task5 = CompletableFuture.allOf(task3, task4).thenRun(() -> {
//            System.out.println("执行任务 5");
//            // 模拟一些工作
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        // 等待任务 5 完成（或任意任务失败）
//        try {
//            task5.get();
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }


        CompletableFuture<String> future = CompletableFuture.completedFuture("hello!")
                .thenApply(s -> s + "world!");
        System.out.println(future.get()); // hello!world!

        // 这次调用将被忽略。
        future.thenApply(s -> s + "nice!");
        System.out.println(future.get()); // hello!world!


        CompletableFuture<String> future1 = CompletableFuture.completedFuture("hello!")
                .thenApply(s -> s + "world!").thenApply(s -> s + "nice!");
        System.out.println(future1.get()); // hello!world!nice!


//        CompletableFuture.completedFuture("hello!")
//                .thenApply(s -> s + "world!").thenApply(s -> s + "nice!").thenAccept(System.out::println);//hello!world!nice!
//
//        CompletableFuture.completedFuture("hello!")
//                .thenApply(s -> s + "world!").thenApply(s -> s + "nice!").thenRun(() -> System.out.println("hello!"));//hello!


//        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "hello world");
//
//        // thenApply
//        CompletableFuture<String> upperCaseFuture = future.thenApply(String::toUpperCase);
//        System.out.println(upperCaseFuture.get()); // HELLO WORLD
//
//        // thenAccept
//        CompletableFuture<Void> printlineFuture = upperCaseFuture.thenAccept(result -> System.out.println("Converted Result: " + result));
//        System.out.println(printlineFuture.get()); // null


    }
}