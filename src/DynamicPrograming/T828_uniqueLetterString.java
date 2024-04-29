package src.DynamicPrograming;

import javax.print.DocFlavor;
import java.util.*;

public class T828_uniqueLetterString {

    /**
     * https://leetcode.cn/problems/count-unique-characters-of-all-substrings-of-a-given-string
     * 超时！
     */

    public int uniqueLetterString(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();
        // 边界 -1 。。。。s.length()
        for (int i = 0; i < 26; i++) {
            map.put((char) (i+'A'),new ArrayList<>());
            map.get((char) (i+'A')).add(-1);
        }


        for (int i = 0; i < s.length(); i++) {
            map.get(s.charAt(i)).add(i);
        }

        for (int i = 0; i < 26; i++) {
            map.get((char) (i+'A')).add(s.length());
        }

        int res = 0;
        for (Character c : map.keySet()) {

            for (int i = 1; i < map.get(c).size()-1; i++) {
                int pre = map.get(c).get(i)-map.get(c).get(i-1)-1; //距离上边界有几个元素
                int next = map.get(c).get(i+1)-map.get(c).get(i)-1; //距离下边界有几个元素
                // 前+后+单一+中间
                res+=pre+next+1+pre*next;
            }

        }

        return res;
    }



//    public int uniqueLetterString(String s) {
//
//        int n = s.length();
//        int res = n;
//
//        for (int len = 2; len <=n ; len++) {
//
//            int[] counts = new int[26];
//            for (int i = 0; i < len ; i++) {
//                counts[s.charAt(i)-'A']++;
//            }
//
//            int last=0;
//            for (int i = 0; i < 26; i++) {
//                if(counts[i]==1){
//                    last++;
//                }
//            }
//            res+=last;
//
//            for (int i = 1; i+len-1 <n ; i++) {
//
//                char remove = s.charAt(i-1);
//                char add = s.charAt(i+len-1);
//
//                if(remove==add){
//                    res+=last;
//                    continue;
//                }
//
//                counts[remove-'A']--;
//                counts[add-'A']++;
//
//                if(counts[remove-'A']==0){
//                    last--;
//                }else if(counts[remove-'A']==1) {
//                    last++;
//                }
//
//                if(counts[add-'A']==1){
//                    last++;
//                }else if(counts[add-'A']==2){
//                    last--;
//                }
//
//
//                res+=last;
//            }
//
////            System.out.println(res);
//        }
//
//        return res;
//    }





    public static void main(String[] args) {
        System.out.println(new T828_uniqueLetterString().uniqueLetterString( "LEETEE"));
    }
}
