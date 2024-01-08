package src.DifferentialArray;

public class T370_getModifiedArray {

    /**
     * https://leetcode.cn/problems/range-addition/
     * @param length
     * @param updates
     * @return
     */
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] diff = new int[length+1];
        for (int i = 0; i < updates.length; i++) {
            diff[updates[i][0]]+=updates[i][2];
            diff[updates[i][1]+1]-=updates[i][2];
        }
        int[] res = new int[length];
        res[0]=diff[0];
        for (int i = 1; i < length; i++) {
            res[i]=res[i-1]+diff[i];
        }
        return res;
    }


}
