package src.ByMonth.M2408;

public class T3154_waysToReachStair {

    /**
     * https://leetcode.cn/problems/find-number-of-ways-to-reach-the-k-th-stair/
     *
     */
    public int waysToReachStair(int k) {

        int res=0;
        int n=0;
        int r=1;
        // l=r=n-1;
        while (r-n-1<=k){
            if(r>=k){
                int m=r-k;
                res+=comb(n+1,m);
            }
            r=2*r;
            n++;
        }

        return res;
    }

    public int comb(int n, int k) {
        long ans = 1;
        for (int i = n; i >= n - k + 1; --i) {
            ans *= i;
            ans /= n - i + 1;
        }
        return (int) ans;
    }


    public static void main(String[] args) {
        System.out.println(new T3154_waysToReachStair().waysToReachStair(1));
    }

}
