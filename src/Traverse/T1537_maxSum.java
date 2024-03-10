package src.Traverse;

public class T1537_maxSum {


//    public int maxSum(int[] nums1, int[] nums2) {
//        int helper = (int) Math.pow(10,9)+7;
//
//        int res = 0;
//        int i=0,j=0;
//        int temp1=0,temp2=0;
//        while (i<nums1.length && j<nums2.length){
//            while (j<nums2.length && nums2[j]<nums1[i] ){
//                temp2=(temp2+(nums2[j++])%helper)%helper;
//            }
//            if(j<nums2.length && nums2[j]==nums1[i]){
//                res=(res+(Math.max(temp1,temp2))%helper+nums1[i]%helper)%helper;
//                i++;
//                j++;
//                temp1=0;
//                temp2=0;
//            }else {
//                if(i<nums1.length){
//                    temp1=(temp1+nums1[i++]%helper)%helper;
//                }
//
//            }
//
//            System.out.println(i+" "+j);
//        }
//
//        while (i<nums1.length){
//            temp1=(temp1+nums1[i++]%helper)%helper;
//        }
//        while (j<nums2.length){
//            temp2=(temp2+(nums2[j++])%helper)%helper;
//        }
//        return (res+(Math.max(temp1,temp2))%helper)%helper;
//
//    }


    /**
     * https://leetcode.cn/problems/get-the-maximum-score/
     * 我的思路是对的，但是实现起来代码不好写，应该稍微改为，代码好实现的思路（分nums2[j]<nums1[i]的三种关系来比，不写while，逻辑清晰很多）
     * 踩雷： mod(Max(a+b,a+c)) !=mod(a+Max(mod(b),mod(c)) )！！！必须用实际值比，再mod--->long
     *
     */
    public int maxSum(int[] nums1, int[] nums2) {
        long helper = (long) Math.pow(10,9)+7;
        long res = 0;
        int i=0,j=0;
        long temp1=0,temp2=0;
        while (i<nums1.length && j<nums2.length){
            if  (nums2[j]<nums1[i] ){
                temp2+=nums2[j++];
            }else if(nums2[j]==nums1[i]){
                res= res+ Math.max(temp1,temp2) +nums1[i] ;
                i++;
                j++;
                temp1=0;
                temp2=0;
            }else {
                temp1+=nums1[i++];
            }

        }

        while (i<nums1.length){
            temp1+=nums1[i++];
        }
        while (j<nums2.length){
            temp2+=nums2[j++];
        }

//        while (i<nums1.length){
//            temp1=(temp1+nums1[i++]%helper)%helper;
//        }
//        while (j<nums2.length){
//            temp2=(temp2+(nums2[j++])%helper)%helper;
//        }
        // mod(Max(a+b,a+c)) !=mod(a+Max(mod(b),mod(c)) )
        return (int)((res+  Math.max(temp1,temp2) )%helper);

    }



    public static void main(String[] args) {
        int[] nums1 = new int[]{2,4,5,8,10,12};
        int[] nums2 = new int[]{4,6,8,12};

        nums1 = new int[]{1,3,5,7,9,100};
        nums2 = new int[]{1,5,100};



        System.out.println(new T1537_maxSum().maxSum(nums1,nums2));
    }

}
