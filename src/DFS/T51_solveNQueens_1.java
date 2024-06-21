package src.DFS;

import java.util.*;

public class T51_solveNQueens_1 {
    /**
     * https://leetcode.cn/problems/n-queens/
     * int[] 不能深复制，System.arraycopy(a, 0, b, 0, a.length);
     * strs[i]=new String(chars);
     */

    public List<List<String>> solveNQueens(int n) {
        List<Integer> path = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();

        dfs(res,path,set,0,n);

        char[] chars = new char[n];
        Arrays.fill(chars,'.');
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            chars[i]='Q';
            strs[i]=new String(chars);
            chars[i]='.';
        }

        List<List<String>> ress = new ArrayList<>();
        for (int i = 0; i < res.size(); i++) {
            List<String> temp = new ArrayList<>();

            for (int j = 0; j <n ; j++) {
                temp.add(strs[res.get(i).get(j)]);
            }
            ress.add(temp);
        }


        return ress;
    }


    public void dfs(List<List<Integer>> res, List<Integer>  path, Set<Integer> set, int cur,int n){

        if(cur==n){
            res.add(new ArrayList(path));
            return;
        }

        for (int i = 0; i < n; i++) {
            if(!set.contains(i)){

                boolean ok=true;
                for (int j = 0; j < cur; j++) {
                    // (cur,i) (j,path[j])
                    if(Math.abs((double) (path.get(j)-i)/(j-cur))==1){
                        ok=false;
                        break;
                    }
                }

                if(ok){
                    set.add(i);
                    path.add(i);
                    dfs(res,path,set,cur+1,n);
                    path.remove(path.size()-1);
                    set.remove(i);
                }

            }
        }


    }





    public static void main(String[] args) {
        List<List<String>> res = new T51_solveNQueens_1().solveNQueens(4);


        System.out.println(res);

    }
}
