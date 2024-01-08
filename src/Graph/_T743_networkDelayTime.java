package src.Graph;

import java.util.*;

public class _T743_networkDelayTime {

    /**
     * https://leetcode.cn/problems/network-delay-time/
     */

    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n+1]; // 点所连的最长边
        Arrays.fill(dist,Integer.MAX_VALUE);

        Map<Integer, List<int[]>> allEdges = new HashMap<>(); //[ 目标点，距离]
        for (int i = 0; i < times.length; i++) {
            if(!allEdges.containsKey(times[i][0])){
                allEdges.put(times[i][0],new ArrayList<>());
            }
            allEdges.get(times[i][0]).add(new int[]{times[i][1],times[i][2]});
        }

        dist[k]=0;
        Set<Integer> already = new HashSet<>();
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return dist[o1]-dist[o2];
            }
        });
        q.add(k);

        while (!q.isEmpty()){
            while (!q.isEmpty()&& already.contains(q.peek())){
                q.poll();
            }
            if(q.isEmpty()){
                break;
            }
            int cur=q.poll();
            already.add(cur);

                List<int[]> edges = allEdges.get(cur);

                if(edges!=null){
                    for (int[] edge : edges) {
                        int endP = edge[0];
                        int addDist=edge[1];

                        if(!already.contains(endP)){
                            dist[endP]=Math.min(dist[endP],dist[cur]+addDist);
                            q.add(endP);
                        }
                        //终点

                    }

                }
            System.out.println(Arrays.toString(dist));
        }

        int res = Integer.MIN_VALUE;
        for (int i = 1; i < n+1; i++) {
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }
            res=Math.max(res,dist[i]);
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] times = new int[][]{{4,2,76},{1,3,79},{3,1,81},{4,3,30},{2,1,47},{1,5,61},{1,4,99},{3,4,68},{3,5,46},{4,1,6},{5,4,7},{5,3,44},{4,5,19},{2,3,13},{3,2,18},{1,2,0},{5,1,25},{2,5,58},{2,4,77},{5,2,74}};
        System.out.println(new _T743_networkDelayTime().networkDelayTime(times,5,2));
    }
}
