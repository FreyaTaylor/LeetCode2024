package src.PrefixSum;

import java.util.Arrays;

public class T1314_matrixBlockSum {
    /**
     *
     * https://leetcode.cn/problems/matrix-block-sum/description/
     */

    public int[][] matrixBlockSum(int[][] mat, int k) {

        int n=mat.length,m=mat[0].length;

        int[][] psum = new int[n+1][m+1];  //[0,i-1][0,j-1]


        for (int i = 1; i <n+1 ; i++) {
            int lineSum=0;
            for (int j = 1; j <m+1 ; j++) {
                lineSum+=mat[i-1][j-1];
                psum[i][j]=psum[i-1][j]+lineSum;
            }
        }

        int[][] res = new int[n][m];

        for (int i = 1; i <n+1 ; i++) {
            for (int j = 1; j <m+1 ; j++) {
                int i1=Math.max(0,i-k-1);
                int i2=Math.min(n,i+k);
                int j1=Math.max(0,j-k-1);
                int j2=Math.min(m,j+k);
                res[i-1][j-1]=psum[i2][j2]-psum[i1][j2]-psum[i2][j1]+psum[i1][j1];
            }
        }


        return res;

    }

    public static void main(String[] args) {
        int[][]mat = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int k = 2;

        int[][] res = new T1314_matrixBlockSum().matrixBlockSum(mat,k);
        System.out.println(Arrays.deepToString(res));
    }
}
