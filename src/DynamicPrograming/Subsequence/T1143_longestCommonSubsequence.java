package src.DynamicPrograming.Subsequence;

public class T1143_longestCommonSubsequence {

    /**
     * https://leetcode.cn/problems/longest-common-subsequence/description/
     * 动态规划在于怎么样将大问题变成小问题,dp[i][j]看作是下面子序列的匹配：
     * (0 1 2 3 4 ... i-1)  i
     * (0 1 2 3 4 ... j-1)  j
     * 把两个字符串分别看作两段，则大问题看作以下三个问题的max：
     * 1.第一段匹配：dp[i-1][j-1]，第二段匹配：i,j
     * 2.第一段匹配：dp[i][j-1]，第二段匹配：i,null
     * 3.第一段匹配：dp[i-1][j]，第二段匹配：null,j
     *
     * 当text1.charAt(i-1)==text2.charAt(j-1)时候:
     * 1. dp[i][j]=dp[i-1][j-1]+1;
     * 2. dp[i][j-1]+0
     * 3. dp[i-1][j]+0
     * 因为 dp[i][j-1]或dp[i-1][j]最多比dp[i-1][j-1]多1，因此可不考虑2 3，只考虑1
     *
     * 当text1.charAt(i-1)!=text2.charAt(j-1)时候:
     * 1. dp[i][j]=dp[i-1][j-1]+0;
     * 2. dp[i][j-1]+0
     * 3. dp[i-1][j]+0
     * 因为 dp[i][j-1]或dp[i-1][j]必然比比dp[i-1][j-1]多或相等，因此可不考虑1，只考虑2 3
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for (int i = 1; i < text1.length()+1; i++) {
            for (int j = 1; j < text2.length()+1; j++) {
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }

            }
        }

        return dp[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
        System.out.println(new T1143_longestCommonSubsequence().longestCommonSubsequence("abcde","ace"));
    }
}
