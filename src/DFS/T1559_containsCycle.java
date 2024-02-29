package src.DFS;

import java.util.HashSet;
import java.util.Set;

public class T1559_containsCycle {

    /**
     * https://leetcode.cn/problems/detect-cycles-in-2d-grid/
     */

    public boolean containsCycle(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
//                System.out.println("--------------------------------------");
                if(!visited[i][j] && dfs(grid[i][j],grid,visited,new HashSet<>(),i,j,new int[]{-1,-1})){
                    return true;
                }

            }
        }

        return false;
    }

    public boolean dfs(char c, char[][] grid,boolean[][] visited,Set<Integer> path,int i,int j,int[] pre){

//        System.out.println(i+" "+j);
        if(path.contains(i*1000+j)){
            return true;
        }

        visited[i][j]=true;
        path.add(i*1000+j);

        int[][] next = new int[][]{{i,j+1},{i,j-1},{i+1,j},{i-1,j}};
        for (int k = 0; k < 4; k++) {
            int nexti=next[k][0];
            int nextj=next[k][1];
            if(nexti>=0 && nexti<grid.length && nextj>=0 && nextj<grid[0].length
                    && !(pre[0]==nexti && pre[1]==nextj)
                    && grid[nexti][nextj]==c){
                if (dfs(c,grid,visited,path,nexti,nextj,new int[]{i,j})){
                    return true;
                }
            }
        }

        path.remove(i*1000+j);
        return false;
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'a','n','a','a'},
                {'a','b','a','a'},
                {'a','b','c','a'},
                {'a','a','a','f'}};
        System.out.println(new T1559_containsCycle().containsCycle(grid));
    }

}
