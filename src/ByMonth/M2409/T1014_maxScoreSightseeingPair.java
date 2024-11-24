package src.ByMonth.M2409;

import java.util.ArrayDeque;
import java.util.Deque;

public class T1014_maxScoreSightseeingPair {

    /**
     * https://leetcode.cn/problems/best-sightseeing-pair/description/
     */
    public int maxScoreSightseeingPair(int[] values) {
        // 目标:max{values[j]+values[i]-(j-i)}
        // =values[j]+max{values[i]-(j-i)}

        int maxCtbt=0; //当遍历到i时，【0，i-1】中最大的values[k]-k,即max{values[i]-(j-i)}
        int res=Integer.MIN_VALUE;

        for (int i = 0; i < values.length; i++) {
            // i作为end，的最值=values[i]+max{values[k]-(i-k)}
            // i=0，合理，因为1 <= values[i]，即使最差情况，i=1是最小的1，也满足【0，1】=values[i]
            res=Math.max(res,maxCtbt+values[i]);

            // 更新 maxCtbt，要么沿用【0，i-1】的最值，要么是values[i]
            maxCtbt=Math.max(maxCtbt,values[i]);
            maxCtbt--; //下一次使用，i++了，所以maxCtbt要--，弥补index的diff
        }

        return res;
    }


    public int maxScoreSightseeingPair_(int[] values) {
        // 目标:max{values[j]+values[i]-(j-i)}
        // =values[j]-j+max{+values[i]+i}
        int res=Integer.MIN_VALUE;
        int maxi=0;
        for (int j = 0; j < values.length; j++) {
            res=Math.max(res,values[j]-j+maxi);
            maxi=Math.max(maxi,values[j]+j); //max{+values[i]+i}
        }
        return res;
    }

    public static void main(String[] args) {
        int[] values;

        values = new int[]{8,1,5,2,6};
//        values = new int[]{1,2};
//        values = new int[]{2,1};

        System.out.println(new T1014_maxScoreSightseeingPair().maxScoreSightseeingPair(values));

    }
}
