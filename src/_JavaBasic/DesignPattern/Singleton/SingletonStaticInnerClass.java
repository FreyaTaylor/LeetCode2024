package src._JavaBasic.DesignPattern.Singleton;

public class SingletonStaticInnerClass {


    private SingletonStaticInnerClass(){

    }

    // 对于InnerClass的属性来说，SingletonStaticInnerClass是类被创建时创建的，与饿汉类似
    // 但是类的加载时机是getInstance方法被调用
    // 因此：也是按需创建，但是使用类加载机制保证了线程安全
    public static SingletonStaticInnerClass getInstance(){
        return InnerClass.INSTANCE;
    }

    static class InnerClass{
        private static SingletonStaticInnerClass INSTANCE = new SingletonStaticInnerClass();
    }


}
