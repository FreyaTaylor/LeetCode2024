package src.BinarySearch;

public class T1060_missingElement {
    /**
     * https://leetcode.cn/problems/missing-element-in-sorted-array/
     */
    public int missingElement(int[] nums, int k) {

        int l=0,r=nums.length-1;
        while (l+1<r){
            int mid = l+(r-l)/2;
            int lmiss=(nums[mid]-nums[l])-(mid-l);
            if(lmiss<k){
                l=mid;
                k-=lmiss;
            }else {
                r=mid;
            }
        }

        if(l==r){
            return nums[l]+k;
        }else {
            if(nums[l]+k<nums[r]){
                return nums[l]+k;
            }else {
                return nums[l]+k+1;
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(new T1060_missingElement().missingElement(new int[]{1,3,4},4));
    }


}
