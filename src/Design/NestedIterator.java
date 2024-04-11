package src.Design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIterator {

    /**
     * https://leetcode.cn/problems/flatten-nested-list-iterator/
     */


    private List<Integer> nums;
    private Iterator<Integer> iterator;

    public NestedIterator(List<NestedInteger> nestedList) {
        nums = new ArrayList<>();
        dfs(nestedList);
        iterator = nums.iterator();


    }

    public void dfs(List<NestedInteger> nestedList){
        for (NestedInteger nestedInteger : nestedList) {
            if(nestedInteger.isInteger()){
                nums.add(nestedInteger.getInteger());
            }
            dfs(nestedInteger.getList());
        }
    }

//    @Override
    public Integer next() {
        return iterator.next();
    }

//    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }


}
