package src._JavaBasic.MultiThread.MultiThreadCreation;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;
import java.util.concurrent.RecursiveTask;


public class ForkJoinDemo {
    // 1. 运行入口
    public static void main(String[] args) {
        int n = 20; // 计算斐波那契数列的第n项
        // 为了追踪子线程名称，需要重写 ForkJoinWorkerThreadFactory 的方法
        final ForkJoinPool.ForkJoinWorkerThreadFactory factory = pool -> {
            final ForkJoinWorkerThread worker = ForkJoinPool.defaultForkJoinWorkerThreadFactory.newThread(pool);
            worker.setName("my-thread" + worker.getPoolIndex()); // 设置线程名称
            return worker;
        };
        // 创建分治任务线程池，可以追踪到线程名称
        ForkJoinPool forkJoinPool = new ForkJoinPool(4, factory, null, false);
        // 创建分治任务
        Fibonacci fibonacci = new Fibonacci(n);
        // 调用 invoke 方法启动分治任务
        Integer result = forkJoinPool.invoke(fibonacci);

    }
}

// 2. 定义拆分任务，写好拆分逻辑
class Fibonacci extends RecursiveTask<Integer> {
    final int n; // 斐波那契数列的索引

    Fibonacci(int n) {
        this.n = n;
    }

    @Override
    public Integer compute() {
        // 和递归类似，定义可计算的最小单元
        if (n <= 1) {
            return n;
        }
        // 拆分成子任务
        Fibonacci f1 = new Fibonacci(n - 1);
        f1.fork(); // 异步执行子任务f1
        Fibonacci f2 = new Fibonacci(n - 2);
        // 同步执行子任务f2并等待结果
        int result = f2.compute() + f1.join(); // 等待f1执行完毕并获取结果
        return result;
    }
}
