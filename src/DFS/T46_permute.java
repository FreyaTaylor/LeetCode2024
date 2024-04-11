package src.DFS;

import java.util.ArrayList;
import java.util.List;

public class T46_permute {

    /**
     * https://leetcode.cn/problems/permutations/
     */

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> nums_ = new ArrayList<>();
        for (int num : nums) {
            nums_.add(num);
        }
        dfs(res,nums_,0);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> nums, int i){
        if(i>=nums.size()){
//            System.out.println(nums.toString());
            res.add(new ArrayList<>(nums));
            return;
        }

        dfs(res,nums,i+1);
        for (int j = i+1; j <nums.size() ; j++) {
            swap(nums,i,j);
            dfs(res,nums,i+1);
            swap(nums,i,j);
        }

    }

    public void swap(List<Integer> nums,int i,int j){
        int temp = nums.get(i);
        nums.set(i,nums.get(j));
        nums.set(j,temp);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> res = new T46_permute().permute(nums);
        System.out.println(res);

    }
}
