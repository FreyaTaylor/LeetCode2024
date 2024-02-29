package src.StateTransition;

import java.util.*;

public class T2581_rootCount {

    /**
     * https://leetcode.cn/problems/count-number-of-possible-root-nodes/description
     *
     * 最厉害的思路：
     * 1.当根节点和某一个子节点交换位置后，新树中符合要求的边的数量的变化，只和（父子），（子父）这两条边有关--状态转化
     * 2.通过遍历树，即可验证所有节点为根节点的情况
     *
     */

    int iniCount=0;
    int res=0;
    Set<Long> set = new HashSet<>();
    List<Integer>[] map;
    public int rootCount(int[][] edges, int[][] guesses, int k) {
        int n=edges.length;
        map = new List[n+1];
//        Arrays.fill(map,new ArrayList<>());
        for (int i = 0; i < n+1; i++) {
            map[i]=new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            map[edges[i][0]].add(edges[i][1]);
            map[edges[i][1]].add(edges[i][0]);
        }


        for (int i = 0; i < guesses.length; i++) {
            set.add((long)guesses[i][0]*1000000+guesses[i][1]);
        }

        build(0,-1);
        guessTree(0,-1,iniCount,k);
        return res;

    }

    //build 构建树，此树中的有向边的数量需要累加，因此需要全局
    public void build(int root,int pre){
        System.out.println(root);
        for (int child : map[root]) {
            if(child!=pre){
                if(set.contains((long)root*1000000+child)){
                    iniCount++;
                }
                build(child,root);
            }
        }
    }

    //guessTree dfs时候，需要在走完一个分支后，下一个分支继续延续父节点对应的count，因此需要是局部变量
    public void guessTree(int root,int pre,int count,int k){
//      System.out.println(root+" "+iniCount);
        if(count>=k){
            res++;
        }

        for (int child : map[root]) {
            if(child!=pre){
                int nextCount=count;
                if(set.contains((long)root*1000000+child)){
                    nextCount--;
                }
                if(set.contains((long)child*1000000+root)) {
                    nextCount++;
                }
                guessTree(child,root,nextCount,k);
            }
        }

    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{{0,1},{1,2},{2,3},{3,4}};
        int[][] guesses = new int[][]{{1,0},{2,1},{3,2},{3,4}};
        int k = 1;

        edges = new int[][]{{0,1},{1,2},{1,3},{4,2}};
        guesses = new int[][]{{1,3},{0,1},{1,0},{2,4}};
        k = 3;

        System.out.println(new T2581_rootCount().rootCount(edges,guesses,k));
    }

}
