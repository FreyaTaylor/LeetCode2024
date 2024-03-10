package src.Other.Basic;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class T946_validateStackSequences {

    /**
     * https://leetcode.cn/problems/validate-stack-sequences/
     */

    public boolean validateStackSequences(int[] pushed, int[] popped) {

        int i=0,j=0;
        Deque<Integer> q = new ArrayDeque<>();
        while (j<popped.length){
            if(q.isEmpty() || q.getLast()!=popped[j]){
                if(i<pushed.length){
                    q.addLast(pushed[i++]);
                }else {
                    return false;
                }

            }else {
                q.removeLast();
                j++;
            }
        }

        return i==pushed.length && j==popped.length;
    }


    public static void main(String[] args) {
        int[] pushed = new int[]{1,2,3,4,5};
//        int[] popped = new int[]{4,5,3,2,1};
        int[] popped = new int[]{4,3,5,1,2};
        System.out.println(new T946_validateStackSequences().validateStackSequences(pushed,popped));

    }
}
