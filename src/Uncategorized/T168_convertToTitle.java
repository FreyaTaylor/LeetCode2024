package src.Uncategorized;

public class T168_convertToTitle {

    /**
     * https://leetcode.cn/problems/excel-sheet-column-title/
     */
    public String convertToTitle(int columnNumber) {

        StringBuilder sb = new StringBuilder();
        while (columnNumber>0){
            int d = columnNumber%26;
            if(d==0){
                sb.append('Z'); //0变26
            }else {
                sb.append((char) ('A'+d-1));
            }

            columnNumber=columnNumber/26;
            if(d==0){
                columnNumber--;
            }

        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new T168_convertToTitle().convertToTitle(27));
    }
}
