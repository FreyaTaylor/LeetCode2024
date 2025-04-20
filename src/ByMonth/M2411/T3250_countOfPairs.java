package src.ByMonth.M2411;

import java.util.Arrays;

public class T3250_countOfPairs {
    /**
     * https://leetcode.cn/problems/find-the-count-of-monotonic-pairs-i/?envType=daily-question&envId=2024-11-28
     * dfs
     * dfs遍历数组a，因为a确定，b也确定了
     * 超时，有关键子结构dfs的重复
     *
     */

//    int count=0;
//    int mod = (int) (Math.pow(10,9)+7);
//    public int countOfPairs(int[] nums) {
//        int n=nums.length;
//        int[] a = new int[n];
//        int[] b = new int[n];
//
//        dfs(nums,a,b,0);
//        return count;
//    }
//
//    public void dfs(int[] nums, int[] a, int[] b,int cur){
//
//        if(cur==nums.length){
//            count=(count+1)%mod;
//            return;
//        }
//
//        int low = (cur>0) ? Math.max(a[cur-1],nums[cur]-b[cur-1]) : 0;
//        int high = nums[cur];
//
//        for (int i = low; i <=high ; i++) {
//            a[cur]=i;
//            b[cur]=nums[cur]-i;
//            dfs(nums,a,b,cur+1);
//        }
//    }



    int mod = (int) (Math.pow(10,9)+7);
    public int countOfPairs(int[] nums) {
        int n=nums.length;
        long[][] dp = new long[n+1][51];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i],-1l);
        }

        long res=0;
        for (int i = 0; i <=nums[0] ; i++) {
            res=(res+dfs(nums,dp,0,i))%mod;
        }
        return (int) res;
    }

    public long dfs(int[] nums, long[][] dp ,int cur,int curNumA){

        if(dp[cur][curNumA]!=-1){
            return dp[cur][curNumA];
        }

        if(cur+1==nums.length){
            dp[cur][curNumA]=1l;
            return dp[cur][curNumA];
        }

        int low = Math.max(curNumA,nums[cur+1]-nums[cur]+curNumA);
        int high = nums[cur+1];

        long res=0l;
        for (int i = low; i <=high ; i++) {
            res=(res+dfs(nums,dp,cur+1,i))%mod;
        }

        dp[cur][curNumA]=res;
        return dp[cur][curNumA];
    }






    public static void main(String[] args) {
        int[] nums = new int[]{2,3,2};
        nums = new int[]{5,5,5,5};
//        nums = new int[]{40,40,40,40,41,42,43,44,45,45};

        System.out.println(new T3250_countOfPairs().countOfPairs(nums));
    }
}
