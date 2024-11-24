package src.Graph.Traversal;

import java.util.*;

public class T2338_idealArrays {

    /**
     * https://leetcode.cn/problems/count-the-number-of-ideal-arrays/
     * 1.找到所有不重复子序列，根据图
     * 长度=1:
     * 1
     * 2
     * ...
     * 长度=2:
     * 1 2
     * 1 3
     * ...
     * 长度=k:
     * 1 2 4 12 36  ...
     * ...
     *
     * 2.根据每个长度，计算展示成n长度数组的可能性，dp
     * k->n
     * k-1->n-m,m个最后一个数
     *
     *
     * 内存超了
     * */
    public int idealArrays_1(int n, int maxValue) {

        int helper = (int)Math.pow(10,9)+7;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 1; i <maxValue+1 ; i++) {
            map.put(i,new ArrayList<>());
        }

        for (int i = 1; i < maxValue+1; i++) {
            for (int j = i+1; j < maxValue+1; j++) {
                if(j%i==0){
                    map.get(i).add(j);
                }
            }
        }


        int[] count=new int[n+1];
        count[1]=maxValue;
        for (int i = 1; i <maxValue+1 ; i++) {
            Deque<Integer> q = new ArrayDeque<>();
            q.add(i);
            int len=2;

            while (!q.isEmpty() && len<n+1){
                int size = q.size();
                for (int j = 0; j < size; j++) {
                    int cur=q.removeFirst();
                    count[len]+=map.get(cur).size();
                    for (Integer next : map.get(cur)) {
                        q.addLast(next);
                    }

                }
                len++;
            }

//            System.out.println();
        }

        // i 个数字有几种凑成 j 的方法
        long[][] dp = new long[n+1][n+1];
        Arrays.fill(dp[1],1);
        dp[1][0]=0;
        for (int i = 2; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                for (int k = 1; k <=j+1-i ; k++) {
                    dp[i][j]+=dp[i-1][j-k];
                    dp[i][j]%=helper;
                }
            }
        }


        int res=0;
        for (int i = 1; i <n+1 ; i++) {
            // count[i]个数字加起来=n，有几种方法
            res+=((count[i]*dp[i][n])%helper);
            res%=helper;
        }


        return res;

    }


    /**
     * 从结尾来找规律：
     * 1 1 1 2 2 2 2 2 6 6 6 6 6 6 30 30
     *
     *      x2          x3          x5
     *
     *  分解质因子
     */

    public int idealArrays(int n, int maxValue) {

        boolean[] ish = countPrimes(maxValue+1);

        List<Integer> zs = new ArrayList<>();
        for (int i = 2; i < maxValue+1; i++) {
            if(!ish[i]){
                zs.add(i);
            }
        }

        List<List<Integer>> factor = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        factor.add(new ArrayList<>());
        factor.add(new ArrayList<>(temp));
        for (int i = 2; i <maxValue+1 ; i++) {
            int half=(int) Math.pow(maxValue,0.5);
            temp = new ArrayList<>();
            temp.add(1);
            int num=i;
            int index=0;
            while (zs.get(index)*zs.get(index)<=num){
                int count=0;
                while (num%(zs.get(index))==0){
                    count++;
                    num=num/zs.get(index);
                }
                temp.add(count);
                index++;
            }

        }

        return -1;
    }


    public boolean[] countPrimes(int n) {

        boolean[] ish = new boolean[n];

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!ish[i]) { //未检测
                count++;
                for (int j = i; (long) j * i < n; j++) {
                    ish[j * i] = true;

                }
            }
        }

        return ish;
    }

    public static void main(String[] args) {
        System.out.println(new T2338_idealArrays().idealArrays(184,389));
    }
}
