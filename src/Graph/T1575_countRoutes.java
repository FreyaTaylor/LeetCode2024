package src.Graph;

import java.util.HashMap;
import java.util.Map;

public class T1575_countRoutes {

    /**
     * https://leetcode.cn/problems/count-all-possible-routes/
     */


    private Map<Integer,Integer> map = new HashMap<>();
    int mod = (int)Math.pow(10,9)+7;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        return dfs(locations, start, finish, fuel);

    }

    public int dfs(int[] locations, int cur, int finish, int fuel){

        if(map.containsKey(cur*1000+fuel)){
            return map.get(cur*1000+fuel);
        }

        int temp=0;
        if(cur==finish){
            temp=1;
        }

        for (int i = 0; i < locations.length; i++) {
            if (i != cur && fuel >= Math.abs(locations[i] - locations[cur])) {
                temp += dfs(locations, i, finish, fuel - Math.abs(locations[i] - locations[cur]));
                temp %=mod;
            }
        }

        map.put(cur*1000+fuel,temp);
        return temp;
    }


    public static void main(String[] args) {
        System.out.println(new T1575_countRoutes().countRoutes(
//                new int[]{2,3,6,8,4},1,3,5));
                new int[]{4,3,1},1,0,6));
    }
}
