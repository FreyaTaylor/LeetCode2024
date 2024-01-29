package src.Number;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.DelayQueue;

public class T670_maximumSwap {

    /**
     * https://leetcode.cn/problems/maximum-swap/?envType=daily-question&envId=2024-01-22
     * 首位与（最大&最右）交换
     * 需要注意：98368
     * 若是第0位交换，则是与第一位之后的数位的最大值交换
     * 若不交换，则第1位交换，是与第二位之后的数位的最大值交换
     * 。。。
     *
     * 官方解题：
     * 从做开始遍历，记录所有可以交换的对(i,curmax),取最小（左）的i的对进行交换
     */

    public int maximumSwap(int num) {

        String s= String.valueOf(num);
        // 右起的递增队列
        Deque<Integer> q = new ArrayDeque<>();
        int i=s.length()-1;
        while (i>=0){
            if (q.isEmpty() || s.charAt(q.getLast())<s.charAt(i)){
                q.addLast(i);
            }
            i--;
        }

        // 第一个可交换时机出现时，交换&结束算法
        for (int j = 0; j < s.length(); j++) {
            if(q.isEmpty()){break;}
            if(j==q.getLast()){ // 98368 j=0,q.getLast()=0
                q.removeLast();
            } else if(s.charAt(j)<s.charAt(q.getLast())){ // skip first 8==last 8
                int target=q.getLast();
                 // -j-target-
                String res = s.substring(0,j)+s.charAt(target)+s.substring(j+1,target)+s.charAt(j)+s.substring(target+1,s.length());
                return Integer.valueOf(res);
            }
        }

        return num;
    }

    public static void main(String[] args) {
        System.out.println(new T670_maximumSwap().maximumSwap(9));
    }


}
