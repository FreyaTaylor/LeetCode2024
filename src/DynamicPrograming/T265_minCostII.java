package src.DynamicPrograming;

public class T265_minCostII {

    /**
     *
     * https://leetcode.cn/problems/paint-house-ii/
     *
     * dp(i,j)=min{dp(i-1,k)|1<=k<=m,k!=j}
     *
     */
    public int minCostII(int[][] costs) {

        int n=costs.length;
        int m=costs[0].length;
        int[][]dp = new int[n][m];

        for (int j = 0; j < m; j++) {
            dp[0][j]=costs[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int temp=Integer.MAX_VALUE;
                for (int k = 0; k < j; k++) {
                    temp=Math.min(temp,dp[i-1][k]);
                }
                for (int k = j+1; k < m; k++) {
                    temp=Math.min(temp,dp[i-1][k]);
                }
                dp[i][j]=temp+costs[i][j];

            }
        }

        int res=Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            res=Math.min(res,dp[n-1][j]);
        }

        return res;
    }

    public static void main(String[] args) {
        int [][] costs = new int[][]{
                {15,17,15,20,7,16,6,10,4,20,7,3, 4},
                {11,3,  9,13,7,12,6,7, 5,1, 7,18,9}};
        System.out.println(new T265_minCostII().minCostII(costs));
    }
}
