package src.BinarySearch;

public class T1060_missingElement_2 {
    /**
     * https://leetcode.cn/problems/missing-element-in-sorted-array/
     */
    public int missingElement(int[] nums, int k) {

        int l=0,r=nums.length;
        int num0=nums[0];

        //!!! 从左往右第一个大于等于k，有可能不存在，那么就是nums.length;
        while (l+1<r){
            int mid=(l+r)/2; //取不到r
            if(nums[mid]-num0-mid<k){
                l=mid+1;
            }else {
                r=mid;
            }
        }

        // 判断两个的情况，目标更新至l
        if(l<r && nums[l]-num0-l<k){
              l=r;
        }
        return nums[l-1]+k-(nums[l-1]-num0-l+1);
    }

    public static void main(String[] args) {
        System.out.println(new T1060_missingElement_2().missingElement(new int[]{1,2,4},3));
    }


}
