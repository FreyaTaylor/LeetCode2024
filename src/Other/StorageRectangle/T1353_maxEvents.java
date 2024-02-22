package src.Other.StorageRectangle;

import java.util.*;

public class T1353_maxEvents {

    /**
     * https://leetcode.cn/problems/maximum-number-of-events-that-can-be-attended/
     * 贪心：选今日可参加的，结束时间最早的
     */

    public int maxEvents(int[][] events) {
        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        PriorityQueue<Integer> q = new PriorityQueue<>();
        int n=events.length;
        int today=Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            today=Math.min(today,events[i][0]);
        }

        int res=0;
        int i=0;
        while (i<n||!q.isEmpty()){

            // 今日可选，条件1：events[i][0]<=today
            while (i<n&&events[i][0]<=today){
                q.add(events[i++][1]);
            }
            // 今日可选，条件2：q.peek()>=today
            while (!q.isEmpty() && q.peek()<today){
                q.poll();
            }
            //参加会议
            if(!q.isEmpty()){
                q.poll();
                res++;
            }
            today++; //每次天数+1
        }

        return res;
    }

    public static void main(String[] args) {
//        int[][] events = new int[][]{{1,5},{1,5},{1,5},{2,3},{2,3}};
        int[][] events = new int[][]{{52,79},{7,34}};
        System.out.println(new T1353_maxEvents().maxEvents(events));
    }
}
