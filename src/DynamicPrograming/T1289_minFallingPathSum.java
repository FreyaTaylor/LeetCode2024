package src.DynamicPrograming;

import src.BinaryTree.TreeNode;

import java.util.TreeMap;

public class T1289_minFallingPathSum {


    /**
     https://leetcode.cn/problems/minimum-falling-path-sum-ii/
     *
     */

    public int minFallingPathSum(int[][] grid) {

        int n = grid.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[0][i]=grid[0][i];
        }

        for (int i = 1; i < n; i++) {

            int minv=Integer.MAX_VALUE;
            int mini=Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if(dp[i-1][j]<minv){
                    minv=dp[i-1][j];
                    mini=j;
                }
            }

            for (int j = 0; j < n; j++) {
                if(j==mini){
                    continue;
                }
                dp[i][j]=grid[i][j]+minv;
            }

            int minvoni=Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if(j==mini){
                    continue;
                }
                minvoni=Math.min(minvoni,dp[i-1][j]);
            }
            dp[i][mini]=minvoni+grid[i][mini];


        }


        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res=Math.min(res,dp[n-1][i]);
        }

        return res;
    }



    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}};

        System.out.println(new T1289_minFallingPathSum().minFallingPathSum(grid));

    }
}
