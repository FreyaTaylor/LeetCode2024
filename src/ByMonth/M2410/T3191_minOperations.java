package src.ByMonth.M2410;

public class T3191_minOperations {

    /**
     * https://leetcode.cn/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i/description/
     */

    public int minOperations(int[] nums) {

        int res=0;
        int i=0;
        while (i+2<nums.length){
            if(nums[i]==0){
                for (int j = 0; j < 3; j++) {
                    nums[i+j]=1-nums[i+j];
                }
                res++;
            }
        }

        while (i<nums.length){
            if(nums[i]==0){
                return -1;
            }
        }
        return res;

    }


}
