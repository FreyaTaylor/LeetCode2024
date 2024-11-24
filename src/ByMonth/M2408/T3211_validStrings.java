package src.ByMonth.M2408;

import java.util.ArrayList;
import java.util.List;

public class T3211_validStrings {

    public List<String> validStrings(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        helper(res,sb,1,0,n);
        return res;
    }

    public void helper(List<String> res,StringBuilder sb,int lastNum,int cur,int n){
//        System.out.println(sb);

        if(cur>=n){
            res.add(new String(sb));
            return;
        }

        sb.append(1);
        helper(res,sb,1,cur+1,n);
        sb.setLength(sb.length()-1);


        if(lastNum==1){
            sb.append(0);
            helper(res,sb,0,cur+1,n);
            sb.setLength(sb.length()-1);
        }
    }


    public static void main(String[] args) {
        System.out.println(new T3211_validStrings().validStrings(3));
    }

}
