package src.Traverse.StorageRectangle;

import java.util.*;

public class T56_merge {
    /**
     * https://leetcode.cn/problems/merge-intervals/
     */

    public int[][] merge(int[][] intervals) {

        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        for (int i = 0; i < intervals.length; i++) {
            q.add(intervals[i]);
        }

        List<int[]> res = new ArrayList<>();

        while (!q.isEmpty()){
            int[] cur = q.poll();
            int left= cur[0];
            int right= cur[1];
            while (!q.isEmpty() && q.peek()[0]<=right){
                right=Math.max(right,q.poll()[1]);
            }
            res.add(new int[]{left,right});

        }
        int[][] ress = new int[res.size()][2];
        for (int i = 0; i < res.size() ; i++) {
            ress[i]=res.get(i);
        }

        return ress;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(new T56_merge().merge(intervals)));
    }
}
