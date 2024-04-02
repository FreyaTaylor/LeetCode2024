package src.Uncategorized;

import java.util.ArrayList;
import java.util.List;

public class T282_addOperators {
    /**
     * https://leetcode.cn/problems/expression-add-operators/
     */

    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        dfs(res,new StringBuilder(),0L,1,target,num,0);
        return res;
    }

    public void dfs (List<String> res, StringBuilder sb,long curRes,long mulRes,int target,String num,int cur){
        if(cur==num.length()){
            if(curRes==target){
                res.add(new String(sb.toString()));
            }
            return;
        }

        int index=sb.length();
        for (int i = cur; i <num.length() && (num.charAt(cur)!='0' || i<=cur) ; i++) {
            // [cur,i]
            long curNum=Long.valueOf(num.substring(cur,i+1));
            if(cur==0){
                sb.append(curNum);
                dfs(res,sb,curNum,curNum,target,num,i+1);
            }else {
                // +
                sb.append("+"+curNum);
                dfs(res,sb,curRes+curNum,curNum,target,num,i+1);
                // -
                sb.setCharAt(index,'-');
                dfs(res,sb,curRes-curNum,-curNum,target,num,i+1);
                // *
                sb.setCharAt(index,'*');
                dfs(res,sb,curRes-mulRes+mulRes*curNum,mulRes*curNum,target,num,i+1);
                //!!curRes-mulRes+mulRes*curNum
            }
            sb.setLength(index);

        }

    }

    public static void main(String[] args) {
        System.out.println(new T282_addOperators().addOperators("3456237490",9191));
//        System.out.println(new T282_addOperators().addOperators("105",5));
//        System.out.println(new T282_addOperators().addOperators("123",6));
    }
}
