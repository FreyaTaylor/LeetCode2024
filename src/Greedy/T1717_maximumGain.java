package src.Greedy;

import java.util.HashMap;
import java.util.Map;

public class T1717_maximumGain {

    /**
     * https://leetcode.cn/problems/maximum-score-from-removing-substrings/
     * 贪心
     */
    public int maximumGain(String s, int x, int y) {
        int l=0,r=0;
        int res=0;
        while (r<s.length()){

            while (r<s.length() && (s.charAt(r)!='a' && s.charAt(r)!='b')){
                r++;
            }
            l=r;

            while (r<s.length() && (s.charAt(r)=='a' || s.charAt(r)=='b')){
                r++;
            }

            if(r-l>1){
                String ss = s.substring(l,r);
                Map<String, Integer> map = new HashMap<>();
//                res+=helper(map,ss,x,y);
                res+=greedy(ss,x,y);
            }

            l=r;

        }
        return res;
    }

//     // 记忆化搜索空间超限制
//    public int helper(Map<String, Integer> map, String s, int x, int y){
//
//        if(map.containsKey(s)){
//            return map.get(s);
//        }
//
//        int temp=0;
//        for (int i = 0; i < s.length()-1; i++) {
//            if(s.charAt(i)=='a' &&s.charAt(i+1)=='b' ){
//                temp=Math.max(temp,
//                        x+helper(map,s.substring(0,i)+s.substring(i+2,s.length()),x,y));
//            }else if(s.charAt(i)=='b' &&s.charAt(i+1)=='a' ){
//                temp=Math.max(temp,
//                        y+helper(map,s.substring(0,i)+s.substring(i+2,s.length()),x,y));
//            }
//        }
//
//        map.put(s,temp);
//        return temp;
//    }


    public int greedy(String s, int x, int y){

        // 处理x<y，交换：ab元素；xy数值
        if(x<y){
            int temp=x;
            x=y;
            y=temp;
            s=s.replace('a','c');
            s=s.replace('b','a');
            s=s.replace('c','b');
        }

        // x>=y，优先处理ab
        // 只包含ab，那么消除完成后只能剩下一种元素，因此消除次数的相同的
        // 因此优先匹配ab
        int counta=0,countb=0;
        int ab=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='a'){ // a先攒着
                counta++;
            }else {
                countb++;
                if(counta>0){ //有b且前面有a，则消除
                    ab++;
                    countb--;
                    counta--;
                }
            }
        }

        int res=ab*x+Math.min(counta,countb)*y; //消除ba
        return res;
    }


    public static void main(String[] args) {

        System.out.println(new T1717_maximumGain().maximumGain( "cdbcbbaaabab",  4,  5));

    }
}
