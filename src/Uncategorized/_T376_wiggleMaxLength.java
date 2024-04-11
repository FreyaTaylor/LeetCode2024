package src.Uncategorized;

public class _T376_wiggleMaxLength {
    /**
     * https://leetcode.cn/problems/wiggle-subsequence/
     */

    public int wiggleMaxLength(int[] nums) {

        if(nums.length==1){return 1;}

        int n = nums.length;
        int[] diff = new int[n-1];

        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i+1]>nums[i]){
                diff[i]=1;
            }else if(nums[i+1]<nums[i]){
                diff[i]=-1;
            }else {
                diff[i]=0;
            }

        }

        int i=0;
        int res=0;
        int index=0;
        int num=diff[0];

        while (i<diff.length){
            while (i<diff.length && diff[i]==num){
                i++;
            }
            if(num!=0){
                res+=i-index-1;
            }else {
                res+=i-index;
            }

            if(i<diff.length){
                index=i;
                num=diff[index];
            }
//            System.out.println(i);
        }

        return nums.length-res;

    }

    public static void main(String[] args) {
//        System.out.println(new T376_wiggleMaxLength().wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8}));
//        System.out.println(new T376_wiggleMaxLength().wiggleMaxLength(new int[]{1,2,3,4,5,6,7,8,9}));
        System.out.println(new _T376_wiggleMaxLength().wiggleMaxLength(new int[]{1,1}));
    }
}
