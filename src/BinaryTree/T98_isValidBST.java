package src.BinaryTree;

public class T98_isValidBST {

    /**
     * https://leetcode.cn/problems/validate-binary-search-tree/
     */

    public boolean isValidBST(TreeNode root) {
        return helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean helper(TreeNode root,long min,long max){
        if(root==null){
            return true;
        }

        int val = root.val;
        if(val<=min || val>=max){
            return false;
        }

        return helper(root.left,min,val)&&helper(root.right,val,max);
    }


}
