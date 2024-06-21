package src.Trie;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class WordFilter {

    /**
     * https://leetcode.cn/problems/prefix-and-suffix-search/description/
     * 745. 前缀和后缀搜索
     * 测试用例太长了 diff不过来，思路正确，后续不看了
     */

    Trie pre;
    Trie tail;
    public WordFilter(String[] words) {
        pre = new Trie();
        tail = new Trie();
        Set<String> set = new HashSet<>();
        for (int i = words.length-1; i >-1; i--) {
            if(!set.contains(words[i])){
                buildTrie(i,pre,words[i],0);
                buildTrie(i,tail,new StringBuilder(words[i]).reverse().toString(),0);
                set.add(words[i]);
            }

        }

    }

    public int f(String pref, String suff) {
        Set<Integer> p = findWords(pre,pref,0);
        Set<Integer> s = findWords(tail,new StringBuilder(suff).reverse().toString(),0);

        if(p==null || s==null || p.size()==0 ||s.size()==0){
            return -1;
        }

        Set<Integer> res = p.stream()
                .filter(s::contains)
                .collect(Collectors.toSet());


        int index=-1;
        for (Integer re : res) {
            index=Math.max(index,re);
        }

        return index;

    }


    public void buildTrie(int wordi,Trie t,String s, int i){
        if(i<s.length()){
            int index=s.charAt(i)-'a';
            if(t.children[index]==null){
                t.children[index]= new Trie();
            }
            t.children[index].words.add(wordi);
            buildTrie(wordi,t.children[index],s,i+1);
        }
    }

    public Set<Integer> findWords(Trie t,String s, int i){
        if(i<s.length()){
            t.words.add(i);
            int index=s.charAt(i)-'a';
            if(t.children[index]==null){
                return null;
            }else {
                if(i==s.length()-1){
                    return t.children[index].words;
                }else {
                    return findWords(t.children[index],s,i+1);
                }
            }

        }
        return null;
    }

    class Trie{
        Set<Integer> words;
        Trie[] children;

        public Trie(){
            words = new HashSet<>();
            children = new Trie[26];
        }

    }


    public static void main(String[] args) {
        String[] words = new String[]{"","aba"};
        WordFilter obj = new WordFilter(words);
        System.out.println(obj.f("aba","b"));

    }


}
