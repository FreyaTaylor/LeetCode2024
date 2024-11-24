package src._JavaBasic.DesignPattern.Singleton.Serializable;

import java.io.*;

public class Singleton implements Serializable {
    private static Singleton instance;

    private Singleton() {
        if (instance != null) {
            throw new IllegalStateException("Instance already exists!");
        }
        instance = this;
    }

    public static Singleton getInstance() {
        return instance;
    }
}

 class TestSerialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 序列化
        FileOutputStream fileOutputStream = new FileOutputStream("singleton.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(Singleton.getInstance());
        objectOutputStream.close();
        fileOutputStream.close();

        // 反序列化
        FileInputStream fileInputStream = new FileInputStream("singleton.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Singleton newSingleton = (Singleton) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();

        // 检查是否为同一个实例
        System.out.println(newSingleton == Singleton.getInstance() ? "Same instance" : "New instance");
    }
}
