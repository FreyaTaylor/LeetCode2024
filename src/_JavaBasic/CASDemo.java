package src._JavaBasic;

import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        // 线程1，对共享变量进行增加操作
        Thread thread1 = new Thread(() -> {
            int newValue = atomicInteger.incrementAndGet();
            System.out.println(Thread.currentThread().getName() + " incremented value to: " + newValue);
        });

        // 线程2，对共享变量进行增加操作
        Thread thread2 = new Thread(() -> {
            int newValue = atomicInteger.incrementAndGet();
            System.out.println(Thread.currentThread().getName() + " incremented value to: " + newValue);
        });

        thread1.start();
        thread2.start();
        System.out.println(atomicInteger);
        thread1.join();
        System.out.println(atomicInteger);
        thread2.join();
        System.out.println(atomicInteger);
    }
}