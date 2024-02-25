package src.Graph;

import java.util.*;

public class T210_findOrder {
    /**
     * https://leetcode.cn/problems/course-schedule-ii/
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Integer> hasPre = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i,new ArrayList<>());
            hasPre.put(i,0);
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            map.get(from).add(to);
            hasPre.put(to,hasPre.get(to)+1);
        }


        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if(hasPre.get(i)==0){
                q.addLast(i);
            }
        }
        Set<Integer> visited = new HashSet<>();

        int[] res = new int[numCourses];
        int index=0;
        while (!q.isEmpty()){
            int size = q.size();
//            System.out.println(q.toString());
            for (int i = 0; i < size; i++) {
                int cur = q.removeFirst();
                res[index++]=cur;
                visited.add(cur);
                if(map.containsKey(cur) && map.get(cur).size()>0){
                    for (Integer to : map.get(cur)) {
                        if(!visited.contains(to)){
                            hasPre.put(to,hasPre.get(to)-1);
                            if(hasPre.get(to)==0){
                                q.addLast(to);
                            }
                        }
                    }
                }
            }

        }

        if(index==numCourses){
            return res;
        }else {
            return new int[]{};
        }

    }

    public static void main(String[] args) {
        int numCourses =4;
        int[][] prerequisites = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        System.out.println(Arrays.toString(new T210_findOrder().findOrder(numCourses,prerequisites)));
    }
}
