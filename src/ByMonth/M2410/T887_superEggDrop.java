package src.ByMonth.M2410;

import javax.imageio.metadata.IIOMetadataFormatImpl;

public class T887_superEggDrop {

    /**
     * https://leetcode.cn/problems/super-egg-drop/?envType=daily-question&envId=2024-10-14
     *
     * 1.KNN，但是[i,i+k]==[j,k+k]只和范围大小有关，降级为KN
     * 2.遍历时，f=h+g,h升g降，可二分？？？这样并不严谨
     */

    public int superEggDrop(int k, int n) {

        int[][] dp = new int[k+1][n+1];
        for (int i = 1; i < n+1; i++) {
            dp[1][i]=i;
        }

        for (int i = 2; i < k+1; i++) {
            for (int j = 1; j <n+1 ; j++) {
//                int temp=Integer.MAX_VALUE;
//                for (int l = 1; l <=j ; l++) {
//                    temp=Math.min(temp,1+Math.max(dp[i-1][l-1],dp[i][j-l]));
//                }
//                dp[i][j]=temp;

                int l=1,r=j;
                // 第一个》=
                while (l<r){
                    int mid=(r+l)/2;
                    if(dp[i-1][mid-1]>dp[i][j-mid]){
                        r=mid-1;
                    }else if (dp[i-1][mid-1]<dp[i][j-mid]){
                        l=mid+1;
                    }else {
                        l=mid;
                        r=mid;
                    }
                }

                dp[i][j]=1+Math.max(dp[i-1][l-1],dp[i][j-l]);

            }

//            System.out.println();
        }


        return dp[k][n];
    }

    public static void main(String[] args) {
        System.out.println(new T887_superEggDrop().superEggDrop(2,6));
    }
}
