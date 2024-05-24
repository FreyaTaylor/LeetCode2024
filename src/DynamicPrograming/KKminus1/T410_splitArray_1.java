package src.DynamicPrograming.KKminus1;

import java.util.Map;

public class T410_splitArray_1 {
    public int splitArray(int[] nums, int k) {

        int n = nums.length;
        int[][] dp = new int[k+1][n]; //[0,i] j个
        int[] presum = new int[n+1]; //presum[i+1]=sum[0,i-1] ; sum[a,b]=presum[b+1]-presum[a];

        for (int i = 0; i < n; i++) {
            presum[i+1]=presum[i]+nums[i];
            dp[1][i]=presum[i+1];
        }

        for (int kk = 2; kk <k+1 ; kk++) {
            for (int i = kk-1; i <n ; i++) {
                int temp=Integer.MAX_VALUE;
                for (int j = kk-2; j <i ; j++) { //[0,j] kkk-1 [j+1,i] 1
                    temp= Math.min(temp,Math.max(presum[i+1]-presum[j+1],dp[kk-1][j]));
                }
                dp[kk][i]=temp;
            }
        }

        return dp[k][n-1];
    }

    public static void main(String[] args) {
        System.out.println(new T410_splitArray_1().splitArray(new int[]{7,2,5,10,8},4));
    }
}
