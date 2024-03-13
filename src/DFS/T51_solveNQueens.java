package src.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntBinaryOperator;

public class T51_solveNQueens {
    /**
     * https://leetcode.cn/problems/n-queens/
     */

    public List<List<String>> solveNQueens(int n) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] already = new boolean[n];

        dfs(res,path,already,0,n);

        char[] chars = new char[n];
        Arrays.fill(chars,'.');
        List<String> strs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            chars[i]='Q';
            strs.add(new String(chars));
            chars[i]='.';
        }

        List<List<String>> ress = new ArrayList<>();
        for (List<Integer> re : res) {
            List<String> temp = new ArrayList<>();
            for (Integer i : re) {
                temp.add(strs.get(i));
            }
            ress.add(temp);
        }


        return ress;
    }

    public void dfs(List<List<Integer>> res, List<Integer> path, boolean[] already, int cur, int n){
        if(cur==n){
            if(path.size()==n){
                res.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = 0; i < n; i++) {

            if(!already[i]){ // cur, i
                boolean iok=true;
                for (int j = 0; j < path.size(); j++) { // j,path.get(j)
                    if(Math.abs(cur-j)==Math.abs(i-path.get(j))){
                        iok=false;
                        break;
                    }
                }

                if(iok){
                    already[i]=true;
                    path.add(i);
                    dfs(res,path,already,cur+1,n);
                    path.remove(path.size()-1);
                    already[i]=false;
                }

            }
        }
    }


    public static void main(String[] args) {
        List<List<String>> res = new T51_solveNQueens().solveNQueens(4);
//        for (List<String> re : res) {
//            // 使用 forEach 方法结合 Lambda 表达式打印每个元素
////            System.out.println("----------");
////            for (String s : re) {
////                System.out.println(s);
////            }
//            System.out.println(re);
//        }

        System.out.println(res);

    }
}
