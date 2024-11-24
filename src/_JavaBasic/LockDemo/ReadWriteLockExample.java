package src._JavaBasic.LockDemo;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {
    private int data;
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void readData() {
        readWriteLock.readLock().lock();
        try {
            // 模拟读操作
            System.out.println(Thread.currentThread().getName() + " is reading data: " + data);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public void writeData(int data) {
        readWriteLock.writeLock().lock();
        try {
            // 模拟写操作
            this.data = data;
            System.out.println(Thread.currentThread().getName() + " is writing data: " + data);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteLockExample example = new ReadWriteLockExample();
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> example.readData(), "Read-Thread-" + finalI).start();
        }
        new Thread(() -> example.writeData(10), "Write-Thread-1").start();
    }
}
