package src.Other.Sort;

import java.util.Random;

public class T912_sortArray_1 {

    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
    }

    public void quickSort(int[] nums, int l, int r){
        if(l>=r){return;}
        int index=new Random().nextInt(r-l+1)+l;
        swap(nums,l,index);
        int mark=nums[l];

        int i=l+1,j=r;
        while (i<j){
            while (i<j && nums[i]<=mark){i++;}
            while (i<j && nums[j]>=mark){j--;}

            if(i<j){
                swap(nums,i,j);
            }
        }

        if(nums[i]>mark){
            i--;
        }

        swap(nums,l,i);
        quickSort(nums,l,i-1);
        quickSort(nums,i+1,r);

    }

    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

}
