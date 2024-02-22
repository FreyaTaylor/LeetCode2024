package src.BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T652_findDuplicateSubtrees {
    /**
     * https://leetcode.cn/problems/find-duplicate-subtrees/description/
     *
     * 唯一的toString法
     */

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        Map<String,List<TreeNode>> map = new HashMap<>();
        toString(map,root);
        List<TreeNode> res = new ArrayList<>();
        for(String key:map.keySet()){
            if(map.get(key).size()>=2){
                res.add(map.get(key).get(0));
            }
        };
        return res;
    }


    public String toString(Map<String,List<TreeNode>> map,TreeNode root){
        if(root==null){
            return "";
        }

        String l = toString(map,root.left);
        String r = toString(map,root.right);
        String res=root.val+"("+l+")"+"("+r+")";

        if(!map.containsKey(res)){
            map.put(res,new ArrayList<>());
        }
        map.get(res).add(root);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(4);

        List<TreeNode> res = new T652_findDuplicateSubtrees().findDuplicateSubtrees(root);
        System.out.println();


    }


}
