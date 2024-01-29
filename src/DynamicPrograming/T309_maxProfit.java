package src.DynamicPrograming;

public class T309_maxProfit {
    /**
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/
     */

    public int maxProfit(int[] prices) {
        int [][] dp = new int[prices.length][3];

        dp[0][0]=-prices[0]; // have from have or buy
        dp[0][1]=0; //not have by sell, for next i calculate ,it should be 0
        dp[0][2]=0; //not have by colding or doing nothing, for next i calculate ,it should be 0
        // purpose is important, rather than name ,when set initinal value and caltulate

        for (int i = 1; i < prices.length; i++) {
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][2]-prices[i]);
            dp[i][1]=dp[i-1][0]+prices[i];
            dp[i][2]=Math.max(dp[i-1][1],dp[i-1][2]);
        }

        return Math.max(dp[prices.length-1][1],dp[prices.length-1][2]);
    }

    public static void main(String[] args) {
        System.out.println(new T309_maxProfit().maxProfit(new int[]{4,2,1}));
    }

}
