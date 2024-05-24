package src.DynamicPrograming;

public class T629_kInversePairs_1 {

    /**
     * 递推公式优化：？？？
     * @param n
     * @param k
     * @return
     */
    public int kInversePairs(int n, int k) {
        int mod = (int)Math.pow(10,9)+7;
        int[][] dp = new int[k+1][n+1];
        for (int j = 1; j < n+1; j++) {
            dp[0][j]=1;
        }

//        for (int i = 1; i < k+1 ; i++) {
//            for (int j = 1; j <n+1 ; j++) {
//                for (int l = 0; l <= Math.min(i,j-1); l++) {
//                    dp[i][j]=(dp[i][j]+dp[i-l][j-1])%mod;
//                }
//            }
//        }

        for (int j = 1; j <n+1 ; j++) {
            for (int i = 1; i < k+1 ; i++) {

                for (int l = 0; l <= i; l++) {
                    dp[i][j]=(dp[i][j]+dp[i-l][j-1])%mod;
                }
            }
        }


        return dp[k][n];
    }

    public static void main(String[] args) {
        System.out.println(new T629_kInversePairs_1().kInversePairs(2,2));
    }
}
