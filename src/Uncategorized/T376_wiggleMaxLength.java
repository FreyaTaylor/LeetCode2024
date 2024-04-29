package src.Uncategorized;

public class T376_wiggleMaxLength {
    /**
     * https://leetcode.cn/problems/wiggle-subsequence/
     *
     * 找升降次数，+1，因为
     * 1 17 5 10 16
     * diff是 16 -12 5 6
     * 如果删除10这个数字，变成16-5=16-10+10-5=5+6=11，区间的正数会合并，负数合并，0无视（任意合并）
     */

    public int wiggleMaxLength(int[] nums) {

        if(nums.length==1){return 1;}

        int n = nums.length;
        int[] diff = new int[n-1];

        for (int i = 0; i < nums.length-1; i++) {
            diff[i]=nums[i+1]-nums[i];
        }


        int i=0;
        int last=0;
        int res=0;
        while(i<diff.length && diff[i]==0){
            i++;
        }
        if(i<diff.length){
            System.out.println(i);
            last = diff[i];
            res++;
        }



        while(i<diff.length) {

            while (i < diff.length && diff[i] * last >= 0) {
                i++;
            }

            if(i<diff.length){
                res++;
                last = diff[i++];
            }


            System.out.println(i);

        }

        return res+1;
    }



    public static void main(String[] args) {
//        System.out.println(new _T376_wiggleMaxLength().wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8}));
//        System.out.println(new _T376_wiggleMaxLength().wiggleMaxLength(new int[]{1,2,3,4,5,6,7,8,9}));
//        System.out.println(new _T376_wiggleMaxLength().wiggleMaxLength(new int[]{1,1}));
        System.out.println(new T376_wiggleMaxLength().wiggleMaxLength(new int[]{3,3,3,2,5}));
    }
}
