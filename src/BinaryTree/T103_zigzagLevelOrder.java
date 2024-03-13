package src.BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class T103_zigzagLevelOrder {

    /**
     * https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/
     */

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if(root==null){
            return res;
        }

        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        boolean left2right=true;
        List<Integer>  level = new ArrayList<>();
        while (!q.isEmpty()){
            int size=q.size();
            level = new ArrayList<>();
            if(left2right){
                for (int i = 0; i < size; i++) {
                    TreeNode cur = q.removeFirst(); // left2right
                    level.add(cur.val);
                    if(cur.left!=null){
                        q.addLast(cur.left);
                    }
                    if(cur.right!=null){
                        q.addLast(cur.right);
                    }
                }

            }else {
                for (int i = 0; i < size; i++) {
                    TreeNode cur = q.removeLast(); //
                    level.add(cur.val);
                    if(cur.right!=null){
                        q.addFirst(cur.right);
                    }
                    if(cur.left!=null){
                        q.addFirst(cur.left);
                    }
                }
            }

            res.add(new ArrayList<>(level));
            left2right=!left2right;

        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(-10);
        t.left = new TreeNode(9);
        t.right = new TreeNode(20);
        t.right.left = new TreeNode(15);
        t.right.right = new TreeNode(7);

        System.out.println(new T103_zigzagLevelOrder().zigzagLevelOrder(t));
    }
}
