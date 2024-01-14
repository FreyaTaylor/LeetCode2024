package src.DynamicPrograming;

public class T72_minDistance {

    /**
     * https://leetcode.cn/problems/edit-distance/
     * 参考：最长子序列
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i < n+1; i++) {
            dp[i][0]=i;
        }
        for (int j = 1; j < m+1 ; j++) {

            dp[0][j]=j;
        }


        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1 ; j++) {
                if(word1.charAt(j-1)==word2.charAt(i-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    dp[i][j]=Math.min(Math.min(dp[i][j-1],dp[i-1][j]),dp[i-1][j-1])+1;
                    // 三个中选最小:
                    // dp[i][j-1] 增word2的尾字母，使尾=word1.charAt(j-1)；
                    // dp[i-1][j] 删word2的尾字母；
                    // dp[i-1][j-1] 改word2的尾字母
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        System.out.println(new T72_minDistance().minDistance("horse","ros"));
    }
}
