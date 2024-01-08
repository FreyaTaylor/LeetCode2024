package src.DynamicPrograming.MatryoshkaDolls;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

public class T354_maxEnvelopes {


    /**
     * https://leetcode.cn/problems/russian-doll-envelopes/
     * 1.记忆化动态规划：dp[i]=max{ all j ：int[j][]>intint[i][]}+
     * 时间复杂度为：O(n2)
     *
     * 2.按照第一维度升序，第二维度降序排列，然后只保留第二维的数，存于nums，然后找nums的最长升序序列
     * 为什么“第一维度升序，第二维度降序排列”，避免[6,4],[6,7] 的出现，如果是[6,7],[6,4]则第二维度不符合升序
     * 最长升序序列 单调栈！
     */

    public int maxEnvelopes(int[][] envelopes) {
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]!=o2[0]){
                    return o1[0]-o2[0];
                }else {
                    return o2[1]-o1[1];
                }
            }
        });

        int n=envelopes.length;
        for (int i = 0; i < n; i++) {
            q.add(envelopes[i]);
        }

        int[] h = new int[n];
        for (int i = 0; i <n ; i++) {
            h[i]=q.poll()[1];
        }

        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(h[0]);
        int res=1;
        for (int i = 1; i < n ; i++) {
            if(dq.getLast()<h[i]){
                dq.addLast(h[i]);
                res++;
            } else if(dq.getLast()==h[i]){
                continue;
            } else{
                Deque<Integer> temp = new ArrayDeque<>();
                // >= ，防止dq={ 7 9 11 17 }，h[i]=11
                while (!dq.isEmpty()&& dq.getLast()>=h[i]){
                    temp.addFirst(dq.removeLast());
                }
                dq.addLast(h[i]);
                temp.removeFirst();
                while (!temp.isEmpty()){
                    dq.addLast(temp.removeFirst());
                }
            }
//            System.out.println(dq);
        }

        return res;
    }

    public static void main(String[] args) {

//        int[][] arr = new int[][]{{5,4},{6,4},{6,7},{2,3}};
//        int[][] arr = new int[][]{{5,4},{5,4},{5,4},{5,4}};
        int[][] arr = new int[][]{{15,8},{2,20},{2,14},{4,17},{8,19},{8,9},{5,7},{11,19},{8,11},{13,11},{2,13},{11,19},{8,11},{13,11},{2,13},{11,19},{16,1},{18,13},{14,17},{18,19}};
        System.out.println(new T354_maxEnvelopes().maxEnvelopes(arr));
    }
}
