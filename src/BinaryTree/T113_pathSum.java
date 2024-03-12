package src.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class T113_pathSum {

    /**
     * https://leetcode.cn/problems/path-sum-ii/
     */

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        if(root==null){
            return res;
        }

        dfs(res,path,root,0,targetSum);
        return res;

    }

    public void dfs(List<List<Integer>> res,List<Integer> path,TreeNode root,int curSum,int targetSum){
//        System.out.println(path.toString()+" "+root.val);


        path.add(root.val);
        int nextSum=curSum+root.val;

        if(root.left==null && root.right==null){
            if(nextSum==targetSum){
                res.add(new ArrayList<>(path));
            }

        }

        if(root.left!=null){
            dfs(res,path,root.left,nextSum,targetSum);
        }

        if(root.right!=null){
            dfs(res,path,root.right,nextSum,targetSum);
        }

        path.remove(path.size()-1);

    }


    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left=new TreeNode(2);
//        t.right=new TreeNode(3);

        System.out.println(new T113_pathSum().pathSum(t,3).toString());

    }

}
