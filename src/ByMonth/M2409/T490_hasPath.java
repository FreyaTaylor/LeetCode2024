package src.ByMonth.M2409;

import java.util.Arrays;

public class T490_hasPath {

    /**
     * https://leetcode.cn/problems/the-maze/description/
     * 1.球可以途经空地向 上、下、左、右 四个方向滚动，且在遇到墙壁前不会停止滚动。当球停下时，可以选择向下一个方向滚动。
     * 请你判断球能否在目的地[停下]
     * 2. // visited[x_][y_]=false; //检查过的点无需检查，直接设置成true
     */


    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

        boolean[][] visited = new boolean[maze.length][maze[0].length];
        visited[start[0]][start[1]]=true;
        return dfs(maze,visited,start[0],start[1],destination);
    }

    public boolean dfs(int[][] maze, boolean[][] visited, int x,int y,int[] destination){

        if(x==destination[0] && y==destination[1]){
            return true;
        }
        int m=maze.length;
        int n=maze[0].length;

        int[][] nexts = new int[4][2];

        int i=x+1;
        while (i<m && maze[i][y]==0){i++;}
        nexts[0][0]=i-1;
        nexts[0][1]=y;

        i=x-1;
        while (i>=0 && maze[i][y]==0){i--;}
        nexts[1][0]=i+1;
        nexts[1][1]=y;

        int j=y+1;
        while (j<n && maze[x][j]==0){j++;}
        nexts[2][0]=x;
        nexts[2][1]=j-1;

        j=y-1;
        while (j>=0 && maze[x][j]==0){j--;}
        nexts[3][0]=x;
        nexts[3][1]=j+1;


        for (int[] next : nexts) {
            int x_=next[0];
            int y_=next[1];
//            System.out.println(Arrays.toString(next));

            if(x_>=0 && x_<maze.length && y_>=0 && y_<maze[0].length && !visited[x_][y_] && maze[x_][y_]==0){
                visited[x_][y_]=true;
                if(dfs(maze,visited,x_,y_,destination)){
                    return true;
                }
                // visited[x_][y_]=false; //检查过的点无需检查，直接设置成true

            }

        }

        return false;
    }


    public static void main(String[] args) {
        int[][] maze;
        int[] start;
        int[] destination;

        maze=new int[][] {
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0}};
        start = new int[]{0,4};
        destination = new int[]{3,2};

        maze=new int[][] {
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0}};
        start = new int[]{0,4};
        destination = new int[]{4,4};

        System.out.println(new T490_hasPath().hasPath(maze,start,destination));
    }
}
