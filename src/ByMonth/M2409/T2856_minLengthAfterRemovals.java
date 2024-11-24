package src.ByMonth.M2409;

import java.util.*;

public class T2856_minLengthAfterRemovals {

    /**
     * https://leetcode.cn/problems/minimum-array-length-after-pair-removals/
     *
     * 首先，找出重复最多的元素，将其与剩下的元素分为AB两组，A组的元素只能与B组的元素对应消除。
     */

    public int minLengthAfterRemovals(List<Integer> nums) {

        Map<Integer,Integer> map = new HashMap<>();
        for (Integer num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }

        int max=0;
        for (Integer i : map.keySet()) {
            max=Math.max(max,map.get(i));
        }
        int another=nums.size()-max;

        if(max>another){
            return max-another;
        }else {
            return (another-max)%2;
        }
    }


}
