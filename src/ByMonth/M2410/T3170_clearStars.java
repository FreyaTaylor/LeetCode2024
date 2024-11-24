package src.ByMonth.M2410;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.DelayQueue;

public class T3170_clearStars {

    /**
     * https://leetcode.cn/problems/lexicographically-minimum-string-after-removing-stars/description/
     */

    public String clearStars(String s) {

        List<Integer> del = new ArrayList<>();
        char[] chars = s.toCharArray();
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(s.charAt(o1)!=s.charAt(o2)){
                    return s.charAt(o1)-s.charAt(o2);
                }
                return o2-o1;
            }
        });

        for (int i = 0; i < s.length(); i++) {
            if(chars[i]!='*'){
                q.add(i);
            }else {
                chars[q.poll()]='*';
            }
        }

        String res=new String(chars);
        res=res.replace("*","");
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new T3170_clearStars().clearStars("aaba*"));
    }
}
