package src.BinarySearch;

public class T540_singleNonDuplicate_1 {

    /**
     * https://leetcode.cn/problems/single-element-in-a-sorted-array/
     * 二分：边界+完备的分情况讨论
     */

    public int singleNonDuplicate(int[] nums) {
        int l=0,r=nums.length-1;

        while (l+1<r){
            int mid=(l+r+1)/2;

            if((mid-l+1)%2==0){
                if(nums[mid]==nums[mid-1]){
                    l=mid+1;
                }else {
                    r=mid;
                }
            }else {
                if(nums[mid]==nums[mid-1]){
                    r=mid-2;
                }else {
                    l=mid;
                }
            }
        }

        return nums[l];
    }

    public static void main(String[] args) {
        System.out.println(new T540_singleNonDuplicate_1().singleNonDuplicate(new int[]{
                3,3,7,7,10,11,11}));
    }
}
