package src.Bit;

import java.util.HashMap;
import java.util.Map;

public class LCR005_maxProduct {
    /**
     * https://leetcode.cn/problems/aseY1I/
     */

    public int maxProduct(String[] words) {

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            Integer b = 0;
            for (int j = 0; j < s.length(); j++) {
                char c=s.charAt(j);
                b=b|1<<(c-'a');
            }
            map.put(b,Math.max(map.getOrDefault(b,0),s.length()));
        }

        int res=0;
        for (Integer i : map.keySet()) {
            for (Integer j : map.keySet()) {
                if((i&j)==0){
                    res=Math.max(res,map.get(i)*map.get(j));
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String[] words = {"abcw","baz","foo","bar","xtfn","abcdef"};
        System.out.println(new LCR005_maxProduct().maxProduct(words));
    }
}
