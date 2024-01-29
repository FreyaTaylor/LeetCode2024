package src.DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class T2850_minimumMoves {

    /**
     * https://leetcode.cn/problems/minimum-moves-to-spread-stones-over-grid/?company_slug=microsoft
     *
     * @param grid
     * @return
     */
    int res=Integer.MAX_VALUE;
    public int minimumMoves(int[][] grid) {
        List<int[]> zeros = new ArrayList<>();
        List<int[]> many = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(grid[i][j]==0){
                    zeros.add(new int[]{i,j});
                }else if(grid[i][j]>1){
                    many.add(new int[]{i,j,grid[i][j]-1});
                }
            }
        }

        int[][]dist= new int[many.size()][zeros.size()];
        for (int i = 0; i < many.size(); i++) {
            for (int j = 0; j < zeros.size(); j++) {
                dist[i][j]=Math.abs(many.get(i)[0]-zeros.get(j)[0])+Math.abs(many.get(i)[1]-zeros.get(j)[1]);
            }
        }
        int[] times = new int[many.size()];
        for (int i = 0; i < many.size(); i++) {
            times[i]=many.get(i)[2];
        }

        helper(dist,times,0,0);
        return res;
    }

    public void helper(int[][]dist,int[] times,int cur,int curSum){
        if(cur==dist[0].length){
            res=Math.min(res,curSum);
            return;
        }
        for (int i = 0; i < dist.length; i++) {
            if(times[i]>0){
                times[i]--;
                helper(dist,times,cur+1,curSum+dist[i][cur]);
                times[i]++;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new T2850_minimumMoves().minimumMoves(new int[][]{{1,3,0},{1,0,0},{1,0,3}}));
    }

}
