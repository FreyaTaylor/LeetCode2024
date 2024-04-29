package src.DynamicPrograming.MemorySearch;

import java.util.HashMap;
import java.util.Map;

public class T1444_ways {

    /**
     * https://leetcode.cn/problems/number-of-ways-of-cutting-a-pizza/
     */

    Map<Integer,Integer> dp = new HashMap<>(); //[i,j]到[row-1,col-1] 分给k个人，有几种方式
    int mod = (int) Math.pow(10,9)+7;
    public int ways(String[] pizza, int k) {

        int row = pizza.length;
        int col = pizza[0].length();
        char[][] pz = new char[row][col];

        int sumApple=0;
        for (int i = 0; i < row; i++) {
            pz[i]=pizza[i].toCharArray();
            for (int j = 0; j < col; j++) {
                if(pz[i][j]=='A'){
                    sumApple++;
                }
            }
        }

        int[][] apples = new int[row+1][col+1];
        for (int i = row-1; i > -1; i--) {
            for (int j = col-1; j >-1; j--) {
                apples[i][j]=apples[i+1][j]+apples[i][j+1]-apples[i+1][j+1];
                if(pz[i][j]=='A'){
                    apples[i][j]++;
                }
            }
        }

        int res = helper(apples,row,col,0,0,k,sumApple);
        return res;
    }

    public int helper(int[][] apples, int row, int col, int i, int j, int k, int leftApple){
        System.out.println(i+" "+j+" "+k);

        if(dp.containsKey(i*10000+j*100+k)){
            return dp.get(i*10000+j*100+k);
        }


        if(leftApple<k){
            dp.put(i*10000+j*100+k,0);
            return 0;
        }

        if(k==1){
            dp.put(i*10000+j*100+k,1);
            return 1;
        }

        int temp=0;

        // 横切
        for (int nexti = i+1; nexti < row ; nexti++) {
            int leftApple_ = apples[nexti][j];
            if (leftApple>leftApple_ && leftApple_>-k-1){ //第一个人有苹果
                int nextWays = helper(apples,row,col,nexti,j,k-1,leftApple_);
                if(nextWays>0){ //只有前面的切法，使得后续可分，后续切才可行，不然下一刀就不够分了
                    temp=(temp+nextWays)%mod;
                }else {
                    break;
                }
            }
        }

        // 竖切
        for (int nextj = j+1; nextj <col ; nextj++) {
            int leftApple_ = apples[i][nextj];
            if (leftApple>leftApple_ && leftApple_>=k-1){//第一个人有苹果
                int nextWays = helper(apples,row,col,i,nextj,k-1,leftApple_);
                if(nextWays>0){ //只有前面的切法，使得后续可分，后续切才可行，不然下一刀就不够分了
                    temp=(temp+nextWays)%mod;
                }else {
                    break;
                }
            }
        }

        dp.put(i*10000+j*100+k,temp);
        return temp;
    }



    public static void main(String[] args) {
        String[] pizza = new String[]{"A..","AAA","..."};
        int k = 3;
        System.out.println(new T1444_ways().ways(pizza,k));
    }
}
