package src.DoublePointer.LeftRightMax;

public class T11_maxArea {

    /**
     * https://leetcode.cn/problems/container-with-most-water/
     */

    public int maxArea(int[] height) {
        int l=0;
        int r=height.length-1;
        int area = 0;
        while (l<r){
            area=Math.max(area,Math.min(height[l],height[r])*(r-l));
            if(height[l]<height[r]){
                l++;
            }else if(height[l]>height[r]){
                r--;
            }else {
                l++;
                r--;
            }
        }

        return area;
    }

    public static void main(String[] args) {
        System.out.println(new T11_maxArea().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
