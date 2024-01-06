package Dec2023;

import java.lang.reflect.Array;
import java.util.Arrays;

public class T518_change {

    /**
     * https://leetcode.cn/problems/coin-change-ii/
     * @param amount
     * @param coins
     * @return
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
