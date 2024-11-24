package src.String;

public class T471_encode {

    /**
     * https://leetcode.cn/problems/encode-string-with-shortest-length/
     * 动规：要么作为整体进行重复子串的包装，要么某一处分割
     * 难点：如何快速判断一个字符串由重复子串构成
     */

    public String encode(String s) {
        int n=s.length();
        int[][]dp = new int[n][n];
        String[][]str = new String[n][n];


        for (int len = 1; len <n+1 ; len++) {
            for (int i = 0; i <n+1-len ; i++) {
                int j=i+len-1;

                if(len<=4){
                    dp[i][j]=len;
                    str[i][j]=s.substring(i,j+1);
                }else {
                    // 如何快速判断一个字符串由重复子串构成
                    String p=s.substring(i,j+1);
                    String pp=p+p;
                    int index=pp.indexOf(p,1); //在pp找到p的第二个index

                    if(index<len){ //在p的内部找到index，则[0,index-1]是重复项
                        int count=len/(index);
                        int numLen=(int) Math.log10(count+0.0001);

                        dp[i][j]=numLen+dp[i][i+index-1]+2;
                        str[i][j]=count+"["+str[i][i+index-1]+"]";
                    }else { //反之，无重复，则分割
                        int temp=Integer.MAX_VALUE;
                        String tempStr="";
                        for (int k = i; k <j ; k++) {
                            if(dp[i][k]+dp[k+1][j]<temp){
                                temp=dp[i][k]+dp[k+1][j];
                                tempStr=str[i][k]+str[k+1][j];
                            }
                        }

                        dp[i][j]=temp;
                        str[i][j]=tempStr;
                    }


                }
            }
        }


        return str[0][n-1];
    }

    public static void main(String[] args) {
        System.out.println(new T471_encode().encode("aaaaaaaaaac"));
//        System.out.println(new T471_encode().encode("abbbabbbcabbbabbbc"));
    }
}
