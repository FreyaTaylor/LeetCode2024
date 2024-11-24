package src.DifferentialArray;

import java.util.Arrays;

public class T370_getModifiedArray_1 {

    /**
     * https://leetcode.cn/problems/range-addition/
     * @param length
     * @param updates
     * @return
     */
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res=new int[length];

        Arrays.fill(res,0);

        for (int[] update : updates) {
            int from=update[0];
            int to=update[1];
            int add=update[2];

            res[from]+=add;
            if(to+1<length){
                res[to+1]-=add;
            }
        }

        for (int i = 1; i <length ; i++) {
            res[i]=res[i-1]+res[i];
        }

        return res;
    }


}
