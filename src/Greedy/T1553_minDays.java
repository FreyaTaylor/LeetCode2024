package src.Greedy;

import java.util.HashMap;
import java.util.Map;

public class T1553_minDays {
    /**
     * https://leetcode.cn/problems/minimum-number-of-days-to-eat-n-oranges
     */


    //61455274 超出内存限制,也会超时
//    public int minDays(int n) {
//        int[] dp = new int[n+1];
//        for (int i = 1; i < n+1; i++) {
//            int temp=Integer.MAX_VALUE;
//            if(i%3==0){
//                temp=Math.min(temp,1+dp[i/3]);
//            }
//            if(i%2==0){
//                temp=Math.min(temp,1+dp[i/2]);
//            }
//            temp=Math.min(temp,1+dp[i-1]);
//            dp[i]=temp;
//        }
//
//        return dp[n];
//    }

    /**
     *
     */

    Map<Integer,Integer> dp = new HashMap<>();
    public int minDays(int n) {
        dp.put(0,0);
        dp.put(1,1);
        return helper(n);
    }

    public int helper(int n){
        if(!dp.containsKey(n)){
            dp.put(n,Math.min(n % 2 + 1 + minDays(n / 2), n % 3 + 1 + minDays(n / 3)));
        }
        return dp.get(n);
    }




    public static void main(String[] args) {
        System.out.println(new T1553_minDays().minDays(10));
    }
}
