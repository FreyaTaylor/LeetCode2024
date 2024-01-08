package src.DynamicPrograming.MemorySearch;

import java.util.HashMap;
import java.util.Map;

public class T128_longestConsecutive {

    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])){
                map.put(nums[i],-1);
            }
        }

        int res = 0;
        for (int num:map.keySet()) {
//            System.out.println("----------------------");
//            System.out.println(num+" "+map.get(num));
            if(map.get(num)!=-1){
                res=Math.max(res,map.get(num));
            }else {
                res=Math.max(res,helper(map,num));
            }
//            System.out.println(num+" "+map.get(num));
        }

        return res;
    }

    public int helper(Map<Integer,Integer> map,int num){
        if(map.get(num)!=-1){
            return map.get(num);
        }else {
            if(!map.containsKey(num-1)){
                map.replace(num,1);
                return 1;
            }else {
                int res=helper(map,num-1);
                map.replace(num,res+1);
                return res+1;
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(new T128_longestConsecutive().longestConsecutive(new int[]{100,4,200,1,3,2}));
    }
}
