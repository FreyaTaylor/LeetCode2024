package src.MonotoneStack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class T239_maxSlidingWindow {

    /**
     * https://leetcode.cn/problems/sliding-window-maximum/
     * 在窗口范围内，左且小的数，无用，因此维护一个降序的栈，每次返回最左元素
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        Deque<Integer> q = new ArrayDeque<>();
        // q存index，这样即相当于既存了index，又存了nums[index]

        for (int i = 0; i < k; i++) {
            while (!q.isEmpty()&& nums[q.getLast()]<=nums[i]){
                q.removeLast();

            }
            q.addLast(i);
        }
        res[0]=nums[q.getFirst()];
        for (int i = k; i < nums.length; i++) {
            while (!q.isEmpty()&& nums[q.getLast()]<=nums[i]){
                q.removeLast();

            }
            q.addLast(i);
            while (!q.isEmpty()&&q.getFirst()<i-k+1){
                q.removeFirst();
            }
            res[i-k+1]=nums[q.getFirst()];
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new T239_maxSlidingWindow().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3)));
    }
}
