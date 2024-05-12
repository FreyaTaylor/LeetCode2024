package src.DynamicPrograming;

import java.util.Arrays;
import java.util.List;

public class T1301_pathsWithMaxScore {

    /**
     * https://leetcode.cn/problems/number-of-paths-with-max-score/
     * @param args
     */

    public int[] pathsWithMaxScore(List<String> board) {

        int n = board.size();
        int[][] num = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = board.get(i);
            for (int j = 0; j < n; j++) {
                if(Character.isDigit(s.charAt(j))){
                    num[i][j]=Integer.valueOf(s.charAt(j));
                }else {
                    num[i][j]=-1;
                }
            }
        }
        num[n-1][n-1]=0;
        num[0][0]=0;

        int[][] count = new int[n][n];
        int[][] maxScore = new int[n][n];

        for (int i = 0; i < n ; i++) {
            Arrays.fill(maxScore[i],Integer.MIN_VALUE);
        }

        count[n-1][n-1]=1;
        maxScore[n-1][n-1]=0;


        for (int i = n-2; i >-1; i--) {
            if(num[i][n-1]!=-1){
                count[i][n-1]=1;
                maxScore[i][n-1]=maxScore[i+1][n-1]+num[i][n-1];
            }else {
                break;
            }
        }

        for (int i = n-2; i >-1; i--) {
            if(num[n-1][i]!=-1 ){
                count[n-1][i]=1;
                maxScore[n-1][i]=maxScore[n-1][i+1]+num[n-1][i];
            }else {
                break;
            }
        }

        for (int i = n-2; i >-1 ; i--) {
            for (int j = n-2; j >-1 ; j--) {

                int count_=0;
                int maxScore_=Integer.MIN_VALUE;


                if(num[i][j]!=-1){
                    if(num[i+1][j]!=-1 && num[i][j+1]!=-1){
                        if(maxScore[i+1][j]==maxScore[i][j+1]){
                            maxScore_=maxScore[i+1][j];
                            count_=count[i+1][j]+count[i][j+1];
                        }else if(maxScore[i+1][j]>maxScore[i][j+1]){
                            maxScore_=maxScore[i+1][j];
                            count_=count[i+1][j];
                        }else {
                            maxScore_=maxScore[i][j+1];
                            count_=count[i][j+1];
                        }
                    }else if(num[i+1][j]!=-1 && num[i][j+1]==-1){
                        maxScore_=maxScore[i+1][j];
                        count_=count[i+1][j];
                    }else if(num[i+1][j]==-1 && num[i][j+1]!=-1){
                        maxScore_=maxScore[i][j+1];
                        count_=count[i][j+1];
                    }

                }

                maxScore[i][j]=maxScore_+num[i][j];
                count[i][j]=count_;

            }
        }



        return new int[]{maxScore[0][0],count[0][0]};

    }


    public static void main(String[] args) {
         List<String> board = new String[]{
                "E12",
                "1X1",
                "21S"};
//        输出：[4,2]

        int[] res = new T1301_pathsWithMaxScore().pathsWithMaxScore(board);
        System.out.println(Arrays.toString(res));
    }
}
