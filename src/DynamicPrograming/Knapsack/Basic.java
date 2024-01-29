package src.DynamicPrograming.Knapsack;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Basic {

    /**
     * https://www.nowcoder.com/questionTerminal/708f0442863a46279cce582c4f508658?
     */

    int maxv=Integer.MIN_VALUE;
    public int basicKnapsack(int bag,int[] v,int[]val){
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return val[o2]/v[o2]-val[o1]/v[o1];
            }
        });
        int n=v.length;
        int[] nv = new int[n];
        int[] nval = new int[n];
        double[] rate  = new double[n];
        for (int i = 0; i < n; i++) {
            q.add(i);
        }
        for (int i = 0; i < n; i++) {
            int index=q.poll();
            nv[i]=v[index];
            nval[i]=val[index];
            rate[i]=(double) nval[i]/nv[i];
        }


        helper(bag,v,val,rate,0,0,0);
        return maxv;
    }

    public void helper(int bag, int[] v, int[] val,double[] rate,int cur,int curV, int curVal){
        if(cur==v.length){
            maxv=Math.max(maxv,curVal);
            return;
        }

        if(rate[cur]*(bag-curV)+curVal<maxv){
            return;
        }

        helper(bag,v,val,rate,cur+1,curV,curVal);
        if(curV+v[cur]<=bag){
            helper(bag,v,val,rate,cur+1,curV+v[cur],curVal+val[cur]);
        }

    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int bag = in.nextInt();
        int n = in.nextInt();
        int[] v = new int[n];
        int[] val = new int[n];
        // 注意 hasNext 和 hasNextLine 的区别
        for (int i = 0; i < n; i++) {
            v[i]=in.nextInt();
            val[i]=in.nextInt();
        }

//        int bag = 6;
//        int[] v = new int[]{3,2,4};
//        int[] val = new int[]{5,4,2};

        System.out.println(new Basic().basicKnapsack(bag,v,val));



    }



}
