package src.DynamicPrograming.Parentheses;

public class T32_longestValidParentheses {


    /**
     * https://leetcode.cn/problems/longest-valid-parentheses/
     * ()()
     * (***)
     * 超时
     *
     *
     */

    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int res=0;
        for (int i = 1; i <n ; i++) {
            if(s.charAt(i)==')'){

                if(s.charAt(i-1)=='('){// ...()
                    dp[i]=2;
                    if(i-2>=0){
                        dp[i]+=dp[i-2];
                    }

                }else { //...(()())
                    int from=i-dp[i-1];
                    if(from-1>=0 && s.charAt(from-1)=='('){
                        dp[i]=2+dp[i-1];
                        if(from-2>=0){
                            dp[i]+=dp[from-2];
                        }
                    }
                }

                res=Math.max(res,dp[i]);
            }
        }


        return res;
    }


    public int longestValidParentheses_(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        int res=0;
        for (int len = 2; len <n+1 ; len=len+2) {
            for (int i = 0; i < n+1-len; i++) {

                int j=i+len-1;
                System.out.println(i+" "+j);

                if(s.charAt(i)=='('&& s.charAt(j)==')'){
                    if(i+1>j-1 || dp[i+1][j-1]) {
                        res = len;
                        dp[i][j] = true;
                        continue;
                    }

                    for (int k = i+1; k <j-1 ; k++) {
                        if((i>k || dp[i][k]) &&(k+1>j || dp[k+1][j])){
                            res=len;
                            dp[i][j]=true;
                            break;
                        }
                    }

                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new T32_longestValidParentheses().longestValidParentheses(")()(()())"));
//        System.out.println(new T32_longestValidParentheses().longestValidParentheses("(()"));
//        System.out.println(new T32_longestValidParentheses().longestValidParentheses(""));
//        System.out.println(new T32_longestValidParentheses().longestValidParentheses("()"));
    }
}
