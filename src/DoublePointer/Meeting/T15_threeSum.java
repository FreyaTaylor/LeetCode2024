package src.DoublePointer.Meeting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T15_threeSum {

    /**
     *
     */

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res =new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int a = nums[i];
            int target=-a;
            int l=i+1;
            int r=nums.length-1;
            while (l<r){
//                System.out.println(l+" "+r);
                if(nums[l]+nums[l+1]>target || nums[r]+nums[r-1]<target){
                    break;
                }
                if(nums[l]+nums[r]==target){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    res.add(temp);

                    l++;
                    while (l<r && nums[l]==nums[l-1]){
                        l++;
                    }

                    r--;
                    while (l<r && nums[r]==nums[r+1]){
                        r--;
                    }
                }else if(nums[l]+nums[r]<target){
                    l++;
                    while (l<r && nums[l]==nums[l-1]){
                        l++;
                    }
                }else {
                    r--;
                    while (l<r && nums[r]==nums[r+1]){
                        r--;
                    }
                }



            }
        }

        return res;
    }



    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> res = new T15_threeSum().threeSum(nums);
        System.out.println(res.toString());

    }
}
