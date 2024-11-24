package src.StateTransition;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class T2581_rootCount_1 {

    /**
     *
     * https://leetcode.cn/problems/count-number-of-possible-root-nodes/
     *
     */

    int count=0;
    int res=0;
    public int rootCount(int[][] edges, int[][] guesses, int k) {

        Map<Integer, Set<Integer>> map = new HashMap<>();
        int n=edges.length+1;
        for (int i = 0; i < n; i++) {
            map.put(i,new HashSet<>());
        }
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        Set<Long>  gus = new HashSet<>();
        for (int i = 0; i < guesses.length; i++) {
            gus.add(guesses[i][0]*10000000L+guesses[i][1]);
        }
        
        helper0(map,0,-1,gus);
        helper(map,0,-1,gus,k);
        return res;

    }


    /**
     *
     * 处理 pre cur的逆转，dfs要复原
     */
    public void helper(Map<Integer, Set<Integer>> map, int cur,int pre,Set<Long>  gus,int k){

        long olde = pre*10000000L+cur;
        long newe = cur*10000000L+pre;
        
        if(gus.contains(olde)){
            count--;
        }
        if(gus.contains(newe)){
            count++;
        }
        
        if(count>=k){
            res++;
        }
        
        for (Integer i : map.get(cur)) {
            if(i!=pre){
                helper(map,i,cur,gus,k);
            }
        }

        if(gus.contains(olde)){
            count++;
        }
        if(gus.contains(newe)){
            count--;
        }


    }


    public void helper0(Map<Integer, Set<Integer>> map, int cur,int pre,Set<Long>  gus){

        if(gus.contains(pre*10000000L+cur)){
            count++;
        }
        for (Integer i : map.get(cur)) {
            if(i!=pre){
                helper0(map,i,cur,gus);
            }
        }

    }



    public static void main(String[] args) {
        int[][] edges = new int[][]{{0,1},{1,2},{2,3},{3,4}};
        int[][] guesses = new int[][]{{1,0},{2,1},{3,2},{3,4}};
        int k = 1;

        edges = new int[][]{{0,1},{1,2},{1,3},{4,2}};
        guesses = new int[][]{{1,3},{0,1},{1,0},{2,4}};
        k = 3;

        edges=new int[][]{{0,1},{2,0},{0,3},{4,2},{3,5},{6,0},{1,7},{2,8},{2,9},{4,10},{9,11},{3,12},{13,8},{14,9},{15,9},{10,16}};
        guesses = new int[][]{{8,2},{12,3},{0,1},{16,10}};
        k = 2;

        System.out.println(new T2581_rootCount_1().rootCount(edges,guesses,k));
    }


}
