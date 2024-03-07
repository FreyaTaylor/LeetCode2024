package src.Graph;

import java.util.*;

public class _T1976_countPaths {

    /**
     *
     * https://leetcode.cn/problems/number-of-ways-to-arrive-at-destination/
     *
     */

    private  int minPath=Integer.MAX_VALUE;
    private  int minCount=0;
    int helper = 1000000007;

    Map<Integer,Integer> stage = new HashMap<>(); //在某个点，只能比这个点的path小，否则不会更新最短 路径
    public int countPaths(int n, int[][] roads) {

        Map<Integer, List<int[]>> map = new HashMap<>(); // [target,dist]
        for (int i = 0; i < n; i++) {
            map.put(i,new ArrayList<>());
        }
        for (int i = 0; i < roads.length; i++) {
            map.get(roads[i][0]).add(new int[]{roads[i][1],roads[i][2]});
            map.get(roads[i][1]).add(new int[]{roads[i][0],roads[i][2]});
        }



        Set<Integer> already = new HashSet<>();

        dfs(map, already,0,n-1,0);
        return minCount;

    }

    public void dfs(Map<Integer, List<int[]>> map,Set<Integer> already,int cur,int target,int curPath){
        if(cur==target){
            if(curPath<minPath){
                minPath=curPath;
                minCount=1;
            }else if (curPath==minPath){
                minCount=(minCount+1)%helper;
            }
            return;
        }

        if(curPath>=minPath){
            return;
        }

        if(map.containsKey(cur) && map.get(cur).size()>=0){
            for (int[] ints : map.get(cur)) {
                if(!already.contains(ints[0])){
                    already.add(ints[0]);
                    dfs(map, already,ints[0],target,curPath+ints[1]);
                    already.remove(ints[0]);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][]roads = new int[][]{{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};

        System.out.println(new _T1976_countPaths().countPaths(7,roads));
    }
}
