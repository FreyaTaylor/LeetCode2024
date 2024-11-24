package src.DoublePointer.SlideWindow;

public class T424_characterReplacement_1 {
    /**
     * https://leetcode.cn/problems/longest-repeating-character-replacement/
     *
     */


    public int characterReplacement(String s, int k) {
        int l=0,r=0;
        int[] count = new int[26];
        int maxCount=0;
        int res=0;
        while (r<s.length()){
            int index=s.charAt(r)-'A';
            count[index]++;
            maxCount=Math.max(maxCount,count[index]);
            if(r-l+1-maxCount>k){ // l,r 是否合法
//                System.out.println(s.substring(l,r));
                res=Math.max(res,r-l-1); // l,r-1
                count[s.charAt(l++)-'A']--;
            }
            r++;

        }
        res=Math.max(res,r-l);
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(new T424_characterReplacement().characterReplacement("CAAFDAEFFAEECBDFDFAECACBDADDEEFFCDEDBDDEDDEAFEFFCCFDDEFBBABAEACCADFEEBAFFBCBDADCCCAFAFBFCCACBDDBDEFECCDDEECBDEFEDCEDEFFACFFCFEFCCBDCBAEDEBBCDBECCFEDEDBDFAEFBCEFEFECBFCBBAFBAFDFCDCEBAFFDFFABCCABDDAEEEFDFCDECEBEEBCCECACEECBCBBEDBBECAAFDEAADCBDAADCDDFBDDCCFACACBBCDFBCBEFDCAFDBACFCEAAFDEBCDCCFFCEFFECECBFABFACCBACAEFEDCECCFBCCBEDECCBAFDDBEDDABDDADEFADDCDABDDBEECDDDCBDDABECCBBFDBBBCDBFCACBBFFBBBDFDDFFCBBEEAEFEDECAFEDACABAEEAAAFEBEBAEFEACEECEFDECBEDCEFDDFCACFCCDCFBBEBAFABECCACDFBBDFEEDABFEFFFDFFDCCFDAFCFEFBBABCBCFABEBBFDABEAEFDAFDDBFAEBCEEADBAFDBDFBAEACEDADCDADDCDEBBAFBBEEBFFDACCAFFFCCFEEADFECAFBEBCDFADCCECFEEBDFBDEBFEFEEAEEADCECBFEDFBCDEADDFFFDCDFAFCAECBBBBDBAFEBBBEEDABCEDECABDCFBEBAFCEFBECDACEFEBFCEDFCDBBCBFCCBCAACEFDBCDFDDEACAFADCAAEFAAEAECFBAFFFEAFFBCDBEFFEFDDECEEACACFEDFFBDEDCCDDEBEBBDDAAFCCAAADCEBEECFADFEECDDAAFCFDADBBCECADDBEEAEEFBEDBBADAFEAFFBDAEFCBCCBABDEFFADEBEBCEBEBDCECEDCFCEECFBAEEDFBAEDAECEDDCFEEEAEABDDDDBCBABABCBEDDABCEFACBCAFBCFBDFFAEAFDFBAAFDFAECCACBFEAAEDBAFADCADFCBAACBFECFFBDDEDCCBFDFFBCAADDAABEECDBDEFEFABABDDABACCADFFECBAEAFCEBFFAEFCDFACAEBFFCFAFBEFBDACECECFCFABFBEEFFADBDEECADEFAFAECBFDCADFFDFDEADFEBFDBBBDAEEBBDBDBFDEDFDCAAEFBADEDABEECABAACAFFACBBDEECDDDDAAACCBADCCBECACCBEEDBABCDEBFBFECDFEFFCDEFBEFDACDEAADBECBBCBCACEFDECFCACDDABDBAFFDCAFDADDEDBDEEEFBCFEACCBDEFCEFECCCEECBDADBCDBBDEFEDEAEDCEFBAAEACBEDBFFFADCDDFEFFBBACEECBBBBCCDDEEAEAEDEBCADFABDEBBFEEAADBCBFACDDACBDDFFFAEECEFBBDABBADDDDCBCFAAEABFFABCFAADDCFDDDDFEDAFFEEEBBBEEACACDECEDECCAFDECDADBDAFCBCAAEAEECCCCBAFABFADFEABFEABFDAADCCECABDCECEAFAEDAFCDDEABCDBCDCCAEBFDDFCBDBDCEEBBDFCCDADEDCADCCCBEBFCEFACDFCFDBDDFBCBDBACFEECCEBECEBEABDCDCDAFAEBECEFBFABCDDBDFFBAFCFDACEFECABDECFECFBCCFFFEEDAABABDECDBABFCDEFBBAACDEFAEABCDDEAECDFFCFFACFBAFFBBAFDFFAAAFCBCAEACEDFDDEBEBABEFCABACECCFAAECAAEBFFBDADEAAFBADDACFEFBCDCDDEBBAADEEEEFBFCEDDFAAEEFEADEECCADBECAABEECBAFECAFAACFEADBDCBDBCDEDABEBBDAFBDBCBCAFFBBDBDDABBBAEFBADDCBADFFEFFBDFEFDCAAEBFCDABFEFBBADFDBACBEDBABBBBDCCDFDDEBFBADBDDFAABCFDEECCFDBCDACDCDBBEEEEDCAECABAAEFEDAACCDFDCDECFCAEADBFFABCBEAABCCDEEDFBABFDBBCCFDFDDCEBFDCDEBCDAEFCBCEDACACEDEADCEEFBBEEBCCAAADCCFDEBFEEDCDEBEFFECEAFDBCBDCBACEFDBEAFBCCCFECFDEEAFCBEDAAFFFAADFBFFBCAAEEDBAEAADFAFDEAEBEBEEBCAEDCACCBDDDDCBBBABDEAAFEFAFFEDBDEEEACFFFAEBABADEACCDEAFCCCEDCCBABEECEFAEACADDDDBEACEBEFDEEDDBAEEEACDBBBFADCAACDDFACFFAFAECFABADFDDCAFEDECDEDCEABDEFFEFBDECDACDCAECCECCCBCEABBFACDBFDFCECCEFCCEEEABFDDBBFBEDBBAEACEEFDBFFFEECFABBAAEBFBCDECCFCFACBEAEFADACCBEDBFBBFAEBFBCBECCAFBBFFEEEBFBCDACBABCCCAEDCEDADCAFADBABFCCAAABFEEBACFFABCFBFABDFABFEFADAEFDCADCDBFCABCAAFDACFEAFCECFBEDAFBFFBFEAFBACDDEFEEBDEBEDDEBBBACCADBFDCEFABDCBFCFECDFDDFAADEDCCEDCEACDEFEAFEEBAFBDEDBADFDEBCBBCEAEFDEFDDAFCDBEBABBABEEAEEDBEFEBBCEEFBAABFBCFEABDFAFEAADDFCEEBECDDBCFACBECECDEFDEBEECEBEFEDADBDABAEEFFEAFEEBDACDCAEBDAEBACFBABFBEADBDBAADAACADCEBCDCEADEEDDAEDFCFBCDBFAEDAFAACEABFADDEEEEDCFCBABAADEAFEBDEAAEFAAFECDEBEDABDBAFBECFCCEFFFFEADFFFDDCAFCBBFBBBEFBACEEDEACEFFEFCEADAACAAFBBAEACCFBCFABBFDDFCEFCDACACFBEBEADEECFEADCBDFDCFCBBDBAFAFCBFAFEFDAFEDBAEDEDABDEECEBECDFBACEDAFEFABFEDEADCAEAFDECCDEEFCECDBFBCDCCCACADFBDEEEFCBABCAFAAACBECDEACEDBBAFBDFDDCEAAADABDCBDADECCCEFFBBDBDFFAFFBEAAABBAFBFFAEAAFEDFDABDBCFFACECCEAFEFCCCBECEBECEDDFCCFECDFCDDAECDCCDDCCFEAABCECFFCBAFBDBABAEDAEFCAFADEBFECECBEEABFECBCDFFCCFECEECAFDFEFCFFBCAEFADADFEFEEFECCFAECCBCADBEACFCCAFFFFCBABDEBBDFDFCBCDCFDBCEBACEEDAEEFCDCFEFEEBBBEBADEEEBBFCEFEACDFEFFAFECBCCDACCDADABBEDBEFCDCADDDCECCEEBADBABCAABBEDBABABDCEFEEADBAFBCDCBBABEBFADEBBACFCBFBCFBBACFEABEDEBCCAEFDAFFAAADCAFDEBEDABCCDCDADFDFFFBBAACFFEDCCFBDBABCBFFDDDAFBCFFBFACECDDCBCDADAEFCEAEBBDABCBDCFCFAEDEBAFFEAFEBBFECDDEDEDCBAFFDFABBDEFEDDAFBFDDEEBADBFFFEDACDAEAAFADDBDCCDBEEABBBEBBCAFAABFFEAABEACFFFAAFEBCAAEEBEFDDBECECEBCEFCABBDBBABECAAFFDBCDCFDAAFCABBEAAFCDAAEECEBCADCDAFDECDBDDBFCBEDEBDDBFFAEDFBAAAADDECBDDBBECFFFFCEACEEEACDBDCDFFBFBEFFABBAFBCACDBFDCBFAAFCBFCAAACBBEFAACAAACFDACADDDCACACBDBAABDEFCCCFAFAFAACDDBDFBFECFEADEEECABAFDECADDDFADBEDBBAFEBFBEBAEAACDECCACACEDCEFECEFFFBBBDFBCBDBCCDDFCABEDFDCEECAAFFBEEDCEBDCEEEBFAEBBFFCFFCDFDDBBBAECBFEBDEEDCEFDDFBDBCDBBEEFFDEFFCBBFDBCFECBECEBDADEEDDBBEADCFCCAABABACBBCAACFEABBFAADDFEFDAFDDFDBBCCBFCBDEEEBAFDEDDCAEBDCDABCACFFDDCEECDEDCCBCAEFCECFDCDCBCDEEACAEAACBADDCFACABFFBCCEACFEFFACDCFDFCDDCBFEEFCFCDFEDACAAFADDAAAAFCBBBABFAACCEEFABAECCECFFFADEBEEDEECCABAAFCECEDFFBACCCEDCCEACAEEBBCBFACBCAEABCEFEABCEBAFBBECEEABDDFEBBFCDDBCBBCEFFEADCBCDCDFBCBABEBAEFEDFEADBEBFFFBAEEADFDDDDFCEECEBDEFFDCBBCDFAFDDFEADEBADACBDAFDDDCCCEDAAFECFFFFDCADEDDFAFBFDEBDBFABEEAFDBFEEDFDECFCBFCDACDDDADECCFDEFADFFCECCDBEDCDCDFFEACDDABFEEDEBFDFADACEEFACEFCECEEAADFBBDEEAEEDDBEECFAFFFDDEBBADBADDFBEBAFDFEAFFCEEEFFACDDECCDFBBBAFFCCAAFEACEAABEDBBAAAEFEAEBFBFCBFFFFADDEEFAEAFFCAACCBDBBAEFACCCCEDDCBBACBEACCDFFBAEAABCFADFFDACCAEFAABCDDFBFCAEAEEDADEDFAFEBDEFAFBDAECAFCCAEBEEFEABEFBEFAFFFFCAACBBDDBDBCCBFDFCDDDAFDCCEBCFECDBFCDEEAFEEACFFCCFFCCAFDCFBEACCEEEECDFFBBAACAEDCEDDCEADEFFFADCBDAEBCFDAFBABCACCCEBEFFEDCBBCDBECCEADAEDEFBFEFEDFDAECEBBFAEBFDBCFECBCBCEFCBCFCDFCDEBBDCFDAEEFCBDCDEACEABCEACBBBBDCBFDCBACABCADBDEEADEFBFADDAAFCFEADCFADBFFAEFAEEAAADBDEEEBFADBACEEEEDDEABAADFCADDFCDFECEFBDFDFDBAAEDBEAFFDCADEDFDDFDEEBACFEFCDCDAFABBABDFFECCDCDCABBBFFBACEEAFBFFFCCCCEBFCDFCBABDBBBDFFFFBECACBEAABADDFEBACDBAFDDCBBBFDACFDECEEDCBAACBEBBFEABEBCCACDEFDCABECFEFACFDEBEFCADDBDABEFFEBBFFCCCDFEDDAECEFDCEAEEBCCCABFBAABAFFBFADAAEEACEBFAADCEEEFDEAACECDDBEDBDDBBEABDEAADEBDBCEABFBEFADCDBECBFFAADFEEEAEDAEAECDCDAFAFBBBEBBBBBEECDDBDBACEACEDEAFDDCEBBEBFDECCFCDFDEDFFDBBDBDFBACADBCECDFBBFFBBDBECAEFADDBDBBFAAFCCCFFAAFEBFCEECBDFACBEDACEEFCEDEFBFCAABEEDCDAEBAEFACEDEEFCADCADEAFABDDBEDEBFEACEDCBCBAFFADAFCBDBBFFFCCFBEFCFEDCFDFFFBEDCDBEDAECCEACCCCEBCAEDDBABCCFBEBBDBCABFAFBAADBDBCEEFBFADBAEACEFBEACCAFADBBDEFFEDADABCCECADAABFDDFFDFDCBDAFFEAEFBBFEBBBDEDDCECAAEFFDCEFCFCCEABCAFAEFADFFBCFDECBABEDCEEEDABCDFDCCBEFBACBAABBADEBFCAEDCCBAFADBEBEFCCDAFBFFDCFFDAFFEABECDBFFBEEFFCEABEBBFFFDDDACCCBBCEABEEBCDDEFCACBDDAFBBFFCECADAABEAABEBDFDEDBBBAECDDAEBCBFFBEBADDDEDDAEFEADBECFDEAEBFEBCAFBFACCBDFDADEADCACEDBAEABFECFCFBFBEFCFCCCFFBAECFEDFBCCBABFDCFCFEFEDDAEEADFCEFDADABBCCCFEACBABDDEAEDBBAEBBEAADFBEDEACBDEFDAFECAFADDDBFCCEAFAEDBFDDDFEEABCDBBAAEBCEDAFBFBBFEACAFEAFDCBCCECAFDDAADDADCAEACBBABEDFBFFCCBACCAEEFFACADEFBDDEDFFDCEABABEFDFCBEDCAEDAAFCCABEACCBBEBDCEEDEACCDCEACCFCDFBAEDADBFCFBBCFDBBEFCDECDDFAEAEBBFBADDFDABBBECEAAFEBBDDDDAACEECEBFBEDEBFDFFEDDACFBABDEFACFFBADCBFDCFCACBFEAECDDFECDAFCACADAACEFBDFDFEFBFDADDADBBCACEEDCAEAFFBCCAFEDEEFFFFEAAEDCAADCDECCCCFCFDABAFDDCACAECCCDBEEACFEBCACBFFABDEBEEAEDBBCFDEBDBACAAAADDDECBBBEDFFDDCCBAECDDBEEECBBCCFFDEBDDCEEEEEEBDFCDBDBFBAADAFACBBBCBAEAEFBFACAEAFFAEEFABDEBFACBBCDABABBECDACABABAEABFCAAADEBBACFBCEBBDCAEEABAACBBCCACFDAFBDCCCEDDDEEECFBDCAECCACFACDFCFBBDBDBCDCBDEEEEEACDDBBDDFACCDCCDABCFDCECFFCEEEECCFFFDCAEACFCDEBAEFACFBAEDAFCEDCFDEDCCDFBFCBBBEEEBDBBBDABDBCCDEBBCCCAFCFFCDCCCBEACBEBABFCFEEFDFCECBBFCDADECBFAFAFCABCBECDAAFEEFDDECBBDBFBABFEDAADCBBAEEACEACABFACEECAAFEEBABBDABFAEBCDEDCACCDCBAFFEDCEAEDBEBBEEDBFCDDEFAECFEDFFBDFDDCECAFCACBDEEBFFFFABEABEACEACFFEBEDFBBDBEABFDDDEDEDFABEEEDBECBBCDAFBDADEFDCBBBBBAAABEFDEDAECDCCACAECFBAEBDCEBEAAECDBDCDEEDCFECADCABDCCBCECDCDEBACCBFFBFBBECFEFCEFFDEFFEDFEBBAABFCCFDEBBADAFFAECEDAAEEBEACEDDECFDEAFBFACAEAAAABCDCBABFABDCBFAFBBFAADCAEEECFBFECBAEADEAAFBEDECBFEECCCEEBFAFDFBFCCEBFEFAFECDCDABEAFEADBCEFBEDAEAFBBBBFAFCFAECCBBECBCFEAECEACACCADEFFDCFEDADDBDEEEDDCBCECBEAFBCCFDCBBEFFDEACDCBCFCEFABEADACEEBAEECCDDFAFFEACAEEADEAFAFDAADCABDFDBCAEEADBFBADEFEAEEFDDFAFEAEBECFDCEEBBACAAFDEEFCCEECEDADEABCAAADEACCFADCEFBCEDEEEFEEDDEDBFABBBCCBCCBBECAFFEBEAFEEBEDBAFADCCDFBBEEECFABCFEBACBFDDFCBFCADBDECBEABACEDFBDDABFDFDAABCECDCCBCACEFEEAEAFDEACBCACEDCAFCEAEECFBAEDCCBACBFACBEADADFCFEBCBDBBAAFFDFBCEECCDECFDBAFABCDAADABECCDFEBDEBBCFCCDEFECADDEFFBDAEEDCFABCACFFBFFDCDDBCDADDCBBBDADBCCDCFDABEEDACEFEBEADBBDCAFDEFFCFACCFAFAEAECDDFEBFFAECCACFBCFDDDDFCCDBFAEAFBCDBFFAFADCBCAEFACFEABACFFACFCCADDCCCEEDCEFECEEEEFECAFFDABAAEFBFFECEDEFFEFEFCBBCBEBAEFCCEAAABBADDFDAABFFAAEBCBBDADFBCECBABFFECEEFDECBCECEBADBADEFBDCCDDAECFECFFACEFDAEBFEFEECAEBFDFABEDADAABCECCAFDEDFBAEFFCDDAFFEDBEEAEFFDFDFEEBCCDDAAADAFFFADABCFFCCCEDAEDEAEFFCEBDFBBCBDFBFAAEEDEABBCFADEFBAAFBBBDBDBCFAEBCAAFCBEDEFFEEEBAAADBABCCEBFACEEFFBFBAFBFBCDBFDACDFABBCFCFDABCBCEAAEDCEBABCFBDADABAFDADAEFDEBAFBABFBBFEBACEADFEACAACAAFACDEDFCAABBFDCDADECDDEADDAFDACABDACDACEFBCBFDADAACDFDFCCDFBBDFEFFCDACFBAAAFCADBADCECDFFABCFACEBDADFABCDCDFFABACCBCEFCAEFFDEDCDFAEDFBCBDFAFFCDDCCDEABFAFFDDAAAEAFABAEFCABEFFAFFEBBEEDEECEDBFDAEBFCFBAEDEFDAADFFDCBEBFBBFFAFFBECBDCCFCDCCFCBBFFBFADACABDCFCDDAECCBBAEEEEEADBFADFACFEEBDFDFCBCDCDBBFECFCFAEBDCDAFEFBFDBCDBDFCADFEBCBDCFDDFFFFAACDACFEBECAAACCDFDCDAEEEFCCCBCCFECEACACEEBDEBFFEFEFECBFAECDAEDDACEDCBBBFDDBDFDEBFEDCFBFEAFAEFADBBCBAFCCBFDDFAADFFEDDBDACBCFEAFDDACCDFFCCFFDEEDBDEFCABCAFECDBCEBCADCBEFCEBABCFBECCCEBCDCBABFBEDCABEFECCEBFBECBCAABFADDEEACCEAADDBCEAFEDABCDDFBACFEDFCEAFFDCAAEDABEFEAAECECBDACEFCBBBFDACDCCDECCCFABABFDCBFBECCACDAAFDFDDEDEFCABABAACABECDCFAEDFFDBDECCCCBFDEBFECEFDFCCEEDECEEBDEDCBCABACBBEAFCDADFAFFCADDDDDDDEEFEBAAFEEFEDADABFACABDACCDBEBEDDFDFBECEFECDAECBAEECFFACEFAFFDCCBEDEBABEEADCBBCBCFDCCADBAADFCDEBFEFFCBDACECDFEABBBDEBADAEBFEDBABEFCDCBFCAFCCAEAEDDDCBEBDCDAEFCBBAEFEEFDAACEACAACBEEFAFDEBDCCBAAEFFCAEFDFBAFFDBCAEAFCCDADEAADCAADAFCDAADAFFCAEFBDDEADAEDEBACDAEDFDFEDCEDFBBEAFCDDEFDCEDFCFCDFEEECDCCBBEBBBFFBAEBFEEBDDFDEDFBFCABFDFFCBDEBADEFAFADCDBAABAEEFFBDEDBCBEDFBBBEAEBEDEDAADDBBFFDFFDDEBFBBDBFFBFCDADFBAACCDABBCADBEAAAECEEDAEBFBDADEBAADFCDBAEBBFCCCFDBACAAAEFCCDACFFFFDAADBEAABACABEBCAEEAAACFCAFDBFDBFCDCEDBBFEDECEBCBACEFFAEEDFECAABDBFEABAEDCBDFBFBAFCEADEEDDDEFEDEEFFBCAEDDDDDFADABABAFFEECADEBFCBEDBDCEDDDECDBEAFCEBCBEEBBEFBDBEDEEDCABDEDBEBAAEFDFFEBADABCCABBABCBDFFCFACCCEEDACEBFAAAFBEAFFEBECACFBAFCDAFAFFADECFACAEFEEDDBBFEBBCFBFACBCDEDBABECBEBFEEBBBBCEFEACDFECAFCEADEFABEBEFEEDDEDFDFDEEDFDFCFEFBEECDCDFFDCFBFCFFEACCFCDEBAFCBAEDFDECEBEEAFEECFDBBBEAABDEDDACDACCBCCAEFAFFBCDDEAEABBEECBCBAADFFBBCCFFCFBDADEBACEECECFBEDBEBBDBCEBDCFDABBDBDECBDCADECDBAFCADBDDAEBEADEEFEAABABACCADEEBBBAAFEBBCADCBEAFACDDFAADBAFDBCFFAACFFDCFCCFCACDFDCFCEBCDBAEEACEFEFFBEBBFFFCFAEDFDEFCDDAFCFEEBEEAFDCBCAACBFECBFBCDDBCFACDDEBE",3371));
//        System.out.println(new T424_characterReplacement_1().characterReplacement("AABABBA",1));
//        System.out.println(new T424_characterReplacement_1().characterReplacement("ABAB",2));
        System.out.println(new T424_characterReplacement_1().characterReplacement("ABAA",0));
    }
}