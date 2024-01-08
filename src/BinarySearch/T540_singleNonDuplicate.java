package src.BinarySearch;

public class T540_singleNonDuplicate {

    /**
     * https://leetcode.cn/problems/single-element-in-a-sorted-array/
     * 二分：边界+完备的分情况讨论
     */

    public int singleNonDuplicate(int[] nums) {
        int l=0,r=nums.length-1;

        //可行解比必然包含基数个数字，所以退出条件是l==r
        while (l<r){
            int mid = l+(r-l)/2;
            boolean isLeven= ((mid-l)%2==0); //左边是偶数个数字
            //至少三个数字，因此必含有mid-1，mid+1
            if(nums[mid]==nums[mid-1]){ //四种情况
                if(isLeven){
                    r=mid-2;
                }else {
                    l=mid+1;
                }
            }else if(nums[mid]==nums[mid+1]){
                if(!isLeven){
                    r=mid-1;
                }else {
                    l=mid+2;
                }
            }else {
                return nums[mid]; //碰巧退出的条件
            }

        }

        return nums[l]; //l==r
    }

    public static void main(String[] args) {
        System.out.println(new T540_singleNonDuplicate().singleNonDuplicate(new int[]{1,1,2,2,3}));
    }
}
