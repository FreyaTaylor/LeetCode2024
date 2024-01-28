package src.DynamicPrograming.MatryoshkaDolls;

import java.util.Arrays;

public class T300_lengthOfLIS {

    /**
     * https://leetcode.cn/problems/longest-increasing-subsequence/
     * each step:
     * update already subSequency (if all numbers are replaced, the subSequency replaced)
     * OR add a number
     */

    public int lengthOfLIS(int[] nums) {
        int[] sub = new int[nums.length+1];
        int top=0;
        sub[0]=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length ; i++) {
            int cur=top;
            if(nums[i]>sub[cur]){
                sub[++top]=nums[i];
            }else if(nums[i]<sub[cur]){
                while (nums[i]<=sub[cur]){cur--;} // inner same number
                if(cur!=top){
                    sub[cur+1] =nums[i];
                }
            }
            System.out.println(Arrays.toString(sub));
        }
        return top;
    }

    public static void main(String[] args) {
        System.out.println(new T300_lengthOfLIS().lengthOfLIS(new int[]{4,10,10,4,3,8,9}));
    }
}
