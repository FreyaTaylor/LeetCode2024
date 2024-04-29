package src.Traverse;

import java.util.Arrays;

public class T48_rotate {

    /**
     * https://leetcode.cn/problems/rotate-image/
     */

    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for (int i = 0; i <n/2 ; i++) {

            for (int j = i; j < n-1-i; j++) {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[n-1-j][i];
                matrix[n-1-j][i]=matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j]=matrix[j][n-1-i];
                matrix[j][n-1-i]=temp;


            }
        }

    }


    public static void main(String[] args) {
        int[][]matrix = new int[][]{
                {5,1,9,11},
                {2,4,8,10},
                {13,3,6,7},
                {15,14,12,16}};

        new T48_rotate().rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

}
