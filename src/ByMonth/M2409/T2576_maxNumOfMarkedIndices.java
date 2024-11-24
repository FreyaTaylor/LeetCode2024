package src.ByMonth.M2409;

import java.util.Arrays;

public class T2576_maxNumOfMarkedIndices {
    /**
     * https://leetcode.cn/problems/find-the-maximum-number-of-marked-indices/description/
     */

    public int maxNumOfMarkedIndices(int[] nums) {

        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));

        int res=0;
        for (int i = nums.length/2-1,j=nums.length-1; i >-1; i--,j--) {
//            System.out.println(i+" "+nums[i]+" "+nums[j]);
            if(nums[j]>=2*nums[i]){
                res++;

//                System.out.println(res);
            }else {
                j++;
            }
        }

        return res*2;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{42,83,48,10,24,55,9,100,10,17,17,99,51,32,16,98,99,31,28,68,71,14,64,29,15,40};
        System.out.println(new T2576_maxNumOfMarkedIndices().maxNumOfMarkedIndices(nums));
    }


}
