package src;

import java.util.Arrays;

public class T718_findLength {
    /**
     * https://leetcode.cn/problems/maximum-length-of-repeated-subarray/description/
     * 经验：从暴力解法的所有字串->以nums1[i-1]，nums2[j-1]为尾的最长字串,
     * 能够定义更有操作性（利用dp[i][j]=dp[i-1][j-1]+1）的定义域
     * 且不会漏正确答案
     * @param nums1
     * @param nums2
     * @return
     */
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length+1][nums2.length+1]; //以nums1[i-1]，nums2[j-1]为尾的最长字串
        int res=0;
        for (int i = 1; i < nums1.length+1; i++) {
            for (int j = 1; j < nums2.length+1; j++) {
                if(nums1[i-1]==nums2[j-1]){ //必然通过此拼接，即这个判断条件是不会漏的
                    dp[i][j]=dp[i-1][j-1]+1;
                    res=Math.max(res,dp[i][j]);
                }
            }
        }

//        System.out.println(Arrays.deepToString(dp));
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new T718_findLength().findLength(new int[]{1,2,3,2,1},new int[]{3,2,1,4,7}));
    }
}
