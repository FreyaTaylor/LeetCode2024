package src.BFS;

import java.util.*;

public class T752_openLock {

    /**
     * https://leetcode.cn/problems/open-the-lock/
     */

    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>();
        for (String deadend : deadends) {
            set.add(deadend);
        }

        Map<Character,Character> next = new HashMap<>();
        Map<Character,Character> pre = new HashMap<>();
        String s = "01234567890";
        for (int i = 0; i < 10; i++) {
            next.put(s.charAt(i),s.charAt(i+1));
            pre.put(s.charAt(i+1),s.charAt(i));
        }


        Deque<String> q = new ArrayDeque<>();
        if(!set.contains("0000")){
            q.add("0000");
        }

        char[] chars;

        int step=0;
        while (!q.isEmpty()){
            int size = q.size();
            System.out.println(q);
            for (int i = 0; i < size; i++) {
                String cur = q.removeFirst();

                if(cur.equals(target)){
                    return step;
                }

                chars = cur.toCharArray();

                for (int j = 0; j < 4; j++) {
                    char c = chars[j];

                    chars[j]=next.get(c);
                    String next_ = new String(chars);
                    if(!set.contains(next_)){
                        q.addLast(next_);
                        set.add(next_);
                    }

                    chars[j]=pre.get(c);
                    String pre_ = new String(chars);
                    if(!set.contains(pre_)){
                        q.addLast(pre_);
                        set.add(pre_);
                    }

                    chars[j]=c;
                }


            }


            step++;
        }

        return -1;

    }


    public static void main(String[] args) {
        String[] deadends;
        String target;

        deadends = new String[]{"0201","0101","0102","1212","2002"};
        target = "0202";

        deadends = new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"};
        target = "8888";

        deadends = new String[]{"0000"};
        target = "8888";

        System.out.println(new T752_openLock().openLock(deadends,target));

    }
}
