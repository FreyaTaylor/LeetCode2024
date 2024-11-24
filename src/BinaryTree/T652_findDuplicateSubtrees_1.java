package src.BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T652_findDuplicateSubtrees_1 {
    /**
     * https://leetcode.cn/problems/find-duplicate-subtrees/description/
     *
     * 唯一的toString法
     */

    Map<String,List<TreeNode>> map = new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        toString(new StringBuilder(),root);
        List<TreeNode> res = new ArrayList<>();
        for (String s : map.keySet()) {
            if(map.get(s).size()>1){
                res.add(map.get(s).get(0));
            }
        }


        return res;
    }


    public StringBuilder toString(StringBuilder sb,TreeNode root){
        if(root==null){
            return new StringBuilder("None,");
        }

        StringBuilder l=toString(sb,root.left);
        StringBuilder r=toString(sb,root.right);

        StringBuilder res=new StringBuilder();
        res.append(root.val);
        res.append(",");

        res.append(l);
        res.append(r);

        String key=res.toString();
        System.out.println(key);
        if(!map.containsKey(key)){
            map.put(key,new ArrayList<>() );
        }
        map.get(key).add(root);

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.right = new TreeNode(0);
        root.right.right = new TreeNode(0);
        root.right.right.left = new TreeNode(0);

        List<TreeNode> res = new T652_findDuplicateSubtrees_1().findDuplicateSubtrees(root);
        System.out.println();


    }


}
