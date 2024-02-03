package src.BFS;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.DelayQueue;

public class T365_canMeasureWater {
    /**
     * https://leetcode.cn/problems/water-and-jug-problem/description/
     * 最后请用以上水壶中的一或两个来盛放取得的 targetCapacity 升水。
     */

    public boolean canMeasureWater(int a, int b, int target) {
//        target=(target%(Math.max(a,b)))%Math.min(a,b);
        Deque<int[]> q =new ArrayDeque<>();
        Set<Long> set = new HashSet<>();
        Long helper = (long)Math.pow(10,7);

        q.add(new int[]{0,0});
        set.add(0L);

        while (!q.isEmpty()){
        int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur=q.removeFirst();
                int x=cur[0];
                int y=cur[1];
//                System.out.println(x+" "+y);

                if(x==target||y==target||x+y==target){
                    return true;
                }

                int a2b=Math.min(x,(b-y));
                int b2a=Math.min(y,(a-x));
                int[][] next = new int[][]{{0,y},{a,y}, {x-a2b,y+a2b},
                        {x,0},{x,b}, {x+b2a,y-b2a}};

                for (int j = 0; j < 4; j++) {
                    int nextx=next[j][0];
                    int nexty=next[j][1];
                    if(!set.contains(nextx*helper+nexty)){
                        q.addLast(new int[]{nextx,nexty});
                        set.add(nextx*helper+nexty);
                    }
                }
            }


        }


        return false;
    }

    public static void main(String[] args) {
        System.out.println(new T365_canMeasureWater().canMeasureWater(1,1,12));
//        System.out.println(new T365_canMeasureWater().canMeasureWater(2,6,5));
    }

    }
