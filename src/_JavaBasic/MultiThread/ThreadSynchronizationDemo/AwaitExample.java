package src._JavaBasic.MultiThread.ThreadSynchronizationDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AwaitExample {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private int sharedResource = 0;

    public void waitForResource() throws InterruptedException {
        lock.lock();
        try {
            while (sharedResource == 0) {
                System.out.println("Waiting for resource with await...");
                condition.await(); // 调用 await() 并释放锁
            }
            // 资源可用，执行操作
            sharedResource = 0; // 假设操作后资源被消耗
            System.out.println("Resource consumed with await.");
        } finally {
            lock.unlock();
        }
    }

    public void produceResource() {
        lock.lock();
        try {
            sharedResource = 1; // 假设生产了一个资源
            System.out.println("Resource produced with await.");
            condition.signal(); // 唤醒等待的线程
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        AwaitExample example = new AwaitExample();
        Thread consumer = new Thread(() -> {
            try {
                example.waitForResource();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread producer = new Thread(() -> {
            example.produceResource();
        });

        consumer.start();
        producer.start();
    }
}