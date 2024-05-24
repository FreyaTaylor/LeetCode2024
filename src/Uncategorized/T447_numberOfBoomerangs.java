package src.Uncategorized;

import java.util.HashMap;
import java.util.Map;

public class T447_numberOfBoomerangs {

    /**
     * https://leetcode.cn/problems/number-of-boomerangs/
     *
     */

    public int numberOfBoomerangs(int[][] points) {

        int res=0;

        // 遍历i，计算与改点距离相同的点数
        for (int i = 0; i < points.length; i++) {
            Map<Integer,Integer> map = new HashMap<>(); //dist,count
            int x=points[i][0];
            int y=points[i][1];
            for (int j = 0; j <points.length ; j++) {
                int dist = (int)Math.pow(x-points[j][0],2)+ (int)Math.pow(y-points[j][1],2);
                map.put(dist,map.getOrDefault(dist,0)+1);
            }

            for (Integer dist : map.keySet()) {
                if(map.get(dist)>=2){
                    res+=map.get(dist)*(map.get(dist)-1);
                }
            }
//            System.out.println();
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{1,1},{2,2},{3,3}};
        points = new int[][]{{1,1}};
        points = new int[][]{{0,0},{1,0},{-1,0},{0,1},{0,-1}};

        System.out.println(new T447_numberOfBoomerangs().numberOfBoomerangs(points));
    }
}
