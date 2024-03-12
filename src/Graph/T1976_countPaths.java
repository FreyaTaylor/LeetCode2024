package src.Graph;

import java.util.*;

public class T1976_countPaths {

    /**
     *
     * https://leetcode.cn/problems/number-of-ways-to-arrive-at-destination/
     *
     */



    public int countPaths(int n, int[][] roads) {
        int helper = 1000000007;

        Map<Integer, List<int[]>> map = new HashMap<>(); // [target,dist]
        for (int i = 0; i < n; i++) {
            map.put(i,new ArrayList<>());
        }
        for (int i = 0; i < roads.length; i++) {
            map.get(roads[i][0]).add(new int[]{roads[i][1],roads[i][2]});
            map.get(roads[i][1]).add(new int[]{roads[i][0],roads[i][2]});
        }
        int[] len = new int[n];
        int[] count = new int[n];
        Arrays.fill(len,Integer.MAX_VALUE);
        len[0]=0;
        count[0]=1;

        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() { //[target,len]
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        q.add(new int[]{0,0});

        Set<Integer> already = new HashSet<>();
        already.add(0);

        while (!already.isEmpty() && !already.contains(n-1) ){
            int cur[]=q.poll();
            int curPoint=cur[0];
            int curLen=cur[1];
            int curCount=count[curPoint];
            already.add(curPoint);

            if(curPoint==n-1){
                return curCount;
            }

            if(map.containsKey(curPoint) && map.get(curPoint).size()>0){
                for (int[] ints : map.get(curPoint)) {
                    int next=ints[0];
                    int nextLen=ints[1]+curLen;
                    if(!already.contains(next)){
                        if(nextLen<len[next]){
                            len[next]=nextLen;
                            count[next]=curCount%helper;
                            q.add(new int[]{next,nextLen});
                        }else  if(nextLen==len[next]){
                            count[next]=(count[next]+curCount)%helper;
                        }
                    }
                }
            }

        }

        return 1;

    }



    public static void main(String[] args) {
//        int[][]roads = new int[][]{{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
//        System.out.println(new _T1976_countPaths().countPaths(7,roads));


        System.out.println(new T1976_countPaths().countPaths(1,new int[][]{}));
    }
}
