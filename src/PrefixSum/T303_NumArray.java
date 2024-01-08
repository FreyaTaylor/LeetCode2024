package src.PrefixSum;

public class T303_NumArray {

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[] {-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0, 2));// return 1 ((-2) + 0 + 3)
        System.out.println(numArray.sumRange(2, 5));// return 1 ((-2) + 0 + 3)
        System.out.println(numArray.sumRange(0, 5));// return 1 ((-2) + 0 + 3)

        numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
        numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
    }
}

class NumArray {

    private int[] psum;
    public NumArray(int[] nums) {
        psum = new int [nums.length+1]; // [0,i-1]

        for (int i = 0; i <nums.length ; i++) {
            psum[i+1]=psum[i]+nums[i];
        }
    }

    public int sumRange(int left, int right) {

        return psum[right+1]-psum[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */