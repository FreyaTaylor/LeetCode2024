package src._JavaBasic.SerializableDemo;

import java.io.*;

public class SerializableTest {

    /**
     * 将User对象作为文本写入磁盘
     */
    public static void writeObj() throws IOException {
        User user = new User("1001", "Joe");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("files\\demo.txt"));
        objectOutputStream.writeObject(user);
        objectOutputStream.close();
    }

    public static void readObj() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("files\\demo.txt"));
            try {
                Object object = objectInputStream.readObject();
                User user = (User) object;
                System.out.println(user);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String args[]) throws IOException {

        System.out.println(System.getProperty("user.dir"));;

        writeObj();
        readObj();

         System.out.println();
    }
}



