package src.BinaryTree;

import java.util.HashSet;
import java.util.Set;

public class T1261_FindElements {

    TreeNode root;
    Set<Integer> vals;

    /**
     * https://leetcode.cn/problems/find-elements-in-a-contaminated-binary-tree
     * @param root
     */
    public T1261_FindElements(TreeNode root) {
        this.root=root;
        this.vals = new HashSet<>();
        if(root!=null){
            root.val=0;
            build(root);
            vals.add(0);
        }


    }

    public void build(TreeNode root){
        if(root.left!=null){
            root.left.val=2*root.val+1;
            vals.add(2*root.val+1);
            build(root.left);
        }
        if(root.right!=null){
            root.right.val=2*root.val+2;
            vals.add(2*root.val+2);
            build(root.right);
        }

    }

    public boolean find(int target) {
        return vals.contains(target);
    }

}
