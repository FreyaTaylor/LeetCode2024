package src.ByMonth.M2410;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T3148_maxScore {

    /**
     * https://leetcode.cn/problems/maximum-difference-score-in-a-grid/
     */

    public int maxScore(List<List<Integer>> grid) {

        int m=grid.size();
        int n=grid.get(0).size();

        int[][] scores = new int[m][n];


        int res=Integer.MIN_VALUE;
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                scores[i][j]=Integer.MIN_VALUE;
                if(i>0){
                    scores[i][j]=Math.max(scores[i][j],Math.max(0,scores[i-1][j])+grid.get(i).get(j)-grid.get(i-1).get(j));
                }
                if(j>0){
                    scores[i][j]=Math.max(scores[i][j],Math.max(0,scores[i][j-1])+grid.get(i).get(j)-grid.get(i).get(j-1));
                }
                res=Math.max(res,scores[i][j]);
            }
        }


        return res;
    }


    public static void main(String[] args) {
        List<List<Integer>> grid=new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.clear();
        temp.add(4);
        temp.add(3);
        temp.add(2);
        grid.add(new ArrayList<>(temp));
        temp.clear();
        temp.add(3);
        temp.add(2);
        temp.add(1);
        grid.add(new ArrayList<>(temp));

        System.out.println(new T3148_maxScore().maxScore(grid));
    }

}
