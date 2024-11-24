package src.ByMonth.M2410;

import java.util.*;

public class _T2092_findAllPeople {
    /**
     * https://leetcode.cn/problems/find-all-people-with-secret/
     * 并查集太慢了，这里其实只需要【包含知道秘密成员】的集合就好了，
     */

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

        Map<Integer, Set<int[]>> map = new HashMap<>();
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        for (int[] meeting : meetings) {
            if(!map.containsKey(meeting[2])){
                map.put(meeting[2],new HashSet<>());
                q.add(meeting[2]);
            }
            map.get(meeting[2]).add(new int[]{meeting[0],meeting[1]});
        }


        Set<Integer> res = new HashSet<>();
        res.add(0);
        res.add(firstPerson);

        while (!q.isEmpty()){
            Set<int[]> curMeetings = map.get(q.poll());
            spread(res,curMeetings);
        }

        return new ArrayList<>(res);
    }


    public void spread(Set<Integer> res,Set<int[]> curMeetings){
        Deque<Integer> q = new ArrayDeque<>();

        Map<Integer,Set<Integer>> map = new HashMap<>();
        for (int[] curMeeting : curMeetings) {
            int x=curMeeting[0];
            int y=curMeeting[1];

            if(!map.containsKey(x)){
                map.put(x,new HashSet<>());
            }
            if(!map.containsKey(y)){
                map.put(y,new HashSet<>());
            }

            map.get(x).add(y);
            map.get(y).add(x);
        }


        for (Integer re : res) {
            q.addLast(re);
        }

        while (!q.isEmpty()){
            int size=q.size();
            for (int i = 0; i < size; i++) {
                int cur =q.removeFirst();
                if(map.containsKey(cur) && map.get(cur).size()>0){
                    for (Integer integer : map.get(cur)) {
                        if(!res.contains(integer)){
                            q.addLast(integer);
                            res.add(integer);
                        }
                    }
                }
            }

        }


    }









    public static void main(String[] args) {
        int n = 5;
        int[][]meetings = new int[][]{{3,4,2},{1,2,1},{2,3,1}};
        int  firstPerson = 1;


        n = 4;
        meetings = new int[][]{{3,1,3},{1,2,2},{0,3,3}};
        firstPerson = 3;

        System.out.println(new _T2092_findAllPeople().findAllPeople(n,meetings,firstPerson));
//
//        Set<Integer> s1 = new HashSet<>();
//        s1.add(1);
//        s1.add(2);
//
//        Set<Integer> s2 = new HashSet<>();
//        s2.add(3);
//        s2.add(4);
//
//        System.out.println(s1.retainAll(s2) && s1.size()>0);
//
    }


}
