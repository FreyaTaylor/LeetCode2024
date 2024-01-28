package src.DynamicPrograming.MatryoshkaDolls;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MST0813_pileBox {
    /**
     * https://leetcode.cn/problems/pile-box-lcci/
     *
     * refer to T354
     */
    public int pileBox(int[][] box) {
        if(box.length<2){return box.length;}
        Arrays.sort(box, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]!=o2[0]){
                    return o1[0]-o2[0];
                }else if(o1[1]!=o2[1]){
                    return o2[1]-o1[1];
                }else {
                    return o2[2]-o1[2];
                }
            }
        });

        int n=box.length;
        int[] dp = new int[n];
        dp[0]=box[0][2];
        int res=dp[0];
        for (int i = 1; i <n ; i++) {
            int temp=0;
            for (int j = 0; j < i; j++) {
                if(box[j][2]<box[i][2]&&box[j][1]<box[i][1]){
                    temp=Math.max(temp,dp[j]);
                }
            }
            dp[i]=temp+box[i][2];
            res=Math.max(res,dp[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[][]box =new int[][]{{1, 1, 1},{2, 3, 4},{2, 6, 7},{3, 4, 5}};
        System.out.println(new MST0813_pileBox().pileBox(box));
    }
}
