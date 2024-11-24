package src._JavaBasic.ConcurrentDemo;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    private final ReentrantLock lock = new ReentrantLock();
    private int sharedResource = 0;

    public void incrementResource() {
        lock.lock(); // 获取锁
        try {
            // 第一次操作资源
            sharedResource++;
            System.out.println("Incremented to: " + sharedResource);

            // 再次操作资源，需要重新获取锁
            lock.lock(); // 由于是同一个线程，state 会再次加1
            try {
                sharedResource++;
                System.out.println("Incremented to: " + sharedResource);
            } finally {
                lock.unlock(); // 释放锁，state 减1
                System.out.println("Incremented to: " + sharedResource);
            }

            // 执行其他操作
        } finally {
            // 最终释放锁，state 减1
            lock.unlock(); // 此时state 减到0，其他线程可以获取锁
            System.out.println("Incremented to: " + sharedResource);
        }
    }

    public static void main(String[] args) {
        ReentrantLockDemo demo = new ReentrantLockDemo();
        Thread thread = new Thread(() -> demo.incrementResource());
        thread.start();


    }
}
