package src.BFS;

import javax.print.DocFlavor;
import java.util.*;

public class T752_openLock_1 {

    /**
     * https://leetcode.cn/problems/open-the-lock/
     *
     * 双向bfs:set,q,map都必须的单独的一套
     *
     */

    public int openLock(String[] deadends, String target) {

        Map<Character,Character> next = new HashMap<>();
        Map<Character,Character> pre = new HashMap<>();
        String s = "01234567890";
        for (int i = 0; i < 10; i++) {
            next.put(s.charAt(i),s.charAt(i+1));
            pre.put(s.charAt(i+1),s.charAt(i));
        }

        Set<String> setFrom = new HashSet<>();
        Set<String> setEnd = new HashSet<>();
        Deque<String> qFrom = new ArrayDeque<>();
        Deque<String> qEnd = new ArrayDeque<>();
        Map<String,Integer> fromStr = new HashMap<>();
        Map<String,Integer> endStr = new HashMap<>();

        for (String deadend : deadends) {
            setFrom.add(deadend);
            setEnd.add(deadend);
        }

        if(!setFrom.contains("0000")){
            qFrom.add("0000");
            fromStr.put("0000",0);
            setFrom.add("0000");
        }

        if(!setEnd.contains(target)){
            qEnd.addLast(target);
            endStr.put(target,0);
            setEnd.add(target);
        }

        char[] chars;

        int stepFrom = 1;
        int stepEnd = 1;


        while (!qFrom.isEmpty() || !qEnd.isEmpty()){
//            System.out.println("----------------------------");
//            System.out.println(qFrom);
//            System.out.println(qEnd);

            int size = qFrom.size();
            for (int i = 0; i < size; i++) {
                String cur = qFrom.removeFirst();
                if (endStr.containsKey(cur)) {
                    return fromStr.get(cur) + endStr.get(cur);
                }
                chars = cur.toCharArray();

                for (int j = 0; j < 4; j++) {
                    char c = chars[j];

                    chars[j] = next.get(c);
                    String next_ = new String(chars);
                    if (!setFrom.contains(next_)) {
                        qFrom.addLast(next_);
                        setFrom.add(next_);
                        fromStr.put(next_, stepFrom);
                    }
                    chars[j] = pre.get(c);
                    String pre_ = new String(chars);
                    if (!setFrom.contains(pre_)) {
                        qFrom.addLast(pre_);
                        setFrom.add(pre_);
                        fromStr.put(pre_, stepFrom);
                    }

                    chars[j] = c;
                }
            }// for (int i = 0; i < size; i++) {

                size = qEnd.size();
                for (int i = 0; i < size; i++) {
                    String cur = qEnd.removeFirst();
                    if(fromStr.containsKey(cur)){
                        return fromStr.get(cur)+endStr.get(cur);
                    }
                    chars = cur.toCharArray();

                    for (int j = 0; j < 4; j++) {
                        char c = chars[j];

                        chars[j]=next.get(c);
                        String next_ = new String(chars);
                        if(!setEnd.contains(next_)){
                            qEnd.addLast(next_);
                            setEnd.add(next_);
                            endStr.put(next_,stepEnd);
                        }
                        chars[j]=pre.get(c);
                        String pre_ = new String(chars);
                        if(!setEnd.contains(pre_)){
                            qEnd.addLast(pre_);
                            setEnd.add(pre_);
                            endStr.put(pre_,stepEnd);
                        }

                        chars[j]=c;
                    } // for (int i = 0; i < size; i++) {
            }


            stepFrom++;
            stepEnd++;
        }

        return -1;

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

        System.out.println(new T752_openLock_1().openLock(deadends,target));

    }
}
