package src.DoublePointer.SlideWindow;

import java.util.HashMap;
import java.util.Map;

public class T424_characterReplacement {
    /**
     * https://leetcode.cn/problems/longest-repeating-character-replacement/
     *
     */

//    // 从左往右，无法处理从右往左的情况，会漏一部分
//    public int characterReplacement(String s, int k) {
//        Map<Character,Integer> map = new HashMap<>(); //[l,r)
//        char target=s.charAt(0); //target is first
//        int diffNum=0;
//        int l=0,r=0;
//        int maxLen=0;
//        while (r<s.length()){
//            char c=s.charAt(r);
//
//            if(c==target){
//                map.put(c,map.getOrDefault(c,0)+1);
//                r++;
//            }else {
//                diffNum++;
//                if(diffNum>k){
//                    //[l,r-1]
//                    // update
//                    maxLen=Math.max(maxLen,r-l);
//                    // find next l : nextl
//                    int nextl=l+1;
//                    while (nextl<r && s.charAt(nextl)==target){nextl++;}
//                    map.put(target,map.get(target)-(nextl-l));
//                    // new : l->nextl
//                    l=nextl;
//                    target=s.charAt(l);
//                    diffNum=r-l-map.getOrDefault(target,0);
//                }else {
//                    map.put(c,map.getOrDefault(c,0)+1);
//                    r++;
//                }
//            }
//            System.out.println(l+" "+r);
//
//        }
//        int lastLen=Math.min(k-diffNum,l)+r-l;
//        maxLen=Math.max(maxLen,lastLen);
//        return maxLen;
//    }

    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int l=0,r=0;
        int maxCount=0;
        int maxLen=0;
        while (r<s.length()){
            count[s.charAt(r)-'A']++;
            maxCount=Math.max(maxCount,count[s.charAt(r)-'A']); //maxCount只可能由新引入的字符的数量更新
            if(r-l+1-maxCount>k){
                maxLen=Math.max(maxLen,r-l);
                // 移l
                count[s.charAt(l)-'A']--;
                l++;
            }
            r++; //没必要维护更短的字串
        }
        maxLen=Math.max(maxLen,r-l);
        return maxLen;
    }

    public static void main(String[] args) {
//        System.out.println(new T424_characterReplacement().characterReplacement("CAAFDAEFFAEECBDFDFAECACBDADDEEFFCDEDBDDEDDEAFEFFCCFDDEFBBABAEACCADFEEBAFFBCBDADCCCAFAFBFCCACBDDBDEFECCDDEECBDEFEDCEDEFFACFFCFEFCCBDCBAEDEBBCDBECCFEDEDBDFAEFBCEFEFECBFCBBAFBAFDFCDCEBAFFDFFABCCABDDAEEEFDFCDECEBEEBCCECACEECBCBBEDBBECAAFDEAADCBDAADCDDFBDDCCFACACBBCDFBCBEFDCAFDBACFCEAAFDEBCDCCFFCEFFECECBFABFACCBACAEFEDCECCFBCCBEDECCBAFDDBEDDABDDADEFADDCDABDDBEECDDDCBDDABECCBBFDBBBCDBFCACBBFFBBBDFDDFFCBBEEAEFEDECAFEDACABAEEAAAFEBEBAEFEACEECEFDECBEDCEFDDFCACFCCDCFBBEBAFABECCACDFBBDFEEDABFEFFFDFFDCCFDAFCFEFBBABCBCFABEBBFDABEAEFDAFDDBFAEBCEEADBAFDBDFBAEACEDADCDADDCDEBBAFBBEEBFFDACCAFFFCCFEEADFECAFBEBCDFADCCECFEEBDFBDEBFEFEEAEEADCECBFEDFBCDEADDFFFDCDFAFCAECBBBBDBAFEBBBEEDABCEDECABDCFBEBAFCEFBECDACEFEBFCEDFCDBBCBFCCBCAACEFDBCDFDDEACAFADCAAEFAAEAECFBAFFFEAFFBCDBEFFEFDDECEEACACFEDFFBDEDCCDDEBEBBDDAAFCCAAADCEBEECFADFEECDDAAFCFDADBBCECADDBEEAEEFBEDBBADAFEAFFBDAEFCBCCBABDEFFADEBEBCEBEBDCECEDCFCEECFBAEEDFBAEDAECEDDCFEEEAEABDDDDBCBABABCBEDDABCEFACBCAFBCFBDFFAEAFDFBAAFDFAECCACBFEAAEDBAFADCADFCBAACBFECFFBDDEDCCBFDFFBCAADDAABEECDBDEFEFABABDDABACCADFFECBAEAFCEBFFAEFCDFACAEBFFCFAFBEFBDACECECFCFABFBEEFFADBDEECADEFAFAECBFDCADFFDFDEADFEBFDBBBDAEEBBDBDBFDEDFDCAAEFBADEDABEECABAACAFFACBBDEECDDDDAAACCBADCCBECACCBEEDBABCDEBFBFECDFEFFCDEFBEFDACDEAADBECBBCBCACEFDECFCACDDABDBAFFDCAFDADDEDBDEEEFBCFEACCBDEFCEFECCCEECBDADBCDBBDEFEDEAEDCEFBAAEACBEDBFFFADCDDFEFFBBACEECBBBBCCDDEEAEAEDEBCADFABDEBBFEEAADBCBFACDDACBDDFFFAEECEFBBDABBADDDDCBCFAAEABFFABCFAADDCFDDDDFEDAFFEEEBBBEEACACDECEDECCAFDECDADBDAFCBCAAEAEECCCCBAFABFADFEABFEABFDAADCCECABDCECEAFAEDAFCDDEABCDBCDCCAEBFDDFCBDBDCEEBBDFCCDADEDCADCCCBEBFCEFACDFCFDBDDFBCBDBACFEECCEBECEBEABDCDCDAFAEBECEFBFABCDDBDFFBAFCFDACEFECABDECFECFBCCFFFEEDAABABDECDBABFCDEFBBAACDEFAEABCDDEAECDFFCFFACFBAFFBBAFDFFAAAFCBCAEACEDFDDEBEBABEFCABACECCFAAECAAEBFFBDADEAAFBADDACFEFBCDCDDEBBAADEEEEFBFCEDDFAAEEFEADEECCADBECAABEECBAFECAFAACFEADBDCBDBCDEDABEBBDAFBDBCBCAFFBBDBDDABBBAEFBADDCBADFFEFFBDFEFDCAAEBFCDABFEFBBADFDBACBEDBABBBBDCCDFDDEBFBADBDDFAABCFDEECCFDBCDACDCDBBEEEEDCAECABAAEFEDAACCDFDCDECFCAEADBFFABCBEAABCCDEEDFBABFDBBCCFDFDDCEBFDCDEBCDAEFCBCEDACACEDEADCEEFBBEEBCCAAADCCFDEBFEEDCDEBEFFECEAFDBCBDCBACEFDBEAFBCCCFECFDEEAFCBEDAAFFFAADFBFFBCAAEEDBAEAADFAFDEAEBEBEEBCAEDCACCBDDDDCBBBABDEAAFEFAFFEDBDEEEACFFFAEBABADEACCDEAFCCCEDCCBABEECEFAEACADDDDBEACEBEFDEEDDBAEEEACDBBBFADCAACDDFACFFAFAECFABADFDDCAFEDECDEDCEABDEFFEFBDECDACDCAECCECCCBCEABBFACDBFDFCECCEFCCEEEABFDDBBFBEDBBAEACEEFDBFFFEECFABBAAEBFBCDECCFCFACBEAEFADACCBEDBFBBFAEBFBCBECCAFBBFFEEEBFBCDACBABCCCAEDCEDADCAFADBABFCCAAABFEEBACFFABCFBFABDFABFEFADAEFDCADCDBFCABCAAFDACFEAFCECFBEDAFBFFBFEAFBACDDEFEEBDEBEDDEBBBACCADBFDCEFABDCBFCFECDFDDFAADEDCCEDCEACDEFEAFEEBAFBDEDBADFDEBCBBCEAEFDEFDDAFCDBEBABBABEEAEEDBEFEBBCEEFBAABFBCFEABDFAFEAADDFCEEBECDDBCFACBECECDEFDEBEECEBEFEDADBDABAEEFFEAFEEBDACDCAEBDAEBACFBABFBEADBDBAADAACADCEBCDCEADEEDDAEDFCFBCDBFAEDAFAACEABFADDEEEEDCFCBABAADEAFEBDEAAEFAAFECDEBEDABDBAFBECFCCEFFFFEADFFFDDCAFCBBFBBBEFBACEEDEACEFFEFCEADAACAAFBBAEACCFBCFABBFDDFCEFCDACACFBEBEADEECFEADCBDFDCFCBBDBAFAFCBFAFEFDAFEDBAEDEDABDEECEBECDFBACEDAFEFABFEDEADCAEAFDECCDEEFCECDBFBCDCCCACADFBDEEEFCBABCAFAAACBECDEACEDBBAFBDFDDCEAAADABDCBDADECCCEFFBBDBDFFAFFBEAAABBAFBFFAEAAFEDFDABDBCFFACECCEAFEFCCCBECEBECEDDFCCFECDFCDDAECDCCDDCCFEAABCECFFCBAFBDBABAEDAEFCAFADEBFECECBEEABFECBCDFFCCFECEECAFDFEFCFFBCAEFADADFEFEEFECCFAECCBCADBEACFCCAFFFFCBABDEBBDFDFCBCDCFDBCEBACEEDAEEFCDCFEFEEBBBEBADEEEBBFCEFEACDFEFFAFECBCCDACCDADABBEDBEFCDCADDDCECCEEBADBABCAABBEDBABABDCEFEEADBAFBCDCBBABEBFADEBBACFCBFBCFBBACFEABEDEBCCAEFDAFFAAADCAFDEBEDABCCDCDADFDFFFBBAACFFEDCCFBDBABCBFFDDDAFBCFFBFACECDDCBCDADAEFCEAEBBDABCBDCFCFAEDEBAFFEAFEBBFECDDEDEDCBAFFDFABBDEFEDDAFBFDDEEBADBFFFEDACDAEAAFADDBDCCDBEEABBBEBBCAFAABFFEAABEACFFFAAFEBCAAEEBEFDDBECECEBCEFCABBDBBABECAAFFDBCDCFDAAFCABBEAAFCDAAEECEBCADCDAFDECDBDDBFCBEDEBDDBFFAEDFBAAAADDECBDDBBECFFFFCEACEEEACDBDCDFFBFBEFFABBAFBCACDBFDCBFAAFCBFCAAACBBEFAACAAACFDACADDDCACACBDBAABDEFCCCFAFAFAACDDBDFBFECFEADEEECABAFDECADDDFADBEDBBAFEBFBEBAEAACDECCACACEDCEFECEFFFBBBDFBCBDBCCDDFCABEDFDCEECAAFFBEEDCEBDCEEEBFAEBBFFCFFCDFDDBBBAECBFEBDEEDCEFDDFBDBCDBBEEFFDEFFCBBFDBCFECBECEBDADEEDDBBEADCFCCAABABACBBCAACFEABBFAADDFEFDAFDDFDBBCCBFCBDEEEBAFDEDDCAEBDCDABCACFFDDCEECDEDCCBCAEFCECFDCDCBCDEEACAEAACBADDCFACABFFBCCEACFEFFACDCFDFCDDCBFEEFCFCDFEDACAAFADDAAAAFCBBBABFAACCEEFABAECCECFFFADEBEEDEECCABAAFCECEDFFBACCCEDCCEACAEEBBCBFACBCAEABCEFEABCEBAFBBECEEABDDFEBBFCDDBCBBCEFFEADCBCDCDFBCBABEBAEFEDFEADBEBFFFBAEEADFDDDDFCEECEBDEFFDCBBCDFAFDDFEADEBADACBDAFDDDCCCEDAAFECFFFFDCADEDDFAFBFDEBDBFABEEAFDBFEEDFDECFCBFCDACDDDADECCFDEFADFFCECCDBEDCDCDFFEACDDABFEEDEBFDFADACEEFACEFCECEEAADFBBDEEAEEDDBEECFAFFFDDEBBADBADDFBEBAFDFEAFFCEEEFFACDDECCDFBBBAFFCCAAFEACEAABEDBBAAAEFEAEBFBFCBFFFFADDEEFAEAFFCAACCBDBBAEFACCCCEDDCBBACBEACCDFFBAEAABCFADFFDACCAEFAABCDDFBFCAEAEEDADEDFAFEBDEFAFBDAECAFCCAEBEEFEABEFBEFAFFFFCAACBBDDBDBCCBFDFCDDDAFDCCEBCFECDBFCDEEAFEEACFFCCFFCCAFDCFBEACCEEEECDFFBBAACAEDCEDDCEADEFFFADCBDAEBCFDAFBABCACCCEBEFFEDCBBCDBECCEADAEDEFBFEFEDFDAECEBBFAEBFDBCFECBCBCEFCBCFCDFCDEBBDCFDAEEFCBDCDEACEABCEACBBBBDCBFDCBACABCADBDEEADEFBFADDAAFCFEADCFADBFFAEFAEEAAADBDEEEBFADBACEEEEDDEABAADFCADDFCDFECEFBDFDFDBAAEDBEAFFDCADEDFDDFDEEBACFEFCDCDAFABBABDFFECCDCDCABBBFFBACEEAFBFFFCCCCEBFCDFCBABDBBBDFFFFBECACBEAABADDFEBACDBAFDDCBBBFDACFDECEEDCBAACBEBBFEABEBCCACDEFDCABECFEFACFDEBEFCADDBDABEFFEBBFFCCCDFEDDAECEFDCEAEEBCCCABFBAABAFFBFADAAEEACEBFAADCEEEFDEAACECDDBEDBDDBBEABDEAADEBDBCEABFBEFADCDBECBFFAADFEEEAEDAEAECDCDAFAFBBBEBBBBBEECDDBDBACEACEDEAFDDCEBBEBFDECCFCDFDEDFFDBBDBDFBACADBCECDFBBFFBBDBECAEFADDBDBBFAAFCCCFFAAFEBFCEECBDFACBEDACEEFCEDEFBFCAABEEDCDAEBAEFACEDEEFCADCADEAFABDDBEDEBFEACEDCBCBAFFADAFCBDBBFFFCCFBEFCFEDCFDFFFBEDCDBEDAECCEACCCCEBCAEDDBABCCFBEBBDBCABFAFBAADBDBCEEFBFADBAEACEFBEACCAFADBBDEFFEDADABCCECADAABFDDFFDFDCBDAFFEAEFBBFEBBBDEDDCECAAEFFDCEFCFCCEABCAFAEFADFFBCFDECBABEDCEEEDABCDFDCCBEFBACBAABBADEBFCAEDCCBAFADBEBEFCCDAFBFFDCFFDAFFEABECDBFFBEEFFCEABEBBFFFDDDACCCBBCEABEEBCDDEFCACBDDAFBBFFCECADAABEAABEBDFDEDBBBAECDDAEBCBFFBEBADDDEDDAEFEADBECFDEAEBFEBCAFBFACCBDFDADEADCACEDBAEABFECFCFBFBEFCFCCCFFBAECFEDFBCCBABFDCFCFEFEDDAEEADFCEFDADABBCCCFEACBABDDEAEDBBAEBBEAADFBEDEACBDEFDAFECAFADDDBFCCEAFAEDBFDDDFEEABCDBBAAEBCEDAFBFBBFEACAFEAFDCBCCECAFDDAADDADCAEACBBABEDFBFFCCBACCAEEFFACADEFBDDEDFFDCEABABEFDFCBEDCAEDAAFCCABEACCBBEBDCEEDEACCDCEACCFCDFBAEDADBFCFBBCFDBBEFCDECDDFAEAEBBFBADDFDABBBECEAAFEBBDDDDAACEECEBFBEDEBFDFFEDDACFBABDEFACFFBADCBFDCFCACBFEAECDDFECDAFCACADAACEFBDFDFEFBFDADDADBBCACEEDCAEAFFBCCAFEDEEFFFFEAAEDCAADCDECCCCFCFDABAFDDCACAECCCDBEEACFEBCACBFFABDEBEEAEDBBCFDEBDBACAAAADDDECBBBEDFFDDCCBAECDDBEEECBBCCFFDEBDDCEEEEEEBDFCDBDBFBAADAFACBBBCBAEAEFBFACAEAFFAEEFABDEBFACBBCDABABBECDACABABAEABFCAAADEBBACFBCEBBDCAEEABAACBBCCACFDAFBDCCCEDDDEEECFBDCAECCACFACDFCFBBDBDBCDCBDEEEEEACDDBBDDFACCDCCDABCFDCECFFCEEEECCFFFDCAEACFCDEBAEFACFBAEDAFCEDCFDEDCCDFBFCBBBEEEBDBBBDABDBCCDEBBCCCAFCFFCDCCCBEACBEBABFCFEEFDFCECBBFCDADECBFAFAFCABCBECDAAFEEFDDECBBDBFBABFEDAADCBBAEEACEACABFACEECAAFEEBABBDABFAEBCDEDCACCDCBAFFEDCEAEDBEBBEEDBFCDDEFAECFEDFFBDFDDCECAFCACBDEEBFFFFABEABEACEACFFEBEDFBBDBEABFDDDEDEDFABEEEDBECBBCDAFBDADEFDCBBBBBAAABEFDEDAECDCCACAECFBAEBDCEBEAAECDBDCDEEDCFECADCABDCCBCECDCDEBACCBFFBFBBECFEFCEFFDEFFEDFEBBAABFCCFDEBBADAFFAECEDAAEEBEACEDDECFDEAFBFACAEAAAABCDCBABFABDCBFAFBBFAADCAEEECFBFECBAEADEAAFBEDECBFEECCCEEBFAFDFBFCCEBFEFAFECDCDABEAFEADBCEFBEDAEAFBBBBFAFCFAECCBBECBCFEAECEACACCADEFFDCFEDADDBDEEEDDCBCECBEAFBCCFDCBBEFFDEACDCBCFCEFABEADACEEBAEECCDDFAFFEACAEEADEAFAFDAADCABDFDBCAEEADBFBADEFEAEEFDDFAFEAEBECFDCEEBBACAAFDEEFCCEECEDADEABCAAADEACCFADCEFBCEDEEEFEEDDEDBFABBBCCBCCBBECAFFEBEAFEEBEDBAFADCCDFBBEEECFABCFEBACBFDDFCBFCADBDECBEABACEDFBDDABFDFDAABCECDCCBCACEFEEAEAFDEACBCACEDCAFCEAEECFBAEDCCBACBFACBEADADFCFEBCBDBBAAFFDFBCEECCDECFDBAFABCDAADABECCDFEBDEBBCFCCDEFECADDEFFBDAEEDCFABCACFFBFFDCDDBCDADDCBBBDADBCCDCFDABEEDACEFEBEADBBDCAFDEFFCFACCFAFAEAECDDFEBFFAECCACFBCFDDDDFCCDBFAEAFBCDBFFAFADCBCAEFACFEABACFFACFCCADDCCCEEDCEFECEEEEFECAFFDABAAEFBFFECEDEFFEFEFCBBCBEBAEFCCEAAABBADDFDAABFFAAEBCBBDADFBCECBABFFECEEFDECBCECEBADBADEFBDCCDDAECFECFFACEFDAEBFEFEECAEBFDFABEDADAABCECCAFDEDFBAEFFCDDAFFEDBEEAEFFDFDFEEBCCDDAAADAFFFADABCFFCCCEDAEDEAEFFCEBDFBBCBDFBFAAEEDEABBCFADEFBAAFBBBDBDBCFAEBCAAFCBEDEFFEEEBAAADBABCCEBFACEEFFBFBAFBFBCDBFDACDFABBCFCFDABCBCEAAEDCEBABCFBDADABAFDADAEFDEBAFBABFBBFEBACEADFEACAACAAFACDEDFCAABBFDCDADECDDEADDAFDACABDACDACEFBCBFDADAACDFDFCCDFBBDFEFFCDACFBAAAFCADBADCECDFFABCFACEBDADFABCDCDFFABACCBCEFCAEFFDEDCDFAEDFBCBDFAFFCDDCCDEABFAFFDDAAAEAFABAEFCABEFFAFFEBBEEDEECEDBFDAEBFCFBAEDEFDAADFFDCBEBFBBFFAFFBECBDCCFCDCCFCBBFFBFADACABDCFCDDAECCBBAEEEEEADBFADFACFEEBDFDFCBCDCDBBFECFCFAEBDCDAFEFBFDBCDBDFCADFEBCBDCFDDFFFFAACDACFEBECAAACCDFDCDAEEEFCCCBCCFECEACACEEBDEBFFEFEFECBFAECDAEDDACEDCBBBFDDBDFDEBFEDCFBFEAFAEFADBBCBAFCCBFDDFAADFFEDDBDACBCFEAFDDACCDFFCCFFDEEDBDEFCABCAFECDBCEBCADCBEFCEBABCFBECCCEBCDCBABFBEDCABEFECCEBFBECBCAABFADDEEACCEAADDBCEAFEDABCDDFBACFEDFCEAFFDCAAEDABEFEAAECECBDACEFCBBBFDACDCCDECCCFABABFDCBFBECCACDAAFDFDDEDEFCABABAACABECDCFAEDFFDBDECCCCBFDEBFECEFDFCCEEDECEEBDEDCBCABACBBEAFCDADFAFFCADDDDDDDEEFEBAAFEEFEDADABFACABDACCDBEBEDDFDFBECEFECDAECBAEECFFACEFAFFDCCBEDEBABEEADCBBCBCFDCCADBAADFCDEBFEFFCBDACECDFEABBBDEBADAEBFEDBABEFCDCBFCAFCCAEAEDDDCBEBDCDAEFCBBAEFEEFDAACEACAACBEEFAFDEBDCCBAAEFFCAEFDFBAFFDBCAEAFCCDADEAADCAADAFCDAADAFFCAEFBDDEADAEDEBACDAEDFDFEDCEDFBBEAFCDDEFDCEDFCFCDFEEECDCCBBEBBBFFBAEBFEEBDDFDEDFBFCABFDFFCBDEBADEFAFADCDBAABAEEFFBDEDBCBEDFBBBEAEBEDEDAADDBBFFDFFDDEBFBBDBFFBFCDADFBAACCDABBCADBEAAAECEEDAEBFBDADEBAADFCDBAEBBFCCCFDBACAAAEFCCDACFFFFDAADBEAABACABEBCAEEAAACFCAFDBFDBFCDCEDBBFEDECEBCBACEFFAEEDFECAABDBFEABAEDCBDFBFBAFCEADEEDDDEFEDEEFFBCAEDDDDDFADABABAFFEECADEBFCBEDBDCEDDDECDBEAFCEBCBEEBBEFBDBEDEEDCABDEDBEBAAEFDFFEBADABCCABBABCBDFFCFACCCEEDACEBFAAAFBEAFFEBECACFBAFCDAFAFFADECFACAEFEEDDBBFEBBCFBFACBCDEDBABECBEBFEEBBBBCEFEACDFECAFCEADEFABEBEFEEDDEDFDFDEEDFDFCFEFBEECDCDFFDCFBFCFFEACCFCDEBAFCBAEDFDECEBEEAFEECFDBBBEAABDEDDACDACCBCCAEFAFFBCDDEAEABBEECBCBAADFFBBCCFFCFBDADEBACEECECFBEDBEBBDBCEBDCFDABBDBDECBDCADECDBAFCADBDDAEBEADEEFEAABABACCADEEBBBAAFEBBCADCBEAFACDDFAADBAFDBCFFAACFFDCFCCFCACDFDCFCEBCDBAEEACEFEFFBEBBFFFCFAEDFDEFCDDAFCFEEBEEAFDCBCAACBFECBFBCDDBCFACDDEBE",3371));
        System.out.println(new T424_characterReplacement().characterReplacement("AABABBA",1));
    }
}
