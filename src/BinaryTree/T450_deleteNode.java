package src.BinaryTree;

public class T450_deleteNode {

    /**
     * https://leetcode.cn/problems/delete-node-in-a-bst/
     */

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return null;
        }

        if(root.val>key){
            root.left=deleteNode(root.left,key);
            return root;
        }else if(root.val<key){
            root.right=deleteNode(root.right,key);
            return root;
        }else {
            if(root.left==null&& root.right==null){
                return null;
            }else if(root.left!=null){
                int leftMax=maxVal(root.left);
                root.left=deleteNode(root.left,leftMax);
                root.val=leftMax;
                return root;
            }else {
                int rightMin = minVal(root.right);
                root.right=deleteNode(root.right,rightMin);
                root.val=rightMin;
                return root;
            }
        }

    }

    public int maxVal(TreeNode root){
        TreeNode cur=root;
        while (cur.right!=null){
            cur=cur.right;
        }
        return cur.val;
    }

    public int minVal(TreeNode root){
        TreeNode cur=root;
        while (cur.left!=null){
            cur=cur.left;
        }
        return cur.val;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right=new TreeNode(6);
        root.right.right=new TreeNode(7);

        TreeNode res = new T450_deleteNode().deleteNode(root,3);
        System.out.println(res);
    }
}
