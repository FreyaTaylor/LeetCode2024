package src.BinarySearch;

public class T33_search {
    /**
     * https://leetcode.cn/problems/search-in-rotated-sorted-array/
     */

    public int search(int[] nums, int target) {

        int l=0,r=nums.length-1;
        while (l<r){
            int mid=(r-l)/2+l;
            if(nums[mid]>=nums[l]){
                if(target>=nums[l] && target<=nums[mid]){
                    r=mid;
                }else {
                    l=mid+1;
                }

            }else {
                if(target>=nums[mid] && target<=nums[r]){
                    l=mid;
                }else {
                    r=mid-1;
                }
            }


        }

        if(l>=0 && l<nums.length && nums[l]==target){
            return l;
        }

        return -1;
    }


    public static void main(String[] args) {

        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 0;

        nums = new int[]{4,5,6,7,0,1,2};
        target = 3;

        nums = new int[]{1};
        target = 0;

        nums = new int[]{1,3};
        target = 2;

//        nums = new int[]{3,1};
//        target = 1;


        System.out.println(new T33_search().search(nums,target));
    }
}
