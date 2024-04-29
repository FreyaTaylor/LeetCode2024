package src.BinaryTree;

public class T1325_removeLeafNodes {

    /**
     *
     * https://leetcode.cn/problems/delete-leaves-with-a-given-value/
     *
     */

    public TreeNode removeLeafNodes(TreeNode root, int target) {

        if(root==null){
            return null;
        }

        root.left=removeLeafNodes(root.left,target);
        root.right=removeLeafNodes(root.right,target);

        if(root.left==null && root.right==null && root.val==target){
            return null;
        }

        return root;

    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(3);
        t.left.left = new TreeNode(3);
        t.left.right = new TreeNode(2);
        t.right= new TreeNode(3);

        new T1325_removeLeafNodes().removeLeafNodes(t,3);
        System.out.println();
    }


}
