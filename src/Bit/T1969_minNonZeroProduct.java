package src.Bit;

import src.BinarySearch.T1060_missingElement;

public class T1969_minNonZeroProduct {
    /**
     * https://leetcode.cn/problems/minimum-non-zero-product-of-the-array-elements
     * (2^p -1) (2^p -2)^(2^(p-1)-1)
     */

    public int minNonZeroProduct(int p) {
        long mod= (long) Math.pow(10,9)+7;

        long x =getPow(2,p,mod)-1;
        long y =((long) 1<<(p-1))-1; // 需要 (long)
        return (int)(x*getPow(x-1,y,mod)%mod);

    }

    public long getPow(long x,long n,long mod){
        long res = 1;
        for (; n>0 ; n=n>>1) {
            if((n&1)!=0){
                res=res*x%mod;
            }
            x=x*x%mod;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new T1969_minNonZeroProduct().minNonZeroProduct(33));
    }

}
