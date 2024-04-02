package src.Trie;

import java.util.Arrays;

public class T2416_sumPrefixScores {
    /**
     * https://leetcode.cn/problems/sum-of-prefix-scores-of-strings/
     */

    public int[] sumPrefixScores(String[] words) {

        Trie t = new Trie();
        for (String word : words) {
            build(t,word,0);
        }

        int [] res = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            res[i]=sumCount(t,words[i],0,0);
        }

        return res;
    }

    public void build(Trie t, String s,int i){
        if(i<s.length()){
            int index=s.charAt(i)-'a';
            if(t.children[index]==null){
                t.children[index] = new Trie();
            }
            t.children[index].count++;

            build(t.children[index],s,i+1);

        }

    }

    public int sumCount(Trie t, String s, int curCount, int i){
        if(i>=s.length()){
            return curCount;
        }
        return sumCount(t.children[s.charAt(i)-'a'],s,curCount+t.children[s.charAt(i)-'a'].count,i+1);
    }



    class Trie{
        private Trie[] children;
        int count;

        public Trie(){
            children = new Trie[26];
            count=0;
        }
    }


    public static void main(String[] args) {
        String [] words = new String[]{"abc","ab","bc","b"};
        int [] res = new T2416_sumPrefixScores().sumPrefixScores(words);
        System.out.println(Arrays.toString(res));


    }

}
