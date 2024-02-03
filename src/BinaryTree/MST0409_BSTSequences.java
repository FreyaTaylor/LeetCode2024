package src.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class MST0409_BSTSequences {

    /**
     * https://leetcode.cn/problems/bst-sequences-lcci/
     * 对于二叉搜索树及其每个子树，都应满足根结点值首先插入。
     */

    public List<List<Integer>> BSTSequences(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            res.add(new ArrayList<>());
            return res;
        }

        List<List<Integer>> lstr= BSTSequences(root.left);
        List<List<Integer>> rstr= BSTSequences(root.right);

        for (List<Integer> l : lstr) {
            for (List<Integer> r : rstr) {
                List<List<Integer>> restemp = new ArrayList<>();
                List<Integer> cur = new ArrayList<>();
                cur.add(root.val);
                helper(restemp,cur,l,r,0,0);
                res.addAll(restemp);
            }
        }
        return res;
    }

    public void helper(List<List<Integer>> res,List<Integer> cur,List<Integer> l ,List<Integer> r ,int i,int j){

        if(i==l.size()&&j==r.size()){
            res.add(new ArrayList<>(cur));
            return ;
        }

        if(i<l.size()){
            cur.add(l.get(i));
            helper(res,cur,l,r,i+1,j);
            cur.remove(cur.size()-1);
        }
        if(j<r.size()){
            cur.add(r.get(j));
            helper(res,cur,l,r,i,j+1);
            cur.remove(cur.size()-1);
        }

    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(2);
        root.left.left=new TreeNode(1);
        root.left.right=new TreeNode(4);
        root.left.right.left=new TreeNode(3);

//        root.right=new TreeNode(4);
        System.out.println(new MST0409_BSTSequences().BSTSequences(root));
    }
}
