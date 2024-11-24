package src.Recursive;

public class LCR152_verifyTreeOrder_1 {

    /**
     * https://leetcode.cn/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/description/
     */
    public boolean verifyTreeOrder(int[] postorder) {
        return verifyHelper(postorder,0,postorder.length-1); //[l,r]
    }
    public boolean verifyHelper(int[] postorder,int l,int r) {

        if(l>=r){return true;}

        int i=l;
        int val=postorder[r];
        while (i<r && postorder[i]<val){i++;}
        int a=i-1;
        while (i<r && postorder[i]>val){i++;}
        int b=i-1;

        if(b==r-1 && verifyHelper(postorder,l,a) && verifyHelper(postorder,a+1,r-1)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new LCR152_verifyTreeOrder_1().verifyTreeOrder(new int[]{4, 6, 7, 5}));
//        System.out.println(new LCR152_verifyTreeOrder_1().verifyTreeOrder(new int[]{4,9,6,9,8}));
//        System.out.println(new LCR152_verifyTreeOrder_1().verifyTreeOrder(new int[]{4,6,5,8}));
    }

}
