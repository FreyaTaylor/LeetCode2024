package src.BinaryTree;

import java.util.*;

public class T2509_cycleLengthQueries {

    /**
     *             Integer -128~127是int，可以用==比较，其他必须用.equals
     *             System.out.println((Integer)(-128)==(Integer)(-128));
     *             System.out.println((Integer)(127)==(Integer)(127));
     *             System.out.println((Integer)(128)==(Integer)(128));
     */

    public int[] cycleLengthQueries(int n, int[][] queries) {
        int[] res = new int[queries.length];
        Deque<Integer> xx;
        Deque<Integer> yy;

        for (int i = 0; i < queries.length; i++) {
            int x=queries[i][0];
            int y=queries[i][1];
            xx = new ArrayDeque<>();
            yy = new ArrayDeque<>();

            while (x>0){
                xx.addFirst(x);
                x=x/2;
            }

            while (y>0){
                yy.addFirst(y);
                y=y/2;
            }
//            System.out.println();

//            while (!xx.isEmpty() && !yy.isEmpty() && xx.getFirst()==yy.getFirst()){
            while (!xx.isEmpty() && !yy.isEmpty() && xx.getFirst().equals(yy.getFirst())){
                xx.removeFirst();
                yy.removeFirst();
            }

            res[i]=xx.size()+yy.size()+1;

        }

        return res;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] queries = new int[][]{{5,3},{4,7},{2,3}};

        n = 14;
        queries = new int[][]{{8303,8267}};
        int[] res = new T2509_cycleLengthQueries().cycleLengthQueries(n,queries);
        System.out.println(Arrays.toString(res));

        System.out.println((Integer)(-128)==(Integer)(-128));
        System.out.println((Integer)(127)==(Integer)(127));
        System.out.println((Integer)(128)==(Integer)(128));


    }
}
