package src._JavaBasic;


public class NotifyTest {
    /**
     * testWait()方法使用了synchronized关键字修饰，表示这是一个同步方法，
     * 该方法首先打印线程名字并输出"Start-----"，然后调用了wait(0)方法，使线程进入等待状态，
     * 等待其他线程调用notify()或notifyAll()来唤醒。
     */
    public synchronized void testWait(){
        System.out.println(Thread.currentThread().getName() +" Start-----");
        try {
            wait(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() +" End-------");
    }

    public static void main(String[] args) throws InterruptedException {
        /**
         * main方法中创建了一个NotifyTest对象test，并启动了5个线程，
         * 每个线程都调用test对象的testWait()方法，
         * 因为testWait()方法是同步方法，所以这5个线程会依次进入等待状态。
         */
        final NotifyTest test = new NotifyTest();
        for(int i=0;i<5;i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    test.testWait();
                }
            }).start();
        }

        /**
         * 在主线程中，先使用synchronized块对test对象加锁，
         * 然后调用test对象的notify()方法，这会随机唤醒一个等待test对象锁的线程。
         * -- 在调用notify()方法之前必须对对象进行加锁
         *
         * 不用 synchronized
         * current thread is not owner
         */
        synchronized (test) {
            test.notify();
        }
//        test.notify();

        Thread.sleep(3000);
        System.out.println("-----------分割线-------------");

        synchronized (test) {
            test.notifyAll();
        }
    }
}