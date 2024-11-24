package src.Graph.Dijkstra;

import java.util.*;

public class T1631_minimumEffortPath {
    /**
     * https://leetcode.cn/problems/path-with-minimum-effort/description/
     */

    public int minimumEffortPath(int[][] heights) {

        int m=heights.length;
        int n=heights[0].length;


        boolean [][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(visited[i],false);
        }
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        q.add(new int[]{0,0,0});


        while (true){
            int[] cur = q.poll();
            int path=cur[0];
            int x=cur[1];
            int y=cur[2];

            if(x==m-1 && y==n-1){
                return path;
            }

            if(!visited[x][y]){
                int[][] nexts = new int[][]{{x+1,y},{x-1,y},{x,y+1},{x,y-1}};
                visited[x][y]=true;

                for (int[] next : nexts) {
                    int xx=next[0];
                    int yy=next[1];

                    if(xx>=0 && xx<m && yy>=0 && yy<n && !visited[xx][yy]){
                        q.add(new int[]{Math.max(path,Math.abs(heights[x][y]-heights[xx][yy])),xx,yy});
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        int[][]heights = new int[][]{{1,2,3},{3,8,4},{5,3,5}};
        System.out.println(new T1631_minimumEffortPath().minimumEffortPath(heights));
    }
}
