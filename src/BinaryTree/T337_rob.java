package src.BinaryTree;

import src.BinaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class T337_rob {
    /**
     * https://leetcode.cn/problems/house-robber-iii/
     */
    public int rob(TreeNode root) {

        Map<TreeNode,Integer> mapyes = new HashMap<>();
        Map<TreeNode,Integer> mapno=new HashMap<>();
        int res = Math.max(robno(mapyes,mapno,root),robyes(mapyes,mapno,root));
        return res;
    }

    public int robyes(Map<TreeNode,Integer> mapyes, Map<TreeNode,Integer> mapno, TreeNode root){

        int res=root.val;

        int l=0;
        if(root.left!=null){
            if(!mapno.containsKey(root.left)){
                robno(mapyes,mapno,root.left);
            }
            l=mapno.get(root.left);
        }

        int r=0;
        if(root.right!=null){
            if(!mapno.containsKey(root.right)){
                robno(mapyes,mapno,root.right);
            }
            r=mapno.get(root.right);
        }

        res+=l+r;
        mapyes.put(root,res);
        return res;
    }

    public int robno(Map<TreeNode,Integer> mapyes, Map<TreeNode,Integer> mapno, TreeNode root){

        int res=0;

        int l=0;
        if(root.left!=null){
            if(!mapno.containsKey(root.left)){
                robno(mapyes,mapno,root.left);
            }
            if(!mapyes.containsKey(root.left)){
                robyes(mapyes,mapno,root.left);
            }
            l=Math.max(mapno.get(root.left),mapyes.get(root.left));
        }

        int r=0;
        if(root.right!=null){
            if(!mapno.containsKey(root.right)){
                robno(mapyes,mapno,root.right);
            }
            if(!mapyes.containsKey(root.right)){
                robyes(mapyes,mapno,root.right);
            }
            r=Math.max(mapno.get(root.right),mapyes.get(root.right));

        }

        res+=l+r;
        mapno.put(root,res);
        return res;
    }


    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(4);
        root.left.left=new TreeNode(1);
        root.left.right=new TreeNode(3);
        root.right=new TreeNode(5);
        root.right.left=new TreeNode(1);


        System.out.println(new T337_rob().rob(root));
    }





}
