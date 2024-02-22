package src.Traverse;

import java.util.Arrays;

public class T475_findRadius {

    /**
     * https://leetcode.cn/problems/heaters/
     */
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int l=0;
        int r=Math.max(heaters[heaters.length-1]-houses[0],houses[houses.length-1]-heaters[0]);
        while (l<r){

//            System.out.println(l+" "+r);
            int mid = l+(r-l)/2;

            if(check(houses,heaters,mid)){

                r=mid;
            }else {
                l=mid+1;
            }

        }


        return l;
    }

    public boolean check(int[] houses, int[] heaters,int radius){
        int i=0,j=0;
        while (i<houses.length && j<heaters.length){
            int l=heaters[j]-radius;
            int r=heaters[j]+radius;

            if(houses[i]<l){
                return false;
            }else if(houses[i]>=l && houses[i]<=r){
                i++;
            }else {
                j++;
            }

        }
        if(i>=houses.length){
            return true;
        }else {
            return false;
        }

    }

    public static void main(String[] args) {
        System.out.println(new T475_findRadius().findRadius(new int[]{1,5},new int[]{2}));
    }
}
