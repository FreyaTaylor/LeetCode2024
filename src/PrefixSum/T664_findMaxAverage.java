package src.PrefixSum;

public class T664_findMaxAverage {

    /**
     * https://leetcode.cn/problems/maximum-average-subarray-ii/
     *
     */
    /**
     * 数组是否存在一个长度>=k的子数组，使其均值>=mid
     * 如何一次处理长度>=k的子数组的【平均值】 ==> nums[i]-mid 长度>=k 且总和大于0 的子数组
     * -mid的操作，避免了求平均值！！！
     * 长度>=k：前缀和，使得末尾位i（前缀和为sumb）确定，起始位为(0，i-k), 保证长度>=k，
     * 要使得子数组和最大，在末尾位i确定的情况下，需要起始位的前缀和（前缀和为suma）最小：minPre=Math.min(minPre,suma);
     * 则此时最大和为：sumb-minPre
     *
     * o(n)
     */

    // o(n2)
//    public double findMaxAverage(int[] nums, int k) {
//        int n=nums.length;
//        int[] preSum = new int[n+1]; //[0,i-1];
//
//        for (int i = 1; i < n+1; i++) {
//            preSum[i]=preSum[i-1]+nums[i-1];
//        }
//
//        double res = Double.MIN_EXPONENT;
//        for (; k < n+1; k++) {
//            int sum=preSum[k]-preSum[0]; //[0,k-1] i=k-1
//            for (int i = k; i <n+1 ; i++) { //i-1<n
//                sum=+Math.max(sum,preSum[i]-preSum[i-k]); // [i-k-1,i-1]
//            }
//            res=Math.max(res,(double) sum/k);
//            System.out.println(sum);
//        }
//
//        return res;
//    }

    public double findMaxAverage(int[] nums, int k) {
        int n=nums.length;
        double l=Integer.MAX_VALUE; // 平均值的最小值：数组最小值
        double r=Integer.MIN_VALUE; // 平均值的最大值：数组最大值
        for (int i = 0; i <n ; i++) {
            l=Math.min(l,nums[i]);
            r=Math.max(r,nums[i]);
        }
        while (r-l>0.00001){
//            System.out.println(l+"  "+r);
            double mid = (r+l)*0.5; //double的取中
            if(has(nums,mid,k)){
                l=mid;
            }else {
                r=mid;
            }
        }

        return r;
    }

    /**
     * 数组是否存在一个长度>=k的子数组，使其均值>=mid
     * 如何一次处理长度>=k的子数组的【平均值】 ==> nums[i]-mid 长度>=k 且总和大于0 的子数组
     * -mid的操作，避免了求平均值！！！
     * 长度>=k：前缀和，使得末尾位i（前缀和为sumb）确定，起始位为(0，i-k), 保证长度>=k，
     * 要使得子数组和最大，在末尾位i确定的情况下，需要起始位的前缀和（前缀和为suma）最小：minPre=Math.min(minPre,suma);
     * 则此时最大和为：sumb-minPre
     *
     * o(n)
     */
    public boolean has(int[] nums,double mid,int k){
        double sumb=0;
        for (int i = 0; i < k; i++) {
            sumb+=nums[i]-mid;
        }

        if(sumb>0){
            return true;
        }

        double suma=0;
        double minPre=0;
        for (int i = k; i <nums.length ; i++) {
            sumb+=nums[i]-mid;
            suma+=nums[i-k]-mid;
            minPre=Math.min(minPre,suma);
            if(sumb>minPre){
                return true;
            }
        }

        return false;
    }



    public static void main(String[] args) {
        int[] nums = new int[]{1,12,-5,-6,50,3};
        int k = 4;

//        nums = new int[]{-1};
//        k = 1;
//
//        nums = new int[]{0,4,0,3,2};
//        k = 1;
//
//        nums = new int[]{0,1,1,3,3};
//        k = 4;

        System.out.println(new T664_findMaxAverage().findMaxAverage(nums,k));
    }
}
