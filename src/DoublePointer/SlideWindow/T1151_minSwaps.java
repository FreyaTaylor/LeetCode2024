package src.DoublePointer.SlideWindow;

public class T1151_minSwaps {
    /**
     * https://leetcode.cn/problems/minimum-swaps-to-group-all-1s-together/
     */
    public int minSwaps(int[] data) {
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            count+=data[i];
        }

        int curCount=0;
        for (int i = 0; i < count; i++) {
            curCount+=data[i];
        }
        int maxCount=curCount;
        for (int i = count; i <data.length ; i++) {
            curCount=curCount+data[i]-data[i-count];
            maxCount=Math.max(maxCount,curCount);
        }

        return count-maxCount;
    }

    public static void main(String[] args) {
        System.out.println(new T1151_minSwaps().minSwaps(new int[]{1,0,1,0,1,0,1,1,1,0,1,0,0,1,1,1,0,0,1,1,1,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1}));
    }

}
