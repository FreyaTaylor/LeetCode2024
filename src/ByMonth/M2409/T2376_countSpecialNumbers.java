package src.ByMonth.M2409;

public class T2376_countSpecialNumbers {


    /**
     * https://leetcode.cn/problems/count-special-integers/description/
     */

    public int countSpecialNumbers(int n) {
        // 362
        int dgtNum= (int) Math.ceil(Math.log10(n+0.1)); //3

        int [] dgs = new int[dgtNum];  // 3 6 2
        int n_=n;
        for (int i = dgtNum-1; i >-1; i--) {
            dgs[i]=n_%10;
            n_/=10;
        }

        // 1-99 :9+9*9=90
        int res=0;
        long  num99=0;
        for (int i = 0;  ; i++) {
            num99=num99*10+9;
            if(n>=num99){
                int temp=9;
                int choice=9;
                for (int j = 0; j < i; j++) {
                    temp*=choice;
                    choice--;
                }
                res+=temp;

                if(n==num99){
                    return res;
                }
            }else {
                break;
            }

        }





        int[] already=new int[10];

        for (int i = 0; i < dgtNum; i++) {
            // i=0 100-299
            // i=1  300-359
            // i=2  360-362

            int curNum=dgs[i]; //6

            // i位可选
            int temp=0;
            for (int j = 0; j<curNum; j++) {
                if(already[j]==0){
                    temp++;
                }
            }

            // 分开写是因为只有一位的话，应+1-1
            if(i==dgtNum-1 && already[curNum]==0){
                temp++;// 末位置+1
            }
            if(i==0){
                temp--; // 首位不能取0
            }

            // 300-359,i+1位遍历
            int choice=10-i-1;
            for (int j = i+1; j <dgtNum ; j++) {
                temp=temp*choice;
                choice--;
            }

            res+=temp;

            already[curNum]++;

            if(already[curNum]>1){ //重复则不用往后
                return res;
            }
        }


        return res;
    }


    public static void main(String[] args) {
        System.out.println(new T2376_countSpecialNumbers().countSpecialNumbers(99));
    }
}
