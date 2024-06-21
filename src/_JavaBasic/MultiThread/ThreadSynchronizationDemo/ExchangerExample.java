package src._JavaBasic.MultiThread.ThreadSynchronizationDemo;

import java.util.concurrent.Exchanger;

public class ExchangerExample {
    public static void main(String[] args) {
        // 创建一个 Exchanger 对象
        Exchanger<String> exchanger = new Exchanger<>();

        // 创建两个线程，它们将通过 Exchanger 交换数据
        Thread thread1 = new Thread(new ExchangerThread(exchanger, "数据A"));
        Thread thread2 = new Thread(new ExchangerThread(exchanger, "数据B"));

        thread1.start();
        thread2.start();
    }
}

class ExchangerThread implements Runnable {
    private final Exchanger<String> exchanger;
    private final String data;

    public ExchangerThread(Exchanger<String> exchanger, String data) {
        this.exchanger = exchanger;
        this.data = data;
    }

    @Override
    public void run() {
        try {
            // 执行数据交换
            String receivedData = exchanger.exchange(data);
            System.out.println(Thread.currentThread().getName() + " 发送了: " + data + " 并接收了: " + receivedData);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
