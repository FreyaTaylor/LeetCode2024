package src.Other.Basic;

import java.util.ArrayDeque;
import java.util.Deque;

public class T544_findContestMatch {

    /**
     * https://leetcode.cn/problems/output-contest-matches/
     */

    public String findContestMatch(int n) {
        Deque<String> q = new ArrayDeque<>();
        Deque<String> tempQ = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            q.addLast(""+i);
        }

        while (q.size()>1){
            tempQ = new ArrayDeque<>();
            while (q.size()>0){
                tempQ.addLast("("+q.removeFirst()+","+q.removeLast()+")");
            }
            q=tempQ;
        }

        return q.removeLast();
    }

    public static void main(String[] args) {
        System.out.println(new T544_findContestMatch().findContestMatch(8));
    }
}
