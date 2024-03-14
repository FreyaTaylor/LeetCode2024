package src.Other.Sort;

import java.util.Random;

public class T912_sortArray {
    /**
     * https://leetcode.cn/problems/sort-an-array/
     */

    public int[] sortArray(int[] nums) {
        quick(nums,0,nums.length-1);
        return nums;
    }
    public void quick(int[] nums,int l,int r){

        if(l>=r){return;}
        // 随机化
        int index=new Random().nextInt(r-l+1)+l;
        swap(nums,index,l);

        int mark=nums[l];
        int i=l+1;
        int j=r;

//        System.out.println(Arrays.toString(nums));

        while (i<j){
            while (i<j && nums[i]<=mark){i++;}
            while (i<j && nums[j]>=mark){j--;}
            if(i<j){
                swap(nums,i,j);
            }
        }


//        System.out.println(Arrays.toString(nums));
//        if(nums[i]>mark){ // mark 小（i-1小） （i大）大
//            swap(nums,l,i-1);
//            quick(nums,l,i-2);
//            quick(nums,i,r);
//        }else { // mark 小（i小） （i+1大）大
//            swap(nums,l,i);
//            quick(nums,l,i-1);
//            quick(nums,i+1,r);
//        }

        if(nums[i]>mark){
            i--;
        }
        swap(nums,l,i);
        quick(nums,l,i-1);
        quick(nums,i+1,r);

    }

    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args) {
//        new _T912_sortArray().sortArray(new int[]{5,2,3,1});
        new T912_sortArray().sortArray(new int[]{5,1,1,2,0,0});
    }
}
