package src.Uncategorized;

public class T1616_checkPalindromeFormation {

    /**
     * https://leetcode.cn/problems/split-two-strings-to-make-palindrome/
     *
     *             }else if(a.charAt(i)==a.charAt(j)){
     *                 return ifHui(a.substring(i+1,j));
     *             }else if(b.charAt(i)==b.charAt(j)){
     *                 return ifHui(b.substring(i+1,j));
     *             //这样写有问题，因为可能存在 a.charAt(i)==a.charAt(j) 且 b.charAt(i)==b.charAt(j)
     *             // 这样写的话，只进行了一种切割！
     */

    public boolean checkPalindromeFormation(String a, String b) {
        return check(a,b)||check(b,a);
    }

    public boolean check(String a, String b) {
        int i=0,j=a.length()-1;
        while (i<j&& a.charAt(i)==b.charAt(j)){
            i++;
            j--;
        }
        if(i>=j){
            return true;
        }
        return ifHui(a.substring(i,j+1)) ||ifHui(b.substring(i,j+1));
    }
//        public boolean check(String a, String b) {
//
//        int i=0,j=a.length()-1;
//        while (i<j){
//            if(a.charAt(i)==b.charAt(j)){
//                i++;
//                j--;
//            }else if(a.charAt(i)==a.charAt(j)){
//                return ifHui(a.substring(i+1,j));
//            }else if(b.charAt(i)==b.charAt(j)){
//                return ifHui(b.substring(i+1,j));
//            //这样写有问题，因为可能存在 a.charAt(i)==a.charAt(j) 且 b.charAt(i)==b.charAt(j)
//            // 这样写的话，只进行了一种切割！
//
//            }else {
//                return false;
//            }
//        }
//
//        if(i>=j){
//            return true;
//        }
//        return false;
////        return ifHui(a.substring(i,j+1))||ifHui(b.substring(i,j+1));
//    }


    public boolean ifHui(String s){
        int i=0,j=s.length()-1;
        while (i<j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;
    }





    public static void main(String[] args) {
        String a = "nsltrtzgkjxazdehgfbzpzorrklcaozcpdobaxobvjfyichwtehvxhspulryplkicuzyoilvrdjcysxvuroijemfjivwcfofgxawvjiychtjnznqbdqjjringklftowjchtrfaighzgynzxrvjrpmcomfvjgkuazkwibtwrtyyreynjielurqpynhtfhtujwpqpxkhaiigqlnilpqohgygetlrsgkbyjhpphqqmbndrihucqlkswhwvhhkqvvpwptlzebgnqwlhvllvwlphbfzhcrrpfcovddozmkwshbzmfnhitmhijypxiudpswilstoruocwsxxteearusqyivlforugwreewzbbsbxnacethadvgurttfzvhdddylniawhjuwazbgtxapqtciqxzmlnrtbnqcfrqpkobzqhjcashgjtoiwoyfpunukiztfuwcplidxlnztrcjvplbqglsgnzwdlbzocboehnrmyqowvujdlmucozcffpewdqmdmudescxjskngccjlvmofdv";
        String b = "dkqxxbtiihevpbplnbnubxosgprhshhantbgyezkgkjrbrfyrpdeplbucprkssmpxffpllslorgqnvlhnavabljjqtyzulatllctaogjafbrbnsxlpwknctxbfgvcmzhgoezcjffjniqomhubotvcokleakdtnmyzctcecmhgbdyzrkwawflkeilmudqckbmhuxsruszkqkotcikozbvttxfopmygkrvwlicicmguciiypeimxterfsbovajpfxbyrkzjkqlmvvmlqkjzkrybxfpjavobsfretxmiepyiicugmcicilwvrkgympofxttvbzokictokqkzsursxuhmbkcqdumlieklfwawkrzydbghmcectczymntdkaelkocvtobuhmoqinjffjczeoghzmcvgfbxtcnkwplxsnbrbfajgoatclltaluzytjfmejioruvxsycjdrvlioyzuciklpyrlupshxvhetwhciyfjvboxabodpczoaclkrrozpzbfghedzaxjkgztrtlsn";
        System.out.println(new T1616_checkPalindromeFormation().checkPalindromeFormation(a,b));
    }

}
