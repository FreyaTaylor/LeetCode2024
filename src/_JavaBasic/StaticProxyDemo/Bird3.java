package src._JavaBasic.StaticProxyDemo;

public class Bird3 implements Flyable {

    /**
     * 聚合
     */
    private Bird bird;

    public Bird3(Bird bird) {
        this.bird = bird;
    }

    @Override
    public void fly() {
        long start = System.currentTimeMillis();

        bird.fly();

        long end = System.currentTimeMillis();
        System.out.println("Fly time = " + (end - start));
    }
}