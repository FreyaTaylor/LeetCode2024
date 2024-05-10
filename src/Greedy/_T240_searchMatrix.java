package src.Greedy;

public class _T240_searchMatrix {

    /**
     * https://leetcode.cn/problems/search-a-2d-matrix-ii/description/
     */

    public boolean searchMatrix(int[][] matrix, int target) {

        int m=matrix.length;
        int n=matrix[0].length;

        int i=0,j=n-1;
        while (i<m && j>-1){
            //左下角至matrix[i][j] ！！相当于每次二分把中间节点选在最右上，因此每次只排除一行/列的数据
            if(matrix[i][j]==target){
                return true;
            }else if(matrix[i][j]<target){
                i++;
            }else {
                j--;
            }
        }

        return false;
    }


}
