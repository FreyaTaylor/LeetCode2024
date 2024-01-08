package src.DynamicPrograming;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T22_generate_parentheses {

    /**
     * @param n
     * @return
     * https://leetcode.cn/problems/generate-parentheses/description/
     * f(n)=f(n-1)*f(0)+f(n-2)+f(1)+...+f(k-1)*f(n-k)+...+f(1)*f(n-1)
     * f(k)*f(n-k-1)表示：总共的括号分为两段，第一段为k个括号构成（外部一层括号，内部k-1个括号），第二段为n-k个括号
     *
     */
    public List<String> generateParenthesis(int n) {

        Map<Integer,List<String>> map = new HashMap<>();

        List<String> temp = new ArrayList<>();
        temp.add("");
        map.put(0,temp);
        temp = new ArrayList<>();
        temp.add("()");
        map.put(1,temp);

        for (int i = 2; i<=n;i++) {
            temp = new ArrayList<>();
            for (int j = i; j>0 ; j--) {
                List<String> left = map.get(j-1);
                List<String> right = map.get(i-j);
                for (String l : left) {
                    for (String r : right) {
                        temp.add("("+l+")"+r);
                    }
                }


            }
            map.put(i,temp);
        }

        return map.get(n);
    }

    public static void main(String[] args) {
        System.out.println(new T22_generate_parentheses().generateParenthesis(2));
    }

}
