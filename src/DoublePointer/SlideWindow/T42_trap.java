package src.DoublePointer.SlideWindow;

public class T42_trap {
    /**
     * https://leetcode.cn/problems/trapping-rain-water/description/
     */

    public int trap(int[] height) {

        int n=height.length;
        int l=0,r=1;
        int stones=0;
        int res=0;
        while (r<n){
            if(height[r]<height[l]){
                stones+=height[r];
                r++;
            }else {
                res+=(r-l-1)*height[l]-stones;
                l=r;
                r=r+1;
                stones=0;
            }
//            System.out.println();
        }
        int mid=l;//最高
        r=n-1;
        l=r-1;
        stones=0;
        while (l>=mid){
            if(height[l]<height[r]){
                stones+=height[l];
                l--;
            }else {
                res+=(r-l-1)*height[r]-stones;
                r=l;
                l=r-1;
                stones=0;
            }
//            System.out.println();
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new T42_trap().trap(new int[]{2,3,9}));
    }
}
