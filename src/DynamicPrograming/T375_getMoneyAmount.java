package src.DynamicPrograming;

public class T375_getMoneyAmount {
    /**
     * https://leetcode.cn/problems/guess-number-higher-or-lower-ii/
     *
     * 猜测 1 2 3 4 和 101 102 103 104的逻辑是不一样的，因为要考虑猜错的代价，数字越大，错误的次数需要更少
     */

    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+2][n+2];
        for (int i = 1; i <=n ; i++) {
            dp[i][i]=0;
        }


        for (int len = 2; len <=n; len++) {
            for (int i = 1; i+len-1 <=n ; i++) { // i,i+len-1
                int j=i+len-1;

                int temp = Integer.MAX_VALUE;
                for (int k = i; k <=j ; k++) {
                    temp=Math.min(temp,k+Math.max(dp[i][k-1],dp[k+1][j]));
                }

                dp[i][j]=temp;
            }
        }

        return dp[1][n];
    }

    public static void main(String[] args) {
        System.out.println(new T375_getMoneyAmount().getMoneyAmount(10));
    }
}
