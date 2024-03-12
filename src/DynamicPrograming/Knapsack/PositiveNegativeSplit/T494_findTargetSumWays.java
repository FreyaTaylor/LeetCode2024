package src.DynamicPrograming.Knapsack.PositiveNegativeSplit;

public class T494_findTargetSumWays {

    /**
     * https://leetcode.cn/problems/target-sum/description/
     * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
     */

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum=0;
        for (int i = 0; i < n; i++) {
            sum+=nums[i];
        }

        if(target+sum<0 || (target+sum)%2!=0){return 0;} // 防止need是负数
        int need=(target+sum)/2;

        int[][] dp = new int[n+1][need+1]; //前i个硬币，组成j
        dp[0][0]=1;

        for (int i = 1; i < n+1; i++) {
            for (int j = 0; j <need+1 ; j++) { // 数组有多个0，需要从0开始dp
                dp[i][j] += dp[i-1][j];
                if(nums[i-1]<=j){
                    dp[i][j] += dp[i-1][j-nums[i-1]];
                }
            }
        }

        return dp[n][need];
    }


    public static void main(String[] args) {
        System.out.println(new T494_findTargetSumWays().findTargetSumWays(new int[]{0,0,0,0,0,0,0,0,1},1));
//        System.out.println(new _T494_findTargetSumWays().findTargetSumWays(new int[]{1,1,1,1,1},3));
    }
}
