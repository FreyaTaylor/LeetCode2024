package src._JavaBasic;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NotifyTest1 {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public void testWait() {
        lock.lock(); // 加锁
        try {
            System.out.println(Thread.currentThread().getName() + " Start-----");
            try {
                condition.await(); // 使用Condition对象进行等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " End-------");
        } finally {
            lock.unlock(); // 释放锁
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final NotifyTest1 test = new NotifyTest1();
        for(int i = 0; i < 5; i++) {
            new Thread(() -> {
                test.testWait();
            }).start();
        }

        test.lock.lock(); // 加锁
        try {
            test.condition.signal(); // 使用Condition对象进行唤醒
        } finally {
            test.lock.unlock(); // 释放锁
        }
        Thread.sleep(3000);
        System.out.println("-----------分割线-------------");

        test.lock.lock(); // 加锁
        try {
            test.condition.signalAll(); // 使用Condition对象进行唤醒
        } finally {
            test.lock.unlock(); // 释放锁
        }
    }
}
