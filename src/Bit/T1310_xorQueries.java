package src.Bit;

public class T1310_xorQueries {
    /**
     * https://leetcode.cn/problems/xor-queries-of-a-subarray/
     * x⊕x=0
     */

    public int[] xorQueries(int[] arr, int[][] queries) {
        int n=arr.length;
        int[] preXor = new int[n+1]; // [0,i-1]

        for (int i = 1; i <n+1 ; i++) {
            preXor[i]=preXor[i-1]^arr[i-1];
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i]=preXor[queries[i][1]+1]^preXor[queries[i][0]];
        }

        return res;
    }

}
