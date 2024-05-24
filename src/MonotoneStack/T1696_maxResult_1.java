package src.MonotoneStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class T1696_maxResult_1 {

    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] maxScore = new int[n];
        maxScore[0]=nums[0];
        Deque<Integer> index = new ArrayDeque<>();
        index.addLast(0);

        for (int i = 1; i < n; i++) {
            while (!index.isEmpty() && i-index.getFirst()>k){
                index.removeFirst();
            }
            maxScore[i]=nums[i]+maxScore[index.getFirst()];

            while (!index.isEmpty() && nums[index.getLast()]<=nums[i]){
                    index.removeLast();
            }
            index.addLast(i);
        }


        return maxScore[n-1];
    }


    public static void main(String[] args) {
        int[]nums = new int[]{1,-1,-2,4,-7,3};
        int k = 2;
        System.out.println(new T1696_maxResult_1().maxResult(nums,k));
    }
}
