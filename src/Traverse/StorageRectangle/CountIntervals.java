package src.Traverse.StorageRectangle;

import java.util.Map;
import java.util.TreeMap;

public class CountIntervals {
    /**
     * https://leetcode.cn/problems/count-integers-in-intervals/
     * @param args
     *
     * 1.把集合中的左边界放在列表lb，有边界在在rb，都是有序的
     * 2.新加入的区间，会影响若干个旧区间（有交集，因此需要改变），找到被影响的区间们：
     * 左起第一个rb>=left，右起第一个lb<=right，可以通过二分得到，被影响区间的index范围为此
     * 3.根据区间们的边界计算出新边界：l=new min l，newr=max r，范围是新区间+被影响区间
     *
     * 官方解题：平衡二叉树
     *  TreeMap<Integer,Integer>
     *  Map.Entry<Integer,Integer> itvs= btree.floorEntry(right); //最大的小于目标值的key
     *
     */

    private int  count;
    private TreeMap<Integer,Integer> btree;
    public CountIntervals() {
        count=0;
        btree = new TreeMap<>();
    }

    public void add(int left, int right) {
        Map.Entry<Integer,Integer> itvs= btree.floorEntry(right); //最大的小于目标值的key
        while (itvs!=null && itvs.getValue()>=left){
            // 取出
            btree.remove(itvs.getKey());
            count-=itvs.getValue()-itvs.getKey()+1;
            //合并
            left=Math.min(left,itvs.getKey());
            right=Math.max(right,itvs.getValue());
            //尝试插入
            itvs= btree.floorEntry(right);
        }

        count+=right-left+1;
        btree.put(left,right);
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {

        CountIntervals obj = new CountIntervals();
        obj.add(2,3);
        obj.add(7,10);
        System.out.println(obj.count());
        obj.add(5,8);
        System.out.println(obj.count());
    }
}
