package src.DFS.NumberDFS;


import java.util.ArrayList;
import java.util.List;

public class T320_generateAbbreviations {

    /**
     * https://leetcode.cn/problems/generalized-abbreviation/
     */
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        dfs(res,new StringBuilder(),0,word,0);
        return res;
    }

    public void dfs(List<String> res, StringBuilder sb,int count, String s,int cur){

        int len=sb.length();

        if(cur==s.length()){
            if(count>0){ // 结尾需要判断count，可能存在sb增加元素
                sb.append(count);
            }
            res.add(sb.toString());
            sb.setLength(len); //因此必须setLength复原
            return;
        }

        // 缩写
        dfs(res,sb,count+1,s,cur+1);

        //不缩写
        if(count>0){
            sb.append(count);
            count=0;
        }
        sb.append(s.charAt(cur));
        dfs(res,sb,count,s,cur+1);
        sb.setLength(len); //每次增加sb，都要复原

    }

    public static void main(String[] args) {
        System.out.println(new T320_generateAbbreviations().generateAbbreviations("ab"));
    }
}
