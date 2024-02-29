package src.Trie;


import java.util.*;

public class T212_findWords {
    /**
     * https://leetcode.cn/problems/word-search-ii/
     * 超时一点点,不要用List<Character> ，用StringBuilder
     */

    public List<String> findWords(char[][] board, String[] words) {
        Trie t = new Trie();
        for (int i = 0; i < words.length; i++) {
            t.build(words[i],0);
        }

        Set<String> set = new HashSet<>();
        boolean[][] visited;
        StringBuffer path;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                visited  = new boolean[board.length][board[0].length];
                path = new StringBuffer();
                dfs(set, visited,path,t,board,i,j );
            }
        }

        List<String> res = new ArrayList<>();
        for (String s : set) {
            res.add(s);
        }
        return res;
    }

    public void dfs(Set<String> set,boolean[][] visited,StringBuffer path, Trie t, char[][] board, int i, int j){
//        System.out.println(path.toString()+" "+i+" "+j);
        if(t.leaf) {
            set.add(path.toString());
        }

        if(t.children==null){
            return;
        }

        if(i>=0 && i<board.length && j>=0 && j<board[i].length && t.children[board[i][j]-'a']!=null && !visited[i][j]){
            path.append(board[i][j]);
            visited[i][j]=true;

            int[][] next = new int[][]{{i+1,j},{i-1,j},{i,j+1},{i,j-1}};
            for (int[] ints : next) {
                dfs(set,visited,path,t.children[board[i][j]-'a'],board,ints[0],ints[1]);
            } // for

            path.setLength(path.length()-1);
            visited[i][j]=false;
        }

    }

    class Trie{
        private Trie[] children;
        private boolean leaf;

        public Trie (){
            children=new Trie[26];
        }
        public void build(String s, int i){
            int index = s.charAt(i)-'a';
            if(this.children[index]==null){
                this.children[index] = new Trie();
            }
            if(i==s.length()-1){
                this.children[index].leaf=true;
            }else {
                this.children[index].build(s,i+1);
            }
        }


    }


    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}};
        String[] words = new String[]{"oath","pea","eat","rain"};

        board = new char[][]{{'a'}};
        words = new String[]{"a"};

        board = new char[][]{{'a','a'}};
        words = new String[]{"aaa"};


        board = new char[][]{
                {'a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a'},
                {'a','a','a','a','a','a','a','a','a','a','a','a'}};
        words = new String[]{"lllllll","fffffff","ssss","s","rr","xxxx","ttt","eee","ppppppp","iiiiiiiii","xxxxxxxxxx","pppppp","xxxxxx","yy","jj","ccc","zzz","ffffffff","r","mmmmmmmmm","tttttttt","mm","ttttt","qqqqqqqqqq","z","aaaaaaaa","nnnnnnnnn","v","g","ddddddd","eeeeeeeee","aaaaaaa","ee","n","kkkkkkkkk","ff","qq","vvvvv","kkkk","e","nnn","ooo","kkkkk","o","ooooooo","jjj","lll","ssssssss","mmmm","qqqqq","gggggg","rrrrrrrrrr","iiii","bbbbbbbbb","aaaaaa","hhhh","qqq","zzzzzzzzz","xxxxxxxxx","ww","iiiiiii","pp","vvvvvvvvvv","eeeee","nnnnnnn","nnnnnn","nn","nnnnnnnn","wwwwwwww","vvvvvvvv","fffffffff","aaa","p","ddd","ppppppppp","fffff","aaaaaaaaa","oooooooo","jjjj","xxx","zz","hhhhh","uuuuu","f","ddddddddd","zzzzzz","cccccc","kkkkkk","bbbbbbbb","hhhhhhhhhh","uuuuuuu","cccccccccc","jjjjj","gg","ppp","ccccccccc","rrrrrr","c","cccccccc","yyyyy","uuuu","jjjjjjjj","bb","hhh","l","u","yyyyyy","vvv","mmm","ffffff","eeeeeee","qqqqqqq","zzzzzzzzzz","ggg","zzzzzzz","dddddddddd","jjjjjjj","bbbbb","ttttttt","dddddddd","wwwwwww","vvvvvv","iii","ttttttttt","ggggggg","xx","oooooo","cc","rrrr","qqqq","sssssss","oooo","lllllllll","ii","tttttttttt","uuuuuu","kkkkkkkk","wwwwwwwwww","pppppppppp","uuuuuuuu","yyyyyyy","cccc","ggggg","ddddd","llllllllll","tttt","pppppppp","rrrrrrr","nnnn","x","yyy","iiiiiiiiii","iiiiii","llll","nnnnnnnnnn","aaaaaaaaaa","eeeeeeeeee","m","uuu","rrrrrrrr","h","b","vvvvvvv","ll","vv","mmmmmmm","zzzzz","uu","ccccccc","xxxxxxx","ss","eeeeeeee","llllllll","eeee","y","ppppp","qqqqqq","mmmmmm","gggg","yyyyyyyyy","jjjjjj","rrrrr","a","bbbb","ssssss","sss","ooooo","ffffffffff","kkk","xxxxxxxx","wwwwwwwww","w","iiiiiiii","ffff","dddddd","bbbbbb","uuuuuuuuu","kkkkkkk","gggggggggg","qqqqqqqq","vvvvvvvvv","bbbbbbbbbb","nnnnn","tt","wwww","iiiii","hhhhhhh","zzzzzzzz","ssssssssss","j","fff","bbbbbbb","aaaa","mmmmmmmmmm","jjjjjjjjjj","sssss","yyyyyyyy","hh","q","rrrrrrrrr","mmmmmmmm","wwwww","www","rrr","lllll","uuuuuuuuuu","oo","jjjjjjjjj","dddd","pppp","hhhhhhhhh","kk","gggggggg","xxxxx","vvvv","d","qqqqqqqqq","dd","ggggggggg","t","yyyy","bbb","yyyyyyyyyy","tttttt","ccccc","aa","eeeeee","llllll","kkkkkkkkkk","sssssssss","i","hhhhhh","oooooooooo","wwwwww","ooooooooo","zzzz","k","hhhhhhhh","aaaaa","mmmmm"};

        List<String> res = new T212_findWords().findWords(board,words);
        System.out.println(res.toString());

    }
}
