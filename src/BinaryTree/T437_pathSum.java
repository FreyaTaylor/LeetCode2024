package src.BinaryTree;

import java.util.*;

public class T437_pathSum {
    /**
     * https://leetcode.cn/problems/path-sum-iii/
     */
    private int count=0;
    public int pathSum(TreeNode root, int targetSum) {
        Deque<TreeNode> path = new ArrayDeque<>();
        Map<Long,Integer> map = new HashMap<>();
        map.put(0L,1);
        dfs(map,0L,root,targetSum);
        return count;
    }

    public void dfs(Map<Long,Integer> map,Long cursum,TreeNode cur,int targetSum){
        if(cur==null){
            return;
        }
        Long nextcursum=cursum+cur.val;
        Long need=nextcursum-targetSum;
        if(map.containsKey(need)){
            count+=map.get(need);
        }

        map.put(nextcursum,map.getOrDefault(nextcursum,0)+1);
        dfs(map,nextcursum,cur.left,targetSum);
        dfs(map,nextcursum,cur.right,targetSum);
        map.put(nextcursum,map.getOrDefault(nextcursum,0)-1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right=new TreeNode(6);
        root.right.right=new TreeNode(7);

        System.out.println(new T437_pathSum().pathSum(root,5));
    }
}
