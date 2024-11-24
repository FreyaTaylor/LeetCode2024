package src.ByMonth.M2408;

import java.util.Arrays;
import java.util.Comparator;

public class T2589_findMinimumTime {
    /**
     * https://leetcode.cn/problems/minimum-time-to-complete-all-tasks
     *
     * 贪心：
     * 先按照结束时间排序
     * 记录一个cpu数组，1为开0为关闭
     * 每处理一个任务，先检查当前任务是否可完成
     * 如果cpu数据满足，则可完成，否则，【从右往左添1，使得新添加的1尽可能被后面的任务用到】
     * （如果是按照开始时间，应该是开始时间从大到小排序，然后优先填充左，使得有序任务尽可能用上新添的1！！！）
     */

    public int findMinimumTime(int[][] tasks) {
        int[]cpu = new int[2001];
        Arrays.sort(tasks, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        for (int i = 0; i < tasks.length; i++) {

            int start=tasks[i][0];
            int end=tasks[i][1];
            int dur=tasks[i][2];

            int sum=0;
            for (int j = start; j <=end ; j++) {
                sum+=cpu[j];
            }

            if(sum<dur){
                int j = end;
                while (sum<dur) {
                    if(cpu[j]==0){
                        cpu[j]=1;
                        sum++;
                    }
                    j--;
                }
            }

        }



        int sum=0;
        for (int i = 0; i <2001 ; i++) {
            sum+=cpu[i];
        }


        return sum;
    }

    public static void main(String[] args) {
        int[][]tasks = new int[][]{{1,18,5},{3,15,1}};
        System.out.println(new T2589_findMinimumTime().findMinimumTime(tasks));

    }
}

