package src.Uncategorized;

public class _T2417_closestFair {

    /**
     * https://leetcode.cn/problems/closest-fair-integer/
     */

    public int closestFair(int n) {
       if((Integer.toString(n).length()&1)==1){
           int len = Integer.toString(n).length()+1;
           return gen(len);
       }
       return -1;
    }


    public int gen(int len){
        int temp = len/2;
        StringBuilder sb = new StringBuilder();
        sb.append("1");
        for (int i = 0; i < temp; i++) {
            sb.append("0");
        }
        for (int i = 0; i < temp-1; i++) {
            sb.append("1");
        }
        return Integer.valueOf(sb.toString());
    }

    public int helper(int n){

        String s = Integer.toString(n);
        int len = s.length();
        int[] array = new int[len];
        for (int i = 0; i < len ; i++) {
            array[i]=s.charAt(i)-'0';
        }

        int[] even = new int[len]; //偶
        if((array[0]&1)==0){
            even[0]=1;
        }
        for (int i = 1; i < len ; i++) {
            even[i]=even[i-1];
            if((array[1]&1)==0){}
            even[i]++;
        }

        if(even[len-1]*2==array.length){
            return n;
        }


        for (int i = array.length-1; i >-1 ; i--) {

            if(Math.abs(2*even[i]-len)>=len-i){
                if(even[i]>len-even[i]){ //偶多

                }
            }

            if(array[i]+1<=9){
                // 偶变奇
                if((array[i]&1)==0){


                }
            }
        }




        return -1;
    }
}
