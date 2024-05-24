package src.BinarySearch;

public class T1060_missingElement_1 {
    /**
     * 二分的重点，将原本数组num[i]，转换成一个f(num[i],i),且升序的数组，然后“寻找第一个》=某”
     * @param nums
     * @param k
     * @return
     */
    public int missingElement(int[] nums, int k) {
        int l=0,r=nums.length-1;
        if(nums[r]-nums[0]-r<k){
            return nums[r]+k-(nums[r]-nums[0]-r);
        }

        // nums[i]-nums[0]-(i-0) [0,i]缺失了多少
        // 0: nums[r]-nums[l]-(r-l) >k
        // 第一个>=K
        while (l<r){
            int mid = (l+r)/2;
            if(nums[mid]-nums[0]-mid<k){
                l=mid+1;
            }else {
                r=mid;
            }
        }

        r--;
        return nums[r]+k-(nums[r]-nums[0]-r);
    }


    public static void main(String[] args) {
        int[] nums = new int[]{4,7,9,10};
        int k = 5;
        System.out.println(new T1060_missingElement_1().missingElement(nums,k));
    }
}
