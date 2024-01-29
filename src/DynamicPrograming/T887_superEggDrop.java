package src.DynamicPrograming;

public class T887_superEggDrop {

    /**
     * https://leetcode.cn/problems/super-egg-drop/
     * f(n,k)=1+min(max{f(m-1,k-1),f(n-m,k)})
     */

    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k+1][n+1];

        for (int j = 0; j < n+1; j++) {
            dp[1][j]=j;
        }
        for (int i = 2; i <k+1 ; i++) {
            for (int j = 1; j < n+1; j++) {
                int temp=Integer.MAX_VALUE;
                for (int l = 1; l <= (j+1)/2; l++) { // Math.max(dp[i-1][l-1],dp[i][j-l]) ,i-1<j-l
                    temp=Math.min(temp,Math.max(dp[i-1][l-1],dp[i][j-l]));
                }
                dp[i][j]=temp+1;
            }
        }

        return dp[k][n];
    }

    public static void main(String[] args) {
        System.out.println(new T887_superEggDrop().superEggDrop(2,6));
    }
}
