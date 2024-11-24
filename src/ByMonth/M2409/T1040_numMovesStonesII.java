package src.ByMonth.M2409;

import src.BinaryTree.T1026_maxAncestorDiff;

import java.util.Arrays;

public class T1040_numMovesStonesII {

    /**
     * https://leetcode.cn/problems/moving-stones-until-consecutive-ii/description/
     * 最大次数：
     * ● m长度的位置，n个石头，
     * ● 每次移动最小减少一个空位，
     *   ○ [孤立端点]如果本次移动的端点石头旁边是空位，则将损益旧端点和端点最近石头之间的空位
     *   ○ [非孤立端点]如果本次移动的端点石头旁边不是空位，
     *     ■ 如何避免损失空位：将端点石头移动到离自己最近的空位，即移动后没有减少端点石头堆的大小
     * ● 极限情况：左右两端点都孤立，只能先移动某个孤立端点，并且将另一个孤立端点改造成非孤立端点
     * ● Math.max(stones[n - 2] - stones[0] + 1, stones[n - 1] - stones[1] + 1) - (n - 1);
     * 最小次数：
     * ● 最终全部石子连续等价于全部的石子最终都移动到了一个长度为 n 的窗口中，假设有k个元素
     * ● k=1
     *   ○ [1234]6
     *     ■ 1
     *   ○ [1234]x x>6
     *     ■ 2
     * ● k>1
     *   ○ n-k个，思路为:造窗口的左右边界（使之成为最终的边界）
     *   ○ 定左
     *     ■ 右端点有，则n-k
     *     ■ 右端点无，看外表点的情况
     *       ● 有左有右，则挪左边的一个到右端点，则n-k
     *       ● 仅右，则挪右边的一个到右端点，则n-k
     *       ● 仅左，定右端点，情况如定左
     */

    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        int n=stones.length;

        // 最大空位-极限条件损失空位
        int max=(stones[n-1]-stones[0]+1-n)-(Math.min(stones[1]-stones[0],stones[n-1]-stones[n-2])-1);

        int k=0; //最大连续n个位置中右多少石头
        int l=0,r=0;
        while (r<n){
            while (r<n && stones[r]-stones[l]+1<=n){
                r++;
            }

            k=Math.max(k,r-l);
            if(n-k==1){

            }

            while (r<n && stones[r]-stones[l]+1>n){
                l++;
            }
        }
        k=Math.max(k,r-l);


        int min=n-k;

        // min=1，只有【0，n-2】【1，n-1】这两种情况，判断这两种情况都无法一步到位，则需要2步
        if(min==1 && stones[n-2]-stones[0]!=n-1 && stones[n-1]-stones[1]!=n-1){
            min=2;
        }

        return new int[]{min,max};
    }


    public static void main(String[] args) {

        int[] values;
        values = new int[]{6,5,4,3,10};
        values = new int[]{7,4,9};
        values = new int[]{8,7,6,5,2};


        System.out.println(Arrays.toString(new T1040_numMovesStonesII().numMovesStonesII(values)));
    }
}
