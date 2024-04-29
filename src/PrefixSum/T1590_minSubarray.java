package src.PrefixSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class T1590_minSubarray {
    /**
     * https://leetcode.cn/problems/make-sum-divisible-by-p/
     * 前缀和，但是%
     */

    public int minSubarray(int[] nums, int p) {

        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);

        long sum=0;
        for (int i = 0; i <nums.length ; i++) {
            sum=sum+nums[i];
        }
        int target=(int) (sum%(long)p);


        if(target==0){
            return 0;
        }

        int res = Integer.MAX_VALUE;
        int curSum = 0;
        for (int i = 0; i <nums.length ; i++) {
            curSum = (curSum+nums[i])%p;
            int need = (curSum+p-target)%p;
            if(map.containsKey(need)){
                res= Math.min(res,i-map.get(need));
            }

            map.put(curSum,i);
//            System.out.println();
        }


        if(res==Integer.MAX_VALUE || res==nums.length){
            return -1;
        }else {
            return res;
        }
    }


//    public int minSubarray(int[] nums, int p) {
//
//        int[] indexs = new int[p];
//        Arrays.fill(indexs,Integer.MAX_VALUE);
//        indexs[0]=-1;
//
//        long sum=0;
//        for (int i = 0; i <nums.length ; i++) {
//            sum=sum+nums[i];
//        }
//        int target=(int) (sum%(long)p);
//
//
//        if(target==0){
//            return 0;
//        }
//
//        int res = Integer.MAX_VALUE;
//        int curSum = 0;
//        for (int i = 0; i <nums.length ; i++) {
//            curSum = (curSum+nums[i])%p;
//            int need = (curSum+p-target)%p;
//            if(indexs[need]!=Integer.MAX_VALUE){
//                res= Math.min(res,i-indexs[need]);
//            }
//
//            indexs[curSum]=i;
//            System.out.println();
//        }
//
//
//        if(res==Integer.MAX_VALUE || res==nums.length){
//            return -1;
//        }else {
//            return res;
//        }
//    }




    public static void main(String[] args) {
        int[] nums = new int[]{6,3,5,2};
        int p = 9;


        nums = new int[]{1,2,3};
        p = 3;

        p = 5;
        p = 4;


        nums = new int[]{1000000000,1000000000,1000000000};
        p = 3;


        System.out.println(new T1590_minSubarray().minSubarray(nums,p));
    }
}
