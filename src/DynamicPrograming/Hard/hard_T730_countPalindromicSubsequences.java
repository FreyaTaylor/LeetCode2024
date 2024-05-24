package src.DynamicPrograming.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class hard_T730_countPalindromicSubsequences {
    /**
     * https://leetcode.cn/problems/count-different-palindromic-subsequences/
     *
     * dp(i,j)=
     *
     * 2+dp(i+1,j−1)×2,
     * 1+dp(i+1,j−1)×2,
     * dp(i+1,j−1)×2−dp(low+1,high−1),
     *
     * low>high
     * low=high
     * low<high
     * // (     (*)           ),
     * 不含最外层的不重复，含最外层的，内馅是*的重复了，因此要-dp(low+1,high−1)
     * 且因为不不含最外层的已经包含：单个和两个目标字符，因此，不用+2
     *
     * 去重！
     * 处处都要mod
     * -的地方要+mod，再mod
     */
    public int countPalindromicSubsequences(String s) {

        int n = s.length();
        int mod = (int)Math.pow(10,9)+7;

        int[] preSame = new int[n];
        int[] nextSame = new int[n];
        Arrays.fill(preSame,-1);
        Arrays.fill(nextSame,-1);

        for (int ci = 0; ci <4 ; ci++) {
            List<Integer> indexs = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (s.charAt(i)-'a'==ci) {
                    indexs.add(i);
                }
            }
            for (int i = 1; i < indexs.size(); i++) {
                nextSame[indexs.get(i-1)]=indexs.get(i);
                preSame[indexs.get(i)]=indexs.get(i-1);
            }
        }

        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i]=1;
        }

        for (int len = 2; len <=n ; len++) {
            for (int i = 0; i < n+1-len; i++) {
                int j = i+len-1;
                if(s.charAt(i)==s.charAt(j)){
                    int low = nextSame[i];
                    int high = preSame[j];
                    if(low == j){ // 无
                        dp[i][j] = (2 + 2 * dp[i+1][j-1]%mod)%mod;
                    }else if(low == high){ //一个
                        dp[i][j] = (1 + 2 * dp[i+1][j-1]%mod)%mod;
                    }else if(low < high){
                        dp[i][j] = (2*dp[i+1][j-1]%mod - dp[low+1][high-1] +mod)%mod;
                    }

                }else {
                    dp[i][j] = ((dp[i+1][j]+dp[i][j-1])%mod -dp[i+1][j-1] +mod)%mod;
                }

            }
        }

        return dp[0][n-1];
    }

    public static void main(String[] args) {
        System.out.println(new hard_T730_countPalindromicSubsequences().countPalindromicSubsequences("a"));
//        System.out.println(new _T730_countPalindromicSubsequences().countPalindromicSubsequences("abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba"));
//        System.out.println(new _T730_countPalindromicSubsequences().countPalindromicSubsequences("bccb"));
    }
}
