package src.ByMonth.M2410;

public class T3171_minimumDifference {

    /**
     * T3171_minimumDifference
     * 滑动窗口必须要右移，否则死循环
     *
     */

    public int minimumDifference(int[] nums, int k) {
        int l=0,r=0;//[l,r)
        int [] count = new int[32];
        int curNum=0;
        int res = Integer.MAX_VALUE;
        while (r<nums.length) {

            if(curNum==k){
                return 0;
            }

            // 右移至>=
            int radd = 0;
            while (r < nums.length && curNum < k) {
                String s = Integer.toBinaryString(nums[r++]);
                int index = 0;
                radd = 0;
                for (int i = s.length() - 1; i > -1; i--) {
                    if (s.charAt(i) == '1') {
                        if (count[index] == 0) {
                            radd += 1 << index;
                        }
                        count[index]++;
                    }
                    index++;
                }
                curNum += radd;
            }


            // [l,r) >=k,因为是新加的r，因此必然有一个元素，
            res = Math.min(res, Math.abs(curNum - k));
            // [l,r-1) <k,需要检验是否包含一个元素
            if(l+1<r){
                res = Math.min(res, Math.abs(curNum - k-radd));
            }


            int lsub = 0;
            while (curNum > k && l<r) {
                String s = Integer.toBinaryString(nums[l++]); //1101
                int index = 0;
                lsub = 0;
                for (int i = s.length() - 1; i > -1; i--) {
                    if (s.charAt(i) == '1') {
                        if (count[index] == 1) {
                            lsub += 1 << index;
                        }
                        count[index]--;
                    }
                    index++;
                }
                curNum -= lsub;

            }

            // [l-1,r) <=k,必然包含元素l
            res = Math.min(res, Math.abs(curNum +lsub- k));
            // [l,r) <=k,需要检验是否包含一个元素
            if(l<r){
                res = Math.min(res, Math.abs(curNum - k));
            }


        }

        return res;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,3,1,3};
        int k = 2;

//        nums = new int[]{1,2,4,5};
//        k = 3;
//
//        nums = new int[]{1};
//        k = 10;
//
        nums = new int[]{6};
        k = 2;

//        nums = new int[]{1,10};
//        k = 6;

        System.out.println(new T3171_minimumDifference().minimumDifference(nums,k));
    }











}
