package src.ByMonth.M2411;




public class MST0502_printBin {

    /**
     * https://leetcode.cn/problems/binary-number-to-string-lcci/description/
     * @param num
     * @return
     */
    public String printBin(double num) {

        int d=0;
        double cur= 0.5;
        StringBuilder sb = new StringBuilder("0.");

        while (num!=0 && d<32){
            if(num>=cur){
                sb.append("1");
                num-=cur;
            }else {
                sb.append("0");
            }
            cur/=2;
            d++;
        }

        if(num==0){
            return sb.toString();
        }else {
            return "ERROR";
        }

    }

    public static void main(String[] args) {

//        System.out.println(new MST0502_printBin().printBin(0.625));
        System.out.println(new MST0502_printBin().printBin(0.1));

    }
}
