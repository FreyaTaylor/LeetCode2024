package src.ByMonth.M2411;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class T85_maximalRectangle {
    /**
     * https://leetcode.cn/problems/maximal-rectangle/description/
     */

    public int maximalRectangle(char[][] matrix) {
        int m=matrix.length,n=matrix[0].length;

        int[] height = new int[n];
        int res=0;
        Arrays.fill(height,0);

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                // [i,j]

                    if(matrix[i][j]=='1'){
                        height[j]+=1;
                    }else {
                        height[j]=0;
                    }


            }
//            System.out.println(Arrays.toString(height));
            res=Math.max(res,getArea(height));
        }
        return res;
    }

    public int getArea( int[] height){

//        System.out.println(Arrays.toString(height));
        int n=height.length;
        int[] lsmall = new int[n]; //向左第一个小于height[i]
        int[] rsmall = new int[n]; //向右第一个小于height[i]

        Deque<Integer> q = new ArrayDeque<>(); //包含i的升序
        for (int i = 0; i < height.length; i++) {
            while (!q.isEmpty() && height[q.getLast()]>=height[i]){
                q.removeLast();
            }

            if(q.isEmpty()){
                lsmall[i]=-1;
            }else {
                lsmall[i]=q.getLast();
            }

            q.addLast(i);
        }


        q = new ArrayDeque<>(); //包含i的升序
        for (int i = height.length-1; i >-1 ; i--) {

            while (!q.isEmpty() && height[q.getLast()]>=height[i]){
                q.removeLast();
            }

            if(q.isEmpty()){
                rsmall[i]=height.length;
            }else {
                rsmall[i]=q.getLast();
            }

            q.addLast(i);
        }

        int res=0;
        for (int i = 0; i < height.length; i++) {
            res=Math.max(res,height[i]*(rsmall[i]-lsmall[i]-1));
        }

        return res;
    }


    /**
     * 只遍历以第i曾为底
     * @param matrix
     * @return
     */
    public int maximalRectangle_(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;

        int[][] h = new int[m][n];
        for (int i = 0; i < n; i++) {
            if(matrix[0][i]=='1'){h[0][i]=1;}
            for (int j = 1; j <m ; j++) {
                if(matrix[j][i]=='1'){
                    h[j][i]=h[j-1][i]+1;
                }else {
                    h[j][i]=0;
                }
            }
        }


        Deque<Integer> stk = new ArrayDeque<>();
        int res=Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            //左边第一个小于自己的index
            stk = new ArrayDeque<>();//单调增栈
            stk.addLast(0);
            int[] rsi = new int[n];//记录
            for (int j = 1; j <n ; j++) {
                while (!stk.isEmpty() && h[i][stk.getLast()]>h[i][j]){
                    rsi[stk.removeLast()]=j;
                }
                stk.addLast(j);
            }
            while (!stk.isEmpty()){
                rsi[stk.removeLast()]=n;
            }

            //右边第一个小于自己的index
            stk = new ArrayDeque<>();//单调增栈
            stk.addLast(n-1);
            int[] lsi = new int[n];//记录
            for (int j = n-2; j >=0 ; j--) {
                while (!stk.isEmpty() && h[i][stk.getLast()]>h[i][j]){
                    lsi[stk.removeLast()]=j;
                }
                stk.addLast(j);
            }
            while (!stk.isEmpty()){
                lsi[stk.removeLast()]=-1;
            }

            int tempMax = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                tempMax=Math.max(tempMax,h[i][j]*(rsi[j]-lsi[j]-1));
            }

            res=Math.max(res,tempMax);
        }


        return res;
    }
    public static void main(String[] args) {
//
//        int[] height = new int[]{2, 0, 2, 2, 2};
//        System.out.println(new T85_maximalRectangle().getArea(height));
        
        char[][] matrix = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};

        System.out.println(new T85_maximalRectangle().maximalRectangle(matrix));

    }
}
