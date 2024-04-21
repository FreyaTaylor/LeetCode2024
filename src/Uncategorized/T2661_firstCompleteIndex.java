package src.Uncategorized;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T2661_firstCompleteIndex {

    /**
     * https://leetcode.cn/problems/first-completely-painted-row-or-column
     */


    public int firstCompleteIndex(int[] arr, int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.put(mat[i][j],new int[]{i,j});
            }
        }



        int[] hang = new int[m];
        int[] lie = new int[n];

        for (int i = 0; i < arr.length; i++) {
            int x = map.get(arr[i])[0];
            int y = map.get(arr[i])[1];

            hang[x]++;
            lie[y]++;

            if(hang[x]==n || lie[y]==m){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,8,7,4,1,3,5,6,9};
        int[][] mat = new int[][]{{3,2,5},{1,4,6},{8,7,9}};

        System.out.println(new T2661_firstCompleteIndex().firstCompleteIndex(arr,mat));
    }
}
