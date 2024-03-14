package src.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class T236_lowestCommonAncestor {
    /**
     * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
     */

    List<TreeNode> pathp;
    List<TreeNode> pathq;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q,new ArrayList<>());

        int i=0;
        while (i<pathq.size() && i<pathp.size() && pathq.get(i)==pathp.get(i)){i++;}
        return pathq.get(i-1);
    }

    public void dfs(TreeNode root,TreeNode p, TreeNode q,List<TreeNode> path){

        path.add(root);

        if(root==p){
            pathp = new ArrayList<>(path);
            if(pathq!=null){
                return;
            }
        }
        if(root==q){
            pathq = new ArrayList<>(path);
            if(pathp!=null){
                return;
            }
        }


        if(root.left!=null){
            dfs(root.left,p,q,path);
        }
        if(root.right!=null){
            dfs(root.right,p,q,path);
        }
        path.remove(path.size()-1);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        root.left.left = new TreeNode(4);
//        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(2);
//        root.right.left.left = new TreeNode(4);

        TreeNode res = new T236_lowestCommonAncestor().lowestCommonAncestor(root,root,root.left);

        System.out.println(res.val);

    }

}
