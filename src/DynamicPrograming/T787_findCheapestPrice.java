package src.DynamicPrograming;

import java.util.*;

public class T787_findCheapestPrice {
    /**
     * https://leetcode.cn/problems/cheapest-flights-within-k-stops/
     * 超时：每个节点的下节点有10个，那个第k步，q里面会有10的k次方个数
     * 方案：参考sijiscta,只有最短距离被更新了才继续其下节点
     * k次用循环次数来判断
     *
     * 注1：1->2->3->4   1->3->4  当k=1时候，只能取后一步，更新时候不能使用更新后的数据
     * 原来的处理办法：List<Map<Integer, Integer>> nzz = new ArrayList<>(); //经够几次中转，可到达的城市
     * 本次：用minCost_
     */

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < flights.length; i++) {
            if(!map.containsKey(flights[i][0])){
                map.put(flights[i][0],new ArrayList<>());
            }
            map.get(flights[i][0]).add(flights[i]);
        }

        Map<Integer,Integer> minCost = new HashMap<>();
        if(map.containsKey(src)){
            minCost.put(src,0);
        }else {
            return -1;
        }

        Map<Integer,Integer> minCost_ = new HashMap<>();

        int res=Integer.MAX_VALUE;
        Deque<Integer> q = new ArrayDeque<>();
        q.add(src);

        int stop=0;
        while (!q.isEmpty() && stop<=k) {
//            System.out.println(q.toString());
//            System.out.println(stop);
            int size = q.size();
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < size; i++) {
                int cur = q.removeFirst();
                if(map.containsKey(cur) && !map.get(cur).isEmpty()){
                    for (int[] ints : map.get(cur)) {
                        int to=ints[1];
                        int cost=ints[2]+minCost.get(cur);
                        if(!minCost.containsKey(to) || minCost.get(to)>cost){
                            minCost_.put(to,Math.min(minCost_.getOrDefault(to,Integer.MAX_VALUE),cost)); //不能直接更新 minCost，可能会使用更新后的脏数据，但是同一级别，需要更新小的cost
                            set.add(to);
//                            q.addLast(to); //会重复
                            if(to==dst){
                                res=Math.min(res,cost);
                            }
                        }

                    }
                }
            }

            minCost.putAll(minCost_);
            for (Integer i : set) {
                q.addLast(i);
            }
            minCost_ = new HashMap<>();

            stop++;
        }

        if(res!=Integer.MAX_VALUE){
            return res;
        }else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int n = 3, src = 0, dst = 2, k = 1;
        int[][] edges = new int[][]{{0,1,1001,2,100},{},{0,2,500}};

        n = 3;
        src = 1;
        dst = 2;
        k = 1;
        edges = new int[][]{{0,1,2},{1,2,1},{2,0,10}};

        n = 10;
        src = 6;
        dst = 0;
        k = 7;
        edges = new int[][]{{3,4,4},{2,5,6},{4,7,10},{9,6,5},{7,4,4},{6,2,10},{6,8,6},{7,9,4},{1,5,4},{1,0,4},{9,7,3},{7,0,5},{6,5,8},{1,7,6},{4,0,9},{5,9,1},{8,7,3},{1,2,6},{4,1,5},{5,2,4},{1,9,1},{7,8,10},{0,4,2},{7,2,8}};

        n = 17;
        src = 13;
        dst = 4;
        k = 13;
        edges = new int[][]{{0,12,28},{5,6,39},{8,6,59},{13,15,7},{13,12,38},{10,12,35},{15,3,23},{7,11,26},{9,4,65},{10,2,38},{4,7,7},{14,15,31},{2,12,44},{8,10,34},{13,6,29},{5,14,89},{11,16,13},{7,3,46},{10,15,19},{12,4,58},{13,16,11},{16,4,76},{2,0,12},{15,0,22},{16,12,13},{7,1,29},{7,14,100},{16,1,14},{9,6,74},{11,1,73},{2,11,60},{10,11,85},{2,5,49},{3,4,17},{4,9,77},{16,3,47},{15,6,78},{14,1,90},{10,5,95},{1,11,30},{11,0,37},{10,4,86},{0,8,57},{6,14,68},{16,8,3},{13,0,65},{2,13,6},{5,13,5},{8,11,31},{6,10,20},{6,2,33},{9,1,3},{14,9,58},{12,3,19},{11,2,74},{12,14,48},{16,11,100},{3,12,38},{12,13,77},{10,9,99},{15,13,98},{15,12,71},{1,4,28},{7,0,83},{3,5,100},{8,9,14},{15,11,57},{3,6,65},{1,3,45},{14,7,74},{2,10,39},{4,8,73},{13,5,77},{10,0,43},{12,9,92},{8,2,26},{1,7,7},{9,12,10},{13,11,64},{8,13,80},{6,12,74},{9,7,35},{0,15,48},{3,7,87},{16,9,42},{5,16,64},{4,5,65},{15,14,70},{12,0,13},{16,14,52},{3,10,80},{14,11,85},{15,2,77},{4,11,19},{2,7,49},{10,7,78},{14,6,84},{13,7,50},{11,6,75},{5,10,46},{13,8,43},{9,10,49},{7,12,64},{0,10,76},{5,9,77},{8,3,28},{11,9,28},{12,16,87},{12,6,24},{9,15,94},{5,7,77},{4,10,18},{7,2,11},{9,5,41}};


//        n = 4;
//        src = 0;
//        dst = 3;
//        k = 1;
//        edges = new int[][]{{0,1,1},{0,2,5},{1,2,1},{2,3,1}};

        System.out.println(new T787_findCheapestPrice().findCheapestPrice(n,edges,src,dst,k));
    }
}
