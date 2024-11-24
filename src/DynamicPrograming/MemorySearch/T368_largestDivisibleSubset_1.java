package src.DynamicPrograming.MemorySearch;

import java.util.*;

public class T368_largestDivisibleSubset_1 {
    /**
     * https://leetcode.cn/problems/largest-divisible-subset/
     */

    int lds=0;
    int resindex=-1;
    Map<Integer,List<Integer>> dp = new HashMap<>();
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            helper(nums,i);
        }
        return dp.get(resindex);
    }

    public int helper(int[] nums,int i){
        if(dp.containsKey(i)){
            return dp.get(i).size();
        }

        int temp=0;
        int index=-1;
        for (int j = 0; j <i ; j++) {
            if(nums[i]%nums[j]==0 && helper(nums,j)>temp){
                temp=helper(nums,j);
                index=j;
            }
        }

        List<Integer> list;
        if(index==-1){
            list = new ArrayList<>();
        }else {
            list = new ArrayList<>(dp.get(index));
        }


        list.add(nums[i]);
        dp.put(i,list);
        temp++;


        if(temp>lds){
            lds=temp;
            resindex=i;
        }

        return temp;
    }


    public static void main(String[] args) {
        System.out.println(new T368_largestDivisibleSubset_1().largestDivisibleSubset(
                new int[]{1,2,4,8}
        ));
    }
}
