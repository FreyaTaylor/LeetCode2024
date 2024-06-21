package src.DFS.Hard;

import java.util.ArrayList;
import java.util.List;

public class T140_wordBreak {

    /**
     * https://leetcode.cn/problems/word-break-ii/description/
     * DFS+字典树
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();

        Trie t = new Trie();
        for (String str : wordDict) {
            buildTrie(t,str,0);
        }

        dfs(res,new StringBuilder(),s,t,0);
        return res;
    }

    public void dfs(List<String> res, StringBuilder sb, String s,Trie t,  int cur){
        // 1.cur为将要探索的位置

        // 2.满足要求条件
        if(cur==s.length()){
            sb.setLength(sb.length()-1);
            res.add(sb.toString());
        }

        // 3.下一步可拓展的位置
        List<Integer> indexs = new ArrayList<>();
        findWord(indexs,t,s,cur);

        int len=sb.length();

        // 4.处理【下一步】
        for (Integer nextCur : indexs) {
            sb.append(s.substring(cur,nextCur));
            sb.append(" ");
            dfs(res,sb,s,t,nextCur);
            // 5.dfs 回退
            sb.setLength(len);
        }


    }

    public void findWord(List<Integer> indexs, Trie t, String s,int i){

        if(t==null){
            return;
        }

        if(t.isLeaf){
            indexs.add(i);
        }

        if(i<s.length()){
            findWord(indexs,t.children[s.charAt(i)-'a'],s,i+1);
        }

    }

    public void buildTrie(Trie t, String s,int i){
        int index=s.charAt(i)-'a';

        if(t.children[index]==null){
            t.children[index] = new Trie();
        }

        if(i==s.length()-1){
            t.children[index].isLeaf=true;
        }else {
            buildTrie(t.children[index],s,i+1);
        }
    }



    class Trie{
        Trie[] children;
        boolean isLeaf;

        public Trie() {
            this.children = new Trie[26];
            this.isLeaf = false;
        }
    }


    public static void main(String[] args) {
        String s = "catsanddog";
        String[] wordDict_ = {"cat","cats","and","sand","dog"};

        List<String> wordDict = new ArrayList<>();
        for (String string : wordDict_) {
            wordDict.add(string);
        }


        System.out.println(new T140_wordBreak().wordBreak(s,wordDict));

    }
}
