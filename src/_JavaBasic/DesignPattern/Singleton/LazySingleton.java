package src._JavaBasic.DesignPattern.Singleton;

public class LazySingleton {
    private static  LazySingleton INSTANCE;

    private LazySingleton(){

    }

    // 在方法处加锁，消耗很大
    public static synchronized LazySingleton getInstance(){
        if(INSTANCE==null){
            INSTANCE = new LazySingleton();
        }
        return INSTANCE;
    }



}
