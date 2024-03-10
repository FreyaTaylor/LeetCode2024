package src.Other.Basic;

public class T299_getHint {

    /**
     * https://leetcode.cn/problems/bulls-and-cows/
     */

    public String getHint(String secret, String guess) {
        int a = 0;
        int n=secret.length();
        int[] s = new int[10];
        int[] g = new int[10];

        for (int i = 0; i < n; i++) {
            if(secret.charAt(i)==guess.charAt(i)){
                a++;
            }else {
                s[secret.charAt(i)-'0']++;
                g[guess.charAt(i)-'0']++;
            }
        }

        int b=0;
        for (int i = 0; i < 10; i++) {
            b+=Math.min(s[i],g[i]);
        }

        return a+"A"+b+"B";
    }

    public static void main(String[] args) {
        System.out.println(new T299_getHint().getHint("1123","0111"));
    }
}
