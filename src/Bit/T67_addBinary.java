package src.Bit;

public class T67_addBinary {
    /**
     * https://leetcode.cn/problems/add-binary/
     */

    public String addBinary(String a, String b) {
        int i=a.length()-1,j=b.length()-1;
        int add=0;
        StringBuilder sb = new StringBuilder();
        int count1=0;
        String temp="";
        while ((i>-1 && j>-1)||add==1){

            count1=0;
            if(i>-1 && a.charAt(i--)=='1'){
                count1++;
            }
            if(j>-1 && b.charAt(j--)=='1'){
                count1++;
            }
            if(add==1){
                count1++;
            }

            temp="0";
            add=0;
            if(count1==0){
                temp="0";
                add=0;
            }else if(count1==1){
                temp="1";
                add=0;
            }else if(count1==2){
                temp="0";
                add=1;
            }else  if(count1==3) {
                temp = "1";
                add = 1;
            }

            sb.append(temp);
//            System.out.println();
        }

        String res =sb.reverse().toString();
        if(i>-1){
            res=a.substring(0,i+1)+res;
        }
        if(j>-1){
            res=b.substring(0,j+1)+res;
        }
        return res;
    }

    public static void main(String[] args) {
        String a = "111010", b = "1011";
        System.out.println(new T67_addBinary().addBinary(a,b));

    }
}
