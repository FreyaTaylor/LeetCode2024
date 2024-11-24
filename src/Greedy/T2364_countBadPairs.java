package src.Greedy;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class T2364_countBadPairs {

    /**
     * https://leetcode.cn/problems/count-number-of-bad-pairs/description/
     *
     * J计算diff数组，
     */

    public long countBadPairs(int[] nums) {
        int n=nums.length;
        Map<Integer,Long> map  = new HashMap<>();
        for (int i = 0; i <n ; i++) {
            int diff=nums[i]-i;
            map.put(diff,map.getOrDefault(diff,0L)+1);
        }

        BigInteger res=new BigInteger("0");
        for (Integer i : map.keySet()) {
            long count=map.get(i);
            res.add(new BigInteger(String.valueOf((count*(count-1))/2)));
        }

        ;
        return (new BigInteger(String.valueOf((n*(n-1))/2)).subtract(res)).longValue();
    }


    public static void main(String[] args) {
        System.out.println(new T2364_countBadPairs().countBadPairs(new int[]{1,2,3,4,5}));
    }
}
