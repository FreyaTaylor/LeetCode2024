package src.ByMonth.M2411;

public class T3208_numberOfAlternatingGroups {
    /**
     * https://leetcode.cn/problems/alternating-groups-ii/?envType=daily-question&envId=2024-11-27
     */

    public int numberOfAlternatingGroups(int[] colors, int k) {

        int l=0,r=1;
        int n=colors.length;
        int count=0;

        while (l<n){
            // l r-1 验证r
            while (colors[r%n]!=colors[(r-1)%n] && r-l<k){
                r++;
            }
            // l r-1=r

            if(r-l==k){
                count++;
                l++;
            }else {
                l=r;
                r++;
            }

        }

        return count;
    }

    public static void main(String[] args) {

        int[] colors = new int[]{0,1,0,1,0};
        int k = 3;


        colors = new int[]{0,1,0,0,1,0,1};
        k = 6;

        System.out.println(new T3208_numberOfAlternatingGroups().numberOfAlternatingGroups(colors,k));
    }
}
