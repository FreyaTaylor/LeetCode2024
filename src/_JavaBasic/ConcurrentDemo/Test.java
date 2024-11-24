package src._JavaBasic.ConcurrentDemo;

public class Test {
    // 声明一个 volatile 变量，确保每次访问时都会从主内存中读取
    public volatile int inc = 0;

    // 增加 inc 的值的方法
    public void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final Test test = new Test();

        // 创建并启动多个线程来增加 inc 的值
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        test.increase();
                    }
                }
            }).start();
        }

        // 等待所有线程完成
        while (Thread.activeCount() > 1) {
            // 让当前线程让出CPU时间片，以便其他线程可以运行
            Thread.yield();
        }

        // 打印最终的 inc 值
        System.out.println(test.inc);
    }
}