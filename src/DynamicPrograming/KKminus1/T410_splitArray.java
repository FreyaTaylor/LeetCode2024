package src.DynamicPrograming.KKminus1;

public class T410_splitArray {
    /**
     * https://leetcode.cn/problems/split-array-largest-sum/
     *
     * k 个子数组各自和的最大值最小
     */

    public int splitArray(int[] nums, int k) {
        int n=nums.length;
        int [] presum=new int[n+1]; //sum [i,j] =[j+1]-[i]
        for (int i = 1; i < n+1; i++) {
            presum[i]=presum[i-1]+nums[i-1];
        }
        int[][] dp = new int[k+1][n+1]; // [i,j]=[0,j-1]  k
        dp[1]=presum;

        for (int i = 2; i < k+1; i++) {
            for (int j = i; j < n+1; j++) {
                int temp=Integer.MAX_VALUE;
                for (int l = i-1; l <j ; l++) { // [0,l] [l+1,j-1]
                    temp=Math.min(temp,Math.max(dp[i-1][l],presum[j]-presum[l]));
                }
                dp[i][j]=temp;
            }
        }

        return dp[k][n];
    }

    public static void main(String[] args) {
        System.out.println(new T410_splitArray().splitArray(new int[]{7,2,5,10,8},4));
    }



}
