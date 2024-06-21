package src._JavaBasic.MultiThread.ThreadSynchronizationDemo;

public class ThreadLocalThread extends Thread {
    private final ThreadLocalExample example;

    public ThreadLocalThread(ThreadLocalExample example) {
        this.example = example;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            example.updateValue(); // 更新当前线程的值
        }
    }

    public static void main(String[] args) {
        ThreadLocalExample example = new ThreadLocalExample();

        // 创建并启动多个线程，它们将共享ThreadLocalExample实例
        ThreadLocalThread thread1 = new ThreadLocalThread(example);
        ThreadLocalThread thread2 = new ThreadLocalThread(example);

        thread1.start();
        thread2.start();
    }
}


class ThreadLocalExample {
    // 使用ThreadLocal来为每个线程创建一个唯一的值
    private static final ThreadLocal<Integer> threadLocalValue = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0; // 为每个线程提供一个初始值
        }
    };

    public void updateValue() {
        int value = threadLocalValue.get(); // 获取当前线程的值
        value++; // 增加值
        threadLocalValue.set(value); // 设置当前线程的新值
        System.out.println("Thread " + Thread.currentThread().getName() + " has value " + value);
    }
}