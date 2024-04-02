package src._JavaBasic;

import src._JavaBasic.SerializableDemo.User;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Test {

    public static void main(String[] args) {
        HashMap<User,Integer> map = new HashMap<>();
        map.put(null,1);
        map.put(null,1);

        ConcurrentHashMap<Integer,Integer> cmap = new ConcurrentHashMap<>();
    }
}
