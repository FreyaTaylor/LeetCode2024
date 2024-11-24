package src.Traverse;

public class T1537_maxSum_1 {





    /**
     * https://leetcode.cn/problems/get-the-maximum-score/
     * 我的思路是对的，但是实现起来代码不好写，应该稍微改为，代码好实现的思路（分nums2[j]<nums1[i]的三种关系来比，不写while，逻辑清晰很多）
     * 踩雷： mod(Max(a+b,a+c)) !=mod(a+Max(mod(b),mod(c)) )！！！必须用实际值比，再mod--->long
     *
     */
    public int maxSum(int[] nums1, int[] nums2) {
        long helper = (long) Math.pow(10,9)+7;

        int i=0,j=0;
        long sum1=0,sum2=0;
        while (i<nums1.length && j<nums2.length){
            if(nums1[i]==nums2[j]){
                sum1+=nums1[i++];
                sum2+=nums2[j++];
                sum1=Math.max(sum1,sum2);
                sum2=Math.max(sum1,sum2);
            }else if(nums1[i]<nums2[j]){
                sum1+=nums1[i++];
            }else{
                sum2+=nums2[j++];
            }
        }

        long res=Math.max(sum1,sum2);

        while (i<nums1.length){
            sum1+=nums1[i++];
            res=Math.max(res,sum1);
        }
        while (j<nums2.length){
            sum2+=nums2[j++];
            res=Math.max(res,sum2);
        }

        return (int)(res%helper);
    }



    public static void main(String[] args) {
        int[] nums1 = new int[]{2,4,5,8,10,12};
        int[] nums2 = new int[]{4,6,8,12};

        nums1 = new int[]{1,3,5,7,9,100};
        nums2 = new int[]{1,5,100};



        System.out.println(new T1537_maxSum_1().maxSum(nums1,nums2));
    }

}
