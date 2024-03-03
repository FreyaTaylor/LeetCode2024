package src.BinaryTree;

import java.util.Map;
import java.util.TreeMap;

public class T1902_maxDepthBST {

    /**
     * https://leetcode.cn/problems/depth-of-bst-given-insertion-order/
     * 先构造，再计算深度，遇到最坏情况会超时!!!
     *
     * 参考：https://leetcode.cn/problems/depth-of-bst-given-insertion-order/solutions/834618/zai-bstzhong-er-fen-cha-zhao-dang-qian-y-1528/
     * 思路：模拟而非真实构造树，平衡树实现log时间复杂度的，寻找当前节点的潜在插入位置（仅更新当前节点的Len）
     */
    public int maxDepthBST(int[] order) {
        TreeMap<Integer,Integer> btree = new TreeMap<>();
        btree.put(-1,0);
        btree.put(Integer.MAX_VALUE,0);
        int res = Integer.MIN_VALUE;
        for (int i = 0; i <order.length ; i++) {
            int cur = order[i];
            Map.Entry<Integer,Integer> smaller = btree.lowerEntry(cur);
            Map.Entry<Integer,Integer> greater = btree.higherEntry(cur);
            int curLen=Math.max(btree.get(smaller.getKey()),btree.get(greater.getKey()))+1;
            btree.put(cur,curLen);
            res = Math.max(res,curLen);
        }
        return res;
    }



//    public int maxDepthBST(int[] order) {
//        TreeNode t = new TreeNode(order[0]);
//        for (int i = 1; i <order.length ; i++) {
//            buildTree(t,order,i);
//        }
//        return getDepth(t);
//    }
//
//    public  void buildTree(TreeNode t,int[] order,int i){
//        int cur=order[i];
//        if(cur<t.val){
//            if(t.left!=null){
//                buildTree(t.left,order,i);
//            }else {
//                t.left=new TreeNode(cur);
//            }
//        }else {
//            if(t.right!=null){
//                buildTree(t.right,order,i);
//            }else {
//                t.right=new TreeNode(cur);
//            }
//        }
//    }
//
//    public int getDepth(TreeNode t){
//        if(t==null){
//            return 0;
//        }
//        return 1+Math.max(getDepth(t.left),getDepth(t.right));
//    }


    public static void main(String[] args) {
        int[] order = new int[]{2,1,4,3};
        System.out.println(new T1902_maxDepthBST().maxDepthBST(order));
    }
}
