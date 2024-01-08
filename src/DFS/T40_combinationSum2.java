package src.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T40_combinationSum2 {

    /**
     * https://leetcode.cn/problems/combination-sum-ii/
     * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * candidates 中的每个数字在每个组合中只能使用 一次
     * @param candidates
     * @param target
     * @return
     * 先排序，然後dfs。
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        helper(res,path,candidates,0,target);
        return res;
    }

    public void helper(List<List<Integer>> res,List<Integer> path,int[] candidates,int cur,int target){
        if(cur==candidates.length){
            if(target==0){
                res.add(new ArrayList<>(path));
            }
            return;
        }

        // 尋找下一個數字,以及該數字出現了幾次
        int nextCur = cur+1;
        while (nextCur<candidates.length && candidates[nextCur]==candidates[cur])nextCur++;
        int count=nextCur-cur;
        // 最多可合法使用該數字幾次
        int maxUse = Math.min(target/candidates[cur],count);

        helper(res,path,candidates,nextCur,target); // 0
        for (int i = 1; i <=maxUse ; i++) { // 1至maxUse
            path.add(candidates[cur]);
            helper(res,path,candidates,nextCur,target-i*candidates[cur]);
        }

        // 退回到沒使用過該數字的現場
        for (int i = 1; i <=maxUse ; i++) {
            path.remove(path.size()-1);
        }

    }

    public static void main(String[] args) {
        System.out.println(new T40_combinationSum2().combinationSum2(new int[]{10,1,2,7,6,1,5},8));
    }

}
