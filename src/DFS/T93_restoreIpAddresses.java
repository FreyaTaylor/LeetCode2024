package src.DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class T93_restoreIpAddresses {

    /**
     * https://leetcode.cn/problems/restore-ip-addresses/
     */

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        dfs(res,new StringBuilder(),0,0,s);
        return res;
    }

    public void dfs(List<String> res,StringBuilder sb,int count,int i,String s){
//        System.out.println(sb+" "+i);
        if(i==s.length()){
            if(count==4){
                sb.setLength(sb.length()-1);
                res.add(new String(sb));
            }
            return;
        }

        if(count>=4){
            return;
        }

        int len = sb.length();

        if(s.charAt(i)=='0'){
            sb.append("0.");
            dfs(res,sb,count+1,i+1,s);
        }else {
            for (int j = i+1; j < Math.min(s.length()+1,i+4); j++) {
                String nextNum = s.substring(i,j);
                int num = Integer.valueOf(nextNum);
                if(num<256){
                    sb.setLength(len);
                    sb.append(nextNum);
                    sb.append(".");
                    dfs(res,sb,count+1,j,s);
                }else {
                    break;
                }

            }
        }

//        sb.setLength(len);
    }


    public static void main(String[] args) {
        System.out.println(new T93_restoreIpAddresses().restoreIpAddresses("101023"));
    }
}
