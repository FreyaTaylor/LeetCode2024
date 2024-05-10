package src.BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class T655_printTree {

    /**
     * https://leetcode.cn/problems/print-binary-tree/
     */
    public List<List<String>> printTree(TreeNode root) {

        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int height=0;
        while (!q.isEmpty()){
            height++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.removeLast();
                if(cur.left!=null){
                    q.addFirst(cur.left);
                }
                if(cur.right!=null){
                    q.addFirst(cur.right);
                }
            }
        }
        height--;
        int m=height+1;
        int n=(int)Math.pow(2,height+1)-1;
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            temp.add("");
        }

        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            res.add(new ArrayList<>(temp));
        }



        dfs(res,root,height,0,(n-1)/2);
        return res;

    }

    public void dfs(List<List<String>> res,TreeNode node,int height,int r,int c){

        res.get(r).set(c, String.valueOf(node.val));

        if(node.left!=null){
            dfs(res,node.left,height,r+1,c-(int)Math.pow(2,height-r-1));
        }

        if(node.right!=null){
            dfs(res,node.right,height,r+1,c+(int)Math.pow(2,height-r-1));
        }

    }


    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.left.right=new TreeNode(4);
        root.right=new TreeNode(3);

        List<List<String>> res=new T655_printTree().printTree(root);

        System.out.println(res);

    }

}
