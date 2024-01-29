package src.Uncategorized.Hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class T321_maxNumber {
    /**
     * https://leetcode.cn/problems/create-maximum-number/
     * 滑动窗口最大值，窗口大小为：1+可抛弃的数字
     * 若当前滑动窗口最大值相等，则dfs
     * 超时！！！
     *
     * 官方解题：先找所有最长子序列组合，在合并所有组合
    */

//    int[] max;
//    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
//        int [] res = new int[k];
//        max=new int[k];
//        helper(nums1,nums2,res,0,0,0,nums1.length+nums2.length-k);
//        return max;
//    }
//
//    public void helper(int[] nums1, int[] nums2,int [] res,int cur,int i,int j,int window) {
//
//        if(cur==res.length){
////            System.out.println(Arrays.toString(res));
////            System.out.println(!notSmaller(max,res));
//            if(!notSmaller(max,res)){
//                max=Arrays.copyOf(res,res.length);
//            }
//            return;
//        }
//
//            int max1 = slideMax(nums1, i, window);
//            int max2 = slideMax(nums2, j, window);
//
//            if(max1>max2){
//                int k=i;
//                while (k<nums1.length && nums1[k]!=max1){k++;}
//                res[cur]=nums1[k];
//                helper(nums1,nums2,res,cur+1,k+1,j,window-(k-i));
//            }else if(max1<max2){
//                int k=j;
//                while (k<nums2.length && nums2[k]!=max2){k++;}
//                res[cur]=nums2[k];
//                helper(nums1,nums2,res,cur+1,i,k+1,window-(k-j));
//            }else {
//                int k=i;
//                while (k<nums1.length && nums1[k]!=max1){k++;}
//                res[cur]=nums1[k];
//                helper(nums1,nums2,res,cur+1,k+1,j,window-(k-i));
//
//                k=j;
//                while (k<nums2.length && nums2[k]!=max2){k++;}
//                res[cur]=nums2[k];
//                helper(nums1,nums2,res,cur+1,i,k+1,window-(k-j));
//            }
//
//
//    }
//
//
//    public int slideMax(int[] num,int l,int window){
//        int res = Integer.MIN_VALUE;
//        for (int i = l; i < Math.min(num.length,l+window+1); i++) {
//            res = Math.max(res,num[i]);
//        }
//        return res;
//    }
//
//


    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        int minlen1= Math.max(0,k-nums2.length);
        int maxlen1= Math.min(nums1.length,k);
        for (int i = minlen1; i <maxlen1+1 ; i++) {
            int len1=i;
            int len2=k-i;
            int[] sub1=subArr(nums1,len1);
            int[] sub2=subArr(nums2,len2);
            int[] temp = merge(sub1,sub2);
//            System.out.println(Arrays.toString(sub1));
//            System.out.println(Arrays.toString(sub2));
//            System.out.println(Arrays.toString(temp));
            if(!notSmaller(res,temp)){
                res=Arrays.copyOf(temp,k);
            }
        }
        return res;
    }

    public int[] subArr(int[] nums,int len){
        Deque<Integer> q = new ArrayDeque<>();
        int canWaste = nums.length-len; //通过canWaste数量>=0,保证q一定可以>=len
        for (int i = 0; i < nums.length; i++) {
            while (!q.isEmpty() && nums[q.getLast()]<nums[i]&& canWaste>0){
                q.removeLast();
                canWaste--;
            }
            q.addLast(i);
        }
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i]=nums[q.removeFirst()];
        }
        return res;
    }

    public int[] merge(int[] nums1, int[] nums2){
        int[] res = new int[nums1.length+nums2.length];
        int i=0,j=0,cur=0;
        while (i<nums1.length && j<nums2.length){
            int ii=i,jj=j;
            while (ii<nums1.length && jj<nums2.length && nums1[ii]==nums2[jj]){
                ii++;
                jj++;
            }
            if(ii==nums1.length){
                res[cur++]=nums2[j++];
            }else if(jj==nums2.length){
                res[cur++]=nums1[i++];
            }else{ // nums1[ii]!=nums2[jj]
            if(nums1[ii]>nums2[jj]){
                res[cur++]=nums1[i++];
            }else {
                res[cur++]=nums2[j++];
            }
        }

        }
        while (i<nums1.length){
            res[cur++]=nums1[i++];
        }
        while (j<nums2.length){
            res[cur++]=nums2[j++];
        }

        return res;
    }

    public boolean notSmaller(int[] nums1, int[] nums2){
        for (int i = 0; i < nums1.length; i++) {
            if(nums1[i]>nums2[i]){return true;}
            if(nums1[i]<nums2[i]){return false;}
        }
        return true;
    }
    public static void main(String[] args) {
//        int[] nums1 = new int[]{3, 4, 6, 5};
//        int[] nums2 = new int[]{9, 1, 2, 5, 8, 3};
//        int k=5;

//        int[] nums1 = new int[]{6, 7};
//        int[] nums2 = new int[]{6,0,4};
//        int k=5;

//        int[] nums1 = new int[]{3,9};
//        int[] nums2 = new int[]{8,9};
//        int k=3;

        int[] nums1 = new int[]{5,6,8};
        int[] nums2 = new int[]{6,4,0};
        int k=3;
        System.out.println(Arrays.toString(new T321_maxNumber().maxNumber(nums1,nums2,k)));
    }


}
