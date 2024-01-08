package src.Greedy;

import java.util.Arrays;

public class T135_candy {

    /**
     * https://leetcode.cn/problems/candy/description/
     * @param ratings
     * @return
     * 思路：
     * “相邻两个孩子评分更高的孩子会获得更多的糖果”拆分为：
     * 1. 比左边孩子分数高，则分数比左边高1，其分数应为（至少为）左边孩子分数+1，记在leftSmallerCount里面
     * 2. 比右边孩子分数高，则分数比右边高1，其分数应为（至少为）右边孩子分数+1，记在rightSmallerCount里面
     * 然后，两个数组取max，因拆分的两个条件是“至少为”，那么取max表示了且的关系
     */
    public int candy(int[] ratings) {

        int n=ratings.length;
        int [] leftSmallerCount=new int[n];
        // left
        for (int i = 1; i < n; i++) {
            if(ratings[i]>ratings[i-1]){
                leftSmallerCount[i]=leftSmallerCount[i-1]+1;
            }
        }

        int [] rightSmallerCount=new int[n];
        // right
        for (int i = n-2; i >=0;i--) {
            if(ratings[i]>ratings[i+1]){
                rightSmallerCount[i]=rightSmallerCount[i+1]+1;
            }
        }


        int res=ratings.length; //比存在小孩糖果为0，这里，明日歌全部增加1个糖果
        for (int i = 0; i < n; i++) {
            res+=Math.max(leftSmallerCount[i],rightSmallerCount[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new T135_candy().candy(new int[]{1,2,3,4,2}));
    }
}
