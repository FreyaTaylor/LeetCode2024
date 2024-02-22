package src.Graph;

import java.util.*;

public class T127_ladderLength {

    /**
     * https://leetcode.cn/problems/word-ladder/
     *
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)){
            return 0;
        }
        if(!set.contains(beginWord)){
            wordList.add(beginWord);
        }

        Map<String,List<String>> map = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            String s=wordList.get(i);
            for (int j = 0; j < s.length(); j++) {
                String s_= s.substring(0,j)+"*"+s.substring(j+1,s.length());

                if(!map.containsKey(s)){
                    map.put(s,new ArrayList<>());
                }
                if(!map.containsKey(s_)){
                    map.put(s_,new ArrayList<>());
                }
                map.get(s).add(s_);
                map.get(s_).add(s);
            }
        }

        Deque<String> q = new ArrayDeque<>();
        q.add(beginWord);
        int step=0;
        set = new HashSet<>();
        set.add(beginWord);
        while (!q.isEmpty()){
//            System.out.println(q.toString());
            step++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur=q.removeFirst();
                if(cur.equals(endWord)){
                    return step/2+1;
                }

                List<String> temp = map.get(cur);
                if(temp!=null && temp.size()>0){
                    for (String next : temp) {
                        if(!set.contains(next)){
                            set.add(next);
                            q.addLast(next);
                        }
                    }
                }
//                System.out.println();
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(new T127_ladderLength().ladderLength("hit","hot",wordList));
    }



}
