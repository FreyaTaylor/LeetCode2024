package src.Other.Mock;

public class T3001_minMovesToCaptureTheQueen {

    /**
     * https://leetcode.cn/problems/minimum-moves-to-capture-the-queen/
     * one step:
     * 1.cat
     * 2.car
     * otherwise two steps
     */

    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        if ((a == e && (c != a || d < Math.min(b, f) || d > Math.max(b, f)))
                || (b == f && (d != b || c < Math.min(a, e) || c > Math.max(a, e)))
                || (Math.abs(c - e) ==Math.abs(d - f)  && ((c - e)*(b - f)  != (a - e)*(d - f)  ||  (a-e)*(c-e)<0 || Math.abs(a - e) > Math.abs(c - e) ))) {
            // 斜率=+—1 &&（车与皇后的斜率不同 || 方向不同 || 车距离更远）
            return 1;
        }
        return 2;
    }

    public static void main(String[] args) {
        System.out.println(new T3001_minMovesToCaptureTheQueen().minMovesToCaptureTheQueen(1,1,3,3,2,2));
    }


}
