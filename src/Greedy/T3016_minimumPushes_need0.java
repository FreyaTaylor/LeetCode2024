package src.Greedy;

import java.util.Arrays;

public class T3016_minimumPushes_need0 {

    /**
     * https://leetcode.cn/problems/minimum-number-of-pushes-to-type-word-ii
     *
     * 思路：
     * 1.按照字母出现次数排序
     * 2.前八个字母分布在首位，接下来八个字母在次位，依次
     * @param word
     * @return
     */

    public int minimumPushes(String word) {
        int[] count = new int[26];
        for (int i = 0; i < word.length(); i++) {
            count[word.charAt(i)-'a']++;
        }

        Arrays.sort(count);

        int i=25;
        int res=0;

        int temp=0;
        int tempSum=0;
        while (i>-1 && temp<8 && count[i]>0) {
            tempSum+=count[i];
            i--;
            temp++;
        }
        res+=tempSum*1;

        temp=0;
        tempSum=0;
        while (i>-1 && temp<8 && count[i]>0) {
            tempSum+=count[i];
            i--;
            temp++;
        }
        res+=tempSum*2;

        temp=0;
        tempSum=0;
        while (i>-1 && temp<8 && count[i]>0) {
            tempSum+=count[i];
            i--;
            temp++;
        }
        res+=tempSum*3;

        temp=0;
        tempSum=0;
        while (i>-1 && temp<8 && count[i]>0) {
            tempSum+=count[i];
            i--;
            temp++;
        }
        res+=tempSum*4;


        return res;
    }

    public static void main(String[] args) {
        System.out.println(new T3016_minimumPushes_need0().minimumPushes("aabbccddeeffgghhiiiiii"));
    }
}
