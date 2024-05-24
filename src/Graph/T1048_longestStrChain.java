package src.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T1048_longestStrChain {

    /**
     * https://leetcode.cn/problems/longest-string-chain/
     */

    public int longestStrChain(String[] words) {

        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> dp = new HashMap<>();

        for (String word : words) {
            //
            for (int i = 0; i < word.length(); i++) {
                String tempPre= word.substring(0, i) + "*" + word.substring(i+1, word.length());
                if(!map.containsKey(tempPre)){
                    map.put(tempPre,new ArrayList<>());
                }
                map.get(tempPre).add(word);
            }

            //
            if(!map.containsKey(word)){
                map.put(word,new ArrayList<>());
            }
            for (int i = 0; i < word.length(); i++) {
                String tempNext= word.substring(0, i+1) + "*" + word.substring(i+1, word.length());
                map.get(word).add(tempNext);
            }
            map.get(word).add("*"+word);
//            System.out.println();
        }


        int maxLen=Integer.MIN_VALUE;
        for (String word : words) {
            maxLen=Math.max(maxLen,dfs(dp,map,word,1));
        }

        return maxLen/2;
    }

    public int dfs(Map<String, Integer> dp, Map<String, List<String>> map, String cur, int pathLen){

        if(dp.containsKey(cur)){
            return dp.get(cur);
        }

        int temp=Integer.MIN_VALUE;
        if(!map.containsKey(cur)){
            temp=0;
        }else {
            for (String next : map.get(cur)) {
                temp=Math.max(temp,dfs(dp,map,next,1));
            }
        }

        temp+=pathLen;
        dp.put(cur,temp);
        return temp;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"a","b","ba","bca","bda","bdca"};

        words = new String[]{"xbc","pcxbcf","xb","cxbc","pcxbc"};

        System.out.println(new T1048_longestStrChain().longestStrChain(words));
    }
}
