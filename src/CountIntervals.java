package src;

import java.util.List;

public class CountIntervals {
    /**
     * https://leetcode.cn/problems/count-integers-in-intervals/
     * @param args
     *
     * 1.把集合中的左边界放在列表lb，有边界在在rb，都是有序的
     * 2.新加入的区间，会影响若干个旧区间（有交集，因此需要改变），找到被影响的区间们：
     * 左起第一个rb>=left，右起第一个lb<=right，可以通过二分得到，被影响区间的index范围为此
     * 3.根据区间们的边界计算出新边界：l=new min l，newr=max r，范围是新区间+被影响区间
     */

    private List<Integer> lb;
    private List<Integer> rb;

    public CountIntervals() {

    }

    public void add(int left, int right) {

        //fist >=right in lds

    }

    public int fistGreater(List<Integer> arr,int target) {
        int l=0;
        int r=arr.size();
        while (l<r){
            int mid=l+(r-l)/2;
//            if()
        }

        return 0;
    }



    public static void main(String[] args) {

    }
}
