package src._JavaBasic.ProxyDemo;

public class Test {

    public static void main(String[] args) {
        Bird bird = new Bird();
        BirdLogProxy p1 = new BirdLogProxy(bird);
        BirdTimeProxy p2 = new BirdTimeProxy(p1);

        p2.fly();
        System.out.println("---------------------------------------");


        bird = new Bird();
        p2 = new BirdTimeProxy(bird);
        p1 = new BirdLogProxy(p2);

        p1.fly();
        System.out.println("---------------------------------------");

    }
}
