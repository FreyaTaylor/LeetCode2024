package src.DynamicPrograming;

public class T5_longestPalindrome {

    public String longestPalindrome(String s) {
        int n = s.length();

        boolean[][] dp = new boolean[n][n];
        String res=s.charAt(0)+"";
        for (int i = 0; i < n; i++) {
            dp[i][i]=true;
        }

        for (int i = 0; i < n-1; i++) {
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=true;
                res=s.substring(i,i+2);
            }
        }


        for (int len = 3; len <n+1 ; len++) {
            for (int i = 0; i < n+1-len; i++) {
                int j= i+len-1;

                if(s.charAt(i)==s.charAt(j)&&dp[i+1][j-1]){
                    dp[i][j]=true;
                    res=s.substring(i,j+1);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new T5_longestPalindrome().longestPalindrome("babad"));
    }
}
