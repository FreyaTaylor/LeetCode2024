package src.DynamicPrograming.Probability;

public class T837_new21Game_1 {

    /**
     * 爱丽丝以 0 分开始，并在她的得分少于 k 分时抽取数字。
     * 抽取时，她从 [1, maxPts] 的范围中随机获得一个整数作为分数进行累计
     * 当爱丽丝获得 k 分 或更多分 时，她就停止抽取数字。
     * 不超过 n 的概率是多少 <=n
     *
     */
    public double new21Game(int n, int k, int maxPts) {
        if(k-1+maxPts<=n){return 1.0;}

        double[] dp = new double[k+maxPts];
//        for (int i = n; i <=k-1+maxPts ; i++) {
//            dp[i]=0;
//        }
        for (int i = k; i <=n ; i++) {
            dp[i]=1;
        }

        if(k-1>-1){
           dp[k-1]=((double) n-k+1)/maxPts;   
        }

        for (int i = k-2; i >-1 ; i--) {
            dp[i]=dp[i+1]+(dp[i+1]-dp[i+maxPts+1])/maxPts;
        }

        return dp[0];

    }

    public static void main(String[] args) {
        System.out.println(new T837_new21Game_1().new21Game(0,0,2));
    }
}
