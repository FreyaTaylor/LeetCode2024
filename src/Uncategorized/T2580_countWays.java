package src.Uncategorized;

import java.util.Arrays;
import java.util.Comparator;

public class T2580_countWays {

    /**
     * https://leetcode.cn/problems/count-ways-to-group-overlapping-ranges
     */
    public int countWays(int[][] ranges) {
        Arrays.sort(ranges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        int i=0;
        int r=ranges[0][1];
        int count=0;
        while (i<ranges.length){
            while (i<ranges.length && ranges[i][0]<=r){
                r=Math.max(r,ranges[i][1]);
                i++;
            }
            count++;
            if(i<ranges.length){
                r=ranges[i][1];
            }
        }


        System.out.println(count);
        count=87;
        long a=count;
        long b=1;
        int res=2;
        for (int j = 1; j <=count/2 ; j++) {
            System.out.println(a+"  "+b);
            if(count-j==j){
                res+=a/b;
            }else {
                res+=2*(a/b);
            };

            a=a*(count-j);
            b=b*(j+1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] ranges = new int[][]{{1,3},{10,20},{2,5},{4,8}};
        System.out.println(new T2580_countWays().countWays(ranges));
    }
}
