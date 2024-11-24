package src._JavaBasic.MultiThread.MultiThreadCreation;

import java.util.concurrent.*;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int result = 0;
        for (int i = 0; i < 5; i++) {
            result += i;
            System.out.println(Thread.currentThread().getName() + " 计算: " + i);
            Thread.sleep(100);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
//        // 创建线程池
//        ExecutorService executor = Executors.newFixedThreadPool(2);
//        // 提交MyCallable任务1
//        Future<Integer> future1 = executor.submit(new MyCallable());
//        // 提交MyCallable任务2
//
//        // 注意到：1和2无法并行，但是两个1，两个2是可以并行的
//        Future<?> future2 = executor.submit(new Callable<Object>() {
//            @Override
//            public Object call() throws Exception {
//                for (int i = 0; i < 50; i++) {
//                    System.out.println("线程2输出: " + i);
//                }
//                return null;
//            }
//        });
//        executor.shutdown();
//
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> future1 = executor.submit(new MyCallable());
        Future<Integer> future2 = executor.submit(new MyCallable());


        System.out.println("结果1: " + future1.get());
        System.out.println("结果2: " + future2.get());

        executor.shutdown();


        // Thread t1 = new Thread(new MyCallable()); 不行
//        FutureTask<Integer> ft = new FutureTask<>(new MyCallable());

        // 手动启动FutureTask
        new Thread(new FutureTask<>(new MyCallable())).start();

//        System.out.println(ft.get());
//
//        // 或者，将FutureTask提交给线程池执行
//        ExecutorService executor = Executors.newSingleThreadExecutor();
//        executor.execute(ft);
//
//        executor.submit(new MyCallable());
//        // executor.execute(new MyCallable()); 不行


    }
}
