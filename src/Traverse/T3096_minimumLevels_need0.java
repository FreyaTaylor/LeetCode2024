package src.Traverse;

public class T3096_minimumLevels_need0 {

    /**
     * https://leetcode.cn/problems/minimum-levels-to-gain-more-points/description/
     * @param possible
     * @return
     */
    public int minimumLevels(int[] possible) {
        int n=possible.length;
        int[] score = new int[n+1];
        int sum=0;

        for (int i = 1; i <n+1 ; i++) {
            if(possible[i-1]==1){
                score[i]=score[i-1]+1;
                sum+=1;
            }else {
                score[i]=score[i-1]-1;
                sum-=1;
            }

        }

        // -3/2=-1
        int need = (int) Math.floor(sum/2.0);

        for (int i = 1; i <n ; i++) {
            if(score[i]>need){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        System.out.println(new T3096_minimumLevels_need0().minimumLevels(new int[]{0,0,0}));
    }


}
