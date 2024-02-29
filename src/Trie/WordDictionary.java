package src.Trie;

public class WordDictionary {
    /**
     * https://leetcode.cn/problems/design-add-and-search-words-data-structure/submissions/504986708/
     */
    private Trie t;
    public WordDictionary() {
        t=new Trie();
    }

    public void addWord(String word) {
        t.build(t,word,0);
    }

    public boolean search(String word) {
        return t.search(t,word,0);
    }

    class Trie{
        private Trie[] children;
        private boolean isLeaf;

        public Trie(){
            children = new Trie[26];
        }

        public void build(Trie t, String s, int i){
            int index=s.charAt(i)-'a';
            if(t.children[index]==null){
                t.children[index] = new Trie();
            }
            if(i==s.length()-1){
                t.children[index].isLeaf=true;
            }else {
                build(t.children[index],s,i+1);
            }
        }

        public boolean search(Trie t, String s,int i){
            char c= s.charAt(i);

            if(c!='.'){
                int index=s.charAt(i)-'a';
                if(t!=null && t.children[index]!=null){
                    if(i==s.length()-1){
                        if(t.children[index].isLeaf){
                            return true;
                        }
                    }else {
                        return search(t.children[index],s,i+1);
                    }

                }
            }else {
                for (int j = 0; j < 26; j++) {
                    if(t!=null && t.children[j]!=null){
                        if(i==s.length()-1){
                            if(t.children[j].isLeaf){
                                return true;
                            }
                        }else {
                            if(search(t.children[j],s,i+1)){
                                return true;
                            }
                        }

                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");
        boolean res = obj.search("pad");
        System.out.println(res);
        res = obj.search("dad");
        System.out.println(res);
        res = obj.search(".ad");
        System.out.println(res);
        res = obj.search("b..");
        System.out.println(res);

    }
}
