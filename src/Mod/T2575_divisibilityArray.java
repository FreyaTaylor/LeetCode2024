package src.Mod;

import java.util.Arrays;

public class T2575_divisibilityArray {

    /**
     * https://leetcode.cn/problems/find-the-divisibility-array-of-a-string/
     *
     *
     */

    public int[] divisibilityArray(String word, int m) {

        int n = word.length();
        int[] res = new int[n];
        long cur = 0;
        for (int i = 0; i <n ; i++) {
            // cur=a*10+b ,mod(cur)=mod(a*10+b)=mod(mod(a)*10+b)=mod(pre*10+b)
            // cur=(pre*10+word.charAt(i)-'0')%m;
            // cur=((pre*10)%m+word.charAt(i)-'0')%m;
            // 因为 pre*10 10的10次方，需要用long
            cur=(cur*10+word.charAt(i)-'0')%m;
            if(cur==0){
                res[i]=1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new T2575_divisibilityArray()
                .divisibilityArray("1010",10)));
    }
}
