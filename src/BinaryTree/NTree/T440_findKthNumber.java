package src.BinaryTree.NTree;

public class T440_findKthNumber {

    /**
     * https://leetcode.cn/problems/k-th-smallest-in-lexicographical-order/
     *
     * 想想成一个字典树的遍历！
     */

    public int findKthNumber(int n, int k) {
        int cur =1;
        while (k>1){
            System.out.println(cur+" "+k);
            int smallerCount = getCount(n,cur);
            if(smallerCount<k){
                cur++;
                k-=smallerCount;
            }else {
                cur*=10;
                k--; //
            }
        }

        return cur;
    }

    public int getCount(int n,int cur){
        long start = cur;
        long end = cur;
        int res = 0;
        while (start<=n){
            res += Math.min(n,end)-start+1;
            start *=10;
            end = end*10+9;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new T440_findKthNumber().findKthNumber(681692778,351251360));
//        System.out.println(new T440_findKthNumber().findKthNumber(13,2));
    }
}
