package src.Other;

import java.util.Arrays;

public class T1921_eliminateMaximum {
    /**
     * https://leetcode.cn/problems/eliminate-maximum-number-of-monsters/
     */

    public int eliminateMaximum(int[] dist, int[] speed) {


        double[] time = new double[dist.length];
        for (int i = 0; i < dist.length; i++) {
            time[i]=(double) dist[i]/speed[i];
        }
        Arrays.sort(time);


        for (int i = 0; i < time.length; i++) {
            if(time[i]<=i){
                return i;
            }
        }
        return dist.length;
    }

    public static void main(String[] args) {
        System.out.println(new T1921_eliminateMaximum().eliminateMaximum(
                new int[]{3,2,4},
                new int[]{5,3,2}
        ));
    }
}
