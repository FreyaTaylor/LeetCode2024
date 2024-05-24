package src.BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class T94_inorderTraversal {

    /**
     * https://leetcode.cn/problems/binary-tree-inorder-traversal/
     */
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        TreeNode cur = root;

        while (!q.isEmpty() || cur!=null){
            if(cur!=null){
                q.addLast(cur);
                cur=cur.left;
            }else {
                cur=q.removeLast();
                res.add(cur.val);
                cur=cur.right;
            }
        }

        return res;
    }


    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        TreeNode cur = root;

        while (!q.isEmpty() || cur!=null){
            if(cur!=null){
                res.add(cur.val);
                q.addLast(cur);
                cur=cur.left;
            }else {
                cur=q.removeLast().right;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(2);
        node.right.left = new TreeNode(3);
        System.out.println(new T94_inorderTraversal().inorderTraversal(node));
    }
}
