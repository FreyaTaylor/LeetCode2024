package src.CornerCase;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class T676_MagicDictionary {
}

/**
 * https://leetcode.cn/problems/implement-magic-dictionary/description
 * "hello","hallo"
 */
class MagicDictionary {

    Map<String,Set> map;

    public MagicDictionary() {
        map = new HashMap<>();
    }

    public void buildDict(String[] dictionary) {

        for (String s : dictionary) {
            for (int i = 0; i < s.length(); i++) {
                String temp = s.substring(0,i)+"-"+s.substring(i+1,s.length());
                if(!map.containsKey(temp)){
                    map.put(temp,new HashSet());
                }
                map.get(temp).add(s);
            }

        }

    }

    public boolean search(String s) {

        for (int i = 0; i < s.length(); i++) {
            String temp = s.substring(0,i)+"-"+s.substring(i+1,s.length());
            if(map.containsKey(temp) &&
                    (!map.get(temp).contains(s)||map.get(temp).size()>1)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {


        MagicDictionary obj = new MagicDictionary();
        obj.buildDict(new String[]{"hello", "hlllo"});
        System.out.println(obj.search("hello"));

    }
}
