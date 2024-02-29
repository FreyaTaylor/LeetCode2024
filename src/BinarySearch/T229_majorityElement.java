package src.BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class T229_majorityElement {

    /**
     * https://leetcode.cn/problems/majority-element-ii/description/
     */

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums.length==1){
            res.add(nums[0]);
            return res;
        }
        int num1=nums[0];
        int i=1;
        while (i<nums.length && nums[i]==num1){i++;}

        if(i==nums.length){
            res.add(nums[0]);
            return res;
        }

        int count1=i;
        int num2=nums[i];
        int count2=0;
        int count3=0;

        for (; i < nums.length; i++) {
            int cur=nums[i];
            if(cur==num1){
                count1++;
            }else if(cur==num2){
                count2++;
            }else {
                count3++;
                if(count1<count3){
                     num1=cur;
                     int temp=count1;
                     count1=count3;
                     count3=temp;
                }else if(count2<count3){
                    num2=cur;
                    int temp=count2;
                    count2=count3;
                    count3=temp;
                }
            }

//            System.out.println();
        }

        count1=0;
        count2=0;
        for (int num : nums) {
            if(num==num1){
                count1++;
            }else if(num==num2){
                count2++;
            }
        }

        int need=(nums.length)/3;
        if(count1>need){res.add(num1);}
        if(count2>need){res.add(num2);}
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new T229_majorityElement().majorityElement(new int[]{1,1,1,2,3,7,8,1,6,9}));
        System.out.println(new T229_majorityElement().majorityElement(new int[]{4,2,1,1}));
    }

}
