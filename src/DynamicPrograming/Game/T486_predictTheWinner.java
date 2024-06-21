package src.DynamicPrograming.Game;

public class T486_predictTheWinner {


    /**
     * https://leetcode.cn/problems/predict-the-winner/
     * xian[i][j]:先手[i,...,j]获得的最大得分
     * xian[i][j]=max{nums[i]+sum[i+1,j]-xian[i+1][j],nums[j]+sum[i,j-1]-xian[i][j-1]}
     *
     * */
    public boolean predictTheWinner(int[] nums) {
        int n =nums.length;
        int[][] xian = new int[n][n];
        int[] presum = new int[n+1]; //sum[i,...,j]=[j+1]-[i]

        for (int i = 0; i < n; i++) {
            xian[i][i]=nums[i];
            presum[i+1]=presum[i]+nums[i];
        }

        for (int len = 2; len <n+1 ; len++) {
            for (int i = 0; i <n+1-len ; i++) {
                int j=i+len-1;
                xian[i][j]=Math.max(nums[i]+presum[j+1]-presum[i+1]-xian[i+1][j],
                        nums[j]+presum[j]-presum[i]-xian[i][j-1]);

            }
        }

        if (presum[n]>2*xian[0][n-1]){
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1};

        System.out.println(new T486_predictTheWinner().predictTheWinner(nums));
    }

}
