package src._JavaBasic;

import src._JavaBasic.SerializableDemo.User;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test {

    void method() {
        int value = 42; // 隐式地具有effectively final的特性
        new Thread(() -> {

            System.out.println(value); // 可以安全地使用value，因为它是effectively final的
        }).start();

//        value=10;
    }


    public String append(String a){
        a=a+"!";
        return a;
    }


    public int exampleMethod() {
        try {
            // 尝试执行一些操作
//            throw new Exception();
            return 1; // 如果没有异常，方法将返回 1
        } catch (Exception e) {
            // 处理异常
            return 2; // 如果有异常，方法将返回 2
        }
        finally {
            // 无论是否发生异常都会执行
            return 3; // 这将覆盖 try 或 catch 中的返回值，方法将返回 3
        }
//        return 4;
    }

    public static void main(String[] args) {
        Test obj = new Test();


        HashMap<User,Integer> map = new HashMap<>();
        map.put(null,1);
        map.put(null,1);
        ConcurrentHashMap<Integer,Integer> cmap = new ConcurrentHashMap<>();


        String s = "12345";
        System.out.println(s.charAt(1));

        System.out.println(obj.append(s) );


        System.out.println(obj.exampleMethod());



        Map<Integer,Integer> map1 = new HashMap<>();
        map1.put(null,null);
        map1.put(null,3);
        map1.put(3,null);

        System.out.println(map1.get(null));

        Map<Integer,Integer> map2 = new ConcurrentHashMap<>();
        map2.put(1,1);

    }
}
