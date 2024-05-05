package src.Uncategorized;

public class T8_myAtoi {

    /**
     * https://leetcode.cn/problems/string-to-integer-atoi/
     */

    public int myAtoi(String s) {
        s=s.trim();
        int isNegtive=1;


        if(s.length()==0){
            return 0;
        }

        if(s.charAt(0)=='-'){
            isNegtive=-1;
            s=s.substring(1,s.length());
        }else if(s.charAt(0)=='+'){
            s=s.substring(1,s.length());
        }

        int i=0;
        while (i<s.length() && s.charAt(i)=='0'){i++;}
        int start=i;
        while (i<s.length() && Character.isDigit(s.charAt(i))){i++;}

        s=s.substring(start,i);
//        System.out.println(s);
        if(s.length()==0){
            return 0;
        }

        if(s.length()<10){
            return isNegtive*Integer.valueOf(s);
        }else if(s.length()==10){
            long temp=Long.valueOf(s.substring(0,10));
            temp=temp*isNegtive;

            if(temp<Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }else if(temp>Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }else {
                return (int)temp;
            }
        }else {
            if(isNegtive==1){
                return Integer.MAX_VALUE;
            }else {
                return Integer.MIN_VALUE;
            }
        }


    }


    public static void main(String[] args) {
        System.out.println(new T8_myAtoi().myAtoi("+1"));
    }
}
