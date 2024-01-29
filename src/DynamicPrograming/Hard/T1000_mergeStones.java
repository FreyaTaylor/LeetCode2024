package src.DynamicPrograming.Hard;

import java.util.Arrays;

public class T1000_mergeStones {
    /**
     * https://leetcode.cn/problems/minimum-cost-to-merge-stones/
     *
     * Official solutions：
     * 1.memory dp:
     * dp[i][j][k]:[i,j] to k piles
     * dp[i][j][1]      = min{dp[i][p][1]+dp[p+1][j][k-1]} + sum[i,j]
     * dp[i][j][k not 1]=min{dp[i][p][1]+dp[p+1][j][k-1]}
     * initialize: dp[i][i][1]=0
     *
     * note 1: dp must divide the whole into two parts,1 and k-1, not 1,and 1 and 1 ,,,and 1
     * note 2: p=i not p=i+target-1,since one stone can be a pile !!!
     * note 3: for [1 2 3 4 5 6] into [1 2 (3 4 5) 6],the first pile is (1) !!!
     * note 4: 3d arr
     *
     *
     *
     * 2.dp
     * dp[i][j]: minimize step for most merge status
     * if (i-j-1)%(k-1)==0: dp[i][j] = min{dp[i][p]+dp[p+1][j]} + sum[i,j]
     * else: dp[i][j] = min{dp[i][p]+dp[p+1][j]}
     * initialize: dp[i][i][1]=0
     *
     * note 1:len = 1 2 3 4 5 is available,not only 1+(k-1)*?,which will induct -1
     * k=3,[1 2 3 4 5 ]:
     * [1, 2 3 4 5 ]; 1 is available but last 4 is not
     * [1 2 3, 4 5 ]; also 3 is available but last 2 is not
     * note 2: The value being used in dp must be meaningful !!
     *
     *
     */
//    public int mergeStones(int[] stones, int k) {
//
//        int n=stones.length;
//        if((n-1)%(k-1)!=0){return -1;}
//
//        int[][][] dp = new int[k+1][n][n];
//        for (int i = 0; i < k; i++) {
//            for (int j = 0; j < n; j++) {
//                Arrays.fill(dp[i][j],-1);
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            dp[1][i][i]=0;
//        }
//        int[] presum = new int[n+1];
//        for (int i = 1; i <n+1 ; i++) {
//            presum[i]=presum[i-1]+stones[i-1];
//        }
//
//        return helper( presum,stones,k,dp,0,n-1,1);
//    }
//
//    public int helper(int[] presum,int[] stones, int target,int[][][] dp,int i,int j,int k){
//        if(dp[k][i][j]!=-1){return dp[k][i][j];}
//
//        if(k==1){ // dp[i][j][1] = min{dp[i][p][1]+dp[p+1][j][k-1]} + sum[i,j]
//            int temp=Integer.MAX_VALUE;
//            for (int p = i; p <j ; p=p+target-1) {
//                // p=i not p=i+target-1,since one stone can be a pile
//                temp=Math.min(temp, helper(presum,stones,target,dp,i,p,1) +helper(presum,stones,target,dp,p+1,j,target-1));
//            }
//            dp[k][i][j]=temp+presum[j+1]-presum[i];
//        }else { // dp[i][j][k not 1]=min{dp[i][p][1]+dp[p+1][j][k-1]}
//            int temp=Integer.MAX_VALUE;
//            for (int p = i; p <j ; p=p+target-1) {
//                temp=Math.min(temp, helper(presum,stones,target,dp,i,p,1) +helper(presum,stones,target,dp,p+1,j,k-1));
//            }
//            dp[k][i][j]=temp;
//        }
//        return dp[k][i][j];
//    }

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

        for (int len = 2; len <=n; len++) { // len = 1 2 3 4 5 is available,not only 1+(k-1)*?,which will induct -1
            for (int i = 0; i <n && i+len-1<n ; i++) {
                int j=i+len-1;
                int temp=Integer.MAX_VALUE;
                for (int p = i; p <j ; p=p+k-1) {
                    temp=Math.min(temp,dp[i][p]+dp[p+1][j]);
                }
                if((j-i)%(k-1)==0){ //[i,j]:(j-i+1)-1
                    temp+=presum[j+1]-presum[i];
                }
                dp[i][j]=temp;
            }
        }

        return dp[0][n-1];
    }

    public static void main(String[] args) {
//        System.out.println(Integer.MAX_VALUE);
        System.out.println(new T1000_mergeStones().mergeStones(new int[]{1},2));
        System.out.println();
    }
}
