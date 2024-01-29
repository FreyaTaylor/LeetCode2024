package src.DynamicPrograming.Knapsack;

import java.util.Arrays;

public class T322_coinChange {

    /**
     * https://leetcode.cn/problems/coin-change/description/
     *
     * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
     * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
     * 你可以认为每种硬币的数量是无限的。
     */
    public int coinChange(int[] coins, int amount) {

        int[][] dp = new int[coins.length+1][amount+1];
        for (int i = 0; i <coins.length+1 ; i++) {
            Arrays.fill(dp[i],Integer.MAX_VALUE); // 1.dp初始状态
            dp[i][0]=0; //2.最小单元问题的初始化
        }

        for (int i = 1; i <coins.length+1 ; i++) {
            for (int j = 1; j <amount+1 ; j++) {
                // 3.递推公式生成数组
                int k = 0;
                int remains=j-k*coins[i-1];
                while (remains>=0){
                    if(dp[i-1][remains]!=Integer.MAX_VALUE){
                        dp[i][j]=Math.min(dp[i][j],k+dp[i-1][remains]);
                    }
                    k++;
                    remains=j-k*coins[i-1];
                }

            }
        }

        // 4.取结果
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <coins.length+1 ; i++) {
            res=Math.min(res,dp[i][amount]);
        }

        // 5，结果输出
        if(res==Integer.MAX_VALUE){
            return -1;
        }
        return res;
    }

    public static void main(String[] args) {
                int [] coins = {1, 2, 5};
        int amount = 11;
//        int [] coins = {2};
//        int amount = 3;
        T322_coinChange obj = new T322_coinChange();
        System.out.println(obj.coinChange(coins,amount));
        System.out.println(Integer.MAX_VALUE);
    }

}
