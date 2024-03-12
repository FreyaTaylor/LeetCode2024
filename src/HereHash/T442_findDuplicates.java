package src.HereHash;

import java.util.*;

public class T442_findDuplicates {

    /**
     * https://leetcode.cn/problems/find-all-duplicates-in-an-array/description/
     * @param nums
     * @return
     */
//    public List<Integer> findDuplicates(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i <nums.length ; i++) {
//            System.out.println(i);
//            if (nums[i]!=i+1){
//                while (nums[i]!=nums[nums[i]-1]){
//                    swap(nums,i,nums[i]-1);
//                } // 每个整数出现 一次 或 两次 ,即总能将其移到目标位置 nums[i]-1
//                if(i!=nums[i]-1){
//                    set.add(nums[i]);
//                }
//
//            }
//            System.out.println(Arrays.toString(nums));
//
//        }
//        return new ArrayList<>(set);
//    }


//    public List<Integer> findDuplicates(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            while (nums[i]!=i+1 && nums[nums[i]-1]!=nums[i]){ //i 和 nums[i]-1 都不匹配
//                swap(nums,i,nums[i]-1);
//            }
//        }
//
//        List<Integer> res = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            if(nums[i]!=i+1){
//                res.add(nums[i]);
//            }
//        }
//
//        return res;
//    }

    /**
     * nums[x - 1] <0,表示出现过数字 x
     * 即用符号表示 某个数字是否存在！！！！！把一个数字当两个用
     */
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            int x = Math.abs(nums[i]);
            if (nums[x - 1] > 0) {
                nums[x - 1] = -nums[x - 1];
            } else {
                ans.add(x);
            }
            System.out.println(Arrays.toString(nums));
        }
        return ans;
    }




    public static void main(String[] args) {
        System.out.println(new T442_findDuplicates().findDuplicates(new int[]{4,3,2,7,8,2,3,1}));
    }
}
