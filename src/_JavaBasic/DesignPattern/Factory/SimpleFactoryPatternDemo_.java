package src._JavaBasic.DesignPattern.Factory;

import com.sun.jdi.PathSearchingVirtualMachine;

public class SimpleFactoryPatternDemo_ {

    public static void main(String[] args) {
        Xm c1 = (Xm) MyCarFactory.produce("xm");
        MyCar c2 = MyCarFactory.produce("jk"); //应该多采用这种，实现真正的解耦
        c1.running();
        c2.running();
    }
}

interface MyCar{
    void running();
}
class Jk implements MyCar{
    public void running(){
        System.out.println("jk is running");
    }
}

class Xm implements MyCar{
    public void running(){
        System.out.println("xm is running");
    }
}

class MyCarFactory{
    public static MyCar produce(String brand){
        if(brand.equals("jk")){
            return new Jk();
        }else if(brand.equals("xm")){
            return new Xm();
        }else {
            return null;
        }
    }
}
