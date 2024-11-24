package src.BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class T229_majorityElement_1 {

    /**
     * https://leetcode.cn/problems/majority-element-ii/description/
     */

    public List<Integer> majorityElement(int[] nums) {
       int max1num=Integer.MAX_VALUE;
       int max1count=0;
       int max2num=Integer.MAX_VALUE;
       int max2count=0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==max1num){
                max1count++;
            }else if(nums[i]==max2num){
                max2count++;
            }else{

                if(max1count>0 && max2count>0){
                    max1count--;
                    max2count--;
                }else if(max1count<=0) {
                        max1num = nums[i]; //这里模拟将max1num换为nums[i]，然后++的操作
                        max1count = 1;
                }else if(max2count<=0) {
                    max2num = nums[i];
                    max2count = 1;

                }


            }
        }



        int count1=0;
        int count2=0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==max1num){
                count1++;
            }
            if(nums[i]==max2num){
                count2++;
            }
        }

        List<Integer> res = new ArrayList<>();
        if(count1>nums.length/3){
            res.add(max1num);
        }
        if(count2>nums.length/3){
            res.add(max2num);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new T229_majorityElement_1().majorityElement(new int[]{1,1,1,2,3,7,8,1,6,9}));
        System.out.println(new T229_majorityElement_1().majorityElement(new int[]{4,2,1,1}));
        System.out.println(new T229_majorityElement_1().majorityElement(new int[]{111}));
    }

}
