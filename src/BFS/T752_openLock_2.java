package src.BFS;

import java.util.*;

public class T752_openLock_2 {

    /**
     * https://leetcode.cn/problems/open-the-lock/
     *
     * 双向bfs:set,q,map都必须的单独的一套
     *
     */

    public int openLock(String[] deadends, String target) {

        if(target.equals("0000")){
            return 0;
        }

        Map<Character,Character> next = new HashMap<>();
        Map<Character,Character> pre = new HashMap<>();
        String s = "01234567890";
        for (int i = 0; i < 10; i++) {
            next.put(s.charAt(i),s.charAt(i+1));
            pre.put(s.charAt(i+1),s.charAt(i));
        }


        Deque<String> qFrom = new ArrayDeque<>();
        Deque<String> qEnd = new ArrayDeque<>();
        Map<String,Integer> mapFrom = new HashMap<>();
        Map<String,Integer> mapEnd = new HashMap<>();
        Set<String> set = new HashSet<>();
        int stepFrom = 1;
        int stepEnd = 1;

        for (String deadend : deadends) {
            set.add(deadend);
        }

        if(!set.contains("0000")){
            qFrom.add("0000");
            mapFrom.put("0000",0);
        }

        if(!set.contains(target)){
            qEnd.addLast(target);
            mapEnd.put(target,0);

        }


        while (!qFrom.isEmpty() && !qEnd.isEmpty()){
//            System.out.println("----------------------------");
//            System.out.println(qFrom);
//            System.out.println(qEnd);

            int size = qFrom.size();
            for (int i = 0; i < size; i++) {
                String cur = qFrom.removeFirst();
                List<String> nextString = getNextStage(cur,next,pre);
                for (String string : nextString) {
                    if(mapEnd.containsKey(string)){
                        return stepFrom+mapEnd.get(string);
                    }
                    if(!set.contains(string)){
                        mapFrom.put(string,stepFrom);
                        set.add(string);
                        qFrom.add(string);
                    }
                }
            }// for (int i = 0; i < size; i++) {

            size = qEnd.size();
            for (int i = 0; i < size; i++) {
                String cur = qEnd.removeFirst();
                List<String> nextString = getNextStage(cur,next,pre);
                for (String string : nextString) {
                    if(mapFrom.containsKey(string)){
                        return stepEnd+mapFrom.get(string);
                    }
                    if(!set.contains(string)){
                        mapEnd.put(string,stepEnd);
                        set.add(string);
                        qEnd.addLast(string);
                    }
                }
            } // for (int i = 0; i < size; i++) {

            stepFrom++;
            stepEnd++;
        }

        return -1;
    }


    public List<String> getNextStage(String cur, Map<Character,Character> next, Map<Character,Character> pre){
        List<String> res = new ArrayList<>();
        char[] chars = cur.toCharArray();
        for (int j = 0; j < 4; j++) {
            char c = chars[j];
            chars[j] = next.get(c);
            res.add(new String(chars));
            chars[j] = pre.get(c);
            res.add(new String(chars));
            chars[j] = c;
        }
        return res;
    }


    public static void main(String[] args) {
        String[] deadends;
        String target;

        deadends = new String[]{"0201","0101","0102","1212","2002"};
        target = "0202";

//        deadends = new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"};
//        target = "8888";
//
//        deadends = new String[]{"0000"};
//        target = "8888";

        deadends = new String[]{"0201","0101","0102","1212","2002"};
        target = "0000";

        System.out.println(new T752_openLock_2().openLock(deadends,target));

    }
}
