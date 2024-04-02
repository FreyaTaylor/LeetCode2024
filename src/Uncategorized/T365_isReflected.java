package src.Uncategorized;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class T365_isReflected {

    /**
     * https://leetcode.cn/problems/line-reflection/
     */

    public boolean isReflected(int[][] points) {

        Map<Integer, Set<Integer>> map = new HashMap<>();

        int minx = Integer.MAX_VALUE;
        int maxx = Integer.MIN_VALUE;
        for (int i = 0; i < points.length; i++) {
            minx=Math.min(minx,points[i][0]);
            maxx=Math.max(maxx,points[i][0]);

            if(!map.containsKey(points[i][1])){
                map.put(points[i][1],new HashSet<>());
            }

            map.get(points[i][1]).add(points[i][0]);
        }

        int xsum=minx+maxx;


        for (Integer y : map.keySet()) {
            for (Integer x : map.get(y)) {
                if(!map.get(y).contains(xsum-x)){
                    return false;
                }
            }
        }

        return true;

    }

    public static void main(String[] args) {

        int[][] points = new int[][]{{1,1},{-1,-1}};
        System.out.println(new T365_isReflected().isReflected(points));
    }
}
