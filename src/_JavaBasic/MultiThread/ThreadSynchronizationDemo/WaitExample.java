package src._JavaBasic.MultiThread.ThreadSynchronizationDemo;

public class WaitExample {
    private int sharedResource = 0;

    public synchronized void waitForResource() throws InterruptedException {
        while (sharedResource == 0) {
            System.out.println("Waiting for resource...");
            wait(); // 调用 wait() 并释放锁
        }
        // 资源可用，执行操作
        sharedResource = 0; // 假设操作后资源被消耗
        System.out.println("Resource consumed.");
    }

    public synchronized void produceResource() {
        sharedResource = 1; // 假设生产了一个资源
        System.out.println("Resource produced.");
        notify(); // 唤醒等待的线程
    }

    public static void main(String[] args) {
        WaitExample example = new WaitExample();
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