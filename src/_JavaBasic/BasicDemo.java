package src._JavaBasic;

public class BasicDemo {

    public static void main(String[] args) {
        Cat cat1 = new Cat("a",1,new People("1",10));
        Cat cat2 = new Cat("a",1,new People("1",10));

        System.out.println(cat1);
        System.out.println(cat2);

//        System.out.println(cat1.toString());
//        System.out.println(cat2.toString());

        System.out.println(cat1.hashCode());
        System.out.println(cat2.hashCode());

        System.out.println(cat1.equals(cat2));


    }
}
