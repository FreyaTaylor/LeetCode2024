package src.DynamicPrograming;

public class T629_kInversePairs {

    /**
     * https://leetcode.cn/problems/k-inverse-pairs-array/description/
     * 递推公式：
     * 1. 递推公式的灵感在于，减少一个i，或者j，其计算是否有重回处！！！
     * 2. 使用递推公式的适用范围！！！可能需要多初始化一行
     *
     */

    public int kInversePairs(int n, int k) {
        if(k==0){return 1;}
        int[][] dp = new int[k+1][n+1];
        int helper = 1000000007;

        // 递推公式的i和i-1必须>=1,因此递推公式适用于i>=2,i=1需要自己初始化
        for (int j = 1; j < n+1; j++) {
            dp[0][j]=1;
            dp[1][j]=j-1;
        }
        for (int i = 2; i <k+1 ; i++) {
            for (int j = 1; j < n+1; j++) {
                // l 1 2 3...l-1,l+1,...
//                int temp=0;
//                for (int l = 1; l <=Math.min(i+1,j) ; l++) { //时间复杂度太大，用递推公式，化为0(1)
//                    temp+=dp[i-l+1][j-1];
//                    temp%=helper;
//                }
//                dp[i][j]=temp;
                dp[i][j]+=dp[i-1][j];
                dp[i][j]%=helper;
                dp[i][j]+=dp[i][j-1];
                dp[i][j]%=helper;
                if(i>=j){
                    dp[i][j]+=helper-dp[i-j][j-1];
                    dp[i][j]%=helper;
                }


            }
        }

        return dp[k][n];
    }

    public static void main(String[] args) {
        System.out.println(new T629_kInversePairs().kInversePairs(1000,1000));
    }
}
