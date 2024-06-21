package src.Trie;

import java.util.*;

public class AutocompleteSystem {

    /**
     * https://leetcode.cn/problems/design-search-autocomplete-system/
     */

    Map<String,Integer> count;
    Trie t;
    Trie cur; //当前指针
    StringBuilder sb; //当前句子

    public AutocompleteSystem(String[] sentences, int[] times) {
        count =new HashMap<>();
        t = new Trie();
        for (int i = 0; i < sentences.length; i++) {
            count.put(sentences[i],times[i]);
            buildTrie(t,sentences[i],0);
        }
        cur=t;
        sb = new StringBuilder();
    }

    public List<String> input(char c) {
        List<String> res = new ArrayList<>();

        if(c=='#'){ // 结尾，需要处理句子，更新状态
            // 需要处理句子
            String s = sb.toString();
            if(s.length()>0){
                if(count.containsKey(s)){
                    count.put(s,count.get(s)+1);
                }else {
                    count.put(s,1);
                    buildTrie(t,s,0);
                }
            }
            // 更新状态
            cur=t;
            sb = new StringBuilder();

            return res;
        }

        // 非结尾，需要
        // 1. 添加字母到句子
        sb.append(c);

        // 2.处理字母
        int index=c-'a';
        if(index==-65){
            index=26;
        }
        // 这三行和if(cur!=null && cur.children[index]!=null)不一样！
        // 因为cur.children[index]!=null时，cur必须往下指，即cur=cur.children[index];
        // case：
        // 新增句子是abc，字典树无a前缀的句子，有b前缀的句子
        // 处理a时候 cur.children[index]!=null，需要cur=cur.children[index]使其为空
        // 这样往后处理b才会正确


        if(cur!=null){
            cur=cur.children[index];
            if(cur!=null){
                Set<String> words = cur.words;
                PriorityQueue<String> q =new PriorityQueue<>(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        if(count.get(o1)!=count.get(o2)){
                            return count.get(o2)-count.get(o1);
                        }else {
                            return o1.compareTo(o2);
                        }
                    }
                });

                for (String word : words) {
                    q.add(word);
                }

                for (int i = 0; i < 3 && !q.isEmpty(); i++) {
                    res.add(q.poll());
                }
            }

        }

        return res;
    }

    public void buildTrie(Trie t,String s,int cur){
        int index=s.charAt(cur)-'a';
        if(index==-65){
            index=26;
        }

        if(t.children[index]==null){
            t.children[index] = new Trie();
        }
        t.children[index].words.add(s);
        //必须是在 t.children[index]处处理！而不是t，因为跟t是没有字母意义的！


        if(cur+1<s.length()){
            buildTrie(t.children[index],s,cur+1);
        }
    }




    class Trie{
        Trie[] children;
        Set<String> words;

        public Trie() {
            children = new Trie[27];
            words = new HashSet<>();
        }
    }


    public static void main(String[] args) {

        AutocompleteSystem obj = new AutocompleteSystem(
                new String[]{"uqpewwnxyqxxlhiptuzevjxbwedbaozz","ewftoujyxdgjtazppyztom","pvyqceqrdrxottnukgbdfcr","qtdkgdbcyozhllfycfjhdsdnuhycqcofaojknuqqnozltrjcabyxrdqwrxvqrztkcxpenbbtnnnkfhmebj","jwfbusbwahyugiaiazysqbxkwgcawpniptbtmhqyrlxdwxxwhtumglihrgizrczv","cfptjitfzdcrhw","aitqgitjgrcbacgnaasvbouqsqcwbyskkpsnigtfeecmlkcjbgduban","utsqkmiqqgglufourfdpgdmrkbippffacwvtkpflzrvdlkdxykfpkoqcb","ethtbdopotpamvrwuomlpahtveyw","jiaqkaxovsqtkpdjfbkajpvpyetuoqwnrnpjdhoojbsdvneecsdvgqpyurmsvcy","j","btbnuplyeuccjbernsfbnveillrwdbqledwvpmvdbcugkurrkabtpykhlcogeszclyfuquafouv","hndjzblegevtfkgbjttektox","gtvnlninpvenapyfgmsjdisfnmiktitrutctawosjflvzfkbegnprixzqwzcyhoovsivuwmofsveqkyosowuyamuvy","sawrirvrfrbfagreahrioaombukmdwztbpggnxd","mgdcwptvbvhzyvvumvbjjn","otjvvkegwleyyxtghwgfmlsqlhrlibdvqfinyyebotjpwoaejhtornfgikmifdmwswbqgwhcbzuhrpajxuqicegcptszct","zlondsttyvnnnnxjtoqnlktitwzurissczzbyfsbgpoawodwjpsmavaugnhqtsbeixwl","yehvdehbtmwqkmcjmvpivfzqvevkotwzvjoyfvp","bjximtpayjdcxbrnksbtfnpynzaygygdflowewprqngdadzdhxcpgapjejojrkzrutgcsfpfvpluagniqimfqddldxqiw","bysyrxfykivyauysytgxfhqcrxliulahuizjvozpywrokxujhzpauxwufcxiitukljiiclatfrspqcljjoxpxziumstnhqr","uxtvutlgqapyfltiulwrplesmtowzoyhhjhzihatpuvmutxqgxfawpwypedbz","jzgsdjdawrqfladolduldhpdpagmvllvzamypuqlrpbmhxxadqaqrqavtxeghcyysjynovkiyjtvdluttodtmtocajgttmv","mbijfkmepalhdiubposdksdmmttxblkodcdrxbnxaqebnwliatnxpwaohbwkidia","ljggggbyxwrwanhjonoramexdmgjigrtpz","cqfvkutpipxjepfgsufonvjtotwfxyn","kvseesjazssavispavchdpzvdhibptowhyrrshyntpwkez","nveuzbaosuayteiozmnelxlwkrrrjlwvhejxhupvchfwmvnqukphgoacnazuoimcliubvhv","uwrpwhfdrxfnarxqpkhrylkwiuhzubjfk","bniyggdcloefwy","ihranmhbsahqjxesbtmdkjfsupzdzjvdfovgbtwhqfjdddwhdvrnlyscvqlnqpzegnvvzyymrajvso","lscreasfuxpdxsiinymuzybjexkpfjiplevqcjxlm","uwgnfozopsygnmptdtmmuumahoungpkodwxrcvfymqpeymaqruayvqqgoddgbnhemtsjifhxwiehncswxzrghf","nyfbxgcpfrzyqwfjzgmhuohjhrjizsyjqgmertmooeiaadcmiuyyylpcosnweoyydeauazhzbeaqn","tpylrxbwnkrfxckfdlvrbytaezuzmyscpvruthuvbxjenkeolvqsrjqzizyclzmqtjvnamdansmzyspcfghfprorqprua","nhldlmxpuckxeekipkrzugatjiivtazjbjyxokksyueyjbgmrovbckbxqcqefaiavzsarbbypgmpxe","sylraqsd","xr","xkzpxkhrucyatpatkigvntohihibyisyqtkjdhatdvyvxbjttz","nvnz","blzddwxphkgqfsfzfclwytstpvpzgcdeggdwzukzirscfzcteeuqbmmrfxcnokbbyxkqrxtjfarcefiynwfmy","inuxmuhtdwpuvyludwtokhtalxbuccepsayrjycbcwbtnfholjvkmypodv","awwillrm","xznodxngrstjrwqzmlmigpw","khlxjdtictufdfbkgfusdtaaeuspbbfmtjodflgqofzlqnulkdztflm","nlngmckslyqzjiyiexbropbxnynjcstziluewypboqhqndqsxhtnosrgrameajovsclrgwqjgnztvxrkhwnxkfrf","yroadxhxyacaexrwju","ujxlbpcbxdqrvubifnpzjmmkolyljzjhdegaiowaal","tnfnjgtxbckbpyplucprxcqzhrfjimylmlhdglntfydepltjvklyxesndzuubienhvuaqc","ouedhtkpkg","ygchsrrubucqffewifsxaefwocfaiiupqbomktvrcddggqfgnaycstpccwtbheyaqwhosxajqeqqxzyjsfng","jqqgpjvfkgjh","csowoazaiyejgyixszqmtctpzlkccccqregyhtvxccvrpkupwcyhqatxscevzdfbdqnuyadiyfnhysddfyxpgqtjiogmxsmzbbkr","dlzxdpchkdaztkqtrjmuujgoiae","plcjkwukkyqluxjbhxsyeaqvviinfuujsafwsquidvmutsrukxwrv","yopqbtpoqhpcktjangauzcvvpephhprpaaclbbkgchlqkrwdsaupeizlwxzcpkchoagmrrkwdkthosmrjefgbumnrjsb"},
                new int[]{12,9,4,4,1,5,3,4,7,9,2,4,2,3,11,13,1,3,4,10,7,1,9,5,10,14,5,3,2,11,5,14,4,13,11,5,15,8,1,12,2,11,4,2,11,14,9,12,1,7,13,11,7,2,6,10});
        System.out.println(obj.input('w')); // return ["i love you", "island", "i love leetcode"]. There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree. Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman". Also we only need to output top 3 hot sentences, so "ironman" will be ignored.
        System.out.println(obj.input('f'));// return ["i love you", "i love leetcode"]. There are only two sentences that have prefix "i ".
        System.out.println(obj.input('q'));// return []. There are no sentences that have prefix "i a".
        System.out.println(obj.input('m')); // return []. The user finished the input, the sentence "i a" should be saved as a historical sentence in system. And the following input will be counted as a new search.


//        AutocompleteSystem obj = new AutocompleteSystem(
//                new String[]{"i love you", "island", "iroman", "i love leetcode"},
//                new int[]{5, 3, 2, 2});
//        System.out.println(obj.input('i')); // return ["i love you", "island", "i love leetcode"]. There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree. Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman". Also we only need to output top 3 hot sentences, so "ironman" will be ignored.
//        System.out.println(obj.input(' '));// return ["i love you", "i love leetcode"]. There are only two sentences that have prefix "i ".
//        System.out.println(obj.input('a'));// return []. There are no sentences that have prefix "i a".
//        System.out.println(obj.input('#')); //
//
//        System.out.println(obj.input('i')); // return ["i love you", "island", "i love leetcode"]. There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree. Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman". Also we only need to output top 3 hot sentences, so "ironman" will be ignored.
//        System.out.println(obj.input(' '));// return ["i love you", "i love leetcode"]. There are only two sentences that have prefix "i ".
//        System.out.println(obj.input('a'));// return []. There are no sentences that have prefix "i a".
//        System.out.println(obj.input('#')); //
//
//        System.out.println(obj.input('i')); // return ["i love you", "island", "i love leetcode"]. There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree. Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman". Also we only need to output top 3 hot sentences, so "ironman" will be ignored.
//        System.out.println(obj.input(' '));// return ["i love you", "i love leetcode"]. There are only two sentences that have prefix "i ".
//        System.out.println(obj.input('a'));// return []. There are no sentences that have prefix "i a".
//        System.out.println(obj.input('#')); //


    }
}
