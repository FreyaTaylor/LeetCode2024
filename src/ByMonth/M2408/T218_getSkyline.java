package src.ByMonth.M2408;

import java.util.*;

public class T218_getSkyline {

    /**
     * https://leetcode.cn/problems/the-skyline-problem/
     *
     * 可以看到，所有的关键点都是建筑的左右边界（称为垂直线），
     * 左边界（标黄）的y，都是取的垂直线所在建筑的最高点。
     * 右边界（标蓝）的y，也是取的垂直线所在建筑的最高点，但是排除掉右边界。！！！右边界不参与计算
     */


    public List<List<Integer>> getSkyline(int[][] buildings) {

        int len=buildings.length;
        List<List<Integer>> res = new ArrayList<>();

        // 左右边界
        int[] x = new int[2*len];
        for (int i = 0; i <len ; i++) {
            x[i]=buildings[i][0];
            x[i+len]=buildings[i][1];
        }
        Arrays.sort(x);


        //[高度，右边界]，一个建筑，只会入队一次，出队一次
        int index=0;
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0];
            }
        });

        // 遍历边界
        for (int curx:x){
            // 入队
            while (index<len && buildings[index][0]<=curx){
                q.add(new int[]{buildings[index][2],buildings[index][1]});
                index++;
            }

            // 出队
            while (!q.isEmpty()&&q.peek()[1] <=curx){
                q.poll();
            }

            // 处理curx的y
            int y=q.isEmpty()?0:q.peek()[0];
            if(res.isEmpty() || res.get(res.size()-1).get(1)!=y){
                res.add(Arrays.asList(curx,y));
            }

        }


        return  res;
    }


    public static void main(String[] args) {
        int[][] buildings = new int[][]{
                {2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        // 输出：[[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]

        List<List<Integer>> res= new T218_getSkyline().getSkyline(buildings);

        System.out.println(res);

    }

}
