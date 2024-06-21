package src.DFS.SubsetSelection;



import java.util.ArrayList;
import java.util.List;

public class T39_combinationSum {
    /**
     * https://leetcode.cn/problems/combination-sum/
     */

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(res,path,candidates,0,0,target);
        return res;
    }

    public void dfs(List<List<Integer>>res,List<Integer> path,int[] candidates,int cur,int cursum,int target){
        if(cur>=candidates.length){
            if(cursum==target){
                res.add(new ArrayList<>(path));
            }
            return;
        }

        int maxcount=(target-cursum)/candidates[cur];
        for (int i = 0; i<=maxcount ; i++) {
            dfs(res,path,candidates,cur+1,i*candidates[cur]+cursum,target);
            path.add(candidates[cur]);
        }
        for (int i = 0; i<=maxcount ; i++) {
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new T39_combinationSum().combinationSum(new int[]{2,3,5},8));
    }

}
