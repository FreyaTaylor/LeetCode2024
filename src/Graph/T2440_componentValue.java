package src.Graph;

import java.util.*;

public class T2440_componentValue {
    /**
     * https://leetcode.cn/problems/create-components-with-same-value/
     *
     * 参考：https://leetcode.cn/problems/maximum-number-of-k-divisible-components/
     */

    int res;
    public int componentValue(int[] nums, int[][] edges) {

        int n = nums.length;
        int sum=0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i,new ArrayList<>());
            sum+=nums[i];
        }

        for (int[] edge : edges) {
            int x=edge[0];
            int y=edge[1];
            map.get(x).add(y);
            map.get(y).add(x);
        }

        for (int i = n; i >=1 ; i--) { // i 块数
            if(sum%i==0){
                int target = sum/i; //每块总值
                res=0;
                dfs(map,nums,-1,0,target); // 分块可被target整除的连通快数据,赋值给res
                if(res==i){
                    return i-1;
                }
            }
        }

        return -1;
    }



    public long dfs(Map<Integer, List<Integer>> map,int[] values, int pre, int cur, int k){
        // pre--cur--next
        long sumNext=values[cur];
        for (Integer next: map.get(cur)) {
            if(next!=pre){
                long temp = dfs(map,values,cur,next,k);
                sumNext+=temp;
            }
        }

        if(sumNext%k==0){
            res++;
        }
        return sumNext;
    }






    public static void main(String[] args) {

        int []nums = new int[]{6,2,2,2,6};
        int[][] edges = new int[][]{{0,1},{1,2},{1,3},{3,4}};

        nums = new int[]{2};
        edges = new int[][]{};

        nums = new int[]{1,2,1,1,1};
        edges = new int[][]{{0,1},{1,3},{3,4},{4,2}};



        System.out.println(new T2440_componentValue().componentValue(nums,edges));
    }



}
