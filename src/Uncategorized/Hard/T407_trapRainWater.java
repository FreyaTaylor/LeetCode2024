package src.Uncategorized.Hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class T407_trapRainWater {

    /**
     * https://leetcode.cn/problems/trapping-rain-water-ii/
     *
     *
     * 接到的雨水的高度由这个容器周围最短的木板来确定的
     * 当前最低的格子，可以更新其上下左右四个格子的水位！然后用有优先队列每次取最低水位的
     */

    public int trapRainWater(int[][] heightMap) {
        int res = 0;
        int n = heightMap.length;
        int m = heightMap[0].length;

        boolean[][] visited = new boolean[n][m];
        int[][] hasWater = new int[n][m];

        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() { // height,x,y
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(i==0 || i==n-1 || j==0 || j==m-1){
                    q.add(new int[]{heightMap[i][j],i,j});
                    hasWater[i][j]=heightMap[i][j];
//                    visited[i][j]=true;
                }
            }
        }

        while (!q.isEmpty()){
            int[] cur = q.poll();
            int curHeight=cur[0];
            int x=cur[1];
            int y=cur[2];

            if(!visited[x][y]) {
                hasWater[x][y]=curHeight;
                visited[x][y]=true;
                res+=curHeight-heightMap[x][y];
            }

            int[][] nexts = new int[][]{{x + 1, y}, {x - 1, y}, {x, y + 1}, {x, y - 1}};
            for (int[] next : nexts) {
                int x_ = next[0];
                int y_ = next[1];
                if (x_ > 0 && x_ < n && y_ > 0 && y_ < m && !visited[x_][y_]) {
                    q.add(new int[]{Math.max(curHeight, heightMap[x_][y_]), x_, y_});
                }
            }

        }
        return res;
    }


    public static void main(String[] args) {
        int[][] heightMap = new int[][]{{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}};

        System.out.println(new T407_trapRainWater().trapRainWater(heightMap));
    }

}
