package src.DynamicPrograming.MemorySearch;

import java.util.HashMap;
import java.util.Map;

public class T403_canCross {
    /**
     * https://leetcode.cn/problems/frog-jump/
     */
    public boolean canCross(int[] stones) {
        Map<Integer,Boolean> dp = new HashMap<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i],i);
        }
        if(stones[1]!=1){
            return false;
        }
        return helper(stones,dp,map,1,1);
    }

    public boolean helper(int[] stones,Map<Integer,Boolean> dp,Map<Integer,Integer> map,int cur,int k){
        System.out.println(cur+" "+k);
        // already calculated
        if(dp.containsKey(cur*10000+k)){
            return dp.get(cur*10000+k);
        }

        // not calculated yet, quick condition
        if(cur==stones.length-1){
            dp.put(cur*10000+k,true);
            return true;
        }
        // next step k-1~k+1
        for (int i = k-1; i <k+2 ; i++) {
            if(map.containsKey(stones[cur]+i)){
                if(i>0 && helper(stones,dp,map,map.get(stones[cur]+i),i)){
                    dp.put(cur*10000+k,true);
                    return true;
                }

            }
        }
        dp.put(cur*10000+k,false);
        return false;
    }


    public static void main(String[] args) {
        System.out.println(new T403_canCross().canCross(new int[]{0,1,3,6,10,13,15,18}));
    }
}
