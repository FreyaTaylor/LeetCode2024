package src.DynamicPrograming.Subsequence;

import java.util.Arrays;

public class T115_numDistinct {
    /**
     * https://leetcode.cn/problems/distinct-subsequences/
     *
     * 思路参考1143
     *      * 动态规划在于怎么样将大问题变成小问题,dp[i][j]看作是下面子序列的匹配：
     *      * (0 1 2 3 4 ... i-1)  i --s
     *      * (0 1 2 3 4 ... j-1)  j --t
     *      * 把两个字符串分别看作两段，则大问题看作以下三个问题的max： --但这里是both的关系
     *      * 1.第一段匹配：dp[i-1][j-1]，第二段匹配：i,j --相等
     *      * 2.第一段匹配：dp[i][j-1]，第二段匹配：i,null --必须考虑j
     *      * 3.第一段匹配：dp[i-1][j]，第二段匹配：null,j --不等
     *
     * note：dp是为了最后的计算负责的，如何不知如何初始化，可以想想之后是怎么用他的，他应该是什么值！
     */

    public int numDistinct(String s, String t) {
        int [][] dp = new int[t.length()+1][s.length()+1];
        Arrays.fill(dp[0],1);
        int helper = (int) (Math.pow(10,9)+7);

        for (int i = 1; i < t.length()+1; i++) {
            for (int j = 1; j < s.length()+1; j++) {
                dp[i][j]=dp[i][j-1];
                if(s.charAt(j-1)==t.charAt(i-1)){
                    dp[i][j]=((dp[i][j]%helper)+(dp[i-1][j-1]%helper))%helper;
                }
            }
        }

        return dp[t.length()][s.length()];
    }

    public static void main(String[] args) {
        System.out.println(new T115_numDistinct().numDistinct("babgbag","bag"));
    }
}
