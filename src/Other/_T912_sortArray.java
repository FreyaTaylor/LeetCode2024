package src.Other;

import java.util.Arrays;

public class _T912_sortArray {
    /**
     * https://leetcode.cn/problems/sort-an-array/
     */

    public int[] sortArray(int[] nums) {
        quick(nums,0,nums.length-1);
        return nums;
    }
    public void quick(int[] nums,int l,int r){
        System.out.println(l+" "+r);
        int mark=nums[l];
        int i=l+1;
        int j=r;

        while (i<j){
            while (i<j && nums[i]<=mark){i++;}
            while (i<j && nums[j]>mark){j--;}
            if(i<j){
                swap(nums,i,j);
            }
        }

        if(i==j){
            if(nums[i]<=mark){
                swap(nums,i,l);
                i--;
            }

        }else {
            i--;
        }
        System.out.println(Arrays.toString(nums));
        quick(nums,l,i);
        quick(nums,i+1,r);
    }

    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args) {
        new _T912_sortArray().sortArray(new int[]{5,2,3,1});
    }
}
