package src.Graph.Topology;

import java.util.*;

public class T207_canFinish {

    /**
     * https://leetcode.cn/problems/course-schedule/
     *
     * DFS
     */

    boolean circle = false;
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            if(!map.containsKey(prerequisites[i][0])){
                map.put(prerequisites[i][0],new ArrayList<>());
            }
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        Deque<Integer> q = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        Set<Integer> ing = new HashSet<>();

        for (Integer i : map.keySet()) {
            dfs(q,set,map,i,ing );
            if(circle){
                return false;
            }
        }

        return true;
    }

    public void dfs(Deque<Integer> q,Set<Integer> set, Map<Integer, List<Integer>> map, int cur, Set<Integer> ing ){


        if(set.contains(cur)){
            return;
        }

        ing.add(cur);

        if(map.containsKey(cur)){
            List<Integer> next = map.get(cur);
            for (Integer i : next) {
                if(ing.contains(i)){
                    circle=true;
                    return;
                }
                dfs(q,set,map,i,ing);
            }
        }

        q.addLast(cur);
        set.add(cur);
        ing.remove(cur);
    }



    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1,0}};


        prerequisites = new int[][]{{1,0},{0,1}};


        System.out.println(new T207_canFinish().canFinish(numCourses,prerequisites));
    }



}
