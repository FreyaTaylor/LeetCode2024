package src.Graph.Union;

import java.util.Arrays;

public class T684_findRedundantConnection_1 {

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] father = new int[n+1];
        for (int i = 1; i <n+1 ; i++) {
            father[i]=i;
        }

        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];

            if(findFather(father,x)==findFather(father,y)){
                return edges[i];
            }else {
                father[father[y]]=father[x];
            }


        }

        return new int[]{-1,-1};
    }

    public int findFather(int[] father,int i){
        if(father[i]==i){
            return i;
        }
        father[i]=findFather(father,father[i]);
        return father[i];
    }


    public static void main(String[] args) {
        int[][] edges = new int[][]{{1,2},{2,3},{3,4},{1,4},{1,5}};
        int[] res = new T684_findRedundantConnection_1().findRedundantConnection(edges);
        System.out.println(Arrays.toString(res));
    }

}
