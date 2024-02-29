package src.Uncategorized;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LCR_93_lenLongestFibSubseq {
    /**
     * https://leetcode.cn/problems/Q91FMA/
     */

    public int lenLongestFibSubseq(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        int res=2;
        for (int i = 0; i < arr.length-2; i++) {
//            int a=arr[i]; // 写这里错了，因为a在下面循环里面被修改了
            for (int j = i+1; j <arr.length-1 ; j++) {
                int len=2;
                int a=arr[i];
                int b=arr[j];
                if(b-a<a && set.contains(b-a)){ // b-a必须<a,因为它必须是a前的数
                    continue;
                }
                while (set.contains(a+b)){
                    len++;
                    int temp=b;
                    b=a+b;
                    a=temp;
                }
                res=Math.max(res,len);
            }
        }

        if(res!=2){
            return res;
        }else {
            return 0;
        }

    }

//
//    public int lenLongestFibSubseq(int[] arr) {
//        Map<Integer, Integer> indices = new HashMap<Integer, Integer>();
//        int n = arr.length;
//        for (int i = 0; i < n; i++) {
//            indices.put(arr[i], i);
//        }
//        int[][] dp = new int[n][n];
//        int ans = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = i - 1; j >= 0 && arr[j] * 2 > arr[i]; j--) {
//                int k = indices.getOrDefault(arr[i] - arr[j], -1);
//                if (k >= 0) {
//                    dp[j][i] = Math.max(dp[k][j] + 1, 3);
//                }
//                ans = Math.max(ans, dp[j][i]);
//            }
//            System.out.println();
//        }
//        return ans;
//    }

    public static void main(String[] args) {
//        System.out.println(new LCR_93_lenLongestFibSubseq().lenLongestFibSubseq(new int[]{1,2,3,4,5,6,7,8}));
        System.out.println(new LCR_93_lenLongestFibSubseq().lenLongestFibSubseq(new int[]{2,4,7,8,9,10,14,15,18,23,32,50}));
//        System.out.println(new LCR_93_lenLongestFibSubseq().lenLongestFibSubseq(new int[]{2,6,8,10,16,19,20,21,23,24,26,28,31,32,33,35,36,38,44,45,46,50,55,56,58,60,64,67,70,77,79,80,87,88,90,96,100,123,125,130,142,144,148,154,164,200,204,205,229,232,238,250,264,323,329,330,371,376,386,404,428,523,530,533,600,608,624,654,692,846,860,862,984,1010,1120,1369,1390,1395,1592,1634,1812,2215,2250,2257,2576,2644,3584,3640,3652,4168,4278,5799,5890,5909,6744,6922,9530,9561,10912,11200,15470,17656,18122,25031,28568,29322,40501,46224,65532,106033,171565,277598}));
    }
}
