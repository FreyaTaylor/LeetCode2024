package src.ByMonth.M2411;

import java.util.*;

public class T2581_rootCount {

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
        
        if(count>=k){
            res++;
        }

        helper(map,0,-1,gus,k);
        return res;

    }


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
                helper0(map,i,cur,gus);
            }
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
    
    



}
