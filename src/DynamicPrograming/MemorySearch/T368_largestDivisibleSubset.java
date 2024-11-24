package src.DynamicPrograming.MemorySearch;

import java.util.*;

public class T368_largestDivisibleSubset {
    /**
     * https://leetcode.cn/problems/largest-divisible-subset/
     */


    Map<Integer,List<Integer>> dp = new HashMap<>();
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {

            // 计算i的dp
            int temp=0;
            int index=-1;
            for (int j = 0; j <i ; j++) {
                if(nums[i]%nums[j]==0 && dp.get(j).size()>temp){
                    temp=dp.get(j).size();
                    index=j;
                }
            }

            // 记录i的dp：最优前缀
            List<Integer> list;
            if(index==-1){
                list = new ArrayList<>();
            }else {
                list = new ArrayList<>(dp.get(index));
            }
            // 记录i的dp：拼接i
            list.add(nums[i]);
            dp.put(i,list);

        }


        int lds=0;
        int resindex=-1;
        // 进行最终结果的比较
        for (int i = 0; i < nums.length; i++) {

            if(dp.get(i).size()>lds){
                lds=dp.get(i).size();
                resindex=i;
            }

        }


        return dp.get(resindex);
    }




    public static void main(String[] args) {
        System.out.println(new T368_largestDivisibleSubset().largestDivisibleSubset(
                new int[]{1,2,4,8}
        ));
    }
}
