package src.BinarySearch;

public class T878_nthMagicalNumber {

    /**
     * https://leetcode.cn/problems/nth-magical-number/
     * 二分猜测法
     * 使用计算机友好的思路
     */
//    public int nthMagicalNumber(int n, int a_, int b_) {
//        long helper=(long) Math.pow(10,9)+7;
//        if(a_==b_){
//            // a*n
//            return (int) (((long)a_*n)%helper);
//        }
//
//        long a=(long) Math.min(a_,b_);
//        long b=(long) Math.max(a_,b_);
//
//
//        long l=a,r=(long)a_*n;
//        long ab=lcm((int) a,(int) b);
//        while (l+1<r){
//            long midVal=(l+r)/2;
//            long aCount=midVal/a;
//            long bCount=midVal/b;
//            long abCount=midVal/ab;
//            long sumCount=aCount+bCount-abCount;
//            if(sumCount==n){
//                if(aCount*a>=bCount*b){
//                    return (int)((aCount*a)%helper);
//                }else {
//                    return (int)((bCount*b)%helper);
//                }
//
//            }else if(sumCount<n){
//                l=midVal;
//            }else {
//                r=midVal;
//            }
//        }
//
//        if(l%a==0 || l%b==0){
//            return (int)(l%helper);
//        }else {
//            return (int)(r%helper);
//        }
//    }

    public int nthMagicalNumber(int n, int a, int b) {
        long helper=(long) Math.pow(10,9)+7;
        long l=Math.min(a,b),r=(long) n*Math.min(a,b);
        long ab=lcm(a,b);
        while (l<r){
            System.out.println(l+" "+r);
            long midVal=(l+r)/2;
            long aCount=midVal/a;
            long bCount=midVal/b;
            long abCount=midVal/ab;
            long sumCount=aCount+bCount-abCount;
            if(sumCount==n){
                if(aCount*a>=bCount*b){
                    return (int)((aCount*a)%helper);
                }else {
                    return (int)((bCount*b)%helper);
                }

            }else if(sumCount<n){
                l=midVal+1;
            }else {
                r=midVal-1;
            }
        }

        return (int)(l%helper);
    }


    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }



    public static void main(String[] args) {
        System.out.println(new T878_nthMagicalNumber().nthMagicalNumber(887859796,37516,29911));
    }
}
