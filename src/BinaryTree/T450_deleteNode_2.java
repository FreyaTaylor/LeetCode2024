package src.BinaryTree;

public class T450_deleteNode_2 {

    /**
     * https://leetcode.cn/problems/delete-node-in-a-bst/
     */

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){return null;}
        if(key==root.val){

            if(root.left==null && root.right==null){
                return null;
            }

            if(root.left==null){
                return root.right;
            }
            if(root.right==null){
                return root.left;
            }


            // 两个都有，与我的逻辑处理一样，先找，再删，然后赋值
            TreeNode temp = root.right;
            while (temp.left!=null){
                temp=temp.left;
            }// 代删除点 temp
            // root.right删除temp.val
            root.right=deleteNode(root.right,temp.val);
            // 赋值
            root.val=temp.val;
            return root;


        }else if(key<root.val){
            root.left=deleteNode(root.left,key);
            return root;
        }else {
            root.right=deleteNode(root.right,key);
            return root;
        }
    }


    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(3);
//        root.left.left = new TreeNode(2);
//        root.left.right = new TreeNode(4);
//
//        root.right=new TreeNode(6);
//        root.right.right=new TreeNode(7);



        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right=new TreeNode(7);

        TreeNode res = new T450_deleteNode_2().deleteNode(root,5);
        System.out.println(res);
    }
}
