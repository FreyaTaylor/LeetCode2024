package src._JavaBasic.DesignPattern.Adapter;

// 定义充电接口（Target）
 interface Charger {
    void charge();
}

// 实现旧的充电类（Adaptee）
 class LightningCharger {
    public void chargeWithLightning() {
        System.out.println("Charging with lightning port.");
    }
}

// 实现新的充电类
 class USBCharger {
    public void chargeWithUSB() {
        System.out.println("Charging with USB port.");
    }
}

// 创建适配器类
 class USBToLightningAdapter implements Charger {
    private USBCharger usbCharger;

    public USBToLightningAdapter(USBCharger usbCharger) {
        this.usbCharger = usbCharger;
    }

    @Override
    public void charge() {
        usbCharger.chargeWithUSB();
    }
}

// 客户端代码
public class AdapterPatternDemo {
    public static void main(String[] args) {
        Charger charger = new USBToLightningAdapter(new USBCharger());
        charger.charge();
    }
}
