package src.Traverse;

public class T2075_decodeCiphertext {
    /**
     * https://leetcode.cn/problems/decode-the-slanted-ciphertext/
     * @param encodedText
     * @param rows
     * @return
     */
    public String decodeCiphertext(String encodedText, int rows) {
        int n=encodedText.length()/rows;
        char[][] chars = new char[rows][n];
        for (int i = 0; i < rows; i++) {
            chars[i]=encodedText.substring(i*n,(i+1)*n).toCharArray();
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < rows && j+i<n ; j++) {
                sb.append(chars[j][j+i]);
//                System.out.println(sb.toString());
            }
        }
        String res = sb.toString();
        int index=res.length()-1;
        while (index>=0 && res.charAt(index)==' '){
            index--;
        }

        return res.substring(0,index+1);
    }

    public static void main(String[] args) {
        System.out.println(new T2075_decodeCiphertext().decodeCiphertext("iveo    eed   l te   olc",4));
    }


}
