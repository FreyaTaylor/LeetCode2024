package src._JavaBasic;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

public class ReferenceDemo {
    public static void main(String[] args) {
        // 创建引用队列
        ReferenceQueue<Object> queue = new ReferenceQueue<>();

        // 创建一个软引用，指向一个对象，并与引用队列关联
        Object object = new Object();
        SoftReference<Object> softReference = new SoftReference<>(object, queue);

        // 清除强引用
        object = null;

        // 假设触发了垃圾回收
        System.gc();

        // 等待软引用所指向的对象被回收，并被放入引用队列
        Reference<?> polledRef = queue.poll();
        while (polledRef == null) {
            // 可以在这里执行其他工作，或者简单地休眠
            try {
                Thread.sleep(100);
                polledRef = queue.remove(100); // 等待最多100毫秒
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // 检查队列中的引用是否是我们的软引用
        if (polledRef == softReference) {
            System.out.println("对象已被垃圾回收");
        }

        // 清理软引用
        softReference.clear();
    }
}