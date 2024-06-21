package src.DFS.SubsetSelection;

import java.util.*;

public class T40_combinationSum2_1 {

    /**
     * https://leetcode.cn/problems/combination-sum-ii/
     * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * candidates 中的每个数字在每个组合中只能使用 一次
     * 注意：解集不能包含重复的组合。
     * @param candidates
     * @param target
     * @return
     * 先排序，然後dfs。
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < candidates.length; i++) {
            map.put(candidates[i],map.getOrDefault(candidates[i],0)+1);
        }

        int n=map.size();
        int[][] nums = new int[n][2];
        int index=0;
        for (Integer i : map.keySet()) {
            nums[index][0]=i;
            nums[index++][1]=map.get(i);
        }

        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        List<List<Integer>> res = new ArrayList<>();
        dfs(res,new ArrayList<>(),0,0,target,nums);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> path, int cursum,int index,int target,int[][] nums){

        // 记录满足要求的结果
        if(cursum==target){
            res.add(new ArrayList<>(path));
            return;
        }

        // 退出条件
        if(index>=nums.length){
            return;
        }

        // 剪枝
        if(cursum+nums[index][0]>target){
            return;
        }

        // 对index的操作，及其后续dfs
        int maxCount=(target-cursum)/nums[index][0];
        int i = 0;
        for ( ;i <=Math.min(maxCount,nums[index][1]) ; i++) {
            dfs(res,path,cursum+i*nums[index][0],index+1,target,nums);
            path.add(nums[index][0]);
        }

        //dfs回退
        while (i>0){
            path.remove(path.size()-1);
            i--;
        }

    }



    public static void main(String[] args) {
        System.out.println(new T40_combinationSum2_1().combinationSum2(new int[]{2,5,2,1,2},5));
//        System.out.println(new T40_combinationSum2_1().combinationSum2(new int[]{10,1,2,7,6,1,5},8));
    }

}
