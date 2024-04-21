package src.Uncategorized;

import java.util.Arrays;
import java.util.Map;

public class T2344_minOperations {

    /**
     * https://leetcode.cn/problems/minimum-deletions-to-make-array-divisible/
     * numsDivide 的最大公因数key=2*3*5，在nums中如何凑出最小的key的最小因数
     */

    public int minOperations(int[] nums, int[] numsDivide) {

        int key=numsDivide[0];
        for (int i = 1; i < numsDivide.length; i++) {
            key = gys(Math.max(key,numsDivide[i]), Math.min(key,numsDivide[i]));
//            System.out.println(key);
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(key%nums[i]==0){
                return i;
            }
        }

        return -1;
    }

    public  int gys(int a, int b){
        if(b>0){
            return gys(b,a%b);
        }
        return a;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2,3,2,4,3};
        int[] numsDivide = new int[]{9,6,9,3,15};

//        nums = new int[]{4,3,6};
//        numsDivide = new int[]{8,2,6,10};



        System.out.println(new T2344_minOperations().minOperations(nums,numsDivide));
    }
}
