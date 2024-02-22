package src.Graph.Union;

import java.util.Arrays;

public class T684_findRedundantConnection {
    /**
     * https://leetcode.cn/problems/redundant-connection/
     */
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        int[] father = new int[n+1];
        for (int i = 1; i <n+1 ; i++) {
            father[i]=i;
        }

        for (int i = 0; i < n; i++) {
            int a=edges[i][0];
            int b=edges[i][1];
            if(findFather(father,a)==findFather(father,b)){
                return edges[i];
            }
            union(father,a,b);
        }

        return new int[]{};
    }

    public int findFather(int[] father,int i){
        if(father[i]!=i){
            father[i]=findFather(father,father[i]); //路径压缩，i的祖先节点的father都被置为“最终祖先”
        }
        return father[i];
    }
    public void union(int[] father,int i,int j){
        father[father[j]]=father[i]; //因为i和j的father，已经是“最终祖先”了
    }


    public static void main(String[] args) {
        int[][] edges = new int[][]{{1,2},{2,3},{3,4},{1,4},{1,5}};
        int[] res = new T684_findRedundantConnection().findRedundantConnection(edges);
        System.out.println(Arrays.toString(res));
    }

}
