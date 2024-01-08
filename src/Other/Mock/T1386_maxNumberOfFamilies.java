package src.Other.Mock;

import javax.print.DocFlavor;
import java.util.*;

public class T1386_maxNumberOfFamilies {

    /**
     * https://leetcode.cn/problems/cinema-seat-allocation/
     * 2 3 : A
     * 4 5   B
     * 6 7   C
     * 8 9   D
     * @param n
     * @param reservedSeats
     * @return
     */
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Character>> map = new HashMap<>();
        Map<Integer,Character> mapping  = new HashMap<>(); // 将每一排位置映射为区域，只有这8个座位映射成的4个区域影响安排结果
        mapping.put(2,'A');
        mapping.put(3,'A');
        mapping.put(4,'B');
        mapping.put(5,'B');
        mapping.put(6,'C');
        mapping.put(7,'C');
        mapping.put(8,'D');
        mapping.put(9,'D');

        for (int i = 0; i < reservedSeats.length; i++) {
            int key = reservedSeats[i][0];
            if(mapping.containsKey(reservedSeats[i][1])){
                if(!map.containsKey(key)){
                    map.put(key,new HashSet<>());
                }
                map.get(key).add(mapping.get(reservedSeats[i][1])); // 构造
            }

        }

        int res = (n-map.size())*2; //空排
        for(int key:map.keySet()){
            Set<Character> temp = map.get(key);
            if(temp.size()==1){ //一个区域，不管是具体哪个，res+1
                res++;
            }else if(temp.size()==2){
                if((temp.contains('A') && temp.contains('B'))
                 ||(temp.contains('C') && temp.contains('D'))
                 ||(temp.contains('A') && temp.contains('D'))){
                    res++; // 2个区域，这三种情况，res+1
                }
            }
        }

        return res;
    }

}
