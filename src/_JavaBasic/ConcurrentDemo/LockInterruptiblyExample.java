package src._JavaBasic.ConcurrentDemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;

public class LockInterruptiblyExample {

    public static void main(String[] args) throws InterruptedException {


        Warehouse warehouse = new Warehouse();

        // 创建第一个线程并启动，它将尝试访问仓库资源
        Thread thread1 = new Thread(() -> {
            try {
                warehouse.accessResource();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " was interrupted while waiting for the lock.");
            }
        }, "Thread-1");
        thread1.start();

        // 让第一个线程有时间去获取锁
        Thread.sleep(500);

        // 创建第二个线程，它也将尝试访问仓库资源，但会中断它
        Thread thread2 = new Thread(() -> {
            try {
                warehouse.accessResource();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " was interrupted while waiting for the lock.");
            }
        }, "Thread-2");
        thread2.start();

        // 中断第二个线程，因为它可能正在等待获取锁，因为第一个线程要Thread.sleep(2000);
        Thread.sleep(500);
        thread2.interrupt();

        // 等待第一个线程完成
        thread1.join();

    }




    // 仓库类，使用Lock来控制访问
    static class Warehouse {
        private final Lock lock = new ReentrantLock();
        private String resource = "Goods inside the warehouse"; // 仓库中的资源

        // 获取仓库资源的方法
        public void accessResource() throws InterruptedException {
//            lock.lock(); // 获取锁
            lock.lockInterruptibly(); // 可响应中断地获取锁
            try {
                // 模拟长时间的操作
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // 注意：这里不会响应中断，因为使用了lock()方法
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " accessed the resource: " + resource);
            } finally {
                lock.unlock(); // 释放锁
            }
        }
    }



}