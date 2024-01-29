package src.Number;

public class T233_countDigitOne {
    /**
     * https://leetcode.cn/problems/number-of-digit-one/
     */

    public int countDigitOne(int n) {
        int d=(int) Math.log10(n+0.1)+1;
        int [] digit = new int[d];
        int n_=n;
        for (int i = d-1; i >=0 ; i--) {
            digit[i]=n%10;
            n/=10;
        }
        n=n_;
        int l=n/10;
        int r=0;
        int res=0;

        int helper=10;
        for (int i = d-1; i >=0 ; i--) {
            int curd=digit[i];

            // l-curd-r
            if(curd>1){
                res+=(l+1)*Math.pow(10,d-i-1);
                // l in [0,l] and r in [0,999...]
            }else if(curd==1){
                res+=l*Math.pow(10,d-i-1)+r+1;
                // l in [0,l-1] and r in [0,999...]
                // l=l and r in [0, r]
            }else{
                res+=l*Math.pow(10,d-i-1);
                // l in [0,l-1] and r in [0,999...]
            }
            l=l/10;
            r=n%helper;
            helper*=10;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new T233_countDigitOne().countDigitOne(234));
    }

}
