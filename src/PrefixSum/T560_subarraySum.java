package src.PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class T560_subarraySum {

    /**
     * https://leetcode.cn/problems/subarray-sum-equals-k/
     * 前缀和 最经典/最简单题目
     */

    public int subarraySum(int[] nums, int k) {

        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        int res=0;
        int curSum=0;
        for (int i = 0; i <nums.length ; i++) {
            curSum+=nums[i];
            int need=curSum-k;
            res+=map.getOrDefault(need,0);
            map.put(curSum,map.getOrDefault(curSum,0)+1);
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1,2,3};
        int k = 3;
        System.out.println(new T560_subarraySum().subarraySum(nums,k));
    }
}
