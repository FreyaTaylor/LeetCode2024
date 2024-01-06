package src;

import java.util.*;

public class T763_partitionLabels {
    /**
     * https://leetcode.cn/problems/partition-labels/description/
     * @param s
     * @return
     */
    public List<Integer> partitionLabels(String s) {
        Map<Character,int[]> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),new int[]{i,-1});
            }
            map.get(s.charAt(i))[1]=i;
        }
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        for(Character key:map.keySet()){
            q.add(map.get(key));
        }
        List<Integer> res=new ArrayList<>();
        while (!q.isEmpty()){

            int[] cur=q.poll();
            int left=cur[0];
            int right=cur[1];
            while (!q.isEmpty() && q.peek()[0]<right){
                right=Math.max(right,q.poll()[1]);
            }
            res.add(right-left+1);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new T763_partitionLabels().partitionLabels("ababcbacadefegdehijhklij"));
    }

}
