package src.Uncategorized;

public class T2186_minSteps {

    /**
     * https://leetcode.cn/problems/minimum-number-of-steps-to-make-two-strings-anagram-ii/
     */

    public int minSteps(String s, String t) {

        int[] ss = new int[26];
        int[] tt = new int[26];

        for (int i = 0; i < s.length(); i++) {
            ss[s.charAt(i)-'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            tt[t.charAt(i)-'a']++;
        }

        int res=0;
        for (int i = 0; i < 26; i++) {
            res+=Math.abs(ss[i]-tt[i]);
        }
        return res;
    }



}
