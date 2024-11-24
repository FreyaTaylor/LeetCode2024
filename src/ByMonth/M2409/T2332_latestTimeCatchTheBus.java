package src.ByMonth.M2409;

import java.util.Arrays;

public class T2332_latestTimeCatchTheBus {

    /**
     * https://leetcode.cn/problems/the-latest-time-to-catch-a-bus/description/
     * 模拟
     */

    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {

        Arrays.sort(buses);
        Arrays.sort(passengers);
        int i=0,j=0;
        int onBus=0; //本次车上的人数

        while (i<buses.length){
            onBus=0;
            while (j<passengers.length && onBus<capacity && passengers[j]<=buses[i] ) {
                j++;
                onBus++;
            }
            i++;
        }
        i--; // while (i<buses.length){
        j--; //每次循环都是已经上车的下一个index，因为后续处理是从，已经上车的开始处理，因此这里-1

        int  lastCatch=buses[i]; //搭车的最晚到达事件
        if(onBus>=capacity && j>=0){ //若车满，最晚搭车事件是【最后一个上车的j乘客】
            lastCatch=passengers[j];
        }

        while (j>=0&& lastCatch ==passengers[j]){ //向前检查，搭车事件是否合法
            lastCatch--;
            j--;
        }

        return lastCatch;
    }


    public static void main(String[] args) {
        int[] buses = new int[]{20,30,10};
        int[] passengers = new int[]{19,13,26,4,25,11,21};
        int capacity = 2;

//
//        buses = new int[]{10,20};
//        passengers = new int[]{2,17,18,19};
//        capacity = 2;

        buses = new int[]{3};
        passengers = new int[]{2,4};
        capacity = 2;

//        buses = new int[]{2};
//        passengers = new int[]{2};
//        capacity = 2;

//        buses = new int[]{3};
//        passengers = new int[]{4};
//        capacity = 1;
//
        buses = new int[]{5};
        passengers = new int[]{7,8};
        capacity = 1;

        System.out.println(new T2332_latestTimeCatchTheBus().latestTimeCatchTheBus(buses,passengers,capacity));
    }
}
