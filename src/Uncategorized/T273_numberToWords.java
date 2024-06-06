package src.Uncategorized;

public class T273_numberToWords {
    /**
     * https://leetcode.cn/problems/integer-to-english-words/
     */

    public String numberToWords(int num) {
        if(num==0){
            return "Zero";
        }

        StringBuilder sb = new StringBuilder();

        String s = num+"";


        String[] name1 = new String[]{
                "One", "Two", "Three", "Four","Five",
                "Six","Seven","Eight","Nine","Ten",
                "Eleven","Twelve","Thirteen", "Fourteen", "Fifteen",
                "Sixteen","Seventeen","Eighteen","Nineteen","Twenty"};


        String[] name2 = new String[]{"","Twenty","Thirty", "Forty", "Fifty", "Sixty","Seventy","Eighty","Ninety"};

        String[] name3 = new String[]{"Billion", "Million", "Thousand", ""};



        for (int i = 0; i < 4; i++) {
            String temp=s.substring(Math.max(0,s.length()-(4-i)*3),Math.max(0,s.length()-(3-i)*3));
            temp= temp.replaceAll("^(0+)", "");

            if(temp.length()==0){
                continue;
            }


            if(temp.length()==3){
                sb.append(name1[temp.charAt(0)-'1']);
                sb.append(" ");
                sb.append("Hundred ");

                temp=temp.substring(1,temp.length());


            }

            int tempnum = Integer.valueOf(temp);

            if(tempnum>0){

                if(tempnum<21){
                    sb.append(name1[tempnum-1]);
                    sb.append(" ");
                }else {
                    int b=tempnum%10;
                    int a=tempnum/10;

                    sb.append(name2[a-1]);
                    sb.append(" ");

                    if(b!=0){
                        sb.append(name1[b-1]);
                        sb.append(" ");
                    }
                }
            }

            sb.append(name3[i]);
            sb.append(" ");


        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(new T273_numberToWords().numberToWords(1234567));
    }


}
