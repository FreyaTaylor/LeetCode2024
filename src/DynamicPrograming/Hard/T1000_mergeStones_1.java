package src.DynamicPrograming.Hard;

import java.util.Arrays;

public class T1000_mergeStones_1 {
   
    public int mergeStones(int[] stones, int k) {
        int n=stones.length;
        if((n-1)%(k-1)!=0){return -1;}

        int[] presum = new int[n+1];
        for (int i = 1; i <n+1 ; i++) {
            presum[i]=presum[i-1]+stones[i-1];
        }

        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i],-1);
        }
        for (int i = 0; i < n; i++) {
            dp[i][i]=0;
        }

        for (int len = 2; len <n ; len++) {
            for (int i = 0; i <n-len+1 ; i++) {
                int j=i+len-1;
                int temp=Integer.MAX_VALUE;
//                for (int l = i; l <j ; l++) {
//                    if()
//                }
                
                dp[i][j]=temp;
            }
        }

        return dp[0][n-1];
    }

    public static void main(String[] args) {
//        System.out.println(Integer.MAX_VALUE);
        System.out.println(new T1000_mergeStones_1().mergeStones(new int[]{1},2));
        System.out.println();
    }
}
