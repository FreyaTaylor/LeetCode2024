package src.HereHash;

import java.util.*;

public class _T442_findDuplicates {

    /**
     * https://leetcode.cn/problems/find-all-duplicates-in-an-array/description/
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i]!=i+1){
                while (nums[i]!=nums[nums[i]-1]){
                    swap(nums,i,nums[i]-1);
                } // 每个整数出现 一次 或 两次 ,即总能将其移到目标位置 nums[i]-1
                if(i!=nums[i]-1){
                    set.add(nums[i]);
                }

            }
            System.out.println(Arrays.toString(nums));

        }
        return new ArrayList<>(set);
    }

    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }


    public static void main(String[] args) {
        System.out.println(new _T442_findDuplicates().findDuplicates(new int[]{4,3,2,7,8,2,3,1}));
    }
}
