package src.ByMonth.M2408;
import java.util.ArrayList;
import java.util.List;

public class T648_replaceWords {

    /**
     * https://leetcode.cn/problems/replace-words/
     * @param dictionary
     * @param sentence
     * @return
     */
    public String replaceWords(List<String> dictionary, String sentence) {

        Trie root = new Trie();

        for (int i = 0; i < dictionary.size(); i++) {
            build(root,dictionary.get(i),0);
        }

        String[] strs=sentence.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            String s = str.trim();
            if(s.length()>0){
                int index=find(root,s,0);
                if(index>0){
                    sb.append(s.substring(0,index));
                }else {
                    sb.append(s);
                }

                sb.append(" ");
            }
        }

        sb.setLength(sb.length()-1);
        return sb.toString();
    }

    public int find(Trie root,String s,int i){

        if(i>=s.length()){
            return -1;
        }

        if(root.isLeaf==true){
            return i;
        }

        int index=s.charAt(i)-'a';
        if(root.children[index]==null){
           return -1;
        }

        return find(root.children[index],s,i+1);
    }
    public void build(Trie root,String s,int i){
        int index=s.charAt(i)-'a';
        if(root.children[index]==null){
            root.children[index]= new Trie();
        }

        if(i==s.length()-1){
            root.children[index].isLeaf=true;

        }else {
            build(root.children[index],s,i+1);
        }

    }


    class Trie{
        Trie[] children;
        boolean isLeaf;

        public Trie(){
            children = new Trie[26];
            isLeaf=false;
        }
    }


    public static void main(String[] args) {

        List<String> dictionary;
        String sentence;

        dictionary = new ArrayList<>();
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("rat");
        sentence="the cattle was rattled by the battery";


//        dictionary = new ArrayList<>();
//        dictionary.add("a");
//        dictionary.add("b");
//        dictionary.add("c");
//        sentence="aadsfasf absbs bbab cadsfafs";

        System.out.println(new T648_replaceWords().replaceWords(dictionary,sentence));

    }
}
