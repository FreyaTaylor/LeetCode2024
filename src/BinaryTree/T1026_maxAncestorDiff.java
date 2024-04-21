package src.BinaryTree;

import java.util.List;

public class T1026_maxAncestorDiff {

    /**
     * https://leetcode.cn/problems/maximum-difference-between-node-and-ancestor/
     */

    public int res=Integer.MIN_VALUE;
    public int maxAncestorDiff(TreeNode root) {

        helper(root.left,root.val,root.val);
        helper(root.right,root.val,root.val);
        return res;
    }

    public void helper(TreeNode t, int max,int min){

        if(t!=null) {
            res = Math.max(res,Math.max(Math.abs(max - t.val), Math.abs(min - t.val)));
//            System.out.println(t.val+" "+max+" "+min+" "+res);
            int max_ = Math.max(max,t.val);
            int min_ = Math.min(min,t.val);
            helper(t.left,max_,min_);
            helper(t.right,max_,min_);
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);


        root.right = new TreeNode(10);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);


        System.out.println(new T1026_maxAncestorDiff().maxAncestorDiff(root));


    }



}
