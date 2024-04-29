package src.Uncategorized;

public class T1052_maxSatisfied {

    /**
     * https://leetcode.cn/problems/grumpy-bookstore-owner/
     */

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int[] lto = new int[n+1];// [0,i)
        int[] rto = new int[n+1];// (i,n-1]

        for (int i = 1; i < n+1; i++) {

            if(grumpy[i-1]==0){
                lto[i]=lto[i-1]+customers[i-1];
            }else {
                lto[i]=lto[i-1];
            }

        }

        for (int i = n-1; i > 0; i--) {
            if(grumpy[i]==0) {
                rto[i] = rto[i + 1] + customers[i];
            }else {
                rto[i] = rto[i + 1];
            }
        }

        int[] sum = new int[n+1]; //[0,i)
        for (int i = 1; i < n+1; i++) {
            sum[i] = sum[i-1]+customers[i-1];
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i<n-minutes+1 ; i++) {
//            System.out.println(lto[i+1]);
//            System.out.println(sum[i+minutes]-sum[i]);
//            System.out.println(rto[i+minutes]);
            int temp = lto[i]+sum[i+minutes]-sum[i]+rto[i+minutes];
//            System.out.println(temp);

            res=Math.max(res,temp);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] customers = new int[]{1,0,1,2,1,1,7,5};
        int[] grumpy = new int[]{0,1,0,1,0,1,0,1};
        int minutes = 3;

        customers = new int[]{5,8};
        grumpy = new int[]{0,1};
        minutes = 1;

        customers = new int[]{10,1,7};
        grumpy = new int[]{0,0,0};
        minutes = 2;



        System.out.println(new T1052_maxSatisfied().maxSatisfied(customers,grumpy,minutes));
    }



}
