package src.Graph.Union;

public class T547_findCircleNum {
    /**
     * https://leetcode.cn/problems/number-of-provinces/description/
     */
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int[] father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i]=i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(isConnected[i][j]==1){
                    if(findFather(father,i)!=findFather(father,j)){
                        union(father,i,j);
                    }
                }

            }
        }

        int count=0;
        for (int i = 0; i < n; i++) {
            if(father[i]==i){
                count++;
            }
        }
        return count;
    }

    public int findFather(int[] father,int i){
        if(father[i]!=i){
            father[i]=findFather(father,father[i]);
        }
        return father[i];
    }

    public void union(int[] father,int i,int j){
        father[father[j]]=father[i];
    }

    public static void main(String[] args) {
        int[][] isConnected = new int[][]{{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(new T547_findCircleNum().findCircleNum(isConnected));
    }

}
