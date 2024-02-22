package src.Graph;

import java.util.*;

public class T743_networkDelayTime {

    /**
     * https://leetcode.cn/problems/network-delay-time/
     */

    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() { //[target,dist]
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        Map<Integer,List<int[]>> map = new HashMap<>(); // [target,dist]
        for (int i = 0; i < times.length; i++) {
            // map.getOrDefault(times[i][0],new ArrayList<>()).add(new int[]{times[i][1],times[i][2]});
            if(!map.containsKey(times[i][0])){
                map.put(times[i][0],new ArrayList<>());
            }
            map.get(times[i][0]).add(new int[]{times[i][1],times[i][2]});
        }


        Set<Integer> set = new HashSet<>();
        set.add(k);
        List<int[]> temp = map.get(k);
        if(temp!=null) {
            for (int[] ints : temp) {
                q.add(ints);
            }
        }

        int maxDelay = Integer.MIN_VALUE;
        while (set.size()<n && !q.isEmpty()){
            int[] cur = q.poll();
            int curPoint=cur[0];
            int curLen=cur[1];
            maxDelay=Math.max(maxDelay,curLen);

            if(!set.contains(curPoint)){
                set.add(curPoint);
                temp = map.get(curPoint);
                if(temp!=null) {
                    for (int[] ints : temp) {
                        q.add(new int[]{ints[0], ints[1] + curLen});
                    }
                }

            }
//            System.out.println(set.toString());
        }

        if(set.size()==n){
            return maxDelay;
        }
        return -1;
    }


    public static void main(String[] args) {
//        int[][] times = new int[][]{{4,2,76},{1,3,79},{3,1,81},{4,3,30},{2,1,47},{1,5,61},{1,4,99},{3,4,68},{3,5,46},{4,1,6},{5,4,7},{5,3,44},{4,5,19},{2,3,13},{3,2,18},{1,2,0},{5,1,25},{2,5,58},{2,4,77},{5,2,74}};
        int[][] times = new int[][]{{2,1,1},{2,3,1},{3,4,1}};
        System.out.println(new T743_networkDelayTime().networkDelayTime(times,4,2));
    }
}
