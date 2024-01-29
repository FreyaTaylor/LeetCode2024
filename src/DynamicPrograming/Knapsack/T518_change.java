package src.DynamicPrograming.Knapsack;

public class T518_change {

    /**
     * https://leetcode.cn/problems/coin-change-ii/
     *
     * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
     * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
     * 假设每一种面额的硬币有无限个。
     */
    public int change(int amount, int[] coins) {

        int[][] dp = new int[coins.length+1][amount+1];
        for (int i = 0; i <coins.length+1 ; i++) {
            dp[i][0]=1;
        }

        for (int i = 1; i <coins.length+1 ; i++) {
            for (int j = 1; j <amount+1 ; j++) {
                // 前i个硬币，凑成j的可能性
                int k = 0;
                while (j-k*coins[i-1]>=0){
                    dp[i][j]+=dp[i-1][j-k*coins[i-1]];
                    k++;

                }

            }
        }

//        System.out.println(Arrays.deepToString(dp));
        return dp[coins.length][amount];
    }

    public static void main(String[] args) {
        System.out.println(new T518_change().change(5,new int[]{1,2,5}));
    }
}
