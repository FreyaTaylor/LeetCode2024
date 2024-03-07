package src.BinarySearch;

public class _T878_nthMagicalNumber {

    /**
     * https://leetcode.cn/problems/nth-magical-number/
     */
    public int nthMagicalNumber(int n, int a_, int b_) {
        long helper=(long) Math.pow(10,9)+7;
        if(a_==b_){
            // a*n
            return (int) ((((long)a_%helper)*((long) n%helper))%helper);
        }

        long a=(long) Math.min(a_,b_);
        long b=(long) Math.max(a_,b_);


        long l=1,r=n;
        long ab=lcm(a_,b_);
        while (l+1<r){
            System.out.println(l+" "+r);
            long mid=(l+r)/2;
            long midVal=mid*a;
            // a:midVal b:
            long bCount=midVal/b;
            long abCount=midVal/ab;
            long sumCount=mid+bCount-abCount;
            if(sumCount==n){
                return (int) midVal;
            }else if(sumCount<n){
                l=mid;
            }else {
                r=mid;
            }
        }
        // l,
        long curVal=(long) l*a;
        long bCount=curVal/b;
        long abCount=curVal/ab;
        long sumCount=l+bCount-abCount;
        long ai=l+1;
        long bi=bCount+1;
        while (sumCount<n){
            if(ai*a<bi*b){
                curVal=ai*a;
                ai++;
            }else if(ai*a==bi*b){
                curVal=ai*a;
                ai++;
                bi++;
            }else {
                curVal=bi*b;
                bi++;
            }

            sumCount++;
        }

        return (int) (curVal%helper);
    }


    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }



    public static void main(String[] args) {
        System.out.println(new _T878_nthMagicalNumber().nthMagicalNumber(887859796,29911,37516));
    }
}
