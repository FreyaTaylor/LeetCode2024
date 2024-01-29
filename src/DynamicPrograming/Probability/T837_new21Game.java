package src.DynamicPrograming.Probability;

public class T837_new21Game {
    /**
     * https://leetcode.cn/problems/new-21-game/
     *
     * 方法一：dfs模拟，会超时
     * 方法二：p(x)=1/maxPts*sum{p(x+i)}, i in {1,maxPts}
     */

//    double pSmaller=0;
//    public double new21Game(int n, int k, int maxPts) {
//        helper(n,k,maxPts,0,0);
//        return pSmaller;
//    }
//    public void helper(int n,int k,int maxPts,int times,int cur){
//        if(cur>=k){
//            if(cur<=n){
//                pSmaller+=1/ Math.pow(maxPts,times);
//            }
//            return;
//        }
//        if(1/ Math.pow(maxPts,times)<Math.pow(10,-10)){
//            return;
//        } // 无法评估到底精度设置在哪里合适，依然会超时
//        for (int i = 1; i <=maxPts ; i++) {
//            helper(n,k,maxPts,times+1,cur+i);
//        }
//    }


    public double new21Game(int n, int k, int maxPts) {
        double[] dp  = new double[k+maxPts]; // 长度参考循环的dp[i+maxPts+1]其中i = k-2，index需要k+maxPts-1
        int border = Math.min(n,k-1+maxPts); // 成功的情况，dp=1
        for (int i = k; i <=border ; i++) {
            dp[i]=1;
        }

        if(k-1>=0){ // 处理k=1
            dp[k-1]=(double) (border-k+1)/maxPts;
            //单独处理k-1，因为递推公式无法处理这一项（dp[K]不符合p(x)=1/maxPts*sum{p(x+i)}）
        }

        for (int i = k-2; i >=0 ; i--) {
            dp[i]=dp[i+1]+(dp[i+1]-dp[i+maxPts+1])/maxPts; //递推公式的优化，数学推理
        }

        return dp[0];
    }
    public static void main(String[] args) {
        System.out.println(new T837_new21Game().new21Game(21,17,10));
        System.out.println(new T837_new21Game().new21Game(0,0,1));
    }


}
