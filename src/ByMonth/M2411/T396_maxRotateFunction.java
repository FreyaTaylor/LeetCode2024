package src.ByMonth.M2411;

public class T396_maxRotateFunction {
    /**
     * https://leetcode.cn/problems/rotate-function/
     */

    public int maxRotateFunction(int[] nums) {

        int n = nums.length;
        int sum=0;
        int res=0;
        for (int i = 0; i < n; i++) {
            res+=i*nums[i];
            sum+=nums[i];
        }

        int result=res;
        for (int i = n-1; i >0 ; i--) {
            res=res+sum-n*nums[i];
            result=Math.max(result,res);

        }

        return result;
    }


}
