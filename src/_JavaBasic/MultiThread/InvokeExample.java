package src._JavaBasic.MultiThread;




import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

class MyCallable implements Callable<Integer> {
    private final int taskNumber;

    MyCallable(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public Integer call() throws Exception {
        // 执行一些计算任务
        Thread.sleep(1000); // 模拟耗时操作
        return taskNumber * 10;
    }
}

public class InvokeExample {
    public static void main(String[] args) {
        // 创建一个固定大小的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // 提交一个Callable任务并获取Future对象
        Future<Integer> future = executorService.submit(new MyCallable(1));

        try {
            // 获取任务结果
            Integer result = future.get();
            System.out.println("Task result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // 关闭线程池
            executorService.shutdown();
        }

        // 提交多个Callable任务并获取Future对象列表
        ExecutorService executorServiceForAll = Executors.newFixedThreadPool(3);
        List<Callable<Integer>> tasks = Arrays.asList(
                new MyCallable(2),
                new MyCallable(3),
                new MyCallable(4)
        );
        try {
            // 提交任务列表并获取Future列表
            List<Future<Integer>> futures = executorServiceForAll.invokeAll(tasks);

            // 处理每个任务的结果
            for (Future<Integer> futureResult : futures) {
                Integer result = futureResult.get();
                System.out.println("Task result: " + result);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // 关闭线程池
            executorServiceForAll.shutdown();
        }
    }
}