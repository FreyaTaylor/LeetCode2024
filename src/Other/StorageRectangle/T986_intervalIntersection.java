package src.Other.StorageRectangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T986_intervalIntersection {
    /**
     * https://leetcode.cn/problems/interval-list-intersections/
     */

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();

        int i=0,j=0;
        while (i<firstList.length && j<secondList.length){
            int start=Math.max(firstList[i][0],secondList[j][0]);
            int end=Math.min(firstList[i][1],secondList[j][1]);
            if(start<=end){
                res.add(new int[]{start,end});
            }

            if(firstList[i][1]<secondList[j][1]){
                i++;
            }else if(firstList[i][1]>secondList[j][1]){
                j++;
            }else {
                i++;
                j++;
            }
//            System.out.println();
        }

        int[][] arr = new int[res.size()][];
        for (int k = 0; k < res.size(); k++) {
            arr[k]=res.get(k);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][]firstList = new int[][]{{0,2},{5,10},{13,23},{24,25}};
        int[][]secondList = new int[][]{{1,5},{8,12},{15,24},{25,26}};
        int[][] arr = new T986_intervalIntersection().intervalIntersection(firstList,secondList);
        System.out.println(Arrays.deepToString(arr));
    }
}
