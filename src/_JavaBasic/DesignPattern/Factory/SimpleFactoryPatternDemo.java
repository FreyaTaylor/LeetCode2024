package src._JavaBasic.DesignPattern.Factory;

public class SimpleFactoryPatternDemo {




    public static void main(String[] args) {
        SimpleFactoryPatternDemo demo = new SimpleFactoryPatternDemo();
        CarFactory factory = new CarFactory();

        Car car1 = factory.createCar("audi");
        Car car2 = factory.createCar("bmw");

        car1.assemble();
        car2.assemble();
    }
}

// 产品接口
interface Car {
    void assemble();
}

// 具体产品
class Audi implements Car {
    public void assemble() {
        System.out.println("Audi car is being assembled.");
    }
}

class Bmw implements Car {
    public void assemble() {
        System.out.println("BMW car is being assembled.");
    }
}

// 简单工厂
class CarFactory {
    public Car createCar(String type) {
        if (type == null) {
            return null;
        }
        switch (type.toLowerCase()) {
            case "audi":
                return new Audi();
            case "bmw":
                return new Bmw();
            default:
                return null;
        }
    }
}