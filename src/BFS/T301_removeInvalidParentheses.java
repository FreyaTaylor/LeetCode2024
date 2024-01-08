package src.BFS;

import java.util.*;

public class T301_removeInvalidParentheses {

    /**
     * https://leetcode.cn/problems/remove-invalid-parentheses/description/
     * @param
     * @return
     * 思路：先找到，字符串需要刪除多少左，右括號才可以。（這一步科學性需要驗證，這一步不做也可，因爲總可以通過bfs找到！）
     * 然後，bfs，注意查重
     * 最後要check
    */
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        Deque<String> q = new ArrayDeque<>();
        Set<String> set=new HashSet<>();
        q.addLast(s);
        set.add(s);
        int needRemoveRight=rCount(s);
        int needRemoveLeft=lCount(s);


        for (int i = 0; i < needRemoveLeft; i++) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                String cur=q.removeFirst();
                for (int k = 0; k < cur.length(); k++) {
                    if(cur.charAt(k)=='('){
                        String temp = cur.substring(0,k)+cur.substring(k+1,cur.length());
                        if(!set.contains(temp)){
                            q.addLast(temp);
                            set.add(temp);
                        }

                    }
                }

            }
        }

        for (int i = 0; i < needRemoveRight; i++) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                String cur=q.removeFirst();
                for (int k = 0; k < cur.length(); k++) {
                    if(cur.charAt(k)==')'){
                        String temp=cur.substring(0,k)+cur.substring(k+1,cur.length());
                        if(!set.contains(temp)){
                            q.addLast(temp);
                            set.add(temp);
                        }
                    }
                }

            }
        }


        while (!q.isEmpty()){
            String temp = q.removeFirst();
            if(check(temp)){
                res.add(temp);
            }
        }

        return res;

    }

    public boolean check(String s){
        int lcount=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                lcount++;
            }else if(s.charAt(i)==')'){
                lcount--;
                if(lcount<0){
                    return false;
                }
            }
        }

        return lcount==0;
    }

    public int rCount(String s){
        int lcount=0;
        int res=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                lcount++;
            }else if(s.charAt(i)==')'){
                lcount--;
                res= Math.min(res,lcount);
            }
        }

        return -res;
    }

    public int lCount(String s){
        int lcount=0;
        int res=0;
        for (int i = s.length()-1; i >=0 ; i--) {
            if(s.charAt(i)==')'){
                lcount++;
            }else if(s.charAt(i)=='('){
                lcount--;
                res= Math.min(res,lcount);
            }
        }

        return -res;
    }


    public static void main(String[] args) {
        System.out.println(new T301_removeInvalidParentheses().removeInvalidParentheses("())((((((((((b))("));

    }
}
