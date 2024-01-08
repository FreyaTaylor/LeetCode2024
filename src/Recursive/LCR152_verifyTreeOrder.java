package src.Recursive;

public class LCR152_verifyTreeOrder {

    /**
     * https://leetcode.cn/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/description/
     * 验证二叉搜索树的后序遍历序列
     * 把字符串看作是：左子树的串+右子树的串+根节点
     * 成功的条件：可分为三部分+左右子树是后续遍历的结果+右子树是后续遍历的结果
     * @param postorder
     * @return
     */
    public boolean verifyTreeOrder(int[] postorder) {
        return verifyHelper(postorder,0,postorder.length-1); //[l,r]
    }
    public boolean verifyHelper(int[] postorder,int l,int r) {
        if(l>=r){return true;}
        int rootVal = postorder[r];
        int i=l;
        while (postorder[i]<rootVal)i++;
        int mark=i; //第一个不小于根节点的
        while (postorder[i]>rootVal)i++;  //分好了左右子串

        return i==r&&verifyHelper(postorder,l,mark-1) && verifyHelper(postorder,mark,r-1);
        //三个&&起来的条件，分别对应：可分为三部分（未分为左右子串的数是根节点）+左右子树是后续遍历的结果+右子树是后续遍历的结果
    }

    public static void main(String[] args) {
        System.out.println(new LCR152_verifyTreeOrder().verifyTreeOrder(new int[]{4,9,6,9,8}));
        System.out.println(new LCR152_verifyTreeOrder().verifyTreeOrder(new int[]{4,6,5,8}));
    }

}
