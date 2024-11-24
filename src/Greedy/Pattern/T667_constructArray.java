package src.Greedy.Pattern;

import java.util.Arrays;

public class T667_constructArray {

    /**
     * https://leetcode.cn/problems/beautiful-arrangement-ii/description/
     * k=1:1,2,3,...n,
     * k=n-1:n,1,n-1,2,...
     * k=m:   n,n-1,...,m+2,m+1,1,m-2,2,...
     */
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];

        int index=0;
        int num = n;
        for (; num >=k+2 ; num--) {
            res[index++]=num;
        }
        int num1=1;
        while (index<n){
            res[index++]=num--;
            if(index<n){
                res[index++]=num1++;
            }

        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new T667_constructArray().constructArray(3,2)));
    }
}
