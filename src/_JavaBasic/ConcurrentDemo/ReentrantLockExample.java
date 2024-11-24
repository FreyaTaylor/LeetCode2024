package src._JavaBasic.ConcurrentDemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    // 创建一个 ReentrantLock 对象
    private final Lock lock = new ReentrantLock();

    public void performAction() {
        // 尝试获取锁
        lock.lock();
        try {
            // 执行同步代码
            System.out.println("Action performed by " + Thread.currentThread().getName());
            // 模拟一些操作
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 释放锁
            lock.unlock();
        }
    }

    public static void main(String[] args) {
//        ReentrantLockExample example = new ReentrantLockExample();
//        Thread thread1 = new Thread(() -> example.performAction(), "Thread-1");
//        Thread thread2 = new Thread(() -> example.performAction(), "Thread-2");
//
//        thread1.start();
//        thread2.start();






    }
}
