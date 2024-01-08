package src.BinaryTree;

public class T124_maxPathSum {
    /**
     * https://leetcode.cn/problems/binary-tree-maximum-path-sum/
     */

    public int res=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        singleLength(root);
        return res;
    }
    public int singleLength(TreeNode root){
        if (root==null){
            return 0;
        }
        int lmax=singleLength(root.left);
        int rmax = singleLength(root.right);

        int curRes=Math.max(0,lmax)+root.val+Math.max(0,rmax); //包含root结点
        res=Math.max(res,curRes);
        //只需要比较这一处就好，因为每个节点都会在某次迭代中被看作是root
        return Math.max(0,Math.max(lmax,rmax))+root.val; // 某层级的叶节点到root（包含root节点）的最大长度
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(-10);
//        t.left = new TreeNode(9);
//        t.right = new TreeNode(20);
//        t.right.left = new TreeNode(15);
//        t.right.right = new TreeNode(7);

        System.out.println(new T124_maxPathSum().maxPathSum(t));

    }
}
