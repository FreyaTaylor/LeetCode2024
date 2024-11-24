package src.HereHash;

import java.util.Arrays;

public class MST_17_19_missingTwo_1 {
    /**
     * https://leetcode.cn/problems/missing-two-lcci/
     */
    public int[] missingTwo(int[] nums) {

        int n=nums.length;
        int a=Integer.MAX_VALUE; // N+1
        int b=Integer.MAX_VALUE; // N+2

        for (int i = 0; i < n; i++) {
            if(nums[i]!=i+1 && nums[i]!=n+3){
                if(nums[i]==n+1){
                    a=n+1;
                    nums[i]=n+3;
                }else if(nums[i]==n+2){
                    b=n+2;
                    nums[i]=n+3;
                }else {
                    // i nums[i]-1
                    int temp=nums[nums[i]-1];
                    nums[nums[i]-1]=nums[i];
                    nums[i]=temp;
                    i--;

                }
            }
        }

        int[]  res=new int[2];
        int index=0;
        for (int i = 0; i < n; i++) {
            if(nums[i]==n+3){
                res[index++]=i+1;
            }
        }

        if(a==Integer.MAX_VALUE){
            res[index++]=n+1;
        }

        if(b==Integer.MAX_VALUE){
            res[index++]=n+2;
        }

        return res;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new MST_17_19_missingTwo_1().missingTwo(
                new int[]{1, 2, 3, 4, 6, 7, 9, 10})));
    }

}
