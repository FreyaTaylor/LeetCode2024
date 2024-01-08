package src.DoublePointer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class T3_Offer48_lengthOfLongestSubstring {
    /**
     * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
     * 无重复字符的最长子串
     * @param s
     * @return
     */

//    public int lengthOfLongestSubstring(String s) {
//        int maxlen = 0;
//        int l=0,r=0;
//        Set<Character> set = new HashSet<>(); // [l,r)
//
//        while (r<s.length()){
//            char c = s.charAt(r);
//
//            if(!set.contains(c)){
//                set.add(c);
//                r++;
//                // 这两行是指针遍历到r的基本操作
//            }else {
//                maxlen=Math.max(maxlen,r-l);
//                while (s.charAt(l)!=c){
//                    set.remove(s.charAt(l));
//                    l++;
//                }
//                set.remove(s.charAt(l));
//                l++;
//                //处理边界条件时候的l左移
//
//                set.add(c);
//                r++;
//                // 这两行是指针遍历到r的基本操作
//            }
//        }
//        maxlen=Math.max(maxlen,r-l); //当r<s.length()时候，也需要处理此时的长度
//
//        return maxlen;
//    }

    public int lengthOfLongestSubstring(String s) {
        int maxlen = 0;
        int l=0,r=0;
        Set<Character> set = new HashSet<>(); // [l,r)

        while (r<s.length()){
            char c = s.charAt(r);
            if(set.contains(c)){
                maxlen=Math.max(maxlen,r-l);
                while (s.charAt(l)!=c){
                    set.remove(s.charAt(l));
                    l++;
                }
                set.remove(s.charAt(l));
                l++;
                //处理边界条件时候的l左移
            }
            set.add(c);
            r++;
            // 这两行是指针遍历到r的基本操作
        }
        maxlen=Math.max(maxlen,r-l); //当r<s.length()时候，也需要处理此时的长度

        return maxlen;
    }

    public static void main(String[] args) {
        System.out.println(new T3_Offer48_lengthOfLongestSubstring().lengthOfLongestSubstring("pwwkew"));
    }

}
