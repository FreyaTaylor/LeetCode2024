package src.Uncategorized;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeSet;

public class T363_maxSumSubmatrix {


    /**
     * https://leetcode.cn/problems/max-sum-of-rectangle-no-larger-than-k/
     *
     *                     long need = height[j+1]-k-1;
     *                     Long higher = treeSet.higher(need); //> height[j+1]-k-1，即>=height[j+1]-k
     */

    public int maxSumSubmatrix(int[][] matrix, int k) {

        int m = matrix.length;
        int n = matrix[0].length;
        long [] height;

        long res = Integer.MIN_VALUE;
        for (int istart = 0;  istart< m; istart++) {
            height = new long[n+1];
            for (int iend = istart; iend<m;iend++) {
                TreeSet<Long> treeSet = new TreeSet<>();
                treeSet.add(0L);
                int preSum=0;
                for (int j = 0; j < n ; j++) {
                    preSum+=matrix[iend][j];
                    height[j+1]+=preSum;
                    long need = height[j+1]-k-1;
                    Long higher = treeSet.higher(need); //> height[j+1]-k-1，即>=height[j+1]-k

                    if(higher!=null){
                        res= Math.max(res,height[j+1]-higher);
                    }
                    treeSet.add(height[j+1]);
                }
                System.out.println(Arrays.toString(height));
            }
        }

        return (int) res;
    }




    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,0,1},{0,-2,3}};
        int k = 2;

//        matrix = new int[][]{{2,2,-1}};
//        k = 3;

        System.out.println(new T363_maxSumSubmatrix().maxSumSubmatrix(matrix,k));
//        System.out.println(Integer.MAX_VALUE);
    }

}
