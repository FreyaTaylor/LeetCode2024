package src.Uncategorized;

import src.BinaryTree.T1902_maxDepthBST;

import java.util.Arrays;

public class T1964_longestObstacleCourseAtEachPosition {
    /**
     * https://leetcode.cn/problems/find-the-longest-valid-obstacle-course-at-each-position/
     */

    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int[] res = new int[n];
        int[] sort = new int[n];

        res[0]=1;
        sort[0]=obstacles[0];
        int index=0;
//        System.out.println(Arrays.toString(sort));

        for (int i = 1; i <n ; i++) {
            int j = index;
            while (j>=0 && sort[j]>obstacles[i]){
                j--;

            }

            res[i]=j+2;
            sort[j+1]=obstacles[i];

            if(j==index){
                index++;
            }
//            System.out.println(Arrays.toString(sort));

        }


        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new T1964_longestObstacleCourseAtEachPosition().longestObstacleCourseAtEachPosition(
                new int[]{2,2,1}
//                new int[]{3,1,5,6,4,2}
        )));
    }
}
