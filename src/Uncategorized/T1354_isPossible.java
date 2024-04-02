package src.Uncategorized;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class T1354_isPossible {
    /**
     * https://leetcode.cn/problems/construct-target-array-with-multiple-sums/
     *
     * 再观察到一个性质：如果最大的数被替换掉以后还是最大的数，那么每次减去的差值，即 (sum-s) 是恒定不变的，
     * 因为这个差值就是除这个最大的数以外的所有的数之和，每次逆操作不会影响到这些数，也就不会影响到这些数之和，
     * 我们可以根据此对我们原来的操作加速。 !!!
     *
     *
     */

    public boolean isPossible(int[] target) {
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() { //[index,val]
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        });

        int n=target.length;
        int sum=0;
        for (int i = 0; i < n; i++) {
            q.add(new int[]{i,target[i]});
            sum+=target[i];
        }


        while (q.size()>=2){
            int[] max1 = q.poll();
            int[] max2 = q.peek();

            if(max1[1]==n && max2[1]==1){
                return true;
            }

            int remain = (sum-max1[1]);
            if(remain<=0){return false;}
            int k = (int)Math.ceil( ((double) max1[1]-max2[1])/remain);
            // int k = Math.max((max1[1]-max2[1])/remain,1);
            int change=max1[1]-k*remain;


            if(change>0 && k!=0){
                target[max1[0]]=change;
                q.add(new int[]{max1[0],change});
                sum+=change-max1[1];
            }else {
                break;
            }
            System.out.println(Arrays.toString(target));
        }

        for (int i = 0; i < n; i++) {
            if(target[i]!=1){
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
//        System.out.println(new T1354_isPossible().isPossible(new int[]{9,3,5}));
//        System.out.println(new T1354_isPossible().isPossible(new int[]{8,5}));
//        System.out.println(new T1354_isPossible().isPossible(new int[]{1,1,1,2}));
        System.out.println(new T1354_isPossible().isPossible(new int[]{1,1000000000}));
//        System.out.println(new T1354_isPossible().isPossible(new int[]{1}));
    }
}
