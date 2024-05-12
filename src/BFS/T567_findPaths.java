package src.BFS;

public class T567_findPaths {

    /**
     * https://leetcode.cn/problems/out-of-boundary-paths/
     */

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][] dp = new int[m][n];
        int[][] dpNext = new int[m][n];

        int res=0;
        dp[startRow][startColumn]=1;
        int mod = (int)Math.pow(10,9)+7;

        for (int move = 0; move <maxMove ; move++) {

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {

                    if(dp[i][j]>0){
                        int[][] next = new int[][]{{i+1,j},{i-1,j},{i,j+1},{i,j-1}};

                        for (int[] nextPos : next) {
                            int x=nextPos[0];
                            int y=nextPos[1];
                            if(x<0 || x>=m || y<0 || y>=n){

                                res+=dp[i][j];
                                System.out.println(res);
                                res%=mod;
                            }else {
                                dpNext[x][y]+=dp[i][j];
                                dpNext[x][y]%=mod;
                            }
                        }
                    }
                }
            }

            dp=dpNext;
            dpNext= new int[m][n];
        }


        return res;
    }

    public static void main(String[] args) {
        // m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
//        System.out.println(new T567_findPaths().findPaths(1,3,3,0,1));
//        System.out.println(new T567_findPaths().findPaths(2,3,8,1,0));
        System.out.println(new T567_findPaths().findPaths(8,50,23,5,26));



    }
}
