package src.Uncategorized;

import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.util.*;

public class T2402_mostBooked {
    /**
     * https://leetcode.cn/problems/meeting-rooms-iii/
     */

//    public int mostBooked(int n, int[][] meetings) {
//        int[] meetingCount = new int[n];
//        Arrays.sort(meetings, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0]-o2[0];
//            }
//        });
//
//        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() { // [index,endtime]
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if(o1[1]!=o2[1]){
//                    return o1[1]-o2[1];
//                }else {
//                    return o1[0]-o2[0];
//                }
//            }
//        });
//        for (int i = 0; i < n; i++) {
//            q.add(new int[]{i,0});
//        }
//
//        for (int i = 0; i < meetings.length; i++) {
//            int come = meetings[i][0];
//            int end = meetings[i][1];
//
//            // 更新所有应该空闲的room，其结束时间设置为该meeting的开始时间
//            // 这样操作，时间复杂度为n，不太好
//            List<Integer> available = new ArrayList<>();
//            while (!q.isEmpty() && q.peek()[1]<come){
//                available.add(q.poll()[0]);
//            }
//            for (Integer integer : available) {
//                q.add(new int[]{integer,come});
//            }
//
//            int [] room = q.poll();
//            meetingCount[room[0]]++;
//            q.add(new int[]{room[0],room[1]+end-come});
//            System.out.println();
//        }
//
//        int room=-1;
//        int count=0;
//        for (int i = 0; i < n; i++) {
//            if(meetingCount[i]>count){
//                room=i;
//                count=meetingCount[i];
//            }
//        }
//
//        return room;
//    }



    public int mostBooked(int n, int[][] meetings) {
        int[] meetingCount = new int[n];
        Arrays.sort(meetings,(a,b)->Integer.compare(a[0],b[0]));

        PriorityQueue<int[]> idel = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                    return o1[0]-o2[0];
            }
        });
        for (int i = 0; i < n; i++) {
            idel.add(new int[]{i,0});
        }

        PriorityQueue<int[]> busy = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]!=o2[1]){
                    return o1[1]-o2[1];
                }else {
                    return o1[0]-o2[0];
                }
            }
        });

        for (int[] meeting : meetings) {
            int come=meeting[0];
            int end=meeting[1];

            while (!busy.isEmpty() && busy.peek()[1]<=come){
                idel.add(busy.poll());
            }

            if(!idel.isEmpty()){
                int [] room = idel.poll();
                meetingCount[room[0]]++;
                busy.add(new int[]{room[0],end});

            }else {
                int [] room = busy.poll();
                meetingCount[room[0]]++;
                busy.add(new int[]{room[0],room[1]+end-come});
            }
//            System.out.println();

        }

        int room=0;
        for (int i = 1; i < n; i++) {
            if(meetingCount[i]>meetingCount[room]){
                room=i;
            }
        }

        return room;
    }


    public static void main(String[] args) {
        int n = 3;
        int[][] meetings = new int[][]{{1,20},{2,10},{3,5},{4,9},{6,8}};

        System.out.println(new T2402_mostBooked().mostBooked(n,meetings));

    }
}
