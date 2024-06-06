package src.DoublePointer.SlideWindow;

import com.sun.jdi.PathSearchingVirtualMachine;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class T76_minWindow {

    /**
     * https://leetcode.cn/problems/minimum-window-substring/
     */
    public String minWindow(String s, String t) {

        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put((char)(i+'A'),i);
            map.put((char)(i+'a'),i+26);
        }

        int[] tc = new int[52];
        for (int i = 0; i < t.length(); i++) {
            tc[map.get(t.charAt(i))]++;
        }
        int[] sc = new int[52];
        int diff=t.length();

        int l=0,r=0;
        String res=s+"#";
        while (r<s.length()){

            int index = map.get(s.charAt(r));

            // 右移r至符合要求
            sc[index]++;
            if(sc[index]<=tc[index]){
                diff--;
            }

            // check
            if(diff==0){
                // 左移l至不符合 [l,r]不符合
                while (diff==0){
                    index = map.get(s.charAt(l++));
                    sc[index]--;

                    if(sc[index]<tc[index]){
                        diff++;
                    }
                }
                // 记录 [l-1,r]
                if(r-l+2<res.length()){
                    res=s.substring(l-1,r+1);
                }
            }

            // [l,r]
            r++;
        }


        if(res.length()==s.length()+1){
            return "";
        }

        return res;
    }

    public static void main(String[] args) {
//        String s = "ADOBECODEBANC", t = "ABC";
//        String s = "aa", t = "aa";
        String s = "cabeca", t = "cae";

        System.out.println(new T76_minWindow().minWindow(s,t));
    }
}
