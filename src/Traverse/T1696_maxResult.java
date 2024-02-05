package src.Traverse;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.concurrent.DelayQueue;

public class T1696_maxResult {
    /**
     * https://leetcode.cn/problems/jump-game-vi
     * 能用有限队列的，想下是否可用 双端单调队列
     */

//    public int maxResult(int[] nums, int k) {
//        int[] maxval = new int[nums.length];
//        maxval[0]=nums[0];
//        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });
//        q.add(nums[0]);
//        for (int i = 1; i <nums.length ; i++) {
////            System.out.println(i+" "+q.peek());
//            int curMax=q.peek()+nums[i];
//            if (q.size()>=k){
//                q.remove(maxval[i-k]);
//            }
//            q.add(curMax);
//            maxval[i]=curMax;
//        }
//        return maxval[nums.length-1];
//    }

    public int maxResult(int[] nums, int k) {
        int[] maxval = new int[nums.length];
        maxval[0]=nums[0];
        Deque<Integer> q = new ArrayDeque<>(); //降序
        q.addLast(0);

        for (int i = 1; i <nums.length ; i++) {
            if(q.getFirst()+k<i){
                q.removeFirst();
            }
            maxval[i]=maxval[q.getFirst()]+nums[i];

            while (!q.isEmpty()&&maxval[q.getLast()]<=maxval[i]){
                q.removeLast();
            }
            q.addLast(i);
        }
        return maxval[nums.length-1];
    }
    public static void main(String[] args) {
        int[]nums = new int[]{1,-1,-2,4,-7,3};
        int k = 2;
        System.out.println(new T1696_maxResult().maxResult(nums,k));
    }
}
