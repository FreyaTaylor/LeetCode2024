package src.HereHash;

public class T42_firstMissingPositive {

    /**
     * https://leetcode.cn/problems/first-missing-positive/
     */

    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        for (int i = 0; i < n; i++) {
            if(nums[i]>0 && nums[i]<n+1 && nums[i]!=i+1 && nums[nums[i]-1]!=nums[i]){
                // i,和目标的index nums[i]-1，都是没匹配的，才swap，并且i--，重新判断交换后的i位置
                swap(nums,i,nums[i]-1);
                i--;
            }
        }

        for (int i = 0; i < n; i++) {
            if(nums[i]!=i+1){
                return i+1;
            }
        }

        return n+1;
    }

    public  void swap(int[] nums, int i,int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,8,9,11,12};

        System.out.println(new T42_firstMissingPositive().firstMissingPositive(nums));
    }

}
