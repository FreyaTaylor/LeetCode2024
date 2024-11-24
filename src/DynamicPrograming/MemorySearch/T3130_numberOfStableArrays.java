package src.DynamicPrograming.MemorySearch;

import java.util.Arrays;
import java.util.Map;

public class T3130_numberOfStableArrays {

    /**
     * https://leetcode.cn/problems/find-all-possible-stable-binary-arrays-ii/description/
     *
     */

    int mod = (int) Math.pow(10,9)+7;
    public int numberOfStableArrays(int zero, int one, int limit) {

        int[][][] dp = new int[2][zero+1][one+1];

        for (int i = 0; i < zero+1; i++) {
            Arrays.fill(dp[0][i],-1);
            Arrays.fill(dp[1][i],-1);
        }

        // 初始化
        // 只有一种元素，
        for (int i = 0; i < one+1; i++) {
            dp[0][0][i]=0;
            dp[1][0][i]=0;
        }
        for (int i = 0; i < zero+1; i++) {
            dp[0][i][0]=0;
            dp[1][i][0]=0;
        }
        // 只有一种元素，只有符合limit限制时，有一种排列方式
        for (int i = 1; i <Math.min(limit,zero)+1 ; i++) {
            dp[0][i][0]=1;
        }
        for (int i = 1; i <Math.min(limit,one)+1 ; i++) {
            dp[1][0][i]=1;
        }

        // 以01为尾，更深含义是后续可接另一种数，从这个意义上讲，00是1
        dp[0][0][0]=1;
        dp[1][0][0]=1;


        int res=(helper(dp,zero,one,0,limit)+ helper(dp,zero,one,1,limit))%mod;

        return res;
    }

    public int helper(int[][][] dp,int i,int j,int tail,int limit){


        if(dp[tail][i][j]!=-1){
            return dp[tail][i][j];
        }

        int temp=0;
        if(tail==1){
            if(j-1>-1){
                //[...0] 1
                temp+=helper(dp,i,j-1,0,limit);
                temp%=mod;

                //[...1] 1
                temp+=helper(dp,i,j-1,1,limit);
                temp%=mod;

                //[...0]...111(limit+1)
                if(j-limit-1>=0){
                    temp=temp-helper(dp,i,j-1-limit,0,limit)+mod;
                    temp%=mod;
                }
            }

        }else {
            if(i-1>-1){
                //[...1] 0
                temp+=helper(dp,i-1,j,1,limit);
                temp%=mod;

                //[...0] 0
                temp+=helper(dp,i-1,j,0,limit);
                temp%=mod;

                //[...1]...000(limit+1)
                if(i-limit-1>=0){
                    temp=temp-helper(dp,i-limit-1,j,1,limit)+mod;
                    temp%=mod;
                }
            }

        }

        dp[tail][i][j]=temp;
//        System.out.println(tail+" "+i+" "+j+" :"+dp[tail][i][j]);
        return temp;
    }


    public static void main(String[] args) {
        System.out.println(new T3130_numberOfStableArrays().numberOfStableArrays(1,4,2));
        // 11011
    }
}
