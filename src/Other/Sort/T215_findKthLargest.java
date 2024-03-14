package src.Other.Sort;

import java.util.Arrays;
import java.util.Random;

public class T215_findKthLargest {

    /**
     * https://leetcode.cn/problems/kth-largest-element-in-an-array/
     */
    public int findKthLargest(int[] nums, int k) {
        return quick(nums,0,nums.length-1,nums.length-k+1);
    }

    public int quick(int[] nums, int l, int r,int k){
        System.out.println(Arrays.toString(nums));
        System.out.println(l+" "+r+" "+k);

        if(l==r){return nums[l];}

//        int index = new Random().nextInt(r-l+1)+l;
//        swap(nums,l,index);



        int mark=nums[l];
        int i=l+1;
        int j=r;
        while (i<j){
            while (i<j && nums[i]<=mark){i++;}
            while (i<j && nums[j]>=mark){j--;}
            swap(nums,i,j);
        }


        if(nums[i]>mark){ // mark 小（i-1小） （i大）大
            i--;
        }
        // mark 小（i小） （i+1大）大
        swap(nums,l,i);
        // 小 i(mark) 大 第i小
        if((i-l)+1<k){
            return quick(nums,i+1,r,k-(i-l)-1);
        }else if((i-l)+1>k){
            return quick(nums,l,i-1,k);
        }else {
            return mark;
        }

    }

    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args) {
        System.out.println(new T215_findKthLargest().findKthLargest(new int[]{1},1));
//        System.out.println(new T215_findKthLargest().findKthLargest(new int[]{3,2,1,5,6,4},2));
//        System.out.println(new T215_findKthLargest().findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4));
    }
}
