package src._JavaBasic.MultiThread.MultiThreadCreation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " 输出: " + i);
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable());
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("线程2输出: " + i);
                }
            }
        });
        t2.start();


        // 示例中，使用Lambda表达式创建了一个匿名的Runnable实例，然后将其传递给Thread构造函数。
        // Lambda表达式可以被看作是匿名内部类的简洁形式，
        // 特别是在实现只有一个抽象方法的接口时。
        // 在Java中，Runnable接口只有一个抽象方法run，所以Lambda表达式可以直接实现这个方法。
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("线程3输出: " + i);
            }
        });
        t3.start();




        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(new MyRunnable());
        executor.execute(new MyRunnable());
        executor.execute(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("线程4输出: " + i);
            }
        });

        executor.shutdown();

    }
}
