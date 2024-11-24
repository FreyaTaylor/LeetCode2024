package src.Bit;

public class T2401_longestNiceSubarray {

    /**
     * https://leetcode.cn/problems/longest-nice-subarray/
     *
     * !!! 因为属于合法字数组的都是每一位最多只存在一个1，因此可以用 亦或 进行减法操作！！
     */


    public int longestNiceSubarray(int[] nums) {

        int l=0,r=0;
        int maxLen = 0;
        int curUnion = 0;
        while (r<nums.length){
            if((curUnion&nums[r])==0){
                curUnion=curUnion|nums[r];
                r++;
            }else {
                maxLen = Math.max(maxLen,r-l);
                curUnion=curUnion^nums[l];
                // !!! 因为属于合法字数组的都是每一位最多只存在一个1，因此可以用 亦或 进行减法操作！！
                l=l+1;
            }

        }
        maxLen = Math.max(maxLen,r-l);

        return maxLen;
    }

//    public int longestNiceSubarray(int[] nums) {
//
//        int l=0,r=0;
//        int maxLen = 0;
//        int[] digits = new int[32];
//
//        while (r<nums.length){
//            int[] num = digits(nums[r]);
//            if(continues(digits, num)){
//                for (int i = 0; i < 32; i++) {
//                    if(num[i]==1){
//                        digits[i]++;
//                    }
//                }
//                r++;
//            }else {
//                maxLen = Math.max(maxLen,r-l);
//                num = digits(nums[l]);
//                for (int i = 0; i < 32; i++) {
//                    if(num[i]==1){
//                        digits[i]--;
//                    }
//                }
//                l++;
//            }
////            System.out.println();
//
//        }
//        maxLen = Math.max(maxLen,r-l);
//
//        return maxLen;
//    }

//    public int[] digits(int n){
//        int[] digits = new int[32];
//        int index = 31;
//        while (n>0){
//            if(n%2==1){
//                digits[index]=1;
//            }
//            index--;
//            n=n/2;
//        }
//        return digits;
//    }
//
//    public boolean continues(int[] digits, int[] n ){
//        for (int i = 0; i < 32; i++) {
//            if(digits[i]>0 && n[i]>0){
//                return false;
//            }
//        }
//        return true;
//    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,8,48,10};

        nums = new int[]{3,1,5,11,13};

        nums = new int[]{84139415,693324769,614626365,497710833,615598711,264,65552,50331652,1,1048576,16384,544,270532608,151813349,221976871,678178917,845710321,751376227,331656525,739558112,267703680};

        System.out.println(new T2401_longestNiceSubarray().longestNiceSubarray(nums));
//        System.out.println(Arrays.toString(new T2401_longestNiceSubarray().digits(4)));

    }

}
