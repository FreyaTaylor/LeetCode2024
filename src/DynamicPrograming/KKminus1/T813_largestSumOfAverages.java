package src.DynamicPrograming.KKminus1;

public class T813_largestSumOfAverages {

    /**
     * https://leetcode.cn/problems/largest-sum-of-averages/
     * int/int = int
     *
     */

    public double largestSumOfAverages(int[] nums, int k) {
        int n=nums.length;
        int[] presum=new int[n+1]; // [0,i-1]
        double[][]dp = new double[k+1][n+1];

        for (int j = 1; j < n+1; j++) {
            presum[j]=presum[j-1]+nums[j-1];
            dp[1][j]=(double) presum[j]/j;
        }

        for (int i = 2; i < k+1; i++) {
            for (int j = i; j < n+1; j++) { // [0,j-1]
                double temp=Double.MIN_VALUE;
                for (int l = i-1; l <j ; l++) {
                    temp=Math.max(temp,dp[i-1][l]+(double) (presum[j]-presum[l])/(j-l));
//                    System.out.println();
                }
                dp[i][j]=temp;
            }
        }

        return dp[k][n];
    }




    public static void main(String[] args) {
//        System.out.println(new T813_largestSumOfAverages().largestSumOfAverages(new int[]{1,2,3,4,5,6,7},4));
        System.out.println(new T813_largestSumOfAverages().largestSumOfAverages(new int[]{4,1,7,5,6,2,3},4));
    }
}
