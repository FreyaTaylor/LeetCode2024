package src.Other.Basic;

import java.util.*;

public class T385_deserialize {
    /**
     * https://leetcode.cn/problems/mini-parser/
     */

    public NestedInteger deserialize(String s) {
        if (s.length() == 0) {
            return new NestedInteger();
        } else if (s.charAt(0) != '[') {
            return single(s);
        }

        Deque<NestedInteger> q = new ArrayDeque<>();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == ',') {
                i++;
            } else if (s.charAt(i) == ']') {
                if (i != s.length() - 1) { //last ],donot remove
                    q.removeLast();
                }
                i++;
            } else if (s.charAt(i) == '[') {
                NestedInteger cur = new NestedInteger();
                if (!q.isEmpty()) {
                    q.getLast().add(cur);
                }
                q.addLast(cur);
                i++;
            } else {
                int start = i;
                while (i < s.length() && s.charAt(i) != ',' && s.charAt(i) != '[' && s.charAt(i) != ']') {
                    i++;
                }
                q.getLast().add(single(s.substring(start, i)));
            }
        }


        return q.getFirst();
    }

    public NestedInteger single(String s) {
        int mark = 1;
        if (s.charAt(0) == '-') {
            s = s.substring(1, s.length());
            mark = -1;
        }
        return new NestedInteger(mark * Integer.valueOf(s));
    }


}


// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {
    public NestedInteger();

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value);

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni);

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}
