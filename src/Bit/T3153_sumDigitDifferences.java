package src.Bit;

import java.util.HashMap;
import java.util.Map;

public class T3153_sumDigitDifferences {

    /**
     * https://leetcode.cn/problems/sum-of-digit-differences-of-all-pairs/description/
     */

    public long sumDigitDifferences(int[] nums) {
     int n=nums.length;
     int m= (int) Math.ceil( Math.log10(nums[0]+0.1));
     long res=0;

        for (int i = 0; i < m; i++) {

            int[] digits = new int[10];
            for (int j = 0; j < n; j++) {
                int digit = nums[j]%10;
                nums[j]/=10;
                digits[digit]++;
            }

            long tempSame=0;
            for (int j = 0; j < 10; j++) {
                if(digits[j]>1){
                    tempSame+=((long) digits[j]*(digits[j]-1))/2;
                }
            }
            res+=tempSame;
        }

        return (long) m*n*(n-1)/2-res;
    }


    public static void main(String[] args) {

        System.out.println(new T3153_sumDigitDifferences().sumDigitDifferences(
                new int[]{13,23,12}
        ));
    }
}
