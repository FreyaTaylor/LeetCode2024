package src;

import java.util.*;

public class T975_oddEvenJumps {
    /**
     * https://leetcode.cn/problems/odd-even-jump/
     * 在进行奇数跳跃时（如，第 1，3，5... 次跳跃），你将会跳到索引 j，
     * 使得 A[i] <= A[j]，A[j] 是可能的最小值。如果存在多个这样的索引 j，你只能跳到满足要求的最小索引 j 上。
     * 在进行偶数跳跃时（如，第 2，4，6... 次跳跃），你将会跳到索引 j，
     * 使得 A[i] >= A[j]，A[j] 是可能的最大值。如果存在多个这样的索引 j，你只能跳到满足要求的最小索引 j 上。
     */
    public int oddEvenJumps(int[] arr) {
        int n=arr.length;
        int[] oddNextBigger = new int[n];
        int[] evenNextSmaller = new int[n];
        Map<Integer, Set<Integer>> odd = new HashMap<>();
        Map<Integer, Set<Integer>> even = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int cur=arr[i];
            int bi=-1;
            int bigger=Integer.MAX_VALUE;
            int si=-1;
            int smaller=Integer.MIN_VALUE;
            for (int j = i+1; j <n ; j++) {
                if(arr[j]>=cur && arr[i]<bigger){
                    bigger=arr[j];
                    bi=j;
                }
                if(arr[j]<=cur && arr[i]>smaller){
                    smaller=arr[j];
                    si=j;
                }
            }
            oddNextBigger[i]=bi;
            if(bi!=-1){
                if(!odd.containsKey(bi)){
                    odd.put(bi,new HashSet<>());
                }
                odd.get(bi).add(i);
            }
            evenNextSmaller[i]=si;
            if(si!=-1){
                if(!even.containsKey(si)){
                    even.put(si,new HashSet<>());
                }
                even.get(si).add(i);
            }
        }

        Set<Integer> res = new HashSet<>();
        Set<Integer> oddSet = new HashSet<>();
        Set<Integer> evenSet = new HashSet<>();
        oddSet.add(n-1);
        if(!even.get(n-1).isEmpty()){
            oddSet.addAll(even.get(n-1));
        }



        Boolean isOdd=true;
        while (!oddSet.isEmpty() ){

            evenSet=new HashSet<>();
            for (Integer i : oddSet) {
                if(!even.get(i).isEmpty()){
                   evenSet.addAll(even.get(i));
                }
            }
            res.addAll(evenSet);
            oddSet=new HashSet<>();
            for (Integer i : evenSet) {
                if(!odd.get(i).isEmpty()){
                    oddSet.addAll(odd.get(i));
                }
            }



        }


        return res.size();
    }

    public static void main(String[] args) {
        System.out.println(new T975_oddEvenJumps().oddEvenJumps(new int[]{10,13,12,14,15}));
    }

}
