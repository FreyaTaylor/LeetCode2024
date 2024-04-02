package src.Uncategorized;

public class T264_nthUglyNumber {
    /**
     * https://leetcode.cn/problems/ugly-number-ii/
     *
     * 新的丑数，必然是旧的丑数构造的，旧的丑数*2/3/5必然是新丑数
     * 新旧排序遍历
     */
    int nthUglyNumber(int n) {
        int[] ugly = new int[n+1];
        ugly[1]=1;
        int p2=1,p3=1,p5=1;
        for (int i = 1; i <n ; i++) {
            int n2=ugly[p2]*2;
            int n3=ugly[p3]*3;
            int n5=ugly[p5]*5;

            int nextNum=Math.min(Math.min(n2,n3),n5);
            if(nextNum==n2){
                p2++;
            }
            if(nextNum==n3){
                p3++;
            }
            if(nextNum==n5){
                p5++;
            }
            ugly[i+1]=nextNum;
        }

        return ugly[n];
    }

    public static void main(String[] args) {
        System.out.println(new T264_nthUglyNumber().nthUglyNumber(10));
    }
}
