package src.HereHash;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class MST_missingTwo {
    /**
     * https://leetcode.cn/problems/missing-two-lcci/
     */
    public int[] missingTwo(int[] nums) {

        int n=nums.length+2;
        int a=Integer.MAX_VALUE;
        int b=Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int num=Math.abs(nums[i]);
            if(num==n-1){
                a=-1;
            }else if(num==n){
                b=-1;
            }else {
                nums[num-1]=-nums[num-1];
            }
        }

        int count=0;
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0){
                res[count++]=i+1;
            }
        }
        if(a>0){
            res[count++]=n-1;
        }
        if(b>0){
            res[count++]=n;
        }

        return res;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new MST_missingTwo().missingTwo(new int[]{3,4})));
    }

}
