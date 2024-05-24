package src.BinarySearch;

public class hard_T4_findMedianSortedArrays {

    /**
     * https://leetcode.cn/problems/median-of-two-sorted-arrays/
     */

//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//
//        if(nums1.length>nums2.length){
//            return findMedianSortedArrays(nums2,nums1);
//        }
//
//        int m=nums1.length;
//        int n=nums2.length;
//
//        int lmax=0,rmin=0;
//        int l=0,r=m;
//        while (l<=r){
//            int i=(l+r)/2;
//            int j=(m+n+1)/2-i;
//
//            int num_i_1 =(i==0?Integer.MIN_VALUE:nums1[i-1]);
//            int num_i =(i==m?Integer.MAX_VALUE:nums1[i]);
//            int num_j_1 =(j==0?Integer.MIN_VALUE:nums2[j-1]);
//            int num_j =(j==n?Integer.MAX_VALUE:nums2[j]);
////            System.out.println();
//
//            if(num_i_1<=num_j){
//                lmax=Math.max(num_i_1,num_j_1);
//                rmin=Math.min(num_i,num_j);
//                l=i+1;
//            }else {
//                r=i-1;
//            }
////            System.out.println();
//        }
//
//        return (m+n)%2==0? (lmax + rmin) /2.0:lmax;
//    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int k=(n1+n2)/2;

        if((n1+n2)%2==1){
            return findk(nums1,nums2,k+1);
        }else {
            return (findk(nums1,nums2,k)+findk(nums1,nums2,k+1))/2.0;
        }
    }

    public int findk(int[] nums1, int[] nums2, int k){
//        System.out.println(k);
        int i=0;
        int j=0;
        while (true){

            if(i==nums1.length){
                return nums2[j+k-1];
            }

            if(j==nums2.length){
                return nums1[i+k-1];
            }

            if(k==1){
                return Math.min(nums1[i],nums2[j]);
            }

            int preCount = k/2;
            int i_=Math.min(nums1.length,i+preCount)-1;
            int j_=Math.min(nums2.length,j+preCount)-1;

            if(nums1[i_]<=nums2[j_]){
                k-=(i_-i+1);
                i=i_+1;
            }else {
                k-=(j_-j+1);
                j=j_+1;
            }


        }

    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3,5};
        int[] nums2 = new int[]{2,4,6};

        System.out.println(new hard_T4_findMedianSortedArrays().findMedianSortedArrays(nums1,nums2));
    }
}
