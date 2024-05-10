package src._JavaBasic.StaticProxyDemo;

public class Bird2 extends Bird {
    /**
     * 使用继承
     */
    @Override
    public void fly() {
        long start = System.currentTimeMillis();

        super.fly();

        long end = System.currentTimeMillis();
        System.out.println("Fly time = " + (end - start));
    }
}
