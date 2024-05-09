package src._NoLeetCode.Singleton;

public class DoubleCheckedSingleton {

    private static volatile DoubleCheckedSingleton INSTANCE;

    private DoubleCheckedSingleton(){

    }

    public static DoubleCheckedSingleton getInstance(){
        if(INSTANCE==null){
            synchronized (DoubleCheckedSingleton.class){
                if(INSTANCE==null){
                    INSTANCE = new DoubleCheckedSingleton();

                }
            }
        }

        return INSTANCE;
    }


}
