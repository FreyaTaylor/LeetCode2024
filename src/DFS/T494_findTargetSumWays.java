package src.DFS;

public class T494_findTargetSumWays {

    /**
     * https://leetcode.cn/problems/target-sum/
     * @param nums
     * @param target
     * @return
     */
    int ways=0;
    public int findTargetSumWays(int[] nums, int target) {
        helper(nums,target,0,0);
        return ways;
    }

    public void helper(int[] nums, int target,int cur,int curSum){
        if(cur==nums.length){
            if(curSum==target){
                ways++;
            }
            return;
        }
        helper(nums,target,cur+1,curSum-nums[cur]);
        helper(nums,target,cur+1,curSum+nums[cur]);
    }


}
