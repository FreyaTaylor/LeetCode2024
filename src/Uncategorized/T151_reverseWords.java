package src.Uncategorized;

public class T151_reverseWords {

    public String reverseWords(String s) {

        String[] words = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = words.length-1; i >-1 ; i--) {
            if(!words[i].equals("")){
                stringBuilder.append(words[i]);
                stringBuilder.append(" ");
            }
        }
        stringBuilder.setLength(stringBuilder.length()-1);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new T151_reverseWords().reverseWords("the sky is     blue  "));
    }
}
