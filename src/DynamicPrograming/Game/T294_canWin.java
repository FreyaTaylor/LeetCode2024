package src.DynamicPrograming.Game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T294_canWin {

    /**
     * https://leetcode.cn/problems/flip-game-ii/
     */
    private Map<String,Boolean> map = new HashMap<>();
    public boolean canWin(String currentState) {
//        System.out.println(currentState);

        if(map.containsKey(currentState)){
            return map.get(currentState);
        }


        int i=0;
        while (i<currentState.length()){
            while (i<currentState.length() && currentState.charAt(i)=='-'){
                i++;
            }
            int start=i;
            while (i<currentState.length() && currentState.charAt(i)=='+'){
                i++;
            }
            int end=i-1;

            // [start,end]
            if(end-start+1>=2){
                // j,j+1 j+1<=end
                for (int j = start; j <= end-1 ; j++) {
                    String temp = currentState.substring(0,j)+"--"+currentState.substring(j+2,currentState.length());
                    if(!map.containsKey(temp)){
                        map.put(temp,canWin(temp));
                    }
                    if(!map.get(temp)){
                        map.put(currentState,true);
                        return true;
                    }
                }

            }
        }

        map.put(currentState,false);
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new T294_canWin().canWin("++++"));
    }

}
