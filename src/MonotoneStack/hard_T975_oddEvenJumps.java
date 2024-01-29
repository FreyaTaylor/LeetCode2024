package src.MonotoneStack;

import java.util.*;

public class hard_T975_oddEvenJumps {
    /**
     * https://leetcode.cn/problems/odd-even-jump/
     * 在进行奇数跳跃时（如，第 1，3，5... 次跳跃），你将会跳到索引 j，
     * 使得 A[i] <= A[j]，A[j] 是可能的最小值。如果存在多个这样的索引 j，你只能跳到满足要求的最小索引 j 上。
     * 在进行偶数跳跃时（如，第 2，4，6... 次跳跃），你将会跳到索引 j，
     * 使得 A[i] >= A[j]，A[j] 是可能的最大值。如果存在多个这样的索引 j，你只能跳到满足要求的最小索引 j 上。
     */
    public int oddEvenJumps(int[] arr) {
        int n=arr.length;
        // 构造每个点的奇偶跳目标点
        int[] oddNextBigger = new int[n];
        int[] evenNextSmaller = new int[n];
        Arrays.fill(oddNextBigger,-1);
        Arrays.fill(evenNextSmaller,-1);
        // 这个构造法时间复杂度为n2，超时，考虑使用单调栈
//        for (int i = 0; i < n; i++) {
//            int cur=arr[i];
//            int bi=-1;
//            int bigger=Integer.MAX_VALUE;
//            int si=-1;
//            int smaller=Integer.MIN_VALUE;
//            for (int j = i+1; j <n ; j++) {
//                if(arr[j]>=cur && arr[j]<bigger){
//                    bigger=arr[j];
//                    bi=j;
//                }
//                if(arr[j]<=cur && arr[j]>smaller){
//                    smaller=arr[j];
//                    si=j;
//                }
//            }
//            oddNextBigger[i]=bi;
//            evenNextSmaller[i]=si;
//        }

        // 先将数组排序
        int[][] iarr= new int[n][2];
        for (int i = 0; i < n; i++) {
            iarr[i][0]=i;
            iarr[i][1]=arr[i];
        }
        Arrays.sort(iarr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]!=o2[1]){
                    return o1[1]-o2[1];
                }else {
                    return o1[0]-o2[0];
                }
            }
        });
        // 排序后，依次处理，遍历到的数组一定是dq中数组的“最小bigger值”，若index符合，则更新；否则待定不更新
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty()&&dq.getLast()<iarr[i][0]){
                oddNextBigger[dq.pollLast()]=iarr[i][0];
            }
            dq.addLast(iarr[i][0]);
//            System.out.println();
        }
//        System.out.println();

        Arrays.sort(iarr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]!=o2[1]){
                    return o2[1]-o1[1];
                }else {
                    return o1[0]-o2[0];
                }
            }
        });
        dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty()&&dq.getLast()<iarr[i][0]){
                evenNextSmaller[dq.pollLast()]=iarr[i][0];
            }
            dq.addLast(iarr[i][0]);
        }



        // 构造奇偶跳目标点为key的set
        Map<Integer, Set<Integer>> odd = new HashMap<>();
        Map<Integer, Set<Integer>> even = new HashMap<>();
        for (int i = 0; i <n ; i++) {
            int bi=oddNextBigger[i];
            if(bi!=-1){
                if(!odd.containsKey(bi)){
                    odd.put(bi,new HashSet<>());
                }
                odd.get(bi).add(i);
            }
            int si=evenNextSmaller[i];
            if(si!=-1){
                if(!even.containsKey(si)){
                    even.put(si,new HashSet<>());
                }
                even.get(si).add(i);
            }
        }

        Set<Integer> res = new HashSet<>();
        Set<Integer> curSet = new HashSet<>();;
        curSet.add(n-1); // n-1之前的一步为偶跳
        if(odd.containsKey(n-1)&&!odd.get(n-1).isEmpty()){
            curSet.addAll(odd.get(n-1)); //n-1之前的一步为奇跳，找到这些奇跳的点，加入curSet，则curSet中前一跳为偶跳
        }
        // curSet中前一跳为偶跳


        while (!curSet.isEmpty() ){
            res.addAll(curSet); // curSet中前一跳为偶跳，即curSet开始跳为奇跳，是可行解
            // even
            Set<Integer> lastSet1=new HashSet<>();
            for (Integer i : curSet) {
                if(even.containsKey(i)&&!even.get(i).isEmpty()){
                   lastSet1.addAll(even.get(i));
                }
            }
            // odd
            Set<Integer> lastSet2=new HashSet<>();
            for (Integer i : lastSet1) {
                if(odd.containsKey(i)&&!odd.get(i).isEmpty()){
                    lastSet2.addAll(odd.get(i));
                }
            }
            curSet = new HashSet<>(lastSet2);
        }


        return res.size();
    }




    public static void main(String[] args) {
        System.out.println(new hard_T975_oddEvenJumps().oddEvenJumps(new int[]{5,1,3,4,2}));
        System.out.println(new hard_T975_oddEvenJumps().oddEvenJumps(new int[]{2,3,1,1,4}));
    }

}
