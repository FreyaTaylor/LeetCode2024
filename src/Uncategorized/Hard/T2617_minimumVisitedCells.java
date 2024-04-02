package src.Uncategorized.Hard;

import java.util.*;

public class T2617_minimumVisitedCells {

    /**
     * https://leetcode.cn/problems/minimum-number-of-visited-cells-in-a-grid
     */


//    public int minimumVisitedCells(int[][] grid) {
//        int m=grid.length;
//        int n=grid[0].length;
//        Set<Long> visited = new HashSet<>();
//        visited.add(0L);
//        int setp=0;
//        Deque<int[]> q = new ArrayDeque<>();
//        q.add(new int[]{0,0});
//
//        while (!q.isEmpty()){
//            int size = q.size();
//            setp++;
//            for (int i = 0; i < size; i++) {
//                int[] cur = q.removeFirst();
//                int x=cur[0];
//                int y=cur[1];
//                int num=grid[x][y];
//
//                if(x==m-1 && y==n-1){
//                    return setp;
//                }
//
//                for (int j =1; j<=num && y+j < n ; j++) {
//                    int ny=y+j;
//                    Long pos = (long)x*1000000+ny;
//                    if(!visited.contains(pos)){
//                        visited.add(pos);
//                        q.addLast(new int[]{x,ny});
//                    }
//                }
//
//                for (int j =1; j<=num && x+j < m ; j++) {
//                    int nx=x+j;
//                    Long pos = (long)nx*1000000+y;
//                    if(!visited.contains(pos)){
//                        visited.add(pos);
//                        q.addLast(new int[]{nx,y});
//                    }
//                }
//
//            }
//        }
//
//
//        return -1;
//    }
//
//


//    public int minimumVisitedCells(int[][] grid) {
//        int m=grid.length;
//        int n=grid[0].length;
//        int []  hang = new int[m]; //第i行，从0开始到哪里已经visited了
//        int []  lie = new int[n]; //第i列，从0开始到哪里已经visited了
//        Arrays.fill(hang,-1);
//        Arrays.fill(lie,-1);
//        hang[0]=0;
//        lie[0]=0;
//        int[] hang_ = Arrays.copyOf(hang,m);
//        int[] lie_ = Arrays.copyOf(lie,n);
//        int[][] res = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            Arrays.fill(res[i],-1);
//        }
//        Set<Long> visited = new HashSet<>();
//        visited.add(0L);
//        int setp=0;
//        Deque<int[]> q = new ArrayDeque<>();
//        q.add(new int[]{0,0});
//
//        while (!q.isEmpty()){
//            int size = q.size();
//            setp++;
//
//            for (int i = 0; i < size; i++) {
//                int[] cur = q.removeFirst();
//                int x=cur[0];
//                int y=cur[1];
//                int num=grid[x][y];
//                res[x][y]=setp;
//
//                if(x==m-1 && y==n-1){
//                    return setp;
//                }
//
//                // 不能通过hang来减少计算重复，因为此时的x,y的上一步不一定是从左右走的
//                int jstart=Math.max(hang[x]+1,y+1);
//                int jend=Math.min(n-1,y+num);
//                hang_[x]=Math.max(hang_[x],jend);
//                for (int j = jstart; j<=jend ; j++) {
//                    int ny=j;
//                    Long pos = (long)x*1000000+ny;
//                    if(!visited.contains(pos)){
//                        visited.add(pos);
//                        q.addLast(new int[]{x,ny});
//                    }
//                }
//
//                jstart=Math.max(lie[y]+1,x+1);
//                jend=Math.min(m-1,x+num);
//                lie_[y]=Math.max(lie_[y],jend);
//                for (int j = jstart; j<=jend ; j++) {
//                    int nx=j;
//                    Long pos = (long)nx*1000000+y;
//                    if(!visited.contains(pos)){
//                        visited.add(pos);
//                        q.addLast(new int[]{nx,y});
//                    }
//                }
//            }
//
//            hang=Arrays.copyOf(hang_,m);
//            lie=Arrays.copyOf(lie_,n);
////            System.out.println();
//        }
//
//
//        return -1;
//    }

    public int minimumVisitedCells(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0]=1;
        PriorityQueue<int[]> [] row = new PriorityQueue[m]; //[index,step]
        PriorityQueue<int[]> [] col = new PriorityQueue[n];

        for (int i = 0; i < m; i++) {
            row[i]=new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1]-o2[1];
                }
            });
        }

        for (int i = 0; i < n; i++) {
            col[i]=new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1]-o2[1];
                }
            });
        }




        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if(i==0 && j==0){
                    dp[i][j]=1;
                }else {

                    int colStep = Integer.MAX_VALUE;
                    while (!col[j].isEmpty()
                            && (col[j].peek()[0] + grid[col[j].peek()[0]][j] < i)
                            && col[j].peek()[1]!=Integer.MAX_VALUE) {
                        col[j].poll();
                    }

                    if (!col[j].isEmpty()) {
                        int[] colFrom = col[j].peek();
                        if(colFrom[1] !=Integer.MAX_VALUE){

                        }
                        colStep = colFrom[1] + 1;

                    }

                    int rowStep = Integer.MAX_VALUE;
                    while (!row[i].isEmpty()
                            && (row[i].peek()[0] + grid[i][row[i].peek()[0]] < j)
                            && row[i].peek()[1]!=Integer.MAX_VALUE) {
                        row[i].poll();
                    }

                    if (!row[i].isEmpty()) {
                        int[] colFrom = row[i].peek();
                        rowStep = colFrom[1] + 1;
                    }

                    dp[i][j] = Math.min(rowStep, colStep);

                }

                if(dp[i][j]!=Integer.MAX_VALUE){
                    col[j].add(new int[]{i,dp[i][j]});
                    row[i].add(new int[]{j,dp[i][j]});
                }


            }
        }

        if(dp[m-1][n-1]==Integer.MAX_VALUE){
            return -1;
        }
        return dp[m-1][n-1];
    }


    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {3,4,2,1},
                {4,2,3,1},
                {2,1,0,0},
                {2,4,0,0}};

        grid = new int[][]{
                {2, 3, 0, 0, 1, 0, 1, 2, 1},
                {0, 1, 3, 3, 0, 0, 2, 2, 0}};
        grid = new int[][]{
                {1, 3, 1, 3, 3, 2},
                {1, 1, 0, 3, 2, 2},
                {1, 3, 2, 0, 0, 3},
                {0, 2, 1, 0, 3, 1},
                {2, 0, 2, 0, 3, 0},
                {3, 0, 0, 2, 3, 0},
                {3, 2, 1, 2, 0, 0}};


        System.out.println(new T2617_minimumVisitedCells().minimumVisitedCells(grid));
    }

}
