package src.DynamicPrograming.Subsequence;

public class T718_findLength {

    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m+1][n+1];

        for (int i = 1; i <m+1 ; i++) {
            for (int j = 1; j <n+1 ; j++) {
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                dp[i][j] = Math.max(dp[i][j],dp[i-1][j]);
                dp[i][j] = Math.max(dp[i][j],dp[i][j-1]);
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,2,1};
        int[] nums2 = new int[]{3,2,1,4,7};
        System.out.println(new T718_findLength().findLength(nums1,nums2));
    }


}
