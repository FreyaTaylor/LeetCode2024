package src.DynamicPrograming;

public class T1884_twoEggDrop {

    /**
     * https://leetcode.cn/problems/egg-drop-with-2-eggs-and-n-floors/
     * f(n)=1+min(max{m-1,f(n-m)})
     *
     */
    public int twoEggDrop(int n) {
        int[]dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for (int i = 0; i < n+1; i++) {
            int temp=Integer.MAX_VALUE;
            for (int j = 1; j <=i ; j++) {
                temp=Math.min(temp,Math.max(j-1,dp[i-j]));
            }
            dp[i]=temp+1;
        }

        return dp[n];
    }
    public static void main(String[] args) {

        System.out.println(new T1884_twoEggDrop().twoEggDrop(100));
    }
}
