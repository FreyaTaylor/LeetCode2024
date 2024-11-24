package src.Graph.Union;

public class T216_validTree {
    /**
     * https://leetcode.cn/problems/graph-valid-tree/description/
     */
    public boolean validTree(int n, int[][] edges) {

        if(edges.length+1!=n){
            return false;
        }

        int[] father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i]=i;
        }

        for (int[] edge : edges) {
            int x=edge[0];
            int y=edge[1];

            if(findFather(father,x)!=findFather(father,y)){
                union(father,x,y);
            }else {
                return false;
            }

        }

        return true;
    }

    public int findFather(int[] father,int i){
        if(father[i]!=i){
            father[i]=findFather(father,father[i]);
        }
        return father[i];
    }

    public void union(int[] father,int i,int j){
        father[father[i]]=father[j];

    }



}
