package src.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T2872_maxKDivisibleComponents {
    /**
     * https://leetcode.cn/problems/maximum-number-of-k-divisible-components/
     *
     * 遍历边+边可删除条件
     *
     */

//    int res=0;
//    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
//
//        if(edges.length==0){
//            return 1;
//        }
//
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            map.put(i,new ArrayList<>());
//        }
//
//        for (int i = 0; i < edges.length;i++) {
//            int x=edges[i][0];
//            int y=edges[i][1];
//            map.get(x).add(y);
//            map.get(y).add(x);
//        }
//
//        long temp = dfs(map,values,edges[0][0],edges[0][1],k);
//        dfs(map,values,edges[0][1],edges[0][0],k);
//
//        if(temp%k==0){
//            return res;
//        }else {
//            return res+1;
//        }
//
//    }



    int res=0;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i,new ArrayList<>());
        }

        for (int[] edge : edges) {
            int x=edge[0];
            int y=edge[1];
            map.get(x).add(y);
            map.get(y).add(x);
        }

        dfs(map,values,-1,0,k); // 从-1，0开始，会计算所有的边
        return res;
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
        int n = 5;
        int[][] edges = new int[][]{{0,2},{1,2},{1,3},{2,4}};
        int[] values = new int[]{1,8,1,4,4};
        int k = 6;

        n = 7;
        edges = new int[][]{{0,1},{0,2},{1,3},{1,4},{2,5},{2,6}};
        values = new int[]{3,0,6,1,5,2,1};
        k = 3;

//        n = 1;
//        edges = new int[][]{};
//        values = new int[]{0};
//        k = 1;


        System.out.println(new T2872_maxKDivisibleComponents().maxKDivisibleComponents(n,edges,values,k));
    }


}
