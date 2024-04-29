package src.BinarySearch;

public class _T4_findMedianSortedArrays {

    /**
     * https://leetcode.cn/problems/median-of-two-sorted-arrays/
     */

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int k=(n1+n2)/2;

//        int l1=0,r1=n1-1,l2=0,r2=n2-1;
        int numOne=Integer.MIN_VALUE;
        int numTwo=Integer.MIN_VALUE;

        int i1=0;
        int i2=0;
        while (i1+k/2<n1 && i2+k/2<n2){
            if(nums1[i1+k/2]<nums2[i2+k/2]){
                k-=(k/2)*2;
                i1+=(k/2)*2;
            }else {
                k-=(k/2)*2;
                i2+=(k/2)*2;
            }
        }




        return 0;

    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3,5};
        int[] nums2 = new int[]{2,4,6};

        System.out.println(new _T4_findMedianSortedArrays().findMedianSortedArrays(nums1,nums2));
    }
}
