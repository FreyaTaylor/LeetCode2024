package src._JavaBasic.DesignPattern.Singleton;

public class LazySingleton_doubleCheckingLocking {

    private static  volatile LazySingleton_doubleCheckingLocking INSTANCE;

    private LazySingleton_doubleCheckingLocking(){

    }

    // 在方法处加锁，消耗很大
    // 双重校验锁，只在需要初始化时候加锁
    public static LazySingleton_doubleCheckingLocking getInstance(){
        if(INSTANCE==null) {
            // 如果此时不二次校验，相当于还是会生成多个INSTANCE，因为多个线程可以走的这段代码里面
            synchronized (LazySingleton_doubleCheckingLocking.class) {
                if (INSTANCE == null) {

                    INSTANCE = new LazySingleton_doubleCheckingLocking();
                    /**
                    1 分配内存空间
                    2 初始化对象
                    3 将对象指向刚分配的内存空间（不为空）

                     因为编译器会指令重排，因此可能以1 3 2 的顺序执行，
                     另一个getInstance()可能会得到初始化未完成的对象
                     因此需要 volatile 禁止指令重排
                     */
                }
            }
        }

        return INSTANCE;
    }

}
