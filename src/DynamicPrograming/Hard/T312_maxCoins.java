package src.DynamicPrograming.Hard;

public class T312_maxCoins {

    /**
     * https://leetcode.cn/problems/burst-balloons/
     * dp[i][j]:fill [i,j] arr
     * how: insert one by one
     */
    public int maxCoins(int[] nums_) {
        int n=nums_.length+2;
        int[] nums =new int[n];
        nums[0]=1;
        nums[n-1]=1;
        for (int i = 1; i <n-1 ; i++) {
            nums[i]=nums_[i-1];
        }

        int[][] dp = new int[n][n]; //[i,j]

        for (int len = 1; len < n-1 ; len++) {
            for (int i = 1; i <n-1 && i+len-1<n-1  ; i++) {
                int j=i+len-1;
                int temp=Integer.MIN_VALUE;
                for (int k = i; k <=j ; k++) {
                    temp=Math.max(temp,dp[i][k-1]+dp[k+1][j]+nums[i-1]*nums[k]*nums[j+1]);
                    // insert k first : nums[i-1]*nums[k]*nums[j+1] , note that the border is i-1,j+1
                    // dp[i][k-1]+dp[k+1][j] : after inserting k, insert the left and right side
                    // for i<j, the initial value is 0
                }
                dp[i][j]=temp;
            }
        }

        return dp[1][n-2];
    }

    public static void main(String[] args) {
        System.out.println(new T312_maxCoins().maxCoins(new int[]{3,1,5,8}));
    }

}
