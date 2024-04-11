package src.BinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;

public class T450_deleteNode_1 {

    /**
     * https://leetcode.cn/problems/delete-node-in-a-bst/
     */

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){return null;}
        if(key==root.val){
            System.out.println();
            if(root.left==null && root.right==null){
                return null;
            }
            if(root.left!=null){
                int newVal = mostRight(root.left);
                root.left=deleteNode(root.left,newVal);
                root.val=newVal;
                return root;
            }

            int newVal = mostLeft(root.right);
            root.right=deleteNode(root.right,newVal);
            root.val=newVal;
            return root;


        }else if(key<root.val){
            root.left=deleteNode(root.left,key);
            return root;
        }else {
            root.right=deleteNode(root.right,key);
            return root;
        }
    }

    public int mostRight(TreeNode t){
        TreeNode cur = t;
        while (cur!=null && cur.right!=null){
            cur=cur.right;
        }
        return cur.val;
    }

    public int mostLeft(TreeNode t){
        TreeNode cur = t;
        while (cur!=null && cur.left!=null){
            cur=cur.left;
        }
        return cur.val;
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

        TreeNode res = new T450_deleteNode_1().deleteNode(root,5);
        System.out.println(res);
    }
}
