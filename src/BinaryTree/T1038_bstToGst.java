package src.BinaryTree;

public class T1038_bstToGst {

    /**
     * https://leetcode.cn/problems/binary-search-tree-to-greater-sum-tree/
     */

    private int sum=0;
    public TreeNode bstToGst(TreeNode root) {

        if(root==null){
            return null;
        }

        root.right = bstToGst(root.right);

        sum+=root.val;
        root.val=sum;

        root.left=bstToGst(root.left);

        return root;
    }


    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(0);
        treeNode.right=new TreeNode(1);
        new T1038_bstToGst().bstToGst(treeNode);
        System.out.println();
    }
}
