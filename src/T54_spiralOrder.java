package src;

import java.util.ArrayList;
import java.util.List;

public class T54_spiralOrder {

    /**
     *   c     d
     * a
     *
     * b
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer>  res = new ArrayList<>();
        int a=0,b=matrix.length-1,c=0,d=matrix[0].length-1;

        while (a<=b && c<=d){

            //
            for (int i = c; i <=d ; i++) {
                res.add(matrix[a][i]);
            }

            for (int i = a+1; i <=b ; i++) {
                res.add(matrix[i][d]);
            }

            if(a!=b){
                for (int i = d-1; i >=c ; i--) {
                    res.add(matrix[b][i]);
                }
            }


            if(c!=d){
                for (int i =b-1;i >=a+1 ; i--) {
                    res.add(matrix[i][c]);
                }
            }

            a++;
            b--;
            c++;
            d--;
//            System.out.println();
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer>  res = new T54_spiralOrder().spiralOrder(matrix);
        System.out.println(res);

    }
}
