package src.ByMonth.M2408;

import src.Trie.WordDictionary;

public class T3007_findMaximumNumber {

    /**
     * https://leetcode.cn/problems/maximum-number-that-sum-of-the-prices-is-less-than-or-equal-to-k
     */

    public long findMaximumNumber(long k, int x) {
        long l=1,r=(k + 1) << x;
        while (l+1<r){
            long mid=(r+l)/2;
             if(accumulatedScore(x,mid)>k){
                r=mid-1;
            }else {
                l=mid; //<=的都可以，因此<不能l=mid+1
            }
        }

        if(accumulatedScore(x,r)>k){
            return l;
        }else {
            return r;
        }

    }


    public long accumulatedScore(int x, long num) {
        long res=0;
        long i=1;

        // 这个循环出不来，因为右移成了1，这里判断一下
        // 循环处理x位，2x位，...
        while ((1L<<(x*(i-1)))<=num && i<64){
            res+=getScore(x*i,num);
            i++;
        };
        return res;
    }

    // 第 x 位
    public long getScore(long x,long num){
        long period = 1L << x;
        long res = period / 2 * ((num+1) / period);
        if((num+1)%period>=period/2){
            res+=(num+1)%period-(period/2);
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new T3007_findMaximumNumber().findMaximumNumber(934717251035561L,8));
//        System.out.println(new T3007_findMaximumNumber().findMaximumNumber(9,1));
//        System.out.println(new T3007_findMaximumNumber().getScore(2,220));
//        System.out.println(new T3007_findMaximumNumber().accumulatedScore(2,221));
    }
}
