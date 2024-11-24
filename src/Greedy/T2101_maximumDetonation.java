package src.Greedy;

import java.util.*;

public class T2101_maximumDetonation {

    /**
     * https://leetcode.cn/problems/detonate-the-maximum-bombs
     * @param bombs
     * @return
     */
    public int maximumDetonation(int[][] bombs) {
        int n=bombs.length;
        List<Set<Integer>> d = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            Set<Integer> temp = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if(i!=j && Math.pow(bombs[i][0]-bombs[j][0],2)
                        +Math.pow(bombs[i][1]-bombs[j][1],2)
                        <=Math.pow(bombs[i][2],2)){
                    temp.add(j);
                }
            }
            d.add(temp);
        }

        int res=0;
        Set<Integer> alreadyTest = new HashSet<>();
        // 如果a引爆b，则引爆a的最终的数量，比如大于等于引爆b
        // 因此，可以减少计算次数，把前面被引爆的记录在alreadyTest中
        for (int i = 0; i < n; i++) {
            if(alreadyTest.contains(i)){
                continue;
            }

            // 引爆i的层次遍历
            Set<Integer> temp = new HashSet<>();
            Deque<Integer> q =new ArrayDeque<>();
            q.add(i);
            temp.add(i);
            while (!q.isEmpty()){
                int size = q.size();
                for (int j = 0; j < size; j++) {
                    Set<Integer> nexts = d.get(q.removeFirst()); //引爆
                    for (Integer next : nexts) {
                        if(!temp.contains(next)){
                            temp.add(next);
                            q.addLast(next);
                        }
                    }
                }
            }
            alreadyTest.addAll(new ArrayList<>(temp));
            res=Math.max(res,temp.size());
        }


        return res;
    }

    public static void main(String[] args) {
        int[][] bombs = new int[][]{{1,1,5},{10,10,5}};
        bombs = new int[][]{{1,2,3},{2,3,1},{3,4,2},{4,5,3},{5,6,4}};

        System.out.println(new T2101_maximumDetonation().maximumDetonation(bombs));
    }
}
