package src.DFS;

import java.util.ArrayList;
import java.util.List;

public class T216_combinationSum3 {

    /**
     * https://leetcode.cn/problems/combination-sum-iii/
     */

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(res,path,n,k,1,0);
        return res;
    }

    public void dfs(List<List<Integer>> res,List<Integer> path,int n,int k,int cur,int cursum){
        if(cur>9 || path.size()==k){
            if(cursum==n){
                res.add(new ArrayList<>(path));
            }
            return;
        }

        // k-path.size()
        // cur,cur+1,...cur+k-path.size()-1 =cursum+(2*cur+k-path.size()-1)*(k-path.size())/2>n
        // 9-(k-path.size()-1)...,8,9       =cursum+(18-(k-path.size()-1))*(k-path.size())/2<n
        if((cursum+(2*cur+k-path.size()-1)*(k-path.size())/2>n)
                ||(cursum+(18-(k-path.size()-1))*(k-path.size())/2<n)){
            return;
        }

        dfs(res,path,n,k,cur+1,cursum);
        path.add(cur);
        dfs(res,path,n,k,cur+1,cursum+cur);
        path.remove(path.size()-1);

    }


    public static void main(String[] args) {
        System.out.println(new T216_combinationSum3().combinationSum3(3,9));
    }
}
